/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.URIUtil;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.osgi.framework.Bundle;

/**
 * The DefaultCompilerOptions provides the standard configuration of the CompilerChain.
 */
public class DefaultCompilerOptions extends AbstractCompilerOptions
{
	public final static @NonNull Map<Object, Object> defaultSavingOptions;

	// FIXME use a better default strategy for the saving options
	static {
		defaultSavingOptions = new HashMap<Object, Object>();
		defaultSavingOptions.put(XMLResource.OPTION_ENCODING, "UTF-8");
		defaultSavingOptions.put(XMLResource.OPTION_LINE_DELIMITER, "\n");
		defaultSavingOptions.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		defaultSavingOptions.put(XMLResource.OPTION_SCHEMA_LOCATION_IMPLEMENTATION, Boolean.TRUE);
		defaultSavingOptions.put(XMLResource.OPTION_LINE_WIDTH, Integer.valueOf(132));
		defaultSavingOptions.put(ASResource.OPTION_NORMALIZE_CONTENTS, Boolean.TRUE);
	}

	public DefaultCompilerOptions() {
		setOption(CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, getSaveOptions());
	}

	private static File getProjectFolder(@NonNull String projectName) throws IOException {
		assert EMFPlugin.IS_ECLIPSE_RUNNING;		// used by launch
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		IProject project = workspaceRoot.getProject(projectName);
		if (project != null) {
			String location = String.valueOf(project.getLocation());
			File projectFile = new File(location);
			File outputClassPath = JavaFileUtil.getOutputClassPath(projectFile);
			if (outputClassPath != null) {
				return outputClassPath;
			}
		}
		//	String path = null;
		Bundle bundle = Platform.getBundle(projectName);
		if (bundle != null) {
			try {
				File bundleFile = FileLocator.getBundleFile(bundle);
				if (bundleFile.isDirectory()) {
					//	File outputPath = getOutputClassPath(bundleFile);
					//	if (outputPath != null) {
					//		addFile(outputPath);
					//	}
				}

				//	File bundleFilePath = getOSGIClassPath(bundle);
				//	location = bundle.getLocation();
				//	path = bundleFilePath.toString();
			} catch (IOException e) {
				// Doesn't fail for sensible names.
			}
		}
		//	if (path == null) {					// platform:/resource
		//	}
		return null;
	}

	public @NonNull Map<Object, Object> getSaveOptions() {
		Map<Object, Object> saveOptions = new HashMap<Object, Object>(defaultSavingOptions);
		saveOptions.put(ASResource.OPTION_NORMALIZE_CONTENTS, Boolean.TRUE);
		return saveOptions;
	}

	private void setClassStepOptions(@NonNull String projectName, @NonNull URI classURI) throws IOException {
		assert EMFPlugin.IS_ECLIPSE_RUNNING;		// used by launch
		JavaClasspath classpath = CompilerUtil.createDefaultQVTiClasspath();
		File projectFolder = getProjectFolder(projectName);
		if (projectFolder != null) {
			classpath.addFile(projectFolder);
		}
		setOption(CompilerChain.CLASS_STEP, CompilerChain.CLASSPATH_KEY, classpath);
		IFile classFiles = URIUtil.getResolvedFile(classURI);
		if (classFiles != null) {
			setOption(CompilerChain.CLASS_STEP, CompilerChain.URI_KEY, URI.createFileURI(classFiles.getLocation().toString()));
		}
		else {
			throw new IOException("Failed to locate Class files folder '" + classURI + "'");
		}
	}

