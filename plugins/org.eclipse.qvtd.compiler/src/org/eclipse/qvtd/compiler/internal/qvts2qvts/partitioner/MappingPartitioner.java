/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * The MappingPartitioner supervises the partitioning of a mapping region into a 'tree' of partitions that avoid
 * scheduling hazards. Each partition describes the future content of a micromapping. For non-degerate cases the 'tree'
 * comprises a sequence of Speculation, Speculating, Speculated partitions followed by zero or more concurrent Edge partitions.
 *
 * The Speculation partition establishes the basic pattern of inputs objects that justify creation of a speculated trace object.
 *
 * The Speculating partition interacts with other Speculations to establish that all predicates are satisfied.
 *
 * The Speculated partition creates the immediate corollaries of the successful speculation.
 *
 * The Edge partitions realize further edges once their targets are available.
 *
 * Each MappingPartitioner collaborates with an overall TransformationPartitioner for global analyses.
 */
public class MappingPartitioner implements Nameable
{
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The overall transformation partitioner providing global analysis results.
	 */
	protected final @NonNull TransformationPartitioner transformationPartitioner;

	/**
	 * The region to be partitioned.
	 */
	protected final @NonNull RegionAnalysis regionAnalysis;

	/**
	 * The region to be partitioned.
	 */
	protected final @NonNull MappingRegion region;

	/**
	 * The TraceClassAnalysis instances that are consumed by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull TraceClassAnalysis> consumedTraceClassAnalyses = null;

	/**
	 * The TraceClassAnalysis instances that are produced by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull TraceClassAnalysis> producedTraceClassAnalyses = null;

	/**
	 * The TraceClassAnalysis instances and super instances that are produced by this MappingPartitioner.
	 */
	private @Nullable Set<@NonNull TraceClassAnalysis> superProducedTraceClassAnalyses = null;

	/**
	 * The constant nodes that require no computation from other nodes.
	 */
	private final @NonNull List<@NonNull Node> constantInputNodes = new ArrayList<>();

	/**
	 * The constant nodes that impose a check on a computation from other nodes.
	 */
	private final @NonNull List<@NonNull Node> constantOutputNodes = new ArrayList<>();

	/**
	 * The map from node to the trace edge by which the node may be located by lookup in a trace node once its trace edge is realized..
	 */
	private final @NonNull Map<@NonNull Node, @NonNull Edge> node2traceEdge = new HashMap<>();

	/**
	 * properties that are directly realized from a middle object provided all predicates are satisfied.
	 */
	private final @NonNull List<@NonNull Edge> predicatedEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> predicatedMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> predicatedOutputNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> realizedMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> realizedOutputNodes = new ArrayList<>();
	private final @NonNull Set<@NonNull NavigableEdge> oldPrimaryNavigableEdges = new HashSet<>();
	private final @NonNull Set<@NonNull Edge> realizedEdges = new HashSet<>();
	private final @NonNull List<@NonNull Edge> realizedOutputEdges = new ArrayList<>();
	private final @NonNull Set<@NonNull SuccessEdge> successEdges = new HashSet<>();	// FIXME redundant wrt traceNode2successEdge.values()
	//	private boolean hasLoadedNodes = false;

	/**
	 * The override dispatch node if needed.
	 */
	private @Nullable Node dispatchNode = null;

	/**
	 * The trace node(s).
	 */
	private final @NonNull List<@NonNull Node> traceNodes = new ArrayList<>();

	/**
	 * The trace nodes and their corresponding success node.
	 *
	 * There should normally be exactly one trace node.
	 *
	 * There is no trace node for Adolfo's prematurely folded middle optimization and for manual partitionings
	 * such as attributeColumns in testQVTcCompiler_SimpleUML2RDBMS_CG.
	 *
	 * There could be multiple trace nodes after an early merge results. Work in progress.
	 */
	private final @NonNull Map<@NonNull Node, @Nullable SuccessEdge> traceNode2successEdge = new HashMap<>();

	/**
	 * The realized edges from the (realized) trace node to a realized (corollary) ouput node that identify what is
	 * guaranteed to be created only speculation succeeds.
	 */
	private final @NonNull List<@NonNull NavigableEdge> corollaryEdges = new ArrayList<>();

	/**
	 * The realized output nodes guaranteed to be created only speculation succeeds;
	 * the targets of corollaryEdges.
	 */
	private final @NonNull List<@NonNull Node> corollaryNodes = new ArrayList<>();

	/**
	 * Dynamically growing list of constant edges that have been traversed by a partition.
	 */
	private final @NonNull Set<@NonNull Edge> alreadyConstantEdges = new HashSet<>();

	/**
	 * Dynamically growing list of loaded edges that have been traversed by a partition.
	 */
	private final @NonNull Set<@NonNull Edge> alreadyLoadedEdges = new HashSet<>();

	/**
	 * Dynamically growing list of edges that have been predicated by a partition.
	 */
	private final @NonNull Set<@NonNull Edge> alreadyPredicatedEdges = new HashSet<>();

