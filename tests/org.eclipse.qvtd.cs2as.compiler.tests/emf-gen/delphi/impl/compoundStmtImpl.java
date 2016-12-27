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
import delphi.compoundStmt;
import delphi.stmtList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>compound Stmt</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.compoundStmtImpl#getStamtList <em>Stamt List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class compoundStmtImpl extends structStmtImpl implements compoundStmt {
	/**
	 * The cached value of the '{@link #getStamtList() <em>Stamt List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStamtList()
	 * @generated
	 * @ordered
	 */
	protected stmtList stamtList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected compoundStmtImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.COMPOUND_STMT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public stmtList getStamtList() {
		return stamtList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStamtList(stmtList newStamtList, NotificationChain msgs) {
		stmtList oldStamtList = stamtList;
		stamtList = newStamtList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.COMPOUND_STMT__STAMT_LIST, oldStamtList, newStamtList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStamtList(stmtList newStamtList) {
		if (newStamtList != stamtList) {
			NotificationChain msgs = null;
			if (stamtList != null)
				msgs = ((InternalEObject)stamtList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.COMPOUND_STMT__STAMT_LIST, null, msgs);
			if (newStamtList != null)
				msgs = ((InternalEObject)newStamtList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.COMPOUND_STMT__STAMT_LIST, null, msgs);
			msgs = basicSetStamtList(newStamtList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.COMPOUND_STMT__STAMT_LIST, newStamtList, newStamtList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.COMPOUND_STMT__STAMT_LIST:
				return basicSetStamtList(null, msgs);
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
			case DelphiPackage.COMPOUND_STMT__STAMT_LIST:
				return getStamtList();
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
			case DelphiPackage.COMPOUND_STMT__STAMT_LIST:
				setStamtList((stmtList)newValue);
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
			case DelphiPackage.COMPOUND_STMT__STAMT_LIST:
				setStamtList((stmtList)null);
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
			case DelphiPackage.COMPOUND_STMT__STAMT_LIST:
				return stamtList != null;
		}
		return super.eIsSet(featureID);
	}


} //compoundStmtImpl