	public void setDebugGraphs(boolean dotGraphs, boolean yedGraphs) {
		setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_DOT_GRAPHS, dotGraphs);
		setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_YED_GRAPHS, yedGraphs);
	}

	public void setGenerateClassesOptions(@NonNull URI srcFileURI, @NonNull URI binFileURI, @NonNull JavaClasspath classpath, boolean isIncremental) {
		setOption(CompilerChain.JAVA_STEP, CompilerChain.URI_KEY, srcFileURI);
		setOption(CompilerChain.JAVA_STEP, CompilerChain.JAVA_INCREMENTAL_KEY, isIncremental);
		setOption(CompilerChain.JAVA_STEP, CompilerChain.JAVA_GENERATED_DEBUG_KEY, true);
		setOption(CompilerChain.CLASS_STEP, CompilerChain.CLASSPATH_KEY, classpath);
		setOption(CompilerChain.CLASS_STEP, CompilerChain.URI_KEY, binFileURI);
	}

	public void setGenerateGenModelOptions(@NonNull URI genModelURI, @NonNull String basePrefix, @Nullable String copyright,
			@Nullable Collection<@NonNull GenPackage> usedGenPackages) {
		setOption(CompilerChain.GENMODEL_STEP, CompilerChain.URI_KEY, genModelURI);
		Map<@NonNull String, @Nullable String> genModelOptions = basicGetOption(CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_OPTIONS_KEY);
		if (genModelOptions == null) {
			genModelOptions = new HashMap<>();
			setOption(CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_OPTIONS_KEY, genModelOptions);
		}
		genModelOptions.put(CompilerChain.GENMODEL_BASE_PREFIX, basePrefix);
		if (copyright != null) {
			genModelOptions.put(CompilerChain.GENMODEL_COPYRIGHT_TEXT, copyright);
		}
		setOption(CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_USED_GENPACKAGES_KEY, usedGenPackages);
	}

	public void setQVTcGenerateOptions(@NonNull String projectName, @NonNull URI txURI,
			@NonNull URI genModelURI, @NonNull URI javaURI, @NonNull URI classURI) throws IOException {
		assert EMFPlugin.IS_ECLIPSE_RUNNING;		// used by launch
		setOption(CompilerChain.GENMODEL_STEP, CompilerChain.URI_KEY, genModelURI);
		IFile javaFiles = URIUtil.getResolvedFile(javaURI);
		if (javaFiles != null) {
			setOption(CompilerChain.JAVA_STEP, CompilerChain.URI_KEY, URI.createFileURI(javaFiles.getLocation().toString()));
		}
		else {
			throw new IOException("Failed to locate Java files folder '" + javaURI + "'");
		}
		setClassStepOptions(projectName, classURI);
	}

	public void setQVTrGenerateOptions(@NonNull String projectName, @NonNull URI txURI,
			@NonNull URI genModelURI, @NonNull URI javaURI, @NonNull URI classURI) throws IOException {
		assert EMFPlugin.IS_ECLIPSE_RUNNING;		// used by launch
		setOption(CompilerChain.GENMODEL_STEP, CompilerChain.URI_KEY, genModelURI);
		setOption(CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_MODEL_DIRECTORY_KEY, javaURI.toPlatformString(false));
		String copyright = null; // "Copyright (c) 2015, 2016 Willink Transformations and others.\n;All rights reserved. This program and the accompanying materials\n;are made available under the terms of the Eclipse Public License v2.0\n;which accompanies this distribution, and is available at\n;http://www.eclipse.org/legal/epl-v20.html\n;\n;Contributors:\n;  E.D.Willink - Initial API and implementation");
		String basePrefix = projectName;
		Collection<@NonNull GenPackage> usedGenPackages = null;
		setGenerateGenModelOptions(genModelURI, basePrefix, copyright, usedGenPackages);

		String javaFolder = javaURI.deresolve(URIUtil.PLATFORM_RESOURCE).toString();
		setOption(CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_MODEL_DIRECTORY_KEY, javaFolder);
		IFile javaFiles = URIUtil.getResolvedFile(javaURI);
		if (javaFiles != null) {
			setOption(CompilerChain.JAVA_STEP, CompilerChain.URI_KEY, URI.createFileURI(javaFiles.getLocation().toString()));
		}
		else {
			throw new IOException("Failed to locate Java files folder '" + javaURI + "'");
		}
		setClassStepOptions(projectName, classURI);
	}

	public void setURIsFromStrings(@NonNull String @NonNull [] keys, @NonNull Map<String, String> key2value) {
		for (@NonNull String key : keys) {
			String value = key2value.get(key);
			URI uri = value != null ? URI.createURI(value, true) : null;
			setOption(key, CompilerChain.URI_KEY, uri);
		}
	}

	public void setURIs2(@NonNull String @NonNull [] keys, @NonNull Map<@NonNull String, @NonNull URI> key2value) {
		for (@NonNull String key : keys) {
			URI uri = key2value.get(key);
			assert uri != null;
			setOption(key, CompilerChain.URI_KEY, uri);
		}
	}
}
