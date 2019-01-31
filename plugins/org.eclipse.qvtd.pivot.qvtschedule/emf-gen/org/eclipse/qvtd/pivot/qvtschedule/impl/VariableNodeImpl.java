/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.VariableNodeImpl#getReferredVariable <em>Referred Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class VariableNodeImpl extends MappingNodeImpl implements VariableNode {
	/**
	 * The number of structural features of the '<em>Variable Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_NODE_FEATURE_COUNT = MappingNodeImpl.MAPPING_NODE_FEATURE_COUNT + 1;
	/**
	 * The number of operations of the '<em>Variable Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VARIABLE_NODE_OPERATION_COUNT = MappingNodeImpl.MAPPING_NODE_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getReferredVariable() <em>Referred Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredVariable()
	 * @generated
	 * @ordered
	 */
	protected VariableDeclaration referredVariable;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.VARIABLE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableDeclaration getReferredVariable() {
		if (referredVariable != null && referredVariable.eIsProxy()) {
			InternalEObject oldReferredVariable = (InternalEObject)referredVariable;
			referredVariable = (VariableDeclaration)eResolveProxy(oldReferredVariable);
			if (referredVariable != oldReferredVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MappingNodeImpl.MAPPING_NODE_FEATURE_COUNT + 0, oldReferredVariable, referredVariable));
			}
		}
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration basicGetReferredVariable() {
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredVariable(VariableDeclaration newReferredVariable) {
		VariableDeclaration oldReferredVariable = referredVariable;
		referredVariable = newReferredVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingNodeImpl.MAPPING_NODE_FEATURE_COUNT + 0, oldReferredVariable, referredVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MappingNodeImpl.MAPPING_NODE_FEATURE_COUNT + 0:
				if (resolve) return getReferredVariable();
				return basicGetReferredVariable();
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
			case MappingNodeImpl.MAPPING_NODE_FEATURE_COUNT + 0:
				setReferredVariable((VariableDeclaration)newValue);
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
			case MappingNodeImpl.MAPPING_NODE_FEATURE_COUNT + 0:
				setReferredVariable((VariableDeclaration)null);
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
			case MappingNodeImpl.MAPPING_NODE_FEATURE_COUNT + 0:
				return referredVariable != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public @NonNull Node createNode(@NonNull Role nodeRole, @NonNull Region region) {
		VariableNode node = (VariableNode)super.createNode(nodeRole, region);
		VariableDeclaration referredVariable = getReferredVariable();
		if (referredVariable != null) {
			node.initializeVariable(region, referredVariable);
		}
		return node;
	}

	@Override
	public void initializeVariable(@NonNull Region region, @NonNull VariableDeclaration variable) {
		assert variable != null;
		setReferredVariable(variable);
		assert variable.eContainer() != null;
		assert variable.getName() != null;
		setOriginatingVariable(variable);
		region.addVariableNode(variable, this);
	}

	@Override
	public @NonNull String toString() {
		Role nodeRole = getNodeRole();
		StringBuilder s = new StringBuilder();
		s.append(nodeRole);
		s.append("-");
		s.append(eClass().getName());
		s.append("(");
		s.append(referredVariable != null ? referredVariable.toString() : getName());
		s.append(")");
		return s.toString();
	}
} //VariableNodeImpl
