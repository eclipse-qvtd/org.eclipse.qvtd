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
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigableEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RegionUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

class Correlator
{
	public static @Nullable Correlator correlate(@NonNull MappingRegion secondaryRegion, @NonNull MappingRegion primaryRegion) {
		Correlator correlator = new Correlator(primaryRegion, secondaryRegion);
		return correlator.correlate() ? correlator : null;
	}

	protected final @NonNull MappingRegion primaryRegion;
	protected final @NonNull MappingRegion secondaryRegion;
	protected final @NonNull Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode = new HashMap<>();
	protected final @NonNull Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> completeClass2primaryNodes;

	protected Correlator(@NonNull MappingRegion primaryRegion, @NonNull MappingRegion secondaryRegion) {
		this.primaryRegion = primaryRegion;
		this.secondaryRegion = secondaryRegion;
		this.completeClass2primaryNodes = RegionUtil.getCompleteClass2Nodes(primaryRegion);
	}

	protected boolean correlate() {
		//
		//	Find the unambiguous head-node matches
		//
		List<@NonNull Node> secondaryHeadNodes = secondaryRegion.getHeadNodes();
		if (secondaryHeadNodes.size() != 1) {
			return false;
		}
		Node secondaryHeadNode = secondaryHeadNodes.get(0);
		CompleteClass completeClass = secondaryHeadNode.getCompleteClass();
		List<@NonNull Node> primaryNodes = completeClass2primaryNodes.get(completeClass);
		if (primaryNodes == null) {
			return false;
		}
		Node primaryHeadNode = selectMergedHeadNode(secondaryHeadNode, primaryNodes);
		if (primaryHeadNode == null) {
			return false;
		}
		secondaryNode2primaryNode.put(secondaryHeadNode, primaryHeadNode);
		//
		//	Validate the transitive navigation from the head nodes. All common navigation edges must have compatible node types.
		//
		if (!canMergeInternal()) {
			return false;
		}

		if (!correlateComputedPredicates()) {
			return false;
		}
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
			if (!isEquivalent(primaryTrueNode, secondaryTrueNode, primary2secondary)) {
				return false;
			}
		}
		else {
			Set<@NonNull Node> residualSecondaryTrueNodes = Sets.newHashSet(secondaryTrueNodes);
			for (@NonNull Node primaryTrueNode : primaryTrueNodes) {
				boolean gotIt = false;
				for (@NonNull Node secondaryTrueNode : residualSecondaryTrueNodes) {
					Map<@NonNull Node, @NonNull Node> primary2secondary2 = new HashMap<>();
					if (isEquivalent(primaryTrueNode, secondaryTrueNode, primary2secondary2)) {	// FIXME use hashes
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

	protected boolean canMergeInternal() {
		Set<@NonNull Node> secondaryNodes = new HashSet<>(secondaryNode2primaryNode.keySet());
		List<@NonNull Node> secondaryNodesList = new ArrayList<>(secondaryNodes);
		for (int i = 0; i < secondaryNodesList.size(); i++) {
			@NonNull Node secondarySourceNode = secondaryNodesList.get(i);
			Node primarySourceNode = secondaryNode2primaryNode.get(secondarySourceNode);
			if (primarySourceNode == null) {
				if (secondarySourceNode.isPredicated()) {
					return false;
				}
			}
			for (@NonNull NavigableEdge secondaryEdge : secondarySourceNode.getNavigationEdges()) {
				Node secondaryTargetNode = RegionUtil.getCastTarget(secondaryEdge.getTarget());
				Node primaryTargetNode = null;
				if (primarySourceNode != null) {
					Edge primaryEdge = primarySourceNode.getNavigationEdge(secondaryEdge.getProperty());
					if (primaryEdge != null) {
						primaryTargetNode = RegionUtil.getCastTarget(primaryEdge.getTarget());
						//						primaryTargetNode = primaryTargetNode.getCastEquivalentNode();
						//						secondaryTargetNode = secondaryTargetNode.getCastEquivalentNode();
						if (primaryTargetNode.getCompleteClass() != secondaryTargetNode.getCompleteClass()) {		// FIXME conforms
							return false;
						}
						if (primaryTargetNode.isExplicitNull() != secondaryTargetNode.isExplicitNull()) {		// FIXME conforms
							return false;
						}
					}
					else {
						if (secondaryEdge.isPredicated()) {
							//							if (!isLateMerge) {		// FIXME must locate in ancestry; if present can merge, if not cannot
							return false;
							//							}
							//							for (@SuppressWarnings("unused") Node secondaryOriginNode : secondaryTargetNode.getUsedBindingSources()) {
							//								return false;
							//							}
						}
					}
				}
				if (primaryTargetNode != null) {
					Node primaryTargetNode2 = secondaryNode2primaryNode.get(secondaryTargetNode);
					if (primaryTargetNode2 == null) {
						secondaryNode2primaryNode.put(secondaryTargetNode, primaryTargetNode);
					}
				}
				assert secondaryTargetNode != null;
				if (secondaryNodes.add(secondaryTargetNode)) {
					//					if (mergedTargetNode != null) {
					//						if (!secondaryTargetNode.isAttributeNode()) {
					secondaryNodesList.add(secondaryTargetNode);
					//						}
				}

			}
			if (/*!isLateMerge &&*/ (primarySourceNode != null)) {
				for (@NonNull Edge secondaryEdge : secondarySourceNode.getComputationEdges()) {
					Node secondaryTargetNode = secondaryEdge.getTarget();
					Node primaryTargetNode = null;
					for (@NonNull Edge primaryEdge : primarySourceNode.getComputationEdges()) {
						if (ClassUtil.safeEquals(primaryEdge.getName(), secondaryEdge.getName())) {
							primaryTargetNode = primaryEdge.getTarget();
							if (isEquivalent(secondaryTargetNode, primaryTargetNode, secondaryNode2primaryNode)) {
								secondaryNodesList.add(secondaryTargetNode);
							}
						}
					}
				}
			}
			/*

					}
					if (secondaryEdge instanceof NavigationEdge) {
						Edge primaryEdge = primarySourceNode.getNavigationEdge(((NavigationEdge)secondaryEdge).getProperty());
						if (primaryEdge != null) {
							primaryTargetNode = primaryEdge.getTarget();
//							primaryTargetNode = primaryTargetNode.getCastEquivalentNode();
//							secondaryTargetNode = secondaryTargetNode.getCastEquivalentNode();
							if (primaryTargetNode.getCompleteClass() != secondaryTargetNode.getCompleteClass()) {		// FIXME conforms
								return false;
							}
						}
						else {
							if (secondaryEdge.isPredicated()) {
								if (!isLateMerge) {		// FIXME must locate in ancestry; if present can merge, if not cannot
									return false;
								}
								for (@SuppressWarnings("null")@NonNull Node secondaryOriginNode : secondaryTargetNode.getUsedBindingSources()) {
									if (!region2depths.isAfter(secondaryOriginNode, this)) {
										return false;
									}
								}
							}
						}
					}
					else {} // FIXME???
				}
				if (primaryTargetNode != null) {
					Node primaryTargetNode2 = secondaryNode2primaryNode.get(secondaryTargetNode);
					if (primaryTargetNode2 == null) {
						secondaryNode2primaryNode.put(secondaryTargetNode, primaryTargetNode);
					}
					if (secondaryNodes.add(secondaryTargetNode)) {
	//					if (mergedTargetNode != null) {
						if (!secondaryTargetNode.isAttributeNode()) {
							secondaryNodesList.add(secondaryTargetNode);
						}
					}
				}
			} */
		}
		return true;
	}

	public @NonNull Map<@NonNull Node, @NonNull Node> getNode2Node() {
		return secondaryNode2primaryNode;
	}

	/**
	 * Return true if the operation nodes for primaryNode and secondaryNode are equivalent
	 * assigning equivalences to equivalentNodes.
	 */
	protected boolean isEquivalent(@NonNull Node primaryNode, @NonNull Node secondaryNode, @NonNull Map<@NonNull Node, @NonNull Node> primary2secondary) {
		Node node = primary2secondary.get(primaryNode);
		if (node != null) {
			return node == secondaryNode;
		}
		if (primaryNode.getNodeRole() != secondaryNode.getNodeRole()) {
			return false;
		}
		if (!ClassUtil.safeEquals(primaryNode.getName(), secondaryNode.getName())) {		// FIXME stronger e.g. referredOperation
			return false;
		}
		HashMap<@NonNull Node, @NonNull Node> nestedPrimary2secondary = new HashMap<>(primary2secondary);
		nestedPrimary2secondary.put(primaryNode, secondaryNode);
		for (@NonNull Edge primaryEdge : primaryNode.getArgumentEdges()) {
			boolean gotIt = false;
			for (@NonNull Edge secondaryEdge : secondaryNode.getArgumentEdges()) {
				if (ClassUtil.safeEquals(primaryEdge.getName(), secondaryEdge.getName())) {
					if (!isEquivalent(primaryEdge.getSource(), secondaryEdge.getSource(), nestedPrimary2secondary)) {
						return false;
					}
					gotIt = true;
					break;
				}
			}
			if (!gotIt) {
				return false;
			}
		}
		primary2secondary.putAll(nestedPrimary2secondary);
		return true;
	}

	/**
	 * Chose the headNode from a group of peer nodes that has the most non-implicit properties targeting its peers.
	 */
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
	}

	protected @Nullable Node selectMergedHeadNode(@NonNull Node headNode, @NonNull List<@NonNull Node> mergedNodes) {
		if (mergedNodes.size() == 1) {
			Node mergedNode = selectBestHeadNode(mergedNodes);
			if (mergedNode.isIterator()) {
				return null;
			}
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
