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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RegionUtil;

import com.google.common.collect.Sets;

/**
 * A NavigationForestBuilder selects a forest of navigable edges to reach each navigable node from its heads.
 */
class NavigationForestBuilder implements Comparator<@NonNull NavigationEdge>
{
	/**
	 * The preferred non-secondary edges to be used in the tree.
	 */
	private final @NonNull Set<@NonNull NavigationEdge> forwardEdges = new HashSet<>();

	/**
	 * The nodes that form the traversal forest.
	 */
	private final @NonNull Set<@NonNull Node> navigableNodes = new HashSet<>();

	/**
	 * The edges that are not traversed while locating each node.
	 */
	private final @NonNull Set<@NonNull NavigationEdge> untraversedEdges = new HashSet<>();

	/**
	 * The edges that are traversed while locating each node and their depth in the traversal forest.
	 */
	private final @NonNull Map<@NonNull NavigationEdge, @NonNull Integer> traversedEdge2depth = new HashMap<>();

	/**
	 * The incoming edge for each node in the traversal forest, null at a root.
	 */
	private final @NonNull Map<@NonNull Node, @Nullable NavigationEdge> traversedNode2incomingEdge = new HashMap<>();

	public NavigationForestBuilder(@NonNull Iterable<@NonNull Node> rootNodes, @NonNull Iterable<@NonNull NavigationEdge> navigationEdges) {
		//
		//	Load the roots.
		//
		for (@NonNull Node rootNode : rootNodes) {
			traversedNode2incomingEdge.put(rootNode, null);
		}
		//
		//	Load the navigable edges.
		//
		for (@NonNull NavigationEdge edge : navigationEdges) {
			addEdge(edge);
		}
		//
		//	Analyze the descendants of the roots to identify the most simply navigated forest.
		//
		analyze();
	}

	/**
	 * Add a possible edge and end nodes categorizing a navigable edge as forward if it is a sole or primary edge,
	 * reverse if it is a secondary edge or untraversed if it is to-null.
	 */
	protected void addEdge(@NonNull NavigationEdge edge) {
		if (edge.isRealized()) {}
		else if (!edge.isNavigable()) {}
		else if (edge.isCast()) {}
		else {
			assert !edge.isExpression();
			assert !edge.isComputation();
			Node sourceNode = edge.getSource();
			navigableNodes.add(sourceNode);
			Node targetNode = edge.getTarget();
			if (targetNode.isNull()) {
				untraversedEdges.add(edge);
			}
			else {
				targetNode = RegionUtil.getCastTarget(targetNode);
				if (edge.isSecondary()) {
					NavigationEdge oppositeEdge = edge.getOppositeEdge();
					assert oppositeEdge != null;
					forwardEdges.add(oppositeEdge);
				}
				else {
					forwardEdges.add(edge);
				}
				navigableNodes.add(targetNode);
			}
		}
	}

	/**
	 * Identify the forest from the given roots.
	 */
	protected void analyze() {
		Set<@NonNull Node> moreNodes = Sets.newHashSet(traversedNode2incomingEdge.keySet());
		//
		//	Advance breadth first, one depth at a time, accumulating all edges that make one stage of progress.
		//
		for (int depth = 0; moreNodes.size() > 0; depth++) {
			//
			//	Select the forward edges that make progress.
			//
			Set<@NonNull Node> moreMoreNodes = new HashSet<>();
			for (@NonNull Node sourceNode : moreNodes) {
				for (@NonNull NavigationEdge forwardEdge : sourceNode.getNavigationEdges()) {
					if (forwardEdges.contains(forwardEdge)) {
						Node targetNode = RegionUtil.getCastTarget(forwardEdge.getTarget());
						if (!traversedNode2incomingEdge.containsKey(targetNode)) {
							traversedNode2incomingEdge.put(targetNode, forwardEdge);
							moreMoreNodes.add(targetNode);
							traversedEdge2depth.put(forwardEdge, depth);
						}
					}
				}
			}
			//
			//	If no forward edge makes progress, select just one backward edge instead.
			//
			if (moreMoreNodes.isEmpty()) {
				for (@NonNull NavigationEdge forwardEdge : forwardEdges) {		// FIXME maintain reducing list of possibles
					NavigationEdge backwardEdge = forwardEdge.getOppositeEdge();
					if (backwardEdge != null) {
						Node sourceNode = backwardEdge.getSource();
						if (traversedNode2incomingEdge.containsKey(sourceNode)) {
							Node targetNode = backwardEdge.getTarget();
							if (!traversedNode2incomingEdge.containsKey(targetNode)) {
								traversedNode2incomingEdge.put(targetNode, backwardEdge);
								moreMoreNodes.add(targetNode);
								traversedEdge2depth.put(backwardEdge, depth);
								break;
							}
						}
					}
				}
			}
			moreNodes = moreMoreNodes;
		}
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
		Set<@NonNull NavigationEdge> predicateEdges = new HashSet<>(forwardEdges);
		for (@NonNull NavigationEdge traversedEdge : traversedEdge2depth.keySet()) {
			predicateEdges.remove(traversedEdge);
			NavigationEdge oppositeEdge = traversedEdge.getOppositeEdge();
			if (oppositeEdge != null) {
				predicateEdges.remove(oppositeEdge);
			}
		}
		untraversedEdges.addAll(predicateEdges);
	}

	/**
	 *	Support the shallowest first then alphabetical ordering of the traversal edges of the forest.
	 */
	@Override
	public int compare(@NonNull NavigationEdge o1, @NonNull NavigationEdge o2) {
		Integer d1 = traversedEdge2depth.get(o1);
		Integer d2 = traversedEdge2depth.get(o2);
		assert (d1 != null) && (d2 != null);
		if (d1 != d2) {
			return d1 - d2;
		}
		String n1 = o1.getDisplayName();
		String n2 = o2.getDisplayName();
		return n1.compareTo(n2);
	}

	/**
	 *	Return a shallowest first then alphabetical ordering of the traversal edges of the forest.
	 */
	public @NonNull List<@NonNull NavigationEdge> getForestNavigations() {
		List<@NonNull NavigationEdge> forestNavigations = new ArrayList<>(traversedEdge2depth.keySet());
		Collections.sort(forestNavigations, this);
		return forestNavigations;
	}

	/**
	 *	Return an alphabetical ordering of the residual edges to be checked as predicates.
	 */
	public @NonNull List<@NonNull NavigationEdge> getGraphPredicates() {
		List<@NonNull NavigationEdge> graphPredicateEdges = new ArrayList<>();
		for (@NonNull NavigationEdge untraversedEdge : untraversedEdges) {
			graphPredicateEdges.add(untraversedEdge);
		}
		Collections.sort(graphPredicateEdges, NameUtil.NAMEABLE_COMPARATOR);
		return graphPredicateEdges;
	}
}