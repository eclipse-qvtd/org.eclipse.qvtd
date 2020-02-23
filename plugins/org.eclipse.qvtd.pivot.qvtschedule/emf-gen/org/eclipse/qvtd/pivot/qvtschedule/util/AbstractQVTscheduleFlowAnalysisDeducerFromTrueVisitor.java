/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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

import java.lang.Boolean;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.manager.FlowAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseFlowAnalysisDeducerFromTrueVisitor;

/**
 * An AbstractQVTscheduleFlowAnalysisDeducerFromTrueVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTscheduleFlowAnalysisDeducerFromTrueVisitor
	extends QVTbaseFlowAnalysisDeducerFromTrueVisitor
	implements QVTscheduleVisitor<Boolean>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTscheduleFlowAnalysisDeducerFromTrueVisitor(@NonNull FlowAnalysis flowAnalysis) {
		super(flowAnalysis);
	}

	@Override
	public @Nullable Boolean visitAbstractDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull AbstractDatum object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Boolean visitArgumentEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ArgumentEdge object) {
		return visitExpressionEdge(object);
	}

	@Override
	public @Nullable Boolean visitBasicPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull BasicPartition object) {
		return visitMappingPartition(object);
	}

	@Override
	public @Nullable Boolean visitBooleanLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull BooleanLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitCastEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CastEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @Nullable Boolean visitCluster(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Cluster object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Boolean visitCollectionClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionClassDatum object) {
		return visitClassDatum(object);
	}

	@Override
	public @Nullable Boolean visitCollectionLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitCollectionPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionPartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Boolean visitCollectionRangeNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionRangeNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitComposedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ComposedNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitCompositePartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CompositePartition object) {
		return visitPartition(object);
	}

	@Override
	public @Nullable Boolean visitConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Connection object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitCyclicMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CyclicMappingRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Boolean visitCyclicPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CyclicPartition object) {
		return visitCompositePartition(object);
	}

	@Override
	public @Nullable Boolean visitDependencyEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitDependencyNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitDispatchRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DispatchRegion object) {
		return visitRuleRegion(object);
	}

	@Override
	public @Nullable Boolean visitEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Edge object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitEdgeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeConnection object) {
		return visitConnection(object);
	}

	@Override
	public @Nullable Boolean visitEnumLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EnumLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitErrorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ErrorNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Boolean visitExpressionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ExpressionEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitIfNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IfNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitIncludesEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IncludesEdge object) {
		return visitExpressionEdge(object);
	}

	@Override
	public @Nullable Boolean visitInputNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull InputNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitIteratedEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratedEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitIteratorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratorNode object) {
		return visitVariableNode(object);
	}

	@Override
	public @Nullable Boolean visitKeyPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull KeyPartEdge object) {
		return visitNavigationEdge(object);
	}

	@Override
	public @Nullable Boolean visitKeyedValueNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull KeyedValueNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitLoadingPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull LoadingPartition object) {
		return visitMappingPartition(object);
	}

	@Override
	public @Nullable Boolean visitLoadingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull LoadingRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Boolean visitMapLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitMapPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapPartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Boolean visitMapPartNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapPartNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitMappingNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitMappingPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingPartition object) {
		return visitPartition(object);
	}

	@Override
	public @Nullable Boolean visitMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Boolean visitMergedPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MergedPartition object) {
		return visitBasicPartition(object);
	}

	@Override
	public @Nullable Boolean visitNavigableEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigableEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitNavigationEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigationEdge object) {
		return visitNavigableEdge(object);
	}

	@Override
	public @Nullable Boolean visitNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Node object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitNodeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeConnection object) {
		return visitConnection(object);
	}

	@Override
	public @Nullable Boolean visitNonPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NonPartition object) {
		return visitMappingPartition(object);
	}

	@Override
	public @Nullable Boolean visitNullLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NullLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitNumericLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NumericLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitOperationCallNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationCallNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitOperationNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Boolean visitOperationParameterEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationParameterEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Boolean visitOperationRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Boolean visitOperationSelfEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationSelfEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Boolean visitPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Partition object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Boolean visitPatternTypedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternTypedNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Boolean visitPatternVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternVariableNode object) {
		return visitVariableNode(object);
	}

	@Override
	public @Nullable Boolean visitPredicateEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PredicateEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitPropertyDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PropertyDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @Nullable Boolean visitRecursionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RecursionEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Region object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Boolean visitRootPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RootPartition object) {
		return visitCompositePartition(object);
	}

	@Override
	public @Nullable Boolean visitRootRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RootRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Boolean visitRuleRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RuleRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Boolean visitScheduleModel(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ScheduleModel object) {
		return visitModel(object);
	}

	@Override
	public @Nullable Boolean visitShadowNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ShadowNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitShadowPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ShadowPartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Boolean visitStringLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull StringLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitSuccessEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull SuccessEdge object) {
		return visitNavigationEdge(object);
	}

	@Override
	public @Nullable Boolean visitSuccessNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull SuccessNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Boolean visitTupleLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TupleLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitTuplePartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TuplePartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Boolean visitTypeLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TypeLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitUnknownNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull UnknownNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Boolean visitVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VariableNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Boolean visitVerdictRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VerdictRegion object) {
		return visitRuleRegion(object);
	}
}
