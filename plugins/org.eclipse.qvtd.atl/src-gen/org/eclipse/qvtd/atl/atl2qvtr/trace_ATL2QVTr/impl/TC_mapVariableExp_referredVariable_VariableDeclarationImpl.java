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

import org.eclipse.m2m.atl.common.ATL.PatternElement;

import org.eclipse.m2m.atl.common.OCL.VariableExp;

import org.eclipse.ocl.pivot.VariableDeclaration;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Variable Exp referred Variable Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapVariableExp_referredVariable_VariableDeclarationImpl#getAtl_atlExpression <em>Atl atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapVariableExp_referredVariable_VariableDeclarationImpl#getAtl_atlVariable <em>Atl atl Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapVariableExp_referredVariable_VariableDeclarationImpl#getInvocation_mapVariable <em>Invocation map Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapVariableExp_referredVariable_VariableDeclarationImpl#getQvtr_qvtrExpression <em>Qvtr qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapVariableExp_referredVariable_VariableDeclarationImpl#getQvtr_qvtrVariable <em>Qvtr qvtr Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapVariableExp_referredVariable_VariableDeclarationImpl extends TI_mapVariableExp_referredVariable_VariableDeclarationImpl implements TC_mapVariableExp_referredVariable_VariableDeclaration {
	/**
	 * The cached value of the '{@link #getAtl_atlExpression() <em>Atl atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlExpression()
	 * @generated
	 * @ordered
	 */
	protected VariableExp atl_atlExpression;

	/**
	 * The cached value of the '{@link #getAtl_atlVariable() <em>Atl atl Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlVariable()
	 * @generated
	 * @ordered
	 */
	protected PatternElement atl_atlVariable;

	/**
	 * The cached value of the '{@link #getInvocation_mapVariable() <em>Invocation map Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvocation_mapVariable()
	 * @generated
	 * @ordered
	 */
	protected TC_mapVariable invocation_mapVariable;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrExpression() <em>Qvtr qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrExpression()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.VariableExp qvtr_qvtrExpression;

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
	protected TC_mapVariableExp_referredVariable_VariableDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableExp getAtl_atlExpression() {
		if (atl_atlExpression != null && atl_atlExpression.eIsProxy()) {
			InternalEObject oldAtl_atlExpression = atl_atlExpression;
			atl_atlExpression = (VariableExp)eResolveProxy(oldAtl_atlExpression);
			if (atl_atlExpression != oldAtl_atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_EXPRESSION, oldAtl_atlExpression, atl_atlExpression));
			}
		}
		return atl_atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExp basicGetAtl_atlExpression() {
		return atl_atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlExpression(VariableExp newAtl_atlExpression) {
		VariableExp oldAtl_atlExpression = atl_atlExpression;
		atl_atlExpression = newAtl_atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_EXPRESSION, oldAtl_atlExpression, atl_atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PatternElement getAtl_atlVariable() {
		if (atl_atlVariable != null && atl_atlVariable.eIsProxy()) {
			InternalEObject oldAtl_atlVariable = atl_atlVariable;
			atl_atlVariable = (PatternElement)eResolveProxy(oldAtl_atlVariable);
			if (atl_atlVariable != oldAtl_atlVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_VARIABLE, oldAtl_atlVariable, atl_atlVariable));
			}
		}
		return atl_atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PatternElement basicGetAtl_atlVariable() {
		return atl_atlVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlVariable(PatternElement newAtl_atlVariable) {
		PatternElement oldAtl_atlVariable = atl_atlVariable;
		atl_atlVariable = newAtl_atlVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_VARIABLE, oldAtl_atlVariable, atl_atlVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TC_mapVariable getInvocation_mapVariable() {
		return invocation_mapVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvocation_mapVariable(TC_mapVariable newInvocation_mapVariable, NotificationChain msgs) {
		TC_mapVariable oldInvocation_mapVariable = invocation_mapVariable;
		invocation_mapVariable = newInvocation_mapVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__INVOCATION_MAP_VARIABLE, oldInvocation_mapVariable, newInvocation_mapVariable);
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
	public void setInvocation_mapVariable(TC_mapVariable newInvocation_mapVariable) {
		if (newInvocation_mapVariable != invocation_mapVariable) {
			NotificationChain msgs = null;
			if (invocation_mapVariable != null)
				msgs = ((InternalEObject)invocation_mapVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__INVOCATION_MAP_VARIABLE, null, msgs);
			if (newInvocation_mapVariable != null)
				msgs = ((InternalEObject)newInvocation_mapVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__INVOCATION_MAP_VARIABLE, null, msgs);
			msgs = basicSetInvocation_mapVariable(newInvocation_mapVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__INVOCATION_MAP_VARIABLE, newInvocation_mapVariable, newInvocation_mapVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.VariableExp getQvtr_qvtrExpression() {
		if (qvtr_qvtrExpression != null && qvtr_qvtrExpression.eIsProxy()) {
			InternalEObject oldQvtr_qvtrExpression = (InternalEObject)qvtr_qvtrExpression;
			qvtr_qvtrExpression = (org.eclipse.ocl.pivot.VariableExp)eResolveProxy(oldQvtr_qvtrExpression);
			if (qvtr_qvtrExpression != oldQvtr_qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_EXPRESSION, oldQvtr_qvtrExpression, qvtr_qvtrExpression));
			}
		}
		return qvtr_qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.VariableExp basicGetQvtr_qvtrExpression() {
		return qvtr_qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrExpression(org.eclipse.ocl.pivot.VariableExp newQvtr_qvtrExpression) {
		org.eclipse.ocl.pivot.VariableExp oldQvtr_qvtrExpression = qvtr_qvtrExpression;
		qvtr_qvtrExpression = newQvtr_qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_EXPRESSION, oldQvtr_qvtrExpression, qvtr_qvtrExpression));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_VARIABLE, oldQvtr_qvtrVariable, qvtr_qvtrVariable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_VARIABLE, oldQvtr_qvtrVariable, qvtr_qvtrVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__INVOCATION_MAP_VARIABLE:
				return basicSetInvocation_mapVariable(null, msgs);
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
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_EXPRESSION:
				if (resolve) return getAtl_atlExpression();
				return basicGetAtl_atlExpression();
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_VARIABLE:
				if (resolve) return getAtl_atlVariable();
				return basicGetAtl_atlVariable();
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__INVOCATION_MAP_VARIABLE:
				return getInvocation_mapVariable();
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_EXPRESSION:
				if (resolve) return getQvtr_qvtrExpression();
				return basicGetQvtr_qvtrExpression();
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_VARIABLE:
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
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_EXPRESSION:
				setAtl_atlExpression((VariableExp)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_VARIABLE:
				setAtl_atlVariable((PatternElement)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__INVOCATION_MAP_VARIABLE:
				setInvocation_mapVariable((TC_mapVariable)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_EXPRESSION:
				setQvtr_qvtrExpression((org.eclipse.ocl.pivot.VariableExp)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_VARIABLE:
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
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_EXPRESSION:
				setAtl_atlExpression((VariableExp)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_VARIABLE:
				setAtl_atlVariable((PatternElement)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__INVOCATION_MAP_VARIABLE:
				setInvocation_mapVariable((TC_mapVariable)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_EXPRESSION:
				setQvtr_qvtrExpression((org.eclipse.ocl.pivot.VariableExp)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_VARIABLE:
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
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_EXPRESSION:
				return atl_atlExpression != null;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__ATL_ATL_VARIABLE:
				return atl_atlVariable != null;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__INVOCATION_MAP_VARIABLE:
				return invocation_mapVariable != null;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_EXPRESSION:
				return qvtr_qvtrExpression != null;
			case trace_ATL2QVTrPackage.TC_MAP_VARIABLE_EXP_REFERRED_VARIABLE_VARIABLE_DECLARATION__QVTR_QVTR_VARIABLE:
				return qvtr_qvtrVariable != null;
		}
		return super.eIsSet(featureID);
	}

} //TC_mapVariableExp_referredVariable_VariableDeclarationImpl
