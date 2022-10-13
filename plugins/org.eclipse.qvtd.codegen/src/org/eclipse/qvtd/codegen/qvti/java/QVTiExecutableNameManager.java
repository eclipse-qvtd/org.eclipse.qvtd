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

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGModelFactory;
import org.eclipse.ocl.examples.codegen.cgmodel.CGNamedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.naming.ClassNameManager;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.naming.NestedNameManager;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTransformation;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;

/**
 * QVTiNestedNameManager provides QVTi-specific overrides for nested contexts.
 */
public class QVTiExecutableNameManager extends ExecutableNameManager
{
	private /*@LazyNonNull*/ CGParameter thisTransformerParameter = null;	// A local orphan parameter spelled "thisTransformer"
	private /*@LazyNonNull*/ CGParameter idResolverParameter = null;		// A local orphan parameter spelled "idResolver" -- XXX probably doesn't need caching

	//	protected QVTiExecutableNameManager(@NonNull JavaCodeGenerator codeGenerator, @NonNull NameManager parent, @NonNull CGNamedElement cgScope) {
	//		super(codeGenerator, parent, cgScope);
	//	}

	//	public QVTiExecutableNameManager(@NonNull ClassNameManager transformationNameManager, @NonNull CGMapping cgMapping) {
	//		super(transformationNameManager, transformationNameManager, cgMapping);
	//	}

	//	public QVTiExecutableNameManager(@NonNull ClassNameManager transformationNameManager, @NonNull ExecutableNameManager parentNameManager, @NonNull CGMappingLoop cgMappingLoop) {
	//		super(transformationNameManager, parentNameManager, cgMappingLoop);
	//	}

	public QVTiExecutableNameManager(@NonNull ClassNameManager classNameManager, @NonNull NestedNameManager parentNameManager, @NonNull CGNamedElement cgScope) {
		super(classNameManager, parentNameManager, cgScope);
	}

	//	public @Nullable CGParameter basicGetIdResolverParameter() {
	//		return idResolverParameter;
	//	}

	//	@Override
	//	public @Nullable CGVariable basicGetIdResolverVariable() {
	//		if (idResolverParameter != null) {
	//			return idResolverParameter;
	//		}
	//		return super.basicGetIdResolverVariable();
	//	}

