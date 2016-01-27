/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *     Horacio Hoyos - More tests
 *******************************************************************************/
package org.eclipse.qvtd.build.etl.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.dynamic.OCL2JavaFileObject;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManagerInternal;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.internal.validation.PivotEObjectValidator;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.ocl.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.build.etl.tests.Families2Persons.Families2PersonsNormalizer;
import org.eclipse.qvtd.build.etl.tests.UpperToLower.UpperToLowerNormalizer;
import org.eclipse.qvtd.codegen.qvti.QVTiCodeGenOptions;
import org.eclipse.qvtd.codegen.qvti.java.QVTiCodeGenerator;
//import org.eclipse.qvtd.build.etl.tests.UpperToLowerHete.UpperToLowerNormalizer;
import org.eclipse.qvtd.compiler.internal.etl.MtcBroker;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiIncrementalExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiTransformationExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtimperative.tests.ModelNormalizer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import build.test.families2persons.Families.FamiliesPackage;
import build.test.families2persons.Families2Persons.Families2PersonsPackage;
import build.test.families2persons.Persons.PersonsPackage;
import build.test.hls.HLSTree.HLSTreePackage;
import build.test.hsv.HSVTree.HSVTreePackage;
import build.test.middle.HSV2HLS.HSV2HLSPackage;
import build.upper2lower.simplegraph.SimplegraphPackage;
import build.upper2lower.simplegraph2graph.Simplegraph2graphPackage;
import junit.framework.TestCase;

public class QVTdMtcTests extends LoadTestCase {

	private static URI TESTS_BASE_URI = URI.createPlatformResourceURI("/org.eclipse.qvtd.build.etl.tests/bin/org/eclipse/qvtd/build/etl/tests", true);

	public static void assertSameModel(@NonNull Resource expectedResource, @NonNull Resource actualResource) throws IOException, InterruptedException {
		TestUtil.assertSameModel(expectedResource, actualResource);
	}


	protected static void assertLoadable(@NonNull URI asURI) {
		OCL ocl = OCL.newInstance();
        ResourceSet asResourceSet = ocl.getMetamodelManager().getASResourceSet();
//        ResourceSet asResourceSet = OCL.createEnvironmentFactory(null).getMetamodelManager().getASResourceSet();
        if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			OCLstdlib.install();
//	        MetamodelManager.initializeASResourceSet(asResourceSet);
        }
        Resource resource = asResourceSet.getResource(asURI, true);
        EcoreUtil.resolveAll(resource);
        assertNoUnresolvedProxies("Loading", resource);
        assertNoResourceErrors("Loading", resource);
        ocl.dispose();
	}
	
