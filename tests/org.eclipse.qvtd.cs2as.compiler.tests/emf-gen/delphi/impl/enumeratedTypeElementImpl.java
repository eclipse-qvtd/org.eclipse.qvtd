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
import delphi.enumeratedTypeElement;
import delphi.ident;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>enumerated Type Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.enumeratedTypeElementImpl#getId <em>Id</em>}</li>
 *   <li>{@link delphi.impl.enumeratedTypeElementImpl#getLiteralExp <em>Literal Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class enumeratedTypeElementImpl extends CSTraceImpl implements enumeratedTypeElement {
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
	 * The cached value of the '{@link #getLiteralExp() <em>Literal Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralExp()
	 * @generated
	 * @ordered
	 */
	protected constExpr literalExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected enumeratedTypeElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.ENUMERATED_TYPE_ELEMENT;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.ENUMERATED_TYPE_ELEMENT__ID, oldId, newId);
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
				msgs = ((InternalEObject)id).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.ENUMERATED_TYPE_ELEMENT__ID, null, msgs);
			if (newId != null)
				msgs = ((InternalEObject)newId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.ENUMERATED_TYPE_ELEMENT__ID, null, msgs);
			msgs = basicSetId(newId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.ENUMERATED_TYPE_ELEMENT__ID, newId, newId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public constExpr getLiteralExp() {
		return literalExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLiteralExp(constExpr newLiteralExp, NotificationChain msgs) {
		constExpr oldLiteralExp = literalExp;
		literalExp = newLiteralExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.ENUMERATED_TYPE_ELEMENT__LITERAL_EXP, oldLiteralExp, newLiteralExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiteralExp(constExpr newLiteralExp) {
		if (newLiteralExp != literalExp) {
			NotificationChain msgs = null;
			if (literalExp != null)
				msgs = ((InternalEObject)literalExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.ENUMERATED_TYPE_ELEMENT__LITERAL_EXP, null, msgs);
			if (newLiteralExp != null)
				msgs = ((InternalEObject)newLiteralExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.ENUMERATED_TYPE_ELEMENT__LITERAL_EXP, null, msgs);
			msgs = basicSetLiteralExp(newLiteralExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.ENUMERATED_TYPE_ELEMENT__LITERAL_EXP, newLiteralExp, newLiteralExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.ENUMERATED_TYPE_ELEMENT__ID:
				return basicSetId(null, msgs);
			case DelphiPackage.ENUMERATED_TYPE_ELEMENT__LITERAL_EXP:
				return basicSetLiteralExp(null, msgs);
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
			case DelphiPackage.ENUMERATED_TYPE_ELEMENT__ID:
				return getId();
			case DelphiPackage.ENUMERATED_TYPE_ELEMENT__LITERAL_EXP:
				return getLiteralExp();
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
			case DelphiPackage.ENUMERATED_TYPE_ELEMENT__ID:
				setId((ident)newValue);
				return;
			case DelphiPackage.ENUMERATED_TYPE_ELEMENT__LITERAL_EXP:
				setLiteralExp((constExpr)newValue);
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
			case DelphiPackage.ENUMERATED_TYPE_ELEMENT__ID:
				setId((ident)null);
				return;
			case DelphiPackage.ENUMERATED_TYPE_ELEMENT__LITERAL_EXP:
				setLiteralExp((constExpr)null);
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
			case DelphiPackage.ENUMERATED_TYPE_ELEMENT__ID:
				return id != null;
			case DelphiPackage.ENUMERATED_TYPE_ELEMENT__LITERAL_EXP:
				return literalExp != null;
		}
		return super.eIsSet(featureID);
	}


} //enumeratedTypeElementImpl
