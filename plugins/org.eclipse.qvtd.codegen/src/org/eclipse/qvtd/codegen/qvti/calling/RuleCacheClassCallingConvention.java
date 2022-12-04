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

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.AbstractCachedOperationCallingConvention2.CacheInstancePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.AbstractCachedOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.AbstractClassCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGParameter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportNameManager;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaConstants;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.naming.ClassNameManager;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.naming.GlobalNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameManagerHelper;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.naming.PackageNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.internal.library.executor.AbstractEvaluationOperation;
import org.eclipse.ocl.pivot.utilities.AbstractLanguageSupport;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.LanguageSupport;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiGlobalNameManager;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariable;
import org.eclipse.qvtd.codegen.qvticgmodel.CGRealizedVariablePart;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;

import com.google.common.collect.Iterables;

/**
 *  RuleCacheClassCallingConvention defines the nested Class that defines the cache of all executions of a particular rule.
 */
public class RuleCacheClassCallingConvention extends AbstractClassCallingConvention
{
	public static final @NonNull RuleCacheClassCallingConvention INSTANCE = new RuleCacheClassCallingConvention();

	public static class BasicEvaluateOperationCallingConvention extends AbstractCachedOperationCallingConvention
	{
		public static final @NonNull BasicEvaluateOperationCallingConvention INSTANCE = new BasicEvaluateOperationCallingConvention();

		@Override
		public void createCGBody(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgCacheOperation) {
			//	Implemented as direct synthesis
		}

		public final @NonNull CGOperation createOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull NewStatement asNewStatement) {
			JavaCodeGenerator codeGenerator = analyzer.getCodeGenerator();
			GlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
			EnvironmentFactory environmentFactory = codeGenerator.getEnvironmentFactory();
			org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
			//
			//	Create AS declaration for basicEvaluate
			//
			NameResolution basicEvaluateNameResolution = globalNameManager.getBasicEvaluateNameResolution();
			String basicEvaluateName = basicEvaluateNameResolution.getResolvedName();
			Type asReturnType = environmentFactory.getStandardLibrary().getBooleanType();
			Operation asCacheOperation = PivotUtil.createOperation(basicEvaluateName, asReturnType, null, null);
			asCacheOperation.setIsRequired(true);
			Parameter asBoxedValuesParameter = createBoxedValuesParameter(codeGenerator);
			asCacheOperation.getOwnedParameters().add(asBoxedValuesParameter);
			asCacheClass.getOwnedOperations().add(asCacheOperation);
			//
			//	Create AS body for basicEvaluate
			//
			/*	directly synthesized for now */
			//
			//	Create CG declaration for basicEvaluate
			//
			CGOperation cgCacheOperation = createCGOperation(analyzer, asCacheOperation);
			analyzer.initAst(cgCacheOperation, asCacheOperation, true);
			cgCacheOperation.setCallingConvention(this);
			basicEvaluateNameResolution.addCGElement(cgCacheOperation);
			ExecutableNameManager operationNameManager = analyzer.getOperationNameManager(cgCacheOperation, asCacheOperation);
			List<@NonNull CGParameter> cgCacheParameters = CGUtil.getParametersList(cgCacheOperation);
			CGParameter cgIdResolverParameter = operationNameManager.getIdResolverParameter();
			cgCacheParameters.add(cgIdResolverParameter);
			CGParameter cgCacheBoxedValuesParameter = operationNameManager.getCGParameter(asBoxedValuesParameter, (String)null);
			globalNameManager.getBoxedValuesNameResolution().addCGElement(cgCacheBoxedValuesParameter);
			cgCacheParameters.add(cgCacheBoxedValuesParameter);
			//
			cgCacheClass.getOperations().add(cgCacheOperation);
			return cgCacheOperation;
		}

