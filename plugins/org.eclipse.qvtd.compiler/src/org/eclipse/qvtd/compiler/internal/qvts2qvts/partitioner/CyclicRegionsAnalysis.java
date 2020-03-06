/*******************************************************************************
 * Copyright (c) 2016, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;

import com.google.common.collect.Iterables;

/**
 * The CyclicRegionsAnalysis identifies the RegionAnalysis' and ClassAnalysis' that contribute to cycles.
 *
 * This supports the initial optimization to only partition those regions that are cyclic.
 */
public class CyclicRegionsAnalysis extends AbstractCyclicPartialRegionsAnalysis<@NonNull RegionsAnalysis>
{
	/**
	 * Each set of RegionAnalysis whose transitive consumption are also transitively produced.
	 */
	@SuppressWarnings("unused")
	private @Nullable Set<@NonNull CyclicRegionAnalysis> cyclicRegionsAnalyses = null;

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each trace class analysis.
	 */
	private @Nullable Set<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> cyclicClassAnalyses = null;

	/**
	 * Mapping from each region analysis to the smallest cyvle in which the region participates. No entry for non-cyclic regions.
	 */
	private @Nullable Map<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>, @NonNull CyclicRegionAnalysis> cyclicRegionAnalysis2smallestCyclicRegionsAnalysis = null;

	public CyclicRegionsAnalysis(@NonNull Iterable<@NonNull RegionAnalysis> regionAnalyses) {
		analyze(regionAnalyses);
	}

	/**
	 * Return a map of the RegionAnalyses that form a cycle including each RegionAnalysis.
	 *
	 * NB cycles may involve trace classes and their trace class properties.
	 */
	private void analyze(@NonNull Iterable<@NonNull RegionAnalysis> regionAnalyses) {
		//
		//	Determine the cycles as transitive predecessor/successor intersections
		//
		Map<@NonNull Set<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>>, @NonNull CyclicRegionAnalysis> cyclicRegionAnalyses2cyclicRegionAnalysis = null;
		Map<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>>> partitioner2predecessors = CompilerUtil.computeTransitivePredecessors(regionAnalyses, TransformationPartitioner.REGION_IMMEDIATE_PREDECESSORS, TransformationPartitioner.REGION_TRANSITIVE_PREDECESSORS);
		Map<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>>> partitioner2successors = CompilerUtil.computeTransitiveSuccessors(partitioner2predecessors, TransformationPartitioner.REGION_TRANSITIVE_SUCCESSORS);
		for (@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis> regionAnalysis : regionAnalyses) {
			Set<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>> intersection = new HashSet<>(partitioner2predecessors.get(regionAnalysis));
			intersection.retainAll(partitioner2successors.get(regionAnalysis));
			if (!intersection.isEmpty()) {
				if (cyclicRegionAnalyses2cyclicRegionAnalysis == null) {
					cyclicRegionAnalyses2cyclicRegionAnalysis = new HashMap<>();
				}
				if (!cyclicRegionAnalyses2cyclicRegionAnalysis.containsKey(intersection)) {
					cyclicRegionAnalyses2cyclicRegionAnalysis.put(intersection, new CyclicRegionAnalysis(intersection));
				}
			}
		}
		if (cyclicRegionAnalyses2cyclicRegionAnalysis == null) {
			return;
		}
		//
		//	Determine the region to cycle membership
		//
		List<@NonNull CyclicRegionAnalysis> cyclicRegionsAnalyses2 = new ArrayList<>(cyclicRegionAnalyses2cyclicRegionAnalysis.values());
		if (cyclicRegionsAnalyses2.size() > 1) {
			Collections.sort(cyclicRegionsAnalyses2);
		}
		Map<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>, @NonNull CyclicRegionAnalysis> cyclicRegionAnalysis2smallestCyclicRegionsAnalysis2 = cyclicRegionAnalysis2smallestCyclicRegionsAnalysis = new HashMap<>();
		for (@NonNull CyclicRegionAnalysis cyclicRegionsAnalysis : cyclicRegionsAnalyses2) {
			for (@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis> cyclicRegionAnalysis : cyclicRegionsAnalysis.regionAnalyses) {
				if (!cyclicRegionAnalysis2smallestCyclicRegionsAnalysis2.containsKey(cyclicRegionAnalysis)) {
					cyclicRegionAnalysis2smallestCyclicRegionsAnalysis2.put(cyclicRegionAnalysis, cyclicRegionsAnalysis);
				}
			}
		}
		//
		//	Create the isCyclic class cache
		//
		Set<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> cyclicClassAnalyses2 = cyclicClassAnalyses = new HashSet<>();
		Set<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> consumedClassAnalyses = new HashSet<>();
		Set<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> superProducedClassAnalyses = new HashSet<>();
		for (@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis> cyclicRegionAnalysis : cyclicRegionAnalysis2smallestCyclicRegionsAnalysis2.keySet()) {
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> consumedClassAnalyses2 = cyclicRegionAnalysis.getConsumedClassAnalyses();
			if (consumedClassAnalyses2 != null) {
				Iterables.addAll(consumedClassAnalyses, consumedClassAnalyses2);
			}
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> superProducedClassAnalyses2 = cyclicRegionAnalysis.getSuperProducedClassAnalyses();
			if (superProducedClassAnalyses2 != null) {
				Iterables.addAll(superProducedClassAnalyses, superProducedClassAnalyses2);
			}
		}
		cyclicClassAnalyses2.addAll(consumedClassAnalyses);
		cyclicClassAnalyses2.retainAll(superProducedClassAnalyses);
		//
		//	Debug traces
		//
		if (TransformationPartitioner.REGION_CYCLES.isActive()) {
			for (@NonNull CyclicRegionAnalysis cyclicRegionsAnalysis : cyclicRegionsAnalyses2) {
				//	showCycles(TransformationPartitioner.REGION_CYCLES, cyclicRegionsAnalysis.regionAnalyses);
				cyclicRegionsAnalysis.showCycle(TransformationPartitioner.REGION_CYCLES);
			}
		}
	}

	public @Nullable CyclicRegionAnalysis basicGetCyclicRegionAnalysis(@NonNull RegionAnalysis regionAnalysis) {
		return cyclicRegionAnalysis2smallestCyclicRegionsAnalysis != null ? cyclicRegionAnalysis2smallestCyclicRegionsAnalysis.get(regionAnalysis) : null;
	}

	public boolean isCyclic(@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> classAnalysis) {		// FIXME this might be removeable
		return cyclicClassAnalyses != null ? cyclicClassAnalyses.contains(classAnalysis) : false;
	}
}
