/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.ocl.pivot.utilities.XMIUtil;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;
import org.eclipse.qvtd.debug.evaluator.BasicQVTrExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;

public class QVTrLaunchConfigurationDelegate extends QVTiLaunchConfigurationDelegate implements QVTcLaunchConstants
{
	@Override
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		String projectName = configuration.getAttribute(PROJECT_KEY, "");
		if (projectName == null) {
			throw QVTiDebugPlugin.newCoreExceptionError("No default project", null);
		}
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
		QVTcoreStandaloneSetup.class.getName();			// QVTrCompilerChain doesn't initialize QVTc
		CompilerChain compilerChain = new QVTrCompilerChain(environmentFactory, txURI, null);
		compilerChain.setOption(CompilerChain.DEFAULT_STEP, CompilerChain.SAVE_OPTIONS_KEY, XMIUtil.createSaveOptions());
		Map<String, String> intermediatesMap = configuration.getAttribute(INTERMEDIATES_KEY, EMPTY_MAP);
		String genmodelAttribute = configuration.getAttribute(GENMODEL_KEY, "");
		compilerChain.setOption(CompilerChain.QVTC_STEP, CompilerChain.URI_KEY, URI.createURI(intermediatesMap.get(CompilerChain.QVTC_STEP), true));
		compilerChain.setOption(CompilerChain.QVTU_STEP, CompilerChain.URI_KEY, URI.createURI(intermediatesMap.get(CompilerChain.QVTU_STEP), true));
		compilerChain.setOption(CompilerChain.QVTM_STEP, CompilerChain.URI_KEY, URI.createURI(intermediatesMap.get(CompilerChain.QVTM_STEP), true));
		compilerChain.setOption(CompilerChain.QVTS_STEP, CompilerChain.URI_KEY, URI.createURI(intermediatesMap.get(CompilerChain.QVTS_STEP), true));
		compilerChain.setOption(CompilerChain.QVTI_STEP, CompilerChain.URI_KEY, URI.createURI(intermediatesMap.get(CompilerChain.QVTI_STEP), true));
		compilerChain.setOption(CompilerChain.GENMODEL_STEP, CompilerChain.URI_KEY, URI.createURI(genmodelAttribute, true));

		Map<@NonNull String, @Nullable String> genModelOptions = new HashMap<@NonNull String, @Nullable String>();
		genModelOptions.put(CompilerChain.GENMODEL_BASE_PREFIX, projectName);
		//		genModelOptions.put(CompilerChain.GENMODEL_COPYRIGHT_TEXT, "Copyright (c) 2015, 2016 Willink Transformations and others.\n;All rights reserved. This program and the accompanying materials\n;are made available under the terms of the Eclipse Public License v1.0\n;which accompanies this distribution, and is available at\n;http://www.eclipse.org/legal/epl-v10.html\n;\n;Contributors:\n;  E.D.Willink - Initial API and implementation");
		//		compilerChain.setOption(CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_USED_GENPACKAGES_KEY, usedGenPackages);
		compilerChain.setOption(CompilerChain.GENMODEL_STEP, CompilerChain.GENMODEL_OPTIONS_KEY, genModelOptions);
		try {
			if (interpreted) {
				compilerChain.setOption(CompilerChain.JAVA_STEP, CompilerChain.URI_KEY, null);
				compilerChain.setOption(CompilerChain.CLASS_STEP, CompilerChain.URI_KEY, null);
				compilerChain.compile(outputName);
			}
			else {
				compilerChain.setOption(CompilerChain.JAVA_STEP, CompilerChain.URI_KEY, URI.createURI(intermediatesMap.get(CompilerChain.JAVA_STEP), true));
				compilerChain.setOption(CompilerChain.CLASS_STEP, CompilerChain.URI_KEY, URI.createURI(intermediatesMap.get(CompilerChain.CLASS_STEP), true));

				compilerChain.build(outputName);
			}
		} catch (Exception e) {
			throw QVTiDebugPlugin.newCoreExceptionError("Failed to compile transformation '" + txURI + "'", e);
		}
		return super.buildForLaunch(configuration, mode, monitor);		// FIXME override with the progress monitor
	}

	@Override
	protected @NonNull QVTiExecutor createExecutor(@NonNull QVTiEnvironmentFactory envFactory, @NonNull ImperativeTransformation transformation) {
		return new BasicQVTrExecutor(envFactory, transformation);
	}

	@Override
	protected @NonNull QVTiDebugCore getDebugCore() {
		return QVTiDebugCore.INSTANCE;				// FIXME QVTrDebugCore with back-traceability
	}

	@Override
	protected @NonNull URI getTransformationURI(final ILaunchConfiguration configuration) throws CoreException {
		Map<String, String> intermediatesMap = configuration.getAttribute(INTERMEDIATES_KEY, EMPTY_MAP);
		String qvtiName = intermediatesMap.get(CompilerChain.QVTI_STEP);
		return URI.createURI(qvtiName, true);
	}
}
