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
package org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.PForward2ReversePackage;
import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.Tlist2list;

import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.Element;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tlist2list</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.impl.Tlist2listImpl#getForwardHead <em>Forward Head</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.impl.Tlist2listImpl#getForwardList <em>Forward List</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.impl.Tlist2listImpl#getListName <em>List Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.impl.Tlist2listImpl#getReverseHead <em>Reverse Head</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.impl.Tlist2listImpl#getReverseList <em>Reverse List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Tlist2listImpl extends MinimalEObjectImpl.Container implements Tlist2list {
	/**
	 * The cached value of the '{@link #getForwardHead() <em>Forward Head</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForwardHead()
	 * @generated
	 * @ordered
	 */
	protected Element forwardHead;

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
	 * The default value of the '{@link #getListName() <em>List Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListName()
	 * @generated
	 * @ordered
	 */
	protected static final String LIST_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getListName() <em>List Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getListName()
	 * @generated
	 * @ordered
	 */
	protected String listName = LIST_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getReverseHead() <em>Reverse Head</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReverseHead()
	 * @generated
	 * @ordered
	 */
	protected Element reverseHead;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Tlist2listImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PForward2ReversePackage.Literals.TLIST2LIST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getForwardHead() {
		if (forwardHead != null && forwardHead.eIsProxy()) {
			InternalEObject oldForwardHead = (InternalEObject)forwardHead;
			forwardHead = (Element)eResolveProxy(oldForwardHead);
			if (forwardHead != oldForwardHead) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PForward2ReversePackage.TLIST2LIST__FORWARD_HEAD, oldForwardHead, forwardHead));
			}
		}
		return forwardHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetForwardHead() {
		return forwardHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForwardHead(Element newForwardHead) {
		Element oldForwardHead = forwardHead;
		forwardHead = newForwardHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PForward2ReversePackage.TLIST2LIST__FORWARD_HEAD, oldForwardHead, forwardHead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoublyLinkedList getForwardList() {
		if (forwardList != null && forwardList.eIsProxy()) {
			InternalEObject oldForwardList = (InternalEObject)forwardList;
			forwardList = (DoublyLinkedList)eResolveProxy(oldForwardList);
			if (forwardList != oldForwardList) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PForward2ReversePackage.TLIST2LIST__FORWARD_LIST, oldForwardList, forwardList));
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
	public void setForwardList(DoublyLinkedList newForwardList) {
		DoublyLinkedList oldForwardList = forwardList;
		forwardList = newForwardList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PForward2ReversePackage.TLIST2LIST__FORWARD_LIST, oldForwardList, forwardList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getListName() {
		return listName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setListName(String newListName) {
		String oldListName = listName;
		listName = newListName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PForward2ReversePackage.TLIST2LIST__LIST_NAME, oldListName, listName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getReverseHead() {
		if (reverseHead != null && reverseHead.eIsProxy()) {
			InternalEObject oldReverseHead = (InternalEObject)reverseHead;
			reverseHead = (Element)eResolveProxy(oldReverseHead);
			if (reverseHead != oldReverseHead) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PForward2ReversePackage.TLIST2LIST__REVERSE_HEAD, oldReverseHead, reverseHead));
			}
		}
		return reverseHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetReverseHead() {
		return reverseHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReverseHead(Element newReverseHead) {
		Element oldReverseHead = reverseHead;
		reverseHead = newReverseHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PForward2ReversePackage.TLIST2LIST__REVERSE_HEAD, oldReverseHead, reverseHead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoublyLinkedList getReverseList() {
		if (reverseList != null && reverseList.eIsProxy()) {
			InternalEObject oldReverseList = (InternalEObject)reverseList;
			reverseList = (DoublyLinkedList)eResolveProxy(oldReverseList);
			if (reverseList != oldReverseList) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PForward2ReversePackage.TLIST2LIST__REVERSE_LIST, oldReverseList, reverseList));
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
	public void setReverseList(DoublyLinkedList newReverseList) {
		DoublyLinkedList oldReverseList = reverseList;
		reverseList = newReverseList;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PForward2ReversePackage.TLIST2LIST__REVERSE_LIST, oldReverseList, reverseList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PForward2ReversePackage.TLIST2LIST__FORWARD_HEAD:
				if (resolve) return getForwardHead();
				return basicGetForwardHead();
			case PForward2ReversePackage.TLIST2LIST__FORWARD_LIST:
				if (resolve) return getForwardList();
				return basicGetForwardList();
			case PForward2ReversePackage.TLIST2LIST__LIST_NAME:
				return getListName();
			case PForward2ReversePackage.TLIST2LIST__REVERSE_HEAD:
				if (resolve) return getReverseHead();
				return basicGetReverseHead();
			case PForward2ReversePackage.TLIST2LIST__REVERSE_LIST:
				if (resolve) return getReverseList();
				return basicGetReverseList();
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
			case PForward2ReversePackage.TLIST2LIST__FORWARD_HEAD:
				setForwardHead((Element)newValue);
				return;
			case PForward2ReversePackage.TLIST2LIST__FORWARD_LIST:
				setForwardList((DoublyLinkedList)newValue);
				return;
			case PForward2ReversePackage.TLIST2LIST__LIST_NAME:
				setListName((String)newValue);
				return;
			case PForward2ReversePackage.TLIST2LIST__REVERSE_HEAD:
				setReverseHead((Element)newValue);
				return;
			case PForward2ReversePackage.TLIST2LIST__REVERSE_LIST:
				setReverseList((DoublyLinkedList)newValue);
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
			case PForward2ReversePackage.TLIST2LIST__FORWARD_HEAD:
				setForwardHead((Element)null);
				return;
			case PForward2ReversePackage.TLIST2LIST__FORWARD_LIST:
				setForwardList((DoublyLinkedList)null);
				return;
			case PForward2ReversePackage.TLIST2LIST__LIST_NAME:
				setListName(LIST_NAME_EDEFAULT);
				return;
			case PForward2ReversePackage.TLIST2LIST__REVERSE_HEAD:
				setReverseHead((Element)null);
				return;
			case PForward2ReversePackage.TLIST2LIST__REVERSE_LIST:
				setReverseList((DoublyLinkedList)null);
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
			case PForward2ReversePackage.TLIST2LIST__FORWARD_HEAD:
				return forwardHead != null;
			case PForward2ReversePackage.TLIST2LIST__FORWARD_LIST:
				return forwardList != null;
			case PForward2ReversePackage.TLIST2LIST__LIST_NAME:
				return LIST_NAME_EDEFAULT == null ? listName != null : !LIST_NAME_EDEFAULT.equals(listName);
			case PForward2ReversePackage.TLIST2LIST__REVERSE_HEAD:
				return reverseHead != null;
			case PForward2ReversePackage.TLIST2LIST__REVERSE_LIST:
				return reverseList != null;
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
		result.append(" (listName: ");
		result.append(listName);
		result.append(')');
		return result.toString();
	}

} //Tlist2listImpl
