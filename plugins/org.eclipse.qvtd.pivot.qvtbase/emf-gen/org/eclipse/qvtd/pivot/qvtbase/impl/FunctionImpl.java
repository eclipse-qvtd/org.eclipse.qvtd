/*******************************************************************************
 * Copyright (c) 2011, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.ParameterVariable;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.OperationImpl;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.oclany.OclAnyOclIsKindOfOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.messages.PivotMessages;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;
import org.eclipse.ocl.pivot.values.InvalidValueException;
import org.eclipse.ocl.pivot.values.OrderedSetValue;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionBody;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.FunctionImpl#getQueryExpression <em>Query Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FunctionImpl extends OperationImpl implements Function {

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_FEATURE_COUNT = OperationImpl.OPERATION_FEATURE_COUNT + 1;
	/**
	 * The number of operations of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FUNCTION_OPERATION_COUNT = OperationImpl.OPERATION_OPERATION_COUNT + 2;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTbasePackage.Literals.FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateParametersAreFunctionParameter(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Function::ParametersAreFunctionParameter";
		try {
			/**
			 *
			 * inv ParametersAreFunctionParameter:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let
			 *         result : Boolean[?] = ownedParameters->forAll(
			 *           oclIsKindOf(FunctionParameter))
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.FUNCTION___VALIDATE_PARAMETERS_ARE_FUNCTION_PARAMETER__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTbaseTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				final /*@NonInvalid*/ @NonNull List<Parameter> ownedParameters = this.getOwnedParameters();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedParameters = idResolver.createOrderedSetOfAll(QVTbaseTables.ORD_CLSSid_Parameter, ownedParameters);
				/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
				@NonNull Iterator<Object> ITER__1 = BOXED_ownedParameters.iterator();
				/*@NonInvalid*/ @Nullable Boolean forAll;
				while (true) {
					if (!ITER__1.hasNext()) {
						if (accumulator == ValueUtil.TRUE_VALUE) {
							forAll = ValueUtil.TRUE_VALUE;
						}
						else {
							throw (InvalidValueException)accumulator;
						}
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Parameter _1 = (@NonNull Parameter)ITER__1.next();
					/**
					 * oclIsKindOf(FunctionParameter)
					 */
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtbase_c_c_FunctionParameter = idResolver.getClass(QVTbaseTables.CLSSid_FunctionParameter, null);
					final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, _1, TYP_qvtbase_c_c_FunctionParameter).booleanValue();
					//
					if (!oclIsKindOf) {					// Normal unsuccessful body evaluation result
						forAll = ValueUtil.FALSE_VALUE;
						break;														// Stop immediately
					}
					else if (oclIsKindOf) {				// Normal successful body evaluation result
						;															// Carry on
					}
					else {															// Impossible badly typed result
						accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, forAll, QVTbaseTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateReturnTypeIsQueryType(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		final @NonNull String constraintName = "Function::ReturnTypeIsQueryType";
		try {
			/**
			 *
			 * inv ReturnTypeIsQueryType:
			 *   let severity : Integer[1] = constraintName.getSeverity()
			 *   in
			 *     if severity <= 0
			 *     then true
			 *     else
			 *       let result : Boolean[?] = queryExpression <> null implies
			 *         queryExpression.type?.conformsTo(type)
			 *       in
			 *         constraintName.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
			 *     endif
			 */
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this);
			final /*@NonInvalid*/ @NonNull IntegerValue getSeverity = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.FUNCTION___VALIDATE_RETURN_TYPE_IS_QUERY_TYPE__DIAGNOSTICCHAIN_MAP);
			final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, getSeverity, QVTbaseTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean IF_le;
			if (le) {
				IF_le = true;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_implies;
				try {
					final /*@NonInvalid*/ @Nullable OCLExpression queryExpression = this.getQueryExpression();
					final /*@NonInvalid*/ boolean IsEQ_ = queryExpression != null;
					final /*@Thrown*/ @Nullable Boolean implies;
					if (!IsEQ_) {
						implies = ValueUtil.TRUE_VALUE;
					}
					else {
						/*@Caught*/ @Nullable Object CAUGHT_type;
						try {
							if (queryExpression == null) {
								throw new InvalidValueException("Null source for \'TypedElement::type\'");
							}
							final /*@Thrown*/ @Nullable Type type = queryExpression.getType();
							CAUGHT_type = type;
						}
						catch (Exception THROWN_CAUGHT_type) {
							CAUGHT_type = ValueUtil.createInvalidValue(THROWN_CAUGHT_type);
						}
						if (CAUGHT_type instanceof InvalidValueException) {
							throw (InvalidValueException)CAUGHT_type;
						}
						final /*@Thrown*/ @Nullable Type THROWN_type = (@Nullable Type)CAUGHT_type;
						final /*@NonInvalid*/ boolean IsEQ2_ = THROWN_type == null;
						/*@Caught*/ @Nullable Object IF_IsEQ2_;
						if (IsEQ2_) {
							IF_IsEQ2_ = null;
						}
						else {
							/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
							try {
								if (THROWN_type == null) {
									throw new InvalidValueException("Null \'\'Type\'\' rather than \'\'OclVoid\'\' value required");
								}
								final /*@NonInvalid*/ @Nullable Type type_0 = this.getType();
								final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, THROWN_type, type_0).booleanValue();
								CAUGHT_conformsTo = conformsTo;
							}
							catch (Exception THROWN_CAUGHT_conformsTo) {
								CAUGHT_conformsTo = ValueUtil.createInvalidValue(THROWN_CAUGHT_conformsTo);
							}
							IF_IsEQ2_ = CAUGHT_conformsTo;
						}
						if (IF_IsEQ2_ == ValueUtil.TRUE_VALUE) {
							implies = ValueUtil.TRUE_VALUE;
						}
						else {
							if (IF_IsEQ2_ instanceof InvalidValueException) {
								throw (InvalidValueException)IF_IsEQ2_;
							}
							if (IF_IsEQ2_ == null) {
								implies = null;
							}
							else {
								implies = ValueUtil.FALSE_VALUE;
							}
						}
					}
					CAUGHT_implies = implies;
				}
				catch (Exception THROWN_CAUGHT_implies) {
					CAUGHT_implies = ValueUtil.createInvalidValue(THROWN_CAUGHT_implies);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, getSeverity, CAUGHT_implies, QVTbaseTables.INT_0).booleanValue();
				IF_le = logDiagnostic;
			}
			return IF_le;
		}
		catch (Throwable e) {
			return ValueUtil.validationFailedDiagnostic(constraintName, this, diagnostics, context, e);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationImpl.OPERATION_FEATURE_COUNT + 0:
				return getQueryExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OperationImpl.OPERATION_FEATURE_COUNT + 0:
				setQueryExpression((OCLExpression)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OperationImpl.OPERATION_FEATURE_COUNT + 0:
				setQueryExpression((OCLExpression)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OperationImpl.OPERATION_FEATURE_COUNT + 0:
				return getQueryExpression() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	@SuppressWarnings("unchecked")
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case OperationImpl.OPERATION_OPERATION_COUNT + 0:
				return validateParametersAreFunctionParameter((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case OperationImpl.OPERATION_OPERATION_COUNT + 1:
				return validateReturnTypeIsQueryType((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTbaseVisitor) {
			return (R) ((QVTbaseVisitor<?>)visitor).visitFunction(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	@Override
	public @Nullable CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		return null;
	}

	/**
	 * Return the query expression from the underlying Operation.ownedBody. See Bug 481664.
	 *
	 * @generated NOT
	 */
	@Override
	public OCLExpression getQueryExpression() {
		if (bodyExpression == null) {
			return null;
		}
		return ((ExpressionInOCL)bodyExpression).getOwnedBody();
	}

	/**
	 * Set the query expression in the underlying Operation.ownedBody. See Bug 481664.
	 *
	 * @generated NOT
	 */
	@Override
	public void setQueryExpression(OCLExpression newQueryExpression) {
		if (newQueryExpression != null) {
			Transformation asTransformation = QVTbaseUtil.getContainingTransformation(this);
			ParameterVariable asContextParameter = asTransformation.getOwnedContext();
			assert asContextParameter != null;		// Caller must create asTransformation.getOwnedContext()
			assert ownedParameters != null;			// Caller must create this.getOwnedParameters()
			ParameterVariable asContextVariable = QVTbaseUtil.createParameterVariable(asContextParameter);
			int size = ownedParameters.size();
			ParameterVariable[] asParameterVariables = new ParameterVariable[size];
			for (int i = 0; i < size; i++) {
				Parameter asParameter = ownedParameters.get(i);
				assert asParameter != null;
				asParameterVariables[i] = QVTbaseUtil.createParameterVariable(asParameter);
			}
			FunctionBody asFunctionBody = QVTbaseFactory.eINSTANCE.createFunctionBody();
			asFunctionBody.setOwnedContext(asContextVariable);
			for (Variable asParameterVariable : asParameterVariables) {
				asFunctionBody.getOwnedParameters().add(asParameterVariable);
			}
			asFunctionBody.setOwnedBody(newQueryExpression);
			asFunctionBody.setIsRequired(newQueryExpression.isIsRequired());
			super.setBodyExpression(asFunctionBody);
		}
		else {
			super.setBodyExpression(null);
		}
	}
} //FunctionImpl
