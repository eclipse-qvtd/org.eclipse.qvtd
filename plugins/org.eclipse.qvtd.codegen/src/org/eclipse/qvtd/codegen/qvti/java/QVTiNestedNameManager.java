/*******************************************************************************
 * Copyright (c) 2022 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.java;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.NameManager;
import org.eclipse.ocl.examples.codegen.analyzer.NameResolution;
import org.eclipse.ocl.examples.codegen.analyzer.NestedNameManager;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;

/**
 * QVTiNestedNameManager provides QVTi-specific overrides for nested contexts.
 */
public class QVTiNestedNameManager extends NestedNameManager
{
	private /*@LazyNonNull*/ CGParameter thisTransformerParameter = null;	// A local orphan parameter spelled "thisTransformer"

	protected QVTiNestedNameManager(@NonNull JavaCodeGenerator codeGenerator, @NonNull NameManager parent, @NonNull CGNamedElement cgScope) {
		super(codeGenerator, parent, cgScope);
	}

	@Override
	public @NonNull CGVariable createExecutorVariable() {
		//	assert outerContext == null;
		//	assert asScope instanceof Transformation;
		NameResolution executorNameResolution = globalNameManager.getExecutorNameResolution();
		CGVariable executorVariable = CGModelFactory.eINSTANCE.createCGFinalVariable();
		executorVariable.setTypeId(analyzer.getCGTypeId(JavaConstants.EXECUTOR_TYPE_ID));
		//	executorVariable.setInit(executorInit);
		executorVariable.setNonInvalid();
		executorVariable.setNonNull();
		executorNameResolution.addCGElement(executorVariable);			// XXX share via creatExecutor(init)
		return executorVariable;			// XXX who owns the variable ??
	}

	@Override
	public @NonNull CGVariable createQualifiedThisVariable() {
		assert asType instanceof Transformation;
		NameResolution transformationName = ((QVTiCodeGenerator)getCodeGenerator()).getGlobalNameManager().getTransformationNameResolution();
		CGVariable transformationVariable = analyzer.createCGParameter(transformationName, analyzer.getCGTypeId(asType.getTypeId()), true);
		//	transformationVariable.setValueName(transformationName);
		transformationVariable.setNonInvalid();
		transformationVariable.setNonNull();
		transformationName.addCGElement(transformationVariable);
		return transformationVariable;
	}

	protected @NonNull CGParameter createThisTransformerParameter() {
		assert !isStatic;
		NameResolution thisTransformerName = ((QVTiCodeGenerator)codeGenerator).getGlobalNameManager().getThisTransformerNameResolution();
		CGParameter thisTransformerParameter = analyzer.createCGParameter(thisTransformerName, analyzer.getCGTypeId(asType.getTypeId()), true);
		//	thisTransformerParameter.setIsThis(true);
		thisTransformerParameter.setNonInvalid();
		thisTransformerParameter.setNonNull();
		return thisTransformerParameter;
	}

	@Override
	public @Nullable CGValuedElement getBody() {
		if (cgScope instanceof CGMapping) {
			return ((CGMapping)cgScope).getOwnedBody();
		}
		else if (cgScope instanceof CGTransformation) {
			return null;
		}
		return super.getBody();
	}

	@Override
	public @NonNull CGVariable getCGVariable(@NonNull VariableDeclaration asVariable) {
		if (asVariable.eContainingFeature() == QVTbasePackage.Literals.TRANSFORMATION__OWNED_CONTEXT) {
			/*	if (isQualifiedThis(asVariableExp, asParameter)) {
				cgVariable = nameManager.getQualifiedThisVariable();
			}
			else {
				cgVariable = nameManager.getThisParameter();
			} */
			return getQualifiedThisVariable();
		}
		return super.getCGVariable(asVariable);
	}

	//	@Override
	/*	protected boolean isQualifiedThis(@NonNull VariableExp asVariableExp, @NonNull Parameter asParameter) {
		assert asParameter == PivotUtil.getReferredVariable(asVariableExp);
		assert isThis(asParameter);
		Type currentType = PivotUtil.getContainingType(asVariableExp);
		Mapping currentMapping = QVTimperativeUtil.basicGetContainingMapping(asVariableExp);
		Operation currentOperation = QVTimperativeUtil.basicGetContainingOperation(asVariableExp);
		Type referencedType = PivotUtil.getContainingType(asParameter);  // FIXME Mappings
		return (currentType != referencedType) || (currentMapping != null) || (currentOperation != null);
	} */

	/**
	 * Return true if asParameter is a 'this' parameter.
	 *
	//	@Override
	protected boolean isThis(@NonNull Parameter asParameter) {
		EStructuralFeature eContainingFeature = asParameter.eContainingFeature();
		if (eContainingFeature == QVTbasePackage.Literals.TRANSFORMATION__OWNED_CONTEXT) {
			return true;
		}
		return false;//super.isThis(asParameter);
	} */

	@Override
	public @NonNull CGVariable getExecutorVariable() {
		if ((asScope instanceof Function) || (asScope instanceof Mapping)) {
			return ((NestedNameManager)parent).getExecutorVariable();
		}
		return super.getExecutorVariable();
	}

	public @NonNull CGParameter getThisTransformerParameter() {
		assert !isStatic;
		CGParameter thisTransformerParameter2 = thisTransformerParameter;
		if (thisTransformerParameter2 == null) {
			thisTransformerParameter = thisTransformerParameter2 = createThisTransformerParameter();
		}
		return thisTransformerParameter2;
	}
}