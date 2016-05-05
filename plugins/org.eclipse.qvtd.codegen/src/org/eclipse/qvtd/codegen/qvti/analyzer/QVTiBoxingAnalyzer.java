/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.analyzer;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
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
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;

public class QVTiBoxingAnalyzer extends BoxingAnalyzer implements QVTiCGModelVisitor<Object>
{
	public QVTiBoxingAnalyzer(@NonNull QVTiAnalyzer analyzer) {
		super(analyzer);
	}

	@Override
	protected CGValuedElement rewriteAsCast(@Nullable CGVariableExp cgChild) {
		if ((cgChild != null) && (cgChild.eContainer() instanceof CGMappingCallBinding)) {
			return cgChild;
		}
		return super.rewriteAsCast(cgChild);
	}

	@Override
	public Object visitCGConnectionAssignment(@NonNull CGConnectionAssignment object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGConnectionVariable(@NonNull CGConnectionVariable object) {
		return visitCGGuardVariable(object);
	}

	@Override
	public Object visitCGEcoreContainerAssignment(@NonNull CGEcoreContainerAssignment cgEcoreContainerAssignment) {
		EStructuralFeature eStructuralFeature = cgEcoreContainerAssignment.getEStructuralFeature();
		boolean isRequired = eStructuralFeature.isRequired();
		rewriteAsEcore(cgEcoreContainerAssignment.getSlotValue(), eStructuralFeature.getEType());
		rewriteAsEcore(cgEcoreContainerAssignment.getInitValue(), eStructuralFeature.getEContainingClass());
		if (isRequired) {
			rewriteAsGuarded(cgEcoreContainerAssignment.getSlotValue(), false, "value for " + cgEcoreContainerAssignment.getReferredProperty() + " assignment");
		}
		return visitCGPropertyAssignment(cgEcoreContainerAssignment);
	}

	@Override
	public Object visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment cgEcorePropertyAssignment) {
		EStructuralFeature eStructuralFeature = cgEcorePropertyAssignment.getEStructuralFeature();
		boolean isRequired = eStructuralFeature.isRequired();
		rewriteAsEcore(cgEcorePropertyAssignment.getSlotValue(), eStructuralFeature.getEContainingClass());
		rewriteAsEcore(cgEcorePropertyAssignment.getInitValue(), eStructuralFeature.getEType());
		if (isRequired) {
			rewriteAsGuarded(cgEcorePropertyAssignment.getInitValue(), false, "value for " + cgEcorePropertyAssignment.getReferredProperty() + " assignment");
		}
		return visitCGPropertyAssignment(cgEcorePropertyAssignment);
	}

	@Override
	public Object visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable cgEcoreRealizedVariable) {
		rewriteAsAssertNonNulled(cgEcoreRealizedVariable);
		return visitCGRealizedVariable(cgEcoreRealizedVariable);
	}

	@Override
	public Object visitCGFunction(@NonNull CGFunction cgFunction) {
		visitCGOperation(cgFunction);
		rewriteAsUnboxed(cgFunction.getBody());
		return null;
	}

	@Override
	public Object visitCGFunctionCallExp(@NonNull CGFunctionCallExp cgFunctionCallExp) {
		visitCGOperationCallExp(cgFunctionCallExp);
		for (CGValuedElement cgArgument : cgFunctionCallExp.getArguments()) {
			rewriteAsUnboxed(cgArgument);
		}
		return null;
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
	public Object visitCGMapping(@NonNull CGMapping cgMapping) {
		return visitCGNamedElement(cgMapping);
	}

	@Override
	public Object visitCGMappingCall(@NonNull CGMappingCall cgMappingCall) {
		return visitCGValuedElement(cgMappingCall);
	}

	@Override
	public Object visitCGMappingCallBinding(@NonNull CGMappingCallBinding cgMappingCallBinding) {
		MappingCallBinding mappingCallBinding = (MappingCallBinding)cgMappingCallBinding.getAst();
		Variable boundVariable = mappingCallBinding.getBoundVariable();
		assert boundVariable != null;
		if (boundVariable instanceof ConnectionVariable) {
			//
		}
		else if (cgMappingCallBinding.isRequired()) {
			rewriteAsUnboxed(rewriteAsGuarded(cgMappingCallBinding.getValue(), false, "binding for '" + mappingCallBinding.getMappingCall().getReferredMapping().getName() + "::" + boundVariable.getName() + "'"));	// FIXME referred mapping
		}
		else {
			rewriteAsUnboxed(cgMappingCallBinding.getValue());
		}
		return visitCGValuedElement(cgMappingCallBinding);
	}

	@Override
	public Object visitCGMappingExp(@NonNull CGMappingExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGMappingLoop(@NonNull CGMappingLoop cgMappingLoop) {
		visitCGIterationCallExp(cgMappingLoop);
//		rewriteAsUnboxed(cgMappingLoop.getSource());
		return null;
	}

	@Override
	public Object visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment cgMiddlePropertyAssignment) {
		rewriteAsUnboxed(cgMiddlePropertyAssignment.getSlotValue());
		rewriteAsUnboxed(cgMiddlePropertyAssignment.getInitValue());
		return visitCGPropertyAssignment(cgMiddlePropertyAssignment);
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
	public Object visitCGSequence(@NonNull CGSequence object) {
		return visitCGValuedElement(object);
	}

	@Override
	public Object visitCGTransformation(@NonNull CGTransformation cgTransformation) {
		return visitCGClass(cgTransformation);
	}

	@Override
	public Object visitCGTypedModel(@NonNull CGTypedModel object) {
		return visitCGNamedElement(object);
	}

	@Override
	public Object visitCGVariable(@NonNull CGVariable object) {
		Object visitCGVariable = super.visitCGVariable(object);
		Element asElement = object.getAst();
		if ((asElement instanceof TypedElement) && ((TypedElement)asElement).isIsRequired()) {
			CGValuedElement cgInit = object.getInit();
			if (cgInit != null) {
				TypeDescriptor typeDescriptor = codeGenerator.getTypeDescriptor(cgInit);
				if (!typeDescriptor.isPrimitive()) {
					rewriteAsGuarded(cgInit, false, "where non-null value required");
				}
			}
		}
		return visitCGVariable;
	}
}
