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
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.internal.evaluation.BasicEvaluationVisitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.CollectionValue;
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
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameter;
import org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.BufferStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;

import com.google.common.collect.Iterables;

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
			Object targetValue = ClassUtil.nonNullState(executor.getValueOf(targetVariable));
			Connection connectionCollection = (Connection) targetValue;
			Object values = valueExpression.accept(undecoratedVisitor);
			assert values != null;
			//			if (values instanceof Iterable<?>) {
			//				CollectionValue valuesCollection = ValueUtil.asCollectionValue(values);
			//				for (Object value : valuesCollection) {
			//					connectionCollection.append(value);
			//				}
			//			}
			//			else {
			connectionCollection.appendElement(values);
			//			}
			return connectionCollection;
		}
		catch (RuntimeException e) {
			executor.replace(targetVariable, e, false);
			throw e;
		}
	}

	private @Nullable Object doMappingCall(@NonNull MappingCall mappingCall) {
		Mapping referredMapping = mappingCall.getReferredMapping();
		if (referredMapping == null) {
			return null;
		}
		Iterable<@NonNull MappingParameterBinding> mappingParameterBindings = QVTimperativeUtil.getOwnedMappingParameterBindings(mappingCall);
		@NonNull Object @NonNull [] boundValues = new @NonNull Object[Iterables.size(mappingParameterBindings)];
		int index = 0;
		for (@NonNull MappingParameterBinding binding : mappingParameterBindings) {
			VariableDeclaration boundVariable = binding.getBoundVariable();
			if (boundVariable == null) {
				return null;
			}
			if (binding instanceof AppendParameterBinding) {	// FIXME visit the bindings
				AppendParameterBinding appendParameterBinding = (AppendParameterBinding)binding;
				ConnectionVariable value = appendParameterBinding.getValue();
				if (value == null) {
					return null;
				}
				Object valueOrValues = executor.getValueOf(value);
				if (valueOrValues == null) {
					return null;
				}
				boundValues[index++] = valueOrValues;
			}
			else if (binding instanceof GuardParameterBinding) {
				Type varType = boundVariable.getType();
				if (varType == null) {
					return null;
				}
				GuardParameterBinding guardParameterBinding = (GuardParameterBinding)binding;
				ConnectionVariable value = guardParameterBinding.getValue();
				if (value == null) {
					return null;
				}
				Object valueOrValues = executor.getValueOf(value);
				if (valueOrValues == null) {
					return null;
				}
				Type valueType = idResolver.getDynamicTypeOf(valueOrValues);
				if (!guardParameterBinding.isIsCheck() || valueType.conformsTo(environmentFactory.getStandardLibrary(), varType)) {
					boundValues[index++] = valueOrValues;
				}
				else {
					return null;
				}
			}
			else if (binding instanceof LoopParameterBinding) {
				Type varType = boundVariable.getType();
				if (varType == null) {
					return null;
				}
				LoopParameterBinding guardParameterBinding = (LoopParameterBinding)binding;
				LoopVariable value = guardParameterBinding.getValue();
				if (value == null) {
					return null;
				}
				Object valueOrValues = executor.getValueOf(value);
				if (valueOrValues == null) {
					return null;
				}
				Type valueType = idResolver.getDynamicTypeOf(valueOrValues);
				if (!guardParameterBinding.isIsCheck() || valueType.conformsTo(environmentFactory.getStandardLibrary(), varType)) {
					boundValues[index++] = valueOrValues;
				}
				else {
					return null;
				}
			}
			else if (binding instanceof SimpleParameterBinding) {
				Type varType = boundVariable.getType();
				if (varType == null) {
					return null;
				}
				SimpleParameterBinding simpleParameterBinding = (SimpleParameterBinding)binding;
				OCLExpression value = simpleParameterBinding.getValue();
				if (value == null) {
					return null;
				}
				Object valueOrValues = value.accept(undecoratedVisitor);
				if (valueOrValues == null) {
					return null;
				}
				assert !(boundVariable instanceof ConnectionVariable);
				//					boundValues[index++] = valueOrValues;

				//				}
				//				else {
				Type valueType = idResolver.getDynamicTypeOf(valueOrValues);
				if (!simpleParameterBinding.isIsCheck() || valueType.conformsTo(environmentFactory.getStandardLibrary(), varType)) {
					boundValues[index++] = valueOrValues;
				}
				else {
					return null;
				}
				//				}
			}
		}
		return executor.internalExecuteMappingCall(mappingCall, boundValues, undecoratedVisitor);
	}

	private @Nullable Object doMappingInstall(@NonNull MappingCall mappingCall) {
		Mapping referredMapping = mappingCall.getReferredMapping();
		if (referredMapping == null) {
			return null;
		}
		InvocationConstructor invocationConstructor = executor.getInvocationConstructor(mappingCall, undecoratedVisitor);
		Iterable<@NonNull MappingParameterBinding> mappingBindings = QVTimperativeUtil.getOwnedMappingParameterBindings(mappingCall);
		assert mappingBindings != null;
		for (MappingParameterBinding asMappingCallBinding : mappingBindings) {
			if (asMappingCallBinding instanceof GuardParameterBinding) {
				ConnectionVariable connectionVariable = ((GuardParameterBinding)asMappingCallBinding).getValue();
				assert connectionVariable != null;
				Object value = executor.getValueOf(connectionVariable);
				assert value != null;
				invocationConstructor.addConsumedConnection((Connection) value);
			}
			else if (asMappingCallBinding instanceof AppendParameterBinding) {
				ConnectionVariable connectionVariable = ((AppendParameterBinding)asMappingCallBinding).getValue();
				assert connectionVariable != null;
				Object value = executor.getValueOf(connectionVariable);
				assert value != null;
				invocationConstructor.addAppendedConnection((Connection) value);
			}
		}
		return Boolean.TRUE;
	}

	@Override
	public @Nullable Object visitAddStatement(@NonNull AddStatement connectionStatement) {
		ConnectionVariable targetVariable = connectionStatement.getTargetVariable() ;
		if (targetVariable != null) {
			OCLExpression valueExpression = connectionStatement.getOwnedExpression();
			if (valueExpression != null) {
				doConnectionAccumulation(targetVariable, valueExpression);
				return true;
			}
		}
		return null;
	}

	@Override
	public Object visitAppendParameter(@NonNull AppendParameter object) {
		CollectionValue.Accumulator accumulator = ValueUtil.createCollectionAccumulatorValue((CollectionTypeId) object.getTypeId());
		return executor.replace(object, accumulator, false);
	}

	@Override
	public Object visitAppendParameterBinding(@NonNull AppendParameterBinding object) {
		return visiting(object);	// FIXME
	}

	@Override
	public @Nullable Object visitBaseModel(@NonNull BaseModel object) {
		return visiting(object);
	}

	/*	@Override
	public Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp oppositePropertyCallExp) {
		QVTiModelManager modelManager = (QVTiModelManager) executor.getModelManager();
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
	public Object visitBufferStatement(@NonNull BufferStatement object) {
		Mapping asMapping = QVTimperativeUtil.getContainingMapping(object);
		assert asMapping != null;
		Interval interval = executor.getInterval(asMapping);
		Connection connection = null;
		OCLExpression ownedExpression = object.getOwnedExpression();
		String name = object.getName();
		assert name != null;
		if (ownedExpression != null) {
			Object initValue = ownedExpression.accept(undecoratedVisitor);
			connection = interval.createConnection(name, ownedExpression.getTypeId(), object.isIsStrict());
			if (initValue != null) {
				for (Object value : (Iterable<?>)initValue) {
					assert value != null;
					connection.appendElement(value);
				}
			}
		}
		else {
			connection = interval.createConnection(name, object.getTypeId(), object.isIsStrict());
		}
		return executor.replace(object, connection, false);
	}

	@Override
	public @Nullable Object visitCheckStatement(@NonNull CheckStatement predicate) {
		// Each predicate has a conditionExpression that is an OCLExpression
		OCLExpression exp = predicate.getOwnedExpression();
		// The predicated is visited with a nested environment
		Object expResult = exp.accept(undecoratedVisitor);
		return expResult;
	}

	@Override
	public Object visitConnectionVariable(@NonNull ConnectionVariable object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitDeclareStatement(@NonNull DeclareStatement asStatement) {
		Object initValue;
		OCLExpression ownedExpression = asStatement.getOwnedExpression();
		if (ownedExpression == null) {
			initValue = null;
		}
		else {
			initValue = ownedExpression.accept(undecoratedVisitor);
			if (asStatement.isIsCheck()) {
				Type guardType = asStatement.getType();
				Type valueType = idResolver.getDynamicTypeOf(initValue);
				if ((guardType == null) || !valueType.conformsTo(standardLibrary, guardType)) {
					// The initialization fails, the guard is not met
					return false;
				}
			}
		}
		return executor.replace(asStatement, initValue, false);
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
	public @Nullable Object visitGuardParameter(@NonNull GuardParameter object) {
		return visiting(object);
	}

	@Override
	public Object visitGuardParameterBinding(@NonNull GuardParameterBinding object) {
		return visiting(object);	// FIXME
	}

	@Override
	public @Nullable Object visitImperativeModel(@NonNull ImperativeModel imperativeModel) {
		for (org.eclipse.ocl.pivot.Package pkge : imperativeModel.getOwnedPackages()) {
			pkge.accept(undecoratedVisitor);
		}
		return true;
	}

	@Override
	public @Nullable Object visitImperativeTransformation(@NonNull ImperativeTransformation transformation) {
		return executor.internalExecuteTransformation(transformation, undecoratedVisitor);
	}

	@Override
	public @Nullable Object visitImperativeTypedModel(@NonNull ImperativeTypedModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitImport(@NonNull Import object) {
		return visiting(object);
	}

	@Override
	public Object visitLoopParameterBinding(@NonNull LoopParameterBinding object) {
		return visiting(object);	// FIXME
	}

	@Override
	public @Nullable Object visitLoopVariable(@NonNull LoopVariable object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitMapping(@NonNull Mapping mapping) {
		return executor.internalExecuteMapping(mapping, undecoratedVisitor);
	}

	@Override
	public @Nullable Object visitMappingCall(@NonNull MappingCall mappingCall) {
		if (mappingCall.isIsInstall()) {
			return doMappingInstall(mappingCall);
		}
		else {
			return doMappingCall(mappingCall);
		}
	}

	@Override
	public @Nullable Object visitMappingLoop(@NonNull MappingLoop mappingLoop) {
		Object inValues = mappingLoop.getOwnedExpression().accept(undecoratedVisitor);
		if (inValues instanceof Connection) {
			inValues = ((Connection)inValues).typedIterable(Object.class);
		}
		if (inValues instanceof Iterable<?>) {
			List<LoopVariable> iterators = mappingLoop.getOwnedIterators();
			if (iterators.size() > 0) {
				LoopVariable iterator = ClassUtil.nonNullState(iterators.get(0));
				for (Object object : (Iterable<?>)inValues) {
					if (!executor.replace(iterator, object, false)) {
						return false;
					}
					for (@NonNull MappingStatement mappingStatement : ClassUtil.nullFree(mappingLoop.getOwnedMappingStatements())) {
						context.pushEvaluationEnvironment(mappingStatement, mappingLoop);
						try {
							mappingStatement.accept(undecoratedVisitor);
						}
						finally {
							context.popEvaluationEnvironment();
						}
					}
				}
				executor.getInvocationManager().flush();
			}
		}
		return true;
	}

	@Override
	public @Nullable Object visitMappingParameter(@NonNull MappingParameter object) {
		return visiting(object);	// MappingParameter is abstract
	}

	@Override
	public @Nullable Object visitMappingParameterBinding(@NonNull MappingParameterBinding object) {
		return visiting(object);	// MappingCallBinding is serviced by the parent MappingCall
	}

	@Override
	public @Nullable Object visitMappingStatement(@NonNull MappingStatement object) {
		return visitStatement(object);	// MappingStatement is abstract
	}

	@Override
	public @Nullable Object visitNewStatement(@NonNull NewStatement newStatement) {
		return executor.internalExecuteNewStatement(newStatement, undecoratedVisitor) != null;
	}

	@Override
	public @Nullable Object visitObservableStatement(@NonNull ObservableStatement object) {
		return visiting(object);
	}

	/*	@Override
	public Object visitOppositePropertyCallExp(@NonNull OppositePropertyCallExp oppositePropertyCallExp) {
		QVTiModelManager modelManager = (QVTiModelManager) executor.getModelManager();
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
	public @Nullable Object visitPredicate(@NonNull Predicate object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitRule(@NonNull Rule object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitSetStatement(@NonNull SetStatement setStatement) {
		VariableDeclaration targetVariable = setStatement.getTargetVariable();
		if (targetVariable == null) {
			throw new InvalidValueException("Undefined variable", null, null, setStatement);
		}
		Object slotObject = executor.getValueOf(targetVariable);
		if (slotObject instanceof InvalidValueException) {
			throw (InvalidValueException)slotObject;
		}
		if (slotObject instanceof EObject) {
			Integer childKey = null;
			try {
				Object boxedValue = setStatement.getOwnedExpression().accept(undecoratedVisitor);
				Property targetProperty = QVTimperativeUtil.getTargetProperty(setStatement);
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
				executor.internalExecuteSetStatement(setStatement, slotObject, ecoreValue, childKey);
				return true;
			}
			catch (InvocationFailedException e) {
				executor.internalExecuteSetStatement(setStatement, slotObject, e, childKey);		// FIXME This leads to an AssertionError in PropertyImpl.initValue
				//				throw e;
			}
			//		} else if (slotObject == null){
			//			throw new InvalidValueException("Null source for '" + navigationAssignment.toString() + "'");
		} else {
			throw new IllegalArgumentException("Unsupported " + setStatement.eClass().getName()
				+ " specification. The assignment slot expression '" + setStatement.toString() + "'evaluates to non-ecore value: " + NameUtil.debugFullName(slotObject));
		}
		return true;
	}

	@Override
	public @Nullable Object visitSimpleParameter(@NonNull SimpleParameter object) {
		return visiting(object);
	}

	@Override
	public Object visitSimpleParameterBinding(@NonNull SimpleParameterBinding object) {
		return visiting(object);	// FIXME
	}

	@Override
	public @Nullable Object visitStatement(@NonNull Statement object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitTransformation(@NonNull Transformation object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitTypedModel(@NonNull TypedModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitVariableStatement(@NonNull VariableStatement object) {
		return visiting(object);
	}
}
