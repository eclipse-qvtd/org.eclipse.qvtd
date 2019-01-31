/**
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rel Invocation Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelInvocationEdgeImpl#getInvokingRelPatternNode <em>Invoking Rel Pattern Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelInvocationEdgeImpl#getOwningRelInvocationNode <em>Owning Rel Invocation Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelInvocationEdgeImpl#getReferredRelPatternNode <em>Referred Rel Pattern Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelInvocationEdgeImpl extends RelEdgeImpl implements RelInvocationEdge {
	/**
	 * The number of structural features of the '<em>Rel Invocation Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_INVOCATION_EDGE_FEATURE_COUNT = RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 3;

	/**
	 * The cached value of the '{@link #getInvokingRelPatternNode() <em>Invoking Rel Pattern Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvokingRelPatternNode()
	 * @generated
	 * @ordered
	 */
	protected RelPatternNode invokingRelPatternNode;

	/**
	 * The cached value of the '{@link #getReferredRelPatternNode() <em>Referred Rel Pattern Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredRelPatternNode()
	 * @generated
	 * @ordered
	 */
	protected RelPatternNode referredRelPatternNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelInvocationEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.REL_INVOCATION_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelPatternNode getReferredRelPatternNode() {
		if (referredRelPatternNode != null && referredRelPatternNode.eIsProxy()) {
			InternalEObject oldReferredRelPatternNode = (InternalEObject)referredRelPatternNode;
			referredRelPatternNode = (RelPatternNode)eResolveProxy(oldReferredRelPatternNode);
			if (referredRelPatternNode != oldReferredRelPatternNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 2, oldReferredRelPatternNode, referredRelPatternNode));
			}
		}
		return referredRelPatternNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelPatternNode basicGetReferredRelPatternNode() {
		return referredRelPatternNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredRelPatternNode(RelPatternNode newReferredRelPatternNode) {
		RelPatternNode oldReferredRelPatternNode = referredRelPatternNode;
		referredRelPatternNode = newReferredRelPatternNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 2, oldReferredRelPatternNode, referredRelPatternNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelInvocationNode getOwningRelInvocationNode() {
		if (eContainerFeatureID() != (RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 1)) return null;
		return (RelInvocationNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningRelInvocationNode(RelInvocationNode newOwningRelInvocationNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningRelInvocationNode, RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningRelInvocationNode(RelInvocationNode newOwningRelInvocationNode) {
		if (newOwningRelInvocationNode != eInternalContainer() || (eContainerFeatureID() != (RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 1) && newOwningRelInvocationNode != null)) {
			if (EcoreUtil.isAncestor(this, newOwningRelInvocationNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningRelInvocationNode != null)
				msgs = ((InternalEObject)newOwningRelInvocationNode).eInverseAdd(this, RelNodeImpl.REL_NODE_FEATURE_COUNT + 2, RelInvocationNode.class, msgs);
			msgs = basicSetOwningRelInvocationNode(newOwningRelInvocationNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 1, newOwningRelInvocationNode, newOwningRelInvocationNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelPatternNode getInvokingRelPatternNode() {
		if (invokingRelPatternNode != null && invokingRelPatternNode.eIsProxy()) {
			InternalEObject oldInvokingRelPatternNode = (InternalEObject)invokingRelPatternNode;
			invokingRelPatternNode = (RelPatternNode)eResolveProxy(oldInvokingRelPatternNode);
			if (invokingRelPatternNode != oldInvokingRelPatternNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 0, oldInvokingRelPatternNode, invokingRelPatternNode));
			}
		}
		return invokingRelPatternNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelPatternNode basicGetInvokingRelPatternNode() {
		return invokingRelPatternNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvokingRelPatternNode(RelPatternNode newInvokingRelPatternNode, NotificationChain msgs) {
		RelPatternNode oldInvokingRelPatternNode = invokingRelPatternNode;
		invokingRelPatternNode = newInvokingRelPatternNode;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 0, oldInvokingRelPatternNode, newInvokingRelPatternNode);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInvokingRelPatternNode(RelPatternNode newInvokingRelPatternNode) {
		if (newInvokingRelPatternNode != invokingRelPatternNode) {
			NotificationChain msgs = null;
			if (invokingRelPatternNode != null)
				msgs = ((InternalEObject)invokingRelPatternNode).eInverseRemove(this, RelNodeImpl.REL_NODE_FEATURE_COUNT + 9, RelPatternNode.class, msgs);
			if (newInvokingRelPatternNode != null)
				msgs = ((InternalEObject)newInvokingRelPatternNode).eInverseAdd(this, RelNodeImpl.REL_NODE_FEATURE_COUNT + 9, RelPatternNode.class, msgs);
			msgs = basicSetInvokingRelPatternNode(newInvokingRelPatternNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 0, newInvokingRelPatternNode, newInvokingRelPatternNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 0:
				if (invokingRelPatternNode != null)
					msgs = ((InternalEObject)invokingRelPatternNode).eInverseRemove(this, RelNodeImpl.REL_NODE_FEATURE_COUNT + 9, RelPatternNode.class, msgs);
				return basicSetInvokingRelPatternNode((RelPatternNode)otherEnd, msgs);
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 1:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningRelInvocationNode((RelInvocationNode)otherEnd, msgs);
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
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 0:
				return basicSetInvokingRelPatternNode(null, msgs);
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 1:
				return basicSetOwningRelInvocationNode(null, msgs);
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
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 1:
				return eInternalContainer().eInverseRemove(this, RelNodeImpl.REL_NODE_FEATURE_COUNT + 2, RelInvocationNode.class, msgs);
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
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 0:
				if (resolve) return getInvokingRelPatternNode();
				return basicGetInvokingRelPatternNode();
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 1:
				return getOwningRelInvocationNode();
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 2:
				if (resolve) return getReferredRelPatternNode();
				return basicGetReferredRelPatternNode();
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
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 0:
				setInvokingRelPatternNode((RelPatternNode)newValue);
				return;
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 1:
				setOwningRelInvocationNode((RelInvocationNode)newValue);
				return;
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 2:
				setReferredRelPatternNode((RelPatternNode)newValue);
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
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 0:
				setInvokingRelPatternNode((RelPatternNode)null);
				return;
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 1:
				setOwningRelInvocationNode((RelInvocationNode)null);
				return;
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 2:
				setReferredRelPatternNode((RelPatternNode)null);
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
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 0:
				return invokingRelPatternNode != null;
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 1:
				return getOwningRelInvocationNode() != null;
			case RelEdgeImpl.REL_EDGE_FEATURE_COUNT + 2:
				return referredRelPatternNode != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitRelInvocationEdge(this);
	}

} //RelInvocationEdgeImpl
