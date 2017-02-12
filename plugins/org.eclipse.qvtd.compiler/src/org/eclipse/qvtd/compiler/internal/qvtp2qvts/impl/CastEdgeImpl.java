/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts.impl;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigableEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeRole;

public class CastEdgeImpl extends NavigableEdgeImpl
{
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
}