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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.ocl.pivot.internal.manager.MetamodelManager;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.qvtd.build.qvtschedule.qvtscheduleFactory;
import org.eclipse.qvtd.build.qvtschedule.impl.qvtscheduleFactoryImpl;

/**
 * The Class MtcBroker.
 */
public class MtcBroker {
	
	/** The Constant ECORE_URI. */
	private static final String ECORE_URI = "http://www.eclipse.org/emf/2002/Ecore";
	
	/** The Constant CONFIG_MODEL_NAME. */
	private static final String CONFIG_MODEL_NAME = "config";
	
	/** The Constant CONFIG_MM. */
	private static final String CONFIG_MM = "/QVTcConfig.ecore";
	
	/** The Constant CONFIG_URI. */
	private static final String CONFIG_URI = "http://www.eclipse.org/qvt/examples/0.1/QVTcConfig";
	
	/** The Constant CONFIG_QUERIES_EOL. */
	private static final String CONFIG_QUERIES_EOL = "helpers/ConfigQueries.eol";
	
	/** The Constant ECORE_CONTAINMENT_MM. */
	private static final String ECORE_CONTAINMENT_MM = "/ECoreContainmentTree.ecore";
	
	/** The Constant ECORE_CONTAINMENT_URI. */
	private static final String ECORE_CONTAINMENT_URI = "http://www.eclipse.org/qvt/examples/0.1/ECoreContainemntTree";
	
	/** The Constant ECORE_TO_TREE_EOL. */
	private static final String ECORE_TO_TREE_EOL = "utils/EcoreToContainmentTree.eol";
	
	/** The Constant QVTS_MM. */
	private static final String QVTS_MM = "/QVTSchedule.ecore";
	
	/** The Constant QVTS_URI. */
	private static final String QVTS_URI = "http://www.eclipse.org/qvt/0.1/QVTschedule/";
	
	/** The Constant OCL_STD_LIB_MODEL_NAME. */
	private static final String OCL_STD_LIB_MODEL_NAME = "oclStdLib";
	
	/** The Constant OCL_STD_LIB_URI. */
	private static final String OCL_STD_LIB_URI = "http://www.eclipse.org/ocl/3.1.0/OCL.oclstdlib.oclas";
	
	/** The Constant PIVOT_URI. */
	private static final String PIVOT_URI = "http://www.eclipse.org/ocl/3.1.0/Pivot";
	
	/** The Constant QVTB_URI. */
	private static final String QVTB_URI ="http://www.eclipse.org/qvt/0.9/QVTbase";
	
	/** The Constant QVTCB_URI. */
	private static final String QVTCB_URI = "http://www.eclipse.org/qvt/0.9/QVTcoreBase";
	
	/** The Constant QVTC_URI. */
	private static final String QVTC_URI = "http://www.eclipse.org/qvt/0.9/QVTcore";
	
	/** The Constant QVTI_URI. */
	private static final String QVTI_URI = "http://www.eclipse.org/qvt/0.9/QVTimperative";
	
	/** The Constant QVTC_FULL_NS. */
	private static final String QVTC_FULL_NS = QVTC_URI + "," + QVTCB_URI + "," + QVTB_URI + "," + PIVOT_URI;
	
	/** The Constant QVTI_FULL_NS. */
	protected static final String QVTI_FULL_NS = QVTI_URI + "," + QVTCB_URI + "," +  QVTB_URI + "," +  PIVOT_URI;
	
	/** The Constant QVTS_FULL_NS. */
	private static final String QVTS_FULL_NS = QVTS_URI + "," + QVTI_FULL_NS;
	
	/** The Constant QVTC_TO_QVTU_FLOCK. */
	private static final String QVTC_TO_QVTU_FLOCK = "mtc/QVTcToQVTu.mig";
	
	/** The Constant QVTU_TO_QVTM_FLOCK. */
	private static final String QVTU_TO_QVTM_FLOCK = "mtc/QVTuToQVTm.mig";
	
	/** The Constant QVTM_TO_QVTP_ETL. */
	private static final String QVTM_TO_QVTP_ETL = "mtc/QVTmToQVTiPartition.etl";
	
