/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublyLinkedList;

import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.Element2Element;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2List;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2listPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>List2 List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.impl.List2ListImpl#getList1 <em>List1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.impl.List2ListImpl#getList2 <em>List2</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.impl.List2ListImpl#getElement2Element <em>Element2 Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.impl.List2ListImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class List2ListImpl extends MinimalEObjectImpl.Container implements List2List {
	/**
	 * The cached value of the '{@link #getList1() <em>List1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getList1()
	 * @generated
	 * @ordered
	 */
	protected DoublyLinkedList list1;

	/**
	 * The cached value of the '{@link #getList2() <em>List2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getList2()
	 * @generated
	 * @ordered
	 */
	protected DoublyLinkedList list2;

	/**
	 * The cached value of the '{@link #getElement2Element() <em>Element2 Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement2Element()
	 * @generated
	 * @ordered
	 */
	protected EList<Element2Element> element2Element;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected List2ListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return List2listPackage.Literals.LIST2_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DoublyLinkedList getList1() {
		if (list1 != null && list1.eIsProxy()) {
			InternalEObject oldList1 = (InternalEObject)list1;
			list1 = (DoublyLinkedList)eResolveProxy(oldList1);
			if (list1 != oldList1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, List2listPackage.LIST2_LIST__LIST1, oldList1, list1));
			}
		}
		return list1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoublyLinkedList basicGetList1() {
		return list1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setList1(DoublyLinkedList newList1) {
		DoublyLinkedList oldList1 = list1;
		list1 = newList1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, List2listPackage.LIST2_LIST__LIST1, oldList1, list1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DoublyLinkedList getList2() {
		if (list2 != null && list2.eIsProxy()) {
			InternalEObject oldList2 = (InternalEObject)list2;
			list2 = (DoublyLinkedList)eResolveProxy(oldList2);
			if (list2 != oldList2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, List2listPackage.LIST2_LIST__LIST2, oldList2, list2));
			}
		}
		return list2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoublyLinkedList basicGetList2() {
		return list2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setList2(DoublyLinkedList newList2) {
		DoublyLinkedList oldList2 = list2;
		list2 = newList2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, List2listPackage.LIST2_LIST__LIST2, oldList2, list2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Element2Element> getElement2Element() {
		if (element2Element == null) {
			element2Element = new EObjectContainmentWithInverseEList<Element2Element>(Element2Element.class, this, List2listPackage.LIST2_LIST__ELEMENT2_ELEMENT, List2listPackage.ELEMENT2_ELEMENT__LIST2LIST);
		}
		return element2Element;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, List2listPackage.LIST2_LIST__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case List2listPackage.LIST2_LIST__ELEMENT2_ELEMENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getElement2Element()).basicAdd(otherEnd, msgs);
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
			case List2listPackage.LIST2_LIST__ELEMENT2_ELEMENT:
				return ((InternalEList<?>)getElement2Element()).basicRemove(otherEnd, msgs);
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
			case List2listPackage.LIST2_LIST__LIST1:
				if (resolve) return getList1();
				return basicGetList1();
			case List2listPackage.LIST2_LIST__LIST2:
				if (resolve) return getList2();
				return basicGetList2();
			case List2listPackage.LIST2_LIST__ELEMENT2_ELEMENT:
				return getElement2Element();
			case List2listPackage.LIST2_LIST__NAME:
				return getName();
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
			case List2listPackage.LIST2_LIST__LIST1:
				setList1((DoublyLinkedList)newValue);
				return;
			case List2listPackage.LIST2_LIST__LIST2:
				setList2((DoublyLinkedList)newValue);
				return;
			case List2listPackage.LIST2_LIST__ELEMENT2_ELEMENT:
				getElement2Element().clear();
				getElement2Element().addAll((Collection<? extends Element2Element>)newValue);
				return;
			case List2listPackage.LIST2_LIST__NAME:
				setName((String)newValue);
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
			case List2listPackage.LIST2_LIST__LIST1:
				setList1((DoublyLinkedList)null);
				return;
			case List2listPackage.LIST2_LIST__LIST2:
				setList2((DoublyLinkedList)null);
				return;
			case List2listPackage.LIST2_LIST__ELEMENT2_ELEMENT:
				getElement2Element().clear();
				return;
			case List2listPackage.LIST2_LIST__NAME:
				setName(NAME_EDEFAULT);
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
			case List2listPackage.LIST2_LIST__LIST1:
				return list1 != null;
			case List2listPackage.LIST2_LIST__LIST2:
				return list2 != null;
			case List2listPackage.LIST2_LIST__ELEMENT2_ELEMENT:
				return element2Element != null && !element2Element.isEmpty();
			case List2listPackage.LIST2_LIST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //List2ListImpl
