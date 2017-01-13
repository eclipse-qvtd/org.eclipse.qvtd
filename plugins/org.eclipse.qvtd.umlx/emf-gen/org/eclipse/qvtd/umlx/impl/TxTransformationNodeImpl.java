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
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxTransformationNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tx Transformation Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTransformationNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTransformationNodeImpl#getTxTypedModelNodes <em>Tx Typed Model Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTransformationNodeImpl#getTxKeyNodes <em>Tx Key Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxTransformationNodeImpl extends TxNodeImpl implements TxTransformationNode {
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
	 * The cached value of the '{@link #getTxTypedModelNodes() <em>Tx Typed Model Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTxTypedModelNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxTypedModelNode> txTypedModelNodes;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TxTransformationNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.TX_TRANSFORMATION_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_TRANSFORMATION_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxTypedModelNode> getTxTypedModelNodes() {
		if (txTypedModelNodes == null) {
			txTypedModelNodes = new EObjectContainmentWithInverseEList<TxTypedModelNode>(TxTypedModelNode.class, this, UMLXPackage.TX_TRANSFORMATION_NODE__TX_TYPED_MODEL_NODES, UMLXPackage.TX_TYPED_MODEL_NODE__TX_TRANSFORMATION_NODE);
		}
		return txTypedModelNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxKeyNode> getTxKeyNodes() {
		if (txKeyNodes == null) {
			txKeyNodes = new EObjectContainmentWithInverseEList<TxKeyNode>(TxKeyNode.class, this, UMLXPackage.TX_TRANSFORMATION_NODE__TX_KEY_NODES, UMLXPackage.TX_KEY_NODE__TX_TRANSFORMATION_NODE);
		}
		return txKeyNodes;
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
			case UMLXPackage.TX_TRANSFORMATION_NODE__TX_TYPED_MODEL_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTxTypedModelNodes()).basicAdd(otherEnd, msgs);
			case UMLXPackage.TX_TRANSFORMATION_NODE__TX_KEY_NODES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTxKeyNodes()).basicAdd(otherEnd, msgs);
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
			case UMLXPackage.TX_TRANSFORMATION_NODE__TX_TYPED_MODEL_NODES:
				return ((InternalEList<?>)getTxTypedModelNodes()).basicRemove(otherEnd, msgs);
			case UMLXPackage.TX_TRANSFORMATION_NODE__TX_KEY_NODES:
				return ((InternalEList<?>)getTxKeyNodes()).basicRemove(otherEnd, msgs);
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
			case UMLXPackage.TX_TRANSFORMATION_NODE__NAME:
				return getName();
			case UMLXPackage.TX_TRANSFORMATION_NODE__TX_TYPED_MODEL_NODES:
				return getTxTypedModelNodes();
			case UMLXPackage.TX_TRANSFORMATION_NODE__TX_KEY_NODES:
				return getTxKeyNodes();
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
			case UMLXPackage.TX_TRANSFORMATION_NODE__NAME:
				setName((String)newValue);
				return;
			case UMLXPackage.TX_TRANSFORMATION_NODE__TX_TYPED_MODEL_NODES:
				getTxTypedModelNodes().clear();
				getTxTypedModelNodes().addAll((Collection<? extends TxTypedModelNode>)newValue);
				return;
			case UMLXPackage.TX_TRANSFORMATION_NODE__TX_KEY_NODES:
				getTxKeyNodes().clear();
				getTxKeyNodes().addAll((Collection<? extends TxKeyNode>)newValue);
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
			case UMLXPackage.TX_TRANSFORMATION_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLXPackage.TX_TRANSFORMATION_NODE__TX_TYPED_MODEL_NODES:
				getTxTypedModelNodes().clear();
				return;
			case UMLXPackage.TX_TRANSFORMATION_NODE__TX_KEY_NODES:
				getTxKeyNodes().clear();
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
			case UMLXPackage.TX_TRANSFORMATION_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLXPackage.TX_TRANSFORMATION_NODE__TX_TYPED_MODEL_NODES:
				return txTypedModelNodes != null && !txTypedModelNodes.isEmpty();
			case UMLXPackage.TX_TRANSFORMATION_NODE__TX_KEY_NODES:
				return txKeyNodes != null && !txKeyNodes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitTxTransformationNode(this);
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

} //TxTransformationNodeImpl
