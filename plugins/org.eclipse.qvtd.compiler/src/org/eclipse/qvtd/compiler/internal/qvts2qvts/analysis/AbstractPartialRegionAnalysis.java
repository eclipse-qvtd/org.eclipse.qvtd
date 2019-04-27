/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

public abstract class AbstractPartialRegionAnalysis<@NonNull PRA extends PartialRegionsAnalysis<@NonNull PRA>> implements PartialRegionAnalysis<@NonNull PRA>
{
	protected final @NonNull PartialRegionsAnalysis<@NonNull PRA> partialRegionsAnalysis;
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The ClassAnalysis instances that are consumed by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> consumedClassAnalyses = null;

	/**
	 * The PropertyAnalysis instances that are consumed by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> consumedPropertyAnalyses = null;

	/**
	 * The ClassAnalysis instances that are produced by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> producedClassAnalyses = null;

	/**
	 * The PropertyAnalysis instances that are produced by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> producedPropertyAnalyses = null;

	/**
	 * The ClassAnalysis instances and super instances that are produced by this MappingPartitioner.
	 */
	private @Nullable Set<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> superProducedClassAnalyses = null;

	/**
	 * The override dispatch node if needed.
	 */
	private @Nullable Node dispatchNode = null;

	/**
	 * The trace node(s).
	 */
	private final @NonNull List<@NonNull Node> traceNodes = new ArrayList<>();

	/**
	 * The constant nodes that require no computation from other nodes.
	 */
	private final @NonNull List<@NonNull Node> constantInputNodes = new ArrayList<>();

	/**
	 * The constant nodes that impose a check on a computation from other nodes.
	 */
	private final @NonNull List<@NonNull Node> constantOutputNodes = new ArrayList<>();
	private final @NonNull List<@NonNull Node> loadedInputNodes = new ArrayList<>();
	private final @NonNull List<@NonNull NavigableEdge> predicatedMiddleEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> predicatedMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull NavigableEdge> predicatedOutputEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> predicatedOutputNodes = new ArrayList<>();
	private final @NonNull List<@NonNull NavigableEdge> realizedMiddleEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> realizedMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull NavigableEdge> realizedOutputEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> realizedOutputNodes = new ArrayList<>();

	/**
	 * properties that are directly realized from a middle object provided all predicates are satisfied.
	 */
	private final @NonNull Set<@NonNull NavigableEdge> oldPrimaryNavigableEdges = new HashSet<>();
	private final @NonNull List<@NonNull Edge> predicatedEdges = new ArrayList<>();
	private final @NonNull Set<@NonNull NavigableEdge> realizedEdges = new HashSet<>();
	private final @NonNull Set<@NonNull SuccessEdge> successEdges = new HashSet<>();	// FIXME redundant wrt traceNode2successEdge.values()

	protected AbstractPartialRegionAnalysis(@NonNull PartialRegionsAnalysis<@NonNull PRA> partialRegionsAnalysis) {
		this.partialRegionsAnalysis = partialRegionsAnalysis;
		this.scheduleManager = partialRegionsAnalysis.getScheduleManager();
	}

