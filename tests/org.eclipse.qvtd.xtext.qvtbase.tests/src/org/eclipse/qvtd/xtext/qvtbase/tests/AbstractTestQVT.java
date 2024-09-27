/*******************************************************************************
 * Copyright (c) 2012, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.PivotConstants;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.compiler.internal.common.SimpleConfigurations;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfigurations;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartitionAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.Execution2GraphVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.xtext.resource.XtextResource;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;

public abstract class AbstractTestQVT extends QVTimperative
{
	/**
	 * ContentEditingURIConverter delegates to a URIConverter but intercepts createInputStream to
	 * read the input fie andapply global replacements. This is used to chnage nsURIs so that multiple
	 * test project syntheses from the same source models do not generate dupicate Java registrations,
	 */
	public static class ContentEditingURIConverter implements URIConverter
	{
		private final @NonNull URIConverter uriConverter;
		private final @NonNull Map<@NonNull String, @NonNull String> old2new = new HashMap<>();

		public ContentEditingURIConverter(@NonNull URIConverter uriConverter) {
			this.uriConverter = uriConverter;
		}

		/**
		 * Specify an oldString to be replaced by a newString in an input stream.
		 */
		public void addReplacement(@NonNull String oldString, @NonNull String newString) {
			old2new.put(oldString, newString);
		}

		@Override
		public Map<String, ?> contentDescription(URI uri, Map<?, ?> options) throws IOException {
			return uriConverter.contentDescription(uri, options);
		}

		@Override
		public @NonNull InputStream createInputStream(URI uri) throws IOException {
			InputStream inputStream = uriConverter.createInputStream(uri);
			return createdEditedInputStream(inputStream);
		}

		private @NonNull InputStream createdEditedInputStream(InputStream inputStream) throws IOException {
			StringBuilder s = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			for (String line; (line = reader.readLine()) != null; ) {
				for (Map.Entry<@NonNull String, @NonNull String> entry : old2new.entrySet()) {
					line = line.replace(entry.getKey(), entry.getValue());
				}
				s.append(line);
				s.append("\n");
			}
			String string = s.toString();
			String encoding = ReadableInputStream.getEncoding(string);
			return new ReadableInputStream(string, encoding != null ? encoding : "UTF-8");
		}

		@Override
		public InputStream createInputStream(URI uri, Map<?, ?> options) throws IOException {
			InputStream inputStream = uriConverter.createInputStream(uri, options);
			return createdEditedInputStream(inputStream);
		}

		@Override
		public OutputStream createOutputStream(URI uri) throws IOException {
			return uriConverter.createOutputStream(uri);
		}

		@Override
		public OutputStream createOutputStream(URI uri, Map<?, ?> options) throws IOException {
			return uriConverter.createOutputStream(uri, options);
		}

		@Override
		public void delete(URI uri, Map<?, ?> options) throws IOException {
			uriConverter.getURIHandlers();
		}

		@Override
		public boolean exists(URI uri, Map<?, ?> options) {
			return uriConverter.exists(uri, options);
		}

		@Override
		public Map<String, ?> getAttributes(URI uri, Map<?, ?> options) {
			return uriConverter.getAttributes(uri, options);
		}

		@Override
		public EList<ContentHandler> getContentHandlers() {
			return uriConverter.getContentHandlers();
		}

		@Override
		public URIHandler getURIHandler(URI uri) {
			return uriConverter.getURIHandler(uri);
		}

		@Override
		public EList<URIHandler> getURIHandlers() {
			return uriConverter.getURIHandlers();
		}

		@Override
		public Map<URI, URI> getURIMap() {
			return uriConverter.getURIMap();
		}

		@Override
		public URI normalize(URI uri) {
			return uriConverter.normalize(uri);
		}

		@Override
		public void setAttributes(URI uri, Map<String, ?> attributes, Map<?, ?> options) throws IOException {
			uriConverter.setAttributes(uri, attributes, options);
		}
	}

	// FIXME move following clones to a Util class
	public static @NonNull XtextResource as2cs(@NonNull OCL ocl, @NonNull ResourceSet resourceSet, @NonNull ASResource asResource, @NonNull URI outputURI, /*@NonNull*/ String csContentType) throws IOException {
		XtextResource xtextResource = ClassUtil.nonNullState((XtextResource) resourceSet.createResource(outputURI, csContentType));
		ocl.as2cs(asResource, (CSResource) xtextResource);
		LoadTestCase.assertNoResourceErrors("Conversion failed", xtextResource);
		//
		//	CS save
		//
		URI savedURI = ClassUtil.nonNullState(asResource.getURI());
		asResource.setURI(outputURI.trimFileExtension().trimFileExtension().appendFileExtension(PivotConstants.OCL_AS_FILE_EXTENSION));
		asResource.save(DefaultCompilerOptions.defaultSavingOptions);
		asResource.setURI(savedURI);
		try {
			LoadTestCase.assertNoDiagnosticErrors("Concrete Syntax validation failed", xtextResource);
			xtextResource.save(DefaultCompilerOptions.defaultSavingOptions);
		}
		catch (Throwable e) {
			e.printStackTrace();
			URI xmiURI = outputURI.appendFileExtension(".xmi");
			Resource xmiResource = resourceSet.createResource(xmiURI);
			xmiResource.getContents().addAll(ClassUtil.nullFree(xtextResource.getContents()));
			xmiResource.save(DefaultCompilerOptions.defaultSavingOptions);
			if (e instanceof WrappedException) {
				e = ((WrappedException)e).getCause();
			}
			if (e instanceof Resource.IOWrappedException) {
				e = ((Resource.IOWrappedException)e).getCause();
			}
			LoadTestCase.fail(e.toString());
		}
		return xtextResource;
	}

	public static @NonNull ASResource loadQVTiAS(@NonNull OCL ocl, @NonNull URI inputURI) {
		ResourceSet asResourceSet = ocl.getMetamodelManager().getASResourceSet();
		List<Resource> asResources = asResourceSet.getResources();
		int oldResourceCount = asResources.size();
		ASResource asResource = (ASResource)asResourceSet.getResource(inputURI, true);
		assert asResource != null;
		resolveAllandSetASonly(asResourceSet);
		//		List<String> conversionErrors = new ArrayList<String>();
		//		RootPackageCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, null, ecoreResource);
		//		Resource eResource = documentCS.eResource();
		LoadTestCase.assertNoResourceErrors("Load failed", asResource);
		//		Resource xtextResource = resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
		//		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI);
		//		xtextResource.getContents().add(documentCS);
		return asResource;
	}

	public static void resolveAllandSetASonly(@NonNull ResourceSet resourceSet) {
		EcoreUtil.resolveAll(resourceSet);
		for (Resource resource : resourceSet.getResources()) {
			if (resource instanceof ASResource) {
				ASResource asResource = (ASResource)resource;
				if (asResource.isSaveable()) {
					asResource.setASonly(true);
				}
			}
		}
	}

	/**
	 * The test bundle in which intermediate and result files are written.
	 */
	protected final @NonNull URI testBundleURI;

	/**
	 * The source transformation.
	 */
	protected final @NonNull URI txURI;

	/**
	 * A prefix for output filenames.
	 */
	protected final @NonNull URI intermediateFileNamePrefixURI;

	/**
	 * The file folder for generated Java sources.
	 */
	protected final @NonNull URI srcFileURI;

	/**
	 * The file folder for compiled Java classes.
	 */
	protected final @NonNull URI binFileURI;

	/**
	 * Project names needed on the classpath in addition to the defaults.
	 */
	private final @NonNull JavaClasspath classpath;

	private final @NonNull Map<@NonNull Class<? extends Partition>, @NonNull Integer> partitionClass2count = new HashMap<>();

	protected AbstractCompilerChain compilerChain = null;
	private TransformationExecutor executor = null;
	private Set<@NonNull String> nsURIs = new HashSet<@NonNull String>();
	private boolean suppressFailureDiagnosis = false;				// FIXME BUG 511028

	protected final @NonNull TestProject testProject;
	private Collection<@NonNull GenPackage> usedGenPackages = null;
	private Collection<@NonNull EPackage> loadedEPackages = null;
	private @Nullable String copyright = null;
	private @Nullable Map<@NonNull String, @NonNull EPackage> extraLocalPackageRegistryEntries = null;

	public AbstractTestQVT(@NonNull ProjectManager projectManager, @NonNull TestProject testProject, @NonNull URI testBundleURI, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull URI srcFileURI, @NonNull URI binFileURI) throws IOException {
		super(new QVTiEnvironmentFactory(projectManager, null));
		assert testBundleURI.isPlatform();
		this.testProject = testProject;
		this.testBundleURI = testBundleURI;
		this.txURI = txURI;
		this.intermediateFileNamePrefixURI = intermediateFileNamePrefixURI;
		this.srcFileURI = srcFileURI;
		this.binFileURI = binFileURI;
		this.classpath = CompilerUtil.createDefaultQVTiClasspath();
		this.classpath.addFile(testProject.getOutputFile(JavaFileUtil.TEST_BIN_FOLDER_NAME).getFile());
		assert srcFileURI.isFile();
		assert srcFileURI.hasAbsolutePath();
		assert binFileURI.isFile();
		assert binFileURI.hasAbsolutePath();
		//			installEPackages(eInstances);
		//
		// http://www.eclipse.org/emf/2002/Ecore is referenced by just about any model load
		// Ecore.core is referenced from Ecore.genmodel that is used by the CG to coordinate Ecore objects with their Java classes
		// therefore suppress diagnostics about confusing usage.
		//
		getProjectManager().configureLoadFirst(getResourceSet(), EcorePackage.eNS_URI);
	}

	public void addClasspathClass(@NonNull Class<?> classpathClass) {
		classpath.addClass(classpathClass);
	}

	public @Nullable Resource addInputURI(@NonNull String modelName, @NonNull URI modelURI) {
		return executor.addInputURI(modelName, modelURI);
	}


	public @NonNull Resource addOutputURI(@NonNull String modelName, @NonNull URI modelURI) {
		return executor.addOutputURI(modelName, modelURI);
	}
	/*	public @NonNull Resource addOutputURI(@NonNull String modelName, @NonNull URI modelURI) {
		ResourceSet resourceSet;
		if (PivotUtilInternal.isASURI(modelURI)) {
			resourceSet = environmentFactory.getMetamodelManager().getASResourceSet();	// Need PivotSave to allocate xmi:ids
		}
		else {
			resourceSet = getResourceSet();
		}
		TypedModelInstance typedModelInstance = executor.getTypedModelInstance(modelName);
		Resource outputResource = ClassUtil.nonNullState(resourceSet.createResource(modelURI));
		typedModelInstance.addOutputResource(outputResource);
		return outputResource;
	} */

	public void addRegisteredPackage(@NonNull String ePackageClassName) throws Exception {
		Class<?> ePackageClass = Class.forName(ePackageClassName);
		Field instanceField = ePackageClass.getField("eINSTANCE");
		EPackage ePackage = (EPackage) instanceField.get(null);
		EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
	}

	public @NonNull GenPackage addUsedGenPackage(@NonNull String resourcePath, @Nullable String fragment) {
		if (usedGenPackages == null) {
			usedGenPackages = new ArrayList<>();
		}
		GenPackage genPackage = CompilerUtil.getGenPackage(getResourceSet(), resourcePath, fragment);
		usedGenPackages.add(genPackage);
		return genPackage;
	}

	public void assertRegionCount(@NonNull Class<? extends Region> partitionClass, int count) {
		PivotUtil.errPrintln("assertRegionCount suppressed");
	}

	//	public void assertRegionCount(@NonNull Class<? extends Partition> partitionClass, int count) {
	//		TestCase.assertEquals("Partition " + partitionClass.getSimpleName() + " count:", count != 0 ? count : null, partitionClass2count.get(partitionClass));
	//	}

	public @NonNull Class<? extends Transformer> buildTransformation(@NonNull String outputName,
			boolean isIncremental, @NonNull String @NonNull... genModelFiles) throws Exception {
		TypedModelsConfigurations typedModelsConfigurations = TypedModelsConfiguration.createTypedModelsConfigurations(outputName);
		return buildTransformation(typedModelsConfigurations, isIncremental, genModelFiles);
	}

	public @NonNull Class<? extends Transformer> buildTransformation(@NonNull TypedModelsConfigurations typedModelsConfigurations,
			boolean isIncremental, @NonNull String @NonNull... genModelFiles) throws Exception {
		CompilerOptions options = createBuildCompilerChainOptions(isIncremental);
		return doBuild(txURI, intermediateFileNamePrefixURI, typedModelsConfigurations, options, genModelFiles);
	}

	public @NonNull Class<? extends Transformer> buildTransformation_486938(@NonNull String outputName,
			boolean isIncremental, @NonNull String @NonNull... genModelFiles) throws Exception {
		CompilerOptions options = createBuildCompilerChainOptions(isIncremental);
		options.setOption(CompilerChain.JAVA_STEP, CompilerChain.JAVA_EXTRA_PREFIX_KEY, "cg");
		TypedModelsConfigurations typedModelsConfigurations = TypedModelsConfiguration.createTypedModelsConfigurations(outputName);
		return doBuild(txURI, intermediateFileNamePrefixURI, typedModelsConfigurations, options, genModelFiles);
	}

	protected void checkOutput(@NonNull Resource outputResource, @NonNull URI referenceModelURI, @Nullable ModelNormalizer normalizer) throws IOException, InterruptedException {
		ResourceSet referenceResourceSet = createTestResourceSet();
		Resource referenceResource = referenceResourceSet.getResource(referenceModelURI, true);
		assert referenceResource != null;
		EcoreUtil.resolveAll(referenceResourceSet);
		if (normalizer != null) {
			assert !referenceResource.getContents().isEmpty() : referenceResource.getURI() + " has no contents";
			assert !outputResource.getContents().isEmpty() : outputResource.getURI() + " has no contents";
			normalizer.normalize(referenceResource);
			normalizer.normalize(outputResource);
		}
		LoadTestCase.assertSameModel(referenceResource, outputResource);
	}

	public @NonNull Resource checkOutput(@NonNull URI actualURI, @Nullable URI expectedURI, @Nullable ModelNormalizer normalizer) throws IOException, InterruptedException {
		deactivate();
		ResourceSet actualResourceSet = createTestResourceSet();
		//		if (PivotUtilInternal.isASURI(modelURI)) {
		//			resourceSet = environmentFactory.getMetamodelManager().getASResourceSet();	// Need PivotSave to allocate xmi:ids
		//		}
		//		else {
		//			resourceSet = getResourceSet();
		//		}
		Resource actualResource = ClassUtil.nonNullState(actualResourceSet.getResource(actualURI, true));
		resolveAllandSetASonly(actualResourceSet);
		if (expectedURI != null) {
			String actualFileStem = actualURI.trimFileExtension().lastSegment();
			String expectedFileStem = expectedURI.trimFileExtension().lastSegment();
			if ((actualFileStem != null) && (expectedFileStem != null) && !actualFileStem.equals(expectedFileStem) && actualFileStem.startsWith(expectedFileStem)) {
				String suffix = actualFileStem.substring(expectedFileStem.length());
				for (Resource resource : actualResourceSet.getResources()) {
					URI resourceURI = resource.getURI();
					String fileExtension = resourceURI.fileExtension();
					URI trimmedURI = resourceURI.trimFileExtension();
					String fileStem = trimmedURI.lastSegment();
					if ((fileStem != null) && fileStem.endsWith(suffix) ) {
						String trimmedFileStem = fileStem.substring(0, fileStem.length() - suffix.length());
						resource.setURI(trimmedURI.trimSegments(1).appendSegment(trimmedFileStem).appendFileExtension(fileExtension));
					}
				}
			}
			checkOutput(actualResource, expectedURI, normalizer);
		}
		activate();
		return actualResource;
	}

	protected @NonNull ResourceSet createTestResourceSet() {
		ResourceSet actualResourceSet = new ResourceSetImpl();
		environmentFactory.getProjectManager().initializeResourceSet(actualResourceSet);
		return actualResourceSet;
	}

	public @NonNull ImperativeTransformation compileTransformation(@NonNull String outputName) throws Exception {
		SimpleConfigurations typedModelsConfigurations = new SimpleConfigurations(outputName);
		return compileTransformation(typedModelsConfigurations);
	}

	public @NonNull ImperativeTransformation compileTransformation(@NonNull TypedModelsConfigurations typedModelsConfigurations) throws Exception {
		return doCompile(txURI, intermediateFileNamePrefixURI, typedModelsConfigurations, createCompilerChainOptions());
	}

	protected @NonNull CompilerOptions createBuildCompilerChainOptions(boolean isIncremental) throws IOException {
		DefaultCompilerOptions compilerOptions = createCompilerChainOptions();
		compilerOptions.setGenerateClassesOptions(srcFileURI, binFileURI, createClassProjectNames(), isIncremental);
		if (generateGenModel()) {
			URI genModelURI = intermediateFileNamePrefixURI.appendFileExtension(AbstractCompilerChain.getDefaultFileExtension(CompilerChain.GENMODEL_STEP));
			compilerOptions.setGenerateGenModelOptions(genModelURI, getBasePrefix(), copyright, usedGenPackages);
		}
		compilerOptions.setOption(CompilerChain.TRACE_STEP, CompilerChain.TRACE_BASE_URI_KEY, "http://" + testProject.getName());
		return compilerOptions;
	}

	/**
	 * Return a list of project names that need to be on the class path.
	 * @throws IOException
	 */
	protected @NonNull JavaClasspath createClassProjectNames() {
		classpath.addClass(getClass()); //testProjectName);
		return classpath;
	}

	protected abstract @NonNull AbstractCompilerChain createCompilerChain(@NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI,
			@NonNull CompilerOptions options);

	protected @NonNull DefaultCompilerOptions createCompilerChainOptions() {
		DefaultCompilerOptions compilerOptions = createCompilerOptions();
		//		if (copyright != null) {
		//			compilerOptions.setCopyright(copyright);
		//		}
		//		compilerOptions.setBasePrefix(getBasePrefix());
		//		if (usedGenPackages != null) {
		//			compilerOptions.setUsedGenPackages(usedGenPackages);
		//		}
		return compilerOptions;
	}

	protected @NonNull DefaultCompilerOptions createCompilerOptions() {
		DefaultCompilerOptions compilerOptions = new DefaultCompilerOptions();
		compilerOptions.setOption(CompilerChain.DEFAULT_STEP, CompilerChain.DEBUG_KEY, true);
		return compilerOptions;
	}

	public @NonNull Class<? extends Transformer> createGeneratedClass(@NonNull ImperativeTransformation iTransformation, @NonNull String @NonNull... genModelFiles) throws Exception {
		ResourceSet resourceSet = getResourceSet();
		resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
		loadGenModels(genModelFiles);
		QVTiCodeGenerator cg = new QVTiCodeGenerator(getEnvironmentFactory(), iTransformation);
		QVTiCodeGenOptions options = cg.getOptions();
		options.setUseNullAnnotations(true);
		setPackagePrefixOption(options);
		cg.generateClassFile();
		cg.saveSourceFile(getJavaSourceURI().toString() + "/");
		File explicitClassPath = new File(getJavaClassURI().toString() + "/");
		String qualifiedClassName = cg.getQualifiedName();
		String javaCodeSource = cg.generateClassFile();
		OCL2JavaFileObject.saveClass(ClassUtil.nonNullState(explicitClassPath.toString()), qualifiedClassName, javaCodeSource);
		@SuppressWarnings("unchecked")
		Class<? extends Transformer> txClass = (Class<? extends Transformer>) OCL2JavaFileObject.loadExplicitClass(explicitClassPath, qualifiedClassName/*, null*/);
		if (txClass == null) {
			TestCase.fail("Failed to compile transformation");
			throw new UnsupportedOperationException();
		}
		return txClass;
	}

	/*	public void createGeneratedExecutor(@NonNull Transformation asTransformation, @NonNull String @NonNull... genModelFiles) throws Exception {
		Class<? extends Transformer> txClass = createGeneratedClass(asTransformation, genModelFiles);
		createGeneratedExecutor(txClass);
	} */

	public @NonNull QVTiTransformationExecutor createGeneratedExecutor(@NonNull Class<? extends Transformer> txClass)  throws Exception {
		QVTiTransformationExecutor generatedExecutor = createGeneratedExecutor(getEnvironmentFactory(), txClass);
		this.executor = generatedExecutor;
		return generatedExecutor;
	}

	protected @NonNull QVTiTransformationExecutor createGeneratedExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull Class<? extends Transformer> txClass) throws ReflectiveOperationException {
		return new QVTiTransformationExecutor(environmentFactory, txClass);
	}

	public @NonNull BasicQVTiExecutor createInterpretedExecutor(@NonNull ImperativeTransformation transformation) throws Exception {
		BasicQVTiExecutor interpretedExecutor = createInterpretedExecutor(getEnvironmentFactory(), transformation);
		this.executor = interpretedExecutor;
		return interpretedExecutor;
	}

	public @NonNull BasicQVTiExecutor createInterpretedExecutor(@NonNull EntryPoint entryPoint) throws Exception {
		BasicQVTiExecutor interpretedExecutor = createInterpretedExecutor(getEnvironmentFactory(), entryPoint, ModeFactory.LAZY);
		this.executor = interpretedExecutor;
		return interpretedExecutor;
	}

	protected @NonNull BasicQVTiExecutor createInterpretedExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull ImperativeTransformation transformation) throws Exception {
		return new BasicQVTiExecutor(getEnvironmentFactory(), QVTimperativeUtil.getDefaultEntryPoint(transformation), ModeFactory.LAZY);
	}

	protected @NonNull BasicQVTiExecutor createInterpretedExecutor(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull EntryPoint entryPoint, @NonNull ModeFactory modeFactory) throws Exception {
		return new BasicQVTiExecutor(environmentFactory, entryPoint, modeFactory);
	}

	@Override
	public synchronized void dispose() {
		if (loadedEPackages != null) {
			for (@NonNull EPackage ePackage : loadedEPackages) {
				EPackage.Registry.INSTANCE.remove(ePackage.getNsURI());
			}
		}
		super.dispose();
		if (executor != null) {
			executor.dispose();
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

	protected @NonNull Class<? extends Transformer> doBuild(@NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull TypedModelsConfigurations typedModelsConfigurations,
			@NonNull CompilerOptions options, @NonNull String @NonNull ... genModelFiles) throws IOException, Exception {
		compilerChain = createCompilerChain(txURI, intermediateFileNamePrefixURI, options);
		ImperativeTransformation asTransformation = compilerChain.compile(typedModelsConfigurations);
		URI asURI = asTransformation.eResource().getURI();
		if (asURI != null) {
			URI asURIstem = asURI.trimFileExtension();
			doSerialize(asURI, asURIstem.appendFileExtension("serialized.qvti"));
		}
		return compilerChain.generate(asTransformation, genModelFiles);
	}

	protected @NonNull ImperativeTransformation doCompile(@NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI,
			@NonNull TypedModelsConfigurations typedModelsConfigurations, @NonNull CompilerOptions options) throws Exception {
		compilerChain = createCompilerChain(txURI, intermediateFileNamePrefixURI, options);
		ImperativeTransformation transformation = compilerChain.compile(typedModelsConfigurations);
		URI txASURI = transformation.eResource().getURI();
		if (txASURI != null) {
			URI inputURI = txASURI;
			URI asURIstem = txASURI.trimFileExtension();
			URI serializedURI = asURIstem.appendFileExtension("serialized.qvti");
			doSerialize(inputURI, serializedURI);
			doScheduleLoadCheck(asURIstem.appendFileExtension(QVTbaseUtil.QVTSAS_FILE_EXTENSION));
		}
		return transformation;
	}

	private void doScheduleLoadCheck(@NonNull URI uri) throws Exception {
		deactivate();
		ResourceSet resourceSet = new ResourceSetImpl();
		getTestProjectManager().initializeResourceSet(resourceSet);
		Resource resource = resourceSet.getResource(uri, true);
		assert resource != null;
		PivotTestCase.assertNoResourceErrors("Load", resource);
		resolveAllandSetASonly(resourceSet);
		PivotTestCase.assertNoUnresolvedProxies("Resolve", resource);;
		PivotTestCase.assertNoValidationErrors("Validate", resource);;
		activate();
	}

	protected XtextResource doSerialize(@NonNull URI inputURI, @NonNull URI serializedURI) throws Exception {
		deactivate();
		//
		//	Load QVTiAS
		//
		OCL ocl = QVTbase.newInstance(getTestProjectManager());
		if (extraLocalPackageRegistryEntries != null) {
			ocl.getResourceSet().getPackageRegistry().putAll(extraLocalPackageRegistryEntries);
		}
		ocl.getEnvironmentFactory().setSeverity(PivotPackage.Literals.VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP, StatusCodes.Severity.IGNORE);
		XtextResource xtextResource = null;
		try {
			ASResource asResource = loadQVTiAS(ocl, inputURI);
			LoadTestCase.assertNoResourceErrors("Serializing to " + serializedURI, asResource);
			LoadTestCase.assertNoUnresolvedProxies("Serializing to " + serializedURI, asResource);
			ResourceSet resourceSet = new ResourceSetImpl();
			try {
				LoadTestCase.assertNoValidationErrors("Serializing to " + serializedURI, asResource);
				//
				//	Pivot to CS
				//
				xtextResource = as2cs(ocl, resourceSet, asResource, serializedURI, QVTimperativeCSPackage.eCONTENT_TYPE);
				resourceSet.getResources().clear();
			}
			catch (AssertionFailedError e) {
				try {	// Try and serialize anyway so that a *.qvti is available even on on obsolete installation
					as2cs(ocl, resourceSet, asResource, serializedURI, QVTimperativeCSPackage.eCONTENT_TYPE);
				}
				catch (Throwable t) {}
				throw e;
			}
		}
		finally {
			ocl.dispose();
			ocl = null;
		}

		QVTimperative qvti = QVTimperative.newInstance(getTestProjectManager(), null);
		if (extraLocalPackageRegistryEntries != null) {
			qvti.getResourceSet().getPackageRegistry().putAll(extraLocalPackageRegistryEntries);
		}
		try {
			ImperativeTransformation asTransformation = QVTimperativeUtil.loadTransformation(qvti.getEnvironmentFactory(), serializedURI, false);
			Resource asResource2 = asTransformation.eResource();
			assert asResource2 != null;
			LoadTestCase.assertNoResourceErrors("Loading " + serializedURI, asResource2);
			LoadTestCase.assertNoUnresolvedProxies("Loading " + serializedURI, asResource2);
			LoadTestCase.assertNoValidationErrors("Loading " + serializedURI, asResource2);
		}
		finally {
			qvti.dispose();
			qvti = null;
		}
		//	if (savedExecutor != null) {
		//		ThreadLocalExecutor.setExecutor(savedExecutor);
		//	}
		activate();
		return xtextResource;
	}

	public boolean executeTransformation() throws Exception {
		if (suppressFailureDiagnosis) {
			executor.setSuppressFailureDiagnosis(true);
		}
		Boolean success = executor.execute(null);
		return success == Boolean.TRUE;
	}

	public boolean executeTransformation(@NonNull String targetName) throws Exception {
		if (suppressFailureDiagnosis) {
			executor.setSuppressFailureDiagnosis(true);
		}
		Boolean success = executor.execute(targetName);
		return success == Boolean.TRUE;
	}

	/**
	 * Return true if this chain generates the GenModel.
	 */
	protected boolean generateGenModel() {
		return false;
	}

	protected abstract @NonNull String getBasePrefix();

	public @NonNull JavaClasspath getClasspath() {
		return classpath;
	}

	@Override
	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
		return super.getEnvironmentFactory();
	}

	public @NonNull TransformationExecutor getExecutor() {
		return ClassUtil.nonNullState(executor);
	}

	@Deprecated /** @deprecated use known writeable area in caller */
	private @NonNull URI getJavaClassURI() {
		return testBundleURI.appendSegment("bin");
	}

	@Deprecated /** @deprecated use known writeable area in caller */
	private @NonNull URI getJavaSourceURI() {
		return testBundleURI.appendSegment("test-gen");
	}

	public @NonNull Collection<@NonNull ? extends EObject> getRootEObjects(@NonNull String modelName) {
		return executor.getTypedModelInstance(modelName).getRootEObjects();
	}

	public @NonNull Map<Object, Object> getSaveOptions() {
		Map<Object, Object> saveOptions = new HashMap<Object, Object>(DefaultCompilerOptions.defaultSavingOptions);
		saveOptions.put(ASResource.OPTION_NORMALIZE_CONTENTS, Boolean.TRUE);
		return saveOptions;
	}

	protected @NonNull String getTestBundleName() {
		return testBundleURI.segment(1);
	}

	protected final @NonNull ProjectManager getTestProjectManager() throws Exception {
		return getTestProjectManager("");
	}

	protected @NonNull ProjectManager getTestProjectManager(@NonNull String pathFromCurrentWorkingDirectoryToFileSystem) throws Exception {
		return ProjectManager.NO_PROJECTS;
	}

	public void installClassName(@NonNull String className) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
		Class<?> middleClass = Class.forName(className);
		Field middleField = middleClass.getDeclaredField("eINSTANCE");
		EPackage middleEPackage = (EPackage) middleField.get(null);
		getResourceSet().getPackageRegistry().put(middleEPackage.getNsURI(), middleEPackage);
	}

	protected void instrumentPartition(@NonNull ScheduleManager scheduleManager) {
		ScheduleModel scheduleModel = scheduleManager.getScheduleModel();
		for (@NonNull RootRegion rootRegion : QVTscheduleUtil.getOwnedRootRegions(scheduleModel)) {
			ScheduleManager directedScheduleManager = scheduleManager.getDirectedScheduleManager(rootRegion);
			RootPartitionAnalysis rootPartitionAnalysis = directedScheduleManager.getRootPartitionAnalysis(rootRegion);
			instrumentPartition(directedScheduleManager, rootPartitionAnalysis.getPartition());
		}
	}

	protected void instrumentPartition(@NonNull ScheduleManager directedScheduleManager, @NonNull Partition parentPartition) {
		Class<? extends @NonNull Partition> partitionClass = parentPartition.getClass();
		Integer count = partitionClass2count.get(partitionClass);
		partitionClass2count.put(partitionClass, count == null ? 1 : count+1);
		for (@NonNull Partition childPartition : directedScheduleManager.getConnectionManager().getCallableChildren(parentPartition)) {
			instrumentPartition(directedScheduleManager, childPartition);
		}
	}

	public void loadEPackage(@NonNull Class<?> txClass, @NonNull String qualifiedClassName) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class<?> ePackageClass = txClass.getClassLoader().loadClass(getBasePrefix() + "." + qualifiedClassName);
		EPackage ePackage = (EPackage)ePackageClass.getField("eINSTANCE").get(null);
		assert ePackage != null;
		if (loadedEPackages == null) {
			loadedEPackages = new ArrayList<>();
		}
		loadedEPackages.add(ePackage);
	}

	/**
	 * Explicitly install the eInstances that would normally make it into the ProjectMap from extension point registrations.
	 * Test models are not registered via extension point so we have to do this manually.
	 *
	public void installEPackages(EPackage... eInstances) {
		ResourceSetImpl resourceSet = (ResourceSetImpl) getResourceSet();
		for (EPackage eInstance : eInstances) {
			String nsURI = eInstance.getNsURI();
			if (nsURI != null) {
				nsURIs.add(nsURI);
			}
			resourceSet.getURIResourceMap().put(testPackageURI.appendSegment(eInstance.getName()+".ecore"), eInstance.eResource());
		}
	} */

	public void loadEcoreFile(URI fileURI, EPackage ePackage) {
		// Install nsURI in global registry
		EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
		// Install physical path in local registry
		String fileURIstring = String.valueOf(fileURI);
		getResourceSet().getPackageRegistry().put(fileURIstring, ePackage);
		// Cache physical path for downstream (serialize) local registries
		Map<@NonNull String, @NonNull EPackage> extraLocalPackageRegistryEntries2 = extraLocalPackageRegistryEntries;
		if (extraLocalPackageRegistryEntries2 == null) {
			extraLocalPackageRegistryEntries2 = extraLocalPackageRegistryEntries = new HashMap<>();
		}
		extraLocalPackageRegistryEntries2.put(fileURIstring, ePackage);
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

	protected void loadGenModels(@NonNull String @NonNull... genModelFiles) {
		URI primaryGenModelURI = compilerChain.getURI(CompilerChain.GENMODEL_STEP, CompilerChain.URI_KEY);
		loadGenModel(primaryGenModelURI);
		for (String genModelFile : genModelFiles) {
			URI genModelURI = URI.createURI(genModelFile).resolve(testBundleURI);
			loadGenModel(genModelURI);
		}
	}

	public void loadGenModels(@NonNull URI @NonNull... genModelURIs) {
		for (@NonNull URI genModelURI : genModelURIs) {
			loadGenModel(genModelURI);
		}
	}

	public void removeRegisteredPackage(@NonNull String ePackageClassName, boolean exceptionThrown) throws Exception {
		if (exceptionThrown) {		// Don't compound an earlier failure
			try {
				Class<?> ePackageClass = Class.forName(ePackageClassName);
				Field eNsURIField = ePackageClass.getField("eNS_URI");
				String nsURI = String.valueOf(eNsURIField.get(null));
				EPackage.Registry.INSTANCE.remove(nsURI);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			Class<?> ePackageClass = Class.forName(ePackageClassName);
			Field eNsURIField = ePackageClass.getField("eNS_URI");
			String nsURI = String.valueOf(eNsURIField.get(null));
			EPackage.Registry.INSTANCE.remove(nsURI);
		}
	}

	public void removeRegisteredPackage(@NonNull Class<?> txClass, @NonNull String ePackageClassName, boolean exceptionThrown) throws Exception {
		if (exceptionThrown) {		// Don't compound an earlier failure
			try {
				Class<?> ePackageClass = txClass.getClassLoader().loadClass(ePackageClassName);
				Field eNsURIField = ePackageClass.getField("eNS_URI");
				String nsURI = String.valueOf(eNsURIField.get(null));
				EPackage.Registry.INSTANCE.remove(nsURI);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else {
			Class<?> ePackageClass = Class.forName(ePackageClassName);
			Field eNsURIField = ePackageClass.getField("eNS_URI");
			String nsURI = String.valueOf(eNsURIField.get(null));
			EPackage.Registry.INSTANCE.remove(nsURI);
		}
	}

	@Deprecated /* @deprecated removing resources is a dubious experimental capability */
	public void removeResources() {
		getExecutor().getModelsManager().removeResources();
	}

	public void saveModels(@Nullable Map<?, ?> saveOptions) throws IOException {
		getExecutor().getModelsManager().saveModels(saveOptions);
	}

	public void setCopyright(@Nullable String copyright) {
		this.copyright = copyright;
	}

	protected void setPackagePrefixOption(@NonNull QVTiCodeGenOptions options) {}

	public void setSuppressFailureDiagnosis(boolean suppressFailureDiagnosis) {		// FIXME BUG 511028
		this.suppressFailureDiagnosis = suppressFailureDiagnosis;
	}

	public void writeGraphMLfile(@NonNull URI graphURI) {
		Transformer transformer = ((QVTiTransformationExecutor)executor).getTransformer();
		Execution2GraphVisitor.writeGraphMLfile(transformer, graphURI);
	}
}