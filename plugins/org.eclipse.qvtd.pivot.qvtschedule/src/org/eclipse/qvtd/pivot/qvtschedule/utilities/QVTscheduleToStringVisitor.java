/*******************************************************************************
 * Copyright (c) 2012, 2017 E.D. Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D. Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseToStringVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.pivot.qvtschedule.ArgumentEdge;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ComposedNode;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyEdge;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyNode;
import org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.ErrorNode;
import org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.IncludesEdge;
import org.eclipse.qvtd.pivot.qvtschedule.InputNode;
import org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge;
import org.eclipse.qvtd.pivot.qvtschedule.IteratorNode;
import org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NullNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge;
import org.eclipse.qvtd.pivot.qvtschedule.OperationValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode;
import org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessNode;
import org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge;
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
	public String visitAbstractDatum(@NonNull AbstractDatum object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitArgumentEdge(@NonNull ArgumentEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitBooleanValueNode(@NonNull BooleanValueNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitCastEdge(@NonNull CastEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitClassDatum(@NonNull ClassDatum object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitCollectionPartEdge(@NonNull CollectionPartEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitComposedNode(@NonNull ComposedNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitConnection(@NonNull Connection object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitDatumConnection(@NonNull DatumConnection<?> object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitDependencyEdge(@NonNull DependencyEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitDependencyNode(@NonNull DependencyNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitDispatchRegion(@NonNull DispatchRegion object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitEdge(@NonNull Edge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitEdgeConnection(@NonNull EdgeConnection object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitErrorNode(@NonNull ErrorNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitExpressionEdge(@NonNull ExpressionEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitIncludesEdge(@NonNull IncludesEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitInputNode(@NonNull InputNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitIteratedEdge(@NonNull IteratedEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitIteratorNode(@NonNull IteratorNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitKeyPartEdge(@NonNull KeyPartEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitKeyedValueNode(@NonNull KeyedValueNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitLoadingRegion(@NonNull LoadingRegion object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitMapPartEdge(@NonNull MapPartEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitMappingRegion(@NonNull MappingRegion object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitMicroMappingRegion(@NonNull MicroMappingRegion object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitNamedMappingRegion(@NonNull NamedMappingRegion object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitNavigableEdge(@NonNull NavigableEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitNavigationEdge(@NonNull NavigationEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitNode(@NonNull Node object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitNodeConnection(@NonNull NodeConnection object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitNullNode(@NonNull NullNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitOperationNode(@NonNull OperationNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitOperationParameterEdge(@NonNull OperationParameterEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitOperationRegion(@NonNull OperationRegion object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitOperationSelfEdge(@NonNull OperationSelfEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitOperationValueNode(@NonNull OperationValueNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitPatternTypedNode(@NonNull PatternTypedNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitPatternVariableNode(@NonNull PatternVariableNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitPredicateEdge(@NonNull PredicateEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitPropertyDatum(@NonNull PropertyDatum object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitRecursionEdge(@NonNull RecursionEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitRegion(@NonNull Region object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitRuleRegion(@NonNull RuleRegion object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitScheduleModel(@NonNull ScheduleModel object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitScheduledRegion(@NonNull ScheduledRegion object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitShadowPartEdge(@NonNull ShadowPartEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitSuccessEdge(@NonNull SuccessEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitSuccessNode(@NonNull SuccessNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitTuplePartEdge(@NonNull TuplePartEdge object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitUnknownNode(@NonNull UnknownNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitVariableNode(@NonNull VariableNode object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}

	@Override
	public String visitVerdictRegion(@NonNull VerdictRegion object) {
		append(object.getClass().getSimpleName() + " ");
		appendName(object);
		return null;
	}
}
