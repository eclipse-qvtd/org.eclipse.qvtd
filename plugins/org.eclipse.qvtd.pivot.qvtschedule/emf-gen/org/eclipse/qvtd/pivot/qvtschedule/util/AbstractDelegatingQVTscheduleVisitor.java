/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.pivot.qvtschedule/model/QVTschedule.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.pivot.qvtschedule.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractDelegatingQVTscheduleVisitor delegates all visits.
 */
public abstract class AbstractDelegatingQVTscheduleVisitor<R, C, @NonNull D extends QVTscheduleVisitor<R>>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractDelegatingQVTbaseVisitor<R, C, D>
	implements QVTscheduleVisitor<R>
{
	protected AbstractDelegatingQVTscheduleVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visiting(org.eclipse.ocl.pivot.util.@NonNull Visitable visitable) {
		return delegate.visiting(visitable);
	}

	@Override
	public R visitAbstractDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull AbstractDatum object) {
		return delegate.visitAbstractDatum(object);
	}

	@Override
	public R visitArgumentEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ArgumentEdge object) {
		return delegate.visitArgumentEdge(object);
	}

	@Override
	public R visitBooleanLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull BooleanLiteralNode object) {
		return delegate.visitBooleanLiteralNode(object);
	}

	@Override
	public R visitCastEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CastEdge object) {
		return delegate.visitCastEdge(object);
	}

	@Override
	public R visitClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatum object) {
		return delegate.visitClassDatum(object);
	}

	@Override
	public R visitCluster(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Cluster object) {
		return delegate.visitCluster(object);
	}

	@Override
	public R visitCollectionLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionLiteralNode object) {
		return delegate.visitCollectionLiteralNode(object);
	}

	@Override
	public R visitCollectionPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionPartEdge object) {
		return delegate.visitCollectionPartEdge(object);
	}

	@Override
	public R visitCollectionRangeNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionRangeNode object) {
		return delegate.visitCollectionRangeNode(object);
	}

	@Override
	public R visitComposedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ComposedNode object) {
		return delegate.visitComposedNode(object);
	}

	@Override
	public R visitConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Connection object) {
		return delegate.visitConnection(object);
	}

	@Override
	public R visitCyclicMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CyclicMappingRegion object) {
		return delegate.visitCyclicMappingRegion(object);
	}

	@Override
	public R visitDependencyEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyEdge object) {
		return delegate.visitDependencyEdge(object);
	}

	@Override
	public R visitDependencyNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyNode object) {
		return delegate.visitDependencyNode(object);
	}

	@Override
	public R visitDispatchRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DispatchRegion object) {
		return delegate.visitDispatchRegion(object);
	}

	@Override
	public R visitEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Edge object) {
		return delegate.visitEdge(object);
	}

	@Override
	public R visitEdgeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeConnection object) {
		return delegate.visitEdgeConnection(object);
	}

	@Override
	public R visitEnumLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EnumLiteralNode object) {
		return delegate.visitEnumLiteralNode(object);
	}

	@Override
	public R visitErrorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ErrorNode object) {
		return delegate.visitErrorNode(object);
	}

	@Override
	public R visitExpressionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ExpressionEdge object) {
		return delegate.visitExpressionEdge(object);
	}

	@Override
	public R visitIfNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IfNode object) {
		return delegate.visitIfNode(object);
	}

	@Override
	public R visitIncludesEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IncludesEdge object) {
		return delegate.visitIncludesEdge(object);
	}

	@Override
	public R visitInputNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull InputNode object) {
		return delegate.visitInputNode(object);
	}

	@Override
	public R visitIteratedEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratedEdge object) {
		return delegate.visitIteratedEdge(object);
	}

	@Override
	public R visitIteratorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratorNode object) {
		return delegate.visitIteratorNode(object);
	}

	@Override
	public R visitKeyPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull KeyPartEdge object) {
		return delegate.visitKeyPartEdge(object);
	}

	@Override
	public R visitKeyedValueNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull KeyedValueNode object) {
		return delegate.visitKeyedValueNode(object);
	}

	@Override
	public R visitLoadingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull LoadingRegion object) {
		return delegate.visitLoadingRegion(object);
	}

	@Override
	public R visitMapLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapLiteralNode object) {
		return delegate.visitMapLiteralNode(object);
	}

	@Override
	public R visitMapPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapPartEdge object) {
		return delegate.visitMapPartEdge(object);
	}

	@Override
	public R visitMapPartNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapPartNode object) {
		return delegate.visitMapPartNode(object);
	}

	@Override
	public R visitMappingNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingNode object) {
		return delegate.visitMappingNode(object);
	}

	@Override
	public R visitMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingRegion object) {
		return delegate.visitMappingRegion(object);
	}

	@Override
	public R visitMicroMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MicroMappingRegion object) {
		return delegate.visitMicroMappingRegion(object);
	}

	@Override
	public R visitNamedMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NamedMappingRegion object) {
		return delegate.visitNamedMappingRegion(object);
	}

	@Override
	public R visitNavigableEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigableEdge object) {
		return delegate.visitNavigableEdge(object);
	}

	@Override
	public R visitNavigationEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigationEdge object) {
		return delegate.visitNavigationEdge(object);
	}

	@Override
	public R visitNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Node object) {
		return delegate.visitNode(object);
	}

	@Override
	public R visitNodeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeConnection object) {
		return delegate.visitNodeConnection(object);
	}

	@Override
	public R visitNullLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NullLiteralNode object) {
		return delegate.visitNullLiteralNode(object);
	}

	@Override
	public R visitNumericLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NumericLiteralNode object) {
		return delegate.visitNumericLiteralNode(object);
	}

	@Override
	public R visitOperationCallNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationCallNode object) {
		return delegate.visitOperationCallNode(object);
	}

	@Override
	public R visitOperationNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationNode object) {
		return delegate.visitOperationNode(object);
	}

	@Override
	public R visitOperationParameterEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationParameterEdge object) {
		return delegate.visitOperationParameterEdge(object);
	}

	@Override
	public R visitOperationRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationRegion object) {
		return delegate.visitOperationRegion(object);
	}

	@Override
	public R visitOperationSelfEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationSelfEdge object) {
		return delegate.visitOperationSelfEdge(object);
	}

	@Override
	public R visitPatternTypedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternTypedNode object) {
		return delegate.visitPatternTypedNode(object);
	}

	@Override
	public R visitPatternVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternVariableNode object) {
		return delegate.visitPatternVariableNode(object);
	}

	@Override
	public R visitPredicateEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PredicateEdge object) {
		return delegate.visitPredicateEdge(object);
	}

	@Override
	public R visitPropertyDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PropertyDatum object) {
		return delegate.visitPropertyDatum(object);
	}

	@Override
	public R visitRecursionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RecursionEdge object) {
		return delegate.visitRecursionEdge(object);
	}

	@Override
	public R visitRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Region object) {
		return delegate.visitRegion(object);
	}

	@Override
	public R visitRuleRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RuleRegion object) {
		return delegate.visitRuleRegion(object);
	}

	@Override
	public R visitScheduleModel(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ScheduleModel object) {
		return delegate.visitScheduleModel(object);
	}

	@Override
	public R visitScheduledRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ScheduledRegion object) {
		return delegate.visitScheduledRegion(object);
	}

	@Override
	public R visitShadowNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ShadowNode object) {
		return delegate.visitShadowNode(object);
	}

	@Override
	public R visitShadowPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ShadowPartEdge object) {
		return delegate.visitShadowPartEdge(object);
	}

	@Override
	public R visitStringLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull StringLiteralNode object) {
		return delegate.visitStringLiteralNode(object);
	}

	@Override
	public R visitSuccessEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull SuccessEdge object) {
		return delegate.visitSuccessEdge(object);
	}

	@Override
	public R visitSuccessNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull SuccessNode object) {
		return delegate.visitSuccessNode(object);
	}

	@Override
	public R visitTupleLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TupleLiteralNode object) {
		return delegate.visitTupleLiteralNode(object);
	}

	@Override
	public R visitTuplePartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TuplePartEdge object) {
		return delegate.visitTuplePartEdge(object);
	}

	@Override
	public R visitTypeLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TypeLiteralNode object) {
		return delegate.visitTypeLiteralNode(object);
	}

	@Override
	public R visitUnknownNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull UnknownNode object) {
		return delegate.visitUnknownNode(object);
	}

	@Override
	public R visitVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VariableNode object) {
		return delegate.visitVariableNode(object);
	}

	@Override
	public R visitVerdictRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VerdictRegion object) {
		return delegate.visitVerdictRegion(object);
	}
}
