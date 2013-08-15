package org.eclipse.qvtd.build.etl.utilities;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.utilities.PivotResource;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.essentialocl.services.EssentialOCLLinkingService;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.xtext.qvtbase.tests.LoadTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ASTModels extends LoadTestCase {
	
	public static PivotResource pivotResource;
	
	@Before
    public void setUp() throws Exception {
	    
		EssentialOCLLinkingService.DEBUG_RETRY = true;
		super.setUp();
		QVTcorePivotStandaloneSetup.doSetup();
		metaModelManager = new MetaModelManager();
        MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
    }
	
	@After
    public void tearDown() throws Exception {
		super.tearDown();
    }
	
	@Test
    public void testSaveAstXmi() throws Exception {
		
		String transformationFileName = "UpperToLower.qvtc";
		Transformation t = loadTransformation(metaModelManager, getProjectFileURI(transformationFileName));
		
    }

	
	public static @NonNull Transformation loadTransformation(@NonNull MetaModelManager metaModelManager, @NonNull URI transformationURI) throws IOException {
		
		// Load the transformation resource
        BaseCSResource xtextResource = null;
        xtextResource = (BaseCSResource) metaModelManager.getExternalResourceSet().getResource(transformationURI, true);
        if (xtextResource != null) {
    		CS2PivotResourceAdapter adapter = null;
    		try {
    			adapter = CS2PivotResourceAdapter.getAdapter(xtextResource, null);
    			pivotResource = (PivotResource)adapter.getPivotResource(xtextResource);
    			for (EObject eContent : pivotResource.getContents()) {
    				if (eContent instanceof ImperativeModel) {
    	    			for (EObject eObject : ((ImperativeModel)eContent).getNestedPackage()) {
    	    				if (eObject instanceof Transformation) {
    	    	                return (Transformation)eObject;
    	    				}
    	    			}
    				}
    			}
    		} finally {
    			if (adapter != null) {
    				adapter.dispose();
    			}
    		}
        } else {
        	// TODO Can I get the parsing errors?
        	//return null;
        }
        throw new IOException("There was an error loading the QVTi file. ");
	}

}
