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
package org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.PForward2ReversePackage;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Telement2element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Telement2elementImpl#getElementName <em>Element Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Telement2elementImpl#getForwardElement <em>Forward Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Telement2elementImpl#getForwardList <em>Forward List</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Telement2elementImpl#getForwardTarget <em>Forward Target</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Telement2elementImpl#getReverseElement <em>Reverse Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Telement2elementImpl#getReverseList <em>Reverse List</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Telement2elementImpl#getReverseSource <em>Reverse Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Telement2elementImpl extends MinimalEObjectImpl.Container implements Telement2element {
	/**
	 * The default value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementName()
	 * @generated
	 * @ordered
	 */
	protected static final String ELEMENT_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementName()
	 * @generated
	 * @ordered
	 */
	protected String elementName = ELEMENT_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getForwardElement() <em>Forward Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardElement()
	 * @generated
	 * @ordered
	 */
	protected Element forwardElement;

	/**
	 * The cached value of the '{@link #getForwardList() <em>Forward List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardList()
	 * @generated
	 * @ordered
	 */
	protected DoublyLinkedList forwardList;

	/**
	 * The cached value of the '{@link #getForwardTarget() <em>Forward Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardTarget()
	 * @generated
	 * @ordered
	 */
	protected Element forwardTarget;

	/**
	 * The cached value of the '{@link #getReverseElement() <em>Reverse Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReverseElement()
	 * @generated
	 * @ordered
	 */
	protected Element reverseElement;

	/**
	 * The cached value of the '{@link #getReverseList() <em>Reverse List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReverseList()
	 * @generated
	 * @ordered
	 */
	protected DoublyLinkedList reverseList;

	/**
	 * The cached value of the '{@link #getReverseSource() <em>Reverse Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReverseSource()
	 * @generated
	 * @ordered
	 */
	protected Element reverseSource;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Telement2elementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PForward2ReversePackage.Literals.TELEMENT2ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getElementName() {
		return elementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElementName(String newElementName) {
		String oldElementName = elementName;
		elementName = newElementName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PForward2ReversePackage.TELEMENT2ELEMENT__ELEMENT_NAME, oldElementName, elementName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Element getForwardElement() {
		if (forwardElement != null && forwardElement.eIsProxy()) {
			InternalEObject oldForwardElement = (InternalEObject)forwardElement;
			forwardElement = (Element)eResolveProxy(oldForwardElement);
			if (forwardElement != oldForwardElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_ELEMENT, oldForwardElement, forwardElement));
			}
		}
		return forwardElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetForwardElement() {
		return forwardElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForwardElement(Element newForwardElement) {
		Element oldForwardElement = forwardElement;
		forwardElement = newForwardElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_ELEMENT, oldForwardElement, forwardElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DoublyLinkedList getForwardList() {
		if (forwardList != null && forwardList.eIsProxy()) {
			InternalEObject oldForwardList = (InternalEObject)forwardList;
			forwardList = (DoublyLinkedList)eResolveProxy(oldForwardList);
			if (forwardList != oldForwardList) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_LIST, oldForwardList, forwardList));
			}
		}
		return forwardList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoublyLinkedList basicGetForwardList() {
		return forwardList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForwardList(DoublyLinkedList newForwardList) {
		DoublyLinkedList oldForwardList = forwardList;
		forwardList = newForwardList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_LIST, oldForwardList, forwardList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Element getForwardTarget() {
		if (forwardTarget != null && forwardTarget.eIsProxy()) {
			InternalEObject oldForwardTarget = (InternalEObject)forwardTarget;
			forwardTarget = (Element)eResolveProxy(oldForwardTarget);
			if (forwardTarget != oldForwardTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_TARGET, oldForwardTarget, forwardTarget));
			}
		}
		return forwardTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetForwardTarget() {
		return forwardTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setForwardTarget(Element newForwardTarget) {
		Element oldForwardTarget = forwardTarget;
		forwardTarget = newForwardTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_TARGET, oldForwardTarget, forwardTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Element getReverseElement() {
		if (reverseElement != null && reverseElement.eIsProxy()) {
			InternalEObject oldReverseElement = (InternalEObject)reverseElement;
			reverseElement = (Element)eResolveProxy(oldReverseElement);
			if (reverseElement != oldReverseElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_ELEMENT, oldReverseElement, reverseElement));
			}
		}
		return reverseElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetReverseElement() {
		return reverseElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReverseElement(Element newReverseElement) {
		Element oldReverseElement = reverseElement;
		reverseElement = newReverseElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_ELEMENT, oldReverseElement, reverseElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DoublyLinkedList getReverseList() {
		if (reverseList != null && reverseList.eIsProxy()) {
			InternalEObject oldReverseList = (InternalEObject)reverseList;
			reverseList = (DoublyLinkedList)eResolveProxy(oldReverseList);
			if (reverseList != oldReverseList) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_LIST, oldReverseList, reverseList));
			}
		}
		return reverseList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoublyLinkedList basicGetReverseList() {
		return reverseList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReverseList(DoublyLinkedList newReverseList) {
		DoublyLinkedList oldReverseList = reverseList;
		reverseList = newReverseList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_LIST, oldReverseList, reverseList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Element getReverseSource() {
		if (reverseSource != null && reverseSource.eIsProxy()) {
			InternalEObject oldReverseSource = (InternalEObject)reverseSource;
			reverseSource = (Element)eResolveProxy(oldReverseSource);
			if (reverseSource != oldReverseSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_SOURCE, oldReverseSource, reverseSource));
			}
		}
		return reverseSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetReverseSource() {
		return reverseSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReverseSource(Element newReverseSource) {
		Element oldReverseSource = reverseSource;
		reverseSource = newReverseSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_SOURCE, oldReverseSource, reverseSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PForward2ReversePackage.TELEMENT2ELEMENT__ELEMENT_NAME:
				return getElementName();
			case PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_ELEMENT:
				if (resolve) return getForwardElement();
				return basicGetForwardElement();
			case PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_LIST:
				if (resolve) return getForwardList();
				return basicGetForwardList();
			case PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_TARGET:
				if (resolve) return getForwardTarget();
				return basicGetForwardTarget();
			case PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_ELEMENT:
				if (resolve) return getReverseElement();
				return basicGetReverseElement();
			case PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_LIST:
				if (resolve) return getReverseList();
				return basicGetReverseList();
			case PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_SOURCE:
				if (resolve) return getReverseSource();
				return basicGetReverseSource();
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
			case PForward2ReversePackage.TELEMENT2ELEMENT__ELEMENT_NAME:
				setElementName((String)newValue);
				return;
			case PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_ELEMENT:
				setForwardElement((Element)newValue);
				return;
			case PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_LIST:
				setForwardList((DoublyLinkedList)newValue);
				return;
			case PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_TARGET:
				setForwardTarget((Element)newValue);
				return;
			case PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_ELEMENT:
				setReverseElement((Element)newValue);
				return;
			case PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_LIST:
				setReverseList((DoublyLinkedList)newValue);
				return;
			case PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_SOURCE:
				setReverseSource((Element)newValue);
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
			case PForward2ReversePackage.TELEMENT2ELEMENT__ELEMENT_NAME:
				setElementName(ELEMENT_NAME_EDEFAULT);
				return;
			case PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_ELEMENT:
				setForwardElement((Element)null);
				return;
			case PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_LIST:
				setForwardList((DoublyLinkedList)null);
				return;
			case PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_TARGET:
				setForwardTarget((Element)null);
				return;
			case PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_ELEMENT:
				setReverseElement((Element)null);
				return;
			case PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_LIST:
				setReverseList((DoublyLinkedList)null);
				return;
			case PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_SOURCE:
				setReverseSource((Element)null);
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
			case PForward2ReversePackage.TELEMENT2ELEMENT__ELEMENT_NAME:
				return ELEMENT_NAME_EDEFAULT == null ? elementName != null : !ELEMENT_NAME_EDEFAULT.equals(elementName);
			case PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_ELEMENT:
				return forwardElement != null;
			case PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_LIST:
				return forwardList != null;
			case PForward2ReversePackage.TELEMENT2ELEMENT__FORWARD_TARGET:
				return forwardTarget != null;
			case PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_ELEMENT:
				return reverseElement != null;
			case PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_LIST:
				return reverseList != null;
			case PForward2ReversePackage.TELEMENT2ELEMENT__REVERSE_SOURCE:
				return reverseSource != null;
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
		result.append(" (elementName: ");
		result.append(elementName);
		result.append(')');
		return result.toString();
	}

} //Telement2elementImpl
