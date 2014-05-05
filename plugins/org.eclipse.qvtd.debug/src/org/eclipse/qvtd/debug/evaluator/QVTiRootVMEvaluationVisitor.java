/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.evaluator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.evaluator.IterateBreakpointHelper;
import org.eclipse.ocl.examples.debug.vm.ConditionChecker;
import org.eclipse.ocl.examples.debug.vm.IVMDebuggerShell;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.VMBreakpoint;
import org.eclipse.ocl.examples.debug.vm.VMBreakpointManager;
import org.eclipse.ocl.examples.debug.vm.ValidBreakpointLocator;
import org.eclipse.ocl.examples.debug.vm.data.VMStackFrameData;
import org.eclipse.ocl.examples.debug.vm.data.VMSuspension;
import org.eclipse.ocl.examples.debug.vm.evaluator.IRootVMEvaluationVisitor;
import org.eclipse.ocl.examples.debug.vm.evaluator.IStepperVisitor;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.vm.event.VMResumeEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMStartEvent;
import org.eclipse.ocl.examples.debug.vm.event.VMSuspendEvent;
import org.eclipse.ocl.examples.debug.vm.request.VMRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMResumeRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMSuspendRequest;
import org.eclipse.ocl.examples.debug.vm.request.VMTerminateRequest;
import org.eclipse.ocl.examples.debug.vm.utils.ASTBindingHelper;
import org.eclipse.ocl.examples.debug.vm.utils.CompiledUnit;
import org.eclipse.ocl.examples.debug.vm.utils.DebugOptions;
import org.eclipse.ocl.examples.debug.vm.utils.VMInterruptedExecutionException;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;
import org.eclipse.qvtd.debug.launching.QVTiDebuggableRunnerFactory;
import org.eclipse.qvtd.debug.vm.QVTiVMVirtualMachine;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironment;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorImpl;

public class QVTiRootVMEvaluationVisitor extends QVTiVMEvaluationVisitor implements IRootVMEvaluationVisitor<Transformation>
{
	private final IVMDebuggerShell fDebugShell;
	private final VMBreakpointManager fBPM;
	private UnitLocation fCurrentLocation;
	private final IterateBreakpointHelper fIterateBPHelper;
//	private final List<UnitLocation> fLocationStack;
	private @NonNull VMSuspension fCurrentStepMode;
	private @NonNull Stack<QVTiVMEvaluationVisitor> visitorStack = new Stack<QVTiVMEvaluationVisitor>();

