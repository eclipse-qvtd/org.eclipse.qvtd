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
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.CacheClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.ImmutableCachePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.OperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.PropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPropertyCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGTuplePartCallExpImpl;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.naming.NestedNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.ocl.pivot.utilities.LanguageSupport;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;

/**
 *  InternalFunctionOperationCallingConvention defines the support for the call of a QVTi function implemented by an OCL expression.
 *
 *  The implementation uses a class whose instance caches a result to ensure unique shared execution.
 */
public class InternalFunctionOperationCallingConvention extends FunctionOperationCallingConvention // cg Cached/Constrained
{
	public static final @NonNull InternalFunctionOperationCallingConvention INSTANCE = new InternalFunctionOperationCallingConvention();

	protected static class CachePropertyCallExpImpl extends CGTuplePartCallExpImpl		// XXX move to CG model
	{
		@Override
		public boolean isInlined() {
			return true;
		}
	}

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

	@Override
	public void createCGBody(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation) {
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		OCLExpression query = asFunction.getQueryExpression(); //getBodyExpression();
		assert asFunction.getImplementationClass() == null;
		assert query != null;
		super.createCGBody(analyzer, cgFunction);
	}

	/*	protected @NonNull CGOperation createCGCacheOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();
		OperationCallingConvention operationCallingConvention = ImmutableCachePropertyCallingConvention.INSTANCE;
		CGOperation cgOperation = operationCallingConvention.createCGOperation(analyzer, asOperation);
		cgOperation.setAst(asOperation);
		cgOperation.setTypeId(analyzer.getCGTypeId(asOperation.getTypeId()));
		cgOperation.setRequired(asOperation.isIsRequired());
		cgOperation.setCallingConvention(operationCallingConvention);
		//	analyzer.addCGProperty(cgProperty);
		as2cgVisitor.pushNestedNameManager(cgOperation);
		as2cgVisitor.popNestedNameManager();
		return cgOperation;
	} */

	@Override
	public @NonNull CGFunction createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		//	assert asOperation.getImplementation() == null;		-- maybe ConstrainedOperation
		assert asOperation.getImplementationClass() == null;
		CGFunction cgFunction = QVTiCGModelFactory.eINSTANCE.createCGFunction();
		initOperation(analyzer, cgFunction, asOperation);
		analyzer.addCGOperation(cgFunction);

