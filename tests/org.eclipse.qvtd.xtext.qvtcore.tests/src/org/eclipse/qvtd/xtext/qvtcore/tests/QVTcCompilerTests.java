/*******************************************************************************
 * Copyright (c) 2012, 2019 Willink Transformations and others.
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

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.dynamic.JavaClasspath;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystemHelper;
import org.eclipse.ocl.examples.xtext.tests.TestFolder;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.QVTcCompilerChain;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.splitter.Splitter;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcore;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests that QVTc files can be compiled and executed.
 */
public class QVTcCompilerTests extends LoadTestCase
{
	private static boolean NO_MERGES = true;				// Set true to suppress the complexities of merging

	protected class MyQVT extends AbstractTestQVT
	{
		protected class InstrumentedCompilerChain extends QVTcCompilerChain
		{
			protected InstrumentedCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
				super(environmentFactory, txURI, intermediateFileNamePrefixURI, options);
			}

			@Override
			protected @NonNull QVTm2QVTsCompilerStep createQVTm2QVTsCompilerStep() {
				return new QVTm2QVTsCompilerStep(this)
				{
					@Override
					public @NonNull ScheduleManager execute(@NonNull Resource pResource, @NonNull TypedModelsConfiguration typedModelsConfiguration) throws IOException {
						ScheduleManager scheduleManager = super.execute(pResource, typedModelsConfiguration);
						instrumentPartition(scheduleManager);
						return scheduleManager;
					}
				};
			}
		}

