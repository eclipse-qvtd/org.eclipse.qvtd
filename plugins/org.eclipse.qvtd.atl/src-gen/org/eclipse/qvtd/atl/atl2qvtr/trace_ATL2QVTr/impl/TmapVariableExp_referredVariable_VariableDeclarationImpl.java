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

import org.eclipse.m2m.atl.common.ATL.PatternElement;

import org.eclipse.ocl.pivot.VariableDeclaration;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariableExp_referredVariable_VariableDeclaration;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl;
import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Variable Exp referred Variable Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_VariableDeclarationImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_VariableDeclarationImpl#getT1atlVariable <em>T1atl Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableExp_referredVariable_VariableDeclarationImpl#getT2qvtrVariable <em>T2qvtr Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapVariableExp_referredVariable_VariableDeclarationImpl extends ImapVariableExp_referredVariableImpl implements TmapVariableExp_referredVariable_VariableDeclaration {
	/**
	 * The number of structural features of the '<em>Tmap Variable Exp referred Variable Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION_FEATURE_COUNT = ImapVariableExp_referredVariableImpl.IMAP_VARIABLE_EXP_REFERRED_VARIABLE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Tmap Variable Exp referred Variable Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION_OPERATION_COUNT = ImapVariableExp_referredVariableImpl.IMAP_VARIABLE_EXP_REFERRED_VARIABLE_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getT1atlVariable() <em>T1atl Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlVariable()
	 * @generated
	 * @ordered
	 */
	protected PatternElement t1atlVariable;

	/**
	 * The cached value of the '{@link #getT2qvtrVariable() <em>T2qvtr Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration t2qvtrVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapVariableExp_referredVariable_VariableDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION;
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
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 3, DmapVariableExp_referredVariable.class, msgs);
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
	public PatternElement getT1atlVariable() {
		if (t1atlVariable != null && t1atlVariable.eIsProxy()) {
			InternalEObject oldT1atlVariable = t1atlVariable;
			t1atlVariable = (PatternElement)eResolveProxy(oldT1atlVariable);
			if (t1atlVariable != oldT1atlVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT1atlVariable, t1atlVariable));
			}
		}
		return t1atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternElement basicGetT1atlVariable() {
		return t1atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlVariable(PatternElement newT1atlVariable) {
		PatternElement oldT1atlVariable = t1atlVariable;
		t1atlVariable = newT1atlVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT1atlVariable, t1atlVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableDeclaration getT2qvtrVariable() {
		if (t2qvtrVariable != null && t2qvtrVariable.eIsProxy()) {
			InternalEObject oldT2qvtrVariable = (InternalEObject)t2qvtrVariable;
			t2qvtrVariable = (VariableDeclaration)eResolveProxy(oldT2qvtrVariable);
			if (t2qvtrVariable != oldT2qvtrVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT2qvtrVariable, t2qvtrVariable));
			}
		}
		return t2qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetT2qvtrVariable() {
		return t2qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrVariable(VariableDeclaration newT2qvtrVariable) {
		VariableDeclaration oldT2qvtrVariable = t2qvtrVariable;
		t2qvtrVariable = newT2qvtrVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT2qvtrVariable, t2qvtrVariable));
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
				return eInternalContainer().eInverseRemove(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 3, DmapVariableExp_referredVariable.class, msgs);
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
				if (resolve) return getT1atlVariable();
				return basicGetT1atlVariable();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setDispatcher((DmapVariableExp_referredVariable)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT1atlVariable((PatternElement)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT2qvtrVariable((VariableDeclaration)newValue);
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
				setT1atlVariable((PatternElement)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT2qvtrVariable((VariableDeclaration)null);
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
				return t1atlVariable != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t2qvtrVariable != null;
		}
		return super.eIsSet(featureID);
	}


} //TmapVariableExp_referredVariable_VariableDeclarationImpl
