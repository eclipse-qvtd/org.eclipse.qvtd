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

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Boolean Value Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BooleanLiteralNodeImpl#isBooleanValue <em>Boolean Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BooleanLiteralNodeImpl extends OperationNodeImpl implements BooleanLiteralNode {
	/**
	 * The number of structural features of the '<em>Boolean Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_LITERAL_NODE_FEATURE_COUNT = OperationNodeImpl.OPERATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Boolean Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int BOOLEAN_LITERAL_NODE_OPERATION_COUNT = OperationNodeImpl.OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The default value of the '{@link #isBooleanValue() <em>Boolean Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBooleanValue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BOOLEAN_VALUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBooleanValue() <em>Boolean Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBooleanValue()
	 * @generated
	 * @ordered
	 */
	protected boolean booleanValue = BOOLEAN_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BooleanLiteralNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.BOOLEAN_LITERAL_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isBooleanValue() {
		return booleanValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBooleanValue(boolean newBooleanValue) {
		boolean oldBooleanValue = booleanValue;
		booleanValue = newBooleanValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OperationNodeImpl.OPERATION_NODE_FEATURE_COUNT + 0, oldBooleanValue, booleanValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OperationNodeImpl.OPERATION_NODE_FEATURE_COUNT + 0:
				return isBooleanValue();
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
			case OperationNodeImpl.OPERATION_NODE_FEATURE_COUNT + 0:
				setBooleanValue((Boolean)newValue);
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
			case OperationNodeImpl.OPERATION_NODE_FEATURE_COUNT + 0:
				setBooleanValue(BOOLEAN_VALUE_EDEFAULT);
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
			case OperationNodeImpl.OPERATION_NODE_FEATURE_COUNT + 0:
				return booleanValue != BOOLEAN_VALUE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitBooleanLiteralNode(this);
	}

	@Override
	public @NonNull Node createNode(@NonNull Role nodeRole, @NonNull Region region) {
		assert nodeRole == Role.CONSTANT;
		BooleanLiteralNode node = (BooleanLiteralNode)super.createNode(nodeRole, region);
		node.setBooleanValue(booleanValue);
		return node;
	}

	@Override
	public @Nullable String getShape() {
		return null;		// rectangle
	}

	@Override
	public @Nullable String getStyle() {
		return "rounded";
	}

	@Override
	public boolean isPrimitive() {
		return true;
	}

	@Override
	public void setIncomingConnection(NodeConnection newIncomingConnection) {
		assert (incomingConnection == null) || (newIncomingConnection == null);
		super.setIncomingConnection(newIncomingConnection);
	}

	@Override
	public void setUtility(@NonNull Utility utility) {
		assert QVTscheduleUtil.isUnconditional(utility);
		super.setUtility(utility);
	}

	@Override
	public void setNodeRole(Role newNodeRole) {
		assert newNodeRole == Role.CONSTANT;
		super.setNodeRole(newNodeRole);
	}

	@Override
	public @NonNull String toString() {
		return super.toString();
	}
} //BooleanValueNodeImpl
