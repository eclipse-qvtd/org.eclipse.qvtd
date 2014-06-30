package org.eclipse.qvtd.build.etl;

import java.net.URISyntaxException;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public class MtcBroker {
	
	
	private static final String CONFIG_MODEL_NAME = "config";
	private static final String ECORE_URI = "http://www.eclipse.org/emf/2002/Ecore";
	
	
	private String configResourcePath;

	
	
	public MtcBroker() {
	
		// TODO Auto-generated constructor stub
	}

	private void loadMetamodelAsModels() throws EolModelLoadingException, URISyntaxException {
		
		// 1. Get the metamodels from the configuration
		EmfModel configModel = createEmfModel(configResourcePath, CONFIG_MODEL_NAME, ECORE_URI, true, false);
		
		// 2. Run the EOL operations to get the candidate models
		
		
	}
	
	
	private static EmfModel createEmfModel(String resourcePath, String modelName, String metamodelUri, boolean readOnLoad, boolean storeOnDispoal) 
			throws EolModelLoadingException, URISyntaxException {
	
		EmfModel emfModel = new EmfModel();
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, modelName);
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, ECORE_URI);
		properties.put(EmfModel.PROPERTY_MODEL_URI, 
				getURI(resourcePath));
		properties.put(EmfModel.PROPERTY_READONLOAD, readOnLoad);
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, storeOnDispoal);
		emfModel.load(properties, null);
		return emfModel;
	}
	
	/**
	 * Return a java.net.URI for an specified filename  
	 * 
	 * @param fileName filename to obtain the URI
	 * @return URI for the provided filename
	 */
	private static java.net.URI getURI(String fileName)  {
	    return java.net.URI.create(URI.createFileURI(fileName).toString());
	}
	
	/**
	 * Return a string representing the URI for a resource
	 * 
	 * @param resource resource to obtain an URI
	 * @return the URI for the provided resource
	 * @throws URISyntaxException
	 */
	private static String getResourceURI(String resource) throws URISyntaxException {
		String uri = MtcBroker.class.getResource(resource).toURI().toString();
	    if (uri.toString().indexOf("bin") > -1) {
	      uri = uri.toString().replaceAll("bin", "src");
	    }
	    return uri;
	}
	

}
