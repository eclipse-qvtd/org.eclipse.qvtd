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
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;

/**
 * An edge is directed and abstracts any Node interconnection within a Region.
 */
public interface Edge extends GraphStringBuilder.GraphEdge, Nameable, Visitable
{
	/**
	 * Create an edgeRole edge from sourceNode to targetNode with the same name as this edge.
	 */
	@NonNull Edge createEdge(@NonNull EdgeRole edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode);

	void destroy();

	/**
	 * Return a non-standard style for the arrow head.
	 */
	@Nullable String getArrowhead();

	/**
	 * Return a non-standard style for the arrow tail, non-null selects bidirectional.
	 */
	@Nullable String getArrowtail();

	/**
	 * Return the color with which this edge is drawn.
	 */
	@NonNull String getColor();

	/**
	 * Return the role of this edge.
	 */
	@NonNull EdgeRole getEdgeRole();

	/**
	 * Retirn the forward form of this edge if this is a bidirectional edge, this edge otherwise.
	 */
	@NonNull Edge getForwardEdge();

	/**
	 * Return a formatted label to accompany the edge, or null for no label.
	 */
	@Nullable String getLabel();

	/**
	 * Return a logical name of the edge.
	 */
	@Override
	@Nullable String getName();

	/**
	 * Return the containing Region..
	 */
	@NonNull Region getRegion();

	/**
	 * Return the source Node.
	 */
	@Override
	@NonNull Node getSource();

	/**
	 * Return the target Node.
	 */
	@Override
	@NonNull Node getTarget();

	/**
	 * Return true if this edge is for an oclAsType cast.
	 */
	boolean isCast();

	/**
	 * Return true if this node is part of the computation functionality of the region.
	 */
	boolean isComputation();

	/**
	 * Return true if this edge conveys a compile-time constant.
	 */
	boolean isConstant();

	/**
	 * Return true if this edge is for an expression.
	 */
	boolean isExpression();

	/**
	 * Return true if this edge conveys a value that is loadable from an input model.
	 */
	boolean isLoaded();

	/**
	 * Return true if after execution this edge exactly corresponds to a relationship between its matching ends.
	 * Conversely return false if this edge is a conditional execution path or its ends my be optional nulls.
	 * Collections are never null-valued, not even empty collections.
	 */
	boolean isMatched();

	/**
	 * Return true if this edge is for a speculation/realized relationship.
	 */
	boolean isNew();

	/**
	 * Return true if this edge is for a constant/loaded/predicated/speculated relationship.
	 */
	boolean isOld();

	/**
	 * Return true if this edge is a property navigation.
	 */
	boolean isNavigation();

	/**
	 * Return true if this edge is for a predicate.
	 */
	boolean isPredicate();

	/**
	 * Return true if this edge is for a predicated relationship.
	 */
	boolean isPredicated();

	/**
	 * Return true if this edge is for an assignment.
	 */
	boolean isRealized();

	/**
	 * Return true if this edge is for a recursion.
	 */
	boolean isRecursion();

	/**
	 * Return true is this edge is the auto-created inverse edge of a bidirectional pair of edges.
	 */
	boolean isSecondary();

	void setSource(@NonNull Node sourceNode);

	void setTarget(@NonNull Node targetNode);

	void toGraph(@NonNull GraphStringBuilder s);
}