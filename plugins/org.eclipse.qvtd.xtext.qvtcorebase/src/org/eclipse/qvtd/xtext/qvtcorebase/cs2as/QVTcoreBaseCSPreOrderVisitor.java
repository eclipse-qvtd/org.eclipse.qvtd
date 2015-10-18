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
package org.eclipse.qvtd.xtext.qvtcorebase.cs2as;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.xtext.base.cs2as.BasicContinuation;
import org.eclipse.ocl.xtext.base.cs2as.CS2ASConversion;
import org.eclipse.ocl.xtext.base.cs2as.Continuation;
import org.eclipse.ocl.xtext.base.cs2as.PivotDependency;
import org.eclipse.ocl.xtext.base.cs2as.SingleContinuation;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.xtext.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.RealizeableVariableCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.TransformationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.util.AbstractQVTcoreBaseCSPreOrderVisitor;

public class QVTcoreBaseCSPreOrderVisitor extends AbstractQVTcoreBaseCSPreOrderVisitor
{	
	public static class ParamDeclarationCompletion extends SingleContinuation<ParamDeclarationCS>
	{
		public ParamDeclarationCompletion(@NonNull CS2ASConversion context, @NonNull ParamDeclarationCS csElement) {
			super(context, null, null, csElement, new PivotDependency(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			FunctionParameter pivotElement = PivotUtil.getPivot(FunctionParameter.class, csElement);
			if (pivotElement != null) {
				context.refreshRequiredType(pivotElement, csElement);
			}
			return null;
		}
	}

	public static class QueryCompletion extends SingleContinuation<QueryCS>
	{
		public QueryCompletion(@NonNull CS2ASConversion context, @NonNull QueryCS csElement) {
			super(context, null, null, csElement, new PivotDependency(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			Function pivotElement = PivotUtil.getPivot(Function.class, csElement);
			if (pivotElement != null) {
				context.refreshRequiredType(pivotElement, csElement);
			}
			return null;
		}
	}

	public static class RealizeableVariableCompletion extends SingleContinuation<RealizeableVariableCS>
	{
		public RealizeableVariableCompletion(@NonNull CS2ASConversion context, @NonNull RealizeableVariableCS csElement) {
			super(context, null, null, csElement, new PivotDependency(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			Variable pivotElement = PivotUtil.getPivot(Variable.class, csElement);
			if (pivotElement != null) {
				context.refreshRequiredType(pivotElement, csElement);
				pivotElement.setIsRequired(true);
			}
			return null;
		}
	}

	public QVTcoreBaseCSPreOrderVisitor(@NonNull CS2ASConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitBottomPatternCS(@NonNull BottomPatternCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDirectionCS(@NonNull DirectionCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitDomainCS(@NonNull DomainCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitEnforcementOperationCS(@NonNull EnforcementOperationCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitGuardPatternCS(@NonNull GuardPatternCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS csElement) {
		return new ParamDeclarationCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitPredicateCS(@NonNull PredicateCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitPredicateOrAssignmentCS(@NonNull PredicateOrAssignmentCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitQueryCS(@NonNull QueryCS csElement) {
		return new QueryCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitRealizeableVariableCS(@NonNull RealizeableVariableCS csElement) {
		return new RealizeableVariableCompletion(context, csElement);
	}

	@Override
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS csElement) {
		Transformation pivotElement = PivotUtil.getPivot(Transformation.class, csElement);
		if (pivotElement != null) {
			List<org.eclipse.ocl.pivot.Class> superClasses = pivotElement.getSuperClasses();
//			context.refreshList(Type.class, superClasses, csElement.getOwnedSuperType());
			if (superClasses.isEmpty()) {
				org.eclipse.ocl.pivot.Class oclElementType = context.getMetamodelManager().getStandardLibrary().getOclElementType();
				pivotElement.getSuperClasses().add(oclElementType);
			}
		}
		return null;
	}
}