	public QVTiRootVMEvaluationVisitor(@NonNull QVTiEnvironment env, @NonNull IQVTiVMEvaluationEnvironment evalEnv, @NonNull Transformation transformation, IVMDebuggerShell shell) {
		super(new QVTiEvaluationVisitorImpl(env, evalEnv));
		fDebugShell = shell;
		fBPM = shell.getBreakPointManager();
		fIterateBPHelper = new IterateBreakpointHelper(fBPM);
//		fLocationStack = new ArrayList<UnitLocation>();
		fCurrentStepMode = VMSuspension.UNSPECIFIED;
		pushVisitor(this);
		fCurrentLocation = null; //getCurrentLocation();
//		UnitLocation newLocation = newLocalLocation((IDebugEvaluationEnvironment) evalEnv, transformation, ASTBindingHelper.getStartPosition(transformation)); //, getNodeLength(element));
//		setCurrentLocation(transformation, newLocation, false);

		fDebugShell.sessionStarted(this);

		VMRequest request = null; 
		try {
			// suspend to let others to wake up us on demand
			QVTiDebugCore.TRACE.trace(DebugOptions.EVALUATOR,
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

	@Override
	protected @Nullable Object badVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv,
			@NonNull Element element, Object preState, @NonNull Throwable e) {
		int endPosition = ASTBindingHelper.getEndPosition(element);
		UnitLocation endLocation = newLocalLocation(evalEnv, element, endPosition, endPosition); //, 1);
		setCurrentLocation(element, endLocation, true);
		suspendAndWaitForResume(endLocation, VMSuspension.BREAKPOINT);	// FIXME see if Interrupt BPt set
		if (e instanceof Exception) {
			throw (RuntimeException)e;
		}
		else {
			throw new RuntimeException(e);
		}
	}

	private @NonNull VMSuspendEvent createVMSuspendEvent(@NonNull VMSuspension vmSuspension) {
		// build the VM stack frames
		VMStackFrameData[] vmStack = QVTiVMVirtualMachine.createStackFrame(getLocationStack());		
		assert vmStack.length > 0;
		return new VMSuspendEvent(vmStack, vmSuspension);
	}

	@Override
	public void dispose() {
		throw new UnsupportedOperationException();			// Root visitor never gets disposed.
	}
	
	private void doProcessRequest(@NonNull UnitLocation location, @NonNull VMRequest request) {
		if (VM_REQUEST.isActive()) {
			VM_REQUEST.println("[" + Thread.currentThread().getName() + "] " + location.toString() + " " + request);
		}
		if (request instanceof VMResumeRequest) {
			VMResumeRequest resumeRequest = (VMResumeRequest) request;
			fCurrentLocation = getCurrentLocation();
			fCurrentStepMode = resumeRequest.suspension;
			if (fCurrentStepMode == VMSuspension.UNSPECIFIED) {
				fIterateBPHelper.removeAllIterateBreakpoints();
			}
		} else if (request instanceof VMSuspendRequest) {
			VMSuspendRequest suspendRequest = (VMSuspendRequest) request;
			suspendAndWaitForResume(location, suspendRequest.suspension);
		} else if (request instanceof VMTerminateRequest) {
			terminate();
		} else {
			throw new IllegalArgumentException("Unsupported debug request: " + request); //$NON-NLS-1$
		}
	}

	public @NonNull UnitLocation getCurrentLocation() {
		QVTiVMEvaluationVisitor currentVisitor = visitorStack.peek();
		IVMEvaluationEnvironment<?> evaluationEnvironment = currentVisitor.getEvaluationEnvironment();
		return evaluationEnvironment.getCurrentLocation();
//		return fCurrentLocation;
	}

	public int getDepth() {
		return 1;
	}

	@Override
	public @NonNull IQVTiVMEvaluationEnvironment getEvaluationEnvironment() {
		return (IQVTiVMEvaluationEnvironment) super.getEvaluationEnvironment();
	}

	public @NonNull List<UnitLocation> getLocationStack() {
		List<UnitLocation> fLocationStack = new ArrayList<UnitLocation>();
		IVMEvaluationEnvironment<?> leafEvaluationEnvironment = visitorStack.peek().getEvaluationEnvironment();
		for (IVMEvaluationEnvironment<?> evaluationEnvironment = leafEvaluationEnvironment; evaluationEnvironment != null; evaluationEnvironment = evaluationEnvironment.getParentEvaluationEnvironment()) {
			Element currentIP = evaluationEnvironment.getCurrentIP();
			UnitLocation unitLocation = newLocalLocation(evaluationEnvironment, currentIP, ASTBindingHelper.getStartPosition(currentIP), ASTBindingHelper.getEndPosition(currentIP)); 
			fLocationStack.add(unitLocation);
		}
		return fLocationStack;
	}
	
	private @NonNull String getMainModuleName() {
		CompiledUnit mainUnit = fBPM.getUnitManager().getMainUnit();
		if(mainUnit.getModules().isEmpty()) {
			return "<null>"; //$NON-NLS-1$
		}
		return mainUnit.getModules().get(0).getName();
	}

	public @NonNull QVTiRootVMEvaluationVisitor getRootEvaluationVisitor() {
		return this;
	}

	@Override
	public @NonNull IStepperVisitor getStepperVisitor() {
		return QVTiStepperVisitor.INSTANCE;
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
		
		ValidBreakpointLocator validbreakpointlocator = QVTiDebuggableRunnerFactory.validBreakpointLocator;
		if(false == (!isElementEnd ? validbreakpointlocator.isBreakpointableElementStart(element) : 
			validbreakpointlocator.isBreakpointableElementEnd(element))) {
			return;
		}
		
		if (fCurrentStepMode == VMSuspension.STEP_OVER) {
			if (location.getStackDepth() <= fCurrentLocation.getStackDepth()
					&& (!location.isTheSameLine(fCurrentLocation)
						/*|| repeatedInIterator(location, fCurrentLocation)*/ )) {
				fCurrentLocation = null;
				suspendAndWaitForResume(location, fCurrentStepMode);
				return;
			}
		}
		else if (fCurrentStepMode == VMSuspension.STEP_INTO) {
			if (!location.isTheSameLocation(fCurrentLocation) /*|| repeatedInIterator(location, fCurrentLocation)*/) {
				fCurrentLocation = null;
				suspendAndWaitForResume(location, fCurrentStepMode);
				return;
			}
		}
		else if (fCurrentStepMode == VMSuspension.STEP_RETURN) {
			if (location.getStackDepth() < fCurrentLocation.getStackDepth()) {
				fCurrentLocation = null;
				suspendAndWaitForResume(location, fCurrentStepMode);
				return;
			}
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
					VMSuspendEvent suspendOnBpConditionErrr = createVMSuspendEvent(VMSuspension.BREAKPOINT_CONDITION_ERR);
					suspendOnBpConditionErrr.setBreakpointID(breakpoint.getID());
					suspendOnBpConditionErrr.setReason(reason, status.getMessage());
					// suspend VM and wait for resolution by the debug client
					suspendAndWaitForResume(location, suspendOnBpConditionErrr);
				} else {
					QVTiDebugCore.INSTANCE.log(e.getStatus());
				}
				
				continue;
			}
			
			if (Boolean.TRUE.equals(isTriggered)) {
				boolean isIterateBp = fIterateBPHelper.isIterateBreakpoint(breakpoint);
				VMSuspension eventDetail = isIterateBp ? fCurrentStepMode : VMSuspension.BREAKPOINT;
				
				// let the VM suspend and wait for resume request
				suspendAndWaitForResume(location, eventDetail);

				if (isIterateBp) {
					fBPM.removeBreakpoint(breakpoint);
				}
			}
		}
		
	}

