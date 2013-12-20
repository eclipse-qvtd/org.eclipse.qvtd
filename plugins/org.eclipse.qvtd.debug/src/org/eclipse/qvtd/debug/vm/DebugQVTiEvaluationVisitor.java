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
package org.eclipse.qvtd.debug.vm;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainExpression;
import org.eclipse.ocl.examples.domain.elements.DomainStandardLibrary;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.evaluation.DomainLogger;
import org.eclipse.ocl.examples.domain.evaluation.DomainModelManager;
import org.eclipse.ocl.examples.domain.types.IdResolver;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.ExpressionInOCL;
import org.eclipse.ocl.examples.pivot.LoopExp;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.ocl.examples.pivot.util.Visitable;
import org.eclipse.qvtd.debug.stubs.ASTBindingHelper;
import org.eclipse.qvtd.debug.stubs.DebugOptions;
import org.eclipse.qvtd.debug.stubs.OperationCallResult;
import org.eclipse.qvtd.debug.stubs.QvtInterruptedExecutionException;
import org.eclipse.qvtd.debug.utils.CompiledUnit;
import org.eclipse.qvtd.debug.utils.IDebugEvaluationEnvironment;
import org.eclipse.qvtd.debug.utils.QVTODebugCore;
import org.eclipse.qvtd.debug.vm.protocol.VMRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMResumeEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMResumeRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMStartEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMSuspendEvent;
import org.eclipse.qvtd.debug.vm.protocol.VMSuspendRequest;
import org.eclipse.qvtd.debug.vm.protocol.VMTerminateRequest;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitor;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorImpl;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelManager;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractWrappingQVTimperativeVisitor;

public final class DebugQVTiEvaluationVisitor extends AbstractWrappingQVTimperativeVisitor<Object, Object, QVTiEvaluationVisitor, Object> implements QVTiEvaluationVisitor
{
	private final IQVTODebuggerShell fDebugShell;
	private final VMBreakpointManager fBPM;
	private final IterateBreakpointHelper fIterateBPHelper;
	private final List<UnitLocation> fLocationStack;
	private UnitLocation fCurrentLocation;
	private int fCurrentStepMode;
	

	private DebugQVTiEvaluationVisitor(DebugQVTiEvaluationVisitor parent, EvaluationEnvironment nestedEvalEnv) {
//		super(parent, nestedEvalEnv);
		super(new QVTiEvaluationVisitorImpl(parent.getEnvironment(), nestedEvalEnv, null), null);
		delegate.setUndecoratedVisitor(this);
		DebugQVTiEvaluationVisitor debugParent = (DebugQVTiEvaluationVisitor) parent;
		fDebugShell = debugParent.fDebugShell;
		fBPM = debugParent.fBPM;
		fIterateBPHelper = debugParent.fIterateBPHelper;
		fLocationStack = debugParent.fLocationStack;
		fCurrentLocation = debugParent.fCurrentLocation;
		fCurrentStepMode = debugParent.fCurrentStepMode;
	}

