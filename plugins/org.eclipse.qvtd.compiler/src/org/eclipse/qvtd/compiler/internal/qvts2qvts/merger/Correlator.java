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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.merger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

class Correlator
{
	public static @Nullable Correlator correlate(@NonNull MappingRegion secondaryRegion, @NonNull MappingRegion primaryRegion, @NonNull CorrelationStrategy strategy, @Nullable Map<@NonNull Node, @NonNull Node> primaryNode2secondaryNode) {
		Correlator correlator = new Correlator(primaryRegion, secondaryRegion, strategy, primaryNode2secondaryNode);
		return correlator.correlate() ? correlator : null;
	}

	private static interface CorrelationStrategy
	{
		boolean navigableEdgesMatch(@NonNull NavigableEdge secondaryEdge, @Nullable NavigableEdge primaryEdge);
		//		boolean navigableIntermediateNodesMatch(@NonNull Node secondaryNode, @NonNull Node primaryNode);
		//		boolean navigableNodeMaybeUnmatched(@NonNull Node secondaryNode);
		boolean navigableNodesMatch(@NonNull Node secondaryNode, @Nullable Node primaryNode);
	}

	static abstract class AbstractCorrelationStrategy implements CorrelationStrategy
	{
		protected final boolean debugFailures = AbstractMerger.FAILURE.isActive();

		@Override
		public boolean navigableEdgesMatch(@NonNull NavigableEdge secondaryEdge, @Nullable NavigableEdge primaryEdge) {
			return true;
		}

		@Override
		public boolean navigableNodesMatch(@NonNull Node secondaryNode, @Nullable Node primaryNode) {
			if (primaryNode == null) {
				if (secondaryNode.isPredicated()) {
					if (debugFailures) {
						AbstractMerger.FAILURE.println("Missing predicated match for : " + secondaryNode);
					}
					return false;
				}
				return true;
			}
			else {
				assert secondaryNode.isExplicitNull() == primaryNode.isExplicitNull();
				return true;
			}
		}

		//		@Override
		//		public boolean navigableIntermediateNodesMatch(@NonNull Node secondaryNode, @NonNull Node primaryNode) {
		//			if (secondaryNode.isExplicitNull() != primaryNode.isExplicitNull()) {
		//				return false;
		//			}
		//			return true;
		//		}
	}

	protected final @NonNull MappingRegion primaryRegion;
	protected final @NonNull MappingRegion secondaryRegion;
	protected final @NonNull CorrelationStrategy strategy;
	protected final @NonNull Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode = new HashMap<>();
	protected final @NonNull Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> completeClass2primaryNodes;
	protected final boolean debugFailures = AbstractMerger.FAILURE.isActive();

	protected Correlator(@NonNull MappingRegion primaryRegion, @NonNull MappingRegion secondaryRegion, @NonNull CorrelationStrategy strategy, @Nullable Map<@NonNull Node, @NonNull Node> primaryNode2secondaryNode) {
		this.primaryRegion = primaryRegion;
		this.secondaryRegion = secondaryRegion;
		this.strategy = strategy;
		this.completeClass2primaryNodes = RegionUtil.getCompleteClass2Nodes(primaryRegion);
		if (primaryNode2secondaryNode != null) {
			for (Map.Entry<@NonNull Node, @NonNull Node> entry : primaryNode2secondaryNode.entrySet()) {
				secondaryNode2primaryNode.put(entry.getValue(), entry.getKey());
			}
		}
	}

	protected boolean correlate() {
		//
		//	Find the unambiguous head-node matches
		//
		if (!correlateHeadNodes()) {
			return false;
		}
		//
		//	Accumulate the transitive navigation from the head nodes. All common navigation edges must have compatible node types.
		//
		if (!correlateNavigablePredicates()) {
			return false;
		}
		Set<@NonNull Node> navigableNodes = secondaryNode2primaryNode.keySet();
		//
		//	Accumulate the transitive computation to the true nodes. All common computation edges must have compatible node types.
		//
		if (!correlateComputedPredicates()) {
			return false;
		}
		//
		//	Accumulate the remaining node pairings from computations enriching the navigable nodes.
		//
		correlateResidualComputations(navigableNodes);
		return true;
	}

