package org.eclipse.qvtd.build.qvtrtoqvtc.tests;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.qvtd.build.qvtrtoqvtc.QvtrToQvtcTransformation;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtrelation.QVTrelationStandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class QvtrToQvtcTests extends LoadTestCase {

	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Before
    public void setUp() throws Exception {
	    
		EssentialOCLLinkingService.DEBUG_RETRY = true;
		super.setUp();
		QVTrelationStandaloneSetup.doSetup();
		QVTcoreStandaloneSetup.doSetup();
		metaModelManager = new MetaModelManager();
        MetaModelManagerResourceSetAdapter.getAdapter(DomainUtil.nonNullState(resourceSet), metaModelManager);
    }
 
    /* (non-Javadoc)
     * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#tearDown()
     */
    @After
    public void tearDown() throws Exception {
		super.tearDown();
    }
    
    @Test
    public void testTransformation() throws Exception {
//    	System.out.println(getClass().getResource("."));
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
    	QvtrToQvtcTransformation t = new QvtrToQvtcTransformation(qvtrResource, qvtcResource, qvtcTraceResource);
		t.prepare();
		t.execute();
		Map<Object, Object> options = new HashMap<Object, Object>();
        options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
        t.save(qvtcTraceResource, t.getTraceRoots(), options);
        assertNoResourceErrors("Trace save", qvtcTraceResource);
        t.save(qvtcResource, t.getCoreRoots(), options);
        assertNoResourceErrors("Core save", qvtcResource);
		
    }

}
