package org.eclipse.qvtd.debug.utils;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.ocl.examples.pivot.evaluation.PivotEvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.QVTdDebugPlugin;
import org.eclipse.qvtd.debug.stubs.QvtRuntimeException;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public abstract class ZZDebugEvaluationEnvironment extends PivotEvaluationEnvironment implements IDebugEvaluationEnvironment
{
	protected final @NonNull DebugRootEvaluationEnvironment rootEvaluationEnvironment;
//    private ThisInstanceResolver myThisResolver;		
	private @Nullable Element myCurrentIP;
	private Operation myOperation;
    private final int myStackDepth;    
	
	protected ZZDebugEvaluationEnvironment(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
		rootEvaluationEnvironment = getRootEvaluationEnvironment();
		myStackDepth = 1;
	}

	protected ZZDebugEvaluationEnvironment(@NonNull ZZDebugEvaluationEnvironment evaluationEnvironment) {
		super(evaluationEnvironment);
		rootEvaluationEnvironment = evaluationEnvironment.rootEvaluationEnvironment;
		myStackDepth = evaluationEnvironment.myStackDepth + 1;
	}

	public @Nullable Element getCurrentIP() {
		return myCurrentIP;
	}

//	public TypeInstance getCurrentInstance() {		
//		return (myThisResolver instanceof TypeInstance) ? (TypeInstance)myThisResolver : null;
//	}

	public abstract Transformation getCurrentTransformation();

//	public abstract TransformationInstance getCurrentTransformationInstance();

	public int getDepth() {
		return myStackDepth;
	}

//	public abstract QvtRuntimeException getException();
	    
	/**
	 * Gets the operation being currently executed.
	 * 
	 * @return the operation of <code>null</code> if no operation context is
	 *         available
	 */    
	public Operation getOperation() {
		return myOperation;
	}

	public ZZDebugEvaluationEnvironment getParentEvaluationEnvironment() {
		return (ZZDebugEvaluationEnvironment) parent;
	}

	public abstract DebugRootEvaluationEnvironment getRootEvaluationEnvironment();

	public List<QVTStackTraceElement> getStackTraceElements() {
    	return new QvtStackTraceBuilder(this).buildStackTrace();
    }		

	public abstract boolean isDeferredExecution();
	
	public abstract void processDeferredTasks();

	protected abstract void saveThrownException(@NonNull QvtRuntimeException exception);

	public Element setCurrentIP(Element element) {
		Element prevValue = myCurrentIP;
		myCurrentIP = element;
		return prevValue;
	}

	/**
	 * Sets the operation being currently executed.
	 */
	public void setOperation(Operation myOperation) {
		this.myOperation = myOperation;
	}

	public void throwQVTException(@NonNull QvtRuntimeException exception) throws QvtRuntimeException {
		try {
			saveThrownException(exception);
			exception.setStackQvtTrace(getStackTraceElements());
		} catch (Exception e) {
			QVTdDebugPlugin.error("Failed to build QVT stack trace", e); //$NON-NLS-1$
		}
		
		throw exception;
	}
}
