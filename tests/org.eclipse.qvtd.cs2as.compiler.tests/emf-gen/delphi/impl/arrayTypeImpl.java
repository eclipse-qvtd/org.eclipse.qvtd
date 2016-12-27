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
import delphi.arrayType;
import delphi.ordinalType;
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
 * An implementation of the model object '<em><b>array Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.arrayTypeImpl#getOrdinalType <em>Ordinal Type</em>}</li>
 *   <li>{@link delphi.impl.arrayTypeImpl#getOrdinalTyp <em>Ordinal Typ</em>}</li>
 *   <li>{@link delphi.impl.arrayTypeImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class arrayTypeImpl extends strucTypeImpl implements arrayType {
	/**
	 * The cached value of the '{@link #getOrdinalType() <em>Ordinal Type</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrdinalType()
	 * @generated
	 * @ordered
	 */
	protected EList<ordinalType> ordinalType;

	/**
	 * The cached value of the '{@link #getOrdinalTyp() <em>Ordinal Typ</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrdinalTyp()
	 * @generated
	 * @ordered
	 */
	protected EList<ordinalType> ordinalTyp;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected arrayTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.ARRAY_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ordinalType> getOrdinalType() {
		if (ordinalType == null) {
			ordinalType = new EObjectContainmentEList<ordinalType>(ordinalType.class, this, DelphiPackage.ARRAY_TYPE__ORDINAL_TYPE);
		}
		return ordinalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ordinalType> getOrdinalTyp() {
		if (ordinalTyp == null) {
			ordinalTyp = new EObjectContainmentEList<ordinalType>(ordinalType.class, this, DelphiPackage.ARRAY_TYPE__ORDINAL_TYP);
		}
		return ordinalTyp;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.ARRAY_TYPE__TYPE, oldType, newType);
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
				msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.ARRAY_TYPE__TYPE, null, msgs);
			if (newType != null)
				msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.ARRAY_TYPE__TYPE, null, msgs);
			msgs = basicSetType(newType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.ARRAY_TYPE__TYPE, newType, newType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.ARRAY_TYPE__ORDINAL_TYPE:
				return ((InternalEList<?>)getOrdinalType()).basicRemove(otherEnd, msgs);
			case DelphiPackage.ARRAY_TYPE__ORDINAL_TYP:
				return ((InternalEList<?>)getOrdinalTyp()).basicRemove(otherEnd, msgs);
			case DelphiPackage.ARRAY_TYPE__TYPE:
				return basicSetType(null, msgs);
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
			case DelphiPackage.ARRAY_TYPE__ORDINAL_TYPE:
				return getOrdinalType();
			case DelphiPackage.ARRAY_TYPE__ORDINAL_TYP:
				return getOrdinalTyp();
			case DelphiPackage.ARRAY_TYPE__TYPE:
				return getType();
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
			case DelphiPackage.ARRAY_TYPE__ORDINAL_TYPE:
				getOrdinalType().clear();
				getOrdinalType().addAll((Collection<? extends ordinalType>)newValue);
				return;
			case DelphiPackage.ARRAY_TYPE__ORDINAL_TYP:
				getOrdinalTyp().clear();
				getOrdinalTyp().addAll((Collection<? extends ordinalType>)newValue);
				return;
			case DelphiPackage.ARRAY_TYPE__TYPE:
				setType((type)newValue);
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
			case DelphiPackage.ARRAY_TYPE__ORDINAL_TYPE:
				getOrdinalType().clear();
				return;
			case DelphiPackage.ARRAY_TYPE__ORDINAL_TYP:
				getOrdinalTyp().clear();
				return;
			case DelphiPackage.ARRAY_TYPE__TYPE:
				setType((type)null);
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
			case DelphiPackage.ARRAY_TYPE__ORDINAL_TYPE:
				return ordinalType != null && !ordinalType.isEmpty();
			case DelphiPackage.ARRAY_TYPE__ORDINAL_TYP:
				return ordinalTyp != null && !ordinalTyp.isEmpty();
			case DelphiPackage.ARRAY_TYPE__TYPE:
				return type != null;
		}
		return super.eIsSet(featureID);
	}


} //arrayTypeImpl
