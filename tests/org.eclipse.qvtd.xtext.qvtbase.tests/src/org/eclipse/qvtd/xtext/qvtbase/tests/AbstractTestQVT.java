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
package org.eclipse.qvtd.xtext.qvtbase.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.pivot.PivotTables;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiIncrementalExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.xtext.resource.XtextResource;

import junit.framework.TestCase;

public abstract class AbstractTestQVT extends QVTimperative
{
	protected final @NonNull URI testsBaseURI;
	protected final @NonNull String projectName;
	protected final @NonNull String testFolderName;
	protected final @NonNull URI testFolderURI;
	protected final @NonNull URI samplesBaseUri;
	protected AbstractCompilerChain compilerChain = null;
	protected BasicQVTiExecutor interpretedExecutor = null;
	protected QVTiTransformationExecutor generatedExecutor = null;
	private Set<@NonNull String> nsURIs = new HashSet<@NonNull String>();

	public AbstractTestQVT(@NonNull URI testsBaseURI, @NonNull String projectName, @NonNull String testFolderName) {
		super(new QVTiEnvironmentFactory(LoadTestCase.getProjectMap(), null));
		this.testsBaseURI = testsBaseURI;
		this.projectName = projectName;
		this.testFolderName = testFolderName;
		this.testFolderURI = testsBaseURI.appendSegment(testFolderName);
		this.samplesBaseUri = testFolderURI.appendSegment("samples");
	}

	public void checkOutput(@NonNull Resource outputResource, @NonNull String expectedFile, @Nullable ModelNormalizer normalizer) throws IOException, InterruptedException {
		URI referenceModelURI = samplesBaseUri.appendSegment(expectedFile);
		Resource referenceResource = outputResource.getResourceSet().getResource(referenceModelURI, true);
		assert referenceResource != null;
		if (normalizer != null) {
			normalizer.normalize(referenceResource);
			normalizer.normalize(outputResource);
		}
		LoadTestCase.assertSameModel(referenceResource, outputResource);
	}

	protected abstract @NonNull AbstractCompilerChain createCompilerChain(@NonNull URI prefixURI,
			@NonNull Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options);

	public @NonNull Class<? extends Transformer> createGeneratedClass(@NonNull Transformation asTransformation, @NonNull String @NonNull... genModelFiles) throws Exception {
		ResourceSet resourceSet = getResourceSet();
		resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
		loadGenModels(genModelFiles);
		QVTiCodeGenerator cg = new QVTiCodeGenerator(getEnvironmentFactory(), asTransformation);
		QVTiCodeGenOptions options = cg.getOptions();
		options.setUseNullAnnotations(true);
		setPackagePrefixOption(options);
		cg.generateClassFile();
		cg.saveSourceFile("../" + projectName + "/test-gen/");
		File explicitClassPath = new File("../" + projectName + "/bin");
		String qualifiedClassName = cg.getQualifiedName();
		String javaCodeSource = cg.generateClassFile();
		OCL2JavaFileObject.saveClass(ClassUtil.nonNullState(explicitClassPath.toString()), qualifiedClassName, javaCodeSource);
		@SuppressWarnings("unchecked")
		Class<? extends Transformer> txClass = (Class<? extends Transformer>) OCL2JavaFileObject.loadExplicitClass(explicitClassPath, qualifiedClassName);
		if (txClass == null) {
			TestCase.fail("Failed to compile transformation");
			throw new UnsupportedOperationException();
		}
		return txClass;
	}

	public void createGeneratedExecutor(@NonNull Transformation asTransformation, @NonNull String @NonNull... genModelFiles) throws Exception {
		Class<? extends Transformer> txClass = createGeneratedClass(asTransformation, genModelFiles);
		createGeneratedExecutor(txClass);
	}

