package org.eclipse.qvtd.build.qvtrtoqvtc.tests;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtrelation.QVTrelationStandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class QvtrToQvtcTests extends LoadTestCase {
	
	private static URI TESTS_BASE_URI = URI.createPlatformResourceURI("/org.eclipse.qvtd.build.qvtrtoqvtc.tests/src/org/eclipse/qvtd/build/qvtrtoqvtc/tests/", true);

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Before
    public void setUp() throws Exception {
//		BaseLinkingService.DEBUG_RETRY.setState(true);
		super.setUp();
		QVTrelationStandaloneSetup.doSetup();
		QVTcoreStandaloneSetup.doSetup();
//		QVTcoreBaseStandaloneSetup.doSetup();
    }
 
    /* (non-Javadoc)
     * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#tearDown()
     */
    @After
    public void tearDown() throws Exception {
		super.tearDown();
    }
    
    /*@Test
    public void testAbstractToConcrete() throws Exception {
    	URL projectURL = this.getClass().getResource("abstracttoconcrete/AbstractToConcrete.qvtras");
    	File f = new File(projectURL.getFile());
    	URI qvtrURI = URI.createFileURI(f.toString());
    	Resource qvtrResource = metaModelManager.getASResourceSet().getResource(qvtrURI, true);
    	URI qvtcURI = qvtrURI.trimFileExtension();
    	qvtcURI = qvtcURI.appendFileExtension("qvtcas");
    	Resource qvtcResource = metaModelManager.getASResourceSet().createResource(qvtcURI, null);
    	URI qvtcTraceURI = qvtrURI.trimFileExtension();
    	qvtcTraceURI = qvtcTraceURI.appendFileExtension("ecore.oclas");
    	Resource qvtcTraceResource = metaModelManager.getASResourceSet().createResource(qvtcTraceURI, null);
    	QvtrToQvtcTransformation t = new QvtrToQvtcTransformation(metaModelManager, qvtrResource, qvtcResource, qvtcTraceResource);
		t.prepare();
		t.execute();
		Map<Object, Object> options = new HashMap<Object, Object>();
        options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
        t.save(qvtcTraceResource, t.getTraceRoots(), options);
        assertNoResourceErrors("Trace save", qvtcTraceResource);
        t.save(qvtcResource, t.getCoreRoots(), options);
        assertNoResourceErrors("Core save", qvtcResource);
		
    }*/
   
   /* @Test
    public void testClassModelToClassModel() throws Exception {
    	URL projectURL = this.getClass().getResource("classmodeltoclassmodel/ClassModelToClassModel.qvtras");
    	File f = new File(projectURL.getFile());
    	URI qvtrURI = URI.createFileURI(f.toString());
    	Resource qvtrResource = metaModelManager.getASResourceSet().getResource(qvtrURI, true);
    	URI qvtcURI = qvtrURI.trimFileExtension();
    	qvtcURI = qvtcURI.appendFileExtension("qvtcas");
    	Resource qvtcResource = metaModelManager.getASResourceSet().createResource(qvtcURI, null);
    	URI qvtcTraceURI = qvtrURI.trimFileExtension();
    	qvtcTraceURI = qvtcTraceURI.appendFileExtension("ecore.oclas");
    	Resource qvtcTraceResource = metaModelManager.getASResourceSet().createResource(qvtcTraceURI, null);
    	QvtrToQvtcTransformation t = new QvtrToQvtcTransformation(metaModelManager, qvtrResource, qvtcResource, qvtcTraceResource);
		t.prepare();
		t.execute();
		Map<Object, Object> options = new HashMap<Object, Object>();
        options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
        t.save(qvtcTraceResource, t.getTraceRoots(), options);
        assertNoResourceErrors("Trace save", qvtcTraceResource);
        t.save(qvtcResource, t.getCoreRoots(), options);
        assertNoResourceErrors("Core save", qvtcResource);
		
    }*/
    
    @Test
    public void testSeqToStm() throws Exception {
    	
    	URI testBaseURI = TESTS_BASE_URI.appendSegment("seqtostm");
		OCL ocl = OCL.newInstance(OCL.NO_PROJECTS);
    	ResourceSet asResourceSet = ocl.getMetamodelManager().getASResourceSet();
    	URI qvtrURI = testBaseURI.appendSegment("SeqToStm.qvtras");
		Resource qvtrResource = asResourceSet.getResource(qvtrURI, true);
    	URI qvtcURI = qvtrURI.trimFileExtension();
    	qvtcURI = qvtcURI.appendFileExtension("qvtcas");
    	Resource qvtcResource = asResourceSet.createResource(qvtcURI, null);
    	URI qvtcTraceURI = qvtrURI.trimFileExtension();
    	qvtcTraceURI = qvtcTraceURI.appendFileExtension("ecore.oclas");
    	Resource qvtcTraceResource = asResourceSet.createResource(qvtcTraceURI, null);
    	QvtrToQvtcTransformation t = new QvtrToQvtcTransformation(ocl.getEnvironmentFactory(), qvtrResource, qvtcResource, qvtcTraceResource);
		t.prepare();
		t.execute();
		Map<Object, Object> options = new HashMap<Object, Object>();
        options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
        t.saveTrace(qvtcTraceResource, t.getTraceRoots(), options);
        assertNoResourceErrors("Trace save", qvtcTraceResource);
        t.saveCore(qvtcResource, t.getCoreRoots(), options);
        assertNoResourceErrors("Core save", qvtcResource);
        ocl.dispose();
    }

}
