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
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.m2m.atl.dsls.core.EMFTCSInjector;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceFactoryImpl;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestFolder;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.Normalizer;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.resource.ProjectManager.IPackageDescriptor;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentThread.AbstractEnvironmentThreadFactory;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.CompilationResult;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.compiler.internal.common.DefaultConfigurations;
import org.eclipse.qvtd.compiler.internal.common.SimpleConfigurations;
import org.eclipse.qvtd.compiler.internal.common.TargetConfiguration;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfigurations;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ConnectivityChecker;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.Execution2GraphVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThread;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationToStringVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.pivot.qvttemplate.utilities.QVTtemplateToStringVisitor;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT.PartitionUsage;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests that QVTc files can be compiled and executed.
 */
public class QVTrCompilerTests extends LoadTestCase
{
	public static final boolean ENABLE_ATL2QVTr_CG_exec = false;	// Set true to debug; may fail if _QVTd_QVTrCompilerTests__testQVTrCompiler_ATL2QVTr_CG isn't a good polugin project.
	public static final boolean ENABLE_ATL2QVTr_reverse_CG = false;	// Set true to debug; test does not pass yet - wip
	private static boolean NO_MERGES = true;				// Set true to suppress the complexities of merging

	public static class DummyPivotExternalURINormalizer implements ModelNormalizer
	{
		public static final @NonNull DummyPivotExternalURINormalizer INSTANCE = new DummyPivotExternalURINormalizer();

		@Override
		public @NonNull List<@NonNull Normalizer> normalize(@NonNull Resource resource) {
			Model model = (Model)resource.getContents().get(0);
			model.setExternalURI("normalized-external-uri");
			return Collections.emptyList();
		}
	}

	protected abstract static class QVTrTestThread<R> extends QVTimperativeEnvironmentThread<R>
	{
		protected QVTrTestThread(@NonNull QVTimperativeEnvironmentThreadFactory environmentThreadFactory, @NonNull String threadName) {
			super(environmentThreadFactory, threadName);
		}

		protected @NonNull String getBasePrefix() {
			return "org.eclipse.qvtd.xtext.qvtrelation.tests";
		}

		@Override
		public void run() {
			Set<String> oldKeys = new HashSet<>(EPackage.Registry.INSTANCE.keySet());
			super.run();
			Set<String> newKeys = new HashSet<>(EPackage.Registry.INSTANCE.keySet());
			for (String key : newKeys) {
				if (!oldKeys.contains(key)) {
					QVTruntimeUtil.errPrintln("Extra " + key + " not unloaded from EPackage.Registry.INSTANCE");
				}
			}
			for (String key : oldKeys) {
				if (!newKeys.contains(key)) {
					QVTruntimeUtil.errPrintln("Missing " + key + " unloaded from EPackage.Registry.INSTANCE");
				}
			}
		}
	}

	protected abstract static class QVTrGenerationThread<R> extends QVTrTestThread<R>
	{
		protected final @NonNull String modelTestName;

		protected class InstrumentedCompilerChain extends QVTrCompilerChain
		{
			protected InstrumentedCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
				super(projectManager, txURI, intermediateFileNamePrefixURI, options);
			}

			@Override
			protected @NonNull QVTr2QVTsCompilerStep createQVTr2QVTsCompilerStep() {
				return new QVTr2QVTsCompilerStep(this)
				{
					@Override
					public @NonNull ScheduleManager execute(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull Resource qvtrResource, @NonNull Resource traceResource, @NonNull TypedModelsConfigurations typedModelsConfigurations) throws IOException {
						ScheduleManager scheduleManager = super.execute(environmentFactory, qvtrResource, traceResource, typedModelsConfigurations);
						partitionUsage.instrumentPartition(scheduleManager);
						return scheduleManager;
					}
				};
			}

			@Override
			public @NonNull ImperativeTransformation qvtr2qvti(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull Resource qvtrResource, @NonNull TypedModelsConfigurations typedModelsConfigurations) throws IOException {
				assertNoValidationErrors("QVTr validation", qvtrResource);
				return super.qvtr2qvti(environmentFactory, qvtrResource, typedModelsConfigurations);
			}
		}

		//	protected final @Nullable String outputName;
		protected final @NonNull TypedModelsConfigurations typedModelsConfigurations;
		/**
		 * The source transformation.
		 */
		protected final @NonNull URI txURI;

		/**
		 * A prefix for output filenames.
		 */
		protected final @NonNull URI intermediateFileNamePrefixURI;

		private final @NonNull PartitionUsage partitionUsage = new PartitionUsage();

		//	protected QVTrGenerationThread(@NonNull QVTrelationEnvironmentThreadFactory environmentThreadFactory, @NonNull String threadName, @NonNull String modelTestName, @Nullable String outputName, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI) {
		protected QVTrGenerationThread(@NonNull QVTrelationEnvironmentThreadFactory environmentThreadFactory,@NonNull String threadName, @NonNull String modelTestName, @NonNull TypedModelsConfigurations typedModelsConfigurations, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI) {
			super(environmentThreadFactory, threadName);
			this.modelTestName = modelTestName;
			this.typedModelsConfigurations = typedModelsConfigurations;
			this.txURI = txURI;
			this.intermediateFileNamePrefixURI = intermediateFileNamePrefixURI;
		}

		protected void assertRegionCount(@NonNull Class<? extends Region> partitionClass, int count) {
			QVTruntimeUtil.errPrintln("assertRegionCount suppressed");
		}

		protected void checkTransformationURI(@NonNull URI inputURI) throws Exception {
			QVTimperativeEnvironmentFactory environmentFactory = getEnvironmentFactory();
			ProjectManager projectManager = environmentFactory.getProjectManager();
			URI inputStem = inputURI.trimFileExtension();
			URI serializedURI = inputStem.appendFileExtension("serialized.qvti");
			AbstractTestQVT.doSerialize(projectManager, inputURI, serializedURI);
		}

		protected @NonNull QVTrCompilerChain createCompilerChain() {
			DefaultCompilerOptions compilerOptions = createCompilerOptions();
			return new InstrumentedCompilerChain(getProjectManager(), txURI, intermediateFileNamePrefixURI, compilerOptions);
		}

		protected @NonNull DefaultCompilerOptions createCompilerOptions() {
			DefaultCompilerOptions compilerOptions = new DefaultCompilerOptions();
			compilerOptions.setOption(CompilerChain.DEFAULT_STEP, CompilerChain.DEBUG_KEY, true);
			return compilerOptions;
		}

		protected @NonNull ImperativeTransformation generateTransformation(@NonNull QVTrCompilerChain compilerChain) throws Exception {
			QVTimperativeEnvironmentFactory environmentFactory = getEnvironmentFactory();
			ImperativeTransformation transformation = compilerChain.compile(environmentFactory, typedModelsConfigurations);
			URI inputURI = transformation.eResource().getURI();
			if (inputURI != null) {
				checkTransformationURI(inputURI);
			}
			return transformation;
		}

