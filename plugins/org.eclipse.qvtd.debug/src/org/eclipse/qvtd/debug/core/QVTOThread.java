package org.eclipse.qvtd.debug.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.qvtd.debug.vm.VMEventListener;
import org.eclipse.qvtd.debug.vm.protocol.VMEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMResumeRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMStackFrame;
import org.eclipse.qvtd.debug.vm.protocol.VMSuspendEvent;

public class QVTOThread extends QVTODebugElement implements IThread, VMEventListener {

	private List<QVTOStackFrame> fFrames;
	private List<VMStackFrame> fUnderlyingFrames;
	
	private VMStackFrame fLastSuspendedFrame;
	private boolean fIsStepping; 
	
	public QVTOThread(IQVTODebugTarget target) {
		super(target);
		
		fFrames = new ArrayList<QVTOStackFrame>();
		fIsStepping = false;
		
		target.addVMEventListener(this);
		
		fireCreationEvent();
	}
		
	public boolean isDeferredExecution() {
		// TODO
		return false;
	}
	        
	public boolean hasStackFrames() throws DebugException {
		return isSuspended();
	}
	
	public IStackFrame[] getStackFrames() throws DebugException {
		if(isSuspended()) {
			if(fFrames.size() == 0) {
				fillFrames();
			}
		}
		
		return fFrames.toArray(new QVTOStackFrame[fFrames.size()]);
	}
	
	public int getPriority() throws DebugException {
		return 0; // not it use at the moment //myWorker.getPriority();
	}

	public IStackFrame getTopStackFrame() throws DebugException {
		if(!hasStackFrames()) {
			return null;
		}
		
		IStackFrame[] frames = getStackFrames();
		return frames.length > 0 ? frames[0] : null;
	}

	public String getName() throws DebugException {
		// no underlying thread ID
		return "QVTOThread"; //$NON-NLS-1$  
	}

	public IBreakpoint[] getBreakpoints() {
		IBreakpoint[] hostBreakpoints = new IBreakpoint[0];
		// FIXME  - add suspedendedBy(IBreakpoint); to be called by the debugger
		return hostBreakpoints;
	}

	public boolean canResume() {
		return isSuspended();
	}

	public boolean canSuspend() {
		return !isSuspended();
	}

	public boolean isSuspended() {
		return getDebugTarget().isSuspended();
	}

	public void resume() throws DebugException {
		setStepping(false);		
		getDebugTarget().resume();
		fireResumeEvent(DebugEvent.CLIENT_REQUEST);
	}

	public void suspend() throws DebugException {
		getDebugTarget().suspend();
	}

	public boolean canStepInto() {
		return isSuspended();
	}
	
	public void stepInto() throws DebugException {
		if(!canStepInto()) {
			return;
		}
		
		setStepping(true);		
		fireResumeEvent(DebugEvent.STEP_INTO);

		getQVTODebugTarget().sendRequest(new VMResumeRequest(DebugEvent.STEP_INTO));
	}

	public boolean canStepOver() {
		return isSuspended();
	}
	
	public void stepOver() throws DebugException {
		if(!canStepOver()) {
			return;
		}
		
		setStepping(true);		
		fireResumeEvent(DebugEvent.STEP_OVER);

		getQVTODebugTarget().sendRequest(new VMResumeRequest(DebugEvent.STEP_OVER));
	}

	public boolean canStepReturn() {
		return isSuspended();
	}
	
	public void stepReturn() throws DebugException {
		if(!canStepReturn()) {
			return;
		}
		
		setStepping(true);		
		fireResumeEvent(DebugEvent.STEP_RETURN);

		getQVTODebugTarget().sendRequest(new VMResumeRequest(DebugEvent.STEP_RETURN));
	}

	public boolean isStepping() {
		return fIsStepping;
	}
	
	private void setStepping(boolean isStepping) {
		fIsStepping = isStepping;
	}

	public boolean canTerminate() {
		return getDebugTarget().canTerminate();
	}

	public boolean isTerminated() {
		return getDebugTarget().isTerminated();
	}

	public void terminate() throws DebugException {
		getDebugTarget().terminate();
		fFrames.clear();
	}
    	
	public void handleEvent(VMEvent event) {
		if(event instanceof VMSuspendEvent) {
			VMSuspendEvent suspendEvent = (VMSuspendEvent) event;
 			
			if(!isStepping()) {
				fFrames.clear();
			} else {				

				VMStackFrame suspendedAtLocation = suspendEvent.stackFrames[0];
				
				if(fLastSuspendedFrame != null && suspendedAtLocation != null &&					
					suspendedAtLocation.id == fLastSuspendedFrame.id && !fFrames.isEmpty()) {
					fFrames.get(0).setLocation(suspendedAtLocation);
				} else {
					// stepped across stack frames since the last suspended
					fFrames.clear();
				}				
			}
			
			fUnderlyingFrames = Arrays.asList(suspendEvent.stackFrames);			
			
			setStepping(false);

			DebugEvent debugEvent = new DebugEvent(this, DebugEvent.SUSPEND, suspendEvent.detail);
			debugEvent.setData(suspendEvent.location);
	        fireEvent(debugEvent);
		}
	}

	private void fillFrames() {
		if(fUnderlyingFrames == null) {
			return;
		}
		for (VMStackFrame frame : fUnderlyingFrames) {
			fFrames.add(new QVTOStackFrame(this, frame));
		}
		
		if(!fUnderlyingFrames.isEmpty()) {
			fLastSuspendedFrame = fUnderlyingFrames.get(0);
		}
	}
	
}
