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
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.utilities.OCL;

/**
 * The Class MtcBroker.
 */
public class MtcBroker {
	
	/** The Constant ECORE_URI. */
	private static final String ECORE_URI = "http://www.eclipse.org/emf/2002/Ecore";
	
	/** The Constant CONFIG_MODEL_NAME. */
	private static final String CONFIG_MODEL_NAME = "config";
	
	/** The Constant CONFIG_MM. */
	private static final String CONFIG_MM = "platform:/resource/org.eclipse.qvtd.build.etl/model/QVTcConfig.ecore";
	
	/** The Constant CONFIG_URI. */
	private static final String CONFIG_URI = "http://www.eclipse.org/qvt/examples/0.1/QVTcConfig";
	
	/** The Constant CONFIG_QUERIES_EOL. */
	private static final String CONFIG_QUERIES_EOL = "helpers/ConfigQueries.eol";
	
	/** The Constant ECORE_CONTAINMENT_MM. */
	private static final String ECORE_CONTAINMENT_MM = "platform:/resource/org.eclipse.qvtd.build.etl/model/ECoreContainmentTree.ecore";
	
	/** The Constant ECORE_CONTAINMENT_URI. */
	private static final String ECORE_CONTAINMENT_URI = "http://www.eclipse.org/qvt/examples/0.1/ECoreContainemntTree";
	
	/** The Constant ECORE_TO_TREE_EOL. */
	private static final String ECORE_TO_TREE_EOL = "utils/EcoreToContainmentTree.etl";
	
	/** The Constant QVTS_MM. */
	private static final String QVTS_MM = "platform:/resource/org.eclipse.qvtd.build.schedule/model/QVTSchedule.ecore";
	
	/** The Constant QVTS_URI. */
	private static final String QVTS_URI = "http://www.eclipse.org/qvt/0.1/QVTschedule/";
	
	/** The Constant OCL_STD_LIB_MODEL_NAME. */
	private static final String OCL_STD_LIB_MODEL_NAME = "oclStdLib";
	
	/** The Constant OCL_STD_LIB_URI. */
	private static final String OCL_STD_LIB_URI = "http://www.eclipse.org/ocl/2015/Library.oclas";
	
	/** The Constant PIVOT_URI. */
	private static final String PIVOT_URI = "http://www.eclipse.org/ocl/2015/Pivot";
	
	/** The Constant QVTB_URI. */
	private static final String QVTB_URI ="http://www.eclipse.org/qvt/2015/QVTbase";
	
	/** The Constant QVTCB_URI. */
	private static final String QVTCB_URI = "http://www.eclipse.org/qvt/2015/QVTcoreBase";
	
	/** The Constant QVTC_URI. */
	private static final String QVTC_URI = "http://www.eclipse.org/qvt/2015/QVTcore";
	
	/** The Constant QVTI_URI. */
	private static final String QVTI_URI = "http://www.eclipse.org/qvt/2015/QVTimperative";
	
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
	
	/** The Constant QVTP_FLAT_SCHEDULE_EOL. */
	private static final String QVTP_FLAT_SCHEDULE_EOL = "scheduling/FlatSchedule.eol";
	
	/** The Constant QVTP_SIMPLE_NESTING_SCHEDULE_EOL. */
	private static final String QVTP_SIMPLE_NESTING_SCHEDULE_EOL = "scheduling/SimpleNestedSchedule.eol";
	
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
	//private Class<?> owner;
	
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
	private OCL qvtUtility;
	
	private PivotModel cModel;
	private PivotModel uModel;
	private PivotModel mModel;
	protected PivotModel pModel;
	protected PivotModel sModel;
	protected PivotModel iModel;

	private URI baseUri;

