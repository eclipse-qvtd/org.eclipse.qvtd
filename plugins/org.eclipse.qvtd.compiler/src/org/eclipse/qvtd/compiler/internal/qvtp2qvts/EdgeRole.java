/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;

/**
 * EdgeRole defines which of many possible roles an edge plays
 */
public interface EdgeRole extends Role
{
	interface Navigation extends EdgeRole
	{
		@NonNull NavigationEdge createEdge(@NonNull Region region, @NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode);

		@Nullable String getLabel(@NonNull Property source2targetProperty);
	}

	interface Recursion extends EdgeRole
	{
		@NonNull Edge createEdge(@NonNull Region region, @NonNull Node sourceNode, @NonNull Node targetNode);
	}

	interface Simple extends EdgeRole
	{
		@NonNull Edge createEdge(@NonNull Region region, @NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode);
	}

	@Nullable String getArrowhead();

	@Nullable String getArrowtail();

	/**
	 * Return a label for the edge, null for none.
	 */
	@Nullable String getLabel();

	/**
	 * Return the pen width with which this edge is drawn.
	 */
	@NonNull Integer getPenwidth();

	/**
	 * Return the line style with which this edge is drawn, nullfor solid.
	 */
	@Nullable String getStyle();

	/**
	 * Return  true if this edge provides an argument for an OCL expression node.
	 */
	boolean isArgument();

	boolean isCast();
	boolean isComputation();

	/**
	 * Return true if this edge forms part of the to-one navigation reachable from a head.
	 */
	boolean isNavigable();

	/**
	 * Return true if this edge represents a property navigation.
	 */
	boolean isNavigation();
	boolean isPredicate();
	boolean isRecursion();

	/**
	 * Return the merged role combining this role and edgeRole.
	 */
	@NonNull EdgeRole merge(@NonNull EdgeRole edgeRole);
}