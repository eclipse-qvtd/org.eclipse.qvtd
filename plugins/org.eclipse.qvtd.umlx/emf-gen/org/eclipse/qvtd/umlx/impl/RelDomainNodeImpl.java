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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rel Domain Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl#getReferredTypedModelNode <em>Referred Typed Model Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl#getRootPatternNodes <em>Root Pattern Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelDomainNodeImpl extends NodeImpl implements RelDomainNode {
	/**
	 * The cached value of the '{@link #getReferredTypedModelNode() <em>Referred Typed Model Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredTypedModelNode()
	 * @generated
	 * @ordered
	 */
	protected TxTypedModelNode referredTypedModelNode;

	/**
	 * The cached value of the '{@link #getRootPatternNodes() <em>Root Pattern Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRootPatternNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<RelPatternNode> rootPatternNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelDomainNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlxPackageImpl.Literals.REL_DOMAIN_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TxTypedModelNode getReferredTypedModelNode() {
		if (referredTypedModelNode != null && referredTypedModelNode.eIsProxy()) {
			InternalEObject oldReferredTypedModelNode = (InternalEObject)referredTypedModelNode;
			referredTypedModelNode = (TxTypedModelNode)eResolveProxy(oldReferredTypedModelNode);
			if (referredTypedModelNode != oldReferredTypedModelNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlxPackageImpl.REL_DOMAIN_NODE__REFERRED_TYPED_MODEL_NODE, oldReferredTypedModelNode, referredTypedModelNode));
			}
		}
		return referredTypedModelNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TxTypedModelNode basicGetReferredTypedModelNode() {
		return referredTypedModelNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredTypedModelNode(TxTypedModelNode newReferredTypedModelNode) {
		TxTypedModelNode oldReferredTypedModelNode = referredTypedModelNode;
		referredTypedModelNode = newReferredTypedModelNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlxPackageImpl.REL_DOMAIN_NODE__REFERRED_TYPED_MODEL_NODE, oldReferredTypedModelNode, referredTypedModelNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RelPatternNode> getRootPatternNodes() {
		if (rootPatternNodes == null) {
			rootPatternNodes = new EObjectWithInverseResolvingEList<RelPatternNode>(RelPatternNode.class, this, UmlxPackageImpl.REL_DOMAIN_NODE__ROOT_PATTERN_NODES, UmlxPackageImpl.REL_PATTERN_NODE__REL_DOMAIN_NODE);
		}
		return rootPatternNodes;
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
			case UmlxPackageImpl.REL_DOMAIN_NODE__ROOT_PATTERN_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRootPatternNodes()).basicAdd(otherEnd, msgs);
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
			case UmlxPackageImpl.REL_DOMAIN_NODE__ROOT_PATTERN_NODES:
				return ((InternalEList<?>)getRootPatternNodes()).basicRemove(otherEnd, msgs);
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
			case UmlxPackageImpl.REL_DOMAIN_NODE__REFERRED_TYPED_MODEL_NODE:
				if (resolve) return getReferredTypedModelNode();
				return basicGetReferredTypedModelNode();
			case UmlxPackageImpl.REL_DOMAIN_NODE__ROOT_PATTERN_NODES:
				return getRootPatternNodes();
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
			case UmlxPackageImpl.REL_DOMAIN_NODE__REFERRED_TYPED_MODEL_NODE:
				setReferredTypedModelNode((TxTypedModelNode)newValue);
				return;
			case UmlxPackageImpl.REL_DOMAIN_NODE__ROOT_PATTERN_NODES:
				getRootPatternNodes().clear();
				getRootPatternNodes().addAll((Collection<? extends RelPatternNode>)newValue);
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
			case UmlxPackageImpl.REL_DOMAIN_NODE__REFERRED_TYPED_MODEL_NODE:
				setReferredTypedModelNode((TxTypedModelNode)null);
				return;
			case UmlxPackageImpl.REL_DOMAIN_NODE__ROOT_PATTERN_NODES:
				getRootPatternNodes().clear();
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
			case UmlxPackageImpl.REL_DOMAIN_NODE__REFERRED_TYPED_MODEL_NODE:
				return referredTypedModelNode != null;
			case UmlxPackageImpl.REL_DOMAIN_NODE__ROOT_PATTERN_NODES:
				return rootPatternNodes != null && !rootPatternNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RelDomainNodeImpl
