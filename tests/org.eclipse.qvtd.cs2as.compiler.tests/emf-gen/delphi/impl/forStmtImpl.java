/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package delphi.impl;

import delphi.DelphiPackage;
import delphi.expression;
import delphi.forStmt;
import delphi.qualId;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>for Stmt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.forStmtImpl#getVarId <em>Var Id</em>}</li>
 *   <li>{@link delphi.impl.forStmtImpl#getVarInit <em>Var Init</em>}</li>
 * </ul>
 *
 * @generated
 */
public class forStmtImpl extends loopStmtImpl implements forStmt {
	/**
	 * The cached value of the '{@link #getVarId() <em>Var Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarId()
	 * @generated
	 * @ordered
	 */
	protected qualId varId;

	/**
	 * The cached value of the '{@link #getVarInit() <em>Var Init</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarInit()
	 * @generated
	 * @ordered
	 */
	protected expression varInit;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected forStmtImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.FOR_STMT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public qualId getVarId() {
		return varId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVarId(qualId newVarId, NotificationChain msgs) {
		qualId oldVarId = varId;
		varId = newVarId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.FOR_STMT__VAR_ID, oldVarId, newVarId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarId(qualId newVarId) {
		if (newVarId != varId) {
			NotificationChain msgs = null;
			if (varId != null)
				msgs = ((InternalEObject)varId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FOR_STMT__VAR_ID, null, msgs);
			if (newVarId != null)
				msgs = ((InternalEObject)newVarId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FOR_STMT__VAR_ID, null, msgs);
			msgs = basicSetVarId(newVarId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.FOR_STMT__VAR_ID, newVarId, newVarId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public expression getVarInit() {
		return varInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVarInit(expression newVarInit, NotificationChain msgs) {
		expression oldVarInit = varInit;
		varInit = newVarInit;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.FOR_STMT__VAR_INIT, oldVarInit, newVarInit);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarInit(expression newVarInit) {
		if (newVarInit != varInit) {
			NotificationChain msgs = null;
			if (varInit != null)
				msgs = ((InternalEObject)varInit).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FOR_STMT__VAR_INIT, null, msgs);
			if (newVarInit != null)
				msgs = ((InternalEObject)newVarInit).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.FOR_STMT__VAR_INIT, null, msgs);
			msgs = basicSetVarInit(newVarInit, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.FOR_STMT__VAR_INIT, newVarInit, newVarInit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.FOR_STMT__VAR_ID:
				return basicSetVarId(null, msgs);
			case DelphiPackage.FOR_STMT__VAR_INIT:
				return basicSetVarInit(null, msgs);
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
			case DelphiPackage.FOR_STMT__VAR_ID:
				return getVarId();
			case DelphiPackage.FOR_STMT__VAR_INIT:
				return getVarInit();
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
			case DelphiPackage.FOR_STMT__VAR_ID:
				setVarId((qualId)newValue);
				return;
			case DelphiPackage.FOR_STMT__VAR_INIT:
				setVarInit((expression)newValue);
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
			case DelphiPackage.FOR_STMT__VAR_ID:
				setVarId((qualId)null);
				return;
			case DelphiPackage.FOR_STMT__VAR_INIT:
				setVarInit((expression)null);
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
			case DelphiPackage.FOR_STMT__VAR_ID:
				return varId != null;
			case DelphiPackage.FOR_STMT__VAR_INIT:
				return varInit != null;
		}
		return super.eIsSet(featureID);
	}


} //forStmtImpl
