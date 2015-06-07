/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.debug.vm.VariableFinder;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEnvironmentFactory;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironmentExtension;
import org.eclipse.ocl.examples.debug.vm.utils.ASTBindingHelper;
import org.eclipse.ocl.examples.debug.vm.utils.VMRuntimeException;
import org.eclipse.ocl.examples.debug.vm.utils.VMStackTraceBuilder;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.debug.core.QVTiDebugCore;
import org.eclipse.qvtd.debug.vm.QVTiVariableFinder;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiModelManager;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiRootEvaluationEnvironment;

public class QVTiVMRootEvaluationEnvironment extends QVTiRootEvaluationEnvironment implements IQVTiVMEvaluationEnvironment, IVMEvaluationEnvironmentExtension
{
	protected final @NonNull IVMEnvironmentFactory vmEnvironmentFactory;
//	private IContext myContext;
	private List<Runnable> myDeferredTasks;
//    private EObjectEStructuralFeaturePair myLastAssignLvalue;	  
//    private ModelParameterExtent myUnboundExtent;
    private boolean myIsDeferedExecution;
//    private QvtRuntimeException myException;
//    private Trace myTraces;
	private @NonNull Element myCurrentIP;
	private final long id;
	private final @NonNull Variable pcVariable;
	private final @NonNull Stack<StepperEntry> stepperStack = new Stack<StepperEntry>();

    public QVTiVMRootEvaluationEnvironment(@NonNull IVMEnvironmentFactory vmEnvironmentFactory, @NonNull Transformation executableObject, @NonNull QVTiModelManager modelManager, long id) {
		super(vmEnvironmentFactory.getEnvironmentFactory(), executableObject, modelManager);
		this.vmEnvironmentFactory = vmEnvironmentFactory;
		myCurrentIP = executableObject;
		this.id = id;
		pcVariable = ClassUtil.nonNullEMF(PivotFactory.eINSTANCE.createVariable());
		pcVariable.setName("$pc");
		String typeName = ClassUtil.nonNullEMF(PivotPackage.Literals.NAMED_ELEMENT.getName());
		pcVariable.setType(environmentFactory.getMetamodelManager().getASClass(typeName));
	}

	@Override
	public @NonNull IQVTiVMEvaluationEnvironment createClonedEvaluationEnvironment() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public @NonNull VariableFinder createVariableFinder(boolean isStoreValues) {
		return new QVTiVariableFinder(this, isStoreValues);
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

	public @NonNull QVTiDebugCore getDebugCore() {
		return QVTiDebugCore.INSTANCE;
	}

	@Override
	public @NonNull Transformation getDebuggableElement() {
		return getTransformation();
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
	public @NonNull QVTiVMModelManager getModelManager() {
		return (QVTiVMModelManager) super.getModelManager();
	}
	
	/** @deprecated no longer useful */
	@Deprecated
	public @NonNull Map<String, Resource> getModelParameterVariables() {
		return new HashMap<String, Resource>();
/*		Transformation currentModule = getTransformation();		
//		if (!(currentModule instanceof Transformation)) {
//			return Collections.emptyMap();
//		}

		Map<String, Resource> result = new HashMap<String, Resource>(2);
		Transformation currentTransformation = currentModule;
		QVTiVMModelManager modelManager = getModelManager();
		for (TypedModel typedModel : currentTransformation.getModelParameter()) {
			if (typedModel != null) {
				Resource model = modelManager.getModel(typedModel);
				result.put(typedModel.getName(), model);
			}
		}
		
//		ModelInstance intermModel = currentTransformation.getAdapter(
//				TransformationInstance.InternalTransformation.class)
//				.getIntermediateExtent();
//		if(intermModel != null) {
//			result.put("_intermediate", intermModel);
//		}
		
		return result; */
	}

	@Override
	public @NonNull NamedElement getOperation() {
		return getTransformation();
	}

	@Override
	@NonNull public Variable getPCVariable() {
		return pcVariable;
	}

	@Override
	public @NonNull QVTiRootEvaluationEnvironment getRootEvaluationEnvironment() {
		return this;
	}

	@Override
	public @NonNull Stack<org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationEnvironment.StepperEntry> getStepperStack() {
		return stepperStack;
	}

	@Override
	public @NonNull IVMEnvironmentFactory getVMEnvironmentFactory() {
		return vmEnvironmentFactory;
	}

	@Override
	public @Nullable QVTiVMRootEvaluationEnvironment getVMParentEvaluationEnvironment() {
		return (QVTiVMRootEvaluationEnvironment) super.getParentEvaluationEnvironment();
	}

	@Override
	public @NonNull QVTiVMRootEvaluationEnvironment getVMRootEvaluationEnvironment() {
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
	
    protected void saveThrownException(@NonNull VMRuntimeException exception) {
//    	myException = exception;
    }

	public @NonNull Element setCurrentIP(@NonNull Element element) {
		Element prevValue = myCurrentIP;
		myCurrentIP = element;
		return prevValue;
	}

    public void setException(@NonNull VMRuntimeException exception) {
    	saveThrownException(exception);
    }

	public void throwVMException(@NonNull VMRuntimeException exception) throws VMRuntimeException {
		try {
			saveThrownException(exception);
			exception.setStackVMTrace(new VMStackTraceBuilder(this).buildStackTrace());
		} catch (Exception e) {
			getDebugCore().error("Failed to build VM stack trace", e); //$NON-NLS-1$
		}
		
		throw exception;
	}
}
