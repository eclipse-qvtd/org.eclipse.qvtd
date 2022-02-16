/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.java;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.NameResolution;
import org.eclipse.ocl.examples.codegen.cgmodel.CGElementId;
import org.eclipse.ocl.examples.codegen.java.CG2JavaPreVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaLocalContext;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionParameter;
import org.eclipse.qvtd.codegen.qvticgmodel.CGGuardVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCall;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingLoop;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculateExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSpeculatePart;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;

public class QVTiCG2JavaPreVisitor extends CG2JavaPreVisitor implements QVTiCGModelVisitor<@Nullable Object>
{
	public QVTiCG2JavaPreVisitor(@NonNull QVTiGlobalContext javaContext) {
		super(javaContext);
	}

	@Override
	public @NonNull QVTiCodeGenerator getCodeGenerator() {
		return (@NonNull QVTiCodeGenerator) super.getCodeGenerator();
	}

	@Override
	public Object visitCGConnectionAssignment(@NonNull CGConnectionAssignment cgConnectionAssignment) {
		NameResolution iteratorNameResolution = getNameManager().declareStandardName(cgConnectionAssignment);
		iteratorNameResolution.addNameVariant(codeGenerator.getITER_NameVariant());
		return visitCGValuedElement(cgConnectionAssignment);
	}

	@Override
	public Object visitCGConnectionVariable(@NonNull CGConnectionVariable object) {
		return visitCGGuardVariable(object);
	}

	@Override
	public Object visitCGEcoreContainerAssignment(@NonNull CGEcoreContainerAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	public Object visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	public Object visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable object) {
		return visitCGRealizedVariable(object);
	}

	@Override
	public Object visitCGFunction(@NonNull CGFunction cgFunction) {
		visitCGOperation(cgFunction);
		JavaLocalContext<?> savedLocalContext = pushLocalContext(cgFunction);
		NameResolution nameResolution = getNameManager().declareStandardName(cgFunction);
		nameResolution.addNameVariant(getCodeGenerator().getINSTANCE_NameVariant());
		popLocalContext(savedLocalContext);
		return null;
	}

	@Override
	public Object visitCGFunctionCallExp(@NonNull CGFunctionCallExp object) {
		return visitCGOperationCallExp(object);
	}

	@Override
	public Object visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	@Override
	public Object visitCGGuardVariable(@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	@Override
	public @Nullable Object visitCGMapping(@NonNull CGMapping cgMapping) {
		JavaLocalContext<?> savedLocalContext = pushLocalContext(cgMapping);
		try {
			return visitCGNamedElement(cgMapping);
		}
		finally {
			popLocalContext(savedLocalContext);
		}
	}

	@Override
	public Object visitCGMappingCall(@NonNull CGMappingCall object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGMappingCallBinding(@NonNull CGMappingCallBinding object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGMappingExp(@NonNull CGMappingExp cgMappingExp) {
		return visitCGValuedElement(cgMappingExp);
	}

	@Override
	public Object visitCGMappingLoop(@NonNull CGMappingLoop object) {
		return visitCGIterationCallExp(object);
	}

	@Override
	public Object visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment object) {
		return visitCGPropertyAssignment(object);
	}

	@Override
	public Object visitCGMiddlePropertyCallExp(@NonNull CGMiddlePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	@Override
	public Object visitCGPropertyAssignment(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		return visitCGValuedElement(cgPropertyAssignment);
	}

	@Override
	public Object visitCGRealizedVariable(@NonNull CGRealizedVariable cgRealizedVariable) {
		return visitCGVariable(cgRealizedVariable);
	}

	@Override
	public @Nullable Object visitCGRealizedVariablePart(@NonNull CGRealizedVariablePart cgRealizedVariablePart) {
		return visitCGValuedElement(cgRealizedVariablePart);
	}

	@Override
	public Object visitCGSequence(@NonNull CGSequence object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGSpeculateExp(@NonNull CGSpeculateExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGSpeculatePart(@NonNull CGSpeculatePart object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGTransformation(@NonNull CGTransformation cgTransformation) {
		ImperativeTransformation transformation = QVTiCGUtil.getAST(cgTransformation);
		EntryPointsAnalysis entryPointsAnalysis = getCodeGenerator().getEntryPointsAnalysis(transformation);
		Map<@NonNull Property, @NonNull Integer> opposites = entryPointsAnalysis.getCaches();
		for (@NonNull Property property : opposites.keySet()) {
			CGElementId cgPropertyId = analyzer.getElementId(property.getPropertyId());
			cgPropertyId.accept(this);
		}
		return visitCGClass(cgTransformation);
	}

	@Override
	public Object visitCGTypedModel(@NonNull CGTypedModel object) {
		return visitCGNamedElement(object);
	}
}
