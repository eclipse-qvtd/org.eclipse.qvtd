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
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TraceClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TracePropertyAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

public class RegionAnalysis extends RegionHelper<@NonNull Region>implements Nameable
{
	protected final @NonNull TransformationAnalysis transformationAnalysis;
	//	protected final @NonNull ScheduleManager scheduleManager;
	//	protected final @NonNull Region region;

	/**
	 * The per-typed model predicated navigable edges for which an execution may be attempted before assignment.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2checkedEdges = null;

	/**
	 * The per-typed model realized navigable edges for which an execution may be attempted elsewhere before assignment here.
	 * Sub-index is both by property and its opposite.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>>> typedModel2property2enforcedEdges = null;

	/**
	 * The override dispatch node if needed.
	 */
	private @Nullable Node dispatchNode = null;

	/**
	 * The TraceClassAnalysis instances that are consumed by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull TraceClassAnalysis> consumedTraceClassAnalyses = null;

	/**
	 * The TracePropertyAnalysis instances that are consumed by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull TracePropertyAnalysis> consumedTracePropertyAnalyses = null;

	/**
	 * The TraceClassAnalysis instances that are produced by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull TraceClassAnalysis> producedTraceClassAnalyses = null;

	/**
	 * The TracePropertyAnalysis instances that are produced by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull TracePropertyAnalysis> producedTracePropertyAnalyses = null;

	/**
	 * The TraceClassAnalysis instances and super instances that are produced by this MappingPartitioner.
	 */
	private @Nullable Set<@NonNull TraceClassAnalysis> superProducedTraceClassAnalyses = null;

	/**
	 * The TracePropertyAnalysis instances and super instances that are produced by this MappingPartitioner.
	 */
	private @Nullable Set<@NonNull TracePropertyAnalysis> superProducedTracePropertyAnalyses = null;

	/**
	 * The constant nodes that require no computation from other nodes.
	 */
	private final @NonNull List<@NonNull Node> constantInputNodes = new ArrayList<>();

	/**
	 * The constant nodes that impose a check on a computation from other nodes.
	 */
	private final @NonNull List<@NonNull Node> constantOutputNodes = new ArrayList<>();

	/**
	 * The edges to be realized iff speculation succeeds.
	 */
	private final @NonNull List<@NonNull NavigableEdge> corollaryEdges = new ArrayList<>();

	/**
	 * The nodes to be realized iff speculation succeeds.
	 */
	private final @NonNull List<@NonNull Node> corollaryNodes = new ArrayList<>();

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
	 * The map from node to the trace edge by which the node may be located by lookup in a trace node once its trace edge is realized..
	 */
	private final @NonNull Map<@NonNull Node, @NonNull Edge> node2traceEdge = new HashMap<>();

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
	 * The actual and pseudo-RegionAnalysis-es that must be unconditionally successful for this RegionAnalysis
	 * to be unconditionally successful. null prior to determination.
	 *
	private @Nullable Iterable<@NonNull RegionAnalysis> fallibilities = null; */

	/**
	 * The edges that may be left unsynthesized when this RegionAnalysis is used in an infallible cycle.
	 *
	private @Nullable Iterable<@NonNull Edge> fallibleEdges = null; */

	public RegionAnalysis(@NonNull TransformationAnalysis transformationAnalysis, @NonNull Region region) {
		super(transformationAnalysis.getScheduleManager(), region);
		this.transformationAnalysis = transformationAnalysis;
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
		analyzeCorollaries(alreadyRealized);
	}