	/** The Constant QVTP_TO_QVTS_ETL. */
	private static final String QVTP_TO_QVTS_ETL = "scheduling/QVTpToSchedule.etl";
	
	/** The Constant QVTP_SCHEDULE_EOL. */
	private static final String QVTP_SCHEDULE_EOL = "scheduling/Scheduler.eol";
	
	/** The Constant QVTPS_TO_QVTI_ETL. */
	private static final String QVTPS_TO_QVTI_ETL = "scheduling/QVTs-pToQVTi.etl";
	
	/** The Constant LEFT_DIR_NAME. */
	@SuppressWarnings("unused")
	private static final String LEFT_DIR_NAME = "L";
	
	/** The Constant RIGHT_DIR_NAME. */
	private static final String RIGHT_DIR_NAME = "R";
	
	/** The Constant MIDDLE_DIR_NAME. */
	@SuppressWarnings("unused")
	private static final String MIDDLE_DIR_NAME = "M";
	
	/** The qvtcas uri. */
	private String qvtcasUri;
	
	/** The qvtu uri. */
	private String qvtuUri;
	
	/** The qvtm uri. */
	private String qvtmUri;
	
	/** The partition uri. */
	protected String partitionUri;
	
	/** The qvti uri. */
	protected String qvtiUri;
	
	/** The config uri. */
	private String configUri;
	
	/** The schedule uri. */
	protected String scheduleUri;
	
	/** The owner clas of the MTC (used to find resources). */
	private Class<?> owner;
	
	/** The config model. */
	private PivotModel configModel;
	
	/** The ocl std lib model. */
	protected PivotModel oclStdLibModel;

	/** The r metamodel. */
	@SuppressWarnings("unused")
	private String rMetamodel;

	/** The r metamodel model. */
	@SuppressWarnings("unused")
	private PivotModel rMetamodelModel;
	
	/** The candidate metamodel containment trees. */
	private Map<String, List<PivotModel>> candidateMetamodelContainmentTrees; 
	
	/** The meta model manager. */
	private MetamodelManager metamodelManager;
	
	private PivotModel cModel;
	private PivotModel uModel;
	private PivotModel mModel;
	protected PivotModel pModel;
	protected PivotModel sModel;
	protected PivotModel iModel;

	
	/**
	 * Instantiates a new MTC broker.
	 *
	 * @param qvtcasUri the qvtcas uri
	 * @param owner the owner
	 * @param metamodelManager the meta model manager
	 * @throws QvtMtcExecutionException If there is a problem registering the required metamodels.
	 */
	public MtcBroker(String qvtcasUri, Class<?> owner, MetamodelManager metamodelManager) throws QvtMtcExecutionException {
		
		this.metamodelManager = metamodelManager;
		// Derive all the required paths		
		this.qvtcasUri = qvtcasUri;
		this.owner = owner;
		System.out.println(URI.createURI(qvtcasUri).lastSegment());
		
		URI baseUri = URI.createURI(qvtcasUri).trimFileExtension();
		this.qvtuUri = baseUri.appendFileExtension("qvtu.qvtcas").toString();
		this.qvtmUri = baseUri.appendFileExtension("qvtm.qvtcas").toString();
		this.partitionUri = baseUri.appendFileExtension("qvtp.qvtias").toString();
		this.qvtiUri = baseUri.appendFileExtension("qvtias").toString();
		
		this.configUri = URI.createURI(baseUri.toString() + "Config").appendFileExtension("xmi").toString();
		this.scheduleUri = URI.createURI(baseUri.toString() + "Schedule").appendFileExtension("xmi").toString();
		candidateMetamodelContainmentTrees = new HashMap<String, List<PivotModel>>();
		registerMetamodels(metamodelManager);
	}
	
	/**
	 * @return the cModel
	 */
	public PivotModel getcModel() {
		return cModel;
	}

	/**
	 * @return the uModel
	 */
	public PivotModel getuModel() {
		return uModel;
	}


	/**
	 * @return the mModel
	 */
	public PivotModel getmModel() {
		return mModel;
	}

	/**
	 * @return the pModel
	 */
	public PivotModel getpModel() {
		return pModel;
	}

	/**
	 * @return the sModel
	 */
	public PivotModel getsModel() {
		return sModel;
	}