	public QVTiTransformationExecutor createGeneratedExecutor(@NonNull Class<? extends Transformer> txClass)  throws Exception {
		return generatedExecutor = new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);
	}

	public @NonNull BasicQVTiExecutor createInterpretedExecutor(@NonNull ImperativeTransformation asTransformation) throws Exception {
		interpretedExecutor = new QVTiIncrementalExecutor(getEnvironmentFactory(), asTransformation, QVTiIncrementalExecutor.Mode.LAZY);
		return interpretedExecutor;
	}

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
			doSerialize(inputURI, serializedURI);
		}
		Class<? extends Transformer> txClass = compilerChain.generate(asTransformation, genModelFiles);
		createGeneratedExecutor(txClass);
		return txClass;
	}

	protected @NonNull ImperativeTransformation doCompile(@NonNull String testFileName, @NonNull String outputName,
			@NonNull Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options) throws Exception {
		compilerChain = createCompilerChain(testFolderURI.appendSegment(testFileName), options);
		ImperativeTransformation transformation = compilerChain.compile(outputName);
		URI txURI = transformation.eResource().getURI();
		if (txURI != null) {
			URI inputURI = txURI;
			URI serializedURI = txURI.trimFileExtension().appendFileExtension("serialized.qvti");
			doSerialize(inputURI, serializedURI);
		}
		return transformation;
	}

	protected static XtextResource doSerialize(@NonNull URI inputURI, @NonNull URI serializedURI) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		//
		//	Load QVTiAS
		//
		OCL ocl = QVTbase.newInstance(OCL.NO_PROJECTS);
		ocl.getEnvironmentFactory().setSeverity(PivotTables.STR_Variable_c_c_CompatibleInitialiserType, StatusCodes.Severity.IGNORE);
		try {
			ASResource asResource = LoadTestCase.loadQVTiAS(ocl, inputURI);
			LoadTestCase.assertNoResourceErrors("Normalisation failed", asResource);
			LoadTestCase.assertNoUnresolvedProxies("Normalisation invalid", asResource);
			LoadTestCase.assertNoValidationErrors("Normalisation invalid", asResource);
			//
			//	Pivot to CS
			//
			XtextResource xtextResource = LoadTestCase.pivot2cs(ocl, resourceSet, asResource, serializedURI, QVTimperativeCSPackage.eCONTENT_TYPE);
			resourceSet.getResources().clear();

			QVTimperative qvti = QVTimperative.newInstance(ProjectManager.NO_PROJECTS, null);
			try {
				Resource asResource2 = QVTimperativeUtil.loadTransformation(qvti.getEnvironmentFactory(), serializedURI, false).eResource();
				LoadTestCase.assertNoResourceErrors("Load failed", asResource2);
				LoadTestCase.assertNoUnresolvedProxies("Load invalid", asResource2);
				LoadTestCase.assertNoValidationErrors("Load invalid", asResource2);
			}
			finally {
				qvti.dispose();
				qvti = null;
			}
			return xtextResource;
		}
		finally {
			ocl.dispose();
			ocl = null;
		}
	}

	public Transformer executeTransformation() throws Exception {
		if (interpretedExecutor != null) {
			interpretedExecutor.execute();
			interpretedExecutor.saveModels(TestsXMLUtil.defaultSavingOptions);
			//				interpretedExecutor.saveModels(TestsXMLUtil.defaultSavingOptions);
			return null;
		}
		else {
			Transformer transformer = generatedExecutor.getTransformer();
			transformer.run();
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
		Map<Object, Object> saveOptions = new HashMap<Object, Object>(TestsXMLUtil.defaultSavingOptions);
		saveOptions.put(ASResource.OPTION_NORMALIZE_CONTENTS, Boolean.TRUE);
		return saveOptions;
	}

	protected void loadGenModel(@NonNull URI genModelURI) {
		ResourceSet resourceSet = getResourceSet();
		MetamodelManagerInternal metamodelManager = getMetamodelManager();
		Resource csGenResource = resourceSet.getResource(genModelURI, true);
		for (EObject eObject : csGenResource.getContents()) {
			if (eObject instanceof GenModel) {
				GenModel genModel = (GenModel)eObject;
				genModel.reconcile();
				metamodelManager.addGenModel(genModel);
			}
		}
	}

	/**
	 * Explicitly install the eInstances that would normally make it into the ProjectMap from extension point registrations.
	 * Test models are not registered via extension point so we have to do this manually.
	 */
	public void installEPackages(EPackage... eInstances) {
		ResourceSetImpl resourceSet = (ResourceSetImpl) getResourceSet();
		for (EPackage eInstance : eInstances) {
			String nsURI = eInstance.getNsURI();
			if (nsURI != null) {
				nsURIs.add(nsURI);
			}
			resourceSet.getURIResourceMap().put(testFolderURI.appendSegment(eInstance.getName()+".ecore"), eInstance.eResource());
		}
	}

	public @Nullable Resource loadInput(@NonNull String modelName, @NonNull String modelFile) {
		URI modelURI = samplesBaseUri.appendSegment(modelFile);
		if (interpretedExecutor != null) {
			return interpretedExecutor.loadModel(modelName, modelURI);
		}
		else {
			//				Resource inputResource = getResourceSet().getResource(modelURI, true);
			ResourceSet resourceSet = environmentFactory.getMetamodelManager().getASResourceSet();		// FIXME get package registrations in exteranl RespurcSet
			PivotUtil.initializeLoadOptionsToSupportSelfReferences(resourceSet);
			Resource inputResource = resourceSet.getResource(modelURI, true);
			generatedExecutor.getTransformer().addRootObjects(modelName, ClassUtil.nonNullState(inputResource.getContents()));
			return inputResource;
		}
	}

	protected abstract void loadGenModels(@NonNull String @NonNull... genModelFiles);

	public void removeRegisteredPackage(@NonNull String ePackageClassName) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
		Class<?> ePackageClass = Class.forName(ePackageClassName);
		Field eNsURIField = ePackageClass.getField("eNS_URI");
		String nsURI = String.valueOf(eNsURIField.get(null));
		EPackage.Registry.INSTANCE.remove(nsURI);
	}

	protected void setPackagePrefixOption(@NonNull QVTiCodeGenOptions options) {}
}