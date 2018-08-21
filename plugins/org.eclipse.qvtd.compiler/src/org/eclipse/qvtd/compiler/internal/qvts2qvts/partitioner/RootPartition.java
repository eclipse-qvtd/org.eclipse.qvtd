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
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

import com.google.common.collect.Lists;

public class RootPartition /*extends AbstractPartialRegionAnalysis<@NonNull Partition>*/ implements InternallyAcyclicPartition
{
	protected final @NonNull Iterable<@NonNull Partition> partitions;
	protected final @NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2predecessors;
	protected final @NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2successors;
	//	protected final @NonNull List<@NonNull MappingRegion> partitionedRegions;
	protected final @NonNull Set<@NonNull TraceClassAnalysis<@NonNull Partition>> cyclicTraceClassAnalyses;
	protected final @NonNull Set<@NonNull TracePropertyAnalysis<@NonNull Partition>> cyclicTracePropertyAnalyses;
	private @Nullable ScheduledRegion scheduledRegion = null;
	private @Nullable List<@NonNull Iterable<@NonNull Partition>> partitionSchedule = null;
	private @Nullable List<@NonNull Collection<@NonNull Region>> regionSchedule = null;

	public RootPartition(@NonNull Iterable<@NonNull Partition> partitions,
			@NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2predecessors,
			@NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2successors,
			@NonNull Set<@NonNull TraceClassAnalysis<@NonNull Partition>> cyclicTraceClassAnalyses,
			@NonNull Set<@NonNull TracePropertyAnalysis<@NonNull Partition>> cyclicTracePropertyAnalyses) {
		this.partitions = partitions;
		this.partition2predecessors = partition2predecessors;
		this.partition2successors = partition2successors;
		CompilerUtil.checkPredecessorsAndSuccessors(partitions, partition2predecessors, partition2successors);
		//	this.partitionedRegions = new ArrayList<>(Iterables.size(partitions));
		this.cyclicTraceClassAnalyses = cyclicTraceClassAnalyses;
		this.cyclicTracePropertyAnalyses = cyclicTracePropertyAnalyses;
		//	int partitionNumber = 0;
		//	Region currentRegion = null;
		//	for (@NonNull Partition partition : partitions) {
		//		Region partitionRegion = partition.getRegion();
		//		if (currentRegion != partitionRegion) {
		//			currentRegion = partitionRegion;
		//			partitionNumber = 0;
		//		}
		//		partitionedRegions.add(partition.createMicroMappingRegion(partitionNumber++));
		//	}
	}

	@Override
	public @NonNull List<@NonNull Iterable<@NonNull Partition>> getPartitionSchedule() {
		List<@NonNull Iterable<@NonNull Partition>> partitionSchedule2 = partitionSchedule;
		if (partitionSchedule2 == null) {
			partitionSchedule = partitionSchedule2 = CompilerUtil.computeParallelSchedule(partition2predecessors, partition2successors);
			for (@NonNull Partition partition : partitions) {
				if (partition instanceof InternallyAcyclicPartition) {
					((InternallyAcyclicPartition)partition).getPartitionSchedule();
				}
			}
		}
		return partitionSchedule2;
	}

	//	public @NonNull Iterable<@NonNull MappingRegion> getPartitionedRegions() {
	//		return partitionedRegions;
	//	}

	@Override
	public @NonNull Iterable<@NonNull Partition> getPartitions() {
		return partitions;
	}

	@Override
	public @NonNull List<@NonNull Collection<@NonNull Region>> getRegionSchedule() {
		List<@NonNull Collection<@NonNull Region>> regionSchedule2 = regionSchedule;
		if (regionSchedule2 == null) {
			regionSchedule = regionSchedule2 = new ArrayList<>();
			assert scheduledRegion != null;
			LoadingRegion loadingRegion = scheduledRegion.getOwnedLoadingRegion();
			if (loadingRegion != null) {
				regionSchedule2.add(Lists.newArrayList(loadingRegion));
			}
			for (@NonNull Iterable<@NonNull Partition> concurrentPartitions : getPartitionSchedule()) {
				List<@NonNull Region> concurrentRegions = new ArrayList<>();
				for (@NonNull Partition partition : concurrentPartitions) {
					Region partitionRegion = partition.getRegion();
					int partitionNumber = partitionRegion.getNextPartitionNumber();
					MappingRegion mappingRegion = partition.createMicroMappingRegion(partitionNumber);
					getScheduledRegion().getMappingRegions().add(mappingRegion);
					concurrentRegions.add(mappingRegion);
				}
				regionSchedule2.add(concurrentRegions);
			}
		}
		return regionSchedule2;
	}

	public @NonNull ScheduledRegion getScheduledRegion() {
		return ClassUtil.nonNullState(scheduledRegion);
	}

	@Override
	public @NonNull Iterable<@NonNull TraceClassAnalysis<@NonNull Partition>> getTraceClassAnalyses() {
		return cyclicTraceClassAnalyses;
	}

	@Override
	public @NonNull Iterable<@NonNull TracePropertyAnalysis<@NonNull Partition>> getTracePropertyAnalyses() {
		return cyclicTracePropertyAnalyses;
	}

	public void setScheduledRegion(@NonNull ScheduledRegion scheduledRegion) {
		this.scheduledRegion = scheduledRegion;
	}
}