/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.MappingRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
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
 * The Speculated partition creates the immediate corrolaries of the successful speculation.
 *
 * The Edge partitions realize further edges once their targets are available.
 *
 * Each MappingPartitioner collaborates with an overall TransformationPartitioner for global analyses.
 */
public class MappingPartitioner
{
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The overall transformation partitioner providing global analysis results.
	 */
	protected final @NonNull TransformationPartitioner transformationPartitioner;

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
	private final @NonNull List<@NonNull Node> leafConstantNodes = new ArrayList<>();

	/**
	 * The map from node to the trace edge by which the node may be located by lookup in a trace node once its trace edge is relaized..
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
	private final @NonNull List<@NonNull Node> trueNodes = new ArrayList<>();
	//	private boolean hasLoadedNodes = false;

	/**
	 * The trace nodes and their corresponding status node.
	 *
	 * There should normally be exactly one trace node.
	 *
	 * There is no trace node for Adolfo's prematurely folded middle optimization and for manual partitionings
	 * such as attributeColumns in testQVTcCompiler_SimpleUML2RDBMS_CG.
	 *
	 * There could be multiple trace nodes after an early merge results. Work in progress.
	 */
	private final @NonNull Map<@NonNull Node, @Nullable Node> traceNode2statusNode = new HashMap<>();

	/**
	 * The realized edges from the (realized) trace node to a realized (corrolary) ouput node that identify what is
	 * guaranteed to be created only speculation succeeds.
	 */
	private final @NonNull List<@NonNull NavigableEdge> corrolaryEdges = new ArrayList<>();

	/**
	 * The realized output nodes guaranteed to be created only speculation succeeds;
	 * the targets of corrolaryEdges.
	 */
	private final @NonNull List<@NonNull Node> corrolaryNodes = new ArrayList<>();

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

	/**
	 * Dynamically growing list of true nodes that have been realized by a partition.
	 */
	private final @NonNull Set<@NonNull Node> alreadyTrueNodes = new HashSet<>();

	private final @NonNull Map<@NonNull Edge, @NonNull List<@NonNull AbstractPartition>> debugEdge2partitions = new HashMap<>();

	public MappingPartitioner(@NonNull TransformationPartitioner transformationPartitioner, @NonNull MappingRegion region) {
		//		super(getTraceNodes(region.getNodes()), getNavigableEdges(region.getNavigationEdges()));
		this.scheduleManager = transformationPartitioner.getScheduleManager();
		this.transformationPartitioner = transformationPartitioner;
		this.region = region;
		//
		analyzeNodes();
		for (@NonNull Node traceNode : analyzeTraceNodes()) {
			analyzeStatusNode(traceNode);
			analyzeTraceEdges(traceNode);
		}
		//
		analyzeEdges();
	}

	private void addConsumptionOfMiddleNode(@NonNull Node node) {
		predicatedMiddleNodes.add(node);
		TraceClassAnalysis consumedTraceAnalysis = transformationPartitioner.addConsumer(node.getCompleteClass(), this);
		List<@NonNull TraceClassAnalysis> consumedTraceClassAnalyses2 = consumedTraceClassAnalyses;
		if (consumedTraceClassAnalyses2 == null) {
			consumedTraceClassAnalyses = consumedTraceClassAnalyses2 = new ArrayList<>();
		}
		consumedTraceClassAnalyses2.add(consumedTraceAnalysis);
	}

	private void addCorrolary(@NonNull NavigableEdge edge) {
		Node targetNode = edge.getTargetNode();
		assert traceNode2statusNode.containsKey(edge.getSourceNode());
		assert targetNode.isRealized();
		assert !targetNode.isStatus();
		assert !corrolaryEdges.contains(edge);
		corrolaryEdges.add(edge);
		corrolaryNodes.add(targetNode);
		transformationPartitioner.addCorrolary(QVTscheduleUtil.getProperty(edge), region);
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
		realizedMiddleNodes.add(node);
		TraceClassAnalysis consumedTraceAnalysis = transformationPartitioner.addProducer(node.getCompleteClass(), this);
		List<@NonNull TraceClassAnalysis> producedTraceClassAnalyses2 = producedTraceClassAnalyses;
		if (producedTraceClassAnalyses2 == null) {
			producedTraceClassAnalyses = producedTraceClassAnalyses2 = new ArrayList<>();
		}
		producedTraceClassAnalyses2.add(consumedTraceAnalysis);
	}

