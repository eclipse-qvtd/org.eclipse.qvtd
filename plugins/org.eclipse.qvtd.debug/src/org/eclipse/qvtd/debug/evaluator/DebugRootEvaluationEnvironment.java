package org.eclipse.qvtd.debug.evaluator;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.debug.QVTdDebugPlugin;
import org.eclipse.qvtd.debug.stubs.ASTBindingHelper;
import org.eclipse.qvtd.debug.utils.QvtStackTraceBuilder;
import org.eclipse.qvtd.debug.vm.UnitLocation;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelManager;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiRootEvaluationEnvironment;

public class DebugRootEvaluationEnvironment extends QVTiRootEvaluationEnvironment implements IDebugEvaluationEnvironment
{
//	private IContext myContext;
	private List<Runnable> myDeferredTasks;
//    private EObjectEStructuralFeaturePair myLastAssignLvalue;	  
//    private ModelParameterExtent myUnboundExtent;
    private boolean myIsDeferedExecution;
//    private QvtRuntimeException myException;
//    private Trace myTraces;
	private @NonNull Element myCurrentIP;
	private final long id;

    public DebugRootEvaluationEnvironment(@NonNull MetaModelManager metaModelManager, @NonNull QVTiModelManager modelManager, @NonNull Transformation transformation, long id) {
		super(metaModelManager, modelManager, transformation);
		myCurrentIP = transformation;
		this.id = id;
	}

//    @Override
//    IContext getContext() {
//    	return myContext;
//    }

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

	@Override
	public int getDepth() {
		return 1;
	}

//    @Override
//    public QvtRuntimeException getException() {
//    	return myException;
//    }

	@Override
	public long getID() {
		return id;
	}

	@Override
	public @Nullable NamedElement getOperation() {
		return null;
	}

	@Override
	public @Nullable DebugRootEvaluationEnvironment getParentEvaluationEnvironment() {
		return (DebugRootEvaluationEnvironment) super.getParentEvaluationEnvironment();
	}

	@Override
	public @NonNull DebugRootEvaluationEnvironment getRootEvaluationEnvironment() {
		return this;
	}

    @Override
	public boolean isDeferredExecution() {
		return myIsDeferedExecution;
	}
	    
	@Override
	public void processDeferredTasks() {
		if (myDeferredTasks != null) {
			try {
				myIsDeferedExecution = true;	    			
				// make me re-entrant in case of errorenous call to #addDeferredTask() 
				// from running the task => concurrent modification exception
				// This error condition should be handled elsewhere
				List<Runnable> tasksCopy = new ArrayList<Runnable>(myDeferredTasks);
			    for (Runnable task : tasksCopy) {
		            task.run();
		        }
			} finally {
				myIsDeferedExecution = false;	    			
			}
		}
	}
	
    protected void saveThrownException(@NonNull QvtRuntimeException exception) {
//    	myException = exception;
    }

	public @NonNull Element setCurrentIP(@NonNull Element element) {
		Element prevValue = myCurrentIP;
		myCurrentIP = element;
		return prevValue;
	}

    public void setException(@NonNull QvtRuntimeException exception) {
    	saveThrownException(exception);
    }

	public void throwQVTException(@NonNull QvtRuntimeException exception) throws QvtRuntimeException {
		try {
			saveThrownException(exception);
			exception.setStackQvtTrace(new QvtStackTraceBuilder(this).buildStackTrace());
		} catch (Exception e) {
			QVTdDebugPlugin.error("Failed to build QVT stack trace", e); //$NON-NLS-1$
		}
		
		throw exception;
	}
}
