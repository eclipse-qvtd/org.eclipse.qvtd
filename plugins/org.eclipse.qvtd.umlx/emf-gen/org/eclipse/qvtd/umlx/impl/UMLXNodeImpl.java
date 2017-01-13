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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.qvtd.umlx.UMLXDiagram;
import org.eclipse.qvtd.umlx.UMLXEdge;
import org.eclipse.qvtd.umlx.UMLXNode;
import org.eclipse.qvtd.umlx.UMLXPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.UMLXNodeImpl#getDiagram <em>Diagram</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.UMLXNodeImpl#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.UMLXNodeImpl#getOwnedOutgoingEdges <em>Owned Outgoing Edges</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class UMLXNodeImpl extends UMLXElementImpl implements UMLXNode {
	/**
	 * The cached value of the '{@link #getIncomingEdges() <em>Incoming Edges</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncomingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<UMLXEdge> incomingEdges;

	/**
	 * The cached value of the '{@link #getOwnedOutgoingEdges() <em>Owned Outgoing Edges</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOutgoingEdges()
	 * @generated
	 * @ordered
	 */
	protected EList<UMLXEdge> ownedOutgoingEdges;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UMLXNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.UMLX_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UMLXDiagram getDiagram() {
		if (eContainerFeatureID() != UMLXPackage.UMLX_NODE__DIAGRAM) return null;
		return (UMLXDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDiagram(UMLXDiagram newDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDiagram, UMLXPackage.UMLX_NODE__DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDiagram(UMLXDiagram newDiagram) {
		if (newDiagram != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.UMLX_NODE__DIAGRAM && newDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDiagram != null)
				msgs = ((InternalEObject)newDiagram).eInverseAdd(this, UMLXPackage.UMLX_DIAGRAM__OWNED_NODES, UMLXDiagram.class, msgs);
			msgs = basicSetDiagram(newDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.UMLX_NODE__DIAGRAM, newDiagram, newDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UMLXEdge> getIncomingEdges() {
		if (incomingEdges == null) {
			incomingEdges = new EObjectWithInverseResolvingEList<UMLXEdge>(UMLXEdge.class, this, UMLXPackage.UMLX_NODE__INCOMING_EDGES, UMLXPackage.UMLX_EDGE__TARGET);
		}
		return incomingEdges;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<UMLXEdge> getOwnedOutgoingEdges() {
		if (ownedOutgoingEdges == null) {
			ownedOutgoingEdges = new EObjectContainmentWithInverseEList<UMLXEdge>(UMLXEdge.class, this, UMLXPackage.UMLX_NODE__OWNED_OUTGOING_EDGES, UMLXPackage.UMLX_EDGE__OWNING_SOURCE);
		}
		return ownedOutgoingEdges;
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
			case UMLXPackage.UMLX_NODE__DIAGRAM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDiagram((UMLXDiagram)otherEnd, msgs);
			case UMLXPackage.UMLX_NODE__INCOMING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncomingEdges()).basicAdd(otherEnd, msgs);
			case UMLXPackage.UMLX_NODE__OWNED_OUTGOING_EDGES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOutgoingEdges()).basicAdd(otherEnd, msgs);
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
			case UMLXPackage.UMLX_NODE__DIAGRAM:
				return basicSetDiagram(null, msgs);
			case UMLXPackage.UMLX_NODE__INCOMING_EDGES:
				return ((InternalEList<?>)getIncomingEdges()).basicRemove(otherEnd, msgs);
			case UMLXPackage.UMLX_NODE__OWNED_OUTGOING_EDGES:
				return ((InternalEList<?>)getOwnedOutgoingEdges()).basicRemove(otherEnd, msgs);
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
			case UMLXPackage.UMLX_NODE__DIAGRAM:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.UMLX_DIAGRAM__OWNED_NODES, UMLXDiagram.class, msgs);
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
			case UMLXPackage.UMLX_NODE__DIAGRAM:
				return getDiagram();
			case UMLXPackage.UMLX_NODE__INCOMING_EDGES:
				return getIncomingEdges();
			case UMLXPackage.UMLX_NODE__OWNED_OUTGOING_EDGES:
				return getOwnedOutgoingEdges();
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
			case UMLXPackage.UMLX_NODE__DIAGRAM:
				setDiagram((UMLXDiagram)newValue);
				return;
			case UMLXPackage.UMLX_NODE__INCOMING_EDGES:
				getIncomingEdges().clear();
				getIncomingEdges().addAll((Collection<? extends UMLXEdge>)newValue);
				return;
			case UMLXPackage.UMLX_NODE__OWNED_OUTGOING_EDGES:
				getOwnedOutgoingEdges().clear();
				getOwnedOutgoingEdges().addAll((Collection<? extends UMLXEdge>)newValue);
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
			case UMLXPackage.UMLX_NODE__DIAGRAM:
				setDiagram((UMLXDiagram)null);
				return;
			case UMLXPackage.UMLX_NODE__INCOMING_EDGES:
				getIncomingEdges().clear();
				return;
			case UMLXPackage.UMLX_NODE__OWNED_OUTGOING_EDGES:
				getOwnedOutgoingEdges().clear();
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
			case UMLXPackage.UMLX_NODE__DIAGRAM:
				return getDiagram() != null;
			case UMLXPackage.UMLX_NODE__INCOMING_EDGES:
				return incomingEdges != null && !incomingEdges.isEmpty();
			case UMLXPackage.UMLX_NODE__OWNED_OUTGOING_EDGES:
				return ownedOutgoingEdges != null && !ownedOutgoingEdges.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //UMLXNodeImpl
