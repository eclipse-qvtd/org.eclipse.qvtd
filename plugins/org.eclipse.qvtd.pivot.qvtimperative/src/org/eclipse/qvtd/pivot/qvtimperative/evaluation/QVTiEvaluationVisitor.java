/*******************************************************************************
 * Copyright (c) 2012, 2015 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.internal.evaluation.BasicEvaluationVisitor;
import org.eclipse.ocl.pivot.internal.evaluation.ExecutorInternal;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
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
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;

/**
 * QVTimperativeEvaluationVisitor is the class for ...
 */
public class QVTiEvaluationVisitor extends BasicEvaluationVisitor implements IQVTiEvaluationVisitor
{
//	private static final Logger logger = Logger.getLogger(QVTiAbstractEvaluationVisitor.class);
	
	protected final @NonNull QVTiTransformationAnalysis transformationAnalysis;
        
    /**
     * Instantiates a new qV tcore evaluation visitor impl.
     */
    public QVTiEvaluationVisitor(@NonNull ExecutorInternal executor) {
        super(executor);
		this.transformationAnalysis = ((QVTiModelManager)executor.getModelManager()).getTransformationAnalysis();
    }

	protected void doCommits(@NonNull Mapping mapping) {
		for (Domain domain : mapping.getDomain()) {
			if (domain.isIsEnforceable()) {
				CoreDomain enforceableDomain = (CoreDomain)domain;
				BottomPattern enforceableBottomPattern = enforceableDomain.getBottomPattern();
				for (RealizedVariable realizedVariable : enforceableBottomPattern.getRealizedVariable()) {
					realizedVariable.accept(undecoratedVisitor);
				}
			}
		}
		BottomPattern middleBottomPattern = mapping.getBottomPattern();
		for (Assignment assignment : middleBottomPattern.getAssignment()) {
			if (assignment instanceof PropertyAssignment) {
				assignment.accept(undecoratedVisitor);
			}
		}
		for (Domain domain : mapping.getDomain()) {
			if (domain.isIsEnforceable()) {
				CoreDomain enforceableDomain = (CoreDomain)domain;
				BottomPattern enforceableBottomPattern = enforceableDomain.getBottomPattern();
				for (EnforcementOperation enforceOp : enforceableBottomPattern.getEnforcementOperation()) {
					enforceOp.accept(undecoratedVisitor);
				}
			}
		}
//		for (EnforcementOperation enforceOp : middleBottomPattern.getEnforcementOperation()) {
//			enforceOp.accept(undecoratedVisitor);
//		}
		}

	protected void doEvaluations(@NonNull Mapping mapping) {
		for (Domain domain : mapping.getDomain()) {
			if (!domain.isIsEnforceable()) {
				assert domain.isIsCheckable();
				CoreDomain checkableDomain = (CoreDomain)domain;
				GuardPattern checkableGuardPattern = checkableDomain.getGuardPattern();
				assert checkableGuardPattern.getPredicate().isEmpty();
				BottomPattern checkableBottomPattern = checkableDomain.getBottomPattern();
				assert checkableBottomPattern.getAssignment().isEmpty();
				assert checkableBottomPattern.getEnforcementOperation().isEmpty();
				assert checkableBottomPattern.getPredicate().isEmpty();
				assert checkableBottomPattern.getRealizedVariable().isEmpty();
				assert checkableBottomPattern.getVariable().isEmpty();
			}
			else {
				CoreDomain enforceableDomain = (CoreDomain)domain;
				GuardPattern enforceableGuardPattern = enforceableDomain.getGuardPattern();
				assert enforceableGuardPattern.getPredicate().isEmpty();
				BottomPattern enforceableBottomPattern = enforceableDomain.getBottomPattern();
				assert enforceableBottomPattern.getAssignment().isEmpty();
				assert enforceableBottomPattern.getPredicate().isEmpty();
				for (Variable rVar : enforceableBottomPattern.getVariable()) {
					OCLExpression ownedInit = rVar.getOwnedInit();
					if (ownedInit != null) {
						Object initValue = ownedInit.accept(undecoratedVisitor);
						context.replace(rVar, initValue);
					}
				}
			}
		}
		BottomPattern middleBottomPattern = mapping.getBottomPattern();
		assert middleBottomPattern.getEnforcementOperation().isEmpty();
		assert middleBottomPattern.getPredicate().isEmpty();
		assert middleBottomPattern.getRealizedVariable().isEmpty();
		for (Variable rVar : middleBottomPattern.getVariable()) {
			OCLExpression ownedInit = rVar.getOwnedInit();
			if (ownedInit != null) {
				Object initValue = ownedInit.accept(undecoratedVisitor);
				context.replace(rVar, initValue);
			}
		}
		for (Assignment assignment : middleBottomPattern.getAssignment()) {
			if (!(assignment instanceof PropertyAssignment)) {
				assignment.accept(undecoratedVisitor);
			}
		}
	}

