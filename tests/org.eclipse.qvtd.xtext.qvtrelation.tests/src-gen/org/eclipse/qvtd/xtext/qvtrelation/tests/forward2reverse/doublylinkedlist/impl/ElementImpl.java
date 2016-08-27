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
package org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.Element;
import org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.doublylinkedlistPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.impl.ElementImpl#getList <em>List</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.impl.ElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.impl.ElementImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.impl.ElementImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementImpl extends MinimalEObjectImpl.Container implements Element {
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
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Element source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Element target;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return doublylinkedlistPackage.Literals.ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoublyLinkedList getList() {
		if (eContainerFeatureID() != doublylinkedlistPackage.ELEMENT__LIST) return null;
		return (DoublyLinkedList)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetList(DoublyLinkedList newList, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newList, doublylinkedlistPackage.ELEMENT__LIST, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setList(DoublyLinkedList newList) {
		if (newList != eInternalContainer() || (eContainerFeatureID() != doublylinkedlistPackage.ELEMENT__LIST && newList != null)) {
			if (EcoreUtil.isAncestor(this, newList))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newList != null)
				msgs = ((InternalEObject)newList).eInverseAdd(this, doublylinkedlistPackage.DOUBLY_LINKED_LIST__OWNED_ELEMENTS, DoublyLinkedList.class, msgs);
			msgs = basicSetList(newList, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, doublylinkedlistPackage.ELEMENT__LIST, newList, newList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, doublylinkedlistPackage.ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (Element)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, doublylinkedlistPackage.ELEMENT__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Element newSource, NotificationChain msgs) {
		Element oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, doublylinkedlistPackage.ELEMENT__SOURCE, oldSource, newSource);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Element newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject)source).eInverseRemove(this, doublylinkedlistPackage.ELEMENT__TARGET, Element.class, msgs);
			if (newSource != null)
				msgs = ((InternalEObject)newSource).eInverseAdd(this, doublylinkedlistPackage.ELEMENT__TARGET, Element.class, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, doublylinkedlistPackage.ELEMENT__SOURCE, newSource, newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (Element)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, doublylinkedlistPackage.ELEMENT__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Element newTarget, NotificationChain msgs) {
		Element oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, doublylinkedlistPackage.ELEMENT__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Element newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, doublylinkedlistPackage.ELEMENT__SOURCE, Element.class, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, doublylinkedlistPackage.ELEMENT__SOURCE, Element.class, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, doublylinkedlistPackage.ELEMENT__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case doublylinkedlistPackage.ELEMENT__LIST:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetList((DoublyLinkedList)otherEnd, msgs);
			case doublylinkedlistPackage.ELEMENT__SOURCE:
				if (source != null)
					msgs = ((InternalEObject)source).eInverseRemove(this, doublylinkedlistPackage.ELEMENT__TARGET, Element.class, msgs);
				return basicSetSource((Element)otherEnd, msgs);
			case doublylinkedlistPackage.ELEMENT__TARGET:
				if (target != null)
					msgs = ((InternalEObject)target).eInverseRemove(this, doublylinkedlistPackage.ELEMENT__SOURCE, Element.class, msgs);
				return basicSetTarget((Element)otherEnd, msgs);
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
			case doublylinkedlistPackage.ELEMENT__LIST:
				return basicSetList(null, msgs);
			case doublylinkedlistPackage.ELEMENT__SOURCE:
				return basicSetSource(null, msgs);
			case doublylinkedlistPackage.ELEMENT__TARGET:
				return basicSetTarget(null, msgs);
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
			case doublylinkedlistPackage.ELEMENT__LIST:
				return eInternalContainer().eInverseRemove(this, doublylinkedlistPackage.DOUBLY_LINKED_LIST__OWNED_ELEMENTS, DoublyLinkedList.class, msgs);
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
			case doublylinkedlistPackage.ELEMENT__LIST:
				return getList();
			case doublylinkedlistPackage.ELEMENT__NAME:
				return getName();
			case doublylinkedlistPackage.ELEMENT__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case doublylinkedlistPackage.ELEMENT__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
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
			case doublylinkedlistPackage.ELEMENT__LIST:
				setList((DoublyLinkedList)newValue);
				return;
			case doublylinkedlistPackage.ELEMENT__NAME:
				setName((String)newValue);
				return;
			case doublylinkedlistPackage.ELEMENT__SOURCE:
				setSource((Element)newValue);
				return;
			case doublylinkedlistPackage.ELEMENT__TARGET:
				setTarget((Element)newValue);
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
			case doublylinkedlistPackage.ELEMENT__LIST:
				setList((DoublyLinkedList)null);
				return;
			case doublylinkedlistPackage.ELEMENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case doublylinkedlistPackage.ELEMENT__SOURCE:
				setSource((Element)null);
				return;
			case doublylinkedlistPackage.ELEMENT__TARGET:
				setTarget((Element)null);
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
			case doublylinkedlistPackage.ELEMENT__LIST:
				return getList() != null;
			case doublylinkedlistPackage.ELEMENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case doublylinkedlistPackage.ELEMENT__SOURCE:
				return source != null;
			case doublylinkedlistPackage.ELEMENT__TARGET:
				return target != null;
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

} //ElementImpl
