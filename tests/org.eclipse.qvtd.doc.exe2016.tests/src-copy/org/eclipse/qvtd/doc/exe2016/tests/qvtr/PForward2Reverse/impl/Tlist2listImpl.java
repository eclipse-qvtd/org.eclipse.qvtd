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
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.SlistHead2listHead;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Tlist2list;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.DoublyLinkedList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tlist2list</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.impl.Tlist2listImpl#getForwardList <em>Forward List</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.impl.Tlist2listImpl#getListName <em>List Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.impl.Tlist2listImpl#getReverseList <em>Reverse List</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.impl.Tlist2listImpl#getWhere_listHead2listHead <em>Where list Head2list Head</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Tlist2listImpl extends MinimalEObjectImpl.Container implements Tlist2list {
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
	 * The cached value of the '{@link #getReverseList() <em>Reverse List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReverseList()
	 * @generated
	 * @ordered
	 */
	protected DoublyLinkedList reverseList;

	/**
	 * The cached value of the '{@link #getWhere_listHead2listHead() <em>Where list Head2list Head</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWhere_listHead2listHead()
	 * @generated
	 * @ordered
	 */
	protected SlistHead2listHead where_listHead2listHead;

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
	@Override
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
	@Override
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
	@Override
	public String getListName() {
		return listName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
	public SlistHead2listHead getWhere_listHead2listHead() {
		if (where_listHead2listHead != null && where_listHead2listHead.eIsProxy()) {
			InternalEObject oldWhere_listHead2listHead = (InternalEObject)where_listHead2listHead;
			where_listHead2listHead = (SlistHead2listHead)eResolveProxy(oldWhere_listHead2listHead);
			if (where_listHead2listHead != oldWhere_listHead2listHead) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PForward2ReversePackage.TLIST2LIST__WHERE_LIST_HEAD2LIST_HEAD, oldWhere_listHead2listHead, where_listHead2listHead));
			}
		}
		return where_listHead2listHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SlistHead2listHead basicGetWhere_listHead2listHead() {
		return where_listHead2listHead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWhere_listHead2listHead(SlistHead2listHead newWhere_listHead2listHead) {
		SlistHead2listHead oldWhere_listHead2listHead = where_listHead2listHead;
		where_listHead2listHead = newWhere_listHead2listHead;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PForward2ReversePackage.TLIST2LIST__WHERE_LIST_HEAD2LIST_HEAD, oldWhere_listHead2listHead, where_listHead2listHead));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PForward2ReversePackage.TLIST2LIST__FORWARD_LIST:
				if (resolve) return getForwardList();
				return basicGetForwardList();
			case PForward2ReversePackage.TLIST2LIST__LIST_NAME:
				return getListName();
			case PForward2ReversePackage.TLIST2LIST__REVERSE_LIST:
				if (resolve) return getReverseList();
				return basicGetReverseList();
			case PForward2ReversePackage.TLIST2LIST__WHERE_LIST_HEAD2LIST_HEAD:
				if (resolve) return getWhere_listHead2listHead();
				return basicGetWhere_listHead2listHead();
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
			case PForward2ReversePackage.TLIST2LIST__FORWARD_LIST:
				setForwardList((DoublyLinkedList)newValue);
				return;
			case PForward2ReversePackage.TLIST2LIST__LIST_NAME:
				setListName((String)newValue);
				return;
			case PForward2ReversePackage.TLIST2LIST__REVERSE_LIST:
				setReverseList((DoublyLinkedList)newValue);
				return;
			case PForward2ReversePackage.TLIST2LIST__WHERE_LIST_HEAD2LIST_HEAD:
				setWhere_listHead2listHead((SlistHead2listHead)newValue);
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
			case PForward2ReversePackage.TLIST2LIST__FORWARD_LIST:
				setForwardList((DoublyLinkedList)null);
				return;
			case PForward2ReversePackage.TLIST2LIST__LIST_NAME:
				setListName(LIST_NAME_EDEFAULT);
				return;
			case PForward2ReversePackage.TLIST2LIST__REVERSE_LIST:
				setReverseList((DoublyLinkedList)null);
				return;
			case PForward2ReversePackage.TLIST2LIST__WHERE_LIST_HEAD2LIST_HEAD:
				setWhere_listHead2listHead((SlistHead2listHead)null);
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
			case PForward2ReversePackage.TLIST2LIST__FORWARD_LIST:
				return forwardList != null;
			case PForward2ReversePackage.TLIST2LIST__LIST_NAME:
				return LIST_NAME_EDEFAULT == null ? listName != null : !LIST_NAME_EDEFAULT.equals(listName);
			case PForward2ReversePackage.TLIST2LIST__REVERSE_LIST:
				return reverseList != null;
			case PForward2ReversePackage.TLIST2LIST__WHERE_LIST_HEAD2LIST_HEAD:
				return where_listHead2listHead != null;
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
