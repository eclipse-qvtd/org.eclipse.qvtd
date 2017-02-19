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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.IteratorNode;
import org.eclipse.qvtd.pivot.qvtschedule.NodeRole;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Iterator Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class IteratorNodeImpl extends VariableNodeImpl implements IteratorNode {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IteratorNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.ITERATOR_NODE;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitIteratorNode(this);
	}

	public static @NonNull VariableNodeImpl create(@NonNull NodeRole nodeRole, @NonNull Region region, @NonNull VariableDeclaration variable) {
		IteratorNodeImpl node = new IteratorNodeImpl();
		node.initialize(nodeRole, region, variable);
		return node;
	}

	@Override
	public @NonNull VariableNodeImpl createNode(@NonNull NodeRole nodeRole, @NonNull Region region) {
		return create(nodeRole, region, getVariable());
	}

	@Override
	public boolean isExpression() {
		return true;
	}

	@Override
	public boolean isIterator() {
		return true;
	}
} //IteratorNodeImpl
