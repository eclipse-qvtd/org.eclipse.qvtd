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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.CodeGenAnalyzer;
import org.eclipse.ocl.examples.codegen.calling.AbstractClassCallingConvention;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGPackage;
import org.eclipse.ocl.examples.codegen.java.CG2JavaVisitor;
import org.eclipse.ocl.examples.codegen.java.ImportNameManager;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.java.JavaStream;
import org.eclipse.ocl.examples.codegen.naming.ClassNameManager;
import org.eclipse.ocl.examples.codegen.naming.GlobalNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameManagerHelper;
import org.eclipse.ocl.examples.codegen.naming.PackageNameManager;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.library.executor.AbstractEvaluationOperation;
import org.eclipse.ocl.pivot.utilities.AbstractLanguageSupport;
import org.eclipse.ocl.pivot.utilities.LanguageSupport;
import org.eclipse.ocl.pivot.utilities.PivotUtil;

/**
 *  RuleCacheClassCallingConvention defines the nested Class that defines the cache of all executions of a particular rule.
 */
public class RuleCacheClassCallingConvention extends AbstractClassCallingConvention
{
	public static final @NonNull RuleCacheClassCallingConvention INSTANCE = new RuleCacheClassCallingConvention();

	@Override
	public @NonNull CGClass createCGClass(@NonNull CodeGenAnalyzer analyzer, org.eclipse.ocl.pivot.@NonNull Class asClass) {
		CGClass cgClass = createCGClass();
		installCGRootClassParent(analyzer, cgClass, asClass);
		return cgClass;
	}

	public org.eclipse.ocl.pivot.@NonNull Class createCacheClass(@NonNull ClassNameManager classNameManager) {
		CodeGenAnalyzer analyzer = classNameManager.getAnalyzer();
		JavaCodeGenerator codeGenerator = analyzer.getCodeGenerator();
		//	boolean isIncremental = codeGenerator.getOptions().isIncremental();
		GlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		ImportNameManager importNameManager = codeGenerator.getImportNameManager();
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		org.eclipse.ocl.pivot.Class asClass = classNameManager.getASClass();
		//	CGMapping cgMapping = (CGMapping)classNameManager.getCGScope();
		//	Mapping asMapping = QVTiCGUtil.getAST(cgMapping);
		org.eclipse.ocl.pivot.@NonNull Package asParentPackage = getParentPackage(analyzer, asClass);
		//
		PackageNameManager packageNameManager = analyzer.getPackageNameManager(null, asParentPackage);
		String entryClassName = packageNameManager.getUniqueClassName(NameManagerHelper.RULE_CACHE_CLASS_NAME_PREFIX, asClass);
		org.eclipse.ocl.pivot.Class asCacheClass = AbstractLanguageSupport.getClass(asParentPackage, entryClassName);
		//	analyzer.addCachedOperation(asTraceClass, asOperation);
		org.eclipse.ocl.pivot.Class asCacheClassSuperClass = jLanguageSupport.getNativeClass(/*isIncremental ? AbstractEvaluationOperation.Incremental.class :*/ AbstractEvaluationOperation.class);
		asCacheClass.getSuperClasses().add(asCacheClassSuperClass);
		importNameManager.reserveLocalName(PivotUtil.getName(asCacheClass));
		//
		CGClass cgCacheClass = analyzer.generateClassDeclaration(asCacheClass, this);
		CGClass cgCacheSuperClass = analyzer.generateClassDeclaration(asCacheClassSuperClass, null);
		cgCacheClass.getSuperTypes().add(cgCacheSuperClass);
		//
		/*	NameResolution contextNameResolution = getContextNameResolution(globalNameManager);
		org.eclipse.ocl.pivot.Class asContextClass = getContextClass(analyzer, cgEntryClass);
		createCacheProperty(analyzer, cgEntryClass, contextNameResolution, asContextClass);
		for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asOperation)) {
			createCacheProperty(analyzer, cgEntryClass, null, asParameter);
			// XXX need to support a cached invalid
		} */
		//	NameResolution cachedResultNameResolution = globalNameManager.getCachedResultNameResolution();
		//	createCacheProperty(analyzer, cgCacheClass, cachedResultNameResolution, asClass);
		/*
		ConstructorOperationCallingConvention.INSTANCE.createCacheConstructor(analyzer, cgEntryClass, asOperation);
		GetResultOperationCallingConvention.INSTANCE.createCacheGetResultOperation(analyzer, cgEntryClass, asOperation);
		IsEqualOperationCallingConvention.INSTANCE.createCacheIsEqualOperation(analyzer, cgEntryClass, asOperation); */
		/*Property asConstructorInstance =*/ createCacheInstance(classNameManager, asCacheClass);
		return asCacheClass;
	}

	protected final @NonNull Property createCacheInstance(@NonNull ClassNameManager classNameManager, org.eclipse.ocl.pivot.@NonNull Class asCacheClass) {
		CodeGenAnalyzer analyzer = classNameManager.getAnalyzer();

		//		CGClass cgRootClass = analyzer.getCGRootClass(asCacheClass);
		//		ClassNameManager classNameManager = analyzer.getGlobalNameManager().getClassNameManager(cgRootClass);
		String propertyName = classNameManager.getUniquePropertyName(NameManagerHelper.INSTANCE_PROPERTY_NAME_PREFIX, asCacheClass);
		Property asProperty = PivotUtil.createProperty(propertyName, asCacheClass);
		//	Operation asOperation = (Operation)operationNameManager.getASScope();
		//	analyzer.addCacheConstructorInstance(asOperation, asProperty, asCacheClass);
		//
		//	CGClass cgClass = qvtiOperationNameManager.getClassNameManager().getCGClass();
		//	CGProperty cgProperty = analyzer.createCGElement(CGProperty.class, asProperty);
		//	cgProperty.setCallingConvention(ConstructorInstancePropertyCallingConvention.INSTANCE);
		//	cgClass.getProperties().add(cgProperty);
		//	assert cgProperty.eContainer() != null;
		return asProperty;
	}

	/*	private void createCacheProperty(@NonNull CodeGenAnalyzer analyzer, @NonNull CGClass cgCacheClass,
			@Nullable NameResolution nameResolution, @NonNull NamedElement asTypeOrTypedElement) {			// XXX share
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
	} */

	/**
	 * Generate the Java code for a Class declaration.
	 * Returns true if control flow continues, false if an exception throw has been synthesized.
	 */
	@Override
	public boolean generateJavaDeclaration(@NonNull CG2JavaVisitor cg2javaVisitor, @NonNull JavaStream js, @NonNull CGClass cgClass) {
		//	if (isEmpty(cgClass)) {
		//		return true;
		//	}
		js.append("\n");
		String className = CGUtil.getName(cgClass);
		CGPackage cgContainingPackage = cgClass.getContainingPackage();
		assert cgContainingPackage == null;
		String title = "The instance of " + cgClass.getName() + " caches the result of each distinct invocation of\n";
		js.appendCommentWithOCL(title, cgClass.getAst());			// XXX lookup rule
		js.append("private static class " + className);
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