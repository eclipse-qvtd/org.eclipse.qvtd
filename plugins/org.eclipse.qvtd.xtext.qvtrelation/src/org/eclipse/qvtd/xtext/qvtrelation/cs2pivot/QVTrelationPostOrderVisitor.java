/**
 * <copyright>
 *
 * Copyright (c) 2010 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id: CompleteOCLPostOrderVisitor.java,v 1.9 2011/05/20 19:51:18 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtrelation.cs2pivot;

import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.baseCST.TypedRefCS;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuations;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.xtext.qvtrelationcst.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PredicateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.TemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcst.VarDeclarationIdCS;

public class QVTrelationPostOrderVisitor extends AbstractQVTrelationPostOrderVisitor
{
	public static class PredicateExpressionCompletion extends SingleContinuation<PredicateCS>
	{
		public PredicateExpressionCompletion(CS2PivotConversion context, PredicateCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Predicate pivotElement = PivotUtil.getPivot(Predicate.class, csElement);
			OCLExpression conditionExpression = context.visitLeft2Right(OCLExpression.class, csElement.getExpr());		
			pivotElement.setConditionExpression(conditionExpression);
			return null;
		}
	}
	
	public static class PropertyTemplateExpressionCompletion extends SingleContinuation<PropertyTemplateCS>
	{
		public PropertyTemplateExpressionCompletion(CS2PivotConversion context, PropertyTemplateCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			PropertyTemplateItem pivotElement = PivotUtil.getPivot(PropertyTemplateItem.class, csElement);
			OCLExpression oclExpression = context.visitLeft2Right(OCLExpression.class, csElement.getExpression());		
			pivotElement.setValue(oclExpression);
			return null;
		}
	}
	
	public static class QueryExpressionCompletion extends SingleContinuation<QueryCS>
	{
		public QueryExpressionCompletion(CS2PivotConversion context, QueryCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Function pivotElement = PivotUtil.getPivot(Function.class, csElement);
			OCLExpression oclExpression = context.visitLeft2Right(OCLExpression.class, csElement.getExpression());		
			pivotElement.setQueryExpression(oclExpression);
			return null;
		}
	}

	protected static class RelationDomainAssignmentContentContinuation extends SingleContinuation<DefaultValueCS>
	{
		private RelationDomainAssignmentContentContinuation(CS2PivotConversion context, DefaultValueCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			RelationDomainAssignment pDomain = PivotUtil.getPivot(RelationDomainAssignment.class, csElement);
			OCLExpression oclExpression = context.visitLeft2Right(OCLExpression.class, csElement.getInitialiser());		
			pDomain.setValueExp(oclExpression);
			return null;
		}
	}
	
	public static class TemplateExpressionCompletion extends SingleContinuation<TemplateCS>
	{
		public TemplateExpressionCompletion(CS2PivotConversion context, TemplateCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			TemplateExp pivotElement = PivotUtil.getPivot(TemplateExp.class, csElement);
			ExpCS guardExpression = csElement.getGuardExpression();
			OCLExpression oclExpression = guardExpression != null ? context.visitLeft2Right(OCLExpression.class, guardExpression) : null;		
			pivotElement.setWhere(oclExpression);
			return null;
		}
	}
	
	public QVTrelationPostOrderVisitor(CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitPredicateCS(PredicateCS csElement) {
		return new PredicateExpressionCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitPropertyTemplateCS(PropertyTemplateCS csElement) {
		return new PropertyTemplateExpressionCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitQueryCS(QueryCS csElement) {
		Continuation<?> superContinuation = super.visitQueryCS(csElement);
		Continuation<?> selfCompletion = new QueryExpressionCompletion(context, csElement);
		return Continuations.combine(superContinuation, selfCompletion);
	}

	@Override
	public Continuation<?> visitTemplateCS(TemplateCS csElement) {
		return new TemplateExpressionCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitVarDeclarationCS(VarDeclarationCS csElement) {
		TypedRefCS ownedType = csElement.getType();
		Type pivotType = ownedType != null ? PivotUtil.getPivot(Type.class, ownedType) : null;
		for (VarDeclarationIdCS csVarDeclarationId : csElement.getVarDeclarationIds()) {
			Variable pivotVariable = PivotUtil.getPivot(Variable.class, csVarDeclarationId);
			context.setType(pivotVariable, pivotType);
		}
		return null;
	}
}