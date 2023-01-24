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
import java.util.List;
import java.util.Map;
import org.eclipse.emf.codegen.ecore.genmodel.GenClassifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.AbstractCachePropertyCallingConvention.DefaultInstancePropertyCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.AbstractClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.AbstractUncachedOperationCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorType;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.cgmodel.CGProperty;
import org.eclipse.ocl.examples.codegen.generator.GenModelHelper;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.internal.library.executor.AbstractEvaluationOperation;
import org.eclipse.ocl.pivot.utilities.AbstractLanguageSupport;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.LanguageSupport;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer;
import org.eclipse.qvtd.codegen.qvti.analyzer.QVTiAnalyzer.CreationCache;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.codegen.qvti.naming.QVTiGlobalNameManager;
import org.eclipse.qvtd.codegen.qvticgmodel.CGTypedModel;
import org.eclipse.qvtd.codegen.utilities.QVTiCGUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;

/**
 *  RuleCacheClassCallingConvention defines the nested Class that defines the cache of all executions of a particular rule.
 */
public class RuleCacheClassCallingConvention extends AbstractClassCallingConvention
{
	private static final @NonNull RuleCacheClassCallingConvention INSTANCE = new RuleCacheClassCallingConvention();

	public static @NonNull RuleCacheClassCallingConvention getInstance(org.eclipse.ocl.pivot.@NonNull Class asClass) {
		INSTANCE.logInstance(asClass);
		return INSTANCE;
	}

	public static class BasicEvaluateOperationCallingConvention extends AbstractUncachedOperationCallingConvention
	{
		private static final @NonNull BasicEvaluateOperationCallingConvention INSTANCE = new BasicEvaluateOperationCallingConvention();

		public static @NonNull BasicEvaluateOperationCallingConvention getInstance(org.eclipse.ocl.pivot.@NonNull Class asClass) {
			INSTANCE.logInstance(asClass);
			return INSTANCE;
		}

		@Override
		public void createCGBody(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgCacheOperation) {
			//	Implemented as direct synthesis
		}

		public final @NonNull CGOperation createOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull NewStatement asNewStatement) {
			JavaCodeGenerator codeGenerator = analyzer.getCodeGenerator();
			GlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
			org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
			//
			//	Create AS declaration for basicEvaluate
			//
			NameResolution basicEvaluateNameResolution = globalNameManager.getBasicEvaluateNameResolution();
			String basicEvaluateName = basicEvaluateNameResolution.getResolvedName();
			Operation asCacheOperation = createASOperationDeclaration(analyzer, asCacheClass, asNewStatement,
				basicEvaluateName, ASResultStyle.BOOLEAN);
			//
			//	Create AS body for basicEvaluate
			//
			/*	directly synthesized for now */
			//
			//	Create CG declaration for basicEvaluate
			//
			CGOperation cgCacheOperation = createCGOperationDeclaration(analyzer, cgCacheClass, asCacheOperation,
				basicEvaluateNameResolution, null);
			/*	CGOperation cgCacheOperation = createCGOperation(analyzer, asCacheOperation);
			analyzer.initAst(cgCacheOperation, asCacheOperation, true);
			cgCacheOperation.setCallingConvention(this);
			basicEvaluateNameResolution.addCGElement(cgCacheOperation);
			ExecutableNameManager operationNameManager = analyzer.getOperationNameManager(cgCacheOperation, asCacheOperation);
			List<@NonNull CGParameter> cgCacheParameters = CGUtil.getParametersList(cgCacheOperation);
			CGParameter cgIdResolverParameter = operationNameManager.getIdResolverParameter();
			cgCacheParameters.add(cgIdResolverParameter);
			Parameter asBoxedValuesParameter = getBoxedValuesParameter(analyzer, asCacheOperation);
			CGParameter cgCacheBoxedValuesParameter = operationNameManager.getCGParameter(asBoxedValuesParameter, (String)null);
			globalNameManager.getBoxedValuesNameResolution().addCGElement(cgCacheBoxedValuesParameter);
			cgCacheParameters.add(cgCacheBoxedValuesParameter);
			//
			cgCacheClass.getOperations().add(cgCacheOperation); */
			return cgCacheOperation;
		}

