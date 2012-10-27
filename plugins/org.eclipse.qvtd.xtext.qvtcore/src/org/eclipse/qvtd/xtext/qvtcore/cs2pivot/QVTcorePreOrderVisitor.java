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
 * $Id: CompleteOCLPreOrderVisitor.java,v 1.11 2011/05/20 15:26:50 ewillink Exp $
 */
package org.eclipse.qvtd.xtext.qvtcore.cs2pivot;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.utilities.PivotUtil;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.BasicContinuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.CS2PivotConversion;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.Continuation;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.PivotDependency;
import org.eclipse.ocl.examples.xtext.base.cs2pivot.SingleContinuation;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.xtext.qvtcorecst.AssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorecst.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.DirectionCS;
import org.eclipse.qvtd.xtext.qvtcorecst.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorecst.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorecst.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecst.ParamDeclarationCS;
import org.eclipse.qvtd.xtext.qvtcorecst.QueryCS;
import org.eclipse.qvtd.xtext.qvtcorecst.RealizeableVariableCS;
import org.eclipse.qvtd.xtext.qvtcorecst.TopLevelCS;
import org.eclipse.qvtd.xtext.qvtcorecst.TransformationCS;

public class QVTcorePreOrderVisitor extends AbstractQVTcorePreOrderVisitor
{	
	public static class ParamDeclarationCompletion extends SingleContinuation<ParamDeclarationCS>
	{
		public ParamDeclarationCompletion(@NonNull CS2PivotConversion context, @NonNull ParamDeclarationCS csElement) {
			super(context, null, null, csElement, new PivotDependency(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			FunctionParameter pivotElement = PivotUtil.getPivot(FunctionParameter.class, csElement);
			if (pivotElement != null) {
				Type type = PivotUtil.getPivot(Type.class, csElement.getOwnedType());
				pivotElement.setType(type);
			}
			return null;
		}
	}

	public static class QueryCompletion extends SingleContinuation<QueryCS>
	{
		public QueryCompletion(@NonNull CS2PivotConversion context, @NonNull QueryCS csElement) {
			super(context, null, null, csElement, new PivotDependency(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			Function pivotElement = PivotUtil.getPivot(Function.class, csElement);
			if (pivotElement != null) {
				Type type = PivotUtil.getPivot(Type.class, csElement.getOwnedType());
				pivotElement.setType(type);
			}
			return null;
		}
	}

	public static class RealizeableVariableCompletion extends SingleContinuation<RealizeableVariableCS>
	{
		public RealizeableVariableCompletion(@NonNull CS2PivotConversion context, @NonNull RealizeableVariableCS csElement) {
			super(context, null, null, csElement, new PivotDependency(csElement.getOwnedType()));
		}

		@Override
		public BasicContinuation<?> execute() {
			Variable pivotElement = PivotUtil.getPivot(Variable.class, csElement);
			if (pivotElement != null) {
				Type type = PivotUtil.getPivot(Type.class, csElement.getOwnedType());
				pivotElement.setType(type);
			}
			return null;
		}
	}

	public QVTcorePreOrderVisitor(@NonNull CS2PivotConversion context) {
		super(context);
	}

	@Override
	public Continuation<?> visitAssignmentCS(@NonNull AssignmentCS csElement) {
		return null;
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
	public Continuation<?> visitMappingCS(@NonNull MappingCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitParamDeclarationCS(@NonNull ParamDeclarationCS csElement) {
		return new ParamDeclarationCompletion(context, csElement);
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
	public Continuation<?> visitTopLevelCS(@NonNull TopLevelCS csElement) {
		return null;
	}

	@Override
	public Continuation<?> visitTransformationCS(@NonNull TransformationCS csElement) {
		return null;
	}
}