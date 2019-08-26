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
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.IteratorNode;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
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
	 * The number of structural features of the '<em>Iterator Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ITERATOR_NODE_FEATURE_COUNT = VariableNodeImpl.VARIABLE_NODE_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Iterator Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ITERATOR_NODE_OPERATION_COUNT = VariableNodeImpl.VARIABLE_NODE_OPERATION_COUNT + 0;

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
		try {
			return (R) ((QVTscheduleVisitor<?>)visitor).visitIteratorNode(this);
		}
		catch (ClassCastException e) {
			return super.accept(visitor);
		}
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
