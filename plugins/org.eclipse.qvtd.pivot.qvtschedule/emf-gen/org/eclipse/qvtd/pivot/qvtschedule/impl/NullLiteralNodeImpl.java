/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Null Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class NullLiteralNodeImpl extends OperationNodeImpl implements NullLiteralNode {
	/**
	 * The number of structural features of the '<em>Null Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NULL_LITERAL_NODE_FEATURE_COUNT = OperationNodeImpl.OPERATION_NODE_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Null Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NULL_LITERAL_NODE_OPERATION_COUNT = OperationNodeImpl.OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NullLiteralNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.NULL_LITERAL_NODE;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTscheduleVisitor) {
			return (R) ((QVTscheduleVisitor<?>)visitor).visitNullLiteralNode(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	@Override
	public @NonNull Node createNode(@NonNull Role nodeRole, @NonNull Region region) {
		assert nodeRole == Role.CONSTANT;
		NullLiteralNode node = (NullLiteralNode)super.createNode(nodeRole, region);
		return node;
	}

	@Override
	public @Nullable String getShape() {
		return null;		// rectangle
	}

	@Override
	public boolean isNullLiteral() {
		return true;
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
} //NullNodeImpl
