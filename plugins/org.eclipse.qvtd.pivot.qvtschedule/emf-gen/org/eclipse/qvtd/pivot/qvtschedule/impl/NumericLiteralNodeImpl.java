/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Numeric Literal Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NumericLiteralNodeImpl#getNumericValue <em>Numeric Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NumericLiteralNodeImpl extends OperationNodeImpl implements NumericLiteralNode {
	/**
	 * The default value of the '{@link #getNumericValue() <em>Numeric Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumericValue()
	 * @generated
	 * @ordered
	 */
	protected static final Number NUMERIC_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNumericValue() <em>Numeric Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumericValue()
	 * @generated
	 * @ordered
	 */
	protected Number numericValue = NUMERIC_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumericLiteralNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.NUMERIC_LITERAL_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Number getNumericValue() {
		return numericValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNumericValue(Number newNumericValue) {
		Number oldNumericValue = numericValue;
		numericValue = newNumericValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.NUMERIC_LITERAL_NODE__NUMERIC_VALUE, oldNumericValue, numericValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.NUMERIC_LITERAL_NODE__NUMERIC_VALUE:
				return getNumericValue();
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
			case QVTschedulePackage.NUMERIC_LITERAL_NODE__NUMERIC_VALUE:
				setNumericValue((Number)newValue);
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
			case QVTschedulePackage.NUMERIC_LITERAL_NODE__NUMERIC_VALUE:
				setNumericValue(NUMERIC_VALUE_EDEFAULT);
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
			case QVTschedulePackage.NUMERIC_LITERAL_NODE__NUMERIC_VALUE:
				return NUMERIC_VALUE_EDEFAULT == null ? numericValue != null : !NUMERIC_VALUE_EDEFAULT.equals(numericValue);
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitNumericLiteralNode(this);
	}

	@Override
	public @NonNull Node createNode(@NonNull Role nodeRole, @NonNull Region region) {
		assert nodeRole == Role.CONSTANT;
		NumericLiteralNode node = (NumericLiteralNode)super.createNode(nodeRole, region);
		node.setNumericValue(numericValue);
		return node;
	}

	@Override
	public boolean isPrimitive() {
		return true;
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
} //NumericLiteralNodeImpl