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

import org.eclipse.m2m.atl.common.ATL.Helper;

import org.eclipse.m2m.atl.common.OCL.VariableDeclaration;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Variable Exp referred Variable Helper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl#getT1atlHelper <em>T1atl Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl#getT1atlVariable <em>T1atl Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl#getT2qvtrVariable <em>T2qvtr Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapVariableExp_referredVariable_HelperImpl extends ImapVariableExp_referredVariableImpl implements TmapVariableExp_referredVariable_Helper {
	/**
	 * The cached value of the '{@link #getT1atlHelper() <em>T1atl Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlHelper()
	 * @generated
	 * @ordered
	 */
	protected Helper t1atlHelper;

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
	 * The cached value of the '{@link #getT2qvtrVariable() <em>T2qvtr Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrVariable()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.VariableDeclaration t2qvtrVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapVariableExp_referredVariable_HelperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapVariableExp_referredVariable getDispatcher() {
		if (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER) return null;
		return (DmapVariableExp_referredVariable)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapVariableExp_referredVariable newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDispatcher(DmapVariableExp_referredVariable newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, trace_ATL2QVTrPackage.DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER, DmapVariableExp_referredVariable.class, msgs);
			msgs = basicSetDispatcher(newDispatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER, newDispatcher, newDispatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Helper getT1atlHelper() {
		if (t1atlHelper != null && t1atlHelper.eIsProxy()) {
			InternalEObject oldT1atlHelper = (InternalEObject)t1atlHelper;
			t1atlHelper = (Helper)eResolveProxy(oldT1atlHelper);
			if (t1atlHelper != oldT1atlHelper) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_HELPER, oldT1atlHelper, t1atlHelper));
			}
		}
		return t1atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Helper basicGetT1atlHelper() {
		return t1atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT1atlHelper(Helper newT1atlHelper) {
		Helper oldT1atlHelper = t1atlHelper;
		t1atlHelper = newT1atlHelper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_HELPER, oldT1atlHelper, t1atlHelper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration getT1atlVariable() {
		if (t1atlVariable != null && t1atlVariable.eIsProxy()) {
			InternalEObject oldT1atlVariable = (InternalEObject)t1atlVariable;
			t1atlVariable = (VariableDeclaration)eResolveProxy(oldT1atlVariable);
			if (t1atlVariable != oldT1atlVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_VARIABLE, oldT1atlVariable, t1atlVariable));
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
	public void setT1atlVariable(VariableDeclaration newT1atlVariable) {
		VariableDeclaration oldT1atlVariable = t1atlVariable;
		t1atlVariable = newT1atlVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_VARIABLE, oldT1atlVariable, t1atlVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.VariableDeclaration getT2qvtrVariable() {
		if (t2qvtrVariable != null && t2qvtrVariable.eIsProxy()) {
			InternalEObject oldT2qvtrVariable = (InternalEObject)t2qvtrVariable;
			t2qvtrVariable = (org.eclipse.ocl.pivot.VariableDeclaration)eResolveProxy(oldT2qvtrVariable);
			if (t2qvtrVariable != oldT2qvtrVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T2QVTR_VARIABLE, oldT2qvtrVariable, t2qvtrVariable));
			}
		}
		return t2qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.VariableDeclaration basicGetT2qvtrVariable() {
		return t2qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT2qvtrVariable(org.eclipse.ocl.pivot.VariableDeclaration newT2qvtrVariable) {
		org.eclipse.ocl.pivot.VariableDeclaration oldT2qvtrVariable = t2qvtrVariable;
		t2qvtrVariable = newT2qvtrVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T2QVTR_VARIABLE, oldT2qvtrVariable, t2qvtrVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDispatcher((DmapVariableExp_referredVariable)otherEnd, msgs);
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
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER:
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
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER:
				return eInternalContainer().eInverseRemove(this, trace_ATL2QVTrPackage.DMAP_VARIABLE_EXP_REFERRED_VARIABLE__DOMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER, DmapVariableExp_referredVariable.class, msgs);
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
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER:
				return getDispatcher();
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_HELPER:
				if (resolve) return getT1atlHelper();
				return basicGetT1atlHelper();
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_VARIABLE:
				if (resolve) return getT1atlVariable();
				return basicGetT1atlVariable();
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T2QVTR_VARIABLE:
				if (resolve) return getT2qvtrVariable();
				return basicGetT2qvtrVariable();
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
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER:
				setDispatcher((DmapVariableExp_referredVariable)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_HELPER:
				setT1atlHelper((Helper)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_VARIABLE:
				setT1atlVariable((VariableDeclaration)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T2QVTR_VARIABLE:
				setT2qvtrVariable((org.eclipse.ocl.pivot.VariableDeclaration)newValue);
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
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER:
				setDispatcher((DmapVariableExp_referredVariable)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_HELPER:
				setT1atlHelper((Helper)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_VARIABLE:
				setT1atlVariable((VariableDeclaration)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T2QVTR_VARIABLE:
				setT2qvtrVariable((org.eclipse.ocl.pivot.VariableDeclaration)null);
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
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__DISPATCHER:
				return getDispatcher() != null;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_HELPER:
				return t1atlHelper != null;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T1ATL_VARIABLE:
				return t1atlVariable != null;
			case trace_ATL2QVTrPackage.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER__T2QVTR_VARIABLE:
				return t2qvtrVariable != null;
		}
		return super.eIsSet(featureID);
	}

} //TmapVariableExp_referredVariable_HelperImpl
