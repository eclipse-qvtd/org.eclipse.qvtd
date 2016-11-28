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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigableEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.QVTp2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis;

import com.google.common.collect.Sets;

/**
 * EarlyMerger replaces one list of MappingRegions by another in which each set of regions that can be merged
 * without knowledge of the schedule is replaced by an equivalent merged region.
 */
public class EarlyMerger extends AbstractMerger
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

	protected EarlyMerger(@NonNull Iterable<@NonNull MappingRegion> inputRegions) {
		this.residualInputRegions = Sets.newLinkedHashSet(inputRegions);
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
				Correlator secondary2primary = Correlator.correlate(secondaryRegion, primaryRegion);
				if (secondary2primary != null) {
					boolean doMerge = false;
					if (!isSharedHead(primaryRegion, secondaryRegion)) {
						doMerge = true;
					}
					else if (Correlator.correlate(primaryRegion, secondaryRegion) != null) {
						doMerge = true;
					}
					if (doMerge) {
						residualInputRegions.remove(mergedRegion);
						residualInputRegions.remove(secondaryRegion);
						RegionMerger regionMerger = new RegionMerger(primaryRegion);
						regionMerger.addSecondaryRegion(secondaryRegion, secondary2primary.getNode2Node());
						regionMerger.prune();
						mergedRegion = regionMerger.create();
						regionMerger.check(mergedRegion);
						primaryRegion = mergedRegion;
					}
				}
			}
		}
		return mergedRegion;
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
