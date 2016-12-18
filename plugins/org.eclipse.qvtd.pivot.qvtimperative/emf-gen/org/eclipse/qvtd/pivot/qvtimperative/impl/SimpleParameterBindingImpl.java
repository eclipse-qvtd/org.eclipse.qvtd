/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import java.lang.reflect.InvocationTargetException;
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
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.classifier.OclTypeConformsToOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanImpliesOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeTables;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterBindingImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterBindingImpl#isIsCheck <em>Is Check</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleParameterBindingImpl extends MappingParameterBindingImpl implements SimpleParameterBinding {
	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression value;

	/**
	 * The default value of the '{@link #isIsCheck() <em>Is Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheck()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CHECK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCheck() <em>Is Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheck()
	 * @generated
	 * @ordered
	 */
	protected boolean isCheck = IS_CHECK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleParameterBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.SIMPLE_PARAMETER_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(OCLExpression newValue, NotificationChain msgs) {
		OCLExpression oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SIMPLE_PARAMETER_BINDING__VALUE, oldValue, newValue);
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
	public void setValue(OCLExpression newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.SIMPLE_PARAMETER_BINDING__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.SIMPLE_PARAMETER_BINDING__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SIMPLE_PARAMETER_BINDING__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsCheck() {
		return isCheck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsCheck(boolean newIsCheck) {
		boolean oldIsCheck = isCheck;
		isCheck = newIsCheck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SIMPLE_PARAMETER_BINDING__IS_CHECK, oldIsCheck, isCheck));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleTypeForCheckedValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleTypeForCheckedValue:
		 *   let
		 *     severity : Integer[1] = 'SimpleParameterBinding::CompatibleTypeForCheckedValue'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = isCheck implies
		 *         boundVariable.type.conformsTo(value.type)
		 *       in
		 *         'SimpleParameterBinding::CompatibleTypeForCheckedValue'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_SimpleParameterBinding_c_c_CompatibleTypeForCheckedValue);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_result;
			try {
				/*@Caught*/ @Nullable Object CAUGHT_isCheck;
				try {
					final /*@Thrown*/ java.lang.@Nullable Boolean isCheck = this.isIsCheck();
					CAUGHT_isCheck = isCheck;
				}
				catch (Exception e) {
					CAUGHT_isCheck = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
				try {
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameter boundVariable = this.getBoundVariable();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type = boundVariable.getType();
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value = this.getValue();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type_0 = value.getType();
					final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
					CAUGHT_conformsTo = conformsTo;
				}
				catch (Exception e) {
					CAUGHT_conformsTo = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_isCheck, CAUGHT_conformsTo);
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_SimpleParameterBinding_c_c_CompatibleTypeForCheckedValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTimperativeTables.INT_0).booleanValue();
			symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateCompatibleTypeForUncheckedValue(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv CompatibleTypeForUncheckedValue:
		 *   let
		 *     severity : Integer[1] = 'SimpleParameterBinding::CompatibleTypeForUncheckedValue'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let result : Boolean[?] = not isCheck implies
		 *         value.type.conformsTo(boundVariable.type)
		 *       in
		 *         'SimpleParameterBinding::CompatibleTypeForUncheckedValue'.logDiagnostic(self, null, diagnostics, context, null, severity, result, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_SimpleParameterBinding_c_c_CompatibleTypeForUncheckedValue);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_result;
			try {
				/*@Caught*/ @Nullable Object CAUGHT_not;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_isCheck;
					try {
						final /*@Thrown*/ java.lang.@Nullable Boolean isCheck = this.isIsCheck();
						CAUGHT_isCheck = isCheck;
					}
					catch (Exception e) {
						CAUGHT_isCheck = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ java.lang.@Nullable Boolean not = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_isCheck);
					CAUGHT_not = not;
				}
				catch (Exception e) {
					CAUGHT_not = ValueUtil.createInvalidValue(e);
				}
				/*@Caught*/ @NonNull Object CAUGHT_conformsTo;
				try {
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.ocl.pivot.@NonNull OCLExpression value = this.getValue();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type = value.getType();
					@SuppressWarnings("null")
					final /*@Thrown*/ org.eclipse.qvtd.pivot.qvtimperative.@NonNull MappingParameter boundVariable = this.getBoundVariable();
					final /*@Thrown*/ org.eclipse.ocl.pivot.@Nullable Type type_0 = boundVariable.getType();
					final /*@Thrown*/ boolean conformsTo = OclTypeConformsToOperation.INSTANCE.evaluate(executor, type, type_0).booleanValue();
					CAUGHT_conformsTo = conformsTo;
				}
				catch (Exception e) {
					CAUGHT_conformsTo = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean result = BooleanImpliesOperation.INSTANCE.evaluate(CAUGHT_not, CAUGHT_conformsTo);
				CAUGHT_result = result;
			}
			catch (Exception e) {
				CAUGHT_result = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_SimpleParameterBinding_c_c_CompatibleTypeForUncheckedValue, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_result, QVTimperativeTables.INT_0).booleanValue();
			symbol_0 = logDiagnostic;
		}
		return Boolean.TRUE == symbol_0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativePackage.SIMPLE_PARAMETER_BINDING__VALUE:
				return basicSetValue(null, msgs);
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
			case QVTimperativePackage.SIMPLE_PARAMETER_BINDING__VALUE:
				return getValue();
			case QVTimperativePackage.SIMPLE_PARAMETER_BINDING__IS_CHECK:
				return isIsCheck();
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
			case QVTimperativePackage.SIMPLE_PARAMETER_BINDING__VALUE:
				setValue((OCLExpression)newValue);
				return;
			case QVTimperativePackage.SIMPLE_PARAMETER_BINDING__IS_CHECK:
				setIsCheck((Boolean)newValue);
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
			case QVTimperativePackage.SIMPLE_PARAMETER_BINDING__VALUE:
				setValue((OCLExpression)null);
				return;
			case QVTimperativePackage.SIMPLE_PARAMETER_BINDING__IS_CHECK:
				setIsCheck(IS_CHECK_EDEFAULT);
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
			case QVTimperativePackage.SIMPLE_PARAMETER_BINDING__VALUE:
				return value != null;
			case QVTimperativePackage.SIMPLE_PARAMETER_BINDING__IS_CHECK:
				return isCheck != IS_CHECK_EDEFAULT;
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
			case QVTimperativePackage.SIMPLE_PARAMETER_BINDING___VALIDATE_COMPATIBLE_TYPE_FOR_CHECKED_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleTypeForCheckedValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTimperativePackage.SIMPLE_PARAMETER_BINDING___VALIDATE_COMPATIBLE_TYPE_FOR_UNCHECKED_VALUE__DIAGNOSTICCHAIN_MAP:
				return validateCompatibleTypeForUncheckedValue((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTimperativeVisitor<?>)visitor).visitSimpleParameterBinding(this);
	}

} //SimpleParameterBindingImpl
