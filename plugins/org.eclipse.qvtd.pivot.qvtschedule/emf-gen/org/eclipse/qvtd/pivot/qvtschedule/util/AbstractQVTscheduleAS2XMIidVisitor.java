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

import java.lang.Boolean;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.AS2XMIid;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseAS2XMIidVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.*;

/**
 * An AbstractQVTscheduleAS2XMIidVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
@SuppressWarnings("deprecation")
public abstract class AbstractQVTscheduleAS2XMIidVisitor
extends QVTbaseAS2XMIidVisitor
implements QVTscheduleVisitor<Boolean>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTscheduleAS2XMIidVisitor(@NonNull AS2XMIid context) {
		super(context);
	}

	@Override
	public @Nullable Boolean visitAbstractDatum(@NonNull AbstractDatum object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Boolean visitArgumentEdge(@NonNull ArgumentEdge object) {
		return visitExpressionEdge(object);
	}

	@Override
	public @Nullable Boolean visitBasicPartition(@NonNull BasicPartition object) {
		return visitMappingPartition(object);
	}

	@Override
	public @Nullable Boolean visitBooleanLiteralNode(@NonNull BooleanLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitCastEdge(@NonNull CastEdge object) {
		return visitNavigableEdge(object);
	}

	@Override
	public @Nullable Boolean visitClassDatum(@NonNull ClassDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @Nullable Boolean visitCluster(@NonNull Cluster object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Boolean visitCollectionLiteralNode(@NonNull CollectionLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitCollectionPartEdge(@NonNull CollectionPartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Boolean visitCollectionRangeNode(@NonNull CollectionRangeNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitComposedNode(@NonNull ComposedNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitCompositePartition(@NonNull CompositePartition object) {
		return visitPartition(object);
	}

	@Override
	public @Nullable Boolean visitConnection(@NonNull Connection object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitCyclicMappingRegion(@NonNull CyclicMappingRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Boolean visitCyclicPartition(@NonNull CyclicPartition object) {
		return visitCompositePartition(object);
	}

	@Override
	public @Nullable Boolean visitDependencyEdge(@NonNull DependencyEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitDependencyNode(@NonNull DependencyNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitDispatchRegion(@NonNull DispatchRegion object) {
		return visitRuleRegion(object);
	}

	@Override
	public @Nullable Boolean visitEdge(@NonNull Edge object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitEdgeConnection(@NonNull EdgeConnection object) {
		return visitConnection(object);
	}

	@Override
	public @Nullable Boolean visitEnumLiteralNode(@NonNull EnumLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitErrorNode(@NonNull ErrorNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Boolean visitExpressionEdge(@NonNull ExpressionEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitIfNode(@NonNull IfNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitIncludesEdge(@NonNull IncludesEdge object) {
		return visitExpressionEdge(object);
	}

	@Override
	public @Nullable Boolean visitInputNode(@NonNull InputNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitIteratedEdge(@NonNull IteratedEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitIteratorNode(@NonNull IteratorNode object) {
		return visitVariableNode(object);
	}

	@Override
	public @Nullable Boolean visitKeyPartEdge(@NonNull KeyPartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Boolean visitKeyedValueNode(@NonNull KeyedValueNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitLoadingPartition(@NonNull LoadingPartition object) {
		return visitMappingPartition(object);
	}

	@Override
	public @Nullable Boolean visitLoadingRegion(@NonNull LoadingRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Boolean visitMapLiteralNode(@NonNull MapLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitMapPartEdge(@NonNull MapPartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Boolean visitMapPartNode(@NonNull MapPartNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitMappingNode(@NonNull MappingNode object) {
		return visitNode(object);
	}

	@Override
	public @Nullable Boolean visitMappingPartition(@NonNull MappingPartition object) {
		return visitPartition(object);
	}

	@Override
	public @Nullable Boolean visitMappingRegion(@NonNull MappingRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Boolean visitMicroMappingRegion(@NonNull MicroMappingRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Boolean visitNamedMappingRegion(@NonNull NamedMappingRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Boolean visitNavigableEdge(@NonNull NavigableEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitNavigationEdge(@NonNull NavigationEdge object) {
		return visitNavigableEdge(object);
	}

	@Override
	public @Nullable Boolean visitNode(@NonNull Node object) {
		return visitElement(object);
	}

	@Override
	public @Nullable Boolean visitNodeConnection(@NonNull NodeConnection object) {
		return visitConnection(object);
	}

	@Override
	public @Nullable Boolean visitNonPartition(@NonNull NonPartition object) {
		return visitMappingPartition(object);
	}

	@Override
	public @Nullable Boolean visitNullLiteralNode(@NonNull NullLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitNumericLiteralNode(@NonNull NumericLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitOperationCallNode(@NonNull OperationCallNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitOperationNode(@NonNull OperationNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Boolean visitOperationParameterEdge(@NonNull OperationParameterEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Boolean visitOperationRegion(@NonNull OperationRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Boolean visitOperationSelfEdge(@NonNull OperationSelfEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Boolean visitPartition(@NonNull Partition object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Boolean visitPatternTypedNode(@NonNull PatternTypedNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Boolean visitPatternVariableNode(@NonNull PatternVariableNode object) {
		return visitVariableNode(object);
	}

	@Override
	public @Nullable Boolean visitPredicateEdge(@NonNull PredicateEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitPropertyDatum(@NonNull PropertyDatum object) {
		return visitAbstractDatum(object);
	}

	@Override
	public @Nullable Boolean visitRecursionEdge(@NonNull RecursionEdge object) {
		return visitEdge(object);
	}

	@Override
	public @Nullable Boolean visitRegion(@NonNull Region object) {
		return visitNamedElement(object);
	}

	@Override
	public @Nullable Boolean visitRootPartition(@NonNull RootPartition object) {
		return visitCompositePartition(object);
	}

	@Override
	public @Nullable Boolean visitRuleRegion(@NonNull RuleRegion object) {
		return visitMappingRegion(object);
	}

	@Override
	public @Nullable Boolean visitScheduleModel(@NonNull ScheduleModel object) {
		return visitModel(object);
	}

	@Override
	public @Nullable Boolean visitScheduledRegion(@NonNull ScheduledRegion object) {
		return visitRegion(object);
	}

	@Override
	public @Nullable Boolean visitShadowNode(@NonNull ShadowNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitShadowPartEdge(@NonNull ShadowPartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Boolean visitStringLiteralNode(@NonNull StringLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitSuccessEdge(@NonNull SuccessEdge object) {
		return visitNavigationEdge(object);
	}

	@Override
	public @Nullable Boolean visitSuccessNode(@NonNull SuccessNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Boolean visitTupleLiteralNode(@NonNull TupleLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitTuplePartEdge(@NonNull TuplePartEdge object) {
		return visitArgumentEdge(object);
	}

	@Override
	public @Nullable Boolean visitTypeLiteralNode(@NonNull TypeLiteralNode object) {
		return visitOperationNode(object);
	}

	@Override
	public @Nullable Boolean visitUnknownNode(@NonNull UnknownNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Boolean visitVariableNode(@NonNull VariableNode object) {
		return visitMappingNode(object);
	}

	@Override
	public @Nullable Boolean visitVerdictRegion(@NonNull VerdictRegion object) {
		return visitRuleRegion(object);
	}
}
