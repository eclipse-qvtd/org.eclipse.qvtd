/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
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
import org.eclipse.m2m.atl.common.OCL.OperationCallExp;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Operation Call Exp argument</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl#getT1atlArgument <em>T1atl Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl#getT1atlParent <em>T1atl Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl#getT2qvtrArgument <em>T2qvtr Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl#getT2qvtrParent <em>T2qvtr Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl#getWmapOclExpression1 <em>Wmap Ocl Expression1</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapOperationCallExp_argumentImpl extends ExecutionImpl implements TmapOperationCallExp_argument {
	/**
	 * The number of structural features of the '<em>Tmap Operation Call Exp argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_OPERATION_CALL_EXP_ARGUMENT_FEATURE_COUNT = ExecutionImpl.EXECUTION_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Tmap Operation Call Exp argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_OPERATION_CALL_EXP_ARGUMENT_OPERATION_COUNT = ExecutionImpl.EXECUTION_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getT1atlArgument() <em>T1atl Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlArgument()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t1atlArgument;

	/**
	 * The cached value of the '{@link #getT1atlParent() <em>T1atl Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlParent()
	 * @generated
	 * @ordered
	 */
	protected OperationCallExp t1atlParent;

	/**
	 * The cached value of the '{@link #getT2qvtrArgument() <em>T2qvtr Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrArgument()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t2qvtrArgument;

	/**
	 * The cached value of the '{@link #getT2qvtrParent() <em>T2qvtr Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrParent()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.OperationCallExp t2qvtrParent;

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
	 * The cached value of the '{@link #getWmapOclExpression1() <em>Wmap Ocl Expression1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapOclExpression1()
	 * @generated
	 * @ordered
	 */
	protected DmapOclExpression wmapOclExpression1;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapOperationCallExp_argumentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_ARGUMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT1atlArgument() {
		if (t1atlArgument != null && t1atlArgument.eIsProxy()) {
			InternalEObject oldT1atlArgument = t1atlArgument;
			t1atlArgument = (OclExpression)eResolveProxy(oldT1atlArgument);
			if (t1atlArgument != oldT1atlArgument) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0, oldT1atlArgument, t1atlArgument));
			}
		}
		return t1atlArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT1atlArgument() {
		return t1atlArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlArgument(OclExpression newT1atlArgument) {
		OclExpression oldT1atlArgument = t1atlArgument;
		t1atlArgument = newT1atlArgument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0, oldT1atlArgument, t1atlArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationCallExp getT1atlParent() {
		if (t1atlParent != null && t1atlParent.eIsProxy()) {
			InternalEObject oldT1atlParent = t1atlParent;
			t1atlParent = (OperationCallExp)eResolveProxy(oldT1atlParent);
			if (t1atlParent != oldT1atlParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT1atlParent, t1atlParent));
			}
		}
		return t1atlParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExp basicGetT1atlParent() {
		return t1atlParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlParent(OperationCallExp newT1atlParent) {
		OperationCallExp oldT1atlParent = t1atlParent;
		t1atlParent = newT1atlParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT1atlParent, t1atlParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT2qvtrArgument() {
		if (t2qvtrArgument != null && t2qvtrArgument.eIsProxy()) {
			InternalEObject oldT2qvtrArgument = (InternalEObject)t2qvtrArgument;
			t2qvtrArgument = (OCLExpression)eResolveProxy(oldT2qvtrArgument);
			if (t2qvtrArgument != oldT2qvtrArgument) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT2qvtrArgument, t2qvtrArgument));
			}
		}
		return t2qvtrArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT2qvtrArgument() {
		return t2qvtrArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrArgument(OCLExpression newT2qvtrArgument) {
		OCLExpression oldT2qvtrArgument = t2qvtrArgument;
		t2qvtrArgument = newT2qvtrArgument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT2qvtrArgument, t2qvtrArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.OperationCallExp getT2qvtrParent() {
		if (t2qvtrParent != null && t2qvtrParent.eIsProxy()) {
			InternalEObject oldT2qvtrParent = (InternalEObject)t2qvtrParent;
			t2qvtrParent = (org.eclipse.ocl.pivot.OperationCallExp)eResolveProxy(oldT2qvtrParent);
			if (t2qvtrParent != oldT2qvtrParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT2qvtrParent, t2qvtrParent));
			}
		}
		return t2qvtrParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.OperationCallExp basicGetT2qvtrParent() {
		return t2qvtrParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrParent(org.eclipse.ocl.pivot.OperationCallExp newT2qvtrParent) {
		org.eclipse.ocl.pivot.OperationCallExp oldT2qvtrParent = t2qvtrParent;
		t2qvtrParent = newT2qvtrParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT2qvtrParent, t2qvtrParent));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldWmapOclExpression, wmapOclExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldWmapOclExpression, wmapOclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapOclExpression getWmapOclExpression1() {
		if (wmapOclExpression1 != null && wmapOclExpression1.eIsProxy()) {
			InternalEObject oldWmapOclExpression1 = (InternalEObject)wmapOclExpression1;
			wmapOclExpression1 = (DmapOclExpression)eResolveProxy(oldWmapOclExpression1);
			if (wmapOclExpression1 != oldWmapOclExpression1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldWmapOclExpression1, wmapOclExpression1));
			}
		}
		return wmapOclExpression1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapOclExpression basicGetWmapOclExpression1() {
		return wmapOclExpression1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapOclExpression1(DmapOclExpression newWmapOclExpression1) {
		DmapOclExpression oldWmapOclExpression1 = wmapOclExpression1;
		wmapOclExpression1 = newWmapOclExpression1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldWmapOclExpression1, wmapOclExpression1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				if (resolve) return getT1atlArgument();
				return basicGetT1atlArgument();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				if (resolve) return getT1atlParent();
				return basicGetT1atlParent();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				if (resolve) return getT2qvtrArgument();
				return basicGetT2qvtrArgument();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT2qvtrParent();
				return basicGetT2qvtrParent();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getWmapOclExpression();
				return basicGetWmapOclExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getWmapOclExpression1();
				return basicGetWmapOclExpression1();
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setT1atlArgument((OclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1atlParent((OperationCallExp)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT2qvtrArgument((OCLExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT2qvtrParent((org.eclipse.ocl.pivot.OperationCallExp)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setWmapOclExpression((DmapOclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setWmapOclExpression1((DmapOclExpression)newValue);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setT1atlArgument((OclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1atlParent((OperationCallExp)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT2qvtrArgument((OCLExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT2qvtrParent((org.eclipse.ocl.pivot.OperationCallExp)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setWmapOclExpression((DmapOclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setWmapOclExpression1((DmapOclExpression)null);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				return t1atlArgument != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return t1atlParent != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t2qvtrArgument != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t2qvtrParent != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return wmapOclExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return wmapOclExpression1 != null;
		}
		return super.eIsSet(featureID);
	}


} //TmapOperationCallExp_argumentImpl
