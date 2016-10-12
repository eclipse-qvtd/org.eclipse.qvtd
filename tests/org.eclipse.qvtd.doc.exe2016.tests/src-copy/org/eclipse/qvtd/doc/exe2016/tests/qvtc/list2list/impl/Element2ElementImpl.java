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
package org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element2 Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.Element2ElementImpl#getElement1 <em>Element1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.Element2ElementImpl#getElement2 <em>Element2</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.Element2ElementImpl#getList2list <em>List2list</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.Element2ElementImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Element2ElementImpl extends MinimalEObjectImpl.Container implements Element2Element {
	/**
	 * The cached value of the '{@link #getElement1() <em>Element1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement1()
	 * @generated
	 * @ordered
	 */
	protected Element element1;

	/**
	 * The cached value of the '{@link #getElement2() <em>Element2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElement2()
	 * @generated
	 * @ordered
	 */
	protected Element element2;

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
	protected Element2ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return List2listPackage.Literals.ELEMENT2_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Element getElement1() {
		if (element1 != null && element1.eIsProxy()) {
			InternalEObject oldElement1 = (InternalEObject)element1;
			element1 = (Element)eResolveProxy(oldElement1);
			if (element1 != oldElement1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, List2listPackage.ELEMENT2_ELEMENT__ELEMENT1, oldElement1, element1));
			}
		}
		return element1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetElement1() {
		return element1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElement1(Element newElement1) {
		Element oldElement1 = element1;
		element1 = newElement1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, List2listPackage.ELEMENT2_ELEMENT__ELEMENT1, oldElement1, element1));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Element getElement2() {
		if (element2 != null && element2.eIsProxy()) {
			InternalEObject oldElement2 = (InternalEObject)element2;
			element2 = (Element)eResolveProxy(oldElement2);
			if (element2 != oldElement2) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, List2listPackage.ELEMENT2_ELEMENT__ELEMENT2, oldElement2, element2));
			}
		}
		return element2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetElement2() {
		return element2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setElement2(Element newElement2) {
		Element oldElement2 = element2;
		element2 = newElement2;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, List2listPackage.ELEMENT2_ELEMENT__ELEMENT2, oldElement2, element2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List2List getList2list() {
		if (eContainerFeatureID() != List2listPackage.ELEMENT2_ELEMENT__LIST2LIST) return null;
		return (List2List)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetList2list(List2List newList2list, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newList2list, List2listPackage.ELEMENT2_ELEMENT__LIST2LIST, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setList2list(List2List newList2list) {
		if (newList2list != eInternalContainer() || (eContainerFeatureID() != List2listPackage.ELEMENT2_ELEMENT__LIST2LIST && newList2list != null)) {
			if (EcoreUtil.isAncestor(this, newList2list))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newList2list != null)
				msgs = ((InternalEObject)newList2list).eInverseAdd(this, List2listPackage.LIST2_LIST__ELEMENT2_ELEMENT, List2List.class, msgs);
			msgs = basicSetList2list(newList2list, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, List2listPackage.ELEMENT2_ELEMENT__LIST2LIST, newList2list, newList2list));
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
			eNotify(new ENotificationImpl(this, Notification.SET, List2listPackage.ELEMENT2_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case List2listPackage.ELEMENT2_ELEMENT__LIST2LIST:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetList2list((List2List)otherEnd, msgs);
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
			case List2listPackage.ELEMENT2_ELEMENT__LIST2LIST:
				return basicSetList2list(null, msgs);
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
			case List2listPackage.ELEMENT2_ELEMENT__LIST2LIST:
				return eInternalContainer().eInverseRemove(this, List2listPackage.LIST2_LIST__ELEMENT2_ELEMENT, List2List.class, msgs);
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
			case List2listPackage.ELEMENT2_ELEMENT__ELEMENT1:
				if (resolve) return getElement1();
				return basicGetElement1();
			case List2listPackage.ELEMENT2_ELEMENT__ELEMENT2:
				if (resolve) return getElement2();
				return basicGetElement2();
			case List2listPackage.ELEMENT2_ELEMENT__LIST2LIST:
				return getList2list();
			case List2listPackage.ELEMENT2_ELEMENT__NAME:
				return getName();
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
			case List2listPackage.ELEMENT2_ELEMENT__ELEMENT1:
				setElement1((Element)newValue);
				return;
			case List2listPackage.ELEMENT2_ELEMENT__ELEMENT2:
				setElement2((Element)newValue);
				return;
			case List2listPackage.ELEMENT2_ELEMENT__LIST2LIST:
				setList2list((List2List)newValue);
				return;
			case List2listPackage.ELEMENT2_ELEMENT__NAME:
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
			case List2listPackage.ELEMENT2_ELEMENT__ELEMENT1:
				setElement1((Element)null);
				return;
			case List2listPackage.ELEMENT2_ELEMENT__ELEMENT2:
				setElement2((Element)null);
				return;
			case List2listPackage.ELEMENT2_ELEMENT__LIST2LIST:
				setList2list((List2List)null);
				return;
			case List2listPackage.ELEMENT2_ELEMENT__NAME:
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
			case List2listPackage.ELEMENT2_ELEMENT__ELEMENT1:
				return element1 != null;
			case List2listPackage.ELEMENT2_ELEMENT__ELEMENT2:
				return element2 != null;
			case List2listPackage.ELEMENT2_ELEMENT__LIST2LIST:
				return getList2list() != null;
			case List2listPackage.ELEMENT2_ELEMENT__NAME:
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

} //Element2ElementImpl
