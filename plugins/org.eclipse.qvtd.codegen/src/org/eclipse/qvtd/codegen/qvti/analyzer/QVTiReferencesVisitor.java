/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.analyzer;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor;
import org.eclipse.qvtd.codegen.qvticgmodel.CGAllInstancesOperationCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGVariablePredicate;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;

/**
 * The ReferencesVisitor compute a list of objects referenced by (but not contained by or containing) the visited object
 * that contribute to that objects identity. The computed list may contain null elements to ensure that the returned lists
 * by two different objects exhibit positioanl equivalence.
 */
public class QVTiReferencesVisitor extends ReferencesVisitor implements QVTiCGModelVisitor<List<Object>>
{
	public static final @NonNull QVTiReferencesVisitor INSTANCE = new QVTiReferencesVisitor(new Object());
	
	protected QVTiReferencesVisitor(@NonNull Object context) {
		super(context);
	}

	@Override
	public @Nullable List<Object> visitCGAllInstancesOperationCallExp(@NonNull CGAllInstancesOperationCallExp object) {
		return visitCGLibraryOperationCallExp(object);
	}

	@Override
	public @Nullable List<Object> visitCGEcorePropertyAssignment(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	public @Nullable List<Object> visitCGEcoreRealizedVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable object) {
		return visitCGRealizedVariable(object);
	}

	@Override
	public @Nullable List<Object> visitCGFunction(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunction object) {
		return visitCGOperation(object);
	}

	@Override
	public @Nullable List<Object> visitCGFunctionCallExp(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @Nullable List<Object> visitCGFunctionParameter(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	@Override
	public @Nullable List<Object> visitCGGuardVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable object) {
		return visitCGParameter(object);
	}

	@Override
	public @Nullable List<Object> visitCGMapping(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMapping object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @Nullable List<Object> visitCGMappingCall(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall cgMappingCall) {
		return append(visitCGValuedElement(cgMappingCall), ((MappingCall)cgMappingCall.getAst()).getReferredMapping());
	}

	@Override
	public @Nullable List<Object> visitCGMappingCallBinding(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable List<Object> visitCGMappingExp(@NonNull CGMappingExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable List<Object> visitCGMappingLoop(@NonNull CGMappingLoop object) {
		return visitCGIterationCallExp(object);
	}

	@Override
	public @Nullable List<Object> visitCGMiddlePropertyAssignment(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment object) {
		return visitCGEcorePropertyAssignment(object);
	}

	@Override
	public @Nullable List<Object> visitCGMiddlePropertyCallExp(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	@Override
	public @Nullable List<Object> visitCGPredicate(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGPredicate object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable List<Object> visitCGPropertyAssignment(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable List<Object> visitCGRealizedVariable(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable object) {
		return visitCGVariable(object);
	}

	@Override
	public @Nullable List<Object> visitCGSequence(@NonNull CGSequence object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable List<Object> visitCGTransformation(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation object) {
		return visitCGClass(object);
	}

	@Override
	public @Nullable List<Object> visitCGTypedModel(@NonNull org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @Nullable List<Object> visitCGVariablePredicate(@NonNull CGVariablePredicate object) {
		return visitCGPredicate(object);
	}
}