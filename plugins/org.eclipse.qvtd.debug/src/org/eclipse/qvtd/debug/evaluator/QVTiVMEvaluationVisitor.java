/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEnvironmentFactory;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationVisitor;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.EvaluationVisitor;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitor;

/**
 * QVTiVMEvaluationVisitorImpl is the class for ...
 */
public class QVTiVMEvaluationVisitor extends QVTiEvaluationVisitor implements IQVTiVMEvaluationVisitor
{
	protected final @NonNull IVMEnvironmentFactory vmEnvironmentFactory;
        
    /**
     * Instantiates a new OCL evaluation visitor impl.
     * 
     * @param env
     *            the env
     * @param evalEnv
     *            the eval env
     */
    public QVTiVMEvaluationVisitor(@NonNull IQVTiVMEvaluationEnvironment evalEnv) {
        super(evalEnv);
        vmEnvironmentFactory = evalEnv.getVMEnvironmentFactory();
    }

	/** @deprecated provide nestedElement argument */
	@Deprecated
    @Override
    public @NonNull IQVTiVMEvaluationVisitor createNestedEvaluator() {
		IQVTiVMEvaluationEnvironment vmEvaluationEnvironment = (IQVTiVMEvaluationEnvironment)evaluationEnvironment;
		IQVTiVMEvaluationEnvironment nestedEvalEnv = getVMEnvironmentFactory().createVMEvaluationEnvironment(vmEvaluationEnvironment, evaluationEnvironment.getExecutableObject());
        QVTiVMEvaluationVisitor ne = new QVTiVMEvaluationVisitor(nestedEvalEnv);
        return ne;
    }

    @Override
    public @NonNull IQVTiVMEvaluationVisitor createNestedEvaluator(@NonNull NamedElement nestedElement) {
		IQVTiVMEvaluationEnvironment vmEvaluationEnvironment = (IQVTiVMEvaluationEnvironment)evaluationEnvironment;
		IQVTiVMEvaluationEnvironment nestedEvalEnv = getVMEnvironmentFactory().createVMEvaluationEnvironment(vmEvaluationEnvironment, nestedElement);
        QVTiVMEvaluationVisitor ne = new QVTiVMEvaluationVisitor(nestedEvalEnv);
        return ne;
    }

	@Override
	@NonNull
	public EvaluationVisitor createNestedUndecoratedEvaluator(@NonNull NamedElement operation) {
		EvaluationVisitor nestedEvaluationVisitor = super.createNestedUndecoratedEvaluator(operation);
		EvaluationEnvironment nestedEvaluationEnvironment = nestedEvaluationVisitor.getEvaluationEnvironment();
		if (nestedEvaluationEnvironment instanceof QVTiVMNestedEvaluationEnvironment) {
			((QVTiVMNestedEvaluationEnvironment)nestedEvaluationEnvironment).setOperation(operation);
		}
		return nestedEvaluationVisitor;
	}

	public void dispose() {}

	@Override
	public @NonNull IVMEvaluationVisitor getClonedEvaluator() {
		IQVTiVMEvaluationEnvironment oldEvaluationEnvironment = getVMEvaluationEnvironment();
		IQVTiVMEvaluationEnvironment clonedEvaluationEnvironment = oldEvaluationEnvironment.createClonedEvaluationEnvironment();
		return new QVTiVMEvaluationVisitor(clonedEvaluationEnvironment);
	}

//    @Override
	public @NonNull QVTiVMEnvironmentFactory getVMEnvironmentFactory() {
		return (QVTiVMEnvironmentFactory) vmEnvironmentFactory;
	}

//	@Override
//	public @NonNull IQVTiVMEvaluationEnvironment getEvaluationEnvironment() {
//		return (IQVTiVMEvaluationEnvironment) super.getEvaluationEnvironment();
//	}

	/* (non-Javadoc)
     * @see org.eclipse.ocl.pivot.evaluation.AbstractEvaluationVisitor#getModelManager()
     */
    @Override
	public @NonNull QVTiVMModelManager getModelManager() {
		return (QVTiVMModelManager) modelManager;
	}

	@Override
	public @NonNull String getPluginId() {
		return QVTiDebugPlugin.PLUGIN_ID;
	}

	@Override
	public @NonNull IQVTiVMEvaluationEnvironment getVMEvaluationEnvironment() {
		return (IQVTiVMEvaluationEnvironment) super.getEvaluationEnvironment();
	}
}
