package org.eclipse.qvtd.build.etl;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.ocl.examples.library.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.examples.pivot.internal.impl.PivotFactoryImpl;

public class MtcBroker {
	
	private static final String ECORE_URI = "http://www.eclipse.org/emf/2002/Ecore";
	
	private static final String CONFIG_MODEL_NAME = "config";
	private static final String CONFIG_MM = "/QVTcConfig.ecore";
	private static final String CONFIG_URI = "http://www.eclipse.org/qvt/examples/0.1/QVTcConfig";
	private static final String CONFIG_QUERIES_EOL = "helpers/ConfigQueries.eol";
	
	private static final String ECORE_CONTAINMENT_MM = "/ECoreContainmentTree.ecore";
	private static final String ECORE_CONTAINMENT_URI = "http://www.eclipse.org/qvt/examples/0.1/ECoreContainemntTree";
	private static final String ECORE_TO_TREE_EOL = "utils/EcoreToContainmentTree.eol";
	
	private static final String OCL_STD_LIB_MODEL_NAME = "oclStdLib";
	private static final String OCL_STD_LIB_MODEL = "/OCL-2.5.oclas";
	
	private static final String PIVOT_URI = "";
	
	private static final String QVTC_URI = "http://www.eclipse.org/qvt/0.9/QVTcore";
	
	private static final String QVTC_TO_QVTU_FLOCK = "mtc/QVTcToQVTu.mig";
	
	
	
	private String configResourcePath;
	private String qvtcasUri;
	private String qvtuUri;
	private String qvtmUri;
	private String partitionUri;
	private String qvtiUri;
	private String configUri;
	private String scheduleUri;
	
	
	private Class owner;
	
	private EmfModel configModel;
	private EmfModel oclStdLibModel;

	
	
	public MtcBroker(String qvtcasUri, Class owner) throws URISyntaxException {
	
		// 1. Derive all the required paths
		// QVTu *.qvtu.qvtas
		// QVTm *.qvtm.qvtas
		// Partition *.qvtp.qvtias
		// QVTi *.qvtias
		// Config *Config.xmi
		// Schedule *Schedule.xmi
		
		this.qvtcasUri = qvtcasUri;
		this.owner = owner;
		System.out.println(qvtcasUri);
		
		URI baseUri = URI.createURI(qvtcasUri).trimFileExtension();
		this.qvtuUri = baseUri.appendFileExtension("qvtu.qvtcas").toString();
		this.qvtmUri = baseUri.appendFileExtension("qvtm.qvtcas").toString();
		this.partitionUri = baseUri.appendFileExtension("qvtp.qvtias").toString();
		this.qvtiUri = baseUri.appendFileExtension("qvtias").toString();
		
		
		
		this.configUri = URI.createURI(baseUri.toString() + "Config").appendFileExtension("xmi").toString();
		this.scheduleUri = URI.createURI(baseUri.toString() + "Schdule").appendFileExtension("xmi").toString();
		registerMetamodels();
	}
	
	public void execute() throws EolModelLoadingException, EpsilonExecutionException, URISyntaxException, EpsilonSourceLoadException, EpsilonParseException {
		
		loadConfigurationModel();
		loadOclStdLibModel();
		createContainmentTrees();
		EmfModel cModel = createEmfModel(qvtcasUri, "QVTc", "QVT", QVTC_URI, true, false, true);
		EmfModel uModel = qvtcToqvtu(cModel);
		uModel.setCachingEnabled(true);
	}
	
	

