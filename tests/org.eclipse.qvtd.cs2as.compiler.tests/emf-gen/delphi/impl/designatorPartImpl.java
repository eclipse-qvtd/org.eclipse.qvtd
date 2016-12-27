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
import delphi.designatorPart;
import delphi.reservedWord;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>designator Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link delphi.impl.designatorPartImpl#getId <em>Id</em>}</li>
 *   <li>{@link delphi.impl.designatorPartImpl#getReservedWord <em>Reserved Word</em>}</li>
 *   <li>{@link delphi.impl.designatorPartImpl#getId2 <em>Id2</em>}</li>
 * </ul>
 *
 * @generated
 */
public class designatorPartImpl extends CSTraceImpl implements designatorPart {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getId2() <em>Id2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId2()
	 * @generated
	 * @ordered
	 */
	protected static final String ID2_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId2() <em>Id2</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId2()
	 * @generated
	 * @ordered
	 */
	protected String id2 = ID2_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected designatorPartImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DelphiPackage.Literals.DESIGNATOR_PART;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.DESIGNATOR_PART__ID, oldId, id));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DelphiPackage.DESIGNATOR_PART__RESERVED_WORD, oldReservedWord, newReservedWord);
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
				msgs = ((InternalEObject)reservedWord).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.DESIGNATOR_PART__RESERVED_WORD, null, msgs);
			if (newReservedWord != null)
				msgs = ((InternalEObject)newReservedWord).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DelphiPackage.DESIGNATOR_PART__RESERVED_WORD, null, msgs);
			msgs = basicSetReservedWord(newReservedWord, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.DESIGNATOR_PART__RESERVED_WORD, newReservedWord, newReservedWord));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId2() {
		return id2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId2(String newId2) {
		String oldId2 = id2;
		id2 = newId2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DelphiPackage.DESIGNATOR_PART__ID2, oldId2, id2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DelphiPackage.DESIGNATOR_PART__RESERVED_WORD:
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
			case DelphiPackage.DESIGNATOR_PART__ID:
				return getId();
			case DelphiPackage.DESIGNATOR_PART__RESERVED_WORD:
				return getReservedWord();
			case DelphiPackage.DESIGNATOR_PART__ID2:
				return getId2();
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
			case DelphiPackage.DESIGNATOR_PART__ID:
				setId((String)newValue);
				return;
			case DelphiPackage.DESIGNATOR_PART__RESERVED_WORD:
				setReservedWord((reservedWord)newValue);
				return;
			case DelphiPackage.DESIGNATOR_PART__ID2:
				setId2((String)newValue);
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
			case DelphiPackage.DESIGNATOR_PART__ID:
				setId(ID_EDEFAULT);
				return;
			case DelphiPackage.DESIGNATOR_PART__RESERVED_WORD:
				setReservedWord((reservedWord)null);
				return;
			case DelphiPackage.DESIGNATOR_PART__ID2:
				setId2(ID2_EDEFAULT);
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
			case DelphiPackage.DESIGNATOR_PART__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DelphiPackage.DESIGNATOR_PART__RESERVED_WORD:
				return reservedWord != null;
			case DelphiPackage.DESIGNATOR_PART__ID2:
				return ID2_EDEFAULT == null ? id2 != null : !ID2_EDEFAULT.equals(id2);
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
		result.append(" (id: ");
		result.append(id);
		result.append(", id2: ");
		result.append(id2);
		result.append(')');
		return result.toString();
	}


} //designatorPartImpl
