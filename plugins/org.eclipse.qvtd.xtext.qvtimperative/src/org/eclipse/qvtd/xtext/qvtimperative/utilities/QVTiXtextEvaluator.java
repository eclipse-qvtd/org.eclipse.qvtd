package org.eclipse.qvtd.xtext.qvtimperative.utilities;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.utilities.PivotResource;
import org.eclipse.ocl.examples.xtext.base.utilities.BaseCSResource;
import org.eclipse.ocl.examples.xtext.base.utilities.CS2PivotResourceAdapter;
import org.eclipse.ocl.examples.xtext.completeocl.validation.CompleteOCLEObjectValidator;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiPivotEvaluator;

/**
 * A QVTiXtextEvaluator supports loading a transformation as source then loading models, performing a transformation
 * and then saving the models.
 * 
 * @see QVTiPivotEvaluator
 */
public class QVTiXtextEvaluator extends QVTiPivotEvaluator
{
	
	public static PivotResource pivotResource;
	
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
    
    
    public QVTiXtextEvaluator(@NonNull MetaModelManager metaModelManager, @NonNull URI transformationURI) throws IOException {
    	super(metaModelManager, loadTransformation(metaModelManager, transformationURI));
    }
    
    
	
}
