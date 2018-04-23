/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ComposedNode;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyNode;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.ErrorNode;
import org.eclipse.qvtd.pivot.qvtschedule.InputNode;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.UnknownNode;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractExtendingQVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
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
			for (@NonNull Edge edge : oldUnconditionalEdges) {
				assert edge.isOld() && edge.isUnconditional();
				edge.accept(this);
			}
			for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
				if (node.isOld() && node.isUnconditional()) {
					node.accept(this);
				}
			}
		}

		private boolean isCheckedNavigation(@NonNull NavigationEdge edge) {
			Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
			Node targetNode = QVTscheduleUtil.getTargetNode(edge);
			return targetNode.isConstant() && !sourceNode.isNew();
		}

		@Override
		public @Nullable Element visiting(@NonNull Visitable visitable) {
			throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
		}

		//		@Override
		//		public Object visitBooleanValueNode(@NonNull BooleanValueNode object) {
		//			return super.visitBooleanValueNode(object);
		//		}

		@Override
		public Object visitCastEdge(@NonNull CastEdge castEdge) {
			context.add(new CastEdgeCheckedCondition(castEdge));
			return null;
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
		public Object visitEdge(@NonNull Edge object) {
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
		public Object visitNavigableEdge(@NonNull NavigableEdge navigableEdge) {
			NavigableEdge checkedEdge = QVTscheduleUtil.getPrimaryEdge(navigableEdge);
			NavigableEdge oppositeEdge = checkedEdge.getOppositeEdge();
			if (oppositeEdge != null) {
				Node sourceNode = QVTscheduleUtil.getSourceNode(checkedEdge);
				Node targetNode = QVTscheduleUtil.getTargetNode(checkedEdge);
				Integer sourceCost = reachabilityForest.getCost(sourceNode);
				Integer targetCost = reachabilityForest.getCost(targetNode);
				if ((sourceCost != null) && (targetCost != null) && (0 < targetCost) &&  (targetCost < sourceCost)) {
					checkedEdge = oppositeEdge;
				}
			}
			Property checkedProperty = checkedEdge.getProperty();
			Set<@NonNull Property> allCheckedProperties2 = allCheckedProperties;
			if ((allCheckedProperties2 == null) || allCheckedProperties2.contains(checkedProperty)) {
				if (checkedNavigableEdges == null) {
					checkedNavigableEdges = new HashSet<>();
				}
				if (checkedNavigableEdges.add(checkedEdge)) {
					context.add(new NavigableEdgeCheckedCondition(checkedEdge));
					return null;
				}
			}
			Node targetNode = QVTscheduleUtil.getTargetNode(navigableEdge);
			if (navigableEdge.isPredicated() && targetNode.isConstant()) {
				context.add(new ConstantTargetCheckedCondition(navigableEdge));
				return null;
			}
			assert navigableEdge.isOld();
			Property property = QVTscheduleUtil.getProperty(navigableEdge);
			CompleteClass edgeTargetCompleteClass = completeModel.getCompleteClass(QVTrelationUtil.getType(property));
			Node sourceNode = QVTscheduleUtil.getSourceNode(navigableEdge);
			Integer sourceCost = reachabilityForest.getCost(sourceNode);
			Integer targetCost = reachabilityForest.getCost(targetNode);
			assert (sourceCost != null) && (targetCost != null);
			if (sourceCost < targetCost) {
				CompleteClass targetNodeCompleteClass = targetNode.getCompleteClass();
				if (!edgeTargetCompleteClass.conformsTo(targetNodeCompleteClass)) {
					context.add(new CastEdgeCheckedCondition(navigableEdge));
					return null;
				}
			}
			return null;
		}

		@Override
		public Object visitNavigationEdge(@NonNull NavigationEdge navigationEdge) {
			if (isCheckedNavigation(navigationEdge)) {
				context.add(new PredicateNavigationEdgeCheckedCondition(navigationEdge));
				return null;
			}
			else {
				return super.visitNavigationEdge(navigationEdge);
			}
		}

		@Override
		public Object visitNode(@NonNull Node node) {
			Integer targetCost = reachabilityForest.getCost(node);
			assert targetCost != null;
			assert node.isOld();
			Edge firstEdge = null;
			MultipleEdgeCheckedCondition checkedCondition = null;
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isOld() && !edge.isExpression()) {		// FIXME why exclude expression?
					Integer sourceCost = reachabilityForest.getCost(QVTscheduleUtil.getSourceNode(edge));
					assert sourceCost != null;
					if (sourceCost <= targetCost) {
						if (firstEdge == null) {
							firstEdge = edge;
						}
						else if (checkedCondition == null){
							checkedCondition = new MultipleEdgeCheckedCondition(firstEdge, edge);
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

		//		@Override
		//		public Object visitNullNode(@NonNull NullNode object) {
		//			return super.visitNullNode(object);
		//		}

		//		@Override
		//		public Object visitOperationNode(@NonNull OperationNode object) {
		//			return super.visitOperationNode(object);
		//		}

		//		@Override
		//		public Object visitOperationValueNode(@NonNull OperationValueNode object) {
		//			return super.visitOperationValueNode(object);
		//		}

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

		//		@Override
		//		public Object visitSuccessEdge(@NonNull SuccessEdge successEdge) {
		//			return super.visitSuccessEdge(successEdge);
		//		}

		//		@Override
		//		public Object visitSuccessNode(@NonNull SuccessNode object) {
		//			return super.visitSuccessNode(object);
		//		}

		@Override
		public Object visitUnknownNode(@NonNull UnknownNode object) {
			return visiting(object);
		}
	};

	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ReachabilityForest reachabilityForest;
	protected final @NonNull Region region;

	/**
	 * All properties (and their opposites) that need to be checked for readiness before access.
	 */
	private final @Nullable Set<@NonNull Property> allCheckedProperties;

	/**
	 * The unconditional old edges provide the pattern matching workload.
	 * Once cost sorted the list is a sensible residual scheduling order after higher priority checked edges.
	 * Conditional edges should be scheduled as a consequence of an invoking unconditional edge/node.
	 */
	private final @NonNull List<@NonNull Edge> oldUnconditionalEdges;

	public CheckedConditionAnalysis(@NonNull ScheduleManager scheduleManager, @NonNull ReachabilityForest reachabilityForest, @NonNull Region region) {
		this.scheduleManager = scheduleManager;
		this.reachabilityForest = reachabilityForest;
		this.region = region;
		this.allCheckedProperties = computeCheckedProperties();
		this.oldUnconditionalEdges = computeOldUnconditionalEdges();
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
	protected @Nullable Set<@NonNull Property> computeCheckedProperties() {
		//
		// Better, we would not be pessimistic about input/output typedModel ambiguity in endogeneous
		// mappings, but that incurs many typedModel accuracy issues.
		//
		Set<@NonNull Property> allCheckedProperties = new HashSet<>();
		DomainUsage anyUsage = scheduleManager.getDomainUsageAnalysis().getAnyUsage();
		for (@NonNull TypedModel qvtmTypedModel : anyUsage.getTypedModels()) {
			Iterable<@NonNull NavigableEdge> checkedEdges = scheduleManager.getRegionAnalysis(region).getCheckedEdges(qvtmTypedModel);
			if (checkedEdges != null) {
				for (@NonNull NavigableEdge checkedEdge : checkedEdges) {
					Property asProperty = QVTscheduleUtil.getProperty(checkedEdge);
					allCheckedProperties.add(asProperty);
					Property asOppositeProperty = asProperty.getOpposite();
					if (asOppositeProperty != null) {
						allCheckedProperties.add(asOppositeProperty);
					}
				}
			}
		}
		return allCheckedProperties;
	}

	private @NonNull List<@NonNull Edge> computeOldUnconditionalEdges() {
		Set<@NonNull Edge> oldEdges = new HashSet<>();
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			if (edge.isOld() && edge.isUnconditional()) {
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				Node targetNode = QVTscheduleUtil.getTargetNode(edge);
				if (sourceNode.isOld() && targetNode.isOld()) {
					oldEdges.add(edge);
				}
			}
		}
		List<@NonNull Edge> sortedEdges = new ArrayList<>(oldEdges);
		Collections.sort(sortedEdges, reachabilityForest.getEdgeCostComparator());
		return sortedEdges;
	}

	public @NonNull Set<@NonNull Property> getAllCheckedProperties() {
		return ClassUtil.nonNullState(allCheckedProperties);
	}

	public @NonNull Iterable<@NonNull Edge> getOldUnconditionalEdges() {
		return oldUnconditionalEdges;
	}
}