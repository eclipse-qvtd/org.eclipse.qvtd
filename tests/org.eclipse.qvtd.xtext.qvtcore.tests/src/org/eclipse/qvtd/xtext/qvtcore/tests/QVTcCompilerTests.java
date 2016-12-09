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
package org.eclipse.qvtd.xtext.qvtcore.tests;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.QVTcCompilerChain;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.BasicMappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MicroMappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.QVTp2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RootScheduledRegion;
//import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.AbstractMerger;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.EarlyMerger;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.LateConsumerMerger;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.splitter.Splitter;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiIncrementalExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families2PersonsNormalizer;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.FamiliesPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families2Persons.Families2PersonsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Persons.PersonsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.forward2reverse.Forward2ReverseNormalizer;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSV2HLSNormalizer;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HLSTree.HLSTreePackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSV2HLS.HSV2HLSPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.HSVTreePackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublylinkedlistPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2listPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.SimpleRDBMSNormalizer;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simplerdbms.SimplerdbmsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.SimpleumlPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.Upper2LowerNormalizer;
import org.eclipse.qvtd.xtext.qvtimperative.tests.ModelNormalizer;
import org.eclipse.qvtd.xtext.qvtimperative.tests.QVTiTestUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * Tests that QVTc files can be compiled and executed.
 */
public class QVTcCompilerTests extends LoadTestCase
{
	protected static final @NonNull URI TESTS_BASE_URI = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtcore.tests/bin/org/eclipse/qvtd/xtext/qvtcore/tests", true);
	protected static final @NonNull URI TESTS_JAVA_SRC_URI = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtcore.tests/test-gen", true);
	protected static final @NonNull URI TESTS_JAVA_BIN_URI = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtcore.tests/bin", true);

	protected static class MyQVT extends QVTimperative
	{
		protected class InstrumentedCompilerChain extends QVTcCompilerChain
		{
			protected InstrumentedCompilerChain(@NonNull QVTiEnvironmentFactory environmentFactory, @NonNull URI prefixURI,
					@Nullable Map<@NonNull String, @Nullable Map<@NonNull Key<Object>, @Nullable Object>> options) {
				super(environmentFactory, prefixURI, options);
			}

			@Override
			protected @NonNull QVTp2QVTsCompilerStep createQVTp2QVTsCompilerStep() {
				return new QVTp2QVTsCompilerStep(this)
				{
					@Override
					public @NonNull RootScheduledRegion execute(@NonNull Resource pResource) throws IOException {
						RootScheduledRegion rootRegion = super.execute(pResource);
						instrumentRegion(rootRegion);
						return rootRegion;
					}
				};
			}
		}

		protected final @NonNull String testFolderName;
		protected final @NonNull URI testFolderURI;
		protected final @NonNull URI samplesBaseUri;
		private QVTcCompilerChain compilerChain = null;
		private BasicQVTiExecutor interpretedExecutor = null;
		private QVTiTransformationExecutor generatedExecutor = null;
		private Set<@NonNull String> nsURIs = new HashSet<@NonNull String>();
		private final @NonNull Map<@NonNull Class<? extends Region>, @NonNull Integer> regionClass2count = new HashMap<>();

		public MyQVT(@NonNull String testFolderName) {
			super(new QVTiEnvironmentFactory(getProjectMap(), null));
			this.testFolderName = testFolderName;
			this.testFolderURI = TESTS_BASE_URI.appendSegment(testFolderName);
			this.samplesBaseUri = testFolderURI.appendSegment("samples");
		}

		public void assertRegionCount(@NonNull Class<? extends Region> regionClass, @NonNull Integer count) {
			assertEquals("Region " + regionClass.getSimpleName() + " count:", count != 0 ? count : null, regionClass2count.get(regionClass));
		}

