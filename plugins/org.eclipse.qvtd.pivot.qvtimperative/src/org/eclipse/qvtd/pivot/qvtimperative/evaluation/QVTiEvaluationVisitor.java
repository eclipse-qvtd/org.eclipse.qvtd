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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.evaluation.tx.InvocationFailedException;
import org.eclipse.ocl.pivot.internal.evaluation.BasicEvaluationVisitor;
import org.eclipse.ocl.pivot.internal.messages.PivotMessagesInternal;
import org.eclipse.ocl.pivot.labels.ILabelGenerator;
import org.eclipse.ocl.pivot.library.AbstractOperation;
import org.eclipse.ocl.pivot.library.LibraryOperation;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.CollectionValue.Accumulator;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.NullValue;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;

/**
 * QVTimperativeEvaluationVisitor is the class for ...
 */
public class QVTiEvaluationVisitor extends BasicEvaluationVisitor implements IQVTiEvaluationVisitor
{
	public class FunctionOperation extends AbstractOperation
	{
		protected final @NonNull Function function;
		
		public FunctionOperation(@NonNull Function function) {
			this.function = function;
		}
		
		/**
		 * @since 1.1
		 */
		@Override
		public @Nullable Object dispatch(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue) {
			List<? extends OCLExpression> arguments = callExp.getOwnedArguments();
			@Nullable Object[] argumentValues = new @Nullable Object[arguments.size()];
			for (int i = 0; i < arguments.size(); i++) {
				OCLExpression argument = arguments.get(i);
				assert argument != null;
				argumentValues[i] = executor.evaluate(argument);
			}
			return evaluate(executor, callExp, sourceValue, argumentValues);
		}

		private @Nullable Object evaluate(@NonNull Executor executor, @NonNull OperationCallExp callExp, @Nullable Object sourceValue, @Nullable Object... argumentValues) {
//			PivotUtil.checkExpression(expressionInOCL);
			EvaluationEnvironment nestedEvaluationEnvironment = executor.pushEvaluationEnvironment(function, callExp);
//			nestedEvaluationEnvironment.add(ClassUtil.nonNullModel(expressionInOCL.getOwnedContext()), sourceValue);
			List<Parameter> parameters = function.getOwnedParameters();
			if (!parameters.isEmpty()) {
				for (int i = 0; i < parameters.size(); i++) {
					Object value = argumentValues[i];
					nestedEvaluationEnvironment.add(ClassUtil.nonNullModel(parameters.get(i)), value);
				}
			}
			try {
				OCLExpression bodyExpression = function.getQueryExpression();
				assert bodyExpression != null;
				return executor.evaluate(bodyExpression);
			}
			finally {
				executor.popEvaluationEnvironment();
			}
		}
	}//	private static final Logger logger = Logger.getLogger(QVTiAbstractEvaluationVisitor.class);
	protected final @NonNull QVTiExecutor executor;			// FIXME fold into templated context
        
    /**
     * Instantiates a new qV tcore evaluation visitor impl.
     */
    public QVTiEvaluationVisitor(@NonNull QVTiExecutor executor) {
        super(executor);
        this.executor = executor;
    }

    @Override
	public @Nullable Object visitAssignment(@NonNull Assignment object) {
		return visiting(object);
    }
	
	@Override
	public @Nullable Object visitBaseModel(@NonNull BaseModel object) {
		return visiting(object);
	}

    @Override
    public @Nullable Object visitBottomPattern(@NonNull BottomPattern object) {
		return visiting(object);
    }

