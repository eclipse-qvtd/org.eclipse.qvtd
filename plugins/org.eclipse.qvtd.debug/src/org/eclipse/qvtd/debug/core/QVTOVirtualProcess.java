package org.eclipse.qvtd.debug.core;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IStreamsProxy;
import org.eclipse.qvtd.debug.launching.LaunchConstants;
import org.eclipse.qvtd.debug.stubs.QVTODebugUtil;
import org.eclipse.qvtd.debug.utils.QVTODebugCore;
import org.eclipse.qvtd.debug.vm.IQVTOVirtualMachineShell;
import org.eclipse.qvtd.debug.vm.protocol.VMTerminateRequest;

public class QVTOVirtualProcess extends PlatformObject implements IProcess {

	private final ILaunch fLaunch;
	private final IQVTOVirtualMachineShell fVM;
    private IStreamsProxy fStreamsPxy;	
	
	public QVTOVirtualProcess(final ILaunch launch, IQVTOVirtualMachineShell vm) {
		fLaunch = launch;
		fVM = vm;
		fLaunch.addProcess(this);
	}
	
	protected void terminated() {
		DebugPlugin manager = DebugPlugin.getDefault();
		if (manager != null) {
			DebugEvent event = new DebugEvent(this, DebugEvent.TERMINATE);
			manager.fireDebugEventSet(new DebugEvent[]{ event });
		}
	}
	
	public void setStreamsProxy(IStreamsProxy streamsProxy) {
		fStreamsPxy = streamsProxy;
	}
	
    public IStreamsProxy getStreamsProxy() {
    	return fStreamsPxy;
    }	

	public String getLabel() {
		String transformationURI = null;
		ILaunchConfiguration configuration = fLaunch.getLaunchConfiguration();
		if(configuration != null) {
			try {
//				transformationURI = QvtLaunchUtil.getTransformationURI(configuration).toString();
				transformationURI = configuration.getAttribute(LaunchConstants.TX_KEY, "");
			} catch (CoreException e) {
				QVTODebugCore.log(e.getStatus());
			}
		}
		
		return transformationURI != null ? transformationURI : "QVTOProcess"; //$NON-NLS-1$
	}

	public ILaunch getLaunch() {
		return fLaunch;
	}

	public void setAttribute(String key, String value) {
	}

	public String getAttribute(String key) {
		return null;
	}

	public int getExitValue() throws DebugException {
		return 0;
	}

	public boolean isTerminated() {
		return fVM.isTerminated();
	}

	public boolean canTerminate() {
		return !isTerminated();
	}
	
	public void terminate() throws DebugException {
		try {
			fVM.sendRequest(new VMTerminateRequest());
		} catch (IOException e) {
			throw new DebugException(QVTODebugUtil.createDebugError("Process termination Failed", e));
		}			
	}
	
}