	protected boolean doPredicates(@NonNull Mapping mapping) {
		GuardPattern middleGuardPattern = mapping.getGuardPattern();
		assert middleGuardPattern.getVariable().isEmpty();
		for (Predicate predicate : middleGuardPattern.getPredicate()) {
			// If the predicate is not true, the binding is not valid
			Object result = predicate.accept(undecoratedVisitor);
			if (result != Boolean.TRUE) {
				return false;
			}
		}
		return true;
	}
	
	protected void doPropertyAssignment(@NonNull PropertyAssignment propertyAssignment, @Nullable Integer cacheIndex) {
		Object slotExpValue = safeVisit(propertyAssignment.getSlotExpression());
		if (slotExpValue instanceof EObject) {
			Object boxedValue = safeVisit(propertyAssignment.getValue());
			Property targetProperty = propertyAssignment.getTargetProperty();
			Class<?> instanceClass = PivotUtil.getEcoreInstanceClass(targetProperty);
			Object ecoreValue = environmentFactory.getIdResolver().ecoreValueOf(instanceClass, boxedValue);
			targetProperty.initValue(slotExpValue, ecoreValue);
			if (cacheIndex != null) {
				((QVTiModelManager)context.getModelManager()).setUnnavigableOpposite(cacheIndex, slotExpValue, ecoreValue);
			}
		} else {
			throw new IllegalArgumentException("Unsupported " + propertyAssignment.eClass().getName()
				+ " specification. The assigment slot expression evaluates to non-ecore value");
		}
	}

//	@Override
//	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
//		return (QVTiEnvironmentFactory) environmentFactory;
//	}

	@Override
	public @NonNull QVTiEvaluationEnvironment getEvaluationEnvironment() {
		return (QVTiEvaluationEnvironment) context.getEvaluationEnvironment();
	}
    
    /**
     * Checks if the mapping is a middle to right mapping. Middle to Right mappings
     * must have enforce domains
     *
     * @param mapping the mapping
     * @return true, if is m to r mapping
     *
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
    } */
    
    /**
     * Checks if is middle to middle mapping.
     *
     * @param mapping the mapping
     * @return true, if is middle to middle mapping
     *
    protected boolean isMtoMMapping(@NonNull Mapping mapping) {
        if (mapping.getDomain().size() == 0) {
            return true;
        }
        return false;
    } */

    /**
     * Checks if the mapping is a left to middle mapping. Left to middle mappings
     * can not have enforce domains
     *
     * @param mapping the mapping
     * @return true, if is left to middle mapping
     *
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
    } */

    /* (non-Javadoc)
     * @see org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor#visitAssignment(org.eclipse.qvtd.pivot.qvtcorebase.Assignment)
     */
    @Override
	public @Nullable Object visitAssignment(@NonNull Assignment object) {
		return visiting(object);
    }
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor#visitBaseModel(org.eclipse.qvtd.pivot.qvtbase.BaseModel)
	 */
	@Override
	public @Nullable Object visitBaseModel(@NonNull BaseModel object) {
		return visiting(object);
	}

    @Override
    public @Nullable Object visitBottomPattern(@NonNull BottomPattern object) {
		return visiting(object);
    }
    
    @Override
	public @Nullable Object visitCoreDomain(@NonNull CoreDomain object) {
		return visiting(object);
    }

	@Override
	public @Nullable Object visitDomain(@NonNull Domain object) {
		return visiting(object);
	}

    @Override
	public @Nullable Object visitCorePattern(@NonNull CorePattern object) {
		return visiting(object);
    }

    @Override
	public @Nullable Object visitEnforcementOperation(@NonNull EnforcementOperation object) {
		return visiting(object);
    }

