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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

import com.google.common.collect.Sets;

abstract class AbstractForestBuilder implements Comparator<@NonNull NavigableEdge>
{
	/**
	 * The preferred non-secondary edges to be used in the tree.
	 */
	private final @NonNull Set<@NonNull NavigableEdge> forwardEdges = new HashSet<>();

	/**
	 * Edges that have no opposite.
	 */
	private final @NonNull Set<@NonNull NavigableEdge> manyToOneEdges = new HashSet<>();

	/**
	 * The edges that are traversed while locating each node and their depth in the traversal forest, 0 at edge sourced by root.
	 */
	private final @NonNull Map<@NonNull NavigableEdge, @NonNull Integer> traversedEdge2depth = new HashMap<>();

	/**
	 * The nodes that are traversed while locating each node and their depth in the traversal forest, 0 at root.
	 */
	//	private final @NonNull Map<@NonNull Node, @NonNull Integer> traversedNode2depth = new HashMap<>();

	/**
	 * The incoming edge for each node in the traversal forest, null at a root.
	 */
	private final @NonNull Map<@NonNull Node, @Nullable NavigableEdge> traversedNode2incomingEdge = new HashMap<>();

	protected AbstractForestBuilder(@NonNull Iterable<@NonNull Node> rootNodes, @NonNull Iterable<@NonNull NavigableEdge> edges) {
		for (@NonNull Node rootNode : rootNodes) {
			traversedNode2incomingEdge.put(rootNode, null);
		}
		for (@NonNull NavigableEdge edge : edges) {
			addEdge(edge);
		}
		//
		//	Analyze the descendants of the roots to identify the most simply navigated forest.
		//
		analyze(traversedNode2incomingEdge.keySet());
	}

	protected void addEdge(@NonNull NavigableEdge edge) {
		if (!edge.isSecondary()) {
			forwardEdges.add(edge);
			if ((edge.getEdgeSource().isClass()) && (edge.getOppositeEdge() == null)) {
				manyToOneEdges.add(edge);
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
				for (@NonNull NavigableEdge forwardEdge : sourceNode.getNavigationEdges()) {
					if (forwardEdges.contains(forwardEdge)) {
						Node targetNode = RegionUtil.getCastTarget(forwardEdge.getEdgeTarget());
						if (!traversedNode2incomingEdge.containsKey(targetNode)) {
							traversedNode2incomingEdge.put(targetNode, forwardEdge);
							moreMoreNodes.add(targetNode);
							traversedEdge2depth.put(forwardEdge, depth);
						}
					}
				}
			}
			if (moreMoreNodes.isEmpty()) {
				//
				//	If no forward edge makes progress, select just one backward edge instead.
				//
				for (@NonNull NavigableEdge forwardEdge : forwardEdges) {		// FIXME maintain reducing list of possibles
					@Nullable NavigableEdge backwardEdge = forwardEdge.getOppositeEdge();
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
	 * Identify the forest from the given roots.
	 *
	public void reanalyze(@NonNull Node rootNode) {
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
					@Nullable NavigationEdge backwardEdge = forwardEdge.getOppositeEdge();
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
	} */

	/**
	 *	Support the shallowest first then alphabetical ordering of the traversal edges of the forest.
	 */
	@Override
	public int compare(@NonNull NavigableEdge o1, @NonNull NavigableEdge o2) {
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

	//	protected @Nullable Integer getDepth(@NonNull Node node) {
	//		return traversedNode2depth.get(node);
	//	}

	protected @NonNull Iterable<@NonNull NavigableEdge> getForwardEdges() {
		return forwardEdges;
	}

	public @Nullable NavigableEdge getParentEdge(@NonNull Node node) {
		return traversedNode2incomingEdge.get(node);
	}

	protected @NonNull Iterable<@NonNull NavigableEdge> getTraversedEdges() {
		return traversedEdge2depth.keySet();
	}
}