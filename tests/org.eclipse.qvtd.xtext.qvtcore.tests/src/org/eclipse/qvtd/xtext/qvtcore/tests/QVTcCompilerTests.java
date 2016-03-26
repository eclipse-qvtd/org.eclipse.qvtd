/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
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
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.QVTcCompilerChain;
import org.eclipse.qvtd.compiler.internal.schedule2qvti.QVTs2QVTiVisitor;
import org.eclipse.qvtd.compiler.internal.scheduler.Scheduler;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiIncrementalExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families2PersonsNormalizer;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.FamiliesPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families2Persons.Families2PersonsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Persons.PersonsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HLSTree.HLSTreePackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSV2HLS.HSV2HLSPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.HSVTreePackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.SimpleRDBMSNormalizer;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simplerdbms.SimplerdbmsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml.SimpleumlPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.uml2rdbms.simpleuml2rdbms.Simpleuml2rdbmsPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.Upper2LowerNormalizer;
import org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph.SimplegraphPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.upper2lower.simplegraph2graph.Simplegraph2graphPackage;
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
	private static URI TESTS_BASE_URI = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtcore.tests/bin/org/eclipse/qvtd/xtext/qvtcore/tests", true);
	private static URI TESTS_JAVA_URI = URI.createPlatformResourceURI("/org.eclipse.qvtd.xtext.qvtcore.tests/test-gen", true);

	protected static class MyQVT extends QVTimperative
	{
		protected final @NonNull String testFolderName;
		protected final @NonNull URI testFolderURI;
		protected final @NonNull URI samplesBaseUri;
		private QVTcCompilerChain compilerChain = null;
		private BasicQVTiExecutor interpretedExecutor = null;
		private QVTiTransformationExecutor generatedExecutor = null;
		private Set<@NonNull String> nsURIs = new HashSet<@NonNull String>();
		
		public MyQVT(@NonNull String testFolderName, @NonNull EPackage... eInstances) {
			super(new QVTiEnvironmentFactory(getProjectMap(), null));
			this.testFolderName = testFolderName;
			this.testFolderURI = TESTS_BASE_URI.appendSegment(testFolderName);
	        this.samplesBaseUri = testFolderURI.appendSegment("samples");
			//
			// Explicitly install the eInstances that would normally make it into the ProjectMap from extension point registrations.
			// Test models are not registered via extension point so we have to do this manually.
			//
			ResourceSetImpl resourceSet = (ResourceSetImpl) getResourceSet();
			for (EPackage eInstance : eInstances) {
				nsURIs.add(eInstance.getNsURI());
				resourceSet.getURIResourceMap().put(testFolderURI.appendSegment(eInstance.getName()+".ecore"), eInstance.eResource());
			}
		}

		public @NonNull Class<? extends Transformer> buildTransformation(@NonNull String testFileName, @NonNull String outputName, @NonNull String @NonNull... genModelFiles) throws Exception {
			Map<@NonNull String, @NonNull Map<CompilerChain.Key<?>, Object>> options = new HashMap<@NonNull String, @NonNull Map<CompilerChain.Key<?>, Object>>();
			compilerChain = new QVTcCompilerChain(getEnvironmentFactory(), testFolderURI.appendSegment(testFileName), options);
			compilerChain.setOption(CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, TestsXMLUtil.defaultSavingOptions);
			compilerChain.setOption(CompilerChain.JAVA_STEP, CompilerChain.URI_KEY, TESTS_JAVA_URI);
			Class<? extends Transformer> txClass = compilerChain.build(outputName, genModelFiles);
			createGeneratedExecutor(txClass);
	        return txClass;
		}

		public @NonNull Transformation compileTransformation(@NonNull String testFileName, @NonNull String outputName) throws Exception {
			Map<@NonNull String, @NonNull Map<CompilerChain.Key<?>, Object>> options = new HashMap<@NonNull String, @NonNull Map<CompilerChain.Key<?>, Object>>();
			compilerChain = new QVTcCompilerChain(getEnvironmentFactory(), testFolderURI.appendSegment(testFileName), options);
			compilerChain.setOption(CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, TestsXMLUtil.defaultSavingOptions);
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
			OCL2JavaFileObject.saveClass(explicitClassPath.toString(), qualifiedClassName, javaCodeSource);	
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

		public QVTiTransformationExecutor createGeneratedExecutor(Class<? extends Transformer> txClass)  throws Exception {
			return generatedExecutor = new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);
		}

		public @NonNull BasicQVTiExecutor createInterpretedExecutor(@NonNull Transformation asTransformation) throws Exception {
			interpretedExecutor = new QVTiIncrementalExecutor(getEnvironmentFactory(), asTransformation, QVTiIncrementalExecutor.Mode.LAZY);
			return interpretedExecutor;
		}

		public void createModel(@NonNull String modelName, @NonNull String modelFile) {
	        URI modelURI = samplesBaseUri.appendSegment(modelFile);
	    	interpretedExecutor.createModel(modelName, modelURI, null);
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
		        interpretedExecutor.saveModels(TestsXMLUtil.defaultSavingOptions);
			}
			else {
				Transformer transformer = generatedExecutor.getTransformer();
				transformer.run();
			}
		}

		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}

		public @NonNull Map<Object, Object> getSaveOptions() {		
			return TestsXMLUtil.defaultSavingOptions;
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

		public void loadInput(@NonNull String modelName, @NonNull String modelFile) {
	        URI modelURI = samplesBaseUri.appendSegment(modelFile);
	        if (interpretedExecutor != null) {
				interpretedExecutor.loadModel(modelName, modelURI);
	        }
	        else {
	        	Resource inputResource = getResourceSet().getResource(modelURI, true);
				generatedExecutor.getTransformer().addRootObjects(modelName, ClassUtil.nonNullState(inputResource.getContents()));
	        }
		}

		public void saveOutput(@NonNull String modelName, @NonNull String modelFile, @Nullable String expectedFile, @Nullable ModelNormalizer normalizer) throws IOException, InterruptedException {
	        URI modelURI = samplesBaseUri.appendSegment(modelFile);
	        URI referenceModelURI = samplesBaseUri.appendSegment(expectedFile);
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
			Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
			assert referenceResource != null;
			if (normalizer != null) {
				normalizer.normalize(referenceResource);
				normalizer.normalize(outputResource);
			}
	        assertSameModel(referenceResource, outputResource);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Before
    public void setUp() throws Exception {
		BaseLinkingService.DEBUG_RETRY.setState(true);
		Scheduler.DEBUG_GRAPHS.setState(true);
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
    @After
    public void tearDown() throws Exception {
		super.tearDown();
    }

	@Test
    public void testQVTcCompiler_Families2Persons() throws Exception {
//		AbstractTransformer.INVOCATIONS.setState(true);
    	MyQVT myQVT = new MyQVT("families2persons");
//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	try {
	    	Transformation asTransformation = myQVT.compileTransformation("Families2Persons.qvtcas", "person");
	    	myQVT.createInterpretedExecutor(asTransformation);
	    	myQVT.loadInput("family", "Families.xmi");
	    	myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "Families2Persons_trace.xmi");
	    	myQVT.createModel("person", "Persons_Interpreted.xmi");
	    	myQVT.executeTransformation();
			myQVT.saveOutput("person", "Persons_Interpreted.xmi", "Persons_expected.xmi", Families2PersonsNormalizer.INSTANCE);
		}
		finally {
	    	myQVT.dispose();
		}
    }
    
    @Test
    public void testQVTcCompiler_Families2Persons_CG() throws Exception {
//		AbstractTransformer.INVOCATIONS.setState(true);
//		Scheduler.EDGE_ORDER.setState(true);
//		Scheduler.REGION_DEPTH.setState(true);
//		Scheduler.REGION_ORDER.setState(true);
//		Scheduler.REGION_TRAVERSAL.setState(true);
//		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
    	MyQVT myQVT = new MyQVT("families2persons", Families2PersonsPackage.eINSTANCE, FamiliesPackage.eINSTANCE, PersonsPackage.eINSTANCE);
//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
			Class<? extends Transformer> txClass = myQVT.buildTransformation("Families2Persons.qvtcas", "person", "Families2Persons.genmodel");
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
    public void testQVTcCompiler_HSVToHLS() throws Exception {
//		AbstractTransformer.EXCEPTIONS.setState(true);
//		AbstractTransformer.INVOCATIONS.setState(true);
    	MyQVT myQVT = new MyQVT("hsv2hls");
//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	try {
	    	Transformation asTransformation = myQVT.compileTransformation("HSV2HLS.qvtcas", "hls");
	    	myQVT.createInterpretedExecutor(asTransformation);
	    	myQVT.loadInput("hsv", "SolarizedHSV.xmi");
	    	myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "HSV2HLS_trace.xmi");
	    	myQVT.createModel("hls", "SolarizedHLS_Interpreted.xmi");
	    	myQVT.executeTransformation();
	    	myQVT.saveOutput("hls", "SolarizedHLS_Interpreted.xmi", "SolarizedHLS_expected.xmi", null);
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
		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
    	MyQVT myQVT = new MyQVT("hsv2hls", HSV2HLSPackage.eINSTANCE, HSVTreePackage.eINSTANCE, HLSTreePackage.eINSTANCE);
		try {	
	        myQVT.buildTransformation("HSV2HLS.qvtcas", "hls", "HSV2HLS.genmodel");
			myQVT.loadInput("hsv", "SolarizedHSV.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("hls", "SolarizedHLS_CG.xmi", "SolarizedHLS_expected.xmi", null);
		}
		finally {
	    	myQVT.dispose();
		}
	}
    
    @Test // fails through at least lack of multi-headed support, which may not be needed if better partitioned
    public void testQVTcCompiler_SimpleUML2RDBMS() throws Exception {
//		AbstractTransformer.INVOCATIONS.setState(true);
    	MyQVT myQVT = new MyQVT("uml2rdbms");
//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	try {
	    	Transformation asTransformation = myQVT.compileTransformation("SimpleUML2RDBMS.qvtcas", "rdbms");
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
//		AbstractTransformer.INVOCATIONS.setState(true);
//		Scheduler.CONNECTION_ROUTING.setState(true);
//		Scheduler.DEBUG_GRAPHS.setState(true);
//		Scheduler.REGION_CYCLES.setState(true);
//		Scheduler.REGION_DEPTH.setState(true);
//		Scheduler.REGION_ORDER.setState(true);
//		Scheduler.REGION_TRAVERSAL.setState(true);
//		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
    	MyQVT myQVT = new MyQVT("uml2rdbms", Simpleuml2rdbmsPackage.eINSTANCE, SimpleumlPackage.eINSTANCE, SimplerdbmsPackage.eINSTANCE);
		try {	
	        Transformation asTransformation = myQVT.compileTransformation("SimpleUML2RDBMS.qvtcas", "rdbms");
	        myQVT.createGeneratedExecutor(asTransformation, "SimpleUML2RDBMS.genmodel");
			myQVT.loadInput("uml", "SimplerUMLPeople2.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("rdbms", "SimplerRDBMSPeople2_CG.xmi", "SimplerRDBMSPeople2_expected.xmi", SimpleRDBMSNormalizer.INSTANCE);
			//
	        myQVT.createGeneratedExecutor(asTransformation, "SimpleUML2RDBMS.genmodel");
			myQVT.loadInput("uml", "SimplerUMLPeople.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("rdbms", "SimplerRDBMSPeople_CG.xmi", "SimplerRDBMSPeople_expected.xmi", SimpleRDBMSNormalizer.INSTANCE);
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
    	MyQVT myQVT = new MyQVT("upper2lower");
//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {	
			Transformation asTransformation = myQVT.compileTransformation("Upper2Lower.qvtcas", "lowerGraph");
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
    	MyQVT myQVT = new MyQVT("upper2lower", Simplegraph2graphPackage.eINSTANCE, SimplegraphPackage.eINSTANCE);
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
