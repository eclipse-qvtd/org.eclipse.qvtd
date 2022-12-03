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
import org.eclipse.ocl.examples.codegen.cgmodel.CGClass;
import org.eclipse.ocl.examples.codegen.cgmodel.CGOperation;
import org.eclipse.ocl.examples.codegen.java.ImportNameManager;
import org.eclipse.ocl.examples.codegen.java.JavaCodeGenerator;
import org.eclipse.ocl.examples.codegen.naming.ExecutableNameManager;
import org.eclipse.ocl.examples.codegen.naming.GlobalNameManager;
import org.eclipse.ocl.examples.codegen.naming.NameManagerHelper;
import org.eclipse.ocl.examples.codegen.naming.NameResolution;
import org.eclipse.ocl.examples.codegen.naming.PackageNameManager;
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
	protected final org.eclipse.ocl.pivot.@NonNull Class createEntryClass(@NonNull ExecutableNameManager operationNameManager) {
		CodeGenAnalyzer analyzer = operationNameManager.getAnalyzer();
		JavaCodeGenerator codeGenerator = analyzer.getCodeGenerator();
		boolean isIncremental = codeGenerator.getOptions().isIncremental();
		//	ImperativeTransformation asTransformation = codeGenerator.getTransformation();
		GlobalNameManager globalNameManager = codeGenerator.getGlobalNameManager();
		ImportNameManager importNameManager = codeGenerator.getImportNameManager();
		LanguageSupport jLanguageSupport = codeGenerator.getLanguageSupport();
		CGOperation cgOperation = (CGOperation)operationNameManager.getCGScope();
		Operation asOperation = CGUtil.getAST(cgOperation);
		//	assert QVTimperativeUtil.basicGetShadowExp(asOperation) == null;
		//
		org.eclipse.ocl.pivot.@NonNull Package asPackage = getCachePackage(analyzer, asOperation);
		PackageNameManager packageNameManager = analyzer.getPackageNameManager(null, asPackage);
		String entryClassName = packageNameManager.getUniqueClassName(NameManagerHelper.ENTRY_CLASS_NAME_PREFIX, asOperation);
		org.eclipse.ocl.pivot.Class asEntryClass = AbstractLanguageSupport.getClass(asPackage, entryClassName);
		analyzer.addCachedOperation(asEntryClass, asOperation);
		org.eclipse.ocl.pivot.Class asEntrySuperClass = jLanguageSupport.getNativeClass(isIncremental ? AbstractComputation.Incremental.class : AbstractComputation.class);
		asEntryClass.getSuperClasses().add(asEntrySuperClass);
		importNameManager.reserveLocalName(PivotUtil.getName(asEntryClass));
		//
		CGClass cgEntryClass = analyzer.generateClassDeclaration(asEntryClass, CacheClassCallingConvention.INSTANCE);
		CGClass cgEntrySuperClass = analyzer.generateClassDeclaration(asEntrySuperClass, getClassCallingConvention());
		cgEntryClass.getSuperTypes().add(cgEntrySuperClass);
		//
		NameResolution cachedResultNameResolution = globalNameManager.getCachedResultNameResolution();
		createCacheSelfProperty(analyzer, cgEntryClass);
		for (@NonNull Parameter asParameter : PivotUtil.getOwnedParameters(asOperation)) {
			createCacheProperty(analyzer, cgEntryClass, null, asParameter);
			// XXX need to support a cached invalid
		}
		createCacheProperty(analyzer, cgEntryClass, cachedResultNameResolution, asOperation);
		//
		ConstructorOperationCallingConvention.INSTANCE.createCacheConstructor(analyzer, cgEntryClass, asOperation);
		GetResultOperationCallingConvention.INSTANCE.createCacheGetResultOperation(analyzer, cgEntryClass, asOperation);
		IsEqualOperationCallingConvention.INSTANCE.createCacheIsEqualOperation(analyzer, cgEntryClass, asOperation);
		return asEntryClass;
	}
}