		@Override
		public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull CGOperation cgOperation) {
			JavaStream js = cg2javaVisitor.getJavaStream();
			QVTiAnalyzer analyzer = (QVTiAnalyzer)cg2javaVisitor.getAnalyzer();
			QVTiCodeGenerator codeGenerator = analyzer.getCodeGenerator();
			QVTiGlobalNameManager globalNameManager = analyzer.getGlobalNameManager();
			GenModelHelper genModelHelper = analyzer.getGenModelHelper();
			//
			CGClass cgCacheClass = CGUtil.getContainingClass(cgOperation);
			org.eclipse.ocl.pivot.Class asCacheClass = CGUtil.getAST(cgCacheClass);
			CreationCache creationCache = analyzer.getCreationCache(asCacheClass);
			CGExecutorType cgExecutorType = creationCache.getExecutorType();
			TypedModel asTypedModel = creationCache.getTypedModel();
			CGTypedModel cgTypedModel = ClassUtil.nonNullState(analyzer.getTypedModel(asTypedModel));
			int modelIndex = cgTypedModel.getModelIndex();
			//
			String instanceName = "instance";
			//
			org.eclipse.ocl.pivot.@NonNull Class asClass = (org.eclipse.ocl.pivot.Class)CGUtil.getAST(cgExecutorType);
			List<@NonNull CGProperty> cgProperties = new ArrayList<>();
			for (@NonNull Property asProperty : creationCache.getProperties()) {
				CGProperty cgProperty = analyzer.getCGProperty(asProperty);
				cgProperties.add(cgProperty);
			}
			js.append("/**\n");
			js.append(" * The inner evaluation, creates, initializes and installs the new trace singleton.\n");
			js.append(" */\n");
			js.append("// " + cgOperation.getCallingConvention() + "\n");
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

		@Override
		protected @NonNull ASParameterStyle @NonNull [] getASParameterStyles(@NonNull TypedElement asOrigin) {
			return AS_PARAMETER_STYLES_BOXED_VALUES_OPTIONAL;
		}

		@Override
		protected @NonNull CGParameterStyle @NonNull [] getCGParameterStyles(@NonNull ExecutableNameManager operationNameManager) {
			return CG_PARAMETER_STYLES_ID_RESOLVER_BOXED_VALUES;
		}
	}

	public static class EvaluateOperationCallingConvention extends AbstractUncachedOperationCallingConvention
	{
		private static final @NonNull EvaluateOperationCallingConvention INSTANCE = new EvaluateOperationCallingConvention();

		public static @NonNull EvaluateOperationCallingConvention getInstance(org.eclipse.ocl.pivot.@NonNull Class asClass) {
			INSTANCE.logInstance(asClass);
			return INSTANCE;
		}

		@Override
		public void createCGBody(@NonNull CodeGenAnalyzer analyzer, @NonNull CGOperation cgCacheOperation) {
			//	Implemented as direct synthesis
		}

		public final @NonNull CGOperation createOperation(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass, @NonNull NewStatement asNewStatement) {
			JavaCodeGenerator codeGenerator = analyzer.getCodeGenerator();
			GlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
			org.eclipse.ocl.pivot.@NonNull Class asCacheClass = CGUtil.getAST(cgCacheClass);
			//
			//	Create AS declaration for evaluate
			//
			NameResolution basicEvaluateNameResolution = globalNameManager.getBasicEvaluateNameResolution();
			String basicEvaluateName = basicEvaluateNameResolution.getResolvedName();
			Operation asCacheOperation = createASOperationDeclaration(analyzer, asCacheClass, asNewStatement,
				basicEvaluateName, ASResultStyle.BOOLEAN);
			//
			//	Create AS body for evaluate
			//
			/*	directly synthesized for now */
			//
			//	Create CG declaration for evaluate
			//
			CGOperation cgCacheOperation = createCGOperationDeclaration(analyzer, cgCacheClass, asCacheOperation,
				basicEvaluateNameResolution, null);
			return cgCacheOperation;
		}

		@Override
		public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull CGOperation cgOperation) {
			JavaStream js = cg2javaVisitor.getJavaStream();
			QVTiAnalyzer analyzer = (QVTiAnalyzer)cg2javaVisitor.getAnalyzer();
			QVTiGlobalNameManager globalNameManager = analyzer.getGlobalNameManager();
			//
			CGClass cgCacheClass = CGUtil.getContainingClass(cgOperation);
			org.eclipse.ocl.pivot.Class asCacheClass = CGUtil.getAST(cgCacheClass);
			CreationCache creationCache = analyzer.getCreationCache(asCacheClass);
			CGExecutorType cgExecutorType = creationCache.getExecutorType();
			//
			List<@NonNull CGProperty> cgProperties = new ArrayList<>();
			for (@NonNull Property asProperty : creationCache.getProperties()) {
				CGProperty cgProperty = analyzer.getCGProperty(asProperty);
				cgProperties.add(cgProperty);
			}
			js.append("/**\n");
			js.append(" * The outer evaluation provides a type safe interface.\n");
			js.append(" */\n");
			js.append("// " + cgOperation.getCallingConvention() + "\n");
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

		@Override
		protected @NonNull ASParameterStyle @NonNull [] getASParameterStyles(@NonNull TypedElement asOrigin) {
			return AS_PARAMETER_STYLES_BOXED_VALUES_OPTIONAL;
		}

		@Override
		protected @NonNull CGParameterStyle @NonNull [] getCGParameterStyles(@NonNull ExecutableNameManager operationNameManager) {
			return CG_PARAMETER_STYLES_ID_RESOLVER_BOXED_VALUES;
		}
	}

	@Override
	public @NonNull CGClass createCGClass(@NonNull CodeGenAnalyzer analyzer, org.eclipse.ocl.pivot.@NonNull Class asClass) {
		CGClass cgClass = createCGClass();
		installCGRootClassParent(analyzer, cgClass, asClass);
		return cgClass;
	}

	public @NonNull CreationCache createCreationCache(@NonNull ClassNameManager classNameManager, @NonNull NewStatement asNewStatement) {
		CodeGenAnalyzer analyzer = classNameManager.getAnalyzer();
		JavaCodeGenerator codeGenerator = analyzer.getCodeGenerator();
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		org.eclipse.ocl.pivot.Class asClass = classNameManager.getASClass();
		org.eclipse.ocl.pivot.@NonNull Package asParentPackage = getParentPackage(analyzer, asClass);
		//
		PackageNameManager packageNameManager = analyzer.getPackageNameManager(null, asParentPackage);
		String entryClassName = packageNameManager.getUniqueClassName(NameManagerHelper.RULE_CACHE_CLASS_NAME_PREFIX, asClass);
		org.eclipse.ocl.pivot.Class asCacheClass = AbstractLanguageSupport.getClass(asParentPackage, entryClassName);
		org.eclipse.ocl.pivot.Class asCacheClassSuperClass = jLanguageSupport.getNativeClass(/*isIncremental ? AbstractEvaluationOperation.Incremental.class :*/ AbstractEvaluationOperation.class);
		asCacheClass.getSuperClasses().add(asCacheClassSuperClass);
		//
		CGClass cgCacheClass = analyzer.generateClassDeclaration(asCacheClass, this);
		CGClass cgCacheSuperClass = analyzer.generateClassDeclaration(asCacheClassSuperClass, null);
		cgCacheClass.getSuperTypes().add(cgCacheSuperClass);
		//
		BasicEvaluateOperationCallingConvention.getInstance(asCacheClass).createOperation(analyzer, cgCacheClass, asNewStatement);
		EvaluateOperationCallingConvention.getInstance(asCacheClass).createOperation(analyzer, cgCacheClass, asNewStatement);
		CreationCache creationCache = createCacheInstance(classNameManager, asCacheClass, asNewStatement);
		return creationCache;
	}

	protected final @NonNull CreationCache createCacheInstance(@NonNull ClassNameManager classNameManager, org.eclipse.ocl.pivot.@NonNull Class asCacheClass, @NonNull NewStatement asNewStatement) {
		QVTiAnalyzer analyzer = (QVTiAnalyzer) classNameManager.getAnalyzer();
		String propertyName = classNameManager.getUniquePropertyName(NameManagerHelper.INSTANCE_PROPERTY_NAME_PREFIX, asCacheClass);
		Property asProperty = PivotUtil.createProperty(propertyName, asCacheClass);
		//	org.eclipse.ocl.pivot.Class asClass = classNameManager.getASClass();
		CreationCache creationCache = analyzer.addCacheInstance(asNewStatement, asProperty, asCacheClass);
		//
		//	CGProperty cgProperty = analyzer.createCGElement(CGProperty.class, asProperty);
		CGProperty cgProperty = analyzer.generatePropertyDeclaration(asProperty, DefaultInstancePropertyCallingConvention.getInstance(asProperty));
		assert cgProperty.eContainer() != null;
		return creationCache;
	}

	/**
	 * Generate the Java code for a Class declaration.
	 * Returns true if control flow continues, false if an exception throw has been synthesized.
	 */
	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull CGClass cgCacheClass) {
		JavaStream js = cg2javaVisitor.getJavaStream();
		QVTiAnalyzer analyzer = (QVTiAnalyzer) cg2javaVisitor.getAnalyzer();
		org.eclipse.ocl.pivot.Class asCacheClass = CGUtil.getAST(cgCacheClass);
		CreationCache creationCache = analyzer.getCreationCache(asCacheClass);
		//	if (isEmpty(cgCacheClass)) {
		//		return true;
		//	}
		js.appendOptionalBlankLine();
		String className = CGUtil.getName(cgCacheClass);
		CGPackage cgContainingPackage = cgCacheClass.getContainingPackage();
		assert cgContainingPackage == null;
		String title = "The instance of " + cgCacheClass.getName() + " caches the result of each distinct creation of\n";
		js.appendCommentWithOCL(title, creationCache.getASEntryClass());
		js.append("// " + cgCacheClass.getCallingConvention() + "\n");
		js.append("private class " + className);
		appendSuperTypes(js, cgCacheClass);
		js.pushClassBody(className);
		generateProperties(cg2javaVisitor, cgCacheClass);
		generateOperations(cg2javaVisitor, cgCacheClass);
		js.popClassBody(false);
		return true;
	}

	protected org.eclipse.ocl.pivot.@NonNull Package getParentPackage(@NonNull CodeGenAnalyzer analyzer, org.eclipse.ocl.pivot.@NonNull Class asClass) {
		CGClass cgClass = analyzer.getCGRootClass(asClass);
		org.eclipse.ocl.pivot.Class asRootClass = CGUtil.getAST(cgClass);
		return AbstractLanguageSupport.getCachePackage(asRootClass);
	}
}