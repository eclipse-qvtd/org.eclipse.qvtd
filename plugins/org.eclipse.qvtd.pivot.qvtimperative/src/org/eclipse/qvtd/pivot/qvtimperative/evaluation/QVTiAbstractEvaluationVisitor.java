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
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.domain.elements.DomainType;
import org.eclipse.ocl.examples.domain.utilities.DomainUtil;
import org.eclipse.ocl.examples.domain.values.impl.InvalidValueException;
import org.eclipse.ocl.examples.pivot.Environment;
import org.eclipse.ocl.examples.pivot.EnvironmentFactory;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.ocl.examples.pivot.Variable;
import org.eclipse.ocl.examples.pivot.VariableExp;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitor;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationVisitorImpl;
import org.eclipse.ocl.examples.pivot.manager.PivotIdResolver;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.Unit;
import org.eclipse.qvtd.pivot.qvtcorebase.Area;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyCallExp;

/**
 * QVTimperativeAbstractEvaluationVisitor is the class for ...
 */
public abstract class QVTiAbstractEvaluationVisitor extends EvaluationVisitorImpl
        implements QVTiEvaluationVisitor {

        
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
    public QVTiAbstractEvaluationVisitor(@NonNull Environment env,
            @NonNull EvaluationEnvironment evalEnv,
            @NonNull QVTiModelManager modelManager) {
        super(env, evalEnv, modelManager);
        // TODO Auto-generated constructor stub
    }

    public @Nullable Object visitImperativeModel(@NonNull ImperativeModel object) {
		return visiting(object);
    }
    
    @Override
	public abstract @NonNull QVTiEvaluationVisitor createNestedEvaluator();
    
    public @NonNull QVTiEvaluationVisitor createNestedLMVisitor() {
        EnvironmentFactory factory = environment.getFactory();
        EvaluationEnvironment nestedEvaluationEnvironment = factory.createEvaluationEnvironment(evaluationEnvironment); 
    	return new QVTiLMEvaluationVisitor(environment, nestedEvaluationEnvironment, getModelManager());
    }
    
    public @NonNull QVTiEvaluationVisitor createNestedMMVisitor() {
    	EnvironmentFactory factory = environment.getFactory();
        EvaluationEnvironment nestedEvaluationEnvironment = factory.createEvaluationEnvironment(evaluationEnvironment); 
    	return new QVTiMMEvaluationVisitor(environment, nestedEvaluationEnvironment, getModelManager());
    }
    
    public @NonNull QVTiEvaluationVisitor createNestedMRVisitor() {
    	EnvironmentFactory factory = environment.getFactory();
        EvaluationEnvironment nestedEvaluationEnvironment = factory.createEvaluationEnvironment(evaluationEnvironment); 
    	return new QVTiMREvaluationVisitor(environment, nestedEvaluationEnvironment, getModelManager());
    }

    /*
     * Perform the recursion for the BoundVariable that loops over the Iterables at depth in the
     * loopedVariables and loopedValues. The recursion proceeds to greater depths and once all
     * depths are exhausted invokes the mapping. 
     */
    private void doMappingCallRecursion(@NonNull Mapping mapping,
    		@NonNull List<Variable> loopedVariables, @NonNull List<Iterable<?>> loopedValues, int depth) {
		assert depth < loopedVariables.size();
		//EvaluationEnvironment nestedEvaluationEnvironment = ((EvaluationVisitor) nestedEvaluator).getEvaluationEnvironment();
		Variable boundVariable = loopedVariables.get(depth);
		Type guardType = boundVariable.getType();
		PivotIdResolver idResolver = metaModelManager.getIdResolver();
		int nestedDepth = depth+1;
		Mapping invokeMapping = nestedDepth >= loopedVariables.size() ? mapping : null;
//		Map.Entry<DomainTypedElement, Object> entry = nestedEvaluationEnvironment.getEntry(boundVariable);
		for (Object value : loopedValues.get(depth)) {
//			entry.setValue(value);
			DomainType valueType = idResolver.getDynamicTypeOf(value);
			if ((guardType != null) && valueType.conformsTo(metaModelManager, guardType)) {
				//nestedEvaluationEnvironment.replace(boundVariable, value);
				getEvaluationEnvironment().replace(boundVariable, value);
				if (invokeMapping != null) {
					invokeMapping.accept(getUndecoratedVisitor());
					//nestedEvaluator.safeVisit(invokeMapping);
				}
				else {
					doMappingCallRecursion(mapping, loopedVariables, loopedValues, nestedDepth);				
				}
			}
		}
	}

    @Override
	public @NonNull QVTiModelManager getModelManager() {
		return (QVTiModelManager) modelManager;
	}
    
    /**
     * Checks if the mapping is a middle to right mapping. Middle to Right mappings
     * must have enforce domains
     *
     * @param mapping the mapping
     * @return true, if is m to r mapping
     */
    protected boolean isMtoRMapping(@NonNull Mapping mapping) {
        if (mapping.getDomain().size() == 0) {
            return false;
        }
        for (Domain domain : mapping.getDomain()) {
            if (!domain.isIsEnforceable()) {
                return false;
            }
        }
        return true;
    }
    
    protected boolean isMtoMMapping(@NonNull Mapping mapping) {
        if (mapping.getDomain().size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the mapping is a left to middle mapping. Left to middle mappings
     * can not have enforce domains
     *
     * @param mapping the mapping
     * @return true, if is l to m mapping
     */
    protected boolean isLtoMMapping(@NonNull Mapping mapping) {
        if (mapping.getDomain().size() == 0) {
            return false;
        }
        for (Domain domain : mapping.getDomain()) {
            if (domain.isIsEnforceable()) {
                return false;
            }
        }
        return true;
    }

    public @Nullable Object visitAssignment(@NonNull Assignment object) {
		return visiting(object);
    }
	
	public @Nullable Object visitBaseModel(@NonNull BaseModel object) {
		return visiting(object);
	}

    public @Nullable Object visitBottomPattern(@NonNull BottomPattern object) {
		return visiting(object);
    }

    public @Nullable Object visitCoreDomain(@NonNull CoreDomain object) {
		return visiting(object);
    }

	public @Nullable Object visitDomain(@NonNull Domain object) {
		return visiting(object);
	}

    public @Nullable Object visitCorePattern(@NonNull CorePattern object) {
		return visiting(object);
    }

    public @Nullable Object visitEnforcementOperation(@NonNull EnforcementOperation object) {
		return visiting(object);
    }

	public @Nullable Object visitFunction(@NonNull Function object) {
		return visiting(object);
	}

	public @Nullable Object visitFunctionParameter(@NonNull FunctionParameter object) {
		return visiting(object);
	}

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor#visitGuardPattern(
     * org.eclipse.qvtd.pivot.qvtcore.GuardPattern)
     */
    public @Nullable Object visitGuardPattern(@NonNull GuardPattern guardPattern) {
    	
    	// The bindings are already defined, test the constraints
        Object result = true;
        for (Predicate predicate : guardPattern.getPredicate()) {
            // If the predicate is not true, the binding is not valid
            result = predicate.accept(getUndecoratedVisitor());
            if (result != Boolean.TRUE) {
            	break;
            }
        }
        return result;
    }

	public @Nullable Object visitMappingCall(@NonNull MappingCall mappingCall) {
    	
    	Mapping calledMapping = DomainUtil.nonNullModel(mappingCall.getReferredMapping());
		//
		//	Initialize nested environment directly with the bound values for non-looped bindings,
		//	and build matching lists of boundVariables and boundIterables for looped bindings. 
		//
		List<Variable> loopedVariables = null;
		List<Iterable<?>> loopedValues = null;
		for (MappingCallBinding binding : mappingCall.getBinding()) {
			Variable boundVariable = DomainUtil.nonNullModel(binding.getBoundVariable());
			Object valueOrValues = ((QVTiEvaluationVisitorDecorator)getUndecoratedVisitor()).safeVisit(binding.getValue());
			if (!binding.isIsLoop()) {
				DomainType valueType = metaModelManager.getIdResolver().getDynamicTypeOf(valueOrValues);
				Type varType = boundVariable.getType();
				if ((varType != null) && valueType.conformsTo(metaModelManager, varType)) {
					//nv.getEvaluationEnvironment().add(boundVariable, valueOrValues);
					evaluationEnvironment.add(boundVariable, valueOrValues);
				}
				else {
					return null;		
				}
			}
			else if (valueOrValues instanceof Iterable<?>) {
				if (loopedVariables == null) {
					loopedVariables = new ArrayList<Variable>();
				}
				if (loopedValues == null) {
					loopedValues = new ArrayList<Iterable<?>>();
				}
				loopedVariables.add(boundVariable);
				loopedValues.add((Iterable<?>)valueOrValues);
				//nv.getEvaluationEnvironment().add(boundVariable, null);
				try {
					evaluationEnvironment.add(boundVariable, null);
				} catch (IllegalArgumentException ex) {
					evaluationEnvironment.replace(boundVariable, null);
				}
			} else {
				// FIXME Error message;
			}
    	}
		//
		//	In the absence of any looped bindings invoke the nested mapping directly,
		//	otherwise recurse over the boundVariables that need to loop.
		//
		if ((loopedValues == null) || (loopedVariables == null)) {
			calledMapping.accept(getUndecoratedVisitor());
			//((QVTimperativeEvaluationVisitorDecorator)).safeVisit(calledMapping);
		}
		else {
			//doMappingCallRecursion(this, calledMapping, loopedVariables, loopedValues, 0);
			doMappingCallRecursion(calledMapping, loopedVariables, loopedValues, 0);
		}
    	return null;
    }

	public @Nullable Object visitMappingCallBinding(@NonNull MappingCallBinding object) {
		return visiting(object);	// MappingCallBinding is serviced by the parent MappingCall
    }
    
    public @Nullable Object visitMiddlePropertyAssignment(@NonNull MiddlePropertyAssignment propertyAssignment) {
        
        OCLExpression slotExp = propertyAssignment.getSlotExpression(); 
        Area area = ((BottomPattern)propertyAssignment.eContainer()).getArea();
        if (area instanceof Mapping) {
        	// TODO Check this approach
        	//if (!(exp instanceof VariableExp)) {
        	//    return modelManager.illFormedModelClass(VariableExp.class, exp, "visitPropertyAssignment");
        	//}
        	//VariableExp variableExp = (VariableExp)exp;
            if (slotExp instanceof VariableExp ) {      // What other type of expressions are there?
                Variable slotVar = (Variable) ((VariableExp)slotExp).getReferredVariable();
                if(slotVar != null) {
                    Object slotBinding = evaluationEnvironment.getValueOf(slotVar);
                    if(slotBinding != null) {
                        Object value = safeVisit(propertyAssignment.getValue());
                        // Unbox to asign to ecore type
                        value = metaModelManager.getIdResolver().unboxedValueOf(value);
                        Property p = propertyAssignment.getTargetProperty();
						getModelManager().setMiddleOpposite(propertyAssignment.getCacheIndex(), slotBinding, value);
                    } else {
                        throw new IllegalArgumentException("Unsupported " + propertyAssignment.eClass().getName()
                                + " specification. The assigment refers to a variable not defined in the" +
                                " current environment");
                    } 
                } else {
                    throw new IllegalArgumentException("Unsupported " + propertyAssignment.eClass().getName()
                            + " specification. The referred variable of the slot expression (" + slotExp.getType().getName() 
                            + ") was not found.");
                }
            } else {
                throw new IllegalArgumentException("Unsupported " + propertyAssignment.eClass().getName()
                        + " specification. The slot expression type (" + slotExp.getType().getName() 
                        + ") is not supported yet.");
            }
        }
        return true;
    }

	public @Nullable Object visitMiddlePropertyCallExp(@NonNull MiddlePropertyCallExp pPropertyCallExp) {
		OCLExpression source = pPropertyCallExp.getSource();
		EvaluationVisitor evaluationVisitor = getUndecoratedVisitor();
		Object sourceValue = source != null ? evaluationVisitor.evaluate(source) : null;
		if (sourceValue != null) {
			return getModelManager().getMiddleOpposite(pPropertyCallExp.getCacheIndex(), sourceValue);
		}
		throw new InvalidValueException("Failed to evaluate '" + pPropertyCallExp.getReferredProperty() + "'", sourceValue, pPropertyCallExp);
	}

	public @Nullable Object visitPattern(@NonNull Pattern object) {
		return visiting(object);
	}

	public @Nullable Object visitPredicate(@NonNull Predicate predicate) {
        
        // Each predicate has a conditionExpression that is an OCLExpression
        OCLExpression exp = predicate.getConditionExpression();
        // The predicated is visited with a nested environment
        Object expResult = exp.accept(getUndecoratedVisitor());
        return expResult;
	}
    
    public @Nullable Object visitPropertyAssignment(@NonNull PropertyAssignment propertyAssignment) {
        
        OCLExpression slotExp = propertyAssignment.getSlotExpression(); 
        Area area = ((BottomPattern)propertyAssignment.eContainer()).getArea();
        if (area instanceof Mapping) {
        	// TODO Check this approach
        	//if (!(exp instanceof VariableExp)) {
        	//    return modelManager.illFormedModelClass(VariableExp.class, exp, "visitPropertyAssignment");
        	//}
        	//VariableExp variableExp = (VariableExp)exp;
            if (slotExp instanceof VariableExp ) {      // What other type of expressions are there?
                Variable slotVar = (Variable) ((VariableExp)slotExp).getReferredVariable();
                if(slotVar != null) {
                    Object slotBinding = evaluationEnvironment.getValueOf(slotVar);
                    if(slotBinding != null) {
                        Object value = safeVisit(propertyAssignment.getValue());
                        // Unbox to asign to ecore type
                        value = metaModelManager.getIdResolver().unboxedValueOf(value);
                        Property p = propertyAssignment.getTargetProperty();
                        p.initValue(slotBinding, value);
                    } else {
                        throw new IllegalArgumentException("Unsupported " + propertyAssignment.eClass().getName()
                                + " specification. The assigment refers to a variable not defined in the" +
                                " current environment");
                    } 
                } else {
                    throw new IllegalArgumentException("Unsupported " + propertyAssignment.eClass().getName()
                            + " specification. The referred variable of the slot expression (" + slotExp.getType().getName() 
                            + ") was not found.");
                }
            } else {
                throw new IllegalArgumentException("Unsupported " + propertyAssignment.eClass().getName()
                        + " specification. The slot expression type (" + slotExp.getType().getName() 
                        + ") is not supported yet.");
            }
        }
        return true;
    }

	/*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor#visitRealizedVariable
     * (org.eclipse.qvtd.pivot.qvtcore.RealizedVariable)
     */
    public @Nullable Object visitRealizedVariable(@NonNull RealizedVariable realizedVariable) {
        
        // LtoM Mapping. Realized variables are in the mapping's bottom pattern
        // and create elements in the middle model. The realized variables
        // are being visited for each binding of variable in the mapping. 
        Area area = ((BottomPattern)realizedVariable.eContainer()).getArea();
        Object element =  realizedVariable.getType().createInstance();
        TypedModel tm = QVTiModelManager.MIDDLE_MODEL;     // L to M
        if (area instanceof CoreDomain) {
            tm = ((CoreDomain)area).getTypedModel();        // M to R
        }
        ((QVTiModelManager)modelManager).addModelElement(tm, element);
        // Add the realize variable binding to the environment
//        try {
//            evaluationEnvironment.add(realizedVariable, element);
//        } catch (IllegalArgumentException ex) {
            evaluationEnvironment.replace(realizedVariable, element);
//        }
        return element;
    }

	public @Nullable Object visitRule(@NonNull Rule object) {
		return visiting(object);
	}

	public @Nullable Object visitTransformation(@NonNull Transformation object) {
		return visiting(object);
	}

	public @Nullable Object visitTypedModel(@NonNull TypedModel object) {
		return visiting(object);
	}

	public @Nullable Object visitUnit(@NonNull Unit object) {
		return visiting(object);
	}

    public @Nullable Object visitVariableAssignment(@NonNull VariableAssignment variableAssignment) {
    	Variable targetVariable = variableAssignment.getTargetVariable() ;
		Object value = ((QVTiEvaluationVisitorDecorator)getUndecoratedVisitor()).safeVisit(variableAssignment.getValue());
		// The variable had been added to the environment before the mapping call
		if (targetVariable != null) {
			evaluationEnvironment.replace(targetVariable, value);
		}
		return null;
    }
    
    
}