	/**
	 * Return true if the tree of computation nodes for firstNode and secondNode are equivalent
	 * assigning equivalences to first2second.
	 */
	protected boolean correlateComputation(@NonNull Node firstNode, @NonNull Node secondNode, @NonNull Map<@NonNull Node, @NonNull Node> first2second) {
		Node node = first2second.get(firstNode);
		if (node != null) {
			return node == secondNode;
		}
		if (firstNode.getNodeRole() != secondNode.getNodeRole()) {
			return false;
		}
		if (!ClassUtil.safeEquals(firstNode.getName(), secondNode.getName())) {		// FIXME stronger e.g. referredOperation
			return false;
		}
		Map<@NonNull Node, @NonNull Node> nestedFirst2second = new HashMap<>(first2second);
		nestedFirst2second.put(firstNode, secondNode);
		List<@NonNull Edge> residualSecondArgumentEdges = Lists.newArrayList(secondNode.getArgumentEdges());
		for (@NonNull Edge firstEdge : firstNode.getArgumentEdges()) {
			boolean gotIt = false;
			for (@NonNull Edge secondEdge : residualSecondArgumentEdges) {
				if (ClassUtil.safeEquals(firstEdge.getName(), secondEdge.getName())) {
					if (!correlateComputation(firstEdge.getEdgeSource(), secondEdge.getEdgeSource(), nestedFirst2second)) {
						return false;
					}
					gotIt = true;
					residualSecondArgumentEdges.remove(secondEdge);
					break;
				}
			}
			if (!gotIt) {
				return false;
			}
		}
		first2second.putAll(nestedFirst2second);
		return true;
	}

	/**
	 *	Return true if all the computed (TrueNode) predicates exactly match between primaryRegion and secondRegion,
	 *	updating secondaryNode2primaryNode accordingly.
	 */
	protected boolean correlateComputedPredicates() {
		Iterable<@NonNull Node> primaryTrueNodes = primaryRegion.getTrueNodes();
		Iterable<@NonNull Node> secondaryTrueNodes = secondaryRegion.getTrueNodes();
		int primaryTrueSize = Iterables.size(primaryTrueNodes);
		if (primaryTrueSize != Iterables.size(secondaryTrueNodes)) {
			return false;
		}
		if (primaryTrueSize == 0) {
			return true;
		}
		Map<@NonNull Node, @NonNull Node> primary2secondary = new HashMap<>();
		if (primaryTrueSize == 1) {
			Node primaryTrueNode = primaryTrueNodes.iterator().next();
			Node secondaryTrueNode = secondaryTrueNodes.iterator().next();
			if (!correlateComputation(primaryTrueNode, secondaryTrueNode, primary2secondary)) {
				return false;
			}
		}
		else {
			Set<@NonNull Node> residualSecondaryTrueNodes = Sets.newHashSet(secondaryTrueNodes);
			for (@NonNull Node primaryTrueNode : primaryTrueNodes) {
				boolean gotIt = false;
				for (@NonNull Node secondaryTrueNode : residualSecondaryTrueNodes) {
					Map<@NonNull Node, @NonNull Node> primary2secondary2 = new HashMap<>();
					if (correlateComputation(primaryTrueNode, secondaryTrueNode, primary2secondary2)) {	// FIXME use hashes
						gotIt = true;
						primary2secondary.putAll(primary2secondary2);
						residualSecondaryTrueNodes.remove(secondaryTrueNode);
						break;
					}
				}
				if (!gotIt) {
					return false;
				}
			}
		}
		for (@NonNull Node primaryNode : primary2secondary.keySet()) {
			Node equivalentNode = primary2secondary.get(primaryNode);
			assert equivalentNode != null;
			secondaryNode2primaryNode.put(equivalentNode, primaryNode);
		}
		return true;
	}

