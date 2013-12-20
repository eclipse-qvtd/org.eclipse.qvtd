package org.eclipse.qvtd.debug.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.qvtd.debug.QVTdDebugPlugin;
import org.eclipse.qvtd.debug.stubs.ASTBindingHelper;
import org.eclipse.qvtd.debug.utils.QvtStackTraceBuilder;
import org.eclipse.qvtd.debug.vm.UnitLocation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiNestedEvaluationEnvironment;

public class DebugNestedEvaluationEnvironment extends QVTiNestedEvaluationEnvironment implements IDebugEvaluationEnvironment
{
	private @Nullable Element myCurrentIP;
	private NamedElement myOperation;
    private final int myStackDepth;
	private final long id;
    
	public DebugNestedEvaluationEnvironment(@NonNull IDebugEvaluationEnvironment evaluationEnvironment, long id, @NonNull NamedElement operation) {
		super(evaluationEnvironment);
		myStackDepth = evaluationEnvironment.getDepth() + 1;
		this.id = id;
		this.myOperation = operation;
	}

	@Override
	public @Nullable Element getCurrentIP() {
		return myCurrentIP;
	}

	public @Nullable UnitLocation getCurrentLocation() {
		if (myCurrentIP == null) {
			return null;
		}
		else {
			int offset = ASTBindingHelper.getStartPosition(myCurrentIP);
			return new UnitLocation(offset, this, myCurrentIP); 
		}
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
	public long getID() {
		return id;
	}

	@Override
	public @Nullable NamedElement getOperation() {
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
