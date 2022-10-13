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

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.AbstractCachedOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.AbstractOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.CacheClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.ConstructorClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.ImmutableCachePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.OperationCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGFinalVariable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGIndexExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperationCallExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGShadowExp;
import org.eclipse.ocl.examples.codegen.cgmodel.CGShadowPart;
import org.eclipse.ocl.examples.codegen.cgmodel.CGTypeId;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.CGVariableExp;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.generator.TypeDescriptor;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportNameManager;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.java.JavaStream.SubStream;
import org.eclipse.ocl.examples.codegen.java.types.AbstractDescriptor;
import org.eclipse.ocl.examples.codegen.java.types.EObjectDescriptor;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.DataType;
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
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.evaluation.Evaluator;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.ElementId;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.PropertyId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.AbstractProperty;
import org.eclipse.ocl.pivot.library.LibraryConstants;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.LanguageSupport;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvticgmodel.CGConnectionVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunction;
import org.eclipse.qvtd.codegen.qvticgmodel.CGFunctionCallExp;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.CGSequence;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelFactory;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelCG2JavaVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.EntryPointsAnalysis;
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

	public static class CacheConstructorConstructorOperationCallingConvention extends DefaultCachedOperationCallingConvention
	{
		public static final @NonNull OperationCallingConvention INSTANCE = new CacheConstructorConstructorOperationCallingConvention();

		@Override
		public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
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

	protected final @NonNull Parameter createBoundValuesParameter(@NonNull QVTiCodeGenerator codeGenerator) {
		NameResolution boundValuesResolution = codeGenerator.getGlobalNameManager().getBoundValuesNameResolution();
		String boundValuesName = boundValuesResolution.getResolvedName();
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		assert jLanguageSupport != null;
		org.eclipse.ocl.pivot.Class boundValueType = jLanguageSupport.getNativeClass(Object[].class);
		Parameter asConstructorParameter = PivotUtil.createParameter(boundValuesName, boundValueType, true);
		return asConstructorParameter;
	}

	protected org.eclipse.ocl.pivot.@NonNull Class createCacheClass(@NonNull QVTiExecutableNameManager qvtiOperationNameManager) {
		QVTiAnalyzer qvtiAnalyzer = qvtiOperationNameManager.getAnalyzer();
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		ImperativeTransformation asTransformation = codeGenerator.getTransformation();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		ImportNameManager importNameManager = codeGenerator.getImportNameManager();
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		CGFunction cgFunction = (CGFunction)qvtiOperationNameManager.getCGScope();
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		//	assert QVTimperativeUtil.basicGetShadowExp(asFunction) == null;
		//
		org.eclipse.ocl.pivot.Class asCacheClass = jLanguageSupport.getCacheClass(asFunction);
		org.eclipse.ocl.pivot.Class asCacheSuperClass = jLanguageSupport.getNativeClass(AbstractComputation.class);
		asCacheClass.getSuperClasses().add(asCacheSuperClass);
		importNameManager.reserveLocalName(PivotUtil.getName(asCacheClass));
		//
		CGClass cgCacheClass = qvtiAnalyzer.generateClassDeclaration(asCacheClass, CacheClassCallingConvention.INSTANCE);
		CGClass cgSuperClass = qvtiAnalyzer.generateClassDeclaration(asCacheSuperClass, getClassCallingConvention());
		cgCacheClass.getSuperTypes().add(cgSuperClass);
		//
		NameResolution cachedResultNameResolution = globalNameManager.getCachedResultNameResolution();
		NameResolution thisTransformerNameResolution = globalNameManager.getThisTransformerNameResolution();
		installCacheProperty(qvtiAnalyzer, cgCacheClass, thisTransformerNameResolution, asTransformation);
		for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asFunction)) {
			installCacheProperty(qvtiAnalyzer, cgCacheClass, null, asParameter);
			// XXX need to support a cached invalid
		}
		installCacheProperty(qvtiAnalyzer, cgCacheClass, cachedResultNameResolution, asFunction);
		//
		installCacheConstructor(qvtiAnalyzer, cgCacheClass, asFunction);
		installCacheGetResultOperation(qvtiAnalyzer, cgCacheClass, asFunction);
		installCacheIsEqualOperation(qvtiAnalyzer, cgCacheClass, asFunction);
		return asCacheClass;
	}

	protected org.eclipse.ocl.pivot.@NonNull Class createConstructorClass(@NonNull QVTiExecutableNameManager qvtiOperationNameManager, org.eclipse.ocl.pivot.@NonNull Class asCacheClass) {
		QVTiAnalyzer qvtiAnalyzer = qvtiOperationNameManager.getAnalyzer();
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		ImportNameManager importNameManager = codeGenerator.getImportNameManager();
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		CGFunction cgFunction = (CGFunction)qvtiOperationNameManager.getCGScope();
		Function asFunction = QVTiCGUtil.getAST(cgFunction);
		//
		org.eclipse.ocl.pivot.Class asConstructorClass = jLanguageSupport.getConstructorClass(asFunction);
		org.eclipse.ocl.pivot.Class asConstructorSuperClass = jLanguageSupport.getNativeClass(AbstractComputationConstructor.class);
		asConstructorClass.getSuperClasses().add(asConstructorSuperClass);
		importNameManager.reserveLocalName(PivotUtil.getName(asConstructorClass));
		//
		CGClass cgConstructorClass = qvtiAnalyzer.generateClassDeclaration(asConstructorClass, ConstructorClassCallingConvention.INSTANCE);
		CGClass cgConstructorSuperClass = qvtiAnalyzer.generateClassDeclaration(asConstructorSuperClass, getClassCallingConvention());
		cgConstructorClass.getSuperTypes().add(cgConstructorSuperClass);
		//
		installCacheConstructorConstructorOperation(qvtiAnalyzer, cgConstructorClass);
		installCacheConstructorNewInstanceOperation(qvtiAnalyzer, cgConstructorClass, asCacheClass);
		//
		return asConstructorClass;
	}

	protected boolean doFunctionBody(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction) {
		CGValuedElement body = qvticg2javaVisitor.getExpression(cgFunction.getBody());
		ElementId elementId = cgFunction.getTypeId().getElementId();
		js.append(" {\n");
		js.pushIndentation(null);
		//		if (isIncremental) {
		//			js.append("super(\"");
		//			js.append(getFunctionName(cgFunction));
		//			js.append("\");\n");
		//		}
		//					js.appendCastParameters(localContext2, cgParameters);
		//					JavaDependencyVisitor dependencyVisitor = new JavaDependencyVisitor(localContext2, null);
		//					dependencyVisitor.visit(body);
		//					dependencyVisitor.visitAll(localContext2.getLocalVariables());
		//					Iterable<CGValuedElement> sortedDependencies = dependencyVisitor.getSortedDependencies();
		//					for (CGValuedElement cgElement : sortedDependencies) {
		//						if (!cgElement.isInlined() && cgElement.isConstant() && !cgElement.isGlobal()) {
		//							cgElement.accept(this);
		//						}
		//					}
		// FIXME merge locals into AST as LetExps.
		if (cgFunction.getBody() != null) {
			if (!js.appendLocalStatements(body)) {
				return false;
			}
			js.append("return ");
			js.appendValueName(body);
			js.append(";\n");
		}
		else {
			TypeId asTypeId = cgFunction.getASTypeId();
			if (asTypeId == TypeId.STRING) {			// FIXME Fudge for body-less functions
				js.append("return \"\";\n");
			}
			else if (asTypeId == TypeId.REAL) {			// FIXME Fudge for body-less functions
				js.append("return 0;\n");
			}
			else if (asTypeId == TypeId.INTEGER) {			// FIXME Fudge for body-less functions
				js.append("return 0;\n");
			}
			else if (asTypeId instanceof CollectionTypeId) {			// FIXME Fudge for body-less functions
				if (js.isUseNullAnnotations()) {
					js.appendSuppressWarningsNull(false);
					js.appendIsRequired(true);
					js.append(" ");
				}
				if (elementId != null) {
					TypeDescriptor javaTypeDescriptor = qvticg2javaVisitor.getCodeGenerator().getUnboxedDescriptor(elementId);
					js.appendClassReference(null, javaTypeDescriptor);
				}
				String emptyListName = qvticg2javaVisitor.getCodeGenerator().getGlobalNameManager().getEmptyListName();
				js.append(" " + emptyListName + " = ");
				js.appendClassReference(null, Collections.class);
				js.append("." + emptyListName + "();\n");
				js.append("return " + emptyListName + ";\n");
			}
			else {			// FIXME Fudge for body-less functions
				js.append("return \"\";\n");
			}
		}
		js.popIndentation();
		js.append("}\n");
		return true;
	}

	protected boolean doFunctionBody2(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction, @NonNull CGShadowExp cgShadowExp) {
		QVTiCodeGenerator codeGenerator = qvticg2javaVisitor.getCodeGenerator();
		boolean isIncremental = codeGenerator.getOptions().isIncremental();
		Function function = QVTiCGUtil.getAST(cgFunction);
		ImperativeTransformation transformation = QVTimperativeUtil.getContainingTransformation(function);
		EntryPointsAnalysis entryPointsAnalysis = codeGenerator.getEntryPointsAnalysis(transformation);
		String functionName = cgFunction.getResolvedName();
		String cachedResultName = codeGenerator.getGlobalNameManager().getCachedResultName();
		js.append(" {\n");
		js.pushIndentation(null);
		if (isIncremental) {
			js.append("super(\"");
			js.append(functionName);
			js.append("\");\n");
		}
		EClassifier eClassifier = ClassUtil.nonNullState(cgShadowExp.getEcoreClassifier());
		if (eClassifier instanceof EDataType) {
			CGShadowPart cgShadowPart = ClassUtil.nullFree(cgShadowExp.getParts()).get(0);
			CGValuedElement cgInit = ClassUtil.nonNullState(cgShadowPart.getInit());
			if (!js.appendLocalStatements(cgInit)) {
				return false;
			}

			List<CGParameter> cgParameters = cgFunction.getParameters();
			assert cgParameters.size() == 1;
			for (@NonNull CGParameter cgParameter : cgParameters) {
				js.appendDeclaration(cgParameter);
				js.append(" = ");
				assert !(cgParameter instanceof CGConnectionVariable);
				SubStream castBody = new SubStream() {
					@Override
					public void append() {
						js.append("boundValues[" + 0 + "]");
					}
				};
				js.appendClassCast(cgParameter, castBody);
				js.append(";\n");
			}



			qvticg2javaVisitor.doEcoreCreateDataType(cgShadowExp, (EDataType)eClassifier, cgInit);
		}
		else if (eClassifier instanceof EClass) {
			if (!qvticg2javaVisitor.doEcoreCreateClass(cgShadowExp, (EClass)eClassifier, false)) {
				return false;
			}
			GenModelHelper genModelHelper = qvticg2javaVisitor.getGenModelHelper();
			int index = 0;
			for (@NonNull CGShadowPart cgShadowPart : ClassUtil.nullFree(cgShadowExp.getParts())) {
				Property asProperty = ClassUtil.nonNullState(((ShadowPart)cgShadowPart.getAst()).getReferredProperty());
				EStructuralFeature eStructuralFeature = ClassUtil.nonNullState(qvticg2javaVisitor.getESObject(asProperty));
				js.appendValueName(cgShadowExp);
				js.append(".");
				if (eStructuralFeature.isMany()) {
					String getAccessor = genModelHelper.getGetAccessor(eStructuralFeature);
					//
					js.append(getAccessor);
					js.append("().addAll");
				}
				else {
					String setAccessor = genModelHelper.getSetAccessor(eStructuralFeature);
					//
					js.append(setAccessor);
				}
				js.append("(");
				int finalI = index++;
				SubStream castBody = new SubStream() {
					@Override
					public void append() {
						js.append("boundValues[" + finalI + "]");
					}
				};
				js.appendClassCast(cgShadowPart, castBody);
				js.append(");\n");
			}
		}
		//
		js.appendThis(functionName);
		js.append(".");
		js.append(cachedResultName);
		js.append(" = ");
		js.appendValueName(cgShadowExp);
		js.append(";\n");
		//
		EPackage ePackage = eClassifier.getEPackage();
		TypedModel bestOutputTypedModel = null;
		TypedModel bestMiddleTypedModel = null;
		TypedModel bestInputTypedModel = null;
		for (@NonNull TypedModel typedModel : QVTimperativeUtil.getModelParameters(entryPointsAnalysis.getTransformation())) {
			TypedModel imperativeTypedModel = null;
			for (org.eclipse.ocl.pivot.Package usedPackage : typedModel.getUsedPackage()) {
				if (usedPackage.getESObject() == ePackage) {
					imperativeTypedModel = typedModel;
				}
			}
			if (imperativeTypedModel != null) {
				if (QVTimperativeUtil.isOutput(imperativeTypedModel)) {
					bestOutputTypedModel = imperativeTypedModel;
				}
				else if (!QVTimperativeUtil.isInput(imperativeTypedModel)) {
					bestMiddleTypedModel = imperativeTypedModel;
				}
				else {
					bestInputTypedModel = imperativeTypedModel;
				}
			}
		}
		TypedModel asTypedModel = null;
		if (bestOutputTypedModel != null) {
			asTypedModel = bestOutputTypedModel;
		}
		else if (bestMiddleTypedModel != null) {
			asTypedModel = bestMiddleTypedModel;
		}
		else if (bestInputTypedModel != null) {
			asTypedModel = bestInputTypedModel;
		}
		if ((eClassifier instanceof EClass) && (asTypedModel != null)) {			// FIXME Why are shadow objects put in a model at all -- testQVTrCompiler_SeqToStm_CG requires it
			CGTypedModel cgTypedModel = qvticg2javaVisitor.getAnalyzer().getTypedModel(asTypedModel);
			qvticg2javaVisitor.appendModelReference(cgTypedModel);
			js.append(".add(");
			js.appendValueName(cgShadowExp);
			js.append(");\n");
		}
		//
		js.popIndentation();
		js.append("}\n");
		return true;
	}

	protected boolean doFunctionBody3(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction) {
		QVTiCodeGenerator codeGenerator = qvticg2javaVisitor.getCodeGenerator();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		String functionName = cgFunction.getResolvedName();
		String cachedResultName = globalNameManager.getCachedResultName();
		CGValuedElement cgBody = cgFunction.getBody();
		ElementId elementId = cgFunction.getTypeId().getElementId();
		// FIXME merge locals into AST as LetExps.
		if (cgBody != null) {
			CGValuedElement body = qvticg2javaVisitor.getExpression(cgBody);
			if (!js.appendLocalStatements(body)) {
				return false;
			}
			js.appendThis(functionName);
			js.append("." + cachedResultName + " = ");
			js.appendValueName(body);
			js.append(";\n");
		}
		/*	else if (QVTiCGUtil.getAST(cgFunction).getImplementationClass() != null) { -- Java Class has synthesized CGLibraryOperationCallExp
			final CGTypeId resultType = cgFunction.getTypeId();
			Function asFunction = QVTiCGUtil.getAST(cgFunction);
			TypeDescriptor functionTypeDescriptor = context.getTypeDescriptor(cgFunction).getEcoreDescriptor(context, null);
			//	js.append("/* " + localContext.getIdResolverVariable(cgFunction) + "* /");

			functionTypeDescriptor.appendBox(js, localContext, cgFunction, cgFunction);
			/*	js.appendClassReference(null, ValueUtil.class);
			js.append(".createSetValue(");
			js.appendValueName(resultType);
			js.append(", "); * /
			js.append(asFunction.getImplementationClass());
			js.append(".INSTANCE.evaluate(");
			js.append(qvtiGlobalContext.getExecutorName());
			js.append(", ");
			js.appendValueName(resultType);
			for (@NonNull CGParameter cgParameter : QVTiCGUtil.getParameters(cgFunction)) {
				js.append(", ");
				js.appendValueName(cgParameter);
			}
			js.append(");\n");
			js.appendThis(functionName);
			js.append("." + instanceName + " = ");
			js.appendValueName(cgFunction);
			js.append(";\n");
		} */
		else {
			TypeId asTypeId = cgFunction.getASTypeId();
			if (asTypeId == TypeId.STRING) {			// FIXME Fudge for body-less functions
				js.appendThis(functionName);
				js.append("." + cachedResultName + " = \"\";\n");
			}
			else if (asTypeId == TypeId.REAL) {			// FIXME Fudge for body-less functions
				js.appendThis(functionName);
				js.append("." + cachedResultName + " = 0;\n");
			}
			else if (asTypeId == TypeId.INTEGER) {			// FIXME Fudge for body-less functions
				js.appendThis(functionName);
				js.append("." + cachedResultName + " = 0;\n");
			}
			else if (asTypeId instanceof CollectionTypeId) {			// FIXME Fudge for body-less functions
				if (js.isUseNullAnnotations()) {
					js.appendSuppressWarningsNull(false);
					js.appendIsRequired(true);
					js.append(" ");
				}
				if (elementId != null) {
					TypeDescriptor javaTypeDescriptor = codeGenerator.getUnboxedDescriptor(elementId);
					js.appendClassReference(null, javaTypeDescriptor);
				}
				String emptyListName = globalNameManager.getEmptyListName();
				js.append(" " + emptyListName + " = ");
				js.appendClassReference(null, Collections.class);
				js.append("." + emptyListName + "();\n");
				js.appendThis(functionName);
				js.append("." + cachedResultName + " = " + emptyListName + ";\n");
			}
			else {			// FIXME Fudge for body-less functions
				js.appendThis(functionName);
				js.append("." + cachedResultName + " = \"\";\n");
			}
		}
		return true;
	}



	/*	protected void doFunctionConstructorInitializers(@NonNull CGTransformation cgTransformation) {
		String className = cgTransformation.getName();
		for (@NonNull CGOperation cgOperation : ClassUtil.nullFree(cgTransformation.getOperations())) {
			if (cgOperation instanceof CGFunction) {
				CGFunction cgFunction = (CGFunction) cgOperation;
				if ((useClass(cgFunction) != null) || useCache(cgFunction)) {
					js.append(getFunctionCtorName(cgFunction) + " = ");
					js.appendClassReference(ClassUtil.class);
					js.append(".nonNullState(" + getFunctionName(cgFunction) + ".class.getConstructor(" + className + ".class, " + "Object[].class));\n");
				}
			}
		}
	} */

	protected void doFunctionConstructor(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction) {
		QVTiCodeGenerator codeGenerator = qvticg2javaVisitor.getCodeGenerator();
		boolean isIncremental = codeGenerator.getOptions().isIncremental();
		String functionName = cgFunction.getResolvedName();
		NameResolution thisTransformerNameResolution = codeGenerator.getGlobalNameManager().getThisTransformerNameResolution();
		//	String thisTransformerName = globalContext.getThisTransformerName();
		//	String cachedResultName = globalContext.getCachedResultName();
		CGClass cgClass = ClassUtil.nonNullState(CGUtil.getContainingClass(cgFunction));
		List<@NonNull CGParameter> cgParameters = ClassUtil.nullFree(cgFunction.getParameters());
		CGValuedElement cgBody = cgFunction.getBody();
		if (cgBody != null) {
			js.appendCommentWithOCL(null, cgBody.getAst());
		}
		if (js.isUseNullAnnotations()) {
			js.append("@SuppressWarnings(\"null\")\n");		// Accurate casts are too hard
		}
		js.append("public ");
		js.append(functionName);
		js.append("(/*@Nullable*/ Object ");
		js.appendIsRequired(true);
		js.append(" [] boundValues) {\n");
		js.pushIndentation(null);
		if (isIncremental) {
			js.append("super(\"");
			js.append(functionName);
			js.append("\");\n");
		}
		//	js.appendThis(functionName);
		//	js.append("." + thisTransformerName + " = (");
		//	js.appendClassReference(cgClass);
		//	js.append(")boundValues[0];\n");
		int i = 0;
		for (@NonNull CGParameter cgParameter : cgParameters) {
			int finalI = i++;
			if (cgParameter.getNameResolution() == thisTransformerNameResolution) {			// XXX Is this irregularity really necessary
				String valueName = qvticg2javaVisitor.getResolvedName(cgParameter);
				js.appendThis(functionName);
				js.append(".");
				js.append(valueName);
				js.append(" = ");
				js.append("(");
				js.appendIsRequired(true);
				js.append(" ");
				js.append(cgClass.getName());
				js.append(")boundValues[" + finalI + "]");
				js.append(";\n");
			}
			else {
				SubStream castBody1 = new SubStream() {
					@Override
					public void append() {
						js.append("boundValues[" + finalI + "]");
					}
				};
				String valueName = qvticg2javaVisitor.getResolvedName(cgParameter);
				///	js.appendTypeDeclaration(cgParameter);
				//	TypeRepresentation boxedTypeRepresentation = js.getBoxedTypeRepresentation();
				//	boxedTypeRepresentation.appendTypeDeclaration(cgParameter);			// FIXME this doesn't enforce boxed if cgElement is primitive
				Boolean isRequired = codeGenerator.isRequired(cgParameter);
				js.appendIsCaught(cgParameter.isNonInvalid(), cgParameter.isCaught());
				js.append(" ");
				//	boxedTypeRepresentation.appendClassReference(isRequired, cgParameter);
				assert cgParameter != null;
				assert !cgParameter.getNamedValue().isCaught();
				ElementId elementId = cgParameter.getTypeId().getElementId();
				TypeDescriptor boxedTypeDescriptor = codeGenerator.getBoxedDescriptor(elementId);
				if ((cgParameter instanceof CGParameter) && (cgParameter.eContainer() instanceof CGOperation) && (boxedTypeDescriptor instanceof EObjectDescriptor)) {		// FIXME eliminate reclassing
					Class<?> originalJavaClass = ((EObjectDescriptor)boxedTypeDescriptor).getOriginalJavaClass();
					js.appendClassReference(isRequired, originalJavaClass);
				}
				else {
					boxedTypeDescriptor.append(js, isRequired);
				}
				js.append(" ");
				js.append(valueName);
				js.append(" = ");
				//	js.appendClassCast(cgParameter, castBody1);
				boxedTypeDescriptor.appendCast(js, isRequired, null, castBody1);
				js.append(";\n");
				SubStream castBody2 = new SubStream() {
					@Override
					public void append() {
						js.append(valueName);
					}
				};
				js.appendThis(functionName);			//  XXX Not needed. This is precisely "this"
				js.append(".");
				js.append(valueName);
				js.append(" = ");
				//	js.appendClassCast(cgParameter, castBody2);
				assert cgParameter != null;
				AbstractDescriptor declaredTypeDescriptor = (AbstractDescriptor) codeGenerator.getTypeDescriptor(cgParameter);
				declaredTypeDescriptor.appendCast(js, isRequired, declaredTypeDescriptor.getNonPrimitiveJavaClass(), castBody2);
				js.append(";\n");
			}
		}
		doFunctionBody3(qvticg2javaVisitor, js, cgFunction);
		js.popIndentation();
		js.append("}\n");
	}

	protected void doFunctionConstructor(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction, @NonNull CGShadowExp cgShadowExp) {
		//		List<@NonNull CGParameter> cgParameters = ClassUtil.nullFree(cgFunction.getParameters());
		//		if (js.isUseNullAnnotations()) {
		//			js.append("@SuppressWarnings(\"null\")\n");		// Accurate casts are too hard
		//		}
		js.append("public ");
		js.appendValueName(cgFunction);
		js.append("(/*Nullable*/ Object ");
		js.appendIsRequired(true);
		js.append(" [] boundValues) ");
		/*		int i = 0;
			for (@NonNull CGParameter cgParameter : cgParameters) {
				String valueName = getResolvedName(cgParameter);
				js.append(valueName);
				js.append(" = ");
	//							js.appendClassCast(cgFreeVariable);
				if (cgParameter instanceof CGConnectionVariable) {
					js.append("(");
					js.appendClassReference(null, cgParameter);
					js.append(".Accumulator)");						// FIXME Embed properly as a nested typeid
				}
				else{
					js.appendClassCast(cgParameter);
				}
				js.append("boundValues[" + i++);
				js.append("];\n");
			} */
		doFunctionBody2(qvticg2javaVisitor, js, cgFunction, cgShadowExp);
	}

	protected void doFunctionGetInstance(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction) {
		String cachedResultName = qvticg2javaVisitor.getCodeGenerator().getGlobalNameManager().getCachedResultName();
		js.append("@Override\n");
		js.append("public ");
		//	js.appendIsRequired(false);
		//	js.append(" Object");
		//	js.appendTypeDeclaration(ClassUtil.nonNullState(cgFunction.getBody()));
		CGValuedElement body = cgFunction.getBody();
		if (body != null) {				// XXX null while developing
			js.appendTypeDeclaration(ClassUtil.nonNullState(body));
		}
		js.append(" getResult() {\n");
		js.pushIndentation(null);
		js.append("return " + cachedResultName + ";\n");
		js.popIndentation();
		js.append("}\n");
	}

	protected void doFunctionIsEqual(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGFunction cgFunction) {
		String functionName = cgFunction.getResolvedName();
		//	String thisTransformerName = qvticg2javaVisitor.getCodeGenerator().getGlobalNameManager().getThisTransformerName();
		js.append("@Override\n");
		js.append("public boolean isEqual(");
		js.appendClassReference(true, IdResolver.class);
		js.append(" idResolver, ");
		js.appendIsRequired(false);
		js.append(" Object ");
		js.appendIsRequired(true);
		js.append(" [] thoseValues) {\n");
		js.pushIndentation(null);
		js.append("return ");
		//	js.appendThis(functionName);
		//	js.append("." + thisTransformerName + " == thoseValues[0]");
		int index = 0;
		for (@NonNull CGParameter cgParameter : ClassUtil.nullFree(cgFunction.getParameters())) {
			if (index > 0) {
				js.append("\n\t&& ");
			}
			js.append("idResolver.oclEquals(");	// FIXME oclEquals / ==
			js.appendThis(functionName);
			js.append(".");
			js.appendValueName(cgParameter);
			js.append(", thoseValues[" + index++ + "])");
		}
		js.append(";\n");
		js.popIndentation();
		js.append("}\n");
	}

	protected void doFunctionIsEqual(@NonNull QVTiCGModelCG2JavaVisitor qvticg2javaVisitor, @NonNull JavaStream js, @NonNull CGShadowExp cgShadowExp, @NonNull String instanceName) {
		js.append("@Override\n");
		js.append("public boolean isEqual(");
		js.appendClassReference(true, IdResolver.class);
		js.append(" idResolver, ");
		js.appendIsRequired(false);
		js.append(" Object ");
		js.appendIsRequired(true);
		js.append(" [] thoseValues) {\n");
		js.pushIndentation(null);
		js.append("return ");
		int index = 0;
		for (@NonNull CGShadowPart cgShadowPart : ClassUtil.nullFree(cgShadowExp.getParts())) {
			if (index > 0) {
				js.append("\n\t&& ");
			}
			js.append("idResolver.oclEquals(");	// FIXME oclEquals / ==
			Type type = ((TypedElement)cgShadowExp.getAst()).getType();
			if (type instanceof DataType) {
				js.append(instanceName);
			}
			else {
				js.append(instanceName);
				js.append(".");
				Property asProperty = ClassUtil.nonNullState(((ShadowPart)cgShadowPart.getAst()).getReferredProperty());
				EStructuralFeature eStructuralFeature = ClassUtil.nonNullState(qvticg2javaVisitor.getESObject(asProperty));
				String getAccessor;
				if (eStructuralFeature == OCLstdlibPackage.Literals.OCL_ELEMENT__OCL_CONTAINER) {
					getAccessor = "eContainer";
				}
				else {
					getAccessor = qvticg2javaVisitor.getGenModelHelper().getGetAccessor(eStructuralFeature);
				}
				js.append(getAccessor);
				js.append("()");
			}
			js.append(", thoseValues[" + index++ + "])");
		}
		js.append(";\n");
		js.popIndentation();
		js.append("}\n");
	}

	@Override
	public boolean generateJavaCall(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperationCallExp cgOperationCallExp) {
		QVTiCGModelCG2JavaVisitor qvticg2javaVisitor = (QVTiCGModelCG2JavaVisitor)cg2javaVisitor;
		CGFunctionCallExp cgFunctionCallExp = (CGFunctionCallExp)cgOperationCallExp;
		CGFunction cgFunction = (CGFunction)QVTiCGUtil.getOperation(cgFunctionCallExp);
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

	protected final @NonNull CGOperation installCacheConstructor(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull Operation asOperation) {
		QVTiAnalyzer qvtiAnalyzer = (QVTiAnalyzer)analyzer;
		QVTiCodeGenerator codeGenerator = qvtiAnalyzer.getCodeGenerator();
		QVTiGlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		EnvironmentFactory environmentFactory = codeGenerator.getEnvironmentFactory();
		org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
		//
		NameResolution ctorNameResolution = cgCacheClass.getNameResolution();
		String ctorName = ctorNameResolution.getResolvedName();
		Type asCacheType = environmentFactory.getStandardLibrary().getOclVoidType();
		Operation asCacheOperation = PivotUtil.createOperation(ctorName, asCacheType, null, null);
		Parameter asBoundValuesParameter = createBoundValuesParameter(codeGenerator);
		asCacheOperation.getOwnedParameters().add(asBoundValuesParameter);
		asCacheClass.getOwnedOperations().add(asCacheOperation);
		//
		ConstructorOperationCallingConvention callingConvention = ConstructorOperationCallingConvention.INSTANCE;
		CGTypeId cgTypeId = analyzer.getCGTypeId(TypeId.OCL_VOID);
		//
		CGOperation cgConstructor = callingConvention.createCGOperation(qvtiAnalyzer, asCacheOperation);
		cgConstructor.setCallingConvention(callingConvention);
		qvtiAnalyzer.initAst(cgConstructor, asCacheOperation, true);
		ctorNameResolution.addCGElement(cgConstructor);
		QVTiExecutableNameManager operationNameManager = qvtiAnalyzer.getOperationNameManager(null, asCacheOperation);
		List<@NonNull CGParameter> cgParameters = CGUtil.getParametersList(cgConstructor);
		CGParameter cgCacheBoundValuesParameter = operationNameManager.getCGParameter(asBoundValuesParameter, (String)null);
		globalNameManager.getBoundValuesNameResolution().addCGElement(cgCacheBoundValuesParameter);
		cgParameters.add(cgCacheBoundValuesParameter);

		CGParameter cgThisParameter = operationNameManager.getThisParameter();
		List<@NonNull CGProperty> cgProperties = CGUtil.getPropertiesList(cgCacheClass);
		CGSequence cgSequence = QVTiCGModelFactory.eINSTANCE.createCGSequence();
		List<@NonNull CGValuedElement> cgStatements = QVTiCGUtil.getOwnedStatementsList(cgSequence);
		//
		//	Unpack and assign boundValues
		//
		for (int i = 0; i < cgProperties.size()-1; i++) {	// XXX not cachedResult
			CGVariableExp cgVariableExp = analyzer.createCGVariableExp(cgCacheBoundValuesParameter);
			CGIndexExp cgIndexExp = analyzer.createCGIndexExp(cgVariableExp, i);
			cgIndexExp.setAst(asBoundValuesParameter);
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

	protected final @NonNull CGOperation installCacheConstructorConstructorOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgConstructorClass) {
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
		Parameter asBoundValuesParameter = createBoundValuesParameter(codeGenerator);
		asConstructorOperation.getOwnedParameters().add(asBoundValuesParameter);
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
		CGParameter cgConstructorBoundValuesParameter = operationNameManager.getCGParameter(asBoundValuesParameter, (String)null);
		globalNameManager.getBoundValuesNameResolution().addCGElement(cgConstructorBoundValuesParameter);
		cgCacheParameters.add(cgConstructorBoundValuesParameter);
		//
		//	Create CG body for newInstance
		//
		//	Implemented as direct synthesis in CacheConstructorConstructorOperationCallingConvention.
		//	Needs an ability to specify a super() invocation and no return type.
		//
		cgConstructorClass.getOperations().add(cgConstructorOperation);
		return cgConstructorOperation;
	}

	protected final @NonNull CGOperation installCacheConstructorNewInstanceOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgConstructorClass, org.eclipse.ocl.pivot.@NonNull Class asCacheClass) {
		//
		// AS Class - yyy2zzz
		// AS Properties -
		// AS Operation - yyy2zzz
		// AS Operation.ownedParameters -
		// AS Cache Operation - newInstance
		// AS Cache Operation.parameters - boundValues
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
		Parameter asBoundValuesParameter = createBoundValuesParameter(codeGenerator);
		asConstructorOperation.getOwnedParameters().add(asBoundValuesParameter);
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
		CGParameter cgConstructorBoundValuesParameter = operationNameManager.getCGParameter(asBoundValuesParameter, (String)null);
		globalNameManager.getBoundValuesNameResolution().addCGElement(cgConstructorBoundValuesParameter);
		cgCacheParameters.add(cgConstructorBoundValuesParameter);
		//
		//	Create CG body for newInstance
		//
		//	Implemented as direct synthesis in CacheConstructorNewInstanceOperationCallingConvention.
		//	Needs an ability to specify a new T invocation.
		//
		cgConstructorClass.getOperations().add(cgConstructorOperation);
		return cgConstructorOperation;
	}

	protected final @NonNull CGOperation installCacheGetResultOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull Operation asOperation) {
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
		OperationCallingConvention callingConvention = DefaultCachedOperationCallingConvention.INSTANCE;
		CGOperation cgCacheOperation = callingConvention.createCGOperation(qvtiAnalyzer, asCacheOperation);
		analyzer.initAst(cgCacheOperation, asCacheOperation, true);
		cgCacheOperation.setCallingConvention(callingConvention);
		getResultNameResolution.addCGElement(cgCacheOperation);
		/*QVTiExecutableNameManager operationNameManager =*/ qvtiAnalyzer.getOperationNameManager(cgCacheOperation, asCacheOperation);
		//	List<@NonNull CGParameter> cgCacheParameters = CGUtil.getParametersList(cgCacheOperation);
		//	cgCacheParameters.add(operationNameManager.getIdResolverParameter());
		//	CGParameter cgCacheBoundValuesParameter = operationNameManager.getCGParameter(asBoundValuesParameter, (String)null);
		//	cgCacheParameters.add(cgCacheBoundValuesParameter);
		//
		//	Create CG body for isEqual unpacking boundValues to regular parameter variables
		//
		CGValuedElement cgResult = qvtiAnalyzer.createCGElement(CGValuedElement.class, asExpressionInOCL);
		cgCacheOperation.setBody(cgResult);
		//
		cgCacheClass.getOperations().add(cgCacheOperation);
		return cgCacheOperation;
	}

	protected final @NonNull CGOperation installCacheIsEqualOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull Operation asOperation) {
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
		CGParameter cgCacheBoundValuesParameter = operationNameManager.getCGParameter(asBoundValuesParameter, (String)null);
		globalNameManager.getBoundValuesNameResolution().addCGElement(cgCacheBoundValuesParameter);
		cgCacheParameters.add(cgCacheBoundValuesParameter);
		//	operationNameManager.getIdResolverParameter();
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

	protected final void installCacheProperty(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass,
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
