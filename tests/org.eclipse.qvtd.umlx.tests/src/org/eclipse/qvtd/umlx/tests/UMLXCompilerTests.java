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
import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.pivot.tests.PivotTestCaseWithAutoTearDown.AbstractTestThread;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystemHelper;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.resource.ProjectManager.IPackageDescriptor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfigurations;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.umlx.compiler.UMLXCompilerChain;
import org.eclipse.qvtd.umlx.utilities.UMLXStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.qvtd.xtext.qvtimperative.tests.QVTiCompilerTests.QVTiExecutionThread;
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

	protected abstract /*static*/ class UMLXExecutionThread extends QVTiExecutionThread
	{
		private QVTiTransformationExecutor executor;
		private boolean suppressFailureDiagnosis = false;				// FIXME BUG 511028

		protected UMLXExecutionThread(@NonNull QVTimperativeEnvironmentThreadFactory environmentThreadFactory, @NonNull Class<? extends Transformer> txClass) {
			super(environmentThreadFactory, "UMLX-Execution", txClass);
		}

		protected @Nullable Resource addInputURI(@NonNull String modelName, @NonNull URI modelURI) {
			return executor.addInputURI(modelName, modelURI);
		}

		protected @NonNull Resource addOutputURI(@NonNull String modelName, @NonNull URI modelURI) {
			return executor.addOutputURI(modelName, modelURI);
		}

		public @NonNull Resource checkOutput(@NonNull URI actualURI, @Nullable URI expectedURI, @Nullable ModelNormalizer normalizer) throws Exception {
			QVTrelationEnvironmentThreadFactory environmentThreadFactory = createQVTrelationEnvironmentThreadFactory();
			return checkOutput(environmentThreadFactory, actualURI, expectedURI, normalizer);
		}

		public <@NonNull EF extends EnvironmentFactoryInternal> @NonNull Resource checkOutput(@NonNull EnvironmentThreadFactory<EF> environmentThreadFactory, @NonNull URI actualURI, @Nullable URI expectedURI, @Nullable ModelNormalizer normalizer) throws Exception {
			//		deactivate();
			AbstractTestThread<@NonNull Resource, EF, @Nullable OCLInternal> checkThread = new AbstractTestThread<@NonNull Resource, EF, @Nullable OCLInternal>("Check-Output", environmentThreadFactory)
			{
				@Override
				protected OCLInternal createOCL() {
					OCL ocl = QVTbase.newInstance(getTestProjectManager());
					ocl.getEnvironmentFactory().setSeverity(PivotPackage.Literals.VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP, StatusCodes.Severity.IGNORE);
					return (OCLInternal) ocl;
				}

				@Override
				public @NonNull Resource runWithThrowable() throws Exception {
					ResourceSet actualResourceSet = createTestResourceSet();
					//		if (PivotUtilInternal.isASURI(modelURI)) {
					//			resourceSet = environmentFactory.getMetamodelManager().getASResourceSet();	// Need PivotSave to allocate xmi:ids
					//		}
					//		else {
					//			resourceSet = getResourceSet();
					//		}
					Resource actualResource = ClassUtil.nonNullState(actualResourceSet.getResource(actualURI, true));
					EcoreUtil.resolveAll(actualResourceSet);
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
					return actualResource;
				}
			};
			Resource actualResource = checkThread.invoke();
			//	activate();
			return actualResource;
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

		public void createGeneratedExecutor() throws ReflectiveOperationException {
			this.executor = new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);
		}

		protected @NonNull ResourceSet createTestResourceSet() {
			ResourceSet actualResourceSet = new ResourceSetImpl();
			getEnvironmentFactory().getProjectManager().initializeResourceSet(actualResourceSet);
			return actualResourceSet;
		}

		public boolean executeTransformation() throws Exception {
			if (suppressFailureDiagnosis) {
				executor.setSuppressFailureDiagnosis(true);
			}
			Boolean success = executor.execute(null);
			return success == Boolean.TRUE;
		}

		@Override
		protected @NonNull TransformationExecutor getExecutor() {
			return executor;
		}

		public void saveModels(@Nullable Map<?, ?> saveOptions) throws IOException {
			getExecutor().getModelsManager().saveModels(saveOptions);
		}
	}

	protected class MyQVT extends AbstractTestQVT
	{
		protected class InstrumentedCompilerChain extends UMLXCompilerChain
		{
			protected InstrumentedCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @Nullable CompilerOptions options) {
				super(projectManager, txURI, intermediateFileNamePrefixURI, options);
			}

			@Override
			protected @NonNull QVTr2QVTsCompilerStep createQVTr2QVTsCompilerStep() {
				return new QVTr2QVTsCompilerStep(this)
				{
					@Override
					public @NonNull ScheduleManager execute(@NonNull QVTimperativeEnvironmentFactory environmentFactory, @NonNull Resource qvtrResource, @NonNull Resource traceResource, @NonNull TypedModelsConfigurations typedModelsConfigurations) throws IOException {
						ScheduleManager scheduleManager = super.execute(environmentFactory, qvtrResource, traceResource, typedModelsConfigurations);
						instrumentPartition(scheduleManager);
						return scheduleManager;
					}
				};
			}
		}

		public MyQVT(@NonNull ProjectManager projectManager, @NonNull TestProject testProject, @NonNull URI testBundleURI, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull URI srcFileURI, @NonNull URI binFileURI) throws IOException {
			super(projectManager, testProject, testBundleURI, txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
		}

		public @NonNull Resource checkOutput(@NonNull URI actualURI, @Nullable URI expectedURI, @Nullable ModelNormalizer normalizer) throws Exception {
			QVTrelationEnvironmentThreadFactory environmentThreadFactory = createQVTrelationEnvironmentThreadFactory();
			return checkOutput(environmentThreadFactory, actualURI, expectedURI, normalizer);
		}

		private void configureGeneratedPackage( /*@NonNull*/ String uriString) {
			URI nsURI = URI.createURI(uriString);
			IPackageDescriptor packageDescriptor = getProjectManager().getPackageDescriptor(nsURI);
			if (packageDescriptor != null) {
				packageDescriptor.configure(getResourceSet(), StandaloneProjectMap.LoadGeneratedPackageStrategy.INSTANCE, null);
			}
		}

		@Override
		protected @NonNull UMLXCompilerChain createCompilerChain(@NonNull ProjectManager projectManager, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
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
			return "org.eclipse.qvtd.umlx.tests";
		}

		@Override
		protected @NonNull ProjectManager getTestProjectManager(@NonNull String pathFromCurrentWorkingDirectoryToFileSystem) {
			return EMFPlugin.IS_ECLIPSE_RUNNING ? new ProjectMap(true) : UMLXCompilerTests.this.getTestProjectManager(pathFromCurrentWorkingDirectoryToFileSystem);
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
		super.setUp();
		OCLstdlib.install();
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			UMLXStandaloneSetup.doSetup();
		}
		XtextCompilerUtil.doQVTrelationSetup();
		XtextCompilerUtil.doQVTcoreSetup();
		XtextCompilerUtil.doQVTimperativeSetup();
		//		QVTrelationPivotStandaloneSetup.doSetup();
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
	//	myQVT1.configureGeneratedPackage(EcorePackage.eNS_URI);
	//	myQVT1.configureGeneratedPackage(PivotPackage.eNS_URI);
	//	myQVT1.configureGeneratedPackage(OCLstdlibPackage.eNS_URI);
		myQVT1.configureGeneratedPackage(EcorePackage.eNS_URI);
		myQVT1.configureGeneratedPackage(PivotPackage.eNS_URI);
		myQVT1.configureGeneratedPackage(OCLstdlibPackage.eNS_URI);
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
	//	MyQVT myQVT2 = createQVT("Forward2Reverse", getModelsURI("forward2reverse/Forward2Reverse.umlx"));
		try {
	//		myQVT2.loadEPackage(txClass, "doublylinkedlist.doublylinkedlistPackage");
	//		myQVT2.loadEPackage(txClass, "trace_Forward2Reverse.trace_Forward2ReversePackage");
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
			UMLXExecutionThread executionThread = new UMLXExecutionThread(createQVTimperativeEnvironmentThreadFactory(), txClass)
			{
				@Override
				protected Object runWithThrowable() throws Exception {
					createGeneratedExecutor();
					addInputURI("forward", inURI);
					executeTransformation();
					addOutputURI("reverse", outURI);
					saveModels(null);
					checkOutput(outURI, expectedURI, Forward2ReverseNormalizer.INSTANCE);
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
			executionThread.invoke();
		}
		finally {
	//		myQVT2.dispose();
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
		try {
			//			myQVT2.loadEPackage(txClass, "doublylinkedlist.doublylinkedlistPackage");
			//			myQVT2.loadEPackage(txClass, "trace_Forward2Reverse.trace_Forward2ReversePackage");
			URI inURI = getResourceURI("/org.eclipse.qvtd.examples.umlx.hstm2fstm/model/in/hier.xmi");
			URI outURI = getTestURI("generated_CG.xmi");
			URI expectedURI = getResourceURI("/org.eclipse.qvtd.examples.umlx.hstm2fstm/model/out/expected.xmi");
			UMLXExecutionThread executionThread = new UMLXExecutionThread(createQVTimperativeEnvironmentThreadFactory(), txClass)
			{
				@Override
				protected Object runWithThrowable() throws Exception {
					createGeneratedExecutor();
					addInputURI("hier", inURI);
					executeTransformation();
					addOutputURI("flat", outURI);
					saveModels(null);
					checkOutput(outURI, expectedURI, null);//FlatStateMachineNormalizer.INSTANCE);
					return null;
				}
			};
			executionThread.invoke();
		}
		finally {
			cleanup("http://www.eclipse.org/qvtd/examples/umlx/hstm2fstm/HierarchicalStateMachine",
					"http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/xtext/umlx/tests/hstm2fstm/HierarchicalStateMachine2FlatStateMachine",
					"http://www.eclipse.org/qvtd/examples/umlx/hstm2fstm/FlatStateMachine");
		}
	}
}
