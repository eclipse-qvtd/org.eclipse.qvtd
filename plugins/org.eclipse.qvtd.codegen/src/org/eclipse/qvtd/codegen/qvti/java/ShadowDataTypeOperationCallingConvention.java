/*******************************************************************************
 * Copyright (c) 2022 Willink Transformation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvti.java;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.CacheClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.ImmutableCachePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIndexExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.LanguageSupport;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.java.InternalFunctionOperationCallingConvention.CachePropertyCallExpImpl;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;

/**
 *  ShadowDataTypeOperationCallingConvention defines the support for the call of an operation returning an implemented DataType.
 */
public class ShadowDataTypeOperationCallingConvention extends ShadowFunctionOperationCallingConvention		// FIXME Promote to OCL
{
	public static final @NonNull ShadowDataTypeOperationCallingConvention INSTANCE = new ShadowDataTypeOperationCallingConvention();

	/**
	 * A CacheProperty instance supports evaluation of a property in a CGed cache. (It has no opposite).
	 */
	public static class CacheProperty extends AbstractProperty
	{
		private final @NonNull PropertyId propertyId;
		private final @Nullable OCLExpression initExpression;
		private final @Nullable Object defaultValue;

		private CacheProperty(@NonNull PropertyId propertyId, @Nullable OCLExpression initExpression, @Nullable Object defaultValue) {
			this.propertyId = propertyId;
			this.initExpression = initExpression;
			this.defaultValue = defaultValue;
		}

		/** @deprecated use Executor */
		@Deprecated
		@Override
		public @Nullable Object evaluate(@NonNull Evaluator evaluator, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
			return evaluate(getExecutor(evaluator), returnTypeId, sourceValue);
		}

		/**
		 * @since 1.1
		 */
		@Override
		public @Nullable Object evaluate(@NonNull Executor executor, @NonNull TypeId returnTypeId, @Nullable Object sourceValue) {
			throw new UnsupportedOperationException();
		}
	}

	protected @NonNull Parameter createBoundValuesParameter(@NonNull QVTiCodeGenerator codeGenerator) {
		NameResolution boundValuesResolution = codeGenerator.getGlobalNameManager().getBoundValuesNameResolution();
		String boundValuesName = boundValuesResolution.getResolvedName();
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		assert jLanguageSupport != null;
		org.eclipse.ocl.pivot.Class boundValueType = jLanguageSupport.getNativeClass(Object[].class);
		Parameter asConstructorParameter = PivotUtil.createParameter(boundValuesName, boundValueType, true);
		return asConstructorParameter;
	}

	@Override
	public void createCGParameters(@NonNull ExecutableNameManager operationNameManager, @Nullable ExpressionInOCL bodyExpression) {
		super.createCGParameters(operationNameManager, bodyExpression);
		//
		QVTiExecutableNameManager qvtiOperationNameManager = (QVTiExecutableNameManager)operationNameManager;
		QVTiAnalyzer qvtiAnalyzer = qvtiOperationNameManager.getAnalyzer();
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		CGFunction cgFunction = (CGFunction)operationNameManager.getCGScope();
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		//	assert QVTimperativeUtil.basicGetShadowExp(asFunction) == null;
		//
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		assert jLanguageSupport != null;
		org.eclipse.ocl.pivot.Class asCacheClass = jLanguageSupport.getCacheClass(asFunction);
		org.eclipse.ocl.pivot.Class asSuperClass = jLanguageSupport.getNativeClass(AbstractComputation.class);
		asCacheClass.getSuperClasses().add(asSuperClass);
		//
		//
		CGClass cgCacheClass = qvtiAnalyzer.generateClassDeclaration(asCacheClass, CacheClassCallingConvention.INSTANCE);
		createCacheProperties(qvtiAnalyzer, cgCacheClass, asFunction);
		createCacheOperations(qvtiAnalyzer, cgCacheClass, asFunction);
		CGClass cgSuperClass = qvtiAnalyzer.generateClassDeclaration(asSuperClass, getClassCallingConvention());
		cgCacheClass.getSuperTypes().add(cgSuperClass);
	}

