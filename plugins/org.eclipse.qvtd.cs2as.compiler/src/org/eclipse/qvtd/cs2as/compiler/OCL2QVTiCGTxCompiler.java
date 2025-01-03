/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler;


import org.apache.commons.logging.Log;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.ocl.xtext.completeocl.CompleteOCLStandaloneSetup;
import org.eclipse.qvtd.compiler.AbstractCompilerOptions;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.cs2as.compiler.internal.CS2ASJavaCompilerImpl;
import org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTiCompilerChain;
import org.eclipse.qvtd.cs2as.compiler.internal.OCL2QVTm;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePivotStandaloneSetup;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.runtime.evaluation.Transformer;
import org.eclipse.qvtd.xtext.qvtimperative.QVTimperativeStandaloneSetup;

public class OCL2QVTiCGTxCompiler implements OCL2JavaTxCompiler<CS2ASJavaCompilerParameters> {

	static {
		CompleteOCLStandaloneSetup.doSetup();
		QVTimperativeStandaloneSetup.doSetup();
		QVTcorePivotStandaloneSetup.doSetup();
	}

	private @Nullable Log log = null;
	private boolean debug = false;

	@Override
	public Class<? extends Transformer> compileTransformation(@Nullable ResourceSet rSet, @NonNull CS2ASJavaCompilerParameters params, @NonNull URI oclDocURI, URI... extendedOCLDocURIs) throws Exception {
		return this.compileTransformation(rSet, params, "ast", oclDocURI);
	}

	@Override
	public Class<? extends Transformer> compileTransformation(@Nullable ResourceSet rSet, @NonNull CS2ASJavaCompilerParameters params, @NonNull String tracePropertyName, @NonNull URI oclDocURI, @NonNull URI... extendedOCLDocURIs)
			throws Exception {

		QVTimperative qvt = QVTimperative.newInstance(BasicProjectManager.CLASS_PATH, rSet);
		try {
			ImperativeTransformation qvtiTransf = executeOCL2QVTi_CompilerChain(qvt, tracePropertyName, oclDocURI, extendedOCLDocURIs);
			CS2ASJavaCompilerImpl compiler = createCompiler();
			compiler.setLog(log);
			return compiler.compileTransformation(qvt, qvtiTransf, params);
		} finally {
			qvt.dispose();
		}
	}

	protected CS2ASJavaCompilerImpl createCompiler() {
		return new CS2ASJavaCompilerImpl();
	}

	protected @NonNull ImperativeTransformation executeOCL2QVTi_CompilerChain(@NonNull QVTimperative qvt, String tracePropName, @NonNull URI oclDocURI, @NonNull URI... extendedOCLDocURIs) throws Exception {

		CompilerOptions options = new AbstractCompilerOptions() {};
		// OCL2QVTm options
		options.setOption(OCL2QVTiCompilerChain.QVTM_STEP, OCL2QVTiCompilerChain.TRACE_PROPERTY_NAME_KEY, tracePropName);
		// QVTs options
		options.setOption(OCL2QVTiCompilerChain.QVTS_STEP, OCL2QVTiCompilerChain.SCHEDULER_DOT_GRAPHS, debug);
		options.setOption(OCL2QVTiCompilerChain.QVTS_STEP, OCL2QVTiCompilerChain.SCHEDULER_YED_GRAPHS, debug);
		// Default options
		options.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, OCL2QVTiCompilerChain.SAVE_OPTIONS_KEY, XMIUtil.createSaveOptions()); // FIXME parametrize save options ?
		options.setOption(OCL2QVTiCompilerChain.DEFAULT_STEP, CompilerChain.DEBUG_KEY, debug);

		OCL2QVTiCompilerChain compilerChain = new OCL2QVTiCompilerChain(qvt, options, oclDocURI, oclDocURI, extendedOCLDocURIs);
		Log log2 = log;
		if (log2 != null) {
			compilerChain.addListener(new CompilerChain.Listener() {

				@Override
				public void compiled(@NonNull String step, @Nullable Object object) {
					if (object instanceof Resource) {
						log2.info(step + " step completed => " + ((Resource)object).getURI());
					}
					else {
						log2.info(step + " step completed => " + object);
					}
				}
			});
		}
		return compilerChain.compile(OCL2QVTm.RIGHT_MODEL_TYPE_NAME);
	}

	public void setLog(@Nullable Log log) {
		this.log  = log;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}
}
