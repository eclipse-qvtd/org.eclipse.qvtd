/*******************************************************************************
 * Copyright (c) 2012, 2022 Willink Transformations and others.
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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.m2m.atl.common.ATL.ATLPackage;
import org.eclipse.m2m.atl.dsls.core.EMFTCSInjector;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceFactoryImpl;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.ocl.examples.xtext.tests.TestFile;
import org.eclipse.ocl.examples.xtext.tests.TestFolder;
import org.eclipse.ocl.examples.xtext.tests.TestProject;
import org.eclipse.ocl.examples.xtext.tests.XtextTestCase.Normalizer;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.dynamic.JavaClasspath;
import org.eclipse.ocl.pivot.internal.dynamic.JavaFileUtil;
import org.eclipse.ocl.pivot.internal.ecore.es2as.Ecore2AS;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.ASResourceImpl;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.resource.ProjectManager.IPackageDescriptor;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.pivot.utilities.ThreadLocalExecutor;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.compiler.internal.common.DefaultConfigurations;
import org.eclipse.qvtd.compiler.internal.common.TargetConfiguration;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfigurations;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ConnectivityChecker;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationToStringVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.pivot.qvttemplate.utilities.QVTtemplateToStringVisitor;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.TransformationExecutor;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT.ContentEditingURIConverter;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.junit.After;
import org.junit.Before;

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

	public class MyQVT extends AbstractTestQVT
	{
		protected class InstrumentedCompilerChain extends QVTrCompilerChain
		{
			protected InstrumentedCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
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

			@Override
			public @NonNull ImperativeTransformation qvtr2qvti(@NonNull Resource qvtrResource, @NonNull TypedModelsConfigurations typedModelsConfigurations) throws IOException {
				assertNoValidationErrors("QVTr validation", qvtrResource);
				return super.qvtr2qvti(qvtrResource, typedModelsConfigurations);
			}
		}

		private boolean keepOldJavaFiles = false;

		public MyQVT(@NonNull ProjectManager projectManager, @NonNull TestProject testProject, @NonNull URI testBundleURI, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull URI srcFileURI, @NonNull URI binFileURI) throws IOException {
			super(projectManager, testProject, testBundleURI, txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
			getEnvironmentFactory().setSafeNavigationValidationSeverity(StatusCodes.Severity.WARNING);
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
		protected @NonNull QVTrCompilerChain createCompilerChain(@NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull CompilerOptions options) {
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
			return "org.eclipse.qvtd.xtext.qvtrelation.tests";
		}

		@Override
		protected @NonNull ProjectManager getTestProjectManager(@NonNull String pathFromCurrentWorkingDirectoryToFileSystem) throws Exception {
			return QVTrCompilerTests.this.getTestProjectManager(pathFromCurrentWorkingDirectoryToFileSystem);
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
		QVTm2QVTs.DEBUG_GRAPHS.setState(true);
		ATLPackage.eINSTANCE.getClass();
		XtextCompilerUtil.doQVTrelationSetup();
		XtextCompilerUtil.doQVTcoreSetup();
		XtextCompilerUtil.doQVTimperativeSetup();
		super.setUp();
		OCLstdlib.install();
		ConnectivityChecker.CONNECTIVITY.setState(true);
		ASResourceImpl.SKIP_CHECK_BAD_REFERENCES = true;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#tearDown()
	 */
	@Override
	@After
	public void tearDown() throws Exception {
		ASResourceImpl.SKIP_CHECK_BAD_REFERENCES = true;
		ConnectivityChecker.CONNECTIVITY.setState(false);
		super.tearDown();
	}

	public void testQVTrCompiler_ATL2QVTr_CG() throws Exception {
		ASResourceImpl.SKIP_CHECK_BAD_REFERENCES = false;	// Incur the Bug 578030 serialization check overheads for one QVTr test.
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.ASSIGNMENTS.setState(true);
		//		AbstractTransformer.CREATIONS.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.GETTINGS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//		QVTm2QVTp.PARTITIONING.setState(true);
		/*	//		AbstractMerger.EARLY.setState(true);
		//		AbstractMerger.FAILURE.setState(true);
		//		AbstractMerger.LATE.setState(true);
		//		AbstractQVTb2QVTs.REGION_ORDER.setState(true);
		//		AbstractQVTb2QVTs.REGION_STACK.setState(true);
		//		QVTscheduleConstants.POLLED_PROPERTIES.setState(true);
		//		QVTscheduleConstants.CONNECTION_CREATION.setState(true);
		//		FallibilityAnalysis.LOCAL.setState(true);;
		TransformationPartitioner.REGION_CYCLES.setState(true);;
		TransformationPartitioner.PARTITION_CYCLES.setState(true);;
		//		TransformationPartitioner.DISCRIMINATION.setState(true);;
		TransformationPartitioner.PARTITION_TRANSITIVE_PREDECESSORS.setState(true);;
		TransformationPartitioner.PARTITION_TRANSITIVE_SUCCESSORS.setState(true);;
		//		QVTscheduleConstants.CONNECTION_CREATION.setState(true);;
		//		ConnectivityChecker.CONNECTIVITY_CLASSDATUMS.setState(true);
		//		ConnectivityChecker.CONNECTIVITY_CONNECTIONS.setState(true);
		//		ConnectivityChecker.CONNECTIVITY_EDGES.setState(true);
		//		ConnectivityChecker.CONNECTIVITY_NODES.setState(true);
		//		QVTm2QVTs.DUMP_CLASS_TO_REALIZED_NODES.setState(true);
		//		QVTm2QVTs.DUMP_CLASS_TO_CONSUMING_NODES.setState(true); */
		//		TransformationPartitioner.PARALLEL_SCHEDULE.setState(true);
		//		TransformationPartitioner.PROPERTY_NOTIFY.setState(true);
		//		TransformationPartitioner.PROPERTY_OBSERVE.setState(true);
		//	TransformationPartitioner.MERGE_SEQUENTIAL.setState(true);
		//		QVTiProductionConsumption.SUMMARY.setState(true);
		//		QVTm2QVTs.DUMP_CLASS_TO_CONSUMING_NODES.setState(true);
		//	TracedHeadAnalysis.TRACED_HEAD_NODE_GROUPS.setState(true);
		//	TracedHeadAnalysis.TRACED_HEAD_IMMEDIATE_SOURCES.setState(true);
		//	RuleHeadAnalysis.RULE_HEAD_NODE_GROUPS.setState(true);
		//	TransformationPartitioner.PARTITION_IMMEDIATE_PREDECESSORS.setState(true);
		//	TransformationPartitioner.PARTITION_TRANSITIVE_PREDECESSORS.setState(true);
		//	TransformationPartitioner.PARTITION_TRANSITIVE_SUCCESSORS.setState(true);
		//	TransformationPartitioner.REGION_IMMEDIATE_PREDECESSORS.setState(true);
		//	TransformationPartitioner.REGION_TRANSITIVE_PREDECESSORS.setState(true);
		//	TransformationPartitioner.REGION_TRANSITIVE_SUCCESSORS.setState(true);
		QVTrelationTestFileSystemHelper testFileSystemHelper = getTestFileSystemHelper();
		testFileSystemHelper.addRequiredBundle("org.eclipse.qvtd.atl");
		testFileSystemHelper.addExportedPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.newatl2qvtr");
		Class<? extends Transformer> txClass1 = null;
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
			txClass1 = myQVT1.buildTransformation("qvtr", false);
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
		ThreadLocalExecutor.resetEnvironmentFactory();
		URI txURI2 = getTestURI("Families2Persons_CG.qvtras");
		MyQVT myQVT2 = createQVT("ATL2QVTr", txURI1);
		//		MyQVT myQVT2 = new MyQVT(createTestProjectManager(), getTestBundleURI(), "models/families2persons", null);
		try {
			myQVT2.createGeneratedExecutor(txClass1);
			//	if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			EMFTCSInjector.class.getName();				// Hidden ATL dependency
			AtlParser.class.getName();					// Hidden ATL dependency
			myQVT2.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl());
			myQVT2.addInputURI("atl", getModelsURI("families2persons/Families2Persons.atl"));
			//	}
			//	else {
			//		myQVT2.addInputURI("atl", getModelsURI("families2persons/Families2Persons.atl.xmi"));		// FIXME Working around BUG 514604
			//	}
			ToStringVisitor.addFactory(new PivotQVTrelationToStringFactory());
			myQVT2.executeTransformation();
			ASResource qvtrASResource = (ASResource) myQVT2.addOutputURI("qvtr", txURI2);
			qvtrASResource.setASonly(true);
			myQVT2.saveModels(null);
			myQVT2.checkOutput(txURI2, getModelsURI("families2persons/Families2Persons_expected.qvtras"), QVTrNormalizer.INSTANCE);	// FIXME normalization unnecessary once Relation domains ordered by tx
		}
		finally {
			myQVT2.activate();
			myQVT2.dispose();
			myQVT2 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
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
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT4 = createQVT("Families2Persons", txURI2);
		try {
			myQVT4.loadEPackage(txClass3, "Families.FamiliesPackage");
			myQVT4.loadEPackage(txClass3, "Persons.PersonsPackage");
			myQVT4.loadEPackage(txClass3, "trace_Families2Persons.trace_Families2PersonsPackage");
			//
			myQVT4.createGeneratedExecutor(txClass3);
			myQVT4.addInputURI("Families", getModelsURI("families2persons/samples/Families.xmi"));
			myQVT4.executeTransformation();
			myQVT4.addOutputURI("Persons", getTestURI("Persons_CG.xmi"));
			myQVT4.saveModels(null);
			myQVT4.checkOutput(getTestURI("Persons_CG.xmi"), getModelsURI("families2persons/samples/Persons_expected.xmi"), Families2PersonsNormalizer.INSTANCE);
		}
		finally {
			myQVT4.dispose();
			myQVT4 = null;
			cleanup("http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/xtext/qvtrelation/tests/newatl2qvtr/NewATL2QVTr");
		}
	}

	public void testQVTrCompiler_ATL2QVTr_reverse_CG() throws Exception {
		if (!ENABLE_ATL2QVTr_reverse_CG) {
			return;
		}
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.ASSIGNMENTS.setState(true);
		//		AbstractTransformer.CREATIONS.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.GETTINGS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//		QVTm2QVTp.PARTITIONING.setState(true);
		//		AbstractMerger.EARLY.setState(true);
		//		AbstractMerger.FAILURE.setState(true);
		//		AbstractMerger.LATE.setState(true);
		//		AbstractQVTb2QVTs.REGION_ORDER.setState(true);
		//		AbstractQVTb2QVTs.REGION_STACK.setState(true);
		//		QVTscheduleConstants.POLLED_PROPERTIES.setState(true);
		//		QVTscheduleConstants.CONNECTION_CREATION.setState(true);
		//		FallibilityAnalysis.LOCAL.setState(true);;
		//		TransformationPartitioner.CYCLES.setState(true);;
		//		TransformationPartitioner.DISCRIMINATION.setState(true);;
		//		TransformationPartitioner.PREDECESSORS.setState(true);;
		//		TransformationPartitioner.SUCCESSORS.setState(true);;
		//		QVTscheduleConstants.CONNECTION_CREATION.setState(true);;
		//		ConnectivityChecker.CONNECTIVITY_CLASSDATUMS.setState(true);
		//		ConnectivityChecker.CONNECTIVITY_CONNECTIONS.setState(true);
		//		ConnectivityChecker.CONNECTIVITY_EDGES.setState(true);
		//		ConnectivityChecker.CONNECTIVITY_NODES.setState(true);
		//		QVTm2QVTs.DUMP_CLASS_TO_REALIZED_NODES.setState(true);
		//		QVTm2QVTs.DUMP_CLASS_TO_CONSUMING_NODES.setState(true);
		//	Class<? extends Transformer> txClass1 = null;
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

	public void testQVTrCompiler_ATL2QVTr_CG_exec() throws Exception {
		if (!ENABLE_ATL2QVTr_CG_exec) {
			return;
		}
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		AbstractTransformer.ASSIGNMENTS.setState(true);
		AbstractTransformer.CREATIONS.setState(true);
		AbstractTransformer.EXCEPTIONS.setState(true);
		AbstractTransformer.GETTINGS.setState(true);
		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		AbstractMerger.EARLY.setState(true);
		//		AbstractMerger.FAILURE.setState(true);
		//		AbstractMerger.LATE.setState(true);
		//		TransformationPartitioner.CYCLES.setState(true);;
		//		TransformationPartitioner.DISCRIMINATION.setState(true);;
		//		TransformationPartitioner.PREDECESSORS.setState(true);;
		//		TransformationPartitioner.SUCCESSORS.setState(true);;
		//		QVTscheduleConstants.CONNECTION_CREATION.setState(true);;
		ConnectivityChecker.CONNECTIVITY_CLASSDATUMS.setState(true);
		ConnectivityChecker.CONNECTIVITY_CONNECTIONS.setState(true);
		ConnectivityChecker.CONNECTIVITY_EDGES.setState(true);
		ConnectivityChecker.CONNECTIVITY_NODES.setState(true);
		//		QVTm2QVTs.DUMP_CLASS_TO_REALIZED_NODES.setState(true);
		//		QVTm2QVTs.DUMP_CLASS_TO_CONSUMING_NODES.setState(true);
		//		Class<? extends Transformer> txClass1 = org.eclipse.qvtd.xtext.qvtrelation.tests.newatl2qvtr.NewATL2QVTr.class;
		Class<?> txClass0 = Class.forName("org.eclipse.qvtd.xtext.qvtrelation.tests.newatl2qvtr.NewATL2QVTr");
		@SuppressWarnings("unchecked")
		Class<Transformer> txClass1 = (Class<Transformer>)txClass0;
		//		URI txURI1 = getModelsURI("newATL2QVTr/NewATL2QVTr.qvtr");

		URI txURI2 = getTestURI("Families2Persons_CG.qvtras");
		MyQVT myQVT2 = createQVT("ATL2QVTr", txURI2);
		//		MyQVT myQVT2 = new MyQVT(createTestProjectManager(), getTestBundleURI(), "models/families2persons", null);
		try {
			myQVT2.createGeneratedExecutor(txClass1);
			if (EMFPlugin.IS_ECLIPSE_RUNNING) {
				EMFTCSInjector.class.getName();				// Hidden ATL dependency
				AtlParser.class.getName();					// Hidden ATL dependency
				myQVT2.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl());
				myQVT2.addInputURI("atl", getModelsURI("families2persons/Families2Persons.atl"));
			}
			else {
				myQVT2.addInputURI("atl", getModelsURI("families2persons/Families2Persons.atl.xmi"));		// FIXME Working around BUG 514604
			}
			ToStringVisitor.addFactory(new PivotQVTrelationToStringFactory());
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("qvtr", txURI2);
			myQVT2.saveModels(null);
			myQVT2.checkOutput(txURI2, getModelsURI("families2persons/Families2Persons_expected.qvtras"), null);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
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
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT4 = createQVT("Families2Persons", txURI2);
		try {
			myQVT4.loadEPackage(txClass3, "Families.FamiliesPackage");
			myQVT4.loadEPackage(txClass3, "Persons.PersonsPackage");
			myQVT4.loadEPackage(txClass3, "trace_Families2Persons.trace_Families2PersonsPackage");
			//
			myQVT4.createGeneratedExecutor(txClass3);
			myQVT4.addInputURI("Families", getModelsURI("families2persons/samples/Families.xmi"));
			myQVT4.executeTransformation();
			myQVT4.addOutputURI("Persons", getTestURI("Persons_CG.xmi"));
			myQVT4.saveModels(null);
			myQVT4.checkOutput(getTestURI("Persons_CG.xmi"), getModelsURI("families2persons/samples/Persons_expected.xmi"), Families2PersonsNormalizer.INSTANCE);
		}
		finally {
			myQVT4.dispose();
			myQVT4 = null;
		}
	}

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
		//	System.out.println("\nocl " + NameUtil.debugSimpleName(ocl) + " : " + ecoreURI + " => " + asURI2a + "\n");
		try {
			Resource inputResource = ocl.getResourceSet().getResource(ecoreURI, true);
			assert inputResource != null;
			assertNoResourceErrors("Ecore load", inputResource);
			assertNoValidationErrors("Ecore load", inputResource);
			Ecore2AS ecore2as = Ecore2AS.getAdapter(inputResource, (EnvironmentFactoryInternal) ocl.getEnvironmentFactory());
			Model pivotModel = ecore2as.getASModel();
			ASResource asResource = (ASResource) pivotModel.eResource();
			asResource.setSaveable(true);
			asResource.setURI(asURI2a);
			assertNoResourceErrors("Ecore2AS failed", asResource);
			asResource.save(XMIUtil.createSaveOptions(asResource));
			assertNoResourceErrors("Save", asResource);
			assertValidationDiagnostics("Ecore2AS invalid", asResource, NO_MESSAGES);
		}
		finally {
			//	System.out.println("\nocl-dispose1 " + NameUtil.debugSimpleName(ocl));
			ocl.dispose();
			//	System.out.println("ocl-dispose2 " + NameUtil.debugSimpleName(ocl) + "\n");
			ocl = null;
		}
		MyQVT myQVT = createQVT("Forward2Reverse", getModelsURI("ecore2pivotRoot/Ecore2PivotRoot.qvtr"));
		//	System.out.println("\nqvt " + NameUtil.debugSimpleName(myQVT) + " : ecore2pivotRoot/Ecore2PivotRoot.qvtr\n");
		//	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		URI asURI2 = getTestURI("Families.ecore.oclas");
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("as");
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.addInputURI("ecore", ecoreURI);
			//	System.out.println("\nqvt-execute" + NameUtil.debugSimpleName(myQVT));
			myQVT.executeTransformation();
			myQVT.addOutputURI("as", asURI2);
			//	System.out.println("\nqvt-save" + NameUtil.debugSimpleName(myQVT));
			myQVT.saveModels(null);
			//	System.out.println("\nqvt-check" + NameUtil.debugSimpleName(myQVT));
			myQVT.checkOutput(asURI2, asURI2a, DummyPivotExternalURINormalizer.INSTANCE);
		}
		finally {
			//	System.out.println("\nqvt-dispose1 " + NameUtil.debugSimpleName(myQVT));
			myQVT.dispose();
			//	System.out.println("qvt-dispose2 " + NameUtil.debugSimpleName(myQVT) + "\n");
			myQVT = null;
		}
	}

	public void testQVTrCompiler_Ecore2PivotRoot_CG() throws Exception {
		//	StandaloneProjectMap.addTrace(EcorePackage.eNS_URI, ~0);
		//	StandaloneProjectMap.addTrace(OCLstdlibPackage.eNS_URI, ~0);
		//	StandaloneProjectMap.addTrace(PivotPackage.eNS_URI, ~0);
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
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
		URI txURI1 = getModelsURI("ecore2pivotRoot/Ecore2PivotRoot.qvtr");
		MyQVT myQVT1 = createQVT("Ecore2PivotRoot", txURI1);
		//	System.out.println("\nqvt " + NameUtil.debugSimpleName(myQVT1) + " : ecore2pivotRoot/Ecore2PivotRoot.qvtr\n");
		myQVT1.configureGeneratedPackage(EcorePackage.eNS_URI);
		myQVT1.configureGeneratedPackage(PivotPackage.eNS_URI);
		myQVT1.configureGeneratedPackage(OCLstdlibPackage.eNS_URI);
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
			//	System.out.println("\nqvt-dispose1 " + NameUtil.debugSimpleName(myQVT1));
			myQVT1.dispose();
			//	System.out.println("qvt-dispose2 " + NameUtil.debugSimpleName(myQVT1) + "\n");
			myQVT1 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
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
			asResource.setSaveable(true);
			asResource.setURI(asURI2a);
			assertNoResourceErrors("Ecore2AS failed", asResource);
			asResource.save(XMIUtil.createSaveOptions(asResource));
			assertNoResourceErrors("Save", asResource);
			assertValidationDiagnostics("Ecore2AS invalid", asResource, NO_MESSAGES);
		}
		finally {
			ocl.dispose();
			ocl = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
		//
		URI asURI2 = getTestURI("Families.ecore.oclas");
		MyQVT myQVT2 = createQVT("Ecore2PivotRoot", txURI1);
		//		MyQVT myQVT2 = new MyQVT(createTestProjectManager(), getTestBundleURI(), "models/families2persons", null);
		try {
			myQVT2.createGeneratedExecutor(txClass1);
			//			myQVT2.loadInput("ecore", getModelsURI("families2persons/Families.ecore"));
			myQVT2.addInputURI("ecore", ecoreURI);
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("as", asURI2);
			myQVT2.saveModels(null);
			myQVT2.checkOutput(asURI2, asURI2a, DummyPivotExternalURINormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
			cleanup("http://www.eclipse.org/qvtd-example/org/eclipse/ocl/pivot2/ecore2pivotRoot/Ecore2PivotRoot");
		}
	}

	public void testQVTrCompiler_Families2Persons_CG() throws Exception {
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		AbstractMerger.EARLY.setState(true);
		//		AbstractMerger.FAILURE.setState(true);
		//		AbstractMerger.LATE.setState(true);
		ConnectivityChecker.CONNECTIVITY_CLASSDATUMS.setState(true);
		ConnectivityChecker.CONNECTIVITY_CONNECTIONS.setState(true);
		ConnectivityChecker.CONNECTIVITY_EDGES.setState(true);
		ConnectivityChecker.CONNECTIVITY_NODES.setState(true);
		Class<? extends Transformer> txClass; // = Families2Persons.class;
		MyQVT myQVT1 = createQVT("Families2Persons", getModelsURI("families2persons/Families2Persons_expected.qvtras"));
		try {
			txClass = myQVT1.buildTransformation("Persons", false);//,
			myQVT1.assertRegionCount(RuleRegionImpl.class, 0);
			//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 4);
			((ASResource)myQVT1.getEnvironmentFactory().getASResourceSet().getResources().get(0)).setASonly(true);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("Families2Persons", getModelsURI("families2persons/Families2Persons_expected.qvtras"));
		try {
			myQVT2.loadEPackage(txClass, "Families.FamiliesPackage");
			myQVT2.loadEPackage(txClass, "Persons.PersonsPackage");
			myQVT2.loadEPackage(txClass, "trace_Families2Persons.trace_Families2PersonsPackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("Families", getModelsURI("families2persons/samples/Families.xmi"));
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("Persons", getTestURI("Persons_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("Persons_CG.xmi"), getModelsURI("families2persons/samples/Persons_expected.xmi"), Families2PersonsNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	}

	/*    public void testQVTrCompiler_ClassModelToClassModel() throws Exception {
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
	        myQVT.createGeneratedExecutor(txClass);
	    	myQVT.loadInput("uml1", "ClassUM1.xmi");
	    	myQVT.executeTransformation();
			myQVT.saveOutput("uml2", "ClassUM1_CG.xmi", "ClassUM1.xmi", null);
		}
		finally {
	    	myQVT.dispose();
			myQVT = null;
		}
    } */

	public void testQVTrCompiler_Forward2Reverse() throws Exception {
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.VARIABLES.setState(true);
		MyQVT myQVT = createQVT("Forward2Reverse", getModelsURI("forward2reverse/Forward2Reverse.qvtr"));
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation iTransformation = myQVT.compileTransformation("reverse");
			//
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("forward", getModelsURI("forward2reverse/samples/EmptyList.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("reverse", getTestURI("EmptyList_Interpreted.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("EmptyList_Interpreted.xmi"), getModelsURI("forward2reverse/samples/EmptyList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("forward", getModelsURI("forward2reverse/samples/OneElementList.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("reverse", getTestURI("OneElementList_Interpreted.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("OneElementList_Interpreted.xmi"), getModelsURI("forward2reverse/samples/OneElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("forward", getModelsURI("forward2reverse/samples/TwoElementList.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("reverse", getTestURI("TwoElementList_Interpreted.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("TwoElementList_Interpreted.xmi"), getModelsURI("forward2reverse/samples/TwoElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("forward", getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("reverse", getTestURI("ThreeElementList_Interpreted.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("ThreeElementList_Interpreted.xmi"), getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
			myQVT = null;
		}
	}

	public void testQVTrCompiler_Forward2Reverse_CG() throws Exception {
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.VARIABLES.setState(true);
		//		QVTp2QVTs.REGION_ORDER.setState(true);
		//		QVTr2QVTc.SYNTHESIS.setState(true);
		//		QVTscheduleConstants.CONNECTION_CREATION.setState(true);
		Class<? extends Transformer> txClass;
		MyQVT myQVT1 = createQVT("Forward2Reverse", getModelsURI("forward2reverse/Forward2Reverse.qvtr"));
		try {
			txClass = myQVT1.buildTransformation(new DefaultConfigurations(), false);//,
			//	txClass = myQVT1.buildTransformation(new SimpleConfigurations("reverse"), false);//,
			//			txClass = myQVT1.buildTransformation(Collections.singletonList(reverseOutputNames), false);//,
			//			Class<? extends Transformer> txClass = Forward2Reverse.class;
			//			myQVT1.assertRegionCount(ActivatorRegionImpl.class, 2);
			//	myQVT1.assertRegionCount(RuleRegionImpl.class, 1);
			//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 7);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("Forward2Reverse", getModelsURI("forward2reverse/Forward2Reverse.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "doublylinkedlist.doublylinkedlistPackage");
			myQVT2.loadEPackage(txClass, "trace_Forward2Reverse.trace_Forward2ReversePackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("forward", getModelsURI("forward2reverse/samples/EmptyList.xmi"));
			myQVT2.executeTransformation("reverse");
			myQVT2.addOutputURI("reverse", getTestURI("EmptyList_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("EmptyList_CG.xmi"), getModelsURI("forward2reverse/samples/EmptyList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("forward", getModelsURI("forward2reverse/samples/OneElementList.xmi"));
			myQVT2.executeTransformation("reverse");
			myQVT2.addOutputURI("reverse", getTestURI("OneElementList_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("OneElementList_CG.xmi"), getModelsURI("forward2reverse/samples/OneElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("forward", getModelsURI("forward2reverse/samples/TwoElementList.xmi"));
			myQVT2.executeTransformation("reverse");
			myQVT2.addOutputURI("reverse", getTestURI("TwoElementList_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("TwoElementList_CG.xmi"), getModelsURI("forward2reverse/samples/TwoElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("forward", getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
			myQVT2.executeTransformation("reverse");
			myQVT2.addOutputURI("reverse", getTestURI("ThreeElementList_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("ThreeElementList_CG.xmi"), getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("reverse", getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
			myQVT2.executeTransformation("forward");
			myQVT2.addOutputURI("forward", getTestURI("ThreeElementList_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("ThreeElementList_CG.xmi"), getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	}

	public void testQVTrCompiler_HierarchicalStateMachine2FlatStateMachine() throws Exception {
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT("HierarchicalStateMachine2FlatStateMachine", getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"));
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation iTransformation = myQVT.compileTransformation("flat");
			//
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("hier", getModelsURI("hstm2fstm/samples/MiniModel.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("flat", getTestURI("MiniModel_Interpreted.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("MiniModel_Interpreted.xmi"), getModelsURI("hstm2fstm/samples/MiniModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("hier", getModelsURI("hstm2fstm/samples/SimpleModel.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("flat", getTestURI("SimpleModel_Interpreted.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("SimpleModel_Interpreted.xmi"), getModelsURI("hstm2fstm/samples/SimpleModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(iTransformation);
			myQVT.addInputURI("hier", getModelsURI("hstm2fstm/samples/LargerModel.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("flat", getTestURI("LargerModel_Interpreted.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("LargerModel_Interpreted.xmi"), getModelsURI("hstm2fstm/samples/LargerModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
			myQVT = null;
		}
	}

	public void testQVTrCompiler_HierarchicalStateMachine2FlatStateMachine_CG() throws Exception {
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.VARIABLES.setState(true);
		ResourceSet resourceSet = new ResourceSetImpl();
		getTestProjectManager().initializeResourceSet(resourceSet);
		TestProject testProject = getTestProject();
		ContentEditingURIConverter uriConverter = new ContentEditingURIConverter(resourceSet.getURIConverter());
		uriConverter.addReplacement("http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/hstm2fstm/FlatStateMachine", "http://" + testProject.getName() + "/FlatStateMachine");
		uriConverter.addReplacement("http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/hstm2fstm/HierarchicalStateMachine", "http://" + testProject.getName() + "/HierarchicalStateMachine");
		TestFolder testFolder = testProject.getOutputFolder("samples");
		TestFile miniModelFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("hstm2fstm/samples/MiniModel.xmi"));
		TestFile simpleModelFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("hstm2fstm/samples/SimpleModel.xmi"));
		TestFile largerModelFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("hstm2fstm/samples/LargerModel.xmi"));
		TestFile miniModelExpectedFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("hstm2fstm/samples/MiniModel_expected.xmi"));
		TestFile simpleModelExpectedFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("hstm2fstm/samples/SimpleModel_expected.xmi"));
		TestFile largerModelExpectedFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("hstm2fstm/samples/LargerModel_expected.xmi"));
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"));
		testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/FlatStateMachine.ecore"));
		testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/HierarchicalStateMachine.ecore"));
		MyQVT myQVT1 = createQVT("HierarchicalStateMachine2FlatStateMachine", txFile.getURI());
		Class<? extends Transformer> txClass;
		try {
			txClass = myQVT1.buildTransformation("flat", false);//,
			myQVT1.assertRegionCount(RuleRegionImpl.class, 0);
			//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 6);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("HierarchicalStateMachine2FlatStateMachine", txFile.getURI());
		try {
			myQVT2.loadEPackage(txClass, "FlatStateMachine.FlatStateMachinePackage");
			myQVT2.loadEPackage(txClass, "HierarchicalStateMachine.HierarchicalStateMachinePackage");
			myQVT2.loadEPackage(txClass, "trace_HierarchicalStateMachine2FlatStateMachine.trace_HierarchicalStateMachine2FlatStateMachinePackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("hier", miniModelFile.getURI());
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("flat", getTestURI("MiniModel_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("MiniModel_CG.xmi"), miniModelExpectedFile.getURI(), FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("hier", simpleModelFile.getURI());
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("flat", getTestURI("SimpleModel_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("SimpleModel_CG.xmi"), simpleModelExpectedFile.getURI(), FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("hier", largerModelFile.getURI());
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("flat", getTestURI("LargerModel_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("LargerModel_CG.xmi"), largerModelExpectedFile.getURI(), FlatStateMachineNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	}

	public void testQVTrCompiler_HierarchicalStateMachine2FlatStateMachine_example_CG() throws Exception {
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.VARIABLES.setState(true);
		Class<? extends Transformer> txClass;
		URI txURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.hstm2fstm/model/HierarchicalStateMachine2FlatStateMachine.qvtr", true);
		MyQVT myQVT1 = createQVT("hstm2fstm", txURI);
		try {
			txClass = myQVT1.buildTransformation("flat", false);//,
			myQVT1.assertRegionCount(RuleRegionImpl.class, 0);
			//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 6);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("HierarchicalStateMachine2FlatStateMachine", getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "FlatStateMachine.FlatStateMachinePackage");
			myQVT2.loadEPackage(txClass, "HierarchicalStateMachine.HierarchicalStateMachinePackage");
			myQVT2.loadEPackage(txClass, "trace_HierarchicalStateMachine2FlatStateMachine.trace_HierarchicalStateMachine2FlatStateMachinePackage");
			//
			URI inURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.hstm2fstm/model/in/hier.xmi", true);
			URI outURI = getTestURI("generated_CG.xmi");
			URI expectedURI = URI.createPlatformResourceURI("/org.eclipse.qvtd.examples.qvtrelation.hstm2fstm/model/out/expected.xmi", true);
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("hier", inURI);
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("flat", outURI);
			myQVT2.saveModels(null);
			myQVT2.checkOutput(outURI, expectedURI, FlatStateMachineNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	}

	public void testQVTrCompiler_HierarchicalStateMachine2FlatStateMachine_iCG() throws Exception {
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.VARIABLES.setState(true);
		ResourceSet resourceSet = new ResourceSetImpl();
		getTestProjectManager().initializeResourceSet(resourceSet);
		TestProject testProject = getTestProject();
		ContentEditingURIConverter uriConverter = new ContentEditingURIConverter(resourceSet.getURIConverter());
		uriConverter.addReplacement("http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/hstm2fstm/FlatStateMachine", "http://" + testProject.getName() + "/FlatStateMachine");
		uriConverter.addReplacement("http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/hstm2fstm/HierarchicalStateMachine", "http://" + testProject.getName() + "/HierarchicalStateMachine");
		TestFolder testFolder = testProject.getOutputFolder("samples");
		TestFile miniModelFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("hstm2fstm/samples/MiniModel.xmi"));
		TestFile simpleModelFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("hstm2fstm/samples/SimpleModel.xmi"));
		TestFile largerModelFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("hstm2fstm/samples/LargerModel.xmi"));
		TestFile miniModelExpectedFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("hstm2fstm/samples/MiniModel_expected.xmi"));
		TestFile simpleModelExpectedFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("hstm2fstm/samples/SimpleModel_expected.xmi"));
		TestFile largerModelExpectedFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("hstm2fstm/samples/LargerModel_expected.xmi"));
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"));
		testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/FlatStateMachine.ecore"));
		testProject.copyFile(uriConverter, null, getModelsURI("hstm2fstm/HierarchicalStateMachine.ecore"));
		MyQVT myQVT1 = createQVT("HierarchicalStateMachine2FlatStateMachine", txFile.getURI());
		Class<? extends Transformer> txClass;
		try {
			txClass = myQVT1.buildTransformation("flat", true);//,
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("HierarchicalStateMachine2FlatStateMachine", txFile.getURI());
		try {
			myQVT2.loadEPackage(txClass, "FlatStateMachine.FlatStateMachinePackage");
			myQVT2.loadEPackage(txClass, "HierarchicalStateMachine.HierarchicalStateMachinePackage");
			myQVT2.loadEPackage(txClass, "trace_HierarchicalStateMachine2FlatStateMachine.trace_HierarchicalStateMachine2FlatStateMachinePackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("hier", miniModelFile.getURI());
			myQVT2.executeTransformation();
			myQVT2.writeGraphMLfile(getTestURI("MiniModel-incremental.graphml"));
			myQVT2.addOutputURI("flat", getTestURI("MiniModel_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("MiniModel_CG.xmi"), miniModelExpectedFile.getURI(), FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("hier", simpleModelFile.getURI());
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("flat", getTestURI("SimpleModel_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.writeGraphMLfile(getTestURI("SimpleModel-incremental.graphml"));
			myQVT2.checkOutput(getTestURI("SimpleModel_CG.xmi"), simpleModelExpectedFile.getURI(), FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("hier", largerModelFile.getURI());
			myQVT2.executeTransformation();
			myQVT2.writeGraphMLfile(getTestURI("LargerModel-incremental.graphml"));
			myQVT2.addOutputURI("flat", getTestURI("LargerModel_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("LargerModel_CG.xmi"), largerModelExpectedFile.getURI(), FlatStateMachineNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	}

	public void testQVTrCompiler_Iterated2Iterated_CG() throws Exception {
		//	StandaloneProjectMap.addTrace(EcorePackage.eNS_URI, ~0);
		//	StandaloneProjectMap.addTrace("http://www.eclipse.org/ocl/2015/Library", ~0);
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTp2QVTs.REGION_ORDER.setState(true);
		Class<? extends Transformer> txClass;
		MyQVT myQVT1 = createQVT("Iterated2Iterated", getModelsURI("iterated2iterated/Iterated2Iterated.qvtr"));
		myQVT1.addUsedGenPackage("org.eclipse.emf.ecore/model/Ecore.genmodel", "//ecore");
		try {
			ProjectManager projectMap = myQVT1.getProjectManager();
			projectMap.configure(myQVT1.getResourceSet(), StandaloneProjectMap.LoadFirstStrategy.INSTANCE, StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
			TypedModelsConfigurations typedModelsConfigurations = new TypedModelsConfigurations();
			typedModelsConfigurations.add(new TypedModelsConfiguration("to", "via"));
			txClass = myQVT1.buildTransformation(typedModelsConfigurations, false);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("Iterated2Iterated", getModelsURI("Iterated2Iterated/Iterated2Iterated.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "iterated.iteratedPackage");
			myQVT2.loadEPackage(txClass, "trace_Iterated2Iterated.trace_Iterated2IteratedPackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("from", getModelsURI("iterated2iterated/samples/testcase1-in.xmi"));
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("to", getTestURI("testcase1-out_CG.iterated"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("testcase1-out_CG.iterated"), getModelsURI("iterated2iterated/samples/testcase1-out.xmi"), null);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	}

	public void testQVTrCompiler_MiToSiSimple_CG() throws Exception {
		ToStringVisitor.SHOW_ALL_MULTIPLICITIES = true;
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.SYNTHESIS.setState(true);
		ResourceSet resourceSet = new ResourceSetImpl();
		getTestProjectManager().initializeResourceSet(resourceSet);
		TestProject testProject = getTestProject();
		ContentEditingURIConverter uriConverter = new ContentEditingURIConverter(resourceSet.getURIConverter());
		uriConverter.addReplacement("http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/mitosi/java", "http://" + testProject.getName() + "/java");
		uriConverter.addReplacement("http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/mitosi/uml", "http://" + testProject.getName() + "/uml");
		TestFolder testFolder = testProject.getOutputFolder("samples");
		TestFile javaFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("mitosi/samples/transportjava.xml"));
		TestFile umlFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("mitosi/samples/transportuml.xml"));
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("mitosi/MiToSiSimple.qvtr"));
		testProject.copyFile(uriConverter, null, getModelsURI("mitosi/javaMM.emof"));
		testProject.copyFile(uriConverter, null, getModelsURI("mitosi/umlMM.emof"));
		MyQVT myQVT1 = createQVT("MiToSiSimple", txFile.getURI());
		Class<? extends Transformer> txClass;
		try {
			txClass = myQVT1.buildTransformation("java", false);
			//
			//			myQVT1.assertRegionCount(BasicMappingRegionImpl.class, 0);
			//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 8);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("MiToSiSimple", txFile.getURI());
		try {
			myQVT2.loadEPackage(txClass, "javammsi.javammsiPackage");
			myQVT2.loadEPackage(txClass, "umlmmmi.umlmmmiPackage");
			myQVT2.loadEPackage(txClass, "trace_MiToSiSimple.trace_MiToSiSimplePackage");
			//
			Map<String, Object> extensionToFactoryMap = myQVT2.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap();
			extensionToFactoryMap.put("xml", new XMIResourceFactoryImpl());		// FIXME workaround BUG 527164
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("uml", umlFile.getURI());
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("java", getTestURI("transportjava_CG.xml"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("transportjava_CG.xml"), javaFile.getURI(), null);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	}

	public void testQVTrCompiler_MiToSiSimpleWithKeys_CG() throws Exception {
		ToStringVisitor.SHOW_ALL_MULTIPLICITIES = true;
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//	TracedHeadAnalysis.TRACED_HEAD_NODE_GROUPS.setState(true);
		//	TransformationPartitioner.PARTITION_IMMEDIATE_PREDECESSORS.setState(true);
		//	TransformationPartitioner.PARTITION_TRANSITIVE_PREDECESSORS.setState(true);
		//	TransformationPartitioner.PARTITION_TRANSITIVE_SUCCESSORS.setState(true);
		//	TransformationPartitioner.REGION_IMMEDIATE_PREDECESSORS.setState(true);
		//	TransformationPartitioner.REGION_TRANSITIVE_PREDECESSORS.setState(true);
		//	TransformationPartitioner.REGION_TRANSITIVE_SUCCESSORS.setState(true);
		//	TransformationPartitioner.ROOT_SCHEDULE_PREDECESSORS.setState(true);
		//	TransformationPartitioner.ROOT_SCHEDULE.setState(true);
		ResourceSet resourceSet = new ResourceSetImpl();
		getTestProjectManager().initializeResourceSet(resourceSet);
		TestProject testProject = getTestProject();
		ContentEditingURIConverter uriConverter = new ContentEditingURIConverter(resourceSet.getURIConverter());
		uriConverter.addReplacement("http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/mitosi/java", "http://" + testProject.getName() + "/java");
		uriConverter.addReplacement("http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/mitosi/uml", "http://" + testProject.getName() + "/uml");
		TestFolder testFolder = testProject.getOutputFolder("samples");
		TestFile javaFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("mitosi/samples/transportjava.xml"));
		TestFile umlFile = testProject.copyFile(uriConverter, testFolder, getModelsURI("mitosi/samples/transportuml.xml"));
		TestFile txFile = testProject.copyFile(uriConverter, null, getModelsURI("mitosi/MiToSiSimpleWithKeys.qvtr"));
		testProject.copyFile(uriConverter, null, getModelsURI("mitosi/javaMM.emof"));
		testProject.copyFile(uriConverter, null, getModelsURI("mitosi/umlMM.emof"));
		MyQVT myQVT1 = createQVT("MiToSiSimpleWithKeys", txFile.getURI());
		Class<? extends Transformer> txClass;
		try {
			txClass = myQVT1.buildTransformation("java", false);
			//			Class<? extends Transformer> txClass = MiToSiSimpleWithKeys.class;
			//
			//			myQVT1.assertRegionCount(BasicMappingRegionImpl.class, 0);
			//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 8);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("MiToSiSimple", txFile.getURI());
		try {
			myQVT2.loadEPackage(txClass, "javammsi.javammsiPackage");
			myQVT2.loadEPackage(txClass, "umlmmmi.umlmmmiPackage");
			myQVT2.loadEPackage(txClass, "trace_MiToSiSimpleWithKeys.trace_MiToSiSimpleWithKeysPackage");
			//
			Map<String, Object> extensionToFactoryMap = myQVT2.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap();
			extensionToFactoryMap.put("xml", new XMIResourceFactoryImpl());		// FIXME workaround BUG 527164
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("uml", umlFile.getURI());
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("java", getTestURI("transportjava_CG.xml"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("transportjava_CG.xml"), javaFile.getURI(), null);
			//
			//	        myQVT.createGeneratedExecutor(txClass);
			//	    	myQVT.loadInput("seqDgm", "SeqUM.xmi");
			//	    	myQVT.executeTransformation();
			//			myQVT.saveOutput("stm", "StmcUM_CG.xmi", "StmcUM_expected.xmi", null);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	}

	/*	public void testQVTrCompiler_PartialPhilosophers_CG() throws Exception {	// For Bug 515490 discussion - doesn't work
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
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("SeqToStm", getModelsURI("partialPhilosophers/PartialPhilosophers.qvtr"));
		try {
			//	myQVT2.loadEPackage(txClass, "SeqMM.SeqMMPackage");
			//	myQVT2.loadEPackage(txClass, "StmcMM.StmcMMPackage");
			//	myQVT2.loadEPackage(txClass, "trace_SeqToStm.trace_SeqToStmPackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("from", getModelsURI("partialPhilosophers/samples/Table3.xmi"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("to", getTestURI("Table3_CG.xmi"), getModelsURI("partialPhilosophers/samples/Table3_expected.xmi"), null);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	} */

	/*	public void testQVTrCompiler_Persons2Families_CG() throws Exception {
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
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("Persons2Families", getModelsURI("persons2families/Persons2Families.qvtr"));
		try {
			Map<String, Object> extensionToFactoryMap = myQVT2.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap();
			extensionToFactoryMap.put("xml", new XMIResourceFactoryImpl());		// FIXME workaround BUG 527164
			//
			TransformationExecutor txExecutor1 = myQVT2.createGeneratedExecutor(txClass);
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

			TransformationExecutor txExecutor2 = myQVT2.createGeneratedExecutor(txClass);
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

	/*	public void testQVTrCompiler_Persons2Families() throws Exception {
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

	public void testQVTrCompiler_Persons2Names2Families_CG() throws Exception {
		ToStringVisitor.SHOW_ALL_MULTIPLICITIES = true;
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
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
			myQVT1.activate();
			myQVT1.dispose();
			myQVT1 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("Persons2Names2Families", txFile.getURI());
		try {
			Map<String, Object> extensionToFactoryMap = myQVT2.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap();
			extensionToFactoryMap.put("xml", new XMIResourceFactoryImpl());		// FIXME workaround BUG 527164
			//
			myQVT2.loadEPackage(txClass, "Families.FamiliesPackage");
			myQVT2.loadEPackage(txClass, "Persons.PersonsPackage");
			myQVT2.loadEPackage(txClass, "Names.NamesPackage");
			myQVT2.loadEPackage(txClass, "trace_Persons2Names2Families.trace_Persons2Names2FamiliesPackage");
			//
			TransformationExecutor txExecutor1 = myQVT2.createGeneratedExecutor(txClass);
			txExecutor1.setContextualProperty("PREFER_EXISTING_FAMILY_TO_NEW", Boolean.FALSE);
			txExecutor1.setContextualProperty("PREFER_CREATING_PARENT_TO_CHILD", Boolean.FALSE);
			txExecutor1.addInputURI("persons", personFile.getURI());
			txExecutor1.addInputURI("familiesLeft", familyFile.getURI());
			txExecutor1.execute("families");
			txExecutor1.addOutputURI("names", namesOutURI);
			txExecutor1.addOutputURI("familiesRight", familiesOutURI);
			txExecutor1.saveModels(null);
			myQVT2.checkOutput(namesOutURI, refNamesFile.getURI(), NamesNormalizer.INSTANCE);
			myQVT2.checkOutput(familiesOutURI, refFamilyFile.getURI(), null); //FamilyPlansNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	}

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
		MyQVT myQVT = createQVT("Persons2Names2Families", txFile.getURI());
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation(TargetConfiguration.createTargetConfigurations("families", "persons"));
			Map<String, Object> extensionToFactoryMap = myQVT.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap();
			extensionToFactoryMap.put("xml", new XMIResourceFactoryImpl());		// FIXME workaround BUG 527164
			//
			BasicQVTiExecutor txExecutor1 = myQVT.createInterpretedExecutor(QVTimperativeUtil.getEntryPoint(asTransformation, "families"));
			txExecutor1.setContextualProperty("PREFER_EXISTING_FAMILY_TO_NEW", Boolean.FALSE);
			txExecutor1.setContextualProperty("PREFER_EXISTING_FAMILY_TO_NEW", Boolean.FALSE);
			txExecutor1.setContextualProperty("PREFER_CREATING_PARENT_TO_CHILD", Boolean.FALSE);
			txExecutor1.addInputURI("persons", personFile.getURI());
			txExecutor1.addInputURI("familiesLeft", familyFile.getURI());
			txExecutor1.execute();
			txExecutor1.addOutputURI("names", namesOutURI);
			txExecutor1.addOutputURI("familiesRight", familiesOutURI);
			txExecutor1.saveModels(null);
			myQVT.checkOutput(namesOutURI, refNamesFile.getURI(), NamesNormalizer.INSTANCE);
			myQVT.checkOutput(familiesOutURI, refFamilyFile.getURI(), null); //FamilyPlansNormalizer.INSTANCE);
		}
		finally {
			myQVT.activate();
			myQVT.dispose();
			myQVT = null;
		}
	}

	public void testQVTrCompiler_SeqToStm() throws Exception {
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT("SeqToStm", getModelsURI("seq2stm/SeqToStm.qvtr"));
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("stm");
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.addInputURI("seqDgm", getModelsURI("seq2stm/samples/Seq.xmi"));
			myQVT.executeTransformation();
			myQVT.addOutputURI("stm", getTestURI("Stmc_Interpreted.xmi"));
			myQVT.addOutputURI(QVTbaseUtil.TRACE_TYPED_MODEL_NAME, getTestURI("Seq2Stmc_trace.xmi"));
			myQVT.saveModels(null);
			myQVT.checkOutput(getTestURI("Stmc_Interpreted.xmi"), getModelsURI("seq2stm/samples/Stmc_expected.xmi"), null);
		}
		finally {
			myQVT.dispose();
			myQVT = null;
		}
	}

	public void testQVTrCompiler_SeqToStm_CG() throws Exception {
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		Class<? extends Transformer> txClass;
		MyQVT myQVT1 = createQVT("SeqToStm", getModelsURI("seq2stm/SeqToStm.qvtr"));
		try {
			txClass = myQVT1.buildTransformation("stm", false);//,
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
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("SeqToStm", getModelsURI("seq2stm/SeqToStm.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "SeqMM.SeqMMPackage");
			myQVT2.loadEPackage(txClass, "StmcMM.StmcMMPackage");
			myQVT2.loadEPackage(txClass, "trace_SeqToStm.trace_SeqToStmPackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("seqDgm", getModelsURI("seq2stm/samples/Seq.xmi"));
			myQVT2.executeTransformation();
			myQVT2.addOutputURI("stm", getTestURI("Stmc_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("Stmc_CG.xmi"), getModelsURI("seq2stm/samples/Stmc_expected.xmi"), null);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	}

	public void testQVTrCompiler_SeqToStm_iCG() throws Exception {
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		Class<? extends Transformer> txClass;
		MyQVT myQVT1 = createQVT("SeqToStm", getModelsURI("seq2stm/SeqToStm.qvtr"));
		try {
			txClass = myQVT1.buildTransformation("stm", true);//,
			//					"SeqMM.SeqMMPackage", "PSeqToStm.PSeqToStmPackage");
			//
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("SeqToStm", getModelsURI("seq2stm/SeqToStm.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "SeqMM.SeqMMPackage");
			myQVT2.loadEPackage(txClass, "StmcMM.StmcMMPackage");
			myQVT2.loadEPackage(txClass, "trace_SeqToStm.trace_SeqToStmPackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("seqDgm", getModelsURI("seq2stm/samples/Seq.xmi"));
			myQVT2.executeTransformation();
			myQVT2.writeGraphMLfile(getTestURI("SeqToStm-incremental.graphml"));
			myQVT2.addOutputURI("stm", getTestURI("Stmc_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("Stmc_CG.xmi"), getModelsURI("seq2stm/samples/Stmc_expected.xmi"), null);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	}

	public void testQVTrCompiler_TinyIsomorph_CG() throws Exception {
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.VARIABLES.setState(true);
		//		QVTp2QVTs.REGION_ORDER.setState(true);
		//		QVTr2QVTc.SYNTHESIS.setState(true);
		//		QVTscheduleConstants.CONNECTION_CREATION.setState(true);
		Class<? extends Transformer> txClass;
		MyQVT myQVT1 = createQVT("TinyIsomorph", getModelsURI("tinyisomorph/TinyIsomorph.qvtr"));
		try {
			txClass = myQVT1.buildTransformation(new DefaultConfigurations(), false);//,
			//			txClass = myQVT1.buildTransformation(Collections.singletonList(reverseOutputNames), false);//,
			//			Class<? extends Transformer> txClass = Forward2Reverse.class;
			//			myQVT1.assertRegionCount(ActivatorRegionImpl.class, 2);
			//	myQVT1.assertRegionCount(RuleRegionImpl.class, 1);
			//			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 7);
		}
		finally {
			myQVT1.dispose();
			myQVT1 = null;
		}
		ThreadLocalExecutor.resetEnvironmentFactory();
		MyQVT myQVT2 = createQVT("TinyIsomorph", getModelsURI("tinyisomorph/TinyIsomorph.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "mma.mmaPackage");
			myQVT2.loadEPackage(txClass, "trace_TinyIsomorph.trace_TinyIsomorphPackage");
			myQVT2.loadEPackage(txClass, "mmb.mmbPackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("mma", getModelsURI("tinyisomorph/samples/Zero.xmi"));
			myQVT2.executeTransformation("mmb");
			myQVT2.addOutputURI("mmb", getTestURI("Zero_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("Zero_CG.xmi"), getModelsURI("tinyisomorph/samples/Zero_expected.xmi"), null);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("mma", getModelsURI("tinyisomorph/samples/One.xmi"));
			myQVT2.executeTransformation("mmb");
			myQVT2.addOutputURI("mmb", getTestURI("One_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("One_CG.xmi"), getModelsURI("tinyisomorph/samples/One_expected.xmi"), null);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("mma", getModelsURI("tinyisomorph/samples/Two.xmi"));
			myQVT2.executeTransformation("mmb");
			myQVT2.addOutputURI("mmb", getTestURI("Two_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("Two_CG.xmi"), getModelsURI("tinyisomorph/samples/Two_expected.xmi"), null);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.addInputURI("mma", getModelsURI("tinyisomorph/samples/Three.xmi"));
			myQVT2.executeTransformation("mmb");
			myQVT2.addOutputURI("mmb", getTestURI("Three_CG.xmi"));
			myQVT2.saveModels(null);
			myQVT2.checkOutput(getTestURI("Three_CG.xmi"), getModelsURI("tinyisomorph/samples/Three_expected.xmi"), null);
		}
		finally {
			myQVT2.dispose();
			myQVT2 = null;
		}
	}

	/*
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
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("seqDgm", "Seq.xmi");
			Transformer tx = myQVT.executeTransformation();
			Execution2GraphVisitor.writeGraphMLfile(tx, getTestModelsFileURI("seq2stm/temp/SeqToStm-incremental.graphml"));
			myQVT.saveOutput("stm", "Stmc_CG.xmi", "Stmc_expected.xmi", null);
			//
			//	        myQVT.createGeneratedExecutor(txClass);
			//	    	myQVT.loadInput("seqDgm", "SeqUM.xmi");
			//	    	myQVT.executeTransformation();
			//			myQVT.saveOutput("stm", "StmcUM_CG.xmi", "StmcUM_expected.xmi", null);
		}
		finally {
			myQVT.dispose();
			myQVT = null;
		}
	} */

	/*
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
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("relations", "MiniSeq2Stm.qvtras");
			myQVT.executeTransformation();
			//	    	myQVT.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",  new EcoreResourceFactoryImpl());
			//	    	myQVT.getEnvironmentFactory().getMetamodelManager().getASResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",  new EcoreResourceFactoryImpl());
			Resource outputResource = myQVT.saveOutput("core", "MiniSeq2Stm_CG.oclas", null, null);
			myQVT.saveOutput(QVTscheduleConstants.MIDDLE_DOMAIN_NAME, "MiniSeq2Stm_CG_Trace.xmi", null, null);
			myQVT.checkOutput(outputResource, "MiniSeq2Stm_expected.oclas", PivotNormalizer.INSTANCE);
			//
			//	        myQVT.createGeneratedExecutor(txClass);
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
