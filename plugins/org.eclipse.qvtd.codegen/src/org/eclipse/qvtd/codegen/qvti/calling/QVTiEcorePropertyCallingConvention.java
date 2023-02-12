/*******************************************************************************
 * Copyright (c) 2023 Willink Transformation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.calling;

import java.lang.reflect.Method;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.calling.EcorePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNavigationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 *  QVTiEcorePropertyCallingConvention refines the Ecore support for incremental execution
 */
public class QVTiEcorePropertyCallingConvention extends EcorePropertyCallingConvention
{
	private static final @NonNull QVTiEcorePropertyCallingConvention INSTANCE = new QVTiEcorePropertyCallingConvention();

	public static @NonNull QVTiEcorePropertyCallingConvention getInstance(@NonNull Property asProperty) {
		INSTANCE.logInstance(asProperty);
		return INSTANCE;
	}

	/**
	 * Append the code for an EcorePropertyCall. If source is null, the code for the source will also be appended.
	 * If source is non-null the caller has already appended it.
	 * @param qvticg2javaVisitor
	 */
	private @NonNull Boolean appendCGEcorePropertyCallExp(@NonNull QVTiCG2JavaVisitor cg2javaVisitor, @NonNull CGEcorePropertyCallExp cgPropertyCallExp, @Nullable CGValuedElement source) {
		JavaStream js = cg2javaVisitor.getJavaStream();
		Property asProperty = ClassUtil.nonNullState(cgPropertyCallExp.getAsProperty());
		assert cg2javaVisitor.getESObject(asProperty) == ClassUtil.nonNullState(cgPropertyCallExp.getEStructuralFeature());
		//
		if (source == null) {
			source = cg2javaVisitor.getExpression(cgPropertyCallExp.getSource());
			if (!js.appendLocalStatements(source)) {
				return false;
			}
		}
		//
		Boolean ecoreIsRequired = cg2javaVisitor.getCodeGenerator().isNonNull(asProperty);
		boolean isPrimitive = js.isPrimitive(cgPropertyCallExp);
		if (!isPrimitive) cg2javaVisitor.appendSuppressWarningsNull(cgPropertyCallExp, ecoreIsRequired);
		//		js.append("/* " + ecoreIsRequired + " " + isRequired + " */\n");
		js.appendDeclaration(cgPropertyCallExp);
		js.append(" = ");
		appendEcoreGet(cg2javaVisitor, source, asProperty);
		js.append(";\n");
		return true;
	}

	private void appendEcoreGet(@NonNull QVTiCG2JavaVisitor cg2javaVisitor, @NonNull CGValuedElement cgSource, @NonNull Property asProperty) {
		JavaStream js = cg2javaVisitor.getJavaStream();
		CGTypeId cgTypeId = cg2javaVisitor.getAnalyzer().getCGTypeId(asProperty.getOwningClass().getTypeId());
		ElementId elementId = ClassUtil.nonNullState(cgTypeId.getElementId());
		TypeDescriptor requiredTypeDescriptor = cg2javaVisitor.getCodeGenerator().getUnboxedDescriptor(elementId);
		//		EStructuralFeature eStructuralFeature = ClassUtil.nonNullState(cgPropertyCallExp.getEStructuralFeature());
		EStructuralFeature eStructuralFeature = ClassUtil.nonNullState(cg2javaVisitor.getESObject(asProperty));
		String getAccessor;
		if (eStructuralFeature == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
			getAccessor = JavaConstants.E_CONTAINER_NAME;
		}
		else {
			getAccessor = cg2javaVisitor.getGenModelHelper().getGetAccessor(eStructuralFeature);
		}
		Class<?> requiredJavaClass = requiredTypeDescriptor.hasJavaClass();
		Method leastDerivedMethod = requiredJavaClass != null ? cg2javaVisitor.getCodeGenerator().getLeastDerivedMethod(requiredJavaClass, getAccessor) : null;
		Class<?> unboxedSourceClass;
		if (leastDerivedMethod != null) {
			unboxedSourceClass = leastDerivedMethod.getDeclaringClass();
		}
		else {
			unboxedSourceClass = requiredJavaClass;
		}
		if ((unboxedSourceClass != null) && (unboxedSourceClass != Object.class)) {
			js.appendAtomicReferenceTo(unboxedSourceClass, cgSource);
		}
		else {
			js.appendAtomicReferenceTo(cgSource);
		}
		js.append(".");
		js.append(getAccessor);
		js.append("()");
	}

	@Override
	public boolean generateJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull CGNavigationCallExp cgPropertyCallExp) {
		CGEcorePropertyCallExp cgEcorePropertyCallExp = (CGEcorePropertyCallExp)cgPropertyCallExp;
		JavaStream js = cg2javaVisitor.getJavaStream();
		QVTiCG2JavaVisitor qvticg2javaVisitor = (QVTiCG2JavaVisitor)cg2javaVisitor;
		CGValuedElement cgSource = qvticg2javaVisitor.getExpression(cgPropertyCallExp.getSource());
		if (!js.appendLocalStatements(cgSource)) {
			return false;
		}
		ElementId sourceTypeId = cgSource.getTypeId().getElementId();
		ImperativeTransformation iTransformation = qvticg2javaVisitor.getAnalyzer().getCodeGenerator().getContextClass();
		org.eclipse.ocl.pivot.Class runtimeContextClass = QVTimperativeUtil.getRuntimeContextClass(iTransformation);
		TypeId runtimeContextTypeId = runtimeContextClass.getTypeId();
		if (sourceTypeId == runtimeContextTypeId) {		// FIXME make transformationInstance regular - cloned from appendCGEcorePropertyCallExp
			Property asProperty = ClassUtil.nonNullState(cgPropertyCallExp.getAsProperty());
			EStructuralFeature eStructuralFeature = ClassUtil.nonNullState(qvticg2javaVisitor.getESObject(asProperty));
			String getAccessor = qvticg2javaVisitor.getGenModelHelper().getGetAccessor(eStructuralFeature);
			js.appendDeclaration(cgPropertyCallExp);
			js.append(" = " + qvticg2javaVisitor.getGlobalNameManager().getGetTransformationExecutionName() + "().");
			js.append(getAccessor);
			js.append("();\n");
			return true;
		}
		EStructuralFeature eStructuralFeature = QVTiCGUtil.getEStructuralFeature(cgEcorePropertyCallExp);
		qvticg2javaVisitor.doGetting(cgPropertyCallExp, eStructuralFeature, false);
		Boolean status = appendCGEcorePropertyCallExp(qvticg2javaVisitor, cgEcorePropertyCallExp, cgSource);
		if (status != ValueUtil.TRUE_VALUE) {
			return status;
		}
		qvticg2javaVisitor.doGot(cgPropertyCallExp, cgSource, eStructuralFeature);
		return status;
	}
}
