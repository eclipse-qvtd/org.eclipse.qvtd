/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2015, 2022 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.codegen/model/qvticgmodel.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.codegen.qvticgmodel.util;

import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractQVTiReferencesVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTiReferencesVisitor
	extends org.eclipse.ocl.examples.codegen.analyzer.ReferencesVisitor
	implements QVTiCGModelVisitor<@NonNull List<@Nullable Object>>
{
	protected AbstractQVTiReferencesVisitor(@Nullable Object context) {
		super(context);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGConnectionAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGConnectionAssignment object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGConnectionVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGConnectionVariable object) {
		return visitCGGuardVariable(object);
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
	public @NonNull List<@Nullable Object> visitCGFunctionParameter(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGGuardVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMapping(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMapping object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMappingCall(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingCall object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMappingCallBinding(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingCallBinding object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMappingExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMappingLoop(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingLoop object) {
		return visitCGIterationCallExp(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGMiddlePropertyCallExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMiddlePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGRealizedVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGRealizedVariable object) {
		return visitCGVariable(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGRealizedVariablePart(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGRealizedVariablePart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGSpeculateExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGSpeculateExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGSpeculatePart(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGSpeculatePart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGTransformation(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGTransformation object) {
		return visitCGClass(object);
	}

	@Override
	public @NonNull List<@Nullable Object> visitCGTypedModel(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGTypedModel object) {
		return visitCGValuedElement(object);
	}
}
