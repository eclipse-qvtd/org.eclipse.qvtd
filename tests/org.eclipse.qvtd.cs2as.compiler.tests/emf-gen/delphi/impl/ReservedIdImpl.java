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
import delphi.ReservedId;
import delphi.reservedWord;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reserved Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.ReservedIdImpl#getReservedWord <em>Reserved Word</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReservedIdImpl extends identImpl implements ReservedId {
	/**
	 * The cached value of the '{@link #getReservedWord() <em>Reserved Word</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReservedWord()
	 * @generated
	 * @ordered
	 */
	protected reservedWord reservedWord;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReservedIdImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.RESERVED_ID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public reservedWord getReservedWord() {
		return reservedWord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReservedWord(reservedWord newReservedWord, NotificationChain msgs) {
		reservedWord oldReservedWord = reservedWord;
		reservedWord = newReservedWord;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.RESERVED_ID__RESERVED_WORD, oldReservedWord, newReservedWord);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReservedWord(reservedWord newReservedWord) {
		if (newReservedWord != reservedWord) {
			NotificationChain msgs = null;
			if (reservedWord != null)
				msgs = ((InternalEObject)reservedWord).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.RESERVED_ID__RESERVED_WORD, null, msgs);
			if (newReservedWord != null)
				msgs = ((InternalEObject)newReservedWord).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.RESERVED_ID__RESERVED_WORD, null, msgs);
			msgs = basicSetReservedWord(newReservedWord, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.RESERVED_ID__RESERVED_WORD, newReservedWord, newReservedWord));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.RESERVED_ID__RESERVED_WORD:
				return basicSetReservedWord(null, msgs);
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
			case DelphiPackage.RESERVED_ID__RESERVED_WORD:
				return getReservedWord();
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
			case DelphiPackage.RESERVED_ID__RESERVED_WORD:
				setReservedWord((reservedWord)newValue);
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
			case DelphiPackage.RESERVED_ID__RESERVED_WORD:
				setReservedWord((reservedWord)null);
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
			case DelphiPackage.RESERVED_ID__RESERVED_WORD:
				return reservedWord != null;
		}
		return super.eIsSet(featureID);
	}


} //ReservedIdImpl
