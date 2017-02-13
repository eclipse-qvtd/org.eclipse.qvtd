/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	extends org.eclipse.ocl.pivot.util.AbstractWrappingVisitor<R, C, D, P>
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
	public R visitBasicMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull BasicMappingRegion object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitBasicMappingRegion(object);
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
	public R visitClassDatumAnalysis(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatumAnalysis object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitClassDatumAnalysis(object);
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
	public R visitConnectionRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ConnectionRole object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitConnectionRole(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitDatumConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DatumConnection<?> object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitDatumConnection(object);
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
	public R visitEdgeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeRole object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitEdgeRole(object);
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
	public R visitMappingAction(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingAction object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMappingAction(object);
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
	public R visitMultiRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MultiRegion object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitMultiRegion(object);
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
	public R visitNodeRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeRole object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNodeRole(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitNullNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NullNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitNullNode(object);
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
	public R visitRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Role object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRole(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitRootCompositionRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RootCompositionRegion object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitRootCompositionRegion(object);
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
	public R visitSchedulerConstants(org.eclipse.qvtd.pivot.qvtschedule.@NonNull SchedulerConstants object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitSchedulerConstants(object);
			return postVisit(object, prologue, result);
		}
		catch (Throwable e) {
			return badVisit(object, prologue, e);
		}
	}

	@Override
	public R visitTrueNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TrueNode object) {
		@Nullable P prologue = preVisit(object);
		try {
			R result = delegate.visitTrueNode(object);
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
}
