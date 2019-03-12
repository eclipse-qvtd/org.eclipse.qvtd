/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteInheritance;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.ExpressionInOCLImpl;
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
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbaseTables;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

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
	 * The cached value of the '{@link #getQueryExpression() <em>Query Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression queryExpression;

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
	public OCLExpression getQueryExpression() {
		return queryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQueryExpression(OCLExpression newQueryExpression, NotificationChain msgs) {
		OCLExpression oldQueryExpression = queryExpression;
		queryExpression = newQueryExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OperationImpl.OPERATION_FEATURE_COUNT + 0, oldQueryExpression, newQueryExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQueryExpression(OCLExpression newQueryExpression) {
		if (newQueryExpression != queryExpression) {
			NotificationChain msgs = null;
			if (queryExpression != null)
				msgs = ((InternalEObject)queryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (OperationImpl.OPERATION_FEATURE_COUNT + 0), null, msgs);
			if (newQueryExpression != null)
				msgs = ((InternalEObject)newQueryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (OperationImpl.OPERATION_FEATURE_COUNT + 0), null, msgs);
			msgs = basicSetQueryExpression(newQueryExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationImpl.OPERATION_FEATURE_COUNT + 0, newQueryExpression, newQueryExpression));
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
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			final /*@NonInvalid*/ @NonNull IdResolver idResolver = executor.getIdResolver();
			/*@Caught*/ @NonNull Object CAUGHT_severity_0;
			try {
				final /*@Thrown*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.FUNCTION___VALIDATE_PARAMETERS_ARE_FUNCTION_PARAMETER__DIAGNOSTICCHAIN_MAP);
				CAUGHT_severity_0 = severity_0;
			}
			catch (Exception e) {
				CAUGHT_severity_0 = ValueUtil.createInvalidValue(e);
			}
			if (CAUGHT_severity_0 instanceof InvalidValueException) {
				throw (InvalidValueException)CAUGHT_severity_0;
			}
			final /*@Thrown*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, CAUGHT_severity_0, QVTbaseTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				final /*@NonInvalid*/ @NonNull List<Parameter> ownedParameters = this.getOwnedParameters();
				final /*@NonInvalid*/ @NonNull OrderedSetValue BOXED_ownedParameters = idResolver.createOrderedSetOfAll(QVTbaseTables.ORD_CLSSid_Parameter, ownedParameters);
				/*@Thrown*/ @Nullable Object accumulator = ValueUtil.TRUE_VALUE;
				@NonNull Iterator<Object> ITERATOR__1 = BOXED_ownedParameters.iterator();
				/*@NonInvalid*/ @Nullable Boolean result;
				while (true) {
					if (!ITERATOR__1.hasNext()) {
						if (accumulator == ValueUtil.TRUE_VALUE) {
							result = ValueUtil.TRUE_VALUE;
						}
						else {
							throw (InvalidValueException)accumulator;
						}
						break;
					}
					@SuppressWarnings("null")
					/*@NonInvalid*/ @NonNull Parameter _1 = (@NonNull Parameter)ITERATOR__1.next();
					/**
					 * oclIsKindOf(FunctionParameter)
					 */
					final /*@NonInvalid*/ org.eclipse.ocl.pivot.@NonNull Class TYP_qvtbase_c_c_FunctionParameter = idResolver.getClass(QVTbaseTables.CLSSid_FunctionParameter, null);
					final /*@NonInvalid*/ boolean oclIsKindOf = OclAnyOclIsKindOfOperation.INSTANCE.evaluate(executor, _1, TYP_qvtbase_c_c_FunctionParameter).booleanValue();
					//
					if (oclIsKindOf == ValueUtil.FALSE_VALUE) {					// Normal unsuccessful body evaluation result
						result = ValueUtil.FALSE_VALUE;
						break;														// Stop immediately
					}
					else if (oclIsKindOf == ValueUtil.TRUE_VALUE) {				// Normal successful body evaluation result
						;															// Carry on
					}
					else {															// Impossible badly typed result
						accumulator = new InvalidValueException(PivotMessages.NonBooleanBody, "forAll");
					}
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, CAUGHT_severity_0, result, QVTbaseTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
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
			final /*@NonInvalid*/ @NonNull Executor executor = PivotUtil.getExecutor(this, context);
			/*@Caught*/ @NonNull Object CAUGHT_severity_0;
			try {
				final /*@Thrown*/ @NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTbasePackage.Literals.FUNCTION___VALIDATE_RETURN_TYPE_IS_QUERY_TYPE__DIAGNOSTICCHAIN_MAP);
				CAUGHT_severity_0 = severity_0;
			}
			catch (Exception e) {
				CAUGHT_severity_0 = ValueUtil.createInvalidValue(e);
			}
			if (CAUGHT_severity_0 instanceof InvalidValueException) {
				throw (InvalidValueException)CAUGHT_severity_0;
			}
			final /*@Thrown*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, CAUGHT_severity_0, QVTbaseTables.INT_0).booleanValue();
			/*@NonInvalid*/ boolean symbol_0;
			if (le) {
				symbol_0 = ValueUtil.TRUE_VALUE;
			}
			else {
				/*@Caught*/ @Nullable Object CAUGHT_result;
				try {
					final /*@NonInvalid*/ @Nullable OCLExpression queryExpression = this.getQueryExpression();
					final /*@NonInvalid*/ boolean ne = queryExpression != null;
					/*@Thrown*/ @Nullable Boolean result;
					if (ne) {
						if (queryExpression == null) {
							throw new InvalidValueException("Null source for \'TypedElement::type\'");
						}
						final /*@Thrown*/ @Nullable Type type = queryExpression.getType();
						/*@Caught*/ @Nullable Object CAUGHT_type;
						try {
							CAUGHT_type = type;
						}
						catch (Exception e) {
							CAUGHT_type = ValueUtil.createInvalidValue(e);
						}
						final /*@NonInvalid*/ @NonNull Object conformsTo = CAUGHT_type == null;
						/*@Thrown*/ @Nullable Boolean safe_conformsTo_source;
						if (conformsTo == Boolean.TRUE) {
							safe_conformsTo_source = null;
						}
						else {
							final /*@NonInvalid*/ @Nullable Type type_0 = this.getType();
							final /*@Thrown*/ boolean conformsTo_0 = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
							safe_conformsTo_source = conformsTo_0;
						}
						result = safe_conformsTo_source;
					}
					else {
						result = ValueUtil.TRUE_VALUE;
					}
					CAUGHT_result = result;
				}
				catch (Exception e) {
					CAUGHT_result = ValueUtil.createInvalidValue(e);
				}
				final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, constraintName, this, (Object)null, diagnostics, context, (Object)null, CAUGHT_severity_0, CAUGHT_result, QVTbaseTables.INT_0).booleanValue();
				symbol_0 = logDiagnostic;
			}
			return Boolean.TRUE == symbol_0;
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OperationImpl.OPERATION_FEATURE_COUNT + 0:
				return basicSetQueryExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
				return queryExpression != null;
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
		return (R) ((QVTbaseVisitor<?>)visitor).visitFunction(this);
	}

	@Override
	public @Nullable CompleteInheritance getInheritance(@NonNull StandardLibrary standardLibrary) {
		return null;
	}

	private final class Function_Body_481664 extends ExpressionInOCLImpl			// FIXME Bug 481664 workaround
	{
		@Override
		public OCLExpression getOwnedBody() {
			return getQueryExpression();
		}

		@Override
		public Type getType() {
			OCLExpression queryExpression = getQueryExpression();
			return queryExpression != null ? queryExpression.getType() : null;
		}
	}

	@Override
	public LanguageExpression getBodyExpression() {			// FIXME Bug 481664 workaround
		return new Function_Body_481664();
	}

	@Override
	public void setBodyExpression(LanguageExpression newBodyExpression) {		// FIXME Bug 481664 workaround
		if (newBodyExpression.getClass() != Function_Body_481664.class) {
			throw new UnsupportedOperationException();
		}
	}
} //FunctionImpl
