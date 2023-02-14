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

import org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl;
import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap If Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getT3atlCondition <em>T3atl Condition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getT3atlElse <em>T3atl Else</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getT3atlThen <em>T3atl Then</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getT4qvtrCondition <em>T4qvtr Condition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getT4qvtrElse <em>T4qvtr Else</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getT4qvtrThen <em>T4qvtr Then</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getWmapOclExpression1 <em>Wmap Ocl Expression1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getWmapOclExpression2 <em>Wmap Ocl Expression2</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapIfExpImpl#getS0local <em>S0local</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapIfExpImpl extends ImapOclExpressionImpl implements TmapIfExp {
	/**
	 * The number of structural features of the '<em>Tmap If Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_IF_EXP_FEATURE_COUNT = ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 11;

	/**
	 * The number of operations of the '<em>Tmap If Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_IF_EXP_OPERATION_COUNT = ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getT3atlCondition() <em>T3atl Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlCondition()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t3atlCondition;

	/**
	 * The cached value of the '{@link #getT3atlElse() <em>T3atl Else</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlElse()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t3atlElse;

	/**
	 * The cached value of the '{@link #getT3atlThen() <em>T3atl Then</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlThen()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t3atlThen;

	/**
	 * The cached value of the '{@link #getT4qvtrCondition() <em>T4qvtr Condition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrCondition()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t4qvtrCondition;

	/**
	 * The cached value of the '{@link #getT4qvtrElse() <em>T4qvtr Else</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrElse()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t4qvtrElse;

	/**
	 * The cached value of the '{@link #getT4qvtrThen() <em>T4qvtr Then</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrThen()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t4qvtrThen;

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
	 * The default value of the '{@link #getS0local() <em>S0local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0local()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean S0LOCAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getS0local() <em>S0local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0local()
	 * @generated
	 * @ordered
	 */
	protected Boolean s0local = S0LOCAL_EDEFAULT;

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
		if (eContainerFeatureID() != (ExecutionImpl.EXECUTION_FEATURE_COUNT + 1)) return null;
		return (DmapOclExpression)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapOclExpression newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDispatcher(DmapOclExpression newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != (ExecutionImpl.EXECUTION_FEATURE_COUNT + 1) && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 3, DmapOclExpression.class, msgs);
			msgs = basicSetDispatcher(newDispatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, newDispatcher, newDispatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT3atlCondition() {
		if (t3atlCondition != null && t3atlCondition.eIsProxy()) {
			InternalEObject oldT3atlCondition = t3atlCondition;
			t3atlCondition = (OclExpression)eResolveProxy(oldT3atlCondition);
			if (t3atlCondition != oldT3atlCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlCondition, t3atlCondition));
			}
		}
		return t3atlCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT3atlCondition() {
		return t3atlCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlCondition(OclExpression newT3atlCondition) {
		OclExpression oldT3atlCondition = t3atlCondition;
		t3atlCondition = newT3atlCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlCondition, t3atlCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT3atlElse() {
		if (t3atlElse != null && t3atlElse.eIsProxy()) {
			InternalEObject oldT3atlElse = t3atlElse;
			t3atlElse = (OclExpression)eResolveProxy(oldT3atlElse);
			if (t3atlElse != oldT3atlElse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlElse, t3atlElse));
			}
		}
		return t3atlElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT3atlElse() {
		return t3atlElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlElse(OclExpression newT3atlElse) {
		OclExpression oldT3atlElse = t3atlElse;
		t3atlElse = newT3atlElse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlElse, t3atlElse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT3atlThen() {
		if (t3atlThen != null && t3atlThen.eIsProxy()) {
			InternalEObject oldT3atlThen = t3atlThen;
			t3atlThen = (OclExpression)eResolveProxy(oldT3atlThen);
			if (t3atlThen != oldT3atlThen) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT3atlThen, t3atlThen));
			}
		}
		return t3atlThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT3atlThen() {
		return t3atlThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlThen(OclExpression newT3atlThen) {
		OclExpression oldT3atlThen = t3atlThen;
		t3atlThen = newT3atlThen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT3atlThen, t3atlThen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT4qvtrCondition() {
		if (t4qvtrCondition != null && t4qvtrCondition.eIsProxy()) {
			InternalEObject oldT4qvtrCondition = (InternalEObject)t4qvtrCondition;
			t4qvtrCondition = (OCLExpression)eResolveProxy(oldT4qvtrCondition);
			if (t4qvtrCondition != oldT4qvtrCondition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT4qvtrCondition, t4qvtrCondition));
			}
		}
		return t4qvtrCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT4qvtrCondition() {
		return t4qvtrCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrCondition(OCLExpression newT4qvtrCondition) {
		OCLExpression oldT4qvtrCondition = t4qvtrCondition;
		t4qvtrCondition = newT4qvtrCondition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT4qvtrCondition, t4qvtrCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT4qvtrElse() {
		if (t4qvtrElse != null && t4qvtrElse.eIsProxy()) {
			InternalEObject oldT4qvtrElse = (InternalEObject)t4qvtrElse;
			t4qvtrElse = (OCLExpression)eResolveProxy(oldT4qvtrElse);
			if (t4qvtrElse != oldT4qvtrElse) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4qvtrElse, t4qvtrElse));
			}
		}
		return t4qvtrElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT4qvtrElse() {
		return t4qvtrElse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrElse(OCLExpression newT4qvtrElse) {
		OCLExpression oldT4qvtrElse = t4qvtrElse;
		t4qvtrElse = newT4qvtrElse;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4qvtrElse, t4qvtrElse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT4qvtrThen() {
		if (t4qvtrThen != null && t4qvtrThen.eIsProxy()) {
			InternalEObject oldT4qvtrThen = (InternalEObject)t4qvtrThen;
			t4qvtrThen = (OCLExpression)eResolveProxy(oldT4qvtrThen);
			if (t4qvtrThen != oldT4qvtrThen) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrThen, t4qvtrThen));
			}
		}
		return t4qvtrThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT4qvtrThen() {
		return t4qvtrThen;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrThen(OCLExpression newT4qvtrThen) {
		OCLExpression oldT4qvtrThen = t4qvtrThen;
		t4qvtrThen = newT4qvtrThen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrThen, t4qvtrThen));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldWmapOclExpression, wmapOclExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldWmapOclExpression, wmapOclExpression));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldWmapOclExpression1, wmapOclExpression1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldWmapOclExpression1, wmapOclExpression1));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10, oldWmapOclExpression2, wmapOclExpression2));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10, oldWmapOclExpression2, wmapOclExpression2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getS0local() {
		return s0local;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setS0local(Boolean newS0local) {
		Boolean oldS0local = s0local;
		s0local = newS0local;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11, oldS0local, s0local));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return eInternalContainer().eInverseRemove(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 3, DmapOclExpression.class, msgs);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return getDispatcher();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				if (resolve) return getT3atlCondition();
				return basicGetT3atlCondition();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT3atlElse();
				return basicGetT3atlElse();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT3atlThen();
				return basicGetT3atlThen();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getT4qvtrCondition();
				return basicGetT4qvtrCondition();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				if (resolve) return getT4qvtrElse();
				return basicGetT4qvtrElse();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				if (resolve) return getT4qvtrThen();
				return basicGetT4qvtrThen();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				if (resolve) return getWmapOclExpression();
				return basicGetWmapOclExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				if (resolve) return getWmapOclExpression1();
				return basicGetWmapOclExpression1();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				if (resolve) return getWmapOclExpression2();
				return basicGetWmapOclExpression2();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				return getS0local();
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setDispatcher((DmapOclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlCondition((OclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlElse((OclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT3atlThen((OclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT4qvtrCondition((OCLExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4qvtrElse((OCLExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrThen((OCLExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setWmapOclExpression((DmapOclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				setWmapOclExpression1((DmapOclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				setWmapOclExpression2((DmapOclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				setS0local((Boolean)newValue);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setDispatcher((DmapOclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlCondition((OclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlElse((OclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT3atlThen((OclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT4qvtrCondition((OCLExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4qvtrElse((OCLExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrThen((OCLExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setWmapOclExpression((DmapOclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				setWmapOclExpression1((DmapOclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				setWmapOclExpression2((DmapOclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				setS0local(S0LOCAL_EDEFAULT);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return getDispatcher() != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t3atlCondition != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t3atlElse != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t3atlThen != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return t4qvtrCondition != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				return t4qvtrElse != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				return t4qvtrThen != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				return wmapOclExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				return wmapOclExpression1 != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				return wmapOclExpression2 != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				return S0LOCAL_EDEFAULT == null ? s0local != null : !S0LOCAL_EDEFAULT.equals(s0local);
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
		result.append(" (s0local: ");
		result.append(s0local);
		result.append(')');
		return result.toString();
	}


} //TmapIfExpImpl
