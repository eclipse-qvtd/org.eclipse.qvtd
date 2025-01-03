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
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableImpl#getSuccess <em>Success</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableImpl#getT1atlVariable <em>T1atl Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapVariableImpl#getT2qvtrVariable <em>T2qvtr Variable</em>}</li>
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
	 * The default value of the '{@link #getSuccess() <em>Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccess()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SUCCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSuccess() <em>Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccess()
	 * @generated
	 * @ordered
	 */
	protected Boolean success = SUCCESS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT1atlVariable() <em>T1atl Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlVariable()
	 * @generated
	 * @ordered
	 */
	protected LocatedElement t1atlVariable;

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
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuccess(Boolean newSuccess) {
		Boolean oldSuccess = success;
		success = newSuccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0, oldSuccess, success));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LocatedElement getT1atlVariable() {
		if (t1atlVariable != null && t1atlVariable.eIsProxy()) {
			InternalEObject oldT1atlVariable = t1atlVariable;
			t1atlVariable = (LocatedElement)eResolveProxy(oldT1atlVariable);
			if (t1atlVariable != oldT1atlVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT1atlVariable, t1atlVariable));
			}
		}
		return t1atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocatedElement basicGetT1atlVariable() {
		return t1atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlVariable(LocatedElement newT1atlVariable) {
		LocatedElement oldT1atlVariable = t1atlVariable;
		t1atlVariable = newT1atlVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT1atlVariable, t1atlVariable));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT2qvtrVariable, t2qvtrVariable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT2qvtrVariable, t2qvtrVariable));
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
				return getSuccess();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				if (resolve) return getT1atlVariable();
				return basicGetT1atlVariable();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setSuccess((Boolean)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1atlVariable((LocatedElement)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setSuccess(SUCCESS_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1atlVariable((LocatedElement)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				return SUCCESS_EDEFAULT == null ? success != null : !SUCCESS_EDEFAULT.equals(success);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return t1atlVariable != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t2qvtrVariable != null;
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
		result.append(" (success: ");
		result.append(success);
		result.append(')');
		return result.toString();
	}


} //TmapVariableImpl
