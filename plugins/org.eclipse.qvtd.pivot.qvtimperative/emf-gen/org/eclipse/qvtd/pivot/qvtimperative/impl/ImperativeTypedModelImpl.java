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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
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
		}
		return super.eIsSet(featureID);
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
