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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class PredicateEdgeImpl extends EdgeImpl implements PredicateEdge {
	/**
	 * The number of structural features of the '<em>Predicate Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PREDICATE_EDGE_FEATURE_COUNT = EdgeImpl.EDGE_FEATURE_COUNT + 0;
	/**
	 * The number of operations of the '<em>Predicate Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PREDICATE_EDGE_OPERATION_COUNT = EdgeImpl.EDGE_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredicateEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.PREDICATE_EDGE;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitPredicateEdge(this);
	}

	@Override
	public @NonNull String getDisplayName() {
		return "«predicate»" + getTargetNode().getDisplayName();
	}

	@Override
	public final boolean isComputation() {
		return true;
	}

	@Override
	public boolean isExpression() {
		return true;			// FIXME
	}

	@Override
	public final boolean isPredicate() {
		return true;
	}
} //PredicateEdgeImpl
