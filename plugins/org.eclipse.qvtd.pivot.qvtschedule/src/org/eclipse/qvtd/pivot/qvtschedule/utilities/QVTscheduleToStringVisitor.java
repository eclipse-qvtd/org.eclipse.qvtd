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
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.ComposedNode;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyNode;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.ErrorNode;
import org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.InputNode;
import org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge;
import org.eclipse.qvtd.pivot.qvtschedule.IteratorNode;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NullNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
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
import org.eclipse.qvtd.pivot.qvtschedule.StatusNode;
import org.eclipse.qvtd.pivot.qvtschedule.TrueNode;
import org.eclipse.qvtd.pivot.qvtschedule.UnknownNode;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitCastEdge(@NonNull CastEdge object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitClassDatum(@NonNull ClassDatum object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitComposedNode(@NonNull ComposedNode object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitConnection(@NonNull Connection object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitDatumConnection(@NonNull DatumConnection<?> object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitDependencyNode(@NonNull DependencyNode object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitEdge(@NonNull Edge object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitEdgeConnection(@NonNull EdgeConnection object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitErrorNode(@NonNull ErrorNode object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitExpressionEdge(@NonNull ExpressionEdge object) {
		// TODO Auto-generated method stub
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
	public String visitLoadingRegion(@NonNull LoadingRegion object) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitNullNode(@NonNull NullNode object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitOperationNode(@NonNull OperationNode object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitOperationRegion(@NonNull OperationRegion object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitPatternTypedNode(@NonNull PatternTypedNode object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitPatternVariableNode(
			@NonNull PatternVariableNode object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitPredicateEdge(@NonNull PredicateEdge object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitPropertyDatum(@NonNull PropertyDatum object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitRecursionEdge(@NonNull RecursionEdge object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitRegion(@NonNull Region object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitRuleRegion(@NonNull RuleRegion object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitScheduleModel(@NonNull ScheduleModel object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitScheduledRegion(@NonNull ScheduledRegion object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitStatusNode(@NonNull StatusNode object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitTrueNode(@NonNull TrueNode object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitUnknownNode(@NonNull UnknownNode object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String visitVariableNode(@NonNull VariableNode object) {
		// TODO Auto-generated method stub
		return null;
	}
}
