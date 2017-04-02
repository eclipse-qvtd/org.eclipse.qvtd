/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.build.utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain.Key;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.runtime.evaluation.Transformer;

public class MyQVT extends AbstractTestQVT
{
	static final @NonNull String PROJECT_NAME = "org.eclipse.qvtd.atl";
	static final @NonNull URI TESTS_BASE_URI = URI.createPlatformResourceURI("/" + PROJECT_NAME + "/bin/" + PROJECT_NAME.replace(".",  "/"), true);
	static URI TESTS_JAVA_SRC_URI = URI.createPlatformResourceURI("/" + PROJECT_NAME +"/src-gen", true);
	static URI TESTS_JAVA_BIN_URI = URI.createPlatformResourceURI("/" + PROJECT_NAME + "/bin", true);

	private Collection<@NonNull GenPackage> usedGenPackages = null;

	public MyQVT(@NonNull String testFolderName) {
		super(MyQVT.TESTS_BASE_URI, MyQVT.PROJECT_NAME, testFolderName);
		//
		// http://www.eclipse.org/emf/2002/Ecore is referenced by just about any model load
		// Ecore.core is referenced from Ecore.genmodel that is used by the CG to coordinate Ecore objects with their Java classes
		// therefore suppress diagnostics about confusing usage.
		//
		URI ecoreURI = URI.createURI(EcorePackage.eNS_URI);
		getProjectManager().getPackageDescriptor(ecoreURI).configure(getResourceSet(), StandaloneProjectMap.LoadFirstStrategy.INSTANCE,
			StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
	}

	public @NonNull GenPackage addUsedGenPackage(@NonNull String resourcePath, @Nullable String fragment) {
		if (usedGenPackages == null) {
			usedGenPackages = new ArrayList<>();
		}
		URI uri = URI.createPlatformResourceURI(resourcePath, false);
		if (fragment != null) {
			uri = uri.appendFragment(fragment);
		}
		EObject eObject = getResourceSet().getEObject(uri, true);
		GenPackage genPackage = ClassUtil.nonNullState((GenPackage)eObject);
		usedGenPackages.add(genPackage);
		return genPackage;
	}

	public @NonNull Class<? extends Transformer> buildTransformation(@NonNull String testName, @NonNull String testFileName, @NonNull String outputName,
			@NonNull String middleNsURI, boolean isIncremental, @NonNull String @NonNull... genModelFiles) throws Exception {
		Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options = createBuildCompilerChainOptions(testName, isIncremental);
		return doBuild(testFileName, outputName, options, genModelFiles);
	}

	protected @NonNull Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> createBuildCompilerChainOptions(String testName, boolean isIncremental) {
		Map<@NonNull String, @Nullable String> genModelOptions = new HashMap<>();
		genModelOptions.put(CompilerChain.GENMODEL_BASE_PREFIX, MyQVT.PROJECT_NAME + "." + testName);
		genModelOptions.put(CompilerChain.GENMODEL_COPYRIGHT_TEXT, "Copyright (c) 2015, 2016 Willink Transformations and others.\n;All rights reserved. This program and the accompanying materials\n;are made available under the terms of the Eclipse Public License v1.0\n;which accompanies this distribution, and is available at\n;http://www.eclipse.org/legal/epl-v10.html\n;\n;Contributors:\n;  E.D.Willink - Initial API and implementation");
		Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options = new HashMap<>();
		QVTrCompilerChain.setOption(options, CompilerChain.DEFAULT_STEP, CompilerChain.DEBUG_KEY, true);
		QVTrCompilerChain.setOption(options, CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, MyQVT.defaultSavingOptions);
		QVTrCompilerChain.setOption(options, CompilerChain.JAVA_STEP, CompilerChain.URI_KEY, MyQVT.TESTS_JAVA_SRC_URI);
		QVTrCompilerChain.setOption(options, CompilerChain.JAVA_STEP, CompilerChain.JAVA_INCREMENTAL_KEY, isIncremental);
		QVTrCompilerChain.setOption(options, CompilerChain.JAVA_STEP, CompilerChain.JAVA_GENERATED_DEBUG_KEY, true);
		QVTrCompilerChain.setOption(options, CompilerChain.CLASS_STEP, CompilerChain.URI_KEY, MyQVT.TESTS_JAVA_BIN_URI);
		QVTrCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_USED_GENPACKAGES_KEY, usedGenPackages);
		QVTrCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_OPTIONS_KEY, genModelOptions);
		return options;
	}

	@Override
	protected @NonNull QVTrCompilerChain createCompilerChain(@NonNull URI prefixURI,
			@NonNull Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options) {
		return new QVTrCompilerChain(getEnvironmentFactory(), prefixURI, options);
	}

	protected @NonNull Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> createCompilerChainOptions(String basePrefix) {
		Map<@NonNull String, @Nullable String> genModelOptions = new HashMap<>();
		genModelOptions.put(CompilerChain.GENMODEL_BASE_PREFIX, basePrefix);
		genModelOptions.put(CompilerChain.GENMODEL_COPYRIGHT_TEXT, "Copyright (c) 2017 Willink Transformations and others.\n;All rights reserved. This program and the accompanying materials\n;are made available under the terms of the Eclipse Public License v1.0\n;which accompanies this distribution, and is available at\n;http://www.eclipse.org/legal/epl-v10.html\n;\n;Contributors:\n;  E.D.Willink - Initial API and implementation");
		Map<@NonNull String, @Nullable String> traceOptions = new HashMap<@NonNull String, @Nullable String>();
		//			traceOptions.put(CompilerChain.TRACE_NS_URI, middleNsURI);
		Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options = new HashMap<>();
		QVTrCompilerChain.setOption(options, CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, getSaveOptions());
		QVTrCompilerChain.setOption(options, CompilerChain.JAVA_STEP, CompilerChain.URI_KEY, null);
		QVTrCompilerChain.setOption(options, CompilerChain.CLASS_STEP, CompilerChain.URI_KEY, null);
		QVTrCompilerChain.setOption(options, CompilerChain.TRACE_STEP, CompilerChain.TRACE_OPTIONS_KEY, traceOptions);
		QVTrCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_USED_GENPACKAGES_KEY, usedGenPackages);
		QVTrCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_OPTIONS_KEY, genModelOptions);
		return options;
	}

	public @NonNull AbstractCompilerChain getCompilerChain() {
		return ClassUtil.nonNullState(compilerChain);
	}

	public @NonNull URI getURI(@NonNull String genmodelStep, @NonNull Key<URI> uriKey) {
		return compilerChain.getURI(CompilerChain.GENMODEL_STEP, CompilerChain.URI_KEY);
	}
}