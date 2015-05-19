/*******************************************************************************
 * Copyright (c) 2010, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.cs2as;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.Continuations;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.ocl.xtext.basecs.TypedRefCS;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.xtext.qvtrelationcs.DefaultValueCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PrimitiveTypeDomainCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.PropertyTemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QueryCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.TemplateCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.VarDeclarationIdCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.AbstractQVTrelationCSPostOrderVisitor;

public class QVTrelationCSPostOrderVisitor extends AbstractQVTrelationCSPostOrderVisitor
{
	public static class PredicateExpressionCompletion extends SingleContinuation<PredicateCS>
	{
		public PredicateExpressionCompletion(@NonNull CS2ASConversion context, @NonNull PredicateCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Predicate pivotElement = PivotUtil.getPivot(Predicate.class, csElement);
			ExpCS csExpr = csElement.getOwnedCondition();
			OCLExpression conditionExpression = csExpr != null ? context.visitLeft2Right(OCLExpression.class, csExpr) : null;		
			if (pivotElement != null) {
				pivotElement.setConditionExpression(conditionExpression);
			}
			return null;
		}
	}
	
	public static class PropertyTemplateExpressionCompletion extends SingleContinuation<PropertyTemplateCS>
	{
		public PropertyTemplateExpressionCompletion(@NonNull CS2ASConversion context, @NonNull PropertyTemplateCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			PropertyTemplateItem pivotElement = PivotUtil.getPivot(PropertyTemplateItem.class, csElement);
			ExpCS csExpression = csElement.getOwnedExpression();
			OCLExpression oclExpression = csExpression != null ? context.visitLeft2Right(OCLExpression.class, csExpression) : null;		
			if (pivotElement != null) {
				pivotElement.setValue(oclExpression);
			}
			return null;
		}
	}
	
	public static class QueryExpressionCompletion extends SingleContinuation<QueryCS>
	{
		public QueryExpressionCompletion(@NonNull CS2ASConversion context, @NonNull QueryCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			Function pivotElement = PivotUtil.getPivot(Function.class, csElement);
			ExpCS csExpression = csElement.getOwnedExpression();
			OCLExpression oclExpression = csExpression != null ? context.visitLeft2Right(OCLExpression.class, csExpression) : null;		
			if (pivotElement != null) {
				pivotElement.setQueryExpression(oclExpression);
			}
			return null;
		}
	}

	protected static class RelationDomainAssignmentContentContinuation extends SingleContinuation<DefaultValueCS>
	{
		private RelationDomainAssignmentContentContinuation(@NonNull CS2ASConversion context, @NonNull DefaultValueCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			RelationDomainAssignment pDomain = PivotUtil.getPivot(RelationDomainAssignment.class, csElement);
			ExpCS csInitialiser = csElement.getOwnedInitExpression();
			OCLExpression oclExpression = csInitialiser != null ? context.visitLeft2Right(OCLExpression.class, csInitialiser) : null;		
			if (pDomain != null) {
				pDomain.setValueExp(oclExpression);
			}
			return null;
		}
	}
	
	public static class TemplateExpressionCompletion extends SingleContinuation<TemplateCS>
	{
		public TemplateExpressionCompletion(@NonNull CS2ASConversion context, @NonNull TemplateCS csElement) {
			super(context, null, null, csElement);
		}

		@Override
		public BasicContinuation<?> execute() {
			TemplateExp pivotElement = PivotUtil.getPivot(TemplateExp.class, csElement);
			ExpCS guardExpression = csElement.getOwnedGuardExpression();
			OCLExpression oclExpression = guardExpression != null ? context.visitLeft2Right(OCLExpression.class, guardExpression) : null;		
			if (pivotElement != null) {
				pivotElement.setWhere(oclExpression);
			}
			return null;
		}
	}
	
	public QVTrelationCSPostOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitDefaultValueCS(@NonNull DefaultValueCS csElement) {
		RelationDomainAssignment pivotElement = PivotUtil.getPivot(RelationDomainAssignment.class, csElement);
		if (pivotElement != null) {
			ExpCS initialiser = csElement.getOwnedInitExpression();
			OCLExpression oclExpression = initialiser != null ? context.visitLeft2Right(OCLExpression.class, initialiser) : null;
			pivotElement.setValueExp(oclExpression);
		}
		return null;
	}

	@Override
	public Continuation<?> visitPredicateCS(@NonNull PredicateCS csElement) {
		return new PredicateExpressionCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitPrimitiveTypeDomainCS(@NonNull PrimitiveTypeDomainCS csElement) {
		RelationDomain pivotElement = PivotUtil.getPivot(RelationDomain.class, csElement);
		if (pivotElement != null) {
			Type type = PivotUtil.getPivot(Type.class, csElement.getOwnedType());
			List<Variable> asRootVariables = pivotElement.getRootVariable();
			if (asRootVariables.size() > 0) {
				Variable asRootVariable = asRootVariables.get(0);
				if (asRootVariable != null) {
					context.setType(asRootVariable, type, true);
				}
			}
			List<DomainPattern> asPatterns = pivotElement.getPattern();
			if (asPatterns.size() > 0) {
				DomainPattern pattern = asPatterns.get(0);
				if (pattern != null) {
					TemplateExp template = pattern.getTemplateExpression();
					if (template instanceof ObjectTemplateExp) {
						((ObjectTemplateExp)template).setReferredClass((org.eclipse.ocl.pivot.Class)type);
					}
				}
			}
		}
		return null;
	}

	@Override
	public Continuation<?> visitPropertyTemplateCS(@NonNull PropertyTemplateCS csElement) {
		return new PropertyTemplateExpressionCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		Continuation<?> superContinuation = super.visitQueryCS(csElement);
		Continuation<?> selfCompletion = new QueryExpressionCompletion(context, csElement);
		return Continuations.combine(superContinuation, selfCompletion);
	}

	@Override
	public Continuation<?> visitTemplateCS(@NonNull TemplateCS csElement) {
		return new TemplateExpressionCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitVarDeclarationCS(@NonNull VarDeclarationCS csElement) {
		Variable pivotVariable = null;
		Type pivotType = null;
		TypedRefCS ownedType = csElement.getOwnedType();
		if (ownedType != null) {
			pivotType = PivotUtil.getPivot(Type.class, ownedType);
		}
		OCLExpression oclExpression = null;
		ExpCS initializer = csElement.getOwnedInitExpression();
		if (initializer != null) {
			oclExpression = context.visitLeft2Right(OCLExpression.class, initializer);
			if ((pivotType == null) && (oclExpression != null)) {
				pivotType = oclExpression.getType();
			}
		}
		for (VarDeclarationIdCS csVarDeclarationId : csElement.getOwnedVarDeclarationIds()) {
			pivotVariable = PivotUtil.getPivot(Variable.class, csVarDeclarationId);
			if (pivotVariable != null) {
				context.setType(pivotVariable, pivotType, false);
				pivotVariable.setOwnedInit(null);
			}
		}
		if ((pivotVariable != null) && (oclExpression != null)) {
			pivotVariable.setOwnedInit(oclExpression);
		}
		return null;
	}
}