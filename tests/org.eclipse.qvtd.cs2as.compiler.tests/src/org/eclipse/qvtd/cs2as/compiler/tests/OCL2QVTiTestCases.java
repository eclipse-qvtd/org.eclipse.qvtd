/*******************************************************************************
 * Copyright (c) 2014, 2021 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler.tests;

import java.io.IOException;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystemHelper;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.qvtd.compiler.AbstractCompilerChain;
import org.eclipse.qvtd.compiler.AbstractCompilerOptions;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.cs2as.compiler.CS2ASJavaCompilerParameters;
import org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerImpl;
import org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerParametersImpl;
import org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTiCompilerChain;
import org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTm;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtbase.tests.QVTbaseTestFileSystemHelper;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

// Manual load tests rely on previous generation of the class to load. - testExample1_CGManual
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OCL2QVTiTestCases extends LoadTestCase
{
	//	private static final boolean CREATE_GRAPHML = false; // Note. You need Epsilon with Bug 458724 fix to have output graphml models serialised
	private static boolean NO_MERGES = true;				// Set true to suppress the complexities of merging

	protected class MyQVT extends AbstractTestQVT
	{
		protected final @NonNull String modelTestName;
		protected final @NonNull String modelSamples;

		public MyQVT(@NonNull ProjectManager projectManager, @NonNull TestProject testProject, @NonNull URI testBundleURI, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull URI srcFileURI, @NonNull URI binFileURI, @NonNull String modelTestName, @NonNull String modelSamples) throws IOException {
			super(projectManager, testProject, testBundleURI, txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
			this.modelTestName = modelTestName;
			this.modelSamples = modelSamples;
		}

		public @NonNull Resource checkOutput(@NonNull URI actualURI, @Nullable URI expectedURI, @Nullable ModelNormalizer normalizer) throws Exception {
			QVTimperativeEnvironmentThreadFactory environmentThreadFactory = createQVTimperativeEnvironmentThreadFactory() ;
			return checkOutput(environmentThreadFactory, actualURI, expectedURI, normalizer);
		}

		@Override
		protected @NonNull AbstractCompilerChain createCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
			try {
				return new OCL2QVTiCompilerChain(this, createCompilerOptions(), txURI, getTestURIWithExtension(txURI, null));
			} catch (CompilerChainException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new IllegalStateException(e);
			}
		}

		@Override
		protected @NonNull DefaultCompilerOptions createCompilerOptions() {
			DefaultCompilerOptions options = super.createCompilerOptions();
			options.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.SAVE_OPTIONS_KEY, DefaultCompilerOptions.defaultSavingOptions);
			options.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.DEBUG_KEY, true);
			// TODO problem when validating options.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.VALIDATE_KEY, true);
			options.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_EARLY_MERGE, NO_MERGES);
			options.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_LATE_CONSUMER_MERGE, NO_MERGES);
			return options;
		}

		@Override
		protected @NonNull ResourceSet createTestResourceSet() {
			return super.createTestResourceSet();
		}

		//
		// Execute the transformation with the code generator
		//
		protected void executeModelsTX_CG(@NonNull Class<? extends Transformer> txClass, @NonNull String modelName) throws Throwable {
			String inputURIstring = modelTestName + "/" + modelSamples + "/" + modelName + "_input.xmi";
			String outURIstring = modelName + "_output_CG.xmi";
			String refURIstring = modelTestName + "/" + modelSamples + "/" + modelName + "_output_ref.xmi";
			createGeneratedExecutor(txClass);
			addInputURI(OCL2QVTm.LEFT_MODEL_TYPE_NAME, getModelsURI(inputURIstring));
			assertTrue(executeTransformation());
			addOutputURI(OCL2QVTm.RIGHT_MODEL_TYPE_NAME, getTestURI(outURIstring));
			saveModels(null);
			checkOutput(getTestURI(outURIstring), getModelsURI(refURIstring), null);
		}

		//
		// Execute the transformation with the QVTi interpreter
		//
		protected void executeModelsTX_Interpreted(@NonNull ImperativeTransformation tx, @NonNull String modelName) throws Throwable {
			String inputURIstring = modelTestName + "/" + modelSamples + "/" + modelName + "_input.xmi";
			String outURIstring = modelName + "_output_Interpreted.xmi";
			String refURIstring = modelTestName + "/" + modelSamples + "/" + modelName + "_output_ref.xmi";
			createInterpretedExecutor(tx);
			addInputURI(OCL2QVTm.LEFT_MODEL_TYPE_NAME, getModelsURI(inputURIstring));
			assertTrue(executeTransformation());
			addOutputURI(OCL2QVTm.RIGHT_MODEL_TYPE_NAME, getTestURI(outURIstring));
			saveModels(null);
			checkOutput(getTestURI(outURIstring), getModelsURI(refURIstring), null);
		}

		protected @NonNull ImperativeTransformation executeOCL2QVTi_CompilerChain(@NonNull String mainOclDoc, @NonNull String... extendedOclDocs) throws Throwable {
			URI mainOclDocURI = getModelsURI(modelTestName + "/" + mainOclDoc);
			@NonNull URI[] oclDocURIs = new @NonNull URI[extendedOclDocs.length];
			for (int i=0; i < extendedOclDocs.length; i++) {
				oclDocURIs[i] = getModelsURI(modelTestName + "/" + extendedOclDocs[i]);
			}
			OCL2QVTiCompilerChain compiler = new OCL2QVTiCompilerChain(this, createCompilerOptions(), mainOclDocURI, getTestURIWithExtension(mainOclDocURI, null), oclDocURIs)
			{
				@Override
				protected @NonNull QVTm2QVTsCompilerStep createQVTm2QVTsCompilerStep() {
					return new QVTm2QVTsCompilerStep(this)
					{
						@Override
						public @NonNull ScheduleManager execute(@NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull Resource pResource, @NonNull TypedModelsConfiguration typedModelsConfiguration) throws IOException {
							ScheduleManager scheduleManager = super.execute(environmentFactory, pResource, typedModelsConfiguration);
							instrumentPartition(scheduleManager);
							return scheduleManager;
						}
					};
				}
			};
			ImperativeTransformation qvtiTransf = compiler.compile(OCL2QVTm.RIGHT_MODEL_TYPE_NAME);
			URI txURI = qvtiTransf.eResource().getURI();
			if (txURI != null) {
				URI inputURI = txURI;
				URI serializedURI = getTestURIWithExtension(inputURI, "serialized.qvti");
				doSerialize(inputURI, serializedURI);
			}
			return qvtiTransf;
		}


		@Override
		protected @NonNull String getBasePrefix() {
			return "org.eclipse.qvtd.cs2as.compiler.tests";
		}

		@Override
		protected @NonNull ProjectManager getTestProjectManager(@NonNull String pathFromCurrentWorkingDirectoryToFileSystem) {
			return OCL2QVTiTestCases.this.getTestProjectManager(pathFromCurrentWorkingDirectoryToFileSystem);
		}
	}

	protected @NonNull CompilerOptions createCompilerOptions() {
		return new AbstractCompilerOptions() {};
	}

	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTimperative.newInstance(getTestProjectManager(), null);
	}

	private @NonNull CS2ASJavaCompilerParameters createParameters(@NonNull String lookupSolverClassName, @NonNull String lookupResultClassName) throws IOException {
		CS2ASJavaCompilerParametersImpl cgParams = new CS2ASJavaCompilerParametersImpl(lookupSolverClassName, lookupResultClassName,
			getTestProject().getOutputFile(JavaFileUtil.TEST_SRC_FOLDER_NAME).getFileString());
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			JavaClasspath classpath = CompilerUtil.createDefaultQVTiClasspath();
			classpath.addClass(getClass()/*getTestBundleName()*/);
			cgParams.setClasspath(classpath);
		}
		cgParams.setClassLoader(getClass().getClassLoader());
		return cgParams;
	}

	private @NonNull MyQVT createQVT(@NonNull String modelTestName, @NonNull URI txURI, @NonNull String modelSamples) throws Exception {
		//		return new MyQVT(getTestProjectManager(), modelTestName, modelSamples);
		ProjectManager testProjectManager = getTestProjectManager();
		URI intermediateFileNamePrefixURI = getTestURI(modelTestName);
		URI srcFileURI = getTestFileURI(JavaFileUtil.TEST_SRC_FOLDER_NAME + "/");
		URI binFileURI = getTestFileURI(JavaFileUtil.TEST_BIN_FOLDER_NAME + "/");
		return new MyQVT(testProjectManager, getTestProject(), getTestBundleURI(), txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI, modelTestName, modelSamples);
	}

	@Override
	protected @NonNull TestFileSystemHelper getTestFileSystemHelper() {
		QVTbaseTestFileSystemHelper testFileSystemHelper = new QVTbaseTestFileSystemHelper();
		testFileSystemHelper.addRequiredBundle("org.eclipse.qvtd.cs2as.compiler.tests");
		return testFileSystemHelper;
	}

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		QVTm2QVTs.DEBUG_GRAPHS.setState(true);;
		XtextCompilerUtil.doQVTimperativeSetup(); // To be able to add QVTimperative.ocl validation
		XtextCompilerUtil.doQVTcoreSetup();
		TestUtil.doCompleteOCLSetup();
	}

	@Override
	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testOCL2QVTi_Source2Target_CG() throws Throwable {
		//		OperationDependencyAnalysis.CALL.setState(true);
		//		OperationDependencyAnalysis.CREATE.setState(true);
		//		OperationDependencyAnalysis.FINISH.setState(true);
		//		OperationDependencyAnalysis.PENDING.setState(true);
		//		OperationDependencyAnalysis.REFINING.setState(true);
		//		OperationDependencyAnalysis.RETURN.setState(true);
		//		OperationDependencyAnalysis.START.setState(true);
		MyQVT myQVT = createQVT("Source2Target", getModelsURI("Source2Target/Source2Target.ocl"), "samples");
		try {
			myQVT.loadGenModels(getModelsURI("Source2Target/SourceMM1.genmodel"), getModelsURI("Source2Target/TargetMM1.genmodel"));
			myQVT.loadEcoreFile(getModelsURI("Source2Target/EnvExample1.ecore"), example1.target.lookup.EnvironmentPackage.eINSTANCE);
			ImperativeTransformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("Source2Target.ocl");
			myQVT.assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 23 : 19);
			//		myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 2);
			//		myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 0);
			//		myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
			CS2ASJavaCompilerParameters cgParams = createParameters("example1.target.lookup.util.TargetLookupSolver",
					"example1.target.lookup.util.TargetLookupResult");
			Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl().compileTransformation(myQVT, qvtiTransf, cgParams);
			myQVT.executeModelsTX_CG(txClass, "model1");
			myQVT.executeModelsTX_CG(txClass, "model2");
			myQVT.executeModelsTX_CG(txClass, "model3");
		}
		finally {
			myQVT.dispose();
			cleanup("http://cs2as/tests/example1/env/1.0",
				example1.source.SourcePackage.eNS_URI,
				example1.target.TargetPackage.eNS_URI);
		}
	}

	/*	@Test
	public void testOCL2QVTi_Source2Target_CGManual() throws Exception {
		MyQVT myQVT = createQVT("Source2Target", getModelsURI("Source2Target/Source2TargetBase.ocl"), "samples");
		try {
			myQVT.loadEcoreFile("SourceMM1.ecore", example1.source.SourcePackage.eINSTANCE);
			myQVT.loadEcoreFile("TargetMM1.ecore", example1.target.TargetPackage.eINSTANCE);
			String testProjectName = getClass().getSimpleName() + "__" + "testOCL2QVTi_Source2Target_CG";
			TestProject testProject = getTestFileSystem().getTestProject(testProjectName, false);
			File file = testProject.getOutputFolder(JavaFileUtil.TEST_BIN_FOLDER_NAME).getFile();
			ExplicitClassLoader explicitClassLoader = new ExplicitClassLoader(file, "_Source2Target_qvtm_qvtcas", getClass().getClassLoader());
			@SuppressWarnings({"null", "unchecked"})
			@NonNull Class<? extends Transformer> txClass = (Class<? extends Transformer>) explicitClassLoader.loadClass("_Source2Target_qvtm_qvtcas.Source2Target_qvtm_qvtcas");
			myQVT.executeModelsTX_CG(txClass, "model1");
			myQVT.executeModelsTX_CG(txClass, "model2");
			myQVT.executeModelsTX_CG(txClass, "model3");
		}
		finally {
			myQVT.dispose();
			EPackage.Registry.INSTANCE.remove(example1.source.SourcePackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example1.target.TargetPackage.eNS_URI);
		}
	} */

	@Test
	public void testOCL2QVTi_Source2Target_Interpreted() throws Throwable {
		testCaseAppender.uninstall();			// Silence Log failures warning that *.ocl has *.ecore rather than http:// references
		MyQVT myQVT = createQVT("Source2Target", getModelsURI("Source2Target/Source2Target.ocl"), "samples");
		try {
			myQVT.loadGenModels(getModelsURI("Source2Target/SourceMM1.genmodel"), getModelsURI("Source2Target/TargetMM1.genmodel"));

			Transformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("Source2Target.ocl");
			URI txURI = qvtiTransf.eResource().getURI();

			myQVT.dispose();
			myQVT = createQVT("Source2Target", getModelsURI("Source2Target/Source2Target.ocl"), "samples");
			myQVT.loadEcoreFile(getModelsURI("Source2Target/SourceMM1.ecore"), example1.source.SourcePackage.eINSTANCE);
			myQVT.loadEcoreFile(getModelsURI("Source2Target/TargetMM1.ecore"), example1.target.TargetPackage.eINSTANCE);
			ImperativeTransformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), txURI);
			//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
			myQVT.executeModelsTX_Interpreted(tx, "model1");
			myQVT.executeModelsTX_Interpreted(tx, "model2");
			myQVT.executeModelsTX_Interpreted(tx, "model3");
		}
		finally {
			myQVT.dispose();
			EPackage.Registry.INSTANCE.remove(example1.source.SourcePackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example1.target.TargetPackage.eNS_URI);
		}
	}

	@Test
	public void testOCL2QVTi_Source2Target_OCL2QVTm() throws Exception {
		MyQVT myQVT = createQVT("Source2Target", getModelsURI("Source2Target/Source2Target.ocl"), "samples");
		URI oclDocURI = getModelsURI("Source2Target/Source2Target.ocl");
		URI qvtmFileURI = getTestURI("Source2Target.qvtm.qvtcas");

		OCL2QVTiCompilerChain mtc = new OCL2QVTiCompilerChain(myQVT, createCompilerOptions(), oclDocURI, getTestURIWithExtension(oclDocURI, "tmp"));
		mtc.ocl2qvtmCompilerStep.ocl2qvtm(oclDocURI.appendFileExtension("oclas"));
		// Test the QVTm transformation can be loaded
		assertValidQVTiModel(qvtmFileURI);
		myQVT.dispose();
	}

	@Test
	public void testOCL2QVTi_SimpleClasses_CG() throws Throwable {
		//		Scheduler.EDGE_ORDER.setState(true);
		//		Scheduler.REGION_DEPTH.setState(true);
		//		Scheduler.REGION_ORDER.setState(true);
		//		Scheduler.REGION_TRAVERSAL.setState(true);
		//		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
		//		Scheduler.DEPENDENCY_ANALYSIS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//		TransformationPartitioner.CYCLES.setState(true);
		MyQVT myQVT = createQVT("SimpleClasses", getModelsURI("SimpleClasses/classescs2as.ocl"), "samples");
		try {
			myQVT.loadGenModels(getModelsURI("SimpleClasses/ClassesCS.genmodel"), getModelsURI("SimpleClasses/Classes.genmodel"));
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/EnvExample2.ecore"), example2.classes.lookup.EnvironmentPackage.eINSTANCE);
			ImperativeTransformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("classescs2as.ocl");
			myQVT.assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 9 : 3);
			//			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 2);
			//			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 1);
			//			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
			CS2ASJavaCompilerParameters cgParams = createParameters(
				"example2.classes.lookup.util.ClassesLookupSolver",
					"example2.classes.lookup.util.ClassesLookupResult");
			Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl().compileTransformation(myQVT, qvtiTransf, cgParams);
			myQVT.executeModelsTX_CG(txClass, "model1");
			myQVT.executeModelsTX_CG(txClass, "model2");
			myQVT.executeModelsTX_CG(txClass, "model3");
			myQVT.executeModelsTX_CG(txClass, "model4");
			myQVT.executeModelsTX_CG(txClass, "model5");
			myQVT.executeModelsTX_CG(txClass, "model6");
			myQVT.executeModelsTX_CG(txClass, "model7");
		}
		finally {
			myQVT.dispose();
			cleanup("http://cs2as/tests/example2/env/1.0",
				example2.classescs.ClassescsPackage.eNS_URI,
				example2.classes.ClassesPackage.eNS_URI);
		}
	}

	@Test
	public void testOCL2QVTi_SimpleClasses_Interpreted() throws Throwable {
		//		OperationDependencyAnalysis.CALL.setState(true);
		//		OperationDependencyAnalysis.CREATE.setState(true);
		//		OperationDependencyAnalysis.FINISH.setState(true);
		//		OperationDependencyAnalysis.HYPOTHECATING.setState(true);
		//		OperationDependencyAnalysis.PENDING.setState(true);
		//		OperationDependencyAnalysis.REFINING.setState(true);
		//		OperationDependencyAnalysis.RETURN.setState(true);
		//		OperationDependencyAnalysis.START.setState(true);
		testCaseAppender.uninstall();			// Silence Log failures warning that *.ocl has *.ecore rather than http:// references
		MyQVT myQVT = createQVT("SimpleClasses", getModelsURI("SimpleClasses/classescs2as.ocl"), "samples");
		myQVT.loadGenModels(getModelsURI("SimpleClasses/ClassesCS.genmodel"), getModelsURI("SimpleClasses/Classes.genmodel"));

		Transformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("classescs2as.ocl");
		URI txURI = qvtiTransf.eResource().getURI();

		myQVT.dispose();
		try {
			myQVT = createQVT("SimpleClasses", getModelsURI("SimpleClasses/classescs2as.ocl"), "samples");
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/Classes.ecore"), example2.classes.ClassesPackage.eINSTANCE);
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/ClassesCS.ecore"), example2.classescs.ClassescsPackage.eINSTANCE);
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/classescs2as.ecore"), example2.classescstraces.ClassescstracesPackage.eINSTANCE);
			ImperativeTransformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), txURI);
			//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
			myQVT.executeModelsTX_Interpreted(tx, "model1");
			myQVT.executeModelsTX_Interpreted(tx, "model2");
			myQVT.executeModelsTX_Interpreted(tx, "model3");
			//    	myQVT.executeModelsTX_Interpreted(tx, "model4");
			//    	myQVT.executeModelsTX_Interpreted(tx, "model5");
			//    	myQVT.executeModelsTX_Interpreted(tx, "model6");
			//    	myQVT.executeModelsTX_Interpreted(tx, "model7");
		}
		finally {
			myQVT.dispose();
			EPackage.Registry.INSTANCE.remove(example2.classes.ClassesPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example2.classescs.ClassescsPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example2.classescstraces.ClassescstracesPackage.eNS_URI);
		}
	}

	@Test
	public void testOCL2QVTi_StructuredClasses_CG() throws Throwable {
		//		Scheduler.DUMP_CLASS_TO_CONSUMING_NODES.setState(true);
		//		Scheduler.DUMP_CLASS_TO_CONTAINING_PROPERTIES.setState(true);
		//		Scheduler.DUMP_CLASS_TO_REALIZED_NODES.setState(true);
		//		Scheduler.DUMP_INPUT_MODEL_TO_DOMAIN_USAGE.setState(true);
		//		Scheduler.DUMP_PROPERTY_TO_CONSUMING_CLASSES.setState(true);
		//		Scheduler.EDGE_ORDER.setState(true);
		//		Scheduler.REGION_DEPTH.setState(true);
		//		Scheduler.REGION_ORDER.setState(true);
		//		Scheduler.REGION_TRAVERSAL.setState(true);
		//		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
		//		OperationDependencyAnalysis.FINISH.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT("StructuredClasses", getModelsURI("StructuredClasses/classescs2asV2.ocl"), "samples");
		try {
			myQVT.loadGenModels(getModelsURI("SimpleClasses/ClassesCS.genmodel"), getModelsURI("SimpleClasses/Classes.genmodel"));
			ImperativeTransformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("classescs2asV2.ocl");
			myQVT.assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 30 : 15);
			//			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 5);
			//			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 2);
			//			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
			CS2ASJavaCompilerParameters cgParams = createParameters(
				"example2.classes.lookup.util.ClassesLookupSolver",
					"example2.classes.lookup.util.ClassesLookupResult");
			Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl().compileTransformation(myQVT, qvtiTransf, cgParams);

			myQVT.dispose();
			myQVT = createQVT("StructuredClasses", getModelsURI("StructuredClasses/classescs2asV2.ocl"), "samples");
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/Classes.ecore"), example2.classes.ClassesPackage.eINSTANCE);
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/ClassesCS.ecore"), example2.classescs.ClassescsPackage.eINSTANCE);
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/classescs2as.ecore"), example2.classescstraces.ClassescstracesPackage.eINSTANCE);
			myQVT.executeModelsTX_CG(txClass, "model1V2");
			myQVT.executeModelsTX_CG(txClass, "model2V2");
			myQVT.executeModelsTX_CG(txClass, "model3V2");
			myQVT.executeModelsTX_CG(txClass, "model4V2");
		}
		finally {
			myQVT.dispose();
			EPackage.Registry.INSTANCE.remove(example2.classes.ClassesPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example2.classescs.ClassescsPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example2.classescstraces.ClassescstracesPackage.eNS_URI);
		}
	}

	@Test
	public void testOCL2QVTi_StructuredClasses_Interpreted() throws Throwable {
		//		OperationDependencyAnalysis.CALL.setState(true);
		//		OperationDependencyAnalysis.CREATE.setState(true);
		//		OperationDependencyAnalysis.FINISH.setState(true);
		//		OperationDependencyAnalysis.PENDING.setState(true);
		//		OperationDependencyAnalysis.REFINING.setState(true);
		//		OperationDependencyAnalysis.RETURN.setState(true);
		//		OperationDependencyAnalysis.START.setState(true);
		testCaseAppender.uninstall();	// Silence Log failures warning that *.ocl has *.ecore rather than http:// references
		MyQVT myQVT = createQVT("StructuredClasses", getModelsURI("StructuredClasses/classescs2asV2.ocl"), "samples");
		try {
			myQVT.loadGenModels(getModelsURI("SimpleClasses/ClassesCS.genmodel"), getModelsURI("SimpleClasses/Classes.genmodel"));

			Transformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("classescs2asV2.ocl");
			URI txURI = qvtiTransf.eResource().getURI();

			myQVT.dispose();
			myQVT = createQVT("StructuredClasses", getModelsURI("StructuredClasses/classescs2asV2.ocl"), "samples");
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/Classes.ecore"), example2.classes.ClassesPackage.eINSTANCE);
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/ClassesCS.ecore"), example2.classescs.ClassescsPackage.eINSTANCE);
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/classescs2as.ecore"), example2.classescstraces.ClassescstracesPackage.eINSTANCE);
			ImperativeTransformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), txURI);
			myQVT.executeModelsTX_Interpreted(tx, "model1V2");
			myQVT.executeModelsTX_Interpreted(tx, "model2V2");
			myQVT.executeModelsTX_Interpreted(tx, "model3V2");
			myQVT.executeModelsTX_Interpreted(tx, "model4V2");
		}
		finally {
			myQVT.dispose();
			EPackage.Registry.INSTANCE.remove(example2.classes.ClassesPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example2.classescs.ClassescsPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example2.classescstraces.ClassescstracesPackage.eNS_URI);
		}
	}

	//  Note supported anymore
	//	@Test
	//	public void testExample2_OCL2QVTm_MiddleModel() throws Exception {
	//		MyQVT myQVT = createQVT("example2");
	//		URI baseURI = TESTS_BASE_URI.appendSegment("example2");
	//		URI oclDocURI = baseURI.appendSegment("classescs2as.ocl.oclas");
	//		URI qvtmFileURI = baseURI.appendSegment("classescs2as.qvtm.qvtcas");
	//		URI tracesMMURI = baseURI.appendSegment("classescs2as.ecore.oclas");
	//
	//		OCL2QVTiBrokerTester mtc = new OCL2QVTiBrokerTester(baseURI, "classescs2as.ocl", myQVT, false);
	//		mtc.runOCL2QVTm_MiddleModel(oclDocURI, qvtmFileURI, tracesMMURI);
	//		// Test the QVTm transformation can be loaded
	//		assertValidQVTiModel(qvtmFileURI);
	//		myQVT.dispose();
	//	}

	@Test
	public void testOCL2QVTi_SimpleClasses_OCL2QVTm_MiddleFolded() throws Exception {
		MyQVT myQVT = createQVT("SimpleClasses", getModelsURI("SimpleClasses/classescs2as.ocl"), "samples");
		URI oclDocURI = getModelsURI("SimpleClasses/classescs2as.ocl");
		URI qvtmFileURI = getTestURI("classescs2as.qvtm.qvtcas");
		OCL2QVTiCompilerChain mtc = new OCL2QVTiCompilerChain(myQVT, createCompilerOptions(), oclDocURI, getTestURIWithExtension(oclDocURI, "tmp"));
		mtc.ocl2qvtmCompilerStep.ocl2qvtm(oclDocURI.appendFileExtension("oclas"));
		// Test the QVTm transformation can be loaded
		assertValidQVTiModel(qvtmFileURI);
		myQVT.dispose();
	}

	@Test
	public void testOCL2QVTi_KiamaRewrite_CG() throws Throwable {
		//		Scheduler.CONNECTION_CREATION.setState(true);
		//		Scheduler.CONNECTION_ROUTING.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		Scheduler.EDGE_ORDER.setState(true);
		//		Scheduler.REGION_CYCLES.setState(true);
		//		Scheduler.REGION_DEPTH.setState(true);
		//		Scheduler.REGION_ORDER.setState(true);
		//		Scheduler.REGION_STACK.setState(true);
		//		TransformationPartitioner.CYCLES.setState(true);
		//		TransformationPartitioner.PREDECESSORS.setState(true);
		//		TransformationPartitioner.SUCCESSORS.setState(true);
		//		TransformationPartitioner.PARALLEL_SCHEDULE.setState(true);
		//		TransformationPartitioner.PROPERTY_NOTIFY.setState(true);
		//		TransformationPartitioner.PROPERTY_OBSERVE.setState(true);
		//		QVTiProductionConsumption.SUMMARY.setState(true);
		MyQVT myQVT = createQVT("KiamaRewrite", getModelsURI("KiamaRewrite/KiamaRewrite.ocl"), "samples");
		try {
			myQVT.loadGenModels(getModelsURI("KiamaRewrite/KiamaAS.genmodel"), getModelsURI("KiamaRewrite/KiamaCS.genmodel"));
			ImperativeTransformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("KiamaRewrite.ocl");
			myQVT.assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 11 : 6);
			//		myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 1);
			//		myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 1);
			//		myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
			CS2ASJavaCompilerParameters cgParams = createParameters("","");
			Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl().compileTransformation(myQVT, qvtiTransf, cgParams);
			//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
			// FIXME BUG 484278 model0 has an invalid model TopCS.node[1] has a null value.
			//		executeModelsTX_CG(myQVT, txClass, testBaseURI, "model0");
			myQVT.executeModelsTX_CG(txClass, "model1");
		}
		finally {
			myQVT.dispose();
			EPackage.Registry.INSTANCE.remove(example3.kiamaas.KiamaasPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example3.kiamacs.KiamacsPackage.eNS_URI);
		}
	}

	/*	@Test
	public void testExample3_CG2() throws Exception {
		EPackage.Registry.INSTANCE.put(example3.kiamaas.KiamaasPackage.eNS_URI, example3.kiamaas.KiamaasPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(example3.kiamacs.KiamacsPackage.eNS_URI, example3.kiamacs.KiamacsPackage.eINSTANCE);
		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT("example3");
		Class<? extends Transformer> txClass = KiamaRewrite_qvtm_qvtcas.class;
		myQVT.executeModelsTX_CG(txClass, "model1");
		myQVT.dispose();
		EPackage.Registry.INSTANCE.remove(example3.kiamaas.KiamaasPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example3.kiamacs.KiamacsPackage.eNS_URI);
	} */

	@Test
	public void testOCL2QVTi_KiamaRewrite_Interpreted() throws Throwable {
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT("KiamaRewrite", getModelsURI("KiamaRewrite/KiamaRewrite.ocl"), "samples");
		myQVT.loadGenModels(getModelsURI("KiamaRewrite/KiamaAS.genmodel"), getModelsURI("KiamaRewrite/KiamaCS.genmodel"));
		ImperativeTransformation tx = myQVT.executeOCL2QVTi_CompilerChain("KiamaRewrite.ocl");
		myQVT.executeModelsTX_Interpreted(tx, "model1");
		myQVT.dispose();
	}

	@Test
	public void testOCL2QVTi_SimplerKiama_CG() throws Throwable {
		//		CommonSubexpressionEliminator.CSE_BUILD.setState(true);
		//		CommonSubexpressionEliminator.CSE_PLACES.setState(true);
		//		CommonSubexpressionEliminator.CSE_PRUNE.setState(true);
		//		CommonSubexpressionEliminator.CSE_PULL_UP.setState(true);
		//		CommonSubexpressionEliminator.CSE_PUSH_UP.setState(true);
		//		CommonSubexpressionEliminator.CSE_REWRITE.setState(true);
		//		Scheduler.EDGE_ORDER.setState(true);
		//		Scheduler.REGION_DEPTH.setState(true);
		//		Scheduler.REGION_ORDER.setState(true);
		//		Scheduler.REGION_TRAVERSAL.setState(true);
		//		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//		TransformationPartitioner.PARALLEL_SCHEDULE.setState(true);
		//		TransformationPartitioner.PROPERTY_NOTIFY.setState(true);
		//		TransformationPartitioner.PROPERTY_OBSERVE.setState(true);
		//		QVTiProductionConsumption.SUMMARY.setState(true);
		MyQVT myQVT = createQVT("SimplerKiama", getModelsURI("SimplerKiama/SimplerKiama.ocl"), "samples");
		try {
			myQVT.loadGenModels(getModelsURI("SimplerKiama/SimplerKiamaAS.genmodel"), getModelsURI("SimplerKiama/SimplerKiamaCS.genmodel"));
			ImperativeTransformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("SimplerKiama.ocl");
			myQVT.assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 9 : 7);
			//		myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 1);
			//		myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 0);
			//		myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
			CS2ASJavaCompilerParameters cgParams = createParameters("","");
			Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl().compileTransformation(myQVT, qvtiTransf, cgParams);
			//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
			// FIXME BUG 484278 model0 has an invalid model TopCS.node[1] has a null value.
			//		executeModelsTX_CG(myQVT, txClass, testBaseURI, "model0");
			myQVT.executeModelsTX_CG(txClass, "model1");
			myQVT.executeModelsTX_CG(txClass, "model2");
			myQVT.executeModelsTX_CG(txClass, "model3");
		}
		finally {
			myQVT.dispose();
			EPackage.Registry.INSTANCE.remove(example4.kiamacs.KiamacsPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example4.kiamaas.KiamaasPackage.eNS_URI);
		}
	}

	@Test
	public void testOCL2QVTi_SimplerKiama_Interpreted() throws Throwable {
		MyQVT myQVT = createQVT("SimplerKiama", getModelsURI("SimplerKiama/SimplerKiama.ocl"), "samples");
		myQVT.loadGenModels(getModelsURI("SimplerKiama/SimplerKiamaAS.genmodel"), getModelsURI("SimplerKiama/SimplerKiamaCS.genmodel"));
		ImperativeTransformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("SimplerKiama.ocl");
		URI txURI = qvtiTransf.eResource().getURI();
		myQVT.dispose();
		//
		myQVT = createQVT("SimplerKiama", getModelsURI("SimplerKiama/SimplerKiama.ocl"), "samples");
		ImperativeTransformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), txURI);
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		// FIXME BUG 484278 model0 has an invalid model TopCS.node[1] has a null value.
		//    	executeModelsTX_Interpreted(myQVT, qvtiTransf, baseURI, "model0");
		myQVT.executeModelsTX_Interpreted(tx, "model1");
		myQVT.executeModelsTX_Interpreted(tx, "model2");
		myQVT.executeModelsTX_Interpreted(tx, "model3");
		myQVT.dispose();
	}

	@Test
	public void testOCL2QVTi_BaseAndDerived_CG() throws Throwable {
		MyQVT myQVT = createQVT("BaseAndDerived", getModelsURI("BaseAndDerived/Source2TargetBase.ocl"), "samples");
		try {
			myQVT.loadGenModels(getModelsURI("BaseAndDerived/SourceBaseMM.genmodel"), getModelsURI("BaseAndDerived/TargetBaseMM.genmodel"));
			ImperativeTransformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("Source2TargetBase.ocl");
			myQVT.assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 9 : 5);
			//		myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 2);
			//		myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 0);
			//		myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
			CS2ASJavaCompilerParameters cgParams = createParameters("", "");
			Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl()
					.compileTransformation(myQVT, qvtiTransf, cgParams);

			// Execute CGed transformation
			myQVT.executeModelsTX_CG(txClass, "model1");

			myQVT.dispose();
			myQVT = createQVT("BaseAndDerived", getModelsURI("BaseAndDerived/Source2TargetDerived.ocl"), "samples");
			myQVT.loadGenModels(getModelsURI("BaseAndDerived/SourceBaseMM.genmodel"), getModelsURI("BaseAndDerived/TargetBaseMM.genmodel"),
				getModelsURI("BaseAndDerived/SourceDerivedMM.genmodel"), getModelsURI("BaseAndDerived/TargetDerivedMM.genmodel"));

			qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("Source2TargetDerived.ocl",
					"Source2TargetBase.ocl");
			txClass = new CS2ASJavaCompilerImpl()
					.compileTransformation(myQVT, qvtiTransf, cgParams);

			// Execute CGed transformation
			myQVT.executeModelsTX_CG(txClass, "model2");
		}
		finally {
			myQVT.dispose();
			EPackage.Registry.INSTANCE.remove(example5.sbase.SbasePackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example5.sderived.SderivedPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example5.tbase.TbasePackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example5.tderived.TderivedPackage.eNS_URI);
		}
	}

	@Test
	public void testOCL2QVTi_BaseAndDerived_Interpreted() throws Throwable {
		MyQVT myQVT = createQVT("BaseAndDerived", getModelsURI("BaseAndDerived/Source2TargetBase.ocl"), "samples");
		myQVT.loadGenModels(getModelsURI("BaseAndDerived/SourceBaseMM.genmodel"), getModelsURI("BaseAndDerived/TargetBaseMM.genmodel"));
		ImperativeTransformation tx = myQVT.executeOCL2QVTi_CompilerChain("Source2TargetBase.ocl");
		myQVT.executeModelsTX_Interpreted(tx, "model1");

		myQVT.dispose();
		myQVT = createQVT("BaseAndDerived", getModelsURI("BaseAndDerived/Source2TargetBase.ocl"), "samples");

		myQVT.loadGenModels(getModelsURI("BaseAndDerived/SourceBaseMM.genmodel"), getModelsURI("BaseAndDerived/TargetBaseMM.genmodel"),
			getModelsURI("BaseAndDerived/SourceDerivedMM.genmodel"), getModelsURI("BaseAndDerived/TargetDerivedMM.genmodel"));
		tx = myQVT.executeOCL2QVTi_CompilerChain("Source2TargetDerived.ocl", "Source2TargetBase.ocl");
		myQVT.executeModelsTX_Interpreted(tx, "model2");
		myQVT.dispose();
	}

	/*
	protected static void assertValidModel(@NonNull URI asURI) {
		EnvironmentFactory factory =  OCL.createEnvironmentFactory(new StandaloneProjectMap());
        ResourceSet asResourceSet = factory.getResourceSet();
        // MetaModelManager.initializeASResourceSet(asResourceSet);
        assertValidModel(asURI, asResourceSet);
	}
	 */
	protected static void assertValidModel(URI asURI, ResourceSet rSet) {
		Resource resource = rSet.getResource(asURI, true);
		EcoreUtil.resolveAll(resource);

		String rUriString = resource.getURI().toString();
		assertNoUnresolvedProxies("Validating a resource: " + rUriString, resource);
		assertNoResourceErrors("Loading a resource" + rUriString, resource);
		//assertNoValidationErrors("Loading a resource" + rUriString, resource);
	}


	protected static void assertValidQVTiModel(@NonNull URI asURI) {

		// We don't generate QVTi models anymore. Perhaps do a QVTc validation if there is a QVTcore.ocl file
	}

	protected @NonNull ImperativeTransformation getTransformation(ResourceSet rSet, URI qvtiURI) {

		Resource resource = rSet.getResource(qvtiURI, true);
		for (EObject eObject : resource.getContents()) {
			if (eObject instanceof ImperativeModel) {
				for (org.eclipse.ocl.pivot.Package pPackage : ((ImperativeModel)eObject).getOwnedPackages()) {
					for (org.eclipse.ocl.pivot.Class pClass : pPackage.getOwnedClasses()) {
						if (pClass instanceof ImperativeTransformation) {
							return  (ImperativeTransformation) pClass;
						}
					}
				}
			}
		}
		throw new IllegalStateException("No transformation");
	}

	// FIXME move following clones to a Util class
	protected static @NonNull XtextResource pivot2cs(@NonNull OCL ocl, @NonNull ResourceSet resourceSet, @NonNull ASResource asResource, @NonNull URI outputURI) throws IOException {
		XtextResource xtextResource = ClassUtil.nonNullState((XtextResource) resourceSet.createResource(outputURI, QVTimperativeCSPackage.eCONTENT_TYPE));
		ocl.as2cs(asResource, (CSResource) xtextResource);
		assertNoResourceErrors("Conversion failed", xtextResource);
		assertNoDiagnosticErrors("Concrete Syntax validation failed", xtextResource);
		try {
			xtextResource.save(DefaultCompilerOptions.defaultSavingOptions);
		}
		catch (Exception e) {
			e.printStackTrace();
			URI xmiURI = outputURI.appendFileExtension(".xmi");
			Resource xmiResource = resourceSet.createResource(xmiURI);
			xmiResource.getContents().addAll(ClassUtil.nullFree(xtextResource.getContents()));
			xmiResource.save(DefaultCompilerOptions.defaultSavingOptions);
			fail(e.toString());
		}
		return xtextResource;
	}

	protected XtextResource doSerialize(@NonNull URI inputURI, @NonNull URI serializedURI) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		//
		//	Load QVTcAS
		//
		OCL ocl = QVTbase.newInstance(getTestProjectManager());
		try {
			ASResource asResource = loadQVTiAS(ocl, inputURI);
			assertNoResourceErrors("Normalisation failed", asResource);
			assertNoUnresolvedProxies("Normalisation invalid", asResource);
			assertNoValidationErrors("Normalisation invalid", asResource);
			//
			//	Pivot to CS
			//
			XtextResource xtextResource = pivot2cs(ocl, resourceSet, asResource, serializedURI);
			resourceSet.getResources().clear();
			return xtextResource;
		}
		finally {
			ocl.dispose();
			ocl = null;
		}
	}


	protected static @NonNull ASResource loadQVTiAS(@NonNull OCL ocl, @NonNull URI inputURI) {
		Resource asResource = ocl.getMetamodelManager().getASResourceSet().getResource(inputURI, true);
		assert asResource != null;
		//		List<String> conversionErrors = new ArrayList<String>();
		//		RootPackageCS documentCS = Ecore2OCLinEcore.importFromEcore(resourceSet, null, ecoreResource);
		//		Resource eResource = documentCS.eResource();
		assertNoResourceErrors("Load failed", asResource);
		//		Resource xtextResource = resourceSet.createResource(outputURI, OCLinEcoreCSTPackage.eCONTENT_TYPE);
		//		XtextResource xtextResource = (XtextResource) resourceSet.createResource(outputURI);
		//		xtextResource.getContents().add(documentCS);
		return (ASResource) asResource;
	}



}
