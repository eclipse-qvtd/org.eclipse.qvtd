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
package org.eclipse.qvtd.umlx.tests;

import java.io.IOException;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystemHelper;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.pivot.internal.dynamic.JavaFileUtil;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfigurations;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.umlx.compiler.UMLXCompilerChain;
import org.eclipse.qvtd.umlx.utilities.UMLXStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.qvtd.xtext.qvtrelation.tests.QVTrelationTestFileSystemHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests that UMLX files can be compiled and executed.
 */
public class UMLXCompilerTests extends LoadTestCase
{
	private static boolean NO_MERGES = true;				// Set true to suppress the complexities of merging

	protected class MyQVT extends AbstractTestQVT
	{
		protected class InstrumentedCompilerChain extends UMLXCompilerChain
		{
			protected InstrumentedCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @Nullable CompilerOptions options) {
				super(environmentFactory, txURI, intermediateFileNamePrefixURI, options);
			}

			@Override
			protected @NonNull QVTr2QVTsCompilerStep createQVTr2QVTsCompilerStep() {
				return new QVTr2QVTsCompilerStep(this)
				{
					@Override
					public @NonNull ScheduleManager execute(@NonNull Resource qvtrResource, @NonNull Resource traceResource, @NonNull TypedModelsConfigurations typedModelsConfigurations) throws IOException {
						ScheduleManager scheduleManager = super.execute(qvtrResource, traceResource, typedModelsConfigurations);
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
		protected @NonNull UMLXCompilerChain createCompilerChain(@NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
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
		protected boolean generateGenModel() {
			return true;
		}

		@Override
		protected @NonNull String getBasePrefix() {
			return "org.eclipse.qvtd.umlx.tests";
		}

		@Override
		protected @NonNull ProjectManager getTestProjectManager(@NonNull String pathFromCurrentWorkingDirectoryToFileSystem) throws Exception {
			return UMLXCompilerTests.this.getTestProjectManager(pathFromCurrentWorkingDirectoryToFileSystem);
		}
	}

	@Override
	protected @NonNull OCLInternal createOCL() {
		return QVTbase.newInstance(getTestProjectManager(), null);
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
		return new QVTrelationTestFileSystemHelper();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
//		BaseLinkingService.DEBUG_RETRY.setState(true);
		QVTm2QVTs.DEBUG_GRAPHS.setState(true);
		XtextCompilerUtil.doQVTrelationSetup();
		XtextCompilerUtil.doQVTcoreSetup();
		XtextCompilerUtil.doQVTimperativeSetup();
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			UMLXStandaloneSetup.doSetup();
		}
		super.setUp();
		OCLstdlib.install();
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
	public void testUMLXCompiler_Forward2Reverse_CG() throws Exception {
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.VARIABLES.setState(true);
		Class<? extends Transformer> txClass;
		MyQVT myQVT1 = createQVT("Forward2Reverse", getModelsURI("forward2reverse/Forward2Reverse.umlx"));
		try {
			txClass = myQVT1.buildTransformation("reverse", false);
			myQVT1.assertRegionCount(RuleRegionImpl.class, 1);
//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 7);
		}
		finally {
			myQVT1.dispose();
		}
		MyQVT myQVT2 = createQVT("Forward2Reverse", getModelsURI("forward2reverse/Forward2Reverse.umlx"));
		try {
			myQVT2.loadEPackage(txClass, "doublylinkedlist.doublylinkedlistPackage");
			myQVT2.loadEPackage(txClass, "trace_Forward2Reverse.trace_Forward2ReversePackage");
			//
			//			Class<?> mClass1 = txClass.getClassLoader().loadClass("org.eclipse.qvtd.umlx.tests.models.forward2reverse.doublylinkedlist.doublylinkedlistPackage");
			//			EPackage ePackage1 = (EPackage)mClass1.getField("eINSTANCE").get(null);
			//			Class<?> mClass2 = txClass.getClassLoader().loadClass("org.eclipse.qvtd.umlx.tests.models.forward2reverse.trace_Forward2Reverse.trace_Forward2ReversePackage");
			//			EPackage ePackage2 = (EPackage)mClass2.getField("eINSTANCE").get(null);

			URI inURI = getModelsURI("forward2reverse/samples/EmptyList.xmi");
			URI outURI = getTestURI("generated_CG.xmi");
			URI expectedURI = getModelsURI("forward2reverse/samples/EmptyList_expected.xmi");
			//				txClass.getName();
			//				Field field = txClass.getField("PLUGIN_ID");
			//				Object pluginId = field.get(null);
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("forward", inURI);
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("reverse", outURI);
			myQVT2.saveModels(null);
			myQVT2.checkOutput(outURI, expectedURI, Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("forward", getModelsURI("forward2reverse/samples/OneElementList.xmi"));
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("reverse", getTestURI("OneElementList_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("OneElementList_CG.xmi"), getModelsURI("forward2reverse/samples/OneElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("forward", getModelsURI("forward2reverse/samples/TwoElementList.xmi"));
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("reverse", getTestURI("TwoElementList_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("TwoElementList_CG.xmi"), getModelsURI("forward2reverse/samples/TwoElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("forward", getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("reverse", getTestURI("ThreeElementList_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("ThreeElementList_CG.xmi"), getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
		}
	}

	@Test
	public void testUMLXCompiler_HierarchicalStateMachine2FlatStateMachine_example_CG() throws Exception {
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.VARIABLES.setState(true);
		Class<? extends Transformer> txClass;
		URI txURI = getResourceURI("/org.eclipse.qvtd.examples.umlx.hstm2fstm/model/HierarchicalStateMachine2FlatStateMachine.umlx");
		MyQVT myQVT1 = createQVT("HierarchicalStateMachine2FlatStateMachine", txURI);
		//		MyQVT myQVT = new MyQVT(createTestProjectManager(), getTestBundleURI(), "models/example_hstm2fstm", "samples");
		//		MyQVT myQVT = new MyQVT("forward2reverse");
		try {
			txClass = myQVT1.buildTransformation("flat", false);
			myQVT1.assertRegionCount(RuleRegionImpl.class, 0);
//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 6);
		}
		finally {
			myQVT1.dispose();
		}
		MyQVT myQVT2 = createQVT("HierarchicalStateMachine2FlatStateMachine", txURI);
		try {
			//			myQVT2.loadEPackage(txClass, "doublylinkedlist.doublylinkedlistPackage");
			//			myQVT2.loadEPackage(txClass, "trace_Forward2Reverse.trace_Forward2ReversePackage");
			URI inURI = getResourceURI("/org.eclipse.qvtd.examples.umlx.hstm2fstm/model/in/hier.xmi");
			URI outURI = getTestURI("generated_CG.xmi");
			URI expectedURI = getResourceURI("/org.eclipse.qvtd.examples.umlx.hstm2fstm/model/out/expected.xmi");
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("hier", inURI);
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("flat", outURI);
			myQVT2.saveModels(null);
			myQVT2.checkOutput(outURI, expectedURI, null);//FlatStateMachineNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
			cleanup("http://www.eclipse.org/qvtd/examples/umlx/hstm2fstm/HierarchicalStateMachine",
					"http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/xtext/umlx/tests/hstm2fstm/HierarchicalStateMachine2FlatStateMachine",
					"http://www.eclipse.org/qvtd/examples/umlx/hstm2fstm/FlatStateMachine");
		}
	}
}
