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
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalyzer.ReturnState;

/**
 * An AbstractQVTiFieldingAnalysisVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractQVTiFieldingAnalysisVisitor
	extends org.eclipse.ocl.examples.codegen.analyzer.FieldingAnalysisVisitor
	implements QVTiCGModelVisitor<@NonNull ReturnState>
{
	protected AbstractQVTiFieldingAnalysisVisitor(@NonNull FieldingAnalyzer context, @NonNull ReturnState requiredReturn) {
		super(context, requiredReturn);
	}

	@Override
	public @NonNull ReturnState visitCGConnectionAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGConnectionAssignment object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull ReturnState visitCGConnectionVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGConnectionVariable object) {
		return visitCGGuardVariable(object);
	}

	@Override
	public @NonNull ReturnState visitCGEcoreRealizedVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGEcoreRealizedVariable object) {
		return visitCGRealizedVariable(object);
	}

	@Override
	public @NonNull ReturnState visitCGFunction(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGFunction object) {
		return visitCGOperation(object);
	}

	@Override
	public @NonNull ReturnState visitCGFunctionCallExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGFunctionCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public @NonNull ReturnState visitCGFunctionParameter(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	@Override
	public @NonNull ReturnState visitCGGuardVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	@Override
	public @NonNull ReturnState visitCGMapping(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMapping object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull ReturnState visitCGMappingCall(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingCall object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull ReturnState visitCGMappingCallBinding(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingCallBinding object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull ReturnState visitCGMappingExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull ReturnState visitCGMappingLoop(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMappingLoop object) {
		return visitCGIterationCallExp(object);
	}

	@Override
	public @NonNull ReturnState visitCGMiddlePropertyAssignment(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMiddlePropertyAssignment object) {
		return visitCGEcorePropertyAssignment(object);
	}

	@Override
	public @NonNull ReturnState visitCGMiddlePropertyCallExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGMiddlePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	@Override
	public @NonNull ReturnState visitCGRealizedVariable(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGRealizedVariable object) {
		return visitCGVariable(object);
	}

	@Override
	public @NonNull ReturnState visitCGRealizedVariablePart(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGRealizedVariablePart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull ReturnState visitCGSpeculateExp(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGSpeculateExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull ReturnState visitCGSpeculatePart(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGSpeculatePart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @NonNull ReturnState visitCGTransformation(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGTransformation object) {
		return visitCGClass(object);
	}

	@Override
	public @NonNull ReturnState visitCGTypedModel(org.eclipse.qvtd.codegen.qvticgmodel.@NonNull CGTypedModel object) {
		return visitCGValuedElement(object);
	}
}
