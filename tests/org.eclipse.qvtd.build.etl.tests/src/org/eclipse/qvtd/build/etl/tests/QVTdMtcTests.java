package org.eclipse.qvtd.build.etl.tests;

import java.net.URL;

import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.qvtd.build.etl.MtcBroker;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class QVTdMtcTests extends LoadTestCase {
	
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase#setUp()
	 */
	@Before
    public void setUp() throws Exception {
	    
		EssentialOCLLinkingService.DEBUG_RETRY = true;
		super.setUp();
		QVTcoreStandaloneSetup.doSetup();
		QVTimperativeStandaloneSetup.doSetup();
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
    public void testUmlToRdbms() throws Exception {
    	
    	URL r = this.getClass().getResource("UmlToRdbms/UmlToRdbms.qvtcas");
		String qvtcasUri = r.toURI().toString();
    	MtcBroker mtc = new MtcBroker(qvtcasUri, this.getClass());
    	mtc.execute();
    }
    
    @Test
    public void testUpperToLower() throws Exception {
    	
    	URL r = this.getClass().getResource("UpperToLower/UpperToLower.qvtcas");
		String qvtcasUri = r.toURI().toString();
    	MtcBroker mtc = new MtcBroker(qvtcasUri, this.getClass());
    	mtc.execute();
    }
    
    @Test
    public void testHSVToHLS() throws Exception {
    	
    	URL r = this.getClass().getResource("HSV2HLS/HSV2HLS.qvtc");
		String qvtcasUri = r.toURI().toString();
    	MtcBroker mtc = new MtcBroker(qvtcasUri, this.getClass());
    	mtc.execute();
    }
	
}