	/**
	 * @return the iModel
	 */
	public PivotModel getiModel() {
		return iModel;
	}

	/**
	 * Execute.
	 *
	 * @throws QvtMtcExecutionException If there is an exception at any point in
	 * 	the MTC execution.
	 */
	public void execute() throws QvtMtcExecutionException {
		
		loadConfigurationModel();
		loadOclStdLibModel();
		// This could be run on editor saves by reading the imports!
		createContainmentTrees();
		cModel = createModel(qvtcasUri, "QVTc", "QVT", QVTC_FULL_NS, true, false, true);
		uModel = qvtcToQvtu(cModel);
		uModel.setCachingEnabled(true);
		uModel.clearCache();
		mModel = qvtuToQvtm(uModel);
		mModel.setCachingEnabled(true);
		mModel.clearCache();
		pModel = qvtmToQvtp(mModel);
		pModel.setCachingEnabled(true);
		pModel.clearCache();
		sModel = qvtpToQvts(pModel);
		sModel.setCachingEnabled(true);
		sModel.clearCache();
		pModel.setStoredOnDisposal(true);
		sModel.setStoredOnDisposal(true);
		qvtpScheduling(pModel, sModel);
		iModel = qvtpQvtsToQvti(pModel, sModel);
	}
	
	public void disposeModels() {
		cModel.dispose();
		uModel.dispose();
		mModel.dispose();
		pModel.dispose();
		sModel.dispose();
		iModel.dispose();
	}

	/**
	 * QVTc to QVTu.
	 *
	 * @param cModel the QVTc model
	 * @return the QVTu model
	 * @throws QvtMtcExecutionException If there is a problem loading the models or
	 * 	executing the Flock script.
	 */
	private PivotModel qvtcToQvtu(EmfModel cModel) throws QvtMtcExecutionException {

		PivotModel uModel = null;
		uModel = createASModel(qvtuUri, "QVTu", "QVT", QVTC_FULL_NS, false, true, false);
		if (cModel != null && uModel != null  ) {
			FlockTask flock = null;
			try {
				flock = new FlockTask(java.net.URI.create(getResourceURI(QVTC_TO_QVTU_FLOCK)));
			} catch (URISyntaxException e) {
				throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
			} finally {
				if (flock != null) {
					flock.setOriginalModel(cModel);
					flock.setMigratedModel(uModel);
					flock.models.add(configModel);
					flock.models.add(oclStdLibModel);
					flock.execute();
				}
			}
		}
		return uModel;
	}
	
	/**
	 * QVTu to QVTm.
	 *
	 * @param uModel the QVTu model
	 * @return the QVTm model
	 * @throws QvtMtcExecutionException If there is a problem loading the models or
	 * 	executing the Flock script.
	 */
	private PivotModel qvtuToQvtm(PivotModel uModel) throws QvtMtcExecutionException {

		PivotModel mModel = null;
		mModel = createASModel(qvtmUri, "QVTm", "QVT", QVTC_FULL_NS, false, true, false);
		if (uModel != null && mModel != null  ) {
			FlockTask flock = null;
			try {
				flock = new FlockTask(java.net.URI.create(getResourceURI(QVTU_TO_QVTM_FLOCK)));
			} catch (URISyntaxException e) {
				throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
			} finally {
				if (flock != null) {
					flock.setOriginalModel(uModel);
					flock.setMigratedModel(mModel);
					flock.models.add(configModel);
					flock.models.add(oclStdLibModel);
					flock.execute();
				}
			}
		}
		return mModel;
	}

	/**
	 * QVTm to QVTp.
	 *
	 * @param mModel the QVTm model
	 * @return the QVTp model
	 * @throws QvtMtcExecutionException If there is a problem loading the models or
	 * 	executing the ETL script.
	 */
	private PivotModel qvtmToQvtp(PivotModel mModel) throws QvtMtcExecutionException {
		
		PivotModel pModel = null;
		pModel = createASModel(partitionUri, "QVTp", "QVT", QVTI_FULL_NS, false, true, false);
		if (mModel != null && pModel != null  ) {
			EtlTask etl = null;
			try {
				etl = new EtlTask(java.net.URI.create(getResourceURI(QVTM_TO_QVTP_ETL)));
			} catch (URISyntaxException e) {
				throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
			} finally {
				if (etl != null) {
					etl.models.add(mModel);
					etl.models.add(pModel);
					etl.models.add(configModel);
					etl.models.add(oclStdLibModel);
					etl.execute();
				}
			}
		}
		return pModel;
	}
	
