/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapIntegerExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Integer Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapIntegerExpImpl#getPrimitive_symbol <em>Primitive symbol</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapIntegerExpImpl extends TI_mapIntegerExpImpl implements TC_mapIntegerExp {
	/**
	 * The default value of the '{@link #getPrimitive_symbol() <em>Primitive symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_symbol()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger PRIMITIVE_SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimitive_symbol() <em>Primitive symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_symbol()
	 * @generated
	 * @ordered
	 */
	protected BigInteger primitive_symbol = PRIMITIVE_SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapIntegerExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_INTEGER_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BigInteger getPrimitive_symbol() {
		return primitive_symbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimitive_symbol(BigInteger newPrimitive_symbol) {
		BigInteger oldPrimitive_symbol = primitive_symbol;
		primitive_symbol = newPrimitive_symbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_INTEGER_EXP__PRIMITIVE_SYMBOL, oldPrimitive_symbol, primitive_symbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_INTEGER_EXP__PRIMITIVE_SYMBOL:
				return getPrimitive_symbol();
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
			case trace_ATL2QVTrPackage.TC_MAP_INTEGER_EXP__PRIMITIVE_SYMBOL:
				setPrimitive_symbol((BigInteger)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_INTEGER_EXP__PRIMITIVE_SYMBOL:
				setPrimitive_symbol(PRIMITIVE_SYMBOL_EDEFAULT);
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
			case trace_ATL2QVTrPackage.TC_MAP_INTEGER_EXP__PRIMITIVE_SYMBOL:
				return PRIMITIVE_SYMBOL_EDEFAULT == null ? primitive_symbol != null : !PRIMITIVE_SYMBOL_EDEFAULT.equals(primitive_symbol);
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
		result.append(" (primitive_symbol: ");
		result.append(primitive_symbol);
		result.append(')');
		return result.toString();
	}

} //TC_mapIntegerExpImpl
