/**
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.Element;

import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.Element2Element;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2List;
import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2listPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element2 Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.impl.Element2ElementImpl#getElement1 <em>Element1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.impl.Element2ElementImpl#getElement2 <em>Element2</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.impl.Element2ElementImpl#getList2list <em>List2list</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.impl.Element2ElementImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Element2ElementImpl extends MinimalEObjectImpl.Container implements Element2Element {
	/**
	 * The number of structural features of the '<em>Element2 Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ELEMENT2_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Element2 Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ELEMENT2_ELEMENT_OPERATION_COUNT = 0;

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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 0, oldElement1, element1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 0, oldElement1, element1));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 1, oldElement2, element2));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 1, oldElement2, element2));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List2List getList2list() {
		if (eContainerFeatureID() != (2)) return null;
		return (List2List)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetList2list(List2List newList2list, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newList2list, 2, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setList2list(List2List newList2list) {
		if (newList2list != eInternalContainer() || (eContainerFeatureID() != (2) && newList2list != null)) {
			if (EcoreUtil.isAncestor(this, newList2list))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newList2list != null)
				msgs = ((InternalEObject)newList2list).eInverseAdd(this, 2, List2List.class, msgs);
			msgs = basicSetList2list(newList2list, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 2, newList2list, newList2list));
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
			eNotify(new ENotificationImpl(this, Notification.SET, 3, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case 2:
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
			case 2:
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
			case 2:
				return eInternalContainer().eInverseRemove(this, 2, List2List.class, msgs);
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
				if (resolve) return getElement1();
				return basicGetElement1();
			case 1:
				if (resolve) return getElement2();
				return basicGetElement2();
			case 2:
				return getList2list();
			case 3:
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
			case 0:
				setElement1((Element)newValue);
				return;
			case 1:
				setElement2((Element)newValue);
				return;
			case 2:
				setList2list((List2List)newValue);
				return;
			case 3:
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
			case 0:
				setElement1((Element)null);
				return;
			case 1:
				setElement2((Element)null);
				return;
			case 2:
				setList2list((List2List)null);
				return;
			case 3:
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
			case 0:
				return element1 != null;
			case 1:
				return element2 != null;
			case 2:
				return getList2list() != null;
			case 3:
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //Element2ElementImpl
