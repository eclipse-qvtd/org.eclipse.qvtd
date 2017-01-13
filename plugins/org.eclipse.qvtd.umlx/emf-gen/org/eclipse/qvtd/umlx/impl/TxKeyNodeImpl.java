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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxTransformationNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tx Key Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxKeyNodeImpl#getTxTransformationNode <em>Tx Transformation Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxKeyNodeImpl#getReferredClass <em>Referred Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxKeyNodeImpl#getTxPartNodes <em>Tx Part Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxKeyNodeImpl extends TxNodeImpl implements TxKeyNode {
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
	 * The cached value of the '{@link #getTxPartNodes() <em>Tx Part Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTxPartNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxPartNode> txPartNodes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TxKeyNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.TX_KEY_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxTransformationNode getTxTransformationNode() {
		if (eContainerFeatureID() != UMLXPackage.TX_KEY_NODE__TX_TRANSFORMATION_NODE) return null;
		return (TxTransformationNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTxTransformationNode(TxTransformationNode newTxTransformationNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTxTransformationNode, UMLXPackage.TX_KEY_NODE__TX_TRANSFORMATION_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTxTransformationNode(TxTransformationNode newTxTransformationNode) {
		if (newTxTransformationNode != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.TX_KEY_NODE__TX_TRANSFORMATION_NODE && newTxTransformationNode != null)) {
			if (EcoreUtil.isAncestor(this, newTxTransformationNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTxTransformationNode != null)
				msgs = ((InternalEObject)newTxTransformationNode).eInverseAdd(this, UMLXPackage.TX_TRANSFORMATION_NODE__TX_KEY_NODES, TxTransformationNode.class, msgs);
			msgs = basicSetTxTransformationNode(newTxTransformationNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_KEY_NODE__TX_TRANSFORMATION_NODE, newTxTransformationNode, newTxTransformationNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClassifier getReferredClass() {
		if (referredClass != null && referredClass.eIsProxy()) {
			InternalEObject oldReferredClass = (InternalEObject)referredClass;
			referredClass = (EClassifier)eResolveProxy(oldReferredClass);
			if (referredClass != oldReferredClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.TX_KEY_NODE__REFERRED_CLASS, oldReferredClass, referredClass));
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
	@Override
	public void setReferredClass(EClassifier newReferredClass) {
		EClassifier oldReferredClass = referredClass;
		referredClass = newReferredClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_KEY_NODE__REFERRED_CLASS, oldReferredClass, referredClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxPartNode> getTxPartNodes() {
		if (txPartNodes == null) {
			txPartNodes = new EObjectContainmentWithInverseEList<TxPartNode>(TxPartNode.class, this, UMLXPackage.TX_KEY_NODE__TX_PART_NODES, UMLXPackage.TX_PART_NODE__TX_KEY_NODE);
		}
		return txPartNodes;
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
			case UMLXPackage.TX_KEY_NODE__TX_TRANSFORMATION_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTxTransformationNode((TxTransformationNode)otherEnd, msgs);
			case UMLXPackage.TX_KEY_NODE__TX_PART_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTxPartNodes()).basicAdd(otherEnd, msgs);
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
			case UMLXPackage.TX_KEY_NODE__TX_TRANSFORMATION_NODE:
				return basicSetTxTransformationNode(null, msgs);
			case UMLXPackage.TX_KEY_NODE__TX_PART_NODES:
				return ((InternalEList<?>)getTxPartNodes()).basicRemove(otherEnd, msgs);
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
			case UMLXPackage.TX_KEY_NODE__TX_TRANSFORMATION_NODE:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.TX_TRANSFORMATION_NODE__TX_KEY_NODES, TxTransformationNode.class, msgs);
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
			case UMLXPackage.TX_KEY_NODE__TX_TRANSFORMATION_NODE:
				return getTxTransformationNode();
			case UMLXPackage.TX_KEY_NODE__REFERRED_CLASS:
				if (resolve) return getReferredClass();
				return basicGetReferredClass();
			case UMLXPackage.TX_KEY_NODE__TX_PART_NODES:
				return getTxPartNodes();
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
			case UMLXPackage.TX_KEY_NODE__TX_TRANSFORMATION_NODE:
				setTxTransformationNode((TxTransformationNode)newValue);
				return;
			case UMLXPackage.TX_KEY_NODE__REFERRED_CLASS:
				setReferredClass((EClassifier)newValue);
				return;
			case UMLXPackage.TX_KEY_NODE__TX_PART_NODES:
				getTxPartNodes().clear();
				getTxPartNodes().addAll((Collection<? extends TxPartNode>)newValue);
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
			case UMLXPackage.TX_KEY_NODE__TX_TRANSFORMATION_NODE:
				setTxTransformationNode((TxTransformationNode)null);
				return;
			case UMLXPackage.TX_KEY_NODE__REFERRED_CLASS:
				setReferredClass((EClassifier)null);
				return;
			case UMLXPackage.TX_KEY_NODE__TX_PART_NODES:
				getTxPartNodes().clear();
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
			case UMLXPackage.TX_KEY_NODE__TX_TRANSFORMATION_NODE:
				return getTxTransformationNode() != null;
			case UMLXPackage.TX_KEY_NODE__REFERRED_CLASS:
				return referredClass != null;
			case UMLXPackage.TX_KEY_NODE__TX_PART_NODES:
				return txPartNodes != null && !txPartNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitTxKeyNode(this);
	}

} //TxKeyNodeImpl