		//	as2cgVisitor.generateClassDeclaration(asOperation, CacheClassCallingConvention.INSTANCE);
		//	CacheClassCallingConvention.INSTANCE.createCGClass(null)
		//	CGClass cgCacheClass = analyzer.createNestedCGClass(as2cgVisitor, asOperation, CacheClassCallingConvention.INSTANCE);
		//	createCGProperties(as2cgVisitor, cgCacheClass, asOperation);
		//	createCGConstructor(as2cgVisitor, cgCacheClass, asOperation);
		return cgFunction;
	}

	@Override
	public @NonNull CGValuedElement createCGOperationCallExp(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation, @NonNull LibraryOperation libraryOperation,
			@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		assert cgSource != null;
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		CGFunction cgFunction = (CGFunction)cgOperation;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		assert codeGenerator.getShadowExp(asFunction) == null;
		CGFunctionCallExp cgFunctionCallExp = QVTiCGModelFactory.eINSTANCE.createCGFunctionCallExp();
		initCallExp(qvtiAnalyzer, cgFunctionCallExp, asOperationCallExp, cgOperation, asFunction.isIsRequired());
		cgFunctionCallExp.getArguments().add(cgSource);
		initCallArguments(qvtiAnalyzer, cgFunctionCallExp);
		return cgFunctionCallExp;
	}

	@Override
	public void createCGParameters(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgOperation, @Nullable ExpressionInOCL bodyExpression) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		assert codeGenerator.getShadowExp(asFunction) == null;
		QVTiFeatureNameManager operationNameManager = qvtiAnalyzer.getOperationNameManager(cgOperation, asFunction);
		//
		List<@NonNull CGParameter> cgParameters = CGUtil.getParametersList(cgFunction);
		cgParameters.add(operationNameManager.getThisTransformerParameter());			// Include "this" as part of the uniqueness Tuple.
		for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asFunction)) {
			CGParameter cgParameter = qvtiAnalyzer.createCGElement(CGParameter.class, asParameter);
			cgParameters.add(cgParameter);
		}
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		assert jLanguageSupport != null;
		org.eclipse.ocl.pivot.Class asCacheClass = jLanguageSupport.getCacheClass(asFunction);
		org.eclipse.ocl.pivot.Class asSuperClass = jLanguageSupport.getNativeClass(AbstractComputation.class);
		asCacheClass.getSuperClasses().add(asSuperClass);
		//
		CGClass cgCacheClass = qvtiAnalyzer.generateClassDeclaration(asCacheClass, CacheClassCallingConvention.INSTANCE);
		//		CGClass cgCacheClass = analyzer.createNestedCGClass(qvtiAnalyzer, asCacheClass, CacheClassCallingConvention.INSTANCE);
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
		org.eclipse.ocl.pivot.Class asCacheClass = CGUtil.getAST(cgCacheClass);
		List<@NonNull Property> asCacheProperties = PivotUtilInternal.getOwnedPropertiesList(asCacheClass);
		List<@NonNull CGProperty> cgCacheProperties = CGUtil.getPropertiesList(cgCacheClass);
		Property asCacheProperty = installCacheTransformerProperty(qvtiAnalyzer, asCacheProperties);
		installCGCacheProperty(qvtiAnalyzer, cgCacheProperties, asCacheProperty, ImmutableCachePropertyCallingConvention.INSTANCE);
		for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asOperation)) {
			asCacheProperty = installCacheParameterProperty(qvtiAnalyzer, asCacheProperties, asParameter);
			installCGCacheProperty(qvtiAnalyzer, cgCacheProperties, asCacheProperty, ImmutableCachePropertyCallingConvention.INSTANCE);
		}
		asCacheProperty = installCacheResultProperty(qvtiAnalyzer, asCacheProperties, asOperation);
		installCGCacheProperty(qvtiAnalyzer, cgCacheProperties, asCacheProperty, ImmutableCachePropertyCallingConvention.INSTANCE);
	}

	@Override
	public boolean generateJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperationCallExp cgOperationCallExp) {
		return super.generateJavaCall(cg2javaVisitor, js, cgOperationCallExp);
	}

	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
		return super.generateJavaDeclaration(cg2javaVisitor, js, cgOperation);
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

	protected @NonNull CGOperation installCGCacheOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull List<@NonNull CGOperation> cgCacheOperations,
			@NonNull Operation asCacheOperation, @NonNull OperationCallingConvention callingConvention) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		//
		TypeId asTypeId = asCacheOperation.getTypeId();
		LanguageExpression asExpression = asCacheOperation.getBodyExpression();
		//
		CGOperation cgCacheOperation = callingConvention.createCGOperation(qvtiAnalyzer, asCacheOperation);
		cgCacheOperation.setAst(asCacheOperation);
		cgCacheOperation.setTypeId(analyzer.getCGTypeId(asTypeId));
		cgCacheOperation.setRequired(asCacheOperation.isIsRequired());
		cgCacheOperation.setCallingConvention(callingConvention);
		//	analyzer.addCGOperation(cgCacheOperation);
		cgCacheOperation.setBody(qvtiAnalyzer.createCGElement(CGValuedElement.class, asExpression));
		cgCacheOperations.add(cgCacheOperation);
		//	NestedNameManager nameManager = qvtiAnalyzer.getNameManager();
		//	nameManager.getGlobalNameManager().createNestedNameManager(nameManager, cgCacheOperation);
		return cgCacheOperation;
	}

	protected @NonNull CGProperty installCGCacheProperty(@NonNull CodeGenAnalyzer analyzer, @NonNull List<@NonNull CGProperty> cgCacheProperties,
			@NonNull Property asCacheProperty, @NonNull PropertyCallingConvention callingConvention) {
		//	CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();
		//
		asCacheProperty.setImplementation(new CacheProperty(asCacheProperty.getPropertyId(), null, null));
		//
		CGProperty cgCacheProperty = analyzer.generatePropertyDeclaration(asCacheProperty, callingConvention);
		cgCacheProperties.add(cgCacheProperty);
		return cgCacheProperty;
	}

	protected @NonNull CGOperation installCacheConstructor(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass,
			@NonNull Operation asOperation) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		//
		NameResolution ctorNameResolution = cgCacheClass.getNameResolution();
		String ctorName = ctorNameResolution.getResolvedName();
		//		String cachedResultName = globalNameManager.getCachedResultNameResolution().getResolvedName();
		//		CGProperty cgCacheProperty = getCGCacheProperty(cgCacheClass, cachedResultName);
		//		Property asCacheProperty = CGUtil.getAST(cgCacheProperty);
		//		Type asCacheType = PivotUtil.getType(asCacheProperty);
		Type asCacheType = codeGenerator.getEnvironmentFactory().getStandardLibrary().getOclVoidType();
		//		boolean isRequired = cgCacheProperty.isRequired();
		//
		org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
		Operation asCacheOperation = PivotUtil.createOperation(ctorName, asCacheType, /*CacheOperation.class*/null, null); //asExpression);
		//		asCacheOperation.setIsRequired(isRequired);
		List<@NonNull Operation> asCacheOperations = PivotUtilInternal.getOwnedOperationsList(asCacheClass);
		asCacheOperations.add(asCacheOperation);
		//
		QVTiFeatureNameManager nameManager = qvtiAnalyzer.getOperationNameManager(null, asOperation);
		ConstructorOperationCallingConvention callingConvention = ConstructorOperationCallingConvention.INSTANCE;
		CGParameter thisTransformerParameter = nameManager.getThisTransformerParameter();
		CGTypeId cgTypeId = analyzer.getCGTypeId(TypeId.OCL_VOID);
		//
		CGOperation cgConstructor = callingConvention.createCGOperation(qvtiAnalyzer, asOperation);
		cgConstructor.setAst(asCacheOperation);
		//	cgCacheOperation.setTypeId(cgTypeId);
		//	cgCacheOperation.setRequired(isRequired);
		cgConstructor.setCallingConvention(callingConvention);
		//	analyzer.addCGOperation(cgCacheOperation);
		ctorNameResolution.addCGElement(cgConstructor);
		callingConvention.createCGParameters(qvtiAnalyzer, cgConstructor, null);

		CGParameter cgThisParameter = nameManager.getThisParameter();
		CGSequence cgSequence = QVTiCGModelFactory.eINSTANCE.createCGSequence();
		List<@NonNull CGValuedElement> cgStatements = QVTiCGUtil.getOwnedStatementsList(cgSequence);
		List<@NonNull CGParameter> cgParameters = CGUtil.getParametersList(cgConstructor);
		List<@NonNull CGProperty> cgProperties = CGUtil.getPropertiesList(cgCacheClass);
		int iMax = cgParameters.size();
		assert iMax == cgProperties.size()-1;	// XXX
		for (int i = 0; i < iMax; i++) {
			CGParameter cgParameter = cgParameters.get(i);
			CGProperty cgProperty = cgProperties.get(i);
			Element asProperty = cgProperty.getAst();
			CGPropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGPropertyAssignment();
			cgPropertyAssignment.setAst(asProperty);
			cgPropertyAssignment.setTypeId(cgTypeId);
			cgPropertyAssignment.setOwnedSlotValue(analyzer.createCGVariableExp(cgThisParameter));
			cgPropertyAssignment.setReferredProperty(cgProperty);
			cgPropertyAssignment.setOwnedInitValue(analyzer.createCGVariableExp(cgParameter));
			//	cgPropertyAssignment.setAsProperty(asProperty);
			cgStatements.add(cgPropertyAssignment);
		}
		LanguageExpression asExpression = asOperation.getBodyExpression();
		assert asExpression != null;
		CGValuedElement asValue = qvtiAnalyzer.createCGElement(CGValuedElement.class, asExpression);
		CGProperty cgProperty = cgProperties.get(iMax);
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
		QVTiFeatureNameManager nameManager = qvtiAnalyzer.getOperationNameManager(null, asCacheOperation);
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
		//
		NameResolution getResultNameResolution = globalNameManager.getGetResultNameResolution();
		String getResultName = getResultNameResolution.getResolvedName();
		//	String cachedResultName = globalNameManager.getCachedResultNameResolution().getResolvedName();
		//	CGProperty cgCacheProperty = getCGCacheProperty(cgCacheClass, cachedResultName);
		//	Property asCacheProperty = CGUtil.getAST(cgCacheProperty);
		//	Type asCacheType = PivotUtil.getType(asCacheProperty);
		Type asReturnType = codeGenerator.getEnvironmentFactory().getStandardLibrary().getBooleanType();
		//	boolean isRequired = cgCacheProperty.isRequired();
		//
		org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
		Operation asCacheOperation = PivotUtil.createOperation(getResultName, asReturnType, /*CacheOperation.class*/null, null); //asExpression);
		asCacheOperation.setIsRequired(true);
		List<@NonNull Operation> asCacheOperations = PivotUtilInternal.getOwnedOperationsList(asCacheClass);
		asCacheOperations.add(asCacheOperation);
		//
		NestedNameManager nameManager = qvtiAnalyzer.getNameManager();
		CacheOperationCallingConvention callingConvention = CacheOperationCallingConvention.INSTANCE;
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
		CGOperation cgCacheOperation = callingConvention.createCGOperation(qvtiAnalyzer, asCacheOperation);
		cgCacheOperation.setAst(asCacheOperation);
		cgCacheOperation.setTypeId(analyzer.getCGTypeId(asReturnType.getTypeId()));
		cgCacheOperation.setRequired(true);
		cgCacheOperation.setCallingConvention(callingConvention);
		//	analyzer.addCGOperation(cgCacheOperation);
		cgCacheOperation.setBody(analyzer.getCGBoolean(true));
		getResultNameResolution.addCGElement(cgCacheOperation);
		//
		List<@NonNull CGOperation> cgCacheOperations = CGUtil.getOperationsList(cgCacheClass);
		cgCacheOperations.add(cgCacheOperation);
		//
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

	protected @NonNull Property installCacheParameterProperty(@NonNull CodeGenAnalyzer analyzer, @NonNull List<@NonNull Property> asCacheProperties, @NonNull Parameter asParameter) {
		Property asCacheProperty = PivotFactory.eINSTANCE.createProperty();
		asCacheProperty.setName(asParameter.getName());
		asCacheProperty.setType(asParameter.getType());
		asCacheProperty.setIsRequired(asParameter.isIsRequired());
		asCacheProperties.add(asCacheProperty);
		return asCacheProperty;
	}

	protected @NonNull Property installCacheResultProperty(@NonNull CodeGenAnalyzer analyzer, @NonNull List<@NonNull Property> asCacheProperties, @NonNull Operation asOperation) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		NameResolution cachedResultName = codeGenerator.getGlobalNameManager().getCachedResultNameResolution();
		//
		Property asCacheProperty = PivotFactory.eINSTANCE.createProperty();
		asCacheProperty.setName(cachedResultName.getResolvedName());
		asCacheProperty.setType(asOperation.getType());
		asCacheProperty.setIsRequired(asOperation.isIsRequired());
		asCacheProperties.add(asCacheProperty);
		return asCacheProperty;
	}

	protected @NonNull Property installCacheTransformerProperty(@NonNull CodeGenAnalyzer analyzer, @NonNull List<@NonNull Property> asCacheProperties) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		NameResolution thisTransformerNameResolution = codeGenerator.getGlobalNameManager().getThisTransformerNameResolution();
		ImperativeTransformation asTransformation = codeGenerator.getTransformation();
		//
		Property asCacheProperty = PivotFactory.eINSTANCE.createProperty();
		asCacheProperty.setName(thisTransformerNameResolution.getResolvedName());
		asCacheProperty.setType(asTransformation);
		asCacheProperty.setIsRequired(true);
		asCacheProperties.add(asCacheProperty);
		return asCacheProperty;
	}

	@Override
	public void rewriteWithBoxingAndGuards(@NonNull BoxingAnalyzer boxingAnalyzer, @NonNull CGOperation cgOperation) {
		super.rewriteWithBoxingAndGuards(boxingAnalyzer, cgOperation);
		CGValuedElement cgBody = CGUtil.getBody(cgOperation);
		boxingAnalyzer.rewriteAsBoxed(cgBody);
	}

	@Override
	public void rewriteWithBoxingAndGuards(@NonNull BoxingAnalyzer boxingAnalyzer,@NonNull CGOperationCallExp cgOperationCallExp) {
		for (@NonNull CGValuedElement cgArgument : CGUtil.getArguments(cgOperationCallExp)) {
			boxingAnalyzer.rewriteAsBoxed(cgArgument);
		}
	}
}
