/*******************************************************************************
 * Copyright (c) 2013, 2015 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.etl;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
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
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.internal.resource.OCLASResourceFactory;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibPackage;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.etl.mtc.QVTc2QVTu;
import org.eclipse.qvtd.compiler.internal.etl.mtc.QVTm2QVTp;
import org.eclipse.qvtd.compiler.internal.etl.mtc.QVTu2QVTm;
import org.eclipse.qvtd.compiler.internal.etl.scheduling.ClassRelationships;
import org.eclipse.qvtd.compiler.internal.etl.scheduling.QVTp2QVTg;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.Direction;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage;
import org.eclipse.qvtd.compiler.internal.scheduler.ScheduledRegion;
import org.eclipse.qvtd.compiler.internal.scheduler.Scheduler;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.CoreModel;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.SchedulePackage;
import org.eclipse.qvtd.pivot.schedule.utilities.ScheduleToCallGraph;
import org.eclipse.qvtd.pivot.schedule.utilities.ScheduleToDependencyGraphVisitor;

// TODO: Auto-generated Javadoc
/**
 * The Class MtcBroker.
 */
public class MtcBroker {

	/** The Constant ECORE_URI. */
	private static final String ECORE_URI = EcorePackage.eNS_URI;

	/** The Constant CONFIG_MODEL_NAME. */
	private static final String CONFIG_MODEL_NAME = "config";

	/** The Constant CONFIG_MM. */
//	private static final String CONFIG_MM = "platform:/resource/org.eclipse.qvtd.compiler/model/QVTcConfig.ecore";

	/** The Constant CONFIG_URI. */
	private static final String CONFIG_URI = QVTcConfigPackage.eNS_URI;

	/** The Constant CONFIG_QUERIES_EOL. */
	private static final String CONFIG_QUERIES_EOL = "helpers/ConfigQueries.eol";

	/** The Constant ECORE_CONTAINMENT_MM. */
	private static final String ECORE_CONTAINMENT_MM = "platform:/resource/org.eclipse.qvtd.compiler/model/ECoreContainmentTree.ecore";

	/** The Constant ECORE_CONTAINMENT_URI. */
	private static final String ECORE_CONTAINMENT_URI = "http://www.eclipse.org/qvt/examples/0.1/ECoreContainemntTree";

	/** The Constant ECORE_TO_TREE_EOL. */
	private static final String ECORE_TO_TREE_EOL = "utils/EcoreToContainmentTree.etl";

	/** The Constant QVTS_MM. */
	//private static final String QVTS_MM = "platform:/resource/org.eclipse.qvtd.pivot.schedule/model/Schedule.ecore";

	/** The Constant QVTS_URI. */
	private static final String QVTS_URI = SchedulePackage.eNS_URI;
	
	/** The Constant OCL_STD_LIB_MODEL_NAME. */
	private static final String OCL_STD_LIB_MODEL_NAME = "oclStdLib";

	/** The Constant OCL_STD_LIB_URI. */
	private static final String OCL_STD_LIB_URI = OCLstdlibPackage.eNS_URI + ".oclas";

	/** The Constant PIVOT_URI. */
	private static final String PIVOT_URI = PivotPackage.eNS_URI;

	/** The Constant QVTB_URI. */
	private static final String QVTB_URI = QVTbasePackage.eNS_URI;

	/** The Constant QVTCB_URI. */
	private static final String QVTCB_URI =  QVTcoreBasePackage.eNS_URI;

	/** The Constant QVTC_URI. */
	private static final String QVTC_URI = QVTcorePackage.eNS_URI;

	/** The Constant QVTI_URI. */
	private static final String QVTI_URI = QVTimperativePackage.eNS_URI;

	/** The Constant QVTC_FULL_NS. */
	private static final String QVTC_FULL_NS = QVTC_URI + "," + QVTCB_URI + "," + QVTB_URI + "," + PIVOT_URI;

	/** The Constant QVTI_FULL_NS. */
	protected static final String QVTI_FULL_NS = QVTI_URI + "," + QVTCB_URI + "," +  QVTB_URI + "," +  PIVOT_URI;
	
	/** The Constant QVTS_FULL_NS. */
	private static final String QVTS_FULL_NS = QVTS_URI + "," + QVTI_FULL_NS;

	// Epsilon Scripts
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
	private static final String QVTP_SIMPLE_NESTING_SCHEDULE_EOL = "scheduling/NestedSchedule.eol";

