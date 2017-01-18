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
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxImportNode;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tx Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedRelDiagrams <em>Owned Rel Diagrams</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedTxImportNodes <em>Owned Tx Import Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedTxKeyNodes <em>Owned Tx Key Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedTxTypedModelNodes <em>Owned Tx Typed Model Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getPackage <em>Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxDiagramImpl extends UMLXNamedElementImpl implements TxDiagram {
	/**
	 * The cached value of the '{@link #getOwnedRelDiagrams() <em>Owned Rel Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRelDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<RelDiagram> ownedRelDiagrams;

	/**
	 * The cached value of the '{@link #getOwnedTxImportNodes() <em>Owned Tx Import Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTxImportNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxImportNode> ownedTxImportNodes;

	/**
	 * The cached value of the '{@link #getOwnedTxKeyNodes() <em>Owned Tx Key Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTxKeyNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxKeyNode> ownedTxKeyNodes;

	/**
	 * The cached value of the '{@link #getOwnedTxTypedModelNodes() <em>Owned Tx Typed Model Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTxTypedModelNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxTypedModelNode> ownedTxTypedModelNodes;

	/**
	 * The default value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getPackage() <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackage()
	 * @generated
	 * @ordered
	 */
	protected String package_ = PACKAGE_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TxDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.TX_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelDiagram> getOwnedRelDiagrams() {
		if (ownedRelDiagrams == null) {
			ownedRelDiagrams = new EObjectContainmentWithInverseEList<RelDiagram>(RelDiagram.class, this, UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS, UMLXPackage.REL_DIAGRAM__OWNING_TX_DIAGRAM);
		}
		return ownedRelDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxImportNode> getOwnedTxImportNodes() {
		if (ownedTxImportNodes == null) {
			ownedTxImportNodes = new EObjectContainmentWithInverseEList<TxImportNode>(TxImportNode.class, this, UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES, UMLXPackage.TX_IMPORT_NODE__OWNING_TX_DIAGRAM);
		}
		return ownedTxImportNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxKeyNode> getOwnedTxKeyNodes() {
		if (ownedTxKeyNodes == null) {
			ownedTxKeyNodes = new EObjectContainmentWithInverseEList<TxKeyNode>(TxKeyNode.class, this, UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES, UMLXPackage.TX_KEY_NODE__OWNING_TX_DIAGRAM);
		}
		return ownedTxKeyNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxTypedModelNode> getOwnedTxTypedModelNodes() {
		if (ownedTxTypedModelNodes == null) {
			ownedTxTypedModelNodes = new EObjectContainmentWithInverseEList<TxTypedModelNode>(TxTypedModelNode.class, this, UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES, UMLXPackage.TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM);
		}
		return ownedTxTypedModelNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPackage() {
		return package_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPackage(String newPackage) {
		String oldPackage = package_;
		package_ = newPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_DIAGRAM__PACKAGE, oldPackage, package_));
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
			case UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRelDiagrams()).basicAdd(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxImportNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxKeyNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedTxTypedModelNodes()).basicAdd(otherEnd, msgs);
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
			case UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS:
				return ((InternalEList<?>)getOwnedRelDiagrams()).basicRemove(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES:
				return ((InternalEList<?>)getOwnedTxImportNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES:
				return ((InternalEList<?>)getOwnedTxKeyNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES:
				return ((InternalEList<?>)getOwnedTxTypedModelNodes()).basicRemove(otherEnd, msgs);
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
			case UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS:
				return getOwnedRelDiagrams();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES:
				return getOwnedTxImportNodes();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES:
				return getOwnedTxKeyNodes();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES:
				return getOwnedTxTypedModelNodes();
			case UMLXPackage.TX_DIAGRAM__PACKAGE:
				return getPackage();
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
			case UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS:
				getOwnedRelDiagrams().clear();
				getOwnedRelDiagrams().addAll((Collection<? extends RelDiagram>)newValue);
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES:
				getOwnedTxImportNodes().clear();
				getOwnedTxImportNodes().addAll((Collection<? extends TxImportNode>)newValue);
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES:
				getOwnedTxKeyNodes().clear();
				getOwnedTxKeyNodes().addAll((Collection<? extends TxKeyNode>)newValue);
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES:
				getOwnedTxTypedModelNodes().clear();
				getOwnedTxTypedModelNodes().addAll((Collection<? extends TxTypedModelNode>)newValue);
				return;
			case UMLXPackage.TX_DIAGRAM__PACKAGE:
				setPackage((String)newValue);
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
			case UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS:
				getOwnedRelDiagrams().clear();
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES:
				getOwnedTxImportNodes().clear();
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES:
				getOwnedTxKeyNodes().clear();
				return;
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES:
				getOwnedTxTypedModelNodes().clear();
				return;
			case UMLXPackage.TX_DIAGRAM__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
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
			case UMLXPackage.TX_DIAGRAM__OWNED_REL_DIAGRAMS:
				return ownedRelDiagrams != null && !ownedRelDiagrams.isEmpty();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_IMPORT_NODES:
				return ownedTxImportNodes != null && !ownedTxImportNodes.isEmpty();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_KEY_NODES:
				return ownedTxKeyNodes != null && !ownedTxKeyNodes.isEmpty();
			case UMLXPackage.TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES:
				return ownedTxTypedModelNodes != null && !ownedTxTypedModelNodes.isEmpty();
			case UMLXPackage.TX_DIAGRAM__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitTxDiagram(this);
	}

} //TxDiagramImpl
