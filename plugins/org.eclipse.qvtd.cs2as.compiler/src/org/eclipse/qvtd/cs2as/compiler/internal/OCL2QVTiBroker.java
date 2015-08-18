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
package org.eclipse.qvtd.cs2as.compiler.internal;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
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
	
	private static final String OCL2QVTP_MIDDLE_MODEL = "etl/ocl2qvtp.etl";
	
	private static final String OCL2QVTP_MIDDLE_FOLDED = "etl/ocl2qvtp_v2.etl";

	private static final String OCLSTDLIB_URI = "http://www.eclipse.org/ocl/2015/Library.oclas";
	
	private static final String ECORE_URI = "http://www.eclipse.org/emf/2002/Ecore";
	
	private static final String PIVOT_URI = "http://www.eclipse.org/ocl/2015/Pivot";
	
	private static final String QVTB_URI ="http://www.eclipse.org/qvt/2015/QVTbase";
	
	private static final String QVTCB_URI = "http://www.eclipse.org/qvt/2015/QVTcoreBase";
	
	private static final String QVTI_URI = "http://www.eclipse.org/qvt/2015/QVTimperative";
		
	private static final String QVTI_FULL_NS = QVTI_URI + ',' + QVTCB_URI + ',' +  QVTB_URI + ',' +  PIVOT_URI;
	
	private static final String TRACES_FULL_NS = PIVOT_URI + ',' + ECORE_URI;
	
	private @NonNull List<URI> oclASUris = new ArrayList<URI>();	
	private @Nullable List<URI> tracesASUris = new ArrayList<URI>();
	private @Nullable List<URI> qvtpUris = new ArrayList<URI>();
	private @NonNull PivotModelUtil pmUtil;
	private @Nullable String traceabilityPropName;

	/**
	 * @param baseURI the base {@link URI} on which the OCL document resides
	 * @param oclDocName the name of the OCL document (e.g myCS2AS.ocl)
	 * @param ocl an {@link OCL} instance to parse the OCL document
	 * @param savingOptions some optional savingOptions
	 * @throws Exception
	 */
	public OCL2QVTiBroker(@NonNull URI baseURI, @NonNull String oclDocName, @NonNull OCL ocl, @Nullable Map<?, ?> savingOptions )
		throws Exception {
		this(baseURI,  Collections.singletonList(oclDocName), ocl, savingOptions);
	}	

	/**
	 * @param baseURI the base {@link URI} on which the OCL document resides
	 * @param oclDocName the name of the OCL document (e.g myCS2AS.ocl)
	 * @param ocl an {@link OCL} instance to parse the OCL document
	 * @param savingOptions some optional savingOptions
	 * @param usesMiddleFoldedInInputs true if the generated QVTp transformation should use middle folded in inputs approach
	 * @param traceabilityPropName the name of the traceability property of CS elements (when using middleFoldedInInputs)
	 * @throws Exception
	 */
	public OCL2QVTiBroker(@NonNull URI baseURI, @NonNull String oclDocName, @NonNull OCL ocl, @Nullable Map<?, ?> savingOptions,
			boolean usesMiddleFoldedInInputs, @Nullable String traceabilityPropName)
		throws Exception {
		
		this(baseURI, Collections.singletonList(oclDocName),  ocl, savingOptions, usesMiddleFoldedInInputs, traceabilityPropName);
		
	}
	
	
	public OCL2QVTiBroker(@NonNull URI baseURI, @NonNull List<String> oclDocs, @NonNull OCL ocl, @Nullable Map<?, ?> savingOptions )
			throws Exception {
			this(baseURI, oclDocs, ocl, savingOptions, true, "ast");
	}	
	public OCL2QVTiBroker(@NonNull URI baseURI, @NonNull List<String> oclDocs, @NonNull OCL ocl, @Nullable Map<?, ?> savingOptions,
			boolean usesMiddleFoldedInInputs, @Nullable String traceabilityPropName)
		throws Exception {
		
		super(baseURI, oclDocs.get(0),  ocl.getEnvironmentFactory(), savingOptions);
		this.pmUtil = new PivotModelUtil( ocl.getEnvironmentFactory());
		for (String oclDocName : oclDocs) {
			URI oclDocUri = baseURI.appendSegment(oclDocName);
			URI oclASUri = ocl.parse(oclDocUri).getURI();
			URI modelsBaseURI = oclASUri.trimFileExtension().trimFileExtension();
			this.oclASUris.add(oclASUri);
			this.qvtpUris.add(modelsBaseURI.appendFileExtension("qvtp.qvtias"));
			if (!usesMiddleFoldedInInputs) {
				this.tracesASUris.add(modelsBaseURI.appendFileExtension("ecore.oclas"));
			}
		}
		this.traceabilityPropName = traceabilityPropName;
	}
	@Override
	public void execute() throws QvtMtcExecutionException {
		
		pModel = prepareQVTpModel();
		
		prepare();
		sModel = qvtpToQvts(pModel);
		qvtpFlatScheduling(pModel, sModel);
		// qvtpNestingScheduling(pModel, sModel);
		if (createGraphml) {
			qvtsToGraphML(sModel);
		}
		iModel = qvtpQvtsToQvti(pModel, sModel);
	}
	

	@Override
	public Resource newExecute() throws QvtMtcExecutionException {
		pModel = prepareQVTpModel();
		
		prepare();
		try {
			iResource = qvtp2qvti(true);
		} catch (QvtMtcExecutionException e) {
			throw e;
		} catch (IOException e) {
			throw new QvtMtcExecutionException("Failed to create regions", e);
		}
		return iResource;
	}
	
	
	protected PivotModel prepareQVTpModel() throws QvtMtcExecutionException {
				
		List<PivotModel> qvtpModels = new ArrayList<PivotModel>();
		PivotModel resultingPModel = null;
		for (int i = 0; i < oclASUris.size() ; i++) {
			URI oclASUri = oclASUris.get(i);
			PivotModel pModel = (tracesASUris.isEmpty())	? runOCL2QVTp_MiddleFolded(oclASUri, qvtpUris.get(i), traceabilityPropName) 
					: runOCL2QVTp_MiddleModel(oclASUri, qvtpUris.get(i), tracesASUris.get(i));
			qvtpModels.add(pModel);
		}
		if (qvtpModels.size() > 1) {
			resultingPModel = QVTpModelsMerger.merge(environmentFactory , qvtpModels);
			resultingPModel.store();
			// unload unnecessary qvtpModels
			for(PivotModel qvtpModel : qvtpModels) {
				if (qvtpModel != resultingPModel) {
					qvtpModel.getResource().unload();
				}
			}
		}	else {
			resultingPModel = qvtpModels.get(0);
		}
		assertNoResourceErrors("pModel", resultingPModel.getResource());
		return resultingPModel;
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
		return runOCL2QVTp_MiddleFolded(oclDocURI, qvtiFileURI, "ast");
	}
	
	protected PivotModel runOCL2QVTp_MiddleFolded (URI oclDocURI, URI qvtiFileURI, String traceabilityPropName) throws QvtMtcExecutionException {

		try {
			List<Variable> txVariables = new ArrayList<Variable>();
			txVariables.add(new Variable("traceabilityPropName", traceabilityPropName, EolPrimitiveType.String));
			txVariables.add(new Variable("oclDocURI", oclDocURI.toString(), EolPrimitiveType.String));
			EtlTask etl = new EtlTask(OCL2QVTiBroker.class.getResource(OCL2QVTP_MIDDLE_FOLDED).toURI());
			pModel= createQVTpModel(qvtiFileURI);
			etl.addModel(createOCLModel(oclDocURI));
			etl.addModel(pModel);
			etl.addModel(createOclStdLibModel());
			etl.execute(txVariables);

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
