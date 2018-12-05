/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Operation Call Exp Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_OperationImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_OperationImpl#getT0operationName <em>T0operation Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_OperationImpl#getT1atlSource <em>T1atl Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_OperationImpl#getT2qvtrSource <em>T2qvtr Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_OperationImpl#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapOperationCallExp_OperationImpl extends ImapOclExpressionImpl implements TmapOperationCallExp_Operation {
	/**
	 * The default value of the '{@link #getT0operationName() <em>T0operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0operationName()
	 * @generated
	 * @ordered
	 */
	protected static final String T0OPERATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT0operationName() <em>T0operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0operationName()
	 * @generated
	 * @ordered
	 */
	protected String t0operationName = T0OPERATION_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT1atlSource() <em>T1atl Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlSource()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t1atlSource;

	/**
	 * The cached value of the '{@link #getT2qvtrSource() <em>T2qvtr Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrSource()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t2qvtrSource;

	/**
	 * The cached value of the '{@link #getWmapOclExpression() <em>Wmap Ocl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapOclExpression()
	 * @generated
	 * @ordered
	 */
	protected DmapOclExpression wmapOclExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapOperationCallExp_OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapOclExpression getDispatcher() {
		if (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER) return null;
		return (DmapOclExpression)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapOclExpression newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDispatcher(DmapOclExpression newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION, DmapOclExpression.class, msgs);
			msgs = basicSetDispatcher(newDispatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER, newDispatcher, newDispatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getT0operationName() {
		return t0operationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT0operationName(String newT0operationName) {
		String oldT0operationName = t0operationName;
		t0operationName = newT0operationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T0OPERATION_NAME, oldT0operationName, t0operationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT1atlSource() {
		if (t1atlSource != null && t1atlSource.eIsProxy()) {
			InternalEObject oldT1atlSource = (InternalEObject)t1atlSource;
			t1atlSource = (OclExpression)eResolveProxy(oldT1atlSource);
			if (t1atlSource != oldT1atlSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T1ATL_SOURCE, oldT1atlSource, t1atlSource));
			}
		}
		return t1atlSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT1atlSource() {
		return t1atlSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlSource(OclExpression newT1atlSource) {
		OclExpression oldT1atlSource = t1atlSource;
		t1atlSource = newT1atlSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T1ATL_SOURCE, oldT1atlSource, t1atlSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT2qvtrSource() {
		if (t2qvtrSource != null && t2qvtrSource.eIsProxy()) {
			InternalEObject oldT2qvtrSource = (InternalEObject)t2qvtrSource;
			t2qvtrSource = (OCLExpression)eResolveProxy(oldT2qvtrSource);
			if (t2qvtrSource != oldT2qvtrSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T2QVTR_SOURCE, oldT2qvtrSource, t2qvtrSource));
			}
		}
		return t2qvtrSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT2qvtrSource() {
		return t2qvtrSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrSource(OCLExpression newT2qvtrSource) {
		OCLExpression oldT2qvtrSource = t2qvtrSource;
		t2qvtrSource = newT2qvtrSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T2QVTR_SOURCE, oldT2qvtrSource, t2qvtrSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapOclExpression getWmapOclExpression() {
		if (wmapOclExpression != null && wmapOclExpression.eIsProxy()) {
			InternalEObject oldWmapOclExpression = (InternalEObject)wmapOclExpression;
			wmapOclExpression = (DmapOclExpression)eResolveProxy(oldWmapOclExpression);
			if (wmapOclExpression != oldWmapOclExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__WMAP_OCL_EXPRESSION, oldWmapOclExpression, wmapOclExpression));
			}
		}
		return wmapOclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapOclExpression basicGetWmapOclExpression() {
		return wmapOclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapOclExpression(DmapOclExpression newWmapOclExpression) {
		DmapOclExpression oldWmapOclExpression = wmapOclExpression;
		wmapOclExpression = newWmapOclExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__WMAP_OCL_EXPRESSION, oldWmapOclExpression, wmapOclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDispatcher((DmapOclExpression)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER:
				return basicSetDispatcher(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER:
				return eInternalContainer().eInverseRemove(this, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_OPERATION, DmapOclExpression.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER:
				return getDispatcher();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T0OPERATION_NAME:
				return getT0operationName();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T1ATL_SOURCE:
				if (resolve) return getT1atlSource();
				return basicGetT1atlSource();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T2QVTR_SOURCE:
				if (resolve) return getT2qvtrSource();
				return basicGetT2qvtrSource();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__WMAP_OCL_EXPRESSION:
				if (resolve) return getWmapOclExpression();
				return basicGetWmapOclExpression();
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
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER:
				setDispatcher((DmapOclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T0OPERATION_NAME:
				setT0operationName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T1ATL_SOURCE:
				setT1atlSource((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T2QVTR_SOURCE:
				setT2qvtrSource((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__WMAP_OCL_EXPRESSION:
				setWmapOclExpression((DmapOclExpression)newValue);
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
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER:
				setDispatcher((DmapOclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T0OPERATION_NAME:
				setT0operationName(T0OPERATION_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T1ATL_SOURCE:
				setT1atlSource((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T2QVTR_SOURCE:
				setT2qvtrSource((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__WMAP_OCL_EXPRESSION:
				setWmapOclExpression((DmapOclExpression)null);
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
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__DISPATCHER:
				return getDispatcher() != null;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T0OPERATION_NAME:
				return T0OPERATION_NAME_EDEFAULT == null ? t0operationName != null : !T0OPERATION_NAME_EDEFAULT.equals(t0operationName);
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T1ATL_SOURCE:
				return t1atlSource != null;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__T2QVTR_SOURCE:
				return t2qvtrSource != null;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_OPERATION__WMAP_OCL_EXPRESSION:
				return wmapOclExpression != null;
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
		result.append(" (t0operationName: ");
		result.append(t0operationName);
		result.append(')');
		return result.toString();
	}

} //TmapOperationCallExp_OperationImpl
