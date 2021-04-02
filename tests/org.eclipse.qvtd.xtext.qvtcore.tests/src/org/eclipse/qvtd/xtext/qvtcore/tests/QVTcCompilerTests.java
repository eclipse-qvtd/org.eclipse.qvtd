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
package org.eclipse.qvtd.xtext.qvtcore.tests;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystemHelper;
import org.eclipse.ocl.examples.xtext.tests.TestFolder;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentThread.AbstractEnvironmentThreadFactory;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.CompilationResult;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.QVTcCompilerChain;
import org.eclipse.qvtd.compiler.internal.common.SimpleConfigurations;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfigurations;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.splitter.Splitter;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcore;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThread;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT.PartitionUsage;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.FamiliesPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families2Persons.Families2PersonsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Persons.PersonsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.HSLTreePackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HLS.HSV2HSLPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVTreePackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublylinkedlistPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2listPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simplerdbms.SimplerdbmsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.SimpleumlPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.SimplegraphPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests that QVTc files can be compiled and executed.
 */
public class QVTcCompilerTests extends LoadTestCase
{
	private static boolean NO_MERGES = true;				// Set true to suppress the complexities of merging

	protected abstract static class QVTcTestThread<R> extends QVTimperativeEnvironmentThread<R>
	{
		protected final @NonNull String modelTestName;
		protected final @NonNull PartitionUsage partitionUsage = new PartitionUsage();

		protected QVTcTestThread(@NonNull QVTimperativeEnvironmentThreadFactory environmentThreadFactory, @NonNull String threadName, @NonNull String modelTestName) {
			super(environmentThreadFactory, threadName);
			this.modelTestName = modelTestName;
		}

		/*		protected void assertRegionCount(@NonNull Class<? extends Region> partitionClass, int count) {
			QVTruntimeUtil.errPrintln("assertRegionCount suppressed");
		}

		protected @NonNull DefaultCompilerOptions createCompilerOptions() {
			DefaultCompilerOptions compilerOptions = new DefaultCompilerOptions();
			compilerOptions.setOption(CompilerChain.DEFAULT_STEP, CompilerChain.DEBUG_KEY, true);
			compilerOptions.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.SAVE_OPTIONS_KEY, DefaultCompilerOptions.defaultSavingOptions);
			compilerOptions.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.DEBUG_KEY, true);
			// TODO problem when validating options.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.VALIDATE_KEY, true);
			compilerOptions.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_EARLY_MERGE, NO_MERGES);
			compilerOptions.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_LATE_CONSUMER_MERGE, NO_MERGES);
			return compilerOptions;
		}

		protected @NonNull ImperativeTransformation generateTransformation(@NonNull String mainOclDoc, @NonNull String... extendedOclDocs) throws Exception {
			DefaultCompilerOptions compilerOptions = createCompilerOptions();
			TestFileSystemOwner testFileSystemOwner = getTestFileSystemOwner();
			ProjectManager projectManager = testFileSystemOwner.getTestProjectManager();
			ResourceSet resourceSet = getEnvironmentFactory().getResourceSet();
			URI mainOclDocURI = testFileSystemOwner.getModelsURI(modelTestName + "/" + mainOclDoc);
			@NonNull URI[] oclDocURIs = new @NonNull URI[extendedOclDocs.length];
			for (int i=0; i < extendedOclDocs.length; i++) {
				oclDocURIs[i] = testFileSystemOwner.getModelsURI(modelTestName + "/" + extendedOclDocs[i]);
			}
			OCL2QVTiCompilerChain compiler = new OCL2QVTiCompilerChain(projectManager, resourceSet, compilerOptions, mainOclDocURI, testFileSystemOwner.getTestURIWithExtension(mainOclDocURI, null), oclDocURIs)
			{
				@Override
				protected @NonNull QVTm2QVTsCompilerStep createQVTm2QVTsCompilerStep() {
					return new QVTm2QVTsCompilerStep(this)
					{
						@Override
						public @NonNull ScheduleManager execute(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull Resource pResource, @NonNull TypedModelsConfiguration typedModelsConfiguration) throws IOException {
							ScheduleManager scheduleManager = super.execute(environmentFactory, pResource, typedModelsConfiguration);
							partitionUsage.instrumentPartition(scheduleManager);
							return scheduleManager;
						}
					};
				}
			};
			ImperativeTransformation iTransformation = compiler.compile(OCL2QVTm.RIGHT_MODEL_TYPE_NAME);
			URI txURI = iTransformation.eResource().getURI();
			if (txURI != null) {
				URI inputURI = txURI;
				URI serializedURI = testFileSystemOwner.getTestURIWithExtension(inputURI, "serialized.qvti");
				AbstractTestQVT.doSerialize(projectManager, inputURI, serializedURI);
			}
			return iTransformation;
		}

		protected @NonNull URI generateTransformationURI(@NonNull String mainOclDoc, @NonNull String... extendedOclDocs) throws Exception {
			ImperativeTransformation iTransformation = generateTransformation(mainOclDoc, extendedOclDocs);
			URI uri = iTransformation.eResource().getURI();
			assert uri != null;
			return uri;
		}

		protected void loadEcoreFile(URI fileURI, EPackage ePackage) {
			ResourceSet rSet = getEnvironmentFactory().getResourceSet();
			rSet.getPackageRegistry().put(fileURI.toString(), ePackage);
			EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);		// FIXME Accumulate for cleanup
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
		} */
	}

	public abstract static class QVTcGenerationThread<R> extends QVTcTestThread<R>
	{
		protected QVTcGenerationThread(@NonNull QVTcoreEnvironmentThreadFactory environmentThreadFactory, @NonNull String threadName, @NonNull String modelTestName) {
			super(environmentThreadFactory, threadName, modelTestName);
		}
	}

	public abstract class QVTcTxGenerationThread extends QVTcGenerationThread<@NonNull URI>
	{
		protected class InstrumentedCompilerChain extends QVTcCompilerChain
		{
			protected InstrumentedCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
				super(projectManager, txURI, intermediateFileNamePrefixURI, options);
			}

			@Override
			protected @NonNull QVTm2QVTsCompilerStep createQVTm2QVTsCompilerStep() {
				return new QVTm2QVTsCompilerStep(this)
				{
					@Override
					public @NonNull ScheduleManager execute(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull Resource pResource, @NonNull TypedModelsConfiguration typedModelsConfiguration) throws IOException {
						ScheduleManager scheduleManager = super.execute(environmentFactory, pResource, typedModelsConfiguration);
						partitionUsage.instrumentPartition(scheduleManager);
						return scheduleManager;
					}
				};
			}
		}

