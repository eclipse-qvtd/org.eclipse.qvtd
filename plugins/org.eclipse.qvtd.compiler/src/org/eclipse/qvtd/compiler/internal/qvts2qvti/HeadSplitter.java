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
package org.eclipse.qvtd.compiler.internal.qvts2qvti;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;

/**
 * A HeadSplitter splits multi-headed regions whose heads are dependent into a cascade of looping regions, one per head around
 * a singly-headed core region.
 */
public class HeadSplitter
{
	public static final @NonNull TracingOption SPLITTING = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/headSplitting");

	public class Boundary
	{
		protected final @NonNull Set<@NonNull Node> intersectionNodes;
		protected final @NonNull Set<@NonNull Node> headNodes = new HashSet<@NonNull Node>();
		//		protected final @NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> headNode2reachableNodes;
		Map<@NonNull Node, List<@NonNull Edge>> head2interHeadEdges = new HashMap<@NonNull Node, List<@NonNull Edge>>();
		Map<@NonNull Node, List<@NonNull Node>> head2interHeadNodes = new HashMap<@NonNull Node, List<@NonNull Node>>();

		public Boundary(@NonNull Set<@NonNull Node> intersectionNodes) {
			this.intersectionNodes = intersectionNodes;
		}

		public void add(@NonNull Node headNode) {
			boolean wasAdded = headNodes.add(headNode);
			assert wasAdded;
		}

		public void analyze() {
			for (@NonNull Node headNode : headNodes) {
				analyze(headNode);
			}
		}

		public void analyze(@NonNull Node headNode) {
			List<@NonNull Edge> interHeadEdges = null;
			List<@NonNull Node> interHeadNodes = null;
			Set<@NonNull Node> theseNodes = new HashSet<@NonNull Node>(head2reachables.get(headNode));
			theseNodes.removeAll(intersectionNodes);
			Set<@NonNull Node> thoseNodes = new HashSet<@NonNull Node>(allReachables);
			thoseNodes.removeAll(theseNodes);
			for (@NonNull Node thisNode : theseNodes) {
				for (@NonNull NavigationEdge edge : thisNode.getNavigationEdges()) {
					assert edge.getSource() == thisNode;
					if (!edge.isRealized() && edge.isNavigable()) {
						Property property = edge.getProperty();
						Property opposite = property.getOpposite();
						if ((opposite != null) && opposite.isIsMany()) {
							Node targetNode = edge.getTarget();
							if (!theseNodes.contains(targetNode)) {
								List<@NonNull Node> targetHeadNodes = reachable2heads.get(targetNode);
								assert targetHeadNodes != null;
								targetHeadNodes.remove(headNode);
								targetHeadNodes.retainAll(headNodes);
								if (targetHeadNodes.size() > 0) {
									if (interHeadEdges == null) {
										interHeadEdges = new ArrayList<@NonNull Edge>();
									}
									if (!interHeadEdges.contains(edge)) {
										interHeadEdges.add(edge);
									}
									for (@NonNull Node targetHeadNode : targetHeadNodes) {
										if (interHeadNodes == null) {
											interHeadNodes = new ArrayList<@NonNull Node>();
										}
										if (!interHeadNodes.contains(targetHeadNode)) {
											interHeadNodes.add(targetHeadNode);
										}
									}
								}
							}
						}
					}
				}
				for (@NonNull Edge edge : thisNode.getIncomingEdges()) {
					assert edge.getTarget() == thisNode;
					if (!edge.isRealized() && edge.isComputation()) {
						Set<@NonNull Node> sourceHeadNodes = getSourceHeadNodes(edge);
						sourceHeadNodes.remove(headNode);
						sourceHeadNodes.retainAll(headNodes);
						if (sourceHeadNodes.size() > 0) {
							if (interHeadEdges == null) {
								interHeadEdges = new ArrayList<@NonNull Edge>();
							}
							if (!interHeadEdges.contains(edge)) {
								interHeadEdges.add(edge);
							}
						}
						for (@NonNull Node sourceHeadNode : sourceHeadNodes) {
							if (interHeadNodes == null) {
								interHeadNodes = new ArrayList<@NonNull Node>();
							}
							if (!interHeadNodes.contains(sourceHeadNode)) {
								interHeadNodes.add(sourceHeadNode);
							}
						}
					}
				}
			}
			if (interHeadEdges != null) {
				head2interHeadEdges.put(headNode, interHeadEdges);
			}
			if (interHeadNodes != null) {
				head2interHeadNodes.put(headNode, interHeadNodes);
			}
		}


