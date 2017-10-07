/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.ATL.LocatedElement;

import org.eclipse.ocl.pivot.VariableDeclaration;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Variable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapVariableImpl#getAtl_atlVariable <em>Atl atl Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapVariableImpl#getQvtr_qvtrVariable <em>Qvtr qvtr Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapVariableImpl extends MinimalEObjectImpl.Container implements TC_mapVariable {
	/**
	 * The cached value of the '{@link #getAtl_atlVariable() <em>Atl atl Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlVariable()
	 * @generated
	 * @ordered
	 */
	protected LocatedElement atl_atlVariable;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrVariable() <em>Qvtr qvtr Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration qvtr_qvtrVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapVariableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_VARIABLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LocatedElement getAtl_atlVariable() {
		if (atl_atlVariable != null && atl_atlVariable.eIsProxy()) {
			InternalEObject oldAtl_atlVariable = atl_atlVariable;
			atl_atlVariable = (LocatedElement)eResolveProxy(oldAtl_atlVariable);
			if (atl_atlVariable != oldAtl_atlVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_VARIABLE__ATL_ATL_VARIABLE, oldAtl_atlVariable, atl_atlVariable));
			}
		}
		return atl_atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocatedElement basicGetAtl_atlVariable() {
		return atl_atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlVariable(LocatedElement newAtl_atlVariable) {
		LocatedElement oldAtl_atlVariable = atl_atlVariable;
		atl_atlVariable = newAtl_atlVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE__ATL_ATL_VARIABLE, oldAtl_atlVariable, atl_atlVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableDeclaration getQvtr_qvtrVariable() {
		if (qvtr_qvtrVariable != null && qvtr_qvtrVariable.eIsProxy()) {
			InternalEObject oldQvtr_qvtrVariable = (InternalEObject)qvtr_qvtrVariable;
			qvtr_qvtrVariable = (VariableDeclaration)eResolveProxy(oldQvtr_qvtrVariable);
			if (qvtr_qvtrVariable != oldQvtr_qvtrVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_VARIABLE__QVTR_QVTR_VARIABLE, oldQvtr_qvtrVariable, qvtr_qvtrVariable));
			}
		}
		return qvtr_qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetQvtr_qvtrVariable() {
		return qvtr_qvtrVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrVariable(VariableDeclaration newQvtr_qvtrVariable) {
		VariableDeclaration oldQvtr_qvtrVariable = qvtr_qvtrVariable;
		qvtr_qvtrVariable = newQvtr_qvtrVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE__QVTR_QVTR_VARIABLE, oldQvtr_qvtrVariable, qvtr_qvtrVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE__ATL_ATL_VARIABLE:
				if (resolve) return getAtl_atlVariable();
				return basicGetAtl_atlVariable();
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE__QVTR_QVTR_VARIABLE:
				if (resolve) return getQvtr_qvtrVariable();
				return basicGetQvtr_qvtrVariable();
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
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE__ATL_ATL_VARIABLE:
				setAtl_atlVariable((LocatedElement)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE__QVTR_QVTR_VARIABLE:
				setQvtr_qvtrVariable((VariableDeclaration)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE__ATL_ATL_VARIABLE:
				setAtl_atlVariable((LocatedElement)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE__QVTR_QVTR_VARIABLE:
				setQvtr_qvtrVariable((VariableDeclaration)null);
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
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE__ATL_ATL_VARIABLE:
				return atl_atlVariable != null;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE__QVTR_QVTR_VARIABLE:
				return qvtr_qvtrVariable != null;
		}
		return super.eIsSet(featureID);
	}

} //TC_mapVariableImpl
