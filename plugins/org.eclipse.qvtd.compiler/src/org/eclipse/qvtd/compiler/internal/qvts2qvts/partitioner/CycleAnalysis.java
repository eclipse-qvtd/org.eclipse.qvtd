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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

import com.google.common.collect.Iterables;

/**
 * Each CycleAnalysis identifies one group of mappingPartitioners that contribute to a cycle.
 */
public class CycleAnalysis
{
	protected final @NonNull CyclesAnalysis cyclesAnalysis;
	protected final @NonNull Set<@NonNull MappingPartitioner> mappingPartitioners;
	protected final @NonNull Set<@NonNull TraceClassAnalysis> traceClassAnalyses;
	protected final @NonNull Set<@NonNull TracePropertyAnalysis> tracePropertyAnalyses;
	private @Nullable Boolean isInfallible = null;

	public CycleAnalysis(@NonNull CyclesAnalysis cyclesAnalysis, @NonNull Set<@NonNull MappingPartitioner> mappingPartitioners,
			@NonNull Set<@NonNull TraceClassAnalysis> traceClassAnalyses, @NonNull Set<@NonNull TracePropertyAnalysis> tracePropertyAnalyses) {
		this.cyclesAnalysis = cyclesAnalysis;
		this.mappingPartitioners = mappingPartitioners;
		this.traceClassAnalyses = traceClassAnalyses;
		this.tracePropertyAnalyses = tracePropertyAnalyses;
		assert !mappingPartitioners.isEmpty();
		assert !traceClassAnalyses.isEmpty();
	}

	public @NonNull Iterable<@NonNull MappingPartitioner> getMappingPartitioners() {
		return mappingPartitioners;
	}

	public @NonNull Iterable<@NonNull TraceClassAnalysis> getTraceClassAnalyses() {
		return traceClassAnalyses;
	}

	public @NonNull Iterable<@NonNull TracePropertyAnalysis> getTracePropertyAnalyses() {
		return tracePropertyAnalyses;
	}

	/**
	 * Return true if all sources of fallibility are within the cycle.
	 */
	public boolean isInfallible() {
		Boolean isInfallible2 = isInfallible;
		if (isInfallible2 == null) {
			Set<@NonNull RegionAnalysis> cycleFallibilities = new HashSet<>();
			for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
				RegionAnalysis regionAnalysis = mappingPartitioner.getRegionAnalysis();
				Iterables.addAll(cycleFallibilities, regionAnalysis.getFallibilities());
			}
			Set<@NonNull RegionAnalysis> externalFallibilities = new HashSet<>(cycleFallibilities);
			for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
				RegionAnalysis regionAnalysis = mappingPartitioner.getRegionAnalysis();
				externalFallibilities.remove(regionAnalysis);
			}
			isInfallible = isInfallible2 = externalFallibilities.isEmpty();
		}
		return isInfallible2;
	}

	public @NonNull Iterable<@NonNull MappingRegion> partition(@NonNull Iterable<@NonNull MappingPartitioner> orderedMappingPartitioners) {
		List<@NonNull MappingRegion> partitionedRegions = new ArrayList<>();
		for (@NonNull MappingPartitioner mappingPartitioner : orderedMappingPartitioners) {
			if (mappingPartitioners.contains(mappingPartitioner)) {
				MappingRegion oldRegion = mappingPartitioner.getRegion();
				ScheduledRegion scheduledRegion = oldRegion.getScheduledRegion();
				Iterable<@NonNull MappingRegion> newRegions = mappingPartitioner.partition();
				oldRegion.setScheduledRegion(null);
				for (@NonNull MappingRegion newRegion : newRegions) {
					newRegion.setScheduledRegion(scheduledRegion);
				}
				Iterables.addAll(partitionedRegions, newRegions);
			}
		}
		return partitionedRegions;
	}
}
