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
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.BasicMappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigableEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.QVTp2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RegionMerger;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RegionUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis;
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
	 * Replace those orderedRegions that may be aggregated as part of a GuardedRegion decision tree by GuardedRegions.
	 * orderedRegions should be naturally ordered to ensure that non-recursive dependencies are inherently satisfied.
	 *
	 * Returns the orderedRegions plus the new aggregates less those aggregated.
	 */
	public static @NonNull List<@NonNull MappingRegion> earlyRegionMerge(@NonNull List<@NonNull BasicMappingRegion> orderedRegions) {
		Region2Depth region2depths = new Region2Depth();
		List<@NonNull MappingRegion> outputRegions = new ArrayList<>();
		LinkedHashSet<@NonNull MappingRegion> residualInputRegions = new LinkedHashSet<>(orderedRegions);	// order preserving fast random removal
		while (!residualInputRegions.isEmpty()) {
			@NonNull MappingRegion candidateRegion = residualInputRegions.iterator().next();
			boolean isMerged = false;
			if (isEarlyMergePrimaryCandidate(candidateRegion)) {
				List<@NonNull MappingRegion> secondaryRegions = selectSecondaryRegions(candidateRegion);
				if (secondaryRegions != null) {
					MappingRegion mergedRegion = candidateRegion;
					for (@NonNull MappingRegion secondaryRegion : secondaryRegions) {
						assert secondaryRegion != null;
						if (residualInputRegions.contains(secondaryRegion)) {
							Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode = EarlyMerger.canMerge(mergedRegion, secondaryRegion, region2depths, false);
							if (secondaryNode2primaryNode != null) {
								boolean isSharedHead = isSharedHead(mergedRegion, secondaryRegion);
								if (!isSharedHead || (EarlyMerger.canMerge(secondaryRegion, mergedRegion, region2depths, false) != null)) {
									residualInputRegions.remove(mergedRegion);
									residualInputRegions.remove(secondaryRegion);
									mergedRegion = RegionMerger.createMergedRegion(mergedRegion, secondaryRegion, secondaryNode2primaryNode);
									region2depths.addRegion(mergedRegion);
								}
							}
						}
					}
					if (mergedRegion != candidateRegion) {
						//						mergedRegion.resolveRecursion();
						if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
							mergedRegion.writeDebugGraphs("2-merged");
						}
						//						GuardedRegion guardedRegion = createGuardedRegion(mergedRegion, mergeableRegions);
						//						outputRegions.add(guardedRegion);
						outputRegions.add(mergedRegion);
						isMerged = true;
					}
				}
			}
			if (!isMerged) {
				outputRegions.add(candidateRegion);
			}
			residualInputRegions.remove(candidateRegion);
		}
		return outputRegions;
	}

	/**
	 * Return the nodes with region at which a suitably matching head of another region might be merged.
	 * The nodes must be bi-directionally one to one to respect 1:N trace node relationships.
	 */
	protected static @NonNull Iterable<@NonNull Node> getMergeableNodes(@NonNull MappingRegion region) {
		Set<@NonNull Node> mergeableNodes = new HashSet<>();
		for (@NonNull Node node : region.getHeadNodes()) {
			getMergeableNodes(mergeableNodes, node);
		}
		return mergeableNodes;
	}
	private static void getMergeableNodes(@NonNull Set<@NonNull Node> mergeableNodes, @NonNull Node node) {
		if (isMergeable(node) && mergeableNodes.add(node)) {
			for (@NonNull NavigableEdge edge : node.getNavigationEdges()) {
				if (edge.getOppositeEdge() != null) {
					getMergeableNodes(mergeableNodes, edge.getTarget());
				}
			}
		}
	}
	private static boolean isMergeable(@NonNull Node node) {	// FIXME this is legacy creep
		NodeRole nodeRole = node.getNodeRole();
		if (nodeRole.isRealized() || nodeRole.isSpeculation()) {
			return false;
		}
		if (!node.isClass()) {
			return false;
		}
		if (node.isExplicitNull()) {
			return true;
		}
		if (node.isOperation()) {
			return true;
		}
		if (node.isTrue()) {
			return true;
		}
		if (node.isPattern()) {
			return true;
		}
		return false;
	}

	/**
	 * The primary region in a GuardedRegion must be single-headed. It may be multiply-produced, e.g. recursed.
	 */
	private static boolean isEarlyMergePrimaryCandidate(@NonNull Region mappingRegion) {
		List<@NonNull Node> headNodes = mappingRegion.getHeadNodes();
		return headNodes.size() == 1;
	}

	/**
	 * The secondary region in a GuardedRegion must be single-headed and at least one its head nodes must be a class in use within
	 * the primary region. It may be multiply-produced, e.g. recursed.
	 */
	private static boolean isEarlyMergeSecondaryCandidate(@NonNull Region primaryRegion,
			@NonNull Region secondaryRegion, @NonNull Set<ClassDatumAnalysis> toOneReachableClasses) {
		List<@NonNull Node> secondaryHeadNodes = secondaryRegion.getHeadNodes();
		if (secondaryHeadNodes.size() == 1) {
			Node classNode = secondaryHeadNodes.get(0);
			ClassDatumAnalysis classDatumAnalysis = classNode.getClassDatumAnalysis();
			if (toOneReachableClasses.contains(classDatumAnalysis)) {
				return true;
			}
		}
		return false;
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
	 * Return true if any primaryRegion head coincides with a secondaryRegion head.
	 */
	private static boolean isSharedHead(@NonNull Region primaryRegion, @NonNull Region secondaryRegion) {
		for (Node primaryHead : primaryRegion.getHeadNodes()) {
			ClassDatumAnalysis primaryClassDatumAnalysis = primaryHead.getClassDatumAnalysis();
			for (Node secondaryHead : secondaryRegion.getHeadNodes()) {
				if (primaryClassDatumAnalysis == secondaryHead.getClassDatumAnalysis()) {
					return true;
				}
			}
		}
		return false;
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

	/**
	 * Return a list of single-headed to-one navigable regions whose head is transitively to-one reachable from the primaryRegion's head.
	 */
	private static @Nullable List<@NonNull MappingRegion> selectSecondaryRegions(@NonNull MappingRegion primaryRegion) {
		//
		//	All regions that consume one of the primary nodes.
		//
		Set<@NonNull MappingRegion> allConsumingRegions = new HashSet<>();
		allConsumingRegions.add(primaryRegion);
		//
		//	All classes reachable from the primary head.
		//
		Set<org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis> toOneReachableClasses = new HashSet<>();
		List<@NonNull MappingRegion> secondaryRegions = null;
		List<@NonNull MappingRegion> allConsumingRegionsList = new ArrayList<>(allConsumingRegions);	// CME-proof iterable List shadowing a mutating Set
		for (int i = 0; i < allConsumingRegionsList.size(); i++) {
			@NonNull MappingRegion secondaryRegion = allConsumingRegionsList.get(i);
			if ((i == 0) || isEarlyMergeSecondaryCandidate(primaryRegion, secondaryRegion, toOneReachableClasses)) {
				if (i > 0) {
					if (secondaryRegions == null) {
						secondaryRegions = new ArrayList<>();
					}
					secondaryRegions.add(secondaryRegion);
				}
				for (@NonNull Node predicatedNode : getMergeableNodes(secondaryRegion)) {
					if (predicatedNode.isClass()) {							// Ignore nulls, attributes
						ClassDatumAnalysis predicatedClassDatumAnalysis = predicatedNode.getClassDatumAnalysis();
						if (toOneReachableClasses.add(predicatedClassDatumAnalysis)) {
							for (@NonNull MappingRegion consumingRegion : predicatedClassDatumAnalysis.getConsumingRegions()) {
								if (allConsumingRegions.add(consumingRegion)) {
									allConsumingRegionsList.add(consumingRegion);
								}
							}
						}
					}
				}
				for (@NonNull Node newNode : secondaryRegion.getNewNodes()) {
					if (newNode.isClass()) {							// Ignore nulls, attributes
						ClassDatumAnalysis consumingClassDatumAnalysis = newNode.getClassDatumAnalysis();
						if (toOneReachableClasses.add(consumingClassDatumAnalysis)) {
							for (@NonNull MappingRegion consumingRegion : consumingClassDatumAnalysis.getConsumingRegions()) {
								if (allConsumingRegions.add(consumingRegion)) {
									allConsumingRegionsList.add(consumingRegion);
								}
							}
						}
					}
				}
			}
		}
		assert allConsumingRegionsList.size() == allConsumingRegions.size();					// Check same changes to CME-proof shadow
		return secondaryRegions;
	}
}
