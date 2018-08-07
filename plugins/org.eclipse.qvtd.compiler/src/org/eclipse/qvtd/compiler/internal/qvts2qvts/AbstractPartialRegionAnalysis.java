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
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TraceClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TracePropertyAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

public abstract class AbstractPartialRegionAnalysis<@NonNull RA extends @NonNull PartialRegionAnalysis<@NonNull RA>> extends RegionHelper<@NonNull Region> implements PartialRegionAnalysis<@NonNull RA>
{
	protected final @NonNull RegionsAnalysis<@NonNull RA> regionsAnalysis;
	//	protected final @NonNull ScheduleManager scheduleManager;
	//	protected final @NonNull Region region;

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
	 * The constant nodes that require no computation from other nodes.
	 */
	private final @NonNull List<@NonNull Node> constantInputNodes = new ArrayList<>();

	/**
	 * The constant nodes that impose a check on a computation from other nodes.
	 */
	private final @NonNull List<@NonNull Node> constantOutputNodes = new ArrayList<>();

	/**
	 * The override dispatch node if needed.
	 */
	private @Nullable Node dispatchNode = null;

	/**
	 * The map from node to the trace edge by which the node may be located by lookup in a trace node once its trace edge is realized..
	 */
	private final @NonNull Map<@NonNull Node, @NonNull Edge> node2traceEdge = new HashMap<>();

	/**
	 * properties that are directly realized from a middle object provided all predicates are satisfied.
	 */
	private final @NonNull Set<@NonNull NavigableEdge> oldPrimaryNavigableEdges = new HashSet<>();
	private final @NonNull List<@NonNull Edge> predicatedEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Edge> predicatedMiddleEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> predicatedMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> predicatedOutputNodes = new ArrayList<>();
	private final @NonNull Set<@NonNull NavigableEdge> realizedEdges = new HashSet<>();
	private final @NonNull List<@NonNull NavigableEdge> realizedMiddleEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> realizedMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull NavigableEdge> realizedOutputEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> realizedOutputNodes = new ArrayList<>();
	private final @NonNull Set<@NonNull SuccessEdge> successEdges = new HashSet<>();	// FIXME redundant wrt traceNode2successEdge.values()

	/**
	 * The trace node(s).
	 */
	private final @NonNull List<@NonNull Node> traceNodes = new ArrayList<>();

	/**
	 * The TraceClassAnalysis instances that are consumed by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull TraceClassAnalysis<@NonNull RA>> consumedTraceClassAnalyses = null;

	/**
	 * The TracePropertyAnalysis instances that are consumed by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull TracePropertyAnalysis<@NonNull RA>> consumedTracePropertyAnalyses = null;

	/**
	 * The TraceClassAnalysis instances that are produced by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull TraceClassAnalysis<@NonNull RA>> producedTraceClassAnalyses = null;

	/**
	 * The TracePropertyAnalysis instances that are produced by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull TracePropertyAnalysis<@NonNull RA>> producedTracePropertyAnalyses = null;

	/**
	 * The TraceClassAnalysis instances and super instances that are produced by this MappingPartitioner.
	 */
	private @Nullable Set<@NonNull TraceClassAnalysis<@NonNull RA>> superProducedTraceClassAnalyses = null;

	/**
	 * The TracePropertyAnalysis instances and super instances that are produced by this MappingPartitioner.
	 */
	private @Nullable Set<@NonNull TracePropertyAnalysis<@NonNull RA>> superProducedTracePropertyAnalyses = null;

	protected AbstractPartialRegionAnalysis(@NonNull RegionsAnalysis<@NonNull RA> regionsAnalysis, @NonNull Region region) {
		super(regionsAnalysis.getScheduleManager(), region);
		this.regionsAnalysis = regionsAnalysis;
	}

