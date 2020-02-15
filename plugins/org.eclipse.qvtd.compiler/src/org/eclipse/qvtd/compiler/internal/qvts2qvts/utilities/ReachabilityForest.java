/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.DependencyEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.MapLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge;
import org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowNode;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractExtendingQVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import com.google.common.collect.Lists;

/**
 * The ReachabilityForest comprises a tree of preferred edge paths from each head/leaf-constant root node to the
 * nodes that can be reached from them by to-one navigation. It answers the question: what preceding nodes are necessary
 * to ensure that a given node is reachable by to-one navigation.
 *
 * Since the reachability is in access order, conditionality is completely ignored; callers should filter
 * conditional returns from getReachingEdges() as appropriate. Iterations are similarly ignored being largely
 * treated as a single access, albeit with a slight cost penalty to discourage premature iteration evaluation.s
 */
public class ReachabilityForest
{
	private static final int COLLECTION_COST = 10;
	private static final int FORWARD_NAVIGATION_COST = 1;
	//	private static final int INVERSE_MANY_NAVIGATION_COST = 5;
	private static final int INVERSE_NAVIGATION_COST = 3;
	private static final int ITERATOR_COST = 1;
	private static final int KEY_COST = 15;
	private static final int MAP_COST = 12;
	private static final int OPERATION_COST = 10;
	private static final int PREDICATE_COST = 1;
	private static final int SHADOW_COST = 15;

	private class EdgeVisitor extends AbstractExtendingQVTscheduleVisitor<Object, @NonNull ReachabilityForest>
	{
		protected final @NonNull List<@Nullable List<@NonNull Node>> costs2nodes = new ArrayList<>();
		private @NonNull Node targetNode;
		private int thisCost;
		private Integer targetCost;

		protected EdgeVisitor(@NonNull ReachabilityForest context, @NonNull Iterable<@NonNull Node> rootNodes) {
			super(context);
			List<@NonNull Node> rootNodesList = Lists.newArrayList(rootNodes);
			this.targetNode = rootNodesList.get(0);		// A convenient non-null value.
			costs2nodes.add(rootNodesList);				// Index 0 => rootNodes
		}

		private Object doOperationParameterEdge(@NonNull Edge object) {
			int nextCost = thisCost + OPERATION_COST;
			assert targetNode.isOperation();
			List<@NonNull Edge> edges = null;
			for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
				if (availableEdges.contains(incomingEdge)) {
					if ((incomingEdge instanceof OperationParameterEdge) || (incomingEdge instanceof OperationSelfEdge)) { //incomingEdge.isOld() && incomingEdge.isComputation()) {
						Node node = QVTscheduleUtil.getSourceNode(incomingEdge);
						Integer cost = node2cost.get(node);
						if ((cost == null) || (cost > thisCost)) {
							return null;
						}
						if (edges == null) {
							edges = new ArrayList<>();
						}
						edges.add(incomingEdge);
					}
				}
			}
			if (edges != null) {
				if ((targetCost == null) || (nextCost < targetCost)) {
					putCosts(costs2nodes, nextCost, targetNode, edges);
				}
			}
			return null;
		}

		private void putCosts(@NonNull List<@Nullable List<@NonNull Node>> costs2nodes, int cost, @NonNull Node targetNode, @NonNull Object reachingEdgeOrEdges) {
			assert (targetCost == null) || (cost < targetCost);
			List<@NonNull Edge> reachingEdges;
			if (reachingEdgeOrEdges instanceof Edge) {
				Edge edge = (Edge)reachingEdgeOrEdges;
				assert !edge.isPartial();
				assert (edge instanceof IteratedEdge) || (edge instanceof NavigationEdge) || (edge instanceof PredicateEdge);
				assert edge.getTargetNode() == targetNode;
				assert availableEdges.contains(edge);
				reachingEdges = Collections.singletonList(edge);
			}
			else {
				@SuppressWarnings("unchecked")
				List<@NonNull Edge> reachingEdges2 = (List<@NonNull Edge>)reachingEdgeOrEdges;
				reachingEdges = reachingEdges2;
				assert availableEdges.containsAll(reachingEdges);
				for (@NonNull Edge edge : reachingEdges) {
					assert !edge.isPartial();
					assert (edge instanceof CollectionPartEdge) || (edge instanceof KeyPartEdge) || (edge instanceof MapPartEdge) || (edge instanceof OperationParameterEdge) || (edge instanceof OperationSelfEdge) || (edge instanceof ShadowPartEdge);
					assert edge.getTargetNode() == targetNode;
				}
			}
			node2cost.put(targetNode, cost);
			node2reachingEdges.put(targetNode, reachingEdges);
			while (costs2nodes.size() <= cost) {
				costs2nodes.add(null);
			}
			List<@NonNull Node> nodes = costs2nodes.get(cost);
			if (nodes == null) {
				nodes = new ArrayList<>();
				costs2nodes.set(cost, nodes);
			}
			if (!nodes.contains(targetNode)) {
				nodes.add(targetNode);
			}
		}

