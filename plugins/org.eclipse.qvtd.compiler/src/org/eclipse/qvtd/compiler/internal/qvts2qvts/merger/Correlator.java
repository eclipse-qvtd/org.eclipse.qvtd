/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.merger;

import java.util.ArrayList;
import java.util.Collections;
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
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A Correlator analyzes the compatibility of a new extraRegion with the future merge of one or more oruuginal regions identifued by a regionMerger.
 */
class Correlator
{
	public static @Nullable Correlator correlate(@NonNull RegionMerger regionMerger, @NonNull MappingRegion extraRegion, @NonNull CorrelationStrategy strategy, @Nullable Correlator inverseCorrelator) {
		if (extraRegion instanceof RuleRegion) {
			if (((RuleRegion)extraRegion).getReferredRule().isIsAbstract()) {
				return null;
			}
		}
		if (regionMerger.isAbstract()) {
			return null;
		}
		Correlator correlator = new Correlator(regionMerger, extraRegion, strategy, inverseCorrelator);
		return correlator.correlate() ? correlator : null;
	}

	private static interface CorrelationStrategy
	{
		boolean navigableEdgesMatch(@Nullable EdgeMerger edgeMerger, @NonNull NavigableEdge extraEdge);
		//		boolean navigableIntermediateNodesMatch(@NonNull Node extraNode, @NonNull Node primaryNode);
		//		boolean navigableNodeMaybeUnmatched(@NonNull Node extraNode);
		boolean navigableNodesMatch(@Nullable NodeMerger nodeMerger, @NonNull Node extraNode);
	}

	static abstract class AbstractCorrelationStrategy implements CorrelationStrategy
	{
		protected final boolean debugFailures = AbstractMerger.FAILURE.isActive();

		@Override
		public boolean navigableEdgesMatch(@Nullable EdgeMerger edgeMerger, @NonNull NavigableEdge extraEdge) {
			return true;
		}

		@Override
		public boolean navigableNodesMatch(@Nullable NodeMerger nodeMerger, @NonNull Node extraNode) {
			if (nodeMerger == null) {
				if (extraNode.isPredicated()) {
					if (debugFailures) {
						AbstractMerger.FAILURE.println("Missing predicated match for : " + extraNode);
					}
					return false;
				}
				return true;
			}
			else {
				assert extraNode.isNullLiteral() == nodeMerger.isNullLiteral();
				return true;
			}
		}

		//		@Override
		//		public boolean navigableIntermediateNodesMatch(@NonNull Node extraNode, @NonNull Node primaryNode) {
		//			if (extraNode.isExplicitNull() != primaryNode.isExplicitNull()) {
		//				return false;
		//			}
		//			return true;
		//		}
	}

	protected final @NonNull RegionMerger regionMerger;
	protected final @NonNull MappingRegion extraRegion;
	protected final @NonNull CorrelationStrategy strategy;
	protected final @NonNull Map<@NonNull Node, @NonNull NodeMerger> extraNode2nodeMerger = new HashMap<>();
	protected final boolean debugFailures = AbstractMerger.FAILURE.isActive();

