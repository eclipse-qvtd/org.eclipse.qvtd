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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToGraphHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

public abstract class AbstractPartition2 extends AbstractPartition
{
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The trace nodes and their corresponding global success node.
	 *
	 * There should normally be exactly one trace node.
	 *
	 * There is no trace node for Adolfo's prematurely folded middle optimization and for manual partitionings
	 * such as attributeColumns in testQVTcCompiler_SimpleUML2RDBMS_CG.
	 *
	 * There could be multiple trace nodes after an early merge results. Work in progress.
	 */
	private final @NonNull Map<@NonNull Node, @Nullable SuccessEdge> traceNode2globalSuccessEdge = new HashMap<>();

	/**
	 * The trace nodes and their corresponding local success node.
	 *
	 * There should normally be exactly one trace node.
	 *
	 * There is no trace node for Adolfo's prematurely folded middle optimization and for manual partitionings
	 * such as attributeColumns in testQVTcCompiler_SimpleUML2RDBMS_CG.
	 *
	 * There could be multiple trace nodes after an early merge results. Work in progress.
	 */
	private final @NonNull Map<@NonNull Node, @Nullable SuccessEdge> traceNode2localSuccessEdge = new HashMap<>();

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

	protected AbstractPartition2(@NonNull String name, @NonNull ScheduleManager scheduleManager) {
		super(name);
		this.scheduleManager = scheduleManager;
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

	protected @NonNull List<@NonNull Node> analyze(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		analyzeNodes(partitionedTransformationAnalysis);
		for (@NonNull Node traceNode : analyzeTraceNodes()) {
			analyzeLocalSuccessEdge(traceNode);
			analyzeGlobalSuccessEdge(traceNode);
			analyzeTraceEdges(traceNode);
		}
		analyzeEdges(partitionedTransformationAnalysis);
		List<@NonNull Node> alreadyRealized = new ArrayList<>(getTraceNodes());
		Node dispatchNode = basicGetDispatchNode();
		if (dispatchNode != null) {
			alreadyRealized.add(dispatchNode);
		}
		return alreadyRealized;
	}

	private void analyzeEdges(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		for (@NonNull Edge edge : getPartialEdges()) {
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
						if (isPredicated(navigableEdge) || isSpeculated(navigableEdge)) {
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
						else if (isPredicated(navigableEdge)) {  // || isSpeculated(navigableEdge)) {
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

	private void analyzeGlobalSuccessEdge(@NonNull Node traceNode) {
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
				} */
			}
		}
		traceNode2globalSuccessEdge.put(traceNode, globalSuccessEdge);
	}

	protected void analyzeLocalSuccessEdge(@NonNull Node traceNode) {
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
				} */
			}
		}
		traceNode2localSuccessEdge.put(traceNode, localSuccessEdge);
	}

	private void analyzeNodes(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		for (@NonNull Node node : getPartialNodes()) {
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

	@Override
	public void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName) {
		GraphStringBuilder s = toGraphHelper.getGraphStringBuilder();
		String label = /*getSymbolName() + "\\n " +*/ getName();
		String passesText = getPassesText();
		if (passesText != null) {
			label = label + "\\n " + passesText;
		}
		s.setLabel(label);
		//	String shape = getShape();
		//	if (shape != null) {
		//		s.setShape(shape);
		//	}
		//	String style = getStyle();
		//	if (style != null) {
		//		s.setStyle(style);
		//	}
		s.setColor(getColor());
		//		s.setPenwidth(getPenwidth());
		s.appendAttributedNode(nodeName);
		//		if (isHead) {
		//			s.append("}");
		//		}
	}

	public @Nullable Node basicGetDispatchNode() {
		return dispatchNode;
	}

	public @Nullable SuccessEdge basicGetGlobalSuccessEdge(@NonNull Node traceNode) {
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
	}

	public @NonNull Iterable<@NonNull Node> getConstantInputNodes() {
		return constantInputNodes;
	}

	public @NonNull Iterable<@NonNull Node> getConstantOutputNodes() {
		return constantOutputNodes;
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getConsumedTraceClassAnalyses() {
		return consumedTraceClassAnalyses;
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getConsumedTracePropertyAnalyses() {
		return consumedTracePropertyAnalyses;
	}

	public @NonNull SuccessEdge getGlobalSuccessEdge(@NonNull Node traceNode) {
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

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getProducedTraceClassAnalyses() {
		return producedTraceClassAnalyses;
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getProducedTracePropertyAnalyses() {
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

	//	@Override
	//	public @NonNull Region getRegion() {
	//		return region;
	//	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
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

	public @Nullable Edge getTraceEdge(@NonNull Node node) {
		return node2traceEdge.get(node);
	}

	@Override
	public @NonNull List<@NonNull Node> getTraceNodes() {
		return traceNodes;
	}

	@Override
	public boolean isAwaited(@NonNull Edge edge) {
		Role role = getRole(edge);
		assert role != null;
		return role.isAwaited();
	}

	protected boolean isConstant(@NonNull Edge edge) {
		Role role = getRole(edge);
		assert role != null;
		return role.isConstant();
	}

	protected boolean isConstant(@NonNull Node node) {
		Role role = getRole(node);
		assert role != null;
		return role.isConstant();
	}

	protected boolean isLoaded(@NonNull Edge edge) {
		Role role = getRole(edge);
		assert role != null;
		return role.isLoaded();
	}

	protected boolean isLoaded(@NonNull Node node) {
		Role role = getRole(node);
		assert role != null;
		return role.isLoaded();
	}

	protected boolean isNew(@NonNull Edge edge) {
		Role role = getRole(edge);
		assert role != null;
		return role.isNew();
	}

	protected boolean isNew(@NonNull Node node) {
		Role role = getRole(node);
		assert role != null;
		return role.isNew();
	}

	protected boolean isPredicated(@NonNull Edge edge) {
		Role role = getRole(edge);
		assert role != null;
		return role.isPredicated();
	}

	protected boolean isPredicated(@NonNull Node node) {
		Role role = getRole(node);
		assert role != null;
		return role.isPredicated();
	}

	@Override
	public boolean isRealized(@NonNull Edge edge) {
		Role role = getRole(edge);
		assert role != null;
		return role.isRealized();
	}

	protected boolean isRealized(@NonNull Node node) {
		Role role = getRole(node);
		assert role != null;
		return role.isRealized();
	}

	protected boolean isSpeculated(@NonNull Edge edge) {
		Role role = getRole(edge);
		assert role != null;
		return role.isSpeculated();
	}

	protected boolean isSpeculated(@NonNull Node node) {
		Role role = getRole(node);
		assert role != null;
		return role.isSpeculated();
	}

	protected boolean isSpeculation(@NonNull Node node) {
		Role role = getRole(node);
		assert role != null;
		return role.isSpeculation();
	}
}