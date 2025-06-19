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

import org.eclipse.m2m.atl.common.ATL.Helper;

import org.eclipse.m2m.atl.common.OCL.VariableDeclaration;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl;
import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Variable Exp referred Variable Helper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl#getT3atlHelper <em>T3atl Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl#getT3atlVariable <em>T3atl Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl#getT4qvtrVariable <em>T4qvtr Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_HelperImpl#getS0local <em>S0local</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapVariableExp_referredVariable_HelperImpl extends ImapVariableExp_referredVariableImpl implements TmapVariableExp_referredVariable_Helper {
	/**
	 * The number of structural features of the '<em>Tmap Variable Exp referred Variable Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER_FEATURE_COUNT = ImapVariableExp_referredVariableImpl.IMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Tmap Variable Exp referred Variable Helper</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_HELPER_OPERATION_COUNT = ImapVariableExp_referredVariableImpl.IMAP_VARIABLE_EXP_REFERRED_VARIABLE_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getT3atlHelper() <em>T3atl Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlHelper()
	 * @generated
	 * @ordered
	 */
	protected Helper t3atlHelper;

	/**
	 * The cached value of the '{@link #getT3atlVariable() <em>T3atl Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration t3atlVariable;

	/**
	 * The cached value of the '{@link #getT4qvtrVariable() <em>T4qvtr Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrVariable()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.VariableDeclaration t4qvtrVariable;

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
	@Override
	public DmapVariableExp_referredVariable getDispatcher() {
		if (eContainerFeatureID() != (ExecutionImpl.EXECUTION_FEATURE_COUNT + 1)) return null;
		return (DmapVariableExp_referredVariable)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapVariableExp_referredVariable newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDispatcher(DmapVariableExp_referredVariable newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != (ExecutionImpl.EXECUTION_FEATURE_COUNT + 1) && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 2, DmapVariableExp_referredVariable.class, msgs);
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
	public Helper getT3atlHelper() {
		if (t3atlHelper != null && t3atlHelper.eIsProxy()) {
			InternalEObject oldT3atlHelper = t3atlHelper;
			t3atlHelper = (Helper)eResolveProxy(oldT3atlHelper);
			if (t3atlHelper != oldT3atlHelper) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlHelper, t3atlHelper));
			}
		}
		return t3atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Helper basicGetT3atlHelper() {
		return t3atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlHelper(Helper newT3atlHelper) {
		Helper oldT3atlHelper = t3atlHelper;
		t3atlHelper = newT3atlHelper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlHelper, t3atlHelper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableDeclaration getT3atlVariable() {
		if (t3atlVariable != null && t3atlVariable.eIsProxy()) {
			InternalEObject oldT3atlVariable = t3atlVariable;
			t3atlVariable = (VariableDeclaration)eResolveProxy(oldT3atlVariable);
			if (t3atlVariable != oldT3atlVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlVariable, t3atlVariable));
			}
		}
		return t3atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetT3atlVariable() {
		return t3atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlVariable(VariableDeclaration newT3atlVariable) {
		VariableDeclaration oldT3atlVariable = t3atlVariable;
		t3atlVariable = newT3atlVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlVariable, t3atlVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.VariableDeclaration getT4qvtrVariable() {
		if (t4qvtrVariable != null && t4qvtrVariable.eIsProxy()) {
			InternalEObject oldT4qvtrVariable = (InternalEObject)t4qvtrVariable;
			t4qvtrVariable = (org.eclipse.ocl.pivot.VariableDeclaration)eResolveProxy(oldT4qvtrVariable);
			if (t4qvtrVariable != oldT4qvtrVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT4qvtrVariable, t4qvtrVariable));
			}
		}
		return t4qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.VariableDeclaration basicGetT4qvtrVariable() {
		return t4qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrVariable(org.eclipse.ocl.pivot.VariableDeclaration newT4qvtrVariable) {
		org.eclipse.ocl.pivot.VariableDeclaration oldT4qvtrVariable = t4qvtrVariable;
		t4qvtrVariable = newT4qvtrVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT4qvtrVariable, t4qvtrVariable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldS0local, s0local));
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
				return eInternalContainer().eInverseRemove(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 2, DmapVariableExp_referredVariable.class, msgs);
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
				if (resolve) return getT3atlHelper();
				return basicGetT3atlHelper();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT3atlVariable();
				return basicGetT3atlVariable();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT4qvtrVariable();
				return basicGetT4qvtrVariable();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
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
				setDispatcher((DmapVariableExp_referredVariable)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlHelper((Helper)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlVariable((VariableDeclaration)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT4qvtrVariable((org.eclipse.ocl.pivot.VariableDeclaration)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
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
				setDispatcher((DmapVariableExp_referredVariable)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlHelper((Helper)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlVariable((VariableDeclaration)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT4qvtrVariable((org.eclipse.ocl.pivot.VariableDeclaration)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
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
				return t3atlHelper != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t3atlVariable != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t4qvtrVariable != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
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


} //TmapVariableExp_referredVariable_HelperImpl
