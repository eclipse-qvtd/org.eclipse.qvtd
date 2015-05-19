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
package org.eclipse.qvtd.debug.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.IVMVirtualMachineShell;
import org.eclipse.ocl.examples.debug.vm.core.VMVirtualProcess;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;

public class QVTiVirtualProcess extends VMVirtualProcess
{
	public QVTiVirtualProcess(@NonNull ILaunch launch, @NonNull IVMVirtualMachineShell vm) {
		super(launch, vm);
	}

	public @NonNull String getLabel() {
		String transformationURI = null;
		ILaunchConfiguration configuration = fLaunch.getLaunchConfiguration();
		if(configuration != null) {
			try {
//				transformationURI = QvtLaunchUtil.getTransformationURI(configuration).toString();
				transformationURI = configuration.getAttribute(QVTiLaunchConstants.TX_KEY, "");
			} catch (CoreException e) {
				QVTiDebugCore.INSTANCE.log(e.getStatus());
			}
		}
		
		return transformationURI != null ? transformationURI : "QVTi Process"; //$NON-NLS-1$
	}
}
