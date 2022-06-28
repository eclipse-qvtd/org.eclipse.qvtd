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
import org.eclipse.ocl.examples.codegen.analyzer.AS2CGVisitor;
import org.eclipse.ocl.examples.codegen.analyzer.BoxingAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.analyzer.NameResolution;
import org.eclipse.ocl.examples.codegen.analyzer.NestedNameManager;
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
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAS2CGVisitor;
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
	public void createCGBody(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGOperation cgOperation) {
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		OCLExpression query = asFunction.getQueryExpression(); //getBodyExpression();
		assert asFunction.getImplementationClass() == null;
		assert query != null;
		super.createCGBody(as2cgVisitor, cgFunction);
	}

	/*	protected @NonNull CGOperation createCGCacheOperation(@NonNull AS2CGVisitor as2cgVisitor, @NonNull Operation asOperation) {
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
	public @NonNull CGFunction createCGOperation(@NonNull AS2CGVisitor as2cgVisitor, @NonNull Operation asOperation) {
		CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();
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
	public @NonNull CGFunction createCGOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull CGValuedElement createCGOperationCallExp(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGOperation cgOperation, @NonNull LibraryOperation libraryOperation,
			@Nullable CGValuedElement cgSource, @NonNull OperationCallExp asOperationCallExp) {
		assert cgSource != null;
		QVTiAS2CGVisitor qvtias2cgVisitor = (QVTiAS2CGVisitor)as2cgVisitor;
		CGFunction cgFunction = (CGFunction)cgOperation;
		QVTiCodeGenerator codeGenerator = qvtias2cgVisitor.getCodeGenerator();
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		assert codeGenerator.getShadowExp(asFunction) == null;
		CGFunctionCallExp cgFunctionCallExp = QVTiCGModelFactory.eINSTANCE.createCGFunctionCallExp();
		initCallExp(as2cgVisitor, cgFunctionCallExp, asOperationCallExp, cgOperation, asFunction.isIsRequired());
		cgFunctionCallExp.getArguments().add(cgSource);
		initCallArguments(as2cgVisitor, cgFunctionCallExp);
		return cgFunctionCallExp;
	}

	@Override
	public void createCGParameters(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGOperation cgOperation, @Nullable ExpressionInOCL bodyExpression) {
		QVTiAS2CGVisitor qvtias2cgVisitor = (QVTiAS2CGVisitor)as2cgVisitor;
		CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();
		QVTiCodeGenerator codeGenerator = qvtias2cgVisitor.getCodeGenerator();
		CGFunction cgFunction = (CGFunction)cgOperation;
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		assert codeGenerator.getShadowExp(asFunction) == null;
		QVTiNestedNameManager nameManager = qvtias2cgVisitor.getNameManager();
		//
		List<@NonNull CGParameter> cgParameters = CGUtil.getParametersList(cgFunction);
		cgParameters.add(nameManager.getThisTransformerParameter());			// Include "this" as part of the uniqueness Tuple.
		for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asFunction)) {
			CGParameter cgParameter = as2cgVisitor.doVisit(CGParameter.class, asParameter);
			cgParameters.add(cgParameter);
		}
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		assert jLanguageSupport != null;
		org.eclipse.ocl.pivot.Class asCacheClass = jLanguageSupport.getCacheClass(asFunction);
		org.eclipse.ocl.pivot.Class asSuperClass = jLanguageSupport.getNativeClass(AbstractComputation.class);
		asCacheClass.getSuperClasses().add(asSuperClass);
		//
		CGClass cgCacheClass = analyzer.createNestedCGClass(as2cgVisitor, asCacheClass, CacheClassCallingConvention.INSTANCE);
		as2cgVisitor.pushClassNameManager(cgCacheClass);
		createCacheProperties(as2cgVisitor, cgCacheClass, asFunction);
		createCacheOperations(as2cgVisitor, cgCacheClass, asFunction);
		CGClass cgSuperClass = as2cgVisitor.generateClassDeclaration(asSuperClass, getClassCallingConvention());
		cgCacheClass.getSuperTypes().add(cgSuperClass);
		as2cgVisitor.popClassNameManager();
	}


	protected void createCacheOperations(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGClass cgCacheClass, @NonNull Function asFunction) {
		installCacheConstructor(as2cgVisitor, cgCacheClass, asFunction);
		installCacheGetResultOperation(as2cgVisitor, cgCacheClass, asFunction);
		installCacheIsEqualOperation(as2cgVisitor, cgCacheClass, asFunction);
	}

	protected void createCacheProperties(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGClass cgCacheClass, @NonNull Operation asOperation) {
		org.eclipse.ocl.pivot.Class asCacheClass = CGUtil.getAST(cgCacheClass);
		List<@NonNull Property> asCacheProperties = PivotUtilInternal.getOwnedPropertiesList(asCacheClass);
		List<@NonNull CGProperty> cgCacheProperties = CGUtil.getPropertiesList(cgCacheClass);
		Property asCacheProperty = installCacheTransformerProperty(as2cgVisitor, asCacheProperties);
		installCGCacheProperty(as2cgVisitor, cgCacheProperties, asCacheProperty, ImmutableCachePropertyCallingConvention.INSTANCE);
		for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asOperation)) {
			asCacheProperty = installCacheParameterProperty(as2cgVisitor, asCacheProperties, asParameter);
			installCGCacheProperty(as2cgVisitor, cgCacheProperties, asCacheProperty, ImmutableCachePropertyCallingConvention.INSTANCE);
		}
		asCacheProperty = installCacheResultProperty(as2cgVisitor, asCacheProperties, asOperation);
		installCGCacheProperty(as2cgVisitor, cgCacheProperties, asCacheProperty, ImmutableCachePropertyCallingConvention.INSTANCE);
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

	protected @NonNull CGOperation installCGCacheOperation(@NonNull AS2CGVisitor as2cgVisitor, @NonNull List<@NonNull CGOperation> cgCacheOperations,
			@NonNull Operation asCacheOperation, @NonNull OperationCallingConvention callingConvention) {
		CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();
		//
		TypeId asTypeId = asCacheOperation.getTypeId();
		LanguageExpression asExpression = asCacheOperation.getBodyExpression();
		//
		CGOperation cgCacheOperation = callingConvention.createCGOperation(as2cgVisitor, asCacheOperation);
		cgCacheOperation.setAst(asCacheOperation);
		cgCacheOperation.setTypeId(analyzer.getCGTypeId(asTypeId));
		cgCacheOperation.setRequired(asCacheOperation.isIsRequired());
		cgCacheOperation.setCallingConvention(callingConvention);
		//	analyzer.addCGOperation(cgCacheOperation);
		cgCacheOperation.setBody((CGValuedElement) asExpression.accept(as2cgVisitor));
		cgCacheOperations.add(cgCacheOperation);
		NestedNameManager nameManager = as2cgVisitor.getNameManager();
		nameManager.getGlobalNameManager().createNestedNameManager(nameManager, cgCacheOperation);
		return cgCacheOperation;
	}

	protected @NonNull CGProperty installCGCacheProperty(@NonNull AS2CGVisitor as2cgVisitor, @NonNull List<@NonNull CGProperty> cgCacheProperties,
			@NonNull Property asCacheProperty, @NonNull PropertyCallingConvention callingConvention) {
		//	CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();
		//
		asCacheProperty.setImplementation(new CacheProperty(asCacheProperty.getPropertyId(), null, null));
		//
		CGProperty cgCacheProperty = as2cgVisitor.generatePropertyDeclaration(asCacheProperty, callingConvention);
		cgCacheProperties.add(cgCacheProperty);
		return cgCacheProperty;
	}

	protected @NonNull CGOperation installCacheConstructor(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGClass cgCacheClass,
			@NonNull Operation asOperation) {
		QVTiAS2CGVisitor qvtias2cgVisitor = (QVTiAS2CGVisitor)as2cgVisitor;
		CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();
		QVTiCodeGenerator codeGenerator = qvtias2cgVisitor.getCodeGenerator();
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
		QVTiNestedNameManager nameManager = qvtias2cgVisitor.getNameManager();
		ConstructorOperationCallingConvention callingConvention = ConstructorOperationCallingConvention.INSTANCE;
		CGParameter thisTransformerParameter = nameManager.getThisTransformerParameter();
		CGTypeId cgTypeId = analyzer.getCGTypeId(TypeId.OCL_VOID);
		//
		CGOperation cgConstructor = callingConvention.createCGOperation(as2cgVisitor, asOperation);
		cgConstructor.setAst(asCacheOperation);
		//	cgCacheOperation.setTypeId(cgTypeId);
		//	cgCacheOperation.setRequired(isRequired);
		cgConstructor.setCallingConvention(callingConvention);
		//	analyzer.addCGOperation(cgCacheOperation);
		ctorNameResolution.addCGElement(cgConstructor);
		callingConvention.createCGParameters(as2cgVisitor, cgConstructor, null);

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
		CGValuedElement asValue = as2cgVisitor.doVisit(CGValuedElement.class, asExpression);
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
		globalNameManager.createNestedNameManager(nameManager, cgConstructor);
		return cgConstructor;
	}

	protected @NonNull CGOperation installCacheGetResultOperation(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGClass cgCacheClass,
			@NonNull Operation asOperation) {
		QVTiAS2CGVisitor qvtias2cgVisitor = (QVTiAS2CGVisitor)as2cgVisitor;
		CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();
		QVTiCodeGenerator codeGenerator = qvtias2cgVisitor.getCodeGenerator();
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
		NestedNameManager nameManager = as2cgVisitor.getNameManager();
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
		CGOperation cgCacheOperation = callingConvention.createCGOperation(as2cgVisitor, asCacheOperation);
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
		globalNameManager.createNestedNameManager(nameManager, cgCacheOperation);
		return cgCacheOperation;
	}



	protected @NonNull CGOperation installCacheIsEqualOperation(@NonNull AS2CGVisitor as2cgVisitor, @NonNull CGClass cgCacheClass,
			@NonNull Operation asOperation) {
		QVTiAS2CGVisitor qvtias2cgVisitor = (QVTiAS2CGVisitor)as2cgVisitor;
		CodeGenAnalyzer analyzer = as2cgVisitor.getAnalyzer();
		QVTiCodeGenerator codeGenerator = qvtias2cgVisitor.getCodeGenerator();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		//
		NameResolution getResultNameResolution = globalNameManager.getGetResultNameResolution();
		String getResultName = getResultNameResolution.getResolvedName();
		//	String cachedResultName = globalNameManager.getCachedResultNameResolution().getResolvedName();
		//	CGProperty cgCacheProperty = getCGCacheProperty(cgCacheClass, cachedResultName);
		//	Property asCacheProperty = CGUtil.getAST(cgCacheProperty);
		//	Type asCacheType = PivotUtil.getType(asCacheProperty);
		Type asReturnType = as2cgVisitor.getEnvironmentFactory().getStandardLibrary().getBooleanType();
		//	boolean isRequired = cgCacheProperty.isRequired();
		//
		org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
		Operation asCacheOperation = PivotUtil.createOperation(getResultName, asReturnType, /*CacheOperation.class*/null, null); //asExpression);
		asCacheOperation.setIsRequired(true);
		List<@NonNull Operation> asCacheOperations = PivotUtilInternal.getOwnedOperationsList(asCacheClass);
		asCacheOperations.add(asCacheOperation);
		//
		NestedNameManager nameManager = as2cgVisitor.getNameManager();
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
		CGOperation cgCacheOperation = callingConvention.createCGOperation(as2cgVisitor, asCacheOperation);
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
		globalNameManager.createNestedNameManager(nameManager, cgCacheOperation);
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

	protected @NonNull Property installCacheParameterProperty(@NonNull AS2CGVisitor as2cgVisitor, @NonNull List<@NonNull Property> asCacheProperties, @NonNull Parameter asParameter) {
		Property asCacheProperty = PivotFactory.eINSTANCE.createProperty();
		asCacheProperty.setName(asParameter.getName());
		asCacheProperty.setType(asParameter.getType());
		asCacheProperty.setIsRequired(asParameter.isIsRequired());
		asCacheProperties.add(asCacheProperty);
		return asCacheProperty;
	}

	protected @NonNull Property installCacheResultProperty(@NonNull AS2CGVisitor as2cgVisitor, @NonNull List<@NonNull Property> asCacheProperties, @NonNull Operation asOperation) {
		QVTiAS2CGVisitor qvtias2cgVisitor = (QVTiAS2CGVisitor)as2cgVisitor;
		QVTiCodeGenerator codeGenerator = qvtias2cgVisitor.getCodeGenerator();
		NameResolution cachedResultName = codeGenerator.getGlobalNameManager().getCachedResultNameResolution();
		//
		Property asCacheProperty = PivotFactory.eINSTANCE.createProperty();
		asCacheProperty.setName(cachedResultName.getResolvedName());
		asCacheProperty.setType(asOperation.getType());
		asCacheProperty.setIsRequired(asOperation.isIsRequired());
		asCacheProperties.add(asCacheProperty);
		return asCacheProperty;
	}

	protected @NonNull Property installCacheTransformerProperty(@NonNull AS2CGVisitor as2cgVisitor, @NonNull List<@NonNull Property> asCacheProperties) {
		QVTiAS2CGVisitor qvtias2cgVisitor = (QVTiAS2CGVisitor)as2cgVisitor;
		QVTiCodeGenerator codeGenerator = qvtias2cgVisitor.getCodeGenerator();
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
