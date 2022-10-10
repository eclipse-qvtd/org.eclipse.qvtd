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
import java.util.Stack;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.CacheClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.ImmutableCachePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
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
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.LetVariable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParameterVariable;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.library.LibraryConstants;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.LanguageSupport;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
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

	protected @NonNull CGOperation installCacheConstructor(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull Operation asOperation) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		EnvironmentFactory environmentFactory = codeGenerator.getEnvironmentFactory();
		org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
		//
		NameResolution ctorNameResolution = cgCacheClass.getNameResolution();
		String ctorName = ctorNameResolution.getResolvedName();
		Type asCacheType = environmentFactory.getStandardLibrary().getOclVoidType();
		Operation asCacheOperation = PivotUtil.createOperation(ctorName, asCacheType, null, null);
		asCacheOperation.getOwnedParameters().add(createBoundValuesParameter(codeGenerator));
		//		asCacheOperation.setIsRequired(isRequired);
		asCacheClass.getOwnedOperations().add(asCacheOperation);
		//
		ConstructorOperationCallingConvention callingConvention = ConstructorOperationCallingConvention.INSTANCE;
		CGTypeId cgTypeId = analyzer.getCGTypeId(TypeId.OCL_VOID);
		//
		CGOperation cgConstructor = callingConvention.createCGOperation(qvtiAnalyzer, asCacheOperation);
		cgConstructor.setCallingConvention(callingConvention);
		qvtiAnalyzer.initAst(cgConstructor, asCacheOperation, true);
		ctorNameResolution.addCGElement(cgConstructor);
		QVTiExecutableNameManager nameManager = qvtiAnalyzer.getOperationNameManager(null, asCacheOperation);
		callingConvention.createCGParameters(nameManager, null);

		CGParameter cgThisParameter = nameManager.getThisParameter();
		List<@NonNull CGParameter> cgParameters = CGUtil.getParametersList(cgConstructor);
		List<@NonNull CGProperty> cgProperties = CGUtil.getPropertiesList(cgCacheClass);
		CGSequence cgSequence = QVTiCGModelFactory.eINSTANCE.createCGSequence();
		List<@NonNull CGValuedElement> cgStatements = QVTiCGUtil.getOwnedStatementsList(cgSequence);
		//
		//	Unpack and assign boundValues
		//
		CGParameter cgParameter = cgParameters.get(0);
		for (int i = 0; i < cgProperties.size()-1; i++) {	// XXX not cachedResult
			CGVariableExp cgVariableExp = analyzer.createCGVariableExp(cgParameter);
			CGIndexExp cgIndexExp = analyzer.createCGIndexExp(cgVariableExp, i);
			cgIndexExp.setAst(cgParameter.getAst());
			CGProperty cgProperty = cgProperties.get(i);
			CGPropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGPropertyAssignment();
			cgPropertyAssignment.setAst(cgProperty.getAst());
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
			CGPropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGPropertyAssignment();
			cgPropertyAssignment.setAst(cgProperty.getAst());
			cgPropertyAssignment.setTypeId(cgTypeId);
			cgPropertyAssignment.setOwnedSlotValue(analyzer.createCGVariableExp(cgThisParameter));
			cgPropertyAssignment.setReferredProperty(cgProperty);
			cgPropertyAssignment.setOwnedInitValue(asValue);
			//	cgPropertyAssignment.setAsProperty(asProperty);
			cgStatements.add(cgPropertyAssignment);
			cgConstructor.setBody(cgSequence);
		}
		//
		cgCacheClass.getOperations().add(cgConstructor);
		return cgConstructor;
	}

	protected @NonNull CGOperation installCacheGetResultOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull Operation asOperation) {
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
		Operation asCacheOperation = PivotUtil.createOperation(getResultName, asCacheType, null, null);
		asCacheOperation.setIsRequired(isRequired);
		asCacheClass.getOwnedOperations().add(asCacheOperation);
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
		cgCacheOperation.setBody(cgPropertyCallExp);
		getResultNameResolution.addCGElement(cgCacheOperation);
		//
		cgCacheClass.getOperations().add(cgCacheOperation);
		return cgCacheOperation;
	}

	protected @NonNull CGOperation installCacheIsEqualOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull Operation asOperation) {
		//
		// AS Class - yyy2zzz
		// AS Properties - thisTransformer, x1, x2, cachedResult
		// AS Operation - yyy2zzz
		// AS Operation.ownedParameters - x1, x2
		// AS Cache Operation - isEqual
		// AS Cache Operation.parameters - boundValues
		// AS Cache ExpressionInOCL.ownedContext - this
		// AS Cache ExpressionInOCL.ownedParameters - thisTransformer, x1, x2
		// CG Cache Operation - isEqual
		// CG Cache Operation.parameters - idResolver, boundValues
		// CG Cache Operation.lets - thisTransformer, x1, x2
		//
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		EnvironmentFactory environmentFactory = codeGenerator.getEnvironmentFactory();
		PivotHelper helper = new PivotHelper(environmentFactory);
		org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
		//
		//	Create AS declaration for isEqual
		//
		NameResolution isEqualNameResolution = globalNameManager.getIsEqualNameResolution();
		String isEqualName = isEqualNameResolution.getResolvedName();
		Type asReturnType = environmentFactory.getStandardLibrary().getBooleanType();
		Operation asCacheOperation = PivotUtil.createOperation(isEqualName, asReturnType, null, null);
		asCacheOperation.setIsRequired(true);
		Parameter asBoundValuesParameter = createBoundValuesParameter(codeGenerator);
		asCacheOperation.getOwnedParameters().add(asBoundValuesParameter);
		asCacheClass.getOwnedOperations().add(asCacheOperation);
		//
		//	Create AS body for isEqual
		//
		OCLExpression asBody = null;
		ExpressionInOCL asExpressionInOCL = PivotFactory.eINSTANCE.createExpressionInOCL();
		ParameterVariable asThisVariable = PivotFactory.eINSTANCE.createParameterVariable();
		asThisVariable.setName(PivotConstants.SELF_NAME);
		asThisVariable.setType(codeGenerator.getTransformation());
		asThisVariable.setIsRequired(true);
		asExpressionInOCL.setOwnedContext(asThisVariable);
		List<@NonNull Variable> asCacheParameterVariables = PivotUtilInternal.getOwnedParametersList(asExpressionInOCL);
		List<@NonNull Property> asCacheProperties = PivotUtilInternal.getOwnedPropertiesList(asCacheClass);
		Stack<@NonNull LetVariable> asLetVariables = new Stack<>();
		List<@NonNull Parameter> asParameters = PivotUtilInternal.getOwnedParametersList(asOperation);
		for (int i = 0; i < asCacheProperties.size()-1; i++) {		// not cachedResult
			Property asCacheProperty = asCacheProperties.get(i);
			@NonNull ParameterVariable asCacheParameterVariable;
			if (i == 0) {
				ParameterVariable asCacheThisVariable = PivotFactory.eINSTANCE.createParameterVariable();
				asCacheThisVariable.setName(PivotConstants.SELF_NAME);
				asCacheThisVariable.setType(asCacheClass);
				asCacheThisVariable.setIsRequired(true);
				asCacheParameterVariable = asCacheThisVariable;
			}
			else {
				Parameter asParameter = asParameters.get(i-1);
				asCacheParameterVariable = helper.createParameterVariable(asParameter);
				asCacheParameterVariable.setRepresentedParameter(asParameter);
			}
			asCacheParameterVariables.add(asCacheParameterVariable);
			String name = PivotUtil.getName(asCacheParameterVariable);
			VariableExp asInit = helper.createVariableExp(asCacheParameterVariable);
			LetVariable asLetVariable = helper.createLetVariable(name, asInit);
			asLetVariables.push(asLetVariable);

			OCLExpression asThisVariableExp = helper.createVariableExp(asThisVariable);
			OCLExpression asCacheParameterVariableExp = helper.createVariableExp(asCacheParameterVariable);
			OCLExpression asCachePropertyCallExp = helper.createPropertyCallExp(asThisVariableExp, asCacheProperty);
			OCLExpression asEquals = helper.createOperationCallExp(asCacheParameterVariableExp, "=", asCachePropertyCallExp);
			asBody = asBody != null ? helper.createOperationCallExp(asBody, LibraryConstants.AND2, asEquals) : asEquals;
		}
		assert asBody != null;
		while (!asLetVariables.isEmpty()) {
			LetVariable asVariable = asLetVariables.pop();
			asBody = helper.createLetExp(asVariable, asBody);
		}
		asExpressionInOCL.setOwnedBody(asBody);
		asExpressionInOCL.setType(asBody.getType());
		asCacheOperation.setBodyExpression(asExpressionInOCL);
		//
		//	Create CG declaration for isEqual
		//
		CacheOperationCallingConvention callingConvention = CacheOperationCallingConvention.INSTANCE;
		CGOperation cgCacheOperation = callingConvention.createCGOperation(qvtiAnalyzer, asCacheOperation);
		analyzer.initAst(cgCacheOperation, asCacheOperation, true);
		cgCacheOperation.setCallingConvention(callingConvention);
		isEqualNameResolution.addCGElement(cgCacheOperation);
		QVTiExecutableNameManager operationNameManager = qvtiAnalyzer.getOperationNameManager(cgCacheOperation, asCacheOperation);
		List<@NonNull CGParameter> cgCacheParameters = CGUtil.getParametersList(cgCacheOperation);
		cgCacheParameters.add(operationNameManager.getIdResolverParameter());
		CGParameter cgCacheBoundValuesParameter = operationNameManager.getCGParameter(asBoundValuesParameter, (String)null);
		cgCacheParameters.add(cgCacheBoundValuesParameter);
		//
		//	Create CG body for isEqual unpacking boundValues to regular parameter variables
		//
		Stack<@NonNull CGFinalVariable> cgLetVariables = new Stack<>();
		for (int i = 0; i < asCacheProperties.size()-1; i++) {		// not cachedResult
			ParameterVariable asParameterVariable = (ParameterVariable)asCacheParameterVariables.get(i);
			CGVariableExp cgVariableExp = analyzer.createCGVariableExp(cgCacheBoundValuesParameter);
			CGIndexExp cgIndexExp = analyzer.createCGIndexExp(cgVariableExp, i);
			cgIndexExp.setAst(asParameterVariable);
			CGFinalVariable cgParameterVariable = operationNameManager.createCGVariable(cgIndexExp);
			operationNameManager.addVariable(asParameterVariable, cgParameterVariable);
			cgLetVariables.push(cgParameterVariable);
		}
		CGValuedElement cgResult = qvtiAnalyzer.createCGElement(CGValuedElement.class, asExpressionInOCL);
		while (!cgLetVariables.isEmpty()) {
			CGFinalVariable cgLetVariable = cgLetVariables.pop();
			cgResult = analyzer.createCGLetExp(cgLetVariable, cgResult);
		}
		cgCacheOperation.setBody(cgResult);
		//
		cgCacheClass.getOperations().add(cgCacheOperation);
		return cgCacheOperation;
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
