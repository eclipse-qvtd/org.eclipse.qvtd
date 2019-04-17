/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities;

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
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import com.google.common.collect.Lists;

/**
 * The ReachabilityForest comprises a tree of preferred edge paths from each head/leaf-constant root node to the
 * nodes that can be reached from them. It answers the question: what preceding nodes are necessary to ensure
 * that a given node is reachable.
 */
public class ReachabilityForest
{
	private static final int FORWARD_NAVIGATION_COST = 1;
	private static final int INVERSE_MANY_NAVIGATION_COST = 5;
	private static final int INVERSE_NAVIGATION_COST = 3;
	private static final int ITERATOR_COST = 1;
	private static final int OPERATION_COST = 10;
	private static final int RESULT_COST = 1;

	/**
	 * The preferred non-secondary edges to be used in the tree.
	 */
	private final @NonNull Set<@NonNull NavigableEdge> forwardEdges = new HashSet<>();

	/**
	 * Edges that have no opposite.
	 */
	private final @NonNull Set<@NonNull Edge> manyToOneEdges = new HashSet<>();

	/**
	 * The incoming edge for each node in the traversal forest, null at a root.
	 */
	private final @NonNull Map<@NonNull Node, @Nullable Edge> node2reachingEdge = new HashMap<>();

	/**
	 * The cost for each node from the root in the traversal forest, 0 at a root. The cost is equal
	 * to the sum of the costs of each edge on the lowest cost path from the root.
	 */
	private @NonNull Map<@NonNull Node, @NonNull Integer> node2cost = new HashMap<>();

	/**
	 * Lazily created compartor to order nodes lowest cost first.
	 */
	private @Nullable Comparator<@NonNull Edge> edgeCostComparator = null;

	/**
	 * Lazily created compartor to order nodes lowest cost first.
	 */
	private @Nullable Comparator<@NonNull Node> nodeCostComparator = null;


