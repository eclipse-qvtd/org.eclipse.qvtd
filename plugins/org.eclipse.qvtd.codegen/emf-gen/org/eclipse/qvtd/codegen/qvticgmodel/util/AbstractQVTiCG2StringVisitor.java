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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An AbstractQVTiCG2StringVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTiCG2StringVisitor
	extends org.eclipse.ocl.examples.codegen.analyzer.CG2StringVisitor
	implements QVTiCGModelVisitor<@Nullable String>
{
	protected AbstractQVTiCG2StringVisitor() {
		super();
	}

	@Override
	public @Nullable String visitCGConnectionAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGConnectionAssignment object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable String visitCGConnectionVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGConnectionVariable object) {
		return visitCGGuardVariable(object);
	}

	@Override
	public @Nullable String visitCGEcoreContainerAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGEcoreContainerAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	public @Nullable String visitCGEcorePropertyAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGEcorePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	public @Nullable String visitCGEcoreRealizedVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGEcoreRealizedVariable object) {
		return visitCGRealizedVariable(object);
	}

	@Override
	public @Nullable String visitCGFunction(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGFunction object) {
		return visitCGOperation(object);
	}

	@Override
	public @Nullable String visitCGFunctionCallExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGFunctionCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @Nullable String visitCGFunctionParameter(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	@Override
	public @Nullable String visitCGGuardVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	@Override
	public @Nullable String visitCGMapping(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMapping object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable String visitCGMappingCall(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingCall object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable String visitCGMappingCallBinding(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingCallBinding object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable String visitCGMappingExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable String visitCGMappingLoop(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingLoop object) {
		return visitCGIterationCallExp(object);
	}

	@Override
	public @Nullable String visitCGMiddlePropertyAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMiddlePropertyAssignment object) {
		return visitCGEcorePropertyAssignment(object);
	}

	@Override
	public @Nullable String visitCGMiddlePropertyCallExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMiddlePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	@Override
	public @Nullable String visitCGPropertyAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGPropertyAssignment object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable String visitCGRealizedVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGRealizedVariable object) {
		return visitCGVariable(object);
	}

	@Override
	public @Nullable String visitCGRealizedVariablePart(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGRealizedVariablePart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable String visitCGSequence(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGSequence object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable String visitCGSpeculateExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGSpeculateExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable String visitCGSpeculatePart(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGSpeculatePart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable String visitCGTransformation(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGTransformation object) {
		return visitCGClass(object);
	}

	@Override
	public @Nullable String visitCGTypedModel(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGTypedModel object) {
		return visitCGValuedElement(object);
	}
}
