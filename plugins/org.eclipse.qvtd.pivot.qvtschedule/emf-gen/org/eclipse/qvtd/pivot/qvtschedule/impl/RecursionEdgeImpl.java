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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeRole;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge;

import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Recursion Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class RecursionEdgeImpl extends EdgeImpl implements RecursionEdge {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecursionEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.RECURSION_EDGE;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitRecursionEdge(this);
	}

	public static @NonNull RecursionEdgeImpl create(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode, boolean isPrimary) {
		RecursionEdgeImpl edge = new RecursionEdgeImpl();
		edge.initialize(edgeRole, sourceNode, null, targetNode);
		edge.isPrimary = isPrimary;
		return edge;
	}

	private boolean isPrimary = false;

	@Override
	public @NonNull Edge createEdge(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		return create(edgeRole, sourceNode, targetNode, isPrimary);
	}

	@Override
	public @NonNull String getColor() {
		return QVTscheduleConstants.RECURSION_COLOR;
	}

	@Override
	public final boolean isRecursion() {
		return true;
	}
} //RecursionEdgeImpl