	private ASResource qvtcAS;

	
	public MtcBroker(URI baseURI, String qvtcSource, OCL myQVT) throws Exception {
		
		this.baseUri = baseURI;
		this.qvtUtility = myQVT;
		System.out.println("Executing the QVTc to QVTi MTC for " + qvtcSource);
		URI qvtcURI = baseURI.appendSegment(qvtcSource);
		//CSResource qvtcCS = myQVT.getCSResource(qvtcURI);
    	//this.qvtcAS = myQVT.cs2as(qvtcCS);
		this.qvtcasUri = qvtcURI.toString();
    	URI modelsBaseUri = qvtcURI.trimFileExtension();
    	this.qvtuUri = modelsBaseUri.appendFileExtension("qvtu.qvtcas").toString();
		this.qvtmUri = modelsBaseUri.appendFileExtension("qvtm.qvtcas").toString();
		this.partitionUri = modelsBaseUri.appendFileExtension("qvtp.qvtias").toString();
		this.qvtiUri = modelsBaseUri.appendFileExtension("qvtias").toString();
		
		this.configUri = URI.createURI(modelsBaseUri.toString() + "Config").appendFileExtension("xmi").toString();
		this.scheduleUri = URI.createURI(modelsBaseUri.toString() + "Schedule").appendFileExtension("xmi").toString();
		candidateMetamodelContainmentTrees = new HashMap<String, List<PivotModel>>();
		registerMetamodels(myQVT);
    	
		

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
		cModel = createASModel(qvtcasUri, "QVTc", "QVT", QVTC_FULL_NS, true, false, true, false);
		uModel = qvtcToQvtu(cModel);
		
		mModel = qvtuToQvtm(uModel);
		
		pModel = qvtmToQvtp(mModel);
		
		sModel = qvtpToQvts(pModel);
		
		qvtpFlatScheduling(pModel, sModel);
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
		uModel = createASModel(qvtuUri, "QVTu", "QVT", QVTC_FULL_NS, false, true, false, false);
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
		qvtUtility.getMetamodelManager().getASResourceSet().getResources().remove(cModel.getResource());
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
		mModel = createASModel(qvtmUri, "QVTm", "QVT", QVTC_FULL_NS, false, true, false, false);
		if (uModel != null && mModel != null  ) {
			uModel.setCachingEnabled(true);
			uModel.clearCache();
			uModel.setStoredOnDisposal(false);
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
		qvtUtility.getMetamodelManager().getASResourceSet().getResources().remove(uModel.getResource());
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
		pModel = createASModel(partitionUri, "QVTp", "QVTp,QVT", QVTI_FULL_NS, false, true, false, true);
		if (mModel != null && pModel != null  ) {
			mModel.setCachingEnabled(true);
			mModel.clearCache();
			mModel.setStoredOnDisposal(false);
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
		qvtUtility.getMetamodelManager().getASResourceSet().getResources().remove(mModel.getResource());
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
		sModel = createModel(scheduleUri, "QVTs", "", QVTS_FULL_NS, false, true, false, true);
		pModel.setCachingEnabled(true);
		pModel.clearCache();
		pModel.setStoredOnDisposal(false);
		if (pModel != null && sModel != null) {
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
					// TODO How to deal with multiple candidate metamodels?
					// TODO Include middle and/or inputs
					etl.models.add(candidateMetamodelContainmentTrees.get(RIGHT_DIR_NAME).get(0));
					etl.execute();
				}
			}
		}
		return sModel;
	}
	

	/**
	 * Qvtp flat scheduling.
	 *
	 * @param pModel the model
	 * @param sModel the s model
	 * @throws QvtMtcExecutionException If there was an error loading the script
	 */
	protected void qvtpFlatScheduling(PivotModel pModel, PivotModel sModel) throws QvtMtcExecutionException {
		
		qvtpScheduling(pModel, sModel, QVTP_FLAT_SCHEDULE_EOL);
	}
	
	/**
	 * Qvtp simple nesting scheduling.
	 *
	 * @param pModel the model
	 * @param sModel the s model
	 * @throws QvtMtcExecutionException If there was an error loading the script
	 */
	protected void qvtpSimpleNestingScheduling(PivotModel pModel, PivotModel sModel) throws QvtMtcExecutionException {
		
		qvtpScheduling(pModel, sModel, QVTP_SIMPLE_NESTING_SCHEDULE_EOL);
	}
	
