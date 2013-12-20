/*******************************************************************************
 * Copyright (c) 2009,2012 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *     Christopher Gerking - bug 394498
 *******************************************************************************/
package org.eclipse.qvtd.debug.evaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.qvtd.debug.stubs.ASTBindingHelper;
import org.eclipse.qvtd.debug.stubs.DebugOptions;
import org.eclipse.qvtd.debug.stubs.QvtInterruptedExecutionException;
import org.eclipse.qvtd.debug.utils.CompiledUnit;
import org.eclipse.qvtd.debug.utils.QVTODebugCore;
import org.eclipse.qvtd.debug.vm.ConditionChecker;
import org.eclipse.qvtd.debug.vm.IQVTODebuggerShell;
import org.eclipse.qvtd.debug.vm.UnitLocation;
import org.eclipse.qvtd.debug.vm.VMBreakpoint;
import org.eclipse.qvtd.debug.vm.VMBreakpointManager;
import org.eclipse.qvtd.debug.vm.VMUtils;
import org.eclipse.qvtd.debug.vm.ValidBreakpointLocator;
import org.eclipse.qvtd.debug.vm.protocol.VMRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMResumeEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMResumeRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMStackFrame;
import org.eclipse.qvtd.debug.vm.protocol.VMStartEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMSuspendEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMSuspendRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMTerminateRequest;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.IQVTiEvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironment;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorImpl;

public class DebugRootQVTiEvaluationVisitor extends DebugQVTiEvaluationVisitor
{
	private final IQVTODebuggerShell fDebugShell;
	private final VMBreakpointManager fBPM;
	private UnitLocation fCurrentLocation;
	private final IterateBreakpointHelper fIterateBPHelper;
//	private final List<UnitLocation> fLocationStack;
	private int fCurrentStepMode;
	private @NonNull Stack<DebugQVTiEvaluationVisitor> visitorStack = new Stack<DebugQVTiEvaluationVisitor>();

	public DebugRootQVTiEvaluationVisitor(@NonNull QVTiEnvironment env, @NonNull IQVTiEvaluationEnvironment evalEnv, @NonNull Transformation transformation, IQVTODebuggerShell shell) {
		super(new QVTiEvaluationVisitorImpl(env, evalEnv));
		fDebugShell = shell;
		fBPM = shell.getBreakPointManager();
		fIterateBPHelper = new IterateBreakpointHelper(fBPM);
//		fLocationStack = new ArrayList<UnitLocation>();
		fCurrentStepMode = DebugEvent.UNSPECIFIED;
		pushVisitor(this);
		fCurrentLocation = null; //getCurrentLocation();
//		UnitLocation newLocation = newLocalLocation((IDebugEvaluationEnvironment) evalEnv, transformation, ASTBindingHelper.getStartPosition(transformation)); //, getNodeLength(element));
//		setCurrentLocation(transformation, newLocation, false);

		fDebugShell.sessionStarted(this);

		VMRequest request = null; 
		try {
			// suspend to let others to wake up us on demand
			QVTODebugCore.TRACE.trace(DebugOptions.EVALUATOR,
			"Debug evaluator going to initial SUSPEND state"); //$NON-NLS-1$
			
			request = shell.waitAndPopRequest(new VMStartEvent(getMainModuleName(), true));
		} catch (InterruptedException e) {
			Thread.interrupted();
			terminate();
		}
		
		if(request instanceof VMResumeRequest == false) {
			// TODO - decide a set of request we can handle during initial SUSPEND mode,
			// or report fError
			terminate();
		}
	}

	private VMSuspendEvent createVMSuspendEvent(int eventDetail) {
		// build the VM stack frames
		VMStackFrame[] vmStack = VMUtils.createStackFrame(getLocationStack());		
		assert vmStack.length > 0;
		return new VMSuspendEvent(vmStack, eventDetail);
	}

	@Override
	public void dispose() {
		throw new UnsupportedOperationException();			// Root visitor never gets disposed.
	}
	
