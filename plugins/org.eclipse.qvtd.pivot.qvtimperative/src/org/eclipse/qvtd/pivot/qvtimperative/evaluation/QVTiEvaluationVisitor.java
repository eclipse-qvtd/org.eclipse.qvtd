/*******************************************************************************
 * Copyright (c) 2012, 2014 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * QVTimperativeEvaluationVisitor is the class for ...
 */
public class QVTiEvaluationVisitor extends QVTiAbstractEvaluationVisitor {

        
    /**
     * Instantiates a new qV tcore evaluation visitor impl.
     * 
     * @param env
     *            the env
     * @param evalEnv
     *            the eval env
     */
    public QVTiEvaluationVisitor(@NonNull IQVTiEvaluationEnvironment evalEnv) {
        super(evalEnv);
    }

    @Override
    public @NonNull IQVTiEvaluationVisitor createNestedEvaluator() {
        QVTiEnvironmentFactory environmentFactory = getEnvironmentFactory();
		IQVTiEvaluationEnvironment nestedEvalEnv = environmentFactory.createEvaluationEnvironment(evaluationEnvironment, evaluationEnvironment.getExecutableObject());
        QVTiEvaluationVisitor nestedEvaluationVisitor = new QVTiEvaluationVisitor(nestedEvalEnv);
        nestedEvaluationVisitor.setMonitor(getMonitor());
        return nestedEvaluationVisitor;
    }

    /* (non-Javadoc)
     * @see uk.ac.york.qvtd.pivot.qvtcorebase.evaluation.QVTcoreBaseEvaluationVisitorImpl#visitBottomPattern(org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern)
     */
    @Override
    public @Nullable Object visitBottomPattern(@NonNull BottomPattern bottomPattern) {
        
    	Object result = true;
        Area area = bottomPattern.getArea();
        if (area instanceof CoreDomain) {
        	assert bottomPattern.getAssignment().isEmpty();
        	for (Predicate predicate : bottomPattern.getPredicate()) {
        		result = predicate.accept(undecoratedVisitor);
        		if (result != Boolean.TRUE) {
        			break;
        		}
            }
            for (RealizedVariable rVar : bottomPattern.getRealizedVariable()) {
                rVar.accept(undecoratedVisitor);
            }
//            for (Assignment assigment : bottomPattern.getAssignment()) {
//                assigment.accept(undecoratedVisitor);
//            }
            for (EnforcementOperation enforceOp : bottomPattern.getEnforcementOperation()) {
                enforceOp.accept(undecoratedVisitor);
            }
        	return result;
        }
        // LtoM Mapping. The bottomPattern belongs to a Mapping and it is visited once per
        // binding of the L domain. The bottom pattern should have the realized variables of the
        // middle model. Use the assignments to set values to their properties
        else {
        	assert area instanceof Mapping;
        	assert bottomPattern.getPredicate().isEmpty();
        	assert bottomPattern.getRealizedVariable().isEmpty();
        	assert bottomPattern.getEnforcementOperation().isEmpty();
//            for (RealizedVariable rVar : bottomPattern.getRealizedVariable()) {
//                rVar.accept(undecoratedVisitor);
//            }
            for (Assignment assigment : bottomPattern.getAssignment()) {
                assigment.accept(undecoratedVisitor);
            }
//            for (EnforcementOperation enforceOp : bottomPattern.getEnforcementOperation()) {
//                enforceOp.accept(undecoratedVisitor);
//            }
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
    	Object result = coreDomain.getGuardPattern().accept(undecoratedVisitor);
    	if (result == Boolean.TRUE) {
    		coreDomain.getBottomPattern().accept(undecoratedVisitor);
    	}
    	return result;
        /* THERE SHOULD BE NO VARIABLES OR PREDICATES IN THE BottomPattern
        for (Map.Entry<Variable, Set<Object>> entry : guardBindings.entrySet()) {
            Variable var = entry.getKey();
            for (Object e : entry.getValue()) {
                evaluationEnvironment.replace(var, e);
                coreDomain.getBottomPattern().accept(undecoratedVisitor); 
            }
        }*/
    }

    @Override
    public @Nullable Object visitImperativeModel(@NonNull ImperativeModel imperativeModel) {
    	for (org.eclipse.ocl.pivot.Package pkge : imperativeModel.getOwnedPackages()) {
    		pkge.accept(undecoratedVisitor);
    	}
        return true;
    }
    
    /* (non-Javadoc)
     * @see uk.ac.york.qvtd.pivot.qvtimperative.evaluation.QVTimperativeAbstractEvaluationVisitorImpl#visitMapping(org.eclipse.qvtd.pivot.qvtimperative.Mapping)
     */
	@Override
	public @Nullable Object visitMapping(@NonNull Mapping mapping) {
        GuardPattern gp = mapping.getGuardPattern();
        if (gp != null) {
        	Object result = gp.accept(undecoratedVisitor);
            if (result != Boolean.TRUE) {
            	return null;
            }
        }
/*        for (Domain domain : mapping.getDomain()) {
            if (domain.isIsCheckable()) {
            	Object result = domain.accept(undecoratedVisitor);
                if (result != Boolean.TRUE) {
                	return result;
                }
           }
        } */
        for (Domain domain : mapping.getDomain()) {
            if (domain.isIsEnforceable()) {
            	domain.accept(undecoratedVisitor);
           }
        }
        /*result =*/ mapping.getBottomPattern().accept(undecoratedVisitor);
//      if (result == Boolean.TRUE) {
			MappingStatement mappingStatement = mapping.getMappingStatement();
			if (mappingStatement != null) {
				mappingStatement.accept(undecoratedVisitor);
			}
//    	}
        return null;
    }

    @Override
    public @Nullable Object visitPackage(@NonNull org.eclipse.ocl.pivot.Package pkge) {
        return true;
    }

	@Override
    public @Nullable Object visitTransformation(@NonNull Transformation transformation) {
        Rule rule = NameUtil.getNameable(transformation.getRule(), QVTimperativeUtil.ROOT_MAPPING_NAME);
        if (rule == null) {
        	throw new IllegalStateException("Transformation " + transformation.getName() + " has no root mapping");
        }
    	IQVTiEvaluationVisitor nv = ((IQVTiEvaluationVisitor) undecoratedVisitor).createNestedEvaluator();
        rule.accept(nv);
        return true;
    }
}
