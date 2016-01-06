/*******************************************************************************
 * Copyright (c) 2014 Willink Transformations and others.
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
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.core.OCLDebugCore;
import org.eclipse.ocl.examples.debug.vm.IVMVirtualMachineShell;
import org.eclipse.ocl.examples.debug.vm.core.VMVirtualProcess;
import org.eclipse.ocl.examples.debug.vm.launching.DebuggableRunner;
import org.eclipse.ocl.examples.debug.vm.launching.DebuggableRunnerFactory;
import org.eclipse.ocl.examples.debug.vm.launching.VMLaunchConfigurationDelegate;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;
import org.eclipse.qvtd.debug.core.QVTiDebugTarget;
import org.eclipse.qvtd.debug.core.QVTiEvaluationContext;
import org.eclipse.qvtd.debug.core.QVTiVirtualProcess;
import org.eclipse.qvtd.debug.vm.QVTiVMVirtualMachine;

public class QVTiVMLaunchConfigurationDelegate extends VMLaunchConfigurationDelegate<QVTiEvaluationContext> implements QVTiLaunchConstants
{
	public static final IStatus MODIFIED_SOURCE_STATUS = QVTiDebugCore.INSTANCE.createError("", 300, null); //$NON-NLS-1$

	protected @NonNull QVTiDebugTarget createDebugTarget(@NonNull IVMVirtualMachineShell vm, @NonNull VMVirtualProcess process) {
		return new QVTiDebugTarget(process, vm);
	}

	protected @NonNull DebuggableRunnerFactory createDebuggableRunnerFactory(EPackage.@NonNull Registry packageRegistry,
			@NonNull List<String> modelURIs, @Nullable String traceURI) {
		return new QVTiDebuggableRunnerFactory(packageRegistry, modelURIs, null);
	}
	
	protected @NonNull QVTiEvaluationContext createEvaluationContext(@NonNull ILaunchConfiguration configuration) throws CoreException {
		String txName = configuration.getAttribute(TX_KEY, "");
		@SuppressWarnings("null")@NonNull URI txURI = URI.createURI(txName, true);
		Map<String, String> inMap = configuration.getAttribute(IN_KEY, EMPTY_MAP);
		Map<String, URI> inURIMap = new HashMap<String, URI>();
		for (Map.Entry<String, String> inEntry : inMap.entrySet()) {
			inURIMap.put(inEntry.getKey(), URI.createURI(inEntry.getValue(), true));
		}
		Map<String, String> outMap = configuration.getAttribute(OUT_KEY, EMPTY_MAP);
		Map<String, URI> outURIMap = new HashMap<String, URI>();
		for (Map.Entry<String, String> outEntry : outMap.entrySet()) {
			outURIMap.put(outEntry.getKey(), URI.createURI(outEntry.getValue(), true));
		}
		return new QVTiEvaluationContext(txURI, inURIMap, outURIMap);
	}

	protected @NonNull QVTiVMVirtualMachine createVirtualMachine(@NonNull QVTiEvaluationContext evaluationContext, @NonNull DebuggableRunner runner) {
		return new QVTiVMVirtualMachine(runner, evaluationContext);
	}

	protected @NonNull QVTiVirtualProcess createVirtualProcess(@NonNull ILaunch launch, @NonNull IVMVirtualMachineShell vm) {
		return new QVTiVirtualProcess(launch, vm);
	}

	@Override
	protected @NonNull OCLDebugCore getDebugCore() {
		return OCLDebugCore.INSTANCE;
	}
}