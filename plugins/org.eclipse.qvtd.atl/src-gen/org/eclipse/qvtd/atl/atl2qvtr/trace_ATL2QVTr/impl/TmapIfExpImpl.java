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
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapIfExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap If Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getT1atlCondition <em>T1atl Condition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getT1atlElse <em>T1atl Else</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getT1atlThen <em>T1atl Then</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getT2qvtrCondition <em>T2qvtr Condition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getT2qvtrElse <em>T2qvtr Else</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getT2qvtrThen <em>T2qvtr Then</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getWmapOclExpression1 <em>Wmap Ocl Expression1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getWmapOclExpression2 <em>Wmap Ocl Expression2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapIfExpImpl extends ImapOclExpressionImpl implements TmapIfExp {
	/**
	 * The cached value of the '{@link #getT1atlCondition() <em>T1atl Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlCondition()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t1atlCondition;

	/**
	 * The cached value of the '{@link #getT1atlElse() <em>T1atl Else</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlElse()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t1atlElse;

	/**
	 * The cached value of the '{@link #getT1atlThen() <em>T1atl Then</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlThen()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t1atlThen;

	/**
	 * The cached value of the '{@link #getT2qvtrCondition() <em>T2qvtr Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrCondition()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t2qvtrCondition;

	/**
	 * The cached value of the '{@link #getT2qvtrElse() <em>T2qvtr Else</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrElse()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t2qvtrElse;

	/**
	 * The cached value of the '{@link #getT2qvtrThen() <em>T2qvtr Then</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrThen()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t2qvtrThen;

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
	 * The cached value of the '{@link #getWmapOclExpression2() <em>Wmap Ocl Expression2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapOclExpression2()
	 * @generated
	 * @ordered
	 */
	protected DmapOclExpression wmapOclExpression2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapIfExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_IF_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapOclExpression getDispatcher() {
		if (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_IF_EXP__DISPATCHER) return null;
		return (DmapOclExpression)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapOclExpression newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, trace_ATL2QVTrPackage.TMAP_IF_EXP__DISPATCHER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDispatcher(DmapOclExpression newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_IF_EXP__DISPATCHER && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_IF_EXP, DmapOclExpression.class, msgs);
			msgs = basicSetDispatcher(newDispatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_IF_EXP__DISPATCHER, newDispatcher, newDispatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT1atlCondition() {
		if (t1atlCondition != null && t1atlCondition.eIsProxy()) {
			InternalEObject oldT1atlCondition = (InternalEObject)t1atlCondition;
			t1atlCondition = (OclExpression)eResolveProxy(oldT1atlCondition);
			if (t1atlCondition != oldT1atlCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_CONDITION, oldT1atlCondition, t1atlCondition));
			}
		}
		return t1atlCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT1atlCondition() {
		return t1atlCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlCondition(OclExpression newT1atlCondition) {
		OclExpression oldT1atlCondition = t1atlCondition;
		t1atlCondition = newT1atlCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_CONDITION, oldT1atlCondition, t1atlCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT1atlElse() {
		if (t1atlElse != null && t1atlElse.eIsProxy()) {
			InternalEObject oldT1atlElse = (InternalEObject)t1atlElse;
			t1atlElse = (OclExpression)eResolveProxy(oldT1atlElse);
			if (t1atlElse != oldT1atlElse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_ELSE, oldT1atlElse, t1atlElse));
			}
		}
		return t1atlElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT1atlElse() {
		return t1atlElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlElse(OclExpression newT1atlElse) {
		OclExpression oldT1atlElse = t1atlElse;
		t1atlElse = newT1atlElse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_ELSE, oldT1atlElse, t1atlElse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT1atlThen() {
		if (t1atlThen != null && t1atlThen.eIsProxy()) {
			InternalEObject oldT1atlThen = (InternalEObject)t1atlThen;
			t1atlThen = (OclExpression)eResolveProxy(oldT1atlThen);
			if (t1atlThen != oldT1atlThen) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_THEN, oldT1atlThen, t1atlThen));
			}
		}
		return t1atlThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT1atlThen() {
		return t1atlThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlThen(OclExpression newT1atlThen) {
		OclExpression oldT1atlThen = t1atlThen;
		t1atlThen = newT1atlThen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_THEN, oldT1atlThen, t1atlThen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT2qvtrCondition() {
		if (t2qvtrCondition != null && t2qvtrCondition.eIsProxy()) {
			InternalEObject oldT2qvtrCondition = (InternalEObject)t2qvtrCondition;
			t2qvtrCondition = (OCLExpression)eResolveProxy(oldT2qvtrCondition);
			if (t2qvtrCondition != oldT2qvtrCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_CONDITION, oldT2qvtrCondition, t2qvtrCondition));
			}
		}
		return t2qvtrCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT2qvtrCondition() {
		return t2qvtrCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrCondition(OCLExpression newT2qvtrCondition) {
		OCLExpression oldT2qvtrCondition = t2qvtrCondition;
		t2qvtrCondition = newT2qvtrCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_CONDITION, oldT2qvtrCondition, t2qvtrCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT2qvtrElse() {
		if (t2qvtrElse != null && t2qvtrElse.eIsProxy()) {
			InternalEObject oldT2qvtrElse = (InternalEObject)t2qvtrElse;
			t2qvtrElse = (OCLExpression)eResolveProxy(oldT2qvtrElse);
			if (t2qvtrElse != oldT2qvtrElse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_ELSE, oldT2qvtrElse, t2qvtrElse));
			}
		}
		return t2qvtrElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT2qvtrElse() {
		return t2qvtrElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrElse(OCLExpression newT2qvtrElse) {
		OCLExpression oldT2qvtrElse = t2qvtrElse;
		t2qvtrElse = newT2qvtrElse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_ELSE, oldT2qvtrElse, t2qvtrElse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT2qvtrThen() {
		if (t2qvtrThen != null && t2qvtrThen.eIsProxy()) {
			InternalEObject oldT2qvtrThen = (InternalEObject)t2qvtrThen;
			t2qvtrThen = (OCLExpression)eResolveProxy(oldT2qvtrThen);
			if (t2qvtrThen != oldT2qvtrThen) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_THEN, oldT2qvtrThen, t2qvtrThen));
			}
		}
		return t2qvtrThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT2qvtrThen() {
		return t2qvtrThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrThen(OCLExpression newT2qvtrThen) {
		OCLExpression oldT2qvtrThen = t2qvtrThen;
		t2qvtrThen = newT2qvtrThen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_THEN, oldT2qvtrThen, t2qvtrThen));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION, oldWmapOclExpression, wmapOclExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION, oldWmapOclExpression, wmapOclExpression));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION1, oldWmapOclExpression1, wmapOclExpression1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION1, oldWmapOclExpression1, wmapOclExpression1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapOclExpression getWmapOclExpression2() {
		if (wmapOclExpression2 != null && wmapOclExpression2.eIsProxy()) {
			InternalEObject oldWmapOclExpression2 = (InternalEObject)wmapOclExpression2;
			wmapOclExpression2 = (DmapOclExpression)eResolveProxy(oldWmapOclExpression2);
			if (wmapOclExpression2 != oldWmapOclExpression2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION2, oldWmapOclExpression2, wmapOclExpression2));
			}
		}
		return wmapOclExpression2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapOclExpression basicGetWmapOclExpression2() {
		return wmapOclExpression2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapOclExpression2(DmapOclExpression newWmapOclExpression2) {
		DmapOclExpression oldWmapOclExpression2 = wmapOclExpression2;
		wmapOclExpression2 = newWmapOclExpression2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION2, oldWmapOclExpression2, wmapOclExpression2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__DISPATCHER:
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
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__DISPATCHER:
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
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__DISPATCHER:
				return eInternalContainer().eInverseRemove(this, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_IF_EXP, DmapOclExpression.class, msgs);
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
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__DISPATCHER:
				return getDispatcher();
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_CONDITION:
				if (resolve) return getT1atlCondition();
				return basicGetT1atlCondition();
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_ELSE:
				if (resolve) return getT1atlElse();
				return basicGetT1atlElse();
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_THEN:
				if (resolve) return getT1atlThen();
				return basicGetT1atlThen();
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_CONDITION:
				if (resolve) return getT2qvtrCondition();
				return basicGetT2qvtrCondition();
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_ELSE:
				if (resolve) return getT2qvtrElse();
				return basicGetT2qvtrElse();
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_THEN:
				if (resolve) return getT2qvtrThen();
				return basicGetT2qvtrThen();
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION:
				if (resolve) return getWmapOclExpression();
				return basicGetWmapOclExpression();
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION1:
				if (resolve) return getWmapOclExpression1();
				return basicGetWmapOclExpression1();
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION2:
				if (resolve) return getWmapOclExpression2();
				return basicGetWmapOclExpression2();
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
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__DISPATCHER:
				setDispatcher((DmapOclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_CONDITION:
				setT1atlCondition((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_ELSE:
				setT1atlElse((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_THEN:
				setT1atlThen((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_CONDITION:
				setT2qvtrCondition((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_ELSE:
				setT2qvtrElse((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_THEN:
				setT2qvtrThen((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION:
				setWmapOclExpression((DmapOclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION1:
				setWmapOclExpression1((DmapOclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION2:
				setWmapOclExpression2((DmapOclExpression)newValue);
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
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__DISPATCHER:
				setDispatcher((DmapOclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_CONDITION:
				setT1atlCondition((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_ELSE:
				setT1atlElse((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_THEN:
				setT1atlThen((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_CONDITION:
				setT2qvtrCondition((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_ELSE:
				setT2qvtrElse((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_THEN:
				setT2qvtrThen((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION:
				setWmapOclExpression((DmapOclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION1:
				setWmapOclExpression1((DmapOclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION2:
				setWmapOclExpression2((DmapOclExpression)null);
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
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__DISPATCHER:
				return getDispatcher() != null;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_CONDITION:
				return t1atlCondition != null;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_ELSE:
				return t1atlElse != null;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T1ATL_THEN:
				return t1atlThen != null;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_CONDITION:
				return t2qvtrCondition != null;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_ELSE:
				return t2qvtrElse != null;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__T2QVTR_THEN:
				return t2qvtrThen != null;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION:
				return wmapOclExpression != null;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION1:
				return wmapOclExpression1 != null;
			case trace_ATL2QVTrPackage.TMAP_IF_EXP__WMAP_OCL_EXPRESSION2:
				return wmapOclExpression2 != null;
		}
		return super.eIsSet(featureID);
	}

} //TmapIfExpImpl
