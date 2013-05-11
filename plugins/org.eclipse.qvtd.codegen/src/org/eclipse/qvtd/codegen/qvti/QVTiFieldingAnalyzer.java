/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvti;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

public class QVTiFieldingAnalyzer extends FieldingAnalyzer
{
	public static class QVTiAnalysisVisitor extends AnalysisVisitor implements QVTiCGModelVisitor<Set<CGVariable>>
	{
		public QVTiAnalysisVisitor(@NonNull QVTiFieldingAnalyzer context) {
			super(context);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment object) {
			return visitCGPropertyAssignment(object);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable object) {
			return visitCGRealizedVariable(object);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGFunction(@NonNull CGFunction object) {
			return visitCGOperation(object);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGFunctionCallExp(@NonNull CGFunctionCallExp object) {
			return visitCGOperationCallExp(object);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
			return visitCGParameter(object);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGGuardVariable(@NonNull CGGuardVariable object) {
			return visitCGParameter(object);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGMapping(@NonNull CGMapping object) {
			return visitCGTypedElement(object);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGMappingCall(@NonNull CGMappingCall object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGMappingCallBinding(@NonNull CGMappingCallBinding object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGPredicate(@NonNull CGPredicate object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGPropertyAssignment(@NonNull CGPropertyAssignment object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGRealizedVariable(@NonNull CGRealizedVariable object) {
			return visitCGVariable(object);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGTransformation(@NonNull CGTransformation object) {
			return visitCGClass(object);
		}

		@Override
		public @Nullable Set<CGVariable> visitCGTypedModel(@NonNull CGTypedModel object) {
			return visitCGNamedElement(object);
		}
	}
	
	public static class QVTiRewriteVisitor extends RewriteVisitor implements QVTiCGModelVisitor<Boolean>
	{
		public QVTiRewriteVisitor(@NonNull QVTiAnalyzer context, @NonNull Set<CGVariable> caughtVariables) {
			super(context, caughtVariables);
		}

		@Override
		public Boolean visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment object) {
			return visitCGPropertyAssignment(object);
		}

		@Override
		public Boolean visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable object) {
			return visitCGRealizedVariable(object);
		}

		@Override
		public Boolean visitCGFunction(@NonNull CGFunction object) {
			return visitCGOperation(object);
		}

		@Override
		public Boolean visitCGFunctionCallExp(@NonNull CGFunctionCallExp object) {
			return visitCGOperationCallExp(object);
		}

		@Override
		public Boolean visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
			return visitCGParameter(object);
		}

		@Override
		public Boolean visitCGGuardVariable(@NonNull CGGuardVariable object) {
			return visitCGParameter(object);
		}

		@Override
		public Boolean visitCGMapping(@NonNull CGMapping object) {
			return visitCGTypedElement(object);
		}

		@Override
		public Boolean visitCGMappingCall(@NonNull CGMappingCall object) {
			return visitCGValuedElement(object);
		}

		@Override
		public Boolean visitCGMappingCallBinding(@NonNull CGMappingCallBinding object) {
			return visitCGValuedElement(object);
		}

		@Override
		public Boolean visitCGPredicate(@NonNull CGPredicate cgPredicate) {
			rewriteAsCaught(cgPredicate.getConditionExpression());
			return true;
		}

		@Override
		public Boolean visitCGPropertyAssignment(@NonNull CGPropertyAssignment object) {
			return visitCGValuedElement(object);
		}

		@Override
		public Boolean visitCGRealizedVariable(@NonNull CGRealizedVariable object) {
			return visitCGVariable(object);
		}

		@Override
		public Boolean visitCGTransformation(@NonNull CGTransformation object) {
			return visitCGClass(object);
		}

		@Override
		public Boolean visitCGTypedModel(@NonNull CGTypedModel object) {
			return visitCGNamedElement(object);
		}
	}
	
	public QVTiFieldingAnalyzer(@NonNull QVTiAnalyzer analyzer) {
		super(analyzer);
	}

	@Override
	protected @NonNull AnalysisVisitor createAnalysisVisitor() {
		return new QVTiAnalysisVisitor(this);
	}

	@Override
	protected @NonNull RewriteVisitor createRewriteVisitor(@NonNull Set<CGVariable> caughtVariables) {
		return new QVTiRewriteVisitor((QVTiAnalyzer) analyzer, caughtVariables);
	}
}
