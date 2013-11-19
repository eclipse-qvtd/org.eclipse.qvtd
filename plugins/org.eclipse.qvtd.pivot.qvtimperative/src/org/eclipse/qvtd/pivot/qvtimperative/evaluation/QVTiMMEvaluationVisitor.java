/*******************************************************************************
 * Copyright (c) 2013 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     hhoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * QVTcoreMMEvaluationVisitorImpl is the class for ...
 */
public class QVTiMMEvaluationVisitor extends QVTiEvaluationVisitorImpl
        implements QVTimperativeVisitor<Object> {

    /**
     * Instantiates a new QVTcore MM Evaluation Visitor.
     *
     * @param env the environment
     * @param evalEnv the evaluation environment
     * @param modelManager the model manager
     */
    public QVTiMMEvaluationVisitor(@NonNull Environment env,
            @NonNull EvaluationEnvironment evalEnv, @NonNull QVTiModelManager modelManager) {
        super(env, evalEnv, modelManager);
    }

    @Override
    public @NonNull QVTiEvaluationVisitor createNestedEvaluator() {
        EnvironmentFactory factory = environment.getFactory();
        EvaluationEnvironment nestedEvalEnv = factory.createEvaluationEnvironment(evaluationEnvironment);
        QVTiMMEvaluationVisitor ne = new QVTiMMEvaluationVisitor(environment, nestedEvalEnv, getModelManager());
        return ne;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor#visitBottomPattern
     * (org.eclipse.qvtd.pivot.qvtcore.BottomPattern)
     */
    @Override
	public @Nullable Object visitBottomPattern(@NonNull BottomPattern bottomPattern) {
        // This visit should be called for MiddleBottomPatterns with no domains
        Area area = bottomPattern.getArea();
        if (area instanceof Mapping && ((Mapping)area).getDomain().size() == 0) {
            // What is the environment??
            for (Assignment assigment : bottomPattern.getAssignment()) {
                assigment.accept(undecoratedVisitor);
            }
            // Probably enforcement operations must be called too
            for (EnforcementOperation enforceOp : bottomPattern.getEnforcementOperation()) {
                enforceOp.accept(undecoratedVisitor);
            }
            return true;
        }
        return null;
    }
    
    @Override
	public @Nullable Object visitMapping(@NonNull Mapping object) {
		return visiting(object);
    }
}