    @Override
	public @Nullable Object visitConnectionAssignment(@NonNull ConnectionAssignment connectionAssignment) {
    	Variable targetVariable = connectionAssignment.getTargetVariable() ;
		if (targetVariable != null) {
			OCLExpression valueExpression = connectionAssignment.getValue();
			if (valueExpression != null) {
				try {
//					context.replace(targetVariable, value);
					Object connection = context.getValueOf(targetVariable);
					CollectionValue.Accumulator connectionCollection = (Accumulator) ValueUtil.asCollectionValue(connection);
					Object values = valueExpression.accept(undecoratedVisitor);
					if (values instanceof Iterable<?>) {
						CollectionValue valuesCollection = ValueUtil.asCollectionValue(values);
						for (Object value : valuesCollection) {
							connectionCollection.add(value);
						}
					}
					else {
						connectionCollection.add(values);
					}
					return connectionCollection;
				}
				catch (RuntimeException e) {
					context.replace(targetVariable, e);
					throw e;
				}
			}
		}
		return null;
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
	public @Nullable Object visitImperativeDomain(@NonNull ImperativeDomain object) {
		return visitCoreDomain(object);
	}

    @Override
    public @Nullable Object visitImperativeModel(@NonNull ImperativeModel imperativeModel) {
    	for (org.eclipse.ocl.pivot.Package pkge : imperativeModel.getOwnedPackages()) {
    		pkge.accept(undecoratedVisitor);
    	}
        return true;
    }

	@Override
	public @Nullable Object visitImport(@NonNull Import object) {
		return visiting(object);
	}
    
	@Override
	public @Nullable Object visitMapping(@NonNull Mapping mapping) {
		return executor.internalExecuteMapping(mapping, undecoratedVisitor);
	}

	@Override
	public @Nullable Object visitMappingCall(@NonNull MappingCall mappingCall) {
		Map<Variable, Object> variable2value = new HashMap<Variable, Object>();
		for (MappingCallBinding binding : mappingCall.getBinding()) {
			Variable boundVariable = binding.getBoundVariable();
			if (boundVariable == null) {
				return null;		
			}
			Type varType = boundVariable.getType();
			if (varType == null) {
				return null;		
			}
			OCLExpression value = binding.getValue();
			if (value == null) {
				return null;		
			}
			Object valueOrValues = value.accept(undecoratedVisitor);
			Type valueType = idResolver.getDynamicTypeOf(valueOrValues);
			if (valueType.conformsTo(standardLibrary, varType)) {
				variable2value.put(boundVariable, valueOrValues);
			}
			else {
				return null;		
			}
    	}
		Mapping referredMapping = mappingCall.getReferredMapping();
		if (referredMapping == null) {
			return null;
		}
		return executor.internalExecuteMappingCall(mappingCall, variable2value, undecoratedVisitor);
    }

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
					context.replace(iterator, object);
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
				context.pushEvaluationEnvironment(mappingStatement, mappingSequence);
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
	public Object visitOperationCallExp(@NonNull OperationCallExp operationCallExp) {
		Operation referredOperation = operationCallExp.getReferredOperation();
		if (referredOperation instanceof Function) {
			Function function = (Function)referredOperation;
			LibraryOperation.LibraryOperationExtension implementation = new FunctionOperation(function);
			try {
				Object result = implementation.dispatch(context, operationCallExp, null);
				assert !(result instanceof NullValue);
				return result;
			}
			catch (InvalidValueException e) {
				throw e;
			}
			catch (InvocationFailedException e) {
				throw e;
			}
			catch (Exception e) {
				// This is a backstop. Library operations should catch their own exceptions
				//  and produce a better reason as a result.
				throw new InvalidValueException(e, PivotMessagesInternal.FailedToEvaluate_ERROR_, function, ILabelGenerator.Registry.INSTANCE.labelFor(null), operationCallExp);
			}
		}
		else {
			return super.visitOperationCallExp(operationCallExp);
		}
	}

/*	@Override
	public Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp oppositePropertyCallExp) {
		QVTiModelManager modelManager = (QVTiModelManager) context.getModelManager();
		Integer cacheIndex = modelManager.getTransformationAnalysis().getCacheIndex(oppositePropertyCallExp);
		if (cacheIndex == null) {
			return super.visitOppositePropertyCallExp(oppositePropertyCallExp);
		}
		Object sourceValue = null;
		OCLExpression source = oppositePropertyCallExp.getOwnedSource();
		if (source != null) {
			sourceValue = source.accept(undecoratedVisitor);
			if (sourceValue != null) {
				Object middleOpposite = modelManager.getUnnavigableOpposite(cacheIndex, sourceValue);
				if (middleOpposite == null) {
					throw new NotReadyValueException("Missing opposite value");
				}
				return ClassUtil.nonNullState(middleOpposite);
			}
		}
		throw new InvalidValueException("Failed to evaluate '" + oppositePropertyCallExp.getReferredProperty() + "'", sourceValue, oppositePropertyCallExp);
	} */

    @Override
    public @Nullable Object visitPackage(org.eclipse.ocl.pivot.@NonNull Package pkge) {
        return true;
    }

	@Override
	public @Nullable Object visitPattern(@NonNull Pattern object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitPredicate(@NonNull Predicate predicate) {
        
        // Each predicate has a conditionExpression that is an OCLExpression
        OCLExpression exp = predicate.getConditionExpression();
        // The predicated is visited with a nested environment
        Object expResult = exp.accept(undecoratedVisitor);
        return expResult;
	}
    
    @Override
	public @Nullable Object visitPropertyAssignment(@NonNull PropertyAssignment propertyAssignment) {
		Object slotObject = propertyAssignment.getSlotExpression().accept(undecoratedVisitor);
		if (slotObject instanceof EObject) {
			try {
				Object boxedValue = propertyAssignment.getValue().accept(undecoratedVisitor);
				Property targetProperty = propertyAssignment.getTargetProperty();
				Class<?> instanceClass = PivotUtil.getEcoreInstanceClass(targetProperty);
				Object ecoreValue = idResolver.ecoreValueOf(instanceClass, boxedValue);
				executor.internalExecutePropertyAssignment(propertyAssignment, slotObject, ecoreValue);
				return null;
			}
			catch (InvocationFailedException e) {
				executor.internalExecutePropertyAssignment(propertyAssignment, slotObject, e);
//				throw e;
			}
		} else {
			throw new IllegalArgumentException("Unsupported " + propertyAssignment.eClass().getName()
				+ " specification. The assigment slot expression evaluates to non-ecore value");
		}
        return true;
	}

    @Override
	public @Nullable Object visitRealizedVariable(@NonNull RealizedVariable realizedVariable) {
		return executor.internalExecuteRealizedVariable(realizedVariable, undecoratedVisitor);
    }

	@Override
	public @Nullable Object visitRule(@NonNull Rule object) {
		return visiting(object);
	}

	@Override
    public @Nullable Object visitTransformation(@NonNull Transformation transformation) {
		return executor.internalExecuteTransformation(transformation, undecoratedVisitor);
    }

	@Override
	public @Nullable Object visitTypedModel(@NonNull TypedModel object) {
		return visiting(object);
	}

    @Override
	public @Nullable Object visitVariableAssignment(@NonNull VariableAssignment variableAssignment) {
    	Variable targetVariable = variableAssignment.getTargetVariable() ;
		if (targetVariable != null) {
			OCLExpression valueExpression = variableAssignment.getValue();
			if (valueExpression != null) {
				try {
					Object value = valueExpression.accept(undecoratedVisitor);
					context.replace(targetVariable, value);
					return value;
				}
				catch (RuntimeException e) {
					context.replace(targetVariable, e);
					throw e;
				}
			}
		}
		return null;
    }

	@Override
	public @Nullable Object visitVariablePredicate(@NonNull VariablePredicate variablePredicate) {     
        // Each predicate has a conditionExpression that is an OCLExpression
        OCLExpression exp = variablePredicate.getConditionExpression();
        if (exp == null) {
        	return false;
        }
		Object value = exp.accept(undecoratedVisitor);
        Variable variable = variablePredicate.getTargetVariable();
		Type guardType = variable.getType();
		Type valueType = idResolver.getDynamicTypeOf(value);
		if ((guardType != null) && valueType.conformsTo(standardLibrary, guardType)) {
			context.replace(variable, value);
		} else {
			// The initialisation fails, the guard is not met
			return false;
		}
        return true;
	}
}
