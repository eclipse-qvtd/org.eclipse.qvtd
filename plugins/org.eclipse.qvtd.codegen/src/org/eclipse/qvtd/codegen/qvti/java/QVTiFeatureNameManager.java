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
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.naming.ClassNameManager;
import org.eclipse.ocl.examples.codegen.naming.FeatureNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;

/**
 * QVTiNestedNameManager provides QVTi-specific overrides for nested contexts.
 */
public class QVTiFeatureNameManager extends FeatureNameManager
{
	private /*@LazyNonNull*/ CGParameter thisTransformerParameter = null;	// A local orphan parameter spelled "thisTransformer"

	//	protected QVTiFeatureNameManager(@NonNull JavaCodeGenerator codeGenerator, @NonNull NameManager parent, @NonNull CGNamedElement cgScope) {
	//		super(codeGenerator, parent, cgScope);
	//	}

	protected QVTiFeatureNameManager(@NonNull ClassNameManager classNameManager, @NonNull CGOperation cgOperation) {
		super(classNameManager, cgOperation);
	}

	@Override
	public @NonNull CGVariable createExecutorVariable() {
		//	assert outerContext == null;
		//	assert asScope instanceof Transformation;
		NameResolution executorNameResolution = globalNameManager.getExecutorNameResolution();
		//	Variable asExecutorVariable = PivotFactory.eINSTANCE.createVariable();
		//	asExecutorVariable.setName(executorNameResolution.getResolvedName());
		//	asVariable.setType(asType);
		//	asExecutorVariable.setIsRequired(true);
		//	asVariable.setOwnedInit(asInitExpression);
		//	PivotUtil.createVariable(executorNameResolution.getResolvedName(), JavaConstants.EXECUTOR_TYPE_ID, null);
		CGVariable cgExecutorVariable = CGModelFactory.eINSTANCE.createCGFinalVariable();
		//	cgExecutorVariable.setAst(asExecutorVariable);			// XXX misguided
		cgExecutorVariable.setTypeId(analyzer.getCGTypeId(JavaConstants.EXECUTOR_TYPE_ID));
		//	executorVariable.setInit(executorInit);
		cgExecutorVariable.setNonInvalid();
		cgExecutorVariable.setNonNull();
		executorNameResolution.addCGElement(cgExecutorVariable);			// XXX share via createExecutor(init)
		return cgExecutorVariable;			// XXX who owns the variable ??
	}

	@Override
	public @NonNull CGVariable createQualifiedThisVariable() {
		Class asClass = classNameManager.getASClass();
		assert asClass instanceof Transformation;
		NameResolution transformationName = getGlobalNameManager().getTransformationNameResolution();
		CGTypeId cgTypeId = analyzer.getCGTypeId(asClass.getTypeId());
		CGVariable transformationVariable = analyzer.createCGParameter(transformationName, cgTypeId, true);
		//	transformationVariable.setValueName(transformationName);
		transformationVariable.setNonInvalid();
		transformationVariable.setNonNull();
		transformationName.addCGElement(transformationVariable);
		return transformationVariable;
	}

	protected @NonNull CGParameter createThisTransformerParameter() {
		assert !isStatic;
		QVTiCodeGenerator qvtiCodeGenerator = (QVTiCodeGenerator)codeGenerator;
		ImperativeTransformation asTransformation = qvtiCodeGenerator.getTransformation();
		NameResolution thisTransformerName = getGlobalNameManager().getThisTransformerNameResolution();
		CGTypeId cgTypeId = analyzer.getCGTypeId(asTransformation.getTypeId());
		CGParameter thisTransformerParameter = analyzer.createCGParameter(thisTransformerName, cgTypeId, true);
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
		//	if ((asScope instanceof Function) || (asScope instanceof Mapping)) {
		//		return ((NestedNameManager)parent).getExecutorVariable();
		//	}
		return super.getExecutorVariable();
	}

	@Override
	public @NonNull QVTiGlobalNameManager getGlobalNameManager() {
		return (QVTiGlobalNameManager)super.getGlobalNameManager();
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