	/**
	 * QVTp to QVTs.
	 *
	 * @param pModel the QVTp model
	 * @return the QVTs model
	 * @throws QvtMtcExecutionException If there is a problem loading the models or
	 * 	executing the ETL script.
	 */
	protected PivotModel qvtpToQvts(PivotModel pModel) throws QvtMtcExecutionException {
		PivotModel sModel = null;
		sModel = createModel(scheduleUri, "QVTs", "", QVTS_FULL_NS, false, true, false);
		if (pModel != null && sModel != null  ) {
			EtlTask etl = null;
			try {
				etl = new EtlTask(java.net.URI.create(getResourceURI(QVTP_TO_QVTS_ETL)));
			} catch (URISyntaxException e) {
				throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
			} finally {
				if (etl != null) {
					etl.models.add(pModel);
					etl.models.add(sModel);
					etl.models.add(configModel);
					etl.models.add(oclStdLibModel);
					etl.execute();
				}
			}
		}
		return sModel;
	}
	
	/**
	 * QVTp scheduling.
	 *
	 * @param pModel the QVTp model
	 * @param sModel the QVTs s model
	 * @throws QvtMtcExecutionException If there is a problem loading the models or
	 * 	executing the EOL script.
	 */
	protected void qvtpScheduling(PivotModel pModel, PivotModel sModel) throws QvtMtcExecutionException {
		
		if (pModel != null && sModel != null  ) {
			EolTask eol = null;
			try {
				eol = new EolTask(java.net.URI.create(getResourceURI(QVTP_SCHEDULE_EOL)));
			} catch (URISyntaxException e) {
				throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
			}
			if (eol != null) {
				eol.models.add(pModel);
				eol.models.add(sModel);
				eol.models.add(oclStdLibModel);
				eol.models.add(configModel);
				// TODO HOw to deal with multiple candidate metamodels?
				eol.models.add(candidateMetamodelContainmentTrees.get(RIGHT_DIR_NAME).get(0));
				eol.execute();
			}
		}
	}
	
	/**
	 * QVTp and QVTs to QVTi.
	 *
	 * @param pModel the QVTp model
	 * @param sModel the QVTs model
	 * @return the QVTi model
	 * @throws QvtMtcExecutionException If there is a problem loading the models or
	 * 	executing the ETL script.
	 */
	protected PivotModel qvtpQvtsToQvti(PivotModel pModel, PivotModel sModel) throws QvtMtcExecutionException {
		
		PivotModel iModel = null;
		iModel = createASModel(qvtiUri, "QVTi", "QVT", QVTI_FULL_NS, false, true, false);
		if (pModel != null && sModel != null && iModel != null  ) {
			EtlTask etl = null;
			try {
				etl = new EtlTask(java.net.URI.create(getResourceURI(QVTPS_TO_QVTI_ETL)));
			} catch (URISyntaxException e) {
				throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
			} finally {
				if (etl != null) {
					etl.models.add(pModel);
					etl.models.add(sModel);
					etl.models.add(iModel);
					etl.models.add(configModel);
					etl.models.add(oclStdLibModel);
					etl.execute();
				}
			}
		}
		return iModel;
	}
	
