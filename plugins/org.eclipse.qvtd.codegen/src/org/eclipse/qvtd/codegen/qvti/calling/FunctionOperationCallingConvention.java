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
import org.eclipse.ocl.examples.codegen.calling.AbstractCachedOperationCallingConvention2;
import org.eclipse.ocl.examples.codegen.calling.CacheClassCallingConvention;
import org.eclipse.ocl.examples.codegen.calling.CacheClassCallingConvention.CachedFeatureAdapter;
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.java.ImportNameManager;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.naming.GlobalNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.utilities.CGUtil;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.utilities.AbstractLanguageSupport;
import org.eclipse.ocl.pivot.utilities.LanguageSupport;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractComputation;

/**
 *  FunctionOperationCallingConvention defines the support for the call of a QVTi function.
 */
public abstract class FunctionOperationCallingConvention extends AbstractCachedOperationCallingConvention2	// cf ConstrainedOperationCallingConvention
{
	protected final org.eclipse.ocl.pivot.@NonNull Class createCacheClass(@NonNull ExecutableNameManager operationNameManager) {
		CodeGenAnalyzer analyzer = operationNameManager.getAnalyzer();
		JavaCodeGenerator codeGenerator = analyzer.getCodeGenerator();
		//	ImperativeTransformation asTransformation = codeGenerator.getTransformation();
		GlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		ImportNameManager importNameManager = codeGenerator.getImportNameManager();
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		CGOperation cgOperation = (CGOperation)operationNameManager.getCGScope();
		Operation asOperation = CGUtil.getAST(cgOperation);
		//	assert QVTimperativeUtil.basicGetShadowExp(asOperation) == null;
		//
		org.eclipse.ocl.pivot.@NonNull Package asPackage = getCachePackage(analyzer, asOperation);
		String name = "CACHE_" + PivotUtil.getName(PivotUtil.getOwningClass(asOperation)) + "_" + PivotUtil.getName(asOperation);
		org.eclipse.ocl.pivot.Class asCacheClass = AbstractLanguageSupport.getClass(asPackage, name);
		asCacheClass.eAdapters().add(new CachedFeatureAdapter(asOperation));
		org.eclipse.ocl.pivot.Class asCacheSuperClass = jLanguageSupport.getNativeClass(AbstractComputation.class);
		asCacheClass.getSuperClasses().add(asCacheSuperClass);
		importNameManager.reserveLocalName(PivotUtil.getName(asCacheClass));
		//
		CGClass cgCacheClass = analyzer.generateClassDeclaration(asCacheClass, CacheClassCallingConvention.INSTANCE);
		CGClass cgSuperClass = analyzer.generateClassDeclaration(asCacheSuperClass, getClassCallingConvention());
		cgCacheClass.getSuperTypes().add(cgSuperClass);
		//
		NameResolution cachedResultNameResolution = globalNameManager.getCachedResultNameResolution();
		createCacheSelfProperty(analyzer, cgCacheClass);
		for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asOperation)) {
			createCacheProperty(analyzer, cgCacheClass, null, asParameter);
			// XXX need to support a cached invalid
		}
		createCacheProperty(analyzer, cgCacheClass, cachedResultNameResolution, asOperation);
		//
		ConstructorOperationCallingConvention.INSTANCE.createCacheConstructor(analyzer, cgCacheClass, asOperation);
		GetResultOperationCallingConvention.INSTANCE.createCacheGetResultOperation(analyzer, cgCacheClass, asOperation);
		IsEqualOperationCallingConvention.INSTANCE.createCacheIsEqualOperation(analyzer, cgCacheClass, asOperation);
		return asCacheClass;
	}
}
