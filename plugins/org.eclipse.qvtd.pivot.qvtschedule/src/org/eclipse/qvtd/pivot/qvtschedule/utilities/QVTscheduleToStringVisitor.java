/*******************************************************************************
 * Copyright (c) 2012, 2018 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseToStringVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.pivot.qvtschedule.ArgumentEdge;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Cluster;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionRangeNode;
import org.eclipse.qvtd.pivot.qvtschedule.ComposedNode;
import org.eclipse.qvtd.pivot.qvtschedule.CompositePartition;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyEdge;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyNode;
import org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.ErrorNode;
import org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.IfNode;
import org.eclipse.qvtd.pivot.qvtschedule.IncludesEdge;
import org.eclipse.qvtd.pivot.qvtschedule.InputNode;
import org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge;
import org.eclipse.qvtd.pivot.qvtschedule.IteratorNode;
import org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MapLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.MapPartNode;
import org.eclipse.qvtd.pivot.qvtschedule.MappingNode;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MergedPartition;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NonPartition;
import org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode;
import org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowNode;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessNode;
import org.eclipse.qvtd.pivot.qvtschedule.TupleLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.UnknownNode;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * Converts an OCL expression to a string for debugging. This is not intended to
 * be used by client applications as an AST-to-text transformation.
 */
public class QVTscheduleToStringVisitor extends QVTbaseToStringVisitor implements QVTscheduleVisitor<String>
{
	protected static class QVTscheduleToStringFactory implements QVTbaseToStringVisitor.Factory
	{
		protected QVTscheduleToStringFactory() {
			ToStringVisitor.addFactory(this);
			QVTbaseToStringVisitor.FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new QVTscheduleToStringVisitor(s);
		}

