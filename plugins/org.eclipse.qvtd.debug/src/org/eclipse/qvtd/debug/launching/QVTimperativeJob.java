/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
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

import java.io.IOException;
import java.util.Map;

import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.messages.VMMessages;
import org.eclipse.ocl.examples.debug.vm.utils.StreamsProxy;

/**
 * The QVTimperativeJob provides a Job that executes a QVTd transformation.
 * For QVTi, the job executes the *.qvtias directly.
 * For QVTr/c the job executes after a build job has prepared the *.qvtias.
 */
public abstract class QVTimperativeJob extends WorkspaceJob implements IProcess
{
	protected final @NonNull ILaunch launch;
	protected final @NonNull StreamsProxy streamsProxy;
	protected final @NonNull QVTiLaunchConfigurationDelegate launchConfigurationDelegate;
	protected final boolean traceEvaluation;
	protected final Map<String, String> inMap;
	protected final Map<String, String> outMap;
	protected final @NonNull URI txURI;

	protected QVTimperativeJob(@NonNull String jobName, @NonNull QVTiLaunchConfigurationDelegate launchConfigurationDelegate,
			@NonNull ILaunch launch, @NonNull ILaunchConfiguration configuration) throws CoreException {
		super(jobName);
		this.launch = launch;
		this.streamsProxy = new StreamsProxy();
		addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				if (DebugPlugin.getDefault() != null) {
					DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {new DebugEvent(QVTimperativeJob.this, DebugEvent.TERMINATE)});
				}
			}
		});
		this.launchConfigurationDelegate = launchConfigurationDelegate;
		this.traceEvaluation = configuration.getAttribute(QVTiLaunchConfigurationDelegate.TRACE_EVALUATION_KEY, false);
		this.inMap = configuration.getAttribute(QVTiLaunchConfigurationDelegate.NEW_IN_KEY, QVTiLaunchConfigurationDelegate.EMPTY_MAP);
		this.outMap = configuration.getAttribute(QVTiLaunchConfigurationDelegate.NEW_OUT_KEY, QVTiLaunchConfigurationDelegate.EMPTY_MAP);
		this.txURI = launchConfigurationDelegate.getTransformationURI(configuration);
	}

	@Override
	public boolean canTerminate() {
		return !isTerminated();
	}

	@Override
	public String getAttribute(String key) {
		return null;
	}

	@Override
	public int getExitValue() throws DebugException {
		if(!isTerminated()) {
			throw new DebugException(new Status(IStatus.ERROR, getPluginId(), 1, VMMessages.ShallowProcess_InvalidState, null));
		}
		return getResult().getSeverity();
	}

	@Override
	public @NonNull String getLabel() {
		return "";			// In the console heading at least, there is an adequate prefix.
	}

	@Override
	public @NonNull ILaunch getLaunch() {
		return launch;
	}

	protected @NonNull String getPluginId() {
		return launchConfigurationDelegate.getDebugCore().getPluginId();
	}

	@Override
	public StreamsProxy getStreamsProxy() {
		return streamsProxy;
	}

	@Override
	public boolean isTerminated() {
		return getResult() != null;
	}

	/**
	 * noThrow does nothing or rather it provides an override / breakpoint opportunity to handle the failure
	 * to write to the console, which if logged regularly would probably just make a bad situation worse.
	 */
	protected void noThrow(@NonNull IOException e) {}

	@Override
	public void setAttribute(String key, String value) {
	}

	@Override
	public void terminate() throws DebugException {
		cancel();
	}
}