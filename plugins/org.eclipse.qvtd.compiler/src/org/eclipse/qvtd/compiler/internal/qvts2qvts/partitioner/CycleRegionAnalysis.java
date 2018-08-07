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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

import com.google.common.collect.Iterables;

/**
 * Each CycleAnalysis identifies one group of regionAnalyses that contribute to a cycle.
 */
public class CycleRegionAnalysis implements CycleAnalysis<@NonNull RegionAnalysis>
{
	protected final @NonNull CyclesAnalysis<@NonNull RegionAnalysis> cyclesAnalysis;
	protected final @NonNull Set<@NonNull RegionAnalysis> regionAnalyses;
	protected final @NonNull Set<@NonNull TraceClassAnalysis<@NonNull RegionAnalysis>> traceClassAnalyses;
	protected final @NonNull Set<@NonNull TracePropertyAnalysis<@NonNull RegionAnalysis>> tracePropertyAnalyses;
	//	private @Nullable Boolean isInfallible = null;

	public CycleRegionAnalysis(@NonNull CyclesAnalysis<@NonNull RegionAnalysis> cyclesAnalysis, @NonNull Set<@NonNull RegionAnalysis> regionAnalyses,
			@NonNull Set<@NonNull TraceClassAnalysis<@NonNull RegionAnalysis>> traceClassAnalyses, @NonNull Set<@NonNull TracePropertyAnalysis<@NonNull RegionAnalysis>> tracePropertyAnalyses) {
		this.cyclesAnalysis = cyclesAnalysis;
		this.regionAnalyses = regionAnalyses;
		this.traceClassAnalyses = traceClassAnalyses;
		this.tracePropertyAnalyses = tracePropertyAnalyses;
		assert !regionAnalyses.isEmpty();
		assert !traceClassAnalyses.isEmpty() || !tracePropertyAnalyses.isEmpty();
	}

	@Override
	public @NonNull Iterable<@NonNull RegionAnalysis> getRegionAnalyses() {
		return regionAnalyses;
	}

	@Override
	public @NonNull Iterable<@NonNull TraceClassAnalysis<@NonNull RegionAnalysis>> getTraceClassAnalyses() {
		return traceClassAnalyses;
	}

	@Override
	public @NonNull Iterable<@NonNull TracePropertyAnalysis<@NonNull RegionAnalysis>> getTracePropertyAnalyses() {
		return tracePropertyAnalyses;
	}

	/**
	 * Return true if all sources of fallibility are within the cycle.
	 *
	public boolean isInfallible() {
		Boolean isInfallible2 = isInfallible;
		if (isInfallible2 == null) {
			Set<@NonNull RegionAnalysis> cycleFallibilities = new HashSet<>();
			for (@NonNull RegionAnalysis regionAnalysis : regionAnalyses) {
				Iterables.addAll(cycleFallibilities, regionAnalysis.getFallibilities());
			}
			Set<@NonNull RegionAnalysis> externalFallibilities = new HashSet<>(cycleFallibilities);
			for (@NonNull RegionAnalysis regionAnalysis : regionAnalyses) {
				externalFallibilities.remove(regionAnalysis);
			}
			isInfallible = isInfallible2 = externalFallibilities.isEmpty();
		}
		return isInfallible2;
	} */

	public @NonNull Iterable<@NonNull Partition> partition(@NonNull Iterable<@NonNull MappingPartitioner> orderedMappingPartitioners) {
		List<@NonNull Partition> partitions = new ArrayList<>();
		for (@NonNull MappingPartitioner mappingPartitioner : orderedMappingPartitioners) {
			RegionAnalysis regionAnalysis = mappingPartitioner.getRegionAnalysis();
			if (regionAnalyses.contains(regionAnalysis)) {
				MappingRegion oldRegion = mappingPartitioner.getRegion();
				ScheduledRegion scheduledRegion = oldRegion.getScheduledRegion();
				Iterable<@NonNull Partition> newPartitions = mappingPartitioner.partition();
				//	oldRegion.setScheduledRegion(null);
				//	for (@NonNull MappingRegion newRegion : newRegions) {
				//		newRegion.setScheduledRegion(scheduledRegion);
				//	}
				Iterables.addAll(partitions, newPartitions);
			}
		}
		return partitions;
	}
}