	private void doProcessRequest(UnitLocation location, VMRequest request) {
		if (VM_REQUEST.isActive()) {
			VM_REQUEST.println("[" + Thread.currentThread().getName() + "] " + location.toString() + " " + request);
		}
		if (request instanceof VMResumeRequest) {
			VMResumeRequest resumeRequest = (VMResumeRequest) request;
			fCurrentLocation = getCurrentLocation();
			fCurrentStepMode = resumeRequest.detail;
			if (fCurrentStepMode == DebugEvent.UNSPECIFIED) {
				fIterateBPHelper.removeAllIterateBreakpoints();
			}
		} else if (request instanceof VMSuspendRequest) {
			VMSuspendRequest suspendRequest = (VMSuspendRequest) request;
			suspendAndWaitForResume(location, suspendRequest.detail);
		} else if (request instanceof VMTerminateRequest) {
			terminate();
		} else {
			throw new IllegalArgumentException("Unsupported debug request: " + request); //$NON-NLS-1$
		}
	}

	public @NonNull UnitLocation getCurrentLocation() {
		DebugQVTiEvaluationVisitor currentVisitor = visitorStack.peek();
		IDebugEvaluationEnvironment evaluationEnvironment = currentVisitor.getEvaluationEnvironment();
		return evaluationEnvironment.getCurrentLocation();
//		return fCurrentLocation;
	}

	public int getDepth() {
		return 1;
	}

	public List<UnitLocation> getLocationStack() {
		List<UnitLocation> fLocationStack = new ArrayList<UnitLocation>();
		IDebugEvaluationEnvironment leafEvaluationEnvironment = visitorStack.peek().getEvaluationEnvironment();
		for (IDebugEvaluationEnvironment evaluationEnvironment = leafEvaluationEnvironment; evaluationEnvironment != null; evaluationEnvironment = evaluationEnvironment.getParentEvaluationEnvironment()) {
			Element currentIP = evaluationEnvironment.getCurrentIP();
			UnitLocation unitLocation = newLocalLocation(evaluationEnvironment, currentIP, ASTBindingHelper.getStartPosition(currentIP), ASTBindingHelper.getEndPosition(currentIP)); 
			fLocationStack.add(unitLocation);
		}
		return fLocationStack;
	}
	
	private String getMainModuleName() {
		CompiledUnit mainUnit = fBPM.getUnitManager().getMainUnit();
		if(mainUnit.getModules().isEmpty()) {
			return "<null>"; //$NON-NLS-1$
		}
		return mainUnit.getModules().get(0).getName();
	}

	public @NonNull DebugRootQVTiEvaluationVisitor getRootEvaluationVisitor() {
		return this;
	}
	
