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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigableEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.QVTp2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RegionUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Region2Depth;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * EarlyMerger replaces one list of MappingRegions by another in which each set of regions that can be merged
 * without knowledge of the schedule is replaced by an equivalent merged region.
 */
public class EarlyMerger
{
	/**
	 * Replace those inputRegions that may be merged by merged regions.
	 *
	 * inputRegions should be naturally ordered to ensure that non-recursive dependencies are inherently satisfied.
	 *
	 * Returns the inputRegions after replacement of merges.
	 */
	public static @NonNull List<@NonNull MappingRegion> merge(@NonNull Iterable<@NonNull MappingRegion> inputRegions) {
		EarlyMerger earlyMerger = new EarlyMerger(inputRegions);
		return earlyMerger.merge();
	}

	protected final @NonNull LinkedHashSet<@NonNull MappingRegion> residualInputRegions;
	protected final @NonNull List<@NonNull MappingRegion> outputRegions = new ArrayList<>();
	protected final @NonNull Region2Depth region2depths = new Region2Depth();

	protected EarlyMerger(@NonNull Iterable<@NonNull MappingRegion> inputRegions) {
		this.residualInputRegions = Sets.newLinkedHashSet(inputRegions);
	}

	protected @Nullable Map<@NonNull Node, @NonNull Node> canMerge(@NonNull Region primaryRegion, @NonNull Region secondaryRegion, @NonNull Region2Depth region2depths, boolean isLateMerge) {
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
	protected boolean canMergeInternal(@NonNull Region secondaryRegion, @NonNull Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode, @NonNull Region2Depth region2depths, boolean isLateMerge) {
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
	 * Return the nodes within region at which a suitably matching head of another region might be merged.
	 * The nodes must be bi-directionally one to one to respect 1:N trace node relationships.
	 */
	protected @NonNull Iterable<@NonNull Node> getHostNodes(@NonNull MappingRegion region) {
		Set<@NonNull Node> hostNodes = new HashSet<>();
		for (@NonNull Node node : region.getHeadNodes()) {
			getHostNodesAccumulator(hostNodes, node);
		}
		return hostNodes;
	}

	protected void getHostNodesAccumulator(@NonNull Set<@NonNull Node> hostNodes, @NonNull Node node) {
		//		if (node.isNew()) {
		//			return;
		//		}
		if (!node.isClass()) {		// Simplify - this obviates many of the below
			return;
		}
		if (node.isExplicitNull()) {
			return;
		}
		if (node.isOperation()) {
			return;
		}
		if (!node.isRequired()) {
			return;
		}
		if (node.isTrue()) {
			return;
		}
		if (!node.isPattern()) {
			return;
		}
		if (!hostNodes.add(node)) {
			return;
		}
		for (@NonNull NavigableEdge edge : node.getNavigationEdges()) {
			if (/*!edge.isSecondary() &&*/ edge.isUnconditional()) {		// ?? why isSecondary ?? why not isLoaded ??
				Property property = edge.getProperty();
				if (edge.isNew()) {
					if (isToZeroOrOne(property) && isToZeroOrOne(property.getOpposite())) {
						getHostNodesAccumulator(hostNodes, edge.getTarget());
					}
				}
				else {
					if (isToOne(property) && isToOne(property.getOpposite())) {
						getHostNodesAccumulator(hostNodes, edge.getTarget());
					}
				}
			}
		}
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
	 * The primary region of a merge must be single-headed. It may be multiply-produced, e.g. recursed.
	 *
	 * FIXME Is there any need for this restriction.
	 */
	protected boolean isPrimaryCandidate(@NonNull Region mappingRegion) {
		List<@NonNull Node> headNodes = mappingRegion.getHeadNodes();
		return headNodes.size() == 1;
	}

	/**
	 * The secondary region of a merge must be single-headed and its head node must correspond to
	 * a non-null unconditional class within the primary region. It may be multiply-produced, e.g. recursed.
	 */
	protected boolean isSecondaryCandidate(@NonNull Region primaryRegion,
			@NonNull Region secondaryRegion, @NonNull Set<@NonNull ClassDatumAnalysis> toOneReachableClasses) {
		List<@NonNull Node> secondaryHeadNodes = secondaryRegion.getHeadNodes();
		if (secondaryHeadNodes.size() != 1) {
			return false;
		}
		Node classNode = secondaryHeadNodes.get(0);
		ClassDatumAnalysis classDatumAnalysis = classNode.getClassDatumAnalysis();
		return toOneReachableClasses.contains(classDatumAnalysis);
	}

	/**
	 * Return true if any primaryRegion head coincides with a secondaryRegion head.
	 */
	protected boolean isSharedHead(@NonNull Region primaryRegion, @NonNull Region secondaryRegion) {
		for (@NonNull Node primaryHead : primaryRegion.getHeadNodes()) {
			ClassDatumAnalysis primaryClassDatumAnalysis = primaryHead.getClassDatumAnalysis();
			for (@NonNull Node secondaryHead : secondaryRegion.getHeadNodes()) {
				if (primaryClassDatumAnalysis == secondaryHead.getClassDatumAnalysis()) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isToOne(@Nullable TypedElement typedElement) {
		if (typedElement == null) {
			return false;
		}
		if (!typedElement.isIsRequired()) {
			return false;
		}
		Type type = typedElement.getType();
		if (type instanceof CollectionType) {
			return false;
		}
		else {
			return true;
		}
	}

	private boolean isToZeroOrOne(@Nullable TypedElement typedElement) {
		if (typedElement == null) {
			return false;
		}
		Type type = typedElement.getType();
		if (type instanceof CollectionType) {
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * Replace those orderedRegions that may be aggregated as part of a GuardedRegion decision tree by GuardedRegions.
	 * orderedRegions should be naturally ordered to ensure that non-recursive dependencies are inherently satisfied.
	 *
	 * Returns the orderedRegions plus the new aggregates less those aggregated.
	 */
	protected @NonNull List<@NonNull MappingRegion> merge() {
		while (!residualInputRegions.isEmpty()) {		// Subject to nested removal
			@NonNull MappingRegion candidateRegion = residualInputRegions.iterator().next();
			MappingRegion mergedRegion = null;
			if (isPrimaryCandidate(candidateRegion)) {
				Iterable<@NonNull MappingRegion> secondaryRegions = selectSecondaryRegions(candidateRegion);
				if (secondaryRegions != null) {
					mergedRegion = merge(candidateRegion, secondaryRegions);
				}
			}
			if (mergedRegion == null) {
				outputRegions.add(candidateRegion);
			}
			else {
				outputRegions.add(mergedRegion);
				if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
					mergedRegion.writeDebugGraphs("2-merged");
				}
			}
			residualInputRegions.remove(candidateRegion);
		}
		return outputRegions;
	}

	protected @Nullable MappingRegion merge(@NonNull MappingRegion candidateRegion, @NonNull Iterable<@NonNull MappingRegion> secondaryRegions) {
		MappingRegion primaryRegion = candidateRegion;
		MappingRegion mergedRegion = null;
		for (@NonNull MappingRegion secondaryRegion : secondaryRegions) {
			if (residualInputRegions.contains(secondaryRegion)) {
				Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode = canMerge(primaryRegion, secondaryRegion, region2depths, false);
				if (secondaryNode2primaryNode != null) {
					boolean isSharedHead = isSharedHead(primaryRegion, secondaryRegion);
					if (!isSharedHead || (canMerge(secondaryRegion, primaryRegion, region2depths, false) != null)) {
						residualInputRegions.remove(mergedRegion);
						residualInputRegions.remove(secondaryRegion);
						RegionMerger regionMerger = new RegionMerger(primaryRegion);
						regionMerger.addSecondaryRegion(secondaryRegion, secondaryNode2primaryNode);
						regionMerger.prune();
						mergedRegion = regionMerger.create();
						regionMerger.check(mergedRegion);
						region2depths.addRegion(mergedRegion);
						primaryRegion = mergedRegion;
					}
				}
			}
		}
		return mergedRegion;
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
	protected @Nullable Iterable<@NonNull MappingRegion> selectSecondaryRegions(@NonNull MappingRegion primaryRegion) {
		//
		//	Find the classes that could be consumed by a secondary region head, and the number
		//	of possible consuming contexts.
		//
		Map<@NonNull ClassDatumAnalysis, @NonNull Integer> hostClass2count = new HashMap<>();
		for (@NonNull Node hostNode : getHostNodes(primaryRegion)) {
			ClassDatumAnalysis hostClassDatumAnalysis = hostNode.getClassDatumAnalysis();
			Integer count = hostClass2count.get(hostClassDatumAnalysis);
			hostClass2count.put(hostClassDatumAnalysis, count != null ? count+1 : 1);
		}
		//
		//	Find the secondary regions for single possibility host classes.
		//
		Set<@NonNull MappingRegion> secondaryRegions = new HashSet<>();
		for (Map.Entry<@NonNull ClassDatumAnalysis, @NonNull Integer> entry : hostClass2count.entrySet()) {
			if (entry.getValue() == 1) {
				ClassDatumAnalysis primaryClassDatumAnalysis = entry.getKey();
				for (@NonNull MappingRegion secondaryRegion : primaryClassDatumAnalysis.getConsumingRegions()) {
					if (secondaryRegion != primaryRegion) {
						for (@NonNull Node secondaryHeadNode : secondaryRegion.getHeadNodes()) {
							if (secondaryHeadNode.getClassDatumAnalysis() == primaryClassDatumAnalysis) {
								secondaryRegions.add(secondaryRegion);
								break;
							}
						}
					}
				}
			}
		}
		List<@NonNull MappingRegion> sortedSecondaryRegions = new ArrayList<>(secondaryRegions);
		Collections.sort(sortedSecondaryRegions,NameUtil.NAMEABLE_COMPARATOR);
		return sortedSecondaryRegions;
	}
}
