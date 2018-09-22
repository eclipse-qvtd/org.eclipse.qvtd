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
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractWrappingQVTscheduleVisitor delegates all visits wrapping the delegation in a call to a preVisit function and a postVisit function.
 */
public abstract class AbstractWrappingQVTscheduleVisitor<R, C, @NonNull D extends QVTscheduleVisitor<R>, P>
	extends org.eclipse.qvtd.pivot.qvtbase.util.AbstractWrappingQVTbaseVisitor<R, C, D, P>
	implements QVTscheduleVisitor<R>
{
	protected AbstractWrappingQVTscheduleVisitor(@NonNull D delegate, C context) {
		super(delegate, context);
	}

	@Override
	public R visitAbstractDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull AbstractDatum object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitAbstractDatum(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitArgumentEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ArgumentEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitArgumentEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitBooleanLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull BooleanLiteralNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBooleanLiteralNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCastEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CastEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCastEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatum object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitClassDatum(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCluster(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Cluster object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCluster(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCollectionLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionLiteralNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionLiteralNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCollectionPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionPartEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionPartEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCollectionRangeNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionRangeNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCollectionRangeNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitComposedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ComposedNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitComposedNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Connection object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitConnection(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitCyclicMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CyclicMappingRegion object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitCyclicMappingRegion(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDependencyEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDependencyEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDependencyNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDependencyNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDispatchRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DispatchRegion object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDispatchRegion(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Edge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitEdgeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeConnection object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitEdgeConnection(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitEnumLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EnumLiteralNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitEnumLiteralNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitErrorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ErrorNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitErrorNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitExpressionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ExpressionEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitExpressionEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIfNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IfNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIfNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIncludesEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IncludesEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIncludesEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitInputNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull InputNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitInputNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIteratedEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratedEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIteratedEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitIteratorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratorNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitIteratorNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitKeyPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull KeyPartEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitKeyPartEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitKeyedValueNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull KeyedValueNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitKeyedValueNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitLoadingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull LoadingRegion object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitLoadingRegion(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMapLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapLiteralNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMapLiteralNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMapPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapPartEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMapPartEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMapPartNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapPartNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMapPartNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMappingNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMappingNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingRegion object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMappingRegion(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitMicroMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MicroMappingRegion object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMicroMappingRegion(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNamedMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NamedMappingRegion object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNamedMappingRegion(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNavigableEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigableEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNavigableEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNavigationEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigationEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNavigationEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Node object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNodeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeConnection object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNodeConnection(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNullLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NullLiteralNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNullLiteralNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNumericLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NumericLiteralNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNumericLiteralNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOperationCallNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationCallNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOperationCallNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOperationNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOperationNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOperationParameterEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationParameterEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOperationParameterEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOperationRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationRegion object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOperationRegion(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitOperationSelfEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationSelfEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitOperationSelfEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPatternTypedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternTypedNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPatternTypedNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPatternVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternVariableNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPatternVariableNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPredicateEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PredicateEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPredicateEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitPropertyDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PropertyDatum object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitPropertyDatum(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRecursionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RecursionEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRecursionEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Region object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRegion(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRuleRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RuleRegion object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRuleRegion(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitScheduleModel(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ScheduleModel object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitScheduleModel(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitScheduledRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ScheduledRegion object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitScheduledRegion(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitShadowNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ShadowNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitShadowNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitShadowPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ShadowPartEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitShadowPartEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitStringLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull StringLiteralNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitStringLiteralNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSuccessEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull SuccessEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSuccessEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitSuccessNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull SuccessNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSuccessNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTupleLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TupleLiteralNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTupleLiteralNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTuplePartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TuplePartEdge object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTuplePartEdge(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTypeLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TypeLiteralNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTypeLiteralNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitUnknownNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull UnknownNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitUnknownNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VariableNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVariableNode(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitVerdictRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VerdictRegion object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitVerdictRegion(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}
}
