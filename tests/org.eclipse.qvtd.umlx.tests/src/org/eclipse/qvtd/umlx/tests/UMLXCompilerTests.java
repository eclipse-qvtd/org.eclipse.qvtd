/*******************************************************************************
 * Copyright (c) 2012, 20167 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerChain.Key;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.EarlyMerger;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.LateConsumerMerger;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.impl.BasicMappingRegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.umlx.compiler.UMLXCompilerChain;
import org.eclipse.qvtd.umlx.tests.forward2reverse.Forward2ReverseNormalizer;
import org.eclipse.qvtd.umlx.utilities.UMLXStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtbase.tests.AbstractTestQVT;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtcore.tests.QVTcTestUtil;
import org.eclipse.qvtd.xtext.qvtimperative.tests.QVTiTestUtil;
import org.eclipse.qvtd.xtext.qvtrelation.tests.QVTrTestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests that UMLX files can be compiled and executed.
 */
public class UMLXCompilerTests extends LoadTestCase
{
	private static final @NonNull String PROJECT_NAME = "org.eclipse.qvtd.umlx.tests";
	private static final @NonNull URI TESTS_BASE_URI = URI.createPlatformResourceURI("/" + PROJECT_NAME + "/bin/" + PROJECT_NAME.replace(".",  "/"), true);
	private static URI TESTS_JAVA_SRC_URI = URI.createPlatformResourceURI("/" + PROJECT_NAME +"/test-gen", true);
	private static URI TESTS_JAVA_BIN_URI = URI.createPlatformResourceURI("/" + PROJECT_NAME + "/bin", true);

	protected static class MyQVT extends AbstractTestQVT
	{
		protected class InstrumentedCompilerChain extends UMLXCompilerChain
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
		}

		private Collection<@NonNull GenPackage> usedGenPackages = null;
		private final @NonNull Map<@NonNull Class<? extends Region>, @NonNull Integer> regionClass2count = new HashMap<>();

		public MyQVT(@NonNull String testFolderName, @NonNull EPackage... eInstances) {
			super(TESTS_BASE_URI, PROJECT_NAME, testFolderName);
			installEPackages(eInstances);
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
			QVTrCompilerChain.setOption(options, CompilerChain.CLASS_STEP, CompilerChain.URI_KEY, TESTS_JAVA_BIN_URI);
			QVTrCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_USED_GENPACKAGES_KEY, usedGenPackages);
			QVTrCompilerChain.setOption(options, CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_OPTIONS_KEY, genModelOptions);
			return options;
		}

		@Override
		protected @NonNull UMLXCompilerChain createCompilerChain(@NonNull URI prefixURI,
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
		if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			UMLXStandaloneSetup.doSetup();
		}
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

	@Test
	public void testUMLXCompiler_Forward2Reverse_CG() throws Exception {
		//		Splitter.RESULT.setState(true);
		//		Splitter.STAGES.setState(true);
		//		Scheduler.DEBUG_GRAPHS.setState(true);
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		//   	QVTm2QVTp.PARTITIONING.setState(true);
		//		QVTr2QVTc.VARIABLES.setState(true);
		MyQVT myQVT = new MyQVT("forward2reverse");
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("forward2reverse",
					"Forward2Reverse.umlx", "reverse",
					"http://www.eclipse.org/qvtd/umlx/tests/forward2reverse/Forward2Reverse", false);//,
			//					"FlatStateMachine.FlatStateMachinePackage", "HierarchicalStateMachine.HierarchicalStateMachinePackage");
			myQVT.assertRegionCount(BasicMappingRegionImpl.class, 2);
			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			myQVT.assertRegionCount(MicroMappingRegionImpl.class, 4);
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
		}
		finally {
			myQVT.dispose();
			myQVT.removeRegisteredPackage("org.eclipse.qvtd.umlx.tests.forward2reverse.doublylinkedlist.doublylinkedlistPackage");
			myQVT.removeRegisteredPackage("org.eclipse.qvtd.umlx.tests.forward2reverse.PForward2Reverse.PForward2ReversePackage");
		}
	}
}
