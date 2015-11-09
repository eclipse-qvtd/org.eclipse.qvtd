/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.build.etl.tests;

import java.io.IOException;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.tests.TestUtil;
import org.eclipse.ocl.pivot.model.OCLstdlib;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.base.services.BaseLinkingService;
import org.eclipse.qvtd.compiler.internal.etl.MtcBroker;
import org.eclipse.qvtd.compiler.internal.etl.PivotModel;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.BasicQVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtbase.tests.utilities.TestsXMLUtil;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QVTdMtcTests extends LoadTestCase {
	
	private static URI TESTS_BASE_URI = URI.createPlatformResourceURI("/org.eclipse.qvtd.build.etl.tests/bin/org/eclipse/qvtd/build/etl/tests", true);
	
	protected class MyQVT extends OCL
	{
		public MyQVT(@NonNull QVTiEnvironmentFactory environmentFactory) {
			super(environmentFactory);
		}

		public @Nullable BasicQVTiExecutor createExecutor(@NonNull PivotModel qvtiModel) throws IOException {
			try {
				return new BasicQVTiExecutor(getEnvironmentFactory(), qvtiModel.getTransformation());
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
    
    /*
     * 	UmlToRdbms has a loop from NonLeafAttribute in mapping complexAttributeComplexAttributes_LM,
     *  probably breakable by classComplexAttributes_LM, but still we can't schedule it.
    *
    @Test
    public void testUmlToRdbms() throws Exception {
    	
    	MyQVT myQVT = createQVT();
    	
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("UmlToRdbms");;
//    	URI samplesBaseUri = testBaseURI.appendSegment("samples");
    	MtcBroker mtc = new MtcBroker(testBaseURI, "UmlToRdbms.qvtcas", myQVT.getEnvironmentFactory(), TestsXMLUtil.defaultSavingOptions);
    	mtc.setCreateGraphml(true);
    	mtc.execute();
    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
        assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
        assertNoValidationErrors("QVTi validation", mtc.getiModel().getRooteObject());
        /*FIXME A decision on bug 465913 needs to be made so the transformation can execute
        // Run the QVTi transformation in interpreter mode
    	URI inputURI = samplesBaseUri.appendSegment("SimpleUMLPeople.xmi");
    	URI outputURI = samplesBaseUri.appendSegment("SimpleRDBMSPeople.xmi");
    	URI middleURI = samplesBaseUri.appendSegment("SimpleUMLtoRDBMS_trace.xmi");
    	URI expectedOutputURI = samplesBaseUri.appendSegment("SimpleRDBMSPeople_expected.xmi");
    	
/ * Fails because scheduler uses realized variable in expressions 
    	BasicQVTiExecutor qvtiExecutor = new BasicQVTiExecutor(myQVT.getEnvironmentFactory(), mtc.getTransformation(mtc.getiModel().getResource()));
    	qvtiExecutor.getEnvironmentFactory().setEvaluationTracingEnabled(true);
    	qvtiExecutor.loadModel("uml", inputURI);
    	qvtiExecutor.createModel("middle", middleURI, null);
    	qvtiExecutor.createModel("rdbms", outputURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        testEvaluator.execute();
        
        Resource expected =  myQVT.getEnvironmentFactory().getResourceSet().getResource(expectedOutputURI, true);
        Resource actual =  myQVT.getEnvironmentFactory().getResourceSet().getResource(outputURI, true);
        assertSameModel(expected, actual);
       
        qvtiExecutor.dispose(); * /
        mtc.disposeModels();
        myQVT.dispose();
    } */
	
    @Test
    public void testUpperToLower() throws Exception {
    	
    	MyQVT myQVT = createQVT();
    	
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("UpperToLower");;
    	MtcBroker mtc = new MtcBroker(testBaseURI, "UpperToLower.qvtcas", myQVT.getEnvironmentFactory(), TestsXMLUtil.defaultSavingOptions);
    	mtc.setCreateGraphml(true);
    	mtc.execute();
    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
        assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
        assertNoValidationErrors("QVTi validation", mtc.getiModel().getRooteObject());

        URI samplesBaseUri = testBaseURI.appendSegment("samples");
        URI inputURI = samplesBaseUri.appendSegment("SimpleGraph.xmi");
    	URI outputURI = samplesBaseUri.appendSegment("SimpleGraphLower.xmi");
    	URI middleURI = samplesBaseUri.appendSegment("UpperToLower_trace.xmi");
    	URI expectedOutputURI = samplesBaseUri.appendSegment("SimpleGraphLower_expected.xmi");
    	BasicQVTiExecutor testEvaluator = myQVT.createExecutor(mtc.getiModel());
        testEvaluator.getEnvironmentFactory().setEvaluationTracingEnabled(true);
        testEvaluator.loadModel("upperGraph", inputURI);
        testEvaluator.createModel("middle", middleURI, null);
        testEvaluator.createModel("lowerGraph", outputURI, null);
        System.out.println("Executing QVTi transformation on test models.");
        testEvaluator.execute();
        testEvaluator.saveModels(TestsXMLUtil.defaultSavingOptions);
        
        Resource expected =  myQVT.getEnvironmentFactory().getResourceSet().getResource(expectedOutputURI, true);
        Resource actual =  myQVT.getEnvironmentFactory().getResourceSet().getResource(outputURI, true);
        assertSameModel(expected, actual);
        
        testEvaluator.dispose();
        mtc.disposeModels();
        myQVT.dispose();
    }
    /*
    @Test
    public void testHSVToHLS() throws Exception {
    	
    	
    	MyQVT myQVT = createQVT();
    	
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("HSV2HLS");;
    	MtcBroker mtc = new MtcBroker(testBaseURI, "HSV2HLS.qvtcas", myQVT.getEnvironmentFactory(), TestsXMLUtil.defaultSavingOptions);
    	mtc.setCreateGraphml(true);
    	mtc.execute();
    	
    	assertNoValidationErrors("QVTu validation", mtc.getuModel().getRooteObject());
    	assertNoValidationErrors("QVTm validation", mtc.getmModel().getRooteObject());
        assertNoValidationErrors("QVTp validation", mtc.getpModel().getRooteObject());
        assertNoValidationErrors("QVTs validation", mtc.getsModel().getRooteObject());
        assertNoValidationErrors("QVTi validation", mtc.getiModel().getRooteObject());
        
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
        testEvaluator.saveModels(TestsXMLUtil.defaultSavingOptions);
        
        Resource expected =  myQVT.getEnvironmentFactory().getResourceSet().getResource(expectedOutputURI, true);
        Resource actual =  myQVT.getEnvironmentFactory().getResourceSet().getResource(outputURI, true);
        assertSameModel(expected, actual);
        
        testEvaluator.dispose();
        mtc.disposeModels();
        myQVT.dispose();
    }
    */
	
}