	/**
	 * Qvtp scheduling. By supplying an additional scheduling script URI different scheduling strategies can be
	 * invoked. 
	 *
	 * @param pModel the model
	 * @param sModel the s model
	 * @param schedulingTxURI The URI to the scheduling script to run
	 * @throws QvtMtcExecutionException If there was an error loading the script
	 */
	protected void qvtpScheduling(PivotModel pModel, PivotModel sModel, String schedulingTxURI) throws QvtMtcExecutionException {
		
		if (pModel != null && sModel != null  ) {
			sModel.setCachingEnabled(true);
			sModel.clearCache();
			pModel.setStoredOnDisposal(true);
			sModel.setStoredOnDisposal(true);
			EolTask eol = null;
			try {
				eol = new EolTask(java.net.URI.create(getResourceURI(schedulingTxURI)));
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
		iModel = createASModel(qvtiUri, "QVTi", "QVT", QVTI_FULL_NS, false, true, false, true);
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
		
		EtlTask eol = null;
		List<URI> loadedUris = new ArrayList<URI>();
		try {
			eol = new EtlTask(java.net.URI.create(getResourceURI(ECORE_TO_TREE_EOL)));
		} catch (URISyntaxException e) {
			throw new QvtMtcExecutionException(e.getMessage(), e.getCause());
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
	        		URI modelUri = null;
					try {
						modelUri = baseUri.appendSegment(mm);	
					} catch (IllegalArgumentException e) {
						throw new QvtMtcExecutionException(e.getMessage(), e.getCause());
					} finally {
						if (modelUri != null && !loadedUris.contains(modelUri)) {
							loadedUris.add(modelUri);
							PivotModel mmModel = null;
							PivotModel treeModel = null;
							mmModel = createModel(modelUri.toString(), "mm", "", ECORE_URI, true, false, true, false);
							String cgUri = mmModel.getModelFileUri().trimFileExtension().toString() + "ContainmentTree.xmi";
							treeModel = createModel(cgUri, "tree", pairs.getKey().toLowerCase()+"Tree", ECORE_CONTAINMENT_URI, false, true, true, false);
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
		
		configModel = createModel(configUri, CONFIG_MODEL_NAME, "", CONFIG_URI, true, false, true, false);
	}
	
	/**
	 * Load OCLStdLib model.
	 *
	 * @throws QvtMtcExecutionException If there is a problem loading the model.
	 */
	protected void loadOclStdLibModel() throws QvtMtcExecutionException {
		
		OCLASResourceFactory.getInstance();
//        Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap( ).put("oclas", OCLASResourceFactory.getInstance());
		oclStdLibModel = createASModel(OCL_STD_LIB_URI, OCL_STD_LIB_MODEL_NAME, "", PIVOT_URI, true, false, true, false);
	}
	
	/**
	 * Register metamodels.
	 *
	 * @param myQVT the meta model manager
	 * @throws QvtMtcExecutionException If there is a problem finding the metamodels
	 */
	private void registerMetamodels(OCL myQVT) throws QvtMtcExecutionException {
		
		URI mmURI = null;
		// Configuration Metamodel
		try {
			mmURI = URI.createURI(CONFIG_MM);
		} catch (IllegalArgumentException e) {
			throw new QvtMtcExecutionException(e.getMessage(), e.getCause());
		} finally {
			if (mmURI != null) {
				registerPackages(myQVT, mmURI);
			}
		}
		// Containment tree metamodel
		mmURI = null;
		try {
			mmURI = URI.createURI(ECORE_CONTAINMENT_MM);
		} catch (IllegalArgumentException e) {
			throw new QvtMtcExecutionException(e.getMessage(), e.getCause());
		} finally {
			if (mmURI != null) {
				registerPackages(myQVT, mmURI);
			}
			
		}
		// Schedule metamodel
		mmURI = null;
		try {
			mmURI =  URI.createURI(QVTS_MM);
		} catch (IllegalArgumentException e) {
			throw new QvtMtcExecutionException(e.getMessage(), e.getCause());
		} finally {
			if (mmURI != null) {
				registerPackages(myQVT, mmURI);
			}
		}
	}

	/**
	 * @param myQVT
	 * @param mmURI
	 */
	private void registerPackages(OCL myQVT, URI mmURI) {
		Resource r;
		r = myQVT.getResourceSet().getResource(mmURI, true);
		for (EObject eObject : r.getContents()) {
			if (eObject instanceof EPackage) {
			    EPackage p = (EPackage)eObject;
			    myQVT.getResourceSet().getPackageRegistry().put(p.getNsURI(), p);
			}
		}
	}

	
	/**
	 * Creates a Pivot Model with the given attributes. This models is loaded by the metamodel manager
	 * as external resources. Use this method for creating models that are not AS of any of the
	 * QVTd languages.
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
				boolean readOnLoad, boolean storeOnDispoal, boolean cached, boolean expand) throws QvtMtcExecutionException {
	
		PivotModel model = new PivotModel(qvtUtility, false);
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, modelName);
		properties.put(EmfModel.PROPERTY_ALIASES, modelAliases);
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, metamodelUris);
		properties.put(EmfModel.PROPERTY_MODEL_URI, modeUri);
		properties.put(EmfModel.PROPERTY_READONLOAD, String.valueOf(readOnLoad));
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, String.valueOf(storeOnDispoal));
		properties.put(EmfModel.PROPERTY_CACHED, String.valueOf(cached));
		properties.put(EmfModel.PROPERTY_EXPAND, String.valueOf(expand));
		try {
			model.load(properties, "");
		} catch (EolModelLoadingException e) {
			throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
		}
		return model;
	}
	
	
	private PivotModel createASModel(String modeUri, String modelName, String modelAliases, String metamodelUris,
			boolean readOnLoad, boolean storeOnDispoal, boolean cached, boolean expand) throws QvtMtcExecutionException {
	
		PivotModel model = new PivotModel(qvtUtility, true);
		StringProperties properties = new StringProperties();
		properties.put(EmfModel.PROPERTY_NAME, modelName);
		properties.put(EmfModel.PROPERTY_ALIASES, modelAliases);
		properties.put(EmfModel.PROPERTY_METAMODEL_URI, metamodelUris);
		properties.put(EmfModel.PROPERTY_MODEL_URI, modeUri);
		properties.put(EmfModel.PROPERTY_READONLOAD, String.valueOf(readOnLoad));
		properties.put(EmfModel.PROPERTY_STOREONDISPOSAL, String.valueOf(storeOnDispoal));
		properties.put(EmfModel.PROPERTY_CACHED, String.valueOf(cached));
		properties.put(EmfModel.PROPERTY_EXPAND, String.valueOf(expand));
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
	/*private String getResourceUriFromClass(Class<?> c, String resource) throws URISyntaxException {
		URL r = c.getResource(resource);
		String uri = r.toURI().toString();
	    return uri;
	}	*/

}