	protected void handleLocationChanged(@NonNull Element  element, UnitLocation location, boolean isElementEnd) {
		if (LOCATION.isActive()) {
			LOCATION.println("[" + Thread.currentThread().getName() + "] " + element.eClass().getName() + ": " + element.toString() + " @ " + location + " " + (isElementEnd ? "start" : "end"));
		}
//		DebugQVTiEvaluationVisitor currentVisitor = visitorStack.peek();
//		UnitLocation fCurrentLocation = currentVisitor.getEvaluationEnvironment().getCurrentLocation();
//		if (fCurrentLocation == null) {
//			return;
//		}
		
		if(false == (!isElementEnd ? ValidBreakpointLocator.isBreakpointableElementStart(element) : 
			ValidBreakpointLocator.isBreakpointableElementEnd(element))) {
			return;
		}
		
		switch (fCurrentStepMode) {
		case DebugEvent.STEP_OVER:
			if (location.getStackDepth() <= fCurrentLocation.getStackDepth()
					&& (!location.isTheSameLine(fCurrentLocation)
						/*|| repeatedInIterator(location, fCurrentLocation)*/ )) {
				fCurrentLocation = null;
				suspendAndWaitForResume(location, fCurrentStepMode);
				return;
			}
			break;
		case DebugEvent.STEP_INTO:
			if (!location.isTheSameLocation(fCurrentLocation) /*|| repeatedInIterator(location, fCurrentLocation)*/) {
				fCurrentLocation = null;
				suspendAndWaitForResume(location, fCurrentStepMode);
				return;
			}
			break;
		case DebugEvent.STEP_RETURN:
			if (location.getStackDepth() < fCurrentLocation.getStackDepth()) {
				fCurrentLocation = null;
				suspendAndWaitForResume(location, fCurrentStepMode);
				return;
			}
			break;
		}

		// check if we trigger a registered breakpoint
		for (VMBreakpoint breakpoint : fBPM.getBreakpoints(element)) {	// FIXME Use Adapters to avoid potentially long loop
			if (breakpoint.getLineNumber() != location.getLineNum()) {
				 //TODO - faster to indicate in and or beginning enablement in VMBreakpoint ?
				//|| !((!isElementEnd) ? ValidBreakpointLocator.isBreakpointableElementStart(element) : 
					//ValidBreakpointLocator.isBreakpointableElementEnd(element))) {
				// no breakpoint can be triggered
				continue;
			}
					
			Boolean isTriggered = null;
			try {
				isTriggered = Boolean.valueOf(breakpoint.hitAndCheckIfTriggered(this));
			} catch(CoreException e) {
				IStatus status = e.getStatus();
				String reason = null; //$NON-NLS-1$
				if(status.getCode() == ConditionChecker.ERR_CODE_COMPILATION) {
					reason = "Breakpoint condition compilation failed";
				} else if(status.getCode() == ConditionChecker.ERR_CODE_EVALUATION) {
					reason = "Breakpoint condition evaluation failed";
				}
				
				if(reason != null) {
					// breakpoint condition parsing or evaluation failed, notify the debug client
					VMSuspendEvent suspendOnBpConditionErrr = createVMSuspendEvent(VMSuspendEvent.BREAKPOINT_CONDITION_ERR);
					suspendOnBpConditionErrr.setBreakpointID(breakpoint.getID());
					suspendOnBpConditionErrr.setReason(reason, status.getMessage());
					// suspend VM and wait for resolution by the debug client
					suspendAndWaitForResume(location, suspendOnBpConditionErrr);
				} else {
					QVTODebugCore.log(e.getStatus());
				}
				
				continue;
			}
			
			if (Boolean.TRUE.equals(isTriggered)) {
				boolean isIterateBp = fIterateBPHelper.isIterateBreakpoint(breakpoint);
				int eventDetail = isIterateBp ? fCurrentStepMode : DebugEvent.BREAKPOINT;
				
				// let the VM suspend and wait for resume request
				suspendAndWaitForResume(location, eventDetail);

				if (isIterateBp) {
					fBPM.removeBreakpoint(breakpoint);
				}
			}
		}
		
	}

	private UnitLocation newLocalLocation(@NonNull IDebugEvaluationEnvironment evalEnv, @NonNull Element node, int startPosition, int endPosition) {//, int length) {
		return new UnitLocation(startPosition, endPosition, evalEnv, node);
	}

	public void popVisitor(@NonNull DebugNestedQVTiEvaluationVisitor evaluationVisitor) {
		if (VISITOR_STACK.isActive()) {
			VISITOR_STACK.println("[" + Thread.currentThread().getName() + "] " + "Pop " + evaluationVisitor.toString());
		}
		DebugQVTiEvaluationVisitor poppedVisitor = visitorStack.pop();
		assert poppedVisitor == evaluationVisitor;
	}

	protected void postVisit(@NonNull IDebugEvaluationEnvironment evalEnv, @NonNull Element element, Object preState) {
		if (element instanceof Transformation) {
			// 
		} else {
			if (element instanceof Operation) {
				int endPosition = ASTBindingHelper.getEndPosition(element);
				UnitLocation endLocation = newLocalLocation(evalEnv, element, endPosition, endPosition); //, 1);
				setCurrentLocation(element, endLocation, true);
			} else if (element instanceof EStructuralFeature) {
				// result = null;
			} else if (element instanceof LoopExp) {
				if (preState instanceof VMBreakpoint) {
					fIterateBPHelper.removeIterateBreakpoint((VMBreakpoint) preState);
				}
			} else {
				int endPosition = ASTBindingHelper.getEndPosition(element);
				UnitLocation el = newLocalLocation(evalEnv, element, endPosition - 1, endPosition); //, 1);
				
				setCurrentLocation(element, el, true);
			}
		}
	}

