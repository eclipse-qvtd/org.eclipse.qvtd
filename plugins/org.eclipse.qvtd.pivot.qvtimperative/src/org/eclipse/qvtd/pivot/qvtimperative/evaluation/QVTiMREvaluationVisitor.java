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
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * QVTcoreMREvaluationVisitor is the class for ...
 */
public class QVTiMREvaluationVisitor extends QVTiEvaluationVisitorImpl
        implements QVTimperativeVisitor<Object> {

    /**
     * Instantiates a new qV tcore mr evaluation visitor.
     *
     * @param env the environment
     * @param evalEnv the evaluation environment
     * @param modelManager the model manager
     */
    public QVTiMREvaluationVisitor(@NonNull Environment env,
            @NonNull EvaluationEnvironment evalEnv, @NonNull QVTiModelManager modelManager) {
        super(env, evalEnv, modelManager);
    }

    @Override
    public @NonNull QVTiEvaluationVisitor createNestedEvaluator() {
        EnvironmentFactory factory = environment.getFactory();
        EvaluationEnvironment nestedEvalEnv = factory.createEvaluationEnvironment(evaluationEnvironment);
        QVTiMREvaluationVisitor ne = new QVTiMREvaluationVisitor(environment, nestedEvalEnv, getModelManager());
        return ne;
    }

    /* (non-Javadoc)
     * @see org.eclipse.qvtd.pivot.qvtcore.evaluation.QVTcoreAbstractEvaluationVisitorImpl#visitBottomPattern(org.eclipse.qvtd.pivot.qvtcore.BottomPattern)
     */
    @Override
    public @Nullable Object visitBottomPattern(@NonNull BottomPattern bottomPattern) {
        //Map<Variable, Set<Object>> patternValidBindings = new HashMap<>();
        Area area = bottomPattern.getArea();
        if (area instanceof CoreDomain) {
            for (RealizedVariable rVar : bottomPattern.getRealizedVariable()) {
                rVar.accept(getUndecoratedVisitor());
            }
            for (Assignment assigment : bottomPattern.getAssignment()) {
                assigment.accept(getUndecoratedVisitor());
            }
            /* // Probably enforcement operations must be called too
            for (EnforcementOperation enforceOp : bottomPattern
                    .getEnforcementOperation()) {
                enforceOp.accept(getUndecoratedVisitor());
            }*/
        }
        else if (area instanceof Mapping) {
            for (Assignment assigment : bottomPattern.getAssignment()) {
                assigment.accept(getUndecoratedVisitor());
            }
            for (EnforcementOperation enforceOp : bottomPattern
                    .getEnforcementOperation()) {
                enforceOp.accept(getUndecoratedVisitor());
            }
        }
        return null;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor#visitCoreDomain(org
     * .eclipse.qvtd.pivot.qvtcore.CoreDomain)
     */
    @Override
	public @Nullable Object visitCoreDomain(@NonNull CoreDomain coreDomain) {
        
    	/*// THERE SHULD BE NO GUARD PATTERN IN THE R CoreDomain
        coreDomain.getGuardPattern().accept(getUndecoratedVisitor());
        */
        Object result = coreDomain.getGuardPattern().accept(getUndecoratedVisitor());
        if (result == Boolean.TRUE) {
        	coreDomain.getBottomPattern().accept(getUndecoratedVisitor());
        }
        return result;
    }
    
    
    /* (non-Javadoc)
     * @see org.eclipse.qvtd.pivot.qvtcore.evaluation.QVTcoreAbstractEvaluationVisitorImpl#visitMapping(org.eclipse.qvtd.pivot.qvtcore.Mapping)
     */
    @Override
	public @Nullable Object visitMapping(@NonNull Mapping mapping) {
        
    	if (mapping.getDomain().size() > 1) {
        	MtoRMappingError(mapping, "Max supported number of domains is 1.");
        }
    	GuardPattern gp = mapping.getGuardPattern();
    	Object result = null;
    	if (gp != null) {
    		result = gp.accept(getUndecoratedVisitor());
    		if (result == Boolean.TRUE) {
            	for (Domain domain : mapping.getDomain()) {
                    result = domain.accept(getUndecoratedVisitor());
                }
            	if (result == Boolean.TRUE) {
            		mapping.getBottomPattern().accept(getUndecoratedVisitor());
                	for (MappingCall mappingCall : mapping.getMappingCall()) {
                    	mappingCall.accept(getUndecoratedVisitor());
                    }
            	}
            }
    		// After the mapping has been visited, set all "initialized variables"
    		// values to null
    		for (Variable v : gp.getVariable()) {
    			if (v.getInitExpression() != null) {
    				evaluationEnvironment.replace(v, null);
    			}
    		}
    		for (Domain domain : mapping.getDomain()) {
    			for (Variable v : ((CoreDomain)domain).getBottomPattern().getVariable()) {
        			if (v.getInitExpression() != null) {
        				evaluationEnvironment.replace(v, null);
        			}
        		}
            }
    	}
        return null;
    }
    

    
    /**
     * MtoR mapping error.
     *
     * @param node the node
     * @param cause the cause
     */
    private void MtoRMappingError(Element node, String cause) {
        throw new IllegalArgumentException("Unsupported " + node.eClass().getName()
                + " specification in Middle to Right mapping. " + cause);
    }
}
