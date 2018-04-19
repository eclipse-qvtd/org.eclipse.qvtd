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

import org.eclipse.m2m.atl.common.OCL.VariableDeclaration;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Variable Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExpImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExpImpl#getT0varName <em>T0var Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExpImpl#getT1atlVariable <em>T1atl Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExpImpl#getWmapVariableExp_referredVariable <em>Wmap Variable Exp referred Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapVariableExpImpl extends ImapOclExpressionImpl implements TmapVariableExp {
	/**
	 * The default value of the '{@link #getT0varName() <em>T0var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0varName()
	 * @generated
	 * @ordered
	 */
	protected static final String T0VAR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT0varName() <em>T0var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0varName()
	 * @generated
	 * @ordered
	 */
	protected String t0varName = T0VAR_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT1atlVariable() <em>T1atl Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration t1atlVariable;

	/**
	 * The cached value of the '{@link #getWmapVariableExp_referredVariable() <em>Wmap Variable Exp referred Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapVariableExp_referredVariable()
	 * @generated
	 * @ordered
	 */
	protected DmapVariableExp_referredVariable wmapVariableExp_referredVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapVariableExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapOclExpression getDispatcher() {
		if (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__DISPATCHER) return null;
		return (DmapOclExpression)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapOclExpression newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__DISPATCHER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDispatcher(DmapOclExpression newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__DISPATCHER && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP, DmapOclExpression.class, msgs);
			msgs = basicSetDispatcher(newDispatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__DISPATCHER, newDispatcher, newDispatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getT0varName() {
		return t0varName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT0varName(String newT0varName) {
		String oldT0varName = t0varName;
		t0varName = newT0varName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__T0VAR_NAME, oldT0varName, t0varName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableDeclaration getT1atlVariable() {
		if (t1atlVariable != null && t1atlVariable.eIsProxy()) {
			InternalEObject oldT1atlVariable = (InternalEObject)t1atlVariable;
			t1atlVariable = (VariableDeclaration)eResolveProxy(oldT1atlVariable);
			if (t1atlVariable != oldT1atlVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__T1ATL_VARIABLE, oldT1atlVariable, t1atlVariable));
			}
		}
		return t1atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetT1atlVariable() {
		return t1atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlVariable(VariableDeclaration newT1atlVariable) {
		VariableDeclaration oldT1atlVariable = t1atlVariable;
		t1atlVariable = newT1atlVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__T1ATL_VARIABLE, oldT1atlVariable, t1atlVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapVariableExp_referredVariable getWmapVariableExp_referredVariable() {
		if (wmapVariableExp_referredVariable != null && wmapVariableExp_referredVariable.eIsProxy()) {
			InternalEObject oldWmapVariableExp_referredVariable = (InternalEObject)wmapVariableExp_referredVariable;
			wmapVariableExp_referredVariable = (DmapVariableExp_referredVariable)eResolveProxy(oldWmapVariableExp_referredVariable);
			if (wmapVariableExp_referredVariable != oldWmapVariableExp_referredVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__WMAP_VARIABLE_EXP_REFERRED_VARIABLE, oldWmapVariableExp_referredVariable, wmapVariableExp_referredVariable));
			}
		}
		return wmapVariableExp_referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapVariableExp_referredVariable basicGetWmapVariableExp_referredVariable() {
		return wmapVariableExp_referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapVariableExp_referredVariable(DmapVariableExp_referredVariable newWmapVariableExp_referredVariable) {
		DmapVariableExp_referredVariable oldWmapVariableExp_referredVariable = wmapVariableExp_referredVariable;
		wmapVariableExp_referredVariable = newWmapVariableExp_referredVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__WMAP_VARIABLE_EXP_REFERRED_VARIABLE, oldWmapVariableExp_referredVariable, wmapVariableExp_referredVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__DISPATCHER:
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
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__DISPATCHER:
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
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__DISPATCHER:
				return eInternalContainer().eInverseRemove(this, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_VARIABLE_EXP, DmapOclExpression.class, msgs);
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
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__DISPATCHER:
				return getDispatcher();
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__T0VAR_NAME:
				return getT0varName();
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__T1ATL_VARIABLE:
				if (resolve) return getT1atlVariable();
				return basicGetT1atlVariable();
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__WMAP_VARIABLE_EXP_REFERRED_VARIABLE:
				if (resolve) return getWmapVariableExp_referredVariable();
				return basicGetWmapVariableExp_referredVariable();
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
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__DISPATCHER:
				setDispatcher((DmapOclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__T0VAR_NAME:
				setT0varName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__T1ATL_VARIABLE:
				setT1atlVariable((VariableDeclaration)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__WMAP_VARIABLE_EXP_REFERRED_VARIABLE:
				setWmapVariableExp_referredVariable((DmapVariableExp_referredVariable)newValue);
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
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__DISPATCHER:
				setDispatcher((DmapOclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__T0VAR_NAME:
				setT0varName(T0VAR_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__T1ATL_VARIABLE:
				setT1atlVariable((VariableDeclaration)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__WMAP_VARIABLE_EXP_REFERRED_VARIABLE:
				setWmapVariableExp_referredVariable((DmapVariableExp_referredVariable)null);
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
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__DISPATCHER:
				return getDispatcher() != null;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__T0VAR_NAME:
				return T0VAR_NAME_EDEFAULT == null ? t0varName != null : !T0VAR_NAME_EDEFAULT.equals(t0varName);
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__T1ATL_VARIABLE:
				return t1atlVariable != null;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP__WMAP_VARIABLE_EXP_REFERRED_VARIABLE:
				return wmapVariableExp_referredVariable != null;
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
		result.append(" (t0varName: ");
		result.append(t0varName);
		result.append(')');
		return result.toString();
	}

} //TmapVariableExpImpl
