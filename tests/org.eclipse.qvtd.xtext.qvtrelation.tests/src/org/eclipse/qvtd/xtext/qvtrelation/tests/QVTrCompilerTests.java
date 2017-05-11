/*******************************************************************************
 * Copyright (c) 2012, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.ToStringVisitor;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain.Key;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.EarlyMerger;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.LateConsumerMerger;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.Execution2GraphVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.impl.BasicMappingRegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.XtextCompilerUtil;
import org.eclipse.qvtd.xtext.qvtcore.tests.QVTcTestUtil;
import org.eclipse.qvtd.xtext.qvtimperative.tests.QVTiTestUtil;
import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.Forward2ReverseNormalizer;
import org.eclipse.qvtd.xtext.qvtrelation.tests.hstm2fstm.FlatStateMachineNormalizer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests that QVTc files can be compiled and executed.
 */
public class QVTrCompilerTests extends LoadTestCase
{
	private static final @NonNull String PROJECT_NAME = "org.eclipse.qvtd.xtext.qvtrelation.tests";
	private static final @NonNull URI TESTS_BASE_URI = URI.createPlatformResourceURI("/" + PROJECT_NAME + "/bin/" + PROJECT_NAME.replace(".",  "/"), true);
	private static URI TESTS_JAVA_SRC_URI = URI.createPlatformResourceURI("/" + PROJECT_NAME +"/test-gen", true);
	private static URI TESTS_JAVA_BIN_URI = URI.createPlatformResourceURI("/" + PROJECT_NAME + "/bin", true);

	protected static class MyQVT extends AbstractTestQVT
	{
		protected class InstrumentedCompilerChain extends QVTrCompilerChain
		{
			protected InstrumentedCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI prefixURI,
					@Nullable Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options) {
				super(environmentFactory, prefixURI, options);
			}

			@Override
			protected @NonNull QVTm2QVTsCompilerStep createQVTm2QVTsCompilerStep() {
				return new QVTm2QVTsCompilerStep(this)
				{
					@Override
					public @NonNull ScheduledRegion execute(@NonNull Resource pResource) throws IOException {
						ScheduledRegion rootRegion = super.execute(pResource);
						instrumentRegion(rootRegion);
						return rootRegion;
					}
				};
			}

			@Override
			protected @NonNull QVTr2QVTcCompilerStep createQVTr2QVTcCompilerStep() {
				return new QVTr2QVTcCompilerStep(this)
				{
					@Override
					protected void doQVTcSerializeAndLoad(@NonNull URI asURI, @NonNull URI csURI) throws IOException {
						XtextCompilerUtil.doQVTcSerializeAndLoad(asURI, csURI);
					}
				};
			}
		}

		private Collection<@NonNull GenPackage> usedGenPackages = null;
		private final @NonNull Map<@NonNull Class<? extends Region>, @NonNull Integer> regionClass2count = new HashMap<>();

		public MyQVT(@NonNull String testFolderName, @NonNull EPackage... eInstances) {
			super(TESTS_BASE_URI, PROJECT_NAME, testFolderName);
			installEPackages(eInstances);
			//
			// http://www.eclipse.org/emf/2002/Ecore is referenced by just about any model load
			// Ecore.core is referenced from Ecore.genmodel that is used by the CG to coordinate Ecore objects with their Java classes
			// therefore suppress diagnostics about confusing usage.
			//
			URI ecoreURI = URI.createURI(EcorePackage.eNS_URI);
			getProjectManager().getPackageDescriptor(ecoreURI).configure(getResourceSet(), StandaloneProjectMap.LoadFirstStrategy.INSTANCE,
				StandaloneProjectMap.MapToFirstConflictHandler.INSTANCE);
		}

		public void addUsedGenPackage(@NonNull String resourcePath, @Nullable String fragment) {
			if (usedGenPackages == null) {
				usedGenPackages = new ArrayList<>();
			}
			URI uri = URI.createPlatformResourceURI(resourcePath, false);
			if (fragment != null) {
				uri = uri.appendFragment(fragment);
			}
			usedGenPackages.add(ClassUtil.nonNullState((GenPackage)getResourceSet().getEObject(uri, true)));
		}

