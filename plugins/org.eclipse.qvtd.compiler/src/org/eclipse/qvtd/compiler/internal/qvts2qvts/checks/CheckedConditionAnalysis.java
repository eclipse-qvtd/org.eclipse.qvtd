/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.checks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Rule2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.ConnectionManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.MappingPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.ComposedNode;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyNode;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.ErrorNode;
import org.eclipse.qvtd.pivot.qvtschedule.InputNode;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.UnknownNode;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractExtendingQVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * CheckedConditionAnalysis supports the determination of the CheckConditions
 * that may cause a MicroMapping/Region execution to fail.
 */
public class CheckedConditionAnalysis
{
	/**
	 * Each CheckedConditionAnalysis Visitor visit adds the CheckedConditions applicable to the visited element
	 * to its Set<CheckedCondition> context.
	 */
	protected class Visitor extends AbstractExtendingQVTscheduleVisitor<Object, @NonNull Set<@NonNull CheckedCondition>>
	{
		private Set<@NonNull NavigableEdge> checkedNavigableEdges = null;
		protected final @NonNull CompleteModel completeModel;

		public Visitor(@NonNull Set<@NonNull CheckedCondition> checkedConditions) {
			super(checkedConditions);
			this.completeModel = scheduleManager.getEnvironmentFactory().getMetamodelManager().getCompleteModel();
		}

		public void analyze() {
			if (speculatedEdges != null) {
				context.add(new SpeculationCheckedCondition(speculatedEdges));
			}
			for (@NonNull Edge edge : oldUnconditionalEdges) {
				//				assert edge.isOld() && edge.isUnconditional();
				edge.accept(this);
			}
			for (@NonNull Node node : partition.getPartialNodes()) {
				Role nodeRole = partition.getRole(node);
				if ((nodeRole != null) && nodeRole.isOld() && !node.isConditional() && !node.isDependency() && (nodeRole != Role.CONSTANT_SUCCESS_TRUE)) {	// FIXME move to visitSuccessNode
					node.accept(this);
				}
			}
		}

		@Override
		public @Nullable Element visiting(@NonNull Visitable visitable) {
			throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
		}

		@Override
		public Object visitBooleanLiteralNode(@NonNull BooleanLiteralNode object) {
			return null;
		}

		@Override
		public Object visitCastEdge(@NonNull CastEdge castEdge) {
			//	context.add(new CastEdgeCheckedCondition(castEdge));
			//	return null;
			return visiting(castEdge);		// CastEdge should have been rewritten away
		}

		@Override
		public Object visitComposedNode(@NonNull ComposedNode object) {
			return visiting(object);		// ComposedNode should not occur in MappingRegion
		}

		@Override
		public Object visitDependencyNode(@NonNull DependencyNode object) {
			return visiting(object);
		}

		@Override
		public Object visitEdge(@NonNull Edge edge) {
			return null;
		}

		@Override
		public Object visitEnumLiteralNode(@NonNull EnumLiteralNode object) {
			return null;
		}

		@Override
		public Object visitErrorNode(@NonNull ErrorNode object) {
			return visiting(object);
		}

		//		@Override
		//		public Object visitExpressionEdge(@NonNull ExpressionEdge object) {
		//			return super.visitExpressionEdge(object);
		//		}

		@Override
		public Object visitInputNode(@NonNull InputNode object) {
			return visiting(object);
		}

		//		@Override
		//		public Object visitIteratedEdge(@NonNull IteratedEdge object) {
		//			return super.visitIteratedEdge(object);
		//		}

		//		@Override
		//		public Object visitIteratorNode(@NonNull IteratorNode object) {
		//			return super.visitIteratorNode(object);
		//		}

		//		@Override
		//		public Object visitKeyedValueNode(@NonNull KeyedValueNode object) {
		//			return super.visitKeyedValueNode(object);
		//		}

