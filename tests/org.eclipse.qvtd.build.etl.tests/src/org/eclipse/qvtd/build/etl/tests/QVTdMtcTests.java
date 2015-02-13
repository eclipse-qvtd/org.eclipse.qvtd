package org.eclipse.qvtd.build.etl.tests;

import java.io.IOException;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.build.etl.MtcBroker;
import org.eclipse.qvtd.build.etl.PivotModel;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiPivotEvaluator;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QVTdMtcTests extends LoadTestCase {
	
	private static URI TESTS_BASE_URI = URI.createPlatformResourceURI("/org.eclipse.qvtd.build.etl.tests/src/org/eclipse/qvtd/build/etl/tests", true);
	
	protected class MyQVT extends OCL
	{
		public MyQVT(@NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
		}

		public @Nullable QVTiPivotEvaluator createEvaluator(@NonNull PivotModel qvtiModel) throws IOException {
			try {
				return new QVTiPivotEvaluator(getEnvironmentFactory(), qvtiModel.getTransformation());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
			return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
		}
	}
	
	protected static class MyQVTiEnvironmentFactory extends QVTiEnvironmentFactory
	{
		public MyQVTiEnvironmentFactory(@Nullable ProjectManager projectMap, @Nullable ResourceSet externalResourceSet) {
			super(projectMap, externalResourceSet);
	    	setEvaluationTracingEnabled(true);
		}
	}
	
	
	public static void assertSameModel(@NonNull Resource expectedResource, @NonNull Resource actualResource) throws IOException, InterruptedException {
		org.eclipse.ocl.examples.xtext.tests.XtextTestCase.assertSameModel(expectedResource, actualResource);
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

	protected @NonNull MyQVT createQVT() {
		return new MyQVT(new MyQVTiEnvironmentFactory(getProjectMap(), null));
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
    
    
    @Test
    public void testUmlToRdbms() throws Exception {
    	
    	MyQVT myQVT = createQVT();
    	
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("UmlToRdbms");;
    	URI samplesBaseUri = testBaseURI.appendSegment("samples");
    	MtcBroker mtc = new MtcBroker(testBaseURI, "UmlToRdbms.qvtcas", myQVT.getEnvironmentFactory());
    	mtc.execute();
    	//mtc.executeScheduling(true);
    	
    	Diagnostic diagnostic = Diagnostician.INSTANCE.validate(mtc.getuModel().getRooteObject());
    	// TODO do we want perfect or can we tolerate info and warnings?
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getmModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getpModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getsModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        diagnostic = Diagnostician.INSTANCE.validate(mtc.getiModel().getRooteObject());
        assertTrue(diagnostic.getSeverity() < Diagnostic.ERROR);
        
        // Run the QVTi transformation in interpreter mode
    	URI inputURI = samplesBaseUri.appendSegment("SimpleUMLPeople.xmi");
    	URI outputURI = samplesBaseUri.appendSegment("SimpleRDBMSPeople.xmi");
    	URI middleURI = samplesBaseUri.appendSegment("SimpleUMLtoRDBMS_trace.xmi");
    	URI expectedOutputURI = samplesBaseUri.appendSegment("SimpleRDBMSPeople_expected.xmi");
    	
        QVTiPivotEvaluator testEvaluator = myQVT.createEvaluator(mtc.getiModel());
    	testEvaluator.loadModel("uml", inputURI);
        testEvaluator.createModel("middle", middleURI, null);
        testEvaluator.createModel("rdbms", outputURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        testEvaluator.execute();
        
        Resource expected =  myQVT.getEnvironmentFactory().getResourceSet().getResource(expectedOutputURI, true);
        Resource actual =  myQVT.getEnvironmentFactory().getResourceSet().getResource(outputURI, true);
        assertSameModel(expected, actual);
        
        testEvaluator.dispose();
        mtc.disposeModels();
        myQVT.dispose();
    }
    
    @Test
    public void testUpperToLower() throws Exception {
    	
    	MyQVT myQVT = createQVT();
    	
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("UpperToLower");;
    	MtcBroker mtc = new MtcBroker(testBaseURI, "UpperToLower.qvtcas", myQVT.getEnvironmentFactory());
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

        URI samplesBaseUri = testBaseURI.appendSegment("samples");
        URI inputURI = samplesBaseUri.appendSegment("SimpleGraph.xmi");
    	URI outputURI = samplesBaseUri.appendSegment("SimpleGraphLower.xmi");
    	URI middleURI = samplesBaseUri.appendSegment("UpperToLower_trace.xmi");
    	URI expectedOutputURI = samplesBaseUri.appendSegment("SimpleGraphLower_expected.xmi");
        QVTiPivotEvaluator testEvaluator = myQVT.createEvaluator(mtc.getiModel());
        testEvaluator.loadModel("upperGraph", inputURI);
        testEvaluator.createModel("middle", middleURI, null);
        testEvaluator.createModel("lowerGraph", outputURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        testEvaluator.execute();
        testEvaluator.saveModels();
        
        Resource expected =  myQVT.getEnvironmentFactory().getResourceSet().getResource(expectedOutputURI, true);
        Resource actual =  myQVT.getEnvironmentFactory().getResourceSet().getResource(outputURI, true);
        assertSameModel(expected, actual);
        
        testEvaluator.dispose();
        mtc.disposeModels();
        myQVT.dispose();
    }
    
    @Test
    public void testHSVToHLS() throws Exception {
    	
    	
    	MyQVT myQVT = createQVT();
    	
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("HSV2HLS");;
    	MtcBroker mtc = new MtcBroker(testBaseURI, "HSV2HLS.qvtcas", myQVT.getEnvironmentFactory());
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
        
        URI samplesBaseUri = testBaseURI.appendSegment("samples");
        URI inputURI = samplesBaseUri.appendSegment("SolarizedHSV.xmi");
    	URI outputURI = samplesBaseUri.appendSegment("SolarizedHLS.xmi");
    	URI middleURI = samplesBaseUri.appendSegment("HSV2HLS_trace.xmi");
    	URI expectedOutputURI = samplesBaseUri.appendSegment("SolarizedHLS_expected.xmi");
    	QVTiPivotEvaluator testEvaluator = myQVT.createEvaluator(mtc.getiModel());
    	testEvaluator.loadModel("hsv", inputURI);
        testEvaluator.createModel("middle", middleURI, null);
        testEvaluator.createModel("hls", outputURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        testEvaluator.execute();
        testEvaluator.saveModels();
        
        Resource expected =  myQVT.getEnvironmentFactory().getResourceSet().getResource(expectedOutputURI, true);
        Resource actual =  myQVT.getEnvironmentFactory().getResourceSet().getResource(outputURI, true);
        assertSameModel(expected, actual);
        
        testEvaluator.dispose();
        mtc.disposeModels();
        myQVT.dispose();
    }
    
	
}