	private void addConstantNode(@NonNull Node node) {
		assert isConstant(node);
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			assert !edge.isCast();
			if (edge.isComputation() || (edge.isNavigation() && !isRealized(edge))) {
				constantOutputNodes.add(node);
				return;
			}
		}
		constantInputNodes.add(node);
	}

	private void addConsumptionOfEdge(@NonNull NavigableEdge edge) {
		Property property = QVTscheduleUtil.getProperty(edge);
		if (property == scheduleManager.getStandardLibraryHelper().getOclContainerProperty()) {
			Node targetNode = QVTscheduleUtil.getSourceNode(edge);
			Node castTarget = targetNode;
			ClassDatum classDatum = QVTscheduleUtil.getClassDatum(castTarget);
			for (@NonNull PropertyDatum propertyDatum : scheduleManager.getOclContainerPropertyDatums(classDatum)) {
				addConsumptionOfPropertyDatum(propertyDatum);
			}
		}
		else {
			PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(edge);
			addConsumptionOfPropertyDatum(propertyDatum);
		}
	}

	private void addConsumptionOfInputNode(@NonNull Node node) {
		if (node.isClass() && !loadedInputNodes.contains(node)) {		// DataTypes are consumed by their edge
			loadedInputNodes.add(node);
			addConsumptionOfNode(node);
		}
	}

	private void addConsumptionOfMiddleEdge(@NonNull NavigableEdge edge) {
		if (!predicatedMiddleEdges.contains(edge)) {
			predicatedMiddleEdges.add(edge);
			addConsumptionOfEdge(edge);
		}
	}

	private void addConsumptionOfMiddleNode(@NonNull Node node) {
		if (!predicatedMiddleNodes.contains(node)) {
			predicatedMiddleNodes.add(node);
			addConsumptionOfNode(node);
		}
	}

	private void addConsumptionOfNode(@NonNull Node node) {
		Node castNode = QVTscheduleUtil.getCastTarget(node);
		PartialRegionClassAnalysis<@NonNull PRA> consumedTraceAnalysis = partialRegionsAnalysis.addConsumer(QVTscheduleUtil.getClassDatum(castNode), this);
		List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> consumedClassAnalyses2 = consumedClassAnalyses;
		if (consumedClassAnalyses2 == null) {
			consumedClassAnalyses = consumedClassAnalyses2 = new ArrayList<>();
		}
		if (!consumedClassAnalyses2.contains(consumedTraceAnalysis)) {
			consumedClassAnalyses2.add(consumedTraceAnalysis);
		}
	}

	private void addConsumptionOfOutputEdge(@NonNull NavigableEdge edge) {
		if (!predicatedOutputEdges.contains(edge)) {
			predicatedOutputEdges.add(edge);
			addConsumptionOfEdge(edge);  // FIXME  gives 'should have realized' for 3*QVTc UML2RDBMS CollectionPartEdge
		}
	}

	private void addConsumptionOfOutputNode(@NonNull Node node) {
		if (!predicatedOutputNodes.contains(node)) {
			predicatedOutputNodes.add(node);
			addConsumptionOfNode(node);
		}
	}

	private void addConsumptionOfPropertyDatum(@NonNull PropertyDatum propertyDatum) {
		PartialRegionPropertyAnalysis<@NonNull PRA> consumedTraceAnalysis = partialRegionsAnalysis.addConsumer(propertyDatum, this);
		List<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> consumedPropertyAnalyses2 = consumedPropertyAnalyses;
		if (consumedPropertyAnalyses2 == null) {
			consumedPropertyAnalyses = consumedPropertyAnalyses2 = new ArrayList<>();
		}
		if (!consumedPropertyAnalyses2.contains(consumedTraceAnalysis)) {
			consumedPropertyAnalyses2.add(consumedTraceAnalysis);
		}
	}

	private void addProductionOfEdge(@NonNull NavigableEdge edge) {
		assert isNew(edge);
		Property property = QVTscheduleUtil.getProperty(edge);
		assert property != scheduleManager.getStandardLibraryHelper().getOclContainerProperty();		// oclContainer is not assignable
		if (property.toString().contains("height") || property.toString().contains("ownsB")) {
			property.toString();
		}
		PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(edge);
		PartialRegionPropertyAnalysis<@NonNull PRA> producedTraceAnalysis = partialRegionsAnalysis.addProducer(propertyDatum, this);
		List<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> producedPropertyAnalyses2 = producedPropertyAnalyses;
		if (producedPropertyAnalyses2 == null) {
			producedPropertyAnalyses = producedPropertyAnalyses2 = new ArrayList<>();
		}
		if (!producedPropertyAnalyses2.contains(producedTraceAnalysis)) {
			producedPropertyAnalyses2.add(producedTraceAnalysis);
		}
		/*	PropertyDatum oppositePropertyDatum = propertyDatum.getOpposite();
		if (oppositePropertyDatum != null) {
			PartialRegionPropertyAnalysis<@NonNull PRA> oppositeProducedTraceAnalysis = partialRegionsAnalysis.addProducer(oppositePropertyDatum, this);
			if (!producedPropertyAnalyses2.contains(oppositeProducedTraceAnalysis)) {
				producedPropertyAnalyses2.add(oppositeProducedTraceAnalysis);
			}
		} */
	}

	private void addProductionOfMiddleEdge(@NonNull NavigableEdge edge) {
		if (isRealized(edge) && !realizedMiddleEdges.contains(edge)) {
			realizedMiddleEdges.add(edge);
			addProductionOfEdge(edge);
		}
	}

	private void addProductionOfMiddleNode(@NonNull Node node) {
		if (isRealized(node) && !realizedMiddleNodes.contains(node)) {
			realizedMiddleNodes.add(node);
			addProductionOfNode(node);
		}
	}

	private void addProductionOfNode(@NonNull Node node) {
		assert isNew(node);
		PartialRegionClassAnalysis<@NonNull PRA> consumedTraceAnalysis = partialRegionsAnalysis.addProducer(QVTscheduleUtil.getClassDatum(node), this);
		List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> producedClassAnalyses2 = producedClassAnalyses;
		if (producedClassAnalyses2 == null) {
			producedClassAnalyses = producedClassAnalyses2 = new ArrayList<>();
		}
		if (!producedClassAnalyses2.contains(consumedTraceAnalysis)) {
			producedClassAnalyses2.add(consumedTraceAnalysis);
		}
	}

	private void addProductionOfOutputEdge(@NonNull NavigableEdge edge) {
		if (isRealized(edge) && !realizedOutputEdges.contains(edge)) {
			realizedOutputEdges.add(edge);
			addProductionOfEdge(edge);
		}
	}

	private void addProductionOfOutputNode(@NonNull Node node) {
		if (isRealized(node) && !realizedOutputNodes.contains(node)) {
			realizedOutputNodes.add(node);
			addProductionOfNode(node);
		}
	}

	protected void analyzeEdges() {
		for (@NonNull Edge edge : getPartialEdges()) {
			assert !edge.isCast();
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
					if (!isRealized(navigableEdge) && navigableEdge.isMatched()) {  // FIXME is this totally obsolete
						assert !navigableEdge.isExpression();
						assert !navigableEdge.isComputation();
					}
					Node sourceNode = navigableEdge.getEdgeSource();
					//	Node targetNode = navigableEdge.getEdgeTarget();
					if (scheduleManager.isMiddle(sourceNode)) { // || scheduleManager.isMiddle(targetNode)) {
						if (isChecked(navigableEdge)) {
							addConsumptionOfMiddleEdge(navigableEdge);
						}
						else if (isRealized(navigableEdge)) {
							addProductionOfMiddleEdge(navigableEdge);
						}
						else {
							throw new IllegalStateException("middle edge must be predicated or realized : " + navigableEdge);
						}
					}
					else { // || scheduleManager.isOutput(targetNode)) {
						if (isLoaded(navigableEdge) || isConstant(navigableEdge)) {}
						else if (isChecked(navigableEdge)) {  // || isSpeculated(navigableEdge)) {
							addConsumptionOfOutputEdge(navigableEdge);
						}
						else if (isRealized(navigableEdge)) {
							addProductionOfOutputEdge(navigableEdge);
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

	// FIXME This code should in principle be the same as OriginalContentsAnalysis.addNewNode/addOldNode.
	//  -- the complexity is perhaps historical mis-fixes
	protected void analyzeNodes() {
		for (@NonNull Node node : getPartialNodes()) {
			if (node.isDependency()) {
				addConsumptionOfOutputNode(node);
				continue;
			}
			boolean isOperation = node.isOperation();
			boolean isPattern = node.isPattern();
			boolean isIterator = node.isIterator();
			if (!isOperation && !isPattern && !isIterator) {
				throw new IllegalStateException("unsupported analyzeNode : " + node);
			}
			boolean isMiddle = scheduleManager.isMiddle(node);
			if (isMiddle && !isOperation) {
				if (node.isDispatch()) {
					if (dispatchNode != null) {
						throw new IllegalStateException();		// Dual dispatcher
					}
					dispatchNode = node;
				}
				else if (node.isTrace()) {
					traceNodes.add(node);
				}
			}
			if (isConstant(node)) {
				if (isOperation) {
					addConstantNode(node);
				}
			}
			else if (isLoaded(node)) {
				addConsumptionOfInputNode(node);
			}
			else if (isPredicated(node)) {
				if (isMiddle) {
					addConsumptionOfMiddleNode(node);
				}
				else {
					addConsumptionOfOutputNode(node);
				}
			}
			else if (isSpeculated(node) && isMiddle && !isOperation) {	// middle/operation drop through to throw
				if (!node.isHead()) {		// Don't create a self-consumption cycle
					addConsumptionOfMiddleNode(node);
				}
			}
			else if (isSpeculation(node) || isRealized(node)) {
				if (!isOperation) {
					if (isMiddle) {
						addProductionOfMiddleNode(node);
					}
					else {
						addProductionOfOutputNode(node);
					}
				}
			}
			else {
				throw new IllegalStateException((isMiddle ? "middle" : "other") + " node must be predicated or realized : " + node);
			}
		}
	}

	/* MappingPartitionAnalysis variant
	protected void analyzeNodes2() {
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
					addConsumptionOfInputNode(node);
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
					}
					else {
						throw new IllegalStateException("middle node must be predicated or realized : " + node);
					}
				}
				else { // scheduleManager.isOutput(node)
					if (isPredicated(node)) {
						addConsumptionOfOutputNode(node);
					}
					else if (isRealized(node)) {
						addProductionOfOutputNode(node);
					}
					else {
						throw new IllegalStateException("other node must be predicated or realized : " + node);
					}
				}
			}
			else if (node.isDependency()) {
				addConsumptionOfOutputNode(node);
			}
			else if (node.isIterator()) {}
			else {
				throw new IllegalStateException("unsupported analyzeNode : " + node);
			}
		}
	} */

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
	public @Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> getConsumedClassAnalyses() {
		return consumedClassAnalyses;
	}

	@Override
	public @Nullable Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> getConsumedPropertyAnalyses() {
		return consumedPropertyAnalyses;
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getOldPrimaryNavigableEdges() {
		return oldPrimaryNavigableEdges;
	}

	protected @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		throw new UnsupportedOperationException();		// Analyze should not be invoked for someot all PartialRegions
	}

	protected @NonNull Iterable<@NonNull Node> getPartialNodes() {
		throw new UnsupportedOperationException();		// Analyze should not be invoked for someot all PartialRegions
	}

	@Override
	public @NonNull Partition getPartition() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> getProducedClassAnalyses() {
		return producedClassAnalyses;
	}

	@Override
	public @Nullable Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> getProducedPropertyAnalyses() {
		return producedPropertyAnalyses;
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
	public @Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> getSuperProducedClassAnalyses() {
		List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> producedClassAnalyses2 = producedClassAnalyses;
		if (producedClassAnalyses2 != null) {
			Set<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> superProducedClassAnalyses2 = superProducedClassAnalyses;
			if (superProducedClassAnalyses2 == null) {
				superProducedClassAnalyses = superProducedClassAnalyses2 = new HashSet<>();
			}
			for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> producedClassAnalysis : producedClassAnalyses2) {
				Iterables.addAll(superProducedClassAnalyses2, producedClassAnalysis.getSuperClassAnalyses());
			}
		}
		return superProducedClassAnalyses;
	}

	@Override
	public @NonNull List<@NonNull Node> getTraceNodes() {
		return traceNodes;
	}

	protected boolean isChecked(@NonNull Edge edge) {
		return isPredicated(edge) || isSpeculated(edge);
	}

	protected boolean isConstant(@NonNull Edge edge) {
		return edge.isConstant();
	}

	protected boolean isConstant(@NonNull Node node) {
		return node.isConstant();
	}

	protected boolean isLoaded(@NonNull Edge edge) {
		return edge.isLoaded();
	}

	protected boolean isLoaded(@NonNull Node node) {
		return node.isLoaded();
	}

	protected boolean isNew(@NonNull Edge edge) {
		return edge.isNew();
	}

	protected boolean isNew(@NonNull Node node) {
		return node.isNew();
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