		public void visitAll() {
			//
			//	Advance breadth first, one cost at a time, accumulating all edges that make one stage of progress.
			//
			for (thisCost = 0; thisCost < costs2nodes.size(); thisCost++) {
				List<@NonNull Node> thisCostNodes = costs2nodes.get(thisCost);
				if (thisCostNodes != null) {
					//
					//	Add the forward edges that make progress to moreMoreNodes and remember the
					//	backward and inverse edges in case forward edges alone are inadequate.
					//
					for (@NonNull Node sourceNode : thisCostNodes) {
						assert node2cost.get(sourceNode) == thisCost;
						for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(sourceNode)) {
							assert !edge.isCast();
							if (availableEdges.contains(edge) && !edge.isPartial()) {
								targetNode = edge.getEdgeTarget();
								if (!node2reachingEdges.containsKey(targetNode)) {
									targetCost = node2cost.get(targetNode);
									assert (targetCost == null) || (thisCost < targetCost);
									edge.accept(this);
								}
							}
						}
					}
				}
			}
		}

		@Override
		public Object visitCastEdge(@NonNull CastEdge object) {
			return visiting(object);		// Doesn't happen - CastEdges have been rewritten
		}

		@Override
		public Object visitCollectionPartEdge(@NonNull CollectionPartEdge edge) {
			int nextCost = thisCost + COLLECTION_COST;
			assert targetNode instanceof CollectionLiteralNode;
			List<@NonNull Edge> edges = null;
			for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
				if (incomingEdge instanceof CollectionPartEdge) {
					Node node = QVTscheduleUtil.getSourceNode(incomingEdge);
					Integer cost = node2cost.get(node);
					if ((cost == null) || (cost > thisCost)) {
						return null;
					}
					if (edges == null) {
						edges = new ArrayList<>();
					}
					edges.add(incomingEdge);
				}
			}
			if (edges != null) {
				if ((targetCost == null) || (nextCost < targetCost)) {
					putCosts(costs2nodes, nextCost, targetNode, edges);
				}
			}
			return null;
		}

		@Override
		public Object visitDependencyEdge(@NonNull DependencyEdge object) {
			return null;
		}

		@Override
		public Object visitIteratedEdge(@NonNull IteratedEdge edge) {
			int nextCost = thisCost + ITERATOR_COST;
			assert targetNode.isIterator();
			putCosts(costs2nodes, nextCost, targetNode, edge);
			return null;
		}

		@Override
		public Object visitKeyPartEdge(@NonNull KeyPartEdge edge) {
			int nextCost = thisCost + KEY_COST;
			assert targetNode instanceof KeyedValueNode;
			List<@NonNull Edge> edges = null;
			for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
				if (incomingEdge instanceof KeyPartEdge) {
					Node node = QVTscheduleUtil.getSourceNode(incomingEdge);
					Integer cost = node2cost.get(node);
					if ((cost == null) || (cost > thisCost)) {
						return null;
					}
					if (edges == null) {
						edges = new ArrayList<>();
					}
					edges.add(incomingEdge);
				}
			}
			if (edges != null) {
				if ((targetCost == null) || (nextCost < targetCost)) {
					putCosts(costs2nodes, nextCost, targetNode, edges);
				}
			}
			return null;
		}

		@Override
		public Object visitMapPartEdge(@NonNull MapPartEdge edge) {
			int nextCost = thisCost + MAP_COST;
			assert targetNode instanceof MapLiteralNode;
			List<@NonNull Edge> edges = null;
			for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
				if (incomingEdge instanceof MapPartEdge) {
					Node node = QVTscheduleUtil.getSourceNode(incomingEdge);
					Integer cost = node2cost.get(node);
					if ((cost == null) || (cost > thisCost)) {
						return null;
					}
					if (edges == null) {
						edges = new ArrayList<>();
					}
					edges.add(incomingEdge);
				}
			}
			if (edges != null) {
				if ((targetCost == null) || (nextCost < targetCost)) {
					putCosts(costs2nodes, nextCost, targetNode, edges);
				}
			}
			return null;
		}

		@Override
		public Object visitNavigationEdge(@NonNull NavigationEdge navigationEdge) {
			if (forwardEdges.contains(navigationEdge)) {
				int nextCost = thisCost + FORWARD_NAVIGATION_COST;
				if ((targetCost == null) || (nextCost < targetCost)) {
					putCosts(costs2nodes, nextCost, targetNode, navigationEdge);
				}
			}
			else {
				NavigationEdge oppositeEdge = navigationEdge.getOppositeEdge();
				if (oppositeEdge != null) {
					if (forwardEdges.contains(oppositeEdge)) {
						boolean isImplicit = QVTscheduleUtil.getReferredProperty(navigationEdge).isIsImplicit();
						int nextCost = thisCost + (isImplicit ? INVERSE_NAVIGATION_COST : FORWARD_NAVIGATION_COST);
						if ((targetCost == null) || (nextCost < targetCost)) {
							putCosts(costs2nodes, nextCost, targetNode, navigationEdge);
						}
					}
					//	else if (manyToOneEdges.contains(oppositeEdge)) {
					//		int nextCost = thisCost + INVERSE_MANY_NAVIGATION_COST;
					//		if ((targetCost == null) || (nextCost < targetCost)) {
					//			putCosts(costs2nodes, nextCost, targetNode, oppositeEdge);
					//		}
					//	}
				}
			}
			return null;
		}

		@Override
		public Object visitOperationParameterEdge(@NonNull OperationParameterEdge edge) {
			return doOperationParameterEdge(edge);
		}

		@Override
		public Object visitOperationSelfEdge(@NonNull OperationSelfEdge edge) {
			return doOperationParameterEdge(edge);
		}

		@Override
		public Object visitPredicateEdge(@NonNull PredicateEdge edge) {
			int nextCost = thisCost + PREDICATE_COST;
			putCosts(costs2nodes, nextCost, targetNode, edge);
			return null;
		}

		@Override
		public Object visitShadowPartEdge(@NonNull ShadowPartEdge edge) {
			int nextCost = thisCost + SHADOW_COST;
			assert targetNode instanceof ShadowNode;
			List<@NonNull Edge> edges = null;
			for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
				if (incomingEdge instanceof ShadowPartEdge) {
					Node node = QVTscheduleUtil.getSourceNode(incomingEdge);
					Integer cost = node2cost.get(node);
					if ((cost == null) || (cost > thisCost)) {
						return null;
					}
					if (edges == null) {
						edges = new ArrayList<>();
					}
					edges.add(incomingEdge);
				}
			}
			if (edges != null) {
				if ((targetCost == null) || (nextCost < targetCost)) {
					putCosts(costs2nodes, nextCost, targetNode, edges);
				}
			}
			return null;
		}

		@Override
		public Object visiting(@NonNull Visitable visitable) {
			throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
		}
	}

	/**
	 * Context for diagnostic messages.
	 */
	protected final @Nullable String disambiguator;

	/**
	 * The edges that may be used in the tree.
	 */
	private final @NonNull Set<@NonNull Edge> availableEdges = new HashSet<>();

	/**
	 * The preferred non-secondary edges to be used in the tree.
	 */
	private final @NonNull Set<@NonNull NavigableEdge> forwardEdges = new HashSet<>();

	/**
	 * Edges that have no opposite.
	 */
	//	private final @NonNull Set<@NonNull Edge> manyToOneEdges = new HashSet<>(); -- removed: there is only to-one reachability

	/**
	 * The incoming non-partial Predicate/Navigation edge or Parameter edges for each node in the traversal forest, null at a root.
	 * Each node2reachingEdgeOrEdges value's target is the node2reachingEdgeOrEdges key.
	 *
	 * The value is null, or a PredicateEdge/NavigationEdge, or a List<ParameterEdge>.
	 */
	private final @NonNull Map<@NonNull Node, @Nullable List<@NonNull Edge>> node2reachingEdges = new HashMap<>();

	/**
	 * The cost for each node from the root in the traversal forest, 0 at a root. The cost is equal
	 * to the sum of the costs of each edge on the lowest cost path from the root.
	 */
	private @NonNull Map<@NonNull Node, @NonNull Integer> node2cost = new HashMap<>();

	/**
	 * Lazily created comparator to order nodes lowest cost first.
	 */
	private @Nullable Comparator<@NonNull Edge> edgeCostComparator = null;

	/**
	 * Lazily created comparator to order nodes lowest cost first.
	 */
	private @Nullable Comparator<@NonNull Node> nodeCostComparator = null;

	/**
	 * Construct the Reachability forest for the specified rootNodes using the availableNavigableEdges to locate
	 * paths to further nodes and also any old computation edges.
	 */
	public ReachabilityForest(@Nullable String disambiguator, @NonNull Iterable<@NonNull Node> rootNodes, @NonNull Iterable<@NonNull ? extends Edge> availableEdges) {
		this.disambiguator = disambiguator;
		for (@NonNull Node rootNode : rootNodes) {
			node2reachingEdges.put(rootNode, null);
		}
		for (@NonNull Edge edge : availableEdges) {
			addEdge(edge);
		}
		//
		//	Analyze the descendants of the roots to identify the most simply navigated forest.
		//
		analyze();
	}

	protected void addEdge(@NonNull Edge edge) {
		this.availableEdges.add(edge);
		if (edge instanceof NavigationEdge) {
			NavigationEdge navigationEdge = (NavigationEdge)edge;
			if (!navigationEdge.isSecondary()) {
				forwardEdges.add(navigationEdge);
				//	if ((navigationEdge.getEdgeSource().isClass()) && (navigationEdge.getOppositeEdge() == null)) {
				//		manyToOneEdges.add(navigationEdge);
				//	}
			}
		}
	}

	/**
	 * Identify the forest from the given roots.
	 */
	protected void analyze() {
		Iterable<@NonNull Node> rootNodes = node2reachingEdges.keySet();
		for (@NonNull Node rootNode : rootNodes) {
			node2cost.put(rootNode, 0);
		}
		EdgeVisitor edgeVisitor = new EdgeVisitor(this, rootNodes);
		edgeVisitor.visitAll();
	}

	public @Nullable Integer basicGetCost(@NonNull Node node) {
		return node2cost.get(node);
	}

	public @NonNull Integer getCost(@NonNull Node node) {
		return ClassUtil.nonNullState(node2cost.get(node));
	}

	public @Nullable String getDisambiguator() {
		return disambiguator;
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
					assert d1s != null : s1 + " is not reachable within " + s1.getOwningRegion() + getContext();		// FIXME change to PartitionProblem
					assert d1t != null : t1 + " is not reachable within " + t1.getOwningRegion() + getContext();
					assert d2s != null : s2 + " is not reachable within " + s2.getOwningRegion() + getContext();
					assert d2t != null : t2 + " is not reachable within " + t2.getOwningRegion() + getContext();
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

				private @NonNull String getContext() {
					return disambiguator != null ? ("«" + disambiguator + "»") : "";
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
					assert c1 != null : o1 + " is not reachable within " + o1.getOwningRegion() + getContext();		// FIXME change to PartitionProblem
					assert c2 != null : o2 + " is not reachable within " + o2.getOwningRegion() + getContext();
					int diff = c1 - c2;
					if (diff != 0) {
						return diff;
					}
					return ClassUtil.safeCompareTo(o1.getName(), o2.getName());
				}

				private @NonNull String getContext() {
					return disambiguator != null ? ("«" + disambiguator + "»") : "";
				}
			};
		}
		return nodeCostComparator2;
	}

	/**
	 * Return the reachable nodes in lowest reaching cost first order.
	 */
	public @NonNull List<@NonNull Node> getMostReachableFirstNodes() {
		List<@NonNull Node> nodes = new ArrayList<>(node2cost.keySet());
		Collections.sort(nodes, getNodeCostComparator());
		return nodes;
	}

	/**
	 * Return all reachable nodes.
	 */
	public @NonNull Iterable<@NonNull Node> getNodes() {
		return node2reachingEdges.keySet();
	}

	/**
	 * Return the closure of the reachingEdges source nodes.
	 */
	public @NonNull Iterable<@NonNull Node> getPredecessorsClosure(@NonNull Node targetNode) {
		Set<@NonNull Node> precedingNodes = new HashSet<>();
		getPredecessorsClosure(precedingNodes, targetNode);
		precedingNodes.remove(targetNode);
		return precedingNodes;
	}
	private void getPredecessorsClosure(@NonNull Set<@NonNull Node> precedingNodes, @NonNull Node targetNode) {
		if (precedingNodes.add(targetNode)) {
			for (@NonNull Edge reachingEdge : getReachingEdges(targetNode)) {
				assert !reachingEdge.isPartial();
				Node sourceNode = reachingEdge.getEdgeSource();
				getPredecessorsClosure(precedingNodes, sourceNode);
			}
		}
	}

	/**
	 * Return the navigation or predicate or iterated edge from the preceding reachable node to the given
	 * reachable node. Else return the computation edges needed to compute the given reachable node.
	 * Node is the target of each returned edge which may be noone for a root/head node.
	 */
	public @NonNull Iterable<@NonNull Edge> getReachingEdges(@NonNull Node node) {
		List<@NonNull Edge> edges = node2reachingEdges.get(node);
		if (edges == null) {
			edges = Collections.emptyList();
			node2reachingEdges.put(node, edges);
		}
		return edges;
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		List<@NonNull Node> nodes = getMostReachableFirstNodes();
		for (@NonNull Node node : nodes) {
			if (s.length() > 0) {
				s.append("\n");
			}
			s.append(node2cost.get(node));
			s.append(": ");
			s.append(node.getName());
			s.append(" :");
			List<@NonNull Edge> edges = node2reachingEdges.get(node);
			if (edges != null) {
				for (@NonNull Edge edge : edges) {
					s.append(" ");
					s.append(edge);
				}
			}
		}
		return s.toString();
	}
}