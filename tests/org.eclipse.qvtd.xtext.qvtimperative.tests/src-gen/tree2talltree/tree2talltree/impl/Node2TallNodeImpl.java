/**
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package tree2talltree.tree2talltree.impl;

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

import tree2talltree.talltree.TallNode;

import tree2talltree.tree.Node;

import tree2talltree.tree2talltree.Node2TallNode;
import tree2talltree.tree2talltree.Tree2talltreePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node2 Tall Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tree2talltree.tree2talltree.impl.Node2TallNodeImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link tree2talltree.tree2talltree.impl.Node2TallNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link tree2talltree.tree2talltree.impl.Node2TallNodeImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link tree2talltree.tree2talltree.impl.Node2TallNodeImpl#getNode <em>Node</em>}</li>
 *   <li>{@link tree2talltree.tree2talltree.impl.Node2TallNodeImpl#getTallNode <em>Tall Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class Node2TallNodeImpl extends MinimalEObjectImpl.Container implements Node2TallNode {
	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<Node2TallNode> children;

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
	 * The cached value of the '{@link #getNode() <em>Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected Node node;

	/**
	 * The cached value of the '{@link #getTallNode() <em>Tall Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTallNode()
	 * @generated
	 * @ordered
	 */
	protected TallNode tallNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Node2TallNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Tree2talltreePackage.Literals.NODE2_TALL_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Node2TallNode> getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList<Node2TallNode>(Node2TallNode.class, this, Tree2talltreePackage.NODE2_TALL_NODE__CHILDREN, Tree2talltreePackage.NODE2_TALL_NODE__PARENT);
		}
		return children;
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
			eNotify(new ENotificationImpl(this, Notification.SET, Tree2talltreePackage.NODE2_TALL_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node2TallNode getParent() {
		if (eContainerFeatureID() != Tree2talltreePackage.NODE2_TALL_NODE__PARENT) return null;
		return (Node2TallNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(Node2TallNode newParent, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParent, Tree2talltreePackage.NODE2_TALL_NODE__PARENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Node2TallNode newParent) {
		if (newParent != eInternalContainer() || (eContainerFeatureID() != Tree2talltreePackage.NODE2_TALL_NODE__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, Tree2talltreePackage.NODE2_TALL_NODE__CHILDREN, Node2TallNode.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tree2talltreePackage.NODE2_TALL_NODE__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node getNode() {
		if (node != null && node.eIsProxy()) {
			InternalEObject oldNode = (InternalEObject)node;
			node = (Node)eResolveProxy(oldNode);
			if (node != oldNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Tree2talltreePackage.NODE2_TALL_NODE__NODE, oldNode, node));
			}
		}
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNode(Node newNode) {
		Node oldNode = node;
		node = newNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tree2talltreePackage.NODE2_TALL_NODE__NODE, oldNode, node));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TallNode getTallNode() {
		if (tallNode != null && tallNode.eIsProxy()) {
			InternalEObject oldTallNode = (InternalEObject)tallNode;
			tallNode = (TallNode)eResolveProxy(oldTallNode);
			if (tallNode != oldTallNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, Tree2talltreePackage.NODE2_TALL_NODE__TALL_NODE, oldTallNode, tallNode));
			}
		}
		return tallNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TallNode basicGetTallNode() {
		return tallNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTallNode(TallNode newTallNode) {
		TallNode oldTallNode = tallNode;
		tallNode = newTallNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Tree2talltreePackage.NODE2_TALL_NODE__TALL_NODE, oldTallNode, tallNode));
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
			case Tree2talltreePackage.NODE2_TALL_NODE__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
			case Tree2talltreePackage.NODE2_TALL_NODE__PARENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParent((Node2TallNode)otherEnd, msgs);
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
			case Tree2talltreePackage.NODE2_TALL_NODE__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
			case Tree2talltreePackage.NODE2_TALL_NODE__PARENT:
				return basicSetParent(null, msgs);
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
			case Tree2talltreePackage.NODE2_TALL_NODE__PARENT:
				return eInternalContainer().eInverseRemove(this, Tree2talltreePackage.NODE2_TALL_NODE__CHILDREN, Node2TallNode.class, msgs);
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
			case Tree2talltreePackage.NODE2_TALL_NODE__CHILDREN:
				return getChildren();
			case Tree2talltreePackage.NODE2_TALL_NODE__NAME:
				return getName();
			case Tree2talltreePackage.NODE2_TALL_NODE__PARENT:
				return getParent();
			case Tree2talltreePackage.NODE2_TALL_NODE__NODE:
				if (resolve) return getNode();
				return basicGetNode();
			case Tree2talltreePackage.NODE2_TALL_NODE__TALL_NODE:
				if (resolve) return getTallNode();
				return basicGetTallNode();
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
			case Tree2talltreePackage.NODE2_TALL_NODE__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends Node2TallNode>)newValue);
				return;
			case Tree2talltreePackage.NODE2_TALL_NODE__NAME:
				setName((String)newValue);
				return;
			case Tree2talltreePackage.NODE2_TALL_NODE__PARENT:
				setParent((Node2TallNode)newValue);
				return;
			case Tree2talltreePackage.NODE2_TALL_NODE__NODE:
				setNode((Node)newValue);
				return;
			case Tree2talltreePackage.NODE2_TALL_NODE__TALL_NODE:
				setTallNode((TallNode)newValue);
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
			case Tree2talltreePackage.NODE2_TALL_NODE__CHILDREN:
				getChildren().clear();
				return;
			case Tree2talltreePackage.NODE2_TALL_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case Tree2talltreePackage.NODE2_TALL_NODE__PARENT:
				setParent((Node2TallNode)null);
				return;
			case Tree2talltreePackage.NODE2_TALL_NODE__NODE:
				setNode((Node)null);
				return;
			case Tree2talltreePackage.NODE2_TALL_NODE__TALL_NODE:
				setTallNode((TallNode)null);
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
			case Tree2talltreePackage.NODE2_TALL_NODE__CHILDREN:
				return children != null && !children.isEmpty();
			case Tree2talltreePackage.NODE2_TALL_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case Tree2talltreePackage.NODE2_TALL_NODE__PARENT:
				return getParent() != null;
			case Tree2talltreePackage.NODE2_TALL_NODE__NODE:
				return node != null;
			case Tree2talltreePackage.NODE2_TALL_NODE__TALL_NODE:
				return tallNode != null;
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

} //Node2TallNodeImpl
