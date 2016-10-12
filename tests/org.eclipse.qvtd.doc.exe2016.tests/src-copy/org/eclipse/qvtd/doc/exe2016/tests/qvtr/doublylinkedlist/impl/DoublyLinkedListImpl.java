/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.impl;

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
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.Element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.doublylinkedlistPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Doubly Linked List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.impl.DoublyLinkedListImpl#getHeadElement <em>Head Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.impl.DoublyLinkedListImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.impl.DoublyLinkedListImpl#getOwnedElements <em>Owned Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DoublyLinkedListImpl extends MinimalEObjectImpl.Container implements DoublyLinkedList {
	/**
	 * The cached value of the '{@link #getHeadElement() <em>Head Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadElement()
	 * @generated
	 * @ordered
	 */
	protected Element headElement;

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
	 * The cached value of the '{@link #getOwnedElements() <em>Owned Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<Element> ownedElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DoublyLinkedListImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return doublylinkedlistPackage.Literals.DOUBLY_LINKED_LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Element getHeadElement() {
		if (headElement != null && headElement.eIsProxy()) {
			InternalEObject oldHeadElement = (InternalEObject)headElement;
			headElement = (Element)eResolveProxy(oldHeadElement);
			if (headElement != oldHeadElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, doublylinkedlistPackage.DOUBLY_LINKED_LIST__HEAD_ELEMENT, oldHeadElement, headElement));
			}
		}
		return headElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetHeadElement() {
		return headElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHeadElement(Element newHeadElement) {
		Element oldHeadElement = headElement;
		headElement = newHeadElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, doublylinkedlistPackage.DOUBLY_LINKED_LIST__HEAD_ELEMENT, oldHeadElement, headElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, doublylinkedlistPackage.DOUBLY_LINKED_LIST__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Element> getOwnedElements() {
		if (ownedElements == null) {
			ownedElements = new EObjectContainmentWithInverseEList<Element>(Element.class, this, doublylinkedlistPackage.DOUBLY_LINKED_LIST__OWNED_ELEMENTS, doublylinkedlistPackage.ELEMENT__LIST);
		}
		return ownedElements;
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
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__OWNED_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedElements()).basicAdd(otherEnd, msgs);
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
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__OWNED_ELEMENTS:
				return ((InternalEList<?>)getOwnedElements()).basicRemove(otherEnd, msgs);
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
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__HEAD_ELEMENT:
				if (resolve) return getHeadElement();
				return basicGetHeadElement();
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__NAME:
				return getName();
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__OWNED_ELEMENTS:
				return getOwnedElements();
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
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__HEAD_ELEMENT:
				setHeadElement((Element)newValue);
				return;
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__NAME:
				setName((String)newValue);
				return;
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__OWNED_ELEMENTS:
				getOwnedElements().clear();
				getOwnedElements().addAll((Collection<? extends Element>)newValue);
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
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__HEAD_ELEMENT:
				setHeadElement((Element)null);
				return;
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__NAME:
				setName(NAME_EDEFAULT);
				return;
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__OWNED_ELEMENTS:
				getOwnedElements().clear();
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
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__HEAD_ELEMENT:
				return headElement != null;
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case doublylinkedlistPackage.DOUBLY_LINKED_LIST__OWNED_ELEMENTS:
				return ownedElements != null && !ownedElements.isEmpty();
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

} //DoublyLinkedListImpl
