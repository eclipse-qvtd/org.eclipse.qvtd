/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A NavigationForestBuilder selects a forest of navigable edges to reach each navigable node from its heads.
 */
class NavigationForestBuilder implements Comparator<@NonNull Edge>
{
	/**
	 * The preferred non-secondary edges to be used in the tree.
	 */
	private final @NonNull Set<@NonNull Edge> forwardEdges = new HashSet<>();

	/**
	 * Edges that have no opposite.
	 */
	private final @NonNull Set<@NonNull NavigableEdge> manyToOneEdges = new HashSet<>();

	/**
	 * The edges that are traversed while locating each node and their depth in the traversal forest, 0 at edge sourced by root.
	 */
	private final @NonNull Map<@NonNull Edge, @NonNull Integer> traversedEdge2depth = new HashMap<>();

	/**
	 * The nodes that are traversed while locating each node and their depth in the traversal forest, 0 at root.
	 */
	//	private final @NonNull Map<@NonNull Node, @NonNull Integer> traversedNode2depth = new HashMap<>();

	/**
	 * The incoming edge for each node in the traversal forest, null at a root.
	 */
	private final @NonNull Map<@NonNull Node, @Nullable Edge> traversedNode2incomingEdge = new HashMap<>();

	/**
	 * The nodes that form the traversal forest.
	 */
	//	private final @NonNull Set<@NonNull Node> navigableNodes = new HashSet<>();

	/**
	 * The other edges that are traversed while traversing a primary operation input.
	 */
	private final @NonNull Set<@NonNull Edge> otherTraversedEdges = new HashSet<>();

	/**
	 * The edges that are not traversed while locating each node.
	 */
	private final @NonNull Set<@NonNull Edge> untraversedEdges = new HashSet<>();

	public NavigationForestBuilder(@NonNull Iterable<@NonNull Node> rootNodes, @NonNull Iterable<@NonNull Edge> edges) {
		for (@NonNull Node rootNode : rootNodes) {
			traversedNode2incomingEdge.put(rootNode, null);
		}
		for (@NonNull Edge edge : edges) {
			addEdge(edge);
		}
		//
		//	Analyze the descendants of the roots to identify the most simply navigated forest.
		//
		analyze(traversedNode2incomingEdge.keySet());
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
		Set<@NonNull Edge> predicateEdges = Sets.newHashSet(forwardEdges);
		for (@NonNull Edge traversedEdge : getTraversedEdges()) {
			predicateEdges.remove(traversedEdge);
			if (traversedEdge.isNavigation()) {
				NavigableEdge oppositeEdge = ((NavigableEdge)traversedEdge).getOppositeEdge();
				if (oppositeEdge != null) {
					predicateEdges.remove(oppositeEdge);
				}
			}
		}
		predicateEdges.removeAll(otherTraversedEdges);
		untraversedEdges.addAll(predicateEdges);
	}

	/**
	 * Add a possible edge and end nodes categorizing a navigable edge as forward if it is a sole or primary edge,
	 * reverse if it is a secondary edge.
	 */
	protected void addEdge(@NonNull Edge edge) {
		if (edge.isRealized()) {}
		else if (edge.isCast()) {}
		else {
			//			assert !edge.isExpression();
			//			assert !edge.isComputation();
			Node targetNode = edge.getEdgeTarget();
			targetNode = RegionUtil.getCastTarget(targetNode);
			if (!edge.isSecondary()) {
				forwardEdges.add(edge);
				if ((edge.getEdgeSource().isClass()) && (edge instanceof NavigableEdge)) {
					NavigableEdge navigableEdge = (NavigableEdge)edge;
					if (navigableEdge.getOppositeEdge() == null) {
						manyToOneEdges.add((NavigableEdge)edge);
					}
				}
			}
		}
	}

