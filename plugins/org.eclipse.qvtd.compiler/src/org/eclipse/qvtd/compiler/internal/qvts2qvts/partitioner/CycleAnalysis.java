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
public abstract class CycleAnalysis<RA extends RegionAnalysis>
{
	protected final @NonNull CyclesAnalysis<@NonNull RA> cyclesAnalysis;
	protected final @NonNull Set<@NonNull RA> regionAnalyses;
	protected final @NonNull Set<@NonNull TraceClassAnalysis<@NonNull RA>> traceClassAnalyses;
	protected final @NonNull Set<@NonNull TracePropertyAnalysis<@NonNull RA>> tracePropertyAnalyses;

	protected CycleAnalysis(@NonNull CyclesAnalysis<@NonNull RA> cyclesAnalysis, @NonNull Set<@NonNull RA> regionAnalyses,
			@NonNull Set<@NonNull TraceClassAnalysis<@NonNull RA>> traceClassAnalyses, @NonNull Set<@NonNull TracePropertyAnalysis<@NonNull RA>> tracePropertyAnalyses) {
		this.cyclesAnalysis = cyclesAnalysis;
		this.regionAnalyses = regionAnalyses;
		this.traceClassAnalyses = traceClassAnalyses;
		this.tracePropertyAnalyses = tracePropertyAnalyses;
		assert !regionAnalyses.isEmpty();
		assert !traceClassAnalyses.isEmpty() || !tracePropertyAnalyses.isEmpty();
	}

	public @NonNull Iterable<@NonNull RA> getRegionAnalyses() {
		return regionAnalyses;
	}

	public @NonNull Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> getTraceClassAnalyses() {
		return traceClassAnalyses;
	}

	public @NonNull Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> getTracePropertyAnalyses() {
		return tracePropertyAnalyses;
	}

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
