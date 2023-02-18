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

import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.EcorePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGEcorePropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNavigationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyAssignment;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCG2JavaVisitor;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiGlobalNameManager;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
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

	protected void appendEcoreSet(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull CGValuedElement cgSlot, @NonNull EStructuralFeature eStructuralFeature, @NonNull CGValuedElement cgInit, boolean isPartial) {
		JavaStream js = cg2javaVisitor.getJavaStream();
		EClassifier eType = eStructuralFeature.getEType();
		String instanceClassName = eType.getInstanceClassName();
		GenModelHelper genModelHelper = cg2javaVisitor.getGenModelHelper();
		if (eStructuralFeature.isMany()) {
			String getAccessor = genModelHelper.getGetAccessor(eStructuralFeature);
			//
			js.appendValueName(cgSlot);
			js.append(".");
			js.append(getAccessor);
			js.append("().");
			if (isPartial) {
				js.append("add(");
				if (instanceClassName != null) {
					js.appendEcoreValue(instanceClassName, cgInit);
				}
				else {
					js.appendAtomicReferenceTo(cgInit);
				}
			}
			else {
				js.append( "addAll(");		// FIXME may need to loop addAll manually
				js.appendAtomicReferenceTo(cgInit);
			}
			js.append(");\n");
		}
		else {
			String setAccessor = genModelHelper.getSetAccessor(eStructuralFeature);
			//
			js.appendValueName(cgSlot);
			js.append(".");
			js.append(setAccessor);
			js.append("(");
			if (instanceClassName != null) {
				js.appendEcoreValue(instanceClassName, cgInit);
			}
			else {
				js.appendAtomicReferenceTo(cgInit);
			}
			js.append(");\n");
		}
	}

	protected void doAssigned(@NonNull QVTiCG2JavaVisitor cg2javaVisitor, @NonNull CGEcorePropertyAssignment cgPropertyAssignment, boolean isPartial) {
		JavaStream js = cg2javaVisitor.getJavaStream();
		boolean isIncremental = cg2javaVisitor.getCodeGenerator().getOptions().isIncremental();
		EStructuralFeature eStructuralFeature = QVTiCGUtil.getEStructuralFeature(cgPropertyAssignment);
		CGValuedElement cgSlot = cg2javaVisitor.getExpression(QVTiCGUtil.getOwnedSlotValue(cgPropertyAssignment));
		CGValuedElement cgInit = cg2javaVisitor.getExpression(QVTiCGUtil.getOwnedInitValue(cgPropertyAssignment));
		if (isIncremental || ((SetStatement)cgPropertyAssignment.getAst()).isIsNotify()) {
			QVTiGlobalNameManager globalNameManager = cg2javaVisitor.getGlobalNameManager();
			js.appendName(globalNameManager.getObjectManagerName());
			js.append(".assigned(");
			if (isIncremental) {
				cg2javaVisitor.appendThis(cgPropertyAssignment);
				js.append(", ");
			}
			js.appendValueName(cgSlot);
			js.append(", ");
			cg2javaVisitor.appendQualifiedLiteralName(eStructuralFeature);
			js.append(", ");
			js.appendValueName(cgInit);
			js.append(", ");
			js.appendBooleanString(eStructuralFeature.isMany() && isPartial);
			js.append(");\n");
		}
	}

	@Override
	public boolean generateJavaAssignment(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull CGPropertyAssignment cgPropertyAssignment) {
		CGEcorePropertyAssignment cgEcorePropertyAssignment = (CGEcorePropertyAssignment)cgPropertyAssignment;
		JavaStream js = cg2javaVisitor.getJavaStream();
		QVTiCG2JavaVisitor qvticg2javaVisitor = (QVTiCG2JavaVisitor)cg2javaVisitor;
		QVTiCodeGenerator codeGenerator = qvticg2javaVisitor.getCodeGenerator();
		Property asProperty = QVTiCGUtil.getAsProperty(cgPropertyAssignment);
		assert !asProperty.isIsImplicit();
		CGValuedElement slotValue = QVTiCGUtil.getOwnedSlotValue(cgPropertyAssignment);
		CGValuedElement initValue = QVTiCGUtil.getOwnedInitValue(cgPropertyAssignment);
		Map<@NonNull Property, @NonNull String> oppositeProperties = codeGenerator.getOppositeProperties();
		if (oppositeProperties != null) {
			String cacheName = oppositeProperties.get(asProperty);
			if (cacheName != null) {
				TypeDescriptor outerTypeDescriptor = codeGenerator.getBoxedDescriptor(asProperty.getOwningClass().getTypeId());
				TypeDescriptor middleTypeDescriptor = codeGenerator.getBoxedDescriptor(PivotUtil.getElementalType(PivotUtil.getType(asProperty)).getTypeId());
				js.append(cacheName);
				js.append(".put(");
				js.appendReferenceTo(middleTypeDescriptor, initValue);
				js.append(", ");
				js.appendReferenceTo(outerTypeDescriptor, slotValue);
				js.append(");\n");
			}
		}
		SetStatement asSetStatement = QVTiCGUtil.getAST(cgPropertyAssignment);
		EStructuralFeature eStructuralFeature = QVTiCGUtil.getEStructuralFeature(cgEcorePropertyAssignment);
		CGValuedElement cgSlot = cg2javaVisitor.getExpression(slotValue);
		CGValuedElement cgInit = cg2javaVisitor.getExpression(initValue);
		//		Class<?> requiredJavaClass = requiredTypeDescriptor.getJavaClass();
		//		Method leastDerivedMethod = requiredJavaClass != null ? getLeastDerivedMethod(requiredJavaClass, getAccessor) : null;
		//		Class<?> unboxedSourceClass = leastDerivedMethod != null ? leastDerivedMethod.getDeclaringClass() : requiredJavaClass;
		boolean isPartial = asSetStatement.isIsPartial();
		appendEcoreSet(cg2javaVisitor, cgSlot, eStructuralFeature, cgInit, isPartial);
		doAssigned(qvticg2javaVisitor, cgEcorePropertyAssignment, isPartial);
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

	@Override
	public void rewriteWithBoxingAndGuards(@NonNull BoxingAnalyzer boxingAnalyzer, @NonNull CGPropertyAssignment cgPropertyAssignment) {
		CGEcorePropertyAssignment cgEcorePropertyAssignment = (CGEcorePropertyAssignment)cgPropertyAssignment;
		SetStatement asSetStatement = QVTiCGUtil.getAST(cgPropertyAssignment);
		ImperativeTransformation asTransformation = QVTimperativeUtil.getContainingTransformation(asSetStatement);
		EntryPointsAnalysis entryPointsAnalysis = ((QVTiCodeGenerator)boxingAnalyzer.getCodeGenerator()).getEntryPointsAnalysis(asTransformation);
		Integer cacheIndex = entryPointsAnalysis.getCacheIndex(asSetStatement);
		if (cacheIndex != null) {		// If a middle property assignment
			EStructuralFeature eStructuralFeature = cgEcorePropertyAssignment.getEStructuralFeature();
			assert eStructuralFeature instanceof EReference;
			assert ((EReference)eStructuralFeature).getEOpposite() == null;
			boxingAnalyzer.rewriteAsUnboxed(cgEcorePropertyAssignment.getOwnedSlotValue());
			boxingAnalyzer.rewriteAsUnboxed(cgEcorePropertyAssignment.getOwnedInitValue());
			// XXX is it really appropriate to rewriteAsEcore in super ?
		}
		super.rewriteWithBoxingAndGuards(boxingAnalyzer, cgPropertyAssignment);
	}
}