	private void addCheckedEdge(@NonNull NavigableEdge predicatedEdge) {
		assert predicatedEdge.isPredicated();
		assert predicatedEdge.getOwningRegion() == region;
		Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2checkedEdges2 = typedModel2checkedEdges;
		assert typedModel2checkedEdges2 != null;
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(predicatedEdge.getEdgeSource());
		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		Set<@NonNull NavigableEdge> checkedEdges = typedModel2checkedEdges2.get(typedModel);
		if (checkedEdges == null) {
			checkedEdges = new HashSet<>();
			typedModel2checkedEdges2.put(typedModel, checkedEdges);
		}
		checkedEdges.add(predicatedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("    checked " + predicatedEdge.getProperty() +
			" at " + region.getIndexRangeText() + " in " + typedModel + " for " + region);
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

	private void addConsumptionOfMiddleEdge(@NonNull NavigableEdge edge) {
		if (!predicatedMiddleEdges.contains(edge)) {
			predicatedMiddleEdges.add(edge);
			PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(edge);
			TracePropertyAnalysis consumedTraceAnalysis = transformationAnalysis.addConsumer(propertyDatum, this);
			List<@NonNull TracePropertyAnalysis> consumedTracePropertyAnalyses2 = consumedTracePropertyAnalyses;
			if (consumedTracePropertyAnalyses2 == null) {
				consumedTracePropertyAnalyses = consumedTracePropertyAnalyses2 = new ArrayList<>();
			}
			consumedTracePropertyAnalyses2.add(consumedTraceAnalysis);
		}
	}

	private void addConsumptionOfMiddleNode(@NonNull Node node) {
		if (!predicatedMiddleNodes.contains(node)) {
			predicatedMiddleNodes.add(node);
			TraceClassAnalysis consumedTraceAnalysis = transformationAnalysis.addConsumer(QVTscheduleUtil.getClassDatum(node), this);
			List<@NonNull TraceClassAnalysis> consumedTraceClassAnalyses2 = consumedTraceClassAnalyses;
			if (consumedTraceClassAnalyses2 == null) {
				consumedTraceClassAnalyses = consumedTraceClassAnalyses2 = new ArrayList<>();
			}
			consumedTraceClassAnalyses2.add(consumedTraceAnalysis);
		}
	}

	private void addEnforcedEdge(@NonNull NavigableEdge realizedEdge) {
		assert realizedEdge.isRealized();
		assert realizedEdge.getOwningRegion() == region;
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>>> typedModel2property2enforcedEdges2 = typedModel2property2enforcedEdges;
		assert typedModel2property2enforcedEdges2 != null;
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(realizedEdge.getEdgeSource());
		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>> property2enforcedEdges2 = typedModel2property2enforcedEdges2.get(typedModel);
		if (property2enforcedEdges2 == null) {
			property2enforcedEdges2 = new HashMap<>();
			typedModel2property2enforcedEdges2.put(typedModel, property2enforcedEdges2);
		}
		Property asProperty = QVTscheduleUtil.getProperty(realizedEdge);
		Set<@NonNull NavigableEdge> enforcedEdges = property2enforcedEdges2.get(asProperty);
		if (enforcedEdges == null) {
			enforcedEdges = new HashSet<>();
			property2enforcedEdges2.put(asProperty, enforcedEdges);
			Property asOpposite = asProperty.getOpposite();
			if (asOpposite != null) {
				property2enforcedEdges2.put(asOpposite, enforcedEdges);
			}
		}
		enforcedEdges.add(realizedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("    enforced " + asProperty +
			" at " + region.getIndexRangeText() +
			" in " + typedModel + " for " + region);
	}

	private void addProductionOfMiddleEdge(@NonNull NavigableEdge edge) {
		assert edge.isNew();
		if (edge.isRealized() && !realizedMiddleEdges.contains(edge)) {
			realizedMiddleEdges.add(edge);
		}
		PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(edge);
		TracePropertyAnalysis consumedTraceAnalysis = transformationAnalysis.addProducer(propertyDatum, this);
		List<@NonNull TracePropertyAnalysis> producedTracePropertyAnalyses2 = producedTracePropertyAnalyses;
		if (producedTracePropertyAnalyses2 == null) {
			producedTracePropertyAnalyses = producedTracePropertyAnalyses2 = new ArrayList<>();
		}
		if (!producedTracePropertyAnalyses2.contains(consumedTraceAnalysis)) {
			producedTracePropertyAnalyses2.add(consumedTraceAnalysis);
		}
	}

	private void addProductionOfMiddleNode(@NonNull Node node) {
		assert node.isNew();
		if (node.isRealized() && !realizedMiddleNodes.contains(node)) {
			realizedMiddleNodes.add(node);
		}
		TraceClassAnalysis consumedTraceAnalysis = transformationAnalysis.addProducer(QVTscheduleUtil.getClassDatum(node), this);
		List<@NonNull TraceClassAnalysis> producedTraceClassAnalyses2 = producedTraceClassAnalyses;
		if (producedTraceClassAnalyses2 == null) {
			producedTraceClassAnalyses = producedTraceClassAnalyses2 = new ArrayList<>();
		}
		if (!producedTraceClassAnalyses2.contains(consumedTraceAnalysis)) {
			producedTraceClassAnalyses2.add(consumedTraceAnalysis);
		}
	}

	/**
	 * Identify what gets realized as a consequence of the mapping succeeding.
	 *<p>
	 * The corollaries are realized nodes and edges that are logically realized at the same time as the trace node.
	 * However since the trace node may be created speculatively to host matched and success statuses,
	 * corollary realization is deferred until the speculation has been successfully resolved.
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
					transformationAnalysis.addCorollary(edge);
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
						NavigableEdge navigableEdge = (NavigableEdge)edge;
						realizedEdges.add(navigableEdge);
						Node sourceNode = edge.getEdgeSource();
						Node targetNode = edge.getEdgeTarget();
						/*if (traceNode2successEdge.containsKey(sourceNode)) {
							if (targetNode.isRealized() && !targetNode.isSuccess()) {
								addCorollary((NavigableEdge) edge);
							}
						}
						else*/ if ((sourceNode.isPredicated() || sourceNode.isRealized())) {
							if (!traceNode2successEdge.containsKey(targetNode) && (targetNode.isPredicated() || targetNode.isRealized())) {
								realizedOutputEdges.add(navigableEdge);
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
			Node sourceNode = edge.getEdgeSource();
			//			Node targetNode = edge.getEdgeTarget();
			if (scheduleManager.isMiddle(sourceNode)) { // || scheduleManager.isMiddle(targetNode)) {
				if (edge.isPredicated() || edge.isSpeculated()) {
					addConsumptionOfMiddleEdge(edge);
				}
				else {
					assert edge.isRealized();
					//					addProductionOfMiddleNode(sourceNode);
					addProductionOfMiddleEdge(edge);
				}
			}
			if (edge.isSuccess()) {
				successEdges.add((SuccessEdge) edge);
				//				Node sourceNode = edge.getEdgeSource();
				//				assert scheduleManager.isMiddle(sourceNode);
				//				if (edge.isPredicated()) {
				//					addConsumptionOfMiddleEdge(edge);
				//				}
				//				else {
				//					assert edge.isRealized();
				//					//					addProductionOfMiddleNode(sourceNode);
				//					addProductionOfMiddleEdge(edge);
				//				}
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
		return Iterables.concat(getPredicatedMiddleNodes(), getRealizedMiddleNodes());
	}

	public @Nullable Node basicGetDispatchNode() {
		return dispatchNode;
	}

	public void buildNavigationEdgesIndex(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		buildPredicatedNavigationEdgesIndex2(typedModel2property2predicatedEdges);
		buildRealizedNavigationEdgesIndex2(typedModel2property2realizedEdges);
		typedModel2checkedEdges = new HashMap<>();
		typedModel2property2enforcedEdges = new HashMap<>();
	}

	private void buildPredicatedNavigationEdgesIndex2(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges) {
		for (@NonNull NavigationEdge predicatedEdge : region.getPredicatedNavigationEdges()) {
			assert !predicatedEdge.isCast();
			Property property = QVTscheduleUtil.getProperty(predicatedEdge);
			Node predicatedNode = predicatedEdge.getEdgeSource();
			ClassDatum classDatum = QVTscheduleUtil.getClassDatum(predicatedNode);
			TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
			Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2predicatedEdges = typedModel2property2predicatedEdges.get(typedModel);
			if (property2predicatedEdges == null) {
				property2predicatedEdges = new HashMap<>();
				typedModel2property2predicatedEdges.put(typedModel, property2predicatedEdges);
			}
			List<@NonNull NavigableEdge> predicatedEdges = property2predicatedEdges.get(property);
			if (predicatedEdges == null) {
				predicatedEdges = new ArrayList<>();
				property2predicatedEdges.put(property, predicatedEdges);
			}
			predicatedEdges.add(predicatedEdge);
			QVTscheduleConstants.POLLED_PROPERTIES.println("  " + typedModel + " predicated for " + property);
		}
	}

	private void buildRealizedNavigationEdgesIndex2(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		for (@NonNull NavigableEdge realizedEdge : region.getRealizedNavigationEdges()) {
			Property property = QVTscheduleUtil.getProperty(realizedEdge);
			Node realizedNode = realizedEdge.getEdgeSource();
			ClassDatum classDatum = QVTscheduleUtil.getClassDatum(realizedNode);
			TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
			Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2realizedEdges = typedModel2property2realizedEdges.get(typedModel);
			if (property2realizedEdges == null) {
				property2realizedEdges = new HashMap<>();
				typedModel2property2realizedEdges.put(typedModel, property2realizedEdges);
			}
			List<@NonNull NavigableEdge> realizedEdges = property2realizedEdges.get(property);
			if (realizedEdges == null) {
				realizedEdges = new ArrayList<>();
				property2realizedEdges.put(property, realizedEdges);
			}
			realizedEdges.add(realizedEdge);
			QVTscheduleConstants.POLLED_PROPERTIES.println("  " + typedModel + " realized for " + property);
		}
	}

	public void computeCheckedOrEnforcedEdges(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		boolean doDebug = QVTscheduleConstants.POLLED_PROPERTIES.isActive();
		if (doDebug) {
			QVTscheduleConstants.POLLED_PROPERTIES.println("analyzing " + region + " (" + region.getIndexRangeText() + ")");
		}
		for (@NonNull NavigationEdge predicatedEdge : region.getPredicatedNavigationEdges()) {
			assert !predicatedEdge.isCast();
			Property property = predicatedEdge.getProperty();
			if (doDebug) {
				QVTscheduleConstants.POLLED_PROPERTIES.println("  analyzing " + predicatedEdge.getEdgeSource().getName() + "::" + property.getName() + " : " + predicatedEdge.getEdgeSource().getCompleteClass());
			}
			EdgeConnection edgeConnection = predicatedEdge.getIncomingConnection();
			if (edgeConnection != null) {
				boolean isChecked = false;
				for (@NonNull NavigableEdge usedEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
					Region usedRegion = QVTscheduleUtil.getOwningRegion(usedEdge);
					transformationAnalysis.getRegionAnalysis(usedRegion).addEnforcedEdge(usedEdge);
					if (usedRegion.getFinalExecutionIndex() >= region.getInvocationIndex()) {
						addCheckedEdge(predicatedEdge);
						isChecked = true;
					}
				}
				if (isChecked) {
					for (@NonNull NavigableEdge usedEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
						Region usedRegion = QVTscheduleUtil.getOwningRegion(usedEdge);
						scheduleManager.getRegionAnalysis(usedRegion).addEnforcedEdge(usedEdge);
					}
				}
			}

			Node laterNode = predicatedEdge.getEdgeSource();
			Node predicatedSourceNode = predicatedEdge.getEdgeSource();
			Node predicatedTargetNode = predicatedEdge.getEdgeTarget();
			NodeConnection usedConnection = predicatedTargetNode.getIncomingUsedConnection();
			if (usedConnection != null) {
				for (@NonNull Node usedSourceNode : QVTscheduleUtil.getSourceEnds(usedConnection)) {
					Region usedRegion = QVTscheduleUtil.getOwningRegion(usedSourceNode);
					if (usedRegion.getFinalExecutionIndex() >= region.getInvocationIndex()) {			// FIXME =
						CompleteClass predicatedSourceType = predicatedSourceNode.getCompleteClass();
						CompleteClass predicatedTargetType = predicatedTargetNode.getCompleteClass();
						ClassDatum classDatum = laterNode.getClassDatum();
						TypedModel typedModel = classDatum.getReferredTypedModel();
						Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2realizedEdges = typedModel2property2realizedEdges.get(typedModel);
						assert property2realizedEdges != null;
						Property oclContainerProperty = scheduleManager.getStandardLibraryHelper().getOclContainerProperty();
						if (property == oclContainerProperty) {
							//								Node containerNode = predicatedEdge.getTarget();
							//								Node containedNode = predicatedEdge.getSource();
							//								CompleteClass containerType = containerNode.getCompleteClass();
							//								CompleteClass containedType = containedNode.getCompleteClass();
							for (@NonNull Property candidateProperty : property2realizedEdges.keySet()) {
								if (candidateProperty.isIsComposite()) {
									//										CompleteClass candidateContainerType = completeModel.getCompleteClass(candidateProperty.getOwningClass());
									//										CompleteClass candidateContainedType = completeModel.getCompleteClass(candidateProperty.getType());
									//									if (candidateContainerType.conformsTo(containerType) && containedType.conformsTo(candidateContainedType)) {
									List<@NonNull NavigableEdge> realizedEdges = property2realizedEdges.get(candidateProperty);
									assert realizedEdges != null;
									for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
										// FIXME recheck for narrower types ??
										Region earlierRegion = realizedEdge.getOwningRegion();
										//												String isNotHazardous;
										//											if (region == earlierRegion) {
										//												isNotHazardous = "same region";	// FIXME must handle recursion
										//											}
										//											else if (earlierRegion.getLatestIndex() < getEarliestIndex()) {
										//												isNotHazardous = "later";// FIXME must handle any possible reads of any possible write
										//											}
										//											else {
										Node realizedSourceNode = realizedEdge.getEdgeSource();
										Node realizedTargetNode = realizedEdge.getEdgeTarget();
										CompleteClass realizedSourceType = realizedSourceNode.getCompleteClass();
										CompleteClass realizedTargetType = realizedTargetNode.getCompleteClass();
										if (realizedSourceType.conformsTo(predicatedSourceType) && realizedTargetType.conformsTo(predicatedTargetType)) {
											assert region.getFinalExecutionIndex() >= earlierRegion.getInvocationIndex();
											//														isNotHazardous = null;
										}
										else {
											//														isNotHazardous = "incompatible";
										}
										assert region.getFinalExecutionIndex() >= earlierRegion.getInvocationIndex();
										//													isNotHazardous = null;
										//											}
										//												if (isNotHazardous == null) {
										addCheckedEdge(predicatedEdge);
										scheduleManager.getRegionAnalysis(earlierRegion).addEnforcedEdge(realizedEdge);
										//												}
										//												else if (doDebug) {
										//													QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    ignored " + region + "::" + laterNode.getName() + "(" + getEarliestIndex() + ".." + getLatestIndex() + ")" +
										//															" " + isNotHazardous + " (" + earlierRegion.getEarliestIndex() + ".." + earlierRegion.getLatestIndex() + ")" + earlierRegion + "::" + realizedEdge.getSource().getName());
										//												}
										//										}
									}
								}
							}
						}
						else {
							assert property2realizedEdges != null : "No realized typed model for " + typedModel;
							List<@NonNull NavigableEdge> realizedEdges = property2realizedEdges.get(property);
							if (realizedEdges == null) {
								System.err.println("No realized edges for " + typedModel + "!" + property + " in " + region);
							}
							else {
								for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
									Region earlierRegion = QVTscheduleUtil.getOwningRegion(realizedEdge);
									String checkIsHazardFreeBecause;
									String enforceIsHazardFreeBecause;
									Node realizedSourceNode = realizedEdge.getEdgeSource();
									Node realizedTargetNode = realizedEdge.getEdgeTarget();
									CompleteClass realizedSourceType = realizedSourceNode.getCompleteClass();
									CompleteClass realizedTargetType = realizedTargetNode.getCompleteClass();
									if (!realizedSourceType.conformsTo(predicatedSourceType)) {
										checkIsHazardFreeBecause = "incompatible-source";
										enforceIsHazardFreeBecause = "incompatible-source";
									}
									else if (!QVTscheduleUtil.conformsToClassOrBehavioralClass(realizedTargetType, predicatedTargetType)) {
										checkIsHazardFreeBecause = "incompatible-target";
										enforceIsHazardFreeBecause = "incompatible-target";
									}
									else if (region == earlierRegion) {
										checkIsHazardFreeBecause = null; 		// Same region requires inter-recursion check
										enforceIsHazardFreeBecause = null; 		// Same region requires inter-recursion enforce to be available for check
									}
									else if (earlierRegion.getFinalExecutionIndex() < region.getInvocationIndex()) {
										checkIsHazardFreeBecause = "later";
										enforceIsHazardFreeBecause = null; 		// Enforce required for later check
									}
									else {
										// The QVTi AS has insufficient precision to identify which of multiple references is hazardous
										checkIsHazardFreeBecause = null;
										enforceIsHazardFreeBecause = null;
									}
									if (checkIsHazardFreeBecause == null) {
										addCheckedEdge(predicatedEdge);
									}
									else if (doDebug) {
										QVTscheduleConstants.POLLED_PROPERTIES.println("    ignored check for " + region + "::" + laterNode.getName() + "(" + region.getIndexRangeText() + ")" +
												" " + checkIsHazardFreeBecause + " (" + earlierRegion.getIndexRangeText() + ")" + earlierRegion + "::" + realizedEdge.getEdgeSource().getName());
									}
									if (enforceIsHazardFreeBecause == null) {
										scheduleManager.getRegionAnalysis(earlierRegion).addEnforcedEdge(realizedEdge);
									}
									else if (doDebug) {
										QVTscheduleConstants.POLLED_PROPERTIES.println("    ignored enforce " + region + "::" + laterNode.getName() + "(" + region.getIndexRangeText() + ")" +
												" " + enforceIsHazardFreeBecause + " (" + earlierRegion.getIndexRangeText() + ")" + earlierRegion + "::" + realizedEdge.getEdgeSource().getName());
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public @Nullable Set<@NonNull NavigableEdge> getCheckedEdges(@NonNull TypedModel typedModel) {
		assert typedModel2checkedEdges != null;
		return typedModel2checkedEdges.get(typedModel);
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

	public @Nullable Iterable<@NonNull TracePropertyAnalysis> getConsumedTracePropertyAnalyses() {
		return consumedTracePropertyAnalyses;
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getCorollaryEdges() {
		return corollaryEdges;
	}

	public @NonNull Iterable<@NonNull Node> getCorollaryNodes() {
		return corollaryNodes;
	}

	public @Nullable Iterable<@NonNull NavigableEdge> getEnforcedEdges(@NonNull TypedModel typedModel, @NonNull Property asProperty) {
		assert typedModel2property2enforcedEdges != null;
		Map<@NonNull Property, @NonNull Set<@NonNull NavigableEdge>> property2enforcedEdge = typedModel2property2enforcedEdges.get(typedModel);
		if (property2enforcedEdge != null) {
			Set<@NonNull NavigableEdge> enforcedEdges = property2enforcedEdge.get(asProperty);
			return enforcedEdges;
		}
		return null;
	}

	//	public @NonNull Iterable<@NonNull RegionAnalysis> getFallibilities() {
	//		return ClassUtil.nonNullState(fallibilities);
	//	}

	//	public @NonNull Iterable<@NonNull Edge> getFallibleEdges() {
	//		return ClassUtil.nonNullState(fallibleEdges);
	//	}

	@Override
	public @NonNull String getName() {
		return String.valueOf(region);
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

	public @Nullable Iterable<@NonNull TracePropertyAnalysis> getProducedTracePropertyAnalyses() {
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

	@Override
	public @NonNull Region getRegion() {
		return region;
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

	public @Nullable Iterable<@NonNull TracePropertyAnalysis> getSuperProducedTracePropertyAnalyses() {
		List<@NonNull TracePropertyAnalysis> producedTracePropertyAnalyses2 = producedTracePropertyAnalyses;
		if (producedTracePropertyAnalyses2 != null) {
			Set<@NonNull TracePropertyAnalysis> superProducedTracePropertyAnalyses2 = superProducedTracePropertyAnalyses;
			if (superProducedTracePropertyAnalyses2 == null) {
				superProducedTracePropertyAnalyses = superProducedTracePropertyAnalyses2 = new HashSet<>();
			}
			for (@NonNull TracePropertyAnalysis producedTracePropertyAnalysis : producedTracePropertyAnalyses2) {
				Iterables.addAll(superProducedTracePropertyAnalyses2, producedTracePropertyAnalysis.getSuperTracePropertyAnalyses());
			}
		}
		return superProducedTracePropertyAnalyses;
	}

	public @Nullable Edge getTraceEdge(@NonNull Node node) {
		return node2traceEdge.get(node);
	}

	public @NonNull List<@NonNull Node> getTraceNodes() {
		return traceNodes;
	}

	public @NonNull TransformationAnalysis getTransformationAnalysis() {
		return transformationAnalysis;
	}

	//	public void setFallibilities(@NonNull Iterable<@NonNull RegionAnalysis> fallibilities) {
	//		this.fallibilities = fallibilities;
	//	}

	//	public void setFallibleEdges(@NonNull Iterable<@NonNull Edge> fallibleEdges) {
	//		this.fallibleEdges  = fallibleEdges;
	//	}

	@Override
	public String toString() {
		return region.toString();
	}
}