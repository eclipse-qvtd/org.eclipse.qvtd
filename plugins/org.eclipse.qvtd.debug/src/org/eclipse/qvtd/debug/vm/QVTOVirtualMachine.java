/*******************************************************************************
 * Copyright (c) 2009, 2013 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.vm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.core.QVTODebugTarget;
import org.eclipse.qvtd.debug.core.QVTOLocalValue;
import org.eclipse.qvtd.debug.core.QVTOLocalValue.LocalValue;
import org.eclipse.qvtd.debug.evaluator.DebugQVTiEvaluationVisitor;
import org.eclipse.qvtd.debug.evaluator.DebugRootQVTiEvaluationVisitor;
import org.eclipse.qvtd.debug.stubs.DebugOptions;
import org.eclipse.qvtd.debug.utils.QVTODebugCore;
import org.eclipse.qvtd.debug.vm.protocol.BreakpointData;
import org.eclipse.qvtd.debug.vm.protocol.NewBreakpointData;
import org.eclipse.qvtd.debug.vm.protocol.VMBreakpointRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMBreakpointRequest.ActionKind;
import org.eclipse.qvtd.debug.vm.protocol.VMBreakpointResponse;
import org.eclipse.qvtd.debug.vm.protocol.VMDetailRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMDetailResponse;
import org.eclipse.qvtd.debug.vm.protocol.VMEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMResponse;
import org.eclipse.qvtd.debug.vm.protocol.VMStackFrame;
import org.eclipse.qvtd.debug.vm.protocol.VMStackFrameRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMStackFrameResponse;
import org.eclipse.qvtd.debug.vm.protocol.VMStartEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMStartRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMTerminateEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMVariableRequest;

public class QVTOVirtualMachine implements IQVTOVirtualMachineShell {
		
	private final List<VMRequest> fRequests = new ArrayList<VMRequest>();
	private final BlockingQueue<VMEvent> fEvents = new ArrayBlockingQueue<VMEvent>(50);	
		
	protected final @NonNull MetaModelManager metaModelManager;
	private final @NonNull IQVTODebuggerShell fDebuggerShell;
	
	private final @NonNull VMBreakpointManager fBreakpointManager;
	private @Nullable DebugRootQVTiEvaluationVisitor fInterpreter;
	private final @NonNull DebuggableExecutorAdapter fExecutor;

	private boolean fRunning;
	private boolean fTerminated;
		
	private Object fStateMonitor = new Object();
	private final Object fLock = new Object();
		
	
	public QVTOVirtualMachine(@NonNull MetaModelManager metaModelManager, @NonNull DebuggableExecutorAdapter executorAdapter) {
		this.metaModelManager = metaModelManager;
		fExecutor = executorAdapter;
		fDebuggerShell = new DebuggerShell();
		fBreakpointManager = new VMBreakpointManager(metaModelManager, executorAdapter.getUnit());
		fTerminated = false;
	}

	public boolean isTerminated() {
		return fTerminated;
	}

	public VMEvent readVMEvent() throws IOException {
		try {
			return fEvents.take();
		} catch(InterruptedException e) {
			throw new IOException("Waiting for event interrupted");
		}
	}
	
	public VMResponse sendRequest(@NonNull VMRequest request) throws IOException {
		try {
			if(request instanceof VMStartRequest) {
				return start();
			} else if(request instanceof VMBreakpointRequest) {
				return handleBreakPointRequest((VMBreakpointRequest) request);
			} else if(request instanceof VMStackFrameRequest) {
				return handleStackFrameRequest((VMStackFrameRequest) request);
			} else if(request instanceof VMVariableRequest) {
				return handleVariableRequest((VMVariableRequest) request);
			} else if(request instanceof VMDetailRequest) {
				return handleValueDetailRequest((VMDetailRequest) request);
			}
		} catch (RuntimeException e) {
			QVTODebugCore.log(e);
			return VMResponse.createERROR();
		}
			
		synchronized (fLock) {
			fRequests.add(request);			
			fLock.notifyAll();
		}
		
		return VMResponse.createOK();
	}
	
	public IValue evaluate(String expressionText, QVTODebugTarget debugTarget, long frameID) throws CoreException {
		DebugRootQVTiEvaluationVisitor fInterpreter2 = fInterpreter;
		if (fInterpreter2 == null) {
			return null;
		}

		Element astNode = fInterpreter2.getCurrentLocation().getElement();
        if (astNode == null) {
            return null;
        }
        
        ConditionChecker localChecker = new ConditionChecker(expressionText, astNode);
        LocalValue lv = new LocalValue();
        lv.valueObject = localChecker.evaluate(fInterpreter2);
        lv.valueType = localChecker.getConditionType();
        
		return new QVTOLocalValue(debugTarget, frameID, new String[] {expressionText}, lv, 
				fInterpreter2.getEvaluationEnvironment());
	}

	/**
	 * @since 1.1
	 */
	public EvaluationEnvironment getEvaluationEnv() {
		DebugRootQVTiEvaluationVisitor fInterpreter2 = fInterpreter;
		if (fInterpreter2 == null) {
			return null;
		}
		return fInterpreter2.getEvaluationEnvironment();
	}
	
	private VMResponse start() {
		Thread executorThread = new Thread(createVMRunnable(), "QVTi VM");
		
		synchronized (fStateMonitor) {
			if(fRunning) {
				return VMResponse.createERROR();
			}

			executorThread.start();
			
			while(!(fRunning || fTerminated)) {
				try {				
					fStateMonitor.wait();
				} catch (InterruptedException e) {					
					QVTODebugCore.log(QVTODebugCore.createStatus(IStatus.ERROR,
							"VM startup process interrupted"));
				}
			}
		}
		
		return VMResponse.createOK();
	}	
	
	private VMResponse handleStackFrameRequest(VMStackFrameRequest request) {
		DebugRootQVTiEvaluationVisitor fInterpreter2 = fInterpreter;
		if (fInterpreter2 != null) {
			List<UnitLocation> locationStack = fInterpreter2.getLocationStack();
			VMStackFrame frame = VMUtils.createStackFrame(request.frameID, locationStack);
			if (frame != null) {
				VMStackFrameResponse response = new VMStackFrameResponse(frame);
				if (!locationStack.isEmpty()) {
					UnitLocation topLocation = locationStack.get(0);
			    	response.isDeferredExecution = topLocation.isDeferredExecution();
				}
				return response;
			}

		}
		
		// FIXME
		return VMResponse.createERROR(); 
	}

	private VMBreakpointResponse handleBreakPointRequest(VMBreakpointRequest request) {
		ActionKind actionKind = request.getActionKind();
		
		if(actionKind == VMBreakpointRequest.ActionKind.ADD) {
			List<BreakpointData> allBpData = request.getBreakpointData();
			if(allBpData != null) {
				List<Long> addedBpIDs = new ArrayList<Long>();
				for (BreakpointData bpData : allBpData) {
					if(bpData instanceof NewBreakpointData == false) {
						continue;
					}
					
					NewBreakpointData newBreakpoint = (NewBreakpointData) bpData;
					VMBreakpoint breakpoint = fBreakpointManager.createBreakpoint(newBreakpoint);
					
					if(breakpoint != null) {
						addedBpIDs.add(new Long(newBreakpoint.ID));
						
						QVTODebugCore.TRACE.trace(DebugOptions.VM,
								"Installing breakpoing: " + " line:" //$NON-NLS-1$ //$NON-NLS-2$
										+ newBreakpoint.line + " " //$NON-NLS-1$
										+ newBreakpoint.targetURI);
					} else {
						QVTODebugCore.TRACE.trace(DebugOptions.VM,
								"Failed to create breakpoing: " + " line:" //$NON-NLS-1$ //$NON-NLS-2$
										+ newBreakpoint.line + " " //$NON-NLS-1$
										+ newBreakpoint.targetURI);
					}
				}
				
				return new VMBreakpointResponse(addedBpIDs);
			}
		} else if(actionKind == VMBreakpointRequest.ActionKind.REMOVE) {
			fBreakpointManager.removeBreakpoint(request.getBreakpointID());
		} else if(actionKind == VMBreakpointRequest.ActionKind.CHANGE) {
			fBreakpointManager.changeBreakpoint(request.getBreakpointID(), request.getFirstBreakpointData());
		}
		
		// TODO
		return new VMBreakpointResponse();
	}
	
	private VMResponse handleValueDetailRequest(VMDetailRequest request) {
		// FIXME - ensure VM is in SUSPEND state, otherwise report fError
		DebugRootQVTiEvaluationVisitor fInterpreter2 = fInterpreter;
		if (fInterpreter2 != null) {
			String detail = VariableFinder.computeDetail(request.getVariableURI(), fInterpreter2.getCurrentLocation().getEvalEnv());		
			return new VMDetailResponse(detail != null ? detail : ""); //$NON-NLS-1$
		}
		else {
			return null;
		}
	}
	
	private VMResponse handleVariableRequest(VMVariableRequest request) {
		// FIXME - ensure VM is in SUSPEND state, otherwise report fError
		DebugRootQVTiEvaluationVisitor fInterpreter2 = fInterpreter;
		if (fInterpreter2 != null) {
			return VariableFinder.process(request, fInterpreter2.getLocationStack(), fInterpreter2.getCurrentLocation().getEvalEnv());
		}
		else {
			return null;
		}
	}
	
	private Runnable createVMRunnable() {
		return new Runnable() {
			public void run() {
				int exitCode = -1;
				try {
					fExecutor.connect(fDebuggerShell);
					exitCode = execute(fExecutor);
				} catch(Throwable e) {
					QVTODebugCore.log(e);
				} finally {
					fDebuggerShell.handleVMEvent(new VMTerminateEvent(exitCode));
				}
			}
		};
	}
		
	private static int execute(DebuggableExecutorAdapter executorAdapter) {
		int exitCode = 0;
		try {
			Diagnostic diagnostic = executorAdapter.execute();
			int severity = diagnostic.getSeverity();
			if(severity == Diagnostic.ERROR || severity == Diagnostic.CANCEL) {
				System.err.println(diagnostic.toString());
				exitCode = -1;
			}
		} catch (Throwable e) {
			exitCode = -2;
			// FIXME Auto-generated catch block
			e.printStackTrace();
		}	
		
		return exitCode;
	}	
	
	
	private class DebuggerShell implements IQVTODebuggerShellExtension {
		
		public VMBreakpointManager getBreakPointManager() {
			return QVTOVirtualMachine.this.fBreakpointManager;
		}
		
		public void sessionStarted(@NonNull DebugRootQVTiEvaluationVisitor evaluator) {
			fInterpreter = evaluator;
		}
		
		public boolean isSessionStarted() {
			return fInterpreter != null;
		}
		
		public void handleVMEvent(@NonNull VMEvent event) {
			if (DebugQVTiEvaluationVisitor.VM_EVENT.isActive()) {
				DebugQVTiEvaluationVisitor.VM_EVENT.println("[" + Thread.currentThread().getName() + "] " + event.toString());
			}
			if(event instanceof VMStartEvent) {
				// first start event
				synchronized (fStateMonitor) {
					fRunning = true;
					fStateMonitor.notify();
				}
			} else if(event instanceof VMTerminateEvent) {
				synchronized (fStateMonitor) {
					fRunning = false;
					fTerminated = true;
					fStateMonitor.notify();
				}				
			}

			try {
				fEvents.add(event);				
			} catch(IllegalStateException e) {
				// FIXME
				System.err.println("Event queue full!!!!");
			}
		}	
		
		public VMRequest popRequest() {
			synchronized (fLock) {
				return fRequests.isEmpty() ? null : fRequests.remove(0);
			}
		}
		
		public VMRequest waitAndPopRequest(@NonNull VMEvent suspend) throws InterruptedException {
			// FIXME - should be locked to ensure none can really send a request until
			// we deliver the event
			handleVMEvent(suspend);
			
			synchronized (fLock) {			
				while(fRequests.isEmpty()) {
					fLock.wait();
				}
				return fRequests.remove(0);
			}		
		}

		public VMRequest peekRequest() {
			synchronized (fLock) {
				return fRequests.isEmpty() ? null : fRequests.get(0);
			}
		}
	}

}
