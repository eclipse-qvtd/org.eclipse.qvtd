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
import org.eclipse.ocl.pivot.values.CollectionValue.Accumulator;
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
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.GuardVariable;
import org.eclipse.qvtd.pivot.qvtimperative.IfStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.InConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.InitializeStatement;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.OutConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.VariableStatement;
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
	public @Nullable Object visitAddStatement(@NonNull AddStatement connectionStatement) {
		ConnectionVariable targetVariable = connectionStatement.getTargetVariable() ;
		if (targetVariable != null) {
			OCLExpression valueExpression = connectionStatement.getOwnedInit();
			if (valueExpression != null) {
				doConnectionAccumulation(targetVariable, valueExpression);
				return true;
			}
		}
		return null;
	}

	@Override
	public @Nullable Object visitBaseModel(@NonNull BaseModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitCheckStatement(@NonNull CheckStatement predicate) {
		// Each predicate has a conditionExpression that is an OCLExpression
		OCLExpression exp = predicate.getOwnedCondition();
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
		OCLExpression ownedInit = asStatement.getOwnedInit();
		if (ownedInit == null) {
			initValue = null;
		}
		else {
			initValue = ownedInit.accept(undecoratedVisitor);
			if (asStatement.isIsChecked()) {
				Type guardType = asStatement.getType();
				Type valueType = idResolver.getDynamicTypeOf(initValue);
				if ((guardType == null) || !valueType.conformsTo(standardLibrary, guardType)) {
					// The initialisation fails, the guard is not met
					return false;
				}
			}
		}
		executor.replace(asStatement, initValue, false);
		return true;
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
	public @Nullable Object visitGuardVariable(@NonNull GuardVariable object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitIfStatement(@NonNull IfStatement ifStatement) {
		OCLExpression exp = ifStatement.getOwnedCondition();
		Object expResult = exp.accept(undecoratedVisitor);
		if (expResult == Boolean.TRUE) {
			for (Statement asStatement : ifStatement.getOwnedThenStatements()) {
				Object result = asStatement.accept(this);
				if (result != Boolean.TRUE) {
					return result;
				}
			}
		}
		else if (expResult == Boolean.FALSE) {
			for (Statement asStatement : ifStatement.getOwnedElseStatements()) {
				Object result = asStatement.accept(this);
				if (result != Boolean.TRUE) {
					return result;
				}
			}
		}
		return expResult;
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
	public @Nullable Object visitImperativeTypedModel(@NonNull ImperativeTypedModel object) {
		return visiting(object);
	}

	@Override
	public @Nullable Object visitImport(@NonNull Import object) {
		return visiting(object);
	}

	@Override
	public Object visitInConnectionVariable(@NonNull InConnectionVariable object) {
		CollectionValue.Accumulator accumulator = ValueUtil.createCollectionAccumulatorValue((CollectionTypeId) object.getTypeId());
		executor.replace(object, accumulator, false);
		return true;
	}

	@Override
	public @Nullable Object visitInitializeStatement(@NonNull InitializeStatement asStatement) {
		OCLExpression ownedInit = asStatement.getOwnedInit();
		if (ownedInit == null) {
			return false;
		}
		VariableDeclaration asVariable = asStatement.getTargetVariable();
		if (asVariable == null) {
			return false;
		}
		Object initValue = ownedInit.accept(undecoratedVisitor);
		if (asStatement.isIsChecked()) {
			Type guardType = asVariable.getType();
			Type valueType = idResolver.getDynamicTypeOf(initValue);
			if ((guardType == null) || !valueType.conformsTo(standardLibrary, guardType)) {
				// The initialisation fails, the guard is not met
				return false;
			}
		}
		executor.replace(asVariable, initValue, false);
		return true;
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
		Mapping referredMapping = mappingCall.getReferredMapping();
		if (referredMapping == null) {
			return null;
		}
		@NonNull Object @NonNull [] boundValues = new @NonNull Object[mappingCall.getBinding().size()];
		int index = 0;
		for (MappingCallBinding binding : mappingCall.getBinding()) {
			VariableDeclaration boundVariable = binding.getBoundVariable();
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
			List<LoopVariable> iterators = mappingLoop.getOwnedIterators();
			if (iterators.size() > 0) {
				LoopVariable iterator = ClassUtil.nonNullState(iterators.get(0));
				for (Object object : (Iterable<?>)inValues) {
					((QVTiExecutor)context).replace(iterator, object, false);
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
			}
		}
		return true;
	}

	@Override
	public @Nullable Object visitMappingStatement(@NonNull MappingStatement object) {
		return visitStatement(object);	// MappingStatement is abstract
	}

	@Override
	public @Nullable Object visitNewStatement(@NonNull NewStatement newStatement) {
		return executor.internalExecuteNewStatement(newStatement, undecoratedVisitor) != null;
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
	public Object visitOutConnectionVariable(@NonNull OutConnectionVariable object) {
		CollectionValue.Accumulator accumulator;
		OCLExpression ownedInit = object.getOwnedInit();
		if (ownedInit != null) {
			Object initValue = ownedInit.accept(undecoratedVisitor);
			accumulator = ValueUtil.createCollectionAccumulatorValue((CollectionTypeId) ownedInit.getTypeId());
			if (initValue != null) {
				for (Object value : (Iterable<?>)initValue) {
					accumulator.add(value);
				}
			}
		}
		else {
			accumulator = ValueUtil.createCollectionAccumulatorValue((CollectionTypeId) object.getTypeId());
		}
		executor.replace(object, accumulator, false);
		return true;
	}

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
		Object slotObject = context.getValueOf(targetVariable);
		if (slotObject instanceof InvalidValueException) {
			throw (InvalidValueException)slotObject;
		}
		if (slotObject instanceof EObject) {
			Integer childKey = null;
			try {
				Object boxedValue = setStatement.getOwnedInit().accept(undecoratedVisitor);
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
	public @Nullable Object visitStatement(@NonNull Statement object) {
		return visitNamedElement(object);	// Statement is abstract
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
	public @Nullable Object visitVariableStatement(@NonNull VariableStatement object) {
		return visitStatement(object);
	}
}
