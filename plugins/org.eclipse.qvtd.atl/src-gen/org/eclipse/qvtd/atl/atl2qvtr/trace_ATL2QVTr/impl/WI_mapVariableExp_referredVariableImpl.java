/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.OCL.VariableExp;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WI_mapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>WI map Variable Exp referred Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.WI_mapVariableExp_referredVariableImpl#getAtl_atlExpression <em>Atl atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.WI_mapVariableExp_referredVariableImpl#getQvtr_qvtrExpression <em>Qvtr qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.WI_mapVariableExp_referredVariableImpl#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class WI_mapVariableExp_referredVariableImpl extends MinimalEObjectImpl.Container implements WI_mapVariableExp_referredVariable {
	/**
	 * The cached value of the '{@link #getAtl_atlExpression() <em>Atl atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlExpression()
	 * @generated
	 * @ordered
	 */
	protected VariableExp atl_atlExpression;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrExpression() <em>Qvtr qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrExpression()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.VariableExp qvtr_qvtrExpression;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected TI_mapVariableExp_referredVariable result;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WI_mapVariableExp_referredVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableExp getAtl_atlExpression() {
		if (atl_atlExpression != null && atl_atlExpression.eIsProxy()) {
			InternalEObject oldAtl_atlExpression = atl_atlExpression;
			atl_atlExpression = (VariableExp)eResolveProxy(oldAtl_atlExpression);
			if (atl_atlExpression != oldAtl_atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION, oldAtl_atlExpression, atl_atlExpression));
			}
		}
		return atl_atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExp basicGetAtl_atlExpression() {
		return atl_atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlExpression(VariableExp newAtl_atlExpression) {
		VariableExp oldAtl_atlExpression = atl_atlExpression;
		atl_atlExpression = newAtl_atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION, oldAtl_atlExpression, atl_atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.VariableExp getQvtr_qvtrExpression() {
		if (qvtr_qvtrExpression != null && qvtr_qvtrExpression.eIsProxy()) {
			InternalEObject oldQvtr_qvtrExpression = (InternalEObject)qvtr_qvtrExpression;
			qvtr_qvtrExpression = (org.eclipse.ocl.pivot.VariableExp)eResolveProxy(oldQvtr_qvtrExpression);
			if (qvtr_qvtrExpression != oldQvtr_qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION, oldQvtr_qvtrExpression, qvtr_qvtrExpression));
			}
		}
		return qvtr_qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.VariableExp basicGetQvtr_qvtrExpression() {
		return qvtr_qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrExpression(org.eclipse.ocl.pivot.VariableExp newQvtr_qvtrExpression) {
		org.eclipse.ocl.pivot.VariableExp oldQvtr_qvtrExpression = qvtr_qvtrExpression;
		qvtr_qvtrExpression = newQvtr_qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION, oldQvtr_qvtrExpression, qvtr_qvtrExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TI_mapVariableExp_referredVariable getResult() {
		if (result != null && result.eIsProxy()) {
			InternalEObject oldResult = (InternalEObject)result;
			result = (TI_mapVariableExp_referredVariable)eResolveProxy(oldResult);
			if (result != oldResult) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__RESULT, oldResult, result));
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TI_mapVariableExp_referredVariable basicGetResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResult(TI_mapVariableExp_referredVariable newResult) {
		TI_mapVariableExp_referredVariable oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__RESULT, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION:
				if (resolve) return getAtl_atlExpression();
				return basicGetAtl_atlExpression();
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION:
				if (resolve) return getQvtr_qvtrExpression();
				return basicGetQvtr_qvtrExpression();
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__RESULT:
				if (resolve) return getResult();
				return basicGetResult();
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
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION:
				setAtl_atlExpression((VariableExp)newValue);
				return;
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION:
				setQvtr_qvtrExpression((org.eclipse.ocl.pivot.VariableExp)newValue);
				return;
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__RESULT:
				setResult((TI_mapVariableExp_referredVariable)newValue);
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
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION:
				setAtl_atlExpression((VariableExp)null);
				return;
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION:
				setQvtr_qvtrExpression((org.eclipse.ocl.pivot.VariableExp)null);
				return;
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__RESULT:
				setResult((TI_mapVariableExp_referredVariable)null);
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
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__ATL_ATL_EXPRESSION:
				return atl_atlExpression != null;
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__QVTR_QVTR_EXPRESSION:
				return qvtr_qvtrExpression != null;
			case trace_ATL2QVTrPackage.WI_MAP_VARIABLE_EXP_REFERRED_VARIABLE__RESULT:
				return result != null;
		}
		return super.eIsSet(featureID);
	}

} //WI_mapVariableExp_referredVariableImpl
