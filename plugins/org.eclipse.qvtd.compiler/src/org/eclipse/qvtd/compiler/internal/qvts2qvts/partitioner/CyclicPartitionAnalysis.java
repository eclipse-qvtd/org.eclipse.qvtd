/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import com.google.common.collect.Iterables;

public class CyclicPartitionAnalysis extends AbstractCompositePartitionAnalysis<CyclicPartition> implements CompositePartitionAnalysis
{
	public static @NonNull CyclicPartitionAnalysis createCyclicPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis,
			@NonNull String name, @NonNull Set<@NonNull PartitionAnalysis> partitionAnalyses,
			@NonNull Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> partitionAnalysis2predecessors) {

		Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> nestedPartitionAnalysis2predecessors = new HashMap<>();
		Set<@NonNull PartitionAnalysis> externalPredecessors = new HashSet<>();
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalyses) {
			Set<@NonNull PartitionAnalysis> internalPredecessors = new HashSet<>(partitionAnalysis2predecessors.get(partitionAnalysis));
			externalPredecessors.addAll(internalPredecessors);
			internalPredecessors.remove(partitionAnalysis);
			internalPredecessors.retainAll(partitionAnalyses);
			nestedPartitionAnalysis2predecessors.put(partitionAnalysis, internalPredecessors);
		}
		externalPredecessors.removeAll(partitionAnalyses);
		assert !partitionAnalyses.isEmpty();


		ScheduleManager scheduleManager = partitionedTransformationAnalysis.getScheduleManager();
		CyclicPartition cyclicPartition = RegionHelper.createCyclicPartition(name, scheduleManager);
		return new CyclicPartitionAnalysis(partitionedTransformationAnalysis, cyclicPartition, nestedPartitionAnalysis2predecessors, externalPredecessors);
	}

	/**
	 * The predecessors of the cyclic partition outside the cyclic partition.
	 */
	protected final @NonNull Set<@NonNull PartitionAnalysis> externalPredecessors;

	private CyclicPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull CyclicPartition cyclicPartition,
			@NonNull Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> partitionAnalysis2predecessors,
			@NonNull Set<@NonNull PartitionAnalysis> externalPredecessors) {
		super(partitionedTransformationAnalysis, cyclicPartition, partitionAnalysis2predecessors);
		this.externalPredecessors = externalPredecessors;
		partitionedTransformationAnalysis.addPartitionAnalysis(this);
	}

	public @NonNull Iterable<@NonNull MappingRegion> createMicroMappingRegions() {
		Set<@NonNull PartitionAnalysis> partitionAnalyses = partitionAnalysis2predecessors.keySet();
		List<@NonNull MappingRegion> microMappingRegions = new ArrayList<>();
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalyses) {		// FIXME smarter cyclic schedule
			if (partitionAnalysis instanceof CyclicPartitionAnalysis) {
				Iterables.addAll(microMappingRegions, ((CyclicPartitionAnalysis)partitionAnalysis).createMicroMappingRegions());
			}
			else {
				microMappingRegions.add(partitionAnalysis.getMicroMappingRegion());
			}
		}
		return microMappingRegions;
	}

	@Override
	protected @NonNull List<@NonNull Iterable<@NonNull PartitionAnalysis>> createPartitionSchedule() {
		//
		//	The simplest cyclic schedule is dumb polled. For small cycles the effort of
		//	using the immediate external predecesors as region heads for an internal acyclic
		//	schedule and integrating externally is probably not worth it.
		//
		// FIXME For ATL2QVTr the cycle is 29 partitions (and counting) with many three-level cascades. Worth improving.
		//
		// Analyzing predecessor partitions is unhelpful since they are cyclic.
		// Analyzing the producers of each source datum is more fruitful.
		// The partitions of the producers of each source datum are either ACYCLIC, CYCLIC or MIXED.
		//	ACYCLIC => all partitions are external to the cyclic partition being scheduled
		//	CYCLIC => all partitions are internal to the cyclic partition being scheduled
		//	MIXED => some partitions are external and some are internal to the cyclic partition being scheduled
		//
		// A partition with 0 MIXED, 0 CYCLIC, 0 ACYCLIC producers does not occur - it is dead.
		// A partition with 0 MIXED, 0 CYCLIC, 1+ ACYCLIC producers does not occur - it is acyclic.
		// A partition with 0 MIXED, 1+ CYCLIC and 0+ ACYCLIC is a recursing step
		// A partition with 1+ MIXED, 0 CYCLIC and 0+ ACYCLIC producers is a a base case.
		// A partition with 1+ MIXED, 1+ CYCLIC and 0+ ACYCLIC producers is a recursive case
		//
		// The cyclic schedule is therefore {base-cases}, {recursing-steps}... {recursive-cases}
		//
		Iterable<@NonNull PartitionAnalysis> keys = partitionAnalysis2predecessors.keySet();
		List<@NonNull Iterable<@NonNull PartitionAnalysis>> partitionSchedule = Collections.singletonList(keys); //CompilerUtil.computeParallelSchedule(partition2predecessors);
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalysis2predecessors.keySet()) {
			if (partitionAnalysis instanceof CompositePartitionAnalysis) {
				((CompositePartitionAnalysis)partitionAnalysis).getPartitionSchedule();
			}
		}
		return partitionSchedule;
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getConsumedTraceClassAnalyses() {
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getConsumedTracePropertyAnalyses() {
		return null;
	}

	@Override
	public @NonNull Set<@NonNull PartitionAnalysis> getExplicitPredecessors() {
		return externalPredecessors;
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getProducedTraceClassAnalyses() {
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getProducedTracePropertyAnalyses() {
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getSuperProducedTraceClassAnalyses() {
		return null;
	}
}