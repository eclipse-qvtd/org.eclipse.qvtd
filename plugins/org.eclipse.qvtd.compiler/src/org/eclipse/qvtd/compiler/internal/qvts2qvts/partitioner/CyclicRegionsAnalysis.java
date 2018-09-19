/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.TraceClassRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;

import com.google.common.collect.Iterables;

/**
 * The CyclicRegionsAnalysis identifies the RegionAnalysis' and TraceClassAnalysis' that contribute to cycles.
 *
 * This supports the initial optimization to only partition those regions that are cyclic.
 */
public class CyclicRegionsAnalysis
{
	/**
	 * The RegionAnalysis' whose transitive consumption is also transitively produced.
	 */
	private final @NonNull Set<@NonNull RegionAnalysis> cyclicRegionAnalyses = new HashSet<>();

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each trace class analysis.
	 */
	private final @NonNull Set<@NonNull TraceClassRegionAnalysis> cyclicTraceClassAnalyses = new HashSet<>();

	public CyclicRegionsAnalysis(@NonNull Iterable<@NonNull RegionAnalysis> regionAnalyses) {
		analyze(regionAnalyses);
	}

	/**
	 * Return a map of the RegionAnalyses that form a cycle including each RegionAnalysis.
	 *
	 * NB cycles may involve trace classes and their trace class properties.
	 */
	private void analyze(@NonNull Iterable<@NonNull RegionAnalysis> regionAnalyses) {
		Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> partitioner2predecessors = CompilerUtil.computeTransitivePredecessors(regionAnalyses);
		Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> partitioner2successors = CompilerUtil.computeTransitiveSuccessors(partitioner2predecessors);
		for (@NonNull RegionAnalysis regionAnalysis : regionAnalyses) {
			Set<@NonNull RegionAnalysis> intersection = new HashSet<>(partitioner2predecessors.get(regionAnalysis));
			intersection.retainAll(partitioner2successors.get(regionAnalysis));
			cyclicRegionAnalyses.addAll(intersection);
		}
		if (cyclicRegionAnalyses.isEmpty()) {
			return;
		}
		Set<@NonNull TraceClassRegionAnalysis> consumedTraceClassAnalyses = new HashSet<>();
		Set<@NonNull TraceClassRegionAnalysis> superProducedTraceClassAnalyses = new HashSet<>();
		for (@NonNull RegionAnalysis cyclicRegionAnalysis : cyclicRegionAnalyses) {
			Iterable<@NonNull TraceClassRegionAnalysis> consumedTraceClassAnalyses2 = cyclicRegionAnalysis.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses2 != null) {
				Iterables.addAll(consumedTraceClassAnalyses, consumedTraceClassAnalyses2);
			}
			Iterable<@NonNull TraceClassRegionAnalysis> superProducedTraceClassAnalyses2 = cyclicRegionAnalysis.getSuperProducedTraceClassAnalyses();
			if (superProducedTraceClassAnalyses2 != null) {
				Iterables.addAll(superProducedTraceClassAnalyses, superProducedTraceClassAnalyses2);
			}
		}
		cyclicTraceClassAnalyses.addAll(consumedTraceClassAnalyses);
		cyclicTraceClassAnalyses.retainAll(superProducedTraceClassAnalyses);
	}

	public boolean isCyclic(@NonNull RegionAnalysis regionAnalysis) {
		return cyclicRegionAnalyses.contains(regionAnalysis);
	}

	public boolean isCyclic(@NonNull TraceClassRegionAnalysis traceClassAnalysis) {		// FIXME this might be removeable
		assert cyclicTraceClassAnalyses != null;
		return cyclicTraceClassAnalyses.contains(traceClassAnalysis);
	}
}
