package org.eclipse.qvtd.debug.core;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.qvtd.debug.vm.VMEventListener;
import org.eclipse.qvtd.debug.vm.protocol.VMRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMResponse;

interface IQVTODebugTarget extends IDebugTarget {

	VMResponse sendRequest(VMRequest request) throws DebugException;
	
	void addVMEventListener(VMEventListener listener);
	
	boolean removeVMEventListener(VMEventListener listener);

}