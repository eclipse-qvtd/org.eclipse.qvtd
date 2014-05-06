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
import org.eclipse.ocl.examples.debug.OCLDebugPlugin;
import org.eclipse.ocl.examples.debug.vm.evaluator.IVMEvaluationVisitor;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEvaluationVisitorImpl;

/**
 * OCLAbstractVMEvaluationVisitor is the base abstract class for OCL
 * evaluation visitors.
 */
public abstract class QVTiAbstractVMEvaluationVisitor extends QVTiEvaluationVisitorImpl implements IQVTiVMEvaluationVisitor
{
   /**
     * Instantiates a new OCL imperative abstract visitor.
     *
     * @param env The environment
     * @param evalEnv The evaluation environment
     */
    public QVTiAbstractVMEvaluationVisitor(@NonNull QVTiVMEnvironment env, @NonNull IQVTiVMEvaluationEnvironment evalEnv) {
        super(env, evalEnv);
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl#createNestedEvaluator()
     */
    @Override
	public abstract @NonNull IQVTiVMEvaluationVisitor createNestedEvaluator();

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
		return OCLDebugPlugin.PLUGIN_ID;
	}
}