		@Override
		public Object visitNavigationEdge(@NonNull NavigationEdge navigationEdge) {
			Role sourceNodeRole1 = partition.getRole(QVTscheduleUtil.getSourceNode(navigationEdge));
			assert sourceNodeRole1 != null;
			Role targetNodeRole1 = partition.getRole(QVTscheduleUtil.getTargetNode(navigationEdge));
			assert targetNodeRole1 != null;
			if (targetNodeRole1.isConstant() && !sourceNodeRole1.isNew()) {		// FIXME Is this first check needed ?
				context.add(new ConstantTargetCheckedCondition(navigationEdge));
				return null;
			}
			Role navigableEdgeRole = partition.getRole(navigationEdge);
			assert navigableEdgeRole != null;
			NavigationEdge primaryEdge = QVTscheduleUtil.getPrimaryEdge(navigationEdge);
			{
				NavigationEdge oppositeEdge = primaryEdge.getOppositeEdge();
				if (oppositeEdge != null) {
					Node sourceNode = QVTscheduleUtil.getSourceNode(primaryEdge);
					Node targetNode = QVTscheduleUtil.getTargetNode(primaryEdge);
					Integer sourceCost = reachabilityForest.getCost(sourceNode);
					Integer targetCost = reachabilityForest.getCost(targetNode);
					if ((0 < targetCost) &&  (targetCost < sourceCost)) {
						primaryEdge = oppositeEdge;
					}
				}
			}
			Property checkedProperty = QVTscheduleUtil.getReferredProperty(primaryEdge);
			if (checkedProperty == scheduleManager.getStandardLibraryHelper().getOclContainerProperty()) {
				Node targetNode = QVTscheduleUtil.getSourceNode(primaryEdge);
				Node castTarget = targetNode;
				ClassDatum classDatum = QVTscheduleUtil.getClassDatum(castTarget);
				for (@NonNull PropertyDatum checkedPropertyDatum : scheduleManager.getOclContainerPropertyDatums(classDatum)) {
					addCheckedPropertyDatum(primaryEdge, checkedPropertyDatum);
				}
			}
			else {
				PropertyDatum checkedPropertyDatum = scheduleManager.getPropertyDatum(primaryEdge);
				assert checkedProperty == checkedPropertyDatum.getReferredProperty();
				addCheckedPropertyDatum(primaryEdge, checkedPropertyDatum);
			}
			Node targetNode = QVTscheduleUtil.getTargetNode(navigationEdge);
			if (navigableEdgeRole.isPredicated() && targetNode.isConstant()) {
				context.add(new ConstantTargetCheckedCondition(navigationEdge));
				//				return null;
			}
			//			assert navigableEdge.isOld();
			Property property = QVTscheduleUtil.getReferredProperty(navigationEdge);
			//	ClassDatum edgeTargetClassDatum = completeModel.getClassDatum(QVTrelationUtil.getType(property));
			CompleteClass edgeTargetCompleteClass = completeModel.getCompleteClass(QVTrelationUtil.getType(property));
			Node sourceNode = QVTscheduleUtil.getSourceNode(navigationEdge);
			Integer sourceCost = reachabilityForest.getCost(sourceNode);
			Integer targetCost = reachabilityForest.getCost(targetNode);
			if (sourceCost < targetCost) {
				ClassDatum targetNodeClassDatum = QVTscheduleUtil.getClassDatum(targetNode);
				if (!QVTscheduleUtil.conformsTo(edgeTargetCompleteClass, targetNodeClassDatum)) {
					context.add(new CastEdgeCheckedCondition(navigationEdge));
					//					return null;
				}
			}
			return null;
		}

		private void addCheckedPropertyDatum(NavigationEdge primaryEdge, PropertyDatum checkedPropertyDatum) {
			if (getAllCheckedPropertyDatums().contains(checkedPropertyDatum)) {
				if (checkedNavigableEdges == null) {
					checkedNavigableEdges = new HashSet<>();
				}
				if (checkedNavigableEdges.add(primaryEdge)) {
					context.add(new NavigableEdgeCheckedCondition(primaryEdge));
				}
			}
		}

		@Override
		public Object visitNode(@NonNull Node targetNode) {
			Integer targetCost = reachabilityForest.getCost(targetNode);
			Edge firstEdge = null;
			MultipleEdgeCheckedCondition checkedCondition = null;
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
				Role edgeRole = partition.getRole(edge);
				if ((edgeRole != null) && edgeRole.isOld() && !edge.isExpression()) {		// FIXME why exclude expression?
					Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
					Integer sourceCost = reachabilityForest.getCost(sourceNode);
					if (sourceCost <= targetCost) {
						if (firstEdge == null) {
							firstEdge = edge;
						}
						else if (checkedCondition == null){
							checkedCondition = new MultipleEdgeCheckedCondition(targetNode, firstEdge, edge);
							context.add(checkedCondition);
						}
						else {
							checkedCondition.addEdge(edge);
						}
					}
				}
			}
			return null;
		}

		@Override
		public Object visitNullLiteralNode(@NonNull NullLiteralNode object) {
			return null;
		}

		@Override
		public Object visitNumericLiteralNode(@NonNull NumericLiteralNode object) {
			return null;
		}

