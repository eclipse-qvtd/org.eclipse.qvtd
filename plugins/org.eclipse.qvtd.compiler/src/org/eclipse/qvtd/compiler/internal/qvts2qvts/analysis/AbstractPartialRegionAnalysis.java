/*******************************************************************************
 * Copyright (c) 2016, 2020 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
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
	 *
	 * NB. This excludes DataTypes that may only be consumed by their edges/properties.
	 */
	private @Nullable List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> externallyConsumedClassAnalyses = null;

	/**
	 * The PropertyAnalysis instances that are consumed by this MappingPartitioner.
	 */
	private @Nullable List<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> consumedPropertyAnalyses = null;

	/**
	 * The ClassAnalysis instances that are produced by this MappingPartitioner.
	 *
	 * NB. This excludes DataTypes that may only be produced by their edges/properties.
	 */
	private @Nullable List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> externallyProducedClassAnalyses = null;

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
	 * The transformation context node if used.
	 */
	private @Nullable Node thisNode = null;

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
	private final @NonNull List<@NonNull Node> newMiddleNodes = new ArrayList<>();
	private final @NonNull List<@NonNull NavigableEdge> realizedOutputEdges = new ArrayList<>();
	private final @NonNull List<@NonNull Node> newOutputNodes = new ArrayList<>();

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
		if (edge.isNavigation()) {
			NavigationEdge navigationEdge = (NavigationEdge)edge;
			for (@NonNull PropertyDatum propertyDatum : scheduleManager.getPropertyDatums(navigationEdge)) {
				addConsumptionOfPropertyDatum(propertyDatum);
			}
		}
		else {
			// SharedEdge
		}
	}

	private void addConsumptionOfInputNode(@NonNull Node node) {
		if (node.isClass() && !loadedInputNodes.contains(node)) {		// DataTypes are consumed by their edge
			loadedInputNodes.add(node);
			if (!node.isDataType()) {
				addConsumptionOfNode(node);
			}
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
			if (!node.isDataType()) {
				addConsumptionOfNode(node);
			}
		}
	}

	private void addConsumptionOfNode(@NonNull Node node) {
		if ("mapBooleanExp_qvtr".equals(getName()) || "mapStringExp_qvtr".equals(getName())) {
			CompilerUtil.class.getName();
		}
		assert !node.isDataType();
		PartialRegionClassAnalysis<@NonNull PRA> consumedTraceAnalysis = partialRegionsAnalysis.addConsumer(QVTscheduleUtil.getClassDatum(node), this);
		List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> externallyConsumedClassAnalyses2 = externallyConsumedClassAnalyses;
		if (externallyConsumedClassAnalyses2 == null) {
			externallyConsumedClassAnalyses = externallyConsumedClassAnalyses2 = new ArrayList<>();
		}
		if (!externallyConsumedClassAnalyses2.contains(consumedTraceAnalysis)) {
			externallyConsumedClassAnalyses2.add(consumedTraceAnalysis);
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
			if (!node.isDataType()) {
				addConsumptionOfNode(node);
			}
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
		if (edge.isNavigation()) {
			NavigationEdge navigationEdge = (NavigationEdge)edge;
			Property property = QVTscheduleUtil.getReferredProperty(navigationEdge);
			assert property != scheduleManager.getStandardLibraryHelper().getOclContainerProperty();		// oclContainer is not assignable
			if (property.toString().contains("height") || property.toString().contains("ownsB")) {
				property.toString();
			}
			PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(navigationEdge);
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
		else {
			// SharedEdge
		}
	}

	private void addProductionOfMiddleEdge(@NonNull NavigableEdge edge) {
		if (isRealized(edge) && !realizedMiddleEdges.contains(edge)) {
			realizedMiddleEdges.add(edge);
			addProductionOfEdge(edge);
		}
	}

	private void addProductionOfMiddleNode(@NonNull Node node) {
		if (isNew(node) && !newMiddleNodes.contains(node)) {
			newMiddleNodes.add(node);
			if (!node.isDataType()) {
				addProductionOfNode(node);
			}
		}
	}

	private void addProductionOfNode(@NonNull Node node) {
		assert isNew(node);
		assert !node.isDataType();
		PartialRegionClassAnalysis<@NonNull PRA> consumedTraceAnalysis = partialRegionsAnalysis.addProducer(QVTscheduleUtil.getClassDatum(node), this);
		List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> externallyProducedClassAnalyses2 = externallyProducedClassAnalyses;
		if (externallyProducedClassAnalyses2 == null) {
			externallyProducedClassAnalyses = externallyProducedClassAnalyses2 = new ArrayList<>();
		}
		if (!externallyProducedClassAnalyses2.contains(consumedTraceAnalysis)) {
			externallyProducedClassAnalyses2.add(consumedTraceAnalysis);
		}
	}

	private void addProductionOfOutputEdge(@NonNull NavigableEdge edge) {
		if (isRealized(edge) && !realizedOutputEdges.contains(edge)) {
			realizedOutputEdges.add(edge);
			addProductionOfEdge(edge);
		}
	}

	private void addProductionOfOutputNode(@NonNull Node node) {
		if (isNew(node) && !newOutputNodes.contains(node)) {
			newOutputNodes.add(node);
			if (!node.isDataType()) {
				addProductionOfNode(node);
			}
		}
	}

	protected void analyzeEdges() {
		for (@NonNull Edge edge : getPartialEdges()) {
			assert !edge.isCast();
			if (!edge.isSecondary()) {
				if (isPredicated(edge)) {
					predicatedEdges.add(edge);
				}
				if (edge.isNavigation()) {
					NavigationEdge navigationEdge = (NavigationEdge)edge;
					if (navigationEdge.isSuccess()) {
						successEdges.add((SuccessEdge) navigationEdge);
					}
					if (isRealized(navigationEdge)) {
						realizedEdges.add(navigationEdge);
					}
					else {
						oldPrimaryNavigableEdges.add(navigationEdge);
					}
					if (!isRealized(navigationEdge) && !navigationEdge.isConditional()) {  // FIXME is this totally obsolete
						assert !navigationEdge.isExpression();
						assert !navigationEdge.isComputation();
					}
					Node sourceNode = navigationEdge.getEdgeSource();
					//	Node targetNode = navigableEdge.getEdgeTarget();
					if (scheduleManager.isMiddle(sourceNode)) { // || scheduleManager.isMiddle(targetNode)) {
						if (isChecked(navigationEdge)) {
							addConsumptionOfMiddleEdge(navigationEdge);
						}
						else if (isRealized(navigationEdge)) {
							addProductionOfMiddleEdge(navigationEdge);
						}
						else if (!isLoaded(navigationEdge)){
							throw new IllegalStateException("middle edge must be predicated or realized : " + navigationEdge);
						}
					}
					else { // || scheduleManager.isOutput(targetNode)) {
						if (isLoaded(navigationEdge) || isConstant(navigationEdge)) {}
						else if (isChecked(navigationEdge)) {  // || isSpeculated(navigableEdge)) {
							addConsumptionOfOutputEdge(navigationEdge);
						}
						else if (isRealized(navigationEdge)) {
							addProductionOfOutputEdge(navigationEdge);
						}
						else {
							throw new IllegalStateException("other edge must be predicated or realized : " + navigationEdge);
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
			if (node.isThis()) {
				assert node.isLoaded();
				assert thisNode == null;
				thisNode = node;
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
			/*if (node.isDataType()) {
				;
			}
			else*/ if (isConstant(node)) {
				if (isOperation) {
					addConstantNode(node);
				}
			}
			else if (isLoaded(node)) {
				addConsumptionOfInputNode(node);
			}
			else if (isPredicated(node)) {
				if (!node.isDataType()) {
					if (isMiddle) {
						addConsumptionOfMiddleNode(node);
					}
					else {
						addConsumptionOfOutputNode(node);
					}
				}
			}
			else if (isSpeculated(node) && isMiddle && !isOperation) {	// middle/operation drop through to throw
				if (!node.isHead()) {		// Don't create a self-consumption cycle
					addConsumptionOfMiddleNode(node);
				}
			}
			else if (isNew(node)) {
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
					//	newOutputNodes.add(node);
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
		return externallyConsumedClassAnalyses;
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
		return externallyProducedClassAnalyses;
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
		return newMiddleNodes;
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getRealizedOutputEdges() {
		return realizedOutputEdges;
	}

	public @NonNull Iterable<@NonNull Node> getRealizedOutputNodes() {
		return newOutputNodes;
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @NonNull Iterable<@NonNull SuccessEdge> getSuccessEdges() {
		return successEdges;
	}

	@Override
	public @Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> getSuperProducedClassAnalyses() {
		List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> producedClassAnalyses2 = externallyProducedClassAnalyses;
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

	public @Nullable Node getThisNode() {
		return thisNode;
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