		public MyQVT(@NonNull ProjectManager projectManager, @NonNull TestProject testProject, @NonNull URI testBundleURI, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull URI srcFileURI, @NonNull URI binFileURI) throws IOException {
			super(projectManager, testProject, testBundleURI, txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
		}

		@Override
		protected @NonNull QVTcCompilerChain createCompilerChain(@NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
			return new InstrumentedCompilerChain(getEnvironmentFactory(), txURI, intermediateFileNamePrefixURI, options);
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
		protected @NonNull ProjectManager getTestProjectManager() throws Exception {
			return EMFPlugin.IS_ECLIPSE_RUNNING ? new ProjectMap(true) : QVTcCompilerTests.this.getTestProjectManager();
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
		MyQVT myQVT = createQVT("Families2Persons", txFile.getURI());
		//		myQVT.loadEcoreFile(getModelsURI("families2persons/Families.ecore"), FamiliesPackage.eINSTANCE);
		//		myQVT.loadEcoreFile(getModelsURI("families2persons/Families2Persons.ecore"), Families2PersonsPackage.eINSTANCE);
		//		myQVT.loadEcoreFile(getModelsURI("families2persons/Persons.ecore"), PersonsPackage.eINSTANCE);
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation iTransformation = myQVT.compileTransformation("person");
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("family", inFile.getURI());
			myQVT.executeTransformation();
			myQVT.addOutputURI("person", outURI);
			myQVT.saveModels(null);
			myQVT.checkOutput(outURI, refFile.getURI(), Families2PersonsNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
		}
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
			myQVT.createGeneratedExecutor(txClass);
			myQVT.addInputURI("family", getModelsURI("families2persons/samples/Families.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("person", getTestURI("Persons_CG.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("Persons_CG.xmi"), getModelsURI("families2persons/samples/Persons_expected.xmi"), Families2PersonsNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.addInputURI("family", getModelsURI("families2persons/samples/FamiliesBig.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("person", getTestURI("PersonsBig_CG.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("PersonsBig_CG.xmi"), getModelsURI("families2persons/samples/PersonsBig_expected.xmi"), Families2PersonsNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
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
		MyQVT myQVT = createQVT("Forward2Reverse", txFile.getURI());
		//		DoublylinkedlistPackage.eINSTANCE.getClass();
		//		List2listPackage.eINSTANCE.getClass();
		//		myQVT.loadEcoreFile(getModelsURI("forward2reverse/DoublyLinkedList.ecore"), DoublylinkedlistPackage.eINSTANCE);
		//		myQVT.loadEcoreFile(getModelsURI("forward2reverse/List2List.ecore"), List2listPackage.eINSTANCE);
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation iTransformation = myQVT.compileTransformation("reverse");
			//
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("forward", inFile0.getURI());
			myQVT.executeTransformation();
			myQVT.addOutputURI("reverse", outURI0);
			myQVT.saveModels(null);
			myQVT.checkOutput(outURI0, refFile0.getURI(), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("forward", inFile1.getURI());
			myQVT.executeTransformation();
			myQVT.addOutputURI("reverse", outURI1);
			myQVT.saveModels(null);
			myQVT.checkOutput(outURI1, refFile1.getURI(), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("forward", inFile2.getURI());
			myQVT.executeTransformation();
			myQVT.addOutputURI("reverse", outURI2);
			myQVT.saveModels(null);
			myQVT.checkOutput(outURI2, refFile2.getURI(), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("forward", inFile3.getURI());
			myQVT.executeTransformation();
			myQVT.addOutputURI("reverse", outURI3);
			myQVT.saveModels(null);
			myQVT.checkOutput(outURI3, refFile3.getURI(), Forward2ReverseNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
		}
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
			myQVT.createGeneratedExecutor(txClassReverse);
			myQVT.addInputURI("reverse", getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("forward", getTestURI("ThreeElementList_Reverse_CG.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("ThreeElementList_Reverse_CG.xmi"), getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			Class<? extends Transformer> txClass = myQVT.buildTransformation("reverse", false, "List2List.genmodel");
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.addInputURI("forward", getModelsURI("forward2reverse/samples/EmptyList.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("reverse", getTestURI("EmptyList_CG.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("EmptyList_CG.xmi"), getModelsURI("forward2reverse/samples/EmptyList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.addInputURI("forward", getModelsURI("forward2reverse/samples/OneElementList.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("reverse", getTestURI("OneElementList_CG.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("OneElementList_CG.xmi"), getModelsURI("forward2reverse/samples/OneElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.addInputURI("forward", getModelsURI("forward2reverse/samples/TwoElementList.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("reverse", getTestURI("TwoElementList_CG.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("TwoElementList_CG.xmi"), getModelsURI("forward2reverse/samples/TwoElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.addInputURI("forward", getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("reverse", getTestURI("ThreeElementList_CG.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("ThreeElementList_CG.xmi"), getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
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
		MyQVT myQVT = createQVT("HSV2HSL", txFile.getURI());
		//		myQVT.loadEcoreFile(getTestFileURI("HSV2HSL.ecore"), HSV2HSLPackage.eINSTANCE);
		//		myQVT.loadEcoreFile(getTestFileURI("HSVTree.ecore"), HSVTreePackage.eINSTANCE);
		//		myQVT.loadEcoreFile(getTestFileURI("HSLTree.ecore"), HSLTreePackage.eINSTANCE);
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation iTransformation = myQVT.compileTransformation("hsl");
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("hsv", inFile.getURI());
			myQVT.executeTransformation();
			myQVT.addOutputURI("hsl", outURI);
			myQVT.saveModels(null);
			myQVT.checkOutput(outURI, refFile.getURI(), HSV2HSLNormalizer.INSTANCE);	// FIXME Bug 490497 remove normalizer
		}
		finally {
			myQVT.dispose();
		}
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
			//			myQVT.createGeneratedExecutor(hsv2hsl.class);
			Class<? extends Transformer> txClass = myQVT.buildTransformation("hsl", false, "HSV2HSL.genmodel");
			myQVT.assertRegionCount(RuleRegionImpl.class, 1);
			//			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 4);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.addInputURI("hsv", getModelsURI("hsv2hsl/samples/SolarizedHSV.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("hsl", getTestURI("SolarizedHSL_CG.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("SolarizedHSL_CG.xmi"), getModelsURI("hsv2hsl/samples/SolarizedHSL_expected.xmi"), HSV2HSLNormalizer.INSTANCE);	// FIXME Bug 490497 remove normalizer
		}
		finally {
			myQVT.dispose();
		}
	}

	@Test // fails through at least lack of multi-headed support, which may not be needed if better partitioned
	public void testQVTcCompiler_SimpleUML2RDBMS() throws Exception {
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT("SimpleUML2RDBMS", getModelsURI("uml2rdbms/SimpleUML2RDBMS.qvtcas"));
		myQVT.loadEcoreFile(getModelsURI("uml2rdbms/SimpleUML2RDBMS.ecore"), Simpleuml2rdbmsPackage.eINSTANCE);
		myQVT.loadEcoreFile(getModelsURI("uml2rdbms/SimpleUML.ecore"), SimpleumlPackage.eINSTANCE);
		myQVT.loadEcoreFile(getModelsURI("uml2rdbms/SimpleRDBMS.ecore"), SimplerdbmsPackage.eINSTANCE);
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation iTransformation = myQVT.compileTransformation("rdbms");
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("uml", getModelsURI("uml2rdbms/samples/SimplerUMLPeople.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("rdbms", getTestURI("SimplerRDBMSPeople_Interpreted.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("SimplerRDBMSPeople_Interpreted.xmi"), getModelsURI("uml2rdbms/samples/SimplerRDBMSPeople_expected.xmi"), SimpleRDBMSNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("uml", getModelsURI("uml2rdbms/samples/SimplerUMLPeople2.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("rdbms", getTestURI("SimplerRDBMSPeople2_Interpreted.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("SimplerRDBMSPeople2_Interpreted.xmi"), getModelsURI("uml2rdbms/samples/SimplerRDBMSPeople2_expected.xmi"), SimpleRDBMSNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("uml", getModelsURI("uml2rdbms/samples/SimpleUMLPeople.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("rdbms", getTestURI("SimpleRDBMSPeople_Interpreted.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("SimpleRDBMSPeople_Interpreted.xmi"), getModelsURI("uml2rdbms/samples/SimpleRDBMSPeople_expected.xmi"), SimpleRDBMSNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
		}
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
			myQVT.createGeneratedExecutor(txClass);
			myQVT.addInputURI("uml", getModelsURI("uml2rdbms/samples/SimplerUMLPeople.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("rdbms", getTestURI("SimplerRDBMSPeople_CG.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("SimplerRDBMSPeople_CG.xmi"), getModelsURI("uml2rdbms/samples/SimplerRDBMSPeople_expected.xmi"), SimpleRDBMSNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.addInputURI("uml", getModelsURI("uml2rdbms/samples/SimplerUMLPeople2.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("rdbms", getTestURI("SimplerRDBMSPeople2_CG.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("SimplerRDBMSPeople2_CG.xmi"), getModelsURI("uml2rdbms/samples/SimplerRDBMSPeople2_expected.xmi"), SimpleRDBMSNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.addInputURI("uml", getModelsURI("uml2rdbms/samples/SimpleUMLPeople.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("rdbms", getTestURI("SimpleRDBMSPeople_CG.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("SimpleRDBMSPeople_CG.xmi"), getModelsURI("uml2rdbms/samples/SimpleRDBMSPeople_expected.xmi"), SimpleRDBMSNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
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
			myQVT.createGeneratedExecutor(txClass);
			myQVT.addInputURI("uml", inFile.getURI());
			myQVT.executeTransformation();
			myQVT.addOutputURI("rdbms", outURI);
			myQVT.saveModels(null);
			myQVT.checkOutput(outURI, refFile.getURI(), SimpleRDBMSNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
		}
	}

	@Test
	public void testQVTcCompiler_Upper2Lower() throws Exception {
		//    	QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
		MyQVT myQVT = createQVT("Upper2Lower", getModelsURI("upper2lower/Upper2Lower.qvtcas"));
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation iTransformation = myQVT.compileTransformation("lowerGraph");
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("upperGraph", getModelsURI("upper2lower/samples/SimpleGraph.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("lowerGraph", getTestURI("SimpleGraphLower_Interpreted.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("SimpleGraphLower_Interpreted.xmi"), getModelsURI("upper2lower/samples/SimpleGraphLower_expected.xmi"), Upper2LowerNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
		}
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
		MyQVT myQVT = createQVT("upper2lower", getModelsURI("upper2lower/Upper2Lower.qvtcas"));
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("lowerGraph", false, "SimpleGraph2Graph.genmodel");
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.addInputURI("upperGraph", getModelsURI("upper2lower/samples/SimpleGraph.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("lowerGraph", getTestURI("SimpleGraphLower_CG.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("SimpleGraphLower_CG.xmi"), getModelsURI("upper2lower/samples/SimpleGraphLower_expected.xmi"), Upper2LowerNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
		}
	}
}