		@Override
		public Object visitOperationNode(@NonNull OperationNode operationNode) {
			Element originatingElement = operationNode.basicGetOriginatingElement();
			if (originatingElement instanceof TypedElement) {		// TupleParts are not TypedElements
				TypedElement typedElement = (TypedElement)originatingElement;
				if (operationNode.isRequired() && !typedElement.isIsRequired()) {
					context.add(new NonNullInitializerCheckedCondition(operationNode));
				}
				Type initializerType = QVTbaseUtil.getType(typedElement);
				CompleteClass initializerCompleteClass = completeModel.getCompleteClass(initializerType);
				ClassDatum targetClassDatum = QVTscheduleUtil.getClassDatum(operationNode);
				if (!QVTscheduleUtil.conformsTo(initializerCompleteClass, targetClassDatum)) {
					context.add(new CastInitializerCheckedCondition(operationNode));
				}
			}
			return super.visitOperationNode(operationNode);
		}

		//		@Override
		//		public Object visitPatternTypedNode(@NonNull PatternTypedNode object) {
		//			return super.visitPatternTypedNode(object);
		//		}

		//		@Override
		//		public Object visitPatternVariableNode(@NonNull PatternVariableNode object) {
		//			return super.visitPatternVariableNode(object);
		//		}

		@Override
		public Object visitPredicateEdge(@NonNull PredicateEdge predicateEdge) {
			context.add(new PredicateEdgeCheckedCondition(predicateEdge));
			return null;
		}

		@Override
		public Object visitRecursionEdge(@NonNull RecursionEdge object) {
			return visiting(object);
		}

		@Override
		public Object visitStringLiteralNode(@NonNull StringLiteralNode object) {
			return null;
		}

		@Override
		public Object visitSuccessEdge(@NonNull SuccessEdge successEdge) {
			//	if (!isCheckedNavigation(successEdge)) {				// Part of a computed success
			//		return super.visitSuccessEdge(successEdge);
			//	}
			Role role = partition.getRole(successEdge);
			assert role != null;
			if (role.isSpeculated()) {
				assert (speculatedEdges != null) && speculatedEdges.contains(successEdge);
				return null;
			}
			Role sourceNodeRole = partition.getRole(QVTscheduleUtil.getSourceNode(successEdge));
			assert sourceNodeRole != null;
			assert !sourceNodeRole.isNew();
			Role targetNodeRole = partition.getRole(QVTscheduleUtil.getTargetNode(successEdge));
			assert targetNodeRole != null;
			assert targetNodeRole.isConstant();
			RuleRegion ruleRegion = (RuleRegion)partitionAnalysis.getRegion();
			Rule rule = QVTscheduleUtil.getReferredRule(ruleRegion);
			AbstractTransformationAnalysis transformationAnalysis = partitionAnalysis.getPartitionedTransformationAnalysis().getTransformationAnalysis();
			RuleAnalysis ruleAnalysis = transformationAnalysis.getRuleAnalysis(rule);
			Rule2TraceGroup rule2TraceGroup = ruleAnalysis.getRule2TraceGroup();
			boolean isLocalSuccess = false;
			Element2MiddleProperty basicGetRelation2LocalSuccessProperty = rule2TraceGroup.basicGetRelation2LocalSuccessProperty();
			if (basicGetRelation2LocalSuccessProperty != null) {
				Property localSuccessProperty = basicGetRelation2LocalSuccessProperty.getTraceProperty();
				isLocalSuccess = successEdge.getReferredProperty() == localSuccessProperty;
			}
			context.add(new ConstantTargetCheckedCondition(successEdge, isLocalSuccess));
			return null;
		}

		//		@Override
		//		public Object visitSuccessNode(@NonNull SuccessNode object) {
		//			return super.visitSuccessNode(object);
		//		}

		@Override
		public Object visitTypeLiteralNode(@NonNull TypeLiteralNode object) {
			return null;
		}