	/**
	 * Dynamically growing list of nodes that have been predicated by a partition.
	 */
	private final @NonNull Set<@NonNull Node> alreadyPredicatedNodes = new HashSet<>();

	/**
	 * Dynamically growing map of edges that have been realized to the partition that realizes them.
	 */
	private final @NonNull Map<@NonNull Edge, @NonNull AbstractPartition> alreadyRealizedEdges = new HashMap<>();

	/**
	 * Dynamically growing list of nodes that have been realized by a partition.
	 */
	private final @NonNull Set<@NonNull Node> alreadyRealizedNodes = new HashSet<>();

	private final @NonNull Map<@NonNull Edge, @NonNull List<@NonNull AbstractPartition>> debugEdge2partitions = new HashMap<>();

	public MappingPartitioner(@NonNull TransformationPartitioner transformationPartitioner, @NonNull RegionAnalysis regionAnalysis) {
		this.scheduleManager = transformationPartitioner.getScheduleManager();
		this.transformationPartitioner = transformationPartitioner;
		this.regionAnalysis = regionAnalysis;
		this.region = (MappingRegion) regionAnalysis.getRegion();
		analyzeNodes();
		for (@NonNull Node traceNode : analyzeTraceNodes()) {
			analyzeSuccessEdge(traceNode);
			analyzeTraceEdges(traceNode);
		}
		//
		List<@NonNull Node> alreadyRealized = new ArrayList<>(traceNodes);
		if (dispatchNode != null) {
			alreadyRealized.add(dispatchNode);
		}
		analyzeCorollaries(alreadyRealized);
		analyzeEdges();
	}

