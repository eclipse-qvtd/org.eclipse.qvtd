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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tx Package Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl#getReferredEPackage <em>Referred EPackage</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl#getOwningTxTypedModelNode <em>Owning Tx Typed Model Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxPackageNodeImpl extends TxNodeImpl implements TxPackageNode {
	/**
	 * The cached value of the '{@link #getReferredEPackage() <em>Referred EPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredEPackage()
	 * @generated
	 * @ordered
	 */
	protected EPackage referredEPackage;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TxPackageNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.TX_PACKAGE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EPackage getReferredEPackage() {
		if (referredEPackage != null && referredEPackage.eIsProxy()) {
			InternalEObject oldReferredEPackage = (InternalEObject)referredEPackage;
			referredEPackage = (EPackage)eResolveProxy(oldReferredEPackage);
			if (referredEPackage != oldReferredEPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UMLXPackage.TX_PACKAGE_NODE__REFERRED_EPACKAGE, oldReferredEPackage, referredEPackage));
			}
		}
		return referredEPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetReferredEPackage() {
		return referredEPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredEPackage(EPackage newReferredEPackage) {
		EPackage oldReferredEPackage = referredEPackage;
		referredEPackage = newReferredEPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_PACKAGE_NODE__REFERRED_EPACKAGE, oldReferredEPackage, referredEPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxTypedModelNode getOwningTxTypedModelNode() {
		if (eContainerFeatureID() != UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE) return null;
		return (TxTypedModelNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTxTypedModelNode(TxTypedModelNode newOwningTxTypedModelNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTxTypedModelNode, UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTxTypedModelNode(TxTypedModelNode newOwningTxTypedModelNode) {
		if (newOwningTxTypedModelNode != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE && newOwningTxTypedModelNode != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTxTypedModelNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTxTypedModelNode != null)
				msgs = ((InternalEObject)newOwningTxTypedModelNode).eInverseAdd(this, UMLXPackage.TX_TYPED_MODEL_NODE__OWNED_TX_PACKAGE_NODES, TxTypedModelNode.class, msgs);
			msgs = basicSetOwningTxTypedModelNode(newOwningTxTypedModelNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE, newOwningTxTypedModelNode, newOwningTxTypedModelNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTxTypedModelNode((TxTypedModelNode)otherEnd, msgs);
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
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE:
				return basicSetOwningTxTypedModelNode(null, msgs);
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
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.TX_TYPED_MODEL_NODE__OWNED_TX_PACKAGE_NODES, TxTypedModelNode.class, msgs);
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
			case UMLXPackage.TX_PACKAGE_NODE__REFERRED_EPACKAGE:
				if (resolve) return getReferredEPackage();
				return basicGetReferredEPackage();
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE:
				return getOwningTxTypedModelNode();
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
			case UMLXPackage.TX_PACKAGE_NODE__REFERRED_EPACKAGE:
				setReferredEPackage((EPackage)newValue);
				return;
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE:
				setOwningTxTypedModelNode((TxTypedModelNode)newValue);
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
			case UMLXPackage.TX_PACKAGE_NODE__REFERRED_EPACKAGE:
				setReferredEPackage((EPackage)null);
				return;
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE:
				setOwningTxTypedModelNode((TxTypedModelNode)null);
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
			case UMLXPackage.TX_PACKAGE_NODE__REFERRED_EPACKAGE:
				return referredEPackage != null;
			case UMLXPackage.TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE:
				return getOwningTxTypedModelNode() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitTxPackageNode(this);
	}

} //TxPackageNodeImpl