		/**
		 * The source transformation.
		 */
		protected final @NonNull URI txURI;

		/**
		 * A prefix for output filenames.
		 */
		protected final @NonNull URI intermediateFileNamePrefixURI;

		protected QVTcTxGenerationThread(@NonNull String resultPrefix, @NonNull URI txURI) {
			super(createQVTcoreEnvironmentThreadFactory(), "QVTc-TxGeneration", resultPrefix);
			this.txURI = txURI;
			this.intermediateFileNamePrefixURI = getTestURI(resultPrefix);
		}

		protected @NonNull CompilationResult compileTransformation(@NonNull String outputName) throws Exception {
			SimpleConfigurations typedModelsConfigurations = new SimpleConfigurations(outputName);
			QVTimperativeEnvironmentThreadFactory environmentThreadFactory = createQVTcoreEnvironmentThreadFactory();
			DefaultCompilerOptions compilerOptions = createCompilerChainOptions();
			QVTcCompilerChain compilerChain = new InstrumentedCompilerChain(getTestProjectManager(), txURI, intermediateFileNamePrefixURI, compilerOptions);
			return doCompile(environmentThreadFactory, typedModelsConfigurations, compilerChain);
		}

		private @NonNull CompilationResult doCompile(@NonNull QVTimperativeEnvironmentThreadFactory environmentThreadFactory,
				@NonNull TypedModelsConfigurations typedModelsConfigurations, @NonNull AbstractCompilerChain compilerChain) throws Exception {
			CompilationResult compilationThreadResult = compilerChain.compile3(environmentThreadFactory, typedModelsConfigurations);
			ImperativeTransformation transformation = compilationThreadResult.getResult();
			URI txASURI = transformation.eResource().getURI();
			if (txASURI != null) {
				URI inputURI = txASURI;
				URI asURIstem = txASURI.trimFileExtension();
				URI serializedURI = asURIstem.appendFileExtension("serialized.qvti");
				AbstractTestQVT.doSerialize(environmentThreadFactory.getProjectManager(), inputURI, serializedURI);
				AbstractTestQVT.doScheduleLoadCheck(environmentThreadFactory, asURIstem.appendFileExtension(QVTbaseUtil.QVTSAS_FILE_EXTENSION));
			}
			return compilationThreadResult;
		}

