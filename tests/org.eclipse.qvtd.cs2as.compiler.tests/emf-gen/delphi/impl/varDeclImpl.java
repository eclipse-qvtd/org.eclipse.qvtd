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
import delphi.identList;
import delphi.type;
import delphi.varDecl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>var Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.varDeclImpl#getIdList <em>Id List</em>}</li>
 *   <li>{@link delphi.impl.varDeclImpl#getType <em>Type</em>}</li>
 *   <li>{@link delphi.impl.varDeclImpl#getAbsId <em>Abs Id</em>}</li>
 *   <li>{@link delphi.impl.varDeclImpl#getAbsConst <em>Abs Const</em>}</li>
 *   <li>{@link delphi.impl.varDeclImpl#getAbsIniti <em>Abs Initi</em>}</li>
 * </ul>
 *
 * @generated
 */
public class varDeclImpl extends CSTraceImpl implements varDecl {
	/**
	 * The cached value of the '{@link #getIdList() <em>Id List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdList()
	 * @generated
	 * @ordered
	 */
	protected identList idList;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected type type;

	/**
	 * The cached value of the '{@link #getAbsId() <em>Abs Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsId()
	 * @generated
	 * @ordered
	 */
	protected ident absId;

	/**
	 * The cached value of the '{@link #getAbsConst() <em>Abs Const</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsConst()
	 * @generated
	 * @ordered
	 */
	protected constExpr absConst;

	/**
	 * The cached value of the '{@link #getAbsIniti() <em>Abs Initi</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbsIniti()
	 * @generated
	 * @ordered
	 */
	protected constExpr absIniti;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected varDeclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.VAR_DECL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public identList getIdList() {
		return idList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdList(identList newIdList, NotificationChain msgs) {
		identList oldIdList = idList;
		idList = newIdList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.VAR_DECL__ID_LIST, oldIdList, newIdList);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdList(identList newIdList) {
		if (newIdList != idList) {
			NotificationChain msgs = null;
			if (idList != null)
				msgs = ((InternalEObject)idList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.VAR_DECL__ID_LIST, null, msgs);
			if (newIdList != null)
				msgs = ((InternalEObject)newIdList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.VAR_DECL__ID_LIST, null, msgs);
			msgs = basicSetIdList(newIdList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.VAR_DECL__ID_LIST, newIdList, newIdList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public type getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetType(type newType, NotificationChain msgs) {
		type oldType = type;
		type = newType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.VAR_DECL__TYPE, oldType, newType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(type newType) {
		if (newType != type) {
			NotificationChain msgs = null;
			if (type != null)
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.VAR_DECL__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.VAR_DECL__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.VAR_DECL__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ident getAbsId() {
		return absId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAbsId(ident newAbsId, NotificationChain msgs) {
		ident oldAbsId = absId;
		absId = newAbsId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.VAR_DECL__ABS_ID, oldAbsId, newAbsId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbsId(ident newAbsId) {
		if (newAbsId != absId) {
			NotificationChain msgs = null;
			if (absId != null)
				msgs = ((InternalEObject)absId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.VAR_DECL__ABS_ID, null, msgs);
			if (newAbsId != null)
				msgs = ((InternalEObject)newAbsId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.VAR_DECL__ABS_ID, null, msgs);
			msgs = basicSetAbsId(newAbsId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.VAR_DECL__ABS_ID, newAbsId, newAbsId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constExpr getAbsConst() {
		return absConst;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAbsConst(constExpr newAbsConst, NotificationChain msgs) {
		constExpr oldAbsConst = absConst;
		absConst = newAbsConst;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.VAR_DECL__ABS_CONST, oldAbsConst, newAbsConst);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbsConst(constExpr newAbsConst) {
		if (newAbsConst != absConst) {
			NotificationChain msgs = null;
			if (absConst != null)
				msgs = ((InternalEObject)absConst).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.VAR_DECL__ABS_CONST, null, msgs);
			if (newAbsConst != null)
				msgs = ((InternalEObject)newAbsConst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.VAR_DECL__ABS_CONST, null, msgs);
			msgs = basicSetAbsConst(newAbsConst, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.VAR_DECL__ABS_CONST, newAbsConst, newAbsConst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constExpr getAbsIniti() {
		return absIniti;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAbsIniti(constExpr newAbsIniti, NotificationChain msgs) {
		constExpr oldAbsIniti = absIniti;
		absIniti = newAbsIniti;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.VAR_DECL__ABS_INITI, oldAbsIniti, newAbsIniti);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbsIniti(constExpr newAbsIniti) {
		if (newAbsIniti != absIniti) {
			NotificationChain msgs = null;
			if (absIniti != null)
				msgs = ((InternalEObject)absIniti).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.VAR_DECL__ABS_INITI, null, msgs);
			if (newAbsIniti != null)
				msgs = ((InternalEObject)newAbsIniti).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.VAR_DECL__ABS_INITI, null, msgs);
			msgs = basicSetAbsIniti(newAbsIniti, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.VAR_DECL__ABS_INITI, newAbsIniti, newAbsIniti));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.VAR_DECL__ID_LIST:
				return basicSetIdList(null, msgs);
			case DelphiPackage.VAR_DECL__TYPE:
				return basicSetType(null, msgs);
			case DelphiPackage.VAR_DECL__ABS_ID:
				return basicSetAbsId(null, msgs);
			case DelphiPackage.VAR_DECL__ABS_CONST:
				return basicSetAbsConst(null, msgs);
			case DelphiPackage.VAR_DECL__ABS_INITI:
				return basicSetAbsIniti(null, msgs);
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
			case DelphiPackage.VAR_DECL__ID_LIST:
				return getIdList();
			case DelphiPackage.VAR_DECL__TYPE:
				return getType();
			case DelphiPackage.VAR_DECL__ABS_ID:
				return getAbsId();
			case DelphiPackage.VAR_DECL__ABS_CONST:
				return getAbsConst();
			case DelphiPackage.VAR_DECL__ABS_INITI:
				return getAbsIniti();
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
			case DelphiPackage.VAR_DECL__ID_LIST:
				setIdList((identList)newValue);
				return;
			case DelphiPackage.VAR_DECL__TYPE:
				setType((type)newValue);
				return;
			case DelphiPackage.VAR_DECL__ABS_ID:
				setAbsId((ident)newValue);
				return;
			case DelphiPackage.VAR_DECL__ABS_CONST:
				setAbsConst((constExpr)newValue);
				return;
			case DelphiPackage.VAR_DECL__ABS_INITI:
				setAbsIniti((constExpr)newValue);
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
			case DelphiPackage.VAR_DECL__ID_LIST:
				setIdList((identList)null);
				return;
			case DelphiPackage.VAR_DECL__TYPE:
				setType((type)null);
				return;
			case DelphiPackage.VAR_DECL__ABS_ID:
				setAbsId((ident)null);
				return;
			case DelphiPackage.VAR_DECL__ABS_CONST:
				setAbsConst((constExpr)null);
				return;
			case DelphiPackage.VAR_DECL__ABS_INITI:
				setAbsIniti((constExpr)null);
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
			case DelphiPackage.VAR_DECL__ID_LIST:
				return idList != null;
			case DelphiPackage.VAR_DECL__TYPE:
				return type != null;
			case DelphiPackage.VAR_DECL__ABS_ID:
				return absId != null;
			case DelphiPackage.VAR_DECL__ABS_CONST:
				return absConst != null;
			case DelphiPackage.VAR_DECL__ABS_INITI:
				return absIniti != null;
		}
		return super.eIsSet(featureID);
	}


} //varDeclImpl
