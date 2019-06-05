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

import java.lang.Object;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ASSaver;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseASSaverNormalizeVisitor;

/**
 * An AbstractQVTscheduleASSaverNormalizeVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTscheduleASSaverNormalizeVisitor
	extends QVTbaseASSaverNormalizeVisitor
	implements QVTscheduleVisitor<Object>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTscheduleASSaverNormalizeVisitor(@NonNull ASSaver context) {
		super(context);
	}

	@Override
	public @Nullable Object visitAbstractDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull AbstractDatum object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Object visitArgumentEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ArgumentEdge object) {
		return visitExpressionEdge(object);
	}

	@Override
	public @Nullable Object visitBasicPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull BasicPartition object) {
		return visitMappingPartition(object);
	}

	@Override
	public @Nullable Object visitBooleanLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull BooleanLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitCastEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CastEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Object visitClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ClassDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @Nullable Object visitCluster(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Cluster object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Object visitCollectionClassDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionClassDatum object) {
		return visitClassDatum(object);
	}

	@Override
	public @Nullable Object visitCollectionLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitCollectionPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionPartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Object visitCollectionRangeNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CollectionRangeNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitComposedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ComposedNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Object visitCompositePartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CompositePartition object) {
		return visitPartition(object);
	}

	@Override
	public @Nullable Object visitConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Connection object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitCyclicMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CyclicMappingRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Object visitCyclicPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull CyclicPartition object) {
		return visitCompositePartition(object);
	}

	@Override
	public @Nullable Object visitDependencyEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Object visitDependencyNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DependencyNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Object visitDispatchRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull DispatchRegion object) {
		return visitRuleRegion(object);
	}

	@Override
	public @Nullable Object visitEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Edge object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitEdgeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EdgeConnection object) {
		return visitConnection(object);
	}

	@Override
	public @Nullable Object visitEnumLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull EnumLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitErrorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ErrorNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Object visitExpressionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ExpressionEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Object visitIfNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IfNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitIncludesEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IncludesEdge object) {
		return visitExpressionEdge(object);
	}

	@Override
	public @Nullable Object visitInputNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull InputNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Object visitIteratedEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratedEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Object visitIteratorNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull IteratorNode object) {
		return visitVariableNode(object);
	}

	@Override
	public @Nullable Object visitKeyPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull KeyPartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Object visitKeyedValueNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull KeyedValueNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitLoadingPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull LoadingPartition object) {
		return visitMappingPartition(object);
	}

	@Override
	public @Nullable Object visitLoadingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull LoadingRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Object visitMapLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitMapPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapPartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Object visitMapPartNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MapPartNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitMappingNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Object visitMappingPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingPartition object) {
		return visitPartition(object);
	}

	@Override
	public @Nullable Object visitMappingRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MappingRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Object visitMergedPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull MergedPartition object) {
		return visitBasicPartition(object);
	}

	@Override
	public @Nullable Object visitNavigableEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigableEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Object visitNavigationEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NavigationEdge object) {
		return visitNavigableEdge(object);
	}

	@Override
	public @Nullable Object visitNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Node object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Object visitNodeConnection(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NodeConnection object) {
		return visitConnection(object);
	}

	@Override
	public @Nullable Object visitNonPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NonPartition object) {
		return visitMappingPartition(object);
	}

	@Override
	public @Nullable Object visitNullLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NullLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitNumericLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull NumericLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitOperationCallNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationCallNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitOperationNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Object visitOperationParameterEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationParameterEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Object visitOperationRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Object visitOperationSelfEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull OperationSelfEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Object visitPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Partition object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Object visitPatternTypedNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternTypedNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Object visitPatternVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PatternVariableNode object) {
		return visitVariableNode(object);
	}

	@Override
	public @Nullable Object visitPredicateEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PredicateEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Object visitPropertyDatum(org.eclipse.qvtd.pivot.qvtschedule.@NonNull PropertyDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @Nullable Object visitRecursionEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RecursionEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Object visitRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull Region object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Object visitRootPartition(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RootPartition object) {
		return visitCompositePartition(object);
	}

	@Override
	public @Nullable Object visitRootRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RootRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Object visitRuleRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull RuleRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Object visitScheduleModel(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ScheduleModel object) {
		return visitModel(object);
	}

	@Override
	public @Nullable Object visitShadowNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ShadowNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitShadowPartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull ShadowPartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Object visitStringLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull StringLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitSuccessEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull SuccessEdge object) {
		return visitNavigationEdge(object);
	}

	@Override
	public @Nullable Object visitSuccessNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull SuccessNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Object visitTupleLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TupleLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitTuplePartEdge(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TuplePartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Object visitTypeLiteralNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull TypeLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Object visitUnknownNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull UnknownNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Object visitVariableNode(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VariableNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Object visitVerdictRegion(org.eclipse.qvtd.pivot.qvtschedule.@NonNull VerdictRegion object) {
		return visitRuleRegion(object);
	}
}
