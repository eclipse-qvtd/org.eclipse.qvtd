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
package example5.sderived.impl;

import example5.sbase.impl.YImpl;

import example5.sderived.SderivedPackage;
import example5.sderived.Y2;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Y2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example5.sderived.impl.Y2Impl#getName2 <em>Name2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Y2Impl extends YImpl implements Y2 {
	/**
	 * The number of structural features of the '<em>Y2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int Y2_FEATURE_COUNT = YImpl.Y_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Y2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int Y2_OPERATION_COUNT = YImpl.Y_OPERATION_COUNT + 0;

	/**
	 * The default value of the '{@link #getName2() <em>Name2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName2()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName2() <em>Name2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName2()
	 * @generated
	 * @ordered
	 */
	protected String name2 = NAME2_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Y2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SderivedPackage.Literals.Y2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName2() {
		return name2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName2(String newName2) {
		String oldName2 = name2;
		name2 = newName2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, YImpl.Y_FEATURE_COUNT + 0, oldName2, name2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case YImpl.Y_FEATURE_COUNT + 0:
				return getName2();
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
			case YImpl.Y_FEATURE_COUNT + 0:
				setName2((String)newValue);
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
			case YImpl.Y_FEATURE_COUNT + 0:
				setName2(NAME2_EDEFAULT);
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
			case YImpl.Y_FEATURE_COUNT + 0:
				return NAME2_EDEFAULT == null ? name2 != null : !NAME2_EDEFAULT.equals(name2);
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
		result.append(" (name2: ");
		result.append(name2);
		result.append(')');
		return result.toString();
	}


} //Y2Impl