	protected void createCacheOperations(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull Function asFunction) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		installCacheConstructor(qvtiAnalyzer, cgCacheClass, asFunction);
		installCacheGetResultOperation(qvtiAnalyzer, cgCacheClass, asFunction);
		installCacheIsEqualOperation(qvtiAnalyzer, cgCacheClass, asFunction);
	}

	protected void createCacheProperties(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull Operation asOperation) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		ImperativeTransformation asTransformation = codeGenerator.getTransformation();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		NameResolution cachedResultNameResolution = globalNameManager.getCachedResultNameResolution();
		NameResolution thisTransformerNameResolution = globalNameManager.getThisTransformerNameResolution();
		installCacheProperty(qvtiAnalyzer, cgCacheClass, thisTransformerNameResolution, asTransformation);
		for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asOperation)) {
			installCacheProperty(qvtiAnalyzer, cgCacheClass, null, asParameter);
			// XXX need to support a cached invalid
		}
		installCacheProperty(qvtiAnalyzer, cgCacheClass, cachedResultNameResolution, asOperation);
	}

	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
		// TODO Auto-generated method stub
		return true; //super.generateJavaDeclaration(cg2javaVisitor, js, cgOperation);
	}

	protected @NonNull CGProperty getCGCacheProperty(@NonNull CGClass cgCacheClass, @NonNull String name) {
		for (@NonNull CGProperty cgProperty : CGUtil.getProperties(cgCacheClass)) {
			Property asProperty = CGUtil.getAST(cgProperty);
			if (name.equals(asProperty.getName())) {
				return cgProperty;
			}
		}
		throw new IllegalStateException();
	}

	protected @NonNull CGOperation installCacheConstructor(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass,
			@NonNull Operation asOperation) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		EnvironmentFactory environmentFactory = codeGenerator.getEnvironmentFactory();
		//	QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		//	PivotHelper helper = new PivotHelper(environmentFactory);
		//
		NameResolution ctorNameResolution = cgCacheClass.getNameResolution();
		String ctorName = ctorNameResolution.getResolvedName();
		//		String cachedResultName = globalNameManager.getCachedResultNameResolution().getResolvedName();
		//		CGProperty cgCacheProperty = getCGCacheProperty(cgCacheClass, cachedResultName);
		//		Property asCacheProperty = CGUtil.getAST(cgCacheProperty);
		//		Type asCacheType = PivotUtil.getType(asCacheProperty);
		Type asCacheType = environmentFactory.getStandardLibrary().getOclVoidType();
		//		boolean isRequired = cgCacheProperty.isRequired();
		//
		org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
		Operation asCacheOperation = PivotUtil.createOperation(ctorName, asCacheType, /*CacheOperation.class*/null, null); //asExpression);
		Parameter asBoundValuesParameter = createBoundValuesParameter(codeGenerator);
		asCacheOperation.getOwnedParameters().add(asBoundValuesParameter);
		//		asCacheOperation.setIsRequired(isRequired);
		List<@NonNull Operation> asCacheOperations = PivotUtilInternal.getOwnedOperationsList(asCacheClass);
		asCacheOperations.add(asCacheOperation);
		//
		ConstructorOperationCallingConvention callingConvention = ConstructorOperationCallingConvention.INSTANCE;
		//	CGParameter thisTransformerParameter = nameManager.getThisTransformerParameter();
		CGTypeId cgTypeId = analyzer.getCGTypeId(TypeId.OCL_VOID);
		//
		CGOperation cgConstructor = callingConvention.createCGOperation(qvtiAnalyzer, asCacheOperation);
		cgConstructor.setCallingConvention(callingConvention);
		qvtiAnalyzer.initAst(cgConstructor, asCacheOperation, true);
		//	cgConstructor.setAst(asCacheOperation);
		//	cgCacheOperation.setTypeId(cgTypeId);
		//	cgCacheOperation.setRequired(isRequired);
		//	analyzer.addCGOperation(cgCacheOperation);
		ctorNameResolution.addCGElement(cgConstructor);
		QVTiExecutableNameManager nameManager = qvtiAnalyzer.getOperationNameManager(null, asCacheOperation);
		callingConvention.createCGParameters(nameManager, null);

		CGParameter cgThisParameter = nameManager.getThisParameter();
		List<@NonNull CGParameter> cgParameters = CGUtil.getParametersList(cgConstructor);
		List<@NonNull CGProperty> cgProperties = CGUtil.getPropertiesList(cgCacheClass);
		CGSequence cgSequence = QVTiCGModelFactory.eINSTANCE.createCGSequence();
		List<@NonNull CGValuedElement> cgStatements = QVTiCGUtil.getOwnedStatementsList(cgSequence);
		//
		//	Assign thisTransformer
		/*
		{
			CGParameter cgParameter = cgParameters.get(0);
			CGProperty cgProperty = cgProperties.get(0);
			Element asProperty = cgProperty.getAst();
			CGPropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGPropertyAssignment();
			cgPropertyAssignment.setAst(asProperty);
			cgPropertyAssignment.setTypeId(cgTypeId);
			cgPropertyAssignment.setOwnedSlotValue(analyzer.createCGVariableExp(cgThisParameter));
			cgPropertyAssignment.setReferredProperty(cgProperty);
			cgPropertyAssignment.setOwnedInitValue(analyzer.createCGVariableExp(cgParameter));
			//	cgPropertyAssignment.setAsProperty(asProperty);
			cgStatements.add(cgPropertyAssignment);
		} */
		//
		//	Unpack and assign boundValues
		//
		CGParameter cgParameter = cgParameters.get(0);
		for (int i = 0; i < cgProperties.size()-1; i++) {	// XXX not cachedResult
			CGVariableExp cgVariableExp = analyzer.createCGVariableExp(cgParameter);
			CGIndexExp cgIndexExp = analyzer.createCGIndexExp(cgVariableExp, i);
			cgIndexExp.setAst(cgParameter.getAst());
			CGProperty cgProperty = cgProperties.get(i);
			Element asProperty = cgProperty.getAst();
			CGPropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGPropertyAssignment();
			cgPropertyAssignment.setAst(asProperty);
			cgPropertyAssignment.setTypeId(cgTypeId);
			cgPropertyAssignment.setOwnedSlotValue(analyzer.createCGVariableExp(cgThisParameter));
			cgPropertyAssignment.setReferredProperty(cgProperty);
			cgPropertyAssignment.setOwnedInitValue(cgIndexExp);
			//	cgPropertyAssignment.setAsProperty(asProperty);
			cgStatements.add(cgPropertyAssignment);
		}
		//
		//	Assign cachedResult
		//
		{
			LanguageExpression asExpression = asOperation.getBodyExpression();
			assert asExpression != null;
			CGValuedElement asValue = qvtiAnalyzer.createCGElement(CGValuedElement.class, asExpression);
			CGProperty cgProperty = cgProperties.get(cgProperties.size()-1);
			Element asProperty = cgProperty.getAst();
			CGPropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGPropertyAssignment();
			cgPropertyAssignment.setAst(asProperty);
			cgPropertyAssignment.setTypeId(cgTypeId);
			cgPropertyAssignment.setOwnedSlotValue(analyzer.createCGVariableExp(cgThisParameter));
			cgPropertyAssignment.setReferredProperty(cgProperty);
			cgPropertyAssignment.setOwnedInitValue(asValue);
			//	cgPropertyAssignment.setAsProperty(asProperty);
			cgStatements.add(cgPropertyAssignment);
			cgConstructor.setBody(cgSequence);
		}
		//
		List<@NonNull CGOperation> cgCacheOperations = CGUtil.getOperationsList(cgCacheClass);
		cgCacheOperations.add(cgConstructor);
		//
		//	globalNameManager.createNestedNameManager(nameManager, cgConstructor);
		return cgConstructor;
	}

	protected @NonNull CGOperation installCacheGetResultOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass,
			@NonNull Operation asOperation) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		//
		NameResolution getResultNameResolution = globalNameManager.getGetResultNameResolution();
		String getResultName = getResultNameResolution.getResolvedName();
		String cachedResultName = globalNameManager.getCachedResultNameResolution().getResolvedName();
		CGProperty cgCacheProperty = getCGCacheProperty(cgCacheClass, cachedResultName);
		Property asCacheProperty = CGUtil.getAST(cgCacheProperty);
		Type asCacheType = PivotUtil.getType(asCacheProperty);
		boolean isRequired = cgCacheProperty.isRequired();
		//
		org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
		Operation asCacheOperation = PivotUtil.createOperation(getResultName, asCacheType, /*CacheOperation.class*/null, null); //asExpression);
		asCacheOperation.setIsRequired(isRequired);
		List<@NonNull Operation> asCacheOperations = PivotUtilInternal.getOwnedOperationsList(asCacheClass);
		asCacheOperations.add(asCacheOperation);
		//
		QVTiExecutableNameManager nameManager = qvtiAnalyzer.getOperationNameManager(null, asCacheOperation);
		CacheOperationCallingConvention callingConvention = CacheOperationCallingConvention.INSTANCE;
		CGTypeId cgTypeId = cgCacheProperty.getTypeId();

		CGParameter cgThisParameter = nameManager.getThisParameter();
		CGVariableExp cgThis = analyzer.createCGVariableExp(cgThisParameter);
		CGPropertyCallExp cgPropertyCallExp = new CachePropertyCallExpImpl();
		cgPropertyCallExp.setSource(cgThis);
		cgPropertyCallExp.setAsProperty(asCacheProperty);
		cgPropertyCallExp.setReferredProperty(cgCacheProperty);
		cgPropertyCallExp.setTypeId(cgTypeId);
		cgPropertyCallExp.setRequired(isRequired);
		//
		CGOperation cgCacheOperation = callingConvention.createCGOperation(qvtiAnalyzer, asCacheOperation);
		cgCacheOperation.setAst(asCacheOperation);
		cgCacheOperation.setTypeId(cgTypeId);
		cgCacheOperation.setRequired(isRequired);
		cgCacheOperation.setCallingConvention(callingConvention);
		//	analyzer.addCGOperation(cgCacheOperation);
		cgCacheOperation.setBody(cgPropertyCallExp);
		getResultNameResolution.addCGElement(cgCacheOperation);
		//
		List<@NonNull CGOperation> cgCacheOperations = CGUtil.getOperationsList(cgCacheClass);
		cgCacheOperations.add(cgCacheOperation);
		//
		//	globalNameManager.createNestedNameManager(nameManager, cgCacheOperation);
		return cgCacheOperation;
	}

	protected @NonNull CGOperation installCacheIsEqualOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass,
			@NonNull Operation asOperation) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		EnvironmentFactory environmentFactory = codeGenerator.getEnvironmentFactory();
		//
		NameResolution isEqualNameResolution = globalNameManager.getIsEqualNameResolution();
		String isEqualName = isEqualNameResolution.getResolvedName();
		//	String cachedResultName = globalNameManager.getCachedResultNameResolution().getResolvedName();
		//	CGProperty cgCacheProperty = getCGCacheProperty(cgCacheClass, cachedResultName);
		//	Property asCacheProperty = CGUtil.getAST(cgCacheProperty);
		//	Type asCacheType = PivotUtil.getType(asCacheProperty);
		Type asReturnType = environmentFactory.getStandardLibrary().getBooleanType();
		//	boolean isRequired = cgCacheProperty.isRequired();
		//
		org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
		Operation asCacheOperation = PivotUtil.createOperation(isEqualName, asReturnType, /*CacheOperation.class*/null, null); //asExpression);
		asCacheOperation.setIsRequired(true);
		List<@NonNull Parameter> asCacheParameters = PivotUtilInternal.getOwnedParametersList(asCacheOperation);

		Parameter asBoundValuesParameter = createBoundValuesParameter(codeGenerator);
		asCacheParameters.add(asBoundValuesParameter);

		List<@NonNull Operation> asCacheOperations = PivotUtilInternal.getOwnedOperationsList(asCacheClass);
		asCacheOperations.add(asCacheOperation);
		//
		/*	CGTypeId cgTypeId = cgCacheProperty.getTypeId();

		CGParameter cgThisParameter = nameManager.getThisParameter();
		CGVariableExp cgThis = analyzer.createCGVariableExp(cgThisParameter);
		CGPropertyCallExp cgPropertyCallExp = new CachePropertyCallExpImpl();
		cgPropertyCallExp.setSource(cgThis);
		cgPropertyCallExp.setAsProperty(asCacheProperty);
		cgPropertyCallExp.setReferredProperty(cgCacheProperty);
		cgPropertyCallExp.setTypeId(cgTypeId);
		cgPropertyCallExp.setRequired(isRequired); */
		//
		CacheOperationCallingConvention callingConvention = CacheOperationCallingConvention.INSTANCE;
		CGOperation cgCacheOperation = callingConvention.createCGOperation(qvtiAnalyzer, asCacheOperation);
		analyzer.initAst(cgCacheOperation, asCacheOperation, true);
		cgCacheOperation.setCallingConvention(callingConvention);
		cgCacheOperation.setBody(analyzer.createCGBoolean(true));
		isEqualNameResolution.addCGElement(cgCacheOperation);

		QVTiExecutableNameManager operationNameManager = qvtiAnalyzer.getOperationNameManager(null, asCacheOperation);
		List<CGParameter> cgCacheParameters = cgCacheOperation.getParameters();
		cgCacheParameters.add(operationNameManager.getIdResolverParameter());
		//	callingConvention.createCGParameters(nameManager, null);
		for (@NonNull Parameter asParameterVariable : asCacheParameters) {
			CGParameter cgParameter = operationNameManager.getParameter(asParameterVariable, (String)null);
			cgCacheParameters.add(cgParameter);
		}
		//
		List<@NonNull CGOperation> cgCacheOperations = CGUtil.getOperationsList(cgCacheClass);
		cgCacheOperations.add(cgCacheOperation);
		//
		//	ExecutableNameManager operationNameManager = analyzer.getOperationNameManager(cgCacheOperation, asCacheOperation);	// Needed to support downstream useOperationNameManager()
		//	operationNameManager.getIdResolverVariable();
		//	globalNameManager.createNestedNameManager(nameManager, cgCacheOperation);
		return cgCacheOperation;



		/*	CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();
		CacheOperationCallingConvention callingConvention = CacheOperationCallingConvention.INSTANCE;
		NestedNameManager nameManager = as2cgVisitor.getNameManager();
		//	CGParameter thisParameter = nameManager.getThisParameter();
		//	CGTypeId cgTypeId = analyzer.getCGTypeId(TypeId.OCL_VOID);
		//
		//	nameManager.createCGVariable(null)

		CGOperation cgOperation = callingConvention.createCGOperation(as2cgVisitor, NULL_OPERATION);
		cgOperation.setTypeId(analyzer.getCGTypeId(TypeId.BOOLEAN));
		cgOperation.setRequired(true);
		cgOperation.setCallingConvention(callingConvention);
		nameManager.getGlobalNameManager().getIsEqualNameResolution().addCGElement(cgOperation);
		//
		CGSequence cgSequence = QVTiCGModelFactory.eINSTANCE.createCGSequence();
		List<@NonNull CGValuedElement> cgStatements = QVTiCGUtil.getOwnedStatementsList(cgSequence);
		//	analyzer.createCGNativePropertyCallExp(cgClass.getProperties().get(3)));
		//	cgOperation.setBody(analyzer.createCGVariableExp(cgClass.getProperties().get(3)));
		as2cgVisitor.pushNestedNameManager(cgOperation);
		as2cgVisitor.popNestedNameManager();
		asCacheOperations.add(asCacheOperation);
		return asCacheOperation; */
	}

	protected void installCacheProperty(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass,
			@Nullable NameResolution nameResolution, @NonNull NamedElement asTypeOrTypedElement) {
		org.eclipse.ocl.pivot.Class asCacheClass = CGUtil.getAST(cgCacheClass);
		//
		Property asCacheProperty = PivotFactory.eINSTANCE.createProperty();
		asCacheProperty.setName(nameResolution != null ? nameResolution.getResolvedName() : asTypeOrTypedElement.getName());
		if (asTypeOrTypedElement instanceof Type) {
			asCacheProperty.setType((Type)asTypeOrTypedElement);
			asCacheProperty.setIsRequired(true);
		}
		else if (asTypeOrTypedElement instanceof TypedElement) {
			TypedElement asTypedElement = (TypedElement)asTypeOrTypedElement;
			asCacheProperty.setType(PivotUtil.getType(asTypedElement));
			asCacheProperty.setIsRequired(asTypedElement.isIsRequired());
		}
		else {
			throw new IllegalStateException();
		}
		asCacheClass.getOwnedProperties().add(asCacheProperty);
		asCacheProperty.setImplementation(new CacheProperty(asCacheProperty.getPropertyId(), null, null));
		//
		CGProperty cgCacheProperty = analyzer.generatePropertyDeclaration(asCacheProperty, ImmutableCachePropertyCallingConvention.INSTANCE);
		if (nameResolution != null) {
			nameResolution.addCGElement(cgCacheProperty);
		}
		cgCacheClass.getProperties().add(cgCacheProperty);
	}
}
