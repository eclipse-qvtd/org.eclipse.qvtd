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
import delphi.exceptionBlock;
import delphi.ident;
import delphi.statement;
import delphi.stmtList;
import delphi.type;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>exception Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.exceptionBlockImpl#getExceptionId <em>Exception Id</em>}</li>
 *   <li>{@link delphi.impl.exceptionBlockImpl#getType <em>Type</em>}</li>
 *   <li>{@link delphi.impl.exceptionBlockImpl#getDoStmt <em>Do Stmt</em>}</li>
 *   <li>{@link delphi.impl.exceptionBlockImpl#getElseStmts <em>Else Stmts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class exceptionBlockImpl extends CSTraceImpl implements exceptionBlock {
	/**
	 * The cached value of the '{@link #getExceptionId() <em>Exception Id</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExceptionId()
	 * @generated
	 * @ordered
	 */
	protected EList<ident> exceptionId;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EList<type> type;

	/**
	 * The cached value of the '{@link #getDoStmt() <em>Do Stmt</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDoStmt()
	 * @generated
	 * @ordered
	 */
	protected EList<statement> doStmt;

	/**
	 * The cached value of the '{@link #getElseStmts() <em>Else Stmts</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseStmts()
	 * @generated
	 * @ordered
	 */
	protected stmtList elseStmts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected exceptionBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.EXCEPTION_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ident> getExceptionId() {
		if (exceptionId == null) {
			exceptionId = new EObjectContainmentEList<ident>(ident.class, this, DelphiPackage.EXCEPTION_BLOCK__EXCEPTION_ID);
		}
		return exceptionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<type> getType() {
		if (type == null) {
			type = new EObjectContainmentEList<type>(type.class, this, DelphiPackage.EXCEPTION_BLOCK__TYPE);
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<statement> getDoStmt() {
		if (doStmt == null) {
			doStmt = new EObjectContainmentEList<statement>(statement.class, this, DelphiPackage.EXCEPTION_BLOCK__DO_STMT);
		}
		return doStmt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public stmtList getElseStmts() {
		return elseStmts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseStmts(stmtList newElseStmts, NotificationChain msgs) {
		stmtList oldElseStmts = elseStmts;
		elseStmts = newElseStmts;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.EXCEPTION_BLOCK__ELSE_STMTS, oldElseStmts, newElseStmts);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseStmts(stmtList newElseStmts) {
		if (newElseStmts != elseStmts) {
			NotificationChain msgs = null;
			if (elseStmts != null)
				msgs = ((InternalEObject)elseStmts).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.EXCEPTION_BLOCK__ELSE_STMTS, null, msgs);
			if (newElseStmts != null)
				msgs = ((InternalEObject)newElseStmts).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.EXCEPTION_BLOCK__ELSE_STMTS, null, msgs);
			msgs = basicSetElseStmts(newElseStmts, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.EXCEPTION_BLOCK__ELSE_STMTS, newElseStmts, newElseStmts));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.EXCEPTION_BLOCK__EXCEPTION_ID:
				return ((InternalEList<?>)getExceptionId()).basicRemove(otherEnd, msgs);
			case DelphiPackage.EXCEPTION_BLOCK__TYPE:
				return ((InternalEList<?>)getType()).basicRemove(otherEnd, msgs);
			case DelphiPackage.EXCEPTION_BLOCK__DO_STMT:
				return ((InternalEList<?>)getDoStmt()).basicRemove(otherEnd, msgs);
			case DelphiPackage.EXCEPTION_BLOCK__ELSE_STMTS:
				return basicSetElseStmts(null, msgs);
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
			case DelphiPackage.EXCEPTION_BLOCK__EXCEPTION_ID:
				return getExceptionId();
			case DelphiPackage.EXCEPTION_BLOCK__TYPE:
				return getType();
			case DelphiPackage.EXCEPTION_BLOCK__DO_STMT:
				return getDoStmt();
			case DelphiPackage.EXCEPTION_BLOCK__ELSE_STMTS:
				return getElseStmts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DelphiPackage.EXCEPTION_BLOCK__EXCEPTION_ID:
				getExceptionId().clear();
				getExceptionId().addAll((Collection<? extends ident>)newValue);
				return;
			case DelphiPackage.EXCEPTION_BLOCK__TYPE:
				getType().clear();
				getType().addAll((Collection<? extends type>)newValue);
				return;
			case DelphiPackage.EXCEPTION_BLOCK__DO_STMT:
				getDoStmt().clear();
				getDoStmt().addAll((Collection<? extends statement>)newValue);
				return;
			case DelphiPackage.EXCEPTION_BLOCK__ELSE_STMTS:
				setElseStmts((stmtList)newValue);
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
			case DelphiPackage.EXCEPTION_BLOCK__EXCEPTION_ID:
				getExceptionId().clear();
				return;
			case DelphiPackage.EXCEPTION_BLOCK__TYPE:
				getType().clear();
				return;
			case DelphiPackage.EXCEPTION_BLOCK__DO_STMT:
				getDoStmt().clear();
				return;
			case DelphiPackage.EXCEPTION_BLOCK__ELSE_STMTS:
				setElseStmts((stmtList)null);
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
			case DelphiPackage.EXCEPTION_BLOCK__EXCEPTION_ID:
				return exceptionId != null && !exceptionId.isEmpty();
			case DelphiPackage.EXCEPTION_BLOCK__TYPE:
				return type != null && !type.isEmpty();
			case DelphiPackage.EXCEPTION_BLOCK__DO_STMT:
				return doStmt != null && !doStmt.isEmpty();
			case DelphiPackage.EXCEPTION_BLOCK__ELSE_STMTS:
				return elseStmts != null;
		}
		return super.eIsSet(featureID);
	}


} //exceptionBlockImpl
