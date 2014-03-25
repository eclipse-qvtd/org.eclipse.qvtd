package org.eclipse.qvtd.debug.evaluator;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.core.VMDebugCore;
import org.eclipse.ocl.examples.debug.evaluator.VMRuntimeException;
import org.eclipse.ocl.examples.debug.stubs.ASTBindingHelper;
import org.eclipse.ocl.examples.debug.utils.VMStackTraceBuilder;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.IQVTiEvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiNestedEvaluationEnvironment;

public class QVTiVMNestedEvaluationEnvironment extends QVTiNestedEvaluationEnvironment implements IQVTiVMEvaluationEnvironment
{
	private @NonNull Element myCurrentIP;
	private @NonNull NamedElement myOperation;
    private final int myStackDepth;
	private final long id;
    
	public QVTiVMNestedEvaluationEnvironment(@NonNull IQVTiVMEvaluationEnvironment evaluationEnvironment, long id, @NonNull NamedElement operation) {
		super(evaluationEnvironment);
		myStackDepth = evaluationEnvironment.getDepth() + 1;
		this.id = id;
		this.myOperation = operation;
		this.myCurrentIP = operation;
	}

	@Override
	public @NonNull IQVTiEvaluationEnvironment createClonedEvaluationEnvironment() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Element getCurrentIP() {
		return myCurrentIP;
	}

	public @NonNull UnitLocation getCurrentLocation() {
//		if (myCurrentIP == null) {
//			return null;
//		}
//		else {
		int startPosition = ASTBindingHelper.getStartPosition(myCurrentIP);
		int endPosition = ASTBindingHelper.getEndPosition(myCurrentIP);
			return new UnitLocation(startPosition, endPosition, this, myCurrentIP); 
//		}
	}

	public @NonNull VMDebugCore getDebugCore() {
		return getRootEvaluationEnvironment().getDebugCore();
	}

	public @NonNull Transformation getDebuggableElement() {
		return getRootEvaluationEnvironment().getDebuggableElement();
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
	public @NonNull QVTiVMModelManager getModelManager() {
		return (QVTiVMModelManager) super.getModelManager();
	}
	
	public @NonNull Map<String, Resource> getModelParameterVariables() {
    	return getRootEvaluationEnvironment().getModelParameterVariables();
	}

	@Override
	public @NonNull NamedElement getOperation() {
		return myOperation;
	}

	@Override
	public @Nullable IQVTiVMEvaluationEnvironment getParentEvaluationEnvironment() {
		return (IQVTiVMEvaluationEnvironment) super.getParentEvaluationEnvironment();
	}

	@Override
	public @NonNull QVTiRootVMEvaluationEnvironment getRootEvaluationEnvironment() {
		return (QVTiRootVMEvaluationEnvironment) rootEvaluationEnvironment;
	}

	public boolean isDeferredExecution() {
		return getRootEvaluationEnvironment().isDeferredExecution();
	}
    
    public void processDeferredTasks() {
    	getRootEvaluationEnvironment().processDeferredTasks();
    }

	public @NonNull Element setCurrentIP(@NonNull Element element) {
		Element prevValue = myCurrentIP;
		myCurrentIP = element;
		return prevValue;
	}

	public void throwQVTException(@NonNull VMRuntimeException exception) throws VMRuntimeException {
		try {
			getRootEvaluationEnvironment().saveThrownException(exception);
			exception.setStackQvtTrace(new VMStackTraceBuilder(this).buildStackTrace());
		} catch (Exception e) {
			getDebugCore().error("Failed to build QVT stack trace", e); //$NON-NLS-1$
		}
		
		throw exception;
	}
}
