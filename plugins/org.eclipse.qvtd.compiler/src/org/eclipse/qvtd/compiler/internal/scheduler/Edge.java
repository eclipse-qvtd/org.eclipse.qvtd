/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;

/**
 * An edge is directed and abstracts any Node interconnection within a Region.
 */
public interface Edge extends GraphStringBuilder.GraphEdge, Nameable
{
	void destroy();

	/**
	 * Return a non-standard style for the arrow head. 
	 */
	@Nullable String getArrowhead();

	/**
	 * Return the color with which this edge is drawn. 
	 */
	@NonNull String getColor();

	/**
	 * Return the role of this edge. 
	 */
	@NonNull EdgeRole getEdgeRole();

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

	@NonNull Iterable<SimpleEdge> getSimpleEdges();

	/**
	 * Return the target Node.
	 */
	@Override
	@NonNull Node getTarget();
	
	/**
	 * Return true if this edge is for an expression argument.
	 */
	boolean isArgument();

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
	 * Return true if this edge is for a container (child to parent inverse composition).
	 */
	boolean isContainer();

	/**
	 * Return true if this edge is for an containment (parent to child composition).
	 */
	boolean isContainment();

	/**
	 * Return true if the source of this edge has a known value, because it is inherently constant, or
	 * is available once sufficient input models have been loaded.
	 */
	boolean isKnown();

	/**
	 * Return true if this edge conveys a value that is loadable from an input model.
	 */
	boolean isLoaded();
	
	/**
	 * Return true if this edge is for a predicate or assignment or expression.
	 */
	boolean isMergeable();
	
	/**
	 * Return true if this edge is part of the to-one navigation from a head.
	 */
	boolean isNavigable();
	
	/**
	 * Return true if this edge is a property navigation.
	 */
	boolean isNavigation();
	
	/**
	 * Return true if this edge is for a predicate.
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
	 * Return true if this edge is for an expression result.
	 */
	boolean isResult();

	void setSource(@NonNull Node sourceNode);

	void setTarget(@NonNull Node targetNode);
}