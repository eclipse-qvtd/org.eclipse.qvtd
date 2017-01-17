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
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getOwnedDiagrams <em>Owned Diagrams</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getPackage <em>Package</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getTxImportNodes <em>Tx Import Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getTxKeyNodes <em>Tx Key Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl#getTxTypedModelNodes <em>Tx Typed Model Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxDiagramImpl extends UMLXDiagramImpl implements TxDiagram {
	/**
	 * The cached value of the '{@link #getOwnedDiagrams() <em>Owned Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<RelDiagram> ownedDiagrams;

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
	 * The cached value of the '{@link #getTxImportNodes() <em>Tx Import Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTxImportNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxImportNode> txImportNodes;

	/**
	 * The cached value of the '{@link #getTxKeyNodes() <em>Tx Key Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTxKeyNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxKeyNode> txKeyNodes;
	/**
	 * The cached value of the '{@link #getTxTypedModelNodes() <em>Tx Typed Model Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTxTypedModelNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxTypedModelNode> txTypedModelNodes;

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
	public EList<RelDiagram> getOwnedDiagrams() {
		if (ownedDiagrams == null) {
			ownedDiagrams = new EObjectContainmentWithInverseEList<RelDiagram>(RelDiagram.class, this, UMLXPackage.TX_DIAGRAM__OWNED_DIAGRAMS, UMLXPackage.REL_DIAGRAM__TX_DIAGRAM);
		}
		return ownedDiagrams;
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
	public EList<TxImportNode> getTxImportNodes() {
		if (txImportNodes == null) {
			txImportNodes = new EObjectContainmentWithInverseEList<TxImportNode>(TxImportNode.class, this, UMLXPackage.TX_DIAGRAM__TX_IMPORT_NODES, UMLXPackage.TX_IMPORT_NODE__TX_DIAGRAM);
		}
		return txImportNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxKeyNode> getTxKeyNodes() {
		if (txKeyNodes == null) {
			txKeyNodes = new EObjectContainmentWithInverseEList<TxKeyNode>(TxKeyNode.class, this, UMLXPackage.TX_DIAGRAM__TX_KEY_NODES, UMLXPackage.TX_KEY_NODE__TX_DIAGRAM);
		}
		return txKeyNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxTypedModelNode> getTxTypedModelNodes() {
		if (txTypedModelNodes == null) {
			txTypedModelNodes = new EObjectContainmentWithInverseEList<TxTypedModelNode>(TxTypedModelNode.class, this, UMLXPackage.TX_DIAGRAM__TX_TYPED_MODEL_NODES, UMLXPackage.TX_TYPED_MODEL_NODE__TX_DIAGRAM);
		}
		return txTypedModelNodes;
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
			case UMLXPackage.TX_DIAGRAM__OWNED_DIAGRAMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedDiagrams()).basicAdd(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__TX_IMPORT_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTxImportNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__TX_KEY_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTxKeyNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__TX_TYPED_MODEL_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTxTypedModelNodes()).basicAdd(otherEnd, msgs);
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
			case UMLXPackage.TX_DIAGRAM__OWNED_DIAGRAMS:
				return ((InternalEList<?>)getOwnedDiagrams()).basicRemove(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__TX_IMPORT_NODES:
				return ((InternalEList<?>)getTxImportNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__TX_KEY_NODES:
				return ((InternalEList<?>)getTxKeyNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.TX_DIAGRAM__TX_TYPED_MODEL_NODES:
				return ((InternalEList<?>)getTxTypedModelNodes()).basicRemove(otherEnd, msgs);
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
			case UMLXPackage.TX_DIAGRAM__OWNED_DIAGRAMS:
				return getOwnedDiagrams();
			case UMLXPackage.TX_DIAGRAM__PACKAGE:
				return getPackage();
			case UMLXPackage.TX_DIAGRAM__TX_IMPORT_NODES:
				return getTxImportNodes();
			case UMLXPackage.TX_DIAGRAM__TX_KEY_NODES:
				return getTxKeyNodes();
			case UMLXPackage.TX_DIAGRAM__TX_TYPED_MODEL_NODES:
				return getTxTypedModelNodes();
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
			case UMLXPackage.TX_DIAGRAM__OWNED_DIAGRAMS:
				getOwnedDiagrams().clear();
				getOwnedDiagrams().addAll((Collection<? extends RelDiagram>)newValue);
				return;
			case UMLXPackage.TX_DIAGRAM__PACKAGE:
				setPackage((String)newValue);
				return;
			case UMLXPackage.TX_DIAGRAM__TX_IMPORT_NODES:
				getTxImportNodes().clear();
				getTxImportNodes().addAll((Collection<? extends TxImportNode>)newValue);
				return;
			case UMLXPackage.TX_DIAGRAM__TX_KEY_NODES:
				getTxKeyNodes().clear();
				getTxKeyNodes().addAll((Collection<? extends TxKeyNode>)newValue);
				return;
			case UMLXPackage.TX_DIAGRAM__TX_TYPED_MODEL_NODES:
				getTxTypedModelNodes().clear();
				getTxTypedModelNodes().addAll((Collection<? extends TxTypedModelNode>)newValue);
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
			case UMLXPackage.TX_DIAGRAM__OWNED_DIAGRAMS:
				getOwnedDiagrams().clear();
				return;
			case UMLXPackage.TX_DIAGRAM__PACKAGE:
				setPackage(PACKAGE_EDEFAULT);
				return;
			case UMLXPackage.TX_DIAGRAM__TX_IMPORT_NODES:
				getTxImportNodes().clear();
				return;
			case UMLXPackage.TX_DIAGRAM__TX_KEY_NODES:
				getTxKeyNodes().clear();
				return;
			case UMLXPackage.TX_DIAGRAM__TX_TYPED_MODEL_NODES:
				getTxTypedModelNodes().clear();
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
			case UMLXPackage.TX_DIAGRAM__OWNED_DIAGRAMS:
				return ownedDiagrams != null && !ownedDiagrams.isEmpty();
			case UMLXPackage.TX_DIAGRAM__PACKAGE:
				return PACKAGE_EDEFAULT == null ? package_ != null : !PACKAGE_EDEFAULT.equals(package_);
			case UMLXPackage.TX_DIAGRAM__TX_IMPORT_NODES:
				return txImportNodes != null && !txImportNodes.isEmpty();
			case UMLXPackage.TX_DIAGRAM__TX_KEY_NODES:
				return txKeyNodes != null && !txKeyNodes.isEmpty();
			case UMLXPackage.TX_DIAGRAM__TX_TYPED_MODEL_NODES:
				return txTypedModelNodes != null && !txTypedModelNodes.isEmpty();
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
