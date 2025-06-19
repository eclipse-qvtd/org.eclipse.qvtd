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
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl#getS0global <em>S0global</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl#getT3atlArgument <em>T3atl Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl#getT3atlParent <em>T3atl Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl#getT4qvtrArgument <em>T4qvtr Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_argumentImpl#getT4qvtrParent <em>T4qvtr Parent</em>}</li>
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
	public static final int TMAP_OPERATION_CALL_EXP_ARGUMENT_FEATURE_COUNT = ExecutionImpl.EXECUTION_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Tmap Operation Call Exp argument</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_OPERATION_CALL_EXP_ARGUMENT_OPERATION_COUNT = ExecutionImpl.EXECUTION_OPERATION_COUNT + 0;


	/**
	 * The default value of the '{@link #getS0global() <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0global()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean S0GLOBAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getS0global() <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0global()
	 * @generated
	 * @ordered
	 */
	protected Boolean s0global = S0GLOBAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT3atlArgument() <em>T3atl Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlArgument()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t3atlArgument;

	/**
	 * The cached value of the '{@link #getT3atlParent() <em>T3atl Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlParent()
	 * @generated
	 * @ordered
	 */
	protected OperationCallExp t3atlParent;

	/**
	 * The cached value of the '{@link #getT4qvtrArgument() <em>T4qvtr Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrArgument()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t4qvtrArgument;

	/**
	 * The cached value of the '{@link #getT4qvtrParent() <em>T4qvtr Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrParent()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.OperationCallExp t4qvtrParent;

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
	public Boolean getS0global() {
		return s0global;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setS0global(Boolean newS0global) {
		Boolean oldS0global = s0global;
		s0global = newS0global;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0, oldS0global, s0global));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT3atlArgument() {
		if (t3atlArgument != null && t3atlArgument.eIsProxy()) {
			InternalEObject oldT3atlArgument = t3atlArgument;
			t3atlArgument = (OclExpression)eResolveProxy(oldT3atlArgument);
			if (t3atlArgument != oldT3atlArgument) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT3atlArgument, t3atlArgument));
			}
		}
		return t3atlArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT3atlArgument() {
		return t3atlArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlArgument(OclExpression newT3atlArgument) {
		OclExpression oldT3atlArgument = t3atlArgument;
		t3atlArgument = newT3atlArgument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT3atlArgument, t3atlArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationCallExp getT3atlParent() {
		if (t3atlParent != null && t3atlParent.eIsProxy()) {
			InternalEObject oldT3atlParent = t3atlParent;
			t3atlParent = (OperationCallExp)eResolveProxy(oldT3atlParent);
			if (t3atlParent != oldT3atlParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlParent, t3atlParent));
			}
		}
		return t3atlParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExp basicGetT3atlParent() {
		return t3atlParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlParent(OperationCallExp newT3atlParent) {
		OperationCallExp oldT3atlParent = t3atlParent;
		t3atlParent = newT3atlParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlParent, t3atlParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT4qvtrArgument() {
		if (t4qvtrArgument != null && t4qvtrArgument.eIsProxy()) {
			InternalEObject oldT4qvtrArgument = (InternalEObject)t4qvtrArgument;
			t4qvtrArgument = (OCLExpression)eResolveProxy(oldT4qvtrArgument);
			if (t4qvtrArgument != oldT4qvtrArgument) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT4qvtrArgument, t4qvtrArgument));
			}
		}
		return t4qvtrArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT4qvtrArgument() {
		return t4qvtrArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrArgument(OCLExpression newT4qvtrArgument) {
		OCLExpression oldT4qvtrArgument = t4qvtrArgument;
		t4qvtrArgument = newT4qvtrArgument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT4qvtrArgument, t4qvtrArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.OperationCallExp getT4qvtrParent() {
		if (t4qvtrParent != null && t4qvtrParent.eIsProxy()) {
			InternalEObject oldT4qvtrParent = (InternalEObject)t4qvtrParent;
			t4qvtrParent = (org.eclipse.ocl.pivot.OperationCallExp)eResolveProxy(oldT4qvtrParent);
			if (t4qvtrParent != oldT4qvtrParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT4qvtrParent, t4qvtrParent));
			}
		}
		return t4qvtrParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.OperationCallExp basicGetT4qvtrParent() {
		return t4qvtrParent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrParent(org.eclipse.ocl.pivot.OperationCallExp newT4qvtrParent) {
		org.eclipse.ocl.pivot.OperationCallExp oldT4qvtrParent = t4qvtrParent;
		t4qvtrParent = newT4qvtrParent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT4qvtrParent, t4qvtrParent));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldWmapOclExpression, wmapOclExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldWmapOclExpression, wmapOclExpression));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldWmapOclExpression1, wmapOclExpression1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldWmapOclExpression1, wmapOclExpression1));
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
				return getS0global();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				if (resolve) return getT3atlArgument();
				return basicGetT3atlArgument();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				if (resolve) return getT3atlParent();
				return basicGetT3atlParent();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT4qvtrArgument();
				return basicGetT4qvtrArgument();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT4qvtrParent();
				return basicGetT4qvtrParent();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getWmapOclExpression();
				return basicGetWmapOclExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
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
				setS0global((Boolean)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT3atlArgument((OclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlParent((OperationCallExp)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT4qvtrArgument((OCLExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT4qvtrParent((org.eclipse.ocl.pivot.OperationCallExp)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setWmapOclExpression((DmapOclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
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
				setS0global(S0GLOBAL_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT3atlArgument((OclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlParent((OperationCallExp)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT4qvtrArgument((OCLExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT4qvtrParent((org.eclipse.ocl.pivot.OperationCallExp)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setWmapOclExpression((DmapOclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
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
				return S0GLOBAL_EDEFAULT == null ? s0global != null : !S0GLOBAL_EDEFAULT.equals(s0global);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return t3atlArgument != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t3atlParent != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t4qvtrArgument != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t4qvtrParent != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return wmapOclExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				return wmapOclExpression1 != null;
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
		result.append(" (s0global: ");
		result.append(s0global);
		result.append(')');
		return result.toString();
	}


} //TmapOperationCallExp_argumentImpl