//	protected @NonNull MyQVT createQVT() {
//		return new MyQVT(new MyQVTiEnvironmentFactory(getProjectMap(), null));
//	}
    
    private MyQVT createQVT(@NonNull String testName, @NonNull EPackage... eInstances) {
		MyQVT myQVT = new MyQVT(testName, new MyQVTiEnvironmentFactory(getProjectMap(), null));
		myQVT.install(eInstances);
		return myQVT;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Before
    public void setUp() throws Exception {

		BaseLinkingService.DEBUG_RETRY.setState(true);
		super.setUp();
		OCLstdlib.install();
		QVTcoreStandaloneSetup.doSetup();
		QVTcorePivotStandaloneSetup.doSetup();
		QVTimperativePivotStandaloneSetup.doSetup();
    }

	 /* (non-Javadoc)
     * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#tearDown()
     */
    @After
    public void tearDown() throws Exception {
		super.tearDown();
    }
	
	protected static class MyQVT extends OCLInternal
	{
		protected final @NonNull String testName;
		protected final @NonNull URI baseURI;
		protected final @NonNull URI samplesBaseUri;
		private MtcBroker mtc = null;
		private BasicQVTiExecutor interpretedExecutor = null;
		private QVTiTransformationExecutor generatedExecutor = null;
		private Set<@NonNull String> nsURIs = new HashSet<@NonNull String>();
		
		public MyQVT(@NonNull String testName, @NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
			this.testName = testName;
			this.baseURI = TESTS_BASE_URI.appendSegment(testName);
	        this.samplesBaseUri = baseURI.appendSegment("samples");
		}

		public @NonNull Transformation compileTransformation() throws Exception {
			mtc = new MtcBroker(baseURI, testName + ".qvtcas", getEnvironmentFactory(), TestsXMLUtil.defaultSavingOptions);
	    	mtc.setCreateGraphml(true);
	    	Resource iResource = mtc.newExecute();
	    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
	    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
	        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
//	        assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
	        assertNoValidationErrors("QVTi validation", iResource);
			return mtc.getTransformation(mtc.getiResource());
		}

		public @NonNull Class<? extends Transformer> createGeneratedClass(@NonNull Transformation asTransformation, @NonNull String @NonNull... genModelFiles) throws Exception {
			ResourceSet resourceSet = getResourceSet();
			resourceSet.getPackageRegistry().put(GenModelPackage.eNS_URI, GenModelPackage.eINSTANCE);
			for (String genModelFile : genModelFiles) {
				URI genModelURI = baseURI.appendSegment(genModelFile);
				loadGenModel(genModelURI);
			}
			QVTiCodeGenerator cg = new QVTiCodeGenerator(getEnvironmentFactory(), asTransformation);
			QVTiCodeGenOptions options = cg.getOptions();
			options.setUseNullAnnotations(true);
			options.setPackagePrefix("cg");
			cg.generateClassFile();
			cg.saveSourceFile("../org.eclipse.qvtd.build.etl.tests/src-gen/");
			File explicitClassPath = new File("../org.eclipse.qvtd.build.etl.tests/bin");
			String qualifiedClassName = cg.getQualifiedName();
			String javaCodeSource = cg.generateClassFile();
			OCL2JavaFileObject.saveClass(String.valueOf(explicitClassPath), qualifiedClassName, javaCodeSource);	
			@SuppressWarnings("unchecked")
			Class<? extends Transformer> txClass = (Class<? extends Transformer>) OCL2JavaFileObject.loadExplicitClass(explicitClassPath, qualifiedClassName);
			if (txClass == null) {
				TestCase.fail("Failed tto compile transformation");
				throw new UnsupportedOperationException();
			}
			return txClass;
		}

		public void createGeneratedExecutor(@NonNull Class<? extends Transformer> txClass) throws ReflectiveOperationException {
			generatedExecutor = new QVTiTransformationExecutor(getEnvironmentFactory(), txClass);
		}
		
		public void createGeneratedExecutor(@NonNull Transformation asTransformation, @NonNull String @NonNull... genModelFiles) throws Exception {
			Class<? extends Transformer> txClass = createGeneratedClass(asTransformation, genModelFiles);
			createGeneratedExecutor(txClass);
		}

		public @NonNull BasicQVTiExecutor createInterpretedExecutor(@NonNull Transformation asTransformation) throws Exception {
			BasicQVTiExecutor interpretedExecutor2 = interpretedExecutor = new QVTiIncrementalExecutor(getEnvironmentFactory(), asTransformation, QVTiIncrementalExecutor.Mode.LAZY);
			return interpretedExecutor2;
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
			if (mtc != null) {
				mtc.disposeModels();
			}
			/**
			 * Remove the eInstances from the EPackage.Registry.INSTANCE so that global registrations from the calling test
			 * do not confuse subsequent tests that may want to use dynamic models.
			 */
			for (String nsURI : nsURIs) {
				EPackage.Registry.INSTANCE.remove(nsURI);
			}
		}

		public @NonNull Resource doLoad_ConcreteWithOCL(@NonNull URI inputURI) throws IOException {
			URI cstURI = inputURI.appendFileExtension("xmi");//TestUtil.getFileURI(getClass(), cstName);
			URI pivotURI = inputURI.appendFileExtension("qvtias");//TestUtil.getFileURI(getClass(), pivotName);
			BaseCSResource xtextResource = (BaseCSResource) getResourceSet().getResource(inputURI, true);
			assert xtextResource != null;
			assertNoResourceErrors("Load failed", xtextResource);
			ASResource asResource = xtextResource.getASResource();
//			assertNoUnresolvedProxies("Unresolved proxies", xtextResource);
//			System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validate()");
			assertNoValidationErrors("Validation errors", xtextResource.getContents().get(0));
//			System.out.println(Long.toString(System.currentTimeMillis() - startTime) + " validated()");
			TestUtil.saveAsXMI(xtextResource, cstURI, getSaveOptions());
			asResource.setURI(pivotURI);
		    
		    TestUtil.doCompleteOCLSetup();
		    URI oclURI = ClassUtil.nonNullState(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl", true));
//			CompleteOCLEObjectValidator completeOCLEObjectValidator1 = new CompleteOCLEObjectValidator(QVTimperativePackage.eINSTANCE, oclURI, metamodelManager);
			CompleteOCLEObjectValidator completeOCLEObjectValidator2 = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, getEnvironmentFactory());
//			CompleteOCLEObjectValidator completeOCLEObjectValidator3 = new CompleteOCLEObjectValidator(QVTbasePackage.eINSTANCE, oclURI, metamodelManager);
//			completeOCLEObjectValidator1.initialize();
			completeOCLEObjectValidator2.initialize();
//			completeOCLEObjectValidator3.initialize();
			PivotEObjectValidator.install(ClassUtil.nonNullState(asResource.getResourceSet()), getEnvironmentFactory());
			PivotEObjectValidator.install(ClassUtil.nonNullState(QVTbasePackage.eINSTANCE), null);
			PivotEObjectValidator.install(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), null);
			PivotEObjectValidator.install(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE), null);
		    
			assertNoValidationErrors("Pivot validation errors", asResource.getContents().get(0));
			asResource.save(getSaveOptions());
			return asResource;
		}

		public void executeTransformation() throws Exception {
			if (interpretedExecutor != null) {
//				System.out.println("Executing QVTi transformation on test models.");
		        interpretedExecutor.execute();
		        interpretedExecutor.saveModels(TestsXMLUtil.defaultSavingOptions);
			}
			else {
				generatedExecutor.getTransformer().run();
			}
		}

		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}

		/**
		 * Explicitly install the eInstances that would normally make it into the ProjectMap from extension point registrations.
		 * Test models are not registered via extension point so we have to do this manually.
		 */
		public void install(@NonNull EPackage... eInstances) {
			ResourceSetImpl resourceSet = (ResourceSetImpl) getResourceSet();
			for (EPackage eInstance : eInstances) {
				String nsURI = eInstance.getNsURI();
				assert nsURI != null;
				nsURIs.add(nsURI);
				resourceSet.getURIResourceMap().put(baseURI.appendSegment(eInstance.getName()+".ecore"), eInstance.eResource());
			}
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
				outputResource.getContents().addAll(generatedExecutor.getTransformer().getRootObjects(modelName));
				outputResource.save(getSaveOptions());
	        }
			Resource referenceResource = resourceSet.getResource(referenceModelURI, true);
			assert (referenceResource != null) && (outputResource != null);
			if (normalizer != null) {
				normalizer.normalize(referenceResource);
				normalizer.normalize(outputResource);
			}
	        assertSameModel(referenceResource, outputResource);
		}
	}
	
	protected static class MyQVTiEnvironmentFactory extends QVTiEnvironmentFactory
	{
		public MyQVTiEnvironmentFactory(@NonNull ProjectManager projectMap, @Nullable ResourceSet externalResourceSet) {
			super(projectMap, externalResourceSet);
	    	setEvaluationTracingEnabled(true);
		}
	}

	public static @NonNull Map<Object, Object> getSaveOptions() {		
		return TestsXMLUtil.defaultSavingOptions;
	}



	@Test
    public void testFamilies2Persons() throws Exception {
//		AbstractTransformer.INVOCATIONS.setState(true);
    	MyQVT myQVT = createQVT("Families2Persons");
//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	try {
	    	Transformation asTransformation = myQVT.compileTransformation();
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
    public void testFamilies2Persons_CG() throws Exception {
//		AbstractTransformer.INVOCATIONS.setState(true);
//		Scheduler.EDGE_ORDER.setState(true);
//		Scheduler.REGION_DEPTH.setState(true);
//		Scheduler.REGION_ORDER.setState(true);
//		Scheduler.REGION_TRAVERSAL.setState(true);
//		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
    	MyQVT myQVT = createQVT("Families2Persons", Families2PersonsPackage.eINSTANCE, FamiliesPackage.eINSTANCE, PersonsPackage.eINSTANCE);
//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {
	    	Transformation asTransformation = myQVT.compileTransformation();
	        Class<? extends Transformer> txClass = myQVT.createGeneratedClass(asTransformation, "Families2Persons.genmodel");
	    	//
	        myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("family", "FamiliesBig.xmi");
	    	myQVT.executeTransformation();
			myQVT.saveOutput("person", "PersonsBig_CG.xmi", "PersonsBig_expected.xmi", Families2PersonsNormalizer.INSTANCE);
	    	//
	        myQVT.createGeneratedExecutor(txClass);
			myQVT.loadInput("family", "Families.xmi");
	    	myQVT.executeTransformation();
			myQVT.saveOutput("person", "Persons_CG.xmi", "Persons_expected.xmi", Families2PersonsNormalizer.INSTANCE);
		}
		finally {
	    	myQVT.dispose();
		}
	}
   
    @Test
    public void testHSVToHLS() throws Exception {
//		AbstractTransformer.INVOCATIONS.setState(true);
    	MyQVT myQVT = createQVT("HSV2HLS");
//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	try {
	    	Transformation asTransformation = myQVT.compileTransformation();
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
    public void testHSVToHLS_CG() throws Exception {
//		AbstractTransformer.INVOCATIONS.setState(true);
//		Scheduler.EDGE_ORDER.setState(true);
//		Scheduler.REGION_DEPTH.setState(true);
//		Scheduler.REGION_ORDER.setState(true);
//		Scheduler.REGION_TRAVERSAL.setState(true);
//		QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
    	MyQVT myQVT = createQVT("HSV2HLS", HSV2HLSPackage.eINSTANCE, HSVTreePackage.eINSTANCE, HLSTreePackage.eINSTANCE);
		try {	
	        Transformation asTransformation = myQVT.compileTransformation();
	        myQVT.createGeneratedExecutor(asTransformation, "HSV2HLS.genmodel");
			myQVT.loadInput("hsv", "SolarizedHSV.xmi");
			myQVT.executeTransformation();
			myQVT.saveOutput("hls", "SolarizedHLS_CG.xmi", "SolarizedHLS_expected.xmi", null);
		}
		finally {
	    	myQVT.dispose();
		}
	}

    @Test
    public void testUpperToLower() throws Exception {
//    	QVTs2QVTiVisitor.POLLED_PROPERTIES.setState(true);
    	MyQVT myQVT = createQVT("UpperToLower");
//    	myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
		try {	
			Transformation asTransformation = myQVT.compileTransformation();
	    	myQVT.createInterpretedExecutor(asTransformation);
	    	myQVT.loadInput("upperGraph", "SimpleGraph.xmi");
	    	myQVT.createModel(QVTimperativeUtil.MIDDLE_DOMAIN_NAME, "UpperToLower_trace.xmi");
	    	myQVT.createModel("lowerGraph", "SimpleGraphLower_Interpreted.xmi");
	    	myQVT.executeTransformation();
			myQVT.saveOutput("lowerGraph", "SimpleGraphLower_Interpreted.xmi", "SimpleGraphLower_expected.xmi", UpperToLowerNormalizer.INSTANCE);
		}
		finally {
	    	myQVT.dispose();
		}
    }

    @Test
    public void testUpperToLower_CG() throws Exception {
//    	Scheduler.EDGE_ORDER.setState(true);
//    	Scheduler.REGION_DEPTH.setState(true);
//    	Scheduler.REGION_LOCALITY.setState(true);
//    	Scheduler.REGION_ORDER.setState(true);
//    	Scheduler.REGION_STACK.setState(true);
//    	Scheduler.REGION_TRAVERSAL.setState(true);
    	MyQVT myQVT = createQVT("UpperToLower", Simplegraph2graphPackage.eINSTANCE, SimplegraphPackage.eINSTANCE);
//		myQVT.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	try {
    		Transformation asTransformation = myQVT.compileTransformation();
	        myQVT.createGeneratedExecutor(asTransformation, "SimpleGraph2Graph.genmodel");
			myQVT.loadInput("upperGraph", "SimpleGraph.xmi");
	    	myQVT.executeTransformation();
			myQVT.saveOutput("lowerGraph", "SimpleGraphLower_CG.xmi", "SimpleGraphLower_expected.xmi", UpperToLowerNormalizer.INSTANCE);
    	}
    	finally {
    		myQVT.dispose();
    	}
    }

    /*
     * 	UmlToRdbms has a loop from NonLeafAttribute in mapping complexAttributeComplexAttributes_LM,
     *  probably breakable by classComplexAttributes_LM, but still we can't schedule it.
    */