		public @NonNull Class<? extends Transformer> buildTransformation(@NonNull String testFileName, @NonNull String outputName, @NonNull String @NonNull... genModelFiles) throws Exception {
			Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options = new HashMap<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>>();
			QVTcCompilerChain.setOption(options, CompilerChain.DEFAULT_STEP, CompilerChain.DEBUG_KEY, true);
			QVTcCompilerChain.setOption(options, CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, TestsXMLUtil.defaultSavingOptions);
			QVTcCompilerChain.setOption(options, CompilerChain.JAVA_STEP, CompilerChain.URI_KEY, TESTS_JAVA_SRC_URI);
			QVTcCompilerChain.setOption(options, CompilerChain.JAVA_STEP, CompilerChain.JAVA_EXTRA_PREFIX_KEY, "cg");
			QVTcCompilerChain.setOption(options, CompilerChain.CLASS_STEP, CompilerChain.URI_KEY, TESTS_JAVA_BIN_URI);
			compilerChain = new InstrumentedCompilerChain(getEnvironmentFactory(), testFolderURI.appendSegment(testFileName), options);
			Class<? extends Transformer> txClass = compilerChain.build(outputName, genModelFiles);
			createGeneratedExecutor(txClass);
			return txClass;
		}

		public @NonNull ImperativeTransformation compileTransformation(@NonNull String testFileName, @NonNull String outputName) throws Exception {
			Map<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>> options = new HashMap<@NonNull String, @Nullable Map<CompilerChain.@NonNull Key<Object>, @Nullable Object>>();
			QVTcCompilerChain.setOption(options, CompilerChain.DEFAULT_STEP, CompilerChain.DEBUG_KEY, true);
			QVTcCompilerChain.setOption(options, CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, TestsXMLUtil.defaultSavingOptions);
			compilerChain = new InstrumentedCompilerChain(getEnvironmentFactory(), testFolderURI.appendSegment(testFileName), options);
			return compilerChain.compile(outputName);
		}

		public @NonNull Class<? extends Transformer> createGeneratedClass(@NonNull Transformation asTransformation, @NonNull String @NonNull... genModelFiles) throws Exception {
			ResourceSet resourceSet = getResourceSet();
			resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
			for (String genModelFile : genModelFiles) {
				URI genModelURI = testFolderURI.appendSegment(genModelFile);
				loadGenModel(genModelURI);
			}
			QVTiCodeGenerator cg = new QVTiCodeGenerator(getEnvironmentFactory(), asTransformation);
			QVTiCodeGenOptions options = cg.getOptions();
			options.setUseNullAnnotations(true);
			options.setPackagePrefix("cg");
			cg.generateClassFile();
			cg.saveSourceFile("../org.eclipse.qvtd.xtext.qvtcore.tests/test-gen/");
			File explicitClassPath = new File("../org.eclipse.qvtd.xtext.qvtcore.tests/bin");
			String qualifiedClassName = cg.getQualifiedName();
			String javaCodeSource = cg.generateClassFile();
			OCL2JavaFileObject.saveClass(ClassUtil.nonNullState(explicitClassPath.toString()), qualifiedClassName, javaCodeSource);
			@SuppressWarnings("unchecked")
			Class<? extends Transformer> txClass = (Class<? extends Transformer>) OCL2JavaFileObject.loadExplicitClass(explicitClassPath, qualifiedClassName);
			if (txClass == null) {
				TestCase.fail("Failed to compile transformation");
				throw new UnsupportedOperationException();
			}
			return txClass;
		}

		public void createGeneratedExecutor(@NonNull Transformation asTransformation, @NonNull String @NonNull... genModelFiles) throws Exception {
			Class<? extends Transformer> txClass = createGeneratedClass(asTransformation, genModelFiles);
			createGeneratedExecutor(txClass);
		}

		public QVTiTransformationExecutor createGeneratedExecutor(@NonNull Class<? extends Transformer> txClass)  throws Exception {
			return generatedExecutor = new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);
		}