		@Override
		public @NonNull EPackage getEPackage() {
			QVTschedulePackage eInstance = QVTschedulePackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public static ToStringVisitor.@NonNull Factory FACTORY = new QVTscheduleToStringFactory();

	public QVTscheduleToStringVisitor(@NonNull StringBuilder s) {
		super(s);
	}

	@Override
	public String visiting(@NonNull Visitable object) {
		if (object instanceof EObject) {
			append(((EObject)object).eClass().getName());
		}
		else {
			append(object.getClass().getSimpleName());
		}
		append(" ");
		if (object instanceof Nameable) {
			appendName((Nameable) object);
		}
		return null;
	}

	@Override
	public String visitAbstractDatum(@NonNull AbstractDatum object) {
		return visiting(object);
	}

	@Override
	public String visitArgumentEdge(@NonNull ArgumentEdge object) {
		return visiting(object);
	}

	@Override
	public String visitBasicPartition(@NonNull BasicPartition object) {
		return visiting(object);
	}

	@Override
	public String visitBooleanLiteralNode(@NonNull BooleanLiteralNode object) {
		return visiting(object);
	}

	@Override
	public String visitCastEdge(@NonNull CastEdge object) {
		return visiting(object);
	}

	@Override
	public String visitClassDatum(@NonNull ClassDatum object) {
		return visiting(object);
	}

	@Override
	public String visitCluster(@NonNull Cluster object) {
		return visiting(object);
	}

	@Override
	public String visitCollectionLiteralNode(@NonNull CollectionLiteralNode object) {
		return visiting(object);
	}

	@Override
	public String visitCollectionPartEdge(@NonNull CollectionPartEdge object) {
		return visiting(object);
	}

	@Override
	public String visitCollectionRangeNode(@NonNull CollectionRangeNode object) {
		return visiting(object);
	}

	@Override
	public String visitComposedNode(@NonNull ComposedNode object) {
		return visiting(object);
	}

	@Override
	public String visitCompositePartition(@NonNull CompositePartition object) {
		return visiting(object);
	}

	@Override
	public String visitConnection(@NonNull Connection object) {
		return visiting(object);
	}

	@Override
	public String visitCyclicMappingRegion(@NonNull CyclicMappingRegion object) {
		return visiting(object);
	}

	@Override
	public String visitCyclicPartition(@NonNull CyclicPartition object) {
		return visiting(object);
	}

	@Override
	public String visitDependencyEdge(@NonNull DependencyEdge object) {
		return visiting(object);
	}

	@Override
	public String visitDependencyNode(@NonNull DependencyNode object) {
		return visiting(object);
	}

	@Override
	public String visitDispatchRegion(@NonNull DispatchRegion object) {
		return visiting(object);
	}

	@Override
	public String visitEdge(@NonNull Edge object) {
		return visiting(object);
	}

	@Override
	public String visitEdgeConnection(@NonNull EdgeConnection object) {
		return visiting(object);
	}

	@Override
	public String visitEnumLiteralNode(@NonNull EnumLiteralNode object) {
		return visiting(object);
	}

	@Override
	public String visitErrorNode(@NonNull ErrorNode object) {
		return visiting(object);
	}

	@Override
	public String visitExpressionEdge(@NonNull ExpressionEdge object) {
		return visiting(object);
	}

	@Override
	public String visitIfNode(@NonNull IfNode object) {
		return visiting(object);
	}

	@Override
	public String visitIncludesEdge(@NonNull IncludesEdge object) {
		return visiting(object);
	}

	@Override
	public String visitInputNode(@NonNull InputNode object) {
		return visiting(object);
	}

	@Override
	public String visitIteratedEdge(@NonNull IteratedEdge object) {
		return visiting(object);
	}

	@Override
	public String visitIteratorNode(@NonNull IteratorNode object) {
		return visiting(object);
	}

	@Override
	public String visitKeyPartEdge(@NonNull KeyPartEdge object) {
		return visiting(object);
	}

	@Override
	public String visitKeyedValueNode(@NonNull KeyedValueNode object) {
		return visiting(object);
	}

	@Override
	public String visitLoadingPartition(@NonNull LoadingPartition object) {
		return visiting(object);
	}

	@Override
	public String visitLoadingRegion(@NonNull LoadingRegion object) {
		return visiting(object);
	}

	@Override
	public String visitMapLiteralNode(@NonNull MapLiteralNode object) {
		return visiting(object);
	}

	@Override
	public String visitMapPartEdge(@NonNull MapPartEdge object) {
		return visiting(object);
	}

	@Override
	public String visitMapPartNode(@NonNull MapPartNode object) {
		return visiting(object);
	}

	@Override
	public String visitMappingNode(@NonNull MappingNode object) {
		return visiting(object);
	}

	@Override
	public String visitMappingPartition(@NonNull MappingPartition object) {
		return visiting(object);
	}

	@Override
	public String visitMappingRegion(@NonNull MappingRegion object) {
		return visiting(object);
	}

	@Override
	public String visitMergedPartition(@NonNull MergedPartition object) {
		return visiting(object);
	}

	@Override
	public String visitNavigableEdge(@NonNull NavigableEdge object) {
		return visiting(object);
	}

	@Override
	public String visitNavigationEdge(@NonNull NavigationEdge object) {
		return visiting(object);
	}

	@Override
	public String visitNode(@NonNull Node object) {
		return visiting(object);
	}

	@Override
	public String visitNodeConnection(@NonNull NodeConnection object) {
		return visiting(object);
	}

	@Override
	public String visitNonPartition(@NonNull NonPartition object) {
		return visiting(object);
	}

	@Override
	public String visitNullLiteralNode(@NonNull NullLiteralNode object) {
		return visiting(object);
	}

	@Override
	public String visitNumericLiteralNode(@NonNull NumericLiteralNode object) {
		return visiting(object);
	}

	@Override
	public String visitOperationCallNode(@NonNull OperationCallNode object) {
		return visiting(object);
	}

	@Override
	public String visitOperationNode(@NonNull OperationNode object) {
		return visiting(object);
	}

	@Override
	public String visitOperationParameterEdge(@NonNull OperationParameterEdge object) {
		return visiting(object);
	}

	@Override
	public String visitOperationRegion(@NonNull OperationRegion object) {
		return visiting(object);
	}

	@Override
	public String visitOperationSelfEdge(@NonNull OperationSelfEdge object) {
		return visiting(object);
	}

	@Override
	public String visitPartition(@NonNull Partition object) {
		return visiting(object);
	}

	@Override
	public String visitPatternTypedNode(@NonNull PatternTypedNode object) {
		return visiting(object);
	}

	@Override
	public String visitPatternVariableNode(@NonNull PatternVariableNode object) {
		return visiting(object);
	}

	@Override
	public String visitPredicateEdge(@NonNull PredicateEdge object) {
		return visiting(object);
	}

	@Override
	public String visitPropertyDatum(@NonNull PropertyDatum object) {
		return visiting(object);
	}

	@Override
	public String visitRecursionEdge(@NonNull RecursionEdge object) {
		return visiting(object);
	}

	@Override
	public String visitRegion(@NonNull Region object) {
		return visiting(object);
	}

	@Override
	public String visitRootPartition(@NonNull RootPartition object) {
		return visiting(object);
	}

	@Override
	public String visitRootRegion(@NonNull RootRegion object) {
		return visiting(object);
	}

	@Override
	public String visitRuleRegion(@NonNull RuleRegion object) {
		return visiting(object);
	}

	@Override
	public String visitScheduleModel(@NonNull ScheduleModel object) {
		return visiting(object);
	}

	@Override
	public String visitShadowNode(@NonNull ShadowNode object) {
		return visiting(object);
	}

	@Override
	public String visitShadowPartEdge(@NonNull ShadowPartEdge object) {
		return visiting(object);
	}

	@Override
	public String visitStringLiteralNode(@NonNull StringLiteralNode object) {
		return visiting(object);
	}

	@Override
	public String visitSuccessEdge(@NonNull SuccessEdge object) {
		return visiting(object);
	}

	@Override
	public String visitSuccessNode(@NonNull SuccessNode object) {
		return visiting(object);
	}

	@Override
	public String visitTupleLiteralNode(@NonNull TupleLiteralNode object) {
		return visiting(object);
	}

	@Override
	public String visitTuplePartEdge(@NonNull TuplePartEdge object) {
		return visiting(object);
	}

	@Override
	public String visitTypeLiteralNode(@NonNull TypeLiteralNode object) {
		return visiting(object);
	}

	@Override
	public String visitUnknownNode(@NonNull UnknownNode object) {
		return visiting(object);
	}

	@Override
	public String visitVariableNode(@NonNull VariableNode object) {
		return visiting(object);
	}

	@Override
	public String visitVerdictRegion(@NonNull VerdictRegion object) {
		return visiting(object);
	}
}