	protected Object preVisit(@NonNull IDebugEvaluationEnvironment evalEnv, @NonNull Element element) {
		/*if (element instanceof Transformation) {
//			fCurrentLocation = newLocalLocation(evalEnv, element, ASTBindingHelper.getStartPosition(element)); //, getNodeLength(element));
		} else */ if (element instanceof Operation) {
			// nothing to do before visit
			// only end location visit supported
		} else if (element instanceof EStructuralFeature) {
			// result = null;
		} else if (element instanceof LoopExp) {
//			@SuppressWarnings("unchecked")
			LoopExp loop = (LoopExp) element;

			UnitLocation topLocation = getCurrentLocation();
			boolean skipIterate = (fCurrentStepMode == DebugEvent.UNSPECIFIED)
					|| ((fCurrentStepMode == DebugEvent.STEP_OVER) && 
						(topLocation.getStackDepth() > fCurrentLocation.getStackDepth()));

			if (!skipIterate) {
				return fIterateBPHelper.stepIterateElement(loop, topLocation);
			}
			
		} else if (ValidBreakpointLocator.isBreakpointableElementStart(element)) {
			UnitLocation startLocation = newLocalLocation(evalEnv, element, ASTBindingHelper.getStartPosition(element), ASTBindingHelper.getEndPosition(element)); //, getNodeLength(element));

			setCurrentLocation(element, startLocation, false);
			// FIXME - review, should process the debug request in all cases
			processDebugRequest(startLocation);

		} else {
			setCurrentLocation(element, newLocalLocation(evalEnv, element, ASTBindingHelper.getStartPosition(element), ASTBindingHelper.getEndPosition(element)/*, getNodeLength(element)*/), false);
		}
		return null; //result;
	}

	private void processDebugRequest(UnitLocation location) {
		VMRequest event = fDebugShell.popRequest();
		if (event == null) {
			return;
		}
		
		doProcessRequest(location, event);
	}

	public void pushVisitor(@NonNull DebugQVTiEvaluationVisitor evaluationVisitor) {
		if (VISITOR_STACK.isActive()) {
			VISITOR_STACK.println("[" + Thread.currentThread().getName() + "] " + "Push " + evaluationVisitor.toString());
		}
		assert !visitorStack.contains(evaluationVisitor);
		visitorStack.push(evaluationVisitor);
	}

	private void setCurrentLocation(@NonNull Element element, UnitLocation newLocation, boolean atEnd) {
//		if (fLocationStack.isEmpty()) {
//			return;
//		}

		// do not change to position-less locations
		if (newLocation.getStartPosition() < 0) {
			return;
		}

//		fLocationStack.set(0, newLocation);
		handleLocationChanged(element, newLocation, atEnd);
	}
	
	private void suspendAndWaitForResume(UnitLocation location, int eventDetail) {
		suspendAndWaitForResume(location, createVMSuspendEvent(eventDetail));
	}
	
	private void suspendAndWaitForResume(UnitLocation location, VMSuspendEvent suspendEvent) {		
		try {			
			VMSuspendEvent vmSuspend = suspendEvent;
			
			// send to the client runner, wait for resume
			VMRequest nextRequest = fDebugShell.waitAndPopRequest(vmSuspend);			
			assert nextRequest != null;
			
			if(nextRequest instanceof VMResumeRequest) {
				fDebugShell.handleVMEvent(new VMResumeEvent());
			}

			doProcessRequest(location, nextRequest);
			
		} catch (InterruptedException e) {
			terminate();
		}
	}

	private void terminate() throws QvtInterruptedExecutionException {
		IDebugEvaluationEnvironment evalEnv = getEvaluationEnvironment();
		evalEnv.throwQVTException(new QvtInterruptedExecutionException("User termination request"));
	}
}