		public void debug(@NonNull StringBuilder s) {
			s.append("\n    boundary:");
			for (@NonNull Node headNode : headNodes) {
				s.append(" \"" + headNode.getName() + "\"");
			}
			for (@NonNull Node node : intersectionNodes) {
				s.append("\n        shared " + node);
			}
			for (@NonNull Node headNode : headNodes) {
				s.append("\n        head: \"" + headNode.getName() + "\" <-");
				List<@NonNull Node> interHeadNodes = head2interHeadNodes.get(headNode);
				if (interHeadNodes != null) {
					for (@NonNull Node node : interHeadNodes) {
						s.append(" \"" + node.getName() + "\"");
					}
				}
				List<@NonNull Edge> interHeadEdges = head2interHeadEdges.get(headNode);
				if (interHeadEdges != null) {
					for (@NonNull Edge edge : interHeadEdges) {
						s.append("\n            via: " + edge);
						if (edge instanceof NavigationEdge) {
							Property property = ((NavigationEdge)edge).getProperty();
							s.append("\n                property: " + (property.isIsImplicit() ? "implicit" : "explicit") + " " + property.getName() + " : " + property.getType());
							Property opposite = property.getOpposite();
							if (opposite != null) {
								s.append("\n                opposite: " + (opposite.isIsImplicit() ? "implicit" : "explicit") + " " + opposite.getName() + " : " + opposite.getType());
							}

						}
					}
				}
			}
		}

		public @NonNull LinkedHashMap<@NonNull Node, @NonNull List<@NonNull Edge>> getRemoveableHeads() {
			//
			//	Compute the head nodes that can be derived by navigation from other heads.
			//
			LinkedHashMap<@NonNull Node, @NonNull List<@NonNull Edge>> derivableHeadNodes2edges = new LinkedHashMap<@NonNull Node, @NonNull List<@NonNull Edge>>();
			for (@NonNull Node headNode : headNodes) {
				List<@NonNull Node> interHeadNodes = head2interHeadNodes.get(headNode);
				if ((interHeadNodes != null) && (interHeadNodes.size() > 0)) {
					List<@NonNull Edge> interHeadEdges = head2interHeadEdges.get(headNode);
					if ((interHeadEdges != null) && (interHeadEdges.size() > 0)) {
						derivableHeadNodes2edges.put(headNode, interHeadEdges);
					}
				}
			}
			//
			//	Compute the deriveable head nodes that do not depend on other deriveable heads.
			//
			LinkedHashMap<@NonNull Node, @NonNull List<@NonNull Edge>> removableHeadNodes = new LinkedHashMap<@NonNull Node, @NonNull List<@NonNull Edge>>();
			Set<@NonNull Node> derivableHeadNodes = derivableHeadNodes2edges.keySet();
			for (Map.Entry<@NonNull Node, @NonNull List<@NonNull Edge>> entry : derivableHeadNodes2edges.entrySet()) {
				Node headNode = entry.getKey();
				List<@NonNull Node> interHeadNodes = head2interHeadNodes.get(headNode);
				if ((interHeadNodes != null) && containsNone(interHeadNodes, derivableHeadNodes)) {
					removableHeadNodes.put(headNode, entry.getValue());
				}
			}
			return removableHeadNodes;
		}
	}

	public static boolean containsNone(@NonNull Iterable<@NonNull Node> firstNodes, @NonNull Iterable<@NonNull Node> secondNodes) {
		for (@NonNull Node firstNode : firstNodes) {
			for (@NonNull Node secondNode : secondNodes) {
				if (firstNode == secondNode) {
					return false;
				}
			}
		}
		return true;
	}

