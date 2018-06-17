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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.atl.common.OCL.VariableExp;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Variable Exp referred Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapVariableExp_referredVariableImpl#getAtl_atlExpression1 <em>Atl atl Expression1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapVariableExp_referredVariableImpl#getQvtr_qvtrExpression1 <em>Qvtr qvtr Expression1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapVariableExp_referredVariableImpl extends TI_mapVariableExp_referredVariableImpl implements TC_mapVariableExp_referredVariable {
	/**
	 * The cached value of the '{@link #getAtl_atlExpression1() <em>Atl atl Expression1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlExpression1()
	 * @generated
	 * @ordered
	 */
	protected VariableExp atl_atlExpression1;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrExpression1() <em>Qvtr qvtr Expression1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrExpression1()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.VariableExp qvtr_qvtrExpression1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapVariableExp_referredVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableExp getAtl_atlExpression1() {
		if (atl_atlExpression1 != null && atl_atlExpression1.eIsProxy()) {
			InternalEObject oldAtl_atlExpression1 = atl_atlExpression1;
			atl_atlExpression1 = (VariableExp)eResolveProxy(oldAtl_atlExpression1);
			if (atl_atlExpression1 != oldAtl_atlExpression1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION1, oldAtl_atlExpression1, atl_atlExpression1));
			}
		}
		return atl_atlExpression1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExp basicGetAtl_atlExpression1() {
		return atl_atlExpression1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlExpression1(VariableExp newAtl_atlExpression1) {
		VariableExp oldAtl_atlExpression1 = atl_atlExpression1;
		atl_atlExpression1 = newAtl_atlExpression1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION1, oldAtl_atlExpression1, atl_atlExpression1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.VariableExp getQvtr_qvtrExpression1() {
		if (qvtr_qvtrExpression1 != null && qvtr_qvtrExpression1.eIsProxy()) {
			InternalEObject oldQvtr_qvtrExpression1 = (InternalEObject)qvtr_qvtrExpression1;
			qvtr_qvtrExpression1 = (org.eclipse.ocl.pivot.VariableExp)eResolveProxy(oldQvtr_qvtrExpression1);
			if (qvtr_qvtrExpression1 != oldQvtr_qvtrExpression1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION1, oldQvtr_qvtrExpression1, qvtr_qvtrExpression1));
			}
		}
		return qvtr_qvtrExpression1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.VariableExp basicGetQvtr_qvtrExpression1() {
		return qvtr_qvtrExpression1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrExpression1(org.eclipse.ocl.pivot.VariableExp newQvtr_qvtrExpression1) {
		org.eclipse.ocl.pivot.VariableExp oldQvtr_qvtrExpression1 = qvtr_qvtrExpression1;
		qvtr_qvtrExpression1 = newQvtr_qvtrExpression1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION1, oldQvtr_qvtrExpression1, qvtr_qvtrExpression1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION1:
				if (resolve) return getAtl_atlExpression1();
				return basicGetAtl_atlExpression1();
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION1:
				if (resolve) return getQvtr_qvtrExpression1();
				return basicGetQvtr_qvtrExpression1();
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
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION1:
				setAtl_atlExpression1((VariableExp)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION1:
				setQvtr_qvtrExpression1((org.eclipse.ocl.pivot.VariableExp)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION1:
				setAtl_atlExpression1((VariableExp)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION1:
				setQvtr_qvtrExpression1((org.eclipse.ocl.pivot.VariableExp)null);
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
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION1:
				return atl_atlExpression1 != null;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION1:
				return qvtr_qvtrExpression1 != null;
		}
		return super.eIsSet(featureID);
	}

} //TC_mapVariableExp_referredVariableImpl