	/** The Constant QVTPS_TO_QVTI_ETL. */
	private static final String QVTPS_TO_QVTI_ETL = "mtc/QVTs-pToQVTi.etl";

	/** The Constant LEFT_DIR_NAME. */
	@SuppressWarnings("unused")
	private static final String LEFT_DIR_NAME = "L";

	/** The Constant RIGHT_DIR_NAME. */
	private static final String RIGHT_DIR_NAME = "R";

	/** The Constant MIDDLE_DIR_NAME. */
	@SuppressWarnings("unused")
	private static final String MIDDLE_DIR_NAME = "M";

	/** The Constant CREATE_GRAPHML. */
	protected boolean createGraphml = false;

	private boolean darkTheme = false;
	
	private boolean nestedSchedule = true;
	
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

    private Configuration config;
	
	/** The ocl std lib model. */
	protected PivotModel oclStdLibModel;

	private URI dependencyGraphUri;

	private URI callGraphUri;

	/** The r metamodel. */
	@SuppressWarnings("unused")
	private String rMetamodel;

	/** The r metamodel model. */
	@SuppressWarnings("unused")
	private PivotModel rMetamodelModel;

	/** The candidate metamodel containment trees. */
	private Map<String, List<PivotModel>> candidateMetamodelContainmentTrees;

	/** The meta model manager. */
	protected @NonNull EnvironmentFactory environmentFactory;

	/** The saving options. */
	protected @Nullable Map<?, ?> savingOptions;

	/** The base uri. */
	private URI baseUri;

	private URI debugUri;

	/** The QVTc model. */
	private PivotModel cModel;

	/** The QVTu model. */
	private PivotModel uModel;

	/** The QVTm model. */
	private PivotModel mModel;

	/** The QVTp model. */
	protected PivotModel pModel;

	/** The QVTg model. */
	protected PivotModel gModel;

	/** The QVTs model. */
	protected PivotModel sModel;

	/** The QVTi model. */
	protected PivotModel iModel;
	protected Resource iResource;

	
		
	
	/**
	 * Instantiates a new MTC broker.
	 *
	 * @param baseURI the base uri
	 * @param qvtcSource the qvtc source
	 * @param environmentFactory the environment factory
	 * @throws QvtMtcExecutionException If there is a problem registering the required metamodels.
	 */
	public MtcBroker(URI baseURI, String qvtcSource, @NonNull EnvironmentFactory environmentFactory) throws QvtMtcExecutionException {
		this(baseURI, qvtcSource, environmentFactory, null);
	}

	/**
	 * Instantiates a new mtc broker.
	 *
	 * @param baseURI the base uri
	 * @param qvtcSource the qvtc source
	 * @param environmentFactory the environment factory
	 * @param savingOptions the saving options
	 * @throws QvtMtcExecutionException the qvt mtc execution exception
	 */
	public MtcBroker(URI baseURI, String qvtcSource, @NonNull EnvironmentFactory environmentFactory, Map<?, ?> savingOptions) throws QvtMtcExecutionException {

		this.savingOptions = savingOptions;
		this.environmentFactory = environmentFactory;
		this.baseUri = baseURI;
		this.debugUri = baseURI.appendSegment("debug");
		String dgPath = this.debugUri.appendSegment(qvtcSource).trimFileExtension() + "Dependencies";
		String cgPath = this.debugUri.appendSegment(qvtcSource).trimFileExtension() + "Calls";
		System.out.println("Executing the QVTc to QVTi MTC for " + qvtcSource);
		this.baseUri = baseURI;
		URI qvtcURI = baseURI.appendSegment(qvtcSource);
		this.qvtcasUri = qvtcURI.toString();
    	URI modelsBaseUri = qvtcURI.trimFileExtension();
    	this.qvtuUri = modelsBaseUri.appendFileExtension("qvtu.qvtcas").toString();
		this.qvtmUri = modelsBaseUri.appendFileExtension("qvtm.qvtcas").toString();
		this.partitionUri = modelsBaseUri.appendFileExtension("qvtp.qvtias").toString();
		this.qvtiUri = modelsBaseUri.appendFileExtension("qvtias").toString();
		this.configUri = URI.createURI(modelsBaseUri.toString() + "Config").appendFileExtension("xmi").toString();
		this.scheduleUri = URI.createURI(modelsBaseUri.toString() + "Schedule").appendFileExtension("xmi").toString();
		this.dependencyGraphUri = URI.createURI(dgPath).appendFileExtension("graphml");
		this.callGraphUri = URI.createURI(cgPath).appendFileExtension("graphml");
		candidateMetamodelContainmentTrees = new HashMap<String, List<PivotModel>>();
		registerMetamodels(environmentFactory);
	}