	protected final @NonNull Region region;

	/**
	 * Map from each head node to all the nodes reachable from the head by to-one navigation.
	 */
	private final @NonNull Map<@NonNull Node, Set<@NonNull Node>> head2reachables = new HashMap<@NonNull Node, Set<@NonNull Node>>();

	/**
	 * Map from each head node to all the nodes reachable from the head by to-one navigation.
	 */
	private final @NonNull Set<@NonNull Node> allReachables = new HashSet<@NonNull Node>();

	/**
	 * Map from each reachable node to all the head nodes from which it is reachable by to-one navigation.
	 */
	private final @NonNull Map<@NonNull Node, List<@NonNull Node>> reachable2heads = new HashMap<@NonNull Node, List<@NonNull Node>>();

	private final @NonNull Map<@NonNull Set<@NonNull Node>, @NonNull Boundary> intersection2boundary = new HashMap<@NonNull Set<@NonNull Node>, @NonNull Boundary>();;

	public HeadSplitter(@NonNull Region region) {
		this.region = region;
		List<@NonNull Node> headNodes = region.getHeadNodes();
		for (@NonNull Node headNode : headNodes) {
			Set<@NonNull Node> reachableNodes = new HashSet<@NonNull Node>();
			computeReachableNodes(headNode, reachableNodes);
			head2reachables.put(headNode, reachableNodes);
			for (@NonNull Node reachableNode : reachableNodes) {
				List<@NonNull Node> reachableHeadNodes = reachable2heads.get(reachableNode);
				if (reachableHeadNodes == null) {
					reachableHeadNodes = new ArrayList<@NonNull Node>();
					reachable2heads.put(reachableNode, reachableHeadNodes);
				}
				assert !reachableHeadNodes.contains(headNode);
				reachableHeadNodes.add(headNode);
				allReachables.add(reachableNode);
			}
		}
	}

	private void computeReachableNodes(@NonNull Node sourceNode, @NonNull Set<@NonNull Node> reachableNodes) {
		if (reachableNodes.add(sourceNode)) {
			for (@NonNull NavigationEdge edge : sourceNode.getNavigationEdges()) {
				assert edge.getSource() == sourceNode;
				if (!edge.isRealized() && edge.isNavigable()) {
					Node targetNode = edge.getTarget();
					computeReachableNodes(targetNode, reachableNodes);
				}
			}
		}
	}

	private void computeSourceNodes(@NonNull Edge computationEdge, @NonNull Set<@NonNull Node> sourceNodes) {
		Node sourceNode = computationEdge.getSource();
		if (sourceNodes.add(sourceNode)) {
			for (@NonNull Edge edge : sourceNode.getIncomingEdges()) {
				assert edge.getTarget() == sourceNode;
				if (!edge.isRealized() && edge.isComputation()) {
					computeSourceNodes(edge, sourceNodes);
				}
			}
		}
	}

	private void createBoundary(@NonNull Node thisHeadNode) {
		//
		//	Compute the intersection that is reachable from another headNodes.
		//
		Set<@NonNull Node> allThoseNodes = new HashSet<@NonNull Node>();
		for (@NonNull Node thatHeadNode : region.getHeadNodes()) {
			if (thatHeadNode != thisHeadNode) {
				Set<@NonNull Node> thoseNodes = head2reachables.get(thatHeadNode);
				assert thoseNodes != null;
				allThoseNodes.addAll(thoseNodes);
			}
		}
		Set<@NonNull Node> theseNodes = head2reachables.get(thisHeadNode);
		Set<@NonNull Node> intersectionNodes = new HashSet<@NonNull Node>(theseNodes);
		intersectionNodes.retainAll(allThoseNodes);
		Boundary boundary = intersection2boundary.get(intersectionNodes);
		if (boundary == null) {
			boundary = new Boundary(intersectionNodes);
			intersection2boundary.put(intersectionNodes, boundary);
		}
		boundary.add(thisHeadNode);
	}

