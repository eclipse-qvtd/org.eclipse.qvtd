/*******************************************************************************
 * Copyright (c) 2012, 2016 The University of York, Willink Transformations and others.
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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Import;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.evaluation.BasicEvaluationVisitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
import org.eclipse.ocl.pivot.values.CollectionValue.Accumulator;
import org.eclipse.qvtd.pivot.qvtbase.BaseModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.Assignment;
import org.eclipse.qvtd.pivot.qvtimperative.BottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativePattern;
import org.eclipse.qvtd.pivot.qvtimperative.GuardPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;

/**
 * QVTimperativeEvaluationVisitor is the class for ...
 */
public class QVTiEvaluationVisitor extends BasicEvaluationVisitor implements IQVTiEvaluationVisitor
{
	protected final @NonNull QVTiExecutor executor;			// FIXME fold into templated context

	/**
	 * Instantiates a new qV tcore evaluation visitor impl.
	 */
	public QVTiEvaluationVisitor(@NonNull QVTiExecutor executor) {
		super(executor);
		this.executor = executor;
	}

	private @Nullable Object doConnectionAccumulation(@NonNull ConnectionVariable targetVariable, @NonNull OCLExpression valueExpression) {
		try {
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
			((QVTiExecutor)context).replace(targetVariable, e, false);
			throw e;
		}
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
		ConnectionVariable targetVariable = connectionAssignment.getTargetVariable() ;
		if (targetVariable != null) {
			OCLExpression valueExpression = connectionAssignment.getValue();
			if (valueExpression != null) {
				return doConnectionAccumulation(targetVariable, valueExpression);
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitConnectionStatement(@NonNull ConnectionStatement connectionStatement) {
		ConnectionVariable targetVariable = connectionStatement.getTargetVariable() ;
		if (targetVariable != null) {
			OCLExpression valueExpression = connectionStatement.getValue();
			if (valueExpression != null) {
				return doConnectionAccumulation(targetVariable, valueExpression);
			}
		}
		return null;
	}

	@Override
	public Object visitConnectionVariable(@NonNull ConnectionVariable object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitDomain(@NonNull Domain object) {
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
	public @Nullable Object visitImperativeDomain(@NonNull ImperativeDomain object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitImperativeModel(@NonNull ImperativeModel imperativeModel) {
		for (org.eclipse.ocl.pivot.Package pkge : imperativeModel.getOwnedPackages()) {
			pkge.accept(undecoratedVisitor);
		}
		return true;
	}

	@Override
	public @Nullable Object visitImperativePattern(@NonNull ImperativePattern object) {
		return visiting(object);
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
		Mapping referredMapping = mappingCall.getReferredMapping();
		if (referredMapping == null) {
			return null;
		}
		@NonNull Object @NonNull [] boundValues = new @NonNull Object[mappingCall.getBinding().size()];
		int index = 0;
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
			if (valueOrValues == null) {
				return null;
			}
			if (boundVariable instanceof ConnectionVariable) {
				boundValues[index++] = valueOrValues;

			}
			else {
				Type valueType = idResolver.getDynamicTypeOf(valueOrValues);
				if (valueType.conformsTo(environmentFactory.getStandardLibrary(), varType)) {
					boundValues[index++] = valueOrValues;
				}
				else {
					return null;
				}
			}
		}
		return executor.internalExecuteMappingCall(mappingCall, boundValues, undecoratedVisitor);
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
					((QVTiExecutor)context).replace(iterator, object, false);
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
	public @Nullable Object visitNavigationAssignment(@NonNull NavigationAssignment navigationAssignment) {
		Object slotObject = navigationAssignment.getSlotExpression().accept(undecoratedVisitor);
		if (slotObject instanceof EObject) {
			Integer childKey = null;
			try {
				Object boxedValue = navigationAssignment.getValue().accept(undecoratedVisitor);
				Property targetProperty = QVTimperativeUtil.getTargetProperty(navigationAssignment);
				Class<?> instanceClass = PivotUtil.getEcoreInstanceClass(targetProperty);
				Object ecoreValue = idResolver.ecoreValueOf(instanceClass, boxedValue);
				Property oppositeProperty = targetProperty.getOpposite();
				if (oppositeProperty != null) {
					Type type = oppositeProperty.getType();
					if (type instanceof CollectionType) {
						boolean isOrdered = ((CollectionType)type).isOrdered();
						if (isOrdered) {

						}
					}
				}
				executor.internalExecuteNavigationAssignment(navigationAssignment, slotObject, ecoreValue, childKey);
				return null;
			}
			catch (InvocationFailedException e) {
				executor.internalExecuteNavigationAssignment(navigationAssignment, slotObject, e, childKey);
				//				throw e;
			}
			//		} else if (slotObject == null){
			//			throw new InvalidValueException("Null source for '" + navigationAssignment.toString() + "'");
		} else {
			throw new IllegalArgumentException("Unsupported " + navigationAssignment.eClass().getName()
				+ " specification. The assignment slot expression '" + navigationAssignment.toString() + "'evaluates to non-ecore value: " + NameUtil.debugFullName(slotObject));
		}
		return true;
	}

	@Override
	public @Nullable Object visitOppositePropertyAssignment(@NonNull OppositePropertyAssignment navigationAssignment) {
		return visitNavigationAssignment(navigationAssignment);
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
	public @Nullable Object visitPropertyAssignment(@NonNull PropertyAssignment navigationAssignment) {
		return visitNavigationAssignment(navigationAssignment);
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
					((QVTiExecutor)context).replace(targetVariable, value, true);
					return value;
				}
				catch (RuntimeException e) {
					((QVTiExecutor)context).replace(targetVariable, e, false);
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
			((QVTiExecutor)context).replace(variable, value, false);
		} else {
			// The initialisation fails, the guard is not met
			return false;
		}
		return true;
	}
}
