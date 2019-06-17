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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.utils.MiscUtil;
import org.eclipse.qvtd.compiler.CompilerChain;
import org.eclipse.qvtd.compiler.DefaultCompilerOptions;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiExecutor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiIncrementalExecutor;
import org.eclipse.qvtd.runtime.evaluation.ModeFactory;
import org.eclipse.qvtd.runtime.evaluation.Transformer;

public class QVTiLaunchConfigurationDelegate extends LaunchConfigurationDelegate implements QVTiLaunchConstants
{
	public static final @NonNull String @NonNull [] compileStepKeys = new @NonNull String[] {
		CompilerChain.QVTI_STEP
	};

	public static final @NonNull String @NonNull [] generateStepKeys = new @NonNull String[] {
		CompilerChain.JAVA_STEP,
		CompilerChain.CLASS_STEP
	};

	protected static final int LAUNCH_ERROR_CODE = 210;
	protected static final IStatus fgLaunchErrorStatus = new Status(IStatus.ERROR, QVTiDebugPlugin.PLUGIN_ID, LAUNCH_ERROR_CODE, "Launch configuration error", null); //$NON-NLS-1$

	/**
	 * The Transformation class, if the build for launch identifies a CGed class.
	 */
	protected @Nullable Class<? extends Transformer> txClass = null;

	protected @NonNull DefaultCompilerOptions createCompilerOptions() {
		return new DefaultCompilerOptions();
	}

	protected @NonNull QVTiExecutor createExecutor(@NonNull QVTiEnvironmentFactory envFactory, @NonNull ImperativeTransformation transformation) {
		return new QVTiIncrementalExecutor(envFactory, transformation, ModeFactory.LAZY);
	}

	protected @NonNull QVTiDebugCore getDebugCore() {
		return QVTiDebugCore.INSTANCE;
	}

	protected @NonNull URI getTransformationURI(final ILaunchConfiguration configuration) throws CoreException {
		String txName = configuration.getAttribute(TX_KEY, "");		// FIXME Change to intermediate - same as QVTc/QVTr
		return URI.createURI(txName, true);
	}

	@Override
	public void launch(final ILaunchConfiguration configuration, String mode, final ILaunch launch, IProgressMonitor monitor) throws CoreException {
		assert launch !=null;
		assert configuration !=null;
		try {
			QVTimperativeJob executionJob;
			if (txClass != null) {
				executionJob = new QVTcompiledJob(this, launch, configuration, txClass);
			}
			else {
				executionJob = new QVTinterpretedJob(this, launch, configuration);
			}
			launch.addProcess(executionJob);
			executionJob.schedule();
		}
		catch(Exception e) {
			throw new CoreException(MiscUtil.makeErrorStatus(e));
		}
	}
}

