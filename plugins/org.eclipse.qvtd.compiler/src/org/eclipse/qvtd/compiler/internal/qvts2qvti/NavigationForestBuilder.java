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
package org.eclipse.qvtd.compiler.internal.qvts2qvti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A NavigationForestBuilder selects a forest of navigable edges to reach each navigable node from its heads.
 */
class NavigationForestBuilder extends AbstractForestBuilder
{
	/**
	 * The nodes that form the traversal forest.
	 */
	//	private final @NonNull Set<@NonNull Node> navigableNodes = new HashSet<>();

	/**
	 * The edges that are not traversed while locating each node.
	 */
	private final @NonNull Set<@NonNull NavigableEdge> untraversedEdges = new HashSet<>();

	public NavigationForestBuilder(@NonNull Iterable<@NonNull Node> rootNodes, @NonNull Iterable<@NonNull NavigableEdge> navigationEdges) {
		super(rootNodes, navigationEdges);
		//
		//	Traverse the attributes too.
		//
		/*		for (@NonNull NavigationEdge edge : attributeEdges) {
			Node targetNode = edge.getTarget();
			if (!traversedNode2incomingEdge.containsKey(targetNode)) {
				traversedNode2incomingEdge.put(targetNode, edge);
			}
			else {
				untraversedEdges.add(edge);
			}
		} */
		//
		//	Identify the remaining untraversed edges that are not used to reach nodes and so must be reified as predicates to check nodes.
		//
		Set<@NonNull NavigableEdge> predicateEdges = Sets.newHashSet(getForwardEdges());
		for (@NonNull NavigableEdge traversedEdge : getTraversedEdges()) {
			predicateEdges.remove(traversedEdge);
			NavigableEdge oppositeEdge = traversedEdge.getOppositeEdge();
			if (oppositeEdge != null) {
				predicateEdges.remove(oppositeEdge);
			}
		}
		untraversedEdges.addAll(predicateEdges);
	}

	/**
	 * Add a possible edge and end nodes categorizing a navigable edge as forward if it is a sole or primary edge,
	 * reverse if it is a secondary edge.
	 */
	@Override
	protected void addEdge(@NonNull NavigableEdge edge) {
		if (edge.isRealized()) {}
		else if (edge.isCast()) {}
		else {
			assert !edge.isExpression();
			assert !edge.isComputation();
			Node targetNode = edge.getEdgeTarget();
			targetNode = RegionUtil.getCastTarget(targetNode);
			super.addEdge(edge.getForwardEdge());
		}
	}

	/**
	 *	Return a shallowest first then alphabetical ordering of the traversal edges of the forest.
	 */
	public @NonNull List<@NonNull NavigableEdge> getForestNavigations() {
		List<@NonNull NavigableEdge> forestNavigations = Lists.newArrayList(getTraversedEdges());
		Collections.sort(forestNavigations, this);
		return forestNavigations;
	}

	/**
	 *	Return an alphabetical ordering of the residual edges to be checked as predicates.
	 */
	public @NonNull List<@NonNull NavigableEdge> getGraphPredicates() {
		List<@NonNull NavigableEdge> graphPredicateEdges = new ArrayList<>();
		for (@NonNull NavigableEdge untraversedEdge : untraversedEdges) {
			graphPredicateEdges.add(untraversedEdge);
		}
		Collections.sort(graphPredicateEdges, NameUtil.NAMEABLE_COMPARATOR);
		return graphPredicateEdges;
	}
}