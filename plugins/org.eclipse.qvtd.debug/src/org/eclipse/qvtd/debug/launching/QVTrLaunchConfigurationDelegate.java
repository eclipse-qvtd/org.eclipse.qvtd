/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.launching;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;
import org.eclipse.qvtd.debug.evaluator.BasicQVTrExecutor;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;

public class QVTrLaunchConfigurationDelegate extends QVTiLaunchConfigurationDelegate implements QVTcLaunchConstants
{ 
	@Override
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		String txName = configuration.getAttribute(TX_KEY, (String)null);
		if (txName == null) {
			throw QVTiDebugPlugin.newCoreExceptionError("No transformation to compile", null);
		}
		URI txURI = URI.createURI(txName);
		String outputName = configuration.getAttribute(DIRECTION_KEY, (String)null);
		if (outputName == null) {
			throw QVTiDebugPlugin.newCoreExceptionError("No output direction for '" + txURI + "'", null);
		}
		Boolean interpreted = configuration.getAttribute(INTERPRETED_KEY, true);
		//
		QVTimperative qvt = QVTimperative.newInstance(BasicProjectManager.CLASS_PATH, null);
		QVTiEnvironmentFactory environmentFactory = qvt.getEnvironmentFactory();
		CompilerChain compilerChain = new QVTrCompilerChain(environmentFactory, txURI, null);
		compilerChain.setOption(CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, XMIUtil.createSaveOptions());
		try {
			if (interpreted) {
				compilerChain.compile(outputName);
			}
			else {
				compilerChain.build(outputName);
			}
		} catch (Exception e) {
			throw QVTiDebugPlugin.newCoreExceptionError("Failed to compile transformation '" + txURI + "'", e);
		}
		return super.buildForLaunch(configuration, mode, monitor);		// FIXME override with the progress monitor
	}

	protected @NonNull QVTiExecutor createExecutor(@NonNull QVTiEnvironmentFactory envFactory, @NonNull Transformation transformation) {
		return new BasicQVTrExecutor(envFactory, transformation);
	}

	protected @NonNull QVTiDebugCore getDebugCore() {
		return QVTiDebugCore.INSTANCE;				// FIXME QVTrDebugCore with back-traceability
	}

	protected @NonNull URI getTransformationURI(final ILaunchConfiguration configuration) throws CoreException {
		Map<String, String> intermediatesMap = configuration.getAttribute(INTERMEDIATES_KEY, EMPTY_MAP);
		String qvtiName = intermediatesMap.get(CompilerChain.QVTI_STEP);
		return URI.createURI(qvtiName, true);
	}
}