		@Override
		public Object visitUnknownNode(@NonNull UnknownNode object) {
			return visiting(object);
		}
	};

	protected final @NonNull PartitionAnalysis partitionAnalysis;
	protected final @NonNull Partition partition;
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ReachabilityForest reachabilityForest;		// FIXME Do we really need this so early?

	/**
	 * All properties (and their opposites) that need to be checked for readiness before access.
	 */
	private @Nullable Set<@NonNull PropertyDatum> allCheckedPropertyDatums;

	/**
	 * The unconditional old edges provide the pattern matching workload.
	 * Once cost sorted the list is a sensible residual scheduling order after higher priority checked edges.
	 * Conditional edges should be scheduled as a consequence of an invoking unconditional edge/node.
	 */
	private final @NonNull List<@NonNull Edge> oldUnconditionalEdges = new ArrayList<>();

	/**
	 * The edges that must be speculated as successful to allow this partition to be successful.
	 */
	private final @Nullable List<@NonNull SuccessEdge> speculatedEdges;

	public CheckedConditionAnalysis(@NonNull MappingPartitionAnalysis<?> partitionAnalysis, @NonNull ScheduleManager scheduleManager) {
		this.partitionAnalysis = partitionAnalysis;
		this.partition = partitionAnalysis.getPartition();
		this.scheduleManager = scheduleManager;
		this.reachabilityForest = partitionAnalysis.getReachabilityForest();
		this.speculatedEdges = analyzeEdges();
	}

	private @Nullable List<@NonNull SuccessEdge> analyzeEdges() {
		List<@NonNull SuccessEdge> speculatedEdges = null;
		for (@NonNull Edge edge : partition.getPartialEdges()) {
			if (!edge.isConditional()) {			// FIXME Can we do better than ignoring awkward edges ??
				Role edgeRole = partition.getRole(edge);
				if (edgeRole != null) {
					if (edgeRole.isSpeculated()) {
						if (speculatedEdges == null) {
							speculatedEdges = new ArrayList<>();
						}
						speculatedEdges.add((SuccessEdge) edge);
					}
					else if (edgeRole.isOld() && !edge.isConditional()) {
						Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
						Role sourceNodeRole = partition.getRole(sourceNode);
						if ((sourceNodeRole != null) && sourceNodeRole.isOld()) {
							Node targetNode = QVTscheduleUtil.getTargetNode(edge);
							Role targetNodeRole = partition.getRole(targetNode);
							if ((targetNodeRole != null) && targetNodeRole.isOld()) {
								oldUnconditionalEdges.add(edge);
							}
						}
					}
				}
			}
		}
		if (oldUnconditionalEdges.size() > 1) {
			Collections.sort(oldUnconditionalEdges, reachabilityForest.getEdgeCostComparator());
		}
		if ((speculatedEdges != null) && (speculatedEdges.size() > 1)) {
			Collections.sort(speculatedEdges, reachabilityForest.getEdgeCostComparator());
		}
		return speculatedEdges;
	}

	/**
	 * Return all conditions that need checking for mapping success.
	 */
	public @NonNull Set<@NonNull CheckedCondition> computeCheckedConditions() {
		Set<@NonNull CheckedCondition> checkedConditions = new HashSet<>();
		Visitor visitor = new Visitor(checkedConditions);
		visitor.analyze();
		return checkedConditions;
	}

	/**
	 * Return all properties (and their opposites) that need checking for readiness prior to access.
	 */
	public @NonNull Set<@NonNull PropertyDatum> computeCheckedPropertyDatums(@Nullable StringBuilder s) {
		if (allCheckedPropertyDatums != null) {
			return allCheckedPropertyDatums;
		}
		@NonNull ConnectionManager connectionManager = scheduleManager.getConnectionManager();
		//
		// Better, we would not be pessimistic about input/output typedModel ambiguity in endogeneous
		// mappings, but that incurs many typedModel accuracy issues.
		//
		Set<@NonNull PropertyDatum> allCheckedPropertyDatums = new HashSet<>();
		for (@NonNull Edge edge : partition.getPartialEdges()) {
			if ((edge instanceof NavigationEdge) && partitionAnalysis.isChecked(edge)) {
				NavigationEdge navigationEdge = (NavigationEdge)edge;
				if (connectionManager.isHazardousRead(s, partition, navigationEdge)) {
					PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(navigationEdge);
					allCheckedPropertyDatums.add(propertyDatum);
					PropertyDatum oppositePropertyDatum = propertyDatum.getOpposite();
					if (oppositePropertyDatum == null) {
						NavigationEdge oppositeEdge = navigationEdge.getOppositeEdge();
						if (oppositeEdge != null) {
							oppositePropertyDatum = scheduleManager.getPropertyDatum(oppositeEdge);
							allCheckedPropertyDatums.add(oppositePropertyDatum);
						}
					}
				}
			}
		}
		return allCheckedPropertyDatums;
	}

	public @NonNull Set<@NonNull PropertyDatum> getAllCheckedPropertyDatums() {
		return allCheckedPropertyDatums != null ? allCheckedPropertyDatums : computeCheckedPropertyDatums(null);
	}

	public @NonNull Iterable<@NonNull Edge> getOldUnconditionalEdges() {
		return oldUnconditionalEdges;
	}

	public @Nullable Iterable<@NonNull SuccessEdge> getSpeculatedEdges() {
		return speculatedEdges;
	}

	@Override
	public String toString() {
		return partition.toString();
	}
}