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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MergeableRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MergedMappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.QVTp2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.SimpleMappingRegion;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.QVTs2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Region2Depth;

public class EarlyRegionMerger
{
	protected final @NonNull QVTs2QVTs qvts2qvts;

	public EarlyRegionMerger(@NonNull QVTs2QVTs qvts2qvts) {
		this.qvts2qvts = qvts2qvts;
	}

	/**
	 * Replace those orderedRegions that may be aggregated as part of a GuardedRegion decision tree by GuardedRegions.
	 * orderedRegions should be naturally ordered to ensure that non-recursive dependencies are inherently satisfied.
	 *
	 * Returns the orderedRegions plus the new aggregates less those aggregated.
	 */
	public @NonNull List<@NonNull Region> earlyRegionMerge(@NonNull List<@NonNull SimpleMappingRegion> orderedRegions) {
		Region2Depth region2depths = new Region2Depth();
		List<@NonNull Region> outputRegions = new ArrayList<@NonNull Region>();
		LinkedHashSet<@NonNull SimpleMappingRegion> residualInputRegions = new LinkedHashSet<@NonNull SimpleMappingRegion>(orderedRegions);	// order preserving fast random removal
		while (!residualInputRegions.isEmpty()) {
			@NonNull Region candidateRegion = residualInputRegions.iterator().next();
			boolean isMerged = false;
			if (isEarlyMergePrimaryCandidate(candidateRegion)) {
				List<@NonNull Region> secondaryRegions = selectSecondaryRegions(candidateRegion);
				if (secondaryRegions != null) {
					Region primaryRegion = candidateRegion;
					MergedMappingRegion mergedRegion = null;
					for (@NonNull Region secondaryRegion : secondaryRegions) {
						assert secondaryRegion != null;
						if (residualInputRegions.contains(secondaryRegion)) {
							Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode = primaryRegion.canMerge(secondaryRegion, region2depths, false);
							if (secondaryNode2primaryNode != null) {
								boolean isSharedHead = isSharedHead(primaryRegion, secondaryRegion);
								if (!isSharedHead || (secondaryRegion.canMerge(primaryRegion, region2depths, false) != null)) {
									if (mergedRegion == null) {
										mergedRegion = new MergedMappingRegion((MergeableRegion)primaryRegion);
										residualInputRegions.remove(primaryRegion);
										primaryRegion = mergedRegion;
									}
									mergedRegion.mergeRegion(secondaryRegion, secondaryNode2primaryNode);
									residualInputRegions.remove(secondaryRegion);
									region2depths.addRegion(mergedRegion);
								}
							}
						}
					}
					if (mergedRegion != null) {
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
	 * The primary region in a GuardedRegion must be single-headed. It may be multiply-produced, e.g. recursed.
	 */
	private boolean isEarlyMergePrimaryCandidate(@NonNull Region mappingRegion) {
		List<@NonNull Node> headNodes = mappingRegion.getHeadNodes();
		return headNodes.size() == 1;
	}

	/**
	 * The secondary region in a GuardedRegion must be single-headed and at least one its head nodes must be a class in use within
	 * the primary region. It may be multiply-produced, e.g. recursed.
	 */
	private boolean isEarlyMergeSecondaryCandidate(@NonNull Region primaryRegion,
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
	 * Return true if any primaryRegion head coincides with a secondaryRegion head.
	 */
	private boolean isSharedHead(@NonNull Region primaryRegion, @NonNull Region secondaryRegion) {
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
	 * Return a list of single-headed to-one navigable regions whose head is transitively to-one reachable from the primaryRegion's head.
	 */
	private @Nullable List<@NonNull Region> selectSecondaryRegions(@NonNull Region primaryRegion) {
		//
		//	All regions that consume one of the primary nodes.
		//
		Set<@NonNull Region> allConsumingRegions = new HashSet<@NonNull Region>();
		allConsumingRegions.add(primaryRegion);
		//
		//	All classes reachable from the primary head.
		//
		Set<@NonNull ClassDatumAnalysis> toOneReachableClasses = new HashSet<@NonNull ClassDatumAnalysis>();
		List<@NonNull Region> secondaryRegions = null;
		List<@NonNull Region> allConsumingRegionsList = new ArrayList<@NonNull Region>(allConsumingRegions);	// CME-proof iterable List shadowing a mutating Set
		for (int i = 0; i < allConsumingRegionsList.size(); i++) {
			@NonNull Region secondaryRegion = allConsumingRegionsList.get(i);
			if ((i == 0) || isEarlyMergeSecondaryCandidate(primaryRegion, secondaryRegion, toOneReachableClasses)) {
				if (i > 0) {
					if (secondaryRegions == null) {
						secondaryRegions = new ArrayList<@NonNull Region>();
					}
					secondaryRegions.add(secondaryRegion);
				}
				for (@NonNull Node predicatedNode : secondaryRegion.getMatchableNodes()) {
					if (predicatedNode.isClassNode()) {							// Ignore nulls, attributes
						ClassDatumAnalysis predicatedClassDatumAnalysis = predicatedNode.getClassDatumAnalysis();
						if (toOneReachableClasses.add(predicatedClassDatumAnalysis)) {
							for (@NonNull Region consumingRegion : predicatedClassDatumAnalysis.getConsumingRegions()) {
								if (allConsumingRegions.add(consumingRegion)) {
									allConsumingRegionsList.add(consumingRegion);
								}
							}
						}
					}
				}
				if (secondaryRegion instanceof SimpleMappingRegion) {
					for (@NonNull Node assignedNode : ((SimpleMappingRegion)secondaryRegion).getComputedNodes()) {
						if (assignedNode.isClassNode()) {							// Ignore nulls, attributes
							ClassDatumAnalysis consumingClassDatumAnalysis = assignedNode.getClassDatumAnalysis();
							if (toOneReachableClasses.add(consumingClassDatumAnalysis)) {
								for (@NonNull Region consumingRegion : consumingClassDatumAnalysis.getConsumingRegions()) {
									if (allConsumingRegions.add(consumingRegion)) {
										allConsumingRegionsList.add(consumingRegion);
									}
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
