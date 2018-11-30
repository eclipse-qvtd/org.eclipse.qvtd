/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.ConnectionManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

public abstract class MappingPartitionAnalysis<P extends MappingPartition> extends AbstractPartitionAnalysis<P>
{
	/**
	 * The trace nodes and their corresponding global success node.
	 *
	 * There should normally be exactly one trace node.
	 *
	 * There is no trace node for Adolfo's prematurely folded middle optimization and for manual partitionings
	 * such as attributeColumns in testQVTcCompiler_SimpleUML2RDBMS_CG.
	 *
	 * There could be multiple trace nodes after an early merge results. Work in progress.
	 *
	private final @NonNull Map<@NonNull Node, @Nullable SuccessEdge> traceNode2globalSuccessEdge = new HashMap<>(); */

	/**
	 * The trace nodes and their corresponding local success node.
	 *
	 * There should normally be exactly one trace node.
	 *
	 * There is no trace node for Adolfo's prematurely folded middle optimization and for manual partitionings
	 * such as attributeColumns in testQVTcCompiler_SimpleUML2RDBMS_CG.
	 *
	 * There could be multiple trace nodes after an early merge results. Work in progress.
	 *
	private final @NonNull Map<@NonNull Node, @Nullable SuccessEdge> traceNode2localSuccessEdge = new HashMap<>(); */

	/**
	 * The map from node to the trace edge by which the node may be located by lookup in a trace node once its trace edge is realized..
	 *
	private final @NonNull Map<@NonNull Node, @NonNull Edge> node2traceEdge = new HashMap<>(); */

	/**
	 * The override dispatch node if needed.
	 */
	private @Nullable Node dispatchNode = null;

	/**
	 * The constant nodes that require no computation from other nodes.
	 */
	private final @NonNull List<@NonNull Node> constantInputNodes = new ArrayList<>();

	/**
	 * The constant nodes that impose a check on a computation from other nodes.
	 */
	private final @NonNull List<@NonNull Node> constantOutputNodes = new ArrayList<>();

	/**
	 * properties that are directly realized from a middle object provided all predicates are satisfied.
	 */
	private final @NonNull Set<@NonNull NavigableEdge> oldPrimaryNavigableEdges = new HashSet<>();
	private final @NonNull List<@NonNull Node> loadedInputNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Edge> predicatedEdges = new ArrayList<>();
	private final @NonNull List<@NonNull NavigableEdge> predicatedMiddleEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> predicatedMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull NavigableEdge> predicatedOutputEdges = new ArrayList<>();
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
	private @Nullable List<@NonNull TraceClassPartitionAnalysis> consumedTraceClassAnalyses = null;

	/**
	 * The TracePropertyAnalysis instances that are consumed by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull TracePropertyPartitionAnalysis> consumedTracePropertyAnalyses = null;

	/**
	 * The TraceClassAnalysis instances that are produced by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull TraceClassPartitionAnalysis> producedTraceClassAnalyses = null;

	/**
	 * The TracePropertyAnalysis instances that are produced by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull TracePropertyPartitionAnalysis> producedTracePropertyAnalyses = null;

	/**
	 * The TraceClassAnalysis instances and super instances that are produced by this MappingPartitioner.
	 */
	private @Nullable Set<@NonNull TraceClassPartitionAnalysis> superProducedTraceClassAnalyses = null;