		public @NonNull BasicQVTiExecutor createInterpretedExecutor(@NonNull ImperativeTransformation asTransformation) throws Exception {
			interpretedExecutor = new QVTiIncrementalExecutor(getEnvironmentFactory(), asTransformation, QVTiIncrementalExecutor.Mode.LAZY);
			return interpretedExecutor;
		}

		public @Nullable Resource createModel(@NonNull String modelName, @NonNull String modelFile) {
			URI modelURI = samplesBaseUri.appendSegment(modelFile);
			return interpretedExecutor.createModel(modelName, modelURI, null);
		}

		@Override
		public synchronized void dispose() {
			super.dispose();
			if (interpretedExecutor != null) {
				interpretedExecutor.dispose();
			}
			if (compilerChain != null) {
				compilerChain.dispose();
			}
			/**
			 * Remove the eInstances from the EPackage.Registry.INSTANCE so that global registrations from the calling test
			 * do not confuse subsequent tests that may want to use dynamic models.
			 */
			for (String nsURI : nsURIs) {
				EPackage.Registry.INSTANCE.remove(nsURI);
			}
		}

		public void executeTransformation() throws Exception {
			if (interpretedExecutor != null) {
				interpretedExecutor.execute();
				interpretedExecutor.saveContents();
				//				interpretedExecutor.saveModels(TestsXMLUtil.defaultSavingOptions);
			}
			else {
				Transformer transformer = generatedExecutor.getTransformer();
				transformer.run();
			}
		}

		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return super.getEnvironmentFactory();
		}

		public @NonNull Collection<@NonNull ? extends Object> getRootObjects(@NonNull String modelName) {
			if (interpretedExecutor != null) {
				return interpretedExecutor.getRootObjects(modelName);
			}
			else {
				return generatedExecutor.getTransformer().getRootObjects(modelName);
			}
		}

		public @NonNull Map<Object, Object> getSaveOptions() {
			return TestsXMLUtil.defaultSavingOptions;
		}

		private void instrumentRegion(@NonNull Region parentRegion) {
			Class<? extends @NonNull Region> regionClass = parentRegion.getClass();
			Integer count = regionClass2count.get(regionClass);
			regionClass2count.put(regionClass, count == null ? 1 : count+1);
			for (@NonNull Region childRegion : parentRegion.getCallableChildren()) {
				instrumentRegion(childRegion);
			}
		}

		public void loadEcoreFile(URI fileURI, EPackage ePackage) {
			ResourceSet rSet = getResourceSet();
			rSet.getPackageRegistry().put(fileURI.toString(), ePackage);
		}

		private void loadGenModel(@NonNull URI genModelURI) {
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

		public @Nullable Resource loadInput(@NonNull String modelName, @NonNull String modelFile) {
			URI modelURI = samplesBaseUri.appendSegment(modelFile);
			if (interpretedExecutor != null) {
				return interpretedExecutor.loadModel(modelName, modelURI);
			}
			else {
				Resource inputResource = getResourceSet().getResource(modelURI, true);
				generatedExecutor.getTransformer().addRootObjects(modelName, ClassUtil.nullFree(inputResource.getContents()));
				return inputResource;
			}
		}

		public void saveOutput(@NonNull String modelName, @NonNull String modelFile, @Nullable String expectedFile, @Nullable ModelNormalizer normalizer) throws IOException, InterruptedException {
			URI modelURI = samplesBaseUri.appendSegment(modelFile);
			ResourceSet resourceSet = getResourceSet();
			Resource outputResource;
			if (interpretedExecutor != null) {
				outputResource = interpretedExecutor.saveModel(modelName, modelURI, null, getSaveOptions());
			}
			else {
				outputResource = resourceSet.createResource(modelURI);
				outputResource.getContents().addAll(generatedExecutor.getTransformer().getRootEObjects(modelName));
				outputResource.save(getSaveOptions());
			}
			if ((outputResource != null) && (expectedFile != null)) {
				URI referenceModelURI = samplesBaseUri.appendSegment(expectedFile);
				Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
				assert referenceResource != null;
				if (normalizer != null) {
					normalizer.normalize(referenceResource);
					normalizer.normalize(outputResource);
				}
				assertSameModel(referenceResource, outputResource);
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
		QVTp2QVTs.DEBUG_GRAPHS.setState(true);
		super.setUp();
		OCLstdlib.install();
		QVTcTestUtil.doQVTcoreSetup();
		QVTiTestUtil.doQVTimperativeSetup();
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
		//		AbstractTransformer.INVOCATIONS.setState(true);
		String testFolderName = "families2persons";
		URI testFolderURI = TESTS_BASE_URI.appendSegment(testFolderName);
		MyQVT myQVT = new MyQVT(testFolderName);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("Families.ecore"), FamiliesPackage.eINSTANCE);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("Families2Persons.ecore"), Families2PersonsPackage.eINSTANCE);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("Persons.ecore"), PersonsPackage.eINSTANCE);
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("Families2Persons.qvtc", "person");
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("family", "Families.xmi");
			myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "Families2Persons_trace.xmi");
			myQVT.createModel("person", "Persons_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("person", "Persons_Interpreted.xmi", "Persons_expected.xmi", Families2PersonsNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
			EPackage.Registry.INSTANCE.remove(FamiliesPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(Families2PersonsPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(PersonsPackage.eNS_URI);
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
		MyQVT myQVT = new MyQVT("families2persons");
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("Families2Persons.qvtc", "person", "Families2Persons.genmodel");
			myQVT.assertRegionCount(BasicMappingRegion.class, 0);
			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			myQVT.assertRegionCount(MicroMappingRegion.class, 2);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("family", "Families.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("person", "Persons_CG.xmi", "Persons_expected.xmi", Families2PersonsNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("family", "FamiliesBig.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("person", "PersonsBig_CG.xmi", "PersonsBig_expected.xmi", Families2PersonsNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
		}
	}

	@Test
	public void testQVTcCompiler_Forward2Reverse() throws Exception {
		//    	QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
		String testFolderName = "forward2reverse";
		URI testFolderURI = TESTS_BASE_URI.appendSegment(testFolderName);
		MyQVT myQVT = new MyQVT(testFolderName);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("DoublyLinkedList.ecore"), DoublylinkedlistPackage.eINSTANCE);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("List2List.ecore"), List2listPackage.eINSTANCE);
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("Forward2Reverse.qvtc", "reverse");
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("forward", "EmptyList.xmi");
			myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "EmptyList_trace.xmi");
			myQVT.createModel("reverse", "EmptyList_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", "EmptyList_Interpreted.xmi", "EmptyList_expected.xmi", Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("forward", "OneElementList.xmi");
			myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "OneElementList_trace.xmi");
			myQVT.createModel("reverse", "OneElementList_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", "OneElementList_Interpreted.xmi", "OneElementList_expected.xmi", Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("forward", "TwoElementList.xmi");
			myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "TwoElementList_trace.xmi");
			myQVT.createModel("reverse", "TwoElementList_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", "TwoElementList_Interpreted.xmi", "TwoElementList_expected.xmi", Forward2ReverseNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("forward", "ThreeElementList.xmi");
			myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "ThreeElementList_trace.xmi");
			myQVT.createModel("reverse", "ThreeElementList_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("reverse", "ThreeElementList_Interpreted.xmi", "ThreeElementList_expected.xmi", Forward2ReverseNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
			EPackage.Registry.INSTANCE.remove(DoublylinkedlistPackage.eNS_URI);
			EPackage.Registry.INSTANCE.remove(List2listPackage.eNS_URI);
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
		String testFolderName = "forward2reverse";
		MyQVT myQVT = new MyQVT(testFolderName);
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			Class<? extends Transformer> txClassReverse = myQVT.buildTransformation("Forward2Reverse.qvtc", "forward", "List2List.genmodel");
			myQVT.assertRegionCount(BasicMappingRegion.class, 0);
			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			myQVT.assertRegionCount(MicroMappingRegion.class, 7);
			//
			myQVT.createGeneratedExecutor(txClassReverse);
			myQVT.loadInput("reverse", "ThreeElementList.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("forward", "ThreeElementList_Reverse_CG.xmi", "ThreeElementList_expected.xmi", Forward2ReverseNormalizer.INSTANCE);
			//
			Class<? extends Transformer> txClass = myQVT.buildTransformation("Forward2Reverse.qvtc", "reverse", "List2List.genmodel");
			//
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
		}
	}

	@Test
	public void testQVTcCompiler_HSVToHLS() throws Exception {
		//		AbstractTransformer.EXCEPTIONS.setState(true);
		//		AbstractTransformer.INVOCATIONS.setState(true);
		String testFolderName = "hsv2hls";
		URI testFolderURI = TESTS_BASE_URI.appendSegment(testFolderName);
		MyQVT myQVT = new MyQVT(testFolderName);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("HSV2HLS.ecore"), HSV2HLSPackage.eINSTANCE);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("HSVTree.ecore"), HSVTreePackage.eINSTANCE);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("HLSTree.ecore"), HLSTreePackage.eINSTANCE);
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("HSV2HLS.qvtc", "hls");
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("hsv", "SolarizedHSV.xmi");
			myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "HSV2HLS_trace.xmi");
			myQVT.createModel("hls", "SolarizedHLS_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("hls", "SolarizedHLS_Interpreted.xmi", "SolarizedHLS_expected.xmi", HSV2HLSNormalizer.INSTANCE);	// FIXME Bug 490497 remove normalizer
		}
		finally {
			myQVT.dispose();
		}
	}

	@Test
	public void testQVTcCompiler_HSVToHLS_CG() throws Exception {
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
		String testFolderName = "hsv2hls";
		MyQVT myQVT = new MyQVT(testFolderName);
		try {
			myQVT.buildTransformation("HSV2HLS.qvtc", "hls", "HSV2HLS.genmodel");
			myQVT.assertRegionCount(BasicMappingRegion.class, 0);
			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 1);
			myQVT.assertRegionCount(MicroMappingRegion.class, 2);
			myQVT.loadInput("hsv", "SolarizedHSV.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("hls", "SolarizedHLS_CG.xmi", "SolarizedHLS_expected.xmi", HSV2HLSNormalizer.INSTANCE);	// FIXME Bug 490497 remove normalizer
		}
		finally {
			myQVT.dispose();
		}
	}

	@Test // fails through at least lack of multi-headed support, which may not be needed if better partitioned
	public void testQVTcCompiler_SimpleUML2RDBMS() throws Exception {
		//		AbstractTransformer.INVOCATIONS.setState(true);
		String testFolderName = "uml2rdbms";
		URI testFolderURI = TESTS_BASE_URI.appendSegment(testFolderName);
		MyQVT myQVT = new MyQVT(testFolderName);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("SimpleUML2RDBMS.ecore"), Simpleuml2rdbmsPackage.eINSTANCE);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("SimpleUML.ecore"), SimpleumlPackage.eINSTANCE);
		myQVT.loadEcoreFile(testFolderURI.appendSegment("SimpleRDBMS.ecore"), SimplerdbmsPackage.eINSTANCE);
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("SimpleUML2RDBMS.qvtcas", "rdbms");
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("uml", "SimplerUMLPeople.xmi");
			myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "SimplerUML2RDBMS_trace.xmi");
			myQVT.createModel("rdbms", "SimplerRDBMSPeople_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("rdbms", "SimplerRDBMSPeople_Interpreted.xmi", "SimplerRDBMSPeople_expected.xmi", SimpleRDBMSNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("uml", "SimplerUMLPeople2.xmi");
			myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "SimplerUML2RDBMS2_trace.xmi");
			myQVT.createModel("rdbms", "SimplerRDBMSPeople2_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("rdbms", "SimplerRDBMSPeople2_Interpreted.xmi", "SimplerRDBMSPeople2_expected.xmi", SimpleRDBMSNormalizer.INSTANCE);
			//
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("uml", "SimpleUMLPeople.xmi");
			myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "SimpleUML2RDBMS_trace.xmi");
			myQVT.createModel("rdbms", "SimpleRDBMSPeople_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("rdbms", "SimpleRDBMSPeople_Interpreted.xmi", "SimpleRDBMSPeople_expected.xmi", SimpleRDBMSNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
		}
	}

	@Test
	public void testQVTcCompiler_SimpleUML2RDBMS_CG() throws Exception {
		//		OperationDependencyAnalysis.CALL.setState(true);
		//		OperationDependencyAnalysis.CREATE.setState(true);
		//		OperationDependencyAnalysis.FINISH.setState(true);
		//		OperationDependencyAnalysis.PENDING.setState(true);
		//		OperationDependencyAnalysis.REFINING.setState(true);
		//		OperationDependencyAnalysis.RETURN.setState(true);
		//		OperationDependencyAnalysis.START.setState(true);
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
		String testFolderName = "uml2rdbms";
		MyQVT myQVT = new MyQVT(testFolderName);
		try {
			Transformation asTransformation = myQVT.compileTransformation("SimpleUML2RDBMS.qvtcas", "rdbms");
			myQVT.assertRegionCount(BasicMappingRegion.class, 2);
			myQVT.assertRegionCount(EarlyMerger.EarlyMergedMappingRegion.class, 0);
			myQVT.assertRegionCount(LateConsumerMerger.LateMergedMappingRegion.class, 0);
			myQVT.assertRegionCount(MicroMappingRegion.class, 20);
			myQVT.createGeneratedExecutor(asTransformation, "SimpleUML2RDBMS.genmodel");
			myQVT.loadInput("uml", "SimplerUMLPeople.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("rdbms", "SimplerRDBMSPeople_CG.xmi", "SimplerRDBMSPeople_expected.xmi", SimpleRDBMSNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(asTransformation, "SimpleUML2RDBMS.genmodel");
			myQVT.loadInput("uml", "SimplerUMLPeople2.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("rdbms", "SimplerRDBMSPeople2_CG.xmi", "SimplerRDBMSPeople2_expected.xmi", SimpleRDBMSNormalizer.INSTANCE);
			//
			myQVT.createGeneratedExecutor(asTransformation, "SimpleUML2RDBMS.genmodel");
			myQVT.loadInput("uml", "SimpleUMLPeople.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("rdbms", "SimpleRDBMSPeople_CG.xmi", "SimpleRDBMSPeople_expected.xmi", SimpleRDBMSNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
		}
	}

	@Test
	public void testQVTcCompiler_Upper2Lower() throws Exception {
		//    	QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
		String testFolderName = "upper2lower";
		MyQVT myQVT = new MyQVT(testFolderName);
		//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			ImperativeTransformation asTransformation = myQVT.compileTransformation("Upper2Lower.qvtcas", "lowerGraph");
			myQVT.createInterpretedExecutor(asTransformation);
			myQVT.loadInput("upperGraph", "SimpleGraph.xmi");
			myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "Upper2Lower_trace.xmi");
			myQVT.createModel("lowerGraph", "SimpleGraphLower_Interpreted.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("lowerGraph", "SimpleGraphLower_Interpreted.xmi", "SimpleGraphLower_expected.xmi", Upper2LowerNormalizer.INSTANCE);
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
		String testFolderName = "upper2lower";
		MyQVT myQVT = new MyQVT(testFolderName);
		//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			myQVT.buildTransformation("Upper2Lower.qvtcas", "lowerGraph", "SimpleGraph2Graph.genmodel");
			myQVT.loadInput("upperGraph", "SimpleGraph.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("lowerGraph", "SimpleGraphLower_CG.xmi", "SimpleGraphLower_expected.xmi", Upper2LowerNormalizer.INSTANCE);
		}
		finally {
			myQVT.dispose();
		}
	}
}
