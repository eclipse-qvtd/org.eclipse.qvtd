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

import org.eclipse.m2m.atl.common.OCL.VariableDeclaration;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.WC_mapVariableExp_referredVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Variable Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapVariableExpImpl#getAtl_atlVariable <em>Atl atl Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapVariableExpImpl#getInvocation_mapVariableExp_referredVariable <em>Invocation map Variable Exp referred Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapVariableExpImpl#getPrimitive_varName <em>Primitive var Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapVariableExpImpl extends TI_mapVariableExpImpl implements TC_mapVariableExp {
	/**
	 * The cached value of the '{@link #getAtl_atlVariable() <em>Atl atl Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration atl_atlVariable;

	/**
	 * The cached value of the '{@link #getInvocation_mapVariableExp_referredVariable() <em>Invocation map Variable Exp referred Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvocation_mapVariableExp_referredVariable()
	 * @generated
	 * @ordered
	 */
	protected WC_mapVariableExp_referredVariable invocation_mapVariableExp_referredVariable;

	/**
	 * The default value of the '{@link #getPrimitive_varName() <em>Primitive var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_varName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMITIVE_VAR_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimitive_varName() <em>Primitive var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_varName()
	 * @generated
	 * @ordered
	 */
	protected String primitive_varName = PRIMITIVE_VAR_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapVariableExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_VARIABLE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableDeclaration getAtl_atlVariable() {
		if (atl_atlVariable != null && atl_atlVariable.eIsProxy()) {
			InternalEObject oldAtl_atlVariable = atl_atlVariable;
			atl_atlVariable = (VariableDeclaration)eResolveProxy(oldAtl_atlVariable);
			if (atl_atlVariable != oldAtl_atlVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__ATL_ATL_VARIABLE, oldAtl_atlVariable, atl_atlVariable));
			}
		}
		return atl_atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetAtl_atlVariable() {
		return atl_atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlVariable(VariableDeclaration newAtl_atlVariable) {
		VariableDeclaration oldAtl_atlVariable = atl_atlVariable;
		atl_atlVariable = newAtl_atlVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__ATL_ATL_VARIABLE, oldAtl_atlVariable, atl_atlVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WC_mapVariableExp_referredVariable getInvocation_mapVariableExp_referredVariable() {
		return invocation_mapVariableExp_referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvocation_mapVariableExp_referredVariable(WC_mapVariableExp_referredVariable newInvocation_mapVariableExp_referredVariable, NotificationChain msgs) {
		WC_mapVariableExp_referredVariable oldInvocation_mapVariableExp_referredVariable = invocation_mapVariableExp_referredVariable;
		invocation_mapVariableExp_referredVariable = newInvocation_mapVariableExp_referredVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__INVOCATION_MAP_VARIABLE_EXP_REFERRED_VARIABLE, oldInvocation_mapVariableExp_referredVariable, newInvocation_mapVariableExp_referredVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInvocation_mapVariableExp_referredVariable(WC_mapVariableExp_referredVariable newInvocation_mapVariableExp_referredVariable) {
		if (newInvocation_mapVariableExp_referredVariable != invocation_mapVariableExp_referredVariable) {
			NotificationChain msgs = null;
			if (invocation_mapVariableExp_referredVariable != null)
				msgs = ((InternalEObject)invocation_mapVariableExp_referredVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__INVOCATION_MAP_VARIABLE_EXP_REFERRED_VARIABLE, null, msgs);
			if (newInvocation_mapVariableExp_referredVariable != null)
				msgs = ((InternalEObject)newInvocation_mapVariableExp_referredVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__INVOCATION_MAP_VARIABLE_EXP_REFERRED_VARIABLE, null, msgs);
			msgs = basicSetInvocation_mapVariableExp_referredVariable(newInvocation_mapVariableExp_referredVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__INVOCATION_MAP_VARIABLE_EXP_REFERRED_VARIABLE, newInvocation_mapVariableExp_referredVariable, newInvocation_mapVariableExp_referredVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimitive_varName() {
		return primitive_varName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimitive_varName(String newPrimitive_varName) {
		String oldPrimitive_varName = primitive_varName;
		primitive_varName = newPrimitive_varName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__PRIMITIVE_VAR_NAME, oldPrimitive_varName, primitive_varName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__INVOCATION_MAP_VARIABLE_EXP_REFERRED_VARIABLE:
				return basicSetInvocation_mapVariableExp_referredVariable(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__ATL_ATL_VARIABLE:
				if (resolve) return getAtl_atlVariable();
				return basicGetAtl_atlVariable();
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__INVOCATION_MAP_VARIABLE_EXP_REFERRED_VARIABLE:
				return getInvocation_mapVariableExp_referredVariable();
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__PRIMITIVE_VAR_NAME:
				return getPrimitive_varName();
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
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__ATL_ATL_VARIABLE:
				setAtl_atlVariable((VariableDeclaration)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__INVOCATION_MAP_VARIABLE_EXP_REFERRED_VARIABLE:
				setInvocation_mapVariableExp_referredVariable((WC_mapVariableExp_referredVariable)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__PRIMITIVE_VAR_NAME:
				setPrimitive_varName((String)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__ATL_ATL_VARIABLE:
				setAtl_atlVariable((VariableDeclaration)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__INVOCATION_MAP_VARIABLE_EXP_REFERRED_VARIABLE:
				setInvocation_mapVariableExp_referredVariable((WC_mapVariableExp_referredVariable)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__PRIMITIVE_VAR_NAME:
				setPrimitive_varName(PRIMITIVE_VAR_NAME_EDEFAULT);
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
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__ATL_ATL_VARIABLE:
				return atl_atlVariable != null;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__INVOCATION_MAP_VARIABLE_EXP_REFERRED_VARIABLE:
				return invocation_mapVariableExp_referredVariable != null;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP__PRIMITIVE_VAR_NAME:
				return PRIMITIVE_VAR_NAME_EDEFAULT == null ? primitive_varName != null : !PRIMITIVE_VAR_NAME_EDEFAULT.equals(primitive_varName);
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
		result.append(" (primitive_varName: ");
		result.append(primitive_varName);
		result.append(')');
		return result.toString();
	}

} //TC_mapVariableExpImpl
