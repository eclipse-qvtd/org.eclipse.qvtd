package org.eclipse.qvtd.buid.cs2as;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.qvtd.build.etl.PivotModel;
import org.eclipse.qvtd.build.etl.QvtMtcExecutionException;

public class PivotModelUtil {

	private OCL ocl;
	
	public PivotModelUtil(OCL mmManager) {
		
		this.ocl = mmManager;
	}
	
	/**
	 * Creates a Pivot Model with the given attributes. The models are not expanded
	 * by default.
	 *
	 * @param modeUri the mode uri
	 * @param modelName the model name
	 * @param modelAliases the model aliases (Comma separated string)
	 * @param metamodelUris the metamodel URIs
	 * @param readOnLoad read on load flag
	 * @param storeOnDispoal store on disposal flag 
	 * @param cached cached flag
	 * @param the model is a pivot resource (i.e. .oclas)
	 * @return the pivot model
	 * @throws QvtMtcExecutionException There was an error loading the model
	 */
	// Copied from MTC broker
	public PivotModel createPivotModel(String modeUri, String modelName, String modelAliases, String metamodelUris,
			boolean readOnLoad, boolean storeOnDispoal, boolean cached, boolean resolveExternalRefs, boolean isPivotResource) throws QvtMtcExecutionException {

		PivotModel model = new PivotModel(ocl, isPivotResource);
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, modelName);
		properties.put(EmfModel.PROPERTY_ALIASES, modelAliases);
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, metamodelUris);
		properties.put(EmfModel.PROPERTY_MODEL_URI, modeUri);
		properties.put(EmfModel.PROPERTY_READONLOAD, String.valueOf(readOnLoad));
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, String.valueOf(storeOnDispoal));
		properties.put(EmfModel.PROPERTY_CACHED, String.valueOf(cached));
		properties.put(EmfModel.PROPERTY_EXPAND, String.valueOf(resolveExternalRefs));
		try {
			model.load(properties, "");
		} catch (EolModelLoadingException e) {
			throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
		}
		return model;
	}
}