	private @NonNull UnitLocation newLocalLocation(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element node, int startPosition, int endPosition) {//, int length) {
		return new UnitLocation(startPosition, endPosition, evalEnv, node);
	}

	public void popVisitor(@NonNull QVTiNestedVMEvaluationVisitor evaluationVisitor) {
		if (VISITOR_STACK.isActive()) {
			VISITOR_STACK.println("[" + Thread.currentThread().getName() + "] " + "Pop " + evaluationVisitor.toString());
		}
		QVTiVMEvaluationVisitor poppedVisitor = visitorStack.pop();
		assert poppedVisitor == evaluationVisitor;
	}

	public void postIterate(@NonNull LoopExp loopExp/*, Object preState*/) {
//		if (preState instanceof VMBreakpoint) {
//			fIterateBPHelper.removeIterateBreakpoint((VMBreakpoint) preState);
//		}
	}

	protected void postVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element, Object preState) {
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

	public void preIterate(@NonNull LoopExp loopExp) {
		UnitLocation topLocation = getCurrentLocation();
		boolean skipIterate = (fCurrentStepMode == VMSuspension.UNSPECIFIED)
				|| ((fCurrentStepMode == VMSuspension.STEP_OVER) && 
					(topLocation.getStackDepth() > fCurrentLocation.getStackDepth()));

		if (!skipIterate) {
			/*return*/ fIterateBPHelper.stepIterateElement(loopExp, topLocation);
		}
	}

	protected Object preVisit(@NonNull IVMEvaluationEnvironment<?> evalEnv, @NonNull Element element) {
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
			boolean skipIterate = (fCurrentStepMode == VMSuspension.UNSPECIFIED)
					|| ((fCurrentStepMode == VMSuspension.STEP_OVER) && 
						(topLocation.getStackDepth() > fCurrentLocation.getStackDepth()));

			if (!skipIterate) {
				return fIterateBPHelper.stepIterateElement(loop, topLocation);
			}
			
		} else if (QVTiDebuggableRunnerFactory.validBreakpointLocator.isBreakpointableElementStart(element)) {
			UnitLocation startLocation = newLocalLocation(evalEnv, element, ASTBindingHelper.getStartPosition(element), ASTBindingHelper.getEndPosition(element)); //, getNodeLength(element));

			setCurrentLocation(element, startLocation, false);
			// FIXME - review, should process the debug request in all cases
			processDebugRequest(startLocation);

		} else {
			setCurrentLocation(element, newLocalLocation(evalEnv, element, ASTBindingHelper.getStartPosition(element), ASTBindingHelper.getEndPosition(element)/*, getNodeLength(element)*/), false);
		}
		return null; //result;
	}

	private void processDebugRequest(@NonNull UnitLocation location) {
		VMRequest event = fDebugShell.popRequest();
		if (event == null) {
			return;
		}
		
		doProcessRequest(location, event);
	}

	public void pushVisitor(@NonNull QVTiVMEvaluationVisitor evaluationVisitor) {
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
	
	private void suspendAndWaitForResume(@NonNull UnitLocation location, @NonNull VMSuspension vmSuspension) {
		suspendAndWaitForResume(location, createVMSuspendEvent(vmSuspension));
	}
	
	private void suspendAndWaitForResume(@NonNull UnitLocation location, @NonNull VMSuspendEvent suspendEvent) {		
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

	private void terminate() throws VMInterruptedExecutionException {
		IVMEvaluationEnvironment<?> evalEnv = getEvaluationEnvironment();
		evalEnv.throwVMException(new VMInterruptedExecutionException("User termination request"));
	}
}
