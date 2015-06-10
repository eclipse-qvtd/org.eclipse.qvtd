/*******************************************************************************
 * Copyright (c) 2012, 2015 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 *     Adolfo Sanchez-Barbudo Herrera (University of York) - Bug 456900
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
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;

/**
 * QVTimperativeAbstractEvaluationVisitor is the base abstract class for QVTi
 * evaluation visitors.
 * 
 * @author Horacio Hoyos
 */
public abstract class QVTiAbstractEvaluationVisitor extends BasicEvaluationVisitor implements IQVTiEvaluationVisitor
{
//	private static final Logger logger = Logger.getLogger(QVTiAbstractEvaluationVisitor.class);
	
	protected final @NonNull QVTiTransformationAnalysis transformationAnalysis;
        
    /**
     * Instantiates a new QVT imperative abstract visitor.
     *
     * @param env The environment
     * @param evalEnv The evaluation environment
     */
    public QVTiAbstractEvaluationVisitor(@NonNull ExecutorInternal executor) {
        super(executor);
		this.transformationAnalysis = ((QVTiModelManager)executor.getModelManager()).getTransformationAnalysis();
    }

	protected void doMappingStatements(@NonNull List<MappingStatement> mappingStatements) {
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
			return;
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

    /* (non-Javadoc)
     * @see org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor#visitBottomPattern(org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern)
     */
    @Override
	public @Nullable Object visitBottomPattern(@NonNull BottomPattern object) {
		return visiting(object);
    }

    /* (non-Javadoc)
     * @see org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor#visitCoreDomain(org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain)
     */
    @Override
	public @Nullable Object visitCoreDomain(@NonNull CoreDomain object) {
		return visiting(object);
    }

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor#visitDomain(org.eclipse.qvtd.pivot.qvtbase.Domain)
	 */
	@Override
	public @Nullable Object visitDomain(@NonNull Domain object) {
		return visiting(object);
	}

    /* (non-Javadoc)
     * @see org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor#visitCorePattern(org.eclipse.qvtd.pivot.qvtcorebase.CorePattern)
     */
    @Override
	public @Nullable Object visitCorePattern(@NonNull CorePattern object) {
		return visiting(object);
    }

    /* (non-Javadoc)
     * @see org.eclipse.qvtd.pivot.qvtcorebase.util.QVTcoreBaseVisitor#visitEnforcementOperation(org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation)
     */
    @Override
	public @Nullable Object visitEnforcementOperation(@NonNull EnforcementOperation object) {
		return visiting(object);
    }

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor#visitFunction(org.eclipse.qvtd.pivot.qvtbase.Function)
	 */
	@Override
	public @Nullable Object visitFunction(@NonNull Function object) {
		return visiting(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor#visitFunctionParameter(org.eclipse.qvtd.pivot.qvtbase.FunctionParameter)
	 */
	@Override
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
	@Override
	public @Nullable Object visitGuardPattern(@NonNull GuardPattern guardPattern) {
        for (Predicate predicate : guardPattern.getPredicate()) {
            // If the predicate is not true, the binding is not valid
            Object result = predicate.accept(undecoratedVisitor);
            if (result != Boolean.TRUE) {
            	return false;
            }
        }
        // NB guard 1 variable may be initialized by guard 2 VariablePredicate
/*        for (Variable v : guardPattern.getVariable()) {
        	// Check for binding initialization
        	if (evaluationEnvironment.getValueOf(v) == null) {
        		logger.warn("Missing binding for " + v + " in " + QVTimperativeUtil.getContainingMapping(guardPattern));
            	return false;
			}
		} */
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
	 * @see org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor#visitImperativeModel(org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel)
	 */
	@Override
	public @Nullable Object visitImperativeModel(@NonNull ImperativeModel object) {
		return visiting(object);
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

	/*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor#visitRealizedVariable
     * (org.eclipse.qvtd.pivot.qvtcore.RealizedVariable)
     */
    @Override
	public @Nullable Object visitRealizedVariable(@NonNull RealizedVariable realizedVariable) {
        
        // Realized variables are in the mapping's target bottom pattern
        // and create elements in the target model. The realized variables
        // are being visited for each binding of variable in the mapping. 
        Area area = ((BottomPattern)realizedVariable.eContainer()).getArea();
        Type type = realizedVariable.getType();
		Object element = type instanceof org.eclipse.ocl.pivot.Class ? ((org.eclipse.ocl.pivot.Class)type).createInstance() : null;
        if (element != null) {
	        TypedModel tm = QVTcoreBaseUtil.getTypedModel(area);
	        assert tm != null;
	        ((QVTiModelManager)context.getModelManager()).addModelElement(tm, element);
	        // Add the realize variable binding to the environment
	        context.replace(realizedVariable, element);
        }
        return element;
    }

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor#visitRule(org.eclipse.qvtd.pivot.qvtbase.Rule)
	 */
	@Override
	public @Nullable Object visitRule(@NonNull Rule object) {
		return visiting(object);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor#visitTransformation(org.eclipse.qvtd.pivot.qvtbase.Transformation)
	 */
	@Override
	public @Nullable Object visitTransformation(@NonNull Transformation object) {
		return visiting(object);
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