	private @NonNull Set<@NonNull Node> getSourceHeadNodes(@NonNull Edge edge) {
		Set<@NonNull Node> sourceHeadNodes = new HashSet<@NonNull Node>();
		Set<@NonNull Node> sourceNodes = new HashSet<@NonNull Node>();
		computeSourceNodes(edge, sourceNodes);
		for (@NonNull Node sourceNode : sourceNodes) {
			List<@NonNull Node> reachableSourceHeadNodes = reachable2heads.get(sourceNode);
			if (reachableSourceHeadNodes != null) {
				sourceHeadNodes.addAll(reachableSourceHeadNodes);
			}
		}
		return sourceHeadNodes;
	}

	private void pruneBoundaries() {
		//
		//	Hypothesis: larger boundaries are sums of smaller boundaries, so smaller are the interesting ones.
		//
		List<@NonNull Set<@NonNull Node>> intersections = new ArrayList<@NonNull Set<@NonNull Node>>(intersection2boundary.keySet());
		int iMax = intersections.size();
		for (int i1 = 0; i1 < iMax; i1++) {
			Set<@NonNull Node> intersection1 = intersections.get(i1);
			Boundary boundary1 = intersection2boundary.get(intersection1);
			assert boundary1 != null;
			for (int i2 = 0; i2 < iMax; i2++) {
				if (i1 != i2) {
					Set<@NonNull Node> intersection2 = intersections.get(i2);
					if (/*(intersection2.size() > 0) &&*/ intersection1.containsAll(intersection2)) {
						intersection2boundary.remove(intersection1);
						Boundary boundary2 = intersection2boundary.get(intersection2);
						assert boundary2 != null;
						for (@NonNull Node headNode : boundary1.headNodes) {
							boundary2.add(headNode);
						}
					}
				}
			}
		}
	}

	private @NonNull Collection<@NonNull Node>  removeBoundary() {
		LinkedHashMap<@NonNull Node, @NonNull List<@NonNull Edge>> resolvedHeadNodes2edges = new LinkedHashMap<@NonNull Node, @NonNull List<@NonNull Edge>>();
		for (@NonNull Boundary boundary : intersection2boundary.values()) {
			for (Map.Entry<@NonNull Node, @NonNull List<@NonNull Edge>> entry : boundary.getRemoveableHeads().entrySet()) {
				if (!resolvedHeadNodes2edges.containsKey(entry.getKey())) {
					resolvedHeadNodes2edges.put(entry.getKey(), entry.getValue());
				}
			}
		}
		if (SPLITTING.isActive()) {
			StringBuilder s = new StringBuilder();
			for (Map.Entry<@NonNull Node, @NonNull List<@NonNull Edge>> entry : resolvedHeadNodes2edges.entrySet()) {
				s.append("\n\tresolveable \"" + entry.getKey().getName() + "\"");
				for (@NonNull Edge edge : entry.getValue()) {
					s.append("\n\t    via " + edge);
				}
			}
			SPLITTING.println(region + s.toString());
		}
		return resolvedHeadNodes2edges.keySet();
	}

	public List<@NonNull Region> split() {
		List<@NonNull Node> headNodes = new ArrayList<@NonNull Node>(region.getHeadNodes());
		if (headNodes.size() <= 1) {
			return null;
		}
		do {
			Collection<@NonNull Node> doneNodes = split(headNodes);
			if (doneNodes.size() <= 0) {
				break;
			}
			headNodes.removeAll(doneNodes);
		}
		while(headNodes.size() > 1);
		return null;
	}

	private @NonNull Collection<@NonNull Node> split(@NonNull List<@NonNull Node> headNodes) {
		//		head2reachables.clear();
		intersection2boundary.clear();
		for (@NonNull Node headNode : headNodes) {
			createBoundary(headNode);
		}
		//		pruneBoundaries();
		for (@NonNull Boundary boundary : intersection2boundary.values()) {
			boundary.analyze();
		}
		if (SPLITTING.isActive()) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Boundary boundary : intersection2boundary.values()) {
				boundary.debug(s);
			}
			SPLITTING.println(region + s.toString());
		}
		return removeBoundary();
	}

	@Override
	public @NonNull String toString() {
		return region.getName();
	}
}