	private void addConstantNode(@NonNull Node node) {
		assert node.isConstant();
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isComputation() || ((edge.isCast() || edge.isNavigation()) && !edge.isRealized())) {
				constantOutputNodes.add(node);
				return;
			}
		}
		constantInputNodes.add(node);
	}

	private void addConsumptionOfMiddleNode(@NonNull Node node) {
		if (!predicatedMiddleNodes.contains(node)) {
			predicatedMiddleNodes.add(node);
			TraceClassAnalysis consumedTraceAnalysis = transformationPartitioner.addConsumer(QVTscheduleUtil.getClassDatum(node), this);
			List<@NonNull TraceClassAnalysis> consumedTraceClassAnalyses2 = consumedTraceClassAnalyses;
			if (consumedTraceClassAnalyses2 == null) {
				consumedTraceClassAnalyses = consumedTraceClassAnalyses2 = new ArrayList<>();
			}
			consumedTraceClassAnalyses2.add(consumedTraceAnalysis);
		}
	}

	public void addEdge(@NonNull Edge edge, @NonNull Role newEdgeRole, @NonNull AbstractPartition partition) {
		if (newEdgeRole == Role.CONSTANT) {
			alreadyConstantEdges.add(edge);
		}
		else if (newEdgeRole == Role.LOADED) {
			alreadyLoadedEdges.add(edge);
		}
		else if (newEdgeRole == Role.PREDICATED) {
			alreadyPredicatedEdges.add(edge);
		}
		else if (newEdgeRole == Role.SPECULATED) {
			alreadyPredicatedEdges.add(edge);
		}
		else if (newEdgeRole == Role.REALIZED) {
			alreadyRealizedEdges.put(edge, partition);
		}
		List<@NonNull AbstractPartition> partitions = debugEdge2partitions.get(edge);
		if (partitions == null) {
			partitions = new ArrayList<>();
			debugEdge2partitions.put(edge, partitions);
		}
		assert !partitions.contains(partition);
		partitions.add(partition);
	}

	public boolean addPredicatedNode(@NonNull Node node) {
		return alreadyPredicatedNodes.add(node);
	}

	public void addProblem(@NonNull CompilerProblem problem) {
		transformationPartitioner.addProblem(problem);
	}

	private void addProductionOfMiddleNode(@NonNull Node node) {
		if (node.isRealized() && !realizedMiddleNodes.contains(node)) {
			realizedMiddleNodes.add(node);
		}
		TraceClassAnalysis consumedTraceAnalysis = transformationPartitioner.addProducer(QVTscheduleUtil.getClassDatum(node), this);
		List<@NonNull TraceClassAnalysis> producedTraceClassAnalyses2 = producedTraceClassAnalyses;
		if (producedTraceClassAnalyses2 == null) {
			producedTraceClassAnalyses = producedTraceClassAnalyses2 = new ArrayList<>();
		}
		if (!producedTraceClassAnalyses2.contains(consumedTraceAnalysis)) {
			producedTraceClassAnalyses2.add(consumedTraceAnalysis);
		}
	}

	public boolean addRealizedNode(@NonNull Node node) {
		return alreadyRealizedNodes.add(node);
	}

	/**
	 * Identify what gets realized as a consequence of the mapping succeeding.
	 */
	private void analyzeCorollaries(@NonNull List<@NonNull Node> alreadyRealizedNodes) {
		for (int i = 0; i < alreadyRealizedNodes.size(); i++) {
			Node alreadyRealizedNode = alreadyRealizedNodes.get(i);
			for (@NonNull NavigationEdge edge : alreadyRealizedNode.getRealizedNavigationEdges()) {
				Node targetNode = QVTscheduleUtil.getTargetNode(edge);
				if (targetNode.isRealized() && !targetNode.isSuccess()) {
					assert !corollaryEdges.contains(edge);
					corollaryEdges.add(edge);
					if (!alreadyRealizedNodes.contains(targetNode)) {
						alreadyRealizedNodes.add(targetNode);
						assert !corollaryNodes.contains(targetNode);
						if (!corollaryNodes.contains(targetNode)) {		// Overrides have a base and derived edge to the same rootVariable node
							corollaryNodes.add(targetNode);
						}
					}
					transformationPartitioner.addCorollary(QVTscheduleUtil.getProperty(edge), region);
				}
			}
		}
	}

	private void analyzeEdges() {
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			if (!edge.isSecondary()) {
				if (edge.isPredicated()) {
					predicatedEdges.add(edge);
				}
				if (edge.isCast() || edge.isNavigation()) {
					if (edge.isRealized()) {
						realizedEdges.add(edge);
						Node sourceNode = edge.getEdgeSource();
						Node targetNode = edge.getEdgeTarget();
						/*if (traceNode2successEdge.containsKey(sourceNode)) {
							if (targetNode.isRealized() && !targetNode.isSuccess()) {
								addCorollary((NavigableEdge) edge);
							}
						}
						else*/ if ((sourceNode.isPredicated() || sourceNode.isRealized())) {
							if (!traceNode2successEdge.containsKey(targetNode) && (targetNode.isPredicated() || targetNode.isRealized())) {
								realizedOutputEdges.add(edge);
							}
						}
						if (targetNode.isLoaded() && scheduleManager.isMiddle(sourceNode)) {
							//							navigableEdges.add(navigationEdge);
						}
					}
					else if (edge.isMatched() && !edge.isCast()) {
						assert !edge.isExpression();
						assert !edge.isComputation();
						Node targetNode = edge.getEdgeTarget();
						if (!targetNode.isNullLiteral()) {
							//							navigableEdges.add(navigationEdge);
						}
					}
				}
				/*				else if (QVTscheduleUtil.isRealizedIncludes(edge)) {
					realizedEdges.add(edge);
					Node sourceNode = edge.getSource();
					if ((sourceNode != traceNode) && (sourceNode == Role.PREDICATED || sourceNode == Role.REALIZED)) {
						Node targetNode = edge.getTarget();
						if ((targetNode != traceNode) && (targetNode == Role.PREDICATED || targetNode == Role.REALIZED)) {
							realizedOutputEdges.add(edge);
						}
					}
					if (edge.getTarget().isLoaded() && edge.getSource().getClassDatumAnalysis().getDomainUsage().isMiddle()) {
						//							navigableEdges.add(navigationEdge);
					}
				} */
			}
		}
		for (@NonNull NavigableEdge edge : region.getNavigationEdges()) {
			if (!edge.isSecondary() && !edge.isRealized()) {
				oldPrimaryNavigableEdges.add(edge);
			}
			if (edge.isSuccess()) {
				successEdges.add((SuccessEdge) edge);
				Node sourceNode = edge.getEdgeSource();
				assert scheduleManager.isMiddle(sourceNode);
				if (edge.isPredicated()) {
					addConsumptionOfMiddleNode(sourceNode);
				}
				else {
					assert edge.isRealized();
					addProductionOfMiddleNode(sourceNode);
				}
			}
		}
	}

	private void analyzeNodes() {
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			if (node.isNullLiteral()) {
				addConstantNode(node);
			}
			else if (node.isPattern()) {
				if (node.isConstant()) {
				}
				else if (node.isLoaded()) {
					//					hasLoadedNodes  = true;
				}
				else if (scheduleManager.isMiddle(node)) {
					if (node.isDispatch()) {
						if (dispatchNode != null) {
							throw new IllegalStateException();		// Dual dispatcher
						}
						dispatchNode = node;
					}
					else if (node.isTrace()) {
						//						if (traceNode != null) {
						//							throw new IllegalStateException();		// Two traces
						//						}
						traceNodes.add(node);
					}
					if (node.isPredicated()) {
						addConsumptionOfMiddleNode(node);
					}
					else if (node.isSpeculated()) {
						if (!node.isHead()) {		// Don't create a self-consumption cycle
							addConsumptionOfMiddleNode(node);
						}
					}
					else if (node.isSpeculation()) {
						addProductionOfMiddleNode(node);
					}
					else if (node.isRealized()) {
						addProductionOfMiddleNode(node);
						//					for (@NonNull NavigationEdge edge : node.getNavigationEdges()) {
						//						Node targetNode = edge.getTarget();
						//						NodeRole targetNodeRole = targetNode.getNodeRole();
						//						if (!targetNodeRole == Role.PREDICATED && !targetNodeRole == Role.REALIZED) {
						//							tracedInputNodes.add(targetNode);
						//						}
						//					}
					}
					else if (!node.isNullLiteral()) {
						throw new IllegalStateException("middle node must be predicated or realized : " + node);
					}

				}
				else {
					if (!node.isOperation()) {
						if (node.isPredicated()) {
							predicatedOutputNodes.add(node);
						}
						else if (node.isRealized()) {
							realizedOutputNodes.add(node);
						}
					}
				}
			}
			else if (node.isOperation()) {
				if (node.isConstant()) {
					addConstantNode(node);
				}
				else if (node.isRealized()) {
					realizedOutputNodes.add(node);
				}
			}
		}
	}

	private void analyzeSuccessEdge(@NonNull Node traceNode) {
		SuccessEdge successEdge = null;
		Property successProperty = scheduleManager.basicGetSuccessProperty(traceNode);
		if (successProperty != null) {
			NavigationEdge statusNavigationEdge = QVTscheduleUtil.basicGetNavigationEdge(traceNode, successProperty);
			if (statusNavigationEdge != null) {
				successEdge = (SuccessEdge) statusNavigationEdge;
			}
			else {
				if (!(region instanceof DispatchRegion) && !(region instanceof VerdictRegion)) {
					RegionHelper<@NonNull MappingRegion> regionHelper = new RegionHelper<>(scheduleManager, region);
					successEdge = regionHelper.createRealizedSuccess(traceNode, successProperty, null);
					Node successNode = QVTscheduleUtil.getTargetNode(successEdge);
					successNode.setUtility(Node.Utility.STRONGLY_MATCHED);		// FIXME is this really neded
				}
			}
		}
		traceNode2successEdge.put(traceNode, successEdge);
	}

	private void analyzeTraceEdges(@NonNull Node traceNode) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(traceNode)) {
			if (((edge.isCast() || edge.isNavigation()) && edge.isRealized())) {
				Node tracedNode = QVTscheduleUtil.getTargetNode(edge);
				node2traceEdge.put(tracedNode, edge);
			}
		}
	}

	private @NonNull Iterable<@NonNull Node> analyzeTraceNodes() {
		/*		if (realizedMiddleNodes.size() == 0) {
			return Collections.emptyList();
		}
		if (realizedMiddleNodes.size() == 1) {
			return Collections.singletonList(realizedMiddleNodes.get(0));
		}
		Iterable<@NonNull Node> headNodes = RuleHeadAnalysis.computeRealizedHeadNodes(region, realizedMiddleNodes);
		if (Iterables.size(headNodes) == 0) {
			return Collections.emptyList();
		}
		else {
			return Collections.singletonList(headNodes.iterator().next());
		} */
		return Iterables.concat(predicatedMiddleNodes, realizedMiddleNodes);
	}

	public @Nullable Node basicGetDispatchNode() {
		return dispatchNode;
	}

	private void check(boolean isInfallible) {
		Set<@NonNull Edge> infallibleEdges = null;
		Set<@NonNull Node> infallibleNodes = null;
		if (isInfallible) {
			infallibleEdges = new HashSet<>();
			infallibleNodes = new HashSet<>();
			for (@NonNull Edge edge : regionAnalysis.getFallibleEdges()) {
				infallibleEdges.add(edge);
				infallibleNodes.add(QVTscheduleUtil.getTargetNode(edge));
			}
		}
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			if (((node.isSpeculated() && !node.isHead()) || node.isRealized()) && !hasRealizedNode(node)) {
				if ((infallibleNodes == null) || !infallibleNodes.contains(node)) {
					transformationPartitioner.addProblem(CompilerUtil.createRegionError(region, "Should have realized " + node));
				}
			}
		}
		Set<@NonNull Edge> allPrimaryEdges = new HashSet<>();
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			if (!edge.isSecondary()) {
				allPrimaryEdges.add(edge);
				if (edge.isRealized() && !hasRealizedEdge(edge)) {
					if ((infallibleEdges == null) || !infallibleEdges.contains(edge)) {
						transformationPartitioner.addProblem(CompilerUtil.createRegionError(region, "Should have realized " + edge));
					}
				}
			}
		}
		//
		Set<@NonNull Node> deadNodes = computeDeadNodes(QVTscheduleUtil.getOwnedNodes(region));
		Set<@NonNull Edge> deadEdges = computeDeadEdges(deadNodes);
		allPrimaryEdges.removeAll(deadEdges);
		Set<@NonNull Edge> partitionedEdges = new HashSet<>(debugEdge2partitions.keySet());
		if (!partitionedEdges.equals(allPrimaryEdges)) {
			Set<@NonNull Edge> extraEdgesSet = Sets.newHashSet(partitionedEdges);
			CompilerUtil.removeAll(extraEdgesSet, allPrimaryEdges);
			for (@NonNull Edge edge : extraEdgesSet) {
				transformationPartitioner.addProblem(CompilerUtil.createRegionWarning(region, "Extra " + edge));
			}
			Set<@NonNull Edge> missingEdgesSet = Sets.newHashSet(allPrimaryEdges);
			missingEdgesSet.removeAll(partitionedEdges);
			for (@NonNull Edge edge : missingEdgesSet) {
				if (transformationPartitioner.getCorollaryOf(edge) == null) {// && !isDead(edge)) {
					transformationPartitioner.addProblem(CompilerUtil.createRegionWarning(region, "Missing " + edge));
				}
			}
		}
	}

	private @NonNull Set<@NonNull Edge> computeDeadEdges(@NonNull Iterable<@NonNull Node> deadNodes) {
		Set<@NonNull Edge> deadEdges = new HashSet<>();
		for (@NonNull Node node : deadNodes) {
			Iterables.addAll(deadEdges, QVTscheduleUtil.getIncomingEdges(node));
			Iterables.addAll(deadEdges, QVTscheduleUtil.getOutgoingEdges(node));
		}
		return deadEdges;
	}

	private @NonNull Set<@NonNull Node> computeDeadNodes(@NonNull Iterable<@NonNull Node> nodes) {
		Set<@NonNull Node> deadNodes = new HashSet<>();
		Set<@NonNull Node> moreDeadNodes = null;
		for (@NonNull Node node : nodes) {
			if (!node.isHead() && isDead(node, null)) {
				if (moreDeadNodes == null) {
					moreDeadNodes = new HashSet<>();
				}
				moreDeadNodes.add(node);
			}
		}
		if (moreDeadNodes == null) {
			return deadNodes;
		}
		while (moreDeadNodes.size() > 0) {
			deadNodes.addAll(moreDeadNodes);
			List<@NonNull Node> moreDeadNodesList = new ArrayList<>(moreDeadNodes);
			moreDeadNodes = null;
			for (@NonNull Node deadNode : moreDeadNodesList) {
				for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(deadNode)) {
					Node sourceNode = edge.getEdgeSource();
					if (!sourceNode.isHead() && isDead(sourceNode, deadNodes)) {
						if (moreDeadNodes == null) {
							moreDeadNodes = new HashSet<>();
						}
						moreDeadNodes.add(sourceNode);
					}
				}
			}
			if (moreDeadNodes == null) {
				break;
			}
		}
		return deadNodes;
	}

	private @NonNull MicroMappingRegion createActivatorRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		ActivatorPartition speculatingPartition = new ActivatorPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = speculatingPartition.createMicroMappingRegion("«activator»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		speculatingPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createAssignmentRegion(@NonNull ReachabilityForest reachabilityForest, @NonNull Edge outputEdge, int partitionNumber) {
		String namePrefix = "«edge" + partitionNumber + "»";
		String symbolSuffix = "_p" + partitionNumber;
		AssignmentPartition assignmentPartition = new AssignmentPartition(this, reachabilityForest, outputEdge);
		MicroMappingRegion microMappingRegion = assignmentPartition.createMicroMappingRegion(namePrefix, symbolSuffix);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		assignmentPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createNewSpeculatedRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		NewSpeculatedPartition speculatedPartition = new NewSpeculatedPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = speculatedPartition.createMicroMappingRegion("«speculated»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		speculatedPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createNewSpeculatingRegion(int partitionNumber, boolean isInfallible) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		NewSpeculatingPartition speculatingPartition = new NewSpeculatingPartition(this, reachabilityForest, isInfallible);
		MicroMappingRegion microMappingRegion = speculatingPartition.createMicroMappingRegion("«speculating»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		speculatingPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createNewSpeculationRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getSpeculationReachabilityRootNodes(), getAvailableNavigableEdges());
		NewSpeculationPartition speculationPartition = new NewSpeculationPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = speculationPartition.createMicroMappingRegion("«speculation»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		speculationPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createRealizedRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		RealizedPartition realizedPartition = new RealizedPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = realizedPartition.createMicroMappingRegion("«realized»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		realizedPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createResidualRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		ResidualPartition realizedPartition = new ResidualPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = realizedPartition.createMicroMappingRegion("«residue»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		realizedPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createSpeculatedRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		SpeculatedPartition speculatedPartition = new SpeculatedPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = speculatedPartition.createMicroMappingRegion("«speculated»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		speculatedPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createSpeculatingRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		SpeculatingPartition speculatingPartition = new SpeculatingPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = speculatingPartition.createMicroMappingRegion("«speculating»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		speculatingPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createSpeculationRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getSpeculationReachabilityRootNodes(), getAvailableNavigableEdges());
		SpeculationPartition speculationPartition = new SpeculationPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = speculationPartition.createMicroMappingRegion("«speculation»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		//			>>>>>>> 4473ebf residue
		speculationPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	//	public @NonNull Iterable<@NonNull Edge> getAlreadyPredicatedEdges() {
	//		return alreadyPredicatedEdges;
	//	}

	public @NonNull Iterable<@NonNull Edge> getAlreadyRealizedEdges() {
		return alreadyRealizedEdges.keySet();
	}

	/**
	 * Return the navigable edges that may be used by to locate nodes by this partition.
	 * The default implementation returns all old primary navigable edges
	 * and all already realized navigable edges
	 */
	private @NonNull Iterable<@NonNull NavigableEdge> getAvailableNavigableEdges() {
		List<@NonNull NavigableEdge> navigableEdges = Lists.newArrayList(getOldPrimaryNavigableEdges());
		for (@NonNull Edge edge : getAlreadyRealizedEdges()) {
			if (edge instanceof NavigableEdge) {
				navigableEdges.add((NavigableEdge) edge);
			}
		}
		return navigableEdges;
	}

	public @NonNull Iterable<@NonNull Node> getConstantInputNodes() {
		return constantInputNodes;
	}

	public @NonNull Iterable<@NonNull Node> getConstantOutputNodes() {
		return constantOutputNodes;
	}

	public @Nullable Iterable<@NonNull TraceClassAnalysis> getConsumedTraceClassAnalyses() {
		return consumedTraceClassAnalyses;
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getCorollaryEdges() {
		return corollaryEdges;
	}

	public @NonNull Iterable<@NonNull Node> getCorollaryNodes() {
		return corollaryNodes;
	}

	public @NonNull Iterable<@NonNull Node> getExecutionNodes() {
		return Iterables.concat(getPredicatedExecutionNodes(), getRealizedExecutionNodes());
	}

	@Override
	public String getName() {
		return region.getName();
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getOldPrimaryNavigableEdges() {
		return oldPrimaryNavigableEdges;
	}

	public @NonNull Iterable<@NonNull Edge> getPredicatedEdges() {
		return predicatedEdges;
	}

	public @NonNull List<@NonNull Node> getPredicatedExecutionNodes() {
		List<@NonNull Node> predicatedExecutionNodes = new ArrayList<>();
		for (@NonNull Node node : getPredicatedMiddleNodes()) {
			if (QVTrNameGenerator.TRACECLASS_PROPERTY_NAME.equals(node.getName())) {
				assert node.isTrace();
				predicatedExecutionNodes.add(node);
			}
		}
		return predicatedExecutionNodes;
	}

	public @NonNull Iterable<@NonNull Node> getPredicatedMiddleNodes() {
		return predicatedMiddleNodes;
	}

	public @NonNull Iterable<@NonNull Node> getPredicatedOutputNodes() {
		return predicatedOutputNodes;
	}

	public @NonNull List<@NonNull Node> getPredicatedWhenNodes() {
		List<@NonNull Node> predicatedWhenNodes = new ArrayList<>();
		for (@NonNull Node node : getPredicatedMiddleNodes()) {
			if (node.getName().startsWith("when_")) {
				predicatedWhenNodes.add(node);
			}
		}
		return predicatedWhenNodes;
	}

	public @Nullable Iterable<@NonNull TraceClassAnalysis> getProducedTraceClassAnalyses() {
		return producedTraceClassAnalyses;
	}

	private @NonNull Iterable<@NonNull Node> getReachabilityRootNodes() {
		Iterable<@NonNull Node> traceNodes = getTraceNodes();
		Iterable<@NonNull Node> constantInputNodes = getConstantInputNodes();
		return Iterables.concat(traceNodes, constantInputNodes);
	}

	public @NonNull Iterable<@NonNull Edge> getRealizedEdges() {
		return realizedEdges;
	}

	public @NonNull List<@NonNull Node> getRealizedExecutionNodes() {
		List<@NonNull Node> realizedExecutionNodes = new ArrayList<>();
		for (@NonNull Node node : getRealizedMiddleNodes()) {
			if (QVTrNameGenerator.TRACECLASS_PROPERTY_NAME.equals(node.getName())) {
				realizedExecutionNodes.add(node);
			}
			//			else if (QVTrelationNameGenerator.DISPATCHCLASS_SELF_NAME.equals(node.getName())) {
			//				realizedExecutionNodes.add(node);
			//			}
		}
		return realizedExecutionNodes;
	}

	public @NonNull Iterable<@NonNull Node> getRealizedMiddleNodes() {
		return realizedMiddleNodes;
	}

	public @NonNull Iterable<@NonNull Node> getRealizedOutputNodes() {
		return realizedOutputNodes;
	}

	public @NonNull List<@NonNull Node> getRealizedWhereNodes() {
		List<@NonNull Node> realizedWhereNodes = new ArrayList<>();
		for (@NonNull Node node : getRealizedMiddleNodes()) {
			if (node.getName().startsWith("where_")) {
				realizedWhereNodes.add(node);
			}
		}
		return realizedWhereNodes;
	}

	public @Nullable AbstractPartition getRealizingPartition(@NonNull Edge edge) {
		return alreadyRealizedEdges.get(edge);
	}

	public @NonNull MappingRegion getRegion() {
		return region;
	}

	public @NonNull RegionAnalysis getRegionAnalysis() {
		return regionAnalysis;
	}

	protected @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	private @NonNull Iterable<@NonNull Node> getSpeculationReachabilityRootNodes() {
		List<@NonNull Node> rootNodes = new ArrayList<>();
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(region)) {
			if (!headNode.isDependency()) {
				rootNodes.add(headNode);
			}
		}
		for (@NonNull Node constantInputNode : getConstantInputNodes()) {
			rootNodes.add(constantInputNode);
		}
		return rootNodes;
	}

	public @Nullable SuccessEdge getSuccessEdge(@NonNull Node traceNode) {
		return traceNode2successEdge.get(traceNode);
	}

	public @NonNull Iterable<@NonNull SuccessEdge> getSuccessEdges() {
		return successEdges;
	}

	public @Nullable Node getSuccessNode(@NonNull Node traceNode) {
		SuccessEdge successEdge = traceNode2successEdge.get(traceNode);
		return successEdge != null ? successEdge.getTargetNode() : null;
	}

	public @Nullable Iterable<@NonNull TraceClassAnalysis> getSuperProducedTraceClassAnalyses() {
		List<@NonNull TraceClassAnalysis> producedTraceClassAnalyses2 = producedTraceClassAnalyses;
		if (producedTraceClassAnalyses2 != null) {
			Set<@NonNull TraceClassAnalysis> superProducedTraceClassAnalyses2 = superProducedTraceClassAnalyses;
			if (superProducedTraceClassAnalyses2 == null) {
				superProducedTraceClassAnalyses = superProducedTraceClassAnalyses2 = new HashSet<>();
			}
			for (@NonNull TraceClassAnalysis producedTraceClassAnalysis : producedTraceClassAnalyses2) {
				Iterables.addAll(superProducedTraceClassAnalyses2, producedTraceClassAnalysis.getSuperTraceClassAnalyses());
			}
		}
		return superProducedTraceClassAnalyses;
	}

	public @NonNull TraceClassAnalysis getTraceClassAnalysis(@NonNull Node traceNode) {
		ClassDatum traceClassDatum = QVTscheduleUtil.getClassDatum(traceNode);
		return transformationPartitioner.getTraceClassAnalysis(traceClassDatum);
	}

	public @Nullable Edge getTraceEdge(@NonNull Node node) {
		return node2traceEdge.get(node);
	}

	public @NonNull Node getTraceNode() {
		assert traceNodes.size() == 1;
		return ClassUtil.nonNullState(traceNodes.get(0));
	}

	public @NonNull Iterable<@NonNull Node> getTraceNodes() {
		return traceNodes;
	}

	public @NonNull TransformationPartitioner getTransformationPartitioner() {
		return transformationPartitioner;
	}

	/*	private boolean hasNoComputationInputs(@NonNull Node node) {
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isComputation()) {
				return false;
			}
		}
		return true;
	} */


	public boolean hasConstantEdge(@NonNull Edge edge) {
		return alreadyConstantEdges.contains(edge);
	}

	public boolean hasLoadedEdge(@NonNull Edge edge) {
		return alreadyLoadedEdges.contains(edge);
	}

	public boolean hasPredicatedEdge(@NonNull Edge edge) {
		return alreadyPredicatedEdges.contains(edge);
	}

	public boolean hasPredicatedNode(@NonNull Node node) {
		return alreadyPredicatedNodes.contains(node);
	}

	public boolean hasRealizedEdge(@NonNull Edge edge) {
		return alreadyRealizedEdges.containsKey(edge);
	}

	public boolean hasRealizedNode(@NonNull Node node) {
		return alreadyRealizedNodes.contains(node);
	}

	public @Nullable List<@NonNull MappingRegion> getCorollaryOf(@NonNull Edge edge) {
		return transformationPartitioner.getCorollaryOf(edge);
	}

	public boolean isCyclic(@NonNull Node traceNode) {
		ClassDatum traceClassDatum = QVTscheduleUtil.getClassDatum(traceNode);
		return transformationPartitioner.isCyclic(traceClassDatum);
	}

	private boolean isDead(@NonNull Node node, @Nullable Set<@NonNull Node> knownDeadNodes) {
		if (node.isHead()) {
			return false;
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if ((edge.isCast() || edge.isNavigation())) {
				if ((knownDeadNodes == null) || !knownDeadNodes.contains(edge.getEdgeSource())) {
					return false;
				}
			}
			else if (edge.isPredicate()) {
				if ((knownDeadNodes == null) || !knownDeadNodes.contains(edge.getEdgeSource())) {
					return false;
				}
			}
			//			else if (edge.isExpression() && edge.isPredicated()) {
			//				return false;
			//			}
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(node)) {
			if (edge.isCast() || edge.isNavigation() || edge.isExpression()) {
				if ((knownDeadNodes == null) || !knownDeadNodes.contains(edge.getEdgeTarget())) {
					return false;
				}
			}
		}
		return true;
	}

	/*	private boolean isDead(@NonNull Edge edge) {
		if (!edge.isExpression()) {
			return false;
		}
		Node node = edge.getTarget();
		for (@NonNull Edge incomingEdge : node.getIncomingEdges()) {
			if ((incomingEdge != edge) && incomingEdge.isMatched()) {
				return false;
			}
		}
		for (@NonNull Edge outgoingEdge : node.getOutgoingEdges()) {
			if (!isDead(outgoingEdge)) {
				return false;
			}
		}
		return true;
	} */

	public @NonNull Iterable<@NonNull MappingRegion> partition() {
		boolean useActivators = scheduleManager.useActivators();
		if (useActivators) {
			return partition4qvtr();		// New algorithms with Dispatch/VerdictRegions to support overriding
		}
		else {
			return partition4qvtc();		// Old algorithms pending debugging and exploitation of new algorithms
		}
	}

	public @NonNull Iterable<@NonNull MappingRegion> partition4qvtc() {
		boolean isCyclic = transformationPartitioner.getCycleAnalysis(this) != null;
		List<@NonNull MappingRegion> newRegions = new ArrayList<>();
		if (!isCyclic) {	// Cycle analysis found no cycles
			newRegions.add(region);
		}
		else {
			if (!predicatedMiddleNodes.isEmpty()) {
				newRegions.add(createSpeculationRegion(newRegions.size()));
				newRegions.add(createSpeculatingRegion(newRegions.size()));
				newRegions.add(createSpeculatedRegion(newRegions.size()));
			}
			else {
				newRegions.add(createRealizedRegion(newRegions.size()));
			}
			ReachabilityForest assignmentReachabilityForest	= new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
			//
			//	Create an AssignmentRegion for each to-be-realized edge to an output, which may also realize most trace edges too.
			//
			for (@NonNull Edge outputEdge : realizedOutputEdges) {
				if (!hasRealizedEdge(outputEdge)) {
					newRegions.add(createAssignmentRegion(assignmentReachabilityForest, outputEdge, newRegions.size()));
				}
			}
			//
			//	Create an AssignmentRegion for each still to-be-realized edge to an output.
			//
			for (@NonNull Edge edge : realizedEdges) {
				if (!hasRealizedEdge(edge)) {
					newRegions.add(createAssignmentRegion(assignmentReachabilityForest, edge, newRegions.size()));
				}
			}
		}
		if (newRegions.size() > 1) {		// FIXME shouldn't this work anyway when no partitioning was needed?
			check(false);
		}
		return newRegions;
	}

	public @NonNull Iterable<@NonNull MappingRegion> partition4qvtr() {
		if ((region instanceof DispatchRegion) || (region instanceof VerdictRegion)) {
			return Collections.singletonList(region);
		}
		CycleAnalysis cycleAnalysis = transformationPartitioner.getCycleAnalysis(this);
		boolean isCyclic = cycleAnalysis != null;
		boolean isInfallible = false;
		if (cycleAnalysis != null) {
			isInfallible = cycleAnalysis.isInfallible();
		}
		List<@NonNull Node> predicatedWhenNodes = getPredicatedWhenNodes();
		List<@NonNull Node> realizedExecutionNodes = getRealizedExecutionNodes();
		boolean needsActivator = false;
		if (realizedExecutionNodes.size() > 0)	{			// A 'single' realized "trace" node is a boring no-override top activation.
			needsActivator = true;
		}
		else {
			needsActivator = false;
		}
		boolean needsSpeculation = isCyclic && (predicatedWhenNodes.size() > 0); //(dispatchedTraceNodes2.isEmpty() ? !predicatedMiddleNodes.isEmpty() : !predicatedMiddleNodes.containsAll(dispatchedTraceNodes2));
		//
		//	Create the partitioned regions
		//
		List<@NonNull MappingRegion> newRegions = new ArrayList<>();
		if (needsActivator) {
			//
			//	Create an activator to make a QVTr top relation behave as a non-top relation.
			//
			newRegions.add(createActivatorRegion(newRegions.size()));
		}
		if (!needsSpeculation) {
			//
			//	If speculation is not needed just add the functionality as a single region.
			//
			if (newRegions.isEmpty()) {		// i.e. a QVTr non top relation - re-use as is
				newRegions.add(region);
			}
			else {							// i.e. a QVTr top relation - create a residue to finish off the activator
				newRegions.add(createResidualRegion(newRegions.size()));
			}
		}
		else {								// cycles may need speculation and partitioning into isolated actions
			//			if (isInfallible) {
			//				regionAnalysis.getFallibilities()
			//			}
			newRegions.add(createNewSpeculationRegion(newRegions.size()));
			newRegions.add(createNewSpeculatingRegion(newRegions.size(), isInfallible));
			newRegions.add(createNewSpeculatedRegion(newRegions.size()));
			ReachabilityForest assignmentReachabilityForest	= new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
			//
			//	Create an AssignmentRegion for each to-be-realized edge to an output, which may also realize most trace edges too.
			//
			for (@NonNull Edge outputEdge : realizedOutputEdges) {
				if (!hasRealizedEdge(outputEdge)) {
					newRegions.add(createAssignmentRegion(assignmentReachabilityForest, outputEdge, newRegions.size()));
				}
			}
			//
			//	Create an AssignmentRegion for each still to-be-realized edge to an output.
			//
			for (@NonNull Edge edge : realizedEdges) {
				if (!hasRealizedEdge(edge)) {
					newRegions.add(createAssignmentRegion(assignmentReachabilityForest, edge, newRegions.size()));
				}
			}
		}
		if (newRegions.size() > 1) {		// FIXME shouldn't this work anyway when no partitioning was needed?
			check(isInfallible);
		}
		return newRegions;
	}

	@Override
	public String toString() {
		return region.getName();
	}
}
