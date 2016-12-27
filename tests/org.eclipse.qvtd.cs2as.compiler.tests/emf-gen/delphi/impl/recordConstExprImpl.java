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
import delphi.constExpr;
import delphi.ident;
import delphi.recordConstExpr;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>record Const Expr</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.recordConstExprImpl#getId <em>Id</em>}</li>
 *   <li>{@link delphi.impl.recordConstExprImpl#getConstExp <em>Const Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class recordConstExprImpl extends CSTraceImpl implements recordConstExpr {
	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected ident id;

	/**
	 * The cached value of the '{@link #getConstExp() <em>Const Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstExp()
	 * @generated
	 * @ordered
	 */
	protected constExpr constExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected recordConstExprImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.RECORD_CONST_EXPR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ident getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetId(ident newId, NotificationChain msgs) {
		ident oldId = id;
		id = newId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.RECORD_CONST_EXPR__ID, oldId, newId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(ident newId) {
		if (newId != id) {
			NotificationChain msgs = null;
			if (id != null)
				msgs = ((InternalEObject)id).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.RECORD_CONST_EXPR__ID, null, msgs);
			if (newId != null)
				msgs = ((InternalEObject)newId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.RECORD_CONST_EXPR__ID, null, msgs);
			msgs = basicSetId(newId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.RECORD_CONST_EXPR__ID, newId, newId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constExpr getConstExp() {
		return constExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConstExp(constExpr newConstExp, NotificationChain msgs) {
		constExpr oldConstExp = constExp;
		constExp = newConstExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.RECORD_CONST_EXPR__CONST_EXP, oldConstExp, newConstExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConstExp(constExpr newConstExp) {
		if (newConstExp != constExp) {
			NotificationChain msgs = null;
			if (constExp != null)
				msgs = ((InternalEObject)constExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.RECORD_CONST_EXPR__CONST_EXP, null, msgs);
			if (newConstExp != null)
				msgs = ((InternalEObject)newConstExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.RECORD_CONST_EXPR__CONST_EXP, null, msgs);
			msgs = basicSetConstExp(newConstExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.RECORD_CONST_EXPR__CONST_EXP, newConstExp, newConstExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.RECORD_CONST_EXPR__ID:
				return basicSetId(null, msgs);
			case DelphiPackage.RECORD_CONST_EXPR__CONST_EXP:
				return basicSetConstExp(null, msgs);
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
			case DelphiPackage.RECORD_CONST_EXPR__ID:
				return getId();
			case DelphiPackage.RECORD_CONST_EXPR__CONST_EXP:
				return getConstExp();
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
			case DelphiPackage.RECORD_CONST_EXPR__ID:
				setId((ident)newValue);
				return;
			case DelphiPackage.RECORD_CONST_EXPR__CONST_EXP:
				setConstExp((constExpr)newValue);
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
			case DelphiPackage.RECORD_CONST_EXPR__ID:
				setId((ident)null);
				return;
			case DelphiPackage.RECORD_CONST_EXPR__CONST_EXP:
				setConstExp((constExpr)null);
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
			case DelphiPackage.RECORD_CONST_EXPR__ID:
				return id != null;
			case DelphiPackage.RECORD_CONST_EXPR__CONST_EXP:
				return constExp != null;
		}
		return super.eIsSet(featureID);
	}


} //recordConstExprImpl