		public void assertRegionCount(@NonNull Class<? extends Region> regionClass, @NonNull Integer count) {
			assertEquals("Region " + regionClass.getSimpleName() + " count:", count != 0 ? count : null, regionClass2count.get(regionClass));
		}

		public @NonNull Class<? extends Transformer> buildTransformation(@NonNull String testName, @NonNull String testFileName, @NonNull String outputName,
				@NonNull String middleNsURI, boolean isIncremental, @NonNull String @NonNull... genModelFiles) throws Exception {
			Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options = createBuildCompilerChainOptions(testName, isIncremental);
			return doBuild(testFileName, outputName, options, genModelFiles);
		}

		public @NonNull ImperativeTransformation compileTransformation(@NonNull String testFileName, @NonNull String outputName, @NonNull String basePrefix, @NonNull String middleNsURI) throws Exception {
			return doCompile(testFileName, outputName, createCompilerChainOptions(basePrefix));
		}

		protected @NonNull Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> createBuildCompilerChainOptions(String testName, boolean isIncremental) {
			Map<@NonNull String, @Nullable String> genModelOptions = new HashMap<>();
			genModelOptions.put(CompilerChain.GENMODEL_BASE_PREFIX, PROJECT_NAME + "." + testName);
			genModelOptions.put(CompilerChain.GENMODEL_COPYRIGHT_TEXT, "Copyright (c) 2015, 2016 Willink Transformations and others.\n;All rights reserved. This program and the accompanying materials\n;are made available under the terms of the Eclipse Public License v1.0\n;which accompanies this distribution, and is available at\n;http://www.eclipse.org/legal/epl-v10.html\n;\n;Contributors:\n;  E.D.Willink - Initial API and implementation");
			Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options = new HashMap<>();
			QVTrCompilerChain.setOption(options, CompilerChain.DEFAULT_STEP, CompilerChain.DEBUG_KEY, true);
			QVTrCompilerChain.setOption(options, CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, TestsXMLUtil.defaultSavingOptions);
			QVTrCompilerChain.setOption(options, CompilerChain.JAVA_STEP, CompilerChain.URI_KEY, TESTS_JAVA_SRC_URI);
			QVTrCompilerChain.setOption(options, CompilerChain.JAVA_STEP, CompilerChain.JAVA_INCREMENTAL_KEY, isIncremental);
			QVTrCompilerChain.setOption(options, CompilerChain.JAVA_STEP, CompilerChain.JAVA_GENERATED_DEBUG_KEY, true);
			QVTrCompilerChain.setOption(options, CompilerChain.CLASS_STEP, CompilerChain.URI_KEY, TESTS_JAVA_BIN_URI);
			QVTrCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_USED_GENPACKAGES_KEY, usedGenPackages);
			QVTrCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_OPTIONS_KEY, genModelOptions);
			return options;
		}

		@Override
		protected @NonNull QVTrCompilerChain createCompilerChain(@NonNull URI prefixURI,
				@NonNull Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options) {
			return new InstrumentedCompilerChain(getEnvironmentFactory(), prefixURI, options);
		}

		protected @NonNull Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> createCompilerChainOptions(String basePrefix) {
			Map<@NonNull String, @Nullable String> genModelOptions = new HashMap<>();
			genModelOptions.put(CompilerChain.GENMODEL_BASE_PREFIX, basePrefix);
			genModelOptions.put(CompilerChain.GENMODEL_COPYRIGHT_TEXT, "Copyright (c) 2015, 2016 Willink Transformations and others.\n;All rights reserved. This program and the accompanying materials\n;are made available under the terms of the Eclipse Public License v1.0\n;which accompanies this distribution, and is available at\n;http://www.eclipse.org/legal/epl-v10.html\n;\n;Contributors:\n;  E.D.Willink - Initial API and implementation");
			Map<@NonNull String, @Nullable String> traceOptions = new HashMap<@NonNull String, @Nullable String>();
			//			traceOptions.put(CompilerChain.TRACE_NS_URI, middleNsURI);
			Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options = new HashMap<>();
			QVTrCompilerChain.setOption(options, CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, getSaveOptions());
			QVTrCompilerChain.setOption(options, CompilerChain.JAVA_STEP, CompilerChain.URI_KEY, null);
			QVTrCompilerChain.setOption(options, CompilerChain.CLASS_STEP, CompilerChain.URI_KEY, null);
			QVTrCompilerChain.setOption(options, CompilerChain.TRACE_STEP, CompilerChain.TRACE_OPTIONS_KEY, traceOptions);
			QVTrCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_USED_GENPACKAGES_KEY, usedGenPackages);
			QVTrCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_OPTIONS_KEY, genModelOptions);
			return options;
		}

		public @NonNull URI getURI(@NonNull String genmodelStep, @NonNull Key<URI> uriKey) {
			return compilerChain.getURI(CompilerChain.GENMODEL_STEP, CompilerChain.URI_KEY);
		}

		private void instrumentRegion(@NonNull Region parentRegion) {
			Class<? extends @NonNull Region> regionClass = parentRegion.getClass();
			Integer count = regionClass2count.get(regionClass);
			regionClass2count.put(regionClass, count == null ? 1 : count+1);
			for (@NonNull Region childRegion : parentRegion.getCallableChildren()) {
				instrumentRegion(childRegion);
			}
		}

		@Override
		protected void loadGenModels(@NonNull String @NonNull... genModelFiles) {
			URI primaryGenModelURI = getURI(CompilerChain.GENMODEL_STEP, CompilerChain.URI_KEY);
			loadGenModel(primaryGenModelURI);
			for (String genModelFile : genModelFiles) {
				URI genModelURI = URI.createURI(genModelFile).resolve(testFolderURI);
				loadGenModel(genModelURI);
			}
		}
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
		QVTrTestUtil.doQVTrelationSetup();
		QVTcTestUtil.doQVTcoreSetup();
		QVTiTestUtil.doQVTimperativeSetup();
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
		MyQVT myQVT = new MyQVT("forward2reverse");
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("Forward2Reverse.qvtr", "reverse", PROJECT_NAME + ".Forward2Reverse", "http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/forward2reverse/Forward2Reverse");
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("forward", "EmptyList.xmi");
			myQVT.createModel("reverse", "EmptyList_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", "EmptyList_Interpreted.xmi", "EmptyList_expected.xmi", Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("forward", "OneElementList.xmi");
			myQVT.createModel("reverse", "OneElementList_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", "OneElementList_Interpreted.xmi", "OneElementList_expected.xmi", Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("forward", "TwoElementList.xmi");
			myQVT.createModel("reverse", "TwoElementList_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", "TwoElementList_Interpreted.xmi", "TwoElementList_expected.xmi", Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("forward", "ThreeElementList.xmi");
			myQVT.createModel("reverse", "ThreeElementList_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", "ThreeElementList_Interpreted.xmi", "ThreeElementList_expected.xmi", Forward2ReverseNormalizer.INSTANCE);
		}
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
		boolean exceptionThrown = true;
		MyQVT myQVT = new MyQVT("forward2reverse");
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("forward2reverse",
				"Forward2Reverse.qvtr", "reverse",
				"http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/forward2reverse/Forward2Reverse", false);//,
			//			Class<? extends Transformer> txClass = Forward2Reverse.class;
			myQVT.assertRegionCount(BasicMappingRegionImpl.class, 0);
			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 1);
			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 5);
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("forward", "EmptyList.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", "EmptyList_CG.xmi", "EmptyList_expected.xmi", Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("forward", "OneElementList.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", "OneElementList_CG.xmi", "OneElementList_expected.xmi", Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("forward", "TwoElementList.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", "TwoElementList_CG.xmi", "TwoElementList_expected.xmi", Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("forward", "ThreeElementList.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", "ThreeElementList_CG.xmi", "ThreeElementList_expected.xmi", Forward2ReverseNormalizer.INSTANCE);
			exceptionThrown = false;
		}
		finally {
			myQVT.dispose();
			myQVT.removeRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.doublylinkedlistPackage", exceptionThrown);
			myQVT.removeRegisteredPackage("org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.PForward2ReversePackage", exceptionThrown);
		}
	}

	@Test
	public void testQVTrCompiler_HierarchicalStateMachine2FlatStateMachine() throws Exception {
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = new MyQVT("hstm2fstm");
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("HierarchicalStateMachine2FlatStateMachine.qvtr", "flat", PROJECT_NAME + ".HierarchicalStateMachine2FlatStateMachine", "http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/hstm2fstm/HierarchicalStateMachine2FlatStateMachine");
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("hier", "MiniModel.xmi");
			//	    	myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "HierarchicalStateMachine2FlatStateMachine_trace.xmi");
			myQVT.createModel("flat", "MiniModel_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("flat", "MiniModel_Interpreted.xmi", "MiniModel_expected.xmi", FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("hier", "SimpleModel.xmi");
			//	    	myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "HierarchicalStateMachine2FlatStateMachine_trace.xmi");
			myQVT.createModel("flat", "SimpleModel_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("flat", "SimpleModel_Interpreted.xmi", "SimpleModel_expected.xmi", FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("hier", "LargerModel.xmi");
			//	    	myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "HierarchicalStateMachine2FlatStateMachine_trace.xmi");
			myQVT.createModel("flat", "LargerModel_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("flat", "LargerModel_Interpreted.xmi", "LargerModel_expected.xmi", FlatStateMachineNormalizer.INSTANCE);
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
		MyQVT myQVT = new MyQVT("hstm2fstm");
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("HierarchicalStateMachine2FlatStateMachine",
				"HierarchicalStateMachine2FlatStateMachine.qvtr", "flat",
				"http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/hstm2fstm/HierarchicalStateMachine2FlatStateMachine", false);//,
			myQVT.assertRegionCount(BasicMappingRegionImpl.class, 0);
			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 1);
			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 7);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("hier", "MiniModel.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("flat", "MiniModel_CG.xmi", "MiniModel_expected.xmi", FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("hier", "SimpleModel.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("flat", "SimpleModel_CG.xmi", "SimpleModel_expected.xmi", FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("hier", "LargerModel.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("flat", "LargerModel_CG.xmi", "LargerModel_expected.xmi", FlatStateMachineNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
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
		MyQVT myQVT = new MyQVT("hstm2fstm");
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("HierarchicalStateMachine2FlatStateMachine",
				"HierarchicalStateMachine2FlatStateMachine.qvtr", "flat",
				"http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/hstm2fstm/HierarchicalStateMachine2FlatStateMachine", true);//,
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("hier", "MiniModel.xmi");
			Transformer tx = myQVT.executeTransformation();
			Execution2GraphVisitor.writeGraphMLfile(tx, getProjectFileURI("hstm2fstm/temp/MiniModel-incremental.graphml"));
			myQVT.saveOutput("flat", "MiniModel_CG.xmi", "MiniModel_expected.xmi", FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("hier", "SimpleModel.xmi");
			tx = myQVT.executeTransformation();
			Execution2GraphVisitor.writeGraphMLfile(tx, getProjectFileURI("hstm2fstm/temp/SimpleModel-incremental.graphml"));
			myQVT.saveOutput("flat", "SimpleModel_CG.xmi", "SimpleModel_expected.xmi", FlatStateMachineNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("hier", "LargerModel.xmi");
			tx = myQVT.executeTransformation();
			Execution2GraphVisitor.writeGraphMLfile(tx, getProjectFileURI("hstm2fstm/temp/LargerModel-incremental.graphml"));
			myQVT.saveOutput("flat", "LargerModel_CG.xmi", "LargerModel_expected.xmi", FlatStateMachineNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
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
		MyQVT myQVT = new MyQVT("iterated2iterated");
		myQVT.addUsedGenPackage("org.eclipse.emf.ecore/model/Ecore.genmodel", "//ecore");
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("iterated2iterated", "Iterated2Iterated.qvtr", "to",
				"http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/iterated2iterated/Iterated2Iterated", false);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("from", "testcase1-in.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("to", "testcase1-out_CG.iterated", "testcase1-out.xmi", null);
			//
			//	        myQVT.createGeneratedExecutor(txClass);
			//	    	myQVT.loadInput("seqDgm", "SeqUM.xmi");
			//	    	myQVT.executeTransformation();
			//			myQVT.saveOutput("stm", "StmcUM_CG.xmi", "StmcUM_expected.xmi", null);
		}
		finally {
			myQVT.dispose();
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
		MyQVT myQVT = new MyQVT("mitosi");
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("mitosi", "MiToSiSimple.qvtr", "java",
				"http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/mitosi/MiToSiSimple", false);
			//
			//			myQVT.assertRegionCount(BasicMappingRegionImpl.class, 0);
			//			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 8);
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("uml", "transportuml.xml");
			myQVT.executeTransformation();
			myQVT.saveOutput("java", "transportjava_CG.xml", "transportjava.xml", null);
			//
			//	        myQVT.createGeneratedExecutor(txClass);
			//	    	myQVT.loadInput("seqDgm", "SeqUM.xmi");
			//	    	myQVT.executeTransformation();
			//			myQVT.saveOutput("stm", "StmcUM_CG.xmi", "StmcUM_expected.xmi", null);
		}
		finally {
			myQVT.dispose();
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
		MyQVT myQVT = new MyQVT("mitosi");
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("mitosi", "MiToSiSimpleWithKeys.qvtr", "java",
				"http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/mitosi/MiToSiSimpleWithKeys", false);
			//			Class<? extends Transformer> txClass = MiToSiSimpleWithKeys.class;
			//
			//			myQVT.assertRegionCount(BasicMappingRegionImpl.class, 0);
			//			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			//			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 8);
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("uml", "transportuml.xml");
			myQVT.executeTransformation();
			myQVT.saveOutput("java", "transportjava_CG.xml", "transportjava.xml", null);
			//
			//	        myQVT.createGeneratedExecutor(txClass);
			//	    	myQVT.loadInput("seqDgm", "SeqUM.xmi");
			//	    	myQVT.executeTransformation();
			//			myQVT.saveOutput("stm", "StmcUM_CG.xmi", "StmcUM_expected.xmi", null);
		}
		finally {
			myQVT.dispose();
		}
	}

	@Test
	public void testQVTrCompiler_SeqToStm() throws Exception {
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		MyQVT myQVT = new MyQVT("seq2stm");
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("SeqToStm.qvtr", "stm", PROJECT_NAME + ".seq2stm", "http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/seq2stm/SeqToStm");
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("seqDgm", "Seq.xmi");
			myQVT.createModel(QVTscheduleConstants.MIDDLE_DOMAIN_NAME, "Seq2Stmc_trace.xmi");
			myQVT.createModel("stm", "Stmc_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("stm", "Stmc_Interpreted.xmi", "Stmc_expected.xmi", null);
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
		MyQVT myQVT = new MyQVT("seq2stm");
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("seq2stm", "SeqToStm.qvtr", "stm",
				"http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/seq2stm/SeqToStm", false);//,
			//					"SeqMM.SeqMMPackage", "PSeqToStm.PSeqToStmPackage");
			//
			myQVT.assertRegionCount(BasicMappingRegionImpl.class, 0);
			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 7);
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("seqDgm", "Seq.xmi");
			myQVT.executeTransformation();
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
	}

	@Test
	public void testQVTrCompiler_SeqToStm_iCG() throws Exception {
		//		Splitter.GROUPS.setState(true);
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		MyQVT myQVT = new MyQVT("seq2stm");
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("seq2stm", "SeqToStm.qvtr", "stm",
				"http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/seq2stm/SeqToStm", true);//,
			//					"SeqMM.SeqMMPackage", "PSeqToStm.PSeqToStmPackage");
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("seqDgm", "Seq.xmi");
			Transformer tx = myQVT.executeTransformation();
			Execution2GraphVisitor.writeGraphMLfile(tx, getProjectFileURI("seq2stm/temp/SeqToStm-incremental.graphml"));
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
			Execution2GraphVisitor.writeGraphMLfile(tx, getProjectFileURI("seq2stm/temp/SeqToStm-incremental.graphml"));
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
			Class<? extends Transformer> txClass = myQVT.buildTransformation("rel2core", "RelToCore.qvtr", "core",
					"http://www.eclipse.org/qvtd/xtext/qvtrelation/tests/rel2core/RelToCore");
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("relations", "MiniSeq2Stm.qvtras");
			myQVT.executeTransformation();
			//	    	myQVT.getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",  new EcoreResourceFactoryImpl());
			//	    	myQVT.getEnvironmentFactory().getMetamodelManager().getASResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",  new EcoreResourceFactoryImpl());
			Resource outputResource = myQVT.saveOutput("core", "MiniSeq2Stm_CG.oclas", null, null);
			myQVT.saveOutput("middle", "MiniSeq2Stm_CG_Trace.xmi", null, null);
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
