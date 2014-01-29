package org.eclipse.qvtd.debug.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.IBreakpointManager;
import org.eclipse.debug.core.IBreakpointManagerListener;
import org.eclipse.debug.core.IDebugEventSetListener;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.IStatusHandler;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.emf.common.util.URI;
import org.eclipse.qvtd.debug.evaluator.DebugQVTiEvaluationVisitor;
import org.eclipse.qvtd.debug.stubs.DebugOptions;
import org.eclipse.qvtd.debug.stubs.QVTODebugUtil;
import org.eclipse.qvtd.debug.utils.QVTODebugCore;
import org.eclipse.qvtd.debug.vm.IQVTOVirtualMachineShell;
import org.eclipse.qvtd.debug.vm.QVTOVirtualMachine;
import org.eclipse.qvtd.debug.vm.VMEventListener;
import org.eclipse.qvtd.debug.vm.protocol.NewBreakpointData;
import org.eclipse.qvtd.debug.vm.protocol.VMBreakpointRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMBreakpointResponse;
import org.eclipse.qvtd.debug.vm.protocol.VMDisconnectEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMResponse;
import org.eclipse.qvtd.debug.vm.protocol.VMResumeEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMResumeRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMStartEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMStartRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMSuspendEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMSuspendRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMTerminateEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMTerminateRequest;

public class QVTODebugTarget extends QVTODebugElement implements IQVTODebugTarget, IDebugEventSetListener, IBreakpointManagerListener {

	private final Map<Long, QVTOBreakpoint> fID2Breakpoint = new HashMap<Long, QVTOBreakpoint>();

	private final ILaunch fLaunch;

	private final IProcess fProcess;

	private QVTOThread fMainThread;
	
	private String fMainModuleName;

	private boolean fIsStarting;
	private boolean fIsSuspended = false;

	private final IQVTOVirtualMachineShell fVM;
	private final List<VMEventListener> fEventListener = new LinkedList<VMEventListener>();

	private final Object fVMStartMonitor = new Object();

	public QVTODebugTarget(IProcess process, IQVTOVirtualMachineShell vm) {
		super(null);

		fLaunch = process.getLaunch();
		fProcess = process;
		fVM = vm;
		fIsStarting = true;
		fEventListener.add(createVMEventListener());

		EventDispatchJob dispatcher = new EventDispatchJob();
		Thread eventDispatherThread = new Thread(dispatcher, "QVTi Debug"); //$NON-NLS-1$			
		eventDispatherThread.setDaemon(true);
		eventDispatherThread.start();

		try {
			// start transformation execution				
			sendRequest(new VMStartRequest());
		} catch (DebugException e) {
			QVTODebugCore.log(e.getStatus());
			// FIXME - consult status handler to give UI feedback
			return;
		}
		
		joinStartOrTerminate();
		// Note: VM is still suspended and waiting for resume
		// => do whatever initialization we need now
		// install VM breakpoints
		installVMBreakpoints();
		
		DebugEvent createEvent = new DebugEvent(this, DebugEvent.CREATE);
		createEvent.setData(new HashMap<Long, QVTOBreakpoint>(fID2Breakpoint));

		fMainThread = new QVTOThread(this);
		fLaunch.addDebugTarget(this);
		System.setProperty(QVTODebugCore.DEBUGGER_ACTIVE_PROPERTY, Boolean.TRUE.toString());		

		try {
			// wake up so far suspended VM
			fVM.sendRequest(new VMResumeRequest(0));
		} catch (IOException e) {
			QVTODebugCore.log(e);
		}
		
		IBreakpointManager breakpointManager = DebugPlugin.getDefault().getBreakpointManager();
		breakpointManager.addBreakpointManagerListener(this);
		breakpointManager.addBreakpointListener(this);
		DebugPlugin.getDefault().addDebugEventListener(this);

		fireEvent(createEvent);
	}

	protected URI computeBreakpointURI(URI sourceURI) {
		return sourceURI;
	}
	
