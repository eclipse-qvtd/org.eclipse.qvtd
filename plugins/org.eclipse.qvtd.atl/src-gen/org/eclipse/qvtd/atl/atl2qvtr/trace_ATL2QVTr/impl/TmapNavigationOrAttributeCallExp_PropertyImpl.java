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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Navigation Or Attribute Call Exp Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getT0propertyName <em>T0property Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getT1atlSource <em>T1atl Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getT2qvtrSource <em>T2qvtr Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapNavigationOrAttributeCallExp_PropertyImpl extends ImapOclExpressionImpl implements TmapNavigationOrAttributeCallExp_Property {
	/**
	 * The default value of the '{@link #getT0propertyName() <em>T0property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0propertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String T0PROPERTY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT0propertyName() <em>T0property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0propertyName()
	 * @generated
	 * @ordered
	 */
	protected String t0propertyName = T0PROPERTY_NAME_EDEFAULT;

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
	protected TmapNavigationOrAttributeCallExp_PropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapOclExpression getDispatcher() {
		if (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER) return null;
		return (DmapOclExpression)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapOclExpression newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDispatcher(DmapOclExpression newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY, DmapOclExpression.class, msgs);
			msgs = basicSetDispatcher(newDispatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER, newDispatcher, newDispatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getT0propertyName() {
		return t0propertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT0propertyName(String newT0propertyName) {
		String oldT0propertyName = t0propertyName;
		t0propertyName = newT0propertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T0PROPERTY_NAME, oldT0propertyName, t0propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getT1atlSource() {
		if (t1atlSource != null && t1atlSource.eIsProxy()) {
			InternalEObject oldT1atlSource = (InternalEObject)t1atlSource;
			t1atlSource = (OclExpression)eResolveProxy(oldT1atlSource);
			if (t1atlSource != oldT1atlSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T1ATL_SOURCE, oldT1atlSource, t1atlSource));
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
	public void setT1atlSource(OclExpression newT1atlSource) {
		OclExpression oldT1atlSource = t1atlSource;
		t1atlSource = newT1atlSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T1ATL_SOURCE, oldT1atlSource, t1atlSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getT2qvtrSource() {
		if (t2qvtrSource != null && t2qvtrSource.eIsProxy()) {
			InternalEObject oldT2qvtrSource = (InternalEObject)t2qvtrSource;
			t2qvtrSource = (OCLExpression)eResolveProxy(oldT2qvtrSource);
			if (t2qvtrSource != oldT2qvtrSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T2QVTR_SOURCE, oldT2qvtrSource, t2qvtrSource));
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
	public void setT2qvtrSource(OCLExpression newT2qvtrSource) {
		OCLExpression oldT2qvtrSource = t2qvtrSource;
		t2qvtrSource = newT2qvtrSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T2QVTR_SOURCE, oldT2qvtrSource, t2qvtrSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapOclExpression getWmapOclExpression() {
		if (wmapOclExpression != null && wmapOclExpression.eIsProxy()) {
			InternalEObject oldWmapOclExpression = (InternalEObject)wmapOclExpression;
			wmapOclExpression = (DmapOclExpression)eResolveProxy(oldWmapOclExpression);
			if (wmapOclExpression != oldWmapOclExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__WMAP_OCL_EXPRESSION, oldWmapOclExpression, wmapOclExpression));
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
	public void setWmapOclExpression(DmapOclExpression newWmapOclExpression) {
		DmapOclExpression oldWmapOclExpression = wmapOclExpression;
		wmapOclExpression = newWmapOclExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__WMAP_OCL_EXPRESSION, oldWmapOclExpression, wmapOclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER:
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
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER:
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
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER:
				return eInternalContainer().eInverseRemove(this, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY, DmapOclExpression.class, msgs);
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
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER:
				return getDispatcher();
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T0PROPERTY_NAME:
				return getT0propertyName();
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T1ATL_SOURCE:
				if (resolve) return getT1atlSource();
				return basicGetT1atlSource();
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T2QVTR_SOURCE:
				if (resolve) return getT2qvtrSource();
				return basicGetT2qvtrSource();
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__WMAP_OCL_EXPRESSION:
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
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER:
				setDispatcher((DmapOclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T0PROPERTY_NAME:
				setT0propertyName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T1ATL_SOURCE:
				setT1atlSource((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T2QVTR_SOURCE:
				setT2qvtrSource((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__WMAP_OCL_EXPRESSION:
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
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER:
				setDispatcher((DmapOclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T0PROPERTY_NAME:
				setT0propertyName(T0PROPERTY_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T1ATL_SOURCE:
				setT1atlSource((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T2QVTR_SOURCE:
				setT2qvtrSource((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__WMAP_OCL_EXPRESSION:
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
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__DISPATCHER:
				return getDispatcher() != null;
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T0PROPERTY_NAME:
				return T0PROPERTY_NAME_EDEFAULT == null ? t0propertyName != null : !T0PROPERTY_NAME_EDEFAULT.equals(t0propertyName);
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T1ATL_SOURCE:
				return t1atlSource != null;
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__T2QVTR_SOURCE:
				return t2qvtrSource != null;
			case trace_ATL2QVTrPackage.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY__WMAP_OCL_EXPRESSION:
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
		result.append(" (t0propertyName: ");
		result.append(t0propertyName);
		result.append(')');
		return result.toString();
	}

} //TmapNavigationOrAttributeCallExp_PropertyImpl
