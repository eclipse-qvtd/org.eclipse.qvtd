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

/**
 * An AbstractMergedQVTscheduleVisitor merges all visits direct to visiting().
 * This can be used by a decorating visitor to execute shared code before redispatching to a decorated visitor.
 */
public abstract class AbstractMergedQVTscheduleVisitor<R, C>
	extends org.eclipse.ocl.pivot.util.AbstractMergedVisitor<R, C>
	implements QVTscheduleVisitor<R>
{
	protected AbstractMergedQVTscheduleVisitor(C context) {
		super(context);
	}

	@Override
	public R visitAbstractDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull AbstractDatum object) {
		return visiting(object);
	}

	@Override
	public R visitBasicMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull BasicMappingRegion object) {
		return visiting(object);
	}

	@Override
	public R visitCastEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CastEdge object) {
		return visiting(object);
	}

	@Override
	public R visitClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatum object) {
		return visiting(object);
	}

	@Override
	public R visitClassDatumAnalysis(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatumAnalysis object) {
		return visiting(object);
	}

	@Override
	public R visitComposedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ComposedNode object) {
		return visiting(object);
	}

	@Override
	public R visitConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Connection object) {
		return visiting(object);
	}

	@Override
	public R visitConnectionRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ConnectionRole object) {
		return visiting(object);
	}

	@Override
	public R visitDatumConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DatumConnection<?> object) {
		return visiting(object);
	}

	@Override
	public R visitDependencyNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyNode object) {
		return visiting(object);
	}

	@Override
	public R visitEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Edge object) {
		return visiting(object);
	}

	@Override
	public R visitEdgeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeConnection object) {
		return visiting(object);
	}

	@Override
	public R visitErrorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ErrorNode object) {
		return visiting(object);
	}

	@Override
	public R visitExpressionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ExpressionEdge object) {
		return visiting(object);
	}

	@Override
	public R visitInputNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull InputNode object) {
		return visiting(object);
	}

	@Override
	public R visitIteratedEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratedEdge object) {
		return visiting(object);
	}

	@Override
	public R visitIteratorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratorNode object) {
		return visiting(object);
	}

	@Override
	public R visitLoadingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull LoadingRegion object) {
		return visiting(object);
	}

	@Override
	public R visitMappingAction(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingAction object) {
		return visiting(object);
	}

	@Override
	public R visitMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingRegion object) {
		return visiting(object);
	}

	@Override
	public R visitMicroMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MicroMappingRegion object) {
		return visiting(object);
	}

	@Override
	public R visitNamedMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NamedMappingRegion object) {
		return visiting(object);
	}

	@Override
	public R visitNavigableEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigableEdge object) {
		return visiting(object);
	}

	@Override
	public R visitNavigationEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigationEdge object) {
		return visiting(object);
	}

	@Override
	public R visitNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Node object) {
		return visiting(object);
	}

	@Override
	public R visitNodeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeConnection object) {
		return visiting(object);
	}

	@Override
	public R visitNullNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NullNode object) {
		return visiting(object);
	}

	@Override
	public R visitOperationNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationNode object) {
		return visiting(object);
	}

	@Override
	public R visitOperationRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationRegion object) {
		return visiting(object);
	}

	@Override
	public R visitPatternTypedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternTypedNode object) {
		return visiting(object);
	}

	@Override
	public R visitPatternVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternVariableNode object) {
		return visiting(object);
	}

	@Override
	public R visitPredicateEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PredicateEdge object) {
		return visiting(object);
	}

	@Override
	public R visitPropertyDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PropertyDatum object) {
		return visiting(object);
	}

	@Override
	public R visitRecursionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RecursionEdge object) {
		return visiting(object);
	}

	@Override
	public R visitRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Region object) {
		return visiting(object);
	}

	@Override
	public R visitRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Role object) {
		return visiting(object);
	}

	@Override
	public R visitScheduleModel(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ScheduleModel object) {
		return visiting(object);
	}

	@Override
	public R visitScheduledRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ScheduledRegion object) {
		return visiting(object);
	}

	@Override
	public R visitTrueNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TrueNode object) {
		return visiting(object);
	}

	@Override
	public R visitUnknownNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull UnknownNode object) {
		return visiting(object);
	}

	@Override
	public R visitVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VariableNode object) {
		return visiting(object);
	}
}
