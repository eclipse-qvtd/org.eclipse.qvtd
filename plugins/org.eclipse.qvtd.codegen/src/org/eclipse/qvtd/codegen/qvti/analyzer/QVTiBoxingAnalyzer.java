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
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;

public class QVTiBoxingAnalyzer extends BoxingAnalyzer implements QVTiCGModelVisitor<@Nullable Object>
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
	public @Nullable Object visitCGConnectionAssignment(@NonNull CGConnectionAssignment object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable Object visitCGConnectionVariable(@NonNull CGConnectionVariable object) {
		return visitCGGuardVariable(object);
	}

	@Override
	public @Nullable Object visitCGEcoreContainerAssignment(@NonNull CGEcoreContainerAssignment cgEcoreContainerAssignment) {
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
	public @Nullable Object visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment cgEcorePropertyAssignment) {
		EStructuralFeature eStructuralFeature = cgEcorePropertyAssignment.getEStructuralFeature();
		rewriteAsEcore(cgEcorePropertyAssignment.getSlotValue(), eStructuralFeature.getEContainingClass());
		rewriteAsEcore(cgEcorePropertyAssignment.getInitValue(), eStructuralFeature.getEType());
		if (eStructuralFeature.isRequired()) {
			CGValuedElement cgInit = cgEcorePropertyAssignment.getInitValue();
			TypeDescriptor typeDescriptor = cgInit != null ? codeGenerator.getTypeDescriptor(cgInit) : null;
			if ((typeDescriptor == null) || !typeDescriptor.isPrimitive()) {
				rewriteAsGuarded(cgInit, false, "value for " + cgEcorePropertyAssignment.getReferredProperty() + " assignment");
			}
		}
		return visitCGPropertyAssignment(cgEcorePropertyAssignment);
	}

	@Override
	public @Nullable Object visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable cgEcoreRealizedVariable) {
		rewriteAsAssertNonNulled(cgEcoreRealizedVariable);
		return visitCGRealizedVariable(cgEcoreRealizedVariable);
	}

	@Override
	public @Nullable Object visitCGFunction(@NonNull CGFunction cgFunction) {
		visitCGOperation(cgFunction);
		rewriteAsUnboxed(cgFunction.getBody());
		return null;
	}

	@Override
	public @Nullable Object visitCGFunctionCallExp(@NonNull CGFunctionCallExp cgFunctionCallExp) {
		visitCGOperationCallExp(cgFunctionCallExp);
		for (CGValuedElement cgArgument : cgFunctionCallExp.getArguments()) {
			rewriteAsUnboxed(cgArgument);
		}
		return null;
	}

	@Override
	public @Nullable Object visitCGFunctionParameter(@NonNull CGFunctionParameter object) {
		return visitCGParameter(object);
	}

	@Override
	public @Nullable Object visitCGGuardVariable(@NonNull CGGuardVariable object) {
		return visitCGParameter(object);
	}

	@Override
	public @Nullable Object visitCGMapping(@NonNull CGMapping cgMapping) {
		return visitCGNamedElement(cgMapping);
	}

	@Override
	public @Nullable Object visitCGMappingCall(@NonNull CGMappingCall cgMappingCall) {
		return visitCGValuedElement(cgMappingCall);
	}

	@Override
	public @Nullable Object visitCGMappingCallBinding(@NonNull CGMappingCallBinding cgMappingCallBinding) {
		MappingParameterBinding mappingParameterBinding = (MappingParameterBinding)cgMappingCallBinding.getAst();
		MappingParameter boundVariable = mappingParameterBinding.getBoundVariable();
		assert boundVariable != null;
		if (mappingParameterBinding instanceof AppendParameterBinding) {
			return visitCGValuedElement(cgMappingCallBinding);
		}
		else if (mappingParameterBinding instanceof GuardParameterBinding) {
			//			if (cgMappingCallBinding.isRequired()) {
			//				rewriteAsUnboxed(rewriteAsGuarded(cgMappingCallBinding.getValue(), false, "binding for '" + mappingParameterBinding.getMappingCall().getReferredMapping().getName() + "::" + boundVariable.getName() + "'"));	// FIXME referred mapping
			//			}
			//			else {
			//				rewriteAsUnboxed(cgMappingCallBinding.getValue());
			//			}
			return visitCGValuedElement(cgMappingCallBinding);
		}
		else if (mappingParameterBinding instanceof LoopParameterBinding) {
			//			if (cgMappingCallBinding.isRequired()) {
			//				rewriteAsUnboxed(rewriteAsGuarded(cgMappingCallBinding.getValue(), false, "binding for '" + mappingParameterBinding.getMappingCall().getReferredMapping().getName() + "::" + boundVariable.getName() + "'"));	// FIXME referred mapping
			//			}
			//			else {
			//				rewriteAsUnboxed(cgMappingCallBinding.getValue());
			//			}
			return visitCGValuedElement(cgMappingCallBinding);
		}
		else if (mappingParameterBinding instanceof SimpleParameterBinding) {
			if (cgMappingCallBinding.isRequired()) {
				rewriteAsUnboxed(rewriteAsGuarded(cgMappingCallBinding.getValue(), false, "binding for '" + mappingParameterBinding.getMappingCall().getReferredMapping().getName() + "::" + boundVariable.getName() + "'"));	// FIXME referred mapping
			}
			else {
				rewriteAsUnboxed(cgMappingCallBinding.getValue());
			}
			return visitCGValuedElement(cgMappingCallBinding);
		}
		else {
			assert false;
			return null;
		}
	}

	@Override
	public @Nullable Object visitCGMappingExp(@NonNull CGMappingExp object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable Object visitCGMappingLoop(@NonNull CGMappingLoop cgMappingLoop) {
		visitCGIterationCallExp(cgMappingLoop);
		//		rewriteAsUnboxed(cgMappingLoop.getSource());
		return null;
	}

	@Override
	public @Nullable Object visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment cgMiddlePropertyAssignment) {
		rewriteAsUnboxed(cgMiddlePropertyAssignment.getSlotValue());
		rewriteAsUnboxed(cgMiddlePropertyAssignment.getInitValue());
		return visitCGPropertyAssignment(cgMiddlePropertyAssignment);
	}

	@Override
	public @Nullable Object visitCGMiddlePropertyCallExp(@NonNull CGMiddlePropertyCallExp object) {
		return visitCGOppositePropertyCallExp(object);
	}

	@Override
	public @Nullable Object visitCGPropertyAssignment(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		return visitCGValuedElement(cgPropertyAssignment);
	}

	@Override
	public @Nullable Object visitCGRealizedVariable(@NonNull CGRealizedVariable cgRealizedVariable) {
		return visitCGVariable(cgRealizedVariable);
	}

	@Override
	public @Nullable Object visitCGSequence(@NonNull CGSequence object) {
		return visitCGValuedElement(object);
	}

	@Override
	public @Nullable Object visitCGTransformation(@NonNull CGTransformation cgTransformation) {
		return visitCGClass(cgTransformation);
	}

	@Override
	public @Nullable Object visitCGTypedModel(@NonNull CGTypedModel object) {
		return visitCGNamedElement(object);
	}

	@Override
	public @Nullable Object visitCGVariable(@NonNull CGVariable object) {
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
