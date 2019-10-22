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
package org.eclipse.qvtd.umlx.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rel Domain Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl#isIsEnforced <em>Is Enforced</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl#getOwnedRelPatternEdges <em>Owned Rel Pattern Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl#getOwnedRelPatternNodes <em>Owned Rel Pattern Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl#getOwningRelDiagram <em>Owning Rel Diagram</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl#getReferredTxTypedModelNode <em>Referred Tx Typed Model Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelDomainNodeImpl extends RelNodeImpl implements RelDomainNode {
	/**
	 * The number of structural features of the '<em>Rel Domain Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DOMAIN_NODE_FEATURE_COUNT = RelNodeImpl.REL_NODE_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Rel Domain Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DOMAIN_NODE_OPERATION_COUNT = RelNodeImpl.REL_NODE_OPERATION_COUNT + 0;

	/**
	 * The default value of the '{@link #isIsEnforced() <em>Is Enforced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforced()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENFORCED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEnforced() <em>Is Enforced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforced()
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforced = IS_ENFORCED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedRelPatternEdges() <em>Owned Rel Pattern Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelPatternEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<RelPatternEdge> ownedRelPatternEdges;

	/**
	 * The cached value of the '{@link #getOwnedRelPatternNodes() <em>Owned Rel Pattern Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelPatternNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<RelPatternNode> ownedRelPatternNodes;

	/**
	 * The cached value of the '{@link #getReferredTxTypedModelNode() <em>Referred Tx Typed Model Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredTxTypedModelNode()
	 * @generated
	 * @ordered
	 */
	protected TxTypedModelNode referredTxTypedModelNode;

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
		return UMLXPackage.Literals.REL_DOMAIN_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsEnforced() {
		return isEnforced;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsEnforced(boolean newIsEnforced) {
		boolean oldIsEnforced = isEnforced;
		isEnforced = newIsEnforced;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 1, oldIsEnforced, isEnforced));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelPatternEdge> getOwnedRelPatternEdges() {
		if (ownedRelPatternEdges == null) {
			ownedRelPatternEdges = new EObjectContainmentWithInverseEList<RelPatternEdge>(RelPatternEdge.class, this, 2, 1);
		}
		return ownedRelPatternEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelPatternNode> getOwnedRelPatternNodes() {
		if (ownedRelPatternNodes == null) {
			ownedRelPatternNodes = new EObjectContainmentWithInverseEList<RelPatternNode>(RelPatternNode.class, this, 3, 14);
		}
		return ownedRelPatternNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelDiagram getOwningRelDiagram() {
		if (eContainerFeatureID() != (4)) return null;
		return (RelDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRelDiagram(RelDiagram newOwningRelDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRelDiagram, 4, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRelDiagram(RelDiagram newOwningRelDiagram) {
		if (newOwningRelDiagram != eInternalContainer() || (eContainerFeatureID() != (4) && newOwningRelDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRelDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRelDiagram != null)
				msgs = ((InternalEObject)newOwningRelDiagram).eInverseAdd(this, 4, RelDiagram.class, msgs);
			msgs = basicSetOwningRelDiagram(newOwningRelDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 4, newOwningRelDiagram, newOwningRelDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxTypedModelNode getReferredTxTypedModelNode() {
		if (referredTxTypedModelNode != null && referredTxTypedModelNode.eIsProxy()) {
			InternalEObject oldReferredTxTypedModelNode = (InternalEObject)referredTxTypedModelNode;
			referredTxTypedModelNode = (TxTypedModelNode)eResolveProxy(oldReferredTxTypedModelNode);
			if (referredTxTypedModelNode != oldReferredTxTypedModelNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, 5, oldReferredTxTypedModelNode, referredTxTypedModelNode));
			}
		}
		return referredTxTypedModelNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TxTypedModelNode basicGetReferredTxTypedModelNode() {
		return referredTxTypedModelNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredTxTypedModelNode(TxTypedModelNode newReferredTxTypedModelNode) {
		TxTypedModelNode oldReferredTxTypedModelNode = referredTxTypedModelNode;
		referredTxTypedModelNode = newReferredTxTypedModelNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, 5, oldReferredTxTypedModelNode, referredTxTypedModelNode));
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
		result.append(" (isEnforced: ");
		result.append(isEnforced);
		result.append(')');
		return result.toString();
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
			case 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelPatternEdges()).basicAdd(otherEnd, msgs);
			case 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelPatternNodes()).basicAdd(otherEnd, msgs);
			case 4:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRelDiagram((RelDiagram)otherEnd, msgs);
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
				return ((InternalEList<?>)getOwnedRelPatternEdges()).basicRemove(otherEnd, msgs);
			case 3:
				return ((InternalEList<?>)getOwnedRelPatternNodes()).basicRemove(otherEnd, msgs);
			case 4:
				return basicSetOwningRelDiagram(null, msgs);
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
			case 4:
				return eInternalContainer().eInverseRemove(this, 4, RelDiagram.class, msgs);
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
			case 1:
				return isIsEnforced();
			case 2:
				return getOwnedRelPatternEdges();
			case 3:
				return getOwnedRelPatternNodes();
			case 4:
				return getOwningRelDiagram();
			case 5:
				if (resolve) return getReferredTxTypedModelNode();
				return basicGetReferredTxTypedModelNode();
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
			case 1:
				setIsEnforced((Boolean)newValue);
				return;
			case 2:
				getOwnedRelPatternEdges().clear();
				getOwnedRelPatternEdges().addAll((Collection<? extends RelPatternEdge>)newValue);
				return;
			case 3:
				getOwnedRelPatternNodes().clear();
				getOwnedRelPatternNodes().addAll((Collection<? extends RelPatternNode>)newValue);
				return;
			case 4:
				setOwningRelDiagram((RelDiagram)newValue);
				return;
			case 5:
				setReferredTxTypedModelNode((TxTypedModelNode)newValue);
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
			case 1:
				setIsEnforced(IS_ENFORCED_EDEFAULT);
				return;
			case 2:
				getOwnedRelPatternEdges().clear();
				return;
			case 3:
				getOwnedRelPatternNodes().clear();
				return;
			case 4:
				setOwningRelDiagram((RelDiagram)null);
				return;
			case 5:
				setReferredTxTypedModelNode((TxTypedModelNode)null);
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
			case 1:
				return isEnforced != IS_ENFORCED_EDEFAULT;
			case 2:
				return ownedRelPatternEdges != null && !ownedRelPatternEdges.isEmpty();
			case 3:
				return ownedRelPatternNodes != null && !ownedRelPatternNodes.isEmpty();
			case 4:
				return getOwningRelDiagram() != null;
			case 5:
				return referredTxTypedModelNode != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitRelDomainNode(this);
	}

} //RelDomainNodeImpl
