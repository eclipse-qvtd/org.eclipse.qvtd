/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations Ltd., University of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.build.cs2as;

import java.net.URISyntaxException;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.qvtd.compiler.internal.etl.EtlTask;
import org.eclipse.qvtd.compiler.internal.etl.MtcBroker;
import org.eclipse.qvtd.compiler.internal.etl.PivotModel;
import org.eclipse.qvtd.compiler.internal.etl.QvtMtcExecutionException;

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
	
	private @NonNull URI oclASUri;	
	private @Nullable URI tracesASUri;
	private @NonNull PivotModelUtil pmUtil;

	/**
	 * @param baseURI the base {@link URI} on which the OCL document resides
	 * @param oclDocName the name of the OCL document (e.g myCS2AS.ocl)
	 * @param ocl an {@link OCL} instance to parse the OCL document
	 * @param savingOptions some optional savingOptions
	 * @throws Exception
	 */
	public OCL2QVTiBroker(@NonNull URI baseURI, @NonNull String oclDocName, @NonNull OCL ocl, @Nullable Map<?, ?> savingOptions )
		throws Exception {
		this(baseURI, oclDocName, ocl, savingOptions, true);
	}

	/**
	 * @param baseURI the base {@link URI} on which the OCL document resides
	 * @param oclDocName the name of the OCL document (e.g myCS2AS.ocl)
	 * @param ocl an {@link OCL} instance to parse the OCL document
	 * @param savingOptions some optional savingOptions
	 * @param usesMiddleFoldedInInputs true if the generated QVTp transformation should use middle folded in inputs approach
	 * @throws Exception
	 */
	
	public OCL2QVTiBroker(@NonNull URI baseURI, @NonNull String oclDocName, @NonNull OCL ocl, @Nullable Map<?, ?> savingOptions,
			boolean usesMiddleFoldedInInputs)
		throws Exception {
		
		super(baseURI, oclDocName,  ocl.getEnvironmentFactory(), savingOptions);
		this.pmUtil = new PivotModelUtil( ocl.getEnvironmentFactory());
		URI oclDocUri = baseURI.appendSegment(oclDocName);
		this.oclASUri = ocl.parse(oclDocUri).getURI();
		if (!usesMiddleFoldedInInputs) {
			this.tracesASUri = this.oclASUri.trimFileExtension().trimFileExtension().appendFileExtension("ecore.oclas");
		}
	}
	

	@Override
	public void execute() throws QvtMtcExecutionException {
		
		pModel = (tracesASUri == null)	? runOCL2QVTp_MiddleFolded(oclASUri, URI.createURI(partitionUri)) 
										: runOCL2QVTp_MiddleModel(oclASUri, URI.createURI(partitionUri), tracesASUri);
		
		prepare();
		sModel = qvtpToQvts(pModel);
		qvtpFlatScheduling(pModel, sModel);
		// qvtpNestingScheduling(pModel, sModel);
		iModel = qvtpQvtsToQvti(pModel, sModel);
	}
	
	
	protected PivotModel runOCL2QVTp_MiddleModel (URI oclDocURI, URI qvtiFileURI, URI tracesMMURI) throws QvtMtcExecutionException {
		
		try {
			EtlTask etl = new EtlTask(OCL2QVTiBroker.class.getResource(OCL2QVTP_MIDDLE_MODEL).toURI());
			pModel = createQVTpModel(qvtiFileURI);
			etl.addModel(createOCLModel(oclDocURI));
			etl.addModel(pModel);
			etl.addModel(createTracesModel(tracesMMURI));
			etl.addModel(createOclStdLibModel());
			etl.execute();

		} catch (URISyntaxException e) {
			throw new QvtMtcExecutionException("Exception launching OCL 2 QVTp transformation", e);
		}
		
		return pModel;
	}
	
	protected PivotModel runOCL2QVTp_MiddleFolded (URI oclDocURI, URI qvtiFileURI) throws QvtMtcExecutionException {

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
	
	private PivotModel createOCLModel(URI oclDocURI) throws QvtMtcExecutionException {
		String oclDocModelName = "OCL";
		return pmUtil.createPivotModel(oclDocURI.toString(), oclDocModelName, "", PIVOT_URI, true, false, true, true, true, savingOptions);
		
	}
	
	private PivotModel createQVTpModel(URI qvtiFileURI) throws QvtMtcExecutionException { 
		String qvtiModelName = "QVTp";
		String qvtiModelAlises = "QVTi,QVT"; // FIXME further steps should configure the aliases
		return pmUtil.createPivotModel(qvtiFileURI.toString(), qvtiModelName, qvtiModelAlises, QVTI_FULL_NS, false, true, false, true, true, savingOptions);
	}
	
	private PivotModel createTracesModel(URI tracesMMURI) throws QvtMtcExecutionException { 
		String tracesMModelName = "MiddleMM";
		return pmUtil.createPivotModel(tracesMMURI.toString(), tracesMModelName, "", TRACES_FULL_NS , true, false, true, false, true, savingOptions);
	}
	
	private PivotModel createOclStdLibModel() throws QvtMtcExecutionException {
		String oclStdlibName = "OclStdLib";
		return pmUtil.createPivotModel(OCLSTDLIB_URI, oclStdlibName, "", PIVOT_URI, true, false, true, false, true, savingOptions);
	}
}
