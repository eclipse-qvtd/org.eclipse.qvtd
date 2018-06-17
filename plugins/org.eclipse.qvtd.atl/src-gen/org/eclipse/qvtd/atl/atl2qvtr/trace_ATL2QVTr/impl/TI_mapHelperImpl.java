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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.ATL.Helper;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapHelper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.Function;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TI map Helper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TI_mapHelperImpl#getAtl_atlHelper <em>Atl atl Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TI_mapHelperImpl#getQvtr_qvtrFunction <em>Qvtr qvtr Function</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TI_mapHelperImpl#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TI_mapHelperImpl extends MinimalEObjectImpl.Container implements TI_mapHelper {
	/**
	 * The cached value of the '{@link #getAtl_atlHelper() <em>Atl atl Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlHelper()
	 * @generated
	 * @ordered
	 */
	protected Helper atl_atlHelper;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrFunction() <em>Qvtr qvtr Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrFunction()
	 * @generated
	 * @ordered
	 */
	protected Function qvtr_qvtrFunction;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected Boolean status = STATUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TI_mapHelperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TI_MAP_HELPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Helper getAtl_atlHelper() {
		if (atl_atlHelper != null && atl_atlHelper.eIsProxy()) {
			InternalEObject oldAtl_atlHelper = atl_atlHelper;
			atl_atlHelper = (Helper)eResolveProxy(oldAtl_atlHelper);
			if (atl_atlHelper != oldAtl_atlHelper) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TI_MAP_HELPER__ATL_ATL_HELPER, oldAtl_atlHelper, atl_atlHelper));
			}
		}
		return atl_atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Helper basicGetAtl_atlHelper() {
		return atl_atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlHelper(Helper newAtl_atlHelper) {
		Helper oldAtl_atlHelper = atl_atlHelper;
		atl_atlHelper = newAtl_atlHelper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TI_MAP_HELPER__ATL_ATL_HELPER, oldAtl_atlHelper, atl_atlHelper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Function getQvtr_qvtrFunction() {
		if (qvtr_qvtrFunction != null && qvtr_qvtrFunction.eIsProxy()) {
			InternalEObject oldQvtr_qvtrFunction = (InternalEObject)qvtr_qvtrFunction;
			qvtr_qvtrFunction = (Function)eResolveProxy(oldQvtr_qvtrFunction);
			if (qvtr_qvtrFunction != oldQvtr_qvtrFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TI_MAP_HELPER__QVTR_QVTR_FUNCTION, oldQvtr_qvtrFunction, qvtr_qvtrFunction));
			}
		}
		return qvtr_qvtrFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetQvtr_qvtrFunction() {
		return qvtr_qvtrFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrFunction(Function newQvtr_qvtrFunction) {
		Function oldQvtr_qvtrFunction = qvtr_qvtrFunction;
		qvtr_qvtrFunction = newQvtr_qvtrFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TI_MAP_HELPER__QVTR_QVTR_FUNCTION, oldQvtr_qvtrFunction, qvtr_qvtrFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(Boolean newStatus) {
		Boolean oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TI_MAP_HELPER__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TI_MAP_HELPER__ATL_ATL_HELPER:
				if (resolve) return getAtl_atlHelper();
				return basicGetAtl_atlHelper();
			case trace_ATL2QVTrPackage.TI_MAP_HELPER__QVTR_QVTR_FUNCTION:
				if (resolve) return getQvtr_qvtrFunction();
				return basicGetQvtr_qvtrFunction();
			case trace_ATL2QVTrPackage.TI_MAP_HELPER__STATUS:
				return getStatus();
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
			case trace_ATL2QVTrPackage.TI_MAP_HELPER__ATL_ATL_HELPER:
				setAtl_atlHelper((Helper)newValue);
				return;
			case trace_ATL2QVTrPackage.TI_MAP_HELPER__QVTR_QVTR_FUNCTION:
				setQvtr_qvtrFunction((Function)newValue);
				return;
			case trace_ATL2QVTrPackage.TI_MAP_HELPER__STATUS:
				setStatus((Boolean)newValue);
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
			case trace_ATL2QVTrPackage.TI_MAP_HELPER__ATL_ATL_HELPER:
				setAtl_atlHelper((Helper)null);
				return;
			case trace_ATL2QVTrPackage.TI_MAP_HELPER__QVTR_QVTR_FUNCTION:
				setQvtr_qvtrFunction((Function)null);
				return;
			case trace_ATL2QVTrPackage.TI_MAP_HELPER__STATUS:
				setStatus(STATUS_EDEFAULT);
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
			case trace_ATL2QVTrPackage.TI_MAP_HELPER__ATL_ATL_HELPER:
				return atl_atlHelper != null;
			case trace_ATL2QVTrPackage.TI_MAP_HELPER__QVTR_QVTR_FUNCTION:
				return qvtr_qvtrFunction != null;
			case trace_ATL2QVTrPackage.TI_MAP_HELPER__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
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
		result.append(" (status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //TI_mapHelperImpl