//    @Test -- too slow and not a full test anyway
    public void zztestUmlToRdbms() throws Exception {
    	MyQVT myQVT = createQVT("UmlToRdbms");
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("UmlToRdbms");;
//    	URI samplesBaseUri = testBaseURI.appendSegment("samples");
    	MtcBroker mtc = new MtcBroker(testBaseURI, "UmlToRdbms.qvtcas", myQVT.getEnvironmentFactory(), TestsXMLUtil.defaultSavingOptions);
    	mtc.setCreateGraphml(true);
    	mtc.execute();
    	//mtc.executeQvtpQvtsToQvti();
    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
        assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
        assertNoValidationErrors("QVTi validation", mtc.getiModel().getRooteObject());
        // Run the QVTi transformation in interpreter mode
//    	URI inputURI = samplesBaseUri.appendSegment("SimpleUMLPeople.xmi");
//    	URI outputURI = samplesBaseUri.appendSegment("SimpleRDBMSPeople.xmi");
//    	URI middleURI = samplesBaseUri.appendSegment("SimpleUMLtoRDBMS_trace.xmi");
//    	URI expectedOutputURI = samplesBaseUri.appendSegment("SimpleRDBMSPeople_expected.xmi");
    	
/* Fails because scheduler uses realized variable in expressions 
    	BasicQVTiExecutor qvtiExecutor = new BasicQVTiExecutor(myQVT.getEnvironmentFactory(), mtc.getTransformation(mtc.getiModel().getResource()));
    	qvtiExecutor.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	qvtiExecutor.loadModel("uml", inputURI);
    	qvtiExecutor.createModel("middle", middleURI, null);
    	qvtiExecutor.createModel("rdbms", outputURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        qvtiExecutor.execute();
        qvtiExecutor.saveModels(TestsXMLUtil.defaultSavingOptions);
        
        Resource expected =  myQVT.getEnvironmentFactory().getResourceSet().getResource(expectedOutputURI, true);
        Resource actual =  myQVT.getEnvironmentFactory().getResourceSet().getResource(outputURI, true);
        assertSameModel(expected, actual);
       
        qvtiExecutor.dispose(); */
        mtc.disposeModels();
    	myQVT.dispose();
    }

