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
package org.eclipse.qvtd.umlx.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelPatternNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rel Pattern Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#getReferredClass <em>Referred Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl#getRelDomainNode <em>Rel Domain Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelPatternNodeImpl extends NodeImpl implements RelPatternNode {
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
	 * The cached value of the '{@link #getReferredClass() <em>Referred Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredClass()
	 * @generated
	 * @ordered
	 */
	protected EClassifier referredClass;

	/**
	 * The cached value of the '{@link #getRelDomainNode() <em>Rel Domain Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelDomainNode()
	 * @generated
	 * @ordered
	 */
	protected RelDomainNode relDomainNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelPatternNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlxPackageImpl.Literals.REL_PATTERN_NODE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, UmlxPackageImpl.REL_PATTERN_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier getReferredClass() {
		if (referredClass != null && referredClass.eIsProxy()) {
			InternalEObject oldReferredClass = (InternalEObject)referredClass;
			referredClass = (EClassifier)eResolveProxy(oldReferredClass);
			if (referredClass != oldReferredClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlxPackageImpl.REL_PATTERN_NODE__REFERRED_CLASS, oldReferredClass, referredClass));
			}
		}
		return referredClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClassifier basicGetReferredClass() {
		return referredClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredClass(EClassifier newReferredClass) {
		EClassifier oldReferredClass = referredClass;
		referredClass = newReferredClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlxPackageImpl.REL_PATTERN_NODE__REFERRED_CLASS, oldReferredClass, referredClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelDomainNode getRelDomainNode() {
		if (relDomainNode != null && relDomainNode.eIsProxy()) {
			InternalEObject oldRelDomainNode = (InternalEObject)relDomainNode;
			relDomainNode = (RelDomainNode)eResolveProxy(oldRelDomainNode);
			if (relDomainNode != oldRelDomainNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlxPackageImpl.REL_PATTERN_NODE__REL_DOMAIN_NODE, oldRelDomainNode, relDomainNode));
			}
		}
		return relDomainNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelDomainNode basicGetRelDomainNode() {
		return relDomainNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRelDomainNode(RelDomainNode newRelDomainNode, NotificationChain msgs) {
		RelDomainNode oldRelDomainNode = relDomainNode;
		relDomainNode = newRelDomainNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UmlxPackageImpl.REL_PATTERN_NODE__REL_DOMAIN_NODE, oldRelDomainNode, newRelDomainNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelDomainNode(RelDomainNode newRelDomainNode) {
		if (newRelDomainNode != relDomainNode) {
			NotificationChain msgs = null;
			if (relDomainNode != null)
				msgs = ((InternalEObject)relDomainNode).eInverseRemove(this, UmlxPackageImpl.REL_DOMAIN_NODE__ROOT_PATTERN_NODES, RelDomainNode.class, msgs);
			if (newRelDomainNode != null)
				msgs = ((InternalEObject)newRelDomainNode).eInverseAdd(this, UmlxPackageImpl.REL_DOMAIN_NODE__ROOT_PATTERN_NODES, RelDomainNode.class, msgs);
			msgs = basicSetRelDomainNode(newRelDomainNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlxPackageImpl.REL_PATTERN_NODE__REL_DOMAIN_NODE, newRelDomainNode, newRelDomainNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UmlxPackageImpl.REL_PATTERN_NODE__REL_DOMAIN_NODE:
				if (relDomainNode != null)
					msgs = ((InternalEObject)relDomainNode).eInverseRemove(this, UmlxPackageImpl.REL_DOMAIN_NODE__ROOT_PATTERN_NODES, RelDomainNode.class, msgs);
				return basicSetRelDomainNode((RelDomainNode)otherEnd, msgs);
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
			case UmlxPackageImpl.REL_PATTERN_NODE__REL_DOMAIN_NODE:
				return basicSetRelDomainNode(null, msgs);
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
			case UmlxPackageImpl.REL_PATTERN_NODE__NAME:
				return getName();
			case UmlxPackageImpl.REL_PATTERN_NODE__REFERRED_CLASS:
				if (resolve) return getReferredClass();
				return basicGetReferredClass();
			case UmlxPackageImpl.REL_PATTERN_NODE__REL_DOMAIN_NODE:
				if (resolve) return getRelDomainNode();
				return basicGetRelDomainNode();
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
			case UmlxPackageImpl.REL_PATTERN_NODE__NAME:
				setName((String)newValue);
				return;
			case UmlxPackageImpl.REL_PATTERN_NODE__REFERRED_CLASS:
				setReferredClass((EClassifier)newValue);
				return;
			case UmlxPackageImpl.REL_PATTERN_NODE__REL_DOMAIN_NODE:
				setRelDomainNode((RelDomainNode)newValue);
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
			case UmlxPackageImpl.REL_PATTERN_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UmlxPackageImpl.REL_PATTERN_NODE__REFERRED_CLASS:
				setReferredClass((EClassifier)null);
				return;
			case UmlxPackageImpl.REL_PATTERN_NODE__REL_DOMAIN_NODE:
				setRelDomainNode((RelDomainNode)null);
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
			case UmlxPackageImpl.REL_PATTERN_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UmlxPackageImpl.REL_PATTERN_NODE__REFERRED_CLASS:
				return referredClass != null;
			case UmlxPackageImpl.REL_PATTERN_NODE__REL_DOMAIN_NODE:
				return relDomainNode != null;
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

} //RelPatternNodeImpl
