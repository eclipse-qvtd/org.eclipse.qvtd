/*******************************************************************************
 * Copyright (c) 2012, 2013 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.PivotIdResolver;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;

/**
 * QVTimperativeEvaluationVisitor is the class for ...
 */
public class QVTiEvaluationVisitorImpl extends QVTiAbstractEvaluationVisitor {

        
    /**
     * Instantiates a new qV tcore evaluation visitor impl.
     * 
     * @param env
     *            the env
     * @param evalEnv
     *            the eval env
     * @param modelManager
     *            the model manager
     */
    public QVTiEvaluationVisitorImpl(@NonNull Environment env,
            @NonNull EvaluationEnvironment evalEnv,
            @NonNull QVTiModelManager modelManager) {
        super(env, evalEnv, modelManager);
    }

    @Override
    public @NonNull QVTiEvaluationVisitor createNestedEvaluator() {
        EnvironmentFactory factory = environment.getFactory();
        EvaluationEnvironment nestedEvalEnv = factory.createEvaluationEnvironment(evaluationEnvironment);
        QVTiEvaluationVisitorImpl ne = new QVTiEvaluationVisitorImpl(environment, nestedEvalEnv, getModelManager());
        return ne;
    }

	private void doMappingCallRecursion(@NonNull Rule rule, @NonNull List<Variable> rootVariables,
			@NonNull List<List<Object>> rootBindings, int depth) {
		int nextDepth = depth+1;
		int maxDepth = rootVariables.size();
		Variable var = rootVariables.get(depth);
		Type guardType = var.getType();
		PivotIdResolver idResolver = metaModelManager.getIdResolver();
        for (Object binding : rootBindings.get(depth)) {
			DomainType valueType = idResolver.getDynamicTypeOf(binding);
			if ((guardType != null) && valueType.conformsTo(metaModelManager, guardType)) {
	        	evaluationEnvironment.replace(var, binding);
	        	if (nextDepth < maxDepth) {
	        		doMappingCallRecursion(rule, rootVariables, rootBindings, nextDepth);
	        	}
	        	else {
	        		// The MiddleGuardPattern should be empty in the root mapping, i.e. no need to find bindings
	            	rule.accept(getUndecoratedVisitor());
	        	}
			}
        }
	}

    @Override
    public @Nullable Object visitImperativeModel(@NonNull ImperativeModel imperativeModel) {
    	for (org.eclipse.ocl.examples.pivot.Package pkge : imperativeModel.getNestedPackage()) {
    		pkge.accept(getUndecoratedVisitor());
    	}
        return true;
    }
    
    public @Nullable Object visitMapping(@NonNull Mapping object) {
		return visiting(object);
    }

    @Override
    public @Nullable Object visitPackage(@NonNull org.eclipse.ocl.examples.pivot.Package pkge) {
        return true;
    }

	@Override
    public @Nullable Object visitTransformation(@NonNull Transformation transformation) {
    	for (Rule rule : transformation.getRule()) {
    		// Find bindings before invoking the mapping so all visitors are equal
    		Map<Variable, List<Object>>  mappingBindings = new HashMap<Variable, List<Object>>();
    		List<Variable> rootVariables = new ArrayList<Variable>();
    		List<List<Object>> rootBindings = new ArrayList<List<Object>>();
    		for (Domain domain : rule.getDomain()) {
                CoreDomain coreDomain = (CoreDomain)domain;
                TypedModel m = coreDomain.getTypedModel();
				for (@SuppressWarnings("null")@NonNull Variable var : coreDomain.getGuardPattern().getVariable()) {
                	evaluationEnvironment.add(var, null);
                	rootVariables.add(var);
                    Type varType = var.getType();
					if (varType != null) {
						List<Object> bindingValuesSet = ((QVTiModelManager)modelManager).getElementsByType(m, varType);
	                	rootBindings.add(bindingValuesSet);
	                    mappingBindings.put(var, bindingValuesSet);
					}
                }
            }
    		doMappingCallRecursion(rule, rootVariables, rootBindings, 0);
    		break;		// FIXME ?? multiple rules
    	}
        return true;
    }
}
