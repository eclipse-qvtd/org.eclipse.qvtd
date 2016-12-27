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
import delphi.initSection;
import delphi.stmtList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>init Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.initSectionImpl#getStmtList <em>Stmt List</em>}</li>
 *   <li>{@link delphi.impl.initSectionImpl#getEndStmtList <em>End Stmt List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class initSectionImpl extends CSTraceImpl implements initSection {
	/**
	 * The cached value of the '{@link #getStmtList() <em>Stmt List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStmtList()
	 * @generated
	 * @ordered
	 */
	protected stmtList stmtList;

	/**
	 * The cached value of the '{@link #getEndStmtList() <em>End Stmt List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndStmtList()
	 * @generated
	 * @ordered
	 */
	protected stmtList endStmtList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected initSectionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.INIT_SECTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public stmtList getStmtList() {
		return stmtList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStmtList(stmtList newStmtList, NotificationChain msgs) {
		stmtList oldStmtList = stmtList;
		stmtList = newStmtList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.INIT_SECTION__STMT_LIST, oldStmtList, newStmtList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStmtList(stmtList newStmtList) {
		if (newStmtList != stmtList) {
			NotificationChain msgs = null;
			if (stmtList != null)
				msgs = ((InternalEObject)stmtList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.INIT_SECTION__STMT_LIST, null, msgs);
			if (newStmtList != null)
				msgs = ((InternalEObject)newStmtList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.INIT_SECTION__STMT_LIST, null, msgs);
			msgs = basicSetStmtList(newStmtList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.INIT_SECTION__STMT_LIST, newStmtList, newStmtList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public stmtList getEndStmtList() {
		return endStmtList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEndStmtList(stmtList newEndStmtList, NotificationChain msgs) {
		stmtList oldEndStmtList = endStmtList;
		endStmtList = newEndStmtList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.INIT_SECTION__END_STMT_LIST, oldEndStmtList, newEndStmtList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndStmtList(stmtList newEndStmtList) {
		if (newEndStmtList != endStmtList) {
			NotificationChain msgs = null;
			if (endStmtList != null)
				msgs = ((InternalEObject)endStmtList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.INIT_SECTION__END_STMT_LIST, null, msgs);
			if (newEndStmtList != null)
				msgs = ((InternalEObject)newEndStmtList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.INIT_SECTION__END_STMT_LIST, null, msgs);
			msgs = basicSetEndStmtList(newEndStmtList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.INIT_SECTION__END_STMT_LIST, newEndStmtList, newEndStmtList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.INIT_SECTION__STMT_LIST:
				return basicSetStmtList(null, msgs);
			case DelphiPackage.INIT_SECTION__END_STMT_LIST:
				return basicSetEndStmtList(null, msgs);
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
			case DelphiPackage.INIT_SECTION__STMT_LIST:
				return getStmtList();
			case DelphiPackage.INIT_SECTION__END_STMT_LIST:
				return getEndStmtList();
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
			case DelphiPackage.INIT_SECTION__STMT_LIST:
				setStmtList((stmtList)newValue);
				return;
			case DelphiPackage.INIT_SECTION__END_STMT_LIST:
				setEndStmtList((stmtList)newValue);
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
			case DelphiPackage.INIT_SECTION__STMT_LIST:
				setStmtList((stmtList)null);
				return;
			case DelphiPackage.INIT_SECTION__END_STMT_LIST:
				setEndStmtList((stmtList)null);
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
			case DelphiPackage.INIT_SECTION__STMT_LIST:
				return stmtList != null;
			case DelphiPackage.INIT_SECTION__END_STMT_LIST:
				return endStmtList != null;
		}
		return super.eIsSet(featureID);
	}


} //initSectionImpl
