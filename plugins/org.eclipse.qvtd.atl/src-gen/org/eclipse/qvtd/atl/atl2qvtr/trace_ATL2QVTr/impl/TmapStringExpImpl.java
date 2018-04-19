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

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapStringExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap String Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapStringExpImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapStringExpImpl#getT0symbol <em>T0symbol</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapStringExpImpl extends ImapOclExpressionImpl implements TmapStringExp {
	/**
	 * The default value of the '{@link #getT0symbol() <em>T0symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0symbol()
	 * @generated
	 * @ordered
	 */
	protected static final String T0SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT0symbol() <em>T0symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0symbol()
	 * @generated
	 * @ordered
	 */
	protected String t0symbol = T0SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapStringExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_STRING_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapOclExpression getDispatcher() {
		if (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_STRING_EXP__DISPATCHER) return null;
		return (DmapOclExpression)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapOclExpression newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, trace_ATL2QVTrPackage.TMAP_STRING_EXP__DISPATCHER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDispatcher(DmapOclExpression newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_STRING_EXP__DISPATCHER && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP, DmapOclExpression.class, msgs);
			msgs = basicSetDispatcher(newDispatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_STRING_EXP__DISPATCHER, newDispatcher, newDispatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getT0symbol() {
		return t0symbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT0symbol(String newT0symbol) {
		String oldT0symbol = t0symbol;
		t0symbol = newT0symbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_STRING_EXP__T0SYMBOL, oldT0symbol, t0symbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_STRING_EXP__DISPATCHER:
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
			case trace_ATL2QVTrPackage.TMAP_STRING_EXP__DISPATCHER:
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
			case trace_ATL2QVTrPackage.TMAP_STRING_EXP__DISPATCHER:
				return eInternalContainer().eInverseRemove(this, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_STRING_EXP, DmapOclExpression.class, msgs);
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
			case trace_ATL2QVTrPackage.TMAP_STRING_EXP__DISPATCHER:
				return getDispatcher();
			case trace_ATL2QVTrPackage.TMAP_STRING_EXP__T0SYMBOL:
				return getT0symbol();
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
			case trace_ATL2QVTrPackage.TMAP_STRING_EXP__DISPATCHER:
				setDispatcher((DmapOclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_STRING_EXP__T0SYMBOL:
				setT0symbol((String)newValue);
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
			case trace_ATL2QVTrPackage.TMAP_STRING_EXP__DISPATCHER:
				setDispatcher((DmapOclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_STRING_EXP__T0SYMBOL:
				setT0symbol(T0SYMBOL_EDEFAULT);
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
			case trace_ATL2QVTrPackage.TMAP_STRING_EXP__DISPATCHER:
				return getDispatcher() != null;
			case trace_ATL2QVTrPackage.TMAP_STRING_EXP__T0SYMBOL:
				return T0SYMBOL_EDEFAULT == null ? t0symbol != null : !T0SYMBOL_EDEFAULT.equals(t0symbol);
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
		result.append(" (t0symbol: ");
		result.append(t0symbol);
		result.append(')');
		return result.toString();
	}

} //TmapStringExpImpl
