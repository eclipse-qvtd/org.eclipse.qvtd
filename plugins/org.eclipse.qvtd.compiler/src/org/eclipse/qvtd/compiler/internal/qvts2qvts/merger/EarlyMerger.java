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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigableEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RegionUtil;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Region2Depth;

import com.google.common.collect.Iterables;

public class EarlyMerger
{
	public static @Nullable Map<@NonNull Node, @NonNull Node> canMerge(@NonNull Region primaryRegion, @NonNull Region secondaryRegion, @NonNull Region2Depth region2depths, boolean isLateMerge) {
		Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode = null;
		Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> completeClass2nodes = RegionUtil.getCompleteClass2Nodes(primaryRegion);
		//
		//	Find the unambiguous head-node matches
		//
		List<@NonNull Node> secondaryHeadNodes = secondaryRegion.getHeadNodes();
		if (secondaryHeadNodes.size() != 1) {
			return null;
		}
		Node secondaryHeadNode = secondaryHeadNodes.get(0);
		CompleteClass completeClass = secondaryHeadNode.getCompleteClass();
		List<@NonNull Node> primaryNodes = completeClass2nodes.get(completeClass);
		if (primaryNodes != null) {
			Node primaryHeadNode = selectMergedHeadNode(secondaryHeadNode, primaryNodes);
			if (primaryHeadNode == null) {
				return null;
			}
			secondaryNode2primaryNode = new HashMap<>();
			if ("if".equals(secondaryHeadNode.getName())) {
				secondaryHeadNode.getName();
			}
			secondaryNode2primaryNode.put(secondaryHeadNode, primaryHeadNode);
		}
		if (secondaryNode2primaryNode == null) {
			return null;
		}
		//
		//	Validate the transitive navigation from the head nodes. All common navigation edges must have compatible node types.
		//
		if (!canMergeInternal(secondaryRegion, secondaryNode2primaryNode, region2depths, isLateMerge)) {
			return null;
		}
		//FIXME Must be symmetrically mergeable; do tests before creating MergedRegion
		//
		//	Validate the true node predicate compatibility
		//
		Iterable<@NonNull Node> primaryTrueNodes = primaryRegion.getTrueNodes();
		Iterable<@NonNull Node> secondaryTrueNodes = secondaryRegion.getTrueNodes();
		if (Iterables.size(primaryTrueNodes) != Iterables.size(secondaryTrueNodes)) {
			return null;
		}
		for (@NonNull Node primaryTrueNode : primaryTrueNodes) {
			boolean gotIt = false;
			for (@NonNull Node secondaryTrueNode : secondaryTrueNodes) {
				assert secondaryTrueNode != null;
				Map<@NonNull Node, @NonNull Node> primary2secondary = new HashMap<>();
				if (isEquivalent(primaryTrueNode, secondaryTrueNode, primary2secondary)) {	// FIXME use hashes
					gotIt = true;
					for (@NonNull Node primaryNode : primary2secondary.keySet()) {
						Node equivalentNode = primary2secondary.get(primaryNode);
						assert equivalentNode != null;
						if ("if".equals(equivalentNode.getName())) {
							equivalentNode.getName();
						}
						secondaryNode2primaryNode.put(equivalentNode, primaryNode);
					}
					break;
				}
			}
			if (!gotIt) {
				return null;
			}
		}
		return secondaryNode2primaryNode;
	}
	private static boolean canMergeInternal(@NonNull Region secondaryRegion, @NonNull Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode, @NonNull Region2Depth region2depths, boolean isLateMerge) {
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
				Node secondaryTargetNode = secondaryEdge.getTarget();
				Node primaryTargetNode = null;
				if (primarySourceNode != null) {
					Edge primaryEdge = primarySourceNode.getNavigationEdge(secondaryEdge.getProperty());
					if (primaryEdge != null) {
						primaryTargetNode = primaryEdge.getTarget();
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
							if (!isLateMerge) {		// FIXME must locate in ancestry; if present can merge, if not cannot
								return false;
							}
							for (@SuppressWarnings("unused") Node secondaryOriginNode : secondaryTargetNode.getUsedBindingSources()) {
								return false;
							}
						}
					}
				}
				if (primaryTargetNode != null) {
					Node primaryTargetNode2 = secondaryNode2primaryNode.get(secondaryTargetNode);
					if (primaryTargetNode2 == null) {
						if ("if".equals(secondaryTargetNode.getName())) {
							secondaryTargetNode.getName();
						}
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
			if (!isLateMerge && (primarySourceNode != null)) {
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

	/**
	 * Return true if the operation nodes for primaryNode and secondaryNode are equivalent
	 * assigning equivalences to equivalentNodes.
	 */
	private static boolean isEquivalent(@NonNull Node primaryNode, @NonNull Node secondaryNode, @NonNull Map<@NonNull Node, @NonNull Node> primary2secondary) {
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
	protected static @NonNull Node selectBestHeadNode(@NonNull List<@NonNull Node> headNodes) {
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

	private static @Nullable Node selectMergedHeadNode(@NonNull Node headNode, @NonNull List<@NonNull Node> mergedNodes) {
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
		//		if (predicateEdges == null) {
		//			return null;
		//		}
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
