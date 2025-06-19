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

import org.eclipse.m2m.atl.common.ATL.LocatedElement;

import org.eclipse.ocl.pivot.VariableDeclaration;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableImpl#getS0global <em>S0global</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableImpl#getT3atlVariable <em>T3atl Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableImpl#getT4qvtrVariable <em>T4qvtr Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapVariableImpl extends ExecutionImpl implements TmapVariable {
	/**
	 * The number of structural features of the '<em>Tmap Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_VARIABLE_FEATURE_COUNT = ExecutionImpl.EXECUTION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Tmap Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_VARIABLE_OPERATION_COUNT = ExecutionImpl.EXECUTION_OPERATION_COUNT + 0;


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
	 * The cached value of the '{@link #getT3atlVariable() <em>T3atl Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlVariable()
	 * @generated
	 * @ordered
	 */
	protected LocatedElement t3atlVariable;

	/**
	 * The cached value of the '{@link #getT4qvtrVariable() <em>T4qvtr Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration t4qvtrVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_VARIABLE;
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
	public LocatedElement getT3atlVariable() {
		if (t3atlVariable != null && t3atlVariable.eIsProxy()) {
			InternalEObject oldT3atlVariable = t3atlVariable;
			t3atlVariable = (LocatedElement)eResolveProxy(oldT3atlVariable);
			if (t3atlVariable != oldT3atlVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT3atlVariable, t3atlVariable));
			}
		}
		return t3atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocatedElement basicGetT3atlVariable() {
		return t3atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlVariable(LocatedElement newT3atlVariable) {
		LocatedElement oldT3atlVariable = t3atlVariable;
		t3atlVariable = newT3atlVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT3atlVariable, t3atlVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableDeclaration getT4qvtrVariable() {
		if (t4qvtrVariable != null && t4qvtrVariable.eIsProxy()) {
			InternalEObject oldT4qvtrVariable = (InternalEObject)t4qvtrVariable;
			t4qvtrVariable = (VariableDeclaration)eResolveProxy(oldT4qvtrVariable);
			if (t4qvtrVariable != oldT4qvtrVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT4qvtrVariable, t4qvtrVariable));
			}
		}
		return t4qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetT4qvtrVariable() {
		return t4qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrVariable(VariableDeclaration newT4qvtrVariable) {
		VariableDeclaration oldT4qvtrVariable = t4qvtrVariable;
		t4qvtrVariable = newT4qvtrVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT4qvtrVariable, t4qvtrVariable));
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
				if (resolve) return getT3atlVariable();
				return basicGetT3atlVariable();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				if (resolve) return getT4qvtrVariable();
				return basicGetT4qvtrVariable();
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
				setT3atlVariable((LocatedElement)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT4qvtrVariable((VariableDeclaration)newValue);
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
				setT3atlVariable((LocatedElement)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT4qvtrVariable((VariableDeclaration)null);
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
				return t3atlVariable != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t4qvtrVariable != null;
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


} //TmapVariableImpl
