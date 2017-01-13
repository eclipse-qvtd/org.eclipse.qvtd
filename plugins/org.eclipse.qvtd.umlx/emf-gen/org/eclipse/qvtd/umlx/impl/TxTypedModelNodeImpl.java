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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxTransformationNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.util.UMLXVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tx Typed Model Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl#getTxTransformationNode <em>Tx Transformation Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl#getTxPackageNodes <em>Tx Package Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl#isCheck <em>Check</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl#isEnforce <em>Enforce</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxTypedModelNodeImpl extends TxNodeImpl implements TxTypedModelNode {
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
	 * The cached value of the '{@link #getTxPackageNodes() <em>Tx Package Nodes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTxPackageNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<TxPackageNode> txPackageNodes;

	/**
	 * The default value of the '{@link #isCheck() <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheck()
	 * @generated
	 * @ordered
	 */
	protected static final boolean CHECK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isCheck() <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCheck()
	 * @generated
	 * @ordered
	 */
	protected boolean check = CHECK_EDEFAULT;

	/**
	 * The default value of the '{@link #isEnforce() <em>Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnforce()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENFORCE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEnforce() <em>Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnforce()
	 * @generated
	 * @ordered
	 */
	protected boolean enforce = ENFORCE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TxTypedModelNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UMLXPackage.Literals.TX_TYPED_MODEL_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TxTransformationNode getTxTransformationNode() {
		if (eContainerFeatureID() != UMLXPackage.TX_TYPED_MODEL_NODE__TX_TRANSFORMATION_NODE) return null;
		return (TxTransformationNode)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTxTransformationNode(TxTransformationNode newTxTransformationNode, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newTxTransformationNode, UMLXPackage.TX_TYPED_MODEL_NODE__TX_TRANSFORMATION_NODE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTxTransformationNode(TxTransformationNode newTxTransformationNode) {
		if (newTxTransformationNode != eInternalContainer() || (eContainerFeatureID() != UMLXPackage.TX_TYPED_MODEL_NODE__TX_TRANSFORMATION_NODE && newTxTransformationNode != null)) {
			if (EcoreUtil.isAncestor(this, newTxTransformationNode))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newTxTransformationNode != null)
				msgs = ((InternalEObject)newTxTransformationNode).eInverseAdd(this, UMLXPackage.TX_TRANSFORMATION_NODE__TX_TYPED_MODEL_NODES, TxTransformationNode.class, msgs);
			msgs = basicSetTxTransformationNode(newTxTransformationNode, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_TYPED_MODEL_NODE__TX_TRANSFORMATION_NODE, newTxTransformationNode, newTxTransformationNode));
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
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_TYPED_MODEL_NODE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TxPackageNode> getTxPackageNodes() {
		if (txPackageNodes == null) {
			txPackageNodes = new EObjectContainmentEList<TxPackageNode>(TxPackageNode.class, this, UMLXPackage.TX_TYPED_MODEL_NODE__TX_PACKAGE_NODES);
		}
		return txPackageNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isCheck() {
		return check;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCheck(boolean newCheck) {
		boolean oldCheck = check;
		check = newCheck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_TYPED_MODEL_NODE__CHECK, oldCheck, check));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnforce() {
		return enforce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnforce(boolean newEnforce) {
		boolean oldEnforce = enforce;
		enforce = newEnforce;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UMLXPackage.TX_TYPED_MODEL_NODE__ENFORCE, oldEnforce, enforce));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UMLXPackage.TX_TYPED_MODEL_NODE__TX_TRANSFORMATION_NODE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetTxTransformationNode((TxTransformationNode)otherEnd, msgs);
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
			case UMLXPackage.TX_TYPED_MODEL_NODE__TX_TRANSFORMATION_NODE:
				return basicSetTxTransformationNode(null, msgs);
			case UMLXPackage.TX_TYPED_MODEL_NODE__TX_PACKAGE_NODES:
				return ((InternalEList<?>)getTxPackageNodes()).basicRemove(otherEnd, msgs);
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
			case UMLXPackage.TX_TYPED_MODEL_NODE__TX_TRANSFORMATION_NODE:
				return eInternalContainer().eInverseRemove(this, UMLXPackage.TX_TRANSFORMATION_NODE__TX_TYPED_MODEL_NODES, TxTransformationNode.class, msgs);
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
			case UMLXPackage.TX_TYPED_MODEL_NODE__TX_TRANSFORMATION_NODE:
				return getTxTransformationNode();
			case UMLXPackage.TX_TYPED_MODEL_NODE__NAME:
				return getName();
			case UMLXPackage.TX_TYPED_MODEL_NODE__TX_PACKAGE_NODES:
				return getTxPackageNodes();
			case UMLXPackage.TX_TYPED_MODEL_NODE__CHECK:
				return isCheck();
			case UMLXPackage.TX_TYPED_MODEL_NODE__ENFORCE:
				return isEnforce();
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
			case UMLXPackage.TX_TYPED_MODEL_NODE__TX_TRANSFORMATION_NODE:
				setTxTransformationNode((TxTransformationNode)newValue);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__NAME:
				setName((String)newValue);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__TX_PACKAGE_NODES:
				getTxPackageNodes().clear();
				getTxPackageNodes().addAll((Collection<? extends TxPackageNode>)newValue);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__CHECK:
				setCheck((Boolean)newValue);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__ENFORCE:
				setEnforce((Boolean)newValue);
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
			case UMLXPackage.TX_TYPED_MODEL_NODE__TX_TRANSFORMATION_NODE:
				setTxTransformationNode((TxTransformationNode)null);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__TX_PACKAGE_NODES:
				getTxPackageNodes().clear();
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__CHECK:
				setCheck(CHECK_EDEFAULT);
				return;
			case UMLXPackage.TX_TYPED_MODEL_NODE__ENFORCE:
				setEnforce(ENFORCE_EDEFAULT);
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
			case UMLXPackage.TX_TYPED_MODEL_NODE__TX_TRANSFORMATION_NODE:
				return getTxTransformationNode() != null;
			case UMLXPackage.TX_TYPED_MODEL_NODE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case UMLXPackage.TX_TYPED_MODEL_NODE__TX_PACKAGE_NODES:
				return txPackageNodes != null && !txPackageNodes.isEmpty();
			case UMLXPackage.TX_TYPED_MODEL_NODE__CHECK:
				return check != CHECK_EDEFAULT;
			case UMLXPackage.TX_TYPED_MODEL_NODE__ENFORCE:
				return enforce != ENFORCE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull UMLXVisitor<R> visitor) {
		return visitor.visitTxTypedModelNode(this);
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

} //TxTypedModelNodeImpl
