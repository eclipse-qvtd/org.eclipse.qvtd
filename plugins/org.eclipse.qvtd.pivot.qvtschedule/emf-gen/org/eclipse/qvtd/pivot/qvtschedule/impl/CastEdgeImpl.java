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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeRole;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;

import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cast Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class CastEdgeImpl extends NavigableEdgeImpl implements CastEdge {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CastEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.CAST_EDGE;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitCastEdge(this);
	}
	private static @NonNull CastEdgeImpl create(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		CastEdgeImpl edge = new CastEdgeImpl();
		edge.initialize(edgeRole, sourceNode, source2targetProperty, targetNode);
		return edge;
	}

	/**
	 * Create, install and return the edgeRole edge for source2targetProperty from sourceNode to targetNode. If
	 * source2targetProperty has an opposite, the opposite edge is also created and installed.
	 */
	public static @NonNull NavigableEdge createEdge(@NonNull EdgeRole edgeRole,
			@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		CastEdgeImpl forwardEdge = create(edgeRole, sourceNode, source2targetProperty, targetNode);
		Property target2sourceProperty = source2targetProperty.getOpposite();
		if ((target2sourceProperty != null) && !targetNode.isExplicitNull()) {
			assert (targetNode.getNavigationEdge(target2sourceProperty) == null) || target2sourceProperty.isIsMany();
			if (!source2targetProperty.isIsMany() && !target2sourceProperty.isIsMany() /*&& target2sourceProperty.isIsRequired()*/) {		// FIXME do we need stronger type conformance here ??
				CastEdgeImpl reverseEdge = create(edgeRole, targetNode, target2sourceProperty, sourceNode);
				forwardEdge.initializeOpposite(reverseEdge);
			}
		}
		return forwardEdge;
	}

	@Override
	public @NonNull NavigableEdge createEdge(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		return createEdge(edgeRole, sourceNode, getProperty(), targetNode);
	}

	@Override
	public final boolean isCast() {
		return true;
	}

	@Override
	public final boolean isNavigation() {
		return true;
	}

	@Override
	public void setEdgeRole(@NonNull EdgeRole edgeRole) {
		assert !edgeRole.isNew();
		super.setEdgeRole(edgeRole);
	}

	@Override
	public void setSource(@Nullable Node sourceNode) {
		assert (sourceNode == null) || !sourceNode.isExplicitNull();
		super.setSource(sourceNode);
	}

	@Override
	public void setTarget(@Nullable Node targetNode) {
		assert (targetNode == null) || !targetNode.isExplicitNull();
		super.setTarget(targetNode);
	}
} //CastEdgeImpl