	public DebugQVTiEvaluationVisitor(@NonNull Environment env, @NonNull EvaluationEnvironment evalEnv, @NonNull QVTiModelManager modelManager, IQVTODebuggerShell shell) {
//		super(env, evalEnv);
		super(new QVTiEvaluationVisitorImpl(env, evalEnv, modelManager), null);
		delegate.setUndecoratedVisitor(this);
		fDebugShell = shell;
		fBPM = shell.getBreakPointManager();
		fIterateBPHelper = new IterateBreakpointHelper(fBPM);
		fLocationStack = new ArrayList<UnitLocation>();
		fCurrentLocation = null;
		fCurrentStepMode = DebugEvent.UNSPECIFIED;


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

/*	public QvtOperationalEvaluationVisitor createDebugInterceptor() {
		return new DebugInterceptor(this);
	} */
	
/*	@Override
	protected QvtOperationalEvaluationVisitorImpl createNestedEvaluationVisitor(
			QvtOperationalEvaluationVisitorImpl parent,
			QvtOperationalEvaluationEnv nestedEvalEnv) {
		return new QVTODebugEvaluator(parent, nestedEvalEnv);
	} */

	public @NonNull Environment getEnvironment() {
		return delegate.getEnvironment();
	}

	public @NonNull IDebugEvaluationEnvironment getEvaluationEnvironment() {
		return (IDebugEvaluationEnvironment) delegate.getEvaluationEnvironment();
	}
	
//	@Override
	protected void poppedStack() {
		popLocation();
	}
		
//	@Override
	protected void pushedStack(IDebugEvaluationEnvironment env) {
		Element currentIP = env.getCurrentIP();

		UnitLocation startLocation = newLocalLocation(env, currentIP, ASTBindingHelper.getStartPosition(currentIP)); 
//				getEndPosition(currentIP) - getStartPosition(currentIP));

		pushLocation(startLocation);
	}


//	@Override
//	protected void addToEnv(String varName, Object value, EClassifier declaredType) {
//		getEvaluationEnvironment().add(varName, value, declaredType);
//	}

//	@Override
//	protected void replaceInEnv(String varName, Object value, EClassifier declaredType) {
//		getEvaluationEnvironment().replace(varName, value, declaredType);
//	}

//	@Override
	protected void processDeferredTasks() {
		IDebugEvaluationEnvironment evalEnv = getEvaluationEnvironment();
		Transformation transformation = evalEnv.getTransformation();
		UnitLocation startLocation = newLocalLocation(evalEnv, transformation, ASTBindingHelper.getEndPosition(transformation));//, 0);
		try {
			pushLocation(startLocation);

			superProcessDeferredTasks();
		} finally {
			popLocation();
		}
	}

	protected void superProcessDeferredTasks() {
		IDebugEvaluationEnvironment evalEnv = getEvaluationEnvironment();
		evalEnv.processDeferredTasks();
	}

/*	@Override
	public void notifyAfterDeferredAssign(AssignExp asssignExp,
			Object assignLeftValue) {
		QvtOperationalEvaluationEnv evalEnv = getOperationalEvaluationEnv();

		UnitLocation startLocation = newLocalLocation(evalEnv, asssignExp,
				asssignExp.getStartPosition(), getNodeLength(asssignExp));
		setCurrentLocation(asssignExp, startLocation, false);

		processDebugRequest(startLocation);

		UnitLocation endLocation = newLocalLocation(evalEnv, asssignExp,
				asssignExp.getStartPosition() + getNodeLength(asssignExp) - 1,
				1);
		setCurrentLocation(asssignExp, endLocation, true);
	} */

/*	public Object navigateProperty(EStructuralFeature property, Object target) {
		OCLExpression<EClassifier> body = getPropertyBody(property);
		if (body != null) {
			return super.navigate(property, body, target);
		}
		return getEvaluationEnvironment().navigateProperty(property, null, target);
	} */

	public List<UnitLocation> getLocationStack() {
		return fLocationStack;
	}

	@Override
	protected Object preVisit(@NonNull Visitable visitable) {
		Element element = (Element)visitable;
		setCurrentEnvInstructionPointer(element);
		
		IDebugEvaluationEnvironment evalEnv = getEvaluationEnvironment();
		
		if (element instanceof Transformation) {
			fCurrentLocation = newLocalLocation(evalEnv, element, ASTBindingHelper.getStartPosition(element)); //, getNodeLength(element));
			fCurrentLocation.toString();    // FIXME debugging
		} else if (element instanceof Operation) {
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
			UnitLocation startLocation = newLocalLocation(evalEnv, element, ASTBindingHelper.getStartPosition(element)); //, getNodeLength(element));

			setCurrentLocation(element, startLocation, false);
			// FIXME - review, should process the debug request in all cases
			processDebugRequest(startLocation);

		} else {
			setCurrentLocation(element, newLocalLocation(evalEnv, element, ASTBindingHelper.getStartPosition(element)/*, getNodeLength(element)*/), false);
		}

		return null; //result;
	}

	@Override
	protected Object postVisit(@NonNull Visitable visitable, Object preState, Object result) {
		Element element = (Element)visitable;
		IDebugEvaluationEnvironment evalEnv = getEvaluationEnvironment();
		if (element instanceof Transformation) {
			// 
		} else if (element instanceof Operation) {
			UnitLocation endLocation = newLocalLocation(evalEnv, element, ASTBindingHelper.getEndPosition(element)); //, 1);
			setCurrentLocation(element, endLocation, true);
		} else if (element instanceof EStructuralFeature) {
			// result = null;
		} else if (element instanceof LoopExp) {
			if (preState instanceof VMBreakpoint) {
				fIterateBPHelper.removeIterateBreakpoint((VMBreakpoint) preState);
			}
		} else {
			UnitLocation el = newLocalLocation(evalEnv, element, ASTBindingHelper.getEndPosition(element) - 1); //, 1);
			
			setCurrentLocation(element, el, true);
		}

		return result;
	}




	private void processDebugRequest(UnitLocation location) {
		VMRequest event = fDebugShell.popRequest();
		if (event == null) {
			return;
		}
		
		doProcessRequest(location, event);
	}
	
	private void doProcessRequest(UnitLocation location, VMRequest request) {
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
			throw new IllegalArgumentException(
					"Unsupported debug request: " + request); //$NON-NLS-1$
		}
	}

	
	protected void handleLocationChanged(@NonNull Element  element, UnitLocation location, boolean isElementEnd) {
		if (fCurrentLocation == null) {
			return;
		}
		
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
			if (!location.isTheSameLine(fCurrentLocation) /*|| repeatedInIterator(location, fCurrentLocation)*/) {
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
		for (VMBreakpoint breakpoint : fBPM.getBreakpoints(element)) {			
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

	private VMSuspendEvent createVMSuspendEvent(int eventDetail) {
		// build the VM stack frames
		VMStackFrame[] vmStack = VMStackFrame.create(getLocationStack());		
		assert vmStack.length > 0;
		return new VMSuspendEvent(vmStack, eventDetail);
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

	private UnitLocation newLocalLocation(@NonNull IDebugEvaluationEnvironment evalEnv, @NonNull Element node, int offset) {//, int length) {
		return new UnitLocation(offset, evalEnv, node);
	}

	private void setCurrentLocation(@NonNull Element element, UnitLocation newLocation,
			boolean atEnd) {
		if (fLocationStack.isEmpty()) {
			return;
		}

		// do not change to position-less locations
		if (newLocation.getOffset() < 0) {
			return;
		}

		fLocationStack.set(0, newLocation);
		handleLocationChanged(element, newLocation, atEnd);
	}

	private void pushLocation(UnitLocation location) {
		fLocationStack.add(0, location);
	}

	private UnitLocation popLocation() {
		UnitLocation removed = fLocationStack.remove(0);
		return removed;
	}

	UnitLocation getCurrentLocation() {
		return (!fLocationStack.isEmpty()) ? fLocationStack.get(0) : null;
	}

	private void terminate() throws QvtInterruptedExecutionException {
		IDebugEvaluationEnvironment evalEnv = getEvaluationEnvironment();
		evalEnv.throwQVTException(new QvtInterruptedExecutionException("User termination request"));
	}
	
	private String getMainModuleName() {
		CompiledUnit mainUnit = fBPM.getUnitManager().getMainUnit();
		if(mainUnit.getModules().isEmpty()) {
			return "<null>"; //$NON-NLS-1$
		}
		return mainUnit.getModules().get(0).getName();
	}
	
//	@Override
//	protected InternalEvaluator createInterruptibleVisitor() {
//		return (DebugInterceptor)createDebugInterceptor();
//	}
	
/*	private final class DebugInterceptor extends QvtGenericEvaluationVisitor implements InternalEvaluator {
		
		public ModuleInstance callTransformationImplicitConstructor(OperationalTransformation transformation, List<ModelInstance> args) {
			return QVTODebugEvaluator.this.callTransformationImplicitConstructor(transformation, args);
		}
		
		public OperationCallResult runMainEntry(OperationalTransformation transformation, List<Object> args) {
			return QVTODebugEvaluator.this.runMainEntry(transformation, args);
		}

		public Object execute(OperationalTransformation transformation) throws QvtRuntimeException {
			fCurrentLocation = newLocalLocation(getOperationalEvaluationEnv(), transformation, transformation
					.getStartPosition(), getNodeLength(transformation));
			
			return QVTODebugEvaluator.this.execute(transformation);
		}

		private DebugInterceptor(QvtOperationalEvaluationVisitor qvtExtVisitor) {
			super(qvtExtVisitor);
		}

		public DebugInterceptor(QVTODebugEvaluator qvtoDebugEvaluator) {
			// TODO Auto-generated constructor stub
		}

		public void setOperationalEvaluationEnv(
				QvtOperationalEvaluationEnv evalEnv) {
			QVTODebugEvaluator.this.setOperationalEvaluationEnv(evalEnv);
		}

		public QvtOperationalEvaluationEnv getOperationalEvaluationEnv() {
			return QVTODebugEvaluator.this.getOperationalEvaluationEnv();
		}

		public IContext getContext() {
			return QVTODebugEvaluator.this.getContext();
		}

		@Override
		protected Object genericPreVisitAST(ASTNode visited) {
			if (getContext().getMonitor() != null && getContext().getMonitor().isCanceled()) {    				
				throwQVTException(new QvtInterruptedExecutionException());    				
			}
			return preElementVisit(visited);
		}

		@Override
		protected Object genericPostVisitAST(ASTNode element,
				Object preVisitState, Object result) {
			return postElementVisit(element, preVisitState, result);
		}
	} */

	public void throwQVTException(QvtInterruptedExecutionException qvtInterruptedExecutionException) {
		// TODO Auto-generated method stub
		
	}

	public OperationCallResult runMainEntry(Transformation transformation, List<Object> args) {
		// TODO Auto-generated method stub
		return null;
	}
	   
    protected Element setCurrentEnvInstructionPointer(Element element) {
		IDebugEvaluationEnvironment evalEnv = getEvaluationEnvironment();
    	if (element != null) {
    		return evalEnv.setCurrentIP(element);
    	}
    	else {
    		return evalEnv.getCurrentIP();
    	}
    }

	@Override
	public Object visitVariable(Variable vd) {
		Object result = super.visitVariable(vd);
		Type declaredType = vd.getType();
		String name = vd.getName();
		EvaluationEnvironment env = getEvaluationEnvironment();
		env.replace(vd, declaredType);
//		env.replace(name, env.getValueOf(name), declaredType);

		return result;
	}

	@Override
	public @NonNull QVTiEvaluationVisitor createNestedEvaluator() {
		return delegate.createNestedEvaluator();
	}

	@Override
	public @Nullable Object evaluate(@NonNull DomainExpression body) {
		return delegate.evaluate(body);
	}

	@Override
	public @Nullable Object evaluate(@NonNull ExpressionInOCL expressionInOCL) {
		return delegate.evaluate(expressionInOCL);
	}

	@Override
	public @NonNull EvaluationVisitor getEvaluator() {
		return delegate.getEvaluator();
	}

	@Override
	public @NonNull DomainModelManager getModelManager() {
		return delegate.getModelManager();
	}

	@Override
	public @NonNull MetaModelManager getMetaModelManager() {
		return delegate.getMetaModelManager();
	}

	@Override
	public @NonNull DomainStandardLibrary getStandardLibrary() {
		return delegate.getStandardLibrary();
	}

	@Override
	public void setUndecoratedVisitor(@NonNull EvaluationVisitor evaluationVisitor) {
		delegate.setUndecoratedVisitor(evaluationVisitor);
	}

	@Override
	public @NonNull IdResolver getIdResolver() {
		return delegate.getIdResolver();
	}

	@Override
	@Nullable
	public DomainLogger getLogger() {
		return delegate.getLogger();
	}

	@Override
	public @NonNull Pattern getRegexPattern(@NonNull String regex) {
		return delegate.getRegexPattern(regex);
	}

	@Override
	public @NonNull DomainType getStaticTypeOf(@Nullable Object value) {
		return delegate.getStaticTypeOf(value);
	}

	@Override
	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Object... values) {
		return delegate.getStaticTypeOf(value, values);
	}

	@Override
	public @NonNull DomainType getStaticTypeOf(@Nullable Object value, @NonNull Iterable<?> values) {
		return delegate.getStaticTypeOf(value, values);
	}

	@Override
	public boolean isCanceled() {
		return delegate.isCanceled();
	}

	@Override
	public void setCanceled(boolean isCanceled) {
		delegate.setCanceled(isCanceled);
	}

	@Override
	public void setLogger(@Nullable DomainLogger logger) {
		delegate.setLogger(logger);
	}
}