		@Override
		protected @NonNull String getBasePrefix() {
			return "org.eclipse.qvtd.xtext.qvtrelation.tests";
		}
	}

	protected abstract class QVTrCodeGenerationThread extends QVTrGenerationThread<@NonNull Class<? extends Transformer>>
	{
		protected final boolean isIncremental;

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

		private @Nullable String copyright = null;
		private Collection<@NonNull GenPackage> usedGenPackages = null;

		protected QVTrCodeGenerationThread(@NonNull String modelTestName, @NonNull String outputName, boolean isIncremental, @NonNull URI txURI) throws MalformedURLException {
			this(modelTestName, new SimpleConfigurations(outputName), isIncremental, txURI);
		}

		protected QVTrCodeGenerationThread(@NonNull String modelTestName, @NonNull TypedModelsConfigurations typedModelsConfigurations, boolean isIncremental, @NonNull URI txURI) throws MalformedURLException {
			super(createQVTrelationEnvironmentThreadFactory(), "QVTr-CodeGeneration", modelTestName, typedModelsConfigurations, txURI, getTestURI(modelTestName));
			this.isIncremental = isIncremental;
			this.srcFileURI = getTestFileURI(JavaFileUtil.TEST_SRC_FOLDER_NAME + "/");
			this.binFileURI = getTestFileURI(JavaFileUtil.TEST_BIN_FOLDER_NAME + "/");
			this.classpath = CompilerUtil.createDefaultQVTiClasspath();
			this.classpath.addFile(getTestProject().getOutputFile(JavaFileUtil.TEST_BIN_FOLDER_NAME).getFile());
		}

		protected void addClass(@NonNull Class<?> javaClass) {
			classpath.addClass(javaClass);
		}

		public @NonNull GenPackage addUsedGenPackage(@NonNull String resourcePath, @Nullable String fragment) {
			if (usedGenPackages == null) {
				usedGenPackages = new ArrayList<>();
			}
			GenPackage genPackage = CompilerUtil.getGenPackage(getEnvironmentFactory().getResourceSet(), resourcePath, fragment);
			usedGenPackages.add(genPackage);
			return genPackage;
		}

		protected @NonNull Class<? extends Transformer> buildTransformation() throws Exception {
			QVTrCompilerChain compilerChain = createCompilerChain();
			QVTimperativeEnvironmentFactory environmentFactory = getEnvironmentFactory();
			ImperativeTransformation transformation = generateTransformation(compilerChain);
			return compilerChain.generate(environmentFactory, transformation);
		}

		@Override
		protected void checkTransformationURI(@NonNull URI inputURI) throws Exception {
			super.checkTransformationURI(inputURI);
			URI inputStem = inputURI.trimFileExtension();
			AbstractTestQVT.doScheduleLoadCheck(environmentThreadFactory, inputStem.appendFileExtension(QVTbaseUtil.QVTSAS_FILE_EXTENSION));
		}

		protected @NonNull JavaClasspath createClassProjectNames() {
			classpath.addClass(getClass()); //testProjectName);
			classpath.addClass(/*0,*/ getClass());
			return classpath;
		}

		@Override
		protected @NonNull DefaultCompilerOptions createCompilerOptions() {
			DefaultCompilerOptions compilerOptions =super.createCompilerOptions();
			compilerOptions.setGenerateClassesOptions(srcFileURI, binFileURI, createClassProjectNames(), isIncremental);
			if (generateGenModel()) {
				URI genModelURI = intermediateFileNamePrefixURI.appendFileExtension(AbstractCompilerChain.getDefaultFileExtension(CompilerChain.GENMODEL_STEP));
				compilerOptions.setGenerateGenModelOptions(genModelURI, getBasePrefix(), copyright, usedGenPackages);
			}
			return compilerOptions;
		}

		protected boolean generateGenModel() {
			return true;
		}

		protected void loadGenModel(@NonNull String genModelString) {
			URI resolvedURI = URI.createURI(genModelString, true).resolve(txURI);
			loadGenModel(resolvedURI);
		}

		protected void loadGenModel(@NonNull URI genModelURI) {
			ResourceSet resourceSet = getEnvironmentFactory().getResourceSet();
			MetamodelManagerInternal metamodelManager = getEnvironmentFactory().getMetamodelManager();
			Resource csGenResource = resourceSet.getResource(genModelURI, true);
			for (EObject eObject : csGenResource.getContents()) {
				if (eObject instanceof GenModel) {
					GenModel genModel = (GenModel)eObject;
					genModel.reconcile();
					metamodelManager.addGenModel(genModel);
				}
			}
		}
	}

	protected abstract class QVTrTxGenerationThread extends QVTrGenerationThread<@NonNull URI>
	{
		protected QVTrTxGenerationThread(@NonNull String resultPrefix, @NonNull String outputName, @NonNull URI txURI) {
			this(resultPrefix, new SimpleConfigurations(outputName), txURI);
		}

		protected QVTrTxGenerationThread(@NonNull String resultPrefix, @NonNull TypedModelsConfigurations typedModelConfigurations, @NonNull URI txURI) {
			super(createQVTrelationEnvironmentThreadFactory(), "QVTr-TxGeneration", resultPrefix, typedModelConfigurations, txURI, getTestURI(resultPrefix));
		}

		@Override
		protected @NonNull DefaultCompilerOptions createCompilerOptions() {
			DefaultCompilerOptions compilerOptions =super.createCompilerOptions();
			//		if (copyright != null) {
			//			compilerOptions.setCopyright(copyright);
			//		}
			//		compilerOptions.setBasePrefix(getBasePrefix());
			//		if (usedGenPackages != null) {
			//			compilerOptions.setUsedGenPackages(usedGenPackages);
			//		}
			compilerOptions.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_EARLY_MERGE, NO_MERGES);
			compilerOptions.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_LATE_CONSUMER_MERGE, NO_MERGES);
			return compilerOptions;
		}

		protected @NonNull URI generateTransformationURI() throws Exception {
			QVTrCompilerChain compilerChain = createCompilerChain();
			ImperativeTransformation iTransformation = generateTransformation(compilerChain);
			URI uri = iTransformation.eResource().getURI();
			assert uri != null;
			return uri;
		}
	}

	protected abstract static class QVTrExecutionTestThread extends QVTrTestThread<Object>
	{
		private TransformationExecutor executor;
		private boolean suppressFailureDiagnosis = false;				// FIXME BUG 511028

		protected QVTrExecutionTestThread(@NonNull QVTimperativeEnvironmentThreadFactory environmentThreadFactory, @NonNull String threadName) {
			super(environmentThreadFactory, threadName);
		}

		protected @Nullable Resource addInputURI(@NonNull String modelName, @NonNull URI modelURI) {
			return executor.addInputURI(modelName, modelURI);
		}

		protected @NonNull Resource addOutputURI(@NonNull String modelName, @NonNull URI modelURI) {
			return executor.addOutputURI(modelName, modelURI);
		}

		protected @NonNull Resource checkOutput(@NonNull URI actualURI, @Nullable URI expectedURI, @Nullable ModelNormalizer normalizer) throws Exception {
			return AbstractTestQVT.checkOutput(environmentThreadFactory, actualURI, expectedURI, normalizer);
		}

		protected void configureExtension(@NonNull String extension, Resource.@NonNull Factory resourceFactory) {
			Map<String, Object> extensionToFactoryMap = getEnvironmentFactory().getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap();
			extensionToFactoryMap.put(extension, resourceFactory);
		}

		protected boolean executeTransformation() throws Exception {
			if (suppressFailureDiagnosis) {
				executor.setSuppressFailureDiagnosis(true);
			}
			Boolean success = executor.execute(null);
			return success == Boolean.TRUE;
		}

		protected boolean executeTransformation(@NonNull String targetName) throws Exception {
			if (suppressFailureDiagnosis) {
				executor.setSuppressFailureDiagnosis(true);
			}
			Boolean success = executor.execute(targetName);
			return success == Boolean.TRUE;
		}

		protected void loadEcoreFile(URI fileURI, EPackage ePackage) {
			ResourceSet rSet = getEnvironmentFactory().getResourceSet();
			rSet.getPackageRegistry().put(fileURI.toString(), ePackage);
			EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);		// FIXME Accumulate for cleanup
		}

		protected void saveModels(@Nullable Map<?, ?> saveOptions) throws IOException {
			executor.getModelsManager().saveModels(saveOptions);
		}

		protected void setContextualProperty(@NonNull String propertyName, Object value) {
			executor.setContextualProperty(propertyName, value);
		}

		protected void setExecutor(@NonNull TransformationExecutor executor) {
			this.executor = executor;
		}

		public void writeGraphMLfile(@NonNull URI graphURI) {
			Transformer transformer = executor.getTransformer();
			Execution2GraphVisitor.writeGraphMLfile(transformer, graphURI);
		}
	}

	protected abstract class QVTrCodeExecutionThread extends QVTrExecutionTestThread
	{
		protected @NonNull Class<? extends Transformer> txClass;
		private Collection<@NonNull EPackage> loadedEPackages = null;

		protected QVTrCodeExecutionThread(@NonNull Class<? extends Transformer> txClass) {
			super(createQVTimperativeEnvironmentThreadFactory(), "QVTr-CodeExecution");
			this.txClass = txClass;
		}

		protected void createGeneratedExecutor() throws ReflectiveOperationException {
			setExecutor(new QVTiTransformationExecutor(getEnvironmentFactory(), txClass));
		}

		protected void loadEPackage(@NonNull String qualifiedClassName) throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
			Class<?> ePackageClass = txClass.getClassLoader().loadClass(getBasePrefix() + "." + qualifiedClassName);
			EPackage ePackage = (EPackage)ePackageClass.getField("eINSTANCE").get(null);
			assert ePackage != null;
			if (loadedEPackages == null) {
				loadedEPackages = new ArrayList<>();
			}
			loadedEPackages.add(ePackage);
		}

		protected void unloadEPackages() {
			if (loadedEPackages != null) {
				for (@NonNull EPackage ePackage : loadedEPackages) {
					EPackage.Registry.INSTANCE.remove(ePackage.getNsURI());
				}
			}
		}
	}

	protected abstract class QVTrTxInterpretationThread extends QVTrExecutionTestThread
	{
		protected @NonNull URI txURI;
		protected @Nullable String entryPointName;
		private ImperativeTransformation iTransformation;

		protected QVTrTxInterpretationThread(@NonNull URI txURI, @Nullable String entryPointName) {
			super(createQVTimperativeEnvironmentThreadFactory(), "QVTr-TxInterpretation");
			this.txURI = txURI;
			this.entryPointName = entryPointName;
		}

		protected void createInterpretedExecutor() throws Exception {
			assert iTransformation != null;
			EntryPoint entryPoint = entryPointName != null ? QVTimperativeUtil.getEntryPoint(iTransformation, entryPointName) : QVTimperativeUtil.getDefaultEntryPoint(iTransformation);
			setExecutor(new BasicQVTiExecutor(getEnvironmentFactory(), entryPoint, ModeFactory.LAZY));
		}

		protected void loadTransformation() {
			Resource resource = getEnvironmentFactory().getMetamodelManager().getASResourceSet().getResource(txURI, true);
			for (TreeIterator<EObject> tit = resource.getAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof ImperativeTransformation) {
					iTransformation = (ImperativeTransformation)eObject;
					return;
				}
				//	else if (eObject instanceof Import) {
				//		Namespace importedNamespace = ((Import)eObject).getImportedNamespace();
				//		getClass();
				//	}
				else if (!(eObject instanceof Model)  && !(eObject instanceof org.eclipse.ocl.pivot.Package)) {
					tit.prune();
				}
			}
			throw new IllegalStateException("No transformation");
		}
	}

	public class MyQVT extends AbstractTestQVT
	{
		protected class InstrumentedCompilerChain extends QVTrCompilerChain
		{
			protected InstrumentedCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
				super(projectManager, txURI, intermediateFileNamePrefixURI, options);
			}

			@Override
			protected @NonNull QVTr2QVTsCompilerStep createQVTr2QVTsCompilerStep() {
				return new QVTr2QVTsCompilerStep(this)
				{
					@Override
					public @NonNull ScheduleManager execute(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull Resource qvtrResource, @NonNull Resource traceResource, @NonNull TypedModelsConfigurations typedModelsConfigurations) throws IOException {
						ScheduleManager scheduleManager = super.execute(environmentFactory, qvtrResource, traceResource, typedModelsConfigurations);
						partitionUsage.instrumentPartition(scheduleManager);
						return scheduleManager;
					}
				};
			}

			@Override
			public @NonNull ImperativeTransformation qvtr2qvti(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull Resource qvtrResource, @NonNull TypedModelsConfigurations typedModelsConfigurations) throws IOException {
				assertNoValidationErrors("QVTr validation", qvtrResource);
				return super.qvtr2qvti(environmentFactory, qvtrResource, typedModelsConfigurations);
			}
		}

		protected final @NonNull PartitionUsage partitionUsage = new PartitionUsage();
		private boolean keepOldJavaFiles = false;

		public MyQVT(@NonNull ProjectManager projectManager, @NonNull TestProject testProject, @NonNull URI testBundleURI, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull URI srcFileURI, @NonNull URI binFileURI) throws IOException {
			super(projectManager, testProject, testBundleURI, txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
			//	getEnvironmentFactory().setSafeNavigationValidationSeverity(StatusCodes.Severity.WARNING);
		}

		public @NonNull Resource checkOutput(@NonNull URI actualURI, @Nullable URI expectedURI, @Nullable ModelNormalizer normalizer) throws Exception {
			QVTrelationEnvironmentThreadFactory environmentThreadFactory = createQVTrelationEnvironmentThreadFactory();
			return checkOutput(environmentThreadFactory, actualURI, expectedURI, normalizer);
		}

		public @NonNull CompilationResult compileTransformation(@NonNull String outputName) throws Exception {
			SimpleConfigurations typedModelsConfigurations = new SimpleConfigurations(outputName);
			return compileTransformation(typedModelsConfigurations);
		}

		public @NonNull CompilationResult compileTransformation(@NonNull TypedModelsConfigurations typedModelsConfigurations) throws Exception {
			AbstractEnvironmentThreadFactory<@NonNull QVTimperativeEnvironmentFactory> environmentThreadFactory = createQVTrelationEnvironmentThreadFactory();
			return compileTransformation(environmentThreadFactory, typedModelsConfigurations);
		}

		private void configureGeneratedPackage( /*@NonNull*/ String uriString) {
			URI nsURI = URI.createURI(uriString);
			IPackageDescriptor packageDescriptor = getProjectManager().getPackageDescriptor(nsURI);
			if (packageDescriptor != null) {
				packageDescriptor.configure(getResourceSet(), StandaloneProjectMap.LoadGeneratedPackageStrategy.INSTANCE, null);
			}
		}

		@Override
		protected @NonNull CompilerOptions createBuildCompilerChainOptions(boolean isIncremental) throws IOException {
			CompilerOptions options = super.createBuildCompilerChainOptions(isIncremental);
			if (keepOldJavaFiles) {
				options.setOption(CompilerChain.GENMODEL_STEP, CompilerChain.KEEP_OLD_JAVA_FILES_KEY, Boolean.TRUE);
			}
			return options;
		}

		@Override
		protected @NonNull QVTrCompilerChain createCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
			return new InstrumentedCompilerChain(projectManager, txURI, intermediateFileNamePrefixURI, options);
		}

		@Override
		protected @NonNull DefaultCompilerOptions createCompilerChainOptions() {
			DefaultCompilerOptions options = super.createCompilerChainOptions();
			options.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_EARLY_MERGE, NO_MERGES);
			options.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_LATE_CONSUMER_MERGE, NO_MERGES);
			return options;
		}

		@Override
		protected boolean generateGenModel() {
			return true;
		}

		@Override
		protected @NonNull String getBasePrefix() {
			return "org.eclipse.qvtd.xtext.qvtrelation.tests";
		}

		@Override
		protected @NonNull ProjectManager getTestProjectManager(@NonNull String pathFromCurrentWorkingDirectoryToFileSystem) {
			return EMFPlugin.IS_ECLIPSE_RUNNING ? new ProjectMap(true) : QVTrCompilerTests.this.getTestProjectManager(pathFromCurrentWorkingDirectoryToFileSystem);
		}

		protected void setKeepOldJavaFiles() {
			this.keepOldJavaFiles = true;
		}
	}

	protected static class PivotQVTrelationToStringFactory implements QVTtemplateToStringVisitor.Factory
	{
		protected PivotQVTrelationToStringFactory() {
			ToStringVisitor.addFactory(PivotPackage.eINSTANCE, this);
			ToStringVisitor.addFactory(QVTtemplatePackage.eINSTANCE, this);
			QVTrelationToStringVisitor.FACTORY.getClass();
		}

		@Override
		public @NonNull ToStringVisitor createToStringVisitor(@NonNull StringBuilder s) {
			return new QVTrelationToStringVisitor(s);
		}

		@Override
		public @NonNull EPackage getEPackage() {
			EPackage eInstance = PivotPackage.eINSTANCE;
			assert eInstance != null;
			return eInstance;
		}
	}

	public QVTrelationTestFileSystemHelper testFileSystemHelper = null;

	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTrelation.newInstance(getTestProjectManager(), null);
	}

	protected @NonNull MyQVT createQVT(@NonNull String resultPrefix, @NonNull URI txURI) throws Exception {
		ProjectManager testProjectManager = getTestProjectManager();
		URI intermediateFileNamePrefixURI = getTestURI(resultPrefix);
		URI srcFileURI = getTestFileURI(JavaFileUtil.TEST_SRC_FOLDER_NAME + "/");
		URI binFileURI = getTestFileURI(JavaFileUtil.TEST_BIN_FOLDER_NAME + "/");
		return new MyQVT(testProjectManager, getTestProject(), getTestBundleURI(), txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
	}

	@Override
	protected @NonNull QVTrelationTestFileSystemHelper getTestFileSystemHelper() {
		QVTrelationTestFileSystemHelper testFileSystemHelper2 = testFileSystemHelper;
		if (testFileSystemHelper2 == null) {
			testFileSystemHelper = testFileSystemHelper2 = new QVTrelationTestFileSystemHelper();
		}
		return testFileSystemHelper2;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		//	StandaloneProjectMap.addTrace("http://www.eclipse.org/qvt/2016/QVTimperative", ~0);
		//	StandaloneProjectMap.addTrace("http://www.eclipse.org/qvt/2018/QVTtrace", ~0);
		//	StandaloneProjectMap.addTrace("http://www.eclipse.org/qvt/2019/QVTruntimeLibrary", ~0);
		//		BaseLinkingService.DEBUG_RETRY.setState(true);
		QVTm2QVTs.DEBUG_GRAPHS.setState(true);;
		super.setUp();
		OCLstdlib.install();
		XtextCompilerUtil.doQVTrelationSetup();
		XtextCompilerUtil.doQVTcoreSetup();
		XtextCompilerUtil.doQVTimperativeSetup();
		//		QVTrelationPivotStandaloneSetup.doSetup();
		//		QVTimperativePivotStandaloneSetup.doSetup();
		ConnectivityChecker.CONNECTIVITY.setState(true);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#tearDown()
	 */
	@Override
	@After
	public void tearDown() throws Exception {
		ConnectivityChecker.CONNECTIVITY.setState(false);
		super.tearDown();
	}

	@Test
	public void testQVTrCompiler_ATL2QVTr_CG() throws Exception {
		QVTrelationTestFileSystemHelper testFileSystemHelper = getTestFileSystemHelper();
		testFileSystemHelper.addRequiredBundle("org.eclipse.qvtd.atl");
		testFileSystemHelper.addExportedPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.newatl2qvtr");
		URI txURI1 = getModelsURI("newATL2QVTr/NewATL2QVTr.qvtr");
		MyQVT myQVT1 = createQVT("NewATL2QVTr", txURI1);
		//		URI txURI1 = URI.createPlatformResourceURI("/org.eclipse.qvtd.atl/model/ATL2QVTr.qvtr", true);
		//		MyQVT myQVT1 = createQVT("ATL2QVTr", txURI1);
		myQVT1.addUsedGenPackage("org.eclipse.m2m.atl.common/model/ATL.genmodel", "//ATL");
		myQVT1.addUsedGenPackage("org.eclipse.m2m.atl.common/model/ATL.genmodel", "//OCL");
		myQVT1.addUsedGenPackage("org.eclipse.m2m.atl.common/model/ATL.genmodel", "//PrimitiveTypes");
		myQVT1.addUsedGenPackage("org.eclipse.ocl.pivot/model/Pivot.genmodel", "//pivot");
		myQVT1.addUsedGenPackage("org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.genmodel", "//qvtbase");
		myQVT1.addUsedGenPackage("org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.genmodel", "//qvtrelation");
		myQVT1.addUsedGenPackage("org.eclipse.qvtd.pivot.qvttemplate/model/QVTtemplate.genmodel", "//qvttemplate");
		JavaClasspath classpath1 = myQVT1.getClasspath();
		classpath1.addClass(org.eclipse.m2m.atl.common.ATLLaunchConstants.class);
		classpath1.addClass(org.eclipse.qvtd.pivot.qvtbase.BaseModel.class);
		classpath1.addClass(org.eclipse.qvtd.pivot.qvtrelation.RelationModel.class);
		classpath1.addClass(org.eclipse.qvtd.pivot.qvttemplate.TemplateExp.class);
		classpath1.addClass(org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.class);
		//	try {
		ClassLoader classLoader = getClass().getClassLoader();
		assert classLoader != null;
		((PivotMetamodelManager)myQVT1.getMetamodelManager()).getImplementationManager().getClassLoaders().add(classLoader);
		Class<? extends Transformer> txClass1 = myQVT1.buildTransformation("qvtr", false);
		//			Class<? extends Transformer> txClass = ATL2QVTr.class;
		//
		//			myQVT1.assertRegionCount(BasicMappingRegionImpl.class, 0);
		//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0)
		//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
		//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 8);
		//	}
		//	finally {
		myQVT1.dispose();
		myQVT1 = null;
		//	}
		ThreadLocalExecutor.waitForGC();
		URI txURI2 = getTestURI("Families2Persons_CG.qvtras");
		QVTrCodeExecutionThread executionThread1 = new QVTrCodeExecutionThread(txClass1)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				createGeneratedExecutor();
				//	if (EMFPlugin.IS_ECLIPSE_RUNNING) {
				EMFTCSInjector.class.getName();				// Hidden ATL dependency
				AtlParser.class.getName();					// Hidden ATL dependency
				configureExtension("atl", new AtlResourceFactoryImpl());
				addInputURI("atl", getModelsURI("families2persons/Families2Persons.atl"));
				//	}
				//	else {
				//		addInputURI("atl", getModelsURI("families2persons/Families2Persons.atl.xmi"));		// FIXME Working around BUG 514604
				//	}
				ToStringVisitor.addFactory(new PivotQVTrelationToStringFactory());
				executeTransformation();
				addOutputURI("qvtr", txURI2);
				saveModels(null);
				checkOutput(txURI2, getModelsURI("families2persons/Families2Persons_expected.qvtras"), QVTrNormalizer.INSTANCE);	// FIXME normalization unnecessary once Relation domains ordered by tx
				return null;
			}
		};
		executionThread1.invoke();
		ThreadLocalExecutor.waitForGC();
		Class<? extends Transformer> txClass3;
		MyQVT myQVT3 = createQVT("Families2Persons", txURI2);
		// Avoid the Java files being deleted, and add their classPath since we will compile them again Ugh! use different packge prefix
		myQVT3.setKeepOldJavaFiles();
		JavaClasspath classpath3 = myQVT3.getClasspath();
		classpath3.addClass(org.eclipse.m2m.atl.common.ATLLaunchConstants.class);
		classpath3.addClass(org.eclipse.qvtd.pivot.qvtbase.BaseModel.class);
		classpath3.addClass(org.eclipse.qvtd.pivot.qvtrelation.RelationModel.class);
		classpath3.addClass(org.eclipse.qvtd.pivot.qvttemplate.TemplateExp.class);
		classpath3.addClass(org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.class);
		//		MyQVT myQVT3 = new MyQVT(createTestProjectManager(), getTestBundleURI(), "models/families2persons", "samples");
		//		myQVT3.addRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.models.families2persons.Families.FamiliesPackage");
		//		myQVT3.addRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.models.families2persons.Persons.PersonsPackage");
		//		myQVT3.addRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.models.families2persons.trace_Families2Persons.trace_Families2PersonsPackage");
		try {
			txClass3 = myQVT3.buildTransformation("Persons", false);//,
			myQVT3.assertRegionCount(RuleRegionImpl.class, 0);
			//			myQVT3.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT3.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT3.assertRegionCount(MicroMappingRegionImpl.class, 4);
		}
		finally {
			myQVT3.dispose();
			myQVT3 = null;
		}
		QVTrCodeExecutionThread executionThread2 = new QVTrCodeExecutionThread(txClass3)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEPackage("Families.FamiliesPackage");
				loadEPackage("Persons.PersonsPackage");
				loadEPackage("trace_Families2Persons.trace_Families2PersonsPackage");
				//
				createGeneratedExecutor();
				addInputURI("Families", getModelsURI("families2persons/samples/Families.xmi"));
				executeTransformation();
				addOutputURI("Persons", getTestURI("Persons_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("Persons_CG.xmi"), getModelsURI("families2persons/samples/Persons_expected.xmi"), Families2PersonsNormalizer.INSTANCE);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread2.invoke();
		cleanup("http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/xtext/qvtrelation/tests/newatl2qvtr/NewATL2QVTr");
	}

	@Test
	public void testQVTrCompiler_ATL2QVTr_reverse_CG() throws Exception {
		if (!ENABLE_ATL2QVTr_reverse_CG) {
			return;
		}
		URI txURI1 = getModelsURI("newATL2QVTr/NewATL2QVTr.qvtr");
		MyQVT myQVT1 = createQVT("NewATL2QVTr", txURI1);
		//		URI txURI1 = URI.createPlatformResourceURI("/org.eclipse.qvtd.atl/model/ATL2QVTr.qvtr", true);
		//		MyQVT myQVT1 = createQVT("ATL2QVTr", txURI1);
		myQVT1.addUsedGenPackage("org.eclipse.m2m.atl.common/model/ATL.genmodel", "//ATL");
		myQVT1.addUsedGenPackage("org.eclipse.m2m.atl.common/model/ATL.genmodel", "//OCL");
		myQVT1.addUsedGenPackage("org.eclipse.m2m.atl.common/model/ATL.genmodel", "//PrimitiveTypes");
		myQVT1.addUsedGenPackage("org.eclipse.ocl.pivot/model/Pivot.genmodel", "//pivot");
		myQVT1.addUsedGenPackage("org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.genmodel", "//qvtbase");
		myQVT1.addUsedGenPackage("org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.genmodel", "//qvtrelation");
		myQVT1.addUsedGenPackage("org.eclipse.qvtd.pivot.qvttemplate/model/QVTtemplate.genmodel", "//qvttemplate");
		JavaClasspath classpath1 = myQVT1.getClasspath();
		classpath1.addClass(org.eclipse.m2m.atl.common.ATLLaunchConstants.class);
		classpath1.addClass(org.eclipse.qvtd.pivot.qvtbase.BaseModel.class);
		classpath1.addClass(org.eclipse.qvtd.pivot.qvtrelation.RelationModel.class);
		classpath1.addClass(org.eclipse.qvtd.pivot.qvttemplate.TemplateExp.class);
		classpath1.addClass(org.eclipse.qvtd.atl.atl2qvtr.ATL2QVTr.class);
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			assert classLoader != null;
			((PivotMetamodelManager)myQVT1.getMetamodelManager()).getImplementationManager().getClassLoaders().add(classLoader);
			/*txClass1 =*/ myQVT1.buildTransformation("atl", false);
			//			Class<? extends Transformer> txClass = ATL2QVTr.class;
			//
			//			myQVT1.assertRegionCount(BasicMappingRegionImpl.class, 0);
			//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0)
			//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 8);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		/*		URI txURI2 = getTestURI("Families2Persons_CG.qvtras");
		MyQVT myQVT2 = createQVT("ATL2QVTr", txURI1);
		//		MyQVT myQVT2 = new MyQVT(createTestProjectManager(), getTestBundleURI(), "models/families2persons", null);
		try {
			myQVT2.createGeneratedExecutor(txClass1);
			if (EMFPlugin.IS_ECLIPSE_RUNNING) {
				EMFTCSInjector.class.getName();				// Hidden ATL dependency
				AtlParser.class.getName();					// Hidden ATL dependency
				myQVT2.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl());
				myQVT2.loadInput("atl", getModelsURI("families2persons/Families2Persons.atl"));
			}
			else {
				myQVT2.loadInput("atl", getModelsURI("families2persons/Families2Persons.atl.xmi"));		// FIXME Working around BUG 514604
			}
			ToStringVisitor.addFactory(new PivotQVTrelationToStringFactory());
			myQVT2.executeTransformation();
			myQVT2.saveOutput("qvtr", txURI2, getModelsURI("families2persons/Families2Persons_expected.qvtras"), QVTrNormalizer.INSTANCE);	// FIXME normalization unnecessary once Relation domains ordered by tx
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
		Class<? extends Transformer> txClass3;
		MyQVT myQVT3 = createQVT("Families2Persons", txURI2);
		// Avoid the Java files being deleted, and add their classPath since we will compile them again Ugh! use different packge prefix
		myQVT3.setKeepOldJavaFiles();
		myQVT3.addClasspathProjectName("org.eclipse.m2m.atl.common");
		myQVT3.addClasspathProjectName("org.eclipse.qvtd.pivot.qvtbase");
		myQVT3.addClasspathProjectName("org.eclipse.qvtd.pivot.qvtrelation");
		myQVT3.addClasspathProjectName("org.eclipse.qvtd.pivot.qvttemplate");
		myQVT3.addClasspathProjectName("org.eclipse.qvtd.atl");
		//		MyQVT myQVT3 = new MyQVT(createTestProjectManager(), getTestBundleURI(), "models/families2persons", "samples");
		//		myQVT3.addRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.models.families2persons.Families.FamiliesPackage");
		//		myQVT3.addRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.models.families2persons.Persons.PersonsPackage");
		//		myQVT3.addRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.models.families2persons.trace_Families2Persons.trace_Families2PersonsPackage");
		try {
			txClass3 = myQVT3.buildTransformation("Persons", false);//,
			myQVT3.assertRegionCount(RuleRegionImpl.class, 0);
			//			myQVT3.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT3.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT3.assertRegionCount(MicroMappingRegionImpl.class, 4);
		}
		finally {
			myQVT3.dispose();
			myQVT3 = null;
		}
		MyQVT myQVT4 = createQVT("Families2Persons", txURI2);
		try {
			myQVT4.loadEPackage(txClass3, "Families.FamiliesPackage");
			myQVT4.loadEPackage(txClass3, "Persons.PersonsPackage");
			myQVT4.loadEPackage(txClass3, "trace_Families2Persons.trace_Families2PersonsPackage");
			//
			myQVT4.createGeneratedExecutor(txClass3);
			myQVT4.loadInput("Families", getModelsURI("families2persons/samples/Families.xmi"));
			myQVT4.executeTransformation();
			myQVT4.saveOutput("Persons", getTestURI("Persons_CG.xmi"), getModelsURI("families2persons/samples/Persons_expected.xmi"), Families2PersonsNormalizer.INSTANCE);
		}
		finally {
			myQVT4.dispose();
			myQVT4 = null;
		} */
	}

	@Test
	public void testQVTrCompiler_ATL2QVTr_CG_exec() throws Exception {
		if (!ENABLE_ATL2QVTr_CG_exec) {
			return;
		}
		//		Class<? extends Transformer> txClass1 = org.eclipse.qvtd.xtext.qvtrelation.tests.newatl2qvtr.NewATL2QVTr.class;
		Class<?> txClass0 = Class.forName("org.eclipse.qvtd.xtext.qvtrelation.tests.newatl2qvtr.NewATL2QVTr");
		@SuppressWarnings("unchecked")
		Class<Transformer> txClass1 = (Class<Transformer>)txClass0;
		//		URI txURI1 = getModelsURI("newATL2QVTr/NewATL2QVTr.qvtr");

		URI txURI2 = getTestURI("Families2Persons_CG.qvtras");
		//	MyQVT myQVT2 = createQVT("ATL2QVTr", txURI2);
		//		MyQVT myQVT2 = new MyQVT(createTestProjectManager(), getTestBundleURI(), "models/families2persons", null);
		//	try {
		QVTrCodeExecutionThread executionThread1 = new QVTrCodeExecutionThread(txClass1)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				createGeneratedExecutor();
				if (EMFPlugin.IS_ECLIPSE_RUNNING) {
					EMFTCSInjector.class.getName();				// Hidden ATL dependency
					AtlParser.class.getName();					// Hidden ATL dependency
					configureExtension("atl", new AtlResourceFactoryImpl());
					addInputURI("atl", getModelsURI("families2persons/Families2Persons.atl"));
				}
				else {
					addInputURI("atl", getModelsURI("families2persons/Families2Persons.atl.xmi"));		// FIXME Working around BUG 514604
				}
				ToStringVisitor.addFactory(new PivotQVTrelationToStringFactory());
				executeTransformation();
				addOutputURI("qvtr", txURI2);
				saveModels(null);
				checkOutput(txURI2, getModelsURI("families2persons/Families2Persons_expected.qvtras"), null);
				return null;
			}
		};
		executionThread1.invoke();
		//	}
		//	finally {
		//		myQVT2.dispose();
		//	myQVT2 = null;
		//	}
		ThreadLocalExecutor.waitForGC();
		Class<? extends Transformer> txClass3;
		MyQVT myQVT3 = createQVT("Families2Persons", txURI2);
		//		MyQVT myQVT3 = new MyQVT(createTestProjectManager(), getTestBundleURI(), "models/families2persons", "samples");
		//		myQVT3.addRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.models.families2persons.Families.FamiliesPackage");
		//		myQVT3.addRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.models.families2persons.Persons.PersonsPackage");
		//		myQVT3.addRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.models.families2persons.trace_Families2Persons.trace_Families2PersonsPackage");
		try {
			txClass3 = myQVT3.buildTransformation("Persons", false);//,
			myQVT3.assertRegionCount(RuleRegionImpl.class, 2);
			//	myQVT3.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//	myQVT3.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//	myQVT3.assertRegionCount(MicroMappingRegionImpl.class, 0);
		}
		finally {
			myQVT3.dispose();
			myQVT3 = null;
		}
		QVTrCodeExecutionThread executionThread2 = new QVTrCodeExecutionThread(txClass3)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEPackage("Families.FamiliesPackage");
				loadEPackage("Persons.PersonsPackage");
				loadEPackage("trace_Families2Persons.trace_Families2PersonsPackage");
				//
				createGeneratedExecutor();
				addInputURI("Families", getModelsURI("families2persons/samples/Families.xmi"));
				executeTransformation();
				addOutputURI("Persons", getTestURI("Persons_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("Persons_CG.xmi"), getModelsURI("families2persons/samples/Persons_expected.xmi"), Families2PersonsNormalizer.INSTANCE);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread2.invoke();
	}

	@Test
	public void testQVTrCompiler_Ecore2Pivot() throws Exception {
		/*	QVTrelationTestFileSystemHelper testFileSystemHelper = getTestFileSystemHelper();
		testFileSystemHelper.addRequiredBundle("org.eclipse.qvtd.pivot.qvtbase");
		Class<? extends Transformer> txClass1 = null;
		URI txURI1 = getModelsURI("ecore2pivot/Ecore2Pivot.qvtr");
		MyQVT myQVT1 = createQVT("Ecore2Pivot", txURI1);
		myQVT1.addUsedGenPackage("org.eclipse.emf.ecore/model/Ecore.genmodel", "//ecore");
		myQVT1.addUsedGenPackage("org.eclipse.ocl.pivot/model/Pivot.genmodel", "//pivot");
		ProjectManager projectManager = myQVT1.getProjectManager();
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			assert classLoader != null;
			((PivotMetamodelManager)myQVT1.getMetamodelManager()).getImplementationManager().getClassLoaders().add(classLoader);
			txClass1 = myQVT1.buildTransformation("as", false);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		URI ecoreURI = getModelsURI("ecore2pivot/Families.ecore");
		URI asURI2a = getTestURI("Families2.ecore.oclas");
		ProjectManager testProjectManager = getTestProjectManager();
		OCL ocl = OCL.newInstance(testProjectManager);
		try {
			Resource inputResource = ocl.getResourceSet().getResource(ecoreURI, true);
			assert inputResource != null;
			assertNoResourceErrors("Ecore load", inputResource);
			assertNoValidationErrors("Ecore load", inputResource);
			Ecore2AS ecore2as = Ecore2AS.getAdapter(inputResource, (EnvironmentFactoryInternal) ocl.getEnvironmentFactory());
			Model pivotModel = ecore2as.getASModel();
			Resource asResource = pivotModel.eResource();
			asResource.setURI(asURI2a);
			assertNoResourceErrors("Ecore2AS failed", asResource);
			asResource.save(XMIUtil.createSaveOptions());
			assertValidationDiagnostics("Ecore2AS invalid", asResource, NO_MESSAGES);
		}
		finally {
			ocl.dispose();
			ocl = null;
		}
		MyQVT myQVT = createQVT("Forward2Reverse", getModelsURI("ecore2pivot/Ecore2Pivot.qvtr"));
		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		URI asURI2 = getTestURI("Families.ecore.oclas");
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("as");
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.addInputURI("ecore", ecoreURI);
			myQVT.executeTransformation();
			myQVT.addOutputURI("as", asURI2);
			myQVT.saveModels(null);
			myQVT.checkOutput(asURI2, asURI2a, null); //Forward2ReverseNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
			myQVT = null;
		} */
	}

	@Test
	public void testQVTrCompiler_Ecore2Pivot_CG() throws Exception {
		/*	//	StandaloneProjectMap.addTrace(EcorePackage.eNS_URI, ~0);
		//	StandaloneProjectMap.addTrace(OCLstdlibPackage.eNS_URI, ~0);
		//	StandaloneProjectMap.addTrace(PivotPackage.eNS_URI, ~0);
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		AbstractTransformer.EXCEPTIONS.setState(true);
		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		AbstractMerger.EARLY.setState(true);
		//		AbstractMerger.FAILURE.setState(true);
		//		AbstractMerger.LATE.setState(true);
		//		ConnectivityChecker.CONNECTIVITY_CLASSDATUMS.setState(true);
		//		ConnectivityChecker.CONNECTIVITY_CONNECTIONS.setState(true);
		//		ConnectivityChecker.CONNECTIVITY_EDGES.setState(true);
		//		ConnectivityChecker.CONNECTIVITY_NODES.setState(true);
		QVTrelationTestFileSystemHelper testFileSystemHelper = getTestFileSystemHelper();
		testFileSystemHelper.addRequiredBundle("org.eclipse.qvtd.pivot.qvtbase");
		Class<? extends Transformer> txClass1 = null;
		//		URI txURI1 = URI.createPlatformResourceURI("/org.eclipse.ocl.pivot/model/Ecore2Pivot.qvtr", true);
		URI txURI1 = getModelsURI("ecore2pivot/Ecore2Pivot.qvtr");
		MyQVT myQVT1 = createQVT("Ecore2Pivot", txURI1);
		myQVT1.addUsedGenPackage("org.eclipse.emf.ecore/model/Ecore.genmodel", "//ecore");
		myQVT1.addUsedGenPackage("org.eclipse.ocl.pivot/model/Pivot.genmodel", "//pivot");
		ProjectManager projectManager = myQVT1.getProjectManager();
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			assert classLoader != null;
			((PivotMetamodelManager)myQVT1.getMetamodelManager()).getImplementationManager().getClassLoaders().add(classLoader);
			txClass1 = myQVT1.buildTransformation("as", false);
			//			Class<? extends Transformer> txClass = Ecore2Pivot.class;
			//
			//			myQVT1.assertRegionCount(BasicMappingRegionImpl.class, 0);
			//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0)
			//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 8);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		URI asURI2a = getTestURI("Families2.ecore.oclas");
		URI ecoreURI = getModelsURI("ecore2pivot/Families.ecore");
		OCL ocl = OCL.newInstance(projectManager);
		try {
			Resource inputResource = ocl.getResourceSet().getResource(ecoreURI, true);
			assert inputResource != null;
			assertNoResourceErrors("Ecore load", inputResource);
			assertNoValidationErrors("Ecore load", inputResource);
			Ecore2AS ecore2as = Ecore2AS.getAdapter(inputResource, (EnvironmentFactoryInternal) ocl.getEnvironmentFactory());
			Model pivotModel = ecore2as.getASModel();
			Resource asResource = pivotModel.eResource();
			asResource.setURI(asURI2a);
			assertNoResourceErrors("Ecore2AS failed", asResource);
			asResource.save(XMIUtil.createSaveOptions());
			assertValidationDiagnostics("Ecore2AS invalid", asResource, NO_MESSAGES);
		}
		finally {
			ocl.dispose();
			ocl = null;
		}
		//
		URI asURI2 = getTestURI("Families.ecore.oclas");
		MyQVT myQVT2 = createQVT("Ecore2Pivot", txURI1);
		//		MyQVT myQVT2 = new MyQVT(createTestProjectManager(), getTestBundleURI(), "models/families2persons", null);
		try {
			myQVT2.createGeneratedExecutor(txClass1);
			//			myQVT2.loadInput("ecore", getModelsURI("families2persons/Families.ecore"));
			myQVT2.addInputURI("ecore", ecoreURI);
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("as", asURI2);
			myQVT2.saveModels(null);
			myQVT2.checkOutput(asURI2, asURI2a, null);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		} */
	}

	@Test
	public void testQVTrCompiler_Ecore2PivotRoot() throws Exception {
		/*	QVTrelationTestFileSystemHelper testFileSystemHelper = getTestFileSystemHelper();
		testFileSystemHelper.addRequiredBundle("org.eclipse.qvtd.pivot.qvtbase");
		Class<? extends Transformer> txClass1 = null;
		URI txURI1 = getModelsURI("ecore2pivot/Ecore2Pivot.qvtr");
		MyQVT myQVT1 = createQVT("Ecore2Pivot", txURI1);
		myQVT1.addUsedGenPackage("org.eclipse.emf.ecore/model/Ecore.genmodel", "//ecore");
		myQVT1.addUsedGenPackage("org.eclipse.ocl.pivot/model/Pivot.genmodel", "//pivot");
		ProjectManager projectManager = myQVT1.getProjectManager();
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			assert classLoader != null;
			((PivotMetamodelManager)myQVT1.getMetamodelManager()).getImplementationManager().getClassLoaders().add(classLoader);
			txClass1 = myQVT1.buildTransformation("as", false);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		} */
		URI ecoreURI = getModelsURI("ecore2pivotRoot/Families.ecore");
		URI asURI2a = getTestURI("Families2.ecore.oclas");
		ProjectManager testProjectManager = getTestProjectManager();
		OCL ocl = OCL.newInstance(testProjectManager);
		try {
			Resource inputResource = ocl.getResourceSet().getResource(ecoreURI, true);
			assert inputResource != null;
			assertNoResourceErrors("Ecore load", inputResource);
			assertNoValidationErrors("Ecore load", inputResource);
			Ecore2AS ecore2as = Ecore2AS.getAdapter(inputResource, (EnvironmentFactoryInternal) ocl.getEnvironmentFactory());
			Model pivotModel = ecore2as.getASModel();
			ASResource asResource = (ASResource) pivotModel.eResource();
			asResource.setURI(asURI2a);
			asResource.setSaveable(true);
			assertNoResourceErrors("Ecore2AS failed", asResource);
			asResource.save(XMIUtil.createSaveOptions());
			assertValidationDiagnostics("Ecore2AS invalid", asResource, NO_MESSAGES);
		}
		finally {
			ocl.dispose();
			ocl = null;
		}
		//	MyQVT myQVT = createQVT("Forward2Reverse", getModelsURI("ecore2pivotRoot/Ecore2PivotRoot.qvtr"));
		//	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		//	CompilationResult compilationResult = myQVT.compileTransformation("as");
		//	URI txURI = compilationResult.getResult().eResource().getURI();
		//	compilationResult.dispose();
		QVTrTxGenerationThread compilationThread = new QVTrTxGenerationThread("Forward2Reverse", "as", getModelsURI("ecore2pivotRoot/Ecore2PivotRoot.qvtr"))
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				return generateTransformationURI();
			}
		};
		URI txURI = compilationThread.invoke();
		//
		URI asURI2 = getTestURI("Families.ecore.oclas");
		QVTrTxInterpretationThread interpretationThread = new QVTrTxInterpretationThread(txURI, null)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadTransformation();
				createInterpretedExecutor();
				addInputURI("ecore", ecoreURI);
				executeTransformation();
				addOutputURI("as", asURI2);
				saveModels(null);
				checkOutput(asURI2, asURI2a, DummyPivotExternalURINormalizer.INSTANCE);
				return null;
			}
		};
		interpretationThread.invoke();
	}

	@Test
	public void testQVTrCompiler_Ecore2PivotRoot_CG() throws Exception {
		QVTrelationTestFileSystemHelper testFileSystemHelper = getTestFileSystemHelper();
		testFileSystemHelper.addRequiredBundle("org.eclipse.qvtd.pivot.qvtbase");
		//		URI txURI1 = URI.createPlatformResourceURI("/org.eclipse.ocl.pivot/model/Ecore2Pivot.qvtr", true);
		URI txURI1 = getModelsURI("ecore2pivotRoot/Ecore2PivotRoot.qvtr");
		MyQVT myQVT1 = createQVT("Ecore2PivotRoot", txURI1);
		myQVT1.configureGeneratedPackage(EcorePackage.eNS_URI);
		myQVT1.configureGeneratedPackage(PivotPackage.eNS_URI);
		myQVT1.configureGeneratedPackage(OCLstdlibPackage.eNS_URI);
		myQVT1.addUsedGenPackage("org.eclipse.emf.ecore/model/Ecore.genmodel", "//ecore");
		myQVT1.addUsedGenPackage("org.eclipse.ocl.pivot/model/Pivot.genmodel", "//pivot");
		ProjectManager projectManager = myQVT1.getProjectManager();
		//	try {
		ClassLoader classLoader = getClass().getClassLoader();
		assert classLoader != null;
		((PivotMetamodelManager)myQVT1.getMetamodelManager()).getImplementationManager().getClassLoaders().add(classLoader);
		Class<? extends Transformer> txClass1 = myQVT1.buildTransformation("as", false);
		//			Class<? extends Transformer> txClass = Ecore2Pivot.class;
		//
		//			myQVT1.assertRegionCount(BasicMappingRegionImpl.class, 0);
		//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0)
		//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
		//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 8);
		//	}
		//	finally {
		myQVT1.dispose();
		myQVT1 = null;
		//	}
		ThreadLocalExecutor.waitForGC();
		URI asURI2a = getTestURI("Families2.ecore.oclas");
		URI ecoreURI = getModelsURI("ecore2pivotRoot/Families.ecore");
		OCL ocl = OCL.newInstance(projectManager);
		try {
			Resource inputResource = ocl.getResourceSet().getResource(ecoreURI, true);
			assert inputResource != null;
			assertNoResourceErrors("Ecore load", inputResource);
			assertNoValidationErrors("Ecore load", inputResource);
			Ecore2AS ecore2as = Ecore2AS.getAdapter(inputResource, (EnvironmentFactoryInternal) ocl.getEnvironmentFactory());
			Model pivotModel = ecore2as.getASModel();
			ASResource asResource = (ASResource) pivotModel.eResource();
			asResource.setURI(asURI2a);
			asResource.setSaveable(true);
			assertNoResourceErrors("Ecore2AS failed", asResource);
			asResource.save(XMIUtil.createSaveOptions());
			assertValidationDiagnostics("Ecore2AS invalid", asResource, NO_MESSAGES);
		}
		finally {
			ocl.dispose();
			ocl = null;
		}
		ThreadLocalExecutor.waitForGC();
		//
		URI asURI2 = getTestURI("Families.ecore.oclas");
		QVTrCodeExecutionThread executionThread = new QVTrCodeExecutionThread(txClass1)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				createGeneratedExecutor();
				//			loadInput("ecore", getModelsURI("families2persons/Families.ecore"));
				addInputURI("ecore", ecoreURI);
				executeTransformation();
				addOutputURI("as", asURI2);
				saveModels(null);
				checkOutput(asURI2, asURI2a, DummyPivotExternalURINormalizer.INSTANCE);
				return null;
			}
		};
		executionThread.invoke();
		cleanup("http://www.eclipse.org/qvtd-example/org/eclipse/ocl/pivot2/ecore2pivotRoot/Ecore2PivotRoot");
	}

	@Test
	public void testQVTrCompiler_Families2Persons_CG() throws Exception {
		QVTrCodeGenerationThread generationThread = new QVTrCodeGenerationThread("Families2Persons", "Persons", false, getModelsURI("families2persons/Families2Persons_expected.qvtras"))
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				Class<? extends Transformer> transformation = buildTransformation();
				//			myQVT1.assertRegionCount(ActivatorRegionImpl.class, 2);
				//	myQVT1.assertRegionCount(RuleRegionImpl.class, 1);
				//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 7);
				return transformation;
			}
		};
		//	Class<? extends Transformer> txClass; // = Families2Persons.class;
		Class<? extends Transformer> txClass = generationThread.invoke();
		//
		QVTrCodeExecutionThread executionThread = new QVTrCodeExecutionThread(txClass)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEPackage("Families.FamiliesPackage");
				loadEPackage("Persons.PersonsPackage");
				loadEPackage("trace_Families2Persons.trace_Families2PersonsPackage");
				//
				createGeneratedExecutor();
				addInputURI("Families", getModelsURI("families2persons/samples/Families.xmi"));
				executeTransformation();
				addOutputURI("Persons", getTestURI("Persons_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("Persons_CG.xmi"), getModelsURI("families2persons/samples/Persons_expected.xmi"), Families2PersonsNormalizer.INSTANCE);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread.invoke();
	}

	/*	@Test
    public void testQVTrCompiler_ClassModelToClassModel() throws Exception {
//		AbstractTransformer.EXCEPTIONS.setState(true);
//		AbstractTransformer.INVOCATIONS.setState(true);
    	MyQVT myQVT = new MyQVT("classmodel2classmodel");
//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	try {
	    	Transformation asTransformation = myQVT.compileTransformation("ClassModelToClassModel.qvtr", "uml1", PROJECT_NAME + ".classmodel2classmodel", "http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/classmodel2classmodel/ClassModelToClassModel");
	    	myQVT.createInterpretedExecutor(asTransformation);
	    	myQVT.loadInput("uml1", "ClassUM1.xmi");
	    	myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "classmodel2classmodelc_trace.xmi");
	    	myQVT.createModel("uml2", "ClassUM1_Interpreted.xmi");
	    	myQVT.executeTransformation();
			myQVT.saveOutput("uml2", "ClassUM1_Interpreted.xmi", "ClassUM1_expected.xmi", null);
		}
		finally {
	    	myQVT.dispose();
			myQVT = null;
		}
    }

	@Test
    public void testQVTrCompiler_ClassModelToClassModel_CG() throws Exception {
//		AbstractTransformer.EXCEPTIONS.setState(true);
//		AbstractTransformer.INVOCATIONS.setState(true);
//    	QVTm2QVTp.PARTITIONING.setState(true);
    	MyQVT myQVT = new MyQVT("classmodel2classmodel");
    	try {
	    	String projectTestName = PROJECT_NAME + ".classmodel2classmodel";
			Transformation asTransformation = myQVT.compileTransformation("ClassModelToClassModel.qvtr", "uml2", projectTestName, "http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/classmodel2classmodel/ClassModelToClassModel");
			JavaSourceFileObject.compileClasses("../" + PROJECT_NAME + "/test-gen/" + projectTestName.replace(".",  "/"), "../" + PROJECT_NAME + "/bin");
	    	myQVT.installClassName(projectTestName + ".ClassMM.ClassMMPackage");
	    	myQVT.installClassName(projectTestName + ".PClassModelToClassModel.PClassModelToClassModelPackage");
	    	Class<? extends Transformer> txClass = myQVT.createGeneratedClass(asTransformation);
	    	//
	        myQVT.createGeneratedExecutor(environmentFactory, txClass);
	    	myQVT.loadInput("uml1", "ClassUM1.xmi");
	    	myQVT.executeTransformation();
			myQVT.saveOutput("uml2", "ClassUM1_CG.xmi", "ClassUM1.xmi", null);
		}
		finally {
	    	myQVT.dispose();
			myQVT = null;
		}
    } */

	@Test
	public void testQVTrCompiler_Forward2Reverse() throws Exception {
		QVTrTxGenerationThread compilationThread = new QVTrTxGenerationThread("Forward2Reverse", "reverse", getModelsURI("forward2reverse/Forward2Reverse.qvtr"))
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				return generateTransformationURI();
			}
		};
		URI txURI = compilationThread.invoke();
		//
		QVTrTxInterpretationThread interpretationThread = new QVTrTxInterpretationThread(txURI, null)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadTransformation();
				//
				createInterpretedExecutor();
				addInputURI("forward", getModelsURI("forward2reverse/samples/EmptyList.xmi"));
				executeTransformation();
				addOutputURI("reverse", getTestURI("EmptyList_Interpreted.xmi"));
				saveModels(null);
				checkOutput(getTestURI("EmptyList_Interpreted.xmi"), getModelsURI("forward2reverse/samples/EmptyList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
				//
				createInterpretedExecutor();
				addInputURI("forward", getModelsURI("forward2reverse/samples/OneElementList.xmi"));
				executeTransformation();
				addOutputURI("reverse", getTestURI("OneElementList_Interpreted.xmi"));
				saveModels(null);
				checkOutput(getTestURI("OneElementList_Interpreted.xmi"), getModelsURI("forward2reverse/samples/OneElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
				//
				createInterpretedExecutor();
				addInputURI("forward", getModelsURI("forward2reverse/samples/TwoElementList.xmi"));
				executeTransformation();
				addOutputURI("reverse", getTestURI("TwoElementList_Interpreted.xmi"));
				saveModels(null);
				checkOutput(getTestURI("TwoElementList_Interpreted.xmi"), getModelsURI("forward2reverse/samples/TwoElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
				//
				createInterpretedExecutor();
				addInputURI("forward", getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
				executeTransformation();
				addOutputURI("reverse", getTestURI("ThreeElementList_Interpreted.xmi"));
				saveModels(null);
				checkOutput(getTestURI("ThreeElementList_Interpreted.xmi"), getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
				return null;
			}
		};
		interpretationThread.invoke();
	}

	@Test
	public void testQVTrCompiler_Forward2Reverse_CG() throws Exception {
		QVTrCodeGenerationThread generationThread = new QVTrCodeGenerationThread("Forward2Reverse", new DefaultConfigurations(), false, getModelsURI("forward2reverse/Forward2Reverse.qvtr"))
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				Class<? extends Transformer> transformation = buildTransformation();
				//			myQVT1.assertRegionCount(ActivatorRegionImpl.class, 2);
				//	myQVT1.assertRegionCount(RuleRegionImpl.class, 1);
				//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 7);
				return transformation;
			}
		};
		// Class<? extends Transformer> txClass = Forward2Reverse.class;
		Class<? extends Transformer> txClass = generationThread.invoke();
		//
		QVTrCodeExecutionThread executionThread = new QVTrCodeExecutionThread(txClass)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEPackage("doublylinkedlist.doublylinkedlistPackage");
				loadEPackage("trace_Forward2Reverse.trace_Forward2ReversePackage");
				//
				createGeneratedExecutor();
				addInputURI("forward", getModelsURI("forward2reverse/samples/EmptyList.xmi"));
				executeTransformation("reverse");
				addOutputURI("reverse", getTestURI("EmptyList_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("EmptyList_CG.xmi"), getModelsURI("forward2reverse/samples/EmptyList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
				//
				createGeneratedExecutor();
				addInputURI("forward", getModelsURI("forward2reverse/samples/OneElementList.xmi"));
				executeTransformation("reverse");
				addOutputURI("reverse", getTestURI("OneElementList_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("OneElementList_CG.xmi"), getModelsURI("forward2reverse/samples/OneElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
				//
				createGeneratedExecutor();
				addInputURI("forward", getModelsURI("forward2reverse/samples/TwoElementList.xmi"));
				executeTransformation("reverse");
				addOutputURI("reverse", getTestURI("TwoElementList_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("TwoElementList_CG.xmi"), getModelsURI("forward2reverse/samples/TwoElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
				//
				createGeneratedExecutor();
				addInputURI("forward", getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
				executeTransformation("reverse");
				addOutputURI("reverse", getTestURI("ThreeElementList_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("ThreeElementList_CG.xmi"), getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
				//
				createGeneratedExecutor();
				addInputURI("reverse", getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
				executeTransformation("forward");
				addOutputURI("forward", getTestURI("ThreeElementList_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("ThreeElementList_CG.xmi"), getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread.invoke();
	}

	@Test
	public void testQVTrCompiler_HierarchicalStateMachine2FlatStateMachine() throws Exception {
		QVTrTxGenerationThread compilationThread = new QVTrTxGenerationThread("HierarchicalStateMachine2FlatStateMachine", "flat", getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"))
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				return generateTransformationURI();
			}
		};
		URI txURI = compilationThread.invoke();
		//
		QVTrTxInterpretationThread interpretationThread = new QVTrTxInterpretationThread(txURI, null)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadTransformation();
				createInterpretedExecutor();
				addInputURI("hier", getModelsURI("hstm2fstm/samples/MiniModel.xmi"));
				executeTransformation();
				addOutputURI("flat", getTestURI("MiniModel_Interpreted.xmi"));
				saveModels(null);
				checkOutput(getTestURI("MiniModel_Interpreted.xmi"), getModelsURI("hstm2fstm/samples/MiniModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
				//
				createInterpretedExecutor();
				addInputURI("hier", getModelsURI("hstm2fstm/samples/SimpleModel.xmi"));
				executeTransformation();
				addOutputURI("flat", getTestURI("SimpleModel_Interpreted.xmi"));
				saveModels(null);
				checkOutput(getTestURI("SimpleModel_Interpreted.xmi"), getModelsURI("hstm2fstm/samples/SimpleModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
				//
				createInterpretedExecutor();
				addInputURI("hier", getModelsURI("hstm2fstm/samples/LargerModel.xmi"));
				executeTransformation();
				addOutputURI("flat", getTestURI("LargerModel_Interpreted.xmi"));
				saveModels(null);
				checkOutput(getTestURI("LargerModel_Interpreted.xmi"), getModelsURI("hstm2fstm/samples/LargerModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
				return null;
			}
		};
		interpretationThread.invoke();
	}

	@Test
	public void testQVTrCompiler_HierarchicalStateMachine2FlatStateMachine_CG() throws Exception {
		QVTrCodeGenerationThread generationThread = new QVTrCodeGenerationThread("HierarchicalStateMachine2FlatStateMachine", "flat", false, getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"))
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				Class<? extends Transformer> transformation = buildTransformation();
				assertRegionCount(RuleRegionImpl.class, 0);
				//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 6);
				return transformation;
			}
		};
		Class<? extends Transformer> txClass = generationThread.invoke();
		//
		QVTrCodeExecutionThread executionThread = new QVTrCodeExecutionThread(txClass)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEPackage("FlatStateMachine.FlatStateMachinePackage");
				loadEPackage("HierarchicalStateMachine.HierarchicalStateMachinePackage");
				loadEPackage("trace_HierarchicalStateMachine2FlatStateMachine.trace_HierarchicalStateMachine2FlatStateMachinePackage");
				//
				createGeneratedExecutor();
				addInputURI("hier", getModelsURI("hstm2fstm/samples/MiniModel.xmi"));
				executeTransformation();
				addOutputURI("flat", getTestURI("MiniModel_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("MiniModel_CG.xmi"), getModelsURI("hstm2fstm/samples/MiniModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
				//
				createGeneratedExecutor();
				addInputURI("hier", getModelsURI("hstm2fstm/samples/SimpleModel.xmi"));
				executeTransformation();
				addOutputURI("flat", getTestURI("SimpleModel_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("SimpleModel_CG.xmi"), getModelsURI("hstm2fstm/samples/SimpleModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
				//
				createGeneratedExecutor();
				addInputURI("hier", getModelsURI("hstm2fstm/samples/LargerModel.xmi"));
				executeTransformation();
				addOutputURI("flat", getTestURI("LargerModel_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("LargerModel_CG.xmi"), getModelsURI("hstm2fstm/samples/LargerModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread.invoke();
	}

	@Test
	public void testQVTrCompiler_HierarchicalStateMachine2FlatStateMachine_example_CG() throws Exception {
		URI txURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.hstm2fstm/model/HierarchicalStateMachine2FlatStateMachine.qvtr", true);
		QVTrCodeGenerationThread generationThread = new QVTrCodeGenerationThread("hstm2fstm", "flat", false, txURI)
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				Class<? extends Transformer> transformation = buildTransformation();
				assertRegionCount(RuleRegionImpl.class, 0);
				//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 6);
				return transformation;
			}
		};
		Class<? extends Transformer> txClass = generationThread.invoke();
		//
		URI inURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.hstm2fstm/model/in/hier.xmi", true);
		URI outURI = getTestURI("generated_CG.xmi");
		URI expectedURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.hstm2fstm/model/out/expected.xmi", true);
		QVTrCodeExecutionThread executionThread = new QVTrCodeExecutionThread(txClass)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEPackage("FlatStateMachine.FlatStateMachinePackage");
				loadEPackage("HierarchicalStateMachine.HierarchicalStateMachinePackage");
				loadEPackage("trace_HierarchicalStateMachine2FlatStateMachine.trace_HierarchicalStateMachine2FlatStateMachinePackage");
				//
				createGeneratedExecutor();
				addInputURI("hier", inURI);
				executeTransformation();
				addOutputURI("flat", outURI);
				saveModels(null);
				checkOutput(outURI, expectedURI, FlatStateMachineNormalizer.INSTANCE);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread.invoke();
	}

	@Test
	public void testQVTrCompiler_HierarchicalStateMachine2FlatStateMachine_iCG() throws Exception {
		QVTrCodeGenerationThread generationThread = new QVTrCodeGenerationThread("HierarchicalStateMachine2FlatStateMachine", "flat", true, getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"))
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				Class<? extends Transformer> transformation = buildTransformation();
				return transformation;
			}
		};
		Class<? extends Transformer> txClass = generationThread.invoke();
		//
		QVTrCodeExecutionThread executionThread = new QVTrCodeExecutionThread(txClass)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEPackage("FlatStateMachine.FlatStateMachinePackage");
				loadEPackage("HierarchicalStateMachine.HierarchicalStateMachinePackage");
				loadEPackage("trace_HierarchicalStateMachine2FlatStateMachine.trace_HierarchicalStateMachine2FlatStateMachinePackage");
				//
				createGeneratedExecutor();
				addInputURI("hier", getModelsURI("hstm2fstm/samples/MiniModel.xmi"));
				executeTransformation();
				writeGraphMLfile(getTestURI("MiniModel-incremental.graphml"));
				addOutputURI("flat", getTestURI("MiniModel_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("MiniModel_CG.xmi"), getModelsURI("hstm2fstm/samples/MiniModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
				//
				createGeneratedExecutor();
				addInputURI("hier", getModelsURI("hstm2fstm/samples/SimpleModel.xmi"));
				executeTransformation();
				addOutputURI("flat", getTestURI("SimpleModel_CG.xmi"));
				saveModels(null);
				writeGraphMLfile(getTestURI("SimpleModel-incremental.graphml"));
				checkOutput(getTestURI("SimpleModel_CG.xmi"), getModelsURI("hstm2fstm/samples/SimpleModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
				//
				createGeneratedExecutor();
				addInputURI("hier", getModelsURI("hstm2fstm/samples/LargerModel.xmi"));
				executeTransformation();
				writeGraphMLfile(getTestURI("LargerModel-incremental.graphml"));
				addOutputURI("flat", getTestURI("LargerModel_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("LargerModel_CG.xmi"), getModelsURI("hstm2fstm/samples/LargerModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread.invoke();
	}

	@Test
	public void testQVTrCompiler_Iterated2Iterated_CG() throws Exception {
		TypedModelsConfigurations typedModelsConfigurations = new TypedModelsConfigurations();
		typedModelsConfigurations.add(new TypedModelsConfiguration("to", "via"));
		QVTrCodeGenerationThread generationThread = new QVTrCodeGenerationThread("Iterated2Iterated", typedModelsConfigurations, false, getModelsURI("iterated2iterated/Iterated2Iterated.qvtr"))
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				ProjectManager projectMap = getProjectManager();
				projectMap.configure(getEnvironmentFactory().getResourceSet(), StandaloneProjectMap.LoadFirstStrategy.INSTANCE, StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
				addUsedGenPackage("org.eclipse.emf.ecore/model/Ecore.genmodel", "//ecore");
				Class<? extends Transformer> transformation = buildTransformation();
				return transformation;
			}
		};
		// Class<? extends Transformer> txClass = Forward2Reverse.class;
		Class<? extends Transformer> txClass = generationThread.invoke();
		//
		QVTrCodeExecutionThread executionThread = new QVTrCodeExecutionThread(txClass)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEPackage("iterated.iteratedPackage");
				loadEPackage("trace_Iterated2Iterated.trace_Iterated2IteratedPackage");
				//
				createGeneratedExecutor();
				addInputURI("from", getModelsURI("iterated2iterated/samples/testcase1-in.xmi"));
				executeTransformation();
				addOutputURI("to", getTestURI("testcase1-out_CG.iterated"));
				saveModels(null);
				checkOutput(getTestURI("testcase1-out_CG.iterated"), getModelsURI("iterated2iterated/samples/testcase1-out.xmi"), null);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread.invoke();
	}

	@Test
	public void testQVTrCompiler_MiToSiSimple_CG() throws Exception {
		ToStringVisitor.SHOW_ALL_MULTIPLICITIES = true;
		QVTrCodeGenerationThread generationThread = new QVTrCodeGenerationThread("MiToSiSimple", "java", false, getModelsURI("mitosi/MiToSiSimple.qvtr"))
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				Class<? extends Transformer> transformation = buildTransformation();
				//			myQVT1.assertRegionCount(BasicMappingRegionImpl.class, 0);
				//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 8);
				return transformation;
			}
		};
		Class<? extends Transformer> txClass = generationThread.invoke();
		//
		QVTrCodeExecutionThread executionThread = new QVTrCodeExecutionThread(txClass)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				configureExtension("xml", new XMIResourceFactoryImpl());		// FIXME workaround BUG 527164
				loadEPackage("javammsi.javammsiPackage");
				loadEPackage("umlmmmi.umlmmmiPackage");
				loadEPackage("trace_MiToSiSimple.trace_MiToSiSimplePackage");
				//
				createGeneratedExecutor();
				addInputURI("uml", getModelsURI("mitosi/samples/transportuml.xml"));
				executeTransformation();
				addOutputURI("java", getTestURI("transportjava_CG.xml"));
				saveModels(null);
				checkOutput(getTestURI("transportjava_CG.xml"), getModelsURI("mitosi/samples/transportjava.xml"), null);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread.invoke();
	}

	@Test
	public void testQVTrCompiler_MiToSiSimpleWithKeys_CG() throws Exception {
		ToStringVisitor.SHOW_ALL_MULTIPLICITIES = true;
		QVTrCodeGenerationThread generationThread = new QVTrCodeGenerationThread("MiToSiSimpleWithKeys", "java", false, getModelsURI("mitosi/MiToSiSimpleWithKeys.qvtr"))
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				Class<? extends Transformer> transformation = buildTransformation();
				//			myQVT1.assertRegionCount(BasicMappingRegionImpl.class, 0);
				//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 8);
				return transformation;
			}
		};
		//			Class<? extends Transformer> txClass = MiToSiSimpleWithKeys.class;
		Class<? extends Transformer> txClass = generationThread.invoke();
		//
		QVTrCodeExecutionThread executionThread = new QVTrCodeExecutionThread(txClass)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				configureExtension("xml", new XMIResourceFactoryImpl());		// FIXME workaround BUG 527164
				loadEPackage("javammsi.javammsiPackage");
				loadEPackage("umlmmmi.umlmmmiPackage");
				loadEPackage("trace_MiToSiSimpleWithKeys.trace_MiToSiSimpleWithKeysPackage");
				//
				createGeneratedExecutor();
				addInputURI("uml", getModelsURI("mitosi/samples/transportuml.xml"));
				executeTransformation();
				addOutputURI("java", getTestURI("transportjava_CG.xml"));
				saveModels(null);
				checkOutput(getTestURI("transportjava_CG.xml"), getModelsURI("mitosi/samples/transportjava.xml"), null);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread.invoke();
	}

	/*	@Test
	public void testQVTrCompiler_PartialPhilosophers_CG() throws Exception {	// For Bug 515490 discussion - doesn't work
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		Class<? extends Transformer> txClass;
		MyQVT myQVT1 = createQVT("PartialPhilosophers", getModelsURI("partialPhilosophers/PartialPhilosophers.qvtr"));
		try {
			txClass = myQVT1.buildTransformation("to", false);//,
			//					"SeqMM.SeqMMPackage", "PSeqToStm.PSeqToStmPackage");
			//
			myQVT1.assertRegionCount(RuleRegionImpl.class, 0);
			//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 10);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		ThreadLocalExecutor.waitForGC();
		MyQVT myQVT2 = createQVT("SeqToStm", getModelsURI("partialPhilosophers/PartialPhilosophers.qvtr"));
		try {
			//	myQVT2.loadEPackage(txClass, "SeqMM.SeqMMPackage");
			//	myQVT2.loadEPackage(txClass, "StmcMM.StmcMMPackage");
			//	myQVT2.loadEPackage(txClass, "trace_SeqToStm.trace_SeqToStmPackage");
			//
			myQVT2.createGeneratedExecutor(environmentFactory, txClass);
			myQVT2.loadInput("from", getModelsURI("partialPhilosophers/samples/Table3.xmi"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("to", getTestURI("Table3_CG.xmi"), getModelsURI("partialPhilosophers/samples/Table3_expected.xmi"), null);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	} */

	/*	@Test
	public void testQVTrCompiler_Persons2Families_CG() throws Exception {
		ToStringVisitor.SHOW_ALL_MULTIPLICITIES = true;
		Class<? extends Transformer> txClass;
		MyQVT myQVT1 = createQVT("Persons2Families", getModelsURI("persons2families/Persons2Families.qvtr"));
		try {
			txClass = myQVT1.buildTransformation("family", false);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		ThreadLocalExecutor.waitForGC();
		MyQVT myQVT2 = createQVT("Persons2Families", getModelsURI("persons2families/Persons2Families.qvtr"));
		try {
			Map<String, Object> extensionToFactoryMap = myQVT2.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap();
			extensionToFactoryMap.put("xml", new XMIResourceFactoryImpl());		// FIXME workaround BUG 527164
			//
			TransformationExecutor txExecutor1 = myQVT2.createGeneratedExecutor(environmentFactory, txClass);
			txExecutor1.setContextualProperty("PREFER_CREATING_PARENT_TO_CHILD", Boolean.FALSE);
			txExecutor1.addInputURI("persons", getModelsURI("persons2families/samples/PersonsMulti.xmi"));
			txExecutor1.execute(null);
			txExecutor1.addOutputURI("family", getTestURI("MultiFamiliesChildren-CG.xmi"));
			txExecutor1.saveModels(null);
			myQVT2.checkOutput(getTestURI("MultiFamiliesChildren-CG.xmi"), getModelsURI("persons2families/samples/MultiFamiliesChildren.xmi"), Persons2FamiliesNormalizer.INSTANCE);
			myQVT2.loadEPackage(txClass, "Families.FamiliesPackage");
			myQVT2.loadEPackage(txClass, "Persons.PersonsPackage");
			myQVT2.loadEPackage(txClass, "trace_Persons2Families.trace_Persons2FamiliesPackage");
			//

			//	myQVT2.removeResources();  -- re-using an executor is very dubious until  we reliably support update executions for which
			//  we surely update rather than clean and re-use?

			TransformationExecutor txExecutor2 = myQVT2.createGeneratedExecutor(environmentFactory, txClass);
			txExecutor2.setContextualProperty("PREFER_CREATING_PARENT_TO_CHILD", Boolean.TRUE);
			txExecutor2.addInputURI("persons", getModelsURI("persons2families/samples/PersonsMulti.xmi"));
			txExecutor2.execute(null);
			txExecutor2.addOutputURI("family", getTestURI("MultiFamiliesParents-CG.xmi"));
			txExecutor2.saveModels(null);
			myQVT2.checkOutput(getTestURI("MultiFamiliesParents-CG.xmi"), getModelsURI("persons2families/samples/MultiFamiliesParents.xmi"), Persons2FamiliesNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	} */

	/*	@Test
	public void testQVTrCompiler_Persons2Families() throws Exception {
		ToStringVisitor.SHOW_ALL_MULTIPLICITIES = true;
		ImperativeTransformation asTransformation;
		MyQVT myQVT = createQVT("Persons2Families", getModelsURI("persons2families/Persons2Families.qvtr"));
		try {
			asTransformation = myQVT.compileTransformation("family");
			Map<String, Object> extensionToFactoryMap = myQVT.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap();
			extensionToFactoryMap.put("xml", new XMIResourceFactoryImpl());		// FIXME workaround BUG 527164
			//
			TransformationExecutor txExecutor1 = myQVT.createInterpretedExecutor(QVTimperativeUtil.getDefaultEntryPoint(asTransformation));
			txExecutor1.setContextualProperty("PREFER_CREATING_PARENT_TO_CHILD", Boolean.FALSE);
			txExecutor1.addInputURI("persons", getModelsURI("persons2families/samples/PersonsMulti.xmi"));
			txExecutor1.execute(null);
			txExecutor1.addOutputURI("family", getTestURI("MultiFamiliesChildren-Int.xmi"));
			txExecutor1.saveModels(null);
			myQVT.checkOutput(getTestURI("MultiFamiliesChildren-Int.xmi"), getModelsURI("persons2families/samples/MultiFamiliesChildren.xmi"), Persons2FamiliesNormalizer.INSTANCE);

			//	myQVT2.removeResources();  -- re-using an executor is very dubious until  we reliably support update executions for which
			//  we surely update rather than clean and re-use?

			TransformationExecutor txExecutor2 = myQVT.createInterpretedExecutor(QVTimperativeUtil.getDefaultEntryPoint(asTransformation));
			txExecutor2.setContextualProperty("PREFER_CREATING_PARENT_TO_CHILD", Boolean.TRUE);
			txExecutor2.addInputURI("persons", getModelsURI("persons2families/samples/PersonsMulti.xmi"));
			txExecutor2.execute(null);
			txExecutor2.addOutputURI("family", getTestURI("MultiFamiliesParents-Int.xmi"));
			txExecutor2.saveModels(null);
			myQVT.checkOutput(getTestURI("MultiFamiliesParents-Int.xmi"), getModelsURI("persons2families/samples/MultiFamiliesParents.xmi"), Persons2FamiliesNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
			myQVT = null;
		}
	} */

	@Test
	public void testQVTrCompiler_Persons2Names2Families_CG() throws Exception {
		ToStringVisitor.SHOW_ALL_MULTIPLICITIES = true;
		ResourceSet resourceSet = new ResourceSetImpl();
		getTestProjectManager().initializeResourceSet(resourceSet);
		URIConverter uriConverter = resourceSet.getURIConverter();
		TestProject testProject = getTestProject();
		TestFolder testFolder = testProject.getOutputFolder("samples");
		TestFile personFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("persons2families/samples/PersonsMulti.xmi"));
		TestFile familyFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("persons2families/samples/MultiFamiliesChildren.xmi"));
		//		TestFile familyFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("persons2families/samples/FamiliesWithChildrenOnly.xmi"));
		TestFile refNamesFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("persons2families/samples/MultiFamiliesChildrenPlan.xmi"));
		TestFile refFamilyFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("persons2families/samples/MultiFamiliesAndPersons.xmi"));
		//		TestFile refFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("persons2families/samples/FamiliesWithChildrenOnlyPlan.xmi"));
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("persons2families/Persons2Names2Families.qvtr"));
		testProject.copyFile(uriConverter, null, getModelsURI("persons2families/Families.ecore"));
		testProject.copyFile(uriConverter, null, getModelsURI("persons2families/Names.ecore"));
		testProject.copyFile(uriConverter, null, getModelsURI("persons2families/Persons.ecore"));
		URI namesOutURI = getTestURI("samples/MultiFamiliesChildrenPlan-CG.xmi");
		URI familiesOutURI = getTestURI("samples/MultiFamiliesChildren-CG.xmi");
		//
		MyQVT myQVT1 = createQVT("Persons2Names2Families", txFile.getURI());
		Class<? extends Transformer> txClass;
		try {
			txClass = myQVT1.buildTransformation(TargetConfiguration.createTargetConfigurations("families", "persons"), false);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		//
		QVTrCodeExecutionThread executionThread = new QVTrCodeExecutionThread(txClass)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				configureExtension("xml", new XMIResourceFactoryImpl());		// FIXME workaround BUG 527164
				loadEPackage("Families.FamiliesPackage");
				loadEPackage("Persons.PersonsPackage");
				loadEPackage("Names.NamesPackage");
				loadEPackage("trace_Persons2Names2Families.trace_Persons2Names2FamiliesPackage");
				//
				createGeneratedExecutor();
				setContextualProperty("PREFER_EXISTING_FAMILY_TO_NEW", Boolean.FALSE);
				setContextualProperty("PREFER_CREATING_PARENT_TO_CHILD", Boolean.FALSE);
				addInputURI("persons", personFile.getURI());
				addInputURI("familiesLeft", familyFile.getURI());
				executeTransformation("families");
				addOutputURI("names", namesOutURI);
				addOutputURI("familiesRight", familiesOutURI);
				saveModels(null);
				checkOutput(namesOutURI, refNamesFile.getURI(), NamesNormalizer.INSTANCE);
				checkOutput(familiesOutURI, refFamilyFile.getURI(), null); //FamilyPlansNormalizer.INSTANCE);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread.invoke();
	}

	@Test
	public void testQVTrCompiler_Persons2Names2Families() throws Exception {
		ToStringVisitor.SHOW_ALL_MULTIPLICITIES = true;
		ResourceSet resourceSet = new ResourceSetImpl();
		getTestProjectManager().initializeResourceSet(resourceSet);
		URIConverter uriConverter = resourceSet.getURIConverter();
		TestProject testProject = getTestProject();
		TestFolder testFolder = testProject.getOutputFolder("samples");
		TestFile personFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("persons2families/samples/PersonsMulti.xmi"));
		TestFile familyFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("persons2families/samples/MultiFamiliesChildren.xmi"));
		TestFile refNamesFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("persons2families/samples/MultiFamiliesChildrenPlan.xmi"));
		TestFile refFamilyFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("persons2families/samples/MultiFamiliesAndPersons.xmi"));
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("persons2families/Persons2Names2Families.qvtr"));
		testProject.copyFile(uriConverter, null, getModelsURI("persons2families/Families.ecore"));
		testProject.copyFile(uriConverter, null, getModelsURI("persons2families/Names.ecore"));
		testProject.copyFile(uriConverter, null, getModelsURI("persons2families/Persons.ecore"));
		URI namesOutURI = getTestURI("samples/MultiFamiliesChildrenPlan-Int.xmi");
		URI familiesOutURI = getTestURI("samples/MultiFamiliesChildren-Int.xmi");
		//
		QVTrTxGenerationThread compilationThread = new QVTrTxGenerationThread("Persons2Names2Families", TargetConfiguration.createTargetConfigurations("families", "persons"), txFile.getURI())
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				return generateTransformationURI();
			}
		};
		URI txURI = compilationThread.invoke();
		//
		QVTrTxInterpretationThread interpretationThread = new QVTrTxInterpretationThread(txURI, "families")
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				configureExtension("xml", new XMIResourceFactoryImpl());		// FIXME workaround BUG 527164
				loadTransformation();
				createInterpretedExecutor();
				setContextualProperty("PREFER_EXISTING_FAMILY_TO_NEW", Boolean.FALSE);
				setContextualProperty("PREFER_EXISTING_FAMILY_TO_NEW", Boolean.FALSE);
				setContextualProperty("PREFER_CREATING_PARENT_TO_CHILD", Boolean.FALSE);
				addInputURI("persons", personFile.getURI());
				addInputURI("familiesLeft", familyFile.getURI());
				executeTransformation();
				addOutputURI("names", namesOutURI);
				addOutputURI("familiesRight", familiesOutURI);
				saveModels(null);
				checkOutput(namesOutURI, refNamesFile.getURI(), NamesNormalizer.INSTANCE);
				checkOutput(familiesOutURI, refFamilyFile.getURI(), null); //FamilyPlansNormalizer.INSTANCE);
				return null;
			}
		};
		interpretationThread.invoke();
	}

	@Test
	public void testQVTrCompiler_SeqToStm() throws Exception {
		QVTrTxGenerationThread compilationThread = new QVTrTxGenerationThread("SeqToStm", "stm", getModelsURI("seq2stm/SeqToStm.qvtr"))
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				return generateTransformationURI();
			}
		};
		URI txURI = compilationThread.invoke();
		//
		QVTrTxInterpretationThread interpretationThread = new QVTrTxInterpretationThread(txURI, null)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadTransformation();
				createInterpretedExecutor();
				addInputURI("seqDgm", getModelsURI("seq2stm/samples/Seq.xmi"));
				executeTransformation();
				addOutputURI("stm", getTestURI("Stmc_Interpreted.xmi"));
				addOutputURI(QVTbaseUtil.TRACE_TYPED_MODEL_NAME, getTestURI("Seq2Stmc_trace.xmi"));
				saveModels(null);
				checkOutput(getTestURI("Stmc_Interpreted.xmi"), getModelsURI("seq2stm/samples/Stmc_expected.xmi"), null);
				return null;
			}
		};
		interpretationThread.invoke();
	}

	@Test
	public void testQVTrCompiler_SeqToStm_CG() throws Exception {
		QVTrCodeGenerationThread generationThread = new QVTrCodeGenerationThread("SeqToStm", "stm", false, getModelsURI("seq2stm/SeqToStm.qvtr"))
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				Class<? extends Transformer> transformation = buildTransformation();
				assertRegionCount(RuleRegionImpl.class, 0);
				//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 10);
				return transformation;
			}
		};
		Class<? extends Transformer> txClass = generationThread.invoke();
		//
		QVTrCodeExecutionThread executionThread = new QVTrCodeExecutionThread(txClass)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEPackage("SeqMM.SeqMMPackage");
				loadEPackage("StmcMM.StmcMMPackage");
				loadEPackage("trace_SeqToStm.trace_SeqToStmPackage");
				//
				createGeneratedExecutor();
				addInputURI("seqDgm", getModelsURI("seq2stm/samples/Seq.xmi"));
				executeTransformation();
				addOutputURI("stm", getTestURI("Stmc_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("Stmc_CG.xmi"), getModelsURI("seq2stm/samples/Stmc_expected.xmi"), null);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread.invoke();
	}

	@Test
	public void testQVTrCompiler_SeqToStm_iCG() throws Exception {
		QVTrCodeGenerationThread generationThread = new QVTrCodeGenerationThread("SeqToStm", "stm", true, getModelsURI("seq2stm/SeqToStm.qvtr"))
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				Class<? extends Transformer> transformation = buildTransformation();
				return transformation;
			}
		};
		Class<? extends Transformer> txClass = generationThread.invoke();
		//
		QVTrCodeExecutionThread executionThread = new QVTrCodeExecutionThread(txClass)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEPackage("SeqMM.SeqMMPackage");
				loadEPackage("StmcMM.StmcMMPackage");
				loadEPackage("trace_SeqToStm.trace_SeqToStmPackage");
				//
				createGeneratedExecutor();
				addInputURI("seqDgm", getModelsURI("seq2stm/samples/Seq.xmi"));
				executeTransformation();
				writeGraphMLfile(getTestURI("SeqToStm-incremental.graphml"));
				addOutputURI("stm", getTestURI("Stmc_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("Stmc_CG.xmi"), getModelsURI("seq2stm/samples/Stmc_expected.xmi"), null);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread.invoke();
	}

	@Test
	public void testQVTrCompiler_TinyIsomorph_CG() throws Exception {
		QVTrCodeGenerationThread generationThread = new QVTrCodeGenerationThread("TinyIsomorph", new DefaultConfigurations(), false, getModelsURI("tinyisomorph/TinyIsomorph.qvtr"))
		{
			@Override
			protected @NonNull Class<? extends Transformer> runWithThrowable() throws Exception {
				//	loadGenModel("List2List.genmodel");
				Class<? extends Transformer> transformation = buildTransformation();
				//			myQVT1.assertRegionCount(ActivatorRegionImpl.class, 2);
				//	myQVT1.assertRegionCount(RuleRegionImpl.class, 1);
				//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
				//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 7);
				return transformation;
			}
		};
		Class<? extends Transformer> txClass = generationThread.invoke();
		//
		QVTrCodeExecutionThread executionThread = new QVTrCodeExecutionThread(txClass)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadEPackage("mma.mmaPackage");
				loadEPackage("trace_TinyIsomorph.trace_TinyIsomorphPackage");
				loadEPackage("mmb.mmbPackage");
				//
				createGeneratedExecutor();
				addInputURI("mma", getModelsURI("tinyisomorph/samples/Zero.xmi"));
				executeTransformation("mmb");
				addOutputURI("mmb", getTestURI("Zero_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("Zero_CG.xmi"), getModelsURI("tinyisomorph/samples/Zero_expected.xmi"), null);
				//
				createGeneratedExecutor();
				addInputURI("mma", getModelsURI("tinyisomorph/samples/One.xmi"));
				executeTransformation("mmb");
				addOutputURI("mmb", getTestURI("One_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("One_CG.xmi"), getModelsURI("tinyisomorph/samples/One_expected.xmi"), null);
				//
				createGeneratedExecutor();
				addInputURI("mma", getModelsURI("tinyisomorph/samples/Two.xmi"));
				executeTransformation("mmb");
				addOutputURI("mmb", getTestURI("Two_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("Two_CG.xmi"), getModelsURI("tinyisomorph/samples/Two_expected.xmi"), null);
				//
				createGeneratedExecutor();
				addInputURI("mma", getModelsURI("tinyisomorph/samples/Three.xmi"));
				executeTransformation("mmb");
				addOutputURI("mmb", getTestURI("Three_CG.xmi"));
				saveModels(null);
				checkOutput(getTestURI("Three_CG.xmi"), getModelsURI("tinyisomorph/samples/Three_expected.xmi"), null);
				//
				unloadEPackages();
				return null;
			}
		};
		executionThread.invoke();
	}

	/*	@Test
	public void testQVTrCompiler_SeqToStm_iCG2() throws Exception {
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		MyQVT myQVT = new MyQVT("seq2stm");
		try {
			Class<? extends Transformer> txClass = SeqToStm.class;
			myQVT.createGeneratedExecutor(environmentFactory, txClass);
			myQVT.loadInput("seqDgm", "Seq.xmi");
			Transformer tx = myQVT.executeTransformation();
			Execution2GraphVisitor.writeGraphMLfile(tx, getTestModelsFileURI("seq2stm/temp/SeqToStm-incremental.graphml"));
			myQVT.saveOutput("stm", "Stmc_CG.xmi", "Stmc_expected.xmi", null);
			//
			//	        myQVT.createGeneratedExecutor(environmentFactory, txClass);
			//	    	myQVT.loadInput("seqDgm", "SeqUM.xmi");
			//	    	myQVT.executeTransformation();
			//			myQVT.saveOutput("stm", "StmcUM_CG.xmi", "StmcUM_expected.xmi", null);
		}
		finally {
			myQVT.dispose();
			myQVT = null;
		}
	} */

	/*	@Test
	public void testQVTrCompiler_SimplerRel2Core_CG() throws Exception {
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.SYNTHESIS.setState(true);
		//		QVTr2QVTc.VARIABLES.setState(true);
		MyQVT myQVT = new MyQVT("rel2core");
		try {
			myQVT.addUsedGenPackage("org.eclipse.ocl.pivot/model/Pivot.genmodel", "//pivot");
			myQVT.addUsedGenPackage("org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.genmodel", "//qvtbase");
			myQVT.addUsedGenPackage("org.eclipse.qvtd.pivot.qvtcore/model/QVTcore.genmodel", "//qvtcore");
			myQVT.addUsedGenPackage("org.eclipse.qvtd.pivot.qvtcorebase/model/QVTcoreBase.genmodel", "//qvtcorebase");
			myQVT.addUsedGenPackage("org.eclipse.qvtd.pivot.qvtrelation/model/QVTrelation.genmodel", "//qvtrelation");
			myQVT.addUsedGenPackage("org.eclipse.qvtd.pivot.qvttemplate/model/QVTtemplate.genmodel", "//qvttemplate");
			Class<? extends Transformer> txClass = myQVT.buildTransformation("RelToCore.qvtr", "core",
					"http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/rel2core/RelToCore");
			//
			myQVT.createGeneratedExecutor(environmentFactory, txClass);
			myQVT.loadInput("relations", "MiniSeq2Stm.qvtras");
			myQVT.executeTransformation();
			//	    	myQVT.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",  new EcoreResourceFactoryImpl());
			//	    	myQVT.getEnvironmentFactory().getMetamodelManager().getASResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",  new EcoreResourceFactoryImpl());
			Resource outputResource = myQVT.saveOutput("core", "MiniSeq2Stm_CG.oclas", null, null);
			myQVT.saveOutput(QVTscheduleConstants.MIDDLE_DOMAIN_NAME, "MiniSeq2Stm_CG_Trace.xmi", null, null);
			myQVT.checkOutput(outputResource, "MiniSeq2Stm_expected.oclas", PivotNormalizer.INSTANCE);
			//
			//	        myQVT.createGeneratedExecutor(environmentFactory, txClass);
			//	    	myQVT.loadInput("seqDgm", "SeqUM.xmi");
			//	    	myQVT.executeTransformation();
			//			myQVT.saveOutput("stm", "StmcUM_CG.xmi", "StmcUM_expected.xmi", null);
		}
		finally {
			myQVT.dispose();
			myQVT = null;
		}
	} */
}