	@Override
	public @Nullable Object visitFunction(@NonNull Function object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitFunctionParameter(@NonNull FunctionParameter object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitGuardPattern(@NonNull GuardPattern object) {
		return visiting(object);
    }

	@Override
	public @Nullable Object visitImperativeBottomPattern(@NonNull ImperativeBottomPattern object) {
		return visitBottomPattern(object);
	}

    @Override
    public @Nullable Object visitImperativeModel(@NonNull ImperativeModel imperativeModel) {
    	for (org.eclipse.ocl.pivot.Package pkge : imperativeModel.getOwnedPackages()) {
    		pkge.accept(undecoratedVisitor);
    	}
        return true;
    }

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor#visitUnit(org.eclipse.qvtd.pivot.qvtbase.Unit)
	 */
	@Override
	public @Nullable Object visitImport(@NonNull Import object) {
		return visiting(object);
	}
    
    /* (non-Javadoc)
     * @see uk.ac.york.qvtd.pivot.qvtimperative.evaluation.QVTimperativeAbstractEvaluationVisitorImpl#visitMapping(org.eclipse.qvtd.pivot.qvtimperative.Mapping)
     */
	@Override
	public @Nullable Object visitMapping(@NonNull Mapping mapping) {
		//
		//	Check the predicates
		//
		if (!doPredicates(mapping)) {
			return false;
		}
		//
		//	Evaluate the enforceable domain expressions.
		//
		doEvaluations(mapping);
		//
		//	Perform the instance model addition and property assignment only after all expressions have been evaluated
		//	possibly throwing a not-ready exception that bypasses premature commits.
		//
		doCommits(mapping);
		//
		//	Invoke any corrolaries
		//
 		MappingStatement mappingStatement = mapping.getMappingStatement();
		if (mappingStatement != null) {
			mappingStatement.accept(undecoratedVisitor);
		}
        return true;
    }

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor#visitMappingCall(org.eclipse.qvtd.pivot.qvtimperative.MappingCall)
	 */
	@Override
	public @Nullable Object visitMappingCall(@NonNull MappingCall mappingCall) {
    	Mapping calledMapping = ClassUtil.nonNullModel(mappingCall.getReferredMapping());
		//
		//	Initialise nested environment directly with the bound values for non-looped bindings,
		//	and build matching lists of boundVariables and boundIterables for looped bindings. 
		//
//		List<Variable> loopedVariables = null;
//		List<Iterable<?>> loopedValues = null;
		for (MappingCallBinding binding : mappingCall.getBinding()) {
			Variable boundVariable = ClassUtil.nonNullModel(binding.getBoundVariable());
			Object valueOrValues = null;
			try {
				valueOrValues = ((IQVTiEvaluationVisitor)undecoratedVisitor).safeVisit(binding.getValue());
			} catch (InvalidValueException ex) {
				// There was an OCLVoid value being navigated or any other/similar OCL error
				// evaluating the binding value
				return null;
			}
			Type valueType = environmentFactory.getIdResolver().getDynamicTypeOf(valueOrValues);
			Type varType = boundVariable.getType();
			if ((varType != null) && valueType.conformsTo(metamodelManager.getStandardLibrary(), varType)) {
				context.replace(boundVariable, valueOrValues);
			}
			else {
				return null;		
			}
    	}
		calledMapping.accept(undecoratedVisitor);
    	return null;
    }

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor#visitMappingCallBinding(org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding)
	 */
	@Override
	public @Nullable Object visitMappingCallBinding(@NonNull MappingCallBinding object) {
		return visiting(object);	// MappingCallBinding is serviced by the parent MappingCall
    }

	@Override
	public @Nullable Object visitMappingLoop(@NonNull MappingLoop mappingLoop) {
		Object inValues = mappingLoop.getOwnedSource().accept(undecoratedVisitor);
		if (inValues instanceof Iterable<?>) {
			List<Variable> iterators = mappingLoop.getOwnedIterators();
			if (iterators.size() > 0) {
				Variable iterator = ClassUtil.nonNullState(iterators.get(0));
				for (Object object : (Iterable<?>)inValues) {
					getEvaluationEnvironment().replace(iterator, object);
					mappingLoop.getOwnedBody().accept(undecoratedVisitor);
				}
			}
		}
		return true;
	}

	@Override
	public @Nullable Object visitMappingSequence(@NonNull MappingSequence mappingSequence) {
		for (MappingStatement mappingStatement : mappingSequence.getMappingStatements()) {
			if (mappingStatement != null) {
				context.pushEvaluationEnvironment(mappingStatement);
				try {
					mappingStatement.accept(undecoratedVisitor);
				}
				finally {
					context.popEvaluationEnvironment();
				}
			}
		}
		return true;
	}

	@Override
	public @Nullable Object visitMappingStatement(@NonNull MappingStatement object) {
		return visiting(object);	// MappingStatement is abstract
	}

	@Override
	public Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp oppositePropertyCallExp) {
		Integer cacheIndex = transformationAnalysis.getCacheIndex(oppositePropertyCallExp);
		if (cacheIndex == null) {
			return super.visitOppositePropertyCallExp(oppositePropertyCallExp);
		}
		OCLExpression source = oppositePropertyCallExp.getOwnedSource();
		Object sourceValue = source != null ? undecoratedVisitor.evaluate(source) : null;
		if (sourceValue != null) {
			Object middleOpposite = ((QVTiModelManager) context.getModelManager()).getUnnavigableOpposite(cacheIndex, sourceValue);
			return ClassUtil.nonNullState(middleOpposite);
		}
		throw new InvalidValueException("Failed to evaluate '" + oppositePropertyCallExp.getReferredProperty() + "'", sourceValue, oppositePropertyCallExp);
	}

    @Override
    public @Nullable Object visitPackage(@NonNull org.eclipse.ocl.pivot.Package pkge) {
        return true;
    }

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor#visitPattern(org.eclipse.qvtd.pivot.qvtbase.Pattern)
	 */
	@Override
	public @Nullable Object visitPattern(@NonNull Pattern object) {
		return visiting(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor#visitPredicate(org.eclipse.qvtd.pivot.qvtbase.Predicate)
	 */
	@Override
	public @Nullable Object visitPredicate(@NonNull Predicate predicate) {
        
        // Each predicate has a conditionExpression that is an OCLExpression
        OCLExpression exp = predicate.getConditionExpression();
        // The predicated is visited with a nested environment
        Object expResult = exp.accept(undecoratedVisitor);
        return expResult;
	}
    
    /* (non-Javadoc)
     * @see org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor#visitPropertyAssignment(org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment)
     */
    @Override
	public @Nullable Object visitPropertyAssignment(@NonNull PropertyAssignment propertyAssignment) {
		doPropertyAssignment(propertyAssignment, transformationAnalysis.getCacheIndex(propertyAssignment));
        return true;
    }

    @Override
	public @Nullable Object visitRealizedVariable(@NonNull RealizedVariable realizedVariable) {
        // Realized variables are in the mapping's target bottom pattern
        // and create elements in the target model. The realized variables
        // are being visited for each binding of variable in the mapping. 
        Type type = realizedVariable.getType();
        if (!(type instanceof org.eclipse.ocl.pivot.Class)) {
        	return null;
        }
        Area area = ((BottomPattern)realizedVariable.eContainer()).getArea();
        TypedModel typedModel = QVTcoreBaseUtil.getTypedModel(area);
        assert typedModel != null;
		Object element = ((org.eclipse.ocl.pivot.Class)type).createInstance();
        // Add the realize variable binding to the environment
        context.replace(realizedVariable, element);
        ((QVTiModelManager)context.getModelManager()).addModelElement(typedModel, element);
        return true;
    }

	@Override
	public @Nullable Object visitRule(@NonNull Rule object) {
		return visiting(object);
	}

	@Override
    public @Nullable Object visitTransformation(@NonNull Transformation transformation) {
        Rule rule = NameUtil.getNameable(transformation.getRule(), QVTimperativeUtil.ROOT_MAPPING_NAME);
        if (rule == null) {
        	throw new IllegalStateException("Transformation " + transformation.getName() + " has no root mapping");
        }
        context.pushEvaluationEnvironment(rule);
        try {
        	rule.accept(undecoratedVisitor);
        }
        finally {
        	context.popEvaluationEnvironment();
        }
        return true;
    }

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor#visitTypedModel(org.eclipse.qvtd.pivot.qvtbase.TypedModel)
	 */
	@Override
	public @Nullable Object visitTypedModel(@NonNull TypedModel object) {
		return visiting(object);
	}

	/* (non-Javadoc)
     * @see org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor#visitVariableAssignment(org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment)
     */
    @Override
	public @Nullable Object visitVariableAssignment(@NonNull VariableAssignment variableAssignment) {
    	Variable targetVariable = variableAssignment.getTargetVariable() ;
		Object value = ((IQVTiEvaluationVisitor)undecoratedVisitor).safeVisit(variableAssignment.getValue());
		// The variable had been added to the environment before the mapping call
		if (targetVariable != null) {
			context.replace(targetVariable, value);
		}
		return null;
    }

	@Override
	public @Nullable Object visitVariablePredicate(@NonNull VariablePredicate variablePredicate) {     
        IdResolver idResolver = environmentFactory.getIdResolver();
        // Each predicate has a conditionExpression that is an OCLExpression
        OCLExpression exp = variablePredicate.getConditionExpression();
		Object value = ((IQVTiEvaluationVisitor)undecoratedVisitor).safeVisit(exp);
        Variable variable = variablePredicate.getTargetVariable();
		Type guardType = variable.getType();
		Type valueType = idResolver.getDynamicTypeOf(value);
		if ((guardType != null) && valueType.conformsTo(metamodelManager.getStandardLibrary(), guardType)) {
			context.replace(variable, value);
		} else {
			// The initialisation fails, the guard is not met
			return false;
		}
        return true;
	}
}