		private @NonNull DefaultCompilerOptions createCompilerChainOptions() {
			DefaultCompilerOptions compilerOptions = createCompilerOptions();
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

		private @NonNull DefaultCompilerOptions createCompilerOptions() {
			DefaultCompilerOptions compilerOptions = new DefaultCompilerOptions();
			compilerOptions.setOption(CompilerChain.DEFAULT_STEP, CompilerChain.DEBUG_KEY, true);
			return compilerOptions;
		}

		/*	@Override
		protected @NonNull QVTimperativeEnvironmentFactory createEnvironmentFactory() {
			QVTimperativeEnvironmentFactory environmentFactory = super.createEnvironmentFactory();
			//			installEPackages(eInstances);
			//
			// http://www.eclipse.org/emf/2002/Ecore is referenced by just about any model load
			// Ecore.core is referenced from Ecore.genmodel that is used by the CG to coordinate Ecore objects with their Java classes
			// therefore suppress diagnostics about confusing usage.
			//
			getProjectManager().configureLoadFirst(environmentFactory.getResourceSet(), EcorePackage.eNS_URI);	// XXX transitive usedGenModels
			return environmentFactory;
		} */

		protected ImperativeTransformation generateTransformation(@NonNull String outputName) throws Exception {
			CompilationResult compilationResult = compileTransformation(outputName);
			return compilationResult.getResult();
		}

		protected @NonNull URI generateTransformationURI(@NonNull String outputName) throws Exception {
			ImperativeTransformation iTransformation = generateTransformation(outputName);
			URI uri = iTransformation.eResource().getURI();
			assert uri != null;
			return uri;
		}

		protected void loadEcoreFile(URI fileURI, EPackage ePackage) {
			ResourceSet rSet = getEnvironmentFactory().getResourceSet();
			rSet.getPackageRegistry().put(fileURI.toString(), ePackage);
			EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);		// FIXME Accumulate for cleanup
		}
	}

	protected abstract static class QVTcExecutionTestThread extends QVTimperativeEnvironmentThread<Object>
	{
		private TransformationExecutor executor;
		private boolean suppressFailureDiagnosis = false;				// FIXME BUG 511028

		protected QVTcExecutionTestThread(@NonNull QVTimperativeEnvironmentThreadFactory environmentThreadFactory, @NonNull String threadName) {
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

		protected boolean executeTransformation() throws Exception {
			if (suppressFailureDiagnosis) {
				executor.setSuppressFailureDiagnosis(true);
			}
			Boolean success = executor.execute(null);
			return success == Boolean.TRUE;
		}

		protected void saveModels(@Nullable Map<?, ?> saveOptions) throws IOException {
			executor.getModelsManager().saveModels(saveOptions);
		}

		protected void setExecutor(@NonNull TransformationExecutor executor) {
			this.executor = executor;
		}
	}

	protected abstract class QVTcCodeExecutionThread extends QVTcExecutionTestThread
	{
		protected @NonNull Class<? extends Transformer> txClass;

		protected QVTcCodeExecutionThread(@NonNull Class<? extends Transformer> txClass) {
			super(createQVTcoreEnvironmentThreadFactory(), "QVTc-CodeExecution");
			this.txClass = txClass;
		}

		protected void createGeneratedExecutor() throws ReflectiveOperationException {
			setExecutor(new QVTiTransformationExecutor(getEnvironmentFactory(), txClass));
		}
	}

	protected abstract class QVTcTxInterpretationThread extends QVTcExecutionTestThread
	{
		protected @NonNull URI txURI;
		private ImperativeTransformation iTransformation;

		protected QVTcTxInterpretationThread(@NonNull  URI txURI) {
			super(createQVTcoreEnvironmentThreadFactory(), "QVTc-TxInterpretation");
			this.txURI = txURI;
		}

		protected void createInterpretedExecutor() throws Exception {
			EntryPoint entryPoint = QVTimperativeUtil.getDefaultEntryPoint(iTransformation);
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
				else if (!(eObject instanceof Model)  && !(eObject instanceof org.eclipse.ocl.pivot.Package)) {
					tit.prune();
				}
			}
			throw new IllegalStateException("No transformation");
		}
	}

	/*	protected abstract class QVTcTxExecutionThread extends QVTimperativeEnvironmentThread<Object>
	{
		protected QVTcTxExecutionThread() {
			super(createQVTimperativeEnvironmentThreadFactory(), "QVTc-TxExecution");
		}
	} */

	protected class MyQVT extends AbstractTestQVT
	{
		protected class InstrumentedCompilerChain extends QVTcCompilerChain
		{
			protected InstrumentedCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
				super(projectManager, txURI, intermediateFileNamePrefixURI, options);
			}

			@Override
			protected @NonNull QVTm2QVTsCompilerStep createQVTm2QVTsCompilerStep() {
				return new QVTm2QVTsCompilerStep(this)
				{
					@Override
					public @NonNull ScheduleManager execute(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull Resource pResource, @NonNull TypedModelsConfiguration typedModelsConfiguration) throws IOException {
						ScheduleManager scheduleManager = super.execute(environmentFactory, pResource, typedModelsConfiguration);
						partitionUsage.instrumentPartition(scheduleManager);
						return scheduleManager;
					}
				};
			}
		}

		protected final @NonNull PartitionUsage partitionUsage = new PartitionUsage();

		public MyQVT(@NonNull ProjectManager projectManager, @NonNull TestProject testProject, @NonNull URI testBundleURI, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull URI srcFileURI, @NonNull URI binFileURI) throws IOException {
			super(projectManager, testProject, testBundleURI, txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
		}

		public @NonNull Resource checkOutput(@NonNull URI actualURI, @Nullable URI expectedURI, @Nullable ModelNormalizer normalizer) throws Exception {
			QVTcoreEnvironmentThreadFactory environmentThreadFactory = createQVTcoreEnvironmentThreadFactory();
			return checkOutput(environmentThreadFactory, actualURI, expectedURI, normalizer);
		}

		public @NonNull CompilationResult compileTransformation(@NonNull String outputName) throws Exception {
			SimpleConfigurations typedModelsConfigurations = new SimpleConfigurations(outputName);
			return compileTransformation(typedModelsConfigurations);
		}

		public @NonNull CompilationResult compileTransformation(@NonNull TypedModelsConfigurations typedModelsConfigurations) throws Exception {
			AbstractEnvironmentThreadFactory<@NonNull QVTimperativeEnvironmentFactory> environmentThreadFactory = createQVTcoreEnvironmentThreadFactory();
			return compileTransformation(environmentThreadFactory, typedModelsConfigurations);
		}

		@Override
		protected @NonNull QVTcCompilerChain createCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
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
		protected @NonNull JavaClasspath createClassProjectNames() {
			JavaClasspath classpath = super.createClassProjectNames();
			classpath.addClass(/*0,*/ getClass());
			return classpath;
		}

		@Override
		protected @NonNull String getBasePrefix() {
			return "org.eclipse.qvtd.xtext.qvtcore.tests";
		}

		@Override
		protected @NonNull ProjectManager getTestProjectManager(@NonNull String pathFromCurrentWorkingDirectoryToFileSystem) {
			return EMFPlugin.IS_ECLIPSE_RUNNING ? new ProjectMap(true) : QVTcCompilerTests.this.getTestProjectManager(pathFromCurrentWorkingDirectoryToFileSystem);
		}
	}

	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTcore.newInstance(getTestProjectManager(), null);
	}

	protected @NonNull MyQVT createQVT(@NonNull String resultPrefix, @NonNull URI txURI) throws Exception {
		ProjectManager testProjectManager = getTestProjectManager();
		URI intermediateFileNamePrefixURI = getTestURI(resultPrefix);
		URI srcFileURI = getTestFileURI(JavaFileUtil.TEST_SRC_FOLDER_NAME + "/");
		URI binFileURI = getTestFileURI(JavaFileUtil.TEST_BIN_FOLDER_NAME + "/");
		return new MyQVT(testProjectManager, getTestProject(), getTestBundleURI(), txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
	}

	@Override
	protected @NonNull TestFileSystemHelper getTestFileSystemHelper() {
		return new QVTcoreTestFileSystemHelper();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		//		BaseLinkingService.DEBUG_RETRY.setState(true);
		super.setUp();
		QVTm2QVTs.DEBUG_GRAPHS.setState(true);
		OCLstdlib.install();
		XtextCompilerUtil.doQVTcoreSetup();
		XtextCompilerUtil.doQVTimperativeSetup();
		//		QVTcorePivotStandaloneSetup.doSetup();
		//		QVTimperativePivotStandaloneSetup.doSetup();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#tearDown()
	 */
	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testQVTcCompiler_Families2Persons() throws Exception {
		Registry registry = EPackage.Registry.INSTANCE;
		registry.remove(FamiliesPackage.eNS_URI);
		registry.remove(Families2PersonsPackage.eNS_URI);
		registry.remove(PersonsPackage.eNS_URI);
		//		AbstractTransformer.APPENDS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		ProjectManager testProjectManager = getTestProjectManager();
		TestProject testProject = getTestProject();
		TestFolder outputFolder = testProject.getOutputFolder("samples");
		URI modelsURI = getModelsURI("families2persons/samples");
		TestFile txFile = testProject.copyFiles(testProjectManager, null, getModelsURI("families2persons"), "Families2Persons.qvtc", "Families.ecore", "Persons.ecore", "Families2Persons.ecore"); //, "Families2Persons.genmodel");
		TestFile inFile = testProject.copyFiles(testProjectManager, outputFolder, modelsURI, "Families.xmi");
		URI outURI = getTestURI("Persons_Interpreted.xmi");
		TestFile refFile = testProject.copyFiles(testProjectManager, outputFolder, modelsURI, "Persons_expected.xmi");
		//		myQVT.loadEcoreFile(getModelsURI("families2persons/Families.ecore"), FamiliesPackage.eINSTANCE);
		//		myQVT.loadEcoreFile(getModelsURI("families2persons/Families2Persons.ecore"), Families2PersonsPackage.eINSTANCE);
		//		myQVT.loadEcoreFile(getModelsURI("families2persons/Persons.ecore"), PersonsPackage.eINSTANCE);
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		QVTcTxGenerationThread compilationThread = new QVTcTxGenerationThread("Families2Persons", txFile.getURI())
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				return generateTransformationURI("person");
			}
		};
		URI txURI = compilationThread.invoke();
		QVTcTxInterpretationThread interpretationThread = new QVTcTxInterpretationThread(txURI)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadTransformation();
				createInterpretedExecutor();
				addInputURI("family", inFile.getURI());
				executeTransformation();
				addOutputURI("person", outURI);
				saveModels(null);
				checkOutput(outURI, refFile.getURI(), Families2PersonsNormalizer.INSTANCE);
				return null;
			}
		};
		interpretationThread.invoke();
	}

	@Test
	public void testQVTcCompiler_Families2Persons_CG() throws Exception {
		//		OperationDependencyAnalysis.CALL.setState(true);
		//		OperationDependencyAnalysis.CREATE.setState(true);
		//		OperationDependencyAnalysis.FINISH.setState(true);
		//		OperationDependencyAnalysis.PENDING.setState(true);
		//		OperationDependencyAnalysis.REFINING.setState(true);
		//		OperationDependencyAnalysis.RETURN.setState(true);
		//		OperationDependencyAnalysis.START.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//		Scheduler.EDGE_ORDER.setState(true);
		//		Scheduler.REGION_DEPTH.setState(true);
		//		Scheduler.REGION_ORDER.setState(true);
		//		Scheduler.REGION_TRAVERSAL.setState(true);
		TestFile txFile = getTestProject().copyFiles(getTestProjectManager(), null, getModelsURI("families2persons"), "Families2Persons.qvtc", "Families.ecore", "Persons.ecore", "Families2Persons.ecore", "Families2Persons.genmodel");
		MyQVT myQVT = createQVT("Families2Persons", txFile.getURI());
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation_486938("person", false, "Families2Persons.genmodel"); // FIXME BUG 486938
			myQVT.assertRegionCount(RuleRegionImpl.class, 2);
			//			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
			//
			QVTcCodeExecutionThread executionThread = new QVTcCodeExecutionThread(txClass)
			{
				@Override
				protected Object runWithThrowable() throws Exception {
					createGeneratedExecutor();
					addInputURI("family", getModelsURI("families2persons/samples/Families.xmi"));
					executeTransformation();
					addOutputURI("person", getTestURI("Persons_CG.xmi"));
					saveModels(null);
					checkOutput(getTestURI("Persons_CG.xmi"), getModelsURI("families2persons/samples/Persons_expected.xmi"), Families2PersonsNormalizer.INSTANCE);
					//
					createGeneratedExecutor();
					addInputURI("family", getModelsURI("families2persons/samples/FamiliesBig.xmi"));
					executeTransformation();
					addOutputURI("person", getTestURI("PersonsBig_CG.xmi"));
					saveModels(null);
					checkOutput(getTestURI("PersonsBig_CG.xmi"), getModelsURI("families2persons/samples/PersonsBig_expected.xmi"), Families2PersonsNormalizer.INSTANCE);
					return null;
				}
			};
			executionThread.invoke();
		}
		finally {
			myQVT.dispose();
			cleanup("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families2Persons",
				"http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Families",
					"http://www.eclipse.org/qvtd/xtext/qvtcore/tests/Upper2Lower/1.0/Persons");
		}
	}

	@Test
	public void testQVTcCompiler_Forward2Reverse() throws Exception {
		Registry registry = EPackage.Registry.INSTANCE;
		registry.remove(DoublylinkedlistPackage.eNS_URI);
		registry.remove(List2listPackage.eNS_URI);
		//    	QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
		ProjectManager testProjectManager = getTestProjectManager();
		TestProject testProject = getTestProject();
		TestFolder outputFolder = testProject.getOutputFolder("samples");
		URI modelsURI = getModelsURI("forward2reverse/samples");
		TestFile txFile = testProject.copyFiles(testProjectManager, null, getModelsURI("forward2reverse"), "Forward2Reverse.qvtc", "DoublyLinkedList.ecore", "List2List.ecore"); //, "List2List.genmodel");
		TestFile inFile0 = testProject.copyFiles(testProjectManager, outputFolder, modelsURI, "EmptyList.xmi");
		TestFile inFile1 = testProject.copyFiles(testProjectManager, outputFolder, modelsURI, "OneElementList.xmi");
		TestFile inFile2 = testProject.copyFiles(testProjectManager, outputFolder, modelsURI, "TwoElementList.xmi");
		TestFile inFile3 = testProject.copyFiles(testProjectManager, outputFolder, modelsURI, "ThreeElementList.xmi");
		URI outURI0 = getTestURI("EmptyList_Interpreted.xmi");
		URI outURI1 = getTestURI("OneElementList_Interpreted.xmi");
		URI outURI2 = getTestURI("TwoElementList_Interpreted.xmi");
		URI outURI3 = getTestURI("ThreeElementList_Interpreted.xmi");
		TestFile refFile0 = testProject.copyFiles(testProjectManager, outputFolder, modelsURI, "EmptyList_expected.xmi");
		TestFile refFile1 = testProject.copyFiles(testProjectManager, outputFolder, modelsURI, "OneElementList_expected.xmi");
		TestFile refFile2 = testProject.copyFiles(testProjectManager, outputFolder, modelsURI, "TwoElementList_expected.xmi");
		TestFile refFile3 = testProject.copyFiles(testProjectManager, outputFolder, modelsURI, "ThreeElementList_expected.xmi");
		//		DoublylinkedlistPackage.eINSTANCE.getClass();
		//		List2listPackage.eINSTANCE.getClass();
		//		myQVT.loadEcoreFile(getModelsURI("forward2reverse/DoublyLinkedList.ecore"), DoublylinkedlistPackage.eINSTANCE);
		//		myQVT.loadEcoreFile(getModelsURI("forward2reverse/List2List.ecore"), List2listPackage.eINSTANCE);
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		//	CompilationResult compilationResult = myQVT.generateTransformationURI("reverse");
		QVTcTxGenerationThread compilationThread = new QVTcTxGenerationThread("Forward2Reverse", txFile.getURI())
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				return generateTransformationURI("reverse");
			}
		};
		URI txURI = compilationThread.invoke();
		QVTcTxInterpretationThread interpretationThread = new QVTcTxInterpretationThread(txURI)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadTransformation();
				createInterpretedExecutor();
				addInputURI("forward", inFile0.getURI());
				executeTransformation();
				addOutputURI("reverse", outURI0);
				saveModels(null);
				checkOutput(outURI0, refFile0.getURI(), Forward2ReverseNormalizer.INSTANCE);
				//
				createInterpretedExecutor();
				addInputURI("forward", inFile1.getURI());
				executeTransformation();
				addOutputURI("reverse", outURI1);
				saveModels(null);
				checkOutput(outURI1, refFile1.getURI(), Forward2ReverseNormalizer.INSTANCE);
				//
				createInterpretedExecutor();
				addInputURI("forward", inFile2.getURI());
				executeTransformation();
				addOutputURI("reverse", outURI2);
				saveModels(null);
				checkOutput(outURI2, refFile2.getURI(), Forward2ReverseNormalizer.INSTANCE);
				//
				createInterpretedExecutor();
				addInputURI("forward", inFile3.getURI());
				executeTransformation();
				addOutputURI("reverse", outURI3);
				saveModels(null);
				checkOutput(outURI3, refFile3.getURI(), Forward2ReverseNormalizer.INSTANCE);
				return null;
			}
		};
		interpretationThread.invoke();
	}

	@Test
	public void testQVTcCompiler_Forward2Reverse_CG() throws Exception {
		//    	Scheduler.EDGE_ORDER.setState(true);
		//    	Scheduler.REGION_DEPTH.setState(true);
		//    	Scheduler.REGION_LOCALITY.setState(true);
		//    	Scheduler.REGION_ORDER.setState(true);
		//    	Scheduler.REGION_STACK.setState(true);
		//    	Scheduler.REGION_TRAVERSAL.setState(true);
		TestFile txFile = getTestProject().copyFiles(getTestProjectManager(), null, getModelsURI("forward2reverse"), "Forward2Reverse.qvtc", "DoublyLinkedList.ecore", "List2List.ecore", "List2List.genmodel");
		MyQVT myQVT = createQVT("Forward2Reverse", txFile.getURI());
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			Class<? extends Transformer> txClassReverse = myQVT.buildTransformation("forward", false, "List2List.genmodel");
			//			Class<? extends Transformer> txClassReverse = Forward2Reverse.class;
			myQVT.assertRegionCount(RuleRegionImpl.class, 0);
			//			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 9);
			//
			QVTcCodeExecutionThread reverseExecutionThread = new QVTcCodeExecutionThread(txClassReverse)
			{
				@Override
				protected Object runWithThrowable() throws Exception {
					createGeneratedExecutor();
					addInputURI("reverse", getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
					executeTransformation();
					addOutputURI("forward", getTestURI("ThreeElementList_Reverse_CG.xmi"));
					saveModels(null);
					checkOutput(getTestURI("ThreeElementList_Reverse_CG.xmi"), getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
					return null;
				}
			};
			reverseExecutionThread.invoke();
			//
			Class<? extends Transformer> txClass = myQVT.buildTransformation("reverse", false, "List2List.genmodel");
			QVTcCodeExecutionThread forwardExecutionThread = new QVTcCodeExecutionThread(txClass)
			{
				@Override
				protected Object runWithThrowable() throws Exception {
					createGeneratedExecutor();
					addInputURI("forward", getModelsURI("forward2reverse/samples/EmptyList.xmi"));
					executeTransformation();
					addOutputURI("reverse", getTestURI("EmptyList_CG.xmi"));
					saveModels(null);
					checkOutput(getTestURI("EmptyList_CG.xmi"), getModelsURI("forward2reverse/samples/EmptyList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
					//
					createGeneratedExecutor();
					addInputURI("forward", getModelsURI("forward2reverse/samples/OneElementList.xmi"));
					executeTransformation();
					addOutputURI("reverse", getTestURI("OneElementList_CG.xmi"));
					saveModels(null);
					checkOutput(getTestURI("OneElementList_CG.xmi"), getModelsURI("forward2reverse/samples/OneElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
					//
					createGeneratedExecutor();
					addInputURI("forward", getModelsURI("forward2reverse/samples/TwoElementList.xmi"));
					executeTransformation();
					addOutputURI("reverse", getTestURI("TwoElementList_CG.xmi"));
					saveModels(null);
					checkOutput(getTestURI("TwoElementList_CG.xmi"), getModelsURI("forward2reverse/samples/TwoElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
					//
					createGeneratedExecutor();
					addInputURI("forward", getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
					executeTransformation();
					addOutputURI("reverse", getTestURI("ThreeElementList_CG.xmi"));
					saveModels(null);
					checkOutput(getTestURI("ThreeElementList_CG.xmi"), getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
					return null;
				}
			};
			forwardExecutionThread.invoke();
		}
		finally {
			myQVT.dispose();
			cleanup("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/forward2reverse/1.0/List2List",
					"http://www.eclipse.org/qvtd/xtext/qvtcore/tests/forward2reverse/1.0/DoublyLinkList");
		}
	}

	@Test
	public void testQVTcCompiler_HSVToHSL() throws Exception {
		Registry registry = EPackage.Registry.INSTANCE;
		registry.remove(HSV2HSLPackage.eNS_URI);
		registry.remove(HSVTreePackage.eNS_URI);
		registry.remove(HSLTreePackage.eNS_URI);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		TestFile txFile = getTestProject().copyFiles(getTestProjectManager(), null, getModelsURI("hsv2hsl"), "HSV2HSL.qvtc", "HSLTree.ecore", "HSV2HSL.ecore", "HSVTree.ecore");// "HSV2HSL.genmodel");
		TestFile inFile = getTestProject().copyFiles(getTestProjectManager(), getTestProject().getOutputFolder("samples"), getModelsURI("hsv2hsl/samples"), "SolarizedHSV.xmi");
		URI outURI = getTestURI("SolarizedHSL_Interpreted.xmi");
		TestFile refFile = getTestProject().copyFiles(getTestProjectManager(), getTestProject().getOutputFolder("samples"), getModelsURI("hsv2hsl/samples"), "SolarizedHSL_expected.xmi");
		//		myQVT.loadEcoreFile(getTestFileURI("HSV2HSL.ecore"), HSV2HSLPackage.eINSTANCE);
		//		myQVT.loadEcoreFile(getTestFileURI("HSVTree.ecore"), HSVTreePackage.eINSTANCE);
		//		myQVT.loadEcoreFile(getTestFileURI("HSLTree.ecore"), HSLTreePackage.eINSTANCE);
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		//	CompilationResult compilationResult = myQVT.generateTransformationURI("hsl");
		QVTcTxGenerationThread compilationThread = new QVTcTxGenerationThread("HSV2HSL", txFile.getURI())
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				return generateTransformationURI("hsl");
			}
		};
		URI txURI = compilationThread.invoke();
		QVTcTxInterpretationThread interpretationThread = new QVTcTxInterpretationThread(txURI)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadTransformation();
				createInterpretedExecutor();
				addInputURI("hsv", inFile.getURI());
				executeTransformation();
				addOutputURI("hsl", outURI);
				saveModels(null);
				checkOutput(outURI, refFile.getURI(), HSV2HSLNormalizer.INSTANCE);	// FIXME Bug 490497 remove normalizer
				return null;
			}
		};
		interpretationThread.invoke();
	}

	@Test
	public void testQVTcCompiler_HSVToHSL_CG() throws Exception {
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//		Scheduler.EDGE_ORDER.setState(true);
		//		Scheduler.REGION_DEPTH.setState(true);
		//		Scheduler.REGION_ORDER.setState(true);
		//		Scheduler.REGION_TRAVERSAL.setState(true);
		//		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
		//		AbstractMerger.EARLY.setState(true);
		//		AbstractMerger.FAILURE.setState(true);
		//		AbstractMerger.LATE.setState(true);
		TestFile txFile = getTestProject().copyFiles(getTestProjectManager(), null, getModelsURI("hsv2hsl"), "HSV2HSL.qvtc", "HSLTree.ecore", "HSV2HSL.ecore", "HSVTree.ecore", "HSV2HSL.genmodel");
		MyQVT myQVT = createQVT("HSV2HSL", txFile.getURI());
		try {
			//			executor = myQVT.createGeneratedExecutor(hsv2hsl.class);
			Class<? extends Transformer> txClass = myQVT.buildTransformation("hsl", false, "HSV2HSL.genmodel");
			myQVT.assertRegionCount(RuleRegionImpl.class, 1);
			//			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 4);
			//
			QVTcCodeExecutionThread executionThread = new QVTcCodeExecutionThread(txClass)
			{
				@Override
				protected Object runWithThrowable() throws Exception {
					createGeneratedExecutor();
					addInputURI("hsv", getModelsURI("hsv2hsl/samples/SolarizedHSV.xmi"));
					executeTransformation();
					addOutputURI("hsl", getTestURI("SolarizedHSL_CG.xmi"));
					saveModels(null);
					checkOutput(getTestURI("SolarizedHSL_CG.xmi"), getModelsURI("hsv2hsl/samples/SolarizedHSL_expected.xmi"), HSV2HSLNormalizer.INSTANCE);	// FIXME Bug 490497 remove normalizer
					return null;
				}
			};
			executionThread.invoke();
		}
		finally {
			myQVT.dispose();
			cleanup("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/HSV2HSL/1.0/HSLTree",
				"http://www.eclipse.org/qvtd/xtext/qvtcore/tests/HSV2HLS/1.0/HSVTree",
					"http://www.eclipse.org/qvtd/xtext/qvtcore/tests/HSV2HSL/1.0/HSVtoHSL");
		}
	}

	@Test // fails through at least lack of multi-headed support, which may not be needed if better partitioned
	public void testQVTcCompiler_SimpleUML2RDBMS() throws Exception {
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//	MyQVT myQVT = createQVT("SimpleUML2RDBMS", getModelsURI("uml2rdbms/SimpleUML2RDBMS.qvtcas"));
		//	myQVT.loadEcoreFile(getModelsURI("uml2rdbms/SimpleUML2RDBMS.ecore"), Simpleuml2rdbmsPackage.eINSTANCE);
		//	myQVT.loadEcoreFile(getModelsURI("uml2rdbms/SimpleUML.ecore"), SimpleumlPackage.eINSTANCE);
		//	myQVT.loadEcoreFile(getModelsURI("uml2rdbms/SimpleRDBMS.ecore"), SimplerdbmsPackage.eINSTANCE);
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		//	CompilationResult compilationResult = myQVT.generateTransformationURI("rdbms");
		QVTcTxGenerationThread compilationThread = new QVTcTxGenerationThread("SimpleUML2RDBMS", getModelsURI("uml2rdbms/SimpleUML2RDBMS.qvtcas"))
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				loadEcoreFile(getModelsURI("uml2rdbms/SimpleUML2RDBMS.ecore"), Simpleuml2rdbmsPackage.eINSTANCE);
				loadEcoreFile(getModelsURI("uml2rdbms/SimpleUML.ecore"), SimpleumlPackage.eINSTANCE);
				loadEcoreFile(getModelsURI("uml2rdbms/SimpleRDBMS.ecore"), SimplerdbmsPackage.eINSTANCE);
				return generateTransformationURI("rdbms");
			}
		};
		URI txURI = compilationThread.invoke();
		QVTcTxInterpretationThread interpretationThread = new QVTcTxInterpretationThread(txURI)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadTransformation();
				createInterpretedExecutor();
				addInputURI("uml", getModelsURI("uml2rdbms/samples/SimplerUMLPeople.xmi"));
				executeTransformation();
				addOutputURI("rdbms", getTestURI("SimplerRDBMSPeople_Interpreted.xmi"));
				saveModels(null);
				checkOutput(getTestURI("SimplerRDBMSPeople_Interpreted.xmi"), getModelsURI("uml2rdbms/samples/SimplerRDBMSPeople_expected.xmi"), SimpleRDBMSNormalizer.INSTANCE);
				//
				createInterpretedExecutor();
				addInputURI("uml", getModelsURI("uml2rdbms/samples/SimplerUMLPeople2.xmi"));
				executeTransformation();
				addOutputURI("rdbms", getTestURI("SimplerRDBMSPeople2_Interpreted.xmi"));
				saveModels(null);
				checkOutput(getTestURI("SimplerRDBMSPeople2_Interpreted.xmi"), getModelsURI("uml2rdbms/samples/SimplerRDBMSPeople2_expected.xmi"), SimpleRDBMSNormalizer.INSTANCE);
				//
				createInterpretedExecutor();
				addInputURI("uml", getModelsURI("uml2rdbms/samples/SimpleUMLPeople.xmi"));
				executeTransformation();
				addOutputURI("rdbms", getTestURI("SimpleRDBMSPeople_Interpreted.xmi"));
				saveModels(null);
				checkOutput(getTestURI("SimpleRDBMSPeople_Interpreted.xmi"), getModelsURI("uml2rdbms/samples/SimpleRDBMSPeople_expected.xmi"), SimpleRDBMSNormalizer.INSTANCE);
				return null;
			}
		};
		interpretationThread.invoke();
		cleanup("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/UML2RDBMS/1.0/SimpleRDBMS",
			"http://www.eclipse.org/qvtd/xtext/qvtcore/tests/UML2RDBMS/1.0/simpleUML",
				"http://www.eclipse.org/qvtd/xtext/qvtcore/tests/UML2RDBMS/1.0/SimpleUMLtoRDBMS");
	}

	@Test
	public void testQVTcCompiler_SimpleUML2RDBMS_CG() throws Exception {
		/*	QVTscheduleConstants.CONNECTION_CREATION.setState(true);
		TransformationPartitioner.REGION_IMMEDIATE_PREDECESSORS.setState(true);
		TransformationPartitioner.REGION_TRANSITIVE_PREDECESSORS.setState(true);
		TransformationPartitioner.REGION_TRANSITIVE_SUCCESSORS.setState(true);
		TransformationPartitioner.REGION_CYCLES.setState(true);
		TransformationPartitioner.PARTITION_IMMEDIATE_PREDECESSORS.setState(true);
		TransformationPartitioner.PARTITION_IMMEDIATE_PREDECESSORS.setState(true);
		TransformationPartitioner.PARTITION_TRANSITIVE_PREDECESSORS.setState(true);
		TransformationPartitioner.PARTITION_TRANSITIVE_SUCCESSORS.setState(true);
		TransformationPartitioner.CONTAINMENT.setState(true);
		TransformationPartitioner.PARTITION_CYCLES.setState(true);
		TransformationPartitioner.ROOT_SCHEDULE_PREDECESSORS.setState(true);
		TransformationPartitioner.ROOT_SCHEDULE.setState(true);
		TransformationPartitioner.CYCLE_SCHEDULE_PREDECESSORS.setState(true);
		TransformationPartitioner.CYCLE_SCHEDULE.setState(true); */
		//	TransformationPartitioner.PARALLEL_SCHEDULE.setState(true);
		//	TransformationPartitioner.PROPERTY_NOTIFY.setState(true);
		//	TransformationPartitioner.PROPERTY_OBSERVE.setState(true);
		//	TransformationPartitioner.MERGE_SEQUENTIAL.setState(true);
		//	QVTiProductionConsumption.SUMMARY.setState(true);

		//		OperationDependencyAnalysis.CALL.setState(true);
		//		OperationDependencyAnalysis.CREATE.setState(true);
		//		OperationDependencyAnalysis.FINISH.setState(true);
		//		OperationDependencyAnalysis.PENDING.setState(true);
		//		OperationDependencyAnalysis.REFINING.setState(true);
		//		OperationDependencyAnalysis.RETURN.setState(true);
		//		OperationDependencyAnalysis.START.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//		TransformationPartitioner.DISCRIMINATION.setState(true);
		//		Scheduler.CONNECTION_ROUTING.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		Scheduler.REGION_CYCLES.setState(true);
		//		Scheduler.REGION_DEPTH.setState(true);
		//		Scheduler.REGION_ORDER.setState(true);
		//		Scheduler.REGION_TRAVERSAL.setState(true);
		Splitter.RESULT.setState(true);
		Splitter.STAGES.setState(true);
		Splitter.RESULT.setState(true);
		MyQVT myQVT = createQVT("SimpleUML2RDBMS", getModelsURI("uml2rdbms/SimpleUML2RDBMS.qvtcas"));
		myQVT.setSuppressFailureDiagnosis(true);					// FIXME BUG 511028
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("rdbms", false, "SimpleUML2RDBMS.genmodel");
			//	Class<? extends Transformer> txClass = (Class<? extends Transformer>) Class.forName("_uml2rdbms.uml2rdbms");
			//	myQVT.assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 10 : 11);
			//			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(MicroMappingRegionImpl.class, NO_MERGES ? 9 : 3);
			//
			QVTcCodeExecutionThread executionThread = new QVTcCodeExecutionThread(txClass)
			{
				@Override
				protected Object runWithThrowable() throws Exception {
					createGeneratedExecutor();
					addInputURI("uml", getModelsURI("uml2rdbms/samples/SimplerUMLPeople.xmi"));
					executeTransformation();
					addOutputURI("rdbms", getTestURI("SimplerRDBMSPeople_CG.xmi"));
					saveModels(null);
					checkOutput(getTestURI("SimplerRDBMSPeople_CG.xmi"), getModelsURI("uml2rdbms/samples/SimplerRDBMSPeople_expected.xmi"), SimpleRDBMSNormalizer.INSTANCE);
					//
					createGeneratedExecutor();
					addInputURI("uml", getModelsURI("uml2rdbms/samples/SimplerUMLPeople2.xmi"));
					executeTransformation();
					addOutputURI("rdbms", getTestURI("SimplerRDBMSPeople2_CG.xmi"));
					saveModels(null);
					checkOutput(getTestURI("SimplerRDBMSPeople2_CG.xmi"), getModelsURI("uml2rdbms/samples/SimplerRDBMSPeople2_expected.xmi"), SimpleRDBMSNormalizer.INSTANCE);
					//
					createGeneratedExecutor();
					addInputURI("uml", getModelsURI("uml2rdbms/samples/SimpleUMLPeople.xmi"));
					executeTransformation();
					addOutputURI("rdbms", getTestURI("SimpleRDBMSPeople_CG.xmi"));
					saveModels(null);
					checkOutput(getTestURI("SimpleRDBMSPeople_CG.xmi"), getModelsURI("uml2rdbms/samples/SimpleRDBMSPeople_expected.xmi"), SimpleRDBMSNormalizer.INSTANCE);
					return null;
				}
			};
			executionThread.invoke();
		}
		finally {
			myQVT.dispose();
			cleanup("http://www.eclipse.org/qvtd/xtext/qvtcore/tests/UML2RDBMS/1.0/SimpleRDBMS",
				"http://www.eclipse.org/qvtd/xtext/qvtcore/tests/UML2RDBMS/1.0/simpleUML",
					"http://www.eclipse.org/qvtd/xtext/qvtcore/tests/UML2RDBMS/1.0/SimpleUMLtoRDBMS");
		}
	}

	@Test
	public void testQVTcCompiler_SimpleUML2RDBMS_example_CG() throws Exception {
		//		OperationDependencyAnalysis.CALL.setState(true);
		//		OperationDependencyAnalysis.CREATE.setState(true);
		//		OperationDependencyAnalysis.FINISH.setState(true);
		//		OperationDependencyAnalysis.PENDING.setState(true);
		//		OperationDependencyAnalysis.REFINING.setState(true);
		//		OperationDependencyAnalysis.RETURN.setState(true);
		//		OperationDependencyAnalysis.START.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//		Scheduler.CONNECTION_ROUTING.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		Scheduler.REGION_CYCLES.setState(true);
		//		Scheduler.REGION_DEPTH.setState(true);
		//		Scheduler.REGION_ORDER.setState(true);
		//		Scheduler.REGION_TRAVERSAL.setState(true);
		Splitter.RESULT.setState(true);
		Splitter.STAGES.setState(true);
		Splitter.RESULT.setState(true);
		ProjectManager testProjectManager = getTestProjectManager();
		TestProject testProject = getTestProject();
		TestFolder outputFolder = testProject.getOutputFolder("samples");
		String exampleProjectName = "org.eclipse.qvtd.examples.qvtcore.uml2rdbms";
		URI modelsURI = URI.createPlatformResourceURI("/" + exampleProjectName + "/model", true);
		URI modelsInURI = modelsURI.appendSegment("in");
		URI modelsOutURI = modelsURI.appendSegment("out");
		TestFile txFile = testProject.copyFiles(testProjectManager, null, modelsURI, "SimpleUML2RDBMS.qvtc", "SimpleRDBMS.ecore", "SimpleUML.ecore", "SimpleUML2RDBMS.ecore", "SimpleUML2RDBMS.genmodel");
		TestFile inFile = testProject.copyFiles(testProjectManager, outputFolder, modelsInURI, "SimpleUMLPeople.xmi");
		URI outURI = getTestURI("SimpleRDBMSPeople_CG.xmi");
		TestFile refFile = testProject.copyFiles(testProjectManager, outputFolder, modelsOutURI, "SimpleRDBMSPeople_expected.xmi");
		MyQVT myQVT = createQVT("SimpleUML2RDBMS", txFile.getURI());
		JavaClasspath classpath = myQVT.getClasspath();
		classpath.addClass(org.eclipse.qvtd.examples.qvtcore.uml2rdbms.simpleuml2rdbms.UmlToRdbmsModelElement.class);
		myQVT.setSuppressFailureDiagnosis(true);					// FIXME BUG 511028
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("rdbms", false, "SimpleUML2RDBMS.genmodel");
			myQVT.assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 10 : 11);
			//			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(MicroMappingRegionImpl.class, NO_MERGES ? 9 : 3);
			//
			QVTcCodeExecutionThread executionThread = new QVTcCodeExecutionThread(txClass)
			{
				@Override
				protected Object runWithThrowable() throws Exception {
					createGeneratedExecutor();
					addInputURI("uml", inFile.getURI());
					executeTransformation();
					addOutputURI("rdbms", outURI);
					saveModels(null);
					checkOutput(outURI, refFile.getURI(), SimpleRDBMSNormalizer.INSTANCE);
					return null;
				}
			};
			executionThread.invoke();
		}
		finally {
			myQVT.dispose();
			cleanup("http://www.eclipse.org/qvtd/examples/qvtcore/UML2RDBMS/1.0/SimpleUMLtoRDBMS",
				"http://www.eclipse.org/qvtd/examples/qvtcore/UML2RDBMS/1.0/simpleUML",
					"http://www.eclipse.org/qvtd/examples/qvtcore/UML2RDBMS/1.0/SimpleRDBMS");
		}
	}

	@Test
	public void testQVTcCompiler_Upper2Lower() throws Exception {
		//    	QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		//	CompilationResult compilationResult = myQVT.generateTransformationURI("lowerGraph");
		QVTcTxGenerationThread compilationThread = new QVTcTxGenerationThread("Upper2Lower", getModelsURI("upper2lower/Upper2Lower.qvtcas"))
		{
			@Override
			protected @NonNull URI runWithThrowable() throws Exception {
				return generateTransformationURI("lowerGraph");
			}
		};
		URI txURI = compilationThread.invoke();
		//
		QVTcTxInterpretationThread interpretationThread = new QVTcTxInterpretationThread(txURI)
		{
			@Override
			protected Object runWithThrowable() throws Exception {
				loadTransformation();
				createInterpretedExecutor();
				addInputURI("upperGraph", getModelsURI("upper2lower/samples/SimpleGraph.xmi"));
				executeTransformation();
				addOutputURI("lowerGraph", getTestURI("SimpleGraphLower_Interpreted.xmi"));
				saveModels(null);
				checkOutput(getTestURI("SimpleGraphLower_Interpreted.xmi"), getModelsURI("upper2lower/samples/SimpleGraphLower_expected.xmi"), Upper2LowerNormalizer.INSTANCE);
				return null;
			}
		};
		interpretationThread.invoke();
		//
		cleanup(SimplegraphPackage.eNS_URI,
			Simplegraph2graphPackage.eNS_URI);
	}

	@Test
	public void testQVTcCompiler_Upper2Lower_CG() throws Exception {
		//    	Scheduler.EDGE_ORDER.setState(true);
		//    	Scheduler.REGION_DEPTH.setState(true);
		//    	Scheduler.REGION_LOCALITY.setState(true);
		//    	Scheduler.REGION_ORDER.setState(true);
		//    	Scheduler.REGION_STACK.setState(true);
		//    	Scheduler.REGION_TRAVERSAL.setState(true);
		//		AbstractMerger.EARLY.setState(true);
		//		AbstractMerger.FAILURE.setState(true);
		//		AbstractMerger.LATE.setState(true);
		//	QVTiProductionConsumption.SUMMARY.setState(true);
		EPackage.Registry.INSTANCE.put(SimplegraphPackage.eNS_URI, SimplegraphPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(Simplegraph2graphPackage.eNS_URI, Simplegraph2graphPackage.eINSTANCE);
		MyQVT myQVT = createQVT("upper2lower", getModelsURI("upper2lower/Upper2Lower.qvtcas"));
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("lowerGraph", false, "SimpleGraph2Graph.genmodel");
			//
			QVTcCodeExecutionThread executionThread = new QVTcCodeExecutionThread(txClass)
			{
				@Override
				protected Object runWithThrowable() throws Exception {
					createGeneratedExecutor();
					addInputURI("upperGraph", getModelsURI("upper2lower/samples/SimpleGraph.xmi"));
					executeTransformation();
					addOutputURI("lowerGraph", getTestURI("SimpleGraphLower_CG.xmi"));
					saveModels(null);
					checkOutput(getTestURI("SimpleGraphLower_CG.xmi"), getModelsURI("upper2lower/samples/SimpleGraphLower_expected.xmi"), Upper2LowerNormalizer.INSTANCE);
					return null;
				}
			};
			executionThread.invoke();
		}
		finally {
			myQVT.dispose();
			cleanup(SimplegraphPackage.eNS_URI,
				Simplegraph2graphPackage.eNS_URI);
		}
	}
}
