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
package org.eclipse.qvtd.codegen.qvti.calling;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.AbstractCachedOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.AbstractOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.CacheClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.CacheClassCallingConvention.CachedFeatureAdapter;
import org.eclipse.ocl.examples.codegen.calling.ConstructorClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.ImmutableCachePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.OperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.PropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGCastExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIndexExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportNameManager;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.java.JavaStream.TypeRepresentation;
import org.eclipse.ocl.examples.codegen.naming.ClassNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.ExpressionInOCL;
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
import org.eclipse.ocl.pivot.utilities.AbstractLanguageSupport;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.LanguageSupport;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiExecutableNameManager;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiGlobalNameManager;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelCG2JavaVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractComputationConstructor;

/**
 *  FunctionOperationCallingConvention defines the support for the call of a QVTi function.
 */
public abstract class FunctionOperationCallingConvention extends AbstractOperationCallingConvention	// cf ConstrainedOperationCallingConvention
{
	/**
	 * A CacheProperty instance supports evaluation of a property in a CGed cache. (It has no opposite).
	 */
	public static class CacheProperty extends AbstractProperty
	{
		private final @NonNull PropertyId propertyId;
		private final @Nullable OCLExpression initExpression;
		private final @Nullable Object defaultValue;

		public CacheProperty(@NonNull PropertyId propertyId, @Nullable OCLExpression initExpression, @Nullable Object defaultValue) {
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

	public static final @NonNull ShadowDataTypeOperationCallingConvention INSTANCE = new ShadowDataTypeOperationCallingConvention();

	public static class DefaultCachedOperationCallingConvention extends AbstractCachedOperationCallingConvention
	{
		public static final @NonNull OperationCallingConvention INSTANCE = new DefaultCachedOperationCallingConvention();
	}

	public static class GetResultOperationCallingConvention extends AbstractCachedOperationCallingConvention
	{
		public static final @NonNull OperationCallingConvention INSTANCE = new GetResultOperationCallingConvention();

		@Override
		public boolean generateJavaDeclaration(
				@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js,
				@NonNull CGOperation cgOperation) {
			// TODO Auto-generated method stub
			return super.generateJavaDeclaration(cg2javaVisitor, js, cgOperation);
		}
	}

	public static class CacheConstructorConstructorOperationCallingConvention extends DefaultCachedOperationCallingConvention
	{
		public static final @NonNull OperationCallingConvention INSTANCE = new CacheConstructorConstructorOperationCallingConvention();

		@Override
		public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
			//	js.appendCommentWithOCL(title, asFeature);
			js.append("public ");
			js.appendValueName(cgOperation);
			js.append("() {\n");
			js.pushIndentation(null);
			js.append("super(");
			js.append(QVTiCGUtil.getContainingCGTransformation(cgOperation).getName());
			js.append(".this.");
			js.append(cg2javaVisitor.getGlobalNameManager().getIdResolverName());
			js.append(");\n");
			js.popIndentation();
			js.append("}\n");
			return true;
		}
	}

	public static class CacheConstructorNewInstanceOperationCallingConvention extends DefaultCachedOperationCallingConvention
	{
		public static final @NonNull OperationCallingConvention INSTANCE = new CacheConstructorNewInstanceOperationCallingConvention();

		@Override
		protected void generateJavaOperationBody(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
			js.append("return new ");
			js.appendClassReference(null, cgOperation);
			js.append("(");
			boolean isFirst = true;
			for (@NonNull CGParameter cgParameter : CGUtil.getParameters(cgOperation)) {
				if (!isFirst) {
					js.append(", ");
				}
				js.appendValueName(cgParameter);
				isFirst = false;
			}
			js.append(");\n");
		}
	}

	public static class ConstructorEvaluateOperationCallingConvention extends DefaultCachedOperationCallingConvention
	{
		public static final @NonNull OperationCallingConvention INSTANCE = new ConstructorEvaluateOperationCallingConvention();

		@Override
		protected void generateJavaOperationBody(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
			QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)cg2javaVisitor.getAnalyzer();
			QVTiGlobalNameManager globalNameManager = qvtiAnalyzer.getGlobalNameManager();
			Operation asOperation = CGUtil.getAST(cgOperation);
			org.eclipse.ocl.pivot.Class asConstructorClass = PivotUtil.getOwningClass(asOperation);
			org.eclipse.ocl.pivot.Class asCacheClass = qvtiAnalyzer.getCacheClass(asConstructorClass);
			CGClass cgCacheClass = qvtiAnalyzer.getCGClass(asCacheClass);
			js.append("return ((");
			js.appendClassReference(cgCacheClass);
			js.append(")getUniqueComputation(");
			//	js.append(QVTiCGUtil.getContainingCGTransformation(cgOperation).getName());
			js.append("transformation");		// XXX
			//	js.append(globalNameManager.getIdResolverName());
			for (@NonNull CGParameter cgParameter : CGUtil.getParameters(cgOperation)) {
				js.append(", ");
				js.appendValueName(cgParameter);
			}
			js.append(")).");
			js.append(globalNameManager.getCachedResultNameResolution().getResolvedName());
			js.append(";\n");
		}
	}

	public static class ConstructorInstancePropertyCallingConvention extends ImmutableCachePropertyCallingConvention
	{
		public static final @NonNull PropertyCallingConvention INSTANCE = new ConstructorInstancePropertyCallingConvention();