	private void installVMBreakpoints() {
		HashMap<Long, QVTOBreakpoint> installedBreakpoints = new HashMap<Long, QVTOBreakpoint>();
		List<NewBreakpointData> allBpData = new ArrayList<NewBreakpointData>();
		
		for (QVTOBreakpoint qvtBp : QVTODebugCore.getQVTOBreakpoints(QVTOBreakpoint.class)) {
			boolean enabled = false;
			try {
				enabled = qvtBp.isEnabled();
			} catch (CoreException e) {
				QVTODebugCore.log(e.getStatus());
			}

			if (enabled) {
				installedBreakpoints.put(new Long(((QVTOBreakpoint) qvtBp).getID()),
						qvtBp);
				try {
					NewBreakpointData data = qvtBp.createNewBreakpointData();
					data.targetURI = computeBreakpointURI(URI.createURI(data.targetURI, true)).toString();
					
					allBpData.add(data);
				} catch (CoreException e) {
					QVTODebugCore.log(e.getStatus());
				}
			}
		}

		if (!allBpData.isEmpty()) {
			VMBreakpointRequest breakpointRequest = VMBreakpointRequest
					.createAdd(allBpData
							.toArray(new NewBreakpointData[allBpData.size()]));
			try {
				VMResponse response = fVM.sendRequest(breakpointRequest);
				// 
				fID2Breakpoint.clear();
				if(response instanceof VMBreakpointResponse) {
					VMBreakpointResponse bpResponse = (VMBreakpointResponse) response;
					
					for(long addedID : bpResponse.getAddedBreakpointsIDs()) {
						Long key = new Long(addedID);
						QVTOBreakpoint bp = installedBreakpoints.get(key);
						if(bp != null) {
							fID2Breakpoint.put(key, bp);
						}
					}
				}
			} catch (IOException e) {
				QVTODebugCore.log(e);
			}
		}
	}
	
	public Collection<? extends IBreakpoint> getInstalledBreakpoints() {
		return Collections.unmodifiableCollection(fID2Breakpoint.values());
	}

	public VMResponse sendRequest(VMRequest request) throws DebugException {
		try {
			VMResponse response = fVM.sendRequest(request);
			if (DebugQVTiEvaluationVisitor.VM_RESPONSE.isActive()) {
				DebugQVTiEvaluationVisitor.VM_RESPONSE.println("[" + Thread.currentThread().getName() + "] " + response.toString());
			}
			return response;
		} catch (IOException e) {
			throw new DebugException(QVTODebugUtil.createDebugError(
					"Send debug request failed", e));
		}
	}

	public synchronized boolean isSuspended() {
		return !isTerminated() && fIsSuspended;
	}

	@Override
	public IDebugTarget getDebugTarget() {
		return this;
	}

	@Override
	public ILaunch getLaunch() {
		return fLaunch;
	}

	public IQVTOVirtualMachineShell getVM() {
		return fVM;
	}

	public IProcess getProcess() {
		IProcess[] processes = getLaunch().getProcesses();
		if (processes != null && processes.length > 0) {
			return processes[0];
		}

		return null;
	}

	public boolean hasThreads() throws DebugException {
		return !isTerminated();
	}

	public IThread[] getThreads() throws DebugException {
		return (fMainThread != null) ? new IThread[] { fMainThread }
				: new IThread[0];
	}