	public boolean addRealizedNode(@NonNull Node node) {
		return alreadyRealizedNodes.add(node);
	}

	public boolean addTrueNode(@NonNull Node node) {
		return alreadyTrueNodes.add(node);
	}

	private void analyzeEdges() {
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			if (!edge.isSecondary()) {
				if (edge.isPredicated()) {
					predicatedEdges.add(edge);
				}
				if (edge.isNavigation()) {
					if (edge.isRealized()) {
						realizedEdges.add(edge);
						Node sourceNode = edge.getEdgeSource();
						Node targetNode = edge.getEdgeTarget();
						if (traceNode2statusNode.containsKey(sourceNode)) {
							if (targetNode.isRealized() && !targetNode.isStatus()) {
								addCorrolary((NavigableEdge) edge);
							}
						}
						else if ((sourceNode.isPredicated() || sourceNode.isRealized())) {
							if (!traceNode2statusNode.containsKey(targetNode) && (targetNode.isPredicated() || targetNode.isRealized())) {
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
						if (!targetNode.isExplicitNull()) {
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
		}
	}

	private void analyzeNodes() {
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			if (node.isTrue()) {
				trueNodes.add(node);
			}
			else if (node.isExplicitNull()) {
				assert node.isConstant() && hasNoComputationInputs(node);
				leafConstantNodes.add(node);
			}
			else if (node.isPattern()) {
				if (node.isConstant()) {
				}
				else if (node.isLoaded()) {
					//					hasLoadedNodes  = true;
				}
				else if (scheduleManager.isMiddle(node)) {
					if (node.isPredicated()) {
						addConsumptionOfMiddleNode(node);
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
					else if (!node.isExplicitNull()) {
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
					if (hasNoComputationInputs(node)) {
						leafConstantNodes.add(node);
					}
				}
				else if (node.isRealized()) {
					realizedOutputNodes.add(node);
				}
			}
		}
	}

	private void analyzeStatusNode(@NonNull Node traceNode) {
		Node statusNode = null;
		Property statusProperty = scheduleManager.basicGetStatusProperty(traceNode);
		if (statusProperty != null) {
			transformationPartitioner.getSuccessPropertyDatum(statusProperty);
			RegionHelper<@NonNull MappingRegion> regionHelper = new RegionHelper<>(scheduleManager, region);
			statusNode = regionHelper.createStatusNode();
			statusNode.setUtility(Node.Utility.STRONGLY_MATCHED);
			@SuppressWarnings("unused")
			NavigableEdge statusEdge = regionHelper.createNavigationEdge(traceNode, statusProperty, statusNode, false);
		}
		traceNode2statusNode.put(traceNode, statusNode);
	}

	private void analyzeTraceEdges(@NonNull Node traceNode) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(traceNode)) {
			if ((edge.isNavigation() && edge.isRealized())) {
				Node tracedNode = QVTscheduleUtil.getTargetNode(edge);
				node2traceEdge.put(tracedNode, edge);
			}
		}
	}

	private @NonNull List<@NonNull Node> analyzeTraceNodes() {
		if (realizedMiddleNodes.size() == 0) {
			return Collections.emptyList();
		}
		if (realizedMiddleNodes.size() == 1) {
			return Collections.singletonList(realizedMiddleNodes.get(0));
		}
		//
		//	Compute the Set of all source nodes from which each target can be reached by transitive to-one navigation.
		//
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourceClosure = new HashMap<>();
		for (@NonNull Node targetNode : realizedMiddleNodes) {
			targetFromSourceClosure.put(targetNode, Sets.newHashSet(targetNode));
		}
		for (@NonNull Node sourceNode : realizedMiddleNodes) {
			for (@NonNull NavigableEdge navigationEdge : sourceNode.getRealizedNavigationEdges()) {
				Node targetNode = navigationEdge.getEdgeTarget();
				Set<@NonNull Node> sourceClosure = targetFromSourceClosure.get(targetNode);
				if (sourceClosure != null) {
					sourceClosure.add(sourceNode);
				}
			}
		}
		MappingRegionAnalysis mappingRegionAnalysis = new MappingRegionAnalysis(region);
		List<@NonNull Node> headNodes = mappingRegionAnalysis.computeHeadNodes(targetFromSourceClosure, null);
		if (headNodes.size() == 0) {
			return Collections.emptyList();
		}
		else {
			return Collections.singletonList(headNodes.get(0));
		}
	}

	//	public @Nullable Node basicGetStatusNode() {
	//		return statusNode;
	//	}

	//	public @Nullable Node basicGetTraceNode() {
	//		return traceNode;
	//	}

	private void check() {
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			if ((node.isSpeculated() || node.isRealized()) && !hasRealizedNode(node)) {
				transformationPartitioner.addProblem(CompilerUtil.createRegionError(region, "Should have realized " + node));
			}
		}
		Set<@NonNull Edge> allPrimaryEdges = new HashSet<>();
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			if (!edge.isSecondary()) {
				allPrimaryEdges.add(edge);
				if (edge.isRealized() && !hasRealizedEdge(edge)) {
					transformationPartitioner.addProblem(CompilerUtil.createRegionError(region, "Should have realized " + edge));
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
				if (transformationPartitioner.getCorrolaryOf(edge) == null) {// && !isDead(edge)) {
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

	private @NonNull MicroMappingRegion createAssignmentRegion(@NonNull Edge outputEdge, int i) {
		AssignmentPartition assignmentPartition = new AssignmentPartition(this, outputEdge);
		MicroMappingRegion microMappingRegion = assignmentPartition.createMicroMappingRegion("«edge" + i + "»", "_p" + i);
		scheduleManager.writeDebugGraphs(microMappingRegion, null);
		assignmentPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createRealizedRegion() {
		RealizedPartition realizedPartition = new RealizedPartition(this);
		MicroMappingRegion microMappingRegion = realizedPartition.createMicroMappingRegion("«realized»", "_r0");
		scheduleManager.writeDebugGraphs(microMappingRegion, null);
		realizedPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createSpeculatedRegion() {
		SpeculatedPartition speculatedPartition = new SpeculatedPartition(this);
		MicroMappingRegion microMappingRegion = speculatedPartition.createMicroMappingRegion("«speculated»", "_p2");
		scheduleManager.writeDebugGraphs(microMappingRegion, null);
		speculatedPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createSpeculatingRegion() {
		SpeculatingPartition speculatingPartition = new SpeculatingPartition(this);
		MicroMappingRegion microMappingRegion = speculatingPartition.createMicroMappingRegion("«speculating»", "_p1");
		scheduleManager.writeDebugGraphs(microMappingRegion, null);
		speculatingPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createSpeculationRegion() {
		SpeculationPartition speculationPartition = new SpeculationPartition(this);
		MicroMappingRegion microMappingRegion = speculationPartition.createMicroMappingRegion("«speculation»", "_p0");
		scheduleManager.writeDebugGraphs(microMappingRegion, null);
		speculationPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	//	public @NonNull Iterable<@NonNull Edge> getAlreadyPredicatedEdges() {
	//		return alreadyPredicatedEdges;
	//	}

	public @NonNull Iterable<@NonNull Edge> getAlreadyRealizedEdges() {
		return alreadyRealizedEdges.keySet();
	}

	public @Nullable Iterable<@NonNull TraceClassAnalysis> getConsumedTraceClassAnalyses() {
		return consumedTraceClassAnalyses;
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getCorrolaryEdges() {
		return corrolaryEdges;
	}

	public @NonNull Iterable<@NonNull Node> getCorrolaryNodes() {
		return corrolaryNodes;
	}

	public @NonNull Iterable<@NonNull Node> getLeafConstantNodes() {
		return leafConstantNodes;
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getOldPrimaryNavigableEdges() {
		return oldPrimaryNavigableEdges;
	}

	public @NonNull Iterable<@NonNull Edge> getPredicatedEdges() {
		return predicatedEdges;
	}

	public @NonNull Iterable<@NonNull Node> getPredicatedMiddleNodes() {
		return predicatedMiddleNodes;
	}

	public @NonNull Iterable<@NonNull Node> getPredicatedOutputNodes() {
		return predicatedOutputNodes;
	}

	public @Nullable Iterable<@NonNull TraceClassAnalysis> getProducedTraceClassAnalyses() {
		return producedTraceClassAnalyses;
	}

	public @NonNull Iterable<@NonNull Edge> getRealizedEdges() {
		return realizedEdges;
	}

	//	public @NonNull Iterable<@NonNull Node> getRealizedMiddleNodes() {
	//		return realizedMiddleNodes;
	//	}

	public @NonNull Iterable<@NonNull Node> getRealizedOutputNodes() {
		return realizedOutputNodes;
	}

	public @Nullable AbstractPartition getRealizingPartition(@NonNull Edge edge) {
		return alreadyRealizedEdges.get(edge);
	}

	public @NonNull MappingRegion getRegion() {
		return region;
	}

	protected @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @Nullable Node getStatusNode(@NonNull Node traceNode) {
		return traceNode2statusNode.get(traceNode);
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
		CompleteClass traceClass = traceNode.getCompleteClass();
		return transformationPartitioner.getTraceClassAnalysis(traceClass);
	}

	public @Nullable Edge getTraceEdge(@NonNull Node node) {
		return node2traceEdge.get(node);
	}

	public @NonNull Iterable<@NonNull Node> getTraceNodes() {
		return traceNode2statusNode.keySet();
	}

	public @NonNull TransformationPartitioner getTransformationPartitioner() {
		return transformationPartitioner;
	}

	public @NonNull Iterable<@NonNull Node> getTrueNodes() {
		return trueNodes;
	}

	private boolean hasNoComputationInputs(@NonNull Node node) {
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isComputation()) {
				return false;
			}
		}
		return true;
	}

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

	public boolean hasTrueNode(@NonNull Node node) {
		return alreadyTrueNodes.contains(node);
	}

	public @Nullable List<@NonNull MappingRegion> getCorrolaryOf(@NonNull Edge edge) {
		return transformationPartitioner.getCorrolaryOf(edge);
	}

	public boolean isCyclic(@NonNull Node node) {
		CompleteClass traceClass = node.getCompleteClass();
		return transformationPartitioner.isCyclic(traceClass);
	}

	private boolean isDead(@NonNull Node node, @Nullable Set<@NonNull Node> knownDeadNodes) {
		if (node.isHead()) {
			return false;
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isNavigation()) {
				if ((knownDeadNodes == null) || !knownDeadNodes.contains(edge.getEdgeSource())) {
					return false;
				}
			}
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(node)) {
			if (edge.isNavigation() || edge.isExpression()) {
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
		//		System.out.println("    partition " + region);
		//		Node traceNode2 = traceNode;
		//		assert traceNode2 != null;												// Regular mapping
		//		if (!hasLoadedNodes) {										// No inputs
		//			Collections.singletonList(region);
		//		} else
		if (transformationPartitioner.getCycleAnalysis(this) == null) {	// Cycle analysis failed
			return Collections.singletonList(region);
		}
		//		else if (region.getName().startsWith(QVTrNameGenerator.OVERRIDDEN_PREFIX)) {	// FIXME better test
		//			return Collections.singletonList(region);
		//		}
		else {
			List<@NonNull MappingRegion> regions = new ArrayList<>();
			if (predicatedMiddleNodes.isEmpty()) {
				regions.add(createRealizedRegion());
			}
			else {
				regions.add(createSpeculationRegion());
				regions.add(createSpeculatingRegion());
				regions.add(createSpeculatedRegion());
			}
			//
			//	Create an AssignmentRegion for each to-be-realized edge to an output, which may also realize most trace edges too.
			//
			for (@NonNull Edge outputEdge : realizedOutputEdges) {
				if (!hasRealizedEdge(outputEdge)) {
					regions.add(createAssignmentRegion(outputEdge, regions.size()));
				}
			}
			//
			//	Create an AssignmentRegion for each still to-be-realized edge to an output.
			//
			for (@NonNull Edge edge : realizedEdges) {
				if (!hasRealizedEdge(edge)) {
					regions.add(createAssignmentRegion(edge, regions.size()));
				}
			}
			check();
			return regions;
		}
	}

	@Override
	public String toString() {
		return region.getName();
	}
}
