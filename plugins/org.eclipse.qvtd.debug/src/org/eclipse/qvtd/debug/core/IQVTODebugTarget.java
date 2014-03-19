package org.eclipse.qvtd.debug.core;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.ocl.examples.debug.vm.request.VMRequest;
import org.eclipse.ocl.examples.debug.vm.response.VMResponse;
import org.eclipse.qvtd.debug.vm.VMEventListener;

interface IQVTODebugTarget extends IDebugTarget {

	VMResponse sendRequest(VMRequest request) throws DebugException;
	
	void addVMEventListener(VMEventListener listener);
	
	boolean removeVMEventListener(VMEventListener listener);

}