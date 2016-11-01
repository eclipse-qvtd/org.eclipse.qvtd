/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
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
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;

/**
 * The ReferencesVisitor compute a list of objects referenced by (but not contained by or containing) the visited object
 * that contribute to that objects identity. The computed list may contain null elements to ensure that the returned lists
 * by two different objects exhibit positioanl equivalence.
 */
public class QVTiReferencesVisitor extends ReferencesVisitor implements QVTiCGModelVisitor<@NonNull List<@Nullable Object>>
{
	public static final @NonNull QVTiReferencesVisitor INSTANCE = new QVTiReferencesVisitor(new Object());

	protected QVTiReferencesVisitor(@Nullable Object context) {
		super(context);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGConnectionAssignment(@NonNull CGConnectionAssignment object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGConnectionVariable(@NonNull CGConnectionVariable object) {
		return visitCGGuardVariable(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGEcoreContainerAssignment(@NonNull CGEcoreContainerAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGEcorePropertyAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGEcorePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGEcoreRealizedVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGEcoreRealizedVariable object) {
		return visitCGRealizedVariable(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGFunction(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGFunction object) {
		return visitCGOperation(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGFunctionCallExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGFunctionCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGFunctionParameter(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGGuardVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGIfStatement(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGIfStatement object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMapping(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMapping object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMappingCall(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingCall cgMappingCall) {
		return append(visitCGValuedElement(cgMappingCall), ((MappingCall)cgMappingCall.getAst()).getReferredMapping());
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMappingCallBinding(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingCallBinding object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMappingExp(@NonNull CGMappingExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMappingLoop(@NonNull CGMappingLoop object) {
		return visitCGIterationCallExp(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMiddlePropertyAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMiddlePropertyAssignment object) {
		return visitCGEcorePropertyAssignment(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMiddlePropertyCallExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMiddlePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGPropertyAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGPropertyAssignment object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGRealizedVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGRealizedVariable object) {
		return visitCGVariable(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGSequence(@NonNull CGSequence object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGTransformation(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGTransformation object) {
		return visitCGClass(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGTypedModel(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGTypedModel object) {
		return visitCGNamedElement(object);
	}
}