	protected Correlator(@NonNull RegionMerger regionMerger, @NonNull MappingRegion extraRegion, @NonNull CorrelationStrategy strategy, @Nullable Correlator inverseCorrelator) {
		this.regionMerger = regionMerger;
		this.extraRegion = extraRegion;
		this.strategy = strategy;
		if (inverseCorrelator != null) {
			Map<@NonNull Node, @NonNull NodeMerger> inverseNode2NodeMerger = inverseCorrelator.getNode2NodeMerger();
			for (@NonNull Node inverseNode : inverseNode2NodeMerger.keySet()) {
				NodeMerger forwardNodeMerger = inverseNode2NodeMerger.get(inverseNode);
				assert forwardNodeMerger != null;
				NodeMerger inverseNodeMerger = regionMerger.getNodeMerger(inverseNode);
				for (@NonNull Node extraNode : forwardNodeMerger.getOriginalNodes()) {
					extraNode2nodeMerger.put(extraNode, inverseNodeMerger);
				}
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
		if (!correlateNavigablePredicates()) { // FIXME this may be more efficient but it's a pig to debug, rewrite as intersection then no-extra-predicates
			return false;
		}
		Set<@NonNull Node> navigableNodes = extraNode2nodeMerger.keySet();
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
	protected boolean correlateComputation(@NonNull Node firstNode, @NonNull NodeMerger secondNodeMerger, @NonNull Map<@NonNull Node, @NonNull NodeMerger> first2second) {
		NodeMerger nodeMerger = first2second.get(firstNode);
		if (nodeMerger != null) {
			return nodeMerger == secondNodeMerger;
		}
		//		Node secondNode = secondNodeMerger.getPrimaryNode();
		if (firstNode.getNodeRole() != secondNodeMerger.getNodeRole()) {
			return false;
		}
		if (!ClassUtil.safeEquals(firstNode.getName(), secondNodeMerger.getName())) {		// FIXME stronger e.g. referredOperation
			return false;
		}
		Map<@NonNull Node, @NonNull NodeMerger> nestedFirst2second = new HashMap<>(first2second);
		nestedFirst2second.put(firstNode, secondNodeMerger);
		List<@NonNull Edge> residualSecondArgumentEdges = Lists.newArrayList(secondNodeMerger.getArgumentEdges());
		for (@NonNull Edge firstEdge : firstNode.getArgumentEdges()) {
			boolean gotIt = false;
			for (@NonNull Edge secondEdge : residualSecondArgumentEdges) {
				if (ClassUtil.safeEquals(firstEdge.getName(), secondEdge.getName())) {
					if (!correlateComputation(firstEdge.getEdgeSource(), regionMerger.getNodeMerger(secondEdge.getEdgeSource()), nestedFirst2second)) {
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
	 *	Return true if all the computed (TrueNode) predicates exactly match between regionMerger and extraRegion,
	 *	updating extraNode2nodeMerger accordingly.
	 */
	protected boolean correlateComputedPredicates() {	// FIXME
		Iterable<@NonNull Node> primaryTrueNodes = Collections.emptyList(); //primaryRegion.getTrueNodes();
		Iterable<@NonNull Node> extraTrueNodes = Collections.emptyList(); //extraRegion.getTrueNodes();
		int primaryTrueSize = Iterables.size(primaryTrueNodes);
		if (primaryTrueSize != Iterables.size(extraTrueNodes)) {
			return false;
		}
		if (primaryTrueSize == 0) {
			return true;
		}
		Map<@NonNull Node, @NonNull NodeMerger> primary2extra = new HashMap<>();
		if (primaryTrueSize == 1) {
			Node primaryTrueNode = primaryTrueNodes.iterator().next();
			Node extraTrueNode = extraTrueNodes.iterator().next();
			if (!correlateComputation(primaryTrueNode, regionMerger.getNodeMerger(extraTrueNode), primary2extra)) {
				return false;
			}
		}
		else {
			Set<@NonNull Node> residualExtraTrueNodes = Sets.newHashSet(extraTrueNodes);
			for (@NonNull Node primaryTrueNode : primaryTrueNodes) {
				boolean gotIt = false;
				for (@NonNull Node extraTrueNode : residualExtraTrueNodes) {
					Map<@NonNull Node, @NonNull NodeMerger> primary2extra2 = new HashMap<>();
					if (correlateComputation(primaryTrueNode, regionMerger.getNodeMerger(extraTrueNode), primary2extra2)) {	// FIXME use hashes
						gotIt = true;
						primary2extra.putAll(primary2extra2);
						residualExtraTrueNodes.remove(extraTrueNode);
						break;
					}
				}
				if (!gotIt) {
					return false;
				}
			}
		}
		for (@NonNull Node primaryNode : primary2extra.keySet()) {
			NodeMerger equivalentNodeMerger = primary2extra.get(primaryNode);
			assert equivalentNodeMerger != null;
			NodeMerger primaryNodeMerger = regionMerger.getNodeMerger(primaryNode);
			for (@NonNull Node originalNode : equivalentNodeMerger.getOriginalNodes()) {
				extraNode2nodeMerger.put(originalNode, primaryNodeMerger);
			}
		}
		return true;
	}

	protected boolean correlateHeadNodes() {
		List<Node> extraHeadNodes = extraRegion.getHeadNodes();
		if (extraHeadNodes.size() != 1) {			// FIXME Surely consistent multiple heads are ok?
			if (debugFailures) {
				AbstractMerger.FAILURE.println("More than 1 extra head nodes: " + extraHeadNodes.size());
			}
			return false;
		}
		if (QVTscheduleUtil.hasPredicates(extraRegion)) {
			return false;			// FIXME upgrade to allow merging of matching predicates
		}
		Node extraHeadNode = extraHeadNodes.get(0);
		CompleteClass completeClass = extraHeadNode.getCompleteClass();
		List<@NonNull NodeMerger> nodeMergers = regionMerger.getNodeMergers(completeClass);
		if ((nodeMergers == null) || (nodeMergers.size() == 0)) {
			if (debugFailures) {
				AbstractMerger.FAILURE.println("No node mergers of type: " + completeClass);
			}
			return false;
		}
		NodeMerger headNodeMerger = extraNode2nodeMerger.get(extraHeadNode);
		if (headNodeMerger == null) {
			headNodeMerger = selectHeadNodeMerger(extraHeadNode, nodeMergers);
			if (headNodeMerger == null) {
				headNodeMerger = selectHeadNodeMerger(extraHeadNode, nodeMergers);		// FIXME debugging
				if (debugFailures) {
					AbstractMerger.FAILURE.println("No head node merger to match: " + extraHeadNode);
				}
				return false;
			}
			extraNode2nodeMerger.put(extraHeadNode, headNodeMerger);
		}
		if (nodeMergers.size() > 1) {
			for (@NonNull NodeMerger nodeMerger : nodeMergers) {
				if ((nodeMerger != headNodeMerger) && !nodeMerger.isLoaded()) {
					if (debugFailures) {		// FIXME multiple matching not-speculated might be ok
						AbstractMerger.FAILURE.println("Multiple node mergers of type: " + completeClass);
					}
					return false;
				}
			}
		}
		return true;
	}

	protected boolean correlateNavigablePredicates() {
		//
		//	Loop over a growing worklist of extra nodes.
		//
		Set<@NonNull Node> extraNodes = new HashSet<>(extraNode2nodeMerger.keySet());
		List<@NonNull Node> extraNodesWorkList = new ArrayList<>(extraNodes);
		for (int i = 0; i < extraNodesWorkList.size(); i++) {
			@NonNull Node extraSourceNode = extraNodesWorkList.get(i);
			@Nullable NodeMerger sourceNodeMerger = extraNode2nodeMerger.get(extraSourceNode);
			if (!strategy.navigableNodesMatch(sourceNodeMerger, extraSourceNode)) {
				return false;
			}
			for (@NonNull NavigableEdge uncastExtraEdge : extraSourceNode.getNavigableEdges()) {
				Node uncastExtraTargetNode = uncastExtraEdge.getEdgeTarget();
				Iterable<@NonNull Node> extraTargetNodes = QVTscheduleUtil.getCastTargets(uncastExtraTargetNode, true);
				if (sourceNodeMerger != null) {
					NavigableEdge uncastPrimaryEdge = sourceNodeMerger.getNavigableEdge(QVTscheduleUtil.getProperty(uncastExtraEdge));	// Skip isSecondary properties
					EdgeMerger edgeMerger = uncastPrimaryEdge != null ? regionMerger.getEdgeMerger(uncastPrimaryEdge) : null;
					if (!strategy.navigableEdgesMatch(edgeMerger, uncastExtraEdge)) {
						return false;
					}
					if (uncastPrimaryEdge != null) {
						Node uncastPrimaryTargetNode = uncastPrimaryEdge.getEdgeTarget();
						if (uncastExtraTargetNode.isNullLiteral() != uncastPrimaryTargetNode.isNullLiteral()) {
							if (debugFailures) {
								AbstractMerger.FAILURE.println("Inconsistent ExplicitNull: " + uncastExtraTargetNode);
							}
							return false;
						}
						Map<@NonNull CompleteClass, @NonNull NodeMerger> completeClass2targetNodeMergers = new HashMap<>();
						for (@NonNull Node primaryTargetNode : QVTscheduleUtil.getCastTargets(uncastPrimaryTargetNode, true)) {
							CompleteClass targetCompleteClass = primaryTargetNode.getCompleteClass();
							NodeMerger oldNodeMerger = completeClass2targetNodeMergers.put(targetCompleteClass, regionMerger.getNodeMerger(primaryTargetNode));
							if (oldNodeMerger != null) {
								if (debugFailures) {
									AbstractMerger.FAILURE.println("Inconsistent paths to: " + targetCompleteClass);
								}
								return false;		// FIXME should have an earlier cast rationalizer
							}
						}
						for (@NonNull Node extraTargetNode : extraTargetNodes) {
							CompleteClass targetCompleteClass = extraTargetNode.getCompleteClass();
							NodeMerger targetNodeMerger = completeClass2targetNodeMergers.remove(targetCompleteClass);
							if (targetNodeMerger == null) {
								if (debugFailures) {
									AbstractMerger.FAILURE.println("Inconsistent types at: " + targetNodeMerger + ", " + extraTargetNode);
								}
								return false;		// FIXME Inconsistent navigation is too complex
							}
							else {
								NodeMerger targetNodeMerger2 = extraNode2nodeMerger.get(extraTargetNode);
								if (targetNodeMerger2 == null) {
									extraNode2nodeMerger.put(extraTargetNode, targetNodeMerger);
								}
								else if (targetNodeMerger != targetNodeMerger2) {
									if (debugFailures) {
										AbstractMerger.FAILURE.println("Inconsistent paths to: " + targetNodeMerger + ", " + targetNodeMerger2);
									}
									return false;		// FIXME Inconsistent navigation is too complex
								}
							}
						}
					}
				}
				for (@NonNull Node extraTargetNode : extraTargetNodes) {
					if (extraNodes.add(extraTargetNode)) {
						extraNodesWorkList.add(extraTargetNode);
					}
				}
			}
		}
		return true;
	}

	protected void correlateResidualComputations(@NonNull Iterable<@NonNull Node> extraNodes) {
		for (@NonNull Node extraNode : extraNodes) {
			NodeMerger nodeMerger = extraNode2nodeMerger.get(extraNode);
			assert nodeMerger != null;
			Map<@NonNull Node, @NonNull NodeMerger> extraNode2nodeMerger2 = new HashMap<>();
			if (correlateComputation(extraNode, nodeMerger, extraNode2nodeMerger2)) {	// FIXME use hashes
				for (@NonNull Node extraNode2 : extraNode2nodeMerger2.keySet()) {
					NodeMerger nodeMerger2 = extraNode2nodeMerger2.get(extraNode2);
					assert nodeMerger2 != null;
					extraNode2nodeMerger.put(extraNode2, nodeMerger2);
				}
			}
		}
	}

	public @NonNull Map<@NonNull Node, @NonNull NodeMerger> getNode2NodeMerger() {
		return extraNode2nodeMerger;
	}

	public @NonNull RegionMerger getRegionMerger() {
		return regionMerger;
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

	protected @Nullable NodeMerger selectHeadNodeMerger(@NonNull Node headNode, @NonNull List<@NonNull NodeMerger> nodeMergers) {
		if (nodeMergers.size() == 1) {
			NodeMerger nodeMerger = nodeMergers.get(0);//selectBestHeadNode(mergedNodes);
			//			if (mergedNode.isIterator()) {
			//				return null;
			//			}
			return nodeMerger;
		}
		if (nodeMergers.size() == 0) {
			return null;
		}
		Iterable<NavigableEdge> predicateEdges = headNode.getPredicateEdges();
		for (@NonNull NodeMerger nodeMerger : nodeMergers) {
			boolean ok = !nodeMerger.isIterator();
			if (ok) {
				for (@NonNull NavigableEdge predicateEdge : predicateEdges) {
					Property property = QVTscheduleUtil.getProperty(predicateEdge);
					Node navigation = nodeMerger.getNavigableTarget(property);
					if (navigation == null) {
						ok = false;
						break;
					}
				}
			}
			if (ok) {						// FIXME stronger checking
				return nodeMerger;
			}
		}
		return null;
	}
}
