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
import delphi.constantDecl;
import delphi.ident;
import delphi.typeId;
import delphi.typedConstant;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>constant Decl</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.constantDeclImpl#getId <em>Id</em>}</li>
 *   <li>{@link delphi.impl.constantDeclImpl#getConst <em>Const</em>}</li>
 *   <li>{@link delphi.impl.constantDeclImpl#getPort <em>Port</em>}</li>
 *   <li>{@link delphi.impl.constantDeclImpl#getTypeRef <em>Type Ref</em>}</li>
 *   <li>{@link delphi.impl.constantDeclImpl#getTypedConstat <em>Typed Constat</em>}</li>
 * </ul>
 *
 * @generated
 */
public class constantDeclImpl extends CSTraceImpl implements constantDecl {
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
	 * The cached value of the '{@link #getConst() <em>Const</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConst()
	 * @generated
	 * @ordered
	 */
	protected constExpr const_;

	/**
	 * The default value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected static final String PORT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPort() <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPort()
	 * @generated
	 * @ordered
	 */
	protected String port = PORT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTypeRef() <em>Type Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeRef()
	 * @generated
	 * @ordered
	 */
	protected typeId typeRef;

	/**
	 * The cached value of the '{@link #getTypedConstat() <em>Typed Constat</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypedConstat()
	 * @generated
	 * @ordered
	 */
	protected typedConstant typedConstat;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected constantDeclImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.CONSTANT_DECL;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.CONSTANT_DECL__ID, oldId, newId);
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
				msgs = ((InternalEObject)id).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CONSTANT_DECL__ID, null, msgs);
			if (newId != null)
				msgs = ((InternalEObject)newId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CONSTANT_DECL__ID, null, msgs);
			msgs = basicSetId(newId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.CONSTANT_DECL__ID, newId, newId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constExpr getConst() {
		return const_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConst(constExpr newConst, NotificationChain msgs) {
		constExpr oldConst = const_;
		const_ = newConst;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.CONSTANT_DECL__CONST, oldConst, newConst);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConst(constExpr newConst) {
		if (newConst != const_) {
			NotificationChain msgs = null;
			if (const_ != null)
				msgs = ((InternalEObject)const_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CONSTANT_DECL__CONST, null, msgs);
			if (newConst != null)
				msgs = ((InternalEObject)newConst).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CONSTANT_DECL__CONST, null, msgs);
			msgs = basicSetConst(newConst, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.CONSTANT_DECL__CONST, newConst, newConst));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPort() {
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPort(String newPort) {
		String oldPort = port;
		port = newPort;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.CONSTANT_DECL__PORT, oldPort, port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public typeId getTypeRef() {
		return typeRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeRef(typeId newTypeRef, NotificationChain msgs) {
		typeId oldTypeRef = typeRef;
		typeRef = newTypeRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.CONSTANT_DECL__TYPE_REF, oldTypeRef, newTypeRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeRef(typeId newTypeRef) {
		if (newTypeRef != typeRef) {
			NotificationChain msgs = null;
			if (typeRef != null)
				msgs = ((InternalEObject)typeRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CONSTANT_DECL__TYPE_REF, null, msgs);
			if (newTypeRef != null)
				msgs = ((InternalEObject)newTypeRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CONSTANT_DECL__TYPE_REF, null, msgs);
			msgs = basicSetTypeRef(newTypeRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.CONSTANT_DECL__TYPE_REF, newTypeRef, newTypeRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public typedConstant getTypedConstat() {
		return typedConstat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypedConstat(typedConstant newTypedConstat, NotificationChain msgs) {
		typedConstant oldTypedConstat = typedConstat;
		typedConstat = newTypedConstat;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.CONSTANT_DECL__TYPED_CONSTAT, oldTypedConstat, newTypedConstat);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedConstat(typedConstant newTypedConstat) {
		if (newTypedConstat != typedConstat) {
			NotificationChain msgs = null;
			if (typedConstat != null)
				msgs = ((InternalEObject)typedConstat).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CONSTANT_DECL__TYPED_CONSTAT, null, msgs);
			if (newTypedConstat != null)
				msgs = ((InternalEObject)newTypedConstat).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.CONSTANT_DECL__TYPED_CONSTAT, null, msgs);
			msgs = basicSetTypedConstat(newTypedConstat, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.CONSTANT_DECL__TYPED_CONSTAT, newTypedConstat, newTypedConstat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.CONSTANT_DECL__ID:
				return basicSetId(null, msgs);
			case DelphiPackage.CONSTANT_DECL__CONST:
				return basicSetConst(null, msgs);
			case DelphiPackage.CONSTANT_DECL__TYPE_REF:
				return basicSetTypeRef(null, msgs);
			case DelphiPackage.CONSTANT_DECL__TYPED_CONSTAT:
				return basicSetTypedConstat(null, msgs);
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
			case DelphiPackage.CONSTANT_DECL__ID:
				return getId();
			case DelphiPackage.CONSTANT_DECL__CONST:
				return getConst();
			case DelphiPackage.CONSTANT_DECL__PORT:
				return getPort();
			case DelphiPackage.CONSTANT_DECL__TYPE_REF:
				return getTypeRef();
			case DelphiPackage.CONSTANT_DECL__TYPED_CONSTAT:
				return getTypedConstat();
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
			case DelphiPackage.CONSTANT_DECL__ID:
				setId((ident)newValue);
				return;
			case DelphiPackage.CONSTANT_DECL__CONST:
				setConst((constExpr)newValue);
				return;
			case DelphiPackage.CONSTANT_DECL__PORT:
				setPort((String)newValue);
				return;
			case DelphiPackage.CONSTANT_DECL__TYPE_REF:
				setTypeRef((typeId)newValue);
				return;
			case DelphiPackage.CONSTANT_DECL__TYPED_CONSTAT:
				setTypedConstat((typedConstant)newValue);
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
			case DelphiPackage.CONSTANT_DECL__ID:
				setId((ident)null);
				return;
			case DelphiPackage.CONSTANT_DECL__CONST:
				setConst((constExpr)null);
				return;
			case DelphiPackage.CONSTANT_DECL__PORT:
				setPort(PORT_EDEFAULT);
				return;
			case DelphiPackage.CONSTANT_DECL__TYPE_REF:
				setTypeRef((typeId)null);
				return;
			case DelphiPackage.CONSTANT_DECL__TYPED_CONSTAT:
				setTypedConstat((typedConstant)null);
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
			case DelphiPackage.CONSTANT_DECL__ID:
				return id != null;
			case DelphiPackage.CONSTANT_DECL__CONST:
				return const_ != null;
			case DelphiPackage.CONSTANT_DECL__PORT:
				return PORT_EDEFAULT == null ? port != null : !PORT_EDEFAULT.equals(port);
			case DelphiPackage.CONSTANT_DECL__TYPE_REF:
				return typeRef != null;
			case DelphiPackage.CONSTANT_DECL__TYPED_CONSTAT:
				return typedConstat != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (port: ");
		result.append(port);
		result.append(')');
		return result.toString();
	}


} //constantDeclImpl
