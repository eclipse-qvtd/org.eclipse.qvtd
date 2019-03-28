/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example5.tderived.impl;

import example5.tbase.impl.BImpl;

import example5.tderived.B2;
import example5.tderived.TderivedPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example5.tderived.impl.B2Impl#getAnotherName <em>Another Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class B2Impl extends BImpl implements B2 {
	/**
	 * The number of structural features of the '<em>B2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int B2_FEATURE_COUNT = BImpl.B_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>B2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int B2_OPERATION_COUNT = BImpl.B_OPERATION_COUNT + 0;

	/**
	 * The default value of the '{@link #getAnotherName() <em>Another Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnotherName()
	 * @generated
	 * @ordered
	 */
	protected static final String ANOTHER_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAnotherName() <em>Another Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnotherName()
	 * @generated
	 * @ordered
	 */
	protected String anotherName = ANOTHER_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TderivedPackage.Literals.B2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAnotherName() {
		return anotherName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAnotherName(String newAnotherName) {
		String oldAnotherName = anotherName;
		anotherName = newAnotherName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BImpl.B_FEATURE_COUNT + 0, oldAnotherName, anotherName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BImpl.B_FEATURE_COUNT + 0:
				return getAnotherName();
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
			case BImpl.B_FEATURE_COUNT + 0:
				setAnotherName((String)newValue);
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
			case BImpl.B_FEATURE_COUNT + 0:
				setAnotherName(ANOTHER_NAME_EDEFAULT);
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
			case BImpl.B_FEATURE_COUNT + 0:
				return ANOTHER_NAME_EDEFAULT == null ? anotherName != null : !ANOTHER_NAME_EDEFAULT.equals(anotherName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (anotherName: ");
		result.append(anotherName);
		result.append(')');
		return result.toString();
	}


} //B2Impl
