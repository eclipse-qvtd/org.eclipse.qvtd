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
import org.eclipse.qvtd.umlx.RelNode;
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
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl#getOwnedNodes <em>Owned Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl#getTxDiagram <em>Tx Diagram</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelDiagramImpl extends UMLXDiagramImpl implements RelDiagram {
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
	 * The cached value of the '{@link #getOwnedNodes() <em>Owned Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<RelNode> ownedNodes;

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
	public EList<RelNode> getOwnedNodes() {
		if (ownedNodes == null) {
			ownedNodes = new EObjectContainmentWithInverseEList<RelNode>(RelNode.class, this, UMLXPackage.REL_DIAGRAM__OWNED_NODES, UMLXPackage.REL_NODE__DIAGRAM);
		}
		return ownedNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxDiagram getTxDiagram() {
		if (eContainerFeatureID() != UMLXPackage.REL_DIAGRAM__TX_DIAGRAM) return null;
		return (TxDiagram)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTxDiagram(TxDiagram newTxDiagram, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTxDiagram, UMLXPackage.REL_DIAGRAM__TX_DIAGRAM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTxDiagram(TxDiagram newTxDiagram) {
		if (newTxDiagram != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.REL_DIAGRAM__TX_DIAGRAM && newTxDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newTxDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTxDiagram != null)
				msgs = ((InternalEObject)newTxDiagram).eInverseAdd(this, UMLXPackage.TX_DIAGRAM__OWNED_DIAGRAMS, TxDiagram.class, msgs);
			msgs = basicSetTxDiagram(newTxDiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.REL_DIAGRAM__TX_DIAGRAM, newTxDiagram, newTxDiagram));
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
			case UMLXPackage.REL_DIAGRAM__OWNED_NODES:
				return getOwnedNodes();
			case UMLXPackage.REL_DIAGRAM__TX_DIAGRAM:
				return getTxDiagram();
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
			case UMLXPackage.REL_DIAGRAM__OWNED_NODES:
				getOwnedNodes().clear();
				getOwnedNodes().addAll((Collection<? extends RelNode>)newValue);
				return;
			case UMLXPackage.REL_DIAGRAM__TX_DIAGRAM:
				setTxDiagram((TxDiagram)newValue);
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
			case UMLXPackage.REL_DIAGRAM__OWNED_NODES:
				getOwnedNodes().clear();
				return;
			case UMLXPackage.REL_DIAGRAM__TX_DIAGRAM:
				setTxDiagram((TxDiagram)null);
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
			case UMLXPackage.REL_DIAGRAM__OWNED_NODES:
				return ownedNodes != null && !ownedNodes.isEmpty();
			case UMLXPackage.REL_DIAGRAM__TX_DIAGRAM:
				return getTxDiagram() != null;
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
			case UMLXPackage.REL_DIAGRAM__OWNED_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.REL_DIAGRAM__TX_DIAGRAM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTxDiagram((TxDiagram)otherEnd, msgs);
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
			case UMLXPackage.REL_DIAGRAM__OWNED_NODES:
				return ((InternalEList<?>)getOwnedNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.REL_DIAGRAM__TX_DIAGRAM:
				return basicSetTxDiagram(null, msgs);
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
			case UMLXPackage.REL_DIAGRAM__TX_DIAGRAM:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.TX_DIAGRAM__OWNED_DIAGRAMS, TxDiagram.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

} //RelDiagramImpl
