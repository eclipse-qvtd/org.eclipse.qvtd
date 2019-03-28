/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.FamiliesPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.Family;
import org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.Member;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Member</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.impl.MemberImpl#getFirstName <em>First Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.impl.MemberImpl#getFamilyFather <em>Family Father</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.impl.MemberImpl#getFamilyMother <em>Family Mother</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.impl.MemberImpl#getFamilySon <em>Family Son</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.families2persons.Families.impl.MemberImpl#getFamilyDaughter <em>Family Daughter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MemberImpl extends MinimalEObjectImpl.Container implements Member {
	/**
	 * The number of structural features of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MEMBER_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Member</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MEMBER_OPERATION_COUNT = 0;

	/**
	 * The default value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIRST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFirstName() <em>First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstName()
	 * @generated
	 * @ordered
	 */
	protected String firstName = FIRST_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemberImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return FamiliesPackage.Literals.MEMBER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFirstName() {
		return firstName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFirstName(String newFirstName) {
		String oldFirstName = firstName;
		firstName = newFirstName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 0, oldFirstName, firstName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Family getFamilyFather() {
		if (eContainerFeatureID() != (1)) return null;
		return (Family)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFamilyFather(Family newFamilyFather, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFamilyFather, 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFamilyFather(Family newFamilyFather) {
		if (newFamilyFather != eInternalContainer() || (eContainerFeatureID() != (1) && newFamilyFather != null)) {
			if (EcoreUtil.isAncestor(this, newFamilyFather))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFamilyFather != null)
				msgs = ((InternalEObject)newFamilyFather).eInverseAdd(this, 1, Family.class, msgs);
			msgs = basicSetFamilyFather(newFamilyFather, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 1, newFamilyFather, newFamilyFather));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Family getFamilyMother() {
		if (eContainerFeatureID() != (2)) return null;
		return (Family)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFamilyMother(Family newFamilyMother, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFamilyMother, 2, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFamilyMother(Family newFamilyMother) {
		if (newFamilyMother != eInternalContainer() || (eContainerFeatureID() != (2) && newFamilyMother != null)) {
			if (EcoreUtil.isAncestor(this, newFamilyMother))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFamilyMother != null)
				msgs = ((InternalEObject)newFamilyMother).eInverseAdd(this, 2, Family.class, msgs);
			msgs = basicSetFamilyMother(newFamilyMother, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 2, newFamilyMother, newFamilyMother));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Family getFamilySon() {
		if (eContainerFeatureID() != (3)) return null;
		return (Family)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFamilySon(Family newFamilySon, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFamilySon, 3, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFamilySon(Family newFamilySon) {
		if (newFamilySon != eInternalContainer() || (eContainerFeatureID() != (3) && newFamilySon != null)) {
			if (EcoreUtil.isAncestor(this, newFamilySon))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFamilySon != null)
				msgs = ((InternalEObject)newFamilySon).eInverseAdd(this, 3, Family.class, msgs);
			msgs = basicSetFamilySon(newFamilySon, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 3, newFamilySon, newFamilySon));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Family getFamilyDaughter() {
		if (eContainerFeatureID() != (4)) return null;
		return (Family)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFamilyDaughter(Family newFamilyDaughter, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFamilyDaughter, 4, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFamilyDaughter(Family newFamilyDaughter) {
		if (newFamilyDaughter != eInternalContainer() || (eContainerFeatureID() != (4) && newFamilyDaughter != null)) {
			if (EcoreUtil.isAncestor(this, newFamilyDaughter))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFamilyDaughter != null)
				msgs = ((InternalEObject)newFamilyDaughter).eInverseAdd(this, 4, Family.class, msgs);
			msgs = basicSetFamilyDaughter(newFamilyDaughter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 4, newFamilyDaughter, newFamilyDaughter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 1:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFamilyFather((Family)otherEnd, msgs);
			case 2:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFamilyMother((Family)otherEnd, msgs);
			case 3:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFamilySon((Family)otherEnd, msgs);
			case 4:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFamilyDaughter((Family)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
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
				return basicSetFamilyFather(null, msgs);
			case 2:
				return basicSetFamilyMother(null, msgs);
			case 3:
				return basicSetFamilySon(null, msgs);
			case 4:
				return basicSetFamilyDaughter(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case 1:
				return eInternalContainer().eInverseRemove(this, 1, Family.class, msgs);
			case 2:
				return eInternalContainer().eInverseRemove(this, 2, Family.class, msgs);
			case 3:
				return eInternalContainer().eInverseRemove(this, 3, Family.class, msgs);
			case 4:
				return eInternalContainer().eInverseRemove(this, 4, Family.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case 0:
				return getFirstName();
			case 1:
				return getFamilyFather();
			case 2:
				return getFamilyMother();
			case 3:
				return getFamilySon();
			case 4:
				return getFamilyDaughter();
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
			case 0:
				setFirstName((String)newValue);
				return;
			case 1:
				setFamilyFather((Family)newValue);
				return;
			case 2:
				setFamilyMother((Family)newValue);
				return;
			case 3:
				setFamilySon((Family)newValue);
				return;
			case 4:
				setFamilyDaughter((Family)newValue);
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
			case 0:
				setFirstName(FIRST_NAME_EDEFAULT);
				return;
			case 1:
				setFamilyFather((Family)null);
				return;
			case 2:
				setFamilyMother((Family)null);
				return;
			case 3:
				setFamilySon((Family)null);
				return;
			case 4:
				setFamilyDaughter((Family)null);
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
			case 0:
				return FIRST_NAME_EDEFAULT == null ? firstName != null : !FIRST_NAME_EDEFAULT.equals(firstName);
			case 1:
				return getFamilyFather() != null;
			case 2:
				return getFamilyMother() != null;
			case 3:
				return getFamilySon() != null;
			case 4:
				return getFamilyDaughter() != null;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (firstName: ");
		result.append(firstName);
		result.append(')');
		return result.toString();
	}


} //MemberImpl