		@Override
		public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGProperty cgProperty) {
			TypeRepresentation boxedTypeRepresentation = js.getBoxedTypeRepresentation();
			js.append("protected final");
			js.append(" /*@NonInvalid*/ ");
			boxedTypeRepresentation.appendClassReference(cgProperty.isRequired(), cgProperty);
			js.append(" ");
			js.appendValueName(cgProperty);
			js.append(" = new ");
			boxedTypeRepresentation.appendClassReference(null, cgProperty);
			js.append("();\n");
			return true;
		}
	}

	protected final @NonNull Parameter createBoxedValuesParameter(@NonNull QVTiCodeGenerator codeGenerator) {
		NameResolution boxedValuesResolution = codeGenerator.getGlobalNameManager().getBoxedValuesNameResolution();
		String boxedValuesName = boxedValuesResolution.getResolvedName();
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		org.eclipse.ocl.pivot.Class boxedValueType = jLanguageSupport.getNativeClass(Object[].class);
		Parameter asConstructorParameter = PivotUtil.createParameter(boxedValuesName, boxedValueType, true);
		return asConstructorParameter;
	}

	protected final org.eclipse.ocl.pivot.@NonNull Class createCacheClass(@NonNull QVTiExecutableNameManager qvtiOperationNameManager) {
		QVTiAnalyzer qvtiAnalyzer = qvtiOperationNameManager.getAnalyzer();
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		//	ImperativeTransformation asTransformation = codeGenerator.getTransformation();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		ImportNameManager importNameManager = codeGenerator.getImportNameManager();
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		CGOperation cgOperation = (CGOperation)qvtiOperationNameManager.getCGScope();
		Operation asOperation = QVTiCGUtil.getAST(cgOperation);
		//	assert QVTimperativeUtil.basicGetShadowExp(asOperation) == null;
		//
		org.eclipse.ocl.pivot.@NonNull Package asPackage = getCachePackage(qvtiAnalyzer, asOperation);
		String name = "CACHE_" + PivotUtil.getName(PivotUtil.getOwningClass(asOperation)) + "_" + PivotUtil.getName(asOperation);
		org.eclipse.ocl.pivot.Class asCacheClass = AbstractLanguageSupport.getClass(asPackage, name);
		asCacheClass.eAdapters().add(new CachedFeatureAdapter(asOperation));
		org.eclipse.ocl.pivot.Class asCacheSuperClass = jLanguageSupport.getNativeClass(AbstractComputation.class);
		asCacheClass.getSuperClasses().add(asCacheSuperClass);
		importNameManager.reserveLocalName(PivotUtil.getName(asCacheClass));
		//
		CGClass cgCacheClass = qvtiAnalyzer.generateClassDeclaration(asCacheClass, CacheClassCallingConvention.INSTANCE);
		CGClass cgSuperClass = qvtiAnalyzer.generateClassDeclaration(asCacheSuperClass, getClassCallingConvention());
		cgCacheClass.getSuperTypes().add(cgSuperClass);
		//
		NameResolution cachedResultNameResolution = globalNameManager.getCachedResultNameResolution();
		createCacheSelfProperty(qvtiAnalyzer, cgCacheClass);
		for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asOperation)) {
			createCacheProperty(qvtiAnalyzer, cgCacheClass, null, asParameter);
			// XXX need to support a cached invalid
		}
		createCacheProperty(qvtiAnalyzer, cgCacheClass, cachedResultNameResolution, asOperation);
		//
		createCacheConstructor(qvtiAnalyzer, cgCacheClass, asOperation);
		createCacheGetResultOperation(qvtiAnalyzer, cgCacheClass, asOperation);
		createCacheIsEqualOperation(qvtiAnalyzer, cgCacheClass, asOperation);
		return asCacheClass;
	}

	protected final @NonNull CGOperation createCacheConstructor(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull Operation asOperation) {
		//
		// AS Class - yyy2zzz
		// AS Properties -
		// AS Operation - yyy2zzz
		// AS Operation.ownedParameters - x1, x2
		// AS Cache Operation - newInstance
		// AS Cache Operation.parameters - boxedValues
		// AS Cache ExpressionInOCL.ownedContext - this
		// AS Cache ExpressionInOCL.ownedParameters - x1, x2
		// CG Cache Operation - newInstance
		// CG Cache Operation.lets -
		//
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		EnvironmentFactory environmentFactory = codeGenerator.getEnvironmentFactory();
		org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
		List<@NonNull CGProperty> cgProperties = CGUtil.getPropertiesList(cgCacheClass);
		//
		NameResolution ctorNameResolution = cgCacheClass.getNameResolution();
		String ctorName = ctorNameResolution.getResolvedName();
		Type asCacheType = environmentFactory.getStandardLibrary().getOclVoidType();
		Operation asCacheOperation = PivotUtil.createOperation(ctorName, asCacheType, null, null);
		Parameter asBoxedValuesParameter = createBoxedValuesParameter(codeGenerator);
		asCacheOperation.getOwnedParameters().add(asBoxedValuesParameter);
		asCacheClass.getOwnedOperations().add(asCacheOperation);
		//
		//	Wrap a copy of the original constructor bodies in a let expression per constructor parameter.
		//
		ExpressionInOCL asExpressionInOCL = (ExpressionInOCL)asOperation.getBodyExpression();
		assert asExpressionInOCL != null;
		ExpressionInOCL asCacheExpressionInOCL = EcoreUtil.copy(asExpressionInOCL);
		List<@NonNull Variable> asCacheParameterVariables = PivotUtilInternal.getOwnedParametersList(asCacheExpressionInOCL);
		//	List<@NonNull Property> asCacheProperties = PivotUtilInternal.getOwnedPropertiesList(asCacheClass);
		Map<@NonNull CGProperty, @NonNull ParameterVariable> cgProperty2asLetVariable = new HashMap<>();
		//	Stack<@NonNull ParameterVariable> asLetVariables = new Stack<>();
		for (int i = 0; i < cgProperties.size()-1; i++) {		// not cachedResult		// not/correct thisTransformer
			CGProperty cgProperty = cgProperties.get(i);
			ParameterVariable asCacheParameterVariable = (ParameterVariable)(i == 0 ? asCacheExpressionInOCL.getOwnedContext() : asCacheParameterVariables.get(i-1));
			assert asCacheParameterVariable != null;
			//	CGVariableExp cgVariableExp = analyzer.createCGVariableExp(cgCacheBoxedValuesParameter);
			//	CGIndexExp cgIndexExp = analyzer.createCGIndexExp(cgVariableExp, i);
			//	cgIndexExp.setAst(asParameterVariable);
			ParameterVariable asLetVariable = asCacheParameterVariable;//helper.createLetVariable(PivotUtil.getName(asCacheParameterVariable), helper.createVariableExp(asCacheParameterVariable));
			//	operationNameManager.addVariable(asLetVariable, cgParameterVariable);
			//		asLetVariables.push(asLetVariable);
			cgProperty2asLetVariable.put(cgProperty, asLetVariable);
		}
		OCLExpression asCacheResult = asCacheExpressionInOCL.getOwnedBody();
		PivotUtilInternal.resetContainer(asCacheResult);
		//	while (!asLetVariables.isEmpty()) {
		//		ParameterVariable asLetVariable = asLetVariables.pop();
		//		asCacheResult = helper.createLetExp(asLetVariable, asCacheResult);
		//	}
		asCacheExpressionInOCL.setOwnedBody(asCacheResult);
		asCacheOperation.setBodyExpression(asCacheExpressionInOCL);
		//
		ConstructorOperationCallingConvention callingConvention = ConstructorOperationCallingConvention.INSTANCE;
		CGTypeId cgTypeId = analyzer.getCGTypeId(TypeId.OCL_VOID);
		CGOperation cgConstructor = callingConvention.createCGOperation(qvtiAnalyzer, asCacheOperation);
		cgConstructor.setCallingConvention(callingConvention);
		qvtiAnalyzer.initAst(cgConstructor, asCacheOperation, true);
		ctorNameResolution.addCGElement(cgConstructor);
		QVTiExecutableNameManager operationNameManager = qvtiAnalyzer.getOperationNameManager(cgConstructor, asCacheOperation);
		List<@NonNull CGParameter> cgParameters = CGUtil.getParametersList(cgConstructor);
		CGParameter cgCacheBoxedValuesParameter = operationNameManager.getCGParameter(asBoxedValuesParameter, (String)null);
		globalNameManager.getBoxedValuesNameResolution().addCGElement(cgCacheBoxedValuesParameter);
		cgParameters.add(cgCacheBoxedValuesParameter);
		for (int i = 0; i < cgProperties.size()-1; i++) {		// not cachedResult		// not/correct thisTransformer
			ParameterVariable asCacheParameterVariable = (ParameterVariable)(i == 0 ? asCacheExpressionInOCL.getOwnedContext() : asCacheParameterVariables.get(i-1));
			assert asCacheParameterVariable != null;
			operationNameManager.lazyGetCGVariable(asCacheParameterVariable);
		}

		CGParameter cgThisParameter = operationNameManager.getThisParameter();
		CGSequence cgSequence = QVTiCGModelFactory.eINSTANCE.createCGSequence();
		List<@NonNull CGValuedElement> cgStatements = QVTiCGUtil.getOwnedStatementsList(cgSequence);
		//
		//	Unpack and assign boxedValues
		//
		for (int i = 0; i < cgProperties.size()-1; i++) {	// XXX not cachedResult
			CGProperty cgProperty = cgProperties.get(i);
			Property asProperty = CGUtil.getAST(cgProperty);
			Type asType = PivotUtil.getType(asProperty);
			CGExecutorType cgExecutorType = operationNameManager.getCGExecutorType(asType);
			CGVariableExp cgVariableExp = analyzer.createCGVariableExp(cgCacheBoxedValuesParameter);
			CGIndexExp cgIndexExp = analyzer.createCGIndexExp(cgVariableExp, i);
			cgIndexExp.setAst(asProperty);
			CGCastExp cgCastExp = analyzer.createCGCastExp(cgExecutorType, cgIndexExp);
			cgCastExp.setAst(asProperty);
			CGPropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGPropertyAssignment();
			cgPropertyAssignment.setAst(asProperty);
			cgPropertyAssignment.setTypeId(cgTypeId);
			cgPropertyAssignment.setOwnedSlotValue(analyzer.createCGVariableExp(cgThisParameter));
			cgPropertyAssignment.setReferredProperty(cgProperty);
			cgPropertyAssignment.setOwnedInitValue(cgCastExp);
			//	cgPropertyAssignment.setAsProperty(asProperty);
			cgStatements.add(cgPropertyAssignment);
			//	cgProperty.getNameResolution().addCGElement(cgCastExp);
		}
		//
		//	Assign cachedResult
		//
		{
			CGValuedElement cgResult = qvtiAnalyzer.createCGElement(CGValuedElement.class, asCacheResult);


			for (Map.Entry<@NonNull CGProperty, @NonNull ParameterVariable> entry : cgProperty2asLetVariable.entrySet()) {
				CGProperty cgProperty = entry.getKey();
				ParameterVariable asLetVariable = entry.getValue();
				CGVariable cgLetVariable = operationNameManager.getCGVariable(asLetVariable);
				cgProperty.getNameResolution().addCGElement(cgLetVariable);
			}



			CGProperty cgProperty = cgProperties.get(cgProperties.size()-1);
			CGPropertyAssignment cgPropertyAssignment = QVTiCGModelFactory.eINSTANCE.createCGPropertyAssignment();
			cgPropertyAssignment.setAst(cgProperty.getAst());
			cgPropertyAssignment.setTypeId(cgTypeId);
			cgPropertyAssignment.setOwnedSlotValue(analyzer.createCGVariableExp(cgThisParameter));
			cgPropertyAssignment.setReferredProperty(cgProperty);
			cgPropertyAssignment.setOwnedInitValue(cgResult);
			//	cgPropertyAssignment.setAsProperty(asProperty);
			cgStatements.add(cgPropertyAssignment);
			cgConstructor.setBody(cgSequence);
		}
		//
		cgCacheClass.getOperations().add(cgConstructor);
		return cgConstructor;
	}

	protected final @NonNull CGOperation createCacheGetResultOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull Operation asOperation) {
		/*		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
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
		return cgCacheOperation; */
		//
		// AS Class - yyy2zzz
		// AS Properties - thisTransformer, x1, x2, cachedResult
		// AS Operation - yyy2zzz
		// AS Operation.ownedParameters - x1, x2
		// AS Cache Operation - isEqual
		// AS Cache Operation.parameters - boxedValues
		// AS Cache ExpressionInOCL.ownedContext - this
		// AS Cache ExpressionInOCL.ownedParameters - thisTransformer, x1, x2
		// CG Cache Operation - isEqual
		// CG Cache Operation.parameters - idResolver, boxedValues
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
		//		NameResolution isEqualNameResolution = globalNameManager.getIsEqualNameResolution();
		//		String isEqualName = isEqualNameResolution.getResolvedName();
		NameResolution getResultNameResolution = globalNameManager.getGetResultNameResolution();
		String getResultName = getResultNameResolution.getResolvedName();
		//		Type asReturnType = environmentFactory.getStandardLibrary().getBooleanType();
		//		CGProperty cgCacheProperty = getCGCacheProperty(cgCacheClass, cachedResultName);
		List<@NonNull Property> asCacheProperties = PivotUtilInternal.getOwnedPropertiesList(asCacheClass);
		Property asCachedResultProperty = asCacheProperties.get(asCacheProperties.size()-1);
		Type asCachedResultType = PivotUtil.getType(asCachedResultProperty);
		Operation asCacheOperation = PivotUtil.createOperation(getResultName, asCachedResultType, null, null);
		asCacheOperation.setIsRequired(asCachedResultProperty.isIsRequired());
		asCacheClass.getOwnedOperations().add(asCacheOperation);
		//
		//	Create AS body for isEqual
		//
		ExpressionInOCL asExpressionInOCL = PivotFactory.eINSTANCE.createExpressionInOCL();
		ParameterVariable asThisVariable = PivotFactory.eINSTANCE.createParameterVariable();
		asThisVariable.setName(PivotConstants.SELF_NAME);
		asThisVariable.setType(asCacheClass);
		asThisVariable.setIsRequired(true);
		asExpressionInOCL.setOwnedContext(asThisVariable);
		OCLExpression asThisVariableExp = helper.createVariableExp(asThisVariable);
		OCLExpression asBody = helper.createPropertyCallExp(asThisVariableExp, asCachedResultProperty);
		asExpressionInOCL.setOwnedBody(asBody);
		asExpressionInOCL.setType(asBody.getType());
		asCacheOperation.setBodyExpression(asExpressionInOCL);
		//
		//	Create CG declaration for isEqual
		//
		OperationCallingConvention callingConvention = GetResultOperationCallingConvention.INSTANCE;
		CGOperation cgCacheOperation = callingConvention.createCGOperation(qvtiAnalyzer, asCacheOperation);
		analyzer.initAst(cgCacheOperation, asCacheOperation, true);
		cgCacheOperation.setCallingConvention(callingConvention);
		getResultNameResolution.addCGElement(cgCacheOperation);
		/*QVTiExecutableNameManager operationNameManager =*/ qvtiAnalyzer.getOperationNameManager(cgCacheOperation, asCacheOperation);
		//	List<@NonNull CGParameter> cgCacheParameters = CGUtil.getParametersList(cgCacheOperation);
		//	cgCacheParameters.add(operationNameManager.getIdResolverParameter());
		//	CGParameter cgCacheBoxedValuesParameter = operationNameManager.getCGParameter(asBoxedValuesParameter, (String)null);
		//	cgCacheParameters.add(cgCacheBoxedValuesParameter);
		//
		//	Create CG body for isEqual unpacking boxedValues to regular parameter variables
		//
		CGValuedElement cgResult = qvtiAnalyzer.createCGElement(CGValuedElement.class, asExpressionInOCL);
		cgCacheOperation.setBody(cgResult);
		//
		cgCacheClass.getOperations().add(cgCacheOperation);
		return cgCacheOperation;
	}

	protected final @NonNull CGOperation createCacheIsEqualOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull Operation asOperation) {
		//
		// AS Class - yyy2zzz
		// AS Properties - thisTransformer, x1, x2, cachedResult
		// AS Operation - yyy2zzz
		// AS Operation.ownedParameters - x1, x2
		// AS Cache Operation - isEqual
		// AS Cache Operation.parameters - boxedValues
		// AS Cache ExpressionInOCL.ownedContext - this
		// AS Cache ExpressionInOCL.ownedParameters - thisTransformer, x1, x2
		// CG Cache Operation - isEqual
		// CG Cache Operation.parameters - idResolver, boxedValues
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
		Parameter asBoxedValuesParameter = createBoxedValuesParameter(codeGenerator);
		asCacheOperation.getOwnedParameters().add(asBoxedValuesParameter);
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
		OperationCallingConvention callingConvention = DefaultCachedOperationCallingConvention.INSTANCE;
		CGOperation cgCacheOperation = callingConvention.createCGOperation(qvtiAnalyzer, asCacheOperation);
		analyzer.initAst(cgCacheOperation, asCacheOperation, true);
		cgCacheOperation.setCallingConvention(callingConvention);
		isEqualNameResolution.addCGElement(cgCacheOperation);
		QVTiExecutableNameManager operationNameManager = qvtiAnalyzer.getOperationNameManager(cgCacheOperation, asCacheOperation);
		List<@NonNull CGParameter> cgCacheParameters = CGUtil.getParametersList(cgCacheOperation);
		//		CGVariable cgIdResolverVariable = operationNameManager.getIdResolverVariable();
		CGParameter cgIdResolverParameter = operationNameManager.getIdResolverParameter();
		cgCacheParameters.add(cgIdResolverParameter);
		CGParameter cgCacheBoxedValuesParameter = operationNameManager.getCGParameter(asBoxedValuesParameter, (String)null);
		globalNameManager.getBoxedValuesNameResolution().addCGElement(cgCacheBoxedValuesParameter);
		cgCacheParameters.add(cgCacheBoxedValuesParameter);
		//	operationNameManager.getIdResolverParameter();
		//
		//	Create CG body for isEqual unpacking boxedValues to regular parameter variables
		//
		Stack<@NonNull CGFinalVariable> cgLetVariables = new Stack<>();
		for (int i = 0; i < asCacheProperties.size()-1; i++) {		// not cachedResult
			ParameterVariable asParameterVariable = (ParameterVariable)asCacheParameterVariables.get(i);
			CGVariableExp cgVariableExp = analyzer.createCGVariableExp(cgCacheBoxedValuesParameter);
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

	protected final void createCacheProperty(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass,
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
		if (nameResolution == null) {
			ClassNameManager nameManager = analyzer.getClassNameManager(cgCacheClass, asCacheClass);
			//			nameManager.declareEagerName(cgCacheProperty)
			nameResolution = nameManager.getNameResolution(cgCacheProperty);
		}
	}

	protected void createCacheSelfProperty(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		ImperativeTransformation asTransformation = codeGenerator.getTransformation();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		NameResolution thisTransformerNameResolution = globalNameManager.getThisTransformerNameResolution();
		createCacheProperty(qvtiAnalyzer, cgCacheClass, thisTransformerNameResolution, asTransformation);
	}

	protected final org.eclipse.ocl.pivot.@NonNull Class createConstructorClass(@NonNull QVTiExecutableNameManager qvtiOperationNameManager, org.eclipse.ocl.pivot.@NonNull Class asCacheClass) {
		QVTiAnalyzer qvtiAnalyzer = qvtiOperationNameManager.getAnalyzer();
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		ImportNameManager importNameManager = codeGenerator.getImportNameManager();
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		CGOperation cgOperation = (CGOperation)qvtiOperationNameManager.getCGScope();
		Operation asOperation = QVTiCGUtil.getAST(cgOperation);
		//
		org.eclipse.ocl.pivot.@NonNull Package asPackage = getCachePackage(qvtiAnalyzer, asOperation);
		String name = "CTOR_" + PivotUtil.getName(PivotUtil.getOwningClass(asOperation)) + "_" + PivotUtil.getName(asOperation);
		org.eclipse.ocl.pivot.Class asConstructorClass = AbstractLanguageSupport.getClass(asPackage, name);
		org.eclipse.ocl.pivot.Class asConstructorSuperClass = jLanguageSupport.getNativeClass(AbstractComputationConstructor.class);
		asConstructorClass.getSuperClasses().add(asConstructorSuperClass);
		importNameManager.reserveLocalName(PivotUtil.getName(asConstructorClass));
		//
		CGClass cgConstructorClass = qvtiAnalyzer.generateClassDeclaration(asConstructorClass, ConstructorClassCallingConvention.INSTANCE);
		CGClass cgConstructorSuperClass = qvtiAnalyzer.generateClassDeclaration(asConstructorSuperClass, getClassCallingConvention());
		cgConstructorClass.getSuperTypes().add(cgConstructorSuperClass);
		//
		createConstructorConstructorOperation(qvtiAnalyzer, cgConstructorClass);
		createConstructorEvaluateOperation(qvtiAnalyzer, cgConstructorClass, asOperation, asCacheClass);
		createConstructorNewInstanceOperation(qvtiAnalyzer, cgConstructorClass, asCacheClass);
		//
		return asConstructorClass;
	}

	protected final @NonNull CGOperation createConstructorConstructorOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgConstructorClass) {
		//
		// AS Class - yyy2zzz
		// AS Properties -
		// AS Operation - yyy2zzz
		// AS Operation.ownedParameters -
		// AS Cache Operation - yyy2zzz
		// AS Cache Operation.parameters -
		// AS Cache ExpressionInOCL.ownedContext -
		// AS Cache ExpressionInOCL.ownedParameters -
		// CG Cache Operation - yyy2zzz
		// CG Cache Operation.lets -
		//
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		EnvironmentFactory environmentFactory = codeGenerator.getEnvironmentFactory();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		org.eclipse.ocl.pivot.@NonNull Class asConstructorClass = CGUtil.getAST(cgConstructorClass);
		//
		//	Create AS declaration for newInstance
		//
		String constructorName = PivotUtil.getName(asConstructorClass);
		Type asReturnType = environmentFactory.getStandardLibrary().getOclVoidType();
		Operation asConstructorOperation = PivotUtil.createOperation(constructorName, asReturnType, null, null);
		asConstructorOperation.setIsRequired(true);
		Parameter asBoxedValuesParameter = createBoxedValuesParameter(codeGenerator);
		asConstructorOperation.getOwnedParameters().add(asBoxedValuesParameter);
		asConstructorClass.getOwnedOperations().add(asConstructorOperation);
		//
		//	Create AS body for newInstance
		//
		//	not implemented
		//
		//	Create CG declaration for newInstance
		//
		OperationCallingConvention callingConvention = CacheConstructorConstructorOperationCallingConvention.INSTANCE;
		CGOperation cgConstructorOperation = callingConvention.createCGOperation(qvtiAnalyzer, asConstructorOperation);
		analyzer.initAst(cgConstructorOperation, asConstructorOperation, true);
		cgConstructorOperation.setCallingConvention(callingConvention);
		//	newInstanceNameResolution.addCGElement(cgConstructorOperation);
		QVTiExecutableNameManager operationNameManager = qvtiAnalyzer.getOperationNameManager(cgConstructorOperation, asConstructorOperation);
		List<@NonNull CGParameter> cgCacheParameters = CGUtil.getParametersList(cgConstructorOperation);
		CGParameter cgConstructorBoxedValuesParameter = operationNameManager.getCGParameter(asBoxedValuesParameter, (String)null);
		globalNameManager.getBoxedValuesNameResolution().addCGElement(cgConstructorBoxedValuesParameter);
		cgCacheParameters.add(cgConstructorBoxedValuesParameter);
		//
		//	Create CG body for newInstance
		//
		//	Implemented as direct synthesis in CacheConstructorConstructorOperationCallingConvention.
		//	Needs an ability to specify a super() invocation and no return type.
		//
		cgConstructorClass.getOperations().add(cgConstructorOperation);
		return cgConstructorOperation;
	}

	protected final @NonNull Property createConstructorInstance(@NonNull QVTiExecutableNameManager qvtiOperationNameManager, org.eclipse.ocl.pivot.@NonNull Class asConstructorClass, org.eclipse.ocl.pivot.@NonNull Class asCacheClass) {
		QVTiAnalyzer qvtiAnalyzer = qvtiOperationNameManager.getAnalyzer();
		Property asProperty = PivotUtil.createProperty("INSTANCE_" + asConstructorClass.getName(), asConstructorClass);		// XXX name allocation
		Operation asOperation = (Operation)qvtiOperationNameManager.getASScope();
		qvtiAnalyzer.addCacheConstructorInstance(asOperation, asProperty, asCacheClass);
		//
		//	CGClass cgClass = qvtiOperationNameManager.getClassNameManager().getCGClass();
		CGProperty cgProperty = qvtiAnalyzer.createCGElement(CGProperty.class, asProperty);
		cgProperty.setCallingConvention(ConstructorInstancePropertyCallingConvention.INSTANCE);
		//	cgClass.getProperties().add(cgProperty);
		assert cgProperty.eContainer() != null;
		return asProperty;
	}

	protected final @NonNull CGOperation createConstructorNewInstanceOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgConstructorClass, org.eclipse.ocl.pivot.@NonNull Class asCacheClass) {
		//
		// AS Class - yyy2zzz
		// AS Properties -
		// AS Operation - yyy2zzz
		// AS Operation.ownedParameters -
		// AS Cache Operation - newInstance
		// AS Cache Operation.parameters - boxedValues
		// AS Cache ExpressionInOCL.ownedContext - this
		// AS Cache ExpressionInOCL.ownedParameters -
		// CG Cache Operation - newInstance
		// CG Cache Operation.lets -
		//
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		org.eclipse.ocl.pivot.@NonNull Class asConstructorClass = CGUtil.getAST(cgConstructorClass);
		//
		//	Create AS declaration for newInstance
		//
		NameResolution newInstanceNameResolution = globalNameManager.getNewInstanceResolution();
		String newInstanceName = newInstanceNameResolution.getResolvedName();
		Operation asConstructorOperation = PivotUtil.createOperation(newInstanceName, asCacheClass, null, null);
		asConstructorOperation.setIsRequired(true);
		Parameter asBoxedValuesParameter = createBoxedValuesParameter(codeGenerator);
		asConstructorOperation.getOwnedParameters().add(asBoxedValuesParameter);
		asConstructorClass.getOwnedOperations().add(asConstructorOperation);
		//
		//	Create AS body for newInstance
		//
		//	not implemented
		//
		//	Create CG declaration for newInstance
		//
		OperationCallingConvention callingConvention = CacheConstructorNewInstanceOperationCallingConvention.INSTANCE;
		CGOperation cgConstructorOperation = callingConvention.createCGOperation(qvtiAnalyzer, asConstructorOperation);
		analyzer.initAst(cgConstructorOperation, asConstructorOperation, true);
		cgConstructorOperation.setCallingConvention(callingConvention);
		newInstanceNameResolution.addCGElement(cgConstructorOperation);
		QVTiExecutableNameManager operationNameManager = qvtiAnalyzer.getOperationNameManager(cgConstructorOperation, asConstructorOperation);
		List<@NonNull CGParameter> cgCacheParameters = CGUtil.getParametersList(cgConstructorOperation);
		CGParameter cgConstructorBoxedValuesParameter = operationNameManager.getCGParameter(asBoxedValuesParameter, (String)null);
		globalNameManager.getBoxedValuesNameResolution().addCGElement(cgConstructorBoxedValuesParameter);
		cgCacheParameters.add(cgConstructorBoxedValuesParameter);
		//
		//	Create CG body for newInstance
		//
		//	Implemented as direct synthesis in CacheConstructorNewInstanceOperationCallingConvention.
		//	Needs an ability to specify a new T invocation.
		//
		cgConstructorClass.getOperations().add(cgConstructorOperation);
		return cgConstructorOperation;
	}

	protected final @NonNull CGOperation createConstructorEvaluateOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgConstructorClass, @NonNull Operation asOperation, org.eclipse.ocl.pivot.@NonNull Class asCacheClass) {
		//
		// AS Class - yyy2zzz
		// AS Properties -
		// AS Operation - yyy2zzz
		// AS Operation.ownedParameters - x, y
		// AS Cache Operation - evaluate
		// AS Cache Operation.parameters - x, y
		// AS Cache ExpressionInOCL.ownedContext - this
		// AS Cache ExpressionInOCL.ownedParameters -
		// CG Cache Operation - evaluate
		// CG Cache Operation.lets -
		//
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		org.eclipse.ocl.pivot.@NonNull Class asConstructorClass = CGUtil.getAST(cgConstructorClass);
		//
		//	Create AS declaration for newInstance
		//
		NameResolution evaluateNameResolution = globalNameManager.getEvaluateNameResolution();
		String newInstanceName = evaluateNameResolution.getResolvedName();
		Operation asEvaluateOperation = PivotUtil.createOperation(newInstanceName, asCacheClass, null, null);
		asEvaluateOperation.setType(asOperation.getType());
		asEvaluateOperation.setIsRequired(asOperation.isIsRequired());

		List<@NonNull Parameter> asParameters = PivotUtilInternal.getOwnedParametersList(asOperation);
		List<@NonNull Parameter> asEvaluateParameters = PivotUtilInternal.getOwnedParametersList(asEvaluateOperation);
		Parameter asEvaluateSelfParameter = createConstructorEvaluateOperationSelfParameter(qvtiAnalyzer, asOperation);
		if (asEvaluateSelfParameter != null) {
			asEvaluateParameters.add(asEvaluateSelfParameter);
		}
		for (@NonNull Parameter asParameter : asParameters) {
			Parameter asEvaluateParameter = PivotUtil.createParameter(asParameter.getName(), asParameter.getType(), asParameter.isIsRequired());
			asEvaluateParameters.add(asEvaluateParameter);
		}
		asConstructorClass.getOwnedOperations().add(asEvaluateOperation);
		//
		//	Create AS body for newInstance
		//
		//	not implemented
		//
		//	Create CG declaration for newInstance
		//
		OperationCallingConvention callingConvention = getConstructorEvaluateOperationCallingConvention();
		CGOperation cgEvaluateOperation = callingConvention.createCGOperation(qvtiAnalyzer, asEvaluateOperation);
		analyzer.initAst(cgEvaluateOperation, asEvaluateOperation, true);
		cgEvaluateOperation.setCallingConvention(callingConvention);
		evaluateNameResolution.addCGElement(cgEvaluateOperation);
		QVTiExecutableNameManager operationNameManager = qvtiAnalyzer.getOperationNameManager(cgEvaluateOperation, asEvaluateOperation);
		List<@NonNull CGParameter> cgEvaluateParameters = CGUtil.getParametersList(cgEvaluateOperation);
		for (@NonNull Parameter asEvaluateParameter : asEvaluateParameters) {
			CGParameter cgParameter = operationNameManager.getCGParameter(asEvaluateParameter, null);
			cgEvaluateParameters.add(cgParameter);
		}
		//
		//	Create CG body for newInstance
		//
		//	Implemented as direct synthesis in CacheConstructorNewInstanceOperationCallingConvention.
		//	Needs an ability to specify a new T invocation.
		//
		cgConstructorClass.getOperations().add(cgEvaluateOperation);
		return cgEvaluateOperation;
	}

	protected @Nullable Parameter createConstructorEvaluateOperationSelfParameter(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		return null;
	}

	@Override	@Deprecated /* @deprecated use generateJavaEvaluateCall always */
	public boolean generateJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperationCallExp cgOperationCallExp) {
		QVTiCGModelCG2JavaVisitor qvticg2javaVisitor = (QVTiCGModelCG2JavaVisitor)cg2javaVisitor;
		CGFunctionCallExp cgFunctionCallExp = (CGFunctionCallExp)cgOperationCallExp;
		CGFunction cgFunction = (CGFunction)QVTiCGUtil.getOperation(cgOperationCallExp);
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		//	Operation pOperation = cgFunctionCallExp.getReferredOperation();
		//	CGFunction cgFunction = ClassUtil.nonNullState(cgFunctionCallExp.getFunction());
		boolean useClassToCreateObject = QVTimperativeUtil.basicGetShadowExp(asFunction) != null;
		boolean useCache = !asFunction.isIsTransient();
		boolean isIdentifiedInstance = useCache;
		List<CGValuedElement> cgArguments = cgFunctionCallExp.getArguments();
		List<Parameter> asParameters = asFunction.getOwnedParameters();
		List<CGParameter> cgParameters = cgFunction.getParameters();
		//
		for (@SuppressWarnings("null")@NonNull CGValuedElement cgArgument : cgArguments) {
			CGValuedElement argument = qvticg2javaVisitor.getExpression(cgArgument);
			if (!js.appendLocalStatements(argument)) {
				return false;
			}
		}
		//
		js.appendDeclaration(cgFunctionCallExp);
		js.append(" = ");
		boolean needComma = false;
		if (isIdentifiedInstance) {
			js.append("((");
			js.appendValueName(cgFunction);
			js.append(")");
			js.append(qvticg2javaVisitor.getFunctionCtorName(cgFunction));
			js.append(".getUniqueComputation(");
			//			if (useCache && !useClassToCreateObject) {
			//				CGClass cgClass = ClassUtil.nonNullState(cgFunction.getContainingClass());
			//				//				js.appendClassReference(cgClass);
			//				//				js.append(".this");
			//				qvticg2javaVisitor.appendThis(cgClass);
			//				needComma = true;
			//			}
		}
		else {
			//	js.append(asFunction.getName());
			js.appendValueName(cgFunction);
			js.append("(");
		}
		//	int iMax = cgParameters.size();
		//	assert iMax == cgArguments.size();
		for (int i = 0; i < cgArguments.size(); i++) {
			if (needComma) {
				js.append(", ");
			}
			//	CGParameter cgParameter = cgParameters.get(i);
			CGValuedElement cgArgument = cgArguments.get(i);
			CGValuedElement argument = qvticg2javaVisitor.getExpression(cgArgument);
			//	TypeId asTypeId = cgParameter.getTypeId().getASTypeId();
			//	assert asTypeId != null;
			//	TypeDescriptor parameterTypeDescriptor = codeGenerator.getUnboxedDescriptor(asTypeId);
			//	js.appendReferenceTo(parameterTypeDescriptor, argument);
			js.appendValueName(argument);
			needComma = true;
		}
		js.append(")");
		if (isIdentifiedInstance) {
			js.append(")");
			//	String cachedResultName = qvticg2javaVisitor.getVariantResolvedName(cgFunction, codeGenerator.getCACHED_RESULT_NameVariant());
			String cachedResultName = qvticg2javaVisitor.getCodeGenerator().getGlobalNameManager().getCachedResultName();
			js.append(".");
			js.append(cachedResultName);
		}
		js.append(";\n");
		return true;
	}

	protected final boolean generateJavaEvaluateCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperationCallExp cgOperationCallExp) {
		// FIXME could be a regular CG call if CG and AS separately created by generateDeclaration
		QVTiCGModelCG2JavaVisitor qvticg2javaVisitor = (QVTiCGModelCG2JavaVisitor)cg2javaVisitor;
		QVTiAnalyzer analyzer = qvticg2javaVisitor.getAnalyzer();
		CGOperation cgOperation = QVTiCGUtil.getOperation(cgOperationCallExp);
		Operation asOperation = QVTiCGUtil.getAST(cgOperation);
		Iterable<@NonNull CGValuedElement> cgArguments = CGUtil.getArguments(cgOperationCallExp);
		Property asCacheInstance = analyzer.getCacheConstructorInstance(asOperation);
		CGProperty cgCacheInstance = analyzer.getCGProperty(asCacheInstance);
		//
		for (@NonNull CGValuedElement cgArgument : cgArguments) {
			CGValuedElement argument = qvticg2javaVisitor.getExpression(cgArgument);
			if (!js.appendLocalStatements(argument)) {
				return false;
			}
		}
		//
		js.appendDeclaration(cgOperationCallExp);
		js.append(" = ");
		js.appendValueName(cgCacheInstance);
		js.append(".evaluate(");
		boolean isFirst = true;
		for (@NonNull CGValuedElement cgArgument : cgArguments) {
			if (!isFirst) {
				js.append(", ");
			}
			CGValuedElement argument = qvticg2javaVisitor.getExpression(cgArgument);
			js.appendValueName(argument);
			isFirst = false;
		}
		js.append(");\n");
		return true;
	}

	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
		return true;		 // functionality realized by finer-grained CG elements
	}

	protected final @NonNull CGProperty getCGCacheProperty(@NonNull CGClass cgCacheClass, @NonNull String name) {
		for (@NonNull CGProperty cgProperty : CGUtil.getProperties(cgCacheClass)) {
			Property asProperty = CGUtil.getAST(cgProperty);
			if (name.equals(asProperty.getName())) {
				return cgProperty;
			}
		}
		throw new IllegalStateException();
	}

	protected org.eclipse.ocl.pivot.@NonNull Package getCachePackage(@NonNull CodeGenAnalyzer analyzer, @NonNull Operation asOperation) {
		return AbstractLanguageSupport.getCachePackage(asOperation);
	}

	protected @NonNull OperationCallingConvention getConstructorEvaluateOperationCallingConvention() {
		return ConstructorEvaluateOperationCallingConvention.INSTANCE;
	}
}