	/**
	 * Gets the c model.
	 *
	 * @return the cModel
	 */
	public PivotModel getcModel() {
		return cModel;
	}

	/**
	 * Gets the u model.
	 *
	 * @return the uModel
	 */
	public PivotModel getuModel() {
		return uModel;
	}


	/**
	 * Gets the m model.
	 *
	 * @return the mModel
	 */
	public PivotModel getmModel() {
		return mModel;
	}

	/**
	 * Gets the p model.
	 *
	 * @return the pModel
	 */
	public PivotModel getpModel() {
		return pModel;
	}


	public void setgModel(PivotModel gModel) {
		this.gModel = gModel;
	}

	/**
	 * Gets the g model.
	 *
	 * @return the gModel
	 */
	public PivotModel getgModel() {
		return gModel;
	}

	/**
	 * Gets the s model.
	 *
	 * @return the sModel
	 */
	public PivotModel getsModel() {
		return sModel;
	}


	/**
	 * Gets the i model.
	 *
	 * @return the iModel
	 */
	public PivotModel getiModel() {
		return iModel;
	}
	public Resource getiResource() {
		return iResource;
	}

	/**
	 * Prepare.
	 *
	 * @throws QvtMtcExecutionException the qvt mtc execution exception
	 */
	public void prepare() throws QvtMtcExecutionException {
		loadConfigurationModel();
		loadOclStdLibModel();
		// This could be run on editor saves by reading the imports!
		createContainmentTrees();
	}

	public static void assertNoResourceErrors(String prefix, Resource resource) {
		String message = org.eclipse.ocl.pivot.utilities.PivotUtil.formatResourceDiagnostics(resource.getErrors(), prefix, "\n\t");
		if (message != null)
			assert false : message;
	}

	/**
	 * Execute.
	 *
	 * @throws QvtMtcExecutionException If there is an exception at any point in
	 * 	the MTC execution.
	 */
	public void execute() throws QvtMtcExecutionException {
		
		prepare();
		cModel = createASModel(qvtcasUri, "QVTc", "QVT", QVTC_FULL_NS, true, false, true, false);
		assertNoResourceErrors("cModel", cModel.getResource());
		uModel = qvtcToQvtu(cModel, true);
		assertNoResourceErrors("uModel", uModel.getResource());
		mModel = qvtuToQvtm(uModel, true);
		assertNoResourceErrors("mModel", mModel.getResource());
		pModel = qvtmToQvtp(mModel, true);
		assertNoResourceErrors("pModel", pModel.getResource());
		sModel = qvtpToQvts(pModel);
		if (nestedSchedule)
			qvtpNestingScheduling(pModel, sModel);
		else
			qvtpFlatScheduling(pModel, sModel);
		if (createGraphml)
			qvtsToGraphML(sModel);
		iModel = qvtpQvtsToQvti(pModel, sModel);
		assertNoResourceErrors("iModel", iModel.getResource());
		iModel.store();
	}
	public @Nullable Resource newExecute() throws QvtMtcExecutionException {
		loadConfigurationModel();
		cModel = createASModel(qvtcasUri, "QVTc", "QVT", QVTC_FULL_NS, true, false, true, false);
		assertNoResourceErrors("cModel", cModel.getResource());
		uModel = qvtcToQvtu(cModel, false);
		assertNoResourceErrors("uModel", uModel.getResource());
		mModel = qvtuToQvtm(uModel, false);
		assertNoResourceErrors("mModel", mModel.getResource());
		pModel = qvtmToQvtp(mModel, false);
		assertNoResourceErrors("pModel", pModel.getResource());
		try {
			iResource = qvtp2qvti(false);
		} catch (QvtMtcExecutionException e) {
			throw e;
		} catch (IOException e) {
			throw new QvtMtcExecutionException("Failed to create regions", e);
		}
		return iResource;
	}
	
