/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.OCL.OperationCallExp;

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TOperation Call Exp2 Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOperationCallExp2OperationCallExpImpl#get_success <em>success</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOperationCallExp2OperationCallExpImpl#getAExpression <em>AExpression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOperationCallExp2OperationCallExpImpl#getRExpression <em>RExpression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TOperationCallExp2OperationCallExpImpl extends MinimalEObjectImpl.Container implements TOperationCallExp2OperationCallExp {
	/**
	 * The default value of the '{@link #get_success() <em>success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_success()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean _SUCCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #get_success() <em>success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_success()
	 * @generated
	 * @ordered
	 */
	protected Boolean _success = _SUCCESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAExpression() <em>AExpression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAExpression()
	 * @generated
	 * @ordered
	 */
	protected OperationCallExp aExpression;

	/**
	 * The cached value of the '{@link #getRExpression() <em>RExpression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRExpression()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.OperationCallExp rExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TOperationCallExp2OperationCallExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PATL2QVTrPackage.Literals.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean get_success() {
		return _success;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void set_success(Boolean new_success) {
		Boolean old_success = _success;
		_success = new_success;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__SUCCESS, old_success, _success));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExp getAExpression() {
		if (aExpression != null && aExpression.eIsProxy()) {
			InternalEObject oldAExpression = (InternalEObject)aExpression;
			aExpression = (OperationCallExp)eResolveProxy(oldAExpression);
			if (aExpression != oldAExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__AEXPRESSION, oldAExpression, aExpression));
			}
		}
		return aExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExp basicGetAExpression() {
		return aExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAExpression(OperationCallExp newAExpression) {
		OperationCallExp oldAExpression = aExpression;
		aExpression = newAExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__AEXPRESSION, oldAExpression, aExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.OperationCallExp getRExpression() {
		if (rExpression != null && rExpression.eIsProxy()) {
			InternalEObject oldRExpression = (InternalEObject)rExpression;
			rExpression = (org.eclipse.ocl.pivot.OperationCallExp)eResolveProxy(oldRExpression);
			if (rExpression != oldRExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__REXPRESSION, oldRExpression, rExpression));
			}
		}
		return rExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.OperationCallExp basicGetRExpression() {
		return rExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRExpression(org.eclipse.ocl.pivot.OperationCallExp newRExpression) {
		org.eclipse.ocl.pivot.OperationCallExp oldRExpression = rExpression;
		rExpression = newRExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__REXPRESSION, oldRExpression, rExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__SUCCESS:
				return get_success();
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__AEXPRESSION:
				if (resolve) return getAExpression();
				return basicGetAExpression();
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__REXPRESSION:
				if (resolve) return getRExpression();
				return basicGetRExpression();
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
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__SUCCESS:
				set_success((Boolean)newValue);
				return;
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__AEXPRESSION:
				setAExpression((OperationCallExp)newValue);
				return;
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__REXPRESSION:
				setRExpression((org.eclipse.ocl.pivot.OperationCallExp)newValue);
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
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__SUCCESS:
				set_success(_SUCCESS_EDEFAULT);
				return;
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__AEXPRESSION:
				setAExpression((OperationCallExp)null);
				return;
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__REXPRESSION:
				setRExpression((org.eclipse.ocl.pivot.OperationCallExp)null);
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
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__SUCCESS:
				return _SUCCESS_EDEFAULT == null ? _success != null : !_SUCCESS_EDEFAULT.equals(_success);
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__AEXPRESSION:
				return aExpression != null;
			case PATL2QVTrPackage.TOPERATION_CALL_EXP2_OPERATION_CALL_EXP__REXPRESSION:
				return rExpression != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (_success: ");
		result.append(_success);
		result.append(')');
		return result.toString();
	}

} //TOperationCallExp2OperationCallExpImpl