	private void addConstantNode(@NonNull Node node) {
		assert isConstant(node);
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isComputation() || ((edge.isCast() || edge.isNavigation()) && !isRealized(edge))) {
				constantOutputNodes.add(node);
				return;
			}
		}
		constantInputNodes.add(node);
	}

	private void addConsumptionOfMiddleEdge(@NonNull NavigableEdge edge) {
		if (!predicatedMiddleEdges.contains(edge)) {
			predicatedMiddleEdges.add(edge);
			PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(edge);
			TracePropertyAnalysis<@NonNull RA> consumedTraceAnalysis = regionsAnalysis.addConsumer(propertyDatum, getRA());
			List<@NonNull TracePropertyAnalysis<@NonNull RA>> consumedTracePropertyAnalyses2 = consumedTracePropertyAnalyses;
			if (consumedTracePropertyAnalyses2 == null) {
				consumedTracePropertyAnalyses = consumedTracePropertyAnalyses2 = new ArrayList<>();
			}
			if (!consumedTracePropertyAnalyses2.contains(consumedTraceAnalysis)) {
				consumedTracePropertyAnalyses2.add(consumedTraceAnalysis);
			}
		}
	}

	private void addConsumptionOfMiddleNode(@NonNull Node node) {
		if (!predicatedMiddleNodes.contains(node)) {
			predicatedMiddleNodes.add(node);
			TraceClassAnalysis<@NonNull RA> consumedTraceAnalysis = regionsAnalysis.addConsumer(QVTscheduleUtil.getClassDatum(node), getRA());
			List<@NonNull TraceClassAnalysis<@NonNull RA>> consumedTraceClassAnalyses2 = consumedTraceClassAnalyses;
			if (consumedTraceClassAnalyses2 == null) {
				consumedTraceClassAnalyses = consumedTraceClassAnalyses2 = new ArrayList<>();
			}
			if (!consumedTraceClassAnalyses2.contains(consumedTraceAnalysis)) {
				consumedTraceClassAnalyses2.add(consumedTraceAnalysis);
			}
		}
	}

	private void addProductionOfMiddleEdge(@NonNull NavigableEdge edge) {
		assert edge.isNew();
		if (isRealized(edge) && !realizedMiddleEdges.contains(edge)) {
			realizedMiddleEdges.add(edge);
		}
		PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(edge);
		TracePropertyAnalysis<@NonNull RA> consumedTraceAnalysis = regionsAnalysis.addProducer(propertyDatum, getRA());
		List<@NonNull TracePropertyAnalysis<@NonNull RA>> producedTracePropertyAnalyses2 = producedTracePropertyAnalyses;
		if (producedTracePropertyAnalyses2 == null) {
			producedTracePropertyAnalyses = producedTracePropertyAnalyses2 = new ArrayList<>();
		}
		if (!producedTracePropertyAnalyses2.contains(consumedTraceAnalysis)) {
			producedTracePropertyAnalyses2.add(consumedTraceAnalysis);
		}
	}

	private void addProductionOfMiddleNode(@NonNull Node node) {
		assert node.isNew();
		if (isRealized(node) && !realizedMiddleNodes.contains(node)) {
			realizedMiddleNodes.add(node);
		}
		TraceClassAnalysis<@NonNull RA> consumedTraceAnalysis = regionsAnalysis.addProducer(QVTscheduleUtil.getClassDatum(node), getRA());
		List<@NonNull TraceClassAnalysis<@NonNull RA>> producedTraceClassAnalyses2 = producedTraceClassAnalyses;
		if (producedTraceClassAnalyses2 == null) {
			producedTraceClassAnalyses = producedTraceClassAnalyses2 = new ArrayList<>();
		}
		if (!producedTraceClassAnalyses2.contains(consumedTraceAnalysis)) {
			producedTraceClassAnalyses2.add(consumedTraceAnalysis);
		}
	}

	protected @NonNull List<@NonNull Node> analyze() {
		analyzeNodes();
		for (@NonNull Node traceNode : analyzeTraceNodes()) {
			analyzeSuccessEdge(traceNode);
			analyzeTraceEdges(traceNode);
		}
		analyzeEdges();
		List<@NonNull Node> alreadyRealized = new ArrayList<>(getTraceNodes());
		Node dispatchNode = basicGetDispatchNode();
		if (dispatchNode != null) {
			alreadyRealized.add(dispatchNode);
		}
		return alreadyRealized;
	}

	private void analyzeEdges() {
		for (@NonNull Edge edge : getPartialEdges()) {
			if (!edge.isSecondary()) {
				if (isPredicated(edge)) {
					predicatedEdges.add(edge);
				}
				if (edge.isCast() || edge.isNavigation()) {
					if (isRealized(edge)) {
						NavigableEdge navigableEdge = (NavigableEdge)edge;
						realizedEdges.add(navigableEdge);
						Node sourceNode = edge.getEdgeSource();
						Node targetNode = edge.getEdgeTarget();
						/*if (traceNode2successEdge.containsKey(sourceNode)) {
							if (isRealized(targetNode) && !targetNode.isSuccess()) {
								addCorollary((NavigableEdge) edge);
							}
						}
						else*/ if ((isPredicated(sourceNode) || isRealized(sourceNode))) {
							if (!traceNode2successEdge.containsKey(targetNode) && (isPredicated(targetNode) || isRealized(targetNode))) {
								realizedOutputEdges.add(navigableEdge);
							}
						}
						if (isLoaded(targetNode) && scheduleManager.isMiddle(sourceNode)) {
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
					if (isLoaded(edge.getTarget()) && edge.getSource().getClassDatumAnalysis().getDomainUsage().isMiddle()) {
						//							navigableEdges.add(navigationEdge);
					}
				} */
			}
		}
		for (@NonNull Edge edge : getPartialEdges()) {
			if (edge instanceof NavigableEdge) {
				NavigableEdge navigableEdge = (NavigableEdge)edge;
				if (!navigableEdge.isSecondary() && !isRealized(navigableEdge)) {
					oldPrimaryNavigableEdges.add(navigableEdge);
				}
				Node sourceNode = navigableEdge.getEdgeSource();
				//			Node targetNode = edge.getEdgeTarget();
				if (scheduleManager.isMiddle(sourceNode)) { // || scheduleManager.isMiddle(targetNode)) {
					if (isPredicated(navigableEdge) || isSpeculated(navigableEdge)) {
						addConsumptionOfMiddleEdge(navigableEdge);
					}
					else {
						assert isRealized(navigableEdge);
						//					addProductionOfMiddleNode(sourceNode);
						addProductionOfMiddleEdge(navigableEdge);
					}
				}
				if (navigableEdge.isSuccess()) {
					successEdges.add((SuccessEdge) navigableEdge);
					//				Node sourceNode = edge.getEdgeSource();
					//				assert scheduleManager.isMiddle(sourceNode);
					//				if (isPredicated(edge)) {
					//					addConsumptionOfMiddleEdge(edge);
					//				}
					//				else {
					//					assert isRealized(edge);
					//					//					addProductionOfMiddleNode(sourceNode);
					//					addProductionOfMiddleEdge(edge);
					//				}
				}
			}
		}
	}

	private void analyzeNodes() {
		for (@NonNull Node node : getPartialNodes()) {
			if (node.isNullLiteral()) {
				addConstantNode(node);
			}
			else if (node.isPattern()) {
				if (isConstant(node)) {
				}
				else if (isLoaded(node)) {
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
					if (isPredicated(node)) {
						addConsumptionOfMiddleNode(node);
					}
					else if (isSpeculated(node)) {
						if (!node.isHead()) {		// Don't create a self-consumption cycle
							addConsumptionOfMiddleNode(node);
						}
					}
					else if (isSpeculation(node)) {
						addProductionOfMiddleNode(node);
					}
					else if (isRealized(node)) {
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
						if (isPredicated(node)) {
							predicatedOutputNodes.add(node);
						}
						else if (isRealized(node)) {
							realizedOutputNodes.add(node);
						}
					}
				}
			}
			else if (node.isOperation()) {
				if (isConstant(node)) {
					addConstantNode(node);
				}
				else if (isRealized(node)) {
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
			else {		// Never needed
				/*				if (!(region instanceof DispatchRegion) && !(region instanceof VerdictRegion)) {
					RegionHelper<@NonNull MappingRegion> regionHelper = new RegionHelper<>(scheduleManager, (MappingRegion)region);
					successEdge = regionHelper.createRealizedSuccess(traceNode, successProperty, null);		// FIXME This creates a premature success in a speculation
					Node successNode = QVTscheduleUtil.getTargetNode(successEdge);
					successNode.setUtility(Node.Utility.STRONGLY_MATCHED);		// FIXME is this really neded
				} */
			}
		}
		traceNode2successEdge.put(traceNode, successEdge);
	}

	private void analyzeTraceEdges(@NonNull Node traceNode) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(traceNode)) {
			if (((edge.isCast() || edge.isNavigation()) && isRealized(edge))) {
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
		return Iterables.concat(getPredicatedMiddleNodes(), getRealizedMiddleNodes());
	}

	public @Nullable Node basicGetDispatchNode() {
		return dispatchNode;
	}

	public @NonNull Iterable<@NonNull Node> getConstantInputNodes() {
		return constantInputNodes;
	}

	public @NonNull Iterable<@NonNull Node> getConstantOutputNodes() {
		return constantOutputNodes;
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> getConsumedTraceClassAnalyses() {
		return consumedTraceClassAnalyses;
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> getConsumedTracePropertyAnalyses() {
		return consumedTracePropertyAnalyses;
	}

	protected abstract @NonNull Iterable<@NonNull Edge> getPartialEdges();

	protected abstract @NonNull Iterable<@NonNull Node> getPartialNodes();

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

	@Override
	public @Nullable Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> getProducedTraceClassAnalyses() {
		return producedTraceClassAnalyses;
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> getProducedTracePropertyAnalyses() {
		return producedTracePropertyAnalyses;
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getRealizedEdges() {
		return realizedEdges;
	}

	public @NonNull Iterable<@NonNull Node> getRealizedMiddleNodes() {
		return realizedMiddleNodes;
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getRealizedOutputEdges() {
		return realizedOutputEdges;
	}

	public @NonNull Iterable<@NonNull Node> getRealizedOutputNodes() {
		return realizedOutputNodes;
	}

	@SuppressWarnings("unchecked")
	private @NonNull RA getRA() {
		return (@NonNull RA) this;
	}

	//	@Override
	//	public @NonNull Region getRegion() {
	//		return region;
	//	}

	public @Nullable Role getRole(@NonNull Edge edge) {
		return  edge.getEdgeRole();
	}

	public @Nullable Role getRole(@NonNull Node node) {
		return  node.getNodeRole();
	}

	@Override
	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
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

	@Override
	public @Nullable Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> getSuperProducedTraceClassAnalyses() {
		List<@NonNull TraceClassAnalysis<@NonNull RA>> producedTraceClassAnalyses2 = producedTraceClassAnalyses;
		if (producedTraceClassAnalyses2 != null) {
			Set<@NonNull TraceClassAnalysis<@NonNull RA>> superProducedTraceClassAnalyses2 = superProducedTraceClassAnalyses;
			if (superProducedTraceClassAnalyses2 == null) {
				superProducedTraceClassAnalyses = superProducedTraceClassAnalyses2 = new HashSet<>();
			}
			for (@NonNull TraceClassAnalysis<@NonNull RA> producedTraceClassAnalysis : producedTraceClassAnalyses2) {
				Iterables.addAll(superProducedTraceClassAnalyses2, producedTraceClassAnalysis.getSuperTraceClassAnalyses());
			}
		}
		return superProducedTraceClassAnalyses;
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> getSuperProducedTracePropertyAnalyses() {
		List<@NonNull TracePropertyAnalysis<@NonNull RA>> producedTracePropertyAnalyses2 = producedTracePropertyAnalyses;
		if (producedTracePropertyAnalyses2 != null) {
			Set<@NonNull TracePropertyAnalysis<@NonNull RA>> superProducedTracePropertyAnalyses2 = superProducedTracePropertyAnalyses;
			if (superProducedTracePropertyAnalyses2 == null) {
				superProducedTracePropertyAnalyses2 = superProducedTracePropertyAnalyses = new HashSet<>();
			}
			for (@NonNull TracePropertyAnalysis<@NonNull RA> producedTracePropertyAnalysis : producedTracePropertyAnalyses2) {
				Iterables.addAll(superProducedTracePropertyAnalyses2, producedTracePropertyAnalysis.getSuperTracePropertyAnalyses(getRA()));
			}
		}
		return superProducedTracePropertyAnalyses;
	}

	@Override
	public @NonNull TraceClassAnalysis<@NonNull RA> getTraceClassAnalysis(@NonNull ClassDatum traceClassDatum) {
		return regionsAnalysis.getTraceClassAnalysis(traceClassDatum);
	}

	@Override
	public @NonNull TracePropertyAnalysis<@NonNull RA> getTracePropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		return regionsAnalysis.getTracePropertyAnalysis(propertyDatum);
	}

	public @Nullable Edge getTraceEdge(@NonNull Node node) {
		return node2traceEdge.get(node);
	}

	@Override
	public @NonNull List<@NonNull Node> getTraceNodes() {
		return traceNodes;
	}

	protected boolean isConstant(@NonNull Node node) {
		return node.isConstant();
	}

	protected boolean isLoaded(@NonNull Node node) {
		return node.isLoaded();
	}

	protected boolean isPredicated(@NonNull Edge edge) {
		return edge.isPredicated();
	}

	protected boolean isPredicated(@NonNull Node node) {
		return node.isPredicated();
	}

	protected boolean isRealized(@NonNull Edge edge) {
		return edge.isRealized();
	}

	protected boolean isRealized(@NonNull Node node) {
		return node.isRealized();
	}

	protected boolean isSpeculated(@NonNull Edge edge) {
		return edge.isSpeculated();
	}

	protected boolean isSpeculated(@NonNull Node node) {
		return node.isSpeculated();
	}

	protected boolean isSpeculation(@NonNull Node node) {
		return node.isSpeculation();
	}
}