	/**
	 * Identify the forest from the given roots.
	 */
	public void analyze(@NonNull Iterable<@NonNull Node> rootNodes) {
		Set<@NonNull Node> moreNodes = Sets.newHashSet(rootNodes);
		//
		//	Advance breadth first, one depth at a time, accumulating all edges that make one stage of progress.
		//
		for (int depth = 0; moreNodes.size() > 0; depth++) {
			//
			//	Select the forward edges that make progress.
			//
			Set<@NonNull Node> moreMoreNodes = new HashSet<>();
			for (@NonNull Node sourceNode : moreNodes) {
				//				traversedNode2depth.put(sourceNode, depth);
				for (@NonNull Edge forwardEdge : RegionUtil.getOutgoingEdges(sourceNode)) {
					if (forwardEdges.contains(forwardEdge)) {
						Node targetNode = RegionUtil.getCastTarget(forwardEdge.getEdgeTarget());
						if (forwardEdge.isNavigation()) {
							if (!traversedNode2incomingEdge.containsKey(targetNode)) {
								traversedNode2incomingEdge.put(targetNode, forwardEdge);
								moreMoreNodes.add(targetNode);
								traversedEdge2depth.put(forwardEdge, depth);
							}
						}
						else if (forwardEdge.isExpression()) {
							boolean allReady = true;
							for (@NonNull Edge incomingEdge : RegionUtil.getIncomingEdges(targetNode)) {
								if (incomingEdge.isExpression()) {
									Node expressionSourceNode = incomingEdge.getSourceNode();
									if (!traversedNode2incomingEdge.containsKey(expressionSourceNode)) {
										allReady = false;
										break;
									}
								}
							}
							if (allReady) {
								for (@NonNull Edge incomingEdge : RegionUtil.getIncomingEdges(targetNode)) {
									if (incomingEdge.isExpression()) {
										traversedEdge2depth.put(incomingEdge, depth);
										if (incomingEdge != forwardEdge) {
											otherTraversedEdges.add(incomingEdge);
										}
									}
								}
								traversedNode2incomingEdge.put(targetNode, forwardEdge);
								if (!targetNode.getOutgoingEdges().isEmpty()) {
									moreMoreNodes.add(targetNode);
								}
							}
						}
						else {
							assert false;
						}
					}
				}
			}
			if (moreMoreNodes.isEmpty()) {
				//
				//	If no forward edge makes progress, select just one backward edge instead.
				//
				for (@NonNull Edge forwardEdge : forwardEdges) {		// FIXME maintain reducing list of possibles
					if (forwardEdge instanceof NavigableEdge) {
						NavigableEdge navigableForwardEdge = (NavigableEdge)forwardEdge;
						@Nullable NavigableEdge backwardEdge = navigableForwardEdge.getOppositeEdge();
						if (backwardEdge != null) {
							Node sourceNode = backwardEdge.getEdgeSource();
							if (traversedNode2incomingEdge.containsKey(sourceNode)) {
								Node targetNode = backwardEdge.getEdgeTarget();
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
				if (moreMoreNodes.isEmpty()) {
					//
					//	If no backward edge makes progress, select just one inverse edge instead.
					//
					for (@NonNull NavigableEdge manyToOneEdge : manyToOneEdges) {		// FIXME maintain reducing list of possibles
						Node sourceNode = manyToOneEdge.getEdgeTarget();
						if (traversedNode2incomingEdge.containsKey(sourceNode)) {
							Node targetNode = manyToOneEdge.getEdgeSource();
							if (!traversedNode2incomingEdge.containsKey(targetNode)) {
								traversedNode2incomingEdge.put(targetNode, manyToOneEdge);
								moreMoreNodes.add(targetNode);
								traversedEdge2depth.put(manyToOneEdge, depth);
								break;
							}
						}
					}
				}
			}
			moreNodes = moreMoreNodes;
		}
	}

	/**
	 *	Select the shallowest first then alphabetical ordering of the traversal edges of the forest.
	 *
	 * FIXME prioritize fallible predicate paths
	 */
	@Override
	public int compare(@NonNull Edge o1, @NonNull Edge o2) {
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
	public @NonNull List<@NonNull Edge> getForestNavigations() {
		List<@NonNull Edge> forestNavigations = Lists.newArrayList(getTraversedEdges());
		forestNavigations.removeAll(otherTraversedEdges);
		Collections.sort(forestNavigations, this);
		return forestNavigations;
	}

	/**
	 *	Return an alphabetical ordering of the residual edges to be checked as predicates.
	 */
	public @NonNull List<@NonNull Edge> getGraphPredicates() {
		List<@NonNull Edge> graphPredicateEdges = new ArrayList<>();
		for (@NonNull Edge untraversedEdge : untraversedEdges) {
			graphPredicateEdges.add(untraversedEdge);
		}
		Collections.sort(graphPredicateEdges, NameUtil.NAMEABLE_COMPARATOR);
		return graphPredicateEdges;
	}

	protected @NonNull Iterable<@NonNull Edge> getTraversedEdges() {
		return traversedEdge2depth.keySet();
	}
}