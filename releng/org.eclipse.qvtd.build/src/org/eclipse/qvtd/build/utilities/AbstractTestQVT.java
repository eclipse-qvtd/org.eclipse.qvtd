/*******************************************************************************
 * Copyright (c) 2012, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.build.utilities;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;

public abstract class AbstractTestQVT extends QVTimperative
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

	private static StandaloneProjectMap projectMap = null;

	public static @NonNull StandaloneProjectMap getProjectMap() {
		StandaloneProjectMap projectMap2 = projectMap;
		if (projectMap2 == null) {
			projectMap = projectMap2 = EMFPlugin.IS_ECLIPSE_RUNNING ? new ProjectMap(false) : new StandaloneProjectMap(false);
		}
		return projectMap2;
	}

	protected final @NonNull URI testsBaseURI;
	protected final @NonNull String projectName;
	protected final @NonNull String testFolderName;
	protected final @NonNull URI testFolderURI;
	protected final @NonNull URI samplesBaseUri;
	protected AbstractCompilerChain compilerChain = null;
	private BasicQVTiExecutor interpretedExecutor = null;
	private QVTiTransformationExecutor generatedExecutor = null;
	private Set<@NonNull String> nsURIs = new HashSet<@NonNull String>();

	public AbstractTestQVT(@NonNull URI testsBaseURI, @NonNull String projectName, @NonNull String testFolderName) {
		super(new QVTiEnvironmentFactory(getProjectMap(), null));
		this.testsBaseURI = testsBaseURI;
		this.projectName = projectName;
		this.testFolderName = testFolderName;
		this.testFolderURI = testsBaseURI.appendSegment(testFolderName);
		this.samplesBaseUri = testFolderURI.appendSegment("samples");
	}

	protected abstract @NonNull AbstractCompilerChain createCompilerChain(@NonNull URI prefixURI,
			@NonNull Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options);

	public @Nullable Resource createModel(@NonNull String modelName, @NonNull String modelFile) {
		URI modelURI = samplesBaseUri.appendSegment(modelFile);
		return interpretedExecutor.createModel(modelName, modelURI, null);
	}

	@Override
	public synchronized void dispose() {
		super.dispose();
		if (interpretedExecutor != null) {
			interpretedExecutor.dispose();
		}
		if (compilerChain != null) {
			compilerChain.dispose();
		}
		/**
		 * Remove the eInstances from the EPackage.Registry.INSTANCE so that global registrations from the calling test
		 * do not confuse subsequent tests that may want to use dynamic models.
		 */
		for (String nsURI : nsURIs) {
			EPackage.Registry.INSTANCE.remove(nsURI);
		}
	}

	protected @NonNull Class<? extends Transformer> doBuild(@NonNull String testFileName, @NonNull String outputName,
			@NonNull Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options,
			@NonNull String @NonNull... genModelFiles) throws Exception {
		compilerChain = createCompilerChain(testFolderURI.appendSegment(testFileName), options);
		ImperativeTransformation asTransformation = compilerChain.compile(outputName);
		URI txURI = asTransformation.eResource().getURI();
		if (txURI != null) {
			URI inputURI = txURI;
			URI serializedURI = txURI.trimFileExtension().appendFileExtension("serialized.qvti");
			XtextCompilerUtil.doQVTiSerializeAndLoad(inputURI, serializedURI);
		}
		Class<? extends Transformer> txClass = compilerChain.generate(asTransformation, genModelFiles);
		return txClass;
	}

	public Transformer executeTransformation() throws Exception {
		if (interpretedExecutor != null) {
			interpretedExecutor.execute();
			interpretedExecutor.saveModels(defaultSavingOptions);
			return null;
		}
		else {
			Transformer transformer = generatedExecutor.getTransformer();
			transformer.run();						// FIXME BUG 511028
			//			if (!transformer.run()) {
			//				throw new Exception("Failed to execute");
			//			}
			return transformer;
		}
	}

	@Override
	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return super.getEnvironmentFactory();
	}

	public @NonNull Collection<@NonNull ? extends Object> getRootObjects(@NonNull String modelName) {
		if (interpretedExecutor != null) {
			return interpretedExecutor.getRootObjects(modelName);
		}
		else {
			return generatedExecutor.getTransformer().getRootObjects(modelName);
		}
	}

	public @NonNull Map<Object, Object> getSaveOptions() {
		Map<Object, Object> saveOptions = new HashMap<Object, Object>(defaultSavingOptions);
		saveOptions.put(ASResource.OPTION_NORMALIZE_CONTENTS, Boolean.TRUE);
		return saveOptions;
	}

	public @Nullable Resource loadInput(@NonNull String modelName, @NonNull String modelFile) {
		URI modelURI = samplesBaseUri.appendSegment(modelFile);
		if (interpretedExecutor != null) {
			return interpretedExecutor.loadModel(modelName, modelURI);
		}
		else {
			ResourceSet resourceSet = environmentFactory.getMetamodelManager().getASResourceSet();		// FIXME get package registrations in exteranl RespurcSet
			PivotUtil.initializeLoadOptionsToSupportSelfReferences(resourceSet);
			Resource inputResource = resourceSet.getResource(modelURI, true);
			generatedExecutor.getTransformer().addRootObjects(modelName, ClassUtil.nonNullState(inputResource.getContents()));
			return inputResource;
		}
	}

	public void removeRegisteredPackage(@NonNull String ePackageClassName) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
		Class<?> ePackageClass = Class.forName(ePackageClassName);
		Field eNsURIField = ePackageClass.getField("eNS_URI");
		String nsURI = String.valueOf(eNsURIField.get(null));
		EPackage.Registry.INSTANCE.remove(nsURI);
	}
}