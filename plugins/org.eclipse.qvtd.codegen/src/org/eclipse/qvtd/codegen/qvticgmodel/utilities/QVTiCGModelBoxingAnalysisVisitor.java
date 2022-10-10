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
package org.eclipse.qvtd.codegen.qvticgmodel.utilities;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIndexExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreContainerAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcorePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGEcoreRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingCallBinding;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMiddlePropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart;
import org.eclipse.qvtd.codegen.qvticgmodel.util.AbstractQVTiCGModelBoxingAnalysisVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

public class QVTiCGModelBoxingAnalysisVisitor extends AbstractQVTiCGModelBoxingAnalysisVisitor
{
	public QVTiCGModelBoxingAnalysisVisitor(@NonNull CodeGenAnalyzer analyzer) {
		super(analyzer);
	}

	/*	@Override
	protected CGValuedElement rewriteAsCast(@Nullable CGValuedElement/ *CGVariableExp* / cgChild) {
		if ((cgChild != null) && (cgChild.eContainer() instanceof CGMappingCallBinding)) {
			return cgChild;
		}
		if ((cgChild != null) && (cgChild.getAst() == null)) {		// XXX
			return cgChild;
		}
		return super.rewriteAsCast(cgChild);
	} */

	@Override
	protected CGValuedElement rewriteAsCast(@NonNull CGVariableExp cgChild) {
		if (cgChild.eContainer() instanceof CGMappingCallBinding) {
			return cgChild;
		}
		return super.rewriteAsCast(cgChild);
	}

	/**
	 * Insert a CGCastExp around cgChild if required.
	 */
	protected CGValuedElement rewriteAsCast2(@NonNull Type asRequiredType, @NonNull CGValuedElement cgElement) {
		//		CGVariable cgVariable = cgChild.getReferredVariable();
		Element asElement = cgElement.getAst();
		if ((asElement instanceof TypedElement) && !(asElement instanceof CGIndexExp)) {
			Type asActualType = PivotUtil.getType((TypedElement)asElement);
			if (asActualType.conformsTo(codeGenerator.getEnvironmentFactory().getStandardLibrary(), asRequiredType)) {
				return cgElement;
			}
		}
		//	Type asActualType = PivotUtil.getType(asElement);
		//	if (asActualType.conformsTo(codeGenerator.getEnvironmentFactory().getStandardLibrary(), asRequiredType)) {
		//		return cgElement;
		//	}
		//	CGTypeId cgRequiredTypeId = asRequiredType.getTypeId();
		//	CGTypeId cgActualTypeId = cgElement.getTypeId();
		//	if (cgRequiredTypeId == cgActualTypeId) {		// FIXME conforms
		//		return cgElement;
		//	}
		//	TypeDescriptor typeDescriptor = codeGenerator.getTypeDescriptor(cgElement);
		//	if (typeDescriptor.getJavaClass() == Object.class) {
		//		return cgElement;
		//	}
		//	Type asType = asChild.getType();
		CGCastExp cgCastExp = CGModelFactory.eINSTANCE.createCGCastExp();
		globalNameManager.wrap(cgCastExp, cgElement);
		cgCastExp.setAst(asElement);
		//	if (asType != null) {
		ExecutableNameManager executableNameManager = context.useExecutableNameManager(asElement);
		CGExecutorType cgExecutorType = executableNameManager.getCGExecutorType(asRequiredType);
		cgCastExp.setExecutorType(cgExecutorType);
		//	}
		cgCastExp.setTypeId(codeGenerator.getAnalyzer().getCGTypeId(asRequiredType.getTypeId()));
		return cgCastExp;
	}


	@Override
	public @Nullable Object visitCGEcoreContainerAssignment(@NonNull CGEcoreContainerAssignment cgEcoreContainerAssignment) {
		EStructuralFeature eStructuralFeature = cgEcoreContainerAssignment.getEStructuralFeature();
		boolean isRequired = eStructuralFeature.isRequired();
		rewriteAsEcore(cgEcoreContainerAssignment.getOwnedSlotValue(), eStructuralFeature.getEType());
		rewriteAsEcore(cgEcoreContainerAssignment.getOwnedInitValue(), eStructuralFeature.getEContainingClass());
		if (isRequired) {
			rewriteAsGuarded(cgEcoreContainerAssignment.getOwnedSlotValue(), false, "value for " + cgEcoreContainerAssignment.getReferredProperty() + " assignment");
		}
		return super.visitCGEcoreContainerAssignment(cgEcoreContainerAssignment);
	}

	@Override
	public @Nullable Object visitCGEcorePropertyAssignment(@NonNull CGEcorePropertyAssignment cgEcorePropertyAssignment) {
		EStructuralFeature eStructuralFeature = cgEcorePropertyAssignment.getEStructuralFeature();
		rewriteAsEcore(cgEcorePropertyAssignment.getOwnedSlotValue(), eStructuralFeature.getEContainingClass());
		rewriteAsEcore(cgEcorePropertyAssignment.getOwnedInitValue(), eStructuralFeature.getEType());
		if (eStructuralFeature.isRequired()) {
			CGValuedElement cgInit = cgEcorePropertyAssignment.getOwnedInitValue();
			TypeDescriptor typeDescriptor = cgInit != null ? codeGenerator.getTypeDescriptor(cgInit) : null;
			if ((typeDescriptor == null) || !typeDescriptor.isPrimitive()) {
				rewriteAsGuarded(cgInit, false, "value for " + cgEcorePropertyAssignment.getReferredProperty() + " assignment");
			}
		}
		return super.visitCGEcorePropertyAssignment(cgEcorePropertyAssignment);
	}