	@Override
	public @NonNull CGVariable createExecutorVariable() {
		// create a 'parameter' variable that exposes the static field name as a variable
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
	public @NonNull CGFinalVariable createCGVariable(@NonNull VariableDeclaration asVariable) {
		EStructuralFeature eContainingFeature = asVariable.eContainingFeature();
		if (eContainingFeature == QVTbasePackage.Literals.TRANSFORMATION__OWNED_CONTEXT) {
			CGFinalVariable cgVariable = getQualifiedThisVariable();
			addVariable(asVariable, cgVariable);
			return cgVariable;
		}
		else if (eContainingFeature == QVTbasePackage.Literals.TYPED_MODEL__OWNED_CONTEXT) {
			CGFinalVariable cgVariable = super.createCGVariable(asVariable);
			cgVariable.setAst(asVariable);
			if (asVariable.isIsRequired()) {
				cgVariable.setNonInvalid();
				cgVariable.setNonNull();
			}
			return cgVariable;
		}
		return super.createCGVariable(asVariable);
	}

	protected @NonNull CGParameter createIdResolverParameter() {
		assert !isStatic;
		NameResolution idResolverNameResolution = getGlobalNameManager().getIdResolverNameResolution();
		CGTypeId cgTypeId = analyzer.getCGTypeId(JavaConstants.ID_RESOLVER_TYPE_ID);
		CGParameter idResolverParameter = analyzer.createCGParameter(idResolverNameResolution, cgTypeId, true);
		//	thisTransformerParameter.setIsThis(true);
		idResolverParameter.setNonInvalid();
		idResolverParameter.setNonNull();
		return idResolverParameter;
	}

	@Override
	public @NonNull CGFinalVariable createIdResolverVariable() {
		// if idResolverParameter is non-null, create a 'parameter' variable that exposes the parameter name as a variable
		// if idResolverParameter is null, create a 'parameter' variable that exposes the static field name as a variable
		//	assert asScope instanceof Transformation; -- may be a Function
		NameResolution idResolverNameResolution = globalNameManager.getIdResolverNameResolution();
		CGFinalVariable cgIdResolverVariable = CGModelFactory.eINSTANCE.createCGFinalVariable();
		//	cgExecutorVariable.setAst(asExecutorVariable);			// XXX misguided
		cgIdResolverVariable.setTypeId(analyzer.getCGTypeId(JavaConstants.ID_RESOLVER_TYPE_ID));
		//	executorVariable.setInit(executorInit);			// This name exposes a 'hidden' initialized name
		cgIdResolverVariable.setNonInvalid();
		cgIdResolverVariable.setNonNull();
		idResolverNameResolution.addCGElement(cgIdResolverVariable);			// XXX share via createIdResolver(init)
		return cgIdResolverVariable;			// XXX who owns the variable ??
	}

	@Override
	public @NonNull CGFinalVariable createQualifiedThisVariable() {
		Class asClass = classNameManager.getASClass();
		assert asClass instanceof Transformation;
		NameResolution transformationName = getGlobalNameManager().getTransformationNameResolution();
		CGTypeId cgTypeId = analyzer.getCGTypeId(asClass.getTypeId());
		//		CGFinalVariable transformationVariable = (CGFinalVariable) analyzer.createCGParameter(transformationName, cgTypeId, true);
		CGFinalVariable transformationVariable = CGModelFactory.eINSTANCE.createCGFinalVariable();
		transformationVariable.setTypeId(cgTypeId);
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
	public @NonNull QVTiAnalyzer getAnalyzer() {
		return (QVTiAnalyzer)super.getAnalyzer();
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

	/*	@Override
	public @NonNull CGVariable getCGVariable(@NonNull VariableDeclaration asVariable) {
		EStructuralFeature eContainingFeature = asVariable.eContainingFeature();
		if (eContainingFeature == QVTbasePackage.Literals.TRANSFORMATION__OWNED_CONTEXT) {
			CGFinalVariable cgVariable = getQualifiedThisVariable();
			addVariable(asVariable, cgVariable);
			return cgVariable;
		}
		return super.getCGVariable(asVariable);
	} */

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

	//	@Override
	//	public @NonNull CGVariable getExecutorVariable() {
	//	if ((asScope instanceof Function) || (asScope instanceof Mapping)) {
	//		return ((NestedNameManager)parent).getExecutorVariable();
	//	}
	//		return super.getExecutorVariable();
	//	}

	@Override
	public @NonNull QVTiGlobalNameManager getGlobalNameManager() {
		return (QVTiGlobalNameManager)super.getGlobalNameManager();
	}

	public @NonNull CGParameter getIdResolverParameter() {
		assert !isStatic;
		CGParameter idResolverParameter2 = idResolverParameter;
		if (idResolverParameter2 == null) {
			idResolverParameter = idResolverParameter2 = createIdResolverParameter();
		}
		return idResolverParameter2;
	}

	/*	@Override
	public @NonNull CGVariable getIdResolverVariable() {
		CGVariable idResolverVariable = basicGetIdResolverVariable();
		if (idResolverVariable == null) {
			idResolverVariable = idResolverParameter = createIdResolverParameter();
		}
		return idResolverVariable;
	} */

	public @NonNull CGParameter getThisTransformerParameter() {
		assert !isStatic;
		CGParameter thisTransformerParameter2 = thisTransformerParameter;
		if (thisTransformerParameter2 == null) {
			thisTransformerParameter = thisTransformerParameter2 = createThisTransformerParameter();
		}
		return thisTransformerParameter2;
	}
}