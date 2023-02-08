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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.calling.EcorePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNavigationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.TypeId;
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
		if (source == null) {				// XXX Surely this never happens
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
		assert (sourceTypeId != runtimeContextTypeId);		// FIXME make transformationInstance regular - cloned from appendCGEcorePropertyCallExp
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
