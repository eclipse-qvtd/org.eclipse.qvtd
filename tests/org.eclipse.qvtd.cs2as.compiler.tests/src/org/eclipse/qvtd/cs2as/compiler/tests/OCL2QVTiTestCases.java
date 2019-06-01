/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations Ltd., University of York and others.
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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystemHelper;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.qvtd.compiler.AbstractCompilerOptions;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.cs2as.compiler.CS2ASJavaCompilerParameters;
import org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerImpl;
import org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerParametersImpl;
import org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTiCompilerChain;
import org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTm;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiIncrementalExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.QVTbaseTestFileSystemHelper;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.xtext.resource.XtextResource;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import example2.classes.ClassesPackage;
import example2.classescs.ClassescsPackage;
import example5.sbase.SbasePackage;
import example5.sderived.SderivedPackage;
import example5.tbase.TbasePackage;
import example5.tderived.TderivedPackage;

// Manual load tests rely on previous generation of the class to load. - testExample1_CGManual
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OCL2QVTiTestCases extends LoadTestCase
{
	//	private static final boolean CREATE_GRAPHML = false; // Note. You need Epsilon with Bug 458724 fix to have output graphml models serialised
	private static boolean NO_MERGES = true;				// Set true to suppress the complexities of merging

	protected class MyQVT extends QVTimperative
	{
		private final @NonNull Map<@NonNull Class<? extends Partition>, @NonNull Integer> partitionClass2count = new HashMap<>();
		protected final @NonNull String modelTestName;
		protected final @NonNull String modelSamples;

		public MyQVT(@NonNull ProjectManager projectManager, @NonNull String modelTestName, @NonNull String modelSamples) {
			super(new QVTiEnvironmentFactory(projectManager, null));
			this.modelTestName = modelTestName;
			this.modelSamples = modelSamples;
			//			this.testName = testName;
			//			this.baseURI = TESTS_BASE_URI.appendSegment(testName);
			//
			// http://www.eclipse.org/emf/2002/Ecore is referenced by just about any model load
			// Ecore.core is referenced from Ecore.genmodel that is used by the CG to coordinate Ecore objects with their Java classes
			// therefore suppress diagnostics about confusing usage.
			//
			getProjectManager().configureLoadFirst(getResourceSet(), EcorePackage.eNS_URI);
		}

		//	public void assertRegionCount(@NonNull Class<? extends Region> regionClass, @NonNull Integer count) {
		//		assertEquals("Region " + regionClass.getSimpleName() + " count:", count != 0 ? count : null, regionClass2count.get(regionClass));
		//	}
		public void assertRegionCount(@NonNull Class<? extends Region> partitionClass, int count) {
			QVTruntimeUtil.errPrintln("assertRegionCount suppressed");
		}

		//
		// Execute the transformation with the code generator
		//
		protected void executeModelsTX_CG(@NonNull Class<? extends Transformer> txClass, @NonNull String modelName) throws Exception {
			TransformationExecutor evaluator = new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);
			Transformer tx = evaluator.getTransformer();
			URI modelNamePrefix = getModelsURI(modelTestName + "/" + modelSamples + "/");
			URI csModelURI = modelNamePrefix.appendSegment(modelName + "_input.xmi");
			URI asModelURI = getTestURI(modelName + "_output_CG.xmi");
			URI expectedAsModelURI = modelNamePrefix.appendSegment(modelName + "_output_ref.xmi");
			saveEmptyModel(asModelURI);

			ResourceSet rSet = getResourceSet();
			Resource inputResource = rSet.getResource(csModelURI, true);
			tx.addRootObjects(OCL2QVTm.LEFT_MODEL_TYPE_NAME, ClassUtil.nonNullState(inputResource.getContents()));
			assertTrue(tx.run());
			Resource outputResource = rSet.createResource(asModelURI);
			outputResource.getContents().addAll(tx.getRootEObjects("rightAS"));
			outputResource.save(DefaultCompilerOptions.defaultSavingOptions);

			Resource expected =  rSet.getResource(expectedAsModelURI, true);
			Resource actual = rSet.getResource(asModelURI, true);
			assert (expected != null) && (actual != null);
			assertSameModel(expected, actual);
		}

		//
		// Execute the transformation with the CGed transformation
		//

		protected void executeModelsTX_Interpreted(@NonNull ImperativeTransformation tx, @NonNull String modelName) throws Exception {
			URI modelNamePrefix = getModelsURI(modelTestName + "/" + modelSamples);
			URI csModelURI = modelNamePrefix.appendSegment(modelName + "_input.xmi");
			URI asModelURI = getTestURI(modelName + "_output_Interpreted.xmi");
			URI expectedAsModelURI = modelNamePrefix.appendSegment(modelName + "_output_ref.xmi");
			saveEmptyModel(asModelURI);

			BasicQVTiExecutor testEvaluator = new QVTiIncrementalExecutor(getEnvironmentFactory(), tx, QVTiIncrementalExecutor.Mode.LAZY);
			//testEvaluator.saveTransformation(null);
			testEvaluator.loadModel(OCL2QVTm.LEFT_MODEL_TYPE_NAME, csModelURI);
			testEvaluator.createModel(OCL2QVTm.RIGHT_MODEL_TYPE_NAME, asModelURI, null);
			boolean success = testEvaluator.execute();
			testEvaluator.saveModels(DefaultCompilerOptions.defaultSavingOptions);
			testEvaluator.dispose();
			assertTrue(success);
			ResourceSet rSet = getResourceSet();
			Resource expected =  rSet.getResource(expectedAsModelURI, true);
			Resource actual = rSet.getResource(asModelURI, true);
			assert (expected != null) && (actual != null);
			assertSameModel(expected, actual);
		}

		protected @NonNull ImperativeTransformation executeOCL2QVTi_CompilerChain(@NonNull String mainOclDoc, @NonNull String... extendedOclDocs) throws IOException {
			URI mainOclDocURI = getModelsURI(modelTestName + "/" + mainOclDoc);
			@NonNull URI[] oclDocURIs = new @NonNull URI[extendedOclDocs.length];
			for (int i=0; i < extendedOclDocs.length; i++) {
				oclDocURIs[i] = getModelsURI(modelTestName + "/" + extendedOclDocs[i]);
			}
			OCL2QVTiCompilerChain compiler = new OCL2QVTiCompilerChain(this, createTestCasesCompilerOptions(), mainOclDocURI, getTestURIWithExtension(mainOclDocURI, null), oclDocURIs)
			{
				@Override
				protected @NonNull QVTm2QVTsCompilerStep createQVTm2QVTsCompilerStep() {
					return new QVTm2QVTsCompilerStep(this)
					{
						@Override
						public @NonNull ScheduleManager execute(@NonNull Resource pResource) throws IOException {
							ScheduleManager scheduleManager = super.execute(pResource);
							instrumentPartition(scheduleManager);
							return scheduleManager;
						}
					};
				}
			};
			ImperativeTransformation qvtiTransf = compiler.compile();
			URI txURI = qvtiTransf.eResource().getURI();
			if (txURI != null) {
				URI inputURI = txURI;
				URI serializedURI = getTestURIWithExtension(inputURI, "serialized.qvti");
				doSerialize(inputURI, serializedURI);
			}
			return qvtiTransf;
		}


		protected void instrumentPartition(@NonNull ScheduleManager scheduleManager) {
			ScheduleModel scheduleModel = scheduleManager.getScheduleModel();
			for (@NonNull RootRegion rootRegion : QVTscheduleUtil.getOwnedRootRegions(scheduleModel)) {
				RootPartitionAnalysis rootPartitionAnalysis = scheduleManager.getRootPartitionAnalysis(rootRegion);
				instrumentPartition(scheduleManager, rootPartitionAnalysis.getPartition());
			}
		}

		protected void instrumentPartition(@NonNull ScheduleManager scheduleManager, @NonNull Partition parentPartition) {
			Class<? extends @NonNull Partition> partitionClass = parentPartition.getClass();
			Integer count = partitionClass2count.get(partitionClass);
			partitionClass2count.put(partitionClass, count == null ? 1 : count+1);
			for (@NonNull Partition childPartition : scheduleManager.getConnectionManager().getCallableChildren(parentPartition)) {
				instrumentPartition(scheduleManager, childPartition);
			}
		}

		protected void loadEcoreFile(@NonNull String ecoreFileName, EPackage ePackage) {
			URI fileURI = getModelsURI(modelTestName + "/" + ecoreFileName);
			loadEcoreFile(fileURI, ePackage);
		}

		public void loadEcoreFile(@NonNull URI fileURI, EPackage ePackage) {
			ResourceSet rSet = getResourceSet();
			rSet.getPackageRegistry().put(fileURI.toString(), ePackage);
			rSet.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
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

		protected void loadGenModels(@NonNull URI ... genModelURIs) {
			if (genModelURIs != null) {
				for (@NonNull URI genModelURI : genModelURIs) {
					loadGenModel(genModelURI);
				}
			}
		}

		protected void loadGenModels(String... genModelNames) {
			if (genModelNames != null) {
				for (String genModelName : genModelNames) {
					loadGenModel(getModelsURI(modelTestName + "/" + genModelName));
				}
			}
		}

		// QVTiPivotEvaluator only saves models when something is created. If the transformation
		// does nothing and nothing is created, the output model is not saved. Then I have to ensure
		// that an empty model is serialized for the sake of the of the test cases results. The comparison
		// between output model and the reference one, might be done with a previous output model
		// TODO report QVTd bug
		protected void saveEmptyModel(@NonNull  URI modelURI) throws IOException {
			ResourceSet rSet = new ResourceSetImpl();
			environmentFactory.getProjectManager().initializeResourceSet(rSet);
			Resource r = rSet.createResource(modelURI);
			r.save(DefaultCompilerOptions.defaultSavingOptions);
		}

		protected  @NonNull CompilerOptions createTestCasesCompilerOptions() {
			CompilerOptions options = createCompilerOptions();
			options.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.SAVE_OPTIONS_KEY, DefaultCompilerOptions.defaultSavingOptions);
			options.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.DEBUG_KEY, true);
			// TODO problem when validating options.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.VALIDATE_KEY, true);
			options.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_EARLY_MERGE, NO_MERGES);
			options.setOption(CompilerChain.QVTS_STEP, CompilerChain.SCHEDULER_NO_LATE_CONSUMER_MERGE, NO_MERGES);
			return options;
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

	private @NonNull MyQVT createQVT(@NonNull String modelTestName, @NonNull String modelSamples) throws Exception {
		return new MyQVT(getTestProjectManager(), modelTestName, modelSamples);
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
	public void testOCL2QVTi_Source2Target_CG() throws Exception {
		//		OperationDependencyAnalysis.CALL.setState(true);
		//		OperationDependencyAnalysis.CREATE.setState(true);
		//		OperationDependencyAnalysis.FINISH.setState(true);
		//		OperationDependencyAnalysis.PENDING.setState(true);
		//		OperationDependencyAnalysis.REFINING.setState(true);
		//		OperationDependencyAnalysis.RETURN.setState(true);
		//		OperationDependencyAnalysis.START.setState(true);
		MyQVT myQVT = createQVT("Source2Target", "samples");
		myQVT.loadGenModels("SourceMM1.genmodel", "TargetMM1.genmodel");
		myQVT.loadEcoreFile("EnvExample1.ecore", example1.target.lookup.EnvironmentPackage.eINSTANCE);
		Transformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("Source2Target.ocl");
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
		myQVT.dispose();
		EPackage.Registry.INSTANCE.remove(example1.source.SourcePackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example1.target.TargetPackage.eNS_URI);
	}

	/*	@Test
	public void testOCL2QVTi_Source2Target_CGManual() throws Exception {
		MyQVT myQVT = createQVT("Source2Target", "samples");
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
	public void testOCL2QVTi_Source2Target_Interpreted() throws Exception {
		testCaseAppender.uninstall();			// Silence Log failures warning that *.ocl has *.ecore rather than http:// references
		MyQVT myQVT = createQVT("Source2Target", "samples");
		try {
			myQVT.loadGenModels("SourceMM1.genmodel", "TargetMM1.genmodel");

			Transformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("Source2Target.ocl");
			URI txURI = qvtiTransf.eResource().getURI();

			myQVT.dispose();
			myQVT = createQVT("Source2Target", "samples");
			myQVT.loadEcoreFile("SourceMM1.ecore", example1.source.SourcePackage.eINSTANCE);
			myQVT.loadEcoreFile("TargetMM1.ecore", example1.target.TargetPackage.eINSTANCE);
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
		MyQVT myQVT = createQVT("Source2Target", "samples");
		URI oclDocURI = getModelsURI("Source2Target/Source2Target.ocl");
		URI qvtmFileURI = getTestURI("Source2Target.qvtm.qvtcas");

		OCL2QVTiCompilerChain mtc = new OCL2QVTiCompilerChain(myQVT, createCompilerOptions(), oclDocURI, getTestURIWithExtension(oclDocURI, "tmp"));
		mtc.ocl2qvtmCompilerStep.ocl2qvtm(oclDocURI.appendFileExtension("oclas"));
		// Test the QVTm transformation can be loaded
		assertValidQVTiModel(qvtmFileURI);
		myQVT.dispose();
	}

	@Test
	public void testOCL2QVTi_SimpleClasses_CG() throws Exception {
		//		Scheduler.EDGE_ORDER.setState(true);
		//		Scheduler.REGION_DEPTH.setState(true);
		//		Scheduler.REGION_ORDER.setState(true);
		//		Scheduler.REGION_TRAVERSAL.setState(true);
		//		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
		//		Scheduler.DEPENDENCY_ANALYSIS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//		TransformationPartitioner.CYCLES.setState(true);
		MyQVT myQVT = createQVT("SimpleClasses", "samples");
		try {
			myQVT.loadGenModels("ClassesCS.genmodel", "Classes.genmodel");
			myQVT.loadEcoreFile("EnvExample2.ecore", example2.classes.lookup.EnvironmentPackage.eINSTANCE);
			Transformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("classescs2as.ocl");
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
			EPackage.Registry.INSTANCE.remove(example2.classes.ClassesPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example2.classescs.ClassescsPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(example2.classescstraces.ClassescstracesPackage.eNS_URI);
		}
	}

	@Test
	public void testOCL2QVTi_SimpleClasses_Interpreted() throws Exception {
		//		OperationDependencyAnalysis.CALL.setState(true);
		//		OperationDependencyAnalysis.CREATE.setState(true);
		//		OperationDependencyAnalysis.FINISH.setState(true);
		//		OperationDependencyAnalysis.HYPOTHECATING.setState(true);
		//		OperationDependencyAnalysis.PENDING.setState(true);
		//		OperationDependencyAnalysis.REFINING.setState(true);
		//		OperationDependencyAnalysis.RETURN.setState(true);
		//		OperationDependencyAnalysis.START.setState(true);
		testCaseAppender.uninstall();			// Silence Log failures warning that *.ocl has *.ecore rather than http:// references
		MyQVT myQVT = createQVT("SimpleClasses", "samples");
		myQVT.loadGenModels("ClassesCS.genmodel", "Classes.genmodel");

		Transformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("classescs2as.ocl");
		URI txURI = qvtiTransf.eResource().getURI();

		myQVT.dispose();
		myQVT = createQVT("SimpleClasses", "samples");
		myQVT.loadEcoreFile("ClassesCS.ecore", ClassescsPackage.eINSTANCE);
		myQVT.loadEcoreFile("Classes.ecore", ClassesPackage.eINSTANCE);
		ImperativeTransformation tx = getTransformation(myQVT.getMetamodelManager().getASResourceSet(), txURI);
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		myQVT.executeModelsTX_Interpreted(tx, "model1");
		myQVT.executeModelsTX_Interpreted(tx, "model2");
		myQVT.executeModelsTX_Interpreted(tx, "model3");
		//    	myQVT.executeModelsTX_Interpreted(tx, "model4");
		//    	myQVT.executeModelsTX_Interpreted(tx, "model5");
		//    	myQVT.executeModelsTX_Interpreted(tx, "model6");
		//    	myQVT.executeModelsTX_Interpreted(tx, "model7");
		myQVT.dispose();
	}

	@Test
	public void testOCL2QVTi_StructuredClasses_CG() throws Exception {
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
		MyQVT myQVT = createQVT("StructuredClasses", "samples");
		try {
			myQVT.loadGenModels(getModelsURI("SimpleClasses/ClassesCS.genmodel"), getModelsURI("SimpleClasses/Classes.genmodel"));
			Transformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("classescs2asV2.ocl");
			myQVT.assertRegionCount(RuleRegionImpl.class, NO_MERGES ? 30 : 15);
			//			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, NO_MERGES ? 0 : 5);
			//			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, NO_MERGES ? 0 : 2);
			//			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 0);
			CS2ASJavaCompilerParameters cgParams = createParameters(
				"example2.classes.lookup.util.ClassesLookupSolver",
					"example2.classes.lookup.util.ClassesLookupResult");
			Class<? extends Transformer> txClass = new CS2ASJavaCompilerImpl().compileTransformation(myQVT, qvtiTransf, cgParams);

			myQVT.dispose();
			myQVT = createQVT("StructuredClasses", "samples");
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/ClassesCS.ecore"), example2.classescs.ClassescsPackage.eINSTANCE);
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/Classes.ecore"), example2.classes.ClassesPackage.eINSTANCE);

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
	public void testOCL2QVTi_StructuredClasses_Interpreted() throws Exception {
		//		OperationDependencyAnalysis.CALL.setState(true);
		//		OperationDependencyAnalysis.CREATE.setState(true);
		//		OperationDependencyAnalysis.FINISH.setState(true);
		//		OperationDependencyAnalysis.PENDING.setState(true);
		//		OperationDependencyAnalysis.REFINING.setState(true);
		//		OperationDependencyAnalysis.RETURN.setState(true);
		//		OperationDependencyAnalysis.START.setState(true);
		testCaseAppender.uninstall();	// Silence Log failures warning that *.ocl has *.ecore rather than http:// references
		MyQVT myQVT = createQVT("StructuredClasses", "samples");
		try {
			myQVT.loadGenModels(getModelsURI("SimpleClasses/ClassesCS.genmodel"), getModelsURI("SimpleClasses/Classes.genmodel"));

			Transformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("classescs2asV2.ocl");
			URI txURI = qvtiTransf.eResource().getURI();

			myQVT.dispose();
			myQVT = createQVT("StructuredClasses", "samples");
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/ClassesCS.ecore"), example2.classescs.ClassescsPackage.eINSTANCE);
			myQVT.loadEcoreFile(getModelsURI("SimpleClasses/Classes.ecore"), example2.classes.ClassesPackage.eINSTANCE);
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
		MyQVT myQVT = createQVT("SimpleClasses", "samples");
		URI oclDocURI = getModelsURI("SimpleClasses/classescs2as.ocl");
		URI qvtmFileURI = getTestURI("classescs2as.qvtm.qvtcas");
		OCL2QVTiCompilerChain mtc = new OCL2QVTiCompilerChain(myQVT, createCompilerOptions(), oclDocURI, getTestURIWithExtension(oclDocURI, "tmp"));
		mtc.ocl2qvtmCompilerStep.ocl2qvtm(oclDocURI.appendFileExtension("oclas"));
		// Test the QVTm transformation can be loaded
		assertValidQVTiModel(qvtmFileURI);
		myQVT.dispose();
	}

	@Test
	public void testOCL2QVTi_KiamaRewrite_CG() throws Exception {
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
		MyQVT myQVT = createQVT("KiamaRewrite", "samples");
		myQVT.loadGenModels("KiamaAS.genmodel", "KiamaCS.genmodel");
		Transformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("KiamaRewrite.ocl");
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
		myQVT.dispose();
		EPackage.Registry.INSTANCE.remove(example3.kiamaas.KiamaasPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example3.kiamacs.KiamacsPackage.eNS_URI);
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
	public void testOCL2QVTi_KiamaRewrite_Interpreted() throws Exception {
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT("KiamaRewrite", "samples");
		myQVT.loadGenModels("KiamaAS.genmodel", "KiamaCS.genmodel");
		ImperativeTransformation tx = myQVT.executeOCL2QVTi_CompilerChain("KiamaRewrite.ocl");
		myQVT.executeModelsTX_Interpreted(tx, "model1");
		myQVT.dispose();
	}

	@Test
	public void testOCL2QVTi_SimplerKiama_CG() throws Exception {
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
		MyQVT myQVT = createQVT("SimplerKiama", "samples");
		myQVT.loadGenModels("SimplerKiamaAS.genmodel", "SimplerKiamaCS.genmodel");
		Transformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("SimplerKiama.ocl");
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
		myQVT.dispose();
		EPackage.Registry.INSTANCE.remove(example4.kiamacs.KiamacsPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(example4.kiamaas.KiamaasPackage.eNS_URI);
	}

	@Test
	public void testOCL2QVTi_SimplerKiama_Interpreted() throws Exception {
		MyQVT myQVT = createQVT("SimplerKiama", "samples");
		myQVT.loadGenModels("SimplerKiamaAS.genmodel", "SimplerKiamaCS.genmodel");
		ImperativeTransformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("SimplerKiama.ocl");
		URI txURI = qvtiTransf.eResource().getURI();
		myQVT.dispose();
		//
		myQVT = createQVT("SimplerKiama", "samples");
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
	public void testOCL2QVTi_BaseAndDerived_CG() throws Exception {
		MyQVT myQVT = createQVT("BaseAndDerived", "samples");
		myQVT.loadGenModels("SourceBaseMM.genmodel", "TargetBaseMM.genmodel");
		Transformation qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("Source2TargetBase.ocl");
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
		myQVT = createQVT("BaseAndDerived", "samples");
		myQVT.loadGenModels("SourceBaseMM.genmodel", "TargetBaseMM.genmodel",
			"SourceDerivedMM.genmodel", "TargetDerivedMM.genmodel");

		qvtiTransf = myQVT.executeOCL2QVTi_CompilerChain("Source2TargetDerived.ocl",
				"Source2TargetBase.ocl");
		txClass = new CS2ASJavaCompilerImpl()
				.compileTransformation(myQVT, qvtiTransf, cgParams);

		// Execute CGed transformation
		myQVT.executeModelsTX_CG(txClass, "model2");
		myQVT.dispose();
		EPackage.Registry.INSTANCE.remove(SbasePackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(SderivedPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(TbasePackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(TderivedPackage.eNS_URI);
	}

	@Test
	public void testOCL2QVTi_BaseAndDerived_Interpreted() throws Exception {
		MyQVT myQVT = createQVT("BaseAndDerived", "samples");
		myQVT.loadGenModels("SourceBaseMM.genmodel", "TargetBaseMM.genmodel");
		ImperativeTransformation tx = myQVT.executeOCL2QVTi_CompilerChain("Source2TargetBase.ocl");
		myQVT.executeModelsTX_Interpreted(tx, "model1");

		myQVT.dispose();
		myQVT = createQVT("BaseAndDerived", "samples");

		myQVT.loadGenModels("SourceBaseMM.genmodel", "TargetBaseMM.genmodel",
			"SourceDerivedMM.genmodel", "TargetDerivedMM.genmodel");
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
