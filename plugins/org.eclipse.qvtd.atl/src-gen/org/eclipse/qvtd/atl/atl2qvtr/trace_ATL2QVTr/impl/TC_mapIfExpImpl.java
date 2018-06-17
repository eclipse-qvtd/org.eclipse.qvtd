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

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapIfExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map If Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapIfExpImpl#getAtl_atlCondition <em>Atl atl Condition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapIfExpImpl#getAtl_atlElse <em>Atl atl Else</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapIfExpImpl#getAtl_atlThen <em>Atl atl Then</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapIfExpImpl#getQvtr_qvtrCondition <em>Qvtr qvtr Condition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapIfExpImpl#getQvtr_qvtrElse <em>Qvtr qvtr Else</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapIfExpImpl#getQvtr_qvtrThen <em>Qvtr qvtr Then</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapIfExpImpl extends TI_mapIfExpImpl implements TC_mapIfExp {
	/**
	 * The cached value of the '{@link #getAtl_atlCondition() <em>Atl atl Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlCondition()
	 * @generated
	 * @ordered
	 */
	protected OclExpression atl_atlCondition;

	/**
	 * The cached value of the '{@link #getAtl_atlElse() <em>Atl atl Else</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlElse()
	 * @generated
	 * @ordered
	 */
	protected OclExpression atl_atlElse;

	/**
	 * The cached value of the '{@link #getAtl_atlThen() <em>Atl atl Then</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlThen()
	 * @generated
	 * @ordered
	 */
	protected OclExpression atl_atlThen;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrCondition() <em>Qvtr qvtr Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrCondition()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression qvtr_qvtrCondition;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrElse() <em>Qvtr qvtr Else</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrElse()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression qvtr_qvtrElse;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrThen() <em>Qvtr qvtr Then</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrThen()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression qvtr_qvtrThen;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapIfExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_IF_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getAtl_atlCondition() {
		if (atl_atlCondition != null && atl_atlCondition.eIsProxy()) {
			InternalEObject oldAtl_atlCondition = atl_atlCondition;
			atl_atlCondition = (OclExpression)eResolveProxy(oldAtl_atlCondition);
			if (atl_atlCondition != oldAtl_atlCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_CONDITION, oldAtl_atlCondition, atl_atlCondition));
			}
		}
		return atl_atlCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetAtl_atlCondition() {
		return atl_atlCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlCondition(OclExpression newAtl_atlCondition) {
		OclExpression oldAtl_atlCondition = atl_atlCondition;
		atl_atlCondition = newAtl_atlCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_CONDITION, oldAtl_atlCondition, atl_atlCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getAtl_atlElse() {
		if (atl_atlElse != null && atl_atlElse.eIsProxy()) {
			InternalEObject oldAtl_atlElse = atl_atlElse;
			atl_atlElse = (OclExpression)eResolveProxy(oldAtl_atlElse);
			if (atl_atlElse != oldAtl_atlElse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_ELSE, oldAtl_atlElse, atl_atlElse));
			}
		}
		return atl_atlElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetAtl_atlElse() {
		return atl_atlElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlElse(OclExpression newAtl_atlElse) {
		OclExpression oldAtl_atlElse = atl_atlElse;
		atl_atlElse = newAtl_atlElse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_ELSE, oldAtl_atlElse, atl_atlElse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getAtl_atlThen() {
		if (atl_atlThen != null && atl_atlThen.eIsProxy()) {
			InternalEObject oldAtl_atlThen = atl_atlThen;
			atl_atlThen = (OclExpression)eResolveProxy(oldAtl_atlThen);
			if (atl_atlThen != oldAtl_atlThen) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_THEN, oldAtl_atlThen, atl_atlThen));
			}
		}
		return atl_atlThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetAtl_atlThen() {
		return atl_atlThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlThen(OclExpression newAtl_atlThen) {
		OclExpression oldAtl_atlThen = atl_atlThen;
		atl_atlThen = newAtl_atlThen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_THEN, oldAtl_atlThen, atl_atlThen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getQvtr_qvtrCondition() {
		if (qvtr_qvtrCondition != null && qvtr_qvtrCondition.eIsProxy()) {
			InternalEObject oldQvtr_qvtrCondition = (InternalEObject)qvtr_qvtrCondition;
			qvtr_qvtrCondition = (OCLExpression)eResolveProxy(oldQvtr_qvtrCondition);
			if (qvtr_qvtrCondition != oldQvtr_qvtrCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_CONDITION, oldQvtr_qvtrCondition, qvtr_qvtrCondition));
			}
		}
		return qvtr_qvtrCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetQvtr_qvtrCondition() {
		return qvtr_qvtrCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrCondition(OCLExpression newQvtr_qvtrCondition) {
		OCLExpression oldQvtr_qvtrCondition = qvtr_qvtrCondition;
		qvtr_qvtrCondition = newQvtr_qvtrCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_CONDITION, oldQvtr_qvtrCondition, qvtr_qvtrCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getQvtr_qvtrElse() {
		if (qvtr_qvtrElse != null && qvtr_qvtrElse.eIsProxy()) {
			InternalEObject oldQvtr_qvtrElse = (InternalEObject)qvtr_qvtrElse;
			qvtr_qvtrElse = (OCLExpression)eResolveProxy(oldQvtr_qvtrElse);
			if (qvtr_qvtrElse != oldQvtr_qvtrElse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_ELSE, oldQvtr_qvtrElse, qvtr_qvtrElse));
			}
		}
		return qvtr_qvtrElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetQvtr_qvtrElse() {
		return qvtr_qvtrElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrElse(OCLExpression newQvtr_qvtrElse) {
		OCLExpression oldQvtr_qvtrElse = qvtr_qvtrElse;
		qvtr_qvtrElse = newQvtr_qvtrElse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_ELSE, oldQvtr_qvtrElse, qvtr_qvtrElse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getQvtr_qvtrThen() {
		if (qvtr_qvtrThen != null && qvtr_qvtrThen.eIsProxy()) {
			InternalEObject oldQvtr_qvtrThen = (InternalEObject)qvtr_qvtrThen;
			qvtr_qvtrThen = (OCLExpression)eResolveProxy(oldQvtr_qvtrThen);
			if (qvtr_qvtrThen != oldQvtr_qvtrThen) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_THEN, oldQvtr_qvtrThen, qvtr_qvtrThen));
			}
		}
		return qvtr_qvtrThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetQvtr_qvtrThen() {
		return qvtr_qvtrThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrThen(OCLExpression newQvtr_qvtrThen) {
		OCLExpression oldQvtr_qvtrThen = qvtr_qvtrThen;
		qvtr_qvtrThen = newQvtr_qvtrThen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_THEN, oldQvtr_qvtrThen, qvtr_qvtrThen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_CONDITION:
				if (resolve) return getAtl_atlCondition();
				return basicGetAtl_atlCondition();
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_ELSE:
				if (resolve) return getAtl_atlElse();
				return basicGetAtl_atlElse();
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_THEN:
				if (resolve) return getAtl_atlThen();
				return basicGetAtl_atlThen();
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_CONDITION:
				if (resolve) return getQvtr_qvtrCondition();
				return basicGetQvtr_qvtrCondition();
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_ELSE:
				if (resolve) return getQvtr_qvtrElse();
				return basicGetQvtr_qvtrElse();
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_THEN:
				if (resolve) return getQvtr_qvtrThen();
				return basicGetQvtr_qvtrThen();
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
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_CONDITION:
				setAtl_atlCondition((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_ELSE:
				setAtl_atlElse((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_THEN:
				setAtl_atlThen((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_CONDITION:
				setQvtr_qvtrCondition((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_ELSE:
				setQvtr_qvtrElse((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_THEN:
				setQvtr_qvtrThen((OCLExpression)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_CONDITION:
				setAtl_atlCondition((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_ELSE:
				setAtl_atlElse((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_THEN:
				setAtl_atlThen((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_CONDITION:
				setQvtr_qvtrCondition((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_ELSE:
				setQvtr_qvtrElse((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_THEN:
				setQvtr_qvtrThen((OCLExpression)null);
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
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_CONDITION:
				return atl_atlCondition != null;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_ELSE:
				return atl_atlElse != null;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__ATL_ATL_THEN:
				return atl_atlThen != null;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_CONDITION:
				return qvtr_qvtrCondition != null;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_ELSE:
				return qvtr_qvtrElse != null;
			case trace_ATL2QVTrPackage.TC_MAP_IF_EXP__QVTR_QVTR_THEN:
				return qvtr_qvtrThen != null;
		}
		return super.eIsSet(featureID);
	}

} //TC_mapIfExpImpl