		@Override
		public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
			QVTiAnalyzer analyzer = (QVTiAnalyzer)cg2javaVisitor.getAnalyzer();
			QVTiCodeGenerator codeGenerator = analyzer.getCodeGenerator();
			QVTiGlobalNameManager globalNameManager = analyzer.getGlobalNameManager();
			GenModelHelper genModelHelper = analyzer.getGenModelHelper();
			//
			CGClass cgClass = CGUtil.getContainingClass(cgOperation);
			org.eclipse.ocl.pivot.Class asCacheClass = CGUtil.getAST(cgClass);
			NewStatement asNewStatement = (NewStatement)analyzer.getOrigin(asCacheClass);
			CGRealizedVariable cgRealizedVariable = analyzer.getCGRealizedVariable(asNewStatement);
			CGExecutorType cgExecutorType = QVTiCGUtil.getExecutorType(cgRealizedVariable);
			TypedModel asTypedModel = ClassUtil.nonNullState(asNewStatement.getReferredTypedModel());
			CGTypedModel cgTypedModel = ClassUtil.nonNullState(analyzer.getTypedModel(asTypedModel));
			int modelIndex = cgTypedModel.getModelIndex();
			//
			String instanceName = "instance";
			//
			Iterable<@NonNull CGRealizedVariablePart> ownedParts = QVTiCGUtil.getOwnedParts(cgRealizedVariable);
			assert Iterables.size(ownedParts) > 0;
			org.eclipse.ocl.pivot.@NonNull Class asClass = (org.eclipse.ocl.pivot.Class)CGUtil.getAST(cgExecutorType);
			List<@NonNull CGProperty> cgProperties = new ArrayList<>();
			for (@NonNull CGRealizedVariablePart ownedPart : ownedParts) {
				cgProperties.add(QVTiCGUtil.getReferredProperty(ownedPart));
			}
			Collections.sort(cgProperties, NameUtil.NAMEABLE_COMPARATOR);
			js.append("/**\n");
			js.append(" * The inner evaluation, creates, initializes and installs the new trace singleton.\n");
			js.append(" */\n");
			js.append("@Override\n");
			js.append("public ");
			js.appendClassReference(false, Object.class);
			js.append(" basicEvaluate(");
			js.appendClassReference(true, Executor.class);
			js.append(" ");
			js.append(globalNameManager.getExecutorName());
			js.append(", ");
			js.appendClassReference(true, TypedElement.class);
			js.append(" ");
			js.append("caller");
			js.append(", ");
			js.appendClassReference(false, Object.class);
			js.append(" ");
			js.appendIsRequired(true);
			js.append(" [] ");
			js.append(JavaConstants.SOURCE_AND_ARGUMENT_VALUES_NAME);
			js.append(") {\n");
			js.pushIndentation(null);
			//	Create trace instance
			EClass eClass = (EClass)asClass.getESObject();
			assert eClass != null;
			GenClassifier genClassifier = genModelHelper.getGenClassifier(asClass);
			assert genClassifier != null;
			String createMethodName = "create" + genClassifier.getName();		// EMF provides no API for this.
			boolean canSetNonNull = false;
			EPackage ePackage = eClass.getEPackage();
			String javaClass;
			if (ePackage != null) {
				Class<?> factoryClass = genModelHelper.getEcoreFactoryClass(ePackage);
				if (factoryClass != null) {
					javaClass = factoryClass.getName();
					Method factoryMethod = codeGenerator.getLeastDerivedMethod(factoryClass, createMethodName);
					if (factoryMethod != null) {
						if (codeGenerator.getIsNonNull(factoryMethod) == Boolean.TRUE) {
							canSetNonNull = true;
						}
					}
				}
				else {
					javaClass = genModelHelper.getQualifiedFactoryInterfaceName(ePackage);
				}
			}
			else {
				javaClass = null;
			}
			//
			js.appendTypeDeclaration(cgExecutorType);
			js.append(" " + instanceName + " = ");
			js.appendClassReference(null, javaClass);
			js.append(".eINSTANCE.");
			js.append(createMethodName);
			js.append("();\n");
			//	Assign trace properties
			Map<@NonNull Property, @NonNull String> oppositeProperties = codeGenerator.getOppositeProperties();
			int i = 0;
			for (@NonNull CGProperty cgProperty : cgProperties) {
				Property asProperty = QVTiCGUtil.getAST(cgProperty);
				String setAccessor = genModelHelper.getSetAccessor((EStructuralFeature)asProperty.getESObject());
				if (cgProperty.getASTypeId() instanceof CollectionTypeId) {
					js.append("@SuppressWarnings(\"unchecked\") ");
				}
				else if (cgProperty.isRequired()) {
					if (js.appendSuppressWarningsNull(false)) {
						js.append(" ");
					}
				}
				js.appendTypeDeclaration(cgProperty);
				js.append(" value" + i + " = (");
				js.appendTypeDeclaration(cgProperty);
				js.append(")");
				js.append(JavaConstants.SOURCE_AND_ARGUMENT_VALUES_NAME);
				js.append("[" + i + "];\n");

				js.append(instanceName + "." + setAccessor + "(value" + i);
				js.append(");\n");

				if (oppositeProperties != null) {
					Property iProperty = QVTiCGUtil.getAST(cgProperty);
					String cacheName = oppositeProperties.get(iProperty);
					if (cacheName != null) {
						js.append(cacheName);
						js.append(".put(value" + i);
						js.append(", ");
						js.append(instanceName);
						js.append(");\n");
					}
				}
				i++;
			}
			// Install trace instance
			js.append(globalNameManager.getModelsName());
			js.append("[" + modelIndex + "].add(");
			js.append(instanceName);
			js.append(", false);\n");
			js.append("return " + instanceName + ";\n");
			js.popIndentation();
			js.append("}\n");
			return true;
		}
	}

	public static class EvaluateOperationCallingConvention extends AbstractCachedOperationCallingConvention
	{
		public static final @NonNull EvaluateOperationCallingConvention INSTANCE = new EvaluateOperationCallingConvention();

		@Override
		public void createCGBody(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgCacheOperation) {
			//	Implemented as direct synthesis
		}

		public final @NonNull CGOperation createOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull NewStatement asNewStatement) {
			JavaCodeGenerator codeGenerator = analyzer.getCodeGenerator();
			GlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
			EnvironmentFactory environmentFactory = codeGenerator.getEnvironmentFactory();
			org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
			//
			//	Create AS declaration for evaluate
			//
			NameResolution basicEvaluateNameResolution = globalNameManager.getBasicEvaluateNameResolution();
			String basicEvaluateName = basicEvaluateNameResolution.getResolvedName();
			Type asReturnType = environmentFactory.getStandardLibrary().getBooleanType();
			Operation asCacheOperation = PivotUtil.createOperation(basicEvaluateName, asReturnType, null, null);
			asCacheOperation.setIsRequired(true);
			Parameter asBoxedValuesParameter = createBoxedValuesParameter(codeGenerator);
			asCacheOperation.getOwnedParameters().add(asBoxedValuesParameter);
			asCacheClass.getOwnedOperations().add(asCacheOperation);
			//
			//	Create AS body for evaluate
			//
			/*	directly synthesized for now */
			//
			//	Create CG declaration for evaluate
			//
			CGOperation cgCacheOperation = createCGOperation(analyzer, asCacheOperation);
			analyzer.initAst(cgCacheOperation, asCacheOperation, true);
			cgCacheOperation.setCallingConvention(this);
			basicEvaluateNameResolution.addCGElement(cgCacheOperation);
			ExecutableNameManager operationNameManager = analyzer.getOperationNameManager(cgCacheOperation, asCacheOperation);
			List<@NonNull CGParameter> cgCacheParameters = CGUtil.getParametersList(cgCacheOperation);
			CGParameter cgIdResolverParameter = operationNameManager.getIdResolverParameter();
			cgCacheParameters.add(cgIdResolverParameter);
			CGParameter cgCacheBoxedValuesParameter = operationNameManager.getCGParameter(asBoxedValuesParameter, (String)null);
			globalNameManager.getBoxedValuesNameResolution().addCGElement(cgCacheBoxedValuesParameter);
			cgCacheParameters.add(cgCacheBoxedValuesParameter);
			//
			cgCacheClass.getOperations().add(cgCacheOperation);
			return cgCacheOperation;
		}

		@Override
		public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGOperation cgOperation) {
			QVTiAnalyzer analyzer = (QVTiAnalyzer)cg2javaVisitor.getAnalyzer();
			QVTiCodeGenerator codeGenerator = analyzer.getCodeGenerator();
			QVTiGlobalNameManager globalNameManager = analyzer.getGlobalNameManager();
			GenModelHelper genModelHelper = analyzer.getGenModelHelper();
			//
			CGClass cgClass = CGUtil.getContainingClass(cgOperation);
			org.eclipse.ocl.pivot.Class asCacheClass = CGUtil.getAST(cgClass);
			NewStatement asNewStatement = (NewStatement)analyzer.getOrigin(asCacheClass);
			CGRealizedVariable cgRealizedVariable = analyzer.getCGRealizedVariable(asNewStatement);
			CGExecutorType cgExecutorType = QVTiCGUtil.getExecutorType(cgRealizedVariable);
			//
			Iterable<@NonNull CGRealizedVariablePart> ownedParts = QVTiCGUtil.getOwnedParts(cgRealizedVariable);
			assert Iterables.size(ownedParts) > 0;
			List<@NonNull CGProperty> cgProperties = new ArrayList<>();
			for (@NonNull CGRealizedVariablePart ownedPart : ownedParts) {
				cgProperties.add(QVTiCGUtil.getReferredProperty(ownedPart));
			}
			Collections.sort(cgProperties, NameUtil.NAMEABLE_COMPARATOR);
			js.append("/**\n");
			js.append(" * The outer evaluation provides a type safe interface.\n");
			js.append(" */\n");
			js.append("public ");
			js.appendClassReference(true, cgExecutorType);
			js.append(" ");
			js.append(globalNameManager.getEvaluateName());
			js.append("(");
			boolean isFirst = true;
			for (@NonNull CGProperty cgProperty : cgProperties) {
				if (!isFirst) {
					js.append(", ");
				}
				js.appendDeclaration(cgProperty);
				isFirst = false;
			}
			js.append(") {\n");
			js.pushIndentation(null);
			js.append("return (");
			js.appendClassReference(true, cgExecutorType);
			js.append(")");
			js.append(globalNameManager.getEvaluationCacheName());
			js.append(".");
			js.append(globalNameManager.getGetCachedEvaluationResultName());
			js.append("(this, caller, new ");
			js.appendClassReference(false, Object.class);
			js.append("[]{");
			isFirst = true;
			for (@NonNull CGProperty cgProperty : cgProperties) {
				if (!isFirst) {
					js.append(", ");
				}
				js.appendValueName(cgProperty);
				isFirst = false;
			}
			js.append("});\n");
			js.popIndentation();
			js.append("}\n");
			return true;
		}
	}

	/*	protected void doCachedInstanceEvaluate() {
	} */

	@Override
	public @NonNull CGClass createCGClass(@NonNull CodeGenAnalyzer analyzer, org.eclipse.ocl.pivot.@NonNull Class asClass) {
		CGClass cgClass = createCGClass();
		installCGRootClassParent(analyzer, cgClass, asClass);
		return cgClass;
	}

	public org.eclipse.ocl.pivot.@NonNull Class createCacheClass(@NonNull ClassNameManager classNameManager, @NonNull NewStatement asNewStatement) {
		CodeGenAnalyzer analyzer = classNameManager.getAnalyzer();
		JavaCodeGenerator codeGenerator = analyzer.getCodeGenerator();
		ImportNameManager importNameManager = codeGenerator.getImportNameManager();
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		org.eclipse.ocl.pivot.Class asClass = classNameManager.getASClass();
		org.eclipse.ocl.pivot.@NonNull Package asParentPackage = getParentPackage(analyzer, asClass);
		//
		PackageNameManager packageNameManager = analyzer.getPackageNameManager(null, asParentPackage);
		String entryClassName = packageNameManager.getUniqueClassName(NameManagerHelper.RULE_CACHE_CLASS_NAME_PREFIX, asClass);
		org.eclipse.ocl.pivot.Class asCacheClass = AbstractLanguageSupport.getClass(asParentPackage, entryClassName);
		org.eclipse.ocl.pivot.Class asCacheClassSuperClass = jLanguageSupport.getNativeClass(/*isIncremental ? AbstractEvaluationOperation.Incremental.class :*/ AbstractEvaluationOperation.class);
		asCacheClass.getSuperClasses().add(asCacheClassSuperClass);
		importNameManager.reserveLocalName(PivotUtil.getName(asCacheClass));
		//
		CGClass cgCacheClass = analyzer.generateClassDeclaration(asCacheClass, this);
		CGClass cgCacheSuperClass = analyzer.generateClassDeclaration(asCacheClassSuperClass, null);
		cgCacheClass.getSuperTypes().add(cgCacheSuperClass);
		//
		BasicEvaluateOperationCallingConvention.INSTANCE.createOperation(analyzer, cgCacheClass, asNewStatement);
		EvaluateOperationCallingConvention.INSTANCE.createOperation(analyzer, cgCacheClass, asNewStatement);
		createCacheInstance(classNameManager, asCacheClass, asNewStatement);
		return asCacheClass;
	}

	protected final @NonNull Property createCacheInstance(@NonNull ClassNameManager classNameManager, org.eclipse.ocl.pivot.@NonNull Class asCacheClass, @NonNull NewStatement asNewStatement) {
		QVTiAnalyzer analyzer = (QVTiAnalyzer) classNameManager.getAnalyzer();
		String propertyName = classNameManager.getUniquePropertyName(NameManagerHelper.INSTANCE_PROPERTY_NAME_PREFIX, asCacheClass);
		Property asProperty = PivotUtil.createProperty(propertyName, asCacheClass);
		//	org.eclipse.ocl.pivot.Class asClass = classNameManager.getASClass();
		analyzer.addCacheInstance(asNewStatement, asProperty, asCacheClass);
		//
		CGProperty cgProperty = analyzer.createCGElement(CGProperty.class, asProperty);
		cgProperty.setCallingConvention(CacheInstancePropertyCallingConvention.INSTANCE);
		assert cgProperty.eContainer() != null;
		return asProperty;
	}

	/**
	 * Generate the Java code for a Class declaration.
	 * Returns true if control flow continues, false if an exception throw has been synthesized.
	 */
	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGClass cgClass) {
		CodeGenAnalyzer analyzer = cg2javaVisitor.getAnalyzer();
		org.eclipse.ocl.pivot.Class asClass = CGUtil.getAST(cgClass);
		NewStatement asNewStatement = (NewStatement)analyzer.getOrigin(asClass);
		//	if (isEmpty(cgClass)) {
		//		return true;
		//	}
		js.append("\n");
		String className = CGUtil.getName(cgClass);
		CGPackage cgContainingPackage = cgClass.getContainingPackage();
		assert cgContainingPackage == null;
		String title = "The instance of " + cgClass.getName() + " caches the result of each distinct creation of\n";
		js.appendCommentWithOCL(title, asNewStatement/*.getOwnedExpression()*/);			// XXX lookup rule
		js.append("private class " + className);
		appendSuperTypes(js, cgClass);
		js.pushClassBody(className);
		generateProperties(cg2javaVisitor, js, cgClass);
		generateOperations(cg2javaVisitor, js, cgClass);
		js.popClassBody(false);
		return true;
	}

	protected org.eclipse.ocl.pivot.@NonNull Package getParentPackage(@NonNull CodeGenAnalyzer analyzer, org.eclipse.ocl.pivot.@NonNull Class asClass) {
		CGClass cgClass = analyzer.getCGRootClass(asClass);
		org.eclipse.ocl.pivot.Class asRootClass = CGUtil.getAST(cgClass);
		return AbstractLanguageSupport.getCachePackage(asRootClass);
	}
}