	@Override
	public @Nullable Object visitCGEcoreRealizedVariable(@NonNull CGEcoreRealizedVariable cgEcoreRealizedVariable) {
		rewriteAsAssertNonNulled(cgEcoreRealizedVariable);
		return super.visitCGEcoreRealizedVariable(cgEcoreRealizedVariable);
	}

	/*	@Override
	public @Nullable Object visitCGFunction(@NonNull CGFunction cgFunction) {
		visitCGOperation(cgFunction);
		//	rewriteAsUnboxed(cgFunction.getBody());
		rewriteAsBoxed(cgFunction.getBody());
		return null;
	} */

	/*	@Override
	public @Nullable Object visitCGFunctionCallExp(@NonNull CGFunctionCallExp cgFunctionCallExp) {
		super.visitCGFunctionCallExp(cgFunctionCallExp);
		/ *	int i = 0;
		for (CGValuedElement cgArgument : cgFunctionCallExp.getArguments()) {
			if (i++ > 0) {			// Skip source
				rewriteAsUnboxed(cgArgument);
			}
		} * /
		return null;
	} */

	@Override
	public @Nullable Object visitCGMappingCallBinding(@NonNull CGMappingCallBinding cgMappingCallBinding) {
		MappingParameterBinding mappingParameterBinding = (MappingParameterBinding)cgMappingCallBinding.getAst();
		MappingParameter boundVariable = mappingParameterBinding.getBoundVariable();
		assert boundVariable != null;
		if (mappingParameterBinding instanceof AppendParameterBinding) {
			return super.visitCGMappingCallBinding(cgMappingCallBinding);
		}
		else if (mappingParameterBinding instanceof GuardParameterBinding) {
			//			if (cgMappingCallBinding.isRequired()) {
			//				rewriteAsUnboxed(rewriteAsGuarded(cgMappingCallBinding.getValue(), false, "binding for '" + mappingParameterBinding.getMappingCall().getReferredMapping().getName() + "::" + boundVariable.getName() + "'"));	// FIXME referred mapping
			//			}
			//			else {
			//				rewriteAsUnboxed(cgMappingCallBinding.getValue());
			//			}
			return super.visitCGMappingCallBinding(cgMappingCallBinding);
		}
		else if (mappingParameterBinding instanceof LoopParameterBinding) {
			//			if (cgMappingCallBinding.isRequired()) {
			//				rewriteAsUnboxed(rewriteAsGuarded(cgMappingCallBinding.getValue(), false, "binding for '" + mappingParameterBinding.getMappingCall().getReferredMapping().getName() + "::" + boundVariable.getName() + "'"));	// FIXME referred mapping
			//			}
			//			else {
			//				rewriteAsUnboxed(cgMappingCallBinding.getValue());
			//			}
			return super.visitCGMappingCallBinding(cgMappingCallBinding);
		}
		else if (mappingParameterBinding instanceof SimpleParameterBinding) {
			if (cgMappingCallBinding.isRequired()) {
				rewriteAsUnboxed(rewriteAsGuarded(cgMappingCallBinding.getOwnedValue(), false, "binding for '" + QVTimperativeUtil.getOwningMappingCall(mappingParameterBinding).getReferredMapping().getName() + "::" + boundVariable.getName() + "'"));	// FIXME referred mapping
			}
			else {
				rewriteAsUnboxed(cgMappingCallBinding.getOwnedValue());
			}
			return super.visitCGMappingCallBinding(cgMappingCallBinding);
		}
		else {
			assert false;
			return null;
		}
	}

	@Override
	public @Nullable Object visitCGMiddlePropertyAssignment(@NonNull CGMiddlePropertyAssignment cgMiddlePropertyAssignment) {
		rewriteAsUnboxed(cgMiddlePropertyAssignment.getOwnedSlotValue());
		rewriteAsUnboxed(cgMiddlePropertyAssignment.getOwnedInitValue());
		return super.visitCGMiddlePropertyAssignment(cgMiddlePropertyAssignment);
	}

	@Override
	public @Nullable Object visitCGPropertyAssignment(@NonNull CGPropertyAssignment cgPropertyAssignment) {
		CGProperty cgProperty = QVTiCGUtil.getReferredProperty(cgPropertyAssignment);
		//	CGTypeId cgRequiredTypeId = CGUtil.getTypeId(cgProperty);
		Type asRequiredType = PivotUtil.getType(CGUtil.getAST(cgProperty));
		CGValuedElement cgInitValue = QVTiCGUtil.getOwnedInitValue(cgPropertyAssignment);
		rewriteAsCast2(asRequiredType, cgInitValue);
		return super.visitCGPropertyAssignment(cgPropertyAssignment);
	}

	@Override
	public @Nullable Object visitCGRealizedVariablePart(@NonNull CGRealizedVariablePart cgRealizedVariablePart) {
		rewriteAsUnboxed(cgRealizedVariablePart.getInit());
		return super.visitCGRealizedVariablePart(cgRealizedVariablePart);
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
