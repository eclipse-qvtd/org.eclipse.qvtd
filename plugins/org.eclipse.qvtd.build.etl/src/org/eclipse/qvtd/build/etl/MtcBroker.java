/*******************************************************************************
 * Copyright (c) 2013 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.build.etl;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.qvtd.build.qvtschedule.Schedule;
import org.eclipse.qvtd.build.qvtschedule.qvtscheduleFactory;
import org.eclipse.qvtd.build.qvtschedule.impl.ScheduleImpl;
import org.eclipse.qvtd.build.qvtschedule.impl.qvtscheduleFactoryImpl;
import org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl;
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
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManagerResourceSetAdapter;
import org.eclipse.ocl.examples.pivot.resource.OCLASResourceFactory;

public class MtcBroker {
	
	private static final String ECORE_URI = "http://www.eclipse.org/emf/2002/Ecore";
	
	private static final String CONFIG_MODEL_NAME = "config";
	private static final String CONFIG_MM = "/QVTcConfig.ecore";
	private static final String CONFIG_URI = "http://www.eclipse.org/qvt/examples/0.1/QVTcConfig";
	private static final String CONFIG_QUERIES_EOL = "helpers/ConfigQueries.eol";
	
	private static final String ECORE_CONTAINMENT_MM = "/ECoreContainmentTree.ecore";
	private static final String ECORE_CONTAINMENT_URI = "http://www.eclipse.org/qvt/examples/0.1/ECoreContainemntTree";
	private static final String ECORE_TO_TREE_EOL = "utils/EcoreToContainmentTree.eol";
	
	private static final String QVTS_MM = "/QVTSchedule.ecore";
	private static final String QVTS_URI = "http://www.eclipse.org/qvt/0.1/QVTschedule/";
	
	private static final String OCL_STD_LIB_MODEL_NAME = "oclStdLib";
	private static final String OCL_STD_LIB_URI = "http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib.oclas";
	
	private static final String PIVOT_URI = "http://www.eclipse.org/ocl/3.1.0/Pivot";
	
	private static final String QVTC_URI = "http://www.eclipse.org/qvt/0.9/QVTcore";
	private static final String QVTI_URI = "http://www.eclipse.org/qvt/0.9/QVTimperative";
	
	private static final String QVTC_TO_QVTU_FLOCK = "mtc/QVTcToQVTu.mig";
	private static final String QVTU_TO_QVTM_FLOCK = "mtc/QVTuToQVTm.mig";
	private static final String QVTM_TO_QVTP_ETL = "mtc/QVTmToQVTiPartition.etl";
	private static final String QVTP_TO_QVTS_ETL = "scheduling/QVTpToSchedule.etl";
	private static final String QVTP_SCHEDULE_EOL = "scheduling/Scheduler.eol";
	private static final String QVTPS_TO_QVTI_ETL = "scheduling/QVTs-pToQVTi.etl";
	
	private static final String LEFT_DIR_NAME = "L";
	private static final String RIGHT_DIR_NAME = "R";
	private static final String MIDDLE_DIR_NAME = "M";
	
	
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

	private String rMetamodel;

	private PivotModel rMetamodelModel;
	
	private Map<String, List<PivotModel>> candidateMetamodelContainmentTrees; 
	
	private MetaModelManager metaModelManager;

	
	public MtcBroker(String qvtcasUri, Class owner, MetaModelManager metaModelManager) throws URISyntaxException {
		
		this.metaModelManager = metaModelManager;
		// Derive all the required paths		
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
		candidateMetamodelContainmentTrees = new HashMap<String, List<PivotModel>>();
		registerMetamodels(metaModelManager);
	}
	
	public void execute() throws EolModelLoadingException, EpsilonExecutionException, URISyntaxException, EpsilonSourceLoadException, EpsilonParseException {
		
		loadConfigurationModel();
		loadOclStdLibModel();
		createContainmentTrees();
		//EmfModel cModel = createEmfModel(qvtcasUri, "QVTc", "QVT", QVTC_URI, true, false, true);
		
		//EmfModel uModel = qvtcToQvtu(cModel);
		//uModel.setCachingEnabled(true);
		//uModel.clearCache();
		//uModel.dispose();
		
		PivotModel uModel = createModel(qvtuUri, "QVTu", "QVT", QVTC_URI, true, false, true);
		PivotModel mModel = qvtuToQvtm(uModel);
		mModel.setCachingEnabled(true);
		mModel.clearCache();
		/*
		EmfModel pModel = qvtmToQvtp(mModel);
		pModel.setCachingEnabled(true);
		pModel.clearCache();
		
		EmfModel sModel = qvtpToQvts(pModel);
		sModel.setCachingEnabled(true);
		sModel.clearCache();
		
		pModel.setStoredOnDisposal(true);
		sModel.setStoredOnDisposal(true);
		qvtpScheduling(pModel, sModel);
		
		EmfModel iModel = qvtpQvtsToQvti(pModel, sModel);
		*/
	}

	private EmfModel qvtcToQvtu(EmfModel cModel) {

		EmfModel uModel = null;
		try {
			uModel = createModel(qvtuUri, "QVTu", "QVT", QVTC_URI, false, true, false);
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
					flock.setOriginalModel(cModel);
					flock.setMigratedModel(uModel);
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
	
	private PivotModel qvtuToQvtm(EmfModel uModel) {

		PivotModel mModel = null;
		try {
			mModel = createModel(qvtmUri, "QVTm", "QVT", QVTC_URI, false, true, false);
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} if (uModel != null && mModel != null  ) {
			FlockTask flock = null;
			try {
				flock = new FlockTask(java.net.URI.create(getResourceURI(QVTU_TO_QVTM_FLOCK)));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (flock != null) {
					flock.setOriginalModel(uModel);
					flock.setMigratedModel(mModel);
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
		return mModel;
	}

	private PivotModel qvtmToQvtp(EmfModel mModel) {
		
		PivotModel pModel = null;
		try {
			pModel = createModel(partitionUri, "QVTp", "QVT", QVTI_URI, false, true, false);
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} if (mModel != null && pModel != null  ) {
			EtlTask etl = null;
			try {
				etl = new EtlTask(java.net.URI.create(getResourceURI(QVTM_TO_QVTP_ETL)));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (etl != null) {
					etl.models.add(mModel);
					etl.models.add(pModel);
					etl.models.add(configModel);
					etl.models.add(oclStdLibModel);
					try {
						etl.execute();
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
		return pModel;
	}
	
	private PivotModel qvtpToQvts(EmfModel pModel) {
		PivotModel sModel = null;
		try {
			sModel = createModel(scheduleUri, "QVTs", "QVT", QVTS_URI, false, true, false);
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pModel != null && sModel != null  ) {
				EtlTask etl = null;
				try {
					etl = new EtlTask(java.net.URI.create(getResourceURI(QVTP_TO_QVTS_ETL)));
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (etl != null) {
						etl.models.add(pModel);
						etl.models.add(sModel);
						etl.models.add(configModel);
						etl.models.add(oclStdLibModel);
						try {
							etl.execute();
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
		}
		return sModel;
	}
	
	private void qvtpScheduling(PivotModel pModel, PivotModel sModel) {
		
		if (pModel != null && sModel != null  ) {
			EolTask eol = null;
			try {
				 eol = new EolTask(java.net.URI.create(getResourceURI(QVTP_SCHEDULE_EOL)));
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally  {
				if (eol != null) {
					eol.models.add(pModel);
					eol.models.add(sModel);
					eol.models.add(oclStdLibModel);
					eol.models.add(configModel);
					// TODO HOw to deal with multiple candidate metamodels?
					eol.models.add(candidateMetamodelContainmentTrees.get(RIGHT_DIR_NAME).get(0));
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
					}
				}
			}
		}
	}
	
	private PivotModel qvtpQvtsToQvti(PivotModel pModel, PivotModel sModel) {
		
		PivotModel iModel = null;
		try {
			iModel = createModel(qvtiUri, "QVTi", "QVT", QVTI_URI, false, true, false);
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pModel != null && sModel != null && iModel != null  ) {
				EtlTask etl = null;
				try {
					etl = new EtlTask(java.net.URI.create(getResourceURI(QVTPS_TO_QVTI_ETL)));
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					if (etl != null) {
						etl.models.add(pModel);
						etl.models.add(sModel);
						etl.models.add(iModel);
						etl.models.add(configModel);
						etl.models.add(oclStdLibModel);
						try {
							etl.execute();
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
		}
		return iModel;
	}
	
	
	private void createContainmentTrees() {
		
		EolTask eol = null;
		try {
			eol = new EolTask(java.net.URI.create(getResourceURI(ECORE_TO_TREE_EOL)));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally  {
			if (eol != null) {
				Map<String, List<String>> mms = getCandidateMetamodels();
				Map<PivotModel, PivotModel> emfModels = new HashMap<PivotModel, PivotModel>();
				Iterator<Map.Entry<String, List<String>>> it = mms.entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry<String, List<String>> pairs = it.next();
			        List<PivotModel> trees = new ArrayList<PivotModel>();
			        for (String mm : pairs.getValue()) {
			        	//TODO Check if the containment Tree exist (file)?
			        	//TODO Check if the tree has been already generated
		        		String modelUri = null;
						try {
							modelUri = getResourceUriFromClass(this.owner, mm);
						} catch (URISyntaxException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} finally {
							if (modelUri != null) {
								PivotModel mmModel = null;
								PivotModel treeModel = null;
								try {
									mmModel = createModel(changeResourceToSource(modelUri), "mm", "", ECORE_URI, true, false, true);
									String cgUri = mmModel.getModelFileUri().trimFileExtension().toString() + "ContainmentTree.xmi";
									treeModel = createModel(cgUri, "tree", pairs.getKey().toLowerCase()+"Tree", ECORE_CONTAINMENT_URI, false, true, true);
								} catch (EolModelLoadingException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} finally {
									if (mmModel != null && treeModel != null  ) {
										eol.models.add(mmModel);
										eol.models.add(treeModel);
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
											trees.add(treeModel);
										}
									}
								}
							}
			        	}
			        }
			        candidateMetamodelContainmentTrees.put(pairs.getKey(), trees);
			    }
			}
		}
	}

	private Map<String, List<String>> getCandidateMetamodels() {
		// 2. Run the EOL operations to get the candidate models and generate the Containment Tree
		Map<String, List<String>> result = new HashMap<String, List<String>>();
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
				Iterator it = ((Map)mmList).entrySet().iterator();
			    while (it.hasNext()) {
			        Map.Entry pairs = (Map.Entry)it.next();
			        System.out.println(pairs.getKey() + " = " + pairs.getValue());
			        result.put((String)pairs.getKey(), (ArrayList)pairs.getValue());
			    }
			}
		}
		return result;
	}
	
	private void loadConfigurationModel() {
		
		try {
			configModel = createModel(configUri, CONFIG_MODEL_NAME, "", CONFIG_URI, true, false, true);
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void loadOclStdLibModel() {
		
		//EPackage.Registry.INSTANCE.put(OCL_STD_LIB_URI, OCLstdlibPackage.eINSTANCE);
        OCLASResourceFactory.INSTANCE.getClass();
        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap( ).put("oclas", OCLASResourceFactory.INSTANCE);
	    try {
	    	oclStdLibModel = createModel(OCL_STD_LIB_URI, OCL_STD_LIB_MODEL_NAME, "", PIVOT_URI, true, false, true);
		} catch (EolModelLoadingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private PivotModel createModel(String modeUri, String modelName, String modelAliases, String metamodelUri, boolean readOnLoad, boolean storeOnDispoal, boolean cached) 
			throws EolModelLoadingException {
	
		PivotModel model = new PivotModel(metaModelManager);
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, modelName);
		properties.put(EmfModel.PROPERTY_ALIASES, modelAliases);
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, metamodelUri);
		properties.put(EmfModel.PROPERTY_MODEL_URI, modeUri);
		properties.put(EmfModel.PROPERTY_READONLOAD, String.valueOf(readOnLoad));
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, String.valueOf(storeOnDispoal));
		properties.put(EmfModel.PROPERTY_CACHED, String.valueOf(cached));
		properties.put(EmfModel.PROPERTY_EXPAND, String.valueOf(false));
		model.load(properties, null);
		return model;
	}
	
	private void registerMetamodels(MetaModelManager metaModelManager2) {
		// register globally the Ecore Resource Factory to the ".ecore" extension
		// weird that we need to do this, but well...
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
		    "ecore", new EcoreResourceFactoryImpl());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		// Enable extended metadata
		final ExtendedMetaData extendedMetaData = new BasicExtendedMetaData(resourceSet.getPackageRegistry());
		resourceSet.getLoadOptions().put(XMLResource.OPTION_EXTENDED_META_DATA,
		    extendedMetaData);
		String path = null;
		Resource r;
		EObject eObject;
		// Configuration Metamodel
		try {
			path = getResourceURI(CONFIG_MM);
		} catch (URISyntaxException e) {
			// TODO Re-throw so test fails!
			e.printStackTrace();
		} finally {
			if (path != null) {
				r = resourceSet.getResource(URI.createURI(path, false), true);
				eObject = r.getContents().get(0);
				if (eObject instanceof EPackage) {
				    EPackage p = (EPackage)eObject;
				    EPackage.Registry.INSTANCE.put(p.getNsURI(), p);
				}
			}
		}
		// Containment tree metamodel
		try {
			path = getResourceURI(ECORE_CONTAINMENT_MM);
		} catch (URISyntaxException e) {
			// TODO Re-throw so test fails!
			e.printStackTrace();
		} finally {
			if (path != null) {
				r = resourceSet.getResource(URI.createURI(path, false), true);
				eObject = r.getContents().get(0);
				if (eObject instanceof EPackage) {
				    EPackage p = (EPackage)eObject;
				    EPackage.Registry.INSTANCE.put(p.getNsURI(), p);
				}
			}
			
		}
		// Schedule metamodel
		try {
			qvtscheduleFactory sf = new qvtscheduleFactoryImpl();
			path = getResourceUriFromClass(sf.getClass(), QVTS_MM);
		} catch (URISyntaxException e) {
			// TODO Re-throw so test fails!
			e.printStackTrace();
		} finally {
			if (path != null) {
				r = resourceSet.getResource(URI.createURI(path, false), true);
				eObject = r.getContents().get(0);
				if (eObject instanceof EPackage) {
				    EPackage p = (EPackage)eObject;
				    EPackage.Registry.INSTANCE.put(p.getNsURI(), p);
				}
			}
		}
		MetaModelManagerResourceSetAdapter.getAdapter(resourceSet, metaModelManager);
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
	
	public static String changeModelResourceToSource(String resourcePath) {
		
		String result;
		if (resourcePath.indexOf("/bin/") > -1) {
	      result = resourcePath.replaceAll("/bin/", "/model/");
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
