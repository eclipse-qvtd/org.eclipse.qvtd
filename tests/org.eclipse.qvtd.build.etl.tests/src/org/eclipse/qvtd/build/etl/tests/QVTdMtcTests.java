package org.eclipse.qvtd.build.etl.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.notify.impl.SingletonAdapterImpl;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.StandaloneProjectMap;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.qvtd.build.etl.MtcBroker;
import org.eclipse.qvtd.build.etl.PivotModel;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiPivotEvaluator;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtimperative.utilities.QVTiXtextEvaluator;
import org.eclipse.xtext.util.EmfFormatter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QVTdMtcTests extends LoadTestCase {
	
	
	private static URI TESTS_BASE_URI = URI.createPlatformResourceURI("org.eclipse.qvtd.build.etl.tests/src/org/eclipse/qvtd/build/etl/tests", true);
	
	protected class MyQVT extends OCL
	{
		public MyQVT(@NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
		}

		public @NonNull QVTiPivotEvaluator createEvaluator(Transformation transformation) throws IOException {
			return new QVTiPivotEvaluator(getEnvironmentFactory(), transformation);
		}

		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}
	}
	
	private MyQVT myQVT;

		
	/**
	 * Assert same model.
	 *
	 * @param expectedResource the expected resource
	 * @param actualResource the actual resource
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws InterruptedException the interrupted exception
	 */
	public static void assertSameModel(Resource expectedResource, Resource actualResource) throws IOException, InterruptedException {
		String expected = EmfFormatter.listToStr(expectedResource.getContents());
		String actual = EmfFormatter.listToStr(actualResource.getContents());
		assertEquals(expected, actual);
	}
	
	protected static void assertLoadable(@NonNull URI asURI) {
        ResourceSet asResourceSet = OCL.createEnvironmentFactory(OCL.NO_PROJECTS).getMetamodelManager().getASResourceSet();
        if (!EMFPlugin.IS_ECLIPSE_RUNNING) {
			OCLstdlib.install();
//	        MetamodelManager.initializeASResourceSet(asResourceSet);
        }
        Resource resource = asResourceSet.getResource(asURI, true);
        EcoreUtil.resolveAll(resource);
        assertNoUnresolvedProxies("Loading", resource);
        assertNoResourceErrors("Loading", resource);
	}

	
	protected @NonNull MyQVT createQVT() {
		return new MyQVT(new QVTiEnvironmentFactory(new StandaloneProjectMap()));
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Before
    public void setUp() throws Exception {
	    
		BaseLinkingService.DEBUG_RETRY.setState(true);
		super.setUp();
		CompleteOCLStandaloneSetup.doSetup(); // To be able to add QVTimperative.ocl validation
		QVTcoreStandaloneSetup.doSetup();
		QVTimperativePivotStandaloneSetup.doSetup();
		
		myQVT = createQVT();
		QVTiEnvironmentFactory factory = myQVT.getEnvironmentFactory(); 
		factory.setEvaluationTracingEnabled(true);
		PivotMetamodelManager metamodelManager = factory.getMetamodelManager();
		metamodelManager.configureLoadFirstStrategy(); // Since the models might use a different URI to refer the same meta-model
    }
	
	 /* (non-Javadoc)
     * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#tearDown()
     */
    @After
    public void tearDown() throws Exception {
    	myQVT.dispose();
		super.tearDown();
    }
    
    
    @Test
    public void testUmlToRdbms() throws Exception {
    	
    	
    	URI baseURI = TESTS_BASE_URI.appendSegment("UmlToRdbms");
    	String qvtcSource = "UmlToRdbms.qvtcas";
    	
    	MtcBroker mtc = new MtcBroker(baseURI, qvtcSource, myQVT);
    	mtc.execute();
    	Diagnostic diagnostic = Diagnostician.INSTANCE.validate(mtc.getuModel().getRooteObject());
    	// TODO do we want perfect or can we tolerate info and warnings?
        //assertEquals(Diagnostic.OK, diagnostic.getSeverity());
    	assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getmModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getpModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getsModel().getRooteObject());
        //assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getiModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        
        // Run the QVTi transformation
        PivotModel qvtiTransf = mtc.getiModel();
    	//URI txURI = ClassUtil.nonNullState(qvtiTransf.getResource().getURI());
    	//assertValidQVTiModel(txURI);
        URI txURI = ClassUtil.nonNullState(qvtiTransf.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        URI samplesBaseUri = baseURI.appendSegment("samples");
        URI umlURI = samplesBaseUri.appendSegment("SimpleUMLPeople.xmi");
    	URI rdbmsURI = samplesBaseUri.appendSegment("SimpleRDBMSPeople.xmi");
    	URI traceURI = samplesBaseUri.appendSegment("SimpleUMLtoRDBMSPeople.xmi");
        
        QVTiPivotEvaluator testEvaluator =  new QVTiPivotEvaluator(myQVT.getEnvironmentFactory(), qvtiTransf.getTransformation());
    	testEvaluator.saveTransformation(null);
        testEvaluator.loadModel("uml", umlURI);
        testEvaluator.createModel("middle", traceURI, null);
        testEvaluator.createModel("rdbms", rdbmsURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        testEvaluator.execute();
        testEvaluator.saveModels();
        testEvaluator.dispose();
        // TODO create validation model 
        //testEvaluator.loadReference("rdbms", "SimpleRDBMSPeopleValidate.xmi");
        mtc.disposeModels();
    }
    /*
    @Test
    public void testUpperToLower() throws Exception {
    	
    	URL r = this.getClass().getResource("UpperToLower/UpperToLower.qvtcas");
		String qvtcasUri = MtcBroker.changeResourceToSource(r.toURI().toString());
    	MtcBroker mtc = new MtcBroker(qvtcasUri, this.getClass(), metamodelManager);
    	mtc.execute();
    	Diagnostic diagnostic = Diagnostician.INSTANCE.validate(mtc.getuModel().getRooteObject());
    	assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getmModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getpModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getsModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getiModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(metamodelManager, "UpperToLower",mtc.getiModel().getTransformation());
    	testEvaluator.saveTransformation(null);
        testEvaluator.loadModel("upperGraph", "SimpleGraph.xmi");
        testEvaluator.createModel("middle", "Graph2Graph.xmi");
        testEvaluator.createModel("lowerGraph", "SimpleGraphLower.xmi");
        testEvaluator.loadReference("lowerGraph", "SimpleGraphLowerValidate.xmi");
        System.out.println("Executing QVTi transformation on test models.");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = ClassUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        mtc.disposeModels();
    }
    
    @Test
    public void testHSVToHLS() throws Exception {
    	
    	URL r = this.getClass().getResource("HSV2HLS/HSV2HLS.qvtcas");
		String qvtcasUri = MtcBroker.changeResourceToSource(r.toURI().toString());
    	MtcBroker mtc = new MtcBroker(qvtcasUri, this.getClass(), metamodelManager);
    	mtc.execute();
    	Diagnostic diagnostic = Diagnostician.INSTANCE.validate(mtc.getuModel().getRooteObject());
    	assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getmModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getpModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getsModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getiModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        MyQvtiEvaluator testEvaluator = new MyQvtiEvaluator(metamodelManager, "HSV2HLS",mtc.getiModel().getTransformation());
    	testEvaluator.saveTransformation(null);
        testEvaluator.loadModel("hsv", "HSVNode.xmi");
        testEvaluator.createModel("middle", "HSV2HLS.xmi");
        testEvaluator.createModel("hls", "HLSNode.xmi");
        testEvaluator.loadReference("hls", "HLSNodeValidate.xmi");
        System.out.println("Executing QVTi transformation on test models.");
        testEvaluator.test();
        testEvaluator.dispose();
        
        URI txURI = ClassUtil.nonNullState(testEvaluator.getTransformation().eResource().getURI());
        assertLoadable(txURI);
        mtc.disposeModels();
        
    }
    */
    
    protected static void assertValidQVTiModel(@NonNull URI asURI ) {
	    
		EnvironmentFactory factory =  OCL.createEnvironmentFactory(new StandaloneProjectMap());
		/* FIXME Validating QVTi models are causing problems. Not researched.
		MetamodelManager.Internal mManager = factory.getMetamodelManager(); 
        mManager.configureLoadFirstStrategy();
		
		URI oclURI = ClassUtil.nonNullState(URI.createPlatformResourceURI("/org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ocl", true));

		CompleteOCLEObjectValidator validator = new CompleteOCLEObjectValidator(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE), oclURI, factory);
		validator.initialize();
		PivotEObjectValidator.install(ClassUtil.nonNullState(factory.getResourceSet()), factory);
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTbasePackage.eINSTANCE));
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTcoreBasePackage.eINSTANCE));
		PivotEObjectValidator.install(ClassUtil.nonNullState(QVTimperativePackage.eINSTANCE));*/
		
		assertValidModel(asURI, factory.getResourceSet());
	}
    
    protected static void assertValidModel(URI asURI, ResourceSet rSet) {
		Resource resource = rSet.getResource(asURI, true);
        EcoreUtil.resolveAll(resource);
	        
		String rUriString = resource.getURI().toString();
		assertNoUnresolvedProxies("Validating a resource: " + rUriString, resource);
        assertNoResourceErrors("Loading a resource" + rUriString, resource);
        //assertNoValidationErrors("Loading a resource" + rUriString, resource);
	}
	
}