	/**
	 * Construct the Reachability forest for the specified rootNodes using the availableNavigableEdges to locate
	 * paths to further nodes and also any old computation edges.
	 */
	public ReachabilityForest(@NonNull Iterable<@NonNull Node> rootNodes, @NonNull Iterable<@NonNull NavigableEdge> availableNavigableEdges) {
		for (@NonNull Node rootNode : rootNodes) {
			node2reachingEdge.put(rootNode, null);
		}
		for (@NonNull NavigableEdge edge : availableNavigableEdges) {
			addEdge(edge);
		}
		//
		//	Analyze the descendants of the roots to identify the most simply navigated forest.
		//
		analyze(node2reachingEdge.keySet());
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
	protected void analyze(@NonNull Iterable<@NonNull Node> rootNodes) {
		List<@Nullable List<@NonNull Node>> costs2nodes = new ArrayList<>();
		for (@NonNull Node rootNode : rootNodes) {
			node2cost.put(rootNode, 0);
		}
		costs2nodes.add(Lists.newArrayList(rootNodes));
		//
		//	Advance breadth first, one cost at a time, accumulating all edges that make one stage of progress.
		//
		for (int thisCost = 0; thisCost < costs2nodes.size(); thisCost++) {
			List<@NonNull Node> thisCostNodes = costs2nodes.get(thisCost);
			if (thisCostNodes != null) {
				//
				//	Add the forward edges that make progress to moreMoreNodes and remember the
				//	backward and inverse edges in case forward egdes alone are inadequate.
				//
				for (@NonNull Node sourceNode : thisCostNodes) {
					assert node2cost.get(sourceNode) == thisCost;
					for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(sourceNode)) {
						Node targetNode = edge.getEdgeTarget();
						if (!node2reachingEdge.containsKey(targetNode)) {
							Integer targetCost = node2cost.get(targetNode);
							assert (targetCost == null) || (thisCost < targetCost);
							if (edge.isCast() || edge.isNavigation()) {
								NavigableEdge navigableEdge = (NavigableEdge) edge;
								if (forwardEdges.contains(navigableEdge)) {
									int nextCost = thisCost + FORWARD_NAVIGATION_COST;
									if ((targetCost == null) || (nextCost < targetCost)) {
										node2cost.put(targetNode, nextCost);
										node2reachingEdge.put(targetNode, edge);
										putCosts(costs2nodes, nextCost, targetNode);
									}
								}
								else {
									NavigableEdge oppositeEdge = navigableEdge.getOppositeEdge();
									if (forwardEdges.contains(oppositeEdge)) {
										boolean isImplicit = oppositeEdge.getProperty().isIsImplicit();
										int nextCost = thisCost + (isImplicit ? INVERSE_NAVIGATION_COST : FORWARD_NAVIGATION_COST);
										if ((targetCost == null) || (nextCost < targetCost)) {
											node2cost.put(targetNode, nextCost);
											node2reachingEdge.put(targetNode, oppositeEdge);
											putCosts(costs2nodes, nextCost, targetNode);
										}
									}
									else if (manyToOneEdges.contains(oppositeEdge)) {
										int nextCost = thisCost + INVERSE_MANY_NAVIGATION_COST;
										if ((targetCost == null) || (nextCost < targetCost)) {
											node2cost.put(targetNode, nextCost);
											node2reachingEdge.put(targetNode, oppositeEdge);
											putCosts(costs2nodes, nextCost, targetNode);
										}
									}
								}
							}
							else if (edge.isComputation() /*&& edge.isUnconditional()*/) {
								int nextCost = thisCost + OPERATION_COST;
								if (targetNode.isOperation()) {
									for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
										if (incomingEdge.isOld() && incomingEdge.isComputation()) {
											Node node = QVTscheduleUtil.getSourceNode(incomingEdge);
											Integer cost = node2cost.get(node);
											if ((cost == null) || (cost > thisCost)) {
												nextCost = -1;
												break;
											}
										}
									}
								}
								else if (targetNode.isIterator()) {
									nextCost = thisCost + ITERATOR_COST;
								}
								else {
									nextCost = thisCost + RESULT_COST;
								}
								if (nextCost > 0) {
									if ((targetCost == null) || (nextCost < targetCost)) {
										node2cost.put(targetNode, nextCost);
										node2reachingEdge.put(targetNode, edge);
										putCosts(costs2nodes, nextCost, targetNode);
									}
								}
							}
						}
					}
				}
			}
		}
	}

	public @Nullable Integer getCost(@NonNull Node node) {
		return node2cost.get(node);
	}

	/**
	 * Return a comparator to sort edges source cost first then target cost then alphabetically.
	 */
	public @NonNull Comparator<@NonNull Edge> getEdgeCostComparator() {
		Comparator<@NonNull Edge> edgeCostComparator2 = edgeCostComparator;
		if (edgeCostComparator2 == null) {
			edgeCostComparator = edgeCostComparator2 = new Comparator<@NonNull Edge>()
			{
				@Override
				public int compare(@NonNull Edge e1, @NonNull Edge e2) {
					Node s1 = QVTscheduleUtil.getSourceNode(e1);
					Node t1 = QVTscheduleUtil.getTargetNode(e1);
					Node s2 = QVTscheduleUtil.getSourceNode(e2);
					Node t2 = QVTscheduleUtil.getTargetNode(e2);
					Integer d1s = node2cost.get(s1);
					Integer d1t = node2cost.get(t1);
					Integer d2s = node2cost.get(s2);
					Integer d2t = node2cost.get(t2);
					assert (d1s != null) && (d1t != null) && (d2s != null) && (d2t != null);
					int d1 = Math.max(d1s,  d1t);
					int d2 = Math.max(d2s,  d2t);
					if (d1 != d2) {
						return d1 - d2;
					}
					if (d1s != d2s) {
						return d1s - d2s;
					}
					String n1 = e1.getDisplayName();
					String n2 = e2.getDisplayName();
					int d = ClassUtil.safeCompareTo(n1, n2);
					if (d != 0) {
						return d;
					}
					n1 = s1.getDisplayName();
					n2 = s2.getDisplayName();
					d = ClassUtil.safeCompareTo(n1, n2);
					if (d != 0) {
						return d;
					}
					n1 = t1.getDisplayName();
					n2 = t2.getDisplayName();
					d = ClassUtil.safeCompareTo(n1, n2);
					return d;
				}
			};
		}
		return edgeCostComparator2;
	}

	/**
	 * Return a comparator to sort nodes cost first then alphabetically.
	 */
	public @NonNull Comparator<@NonNull Node> getNodeCostComparator() {
		Comparator<@NonNull Node> nodeCostComparator2 = nodeCostComparator;
		if (nodeCostComparator2 == null) {
			nodeCostComparator = nodeCostComparator2 = new Comparator<@NonNull Node>()
			{
				@Override
				public int compare(@NonNull Node o1, @NonNull Node o2) {
					Integer c1 = node2cost.get(o1);
					Integer c2 = node2cost.get(o2);
					assert (c1 != null) && (c2 != null);
					int diff = c1 - c2;
					if (diff != 0) {
						return diff;
					}
					return ClassUtil.safeCompareTo(o1.getName(), o2.getName());
				}
			};
		}
		return nodeCostComparator2;
	}

	public @NonNull Iterable<@NonNull Node> getNodes() {
		return node2reachingEdge.keySet();
	}

	public @NonNull Iterable<@NonNull Node> getPredecessors(@NonNull Node targetNode) {
		Set<@NonNull Node> precedingNodes = new HashSet<@NonNull Node>();
		getPredecessors(precedingNodes, targetNode);
		precedingNodes.remove(targetNode);
		return precedingNodes;
	}
	private void getPredecessors(@NonNull Set<@NonNull Node> precedingNodes, @NonNull Node targetNode) {
		if (precedingNodes.add(targetNode)) {
			Edge parentEdge = null;
			if (targetNode.isOperation()) {
				Edge reachingEdge = getReachingEdge(targetNode);
				if ((reachingEdge != null) && reachingEdge.isNavigation()) {
					parentEdge = reachingEdge;
				}
				else {
					for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
						if (edge.isComputation() || ((edge.isCast() || edge.isNavigation()) && !edge.isRealized())) {
							getPredecessors(precedingNodes, edge.getEdgeSource());
						}
					}
				}
			}
			else {
				parentEdge = getReachingEdge(targetNode);
			}
			if (parentEdge != null) {
				Node sourceNode = parentEdge.getEdgeSource();
				if (sourceNode == targetNode) {		// invert a backward edge
					sourceNode = parentEdge.getEdgeTarget();
				}
				getPredecessors(precedingNodes, sourceNode);
			}
		}
	}

	/**
	 * Return the edge from the preceding reachable node to the given reachable node. Null if none.
	 */
	public @Nullable Edge getReachingEdge(@NonNull Node node) {
		return node2reachingEdge.get(node);
	}

	private void putCosts(@NonNull List<@Nullable List<@NonNull Node>> costs2nodes, int cost, @NonNull Node node) {
		while (costs2nodes.size() <= cost) {
			costs2nodes.add(null);
		}
		List<@NonNull Node> nodes = costs2nodes.get(cost);
		if (nodes == null) {
			nodes = new ArrayList<>();
			costs2nodes.set(cost, nodes);
		}
		if (!nodes.contains(node)) {
			nodes.add(node);
		}
	}

	@Override
	public @NonNull String toString() {
		Comparator<@NonNull Node> nodeComparator = getNodeCostComparator();
		StringBuilder s = new StringBuilder();
		List<@NonNull Node> nodes = new ArrayList<>(node2cost.keySet());
		Collections.sort(nodes, nodeComparator);
		for (@NonNull Node node : nodes) {
			if (s.length() > 0) {
				s.append("\n");
			}
			s.append(node2cost.get(node));
			s.append(": ");
			s.append(node.getName());
			s.append(" : ");
			s.append(node2reachingEdge.get(node));
		}
		return s.toString();
	}
}