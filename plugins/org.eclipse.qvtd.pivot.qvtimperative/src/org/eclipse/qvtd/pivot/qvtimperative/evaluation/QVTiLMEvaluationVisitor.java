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
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * QVTimperativeLMEvaluationVisitor is the class for ...
 */
public class QVTiLMEvaluationVisitor extends QVTiEvaluationVisitorImpl 
        implements QVTimperativeVisitor<Object> {

    /**
     * Instantiates a new QVTcore LM Evaluation Visitor.
     *
     * @param env the environment
     * @param evalEnv the evaluation environment
     * @param modelManager the model manager
     */
    public QVTiLMEvaluationVisitor(@NonNull Environment env,
            @NonNull EvaluationEnvironment evalEnv, @NonNull QVTiModelManager modelManager) {
        super(env, evalEnv, modelManager);
    }

    @Override
    public @NonNull QVTiLMEvaluationVisitor createNestedEvaluator() {
        EnvironmentFactory factory = environment.getFactory();
        EvaluationEnvironment nestedEvalEnv = factory.createEvaluationEnvironment(evaluationEnvironment);
        QVTiLMEvaluationVisitor ne = new QVTiLMEvaluationVisitor(environment, nestedEvalEnv, getModelManager());
        return ne;
    }
    

    /* (non-Javadoc)
     * @see uk.ac.york.qvtd.pivot.qvtcorebase.evaluation.QVTcoreBaseEvaluationVisitorImpl#visitBottomPattern(org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern)
     */
    @Override
    public @Nullable Object visitBottomPattern(@NonNull BottomPattern bottomPattern) {
        
    	Object result = true;
        Area area = bottomPattern.getArea();
        if (area instanceof CoreDomain) {
            /*// The bottom pattern of an L CoreDomain should not have any variables or constraints
        	if (bottomPattern.getVariable().size() != 0) {
        		LtoMMappingError(bottomPattern, "BottomPattern of L CoreDomain defined 1 or more variables.");
        	}
        	if (bottomPattern.getPredicate().size() != 0) {
        		LtoMMappingError(bottomPattern, "BottomPattern of L CoreDomain defined 1 or more predicates.");
        	}*/
        	// First the assignments because predicates must be evaluated after bindings!
        	for (Assignment assigment : bottomPattern.getAssignment()) {
                assigment.accept(getUndecoratedVisitor());
            }
        	
        	for (Predicate predicate : bottomPattern.getPredicate()) {
        		result = predicate.accept(getUndecoratedVisitor());
        		if (result != Boolean.TRUE) {
        			break;
        		}
            }
        	return result;
        }
        // LtoM Mapping. The bottomPattern belongs to a Mapping and it is visited once per
        // binding of the L domain. The bottom pattern should have the realized variables of the
        // middle model. Use the assignments to set values to their properties
        else if (area instanceof Mapping) {
            for (RealizedVariable rVar : bottomPattern.getRealizedVariable()) {
                rVar.accept(getUndecoratedVisitor());
            }
            for (Assignment assigment : bottomPattern.getAssignment()) {
                assigment.accept(getUndecoratedVisitor());
            }
            for (EnforcementOperation enforceOp : bottomPattern
                    .getEnforcementOperation()) {
                enforceOp.accept(getUndecoratedVisitor());
            }
        }
        return result;
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
        
    	/* Bindings are set by the caller, just test the predicates */
    	Object result = coreDomain.getGuardPattern().accept(getUndecoratedVisitor());
    	if (result == Boolean.TRUE) {
    		coreDomain.getBottomPattern().accept(getUndecoratedVisitor());
    	}
    	return result;
        /* THERE SHOULD BE NO VARIABLES OR PREDICATES IN THE BottomPattern
        for (Map.Entry<Variable, Set<Object>> entry : guardBindings.entrySet()) {
            Variable var = entry.getKey();
            for (Object e : entry.getValue()) {
                evaluationEnvironment.replace(var, e);
                coreDomain.getBottomPattern().accept(getUndecoratedVisitor()); 
            }
        }*/
    }
    
    
    /* (non-Javadoc)
     * @see uk.ac.york.qvtd.pivot.qvtimperative.evaluation.QVTimperativeAbstractEvaluationVisitorImpl#visitMapping(org.eclipse.qvtd.pivot.qvtimperative.Mapping)
     */
    @Override
	public @Nullable Object visitMapping(@NonNull Mapping mapping) {
        
    	if (mapping.getDomain().size() > 1) {
    		LtoMMappingError(mapping, "Max supported number of domains is 1.");
        }
    	Object result = false;
        for (Domain domain : mapping.getDomain()) {
            result = domain.accept(getUndecoratedVisitor());
        }
        if (result == Boolean.TRUE) {
        	result = mapping.getGuardPattern().accept(getUndecoratedVisitor());
            if (result == Boolean.TRUE) {
            	result = mapping.getBottomPattern().accept(getUndecoratedVisitor());
            	if (result == Boolean.TRUE) {
            		for (MappingCall mappingCall : mapping.getMappingCall()) {
	            		Mapping calledMapping = DomainUtil.nonNullModel(mappingCall.getReferredMapping());
	            		QVTiEvaluationVisitor nv = null;
	            		if (isLtoMMapping(calledMapping)) {
	            			nv =  ((QVTiEvaluationVisitor) getUndecoratedVisitor()).createNestedLMVisitor();
	            		}
	                	else if (isMtoRMapping(calledMapping)) {
	                		nv = ((QVTiEvaluationVisitor)getUndecoratedVisitor()).createNestedMRVisitor();
	                	}
	                	else if (isMtoMMapping(calledMapping)) {
	                		nv = ((QVTiEvaluationVisitor)getUndecoratedVisitor()).createNestedMMVisitor();
	                	} else {
	                		// FIXME Error
	                	}
	            		// The Undecorated visitor createNestedXXVisitor should return the undecorated, so no need
	            		// to call the getUndecoratedVisitor.
	                	if (nv != null) {
	                		mappingCall.accept(nv);
	                	}
	            	}
            	}
            }
        }
        return null;
    }
    
    /**
     * L to M Mapping error.
     *
     * @param node the node
     * @param cause the cause
     */
    private void LtoMMappingError(Element node, String cause) {
    	// TODO add logger
        throw new IllegalArgumentException("Unsupported " + node.eClass().getName()
                + " specification in Left to Middle mapping. " + cause);
    }

}