	protected Resource qvtp2qvti(boolean useQVTip) throws IOException, QvtMtcExecutionException {
		Resource pResource = pModel.getResource();
		ResourceSet pResourceSet = pResource.getResourceSet();
		RootDomainUsageAnalysis domainAnalysis = useQVTip
				? new QVTimperativeDomainUsageAnalysis((EnvironmentFactoryInternal) this.environmentFactory)
				: new QVTcoreDomainUsageAnalysis((EnvironmentFactoryInternal) this.environmentFactory);
		gModel = createASModel(scheduleUri, "QVTg", "QVT", QVTS_FULL_NS, false, true, false, true);
		Resource gResource = gModel.getResource();
		pModel.setCachingEnabled(true);
		pModel.clearCache();
		pModel.setStoredOnDisposal(false);
		Transformation asTransformation;
		try {
			asTransformation = getTransformation(pResource);
		} catch (Exception e1) {
			throw new QvtMtcExecutionException(e1.getMessage());
		}
		QVTbaseUtil.rewriteSafeNavigations(environmentFactory, asTransformation);
		/*Map<Element, DomainUsage> analysis =*/ domainAnalysis.analyzeTransformation(asTransformation);
		ClassRelationships classRelationships = new ClassRelationships(environmentFactory, pResourceSet);
		QVTp2QVTg qvtp2qvtg = new QVTp2QVTg(domainAnalysis, classRelationships);
		qvtp2qvtg.run(pResource, gResource);
		gResource.getContents().add(domainAnalysis.getPrimitiveTypeModel());
		
		// We have to manually save the models
		pModel.store();
		assertNoResourceErrors("gModel", gResource);
		if (createGraphml) {
			qvtsToGraphML(gModel);
		}
		org.eclipse.qvtd.compiler.internal.scheduler.Scheduler scheduler = new Scheduler(environmentFactory, getSchedule(), domainAnalysis, qvtp2qvtg);
		ScheduledRegion rootRegion = scheduler.qvtp2qvts();
		return scheduler.qvts2qvti(rootRegion, qvtiUri);
	}
	
