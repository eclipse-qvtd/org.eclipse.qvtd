package org.eclipse.qvtd.debug.core;

import org.eclipse.debug.core.model.IProcess;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.core.VMDebugTarget;
import org.eclipse.ocl.examples.debug.vm.IVMVirtualMachineShell;
import org.eclipse.qvtd.debug.utils.QVTiDebugCore;

public class QVTiDebugTarget extends VMDebugTarget
{
	public QVTiDebugTarget(IProcess process, IVMVirtualMachineShell vm) {
		super(process, vm);
	}

	public @NonNull QVTiDebugCore getDebugCore() {
		return QVTiDebugCore.INSTANCE;
	}
	
	public @NonNull String getModelIdentifier() {
		return getDebugCore().getModelId();
	}
}