	/**
	 * Creates the containment trees.
	 *
	 * @throws QvtMtcExecutionException If there is a problem loading the models or
	 * 	executing the EOL script.
	 */
	protected void createContainmentTrees() throws QvtMtcExecutionException  {
		
		EolTask eol = null;
		List<String> loadedUris = new ArrayList<String>();
		try {
			eol = new EolTask(java.net.URI.create(getResourceURI(ECORE_TO_TREE_EOL)));
		} catch (URISyntaxException e) {
			throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
		}
		if (eol != null) {
			Map<String, List<String>> mms = getCandidateMetamodels();
			//Map<PivotModel, PivotModel> emfModels = new HashMap<PivotModel, PivotModel>();
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
						if (modelUri != null && !loadedUris.contains(modelUri)) {
							loadedUris.add(modelUri);
							PivotModel mmModel = null;
							PivotModel treeModel = null;
							mmModel = createModel(changeResourceToSource(modelUri), "mm", "", ECORE_URI, true, false, true);
							String cgUri = mmModel.getModelFileUri().trimFileExtension().toString() + "ContainmentTree.xmi";
							treeModel = createModel(cgUri, "tree", pairs.getKey().toLowerCase()+"Tree", ECORE_CONTAINMENT_URI, false, true, true);
							if (mmModel != null && treeModel != null  ) {
								eol.models.add(mmModel);
								eol.models.add(treeModel);
								eol.execute();
								eol.models.clear();
								trees.add(treeModel);
							}
						}
		        	}
		        }
		        candidateMetamodelContainmentTrees.put(pairs.getKey(), trees);
		    }
		}
	}

	/**
	 * Gets the candidate metamodels.
	 *
	 * @return the candidate metamodels
	 * @throws QvtMtcExecutionException If there is a problem loading the models or
	 * 	executing the EOL script.
	 */
	private Map<String, List<String>> getCandidateMetamodels() throws QvtMtcExecutionException {
		// 2. Run the EOL operations to get the candidate models and generate the Containment Tree
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		EolTask eol = null;
		try {
			eol = new EolTask(java.net.URI.create(getResourceURI(CONFIG_QUERIES_EOL)));
		} catch (URISyntaxException e) {
			throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
		}
		if (eol != null) {
			eol.addModel(configModel);
			eol.executeOperation("getAllMetamodelFiles");
			Object mmList = eol.getResult();
			@SuppressWarnings("unchecked")
			Iterator<Map.Entry<String,List<String>>> it = ((Map<String,List<String>>)mmList).entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry<String,List<String>> pairs = it.next();
		        System.out.println(pairs.getKey() + " = " + pairs.getValue());
		        result.put(pairs.getKey(), pairs.getValue());
		    }
		}
		return result;
	}
	
	/**
	 * Load configuration model.
	 *
	 * @throws QvtMtcExecutionException If there is a problem loading the model.
	 */
	protected void loadConfigurationModel() throws QvtMtcExecutionException {
		
		configModel = createModel(configUri, CONFIG_MODEL_NAME, "", CONFIG_URI, true, false, true);
	}
	
	/**
	 * Load OCLStdLib model.
	 *
	 * @throws QvtMtcExecutionException If there is a problem loading the model.
	 */
	protected void loadOclStdLibModel() throws QvtMtcExecutionException {
		
		OCLASResourceFactory.getInstance();
//        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap( ).put("oclas", OCLASResourceFactory.getInstance());
	    oclStdLibModel = createModel(OCL_STD_LIB_URI, OCL_STD_LIB_MODEL_NAME, "", PIVOT_URI, true, false, true);
	}
	
	/**
	 * Register metamodels.
	 *
	 * @param metamodelManager the meta model manager
	 * @throws QvtMtcExecutionException If there is a problem finding the metamodels
	 */
	private void registerMetamodels(MetamodelManager metamodelManager) throws QvtMtcExecutionException {
		
		String path = null;
		Resource r;
		EObject eObject;
		// Configuration Metamodel
		try {
			path = getResourceURI(CONFIG_MM);
		} catch (URISyntaxException e) {
			throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
		} finally {
			if (path != null) {
				r = metamodelManager.getExternalResourceSet().getResource(URI.createURI(path, false), true);
				eObject = r.getContents().get(0);
				if (eObject instanceof EPackage) {
				    EPackage p = (EPackage)eObject;
				    metamodelManager.getExternalResourceSet().getPackageRegistry().put(p.getNsURI(), p);
				}
			}
		}
		// Containment tree metamodel
		try {
			path = getResourceURI(ECORE_CONTAINMENT_MM);
		} catch (URISyntaxException e) {
			throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
		} finally {
			if (path != null) {
				r = metamodelManager.getExternalResourceSet().getResource(URI.createURI(path, false), true);
				eObject = r.getContents().get(0);
				if (eObject instanceof EPackage) {
				    EPackage p = (EPackage)eObject;
				    metamodelManager.getExternalResourceSet().getPackageRegistry().put(p.getNsURI(), p);
				}
			}
			
		}
		// Schedule metamodel
		try {
			qvtscheduleFactory sf = new qvtscheduleFactoryImpl();
			path = getResourceUriFromClass(sf.getClass(), QVTS_MM);
		} catch (URISyntaxException e) {
			throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
		} finally {
			if (path != null) {
				r = metamodelManager.getExternalResourceSet().getResource(URI.createURI(path, false), true);
				eObject = r.getContents().get(0);
				if (eObject instanceof EPackage) {
				    EPackage p = (EPackage)eObject;
				    metamodelManager.getExternalResourceSet().getPackageRegistry().put(p.getNsURI(), p);
				}
			}
		}
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
	 * @return the pivot model
	 * @throws QvtMtcExecutionException There was an error loading the model
	 */
	protected PivotModel createModel(String modeUri, String modelName, String modelAliases, String metamodelUris,
				boolean readOnLoad, boolean storeOnDispoal, boolean cached) throws QvtMtcExecutionException {
	
		PivotModel model = new PivotModel(metamodelManager, false);
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, modelName);
		properties.put(EmfModel.PROPERTY_ALIASES, modelAliases);
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, metamodelUris);
		properties.put(EmfModel.PROPERTY_MODEL_URI, modeUri);
		properties.put(EmfModel.PROPERTY_READONLOAD, String.valueOf(readOnLoad));
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, String.valueOf(storeOnDispoal));
		properties.put(EmfModel.PROPERTY_CACHED, String.valueOf(cached));
		properties.put(EmfModel.PROPERTY_EXPAND, String.valueOf(false));
		try {
			model.load(properties, "");
		} catch (EolModelLoadingException e) {
			throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
		}
		return model;
	}
	
	
	private PivotModel createASModel(String modeUri, String modelName, String modelAliases, String metamodelUris,
			boolean readOnLoad, boolean storeOnDispoal, boolean cached) throws QvtMtcExecutionException {

	PivotModel model = new PivotModel(metamodelManager, true);
	StringProperties properties = new StringProperties();
	properties.put(EmfModel.PROPERTY_NAME, modelName);
	properties.put(EmfModel.PROPERTY_ALIASES, modelAliases);
	properties.put(EmfModel.PROPERTY_METAMODEL_URI, metamodelUris);
	properties.put(EmfModel.PROPERTY_MODEL_URI, modeUri);
	properties.put(EmfModel.PROPERTY_READONLOAD, String.valueOf(readOnLoad));
	properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, String.valueOf(storeOnDispoal));
	properties.put(EmfModel.PROPERTY_CACHED, String.valueOf(cached));
	properties.put(EmfModel.PROPERTY_EXPAND, String.valueOf(false));
	try {
		model.load(properties, "");
	} catch (EolModelLoadingException e) {
		throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
	}
	return model;
}
	
	/**
	 * Change resource to source. 
	 *
	 * @param resourcePath the resource path
	 * @return the string
	 */
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
	 * Change model resource to source.
	 *
	 * @param resourcePath the resource path
	 * @return the string
	 */
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
	 *
	private java.net.URI getURI(String fileName)  {
	    return java.net.URI.create(URI.createPlatformResourceURI(fileName, false).toString());
	} */
	
	/**
	 * Return a string representing the URI for a resource.
	 *
	 * @param resource resource to obtain an URI
	 * @return the URI for the provided resource
	 * @throws URISyntaxException the URI syntax exception
	 */
	private String getResourceURI(String resource) throws URISyntaxException {
		URL r = MtcBroker.class.getResource(resource);
		String uri = r.toURI().toString();
	    return uri;
	}
	
	/**
	 * Gets the resource uri from class.
	 *
	 * @param c the c
	 * @param resource the resource
	 * @return the resource uri from class
	 * @throws URISyntaxException the URI syntax exception
	 */
	private String getResourceUriFromClass(Class<?> c, String resource) throws URISyntaxException {
		URL r = c.getResource(resource);
		String uri = r.toURI().toString();
	    return uri;
	}	

}
