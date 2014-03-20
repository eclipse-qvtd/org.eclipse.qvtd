package org.eclipse.qvtd.debug.core;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.core.VMVirtualProcess;
import org.eclipse.ocl.examples.debug.vm.IVMVirtualMachineShell;
import org.eclipse.qvtd.debug.launching.QVTiLaunchConstants;
import org.eclipse.qvtd.debug.utils.QVTiDebugCore;

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
				QVTiDebugCore.log(e.getStatus());
			}
		}
		
		return transformationURI != null ? transformationURI : "QVTi Process"; //$NON-NLS-1$
	}
}
