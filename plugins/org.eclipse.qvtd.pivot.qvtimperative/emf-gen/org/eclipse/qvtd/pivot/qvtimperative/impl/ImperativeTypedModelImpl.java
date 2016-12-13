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
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.ocl.pivot.library.logical.BooleanAndOperation;
import org.eclipse.ocl.pivot.library.logical.BooleanNotOperation;
import org.eclipse.ocl.pivot.library.oclany.OclComparableLessThanEqualOperation;
import org.eclipse.ocl.pivot.library.string.CGStringGetSeverityOperation;
import org.eclipse.ocl.pivot.library.string.CGStringLogDiagnosticOperation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeTables;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Imperative Typed Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTypedModelImpl#isIsChecked <em>Is Checked</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTypedModelImpl#isIsEnforced <em>Is Enforced</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTypedModelImpl#getAllUsedPackages <em>All Used Packages</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImperativeTypedModelImpl extends TypedModelImpl implements ImperativeTypedModel {
	/**
	 * The default value of the '{@link #isIsChecked() <em>Is Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsChecked()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CHECKED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsChecked() <em>Is Checked</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsChecked()
	 * @generated
	 * @ordered
	 */
	protected boolean isChecked = IS_CHECKED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsEnforced() <em>Is Enforced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforced()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENFORCED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEnforced() <em>Is Enforced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforced()
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforced = IS_ENFORCED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImperativeTypedModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.IMPERATIVE_TYPED_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsChecked() {
		return isChecked;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsChecked(boolean newIsChecked) {
		boolean oldIsChecked = isChecked;
		isChecked = newIsChecked;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.IMPERATIVE_TYPED_MODEL__IS_CHECKED, oldIsChecked, isChecked));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsEnforced() {
		return isEnforced;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsEnforced(boolean newIsEnforced) {
		boolean oldIsEnforced = isEnforced;
		isEnforced = newIsEnforced;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.IMPERATIVE_TYPED_MODEL__IS_ENFORCED, oldIsEnforced, isEnforced));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<org.eclipse.ocl.pivot.Package> getAllUsedPackages() {
		/**
		 * usedPackage
		 */
		final /*@Thrown*/ java.util.@NonNull List<org.eclipse.ocl.pivot.Package> usedPackage = this.getUsedPackage();
		return (EList<org.eclipse.ocl.pivot.Package>)usedPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean validateNameIsNotNull(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv NameIsNotNull:
		 *   let
		 *     severity : Integer[1] = 'ImperativeTypedModel::NameIsNotNull'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[1] = name <> null
		 *       in
		 *         'ImperativeTypedModel::NameIsNotNull'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_ImperativeTypedModel_c_c_NameIsNotNull);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @NonNull Object CAUGHT_status;
			try {
				final /*@Thrown*/ java.lang.@Nullable String name = this.getName();
				final /*@Thrown*/ boolean status = name != null;
				CAUGHT_status = status;
			}
			catch (Exception e) {
				CAUGHT_status = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_ImperativeTypedModel_c_c_NameIsNotNull, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_status, QVTimperativeTables.INT_0).booleanValue();
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
	public boolean validateNotBothCheckedAndEnforced(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
		/**
		 *
		 * inv NotBothCheckedAndEnforced:
		 *   let
		 *     severity : Integer[1] = 'ImperativeTypedModel::NotBothCheckedAndEnforced'.getSeverity()
		 *   in
		 *     if severity <= 0
		 *     then true
		 *     else
		 *       let status : OclAny[?] = not (isChecked and isEnforced)
		 *       in
		 *         'ImperativeTypedModel::NotBothCheckedAndEnforced'.logDiagnostic(self, null, diagnostics, context, null, severity, status, 0)
		 *     endif
		 */
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.evaluation.@NonNull Executor executor = PivotUtilInternal.getExecutor(this);
		final /*@NonInvalid*/ org.eclipse.ocl.pivot.values.@NonNull IntegerValue severity_0 = CGStringGetSeverityOperation.INSTANCE.evaluate(executor, QVTimperativeTables.STR_ImperativeTypedModel_c_c_NotBothCheckedAndEnforced);
		final /*@NonInvalid*/ boolean le = OclComparableLessThanEqualOperation.INSTANCE.evaluate(executor, severity_0, QVTimperativeTables.INT_0).booleanValue();
		/*@NonInvalid*/ boolean symbol_0;
		if (le) {
			symbol_0 = ValueUtil.TRUE_VALUE;
		}
		else {
			/*@Caught*/ @Nullable Object CAUGHT_status;
			try {
				/*@Caught*/ @Nullable Object CAUGHT_and;
				try {
					/*@Caught*/ @Nullable Object CAUGHT_isChecked;
					try {
						final /*@Thrown*/ java.lang.@Nullable Boolean isChecked = this.isIsChecked();
						CAUGHT_isChecked = isChecked;
					}
					catch (Exception e) {
						CAUGHT_isChecked = ValueUtil.createInvalidValue(e);
					}
					/*@Caught*/ @Nullable Object CAUGHT_isEnforced;
					try {
						final /*@Thrown*/ java.lang.@Nullable Boolean isEnforced = this.isIsEnforced();
						CAUGHT_isEnforced = isEnforced;
					}
					catch (Exception e) {
						CAUGHT_isEnforced = ValueUtil.createInvalidValue(e);
					}
					final /*@Thrown*/ java.lang.@Nullable Boolean and = BooleanAndOperation.INSTANCE.evaluate(CAUGHT_isChecked, CAUGHT_isEnforced);
					CAUGHT_and = and;
				}
				catch (Exception e) {
					CAUGHT_and = ValueUtil.createInvalidValue(e);
				}
				final /*@Thrown*/ java.lang.@Nullable Boolean status = BooleanNotOperation.INSTANCE.evaluate(CAUGHT_and);
				CAUGHT_status = status;
			}
			catch (Exception e) {
				CAUGHT_status = ValueUtil.createInvalidValue(e);
			}
			final /*@NonInvalid*/ boolean logDiagnostic = CGStringLogDiagnosticOperation.INSTANCE.evaluate(executor, TypeId.BOOLEAN, QVTimperativeTables.STR_ImperativeTypedModel_c_c_NotBothCheckedAndEnforced, this, (Object)null, diagnostics, context, (Object)null, severity_0, CAUGHT_status, QVTimperativeTables.INT_0).booleanValue();
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL__IS_CHECKED:
				return isIsChecked();
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL__IS_ENFORCED:
				return isIsEnforced();
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL__ALL_USED_PACKAGES:
				return getAllUsedPackages();
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
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL__IS_CHECKED:
				setIsChecked((Boolean)newValue);
				return;
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL__IS_ENFORCED:
				setIsEnforced((Boolean)newValue);
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
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL__IS_CHECKED:
				setIsChecked(IS_CHECKED_EDEFAULT);
				return;
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL__IS_ENFORCED:
				setIsEnforced(IS_ENFORCED_EDEFAULT);
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
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL__IS_CHECKED:
				return isChecked != IS_CHECKED_EDEFAULT;
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL__IS_ENFORCED:
				return isEnforced != IS_ENFORCED_EDEFAULT;
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL__ALL_USED_PACKAGES:
				return !getAllUsedPackages().isEmpty();
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
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP:
				return validateNameIsNotNull((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
			case QVTimperativePackage.IMPERATIVE_TYPED_MODEL___VALIDATE_NOT_BOTH_CHECKED_AND_ENFORCED__DIAGNOSTICCHAIN_MAP:
				return validateNotBothCheckedAndEnforced((DiagnosticChain)arguments.get(0), (Map<Object, Object>)arguments.get(1));
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
		return (R) ((QVTimperativeVisitor<?>)visitor).visitImperativeTypedModel(this);
	}

} //ImperativeTypedModelImpl
