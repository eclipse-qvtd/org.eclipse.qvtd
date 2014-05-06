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

/**
 * QVTiVMEvaluationVisitorImpl is the class for ...
 */
public class QVTiVMEvaluationVisitorImpl extends QVTiAbstractVMEvaluationVisitor {

        
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
}
