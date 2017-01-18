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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rel Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl#isIsTop <em>Is Top</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl#getOwnedRelDomainNodes <em>Owned Rel Domain Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl#getOwnedRelInvocationNodes <em>Owned Rel Invocation Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl#getOwningTxDiagram <em>Owning Tx Diagram</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelDiagramImpl extends UMLXNamedElementImpl implements RelDiagram {
	/**
	 * The default value of the '{@link #isIsTop() <em>Is Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTop()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_TOP_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIsTop() <em>Is Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsTop()
	 * @generated
	 * @ordered
	 */
	protected boolean isTop = IS_TOP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedRelDomainNodes() <em>Owned Rel Domain Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelDomainNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<RelDomainNode> ownedRelDomainNodes;
	/**
	 * The cached value of the '{@link #getOwnedRelInvocationNodes() <em>Owned Rel Invocation Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelInvocationNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<RelInvocationNode> ownedRelInvocationNodes;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.REL_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsTop() {
		return isTop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsTop(boolean newIsTop) {
		boolean oldIsTop = isTop;
		isTop = newIsTop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_DIAGRAM__IS_TOP, oldIsTop, isTop));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelDomainNode> getOwnedRelDomainNodes() {
		if (ownedRelDomainNodes == null) {
			ownedRelDomainNodes = new EObjectContainmentWithInverseEList<RelDomainNode>(RelDomainNode.class, this, UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES, UMLXPackage.REL_DOMAIN_NODE__OWNING_REL_DIAGRAM);
		}
		return ownedRelDomainNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelInvocationNode> getOwnedRelInvocationNodes() {
		if (ownedRelInvocationNodes == null) {
			ownedRelInvocationNodes = new EObjectContainmentWithInverseEList<RelInvocationNode>(RelInvocationNode.class, this, UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES, UMLXPackage.REL_INVOCATION_NODE__OWNING_REL_DIAGRAM);
		}
		return ownedRelInvocationNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxDiagram getOwningTxDiagram() {
		if (eContainerFeatureID() != UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM) return null;
		return (TxDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningTxDiagram(TxDiagram newOwningTxDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningTxDiagram, UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningTxDiagram(TxDiagram newOwningTxDiagram) {
		if (newOwningTxDiagram != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM && newOwningTxDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newOwningTxDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningTxDiagram != null)
				msgs = ((InternalEObject)newOwningTxDiagram).eInverseAdd(this, UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS, TxDiagram.class, msgs);
			msgs = basicSetOwningTxDiagram(newOwningTxDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM, newOwningTxDiagram, newOwningTxDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UMLXPackage.REL_DIAGRAM__IS_TOP:
				return isIsTop();
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES:
				return getOwnedRelDomainNodes();
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES:
				return getOwnedRelInvocationNodes();
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
				return getOwningTxDiagram();
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
			case UMLXPackage.REL_DIAGRAM__IS_TOP:
				setIsTop((Boolean)newValue);
				return;
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES:
				getOwnedRelDomainNodes().clear();
				getOwnedRelDomainNodes().addAll((Collection<? extends RelDomainNode>)newValue);
				return;
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES:
				getOwnedRelInvocationNodes().clear();
				getOwnedRelInvocationNodes().addAll((Collection<? extends RelInvocationNode>)newValue);
				return;
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
				setOwningTxDiagram((TxDiagram)newValue);
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
			case UMLXPackage.REL_DIAGRAM__IS_TOP:
				setIsTop(IS_TOP_EDEFAULT);
				return;
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES:
				getOwnedRelDomainNodes().clear();
				return;
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES:
				getOwnedRelInvocationNodes().clear();
				return;
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
				setOwningTxDiagram((TxDiagram)null);
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
			case UMLXPackage.REL_DIAGRAM__IS_TOP:
				return isTop != IS_TOP_EDEFAULT;
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES:
				return ownedRelDomainNodes != null && !ownedRelDomainNodes.isEmpty();
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES:
				return ownedRelInvocationNodes != null && !ownedRelInvocationNodes.isEmpty();
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
				return getOwningTxDiagram() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitRelDiagram(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
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
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelDomainNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelInvocationNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningTxDiagram((TxDiagram)otherEnd, msgs);
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
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_DOMAIN_NODES:
				return ((InternalEList<?>)getOwnedRelDomainNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.REL_DIAGRAM__OWNED_REL_INVOCATION_NODES:
				return ((InternalEList<?>)getOwnedRelInvocationNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
				return basicSetOwningTxDiagram(null, msgs);
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
			case UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS, TxDiagram.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

} //RelDiagramImpl
