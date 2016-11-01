/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.analyzer;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIterator;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGIfStatement;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

public class QVTiFieldingAnalyzer extends FieldingAnalyzer
{
	public static class QVTiAnalysisVisitor extends AnalysisVisitor implements QVTiCGModelVisitor<@Nullable Set<@NonNull CGVariable>>
	{
		public QVTiAnalysisVisitor(@NonNull QVTiFieldingAnalyzer context) {
			super(context);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGConnectionAssignment(@NonNull CGConnectionAssignment object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGConnectionVariable(@NonNull CGConnectionVariable object) {
			return visitCGGuardVariable(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGEcoreContainerAssignment(@NonNull CGEcoreContainerAssignment object) {
			return visitCGPropertyAssignment(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment object) {
			return visitCGPropertyAssignment(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable object) {
			return visitCGRealizedVariable(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGFunction(@NonNull CGFunction object) {
			return visitCGOperation(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGFunctionCallExp(@NonNull CGFunctionCallExp object) {
			return visitCGOperationCallExp(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
			return visitCGParameter(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGGuardVariable(@NonNull CGGuardVariable object) {
			return visitCGParameter(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGIfStatement(@NonNull CGIfStatement object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGMapping(@NonNull CGMapping object) {
			return visitCGNamedElement(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGMappingCall(@NonNull CGMappingCall object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGMappingCallBinding(@NonNull CGMappingCallBinding object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGMappingExp(@NonNull CGMappingExp object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGMappingLoop(@NonNull CGMappingLoop object) {
			return visitCGIterationCallExp(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment object) {
			return visitCGPropertyAssignment(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGMiddlePropertyCallExp(@NonNull CGMiddlePropertyCallExp object) {
			return visitCGOppositePropertyCallExp(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGPropertyAssignment(@NonNull CGPropertyAssignment object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGRealizedVariable(@NonNull CGRealizedVariable object) {
			return visitCGVariable(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGSequence(@NonNull CGSequence object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGTransformation(@NonNull CGTransformation object) {
			return visitCGClass(object);
		}

		@Override
		public @Nullable Set<@NonNull CGVariable> visitCGTypedModel(@NonNull CGTypedModel object) {
			return visitCGNamedElement(object);
		}
	}

	public static class QVTiRewriteVisitor extends RewriteVisitor implements QVTiCGModelVisitor<@NonNull Boolean>
	{
		public QVTiRewriteVisitor(@NonNull QVTiAnalyzer context, @NonNull Set<@NonNull CGVariable> caughtVariables) {
			super(context, caughtVariables);
		}

		@Override
		public @NonNull Boolean visitCGConnectionAssignment(@NonNull CGConnectionAssignment object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @NonNull Boolean visitCGConnectionVariable(@NonNull CGConnectionVariable object) {
			return visitCGGuardVariable(object);
		}

		@Override
		public @NonNull Boolean visitCGEcoreContainerAssignment(@NonNull CGEcoreContainerAssignment object) {
			return visitCGPropertyAssignment(object);
		}

		@Override
		public @NonNull Boolean visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment object) {
			return visitCGPropertyAssignment(object);
		}

		@Override
		public @NonNull Boolean visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable object) {
			return visitCGRealizedVariable(object);
		}

		@Override
		public @NonNull Boolean visitCGFunction(@NonNull CGFunction object) {
			return visitCGOperation(object);
		}

		@Override
		public @NonNull Boolean visitCGFunctionCallExp(@NonNull CGFunctionCallExp object) {
			return visitCGOperationCallExp(object);
		}

		@Override
		public @NonNull Boolean visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
			return visitCGParameter(object);
		}

		@Override
		public @NonNull Boolean visitCGGuardVariable(@NonNull CGGuardVariable object) {
			return visitCGParameter(object);
		}

		@Override
		public @NonNull Boolean visitCGIfStatement(@NonNull CGIfStatement object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @NonNull Boolean visitCGMapping(@NonNull CGMapping object) {
			return visitCGNamedElement(object);
		}

		@Override
		public @NonNull Boolean visitCGMappingCall(@NonNull CGMappingCall object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @NonNull Boolean visitCGMappingCallBinding(@NonNull CGMappingCallBinding object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @NonNull Boolean visitCGMappingExp(@NonNull CGMappingExp object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @NonNull Boolean visitCGMappingLoop(@NonNull CGMappingLoop cgElement) {
			//			return visitCGIterationCallExp(object);
			rewriteAsThrown(cgElement.getSource());
			for (CGIterator cgIterator : cgElement.getIterators()) {
				cgIterator.accept(this);
			}
			//			if (cgElement.getReferredIteration().isValidating()) {
			//				rewriteAsCaught(cgElement.getBody());
			//			}
			//			else {
			rewriteAsThrown(cgElement.getBody());
			//			}
			cgElement.setCaught(false);
			return false;
		}

		@Override
		public @NonNull Boolean visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment object) {
			return visitCGPropertyAssignment(object);
		}

		@Override
		public @NonNull Boolean visitCGMiddlePropertyCallExp(@NonNull CGMiddlePropertyCallExp object) {
			return visitCGOppositePropertyCallExp(object);
		}

		@Override
		public @NonNull Boolean visitCGPropertyAssignment(@NonNull CGPropertyAssignment object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @NonNull Boolean visitCGRealizedVariable(@NonNull CGRealizedVariable object) {
			return visitCGVariable(object);
		}

		@Override
		public @NonNull Boolean visitCGSequence(@NonNull CGSequence object) {
			return visitCGValuedElement(object);
		}

		@Override
		public @NonNull Boolean visitCGTransformation(@NonNull CGTransformation object) {
			return visitCGClass(object);
		}

		@Override
		public @NonNull Boolean visitCGTypedModel(@NonNull CGTypedModel object) {
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
	protected @NonNull RewriteVisitor createRewriteVisitor(@NonNull Set<@NonNull CGVariable> caughtVariables) {
		return new QVTiRewriteVisitor((QVTiAnalyzer) analyzer, caughtVariables);
	}
}