	protected boolean correlateHeadNodes() {
		List<@NonNull Node> secondaryHeadNodes = secondaryRegion.getHeadNodes();
		if (secondaryHeadNodes.size() != 1) {			// FIXME Surely consistent multiple heads are ok?
			if (debugFailures) {
				AbstractMerger.FAILURE.println("More than 1 secondary head nodes: " + secondaryHeadNodes.size());
			}
			return false;
		}
		Node secondaryHeadNode = secondaryHeadNodes.get(0);
		CompleteClass completeClass = secondaryHeadNode.getCompleteClass();
		List<@NonNull Node> primaryNodes = completeClass2primaryNodes.get(completeClass);
		if (primaryNodes == null) {
			if (debugFailures) {
				AbstractMerger.FAILURE.println("No primary nodes of type: " + completeClass);
			}
			return false;
		}
		Node primaryHeadNode = secondaryNode2primaryNode.get(secondaryHeadNode);
		if (primaryHeadNode != null) {
			return true;
		}
		primaryHeadNode = selectMergedHeadNode(secondaryHeadNode, primaryNodes);
		if (primaryHeadNode == null) {
			primaryHeadNode = selectMergedHeadNode(secondaryHeadNode, primaryNodes);		// FIXME debugging
			if (debugFailures) {
				AbstractMerger.FAILURE.println("No primary head node to match: " + secondaryHeadNode);
			}
			return false;
		}
		secondaryNode2primaryNode.put(secondaryHeadNode, primaryHeadNode);
		return true;
	}

	protected boolean correlateNavigablePredicates() {
		//
		//	Loop over a growing worklist of secondary nodes.
		//
		Set<@NonNull Node> secondaryNodes = new HashSet<>(secondaryNode2primaryNode.keySet());
		List<@NonNull Node> secondaryNodesWorkList = new ArrayList<>(secondaryNodes);
		for (int i = 0; i < secondaryNodesWorkList.size(); i++) {
			@NonNull Node secondarySourceNode = secondaryNodesWorkList.get(i);
			@Nullable Node primarySourceNode = secondaryNode2primaryNode.get(secondarySourceNode);
			if (!strategy.navigableNodesMatch(secondarySourceNode, primarySourceNode)) {
				return false;
			}
			for (@NonNull NavigableEdge uncastSecondaryEdge : secondarySourceNode.getNavigationEdges()) {
				Node uncastSecondaryTargetNode = uncastSecondaryEdge.getEdgeTarget();
				Iterable<@NonNull Node> secondaryTargetNodes = RegionUtil.getCastTargets(uncastSecondaryTargetNode, true);
				if (primarySourceNode != null) {
					NavigableEdge uncastPrimaryEdge = primarySourceNode.getNavigationEdge(uncastSecondaryEdge.getProperty());	// Skip isSecondary properties
					if (!strategy.navigableEdgesMatch(uncastSecondaryEdge, uncastPrimaryEdge)) {
						return false;
					}
					if (uncastPrimaryEdge != null) {
						Node uncastPrimaryTargetNode = uncastPrimaryEdge.getEdgeTarget();
						if (uncastSecondaryTargetNode.isExplicitNull() != uncastPrimaryTargetNode.isExplicitNull()) {
							if (debugFailures) {
								AbstractMerger.FAILURE.println("Inconsistent ExplicitNull: " + uncastSecondaryTargetNode);
							}
							return false;
						}
						Map<@NonNull CompleteClass, @NonNull Node> completeClass2primaryTargetNodes = new HashMap<>();
						for (@NonNull Node primaryTargetNode : RegionUtil.getCastTargets(uncastPrimaryTargetNode, true)) {
							CompleteClass targetCompleteClass = primaryTargetNode.getCompleteClass();
							Node oldNode = completeClass2primaryTargetNodes.put(targetCompleteClass, primaryTargetNode);
							if (oldNode != null) {
								if (debugFailures) {
									AbstractMerger.FAILURE.println("Inconsistent paths to: " + targetCompleteClass);
								}
								return false;		// FIXME should have an earlier cast rationalizer
							}
						}
						for (@NonNull Node secondaryTargetNode : secondaryTargetNodes) {
							CompleteClass targetCompleteClass = secondaryTargetNode.getCompleteClass();
							Node primaryTargetNode = completeClass2primaryTargetNodes.remove(targetCompleteClass);
							if (primaryTargetNode != null) {
								Node primaryTargetNode2 = secondaryNode2primaryNode.get(secondaryTargetNode);
								if (primaryTargetNode2 == null) {
									secondaryNode2primaryNode.put(secondaryTargetNode, primaryTargetNode);
								}
								else if (primaryTargetNode != primaryTargetNode2) {
									if (debugFailures) {
										AbstractMerger.FAILURE.println("Inconsistent paths to: " + primaryTargetNode + ", " + primaryTargetNode2);
									}
									return false;		// FIXME Inconsistent navigation is too complex
								}
							}
						}
					}
				}
				for (@NonNull Node secondaryTargetNode : secondaryTargetNodes) {
					if (secondaryNodes.add(secondaryTargetNode)) {
						secondaryNodesWorkList.add(secondaryTargetNode);
					}
				}
			}
		}
		return true;
	}