	private EmfModel qvtcToqvtu(EmfModel cModel) {

		EmfModel uModel = null;
		try {
			uModel = createEmfModel(qvtuUri, "QVTu", "QVT", QVTC_URI, false, true, false);
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} if (cModel != null && uModel != null  ) {
			FlockTask flock = null;
			try {
				flock = new FlockTask(java.net.URI.create(getResourceURI(QVTC_TO_QVTU_FLOCK)));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (flock != null) {
					flock.models.add(cModel);
					flock.models.add(uModel);
					flock.models.add(configModel);
					flock.models.add(oclStdLibModel);
					try {
						flock.execute();
					} catch (EpsilonParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (EpsilonSourceLoadException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (EpsilonExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return uModel;
	}

	private void createContainmentTrees() {
		
		List<String> mms = getCandidateMetamodels();
		Map<EmfModel, EmfModel> emfModels = new HashMap<EmfModel, EmfModel>();
		for (String mm : mms) {
			//TODO Check if the containment Tree exist?
			String modelUri = null;
			try {
				modelUri = getResourceUriFromClass(this.owner, mm);
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (modelUri != null) {
					EmfModel mmModel = null;
					EmfModel cgModel = null;
					try {
						mmModel = createEmfModel(changeResourceToSource(modelUri), "mm", "", ECORE_URI, true, false, true);
						String cgUri = mmModel.getModelFileUri().trimFileExtension().toString() + "ContainmentTree.xmi";
						cgModel = createEmfModel(cgUri, "tree", "", ECORE_CONTAINMENT_URI, false, true, true);
					} catch (EolModelLoadingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						if (mmModel != null && cgModel != null  ) {
							emfModels.put(mmModel, cgModel);
						}
					}
				} 
			}		
		}
		EolTask eol = null;
		try {
			eol = new EolTask(java.net.URI.create(getResourceURI(ECORE_TO_TREE_EOL)));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally  {
			if (eol != null) {
				for (EmfModel em : emfModels.keySet()) {
					eol.models.add(em);
					eol.models.add(emfModels.get(em));
					try {
						eol.execute();
					} catch (EpsilonParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (EpsilonSourceLoadException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (EpsilonExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						eol.models.remove(em);
						eol.models.remove(emfModels.get(em));
					}
				}
			}
		}
	}

	private List<String> getCandidateMetamodels() {
		// 2. Run the EOL operations to get the candidate models and generate the Containment Tree
		List<String> result = new ArrayList<String>();
		EolTask eol = null;
		try {
			eol = new EolTask(java.net.URI.create(getResourceURI(CONFIG_QUERIES_EOL)));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (eol != null) {
				eol.addModel(configModel);
				try {
					eol.executeOperation("getAllMetamodelFiles");
				} catch (EpsilonExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EpsilonSourceLoadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EpsilonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Object mmList = eol.getResult();
				for (String mm : (Set<String>)mmList) {
					result.add(mm);
				}
				
			}
		}
		return result;
	}
	
	private void loadConfigurationModel() {
		
		try {
			configModel = createEmfModel(configUri, CONFIG_MODEL_NAME, "", CONFIG_URI, true, false, true);
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void loadOclStdLibModel() {
		
		try {
			oclStdLibModel = createEmfModel(getResourceURI(OCL_STD_LIB_MODEL), OCL_STD_LIB_MODEL_NAME, "", PIVOT_URI, true, false, true);
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static EmfModel createEmfModel(String modeUri, String modelName, String modelAliases, String metamodelUri, boolean readOnLoad, boolean storeOnDispoal, boolean cached) 
			throws EolModelLoadingException {
	
		EmfModel emfModel = new EmfModel();
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, modelName);
		properties.put(EmfModel.PROPERTY_ALIASES, modelAliases);
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, metamodelUri);
		properties.put(EmfModel.PROPERTY_MODEL_URI, modeUri);
		properties.put(EmfModel.PROPERTY_READONLOAD, String.valueOf(readOnLoad));
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, String.valueOf(storeOnDispoal));
		properties.put(EmfModel.PROPERTY_CACHED, String.valueOf(cached));
		emfModel.load(properties, null);
		return emfModel;
	}
	
	private void registerMetamodels() {
		// register globally the Ecore Resource Factory to the ".ecore" extension
		// weird that we need to do this, but well...
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
		    "ecore", new EcoreResourceFactoryImpl());
		
		ResourceSet rs = new ResourceSetImpl();
		// Enable extended metadata
		final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(rs.getPackageRegistry());
		rs.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA,
		    extendedMetaData);
		String path = null;
		Resource r;
		EObject eObject;
		try {
			path = getResourceURI(CONFIG_MM);
		} catch (URISyntaxException e) {
			// TODO Re-throw so test fails!
			e.printStackTrace();
		} finally {
			if (path != null) {
				r = rs.getResource(URI.createURI(path, false), true);
				eObject = r.getContents().get(0);
				if (eObject instanceof EPackage) {
				    EPackage p = (EPackage)eObject;
				    EPackage.Registry.INSTANCE.put(p.getNsURI(), p);
				}
			}
		}
		try {
			path = getResourceURI(ECORE_CONTAINMENT_MM);
		} catch (URISyntaxException e) {
			// TODO Re-throw so test fails!
			e.printStackTrace();
		} finally {
			if (path != null) {
				r = rs.getResource(URI.createURI(path, false), true);
				eObject = r.getContents().get(0);
				if (eObject instanceof EPackage) {
				    EPackage p = (EPackage)eObject;
				    EPackage.Registry.INSTANCE.put(p.getNsURI(), p);
				}
			}
			
		}
	}
	
	public static String changeResourceToSource(String resourcePath) {
		
		String result;
		if (resourcePath.indexOf("/bin/") > -1) {
	      result = resourcePath.replaceAll("/bin/", "/src/");
	    }
	    else {
	      result= resourcePath;
	    }
		return result;
	}
	
	/**
	 * Return a java.net.URI for an specified filename  
	 * 
	 * @param fileName filename to obtain the URI
	 * @return URI for the provided filename
	 */
	private java.net.URI getURI(String fileName)  {
	    return java.net.URI.create(URI.createPlatformResourceURI(fileName, false).toString());
	}
	
	/**
	 * Return a string representing the URI for a resource
	 * 
	 * @param resource resource to obtain an URI
	 * @return the URI for the provided resource
	 * @throws URISyntaxException
	 */
	private String getResourceURI(String resource) throws URISyntaxException {
		URL r = this.getClass().getResource(resource);
		String uri = r.toURI().toString();
	    return uri;
	}
	
	private String getResourceUriFromClass(Class c, String resource) throws URISyntaxException {
		URL r = c.getResource(resource);
		String uri = r.toURI().toString();
	    return uri;
	}
	

}
