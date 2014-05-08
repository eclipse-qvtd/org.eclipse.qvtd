/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
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
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationVisitor;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorImpl;

/**
 * QVTiVMEvaluationVisitorImpl is the class for ...
 */
public class QVTiVMEvaluationVisitorImpl extends QVTiEvaluationVisitorImpl implements IQVTiVMEvaluationVisitor {

        
    /**
     * Instantiates a new OCL evaluation visitor impl.
     * 
     * @param env
     *            the env
     * @param evalEnv
     *            the eval env
     */
    public QVTiVMEvaluationVisitorImpl(@NonNull QVTiVMEnvironment env, @NonNull IQVTiVMEvaluationEnvironment evalEnv) {
        super(env, evalEnv);
    }

    @Override
    public @NonNull IQVTiVMEvaluationVisitor createNestedEvaluator() {
    	QVTiVMEnvironment vmEnvironment = getEnvironment();
		QVTiVMEnvironmentFactory factory = vmEnvironment.getFactory();
		IQVTiVMEvaluationEnvironment nestedEvalEnv = factory.createEvaluationEnvironment(evaluationEnvironment);
        QVTiVMEvaluationVisitorImpl ne = new QVTiVMEvaluationVisitorImpl(vmEnvironment, nestedEvalEnv);
        return ne;
    }

	public void dispose() {}

	@Override
	public @NonNull IVMEvaluationVisitor<Transformation> getClonedEvaluator() {
		IQVTiVMEvaluationEnvironment oldEvaluationEnvironment = getEvaluationEnvironment();
		IQVTiVMEvaluationEnvironment clonedEvaluationEnvironment = oldEvaluationEnvironment.createClonedEvaluationEnvironment();
		return new QVTiVMEvaluationVisitorImpl(getEnvironment(), clonedEvaluationEnvironment);
	}

    @Override
	public @NonNull QVTiVMEnvironment getEnvironment() {
		return (QVTiVMEnvironment) super.getEnvironment();
	}

	@Override
	public @NonNull IQVTiVMEvaluationEnvironment getEvaluationEnvironment() {
		return (IQVTiVMEvaluationEnvironment) super.getEvaluationEnvironment();
	}

	/* (non-Javadoc)
     * @see org.eclipse.ocl.examples.pivot.evaluation.AbstractEvaluationVisitor#getModelManager()
     */
    @Override
	public @NonNull QVTiVMModelManager getModelManager() {
		return (QVTiVMModelManager) modelManager;
	}

	@Override
	public @NonNull String getPluginId() {
		return QVTiDebugPlugin.PLUGIN_ID;
	}
}