/*    @Test -- fails through lack of multi-headed support, which may not be needed if better partitioned
    public void testNewUmlToRdbms() throws Exception {
    	QVTiEnvironmentFactory environmentFactory = myQVT.getEnvironmentFactory();
        ResourceSet resourceSet = environmentFactory.getResourceSet();
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("UmlToRdbms");;
    	URI samplesBaseUri = testBaseURI.appendSegment("samples");
		MtcBroker mtc = new MtcBroker(testBaseURI, "UmlToRdbms.qvtcas", environmentFactory, TestsXMLUtil.defaultSavingOptions);
    	mtc.setCreateGraphml(true);
    	mtc.newExecute();
    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
//        assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
        assertNoValidationErrors("QVTi validation", mtc.getiResource());

    	URI inputURI = samplesBaseUri.appendSegment("SimpleUMLPeople.xmi");
    	URI outputURI = samplesBaseUri.appendSegment("SimpleRDBMSPeople.xmi");
    	URI middleURI = samplesBaseUri.appendSegment("SimpleUMLtoRDBMS_trace.xmi");
    	URI expectedOutputURI = samplesBaseUri.appendSegment("SimpleRDBMSPeople_expected.xmi");
    	BasicQVTiExecutor qvtiExecutor = new BasicQVTiExecutor(environmentFactory, mtc.getTransformation(mtc.getiResource()));
    	qvtiExecutor.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	qvtiExecutor.loadModel("uml", inputURI);
    	qvtiExecutor.createModel("middle", middleURI, null);
    	qvtiExecutor.createModel("rdbms", outputURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        qvtiExecutor.execute();
        
		Resource expected =  resourceSet.getResource(expectedOutputURI, true);
        Resource actual =  resourceSet.getResource(outputURI, true);
        assertSameModel(expected, actual);
       
        mtc.disposeModels();
    } */
}
