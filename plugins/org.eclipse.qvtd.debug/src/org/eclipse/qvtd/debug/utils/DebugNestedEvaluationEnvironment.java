package org.eclipse.qvtd.debug.utils;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.qvtd.debug.QVTdDebugPlugin;
import org.eclipse.qvtd.debug.stubs.QvtRuntimeException;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiNestedEvaluationEnvironment;

public class DebugNestedEvaluationEnvironment extends QVTiNestedEvaluationEnvironment implements IDebugEvaluationEnvironment
{
	private @Nullable Element myCurrentIP;
	private Operation myOperation;
    private final int myStackDepth;
    
	public DebugNestedEvaluationEnvironment(@NonNull IDebugEvaluationEnvironment evaluationEnvironment) {
		super(evaluationEnvironment);
		myStackDepth = evaluationEnvironment.getDepth() + 1;
	}

	@Override
	public @Nullable Element getCurrentIP() {
		return myCurrentIP;
	}

	@Override
	public int getDepth() {
		return myStackDepth;
	}

//    @Override
//    public QvtRuntimeException getException() {
//		return rootEvaluationEnvironment.getException();
//    }

	@Override
	public @Nullable Operation getOperation() {
		return myOperation;
	}

	@Override
	public @NonNull IDebugEvaluationEnvironment getParentEvaluationEnvironment() {
		return (IDebugEvaluationEnvironment) super.getParentEvaluationEnvironment();
	}

	@Override
	public DebugRootEvaluationEnvironment getRootEvaluationEnvironment() {
		return (DebugRootEvaluationEnvironment) rootEvaluationEnvironment;
	}

	public boolean isDeferredExecution() {
		return getRootEvaluationEnvironment().isDeferredExecution();
	}
    
    public void processDeferredTasks() {
    	getRootEvaluationEnvironment().processDeferredTasks();
    }

	public Element setCurrentIP(Element element) {
		Element prevValue = myCurrentIP;
		myCurrentIP = element;
		return prevValue;
	}

	public void throwQVTException(@NonNull QvtRuntimeException exception) throws QvtRuntimeException {
		try {
			getRootEvaluationEnvironment().saveThrownException(exception);
			exception.setStackQvtTrace(new QvtStackTraceBuilder(this).buildStackTrace());
		} catch (Exception e) {
			QVTdDebugPlugin.error("Failed to build QVT stack trace", e); //$NON-NLS-1$
		}
		
		throw exception;
	}
}
