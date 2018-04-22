/*******************************************************************************
 * Copyright (c) 2012, 2018 Willink Transformations and others.
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
import java.util.Map;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.m2m.atl.dsls.core.EMFTCSInjector;
import org.eclipse.m2m.atl.emftvm.compiler.AtlResourceFactoryImpl;
import org.eclipse.m2m.atl.engine.parser.AtlParser;
import org.eclipse.ocl.examples.codegen.dynamic.JavaFileUtil;
import org.eclipse.ocl.examples.xtext.tests.TestFileSystemHelper;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.ProjectMap;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ConnectivityChecker;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.EarlyMerger;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.LateConsumerMerger;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.Execution2GraphVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationToStringVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl;
import org.eclipse.qvtd.pivot.qvttemplate.utilities.QVTtemplateToStringVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests that QVTc files can be compiled and executed.
 */
public class QVTrCompilerTests extends LoadTestCase
{
	protected class MyQVT extends AbstractTestQVT
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
					public @NonNull ScheduleManager execute(@NonNull Resource qvtrResource, @NonNull Resource traceResource, @NonNull String enforcedOutputName) throws IOException {
						ScheduleManager scheduleManager = super.execute(qvtrResource, traceResource, enforcedOutputName);
						instrumentRegion(scheduleManager);
						return scheduleManager;
					}
				};
			}
		}

		private boolean keepOldJavaFiles = false;

		public MyQVT(@NonNull ProjectManager projectManager, @NonNull String testProjectName, @NonNull URI testBundleURI, @NonNull URI txURI, @NonNull URI intermediateFileNamePrefixURI, @NonNull URI srcFileURI, @NonNull URI binFileURI) {
			super(projectManager, testProjectName, testBundleURI, txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
		}

		@Override
		protected @NonNull CompilerOptions createBuildCompilerChainOptions(boolean isIncremental) {
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
		protected boolean generateGenModel() {
			return true;
		}

		@Override
		protected @NonNull String getBasePrefix() {
			return "org.eclipse.qvtd.xtext.qvtrelation.tests";
		}

		@Override
		protected @NonNull ProjectManager getTestProjectManager() throws Exception {
			return EMFPlugin.IS_ECLIPSE_RUNNING ? new ProjectMap(true) : QVTrCompilerTests.this.getTestProjectManager();
		}

		protected void setKeepOldJavaFiles() {
			this.keepOldJavaFiles = true;
		}
	}

	protected static class PivotQVTrelationToStringFactory implements QVTtemplateToStringVisitor.Factory
	{
		protected PivotQVTrelationToStringFactory() {
			ToStringVisitor.addFactory(this);
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

	protected @NonNull MyQVT createQVT(@NonNull String resultPrefix, @NonNull URI txURI) throws Exception {
		ProjectManager testProjectManager = getTestProjectManager();
		URI intermediateFileNamePrefixURI = getTestURI(resultPrefix);
		URI srcFileURI = getTestFileURI(JavaFileUtil.TEST_SRC_FOLDER_NAME + "/");
		URI binFileURI = getTestFileURI(JavaFileUtil.TEST_BIN_FOLDER_NAME + "/");
		return new MyQVT(testProjectManager, getTestProject().getName(), getTestBundleURI(), txURI, intermediateFileNamePrefixURI, srcFileURI, binFileURI);
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
		BaseLinkingService.DEBUG_RETRY.setState(true);
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
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		AbstractMerger.EARLY.setState(true);
		//		AbstractMerger.FAILURE.setState(true);
		//		AbstractMerger.LATE.setState(true);
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
		myQVT1.addClasspathProjectName("org.eclipse.m2m.atl.common");
		myQVT1.addClasspathProjectName("org.eclipse.qvtd.pivot.qvtbase");
		myQVT1.addClasspathProjectName("org.eclipse.qvtd.pivot.qvtrelation");
		myQVT1.addClasspathProjectName("org.eclipse.qvtd.pivot.qvttemplate");
		myQVT1.addClasspathProjectName("org.eclipse.qvtd.atl");
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
		}
		URI txURI2 = getTestURI("Families2Persons_CG.qvtras");
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
			myQVT2.saveOutput("qvtr", txURI2, getModelsURI("families2persons/Families2Persons_expected.qvtras"), null);
		}
		finally {
			myQVT2.dispose();
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
			myQVT3.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT3.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			myQVT3.assertRegionCount(MicroMappingRegionImpl.class, 4);
		}
		finally {
			myQVT3.dispose();
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
		}
	}

	/*	@Test
	public void testQVTrCompiler_ATL2QVTr_CG_exec() throws Exception {
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		AbstractTransformer.EXCEPTIONS.setState(true);
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
		Class<? extends Transformer> txClass1 = org.eclipse.qvtd.xtext.qvtrelation.tests.newatl2qvtr.NewATL2QVTr.class;
		//		URI txURI1 = getModelsURI("newATL2QVTr/NewATL2QVTr.qvtr");

		URI txURI2 = getTestURI("Families2Persons_CG.qvtras");
		MyQVT myQVT2 = createQVT("ATL2QVTr", txURI2);
		//		MyQVT myQVT2 = new MyQVT(createTestProjectManager(), getTestBundleURI(), "models/families2persons", null);
		try {
			myQVT2.createGeneratedExecutor(txClass1);
			//			if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			EMFTCSInjector.class.getName();				// Hidden ATL dependency
			AtlParser.class.getName();					// Hidden ATL dependency
			myQVT2.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("atl", new AtlResourceFactoryImpl());
			myQVT2.loadInput("atl", getModelsURI("families2persons/Families2Persons2.atl"));
			//			}
			//			else {
			//				myQVT2.loadInput("atl", getModelsURI("families2persons/Families2Persons.atl.xmi"));		// FIXME Working around BUG 514604
			//			}
			ToStringVisitor.addFactory(new PivotQVTrelationToStringFactory());
			myQVT2.executeTransformation();
			myQVT2.saveOutput("qvtr", txURI2, getModelsURI("families2persons/Families2Persons_expected.qvtras"), null);
		}
		finally {
			myQVT2.dispose();
		}
		Class<? extends Transformer> txClass3;
		MyQVT myQVT3 = createQVT("Families2Persons", txURI2);
		//		MyQVT myQVT3 = new MyQVT(createTestProjectManager(), getTestBundleURI(), "models/families2persons", "samples");
		//		myQVT3.addRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.models.families2persons.Families.FamiliesPackage");
		//		myQVT3.addRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.models.families2persons.Persons.PersonsPackage");
		//		myQVT3.addRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.models.families2persons.trace_Families2Persons.trace_Families2PersonsPackage");
		try {
			txClass3 = myQVT3.buildTransformation("Persons", false);//,
			myQVT3.assertRegionCount(RuleRegionImpl.class, 2);
			myQVT3.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT3.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			myQVT3.assertRegionCount(MicroMappingRegionImpl.class, 0);
		}
		finally {
			myQVT3.dispose();
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
		}
	} */

	@Test
	public void testQVTrCompiler_Ecore2Pivot_CG() throws Exception {
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
		Class<? extends Transformer> txClass1 = null;
		//		URI txURI1 = URI.createPlatformResourceURI("/org.eclipse.ocl.pivot/model/Ecore2Pivot.qvtr", true);
		URI txURI1 = getModelsURI("ecore2pivot/Ecore2Pivot.qvtr");
		MyQVT myQVT1 = createQVT("Ecore2Pivot", txURI1);
		myQVT1.addUsedGenPackage("org.eclipse.emf.ecore/model/Ecore.genmodel", "//ecore");
		myQVT1.addUsedGenPackage("org.eclipse.ocl.pivot/model/Pivot.genmodel", "//pivot");
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
		}
		URI asURI2 = getTestURI("Families.ecore.oclas");
		MyQVT myQVT2 = createQVT("Ecore2Pivot", txURI1);
		//		MyQVT myQVT2 = new MyQVT(createTestProjectManager(), getTestBundleURI(), "models/families2persons", null);
		try {
			myQVT2.createGeneratedExecutor(txClass1);
			myQVT2.loadInput("ecore", getModelsURI("families2persons/Families.ecore"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("as", asURI2, getModelsURI("ecore2pivot/Families_expected.ecore.oclas"), null);
		}
		finally {
			myQVT2.dispose();
		}
	}

	@Test
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
			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 4);
		}
		finally {
			myQVT1.dispose();
		}
		MyQVT myQVT2 = createQVT("Forward2Reverse", getModelsURI("forward2reverse/Forward2Reverse.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "Families.FamiliesPackage");
			myQVT2.loadEPackage(txClass, "Persons.PersonsPackage");
			myQVT2.loadEPackage(txClass, "trace_Families2Persons.trace_Families2PersonsPackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("Families", getModelsURI("families2persons/samples/Families.xmi"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("Persons", getTestURI("Persons_CG.xmi"), getModelsURI("families2persons/samples/Persons_expected.xmi"), Families2PersonsNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
		}
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
	        myQVT.createGeneratedExecutor(txClass);
	    	myQVT.loadInput("uml1", "ClassUM1.xmi");
	    	myQVT.executeTransformation();
			myQVT.saveOutput("uml2", "ClassUM1_CG.xmi", "ClassUM1.xmi", null);
		}
		finally {
	    	myQVT.dispose();
		}
    } */

	@Test
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
			ImperativeTransformation asTransformation = myQVT.compileTransformation("reverse");
			//
			/*			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("forward", getModelsURI("forward2reverse/samples/EmptyList.xmi"));
			myQVT.createModel("reverse", getTestURI("EmptyList_Interpreted.xmi"));
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", getTestURI("EmptyList_Interpreted.xmi"), getModelsURI("forward2reverse/samples/EmptyList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			 */			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("forward", getModelsURI("forward2reverse/samples/OneElementList.xmi"));
			myQVT.createModel("reverse", getTestURI("OneElementList_Interpreted.xmi"));
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", getTestURI("OneElementList_Interpreted.xmi"), getModelsURI("forward2reverse/samples/OneElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			/*			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("forward", getModelsURI("forward2reverse/samples/TwoElementList.xmi"));
			myQVT.createModel("reverse", getTestURI("TwoElementList_Interpreted.xmi"));
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", getTestURI("TwoElementList_Interpreted.xmi"), getModelsURI("forward2reverse/samples/TwoElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("forward", getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
			myQVT.createModel("reverse", getTestURI("ThreeElementList_Interpreted.xmi"));
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", getTestURI("ThreeElementList_Interpreted.xmi"), getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			 */		}
		finally {
			myQVT.dispose();
		}
	}

	@Test
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
		Class<? extends Transformer> txClass;
		MyQVT myQVT1 = createQVT("Forward2Reverse", getModelsURI("forward2reverse/Forward2Reverse.qvtr"));
		try {
			txClass = myQVT1.buildTransformation("reverse", false);//,
			//			Class<? extends Transformer> txClass = Forward2Reverse.class;
			//			myQVT1.assertRegionCount(ActivatorRegionImpl.class, 2);
			myQVT1.assertRegionCount(RuleRegionImpl.class, 1);
			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 7);
		}
		finally {
			myQVT1.dispose();
		}
		MyQVT myQVT2 = createQVT("Forward2Reverse", getModelsURI("forward2reverse/Forward2Reverse.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "doublylinkedlist.doublylinkedlistPackage");
			myQVT2.loadEPackage(txClass, "trace_Forward2Reverse.trace_Forward2ReversePackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("forward", getModelsURI("forward2reverse/samples/EmptyList.xmi"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("reverse", getTestURI("EmptyList_CG.xmi"), getModelsURI("forward2reverse/samples/EmptyList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("forward", getModelsURI("forward2reverse/samples/OneElementList.xmi"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("reverse", getTestURI("OneElementList_CG.xmi"), getModelsURI("forward2reverse/samples/OneElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("forward", getModelsURI("forward2reverse/samples/TwoElementList.xmi"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("reverse", getTestURI("TwoElementList_CG.xmi"), getModelsURI("forward2reverse/samples/TwoElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("forward", getModelsURI("forward2reverse/samples/ThreeElementList.xmi"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("reverse", getTestURI("ThreeElementList_CG.xmi"), getModelsURI("forward2reverse/samples/ThreeElementList_expected.xmi"), Forward2ReverseNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
		}
	}

	@Test
	public void testQVTrCompiler_HierarchicalStateMachine2FlatStateMachine() throws Exception {
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT("HierarchicalStateMachine2FlatStateMachine", getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"));
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("flat");
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("hier", getModelsURI("hstm2fstm/samples/MiniModel.xmi"));
			//	    	myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "HierarchicalStateMachine2FlatStateMachine_trace.xmi");
			myQVT.createModel("flat", getTestURI("MiniModel_Interpreted.xmi"));
			myQVT.executeTransformation();
			myQVT.saveOutput("flat", getTestURI("MiniModel_Interpreted.xmi"), getModelsURI("hstm2fstm/samples/MiniModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("hier", getModelsURI("hstm2fstm/samples/SimpleModel.xmi"));
			//	    	myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "HierarchicalStateMachine2FlatStateMachine_trace.xmi");
			myQVT.createModel("flat", getTestURI("SimpleModel_Interpreted.xmi"));
			myQVT.executeTransformation();
			myQVT.saveOutput("flat", getTestURI("SimpleModel_Interpreted.xmi"), getModelsURI("hstm2fstm/samples/SimpleModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("hier", getModelsURI("hstm2fstm/samples/LargerModel.xmi"));
			//	    	myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "HierarchicalStateMachine2FlatStateMachine_trace.xmi");
			myQVT.createModel("flat", getTestURI("LargerModel_Interpreted.xmi"));
			myQVT.executeTransformation();
			myQVT.saveOutput("flat", getTestURI("LargerModel_Interpreted.xmi"), getModelsURI("hstm2fstm/samples/LargerModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
		}
	}

	@Test
	public void testQVTrCompiler_HierarchicalStateMachine2FlatStateMachine_CG() throws Exception {
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.VARIABLES.setState(true);
		Class<? extends Transformer> txClass;
		MyQVT myQVT1 = createQVT("HierarchicalStateMachine2FlatStateMachine", getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"));
		try {
			txClass = myQVT1.buildTransformation("flat", false);//,
			myQVT1.assertRegionCount(RuleRegionImpl.class, 0);
			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 6);
		}
		finally {
			myQVT1.dispose();
		}
		MyQVT myQVT2 = createQVT("HierarchicalStateMachine2FlatStateMachine", getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "FlatStateMachine.FlatStateMachinePackage");
			myQVT2.loadEPackage(txClass, "HierarchicalStateMachine.HierarchicalStateMachinePackage");
			myQVT2.loadEPackage(txClass, "trace_HierarchicalStateMachine2FlatStateMachine.trace_HierarchicalStateMachine2FlatStateMachinePackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("hier", getModelsURI("hstm2fstm/samples/MiniModel.xmi"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("flat", getTestURI("MiniModel_CG.xmi"), getModelsURI("hstm2fstm/samples/MiniModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("hier", getModelsURI("hstm2fstm/samples/SimpleModel.xmi"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("flat", getTestURI("SimpleModel_CG.xmi"), getModelsURI("hstm2fstm/samples/SimpleModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("hier", getModelsURI("hstm2fstm/samples/LargerModel.xmi"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("flat", getTestURI("LargerModel_CG.xmi"), getModelsURI("hstm2fstm/samples/LargerModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
		}
	}

	@Test
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
			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 6);
		}
		finally {
			myQVT1.dispose();
		}
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
			myQVT2.loadInput("hier", inURI);
			myQVT2.executeTransformation();
			myQVT2.saveOutput("flat", outURI, expectedURI, FlatStateMachineNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
		}
	}

	@Test
	public void testQVTrCompiler_HierarchicalStateMachine2FlatStateMachine_iCG() throws Exception {
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.VARIABLES.setState(true);
		Class<? extends Transformer> txClass;
		MyQVT myQVT1 = createQVT("HierarchicalStateMachine2FlatStateMachine", getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"));
		try {
			txClass = myQVT1.buildTransformation("flat", true);//,
		}
		finally {
			myQVT1.dispose();
		}
		MyQVT myQVT2 = createQVT("HierarchicalStateMachine2FlatStateMachine", getModelsURI("hstm2fstm/HierarchicalStateMachine2FlatStateMachine.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "FlatStateMachine.FlatStateMachinePackage");
			myQVT2.loadEPackage(txClass, "HierarchicalStateMachine.HierarchicalStateMachinePackage");
			myQVT2.loadEPackage(txClass, "trace_HierarchicalStateMachine2FlatStateMachine.trace_HierarchicalStateMachine2FlatStateMachinePackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("hier", getModelsURI("hstm2fstm/samples/MiniModel.xmi"));
			Transformer tx = myQVT2.executeTransformation();
			Execution2GraphVisitor.writeGraphMLfile(tx, getTestURI("MiniModel-incremental.graphml"));
			myQVT2.saveOutput("flat", getTestURI("MiniModel_CG.xmi"), getModelsURI("hstm2fstm/samples/MiniModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("hier", getModelsURI("hstm2fstm/samples/SimpleModel.xmi"));
			tx = myQVT2.executeTransformation();
			Execution2GraphVisitor.writeGraphMLfile(tx, getTestURI("SimpleModel-incremental.graphml"));
			myQVT2.saveOutput("flat", getTestURI("SimpleModel_CG.xmi"), getModelsURI("hstm2fstm/samples/SimpleModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("hier", getModelsURI("hstm2fstm/samples/LargerModel.xmi"));
			tx = myQVT2.executeTransformation();
			Execution2GraphVisitor.writeGraphMLfile(tx, getTestURI("LargerModel-incremental.graphml"));
			myQVT2.saveOutput("flat", getTestURI("LargerModel_CG.xmi"), getModelsURI("hstm2fstm/samples/LargerModel_expected.xmi"), FlatStateMachineNormalizer.INSTANCE);
		}
		finally {
			myQVT2.dispose();
		}
	}

	@Test
	public void testQVTrCompiler_Iterated2Iterated_CG() throws Exception {
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
			txClass = myQVT1.buildTransformation("to", false);
		}
		finally {
			myQVT1.dispose();
		}
		MyQVT myQVT2 = createQVT("Iterated2Iterated", getModelsURI("Iterated2Iterated/Iterated2Iterated.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "iterated.iteratedPackage");
			myQVT2.loadEPackage(txClass, "trace_Iterated2Iterated.trace_Iterated2IteratedPackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("from", getModelsURI("iterated2iterated/samples/testcase1-in.xmi"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("to", getTestURI("testcase1-out_CG.iterated"), getModelsURI("iterated2iterated/samples/testcase1-out.xmi"), null);
		}
		finally {
			myQVT2.dispose();
		}
	}

	@Test
	public void testQVTrCompiler_MiToSiSimple_CG() throws Exception {
		ToStringVisitor.SHOW_ALL_MULTIPLICITIES = true;
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.SYNTHESIS.setState(true);
		Class<? extends Transformer> txClass;
		MyQVT myQVT1 = createQVT("MiToSiSimple", getModelsURI("mitosi/MiToSiSimple.qvtr"));
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
		}
		MyQVT myQVT2 = createQVT("MiToSiSimple", getModelsURI("mitosi/MiToSiSimple.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "javammsi.javammsiPackage");
			myQVT2.loadEPackage(txClass, "umlmmmi.umlmmmiPackage");
			myQVT2.loadEPackage(txClass, "trace_MiToSiSimple.trace_MiToSiSimplePackage");
			//
			Map<String, Object> extensionToFactoryMap = myQVT2.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap();
			extensionToFactoryMap.put("xml", new XMIResourceFactoryImpl());		// FIXME workaround BUG 527164
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("uml", getModelsURI("mitosi/samples/transportuml.xml"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("java", getTestURI("transportjava_CG.xml"), getModelsURI("mitosi/samples/transportjava.xml"), null);
		}
		finally {
			myQVT2.dispose();
		}
	}

	@Test
	public void testQVTrCompiler_MiToSiSimpleWithKeys_CG() throws Exception {
		ToStringVisitor.SHOW_ALL_MULTIPLICITIES = true;
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		Class<? extends Transformer> txClass;
		MyQVT myQVT1 = createQVT("MiToSiSimpleWithKeys", getModelsURI("mitosi/MiToSiSimpleWithKeys.qvtr"));
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
		}
		MyQVT myQVT2 = createQVT("MiToSiSimple", getModelsURI("mitosi/MiToSiSimple.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "javammsi.javammsiPackage");
			myQVT2.loadEPackage(txClass, "umlmmmi.umlmmmiPackage");
			myQVT2.loadEPackage(txClass, "trace_MiToSiSimpleWithKeys.trace_MiToSiSimpleWithKeysPackage");
			//
			Map<String, Object> extensionToFactoryMap = myQVT2.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap();
			extensionToFactoryMap.put("xml", new XMIResourceFactoryImpl());		// FIXME workaround BUG 527164
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("uml", getModelsURI("mitosi/samples/transportuml.xml"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("java", getTestURI("transportjava_CG.xml"), getModelsURI("mitosi/samples/transportjava.xml"), null);
			//
			//	        myQVT.createGeneratedExecutor(txClass);
			//	    	myQVT.loadInput("seqDgm", "SeqUM.xmi");
			//	    	myQVT.executeTransformation();
			//			myQVT.saveOutput("stm", "StmcUM_CG.xmi", "StmcUM_expected.xmi", null);
		}
		finally {
			myQVT2.dispose();
		}
	}

	@Test
	public void testQVTrCompiler_SeqToStm() throws Exception {
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = createQVT("SeqToStm", getModelsURI("seq2stm/SeqToStm.qvtr"));
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("stm");
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("seqDgm", getModelsURI("seq2stm/samples/Seq.xmi"));
			myQVT.createModel(QVTbaseUtil.TRACE_TYPED_MODEL_NAME, getTestURI("Seq2Stmc_trace.xmi"));
			myQVT.createModel("stm", getTestURI("Stmc_Interpreted.xmi"));
			myQVT.executeTransformation();
			myQVT.saveOutput("stm", getTestURI("Stmc_Interpreted.xmi"), getModelsURI("seq2stm/samples/Stmc_expected.xmi"), null);
		}
		finally {
			myQVT.dispose();
		}
	}

	@Test
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
			myQVT1.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT1.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			myQVT1.assertRegionCount(MicroMappingRegionImpl.class, 10);
		}
		finally {
			myQVT1.dispose();
		}
		MyQVT myQVT2 = createQVT("SeqToStm", getModelsURI("seq2stm/SeqToStm.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "SeqMM.SeqMMPackage");
			myQVT2.loadEPackage(txClass, "StmcMM.StmcMMPackage");
			myQVT2.loadEPackage(txClass, "trace_SeqToStm.trace_SeqToStmPackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("seqDgm", getModelsURI("seq2stm/samples/Seq.xmi"));
			myQVT2.executeTransformation();
			myQVT2.saveOutput("stm", getTestURI("Stmc_CG.xmi"), getModelsURI("seq2stm/samples/Stmc_expected.xmi"), null);
		}
		finally {
			myQVT2.dispose();
		}
	}

	@Test
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
		}
		MyQVT myQVT2 = createQVT("SeqToStm", getModelsURI("seq2stm/SeqToStm.qvtr"));
		try {
			myQVT2.loadEPackage(txClass, "SeqMM.SeqMMPackage");
			myQVT2.loadEPackage(txClass, "StmcMM.StmcMMPackage");
			myQVT2.loadEPackage(txClass, "trace_SeqToStm.trace_SeqToStmPackage");
			//
			myQVT2.createGeneratedExecutor(txClass);
			myQVT2.loadInput("seqDgm", getModelsURI("seq2stm/samples/Seq.xmi"));
			Transformer tx = myQVT2.executeTransformation();
			Execution2GraphVisitor.writeGraphMLfile(tx, getTestURI("SeqToStm-incremental.graphml"));
			myQVT2.saveOutput("stm", getTestURI("Stmc_CG.xmi"), getModelsURI("seq2stm/samples/Stmc_expected.xmi"), null);
		}
		finally {
			myQVT2.dispose();
		}
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
		}
	} */
}
