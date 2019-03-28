/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example2.classescs.impl;

import example2.classescs.ClassescsPackage;
import example2.classescs.NameExpCS;
import example2.classescs.PathNameCS;
import example2.classescs.RoundedBracketClause;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Name Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example2.classescs.impl.NameExpCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link example2.classescs.impl.NameExpCSImpl#getRoundedBrackets <em>Rounded Brackets</em>}</li>
 *   <li>{@link example2.classescs.impl.NameExpCSImpl#getOwnedNameExp <em>Owned Name Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NameExpCSImpl extends ElementCSImpl implements NameExpCS {
	/**
	 * The number of structural features of the '<em>Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAME_EXP_CS_FEATURE_COUNT = ElementCSImpl.ELEMENT_CS_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Name Exp CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAME_EXP_CS_OPERATION_COUNT = ElementCSImpl.ELEMENT_CS_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS name;

	/**
	 * The cached value of the '{@link #getRoundedBrackets() <em>Rounded Brackets</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoundedBrackets()
	 * @generated
	 * @ordered
	 */
	protected RoundedBracketClause roundedBrackets;

	/**
	 * The cached value of the '{@link #getOwnedNameExp() <em>Owned Name Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedNameExp()
	 * @generated
	 * @ordered
	 */
	protected NameExpCS ownedNameExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NameExpCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassescsPackage.Literals.NAME_EXP_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathNameCS getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetName(PathNameCS newName, NotificationChain msgs) {
		PathNameCS oldName = name;
		name = newName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 1, oldName, newName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(PathNameCS newName) {
		if (newName != name) {
			NotificationChain msgs = null;
			if (name != null)
				msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (1), null, msgs);
			if (newName != null)
				msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (1), null, msgs);
			msgs = basicSetName(newName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 1, newName, newName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RoundedBracketClause getRoundedBrackets() {
		return roundedBrackets;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRoundedBrackets(RoundedBracketClause newRoundedBrackets, NotificationChain msgs) {
		RoundedBracketClause oldRoundedBrackets = roundedBrackets;
		roundedBrackets = newRoundedBrackets;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 2, oldRoundedBrackets, newRoundedBrackets);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRoundedBrackets(RoundedBracketClause newRoundedBrackets) {
		if (newRoundedBrackets != roundedBrackets) {
			NotificationChain msgs = null;
			if (roundedBrackets != null)
				msgs = ((InternalEObject)roundedBrackets).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (2), null, msgs);
			if (newRoundedBrackets != null)
				msgs = ((InternalEObject)newRoundedBrackets).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (2), null, msgs);
			msgs = basicSetRoundedBrackets(newRoundedBrackets, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 2, newRoundedBrackets, newRoundedBrackets));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NameExpCS getOwnedNameExp() {
		return ownedNameExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedNameExp(NameExpCS newOwnedNameExp, NotificationChain msgs) {
		NameExpCS oldOwnedNameExp = ownedNameExp;
		ownedNameExp = newOwnedNameExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, 3, oldOwnedNameExp, newOwnedNameExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedNameExp(NameExpCS newOwnedNameExp) {
		if (newOwnedNameExp != ownedNameExp) {
			NotificationChain msgs = null;
			if (ownedNameExp != null)
				msgs = ((InternalEObject)ownedNameExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (3), null, msgs);
			if (newOwnedNameExp != null)
				msgs = ((InternalEObject)newOwnedNameExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (3), null, msgs);
			msgs = basicSetOwnedNameExp(newOwnedNameExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 3, newOwnedNameExp, newOwnedNameExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 1:
				return basicSetName(null, msgs);
			case 2:
				return basicSetRoundedBrackets(null, msgs);
			case 3:
				return basicSetOwnedNameExp(null, msgs);
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
			case 1:
				return getName();
			case 2:
				return getRoundedBrackets();
			case 3:
				return getOwnedNameExp();
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
			case 1:
				setName((PathNameCS)newValue);
				return;
			case 2:
				setRoundedBrackets((RoundedBracketClause)newValue);
				return;
			case 3:
				setOwnedNameExp((NameExpCS)newValue);
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
			case 1:
				setName((PathNameCS)null);
				return;
			case 2:
				setRoundedBrackets((RoundedBracketClause)null);
				return;
			case 3:
				setOwnedNameExp((NameExpCS)null);
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
			case 1:
				return name != null;
			case 2:
				return roundedBrackets != null;
			case 3:
				return ownedNameExp != null;
		}
		return super.eIsSet(featureID);
	}


} //NameExpCSImpl
