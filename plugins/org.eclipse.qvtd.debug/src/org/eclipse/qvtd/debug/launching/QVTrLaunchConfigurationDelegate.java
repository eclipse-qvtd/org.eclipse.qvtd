/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.launching;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.resource.BasicProjectManager;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.compiler.QVTrCompilerChain;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;
import org.eclipse.qvtd.debug.evaluator.BasicQVTrExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperative;
import org.eclipse.qvtd.xtext.qvtcore.QVTcoreStandaloneSetup;

public class QVTrLaunchConfigurationDelegate extends QVTiLaunchConfigurationDelegate implements QVTcLaunchConstants
{
	public static final @NonNull String @NonNull [] compileStepKeys = new @NonNull String[] {
		CompilerChain.QVTR_STEP,
		CompilerChain.TRACE_STEP,
		//	CompilerChain.QVTC_STEP,
		//	CompilerChain.QVTU_STEP,
		//	CompilerChain.QVTM_STEP,
		CompilerChain.QVTS_STEP,
		CompilerChain.QVTI_STEP
	};

	public static final @NonNull String @NonNull [] generateStepKeys = new @NonNull String[] {
		CompilerChain.GENMODEL_STEP,
		CompilerChain.JAVA_STEP,
		CompilerChain.CLASS_STEP
	};

	@Override
	public boolean buildForLaunch(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		String projectName = configuration.getAttribute(PROJECT_KEY, "");
		if (projectName == null) {
			QVTiDebugPlugin.throwCoreExceptionError("No default project", null);
			return false;
		}
		String txName = configuration.getAttribute(TX_KEY, (String)null);
		if (txName == null) {
			QVTiDebugPlugin.throwCoreExceptionError("No transformation to compile", null);
			return false;
		}
		URI txURI = URI.createURI(txName);
		String outputName = configuration.getAttribute(DIRECTION_KEY, (String)null);
		if (outputName == null) {
			QVTiDebugPlugin.throwCoreExceptionError("No output direction for '" + txURI + "'", null);
			return false;
		}
		List<@NonNull TypedModelsConfiguration> typedModelsConfigurations = new ArrayList<>();
		typedModelsConfigurations.add(new TypedModelsConfiguration(outputName));
		boolean interpreted = configuration.getAttribute(INTERPRETED_KEY, true);
		boolean dotGraphs = configuration.getAttribute(DOT_GRAPHS_KEY, true);
		boolean yedGraphs = configuration.getAttribute(YED_GRAPHS_KEY, true);
		//
		QVTimperative qvt = QVTimperative.newInstance(BasicProjectManager.CLASS_PATH, null);
		QVTiEnvironmentFactory environmentFactory = qvt.getEnvironmentFactory();
		QVTcoreStandaloneSetup.class.getName();			// QVTrCompilerChain doesn't initialize QVTc
		DefaultCompilerOptions compilerOptions = createCompilerOptions();
		Map<String, String> intermediatesMap = configuration.getAttribute(INTERMEDIATES_KEY, EMPTY_MAP);
		assert intermediatesMap != null;
		compilerOptions.setURIsFromStrings(compileStepKeys, intermediatesMap);
		compilerOptions.setDebugGraphs(dotGraphs, yedGraphs);
		if (!interpreted) {
			try {
				URI genModelURI = URI.createURI(intermediatesMap.get(CompilerChain.GENMODEL_STEP), true);
				URI javaURI = URI.createURI(intermediatesMap.get(CompilerChain.JAVA_STEP), true);
				URI classURI = URI.createURI(intermediatesMap.get(CompilerChain.CLASS_STEP), true);
				compilerOptions.setQVTrGenerateOptions(projectName, txURI, genModelURI, javaURI, classURI);
			} catch (Exception e) {
				QVTiDebugPlugin.throwCoreExceptionError("Failed to configure transformation '" + txURI + "'", e);
				return false;
			}
		}
		CompilerChain compilerChain = new QVTrCompilerChain(environmentFactory, txURI, txURI, compilerOptions);
		try {
			if (interpreted) {
				compilerChain.compile(typedModelsConfigurations);
			}
			else {
				txClass = compilerChain.build(typedModelsConfigurations);
			}
		} catch (Exception e) {
			QVTiDebugPlugin.throwCoreExceptionError("Failed to compile transformation '" + txURI + "'", e);
			return false;
		}
		return super.buildForLaunch(configuration, mode, monitor);		// FIXME override with the progress monitor
	}

	@Override
	protected @NonNull QVTiExecutor createExecutor(@NonNull QVTiEnvironmentFactory envFactory, @NonNull EntryPoint entryPoint) {
		return new BasicQVTrExecutor(envFactory, entryPoint);
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
