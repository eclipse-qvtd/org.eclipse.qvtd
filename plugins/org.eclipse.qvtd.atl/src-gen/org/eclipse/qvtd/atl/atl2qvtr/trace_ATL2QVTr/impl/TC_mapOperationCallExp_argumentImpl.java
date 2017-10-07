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
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.OCL.OclExpression;
import org.eclipse.m2m.atl.common.OCL.OperationCallExp;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOperationCallExp_argument;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Operation Call Exp argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperationCallExp_argumentImpl#getAtl_atlArgument <em>Atl atl Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperationCallExp_argumentImpl#getAtl_atlParent <em>Atl atl Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperationCallExp_argumentImpl#getQvtr_qvtrArgument <em>Qvtr qvtr Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOperationCallExp_argumentImpl#getQvtr_qvtrParent <em>Qvtr qvtr Parent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapOperationCallExp_argumentImpl extends MinimalEObjectImpl.Container implements TC_mapOperationCallExp_argument {
	/**
	 * The cached value of the '{@link #getAtl_atlArgument() <em>Atl atl Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlArgument()
	 * @generated
	 * @ordered
	 */
	protected OclExpression atl_atlArgument;

	/**
	 * The cached value of the '{@link #getAtl_atlParent() <em>Atl atl Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlParent()
	 * @generated
	 * @ordered
	 */
	protected OperationCallExp atl_atlParent;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrArgument() <em>Qvtr qvtr Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrArgument()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression qvtr_qvtrArgument;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrParent() <em>Qvtr qvtr Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrParent()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.OperationCallExp qvtr_qvtrParent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapOperationCallExp_argumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_OPERATION_CALL_EXP_ARGUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getAtl_atlArgument() {
		if (atl_atlArgument != null && atl_atlArgument.eIsProxy()) {
			InternalEObject oldAtl_atlArgument = atl_atlArgument;
			atl_atlArgument = (OclExpression)eResolveProxy(oldAtl_atlArgument);
			if (atl_atlArgument != oldAtl_atlArgument) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_ARGUMENT, oldAtl_atlArgument, atl_atlArgument));
			}
		}
		return atl_atlArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetAtl_atlArgument() {
		return atl_atlArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlArgument(OclExpression newAtl_atlArgument) {
		OclExpression oldAtl_atlArgument = atl_atlArgument;
		atl_atlArgument = newAtl_atlArgument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_ARGUMENT, oldAtl_atlArgument, atl_atlArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationCallExp getAtl_atlParent() {
		if (atl_atlParent != null && atl_atlParent.eIsProxy()) {
			InternalEObject oldAtl_atlParent = atl_atlParent;
			atl_atlParent = (OperationCallExp)eResolveProxy(oldAtl_atlParent);
			if (atl_atlParent != oldAtl_atlParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_PARENT, oldAtl_atlParent, atl_atlParent));
			}
		}
		return atl_atlParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExp basicGetAtl_atlParent() {
		return atl_atlParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlParent(OperationCallExp newAtl_atlParent) {
		OperationCallExp oldAtl_atlParent = atl_atlParent;
		atl_atlParent = newAtl_atlParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_PARENT, oldAtl_atlParent, atl_atlParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getQvtr_qvtrArgument() {
		if (qvtr_qvtrArgument != null && qvtr_qvtrArgument.eIsProxy()) {
			InternalEObject oldQvtr_qvtrArgument = (InternalEObject)qvtr_qvtrArgument;
			qvtr_qvtrArgument = (OCLExpression)eResolveProxy(oldQvtr_qvtrArgument);
			if (qvtr_qvtrArgument != oldQvtr_qvtrArgument) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_ARGUMENT, oldQvtr_qvtrArgument, qvtr_qvtrArgument));
			}
		}
		return qvtr_qvtrArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetQvtr_qvtrArgument() {
		return qvtr_qvtrArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrArgument(OCLExpression newQvtr_qvtrArgument) {
		OCLExpression oldQvtr_qvtrArgument = qvtr_qvtrArgument;
		qvtr_qvtrArgument = newQvtr_qvtrArgument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_ARGUMENT, oldQvtr_qvtrArgument, qvtr_qvtrArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.OperationCallExp getQvtr_qvtrParent() {
		if (qvtr_qvtrParent != null && qvtr_qvtrParent.eIsProxy()) {
			InternalEObject oldQvtr_qvtrParent = (InternalEObject)qvtr_qvtrParent;
			qvtr_qvtrParent = (org.eclipse.ocl.pivot.OperationCallExp)eResolveProxy(oldQvtr_qvtrParent);
			if (qvtr_qvtrParent != oldQvtr_qvtrParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_PARENT, oldQvtr_qvtrParent, qvtr_qvtrParent));
			}
		}
		return qvtr_qvtrParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.OperationCallExp basicGetQvtr_qvtrParent() {
		return qvtr_qvtrParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrParent(org.eclipse.ocl.pivot.OperationCallExp newQvtr_qvtrParent) {
		org.eclipse.ocl.pivot.OperationCallExp oldQvtr_qvtrParent = qvtr_qvtrParent;
		qvtr_qvtrParent = newQvtr_qvtrParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_PARENT, oldQvtr_qvtrParent, qvtr_qvtrParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_ARGUMENT:
				if (resolve) return getAtl_atlArgument();
				return basicGetAtl_atlArgument();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_PARENT:
				if (resolve) return getAtl_atlParent();
				return basicGetAtl_atlParent();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_ARGUMENT:
				if (resolve) return getQvtr_qvtrArgument();
				return basicGetQvtr_qvtrArgument();
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_PARENT:
				if (resolve) return getQvtr_qvtrParent();
				return basicGetQvtr_qvtrParent();
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
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_ARGUMENT:
				setAtl_atlArgument((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_PARENT:
				setAtl_atlParent((OperationCallExp)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_ARGUMENT:
				setQvtr_qvtrArgument((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_PARENT:
				setQvtr_qvtrParent((org.eclipse.ocl.pivot.OperationCallExp)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_ARGUMENT:
				setAtl_atlArgument((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_PARENT:
				setAtl_atlParent((OperationCallExp)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_ARGUMENT:
				setQvtr_qvtrArgument((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_PARENT:
				setQvtr_qvtrParent((org.eclipse.ocl.pivot.OperationCallExp)null);
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
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_ARGUMENT:
				return atl_atlArgument != null;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__ATL_ATL_PARENT:
				return atl_atlParent != null;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_ARGUMENT:
				return qvtr_qvtrArgument != null;
			case trace_ATL2QVTrPackage.TC_MAP_OPERATION_CALL_EXP_ARGUMENT__QVTR_QVTR_PARENT:
				return qvtr_qvtrParent != null;
		}
		return super.eIsSet(featureID);
	}

} //TC_mapOperationCallExp_argumentImpl