	protected void qvtsToGraphML(PivotModel sModel) throws QvtMtcExecutionException {
		
		GraphBuilder depBuilder = new GraphMLBuilder();
		GraphBuilder callBuilder = new GraphMLBuilder();
		
		Schedule s = null;
        try {
			s = sModel.getSchedule();
		} catch (Exception e) {
			throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
		} finally {
			if (s != null) {
				ScheduleToDependencyGraphVisitor depVisitor = new ScheduleToDependencyGraphVisitor(depBuilder, this.darkTheme);
				ScheduleToCallGraph callVisitor = new ScheduleToCallGraph(callBuilder, this.darkTheme);
				// GEt the source/middle/target info from the configuration
				for (EObject eContent : configModel.getResource().getContents()) {
					if (eContent instanceof Configuration) {
						Configuration c = (Configuration) eContent;
						depVisitor.setInputDirection(c.getInputDirection().getName());
						depVisitor.setMiddleDirection("middle"); // Always middle? Should the configuration have this value?
						for (Direction od : c.getOutputDirection())  {
							depVisitor.getOutputDirection().add(od.getName());
						}
					}
				}
				s.accept(depVisitor);
				// Save/print the builder
				try (Writer writer = new BufferedWriter(new OutputStreamWriter(
						URIConverter.INSTANCE.createOutputStream(this.dependencyGraphUri), "utf-8"))) {
				   writer.write(depBuilder.toString());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				s.accept(callVisitor);
				try (Writer writer = new BufferedWriter(new OutputStreamWriter(
						URIConverter.INSTANCE.createOutputStream(this.callGraphUri), "utf-8"))) {
				   writer.write(callBuilder.toString());
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
        System.out.println("Graphs created.");
	}


	public void executeQvtcToQvtu() throws QvtMtcExecutionException {

		prepare();
		cModel = createASModel(qvtcasUri, "QVTc", "QVT", QVTC_FULL_NS, true, false, true, false);
		uModel = qvtcToQvtu(cModel, true);
	}

	public void executeQvtuToQvtm() throws QvtMtcExecutionException {

		prepare();
		uModel = createASModel(qvtuUri, "QVTu", "QVT", QVTC_FULL_NS, true, false, false, false);
		mModel = qvtuToQvtm(uModel, true);
	}

	public void executeQvtmToQvtp() throws QvtMtcExecutionException {

		prepare();
		mModel = createASModel(qvtmUri, "QVTm", "QVT", QVTC_FULL_NS, true, false, false, false);
		pModel = qvtmToQvtp(mModel, true);
	}
	
	public void executeQvtsToGraphML() throws QvtMtcExecutionException {
		
		prepare();
		sModel = createASModel(scheduleUri, "QVTs", "QVT", QVTS_FULL_NS, true, false, false, true);
		qvtsToGraphML(sModel);
	}

	public void executeQvtpQvtsToQvti() throws QvtMtcExecutionException {

		prepare();
		pModel = createASModel(partitionUri, "QVTp", "QVT", QVTI_FULL_NS, true, false, false, true);
		sModel = createASModel(scheduleUri, "QVTs", "QVT", QVTS_FULL_NS, false, true, false, true);
		iModel = qvtpQvtsToQvti(pModel, sModel);
	}


	/**
	 * Execute scheduling.
	 *
	 * @param dryRun the dry run
	 * @throws QvtMtcExecutionException the qvt mtc execution exception
	 */
	public void executeQvtpToQvts(boolean dryRun) throws QvtMtcExecutionException {

		prepare();
		try {
			pModel = createASModel(partitionUri, "QVTp", "QVT", QVTI_FULL_NS, true, false, false, true);
			sModel = qvtpToQvts(pModel);
		} catch (QvtMtcExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if ((pModel != null) && (sModel != null))
				sModel.setStoredOnDisposal(!dryRun);
				if (nestedSchedule)
					qvtpNestingScheduling(pModel, sModel);
				else
					qvtpFlatScheduling(pModel, sModel);
		}
	}
	
	/**
	 * Dispose models.
	 */
	public void disposeModels() {
		if (cModel != null) {
			cModel.dispose();
		}
		if (uModel != null) {
			uModel.dispose();
		}
		if (mModel != null) {
			mModel.dispose();
		}
		if (pModel != null) {
			pModel.dispose();
		}
		if (sModel != null) {
			sModel.dispose();
		}
		if (gModel != null) {
			gModel.dispose();
		}
		if (iModel != null) {
			iModel.dispose();
		}
	}

	/**
	 * QVTc to QVTu.
	 *
	 * @param cModel the QVTc model
	 * @return the QVTu model
	 * @throws QvtMtcExecutionException If there is a problem loading the models or
	 * 	executing the Flock script.
	 */
	private PivotModel qvtcToQvtu(EmfModel cModel, boolean useEpsilon) throws QvtMtcExecutionException {
		if (useEpsilon) {
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
			if (cModel != null) {
				environmentFactory.getMetamodelManager().getASResourceSet().getResources().remove(cModel.getResource());
			}
			return uModel;
		}
		else {
	        uModel = createASModel(qvtuUri, "QVTu", "QVT", QVTC_FULL_NS, false, true, false, false);
	        for (EObject e : cModel.getResource().getContents()) {
	            CoreModel newE = (CoreModel) EcoreUtil.copy(e);
	            newE.setExternalURI(((CoreModel) e).getExternalURI().replace(".qvtc", ".qvtu.qvtc"));
	            newE.setName(((CoreModel) e).getName().replace(".qvtc", ".qvtu"));
	            uModel.getResource().getContents().add(newE);
	        }
	        QVTc2QVTu ctou = new QVTc2QVTu(environmentFactory, config);
	        for (EObject e : uModel.getResource().getContents()) {
	        	ctou.execute((CoreModel) e);
	        }
	        uModel.store();
	        System.out.println("QVTcToQVTu Done!");
			return uModel;
		}
	}

	/**
	 * QVTu to QVTm.
	 *
	 * @param uModel the QVTu model
	 * @return the QVTm model
	 * @throws QvtMtcExecutionException If there is a problem loading the models or
	 * 	executing the Flock script.
	 */
	private PivotModel qvtuToQvtm(PivotModel uModel, boolean useEpsilon) throws QvtMtcExecutionException {
		if (useEpsilon) {
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
			if (uModel != null) {
				environmentFactory.getMetamodelManager().getASResourceSet().getResources().remove(uModel.getResource());
			}
			return mModel;
		}
		else {
			mModel = createASModel(qvtmUri, "QVTm", "QVT", QVTC_FULL_NS, false, true, false, false);
			for (EObject e : uModel.getResource().getContents()) {
				CoreModel newE = (CoreModel) EcoreUtil.copy(e);
				newE.setExternalURI(((CoreModel) e).getExternalURI()
					.replace(".qvtu.qvtc", ".qvtm.qvtc"));
				newE.setName(((CoreModel) e).getName().replace(".qvtu", ".qvtm"));
				mModel.getResource().getContents().add(newE);
			}
			QVTu2QVTm utom = new QVTu2QVTm(environmentFactory);
			for (EObject e : mModel.getResource().getContents()) {
				utom.execute((CoreModel) e);
			}
			mModel.store();
			System.out.println("QVTuToQVTm Done!");
			return mModel;
		}
	}

	/**
	 * QVTm to QVTp.
	 *
	 * @param mModel the QVTm model
	 * @return the QVTp model
	 * @throws QvtMtcExecutionException If there is a problem loading the models or
	 * 	executing the ETL script.
	 */
    private PivotModel qvtmToQvtp(@NonNull PivotModel mModel, boolean useEpsilon) throws QvtMtcExecutionException {
    	if (useEpsilon) {
            PivotModel pModel = null;
            pModel = createASModel(partitionUri, "QVTp", "QVT", QVTI_FULL_NS, false, true, false, true);
    		if (pModel != null) {
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
            environmentFactory.getMetamodelManager().getASResourceSet().getResources().remove(mModel.getResource());
            return pModel;
    	}
    	else {
	        PivotModel pModel = null;
	        pModel = createASModel(partitionUri.replace("qvtias",  "qvtcas"), "QVTp", "QVT", QVTI_FULL_NS, false, true, false, true);
	        QVTm2QVTp tx = new QVTm2QVTp(environmentFactory);
	        tx.transform(mModel.getResource(), pModel.getResource());
	        environmentFactory.getMetamodelManager().getASResourceSet().getResources().remove(mModel.getResource());
			pModel.store();
	        return pModel;
    	}
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
		sModel = createASModel(scheduleUri, "QVTs", "QVT", QVTS_FULL_NS, false, true, false, true);
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
					List<PivotModel> rightCandidateModel = candidateMetamodelContainmentTrees.get(RIGHT_DIR_NAME);
					if (rightCandidateModel != null) {
						etl.models.add(rightCandidateModel.get(0));
					}
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
	 * @return
	 * @throws QvtMtcExecutionException If there was an error loading the script
	 */
	protected PivotModel qvtpFlatScheduling(PivotModel pModel, PivotModel sModel) throws QvtMtcExecutionException {

		return qvtpScheduling(pModel, sModel, QVTP_FLAT_SCHEDULE_EOL);
	}

	/**
	 * Qvtp simple nesting scheduling.
	 *
	 * @param pModel the model
	 * @param sModel the s model
	 * @throws QvtMtcExecutionException If there was an error loading the script
	 */
	protected PivotModel qvtpNestingScheduling(PivotModel pModel, PivotModel sModel) throws QvtMtcExecutionException {
		
		return qvtpScheduling(pModel, sModel, QVTP_SIMPLE_NESTING_SCHEDULE_EOL);
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
	protected PivotModel qvtpScheduling(PivotModel pModel, PivotModel sModel, String schedulingTxURI) throws QvtMtcExecutionException {
		
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
				List<PivotModel> rightCandidateModel = candidateMetamodelContainmentTrees.get(RIGHT_DIR_NAME);
				if (rightCandidateModel != null) {
					eol.models.add(rightCandidateModel.get(0));
				}
				eol.execute();
			}
		}
		return sModel;
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
						//modelUri = baseUri.appendSegment(mm);
						URI mmSegments = URI.createURI(mm);
						if (mmSegments.segments().length == 1) {
							modelUri = baseUri.appendSegment(mm);
						} else {
							modelUri = mmSegments.resolve(baseUri);
						}
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
        for (EObject eo : configModel.getResource().getContents()) {
            if (eo instanceof Configuration) {
                config = (Configuration) eo;
                break;
            }
        }
        assert config != null;
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
	 * @param environmentFactory the environment factory
	 * @throws QvtMtcExecutionException If there is a problem finding the metamodels
	 */
	private void registerMetamodels(@NonNull EnvironmentFactory environmentFactory) throws QvtMtcExecutionException {

		URI mmURI = null;

		ResourceSet externalResourceSet = environmentFactory.getResourceSet();
		Resource r;
		EObject eObject;
		// Configuration Metamodel
		EPackage cp = QVTcConfigPackage.eINSTANCE;
		externalResourceSet.getPackageRegistry().put(cp.getNsURI(), cp);
		/*try {
			mmURI = URI.createURI(CONFIG_MM, false);
		} catch (IllegalArgumentException e) {
			throw new QvtMtcExecutionException(e.getMessage(), e.getCause());
		} finally {
			if (mmURI != null) {
				r = externalResourceSet.getResource(mmURI, true);
				eObject = r.getContents().get(0);
				if (eObject instanceof EPackage) {
				    EPackage p = (EPackage)eObject;
				    externalResourceSet.getPackageRegistry().put(p.getNsURI(), p);
				}
			}
		}
		*/
		// Containment tree metamodel
		mmURI = null;
		try {
			mmURI = URI.createURI(ECORE_CONTAINMENT_MM);
		} catch (IllegalArgumentException e) {
			throw new QvtMtcExecutionException(e.getMessage(), e.getCause());
		} finally {
			if (mmURI != null) {
				r = externalResourceSet.getResource(mmURI, true);
				eObject = r.getContents().get(0);
				if (eObject instanceof EPackage) {
				    EPackage p = (EPackage)eObject;
				    externalResourceSet.getPackageRegistry().put(p.getNsURI(), p);
				}
			}

		}
		// Schedule metamodel
		EPackage sp = SchedulePackage.eINSTANCE;
		externalResourceSet.getPackageRegistry().put(sp.getNsURI(), sp);
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
	 * @param expand the expand
	 * @return the pivot model
	 * @throws QvtMtcExecutionException There was an error loading the model
	 */
	protected PivotModel createModel(String modeUri, String modelName, String modelAliases, String metamodelUris,
				boolean readOnLoad, boolean storeOnDispoal, boolean cached, boolean expand) throws QvtMtcExecutionException {

		PivotModel model = new PivotModel(environmentFactory, false, savingOptions);
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
	 * Creates the as model.
	 *
	 * @param modeUri the mode uri
	 * @param modelName the model name
	 * @param modelAliases the model aliases
	 * @param metamodelUris the metamodel uris
	 * @param readOnLoad the read on load
	 * @param storeOnDispoal the store on dispoal
	 * @param cached the cached
	 * @param expand the expand
	 * @return the pivot model
	 * @throws QvtMtcExecutionException the qvt mtc execution exception
	 */
	private PivotModel createASModel(String modeUri, String modelName, String modelAliases, String metamodelUris,
			boolean readOnLoad, boolean storeOnDispoal, boolean cached, boolean expand) throws QvtMtcExecutionException {

	PivotModel model = new PivotModel(environmentFactory, true, savingOptions);
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
	 * @param resource the resource
	 * @return URI for the provided filename
	 *
	 * 	private java.net.URI getURI(String fileName)  {
	 * 	    return java.net.URI.create(URI.createPlatformResourceURI(fileName, false).toString());
	 * 	}
	 * @throws URISyntaxException the URI syntax exception
	 */

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

	public void setCreateGraphml(boolean createGraphml) {
		setCreateGraphml(createGraphml, false);
		
	}
	
	public void setCreateGraphml(boolean createGraphml, boolean darkTheme) {
		this.createGraphml = createGraphml;
		this.darkTheme = darkTheme;
	}

	public @NonNull Transformation getTransformation(Resource resource) throws Exception {
		for (EObject eContent : resource.getContents()) {
			if (eContent instanceof BaseModel) {
	    		for (org.eclipse.ocl.pivot.Package aPackage : ((BaseModel)eContent).getOwnedPackages()) {
	    			for (org.eclipse.ocl.pivot.Class aClass : aPackage.getOwnedClasses()) {
	    				if (aClass instanceof Transformation) {
		                    return (Transformation) aClass;
		    			}
	    			}
	    		}
			}
		}
		throw new Exception("The QVTd model does not have a Transformation element.");
	}

	public @NonNull Schedule getSchedule() throws QvtMtcExecutionException {
		if (gModel != null)
			for (EObject eContent : gModel.getResource().getContents()) {
				if (eContent instanceof Schedule) {
		    		return (Schedule) eContent;
				}
			}
		throw new QvtMtcExecutionException("Could not retreive the Schedule for this MTC");
	}

	/**
	 * Sets the nested schedule option.
	 *
	 * By default, the scheduler creates a nested schedule. If set to False, the
	 * scheduler generates a flat schedule.
	 *
	 * @param nestedSchedule the new nested schedule
	 */
	public void setNestedSchedule(boolean nestedSchedule) {
		this.nestedSchedule = nestedSchedule;
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