	protected void correlateResidualComputations(@NonNull Iterable<@NonNull Node> secondaryNodes) {
		for (@NonNull Node secondaryNode : secondaryNodes) {
			Node primaryNode = secondaryNode2primaryNode.get(secondaryNode);
			assert primaryNode != null;
			Map<@NonNull Node, @NonNull Node> secondary2primary2 = new HashMap<>();
			if (correlateComputation(secondaryNode, primaryNode, secondary2primary2)) {	// FIXME use hashes
				secondaryNode2primaryNode.putAll(secondary2primary2);
			}
		}
	}

	public @NonNull Map<@NonNull Node, @NonNull Node> getNode2Node() {
		return secondaryNode2primaryNode;
	}

	/**
	 * Chose the headNode from a group of peer nodes that has the most non-implicit properties targeting its peers.
	 *
	protected @NonNull Node selectBestHeadNode(@NonNull List<@NonNull Node> headNodes) {
		int size = headNodes.size();
		assert size >= 1;
		if (size == 1) {
			return headNodes.get(0);
		}
		Node bestHeadNode = null;
		int bestNonImplicits = -1;
		List<@NonNull Node> sortedHeadNodes = new ArrayList<>(headNodes);
		Collections.sort(sortedHeadNodes, NameUtil.NAMEABLE_COMPARATOR);		// Stabilize order
		for (@NonNull Node thisHeadNode : sortedHeadNodes) {
			int nonImplicits = 0;
			for (@NonNull Node thatHeadNode : sortedHeadNodes) {
				for (@NonNull NavigableEdge edge : thisHeadNode.getNavigationEdges()) {
					if (edge.getTarget() == thatHeadNode) {
						Property property = edge.getProperty();
						if (!property.isIsImplicit()) {
							nonImplicits++;
							break;
						}
					}
				}
			}
			if (nonImplicits > bestNonImplicits) {
				bestHeadNode = thisHeadNode;
				bestNonImplicits = nonImplicits;
			}
		}
		assert bestHeadNode != null;
		return bestHeadNode;
	} */

	protected @Nullable Node selectMergedHeadNode(@NonNull Node headNode, @NonNull List<@NonNull Node> mergedNodes) {
		if (mergedNodes.size() == 1) {
			Node mergedNode = mergedNodes.get(0);//selectBestHeadNode(mergedNodes);
			//			if (mergedNode.isIterator()) {
			//				return null;
			//			}
			return mergedNode;
		}
		if (mergedNodes.size() == 0) {
			return null;
		}
		Iterable<NavigableEdge> predicateEdges = headNode.getPredicateEdges();
		for (@NonNull Node mergedNode : mergedNodes) {
			boolean ok = !mergedNode.isIterator();
			if (ok) {
				for (@NonNull NavigableEdge predicateEdge : predicateEdges) {
					Property property = predicateEdge.getProperty();
					Node navigation = mergedNode.getNavigationTarget(property);
					if (navigation == null) {
						ok = false;
						break;
					}
				}
			}
			if (ok) {						// FIXME stronger checking
				return mergedNode;
			}
		}
		return null;
	}
}