	public String getName() throws DebugException {
		return "QVTO Debug target";
	}

	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return breakpoint.getModelIdentifier().equals(getModelIdentifier());
	}

	public boolean canTerminate() {
		return !isTerminated();
	}

	public boolean isTerminated() {
		return fVM.isTerminated();
	}

	public void terminate() throws DebugException {
		sendRequest(new VMTerminateRequest());
	}

	protected void started(String mainModuleName) {
		setMainModuleName(mainModuleName);
		setStarting(false);		
	}
		
	synchronized protected void setMainModuleName(String mainModuleName) {
		fMainModuleName = mainModuleName;
	}
	
	synchronized public String getMainModuleName() {
		return fMainModuleName;
	}
		
	protected void terminated() {
		QVTODebugCore.TRACE.trace(DebugOptions.TARGET, "Debug target terminated"); //$NON-NLS-1$
		System.setProperty(QVTODebugCore.DEBUGGER_ACTIVE_PROPERTY, Boolean.FALSE.toString());		

		setStarting(false);
		
		fMainThread = null;

		DebugPlugin debugPlugin = DebugPlugin.getDefault();
		if (debugPlugin != null) {
			IBreakpointManager breakpointManager = debugPlugin.getBreakpointManager();
			breakpointManager.removeBreakpointListener(this);
			breakpointManager.removeBreakpointManagerListener(this);

			debugPlugin.removeDebugEventListener(this);
		}

		fID2Breakpoint.clear();
		
		fireTerminateEvent();
		if(fProcess instanceof QVTOVirtualProcess) {
			QVTOVirtualProcess vp = (QVTOVirtualProcess) fProcess;
			vp.terminated();
		}
	}

	public boolean canResume() {
		return !isTerminated() && isSuspended();
	}

	public boolean canSuspend() {
		return !isTerminated() && !isSuspended();
	}

	public void resume() throws DebugException {
		sendRequest(new VMResumeRequest(DebugEvent.UNSPECIFIED));
	}

	public void suspend() throws DebugException {
		sendRequest(new VMSuspendRequest(DebugEvent.UNSPECIFIED));
	}

	public void breakpointAdded(IBreakpoint breakpoint) {
		if (breakpoint instanceof QVTOBreakpoint == false
				|| !DebugPlugin.getDefault().getBreakpointManager().isEnabled()) {
			return;
		}

		QVTOBreakpoint qvtBreakpoint = (QVTOBreakpoint) breakpoint;
		try {
			NewBreakpointData bpData = qvtBreakpoint.createNewBreakpointData();
			VMBreakpointRequest addBreakpointRequest = VMBreakpointRequest
					.createAdd(bpData);

			VMResponse response = sendRequest(addBreakpointRequest);
			if(response instanceof VMBreakpointResponse) {
				VMBreakpointResponse bpResponse = (VMBreakpointResponse) response;
				long[] addedIDs = bpResponse.getAddedBreakpointsIDs();
				if(addedIDs.length > 0) {
					fID2Breakpoint.put(new Long(addedIDs[0]), qvtBreakpoint);
				}
			}
		} catch (CoreException e) {
			QVTODebugCore.log(e.getStatus());
		}
	}

	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (breakpoint instanceof QVTOBreakpoint == false
				|| !DebugPlugin.getDefault().getBreakpointManager().isEnabled()) {
			return;
		}

		boolean nowEnabled = false;
		try {
			nowEnabled = breakpoint.isEnabled();
		} catch (CoreException e1) {
			// do nothing
		}
		boolean beforeEnabled = delta.getAttribute(IBreakpoint.ENABLED, false);

		VMBreakpointRequest changeRequest = null;
		try {
			QVTOBreakpoint qvtBreakpoint = (QVTOBreakpoint) breakpoint;
			if (nowEnabled && !beforeEnabled) {
				// just to be added to VM
				changeRequest = VMBreakpointRequest
						.createAdd(new NewBreakpointData[] { qvtBreakpoint
								.createNewBreakpointData() });
			} else if (!nowEnabled && beforeEnabled) {
				// just to be removed from VM
				changeRequest = VMBreakpointRequest.createRemove(qvtBreakpoint
						.getID());
			} else {
				// modify existing data
				changeRequest = VMBreakpointRequest.createChange(qvtBreakpoint
						.getID(), qvtBreakpoint.createBreakpointData());
			}

		} catch (CoreException e) {
			QVTODebugCore.log(e);
		}

		if (changeRequest != null) {
			try {
				fVM.sendRequest(changeRequest);
			} catch (IOException e) {
				QVTODebugCore.log(e);
			}
		}
	}

	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		if (breakpoint instanceof QVTOBreakpoint) {
			if (delta == null) {
				IMarker marker = breakpoint.getMarker();
				if (marker.exists()) {
					try {
						marker.delete();
					} catch (CoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			QVTOBreakpoint qvtBreakpoint = (QVTOBreakpoint) breakpoint;
			fID2Breakpoint.remove(new Long(((QVTOBreakpoint) breakpoint)
					.getID()));

			VMBreakpointRequest removeRequest = VMBreakpointRequest
					.createRemove(qvtBreakpoint.getID());
			try {
				fVM.sendRequest(removeRequest);
			} catch (IOException e) {
				QVTODebugCore.log(e);
			}
		}
	}

	public boolean canDisconnect() {
		return false;
	}

	public void disconnect() throws DebugException {
	}

	public boolean isDisconnected() {
		return false;
	}

	public boolean supportsStorageRetrieval() {
		return false;
	}

	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		return null;
	}

	public void handleDebugEvents(DebugEvent[] events) {
		for (int i = 0; i < events.length; i++) {
			DebugEvent event = events[i];

			if (event.getKind() == DebugEvent.TERMINATE) {
				// respond
				if ((fMainThread != null && event.getSource() == fMainThread)
						|| (event.getSource() == fProcess)) {
					if(!isTerminated()) {
						terminated();
					}
				}
			}
		}
	}

	public void breakpointManagerEnablementChanged(boolean enabled) {
		for (IBreakpoint breakpoint : QVTODebugCore
				.getQVTOBreakpoints(IBreakpoint.class)) {
			if (enabled) {
				breakpointAdded(breakpoint);
			} else {
				breakpointRemoved(breakpoint, null);
			}
		}
	}
	
	private void joinStartOrTerminate() {
		synchronized (fVMStartMonitor) {
			while(fIsStarting) {
				try {
					// wait until we receive VM startup event
					fVMStartMonitor.wait();
				} catch (InterruptedException e) {
					Thread.interrupted();
				}
			}
		}
	}
	
		
	private void setStarting(boolean isStarting) {
		synchronized (fVMStartMonitor) {
			fIsStarting = isStarting;
			fVMStartMonitor.notify();
		}
	}
	
	private void handleBreakpointConditionError(VMSuspendEvent suspend) {
		IStatus breakpointStatus = new BreakpointError(suspend
				.getBreakpointID(), suspend.getReason(),
				suspend.getReasonDetail());
		
		IStatusHandler handler = DebugPlugin.getDefault().getStatusHandler(breakpointStatus);
		if(handler != null) {
			try {
				handler.handleStatus(breakpointStatus, QVTODebugTarget.this);									
			} catch (CoreException e) {
				QVTODebugCore.log(e.getStatus());
			}
		} else {
			// no custom handler found, at least log the status
			QVTODebugCore.log(breakpointStatus);
		}
	}	
	
	private VMEventListener createVMEventListener() {
		return new VMEventListener() {
			
			public void handleEvent(VMEvent event) { 
				if (event instanceof VMResumeEvent) {
					fIsSuspended = false;
					fireResumeEvent(0);
				} else if (event instanceof VMSuspendEvent) {
					fIsSuspended = true;
					
					VMSuspendEvent suspend = (VMSuspendEvent) event;					
					fireSuspendEvent(suspend.detail);
					
					if (suspend.detail == VMSuspendEvent.BREAKPOINT_CONDITION_ERR) {
						handleBreakpointConditionError(suspend);
					}
					
				} else if (event instanceof VMTerminateEvent) {
					fIsSuspended = false;
					terminated();
				} else if (event instanceof VMDisconnectEvent) {
					fIsSuspended = false;
					terminated();
				} else if (event instanceof VMStartEvent) {					
					VMStartEvent startEvent = (VMStartEvent) event;
					started(startEvent.mainModuleName);
					fIsSuspended = false; //startEvent.suspendOnStartup;
				}
			}

		};
	}

	public void addVMEventListener(VMEventListener listener) {
		if (listener == null) {
			throw new IllegalArgumentException();
		}

		synchronized (fEventListener) {
			fEventListener.add(listener);
		}
	}

	public boolean removeVMEventListener(VMEventListener listener) {
		synchronized (fEventListener) {
			return fEventListener.remove(listener);
		}
	}

	void handleVMEvent(VMEvent event) {
		List<VMEventListener> listeners;
		synchronized (fEventListener) {
			listeners = new ArrayList<VMEventListener>(fEventListener);
		}

		for (VMEventListener vmEventListener : listeners) {
			try {
				vmEventListener.handleEvent(event);
			} catch (Exception e) {
				QVTODebugCore.log(e);
			}
		}
	}
	
	public IValue evaluate(String expressionText, long frameID) throws CoreException {
		if (getVM() instanceof QVTOVirtualMachine) {
			return ((QVTOVirtualMachine) getVM()).evaluate(expressionText, this, frameID);
		}
		return null;
	}
	
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
/*		if (QvtOperationalEvaluationEnv.class == adapter) {
			if (getVM() instanceof QVTOVirtualMachine) {
				return ((QVTOVirtualMachine) getVM()).getEvaluationEnv();
			}
		} */
		return super.getAdapter(adapter);
	}
	
	private class EventDispatchJob implements Runnable {

		EventDispatchJob() {
			super();
		}

		public void run() {
			while (!isTerminated()) {
				VMEvent event;
				try {
					event = fVM.readVMEvent();
				} catch (IOException e) {
					break;
				}

				if (event != null) {
					handleVMEvent(event);
				}
			}

			QVTODebugCore.TRACE.trace(DebugOptions.TARGET,
					"Debug target VMEvent dispatcher shutdown"); //$NON-NLS-1$
		}
	}

}
