/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.HSLNode;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.HSLTreePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>HLS Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.impl.HSLNodeImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.impl.HSLNodeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.impl.HSLNodeImpl#getHsl <em>Hsl</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.impl.HSLNodeImpl#getName <em>Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HSLNodeImpl extends MinimalEObjectImpl.Container implements HSLNode {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<HSLNode> children;

	/**
	 * The default value of the '{@link #getHsl() <em>Hsl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHsl()
	 * @generated
	 * @ordered
	 */
	protected static final String HSL_EDEFAULT = "1";

	/**
	 * The cached value of the '{@link #getHsl() <em>Hsl</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHsl()
	 * @generated
	 * @ordered
	 */
	protected String hsl = HSL_EDEFAULT;

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
	protected HSLNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HSLTreePackage.Literals.HSL_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HSLNode getParent() {
		if (eContainerFeatureID() != HSLTreePackage.HSL_NODE__PARENT) return null;
		return (HSLNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(HSLNode newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, HSLTreePackage.HSL_NODE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setParent(HSLNode newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != HSLTreePackage.HSL_NODE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, HSLTreePackage.HSL_NODE__CHILDREN, HSLNode.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HSLTreePackage.HSL_NODE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<HSLNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<HSLNode>(HSLNode.class, this, HSLTreePackage.HSL_NODE__CHILDREN, HSLTreePackage.HSL_NODE__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getHsl() {
		return hsl;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHsl(String newHsl) {
		String oldHsl = hsl;
		hsl = newHsl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, HSLTreePackage.HSL_NODE__HSL, oldHsl, hsl));
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
			eNotify(new ENotificationImpl(this, Notification.SET, HSLTreePackage.HSL_NODE__NAME, oldName, name));
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
			case HSLTreePackage.HSL_NODE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((HSLNode)otherEnd, msgs);
			case HSLTreePackage.HSL_NODE__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
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
			case HSLTreePackage.HSL_NODE__PARENT:
				return basicSetParent(null, msgs);
			case HSLTreePackage.HSL_NODE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case HSLTreePackage.HSL_NODE__PARENT:
				return eInternalContainer().eInverseRemove(this, HSLTreePackage.HSL_NODE__CHILDREN, HSLNode.class, msgs);
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
			case HSLTreePackage.HSL_NODE__PARENT:
				return getParent();
			case HSLTreePackage.HSL_NODE__CHILDREN:
				return getChildren();
			case HSLTreePackage.HSL_NODE__HSL:
				return getHsl();
			case HSLTreePackage.HSL_NODE__NAME:
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
			case HSLTreePackage.HSL_NODE__PARENT:
				setParent((HSLNode)newValue);
				return;
			case HSLTreePackage.HSL_NODE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends HSLNode>)newValue);
				return;
			case HSLTreePackage.HSL_NODE__HSL:
				setHsl((String)newValue);
				return;
			case HSLTreePackage.HSL_NODE__NAME:
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
			case HSLTreePackage.HSL_NODE__PARENT:
				setParent((HSLNode)null);
				return;
			case HSLTreePackage.HSL_NODE__CHILDREN:
				getChildren().clear();
				return;
			case HSLTreePackage.HSL_NODE__HSL:
				setHsl(HSL_EDEFAULT);
				return;
			case HSLTreePackage.HSL_NODE__NAME:
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
			case HSLTreePackage.HSL_NODE__PARENT:
				return getParent() != null;
			case HSLTreePackage.HSL_NODE__CHILDREN:
				return children != null && !children.isEmpty();
			case HSLTreePackage.HSL_NODE__HSL:
				return HSL_EDEFAULT == null ? hsl != null : !HSL_EDEFAULT.equals(hsl);
			case HSLTreePackage.HSL_NODE__NAME:
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
		result.append(" (hsl: ");
		result.append(hsl);
		result.append(", name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}


} //HLSNodeImpl