	protected MappingPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull P partition) {
		super(partitionedTransformationAnalysis, partition);
	}

	private void addCheckedEdge(@NonNull NavigableEdge checkedEdge) {
		Role role = partition.getRole(checkedEdge);
		assert (role != null) && role.isChecked();
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(checkedEdge.getEdgeSource());
		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		partition.addCheckedEdge(typedModel, checkedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("    checked " + checkedEdge.getProperty() +
			" at " + partition.getPassRangeText() + " in " + typedModel + " for " + partition);
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

	private void addConsumptionOfEdge(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull NavigableEdge edge) {
		Property property = QVTscheduleUtil.getProperty(edge);
		if (property == scheduleManager.getStandardLibraryHelper().getOclContainerProperty()) {
			Node targetNode = QVTscheduleUtil.getSourceNode(edge);
			Node castTarget = targetNode;
			ClassDatum classDatum = QVTscheduleUtil.getClassDatum(castTarget);
			for (@NonNull PropertyDatum propertyDatum : scheduleManager.getOclContainerPropertyDatums(classDatum)) {
				addConsumptionOfPropertyDatum(partitionedTransformationAnalysis, propertyDatum);
			}
		}
		else {
			PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(edge);
			addConsumptionOfPropertyDatum(partitionedTransformationAnalysis, propertyDatum);
		}
	}

	private void addConsumptionOfInputNode(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Node node) {
		if (node.isClass() && !loadedInputNodes.contains(node)) {		// DataTypes are consumed by their edge
			loadedInputNodes.add(node);
			addConsumptionOfNode(partitionedTransformationAnalysis, node);
		}
	}

	private void addConsumptionOfMiddleEdge(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull NavigableEdge edge) {
		if (!predicatedMiddleEdges.contains(edge)) {
			predicatedMiddleEdges.add(edge);
			addConsumptionOfEdge(partitionedTransformationAnalysis, edge);
		}
	}

	private void addConsumptionOfMiddleNode(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Node node) {
		if (!predicatedMiddleNodes.contains(node)) {
			predicatedMiddleNodes.add(node);
			addConsumptionOfNode(partitionedTransformationAnalysis, node);
		}
	}

	private void addConsumptionOfNode(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Node node) {
		Node castNode = QVTscheduleUtil.getCastTarget(node);
		TraceClassPartitionAnalysis consumedTraceAnalysis = partitionedTransformationAnalysis.addConsumer(QVTscheduleUtil.getClassDatum(castNode), this);
		List<@NonNull TraceClassPartitionAnalysis> consumedTraceClassAnalyses2 = consumedTraceClassAnalyses;
		if (consumedTraceClassAnalyses2 == null) {
			consumedTraceClassAnalyses = consumedTraceClassAnalyses2 = new ArrayList<>();
		}
		if (!consumedTraceClassAnalyses2.contains(consumedTraceAnalysis)) {
			consumedTraceClassAnalyses2.add(consumedTraceAnalysis);
		}
	}

	private void addConsumptionOfOutputEdge(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull NavigableEdge edge) {
		if (!predicatedOutputEdges.contains(edge)) {
			predicatedOutputEdges.add(edge);
			addConsumptionOfEdge(partitionedTransformationAnalysis, edge);  // FIXME  gives 'should have realized' for 3*QVTc UML2RDBMS CollectionPartEdge
		}
	}

	private void addConsumptionOfOutputNode(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Node node) {
		if (!predicatedOutputNodes.contains(node)) {
			predicatedOutputNodes.add(node);
			addConsumptionOfNode(partitionedTransformationAnalysis, node);
		}
	}

	private void addConsumptionOfPropertyDatum(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull PropertyDatum propertyDatum) {
		TracePropertyPartitionAnalysis consumedTraceAnalysis = partitionedTransformationAnalysis.addConsumer(propertyDatum, this);
		List<@NonNull TracePropertyPartitionAnalysis> consumedTracePropertyAnalyses2 = consumedTracePropertyAnalyses;
		if (consumedTracePropertyAnalyses2 == null) {
			consumedTracePropertyAnalyses = consumedTracePropertyAnalyses2 = new ArrayList<>();
		}
		if (!consumedTracePropertyAnalyses2.contains(consumedTraceAnalysis)) {
			consumedTracePropertyAnalyses2.add(consumedTraceAnalysis);
		}
	}

	@Override
	public void addEnforcedEdge(@NonNull NavigableEdge realizedEdge) {
		Role role = partition.getRole(realizedEdge);
		assert (role != null) && role.isRealized();
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(realizedEdge.getEdgeSource());
		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		Property asProperty = partition.addEnforcedEdge(typedModel, realizedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("    enforced " + asProperty +
			" at " + partition.getPassRangeText() +
			" in " + typedModel + " for " + partition);
	}

	private void addProductionOfEdge(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull NavigableEdge edge) {
		assert isNew(edge);
		Property property = QVTscheduleUtil.getProperty(edge);
		assert property != scheduleManager.getStandardLibraryHelper().getOclContainerProperty();		// oclContainer is not assignable
		if (property.toString().contains("toA1") || property.toString().contains("ownsB")) {
			property.toString();
		}
		PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(edge);
		TracePropertyPartitionAnalysis producedTraceAnalysis = partitionedTransformationAnalysis.addProducer(propertyDatum, this);
		List<@NonNull TracePropertyPartitionAnalysis> producedTracePropertyAnalyses2 = producedTracePropertyAnalyses;
		if (producedTracePropertyAnalyses2 == null) {
			producedTracePropertyAnalyses = producedTracePropertyAnalyses2 = new ArrayList<>();
		}
		if (!producedTracePropertyAnalyses2.contains(producedTraceAnalysis)) {
			producedTracePropertyAnalyses2.add(producedTraceAnalysis);
		}
		PropertyDatum oppositePropertyDatum = propertyDatum.getOpposite();
		if (oppositePropertyDatum != null) {
			TracePropertyPartitionAnalysis oppositeProducedTraceAnalysis = partitionedTransformationAnalysis.addProducer(oppositePropertyDatum, this);
			if (!producedTracePropertyAnalyses2.contains(oppositeProducedTraceAnalysis)) {
				producedTracePropertyAnalyses2.add(oppositeProducedTraceAnalysis);
			}
		}
	}

	private void addProductionOfMiddleEdge(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull NavigableEdge edge) {
		if (isRealized(edge) && !realizedMiddleEdges.contains(edge)) {
			realizedMiddleEdges.add(edge);
			addProductionOfEdge(partitionedTransformationAnalysis, edge);
		}
	}

	private void addProductionOfMiddleNode(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Node node) {
		if (isRealized(node) && !realizedMiddleNodes.contains(node)) {
			realizedMiddleNodes.add(node);
			addProductionOfNode(partitionedTransformationAnalysis, node);
		}
	}

	private void addProductionOfNode(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Node node) {
		assert isNew(node);
		TraceClassPartitionAnalysis consumedTraceAnalysis = partitionedTransformationAnalysis.addProducer(QVTscheduleUtil.getClassDatum(node), this);
		List<@NonNull TraceClassPartitionAnalysis> producedTraceClassAnalyses2 = producedTraceClassAnalyses;
		if (producedTraceClassAnalyses2 == null) {
			producedTraceClassAnalyses = producedTraceClassAnalyses2 = new ArrayList<>();
		}
		if (!producedTraceClassAnalyses2.contains(consumedTraceAnalysis)) {
			producedTraceClassAnalyses2.add(consumedTraceAnalysis);
		}
	}

	private void addProductionOfOutputEdge(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull NavigableEdge edge) {
		if (isRealized(edge) && !realizedOutputEdges.contains(edge)) {
			realizedOutputEdges.add(edge);
			addProductionOfEdge(partitionedTransformationAnalysis, edge);
		}
	}

	private void addProductionOfOutputNode(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Node node) {
		if (isRealized(node) && !realizedOutputNodes.contains(node)) {
			realizedOutputNodes.add(node);
			addProductionOfNode(partitionedTransformationAnalysis, node);
		}
	}

	private void analyzeEdges(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		for (@NonNull Edge edge : partition.getPartialEdges()) {
			if (!edge.isSecondary()) {
				if (isPredicated(edge)) {
					predicatedEdges.add(edge);
				}
				if (edge instanceof NavigableEdge) {
					NavigableEdge navigableEdge = (NavigableEdge)edge;
					if (navigableEdge.isSuccess()) {
						successEdges.add((SuccessEdge) navigableEdge);
					}
					if (isRealized(navigableEdge)) {
						realizedEdges.add(navigableEdge);
					}
					else {
						oldPrimaryNavigableEdges.add(navigableEdge);
					}
					if (!isRealized(navigableEdge) && navigableEdge.isMatched() && !navigableEdge.isCast()) {  // FIXME is this totally obsolete
						assert !navigableEdge.isExpression();
						assert !navigableEdge.isComputation();
					}
					Node sourceNode = navigableEdge.getEdgeSource();
					//	Node targetNode = navigableEdge.getEdgeTarget();
					if (scheduleManager.isMiddle(sourceNode)) { // || scheduleManager.isMiddle(targetNode)) {
						if (isChecked(navigableEdge)) {
							addConsumptionOfMiddleEdge(partitionedTransformationAnalysis, navigableEdge);
						}
						else if (isRealized(navigableEdge)) {
							addProductionOfMiddleEdge(partitionedTransformationAnalysis, navigableEdge);
						}
						else {
							throw new IllegalStateException("middle edge must be predicated or realized : " + navigableEdge);
						}
					}
					else { // || scheduleManager.isOutput(targetNode)) {
						if (isLoaded(navigableEdge) || isConstant(navigableEdge)) {}
						else if (isChecked(navigableEdge)) {  // || isSpeculated(navigableEdge)) {
							if (!navigableEdge.isCast()) {
								addConsumptionOfOutputEdge(partitionedTransformationAnalysis, navigableEdge);
							}
						}
						else if (isRealized(navigableEdge)) {
							addProductionOfOutputEdge(partitionedTransformationAnalysis, navigableEdge);
						}
						else {
							throw new IllegalStateException("other edge must be predicated or realized : " + navigableEdge);
						}
					}
				}
				else if (edge.isExpression()) {}
				else if (edge instanceof IteratedEdge) {}
				else if (edge.isDependency()) {}
				else {
					throw new IllegalStateException("unsupported analyzeEdge : " + edge);
				}
			}
		}
	}

	/*	private void analyzeGlobalSuccessEdge(@NonNull Node traceNode) {
		SuccessEdge globalSuccessEdge = null;
		Property globalSuccessProperty = scheduleManager.basicGetGlobalSuccessProperty(traceNode);
		if (globalSuccessProperty != null) {
			NavigationEdge statusNavigationEdge = QVTscheduleUtil.basicGetNavigationEdge(traceNode, globalSuccessProperty);
			if (statusNavigationEdge != null) {
				globalSuccessEdge = (SuccessEdge) statusNavigationEdge;
			}
			else {		// Never needed
				/*				if (!(region instanceof DispatchRegion) && !(region instanceof VerdictRegion)) {
					RegionHelper<@NonNull MappingRegion> regionHelper = new RegionHelper<>(scheduleManager, (MappingRegion)region);
					successEdge = regionHelper.createRealizedSuccess(traceNode, successProperty, null);		// FIXME This creates a premature success in a speculation
					Node successNode = QVTscheduleUtil.getTargetNode(successEdge);
					successNode.setUtility(Node.Utility.STRONGLY_MATCHED);		// FIXME is this really neded
				} * /
			}
		}
		traceNode2globalSuccessEdge.put(traceNode, globalSuccessEdge);
	} */

	/*	private void analyzeLocalSuccessEdge(@NonNull Node traceNode) {
		SuccessEdge localSuccessEdge = null;
		Property localSuccessProperty = scheduleManager.basicGetLocalSuccessProperty(traceNode);
		if (localSuccessProperty != null) {
			NavigationEdge statusNavigationEdge = QVTscheduleUtil.basicGetNavigationEdge(traceNode, localSuccessProperty);
			if (statusNavigationEdge != null) {
				localSuccessEdge = (SuccessEdge) statusNavigationEdge;
			}
			else {		// Never needed
				/*				if (!(region instanceof DispatchRegion) && !(region instanceof VerdictRegion)) {
					RegionHelper<@NonNull MappingRegion> regionHelper = new RegionHelper<>(scheduleManager, (MappingRegion)region);
					successEdge = regionHelper.createRealizedSuccess(traceNode, successProperty, null);		// FIXME This creates a premature success in a speculation
					Node successNode = QVTscheduleUtil.getTargetNode(successEdge);
					successNode.setUtility(Node.Utility.STRONGLY_MATCHED);		// FIXME is this really neded
				} * /
			}
		}
		traceNode2localSuccessEdge.put(traceNode, localSuccessEdge);
	} */

	private void analyzeNodes(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		String name = getName();
		if ("mapBooleanExp_qvtr".equals(name)) {
			getClass();
		}
		for (@NonNull Node node : partition.getPartialNodes()) {
			if (node.isNullLiteral()) {
				addConstantNode(node);
			}
			else if (node.isOperation()) {
				if (isConstant(node)) {
					addConstantNode(node);
				}
				else if (isRealized(node)) {
					// FIXME addProductionOfOutputNode(node);
					//	realizedOutputNodes.add(node);
				}
			}
			else if (node.isPattern()) {
				if (isConstant(node)) {}
				else if (isLoaded(node)) {
					addConsumptionOfInputNode(partitionedTransformationAnalysis, node);
				}
				else if (scheduleManager.isMiddle(node)) {
					if (node.isDispatch()) {
						if (dispatchNode != null) {
							throw new IllegalStateException();		// Dual dispatcher
						}
						dispatchNode = node;
					}
					else if (node.isTrace()) {
						traceNodes.add(node);
					}
					if (isPredicated(node)) {
						addConsumptionOfMiddleNode(partitionedTransformationAnalysis, node);
					}
					else if (isSpeculated(node)) {
						if (!node.isHead()) {		// Don't create a self-consumption cycle
							addConsumptionOfMiddleNode(partitionedTransformationAnalysis, node);
						}
					}
					else if (isSpeculation(node)) {
						addProductionOfMiddleNode(partitionedTransformationAnalysis, node);
					}
					else if (isRealized(node)) {
						addProductionOfMiddleNode(partitionedTransformationAnalysis, node);
					}
					else {
						throw new IllegalStateException("middle node must be predicated or realized : " + node);
					}
				}
				else { // scheduleManager.isOutput(node)
					if (isPredicated(node)) {
						addConsumptionOfOutputNode(partitionedTransformationAnalysis, node);
					}
					else if (isRealized(node)) {
						addProductionOfOutputNode(partitionedTransformationAnalysis, node);
					}
					else {
						throw new IllegalStateException("other node must be predicated or realized : " + node);
					}
				}
			}
			else if (node.isDependency()) {
				addConsumptionOfOutputNode(partitionedTransformationAnalysis, node);
			}
			else if (node.isIterator()) {}
			else {
				throw new IllegalStateException("unsupported analyzeNode : " + node);
			}
		}
	}

	@Override
	public void analyzePartition() {
		analyzeNodes(partitionedTransformationAnalysis);
		analyzeEdges(partitionedTransformationAnalysis);
	}

	@Override
	public void analyzePartitionEdges() {
		for (@NonNull Edge edge : partition.getPartialEdges()) {
			if (edge.isNavigation()) {
				NavigationEdge navigationEdge = (NavigationEdge) edge;
				Node sourceNode = navigationEdge.getEdgeSource();
				ClassDatum classDatum = QVTscheduleUtil.getClassDatum(sourceNode);
				TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
				if (isPredicated(edge)) {
					assert !navigationEdge.isCast();
					partitionedTransformationAnalysis.addCheckedEdge(typedModel, navigationEdge);
				}
				else if (isRealized(edge)) {
					partitionedTransformationAnalysis.addRealizedEdge(typedModel, navigationEdge);
				}
			}
		}
		partition.initTypedModelAnalysis();
	}

	/*	private void analyzeTraceEdges(@NonNull Node traceNode) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(traceNode)) {
			if (((edge.isCast() || edge.isNavigation()) && partition.isRealized(edge))) {
				Node tracedNode = QVTscheduleUtil.getTargetNode(edge);
				node2traceEdge.put(tracedNode, edge);
			}
		}
	} */

	/*	private @NonNull Iterable<@NonNull Node> analyzeTraceNodes() {
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
		} * /
		return Iterables.concat(getPredicatedMiddleNodes(), getRealizedMiddleNodes());
	} */

	public @Nullable Node basicGetDispatchNode() {
		return dispatchNode;
	}

	/*	public @Nullable SuccessEdge basicGetGlobalSuccessEdge(@NonNull Node traceNode) {
		return traceNode2globalSuccessEdge.get(traceNode);
	}

	public @Nullable Node basicGetGlobalSuccessNode(@NonNull Node traceNode) {
		SuccessEdge successEdge = traceNode2globalSuccessEdge.get(traceNode);
		return successEdge != null ? successEdge.getTargetNode() : null;
	}

	public @Nullable SuccessEdge basicGetLocalSuccessEdge(@NonNull Node traceNode) {
		return traceNode2localSuccessEdge.get(traceNode);
	}

	public @Nullable Node basicGetLocalSuccessNode(@NonNull Node traceNode) {
		SuccessEdge successEdge = traceNode2localSuccessEdge.get(traceNode);
		return successEdge != null ? successEdge.getTargetNode() : null;
	} */

	@Override
	public void computeCheckedOrEnforcedEdges() {
		//	String name = getName();
		boolean doDebug = QVTscheduleConstants.POLLED_PROPERTIES.isActive();
		if (doDebug) {
			QVTscheduleConstants.POLLED_PROPERTIES.println("analyzing " + this + " (" + partition.getPassRangeText() + ")");
		}
		ConnectionManager connectionManager = scheduleManager.getConnectionManager();
		for (@NonNull Edge edge : partition.getPartialEdges()) {
			if (edge.isNavigation() && isChecked(edge)) {
				NavigationEdge checkedEdge = (NavigationEdge) edge;
				assert !checkedEdge.isCast();
				Property property = checkedEdge.getProperty();
				if (doDebug) {
					QVTscheduleConstants.POLLED_PROPERTIES.println("  analyzing " + checkedEdge.getEdgeSource().getName() + "::" + property.getName() + " : " + checkedEdge.getEdgeSource().getCompleteClass());
				}
				EdgeConnection edgeConnection = checkedEdge.getIncomingConnection();
				if (edgeConnection != null) {
					boolean isChecked = false;
					for (@NonNull Partition usedPartition : edgeConnection.getSourcePartitions()) {
						if (usedPartition.getLastPass() >= partition.getFirstPass()) {
							addCheckedEdge(checkedEdge);
							isChecked = true;
						}
					}
					if (isChecked) {
						for (@NonNull NavigableEdge usedEdge : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
							Region sourceRegion = QVTscheduleUtil.getOwningRegion(usedEdge);
							RegionAnalysis sourceRegionAnalysis = scheduleManager.getRegionAnalysis(sourceRegion);
							for (@NonNull PartitionAnalysis sourcePartitionAnalysis : sourceRegionAnalysis.getPartitionAnalyses()) {
								Role sourceRole = sourcePartitionAnalysis.getPartition().getRole(usedEdge);
								if ((sourceRole != null) && !sourceRole.isChecked()) {
									sourcePartitionAnalysis.addEnforcedEdge(usedEdge);
								}
							}
						}
					}
				}

				Node laterNode = checkedEdge.getEdgeSource();
				Node predicatedSourceNode = checkedEdge.getEdgeSource();
				Node predicatedTargetNode = checkedEdge.getEdgeTarget();
				NodeConnection usedConnection = connectionManager.getIncomingUsedConnection(predicatedTargetNode);
				if (usedConnection != null) {
					for (@NonNull Partition usedPartition : usedConnection.getSourcePartitions()) {
						if (usedPartition.getLastPass() >= partition.getFirstPass()) {			// FIXME =
							CompleteClass predicatedSourceType = predicatedSourceNode.getCompleteClass();
							CompleteClass predicatedTargetType = predicatedTargetNode.getCompleteClass();
							ClassDatum classDatum = QVTscheduleUtil.getClassDatum(laterNode);
							TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
							Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2realizedEdges = partitionedTransformationAnalysis.getProperty2RealizedEdges(typedModel);
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
												assert partition.getLastPass() >= usedPartition.getFirstPass();
												//														isNotHazardous = null;
											}
											else {
												//														isNotHazardous = "incompatible";
											}
											assert partition.getLastPass() >= usedPartition.getFirstPass();
											//													isNotHazardous = null;
											//											}
											//												if (isNotHazardous == null) {
											addCheckedEdge(checkedEdge);
											AbstractPartitionAnalysis<?> usedPartitionAnalysis = partitionedTransformationAnalysis.getPartitionAnalysis(usedPartition);
											usedPartitionAnalysis.addEnforcedEdge(realizedEdge);
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
									System.err.println("No realized edges for " + typedModel + "!" + property + " in " + this);
								}
								else {
									for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
										//	Region earlierRegion = QVTscheduleUtil.getOwningRegion(realizedEdge);
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
										//	else if (region == earlierRegion) {	// FIXME old commented out code for partitions
										//		checkIsHazardFreeBecause = null; 		// Same region requires inter-recursion check
										//		enforceIsHazardFreeBecause = null; 		// Same region requires inter-recursion enforce to be available for check
										//	}
										else if (usedPartition.getLastPass() < partition.getFirstPass()) {
											checkIsHazardFreeBecause = "later";
											enforceIsHazardFreeBecause = null; 		// Enforce required for later check
										}
										else {
											// The QVTi AS has insufficient precision to identify which of multiple references is hazardous
											checkIsHazardFreeBecause = null;
											enforceIsHazardFreeBecause = null;
										}
										if (checkIsHazardFreeBecause == null) {
											addCheckedEdge(checkedEdge);
										}
										else if (doDebug) {
											QVTscheduleConstants.POLLED_PROPERTIES.println("    ignored check for " + this + "::" + laterNode.getName() + "(" + partition.getPassRangeText() + ")" +
													" " + checkIsHazardFreeBecause + " (" + usedPartition.getPassRangeText() + ")" + usedPartition + "::" + realizedEdge.getEdgeSource().getName());
										}
										if (enforceIsHazardFreeBecause == null) {
											AbstractPartitionAnalysis<?> usedPartitionAnalysis = partitionedTransformationAnalysis.getPartitionAnalysis(usedPartition);
											usedPartitionAnalysis.addEnforcedEdge(realizedEdge);
										}
										else if (doDebug) {
											QVTscheduleConstants.POLLED_PROPERTIES.println("    ignored enforce " + this + "::" + laterNode.getName() + "(" + partition.getPassRangeText() + ")" +
													" " + enforceIsHazardFreeBecause + " (" + usedPartition.getPassRangeText() + ")" + usedPartition + "::" + realizedEdge.getEdgeSource().getName());
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public @NonNull Iterable<@NonNull Node> getConstantInputNodes() {
		return constantInputNodes;
	}

	public @NonNull Iterable<@NonNull Node> getConstantOutputNodes() {
		return constantOutputNodes;
	}

	//		@Override
	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getConsumedTraceClassAnalyses() {
		return consumedTraceClassAnalyses;
	}

	//		@Override
	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getConsumedTracePropertyAnalyses() {
		return consumedTracePropertyAnalyses;
	}

	/*	public @NonNull SuccessEdge getGlobalSuccessEdge(@NonNull Node traceNode) {
		return ClassUtil.nonNullState(traceNode2globalSuccessEdge.get(traceNode));
	}

	public @NonNull Node getGlobalSuccessNode(@NonNull Node traceNode) {
		SuccessEdge successEdge = ClassUtil.nonNullState(traceNode2globalSuccessEdge.get(traceNode));
		return QVTscheduleUtil.getTargetNode(successEdge);
	}

	public @NonNull SuccessEdge getLocalSuccessEdge(@NonNull Node traceNode) {
		return ClassUtil.nonNullState(traceNode2localSuccessEdge.get(traceNode));
	}

	public @NonNull Node getLocalSuccessNode(@NonNull Node traceNode) {
		SuccessEdge successEdge = ClassUtil.nonNullState(traceNode2localSuccessEdge.get(traceNode));
		return QVTscheduleUtil.getTargetNode(successEdge);
	} */

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
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getProducedTraceClassAnalyses() {
		return producedTraceClassAnalyses;
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getProducedTracePropertyAnalyses() {
		return producedTracePropertyAnalyses;
	}

	public abstract @NonNull ReachabilityForest getReachabilityForest();

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

	public @NonNull Iterable<@NonNull SuccessEdge> getSuccessEdges() {
		return successEdges;
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getSuperProducedTraceClassAnalyses() {
		List<@NonNull TraceClassPartitionAnalysis> producedTraceClassAnalyses2 = producedTraceClassAnalyses;
		if (producedTraceClassAnalyses2 != null) {
			Set<@NonNull TraceClassPartitionAnalysis> superProducedTraceClassAnalyses2 = superProducedTraceClassAnalyses;
			if (superProducedTraceClassAnalyses2 == null) {
				superProducedTraceClassAnalyses = superProducedTraceClassAnalyses2 = new HashSet<>();
			}
			for (@NonNull TraceClassPartitionAnalysis producedTraceClassAnalysis : producedTraceClassAnalyses2) {
				Iterables.addAll(superProducedTraceClassAnalyses2, producedTraceClassAnalysis.getSuperTraceClassAnalyses());
			}
		}
		return superProducedTraceClassAnalyses;
	}

	/*	public @Nullable Edge getTraceEdge(@NonNull Node node) {
		return node2traceEdge.get(node);
	} */

	@Override
	public @NonNull List<@NonNull Node> getTraceNodes() {
		return traceNodes;
	}

	protected boolean isConstant(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isConstant();
	}

	protected boolean isConstant(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isConstant();
	}

	protected boolean isLoaded(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isLoaded();
	}

	protected boolean isLoaded(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isLoaded();
	}

	protected boolean isNew(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isNew();
	}

	protected boolean isNew(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isNew();
	}

	protected boolean isOld(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isOld();
	}

	protected boolean isPredicated(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isPredicated();
	}

	protected boolean isPredicated(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isPredicated();
	}

	protected boolean isRealized(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isRealized();
	}

	protected boolean isRealized(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isRealized();
	}

	protected boolean isSpeculated(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isSpeculated();
	}

	protected boolean isSpeculated(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isSpeculated();
	}

	protected boolean isSpeculation(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isSpeculation();
	}
}
