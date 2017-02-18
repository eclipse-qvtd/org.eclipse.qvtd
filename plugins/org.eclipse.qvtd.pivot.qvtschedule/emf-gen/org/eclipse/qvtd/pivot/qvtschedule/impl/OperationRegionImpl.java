/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl#getDependencyNodes <em>Dependency Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl#getHeadNodes <em>Head Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl#getReferredOperation <em>Referred Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl#getResultNode <em>Result Node</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OperationRegionImpl extends RegionImpl implements OperationRegion {
	/**
	 * The cached value of the '{@link #getDependencyNodes() <em>Dependency Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencyNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> dependencyNodes;
	/**
	 * The cached value of the '{@link #getHeadNodes() <em>Head Nodes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHeadNodes()
	 * @generated
	 * @ordered
	 */
	protected EList<Node> headNodes;
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
	 * The cached value of the '{@link #getReferredOperation() <em>Referred Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation referredOperation;
	/**
	 * The cached value of the '{@link #getResultNode() <em>Result Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultNode()
	 * @generated
	 * @ordered
	 */
	protected Node resultNode;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.OPERATION_REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Node> getDependencyNodes() {
		if (dependencyNodes == null) {
			dependencyNodes = new EObjectResolvingEList<Node>(Node.class, this, QVTschedulePackage.OPERATION_REGION__DEPENDENCY_NODES);
		}
		return dependencyNodes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Node> getHeadNodes() {
		if (headNodes == null) {
			headNodes = new EObjectResolvingEList<Node>(Node.class, this, QVTschedulePackage.OPERATION_REGION__HEAD_NODES);
		}
		return headNodes;
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.OPERATION_REGION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getReferredOperation() {
		if (referredOperation != null && referredOperation.eIsProxy()) {
			InternalEObject oldReferredOperation = (InternalEObject)referredOperation;
			referredOperation = (Operation)eResolveProxy(oldReferredOperation);
			if (referredOperation != oldReferredOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.OPERATION_REGION__REFERRED_OPERATION, oldReferredOperation, referredOperation));
			}
		}
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetReferredOperation() {
		return referredOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredOperation(Operation newReferredOperation) {
		Operation oldReferredOperation = referredOperation;
		referredOperation = newReferredOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.OPERATION_REGION__REFERRED_OPERATION, oldReferredOperation, referredOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Node getResultNode() {
		if (resultNode != null && resultNode.eIsProxy()) {
			InternalEObject oldResultNode = (InternalEObject)resultNode;
			resultNode = (Node)eResolveProxy(oldResultNode);
			if (resultNode != oldResultNode) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.OPERATION_REGION__RESULT_NODE, oldResultNode, resultNode));
			}
		}
		return resultNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node basicGetResultNode() {
		return resultNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResultNode(Node newResultNode) {
		Node oldResultNode = resultNode;
		resultNode = newResultNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.OPERATION_REGION__RESULT_NODE, oldResultNode, resultNode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.OPERATION_REGION__DEPENDENCY_NODES:
				return getDependencyNodes();
			case QVTschedulePackage.OPERATION_REGION__HEAD_NODES:
				return getHeadNodes();
			case QVTschedulePackage.OPERATION_REGION__NAME:
				return getName();
			case QVTschedulePackage.OPERATION_REGION__REFERRED_OPERATION:
				if (resolve) return getReferredOperation();
				return basicGetReferredOperation();
			case QVTschedulePackage.OPERATION_REGION__RESULT_NODE:
				if (resolve) return getResultNode();
				return basicGetResultNode();
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
			case QVTschedulePackage.OPERATION_REGION__DEPENDENCY_NODES:
				getDependencyNodes().clear();
				getDependencyNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case QVTschedulePackage.OPERATION_REGION__HEAD_NODES:
				getHeadNodes().clear();
				getHeadNodes().addAll((Collection<? extends Node>)newValue);
				return;
			case QVTschedulePackage.OPERATION_REGION__NAME:
				setName((String)newValue);
				return;
			case QVTschedulePackage.OPERATION_REGION__REFERRED_OPERATION:
				setReferredOperation((Operation)newValue);
				return;
			case QVTschedulePackage.OPERATION_REGION__RESULT_NODE:
				setResultNode((Node)newValue);
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
			case QVTschedulePackage.OPERATION_REGION__DEPENDENCY_NODES:
				getDependencyNodes().clear();
				return;
			case QVTschedulePackage.OPERATION_REGION__HEAD_NODES:
				getHeadNodes().clear();
				return;
			case QVTschedulePackage.OPERATION_REGION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case QVTschedulePackage.OPERATION_REGION__REFERRED_OPERATION:
				setReferredOperation((Operation)null);
				return;
			case QVTschedulePackage.OPERATION_REGION__RESULT_NODE:
				setResultNode((Node)null);
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
			case QVTschedulePackage.OPERATION_REGION__DEPENDENCY_NODES:
				return dependencyNodes != null && !dependencyNodes.isEmpty();
			case QVTschedulePackage.OPERATION_REGION__HEAD_NODES:
				return headNodes != null && !headNodes.isEmpty();
			case QVTschedulePackage.OPERATION_REGION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case QVTschedulePackage.OPERATION_REGION__REFERRED_OPERATION:
				return referredOperation != null;
			case QVTschedulePackage.OPERATION_REGION__RESULT_NODE:
				return resultNode != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public @NonNull String toString() {
		return super.toString();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitOperationRegion(this);
	}

	@Override
	public void addDependencyNode(@NonNull Node dependencyNode) {
		getDependencyNodes().add(dependencyNode);
	}

	@Override
	public void addHeadNode(@NonNull Node headNode) {
		getHeadNodes().add(headNode);
	}

	@Override
	protected @NonNull SymbolNameBuilder computeSymbolName() {
		SymbolNameBuilder s = new SymbolNameBuilder();
		s.appendString("o_");
		s.appendName(name);
		return s;
	}

	@Override
	public boolean isOperationRegion() {
		return true;
	}
} //OperationRegionImpl
