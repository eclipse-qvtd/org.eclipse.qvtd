/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler;



import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.tx.Transformer;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.qvtd.compiler.internal.etl.PivotModel;
import org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerImpl;
import org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTiBroker;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;

public class OCL2QVTiCGTxCompiler implements OCL2JavaTxCompiler<CS2ASJavaCompilerParameters> {

	static {
		CompleteOCLStandaloneSetup.doSetup();
		QVTimperativeStandaloneSetup.doSetup();
	}
		
	@Override
	public Class<? extends Transformer> compileTransformation(@NonNull URI oclDocURI, @NonNull CS2ASJavaCompilerParameters params, @Nullable ResourceSet rSet) throws Exception {
		
		return this.compileTransformation(oclDocURI, params, rSet, "ast");
	}
	
	@Override
	public Class<? extends Transformer> compileTransformation(@NonNull URI oclDocURI, @NonNull CS2ASJavaCompilerParameters params, @Nullable ResourceSet rSet, @NonNull String tracePropertyName) throws Exception {
		
		QVTimperative qvt = QVTimperative.newInstance(BasicProjectManager.CLASS_PATH, rSet);
		try {
			PivotModel qvtiTransf = executeOCL2QVTi_MTC(qvt, oclDocURI.trimSegments(1), oclDocURI.lastSegment(), tracePropertyName);
			return createCompiler().compileTransformation(qvt, qvtiTransf.getTransformation(), (CS2ASJavaCompilerParameters) params);	
		} finally {
			qvt.dispose();	
		}
	}
	
	protected CS2ASJavaCompilerImpl createCompiler() {
		return new CS2ASJavaCompilerImpl();
	}
		
	/**
	 * @param ocl
	 * @param baseURI
	 * @param oclDocName
	 * @param tracePropName the name of the CS2AS traceability property
	 * @return the {@link PivotModel} corresponding to the final QVTi transformation
	 * @throws Exception
	 */
	protected PivotModel executeOCL2QVTi_MTC(OCL ocl, URI baseURI, String oclDocName, String tracePropName) throws Exception {
		
		// FIXME Map<?, ?> savingOptions = this.savingOptions == null ? XMIUtil.createSaveOptions() : this.savingOptions;
		OCL2QVTiBroker mtc = new OCL2QVTiBroker(baseURI, oclDocName, ocl, null, true, tracePropName);
    	mtc.execute();
    	return mtc.getiModel();
	}
}
