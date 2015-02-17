package org.eclipse.qvtd.build.cs2as;

import java.net.URISyntaxException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.build.etl.EtlTask;
import org.eclipse.qvtd.build.etl.MtcBroker;
import org.eclipse.qvtd.build.etl.PivotModel;
import org.eclipse.qvtd.build.etl.QvtMtcExecutionException;

/**
 * This is a quick extension of the MtcBroker, to exercise the OCL2QVTi code in test cases
 * 
 * @author asbh500
 * 
 */
public class OCL2QVTiBroker extends MtcBroker {
	
	private static final String OCL2QVTP_MIDDLE_MODEL = "ocl2qvtp.etl";
	
	private static final String OCL2QVTP_MIDDLE_FOLDED = "ocl2qvtp_v2.etl";

	private static final String OCLSTDLIB_URI = "http://www.eclipse.org/ocl/2015/Library.oclas";
	
	private static final String ECORE_URI = "http://www.eclipse.org/emf/2002/Ecore";
	
	private static final String PIVOT_URI = "http://www.eclipse.org/ocl/2015/Pivot";
	
	private static final String QVTB_URI ="http://www.eclipse.org/qvt/2015/QVTbase";
	
	private static final String QVTCB_URI = "http://www.eclipse.org/qvt/2015/QVTcoreBase";
	
	private static final String QVTI_URI = "http://www.eclipse.org/qvt/2015/QVTimperative";
		
	private static final String QVTI_FULL_NS = QVTI_URI + ',' + QVTCB_URI + ',' +  QVTB_URI + ',' +  PIVOT_URI;
	
	private static final String TRACES_FULL_NS = PIVOT_URI + ',' + ECORE_URI;
	
	private @NonNull String oclDocUri;	
	private @Nullable String tracesMMUri;
	private @NonNull PivotModelUtil pmUtil;
	

	public OCL2QVTiBroker(URI baseURI, String oclDocName, @NonNull EnvironmentFactory environmentFactory)
		throws Exception {
		this(baseURI, oclDocName, environmentFactory, true);
	}
			
	public OCL2QVTiBroker(URI baseURI, String oclDocName, @NonNull EnvironmentFactory environmentFactory, boolean usesMiddleFoldedInInputs)
		throws Exception {
		
		super(baseURI, oclDocName, environmentFactory);
		this.pmUtil = new PivotModelUtil(environmentFactory);
		this.oclDocUri = baseURI.appendSegment(oclDocName).toString();
	
		if (!usesMiddleFoldedInInputs) {
			this.tracesMMUri = baseURI.appendFileExtension("ecore.oclas").toString();	
		}
	}
	

	@Override
	public void execute() throws QvtMtcExecutionException {
		
		pModel = (tracesMMUri == null)	? runOCL2QVTp_MiddleFolded(oclDocUri, partitionUri) 
										: runOCL2QVTp_MiddleModel(oclDocUri, partitionUri, tracesMMUri);
		
		loadOclStdLibModel();
		loadConfigurationModel();
		createContainmentTrees();
		sModel = qvtpToQvts(pModel);
		//qvtpFlatScheduling(pModel, sModel);
		qvtpNestingScheduling(pModel, sModel);
		iModel = qvtpQvtsToQvti(pModel, sModel);
	}
	
	
	protected PivotModel runOCL2QVTp_MiddleModel (String oclDocURI, String qvtiFileURI, String tracesMMURI) throws QvtMtcExecutionException {
		
		try {
			EtlTask etl = new EtlTask(OCL2QVTiBroker.class.getResource(OCL2QVTP_MIDDLE_MODEL).toURI());
			pModel = createQVTpModel(qvtiFileURI);
			etl.addModel(createOCLModel(oclDocURI));
			etl.addModel(pModel);
			etl.addModel(createTacesModel(tracesMMURI));
			etl.addModel(createOclStdLibModel());
			etl.execute();

		} catch (URISyntaxException e) {
			throw new QvtMtcExecutionException("Exception launching OCL 2 QVTp transformation", e);
		}
		
		return pModel;
	}
	
	protected PivotModel runOCL2QVTp_MiddleFolded (String oclDocURI, String qvtiFileURI) throws QvtMtcExecutionException {

		try {
			EtlTask etl = new EtlTask(OCL2QVTiBroker.class.getResource(OCL2QVTP_MIDDLE_FOLDED).toURI());
			pModel= createQVTpModel(qvtiFileURI);
			etl.addModel(createOCLModel(oclDocURI));
			etl.addModel(pModel);
			etl.addModel(createOclStdLibModel());
			etl.execute();

		} catch (URISyntaxException e) {
			throw new QvtMtcExecutionException("Exception launching OCL 2 QVTp transformation", e);
		}
		
		return pModel;
	}
	
	private PivotModel createOCLModel(String oclDocURI) throws QvtMtcExecutionException {
		String oclDocModelName = "OCL";
		return pmUtil.createPivotModel(oclDocURI, oclDocModelName, "", PIVOT_URI, true, false, true, true, true);
		
	}
	
	private PivotModel createQVTpModel(String qvtiFileURI) throws QvtMtcExecutionException { 
		String qvtiModelName = "QVTp";
		String qvtiModelAlises = "QVTi,QVT"; // FIXME further steps should configure the aliases
		return pmUtil.createPivotModel(qvtiFileURI, qvtiModelName, qvtiModelAlises, QVTI_FULL_NS, false, true, false, true, true);
	}
	
	private PivotModel createTacesModel(String tracesMMURI) throws QvtMtcExecutionException { 
		String tracesMModelName = "MiddleMM";
		return pmUtil.createPivotModel(tracesMMURI, tracesMModelName, "", TRACES_FULL_NS , true, false, true, false, true);
	}
	
	private PivotModel createOclStdLibModel() throws QvtMtcExecutionException {
		String oclStdlibName = "OclStdLib";
		return pmUtil.createPivotModel(OCLSTDLIB_URI, oclStdlibName, "", PIVOT_URI, true, false, true, false, true);
	}
}
