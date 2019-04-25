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
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface QVTscheduleVisitor<R> extends org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor<R>
{
	R visitAbstractDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull AbstractDatum object);
	R visitArgumentEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ArgumentEdge object);
	R visitBasicPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull BasicPartition object);
	R visitBooleanLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull BooleanLiteralNode object);
	R visitCastEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CastEdge object);
	R visitClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatum object);
	R visitCluster(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Cluster object);
	R visitCollectionClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionClassDatum object);
	R visitCollectionLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionLiteralNode object);
	R visitCollectionPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionPartEdge object);
	R visitCollectionRangeNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionRangeNode object);
	R visitComposedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ComposedNode object);
	R visitCompositePartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CompositePartition object);
	R visitConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Connection object);
	R visitCyclicMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CyclicMappingRegion object);
	R visitCyclicPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CyclicPartition object);
	R visitDependencyEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyEdge object);
	R visitDependencyNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyNode object);
	R visitDispatchRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DispatchRegion object);
	R visitEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Edge object);
	R visitEdgeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeConnection object);
	R visitEnumLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EnumLiteralNode object);
	R visitErrorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ErrorNode object);
	R visitExpressionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ExpressionEdge object);
	R visitIfNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IfNode object);
	R visitIncludesEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IncludesEdge object);
	R visitInputNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull InputNode object);
	R visitIteratedEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratedEdge object);
	R visitIteratorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratorNode object);
	R visitKeyPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull KeyPartEdge object);
	R visitKeyedValueNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull KeyedValueNode object);
	R visitLoadingPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull LoadingPartition object);
	R visitLoadingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull LoadingRegion object);
	R visitMapLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapLiteralNode object);
	R visitMapPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapPartEdge object);
	R visitMapPartNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapPartNode object);
	R visitMappingNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingNode object);
	R visitMappingPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingPartition object);
	R visitMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingRegion object);
	R visitMergedPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MergedPartition object);
	R visitNavigableEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigableEdge object);
	R visitNavigationEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigationEdge object);
	R visitNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Node object);
	R visitNodeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeConnection object);
	R visitNonPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NonPartition object);
	R visitNullLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NullLiteralNode object);
	R visitNumericLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NumericLiteralNode object);
	R visitOperationCallNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationCallNode object);
	R visitOperationNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationNode object);
	R visitOperationParameterEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationParameterEdge object);
	R visitOperationRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationRegion object);
	R visitOperationSelfEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationSelfEdge object);
	R visitPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Partition object);
	R visitPatternTypedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternTypedNode object);
	R visitPatternVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternVariableNode object);
	R visitPredicateEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PredicateEdge object);
	R visitPropertyDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PropertyDatum object);
	R visitRecursionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RecursionEdge object);
	R visitRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Region object);
	R visitRootPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RootPartition object);
	R visitRootRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RootRegion object);
	R visitRuleRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RuleRegion object);
	R visitScheduleModel(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ScheduleModel object);
	R visitShadowNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ShadowNode object);
	R visitShadowPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ShadowPartEdge object);
	R visitStringLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull StringLiteralNode object);
	R visitSuccessEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull SuccessEdge object);
	R visitSuccessNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull SuccessNode object);
	R visitTupleLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TupleLiteralNode object);
	R visitTuplePartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TuplePartEdge object);
	R visitTypeLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TypeLiteralNode object);
	R visitUnknownNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull UnknownNode object);
	R visitVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VariableNode object);
	R visitVerdictRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VerdictRegion object);
}
