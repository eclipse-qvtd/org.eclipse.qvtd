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
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface QVTscheduleVisitor<R> extends org.eclipse.ocl.pivot.util.Visitor<R>
{
	R visitAbstractDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull AbstractDatum object);
	R visitBasicMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull BasicMappingRegion object);
	R visitCastEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CastEdge object);
	R visitClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatum object);
	R visitClassDatumAnalysis(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatumAnalysis object);
	R visitComposedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ComposedNode object);
	R visitConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Connection object);
	R visitConnectionRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ConnectionRole object);
	R visitDatumConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DatumConnection<?> object);
	R visitDependencyNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyNode object);
	R visitEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Edge object);
	R visitEdgeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeConnection object);
	R visitErrorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ErrorNode object);
	R visitExpressionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ExpressionEdge object);
	R visitInputNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull InputNode object);
	R visitIteratedEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratedEdge object);
	R visitIteratorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratorNode object);
	R visitMappingAction(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingAction object);
	R visitMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingRegion object);
	R visitMicroMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MicroMappingRegion object);
	R visitMultiRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MultiRegion object);
	R visitNamedMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NamedMappingRegion object);
	R visitNavigableEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigableEdge object);
	R visitNavigationEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigationEdge object);
	R visitNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Node object);
	R visitNodeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeConnection object);
	R visitNullNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NullNode object);
	R visitOperationNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationNode object);
	R visitOperationRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationRegion object);
	R visitPatternTypedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternTypedNode object);
	R visitPatternVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternVariableNode object);
	R visitPredicateEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PredicateEdge object);
	R visitPropertyDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PropertyDatum object);
	R visitRecursionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RecursionEdge object);
	R visitRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Region object);
	R visitRole(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Role object);
	R visitRootCompositionRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RootCompositionRegion object);
	R visitScheduleModel(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ScheduleModel object);
	R visitScheduledRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ScheduledRegion object);
	R visitTrueNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TrueNode object);
	R visitUnknownNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull UnknownNode object);
	R visitVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VariableNode object);
}
