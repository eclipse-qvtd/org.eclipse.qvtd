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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.AbstractPartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

/**
 * Each CycleAnalysis identifies one group of regionAnalyses that contribute to a cycle.
 */
public class CyclicPartition extends AbstractPartialRegionAnalysis<@NonNull Partition> implements InternallyAcyclicPartition, Partition
{
	protected final @NonNull String name;
	protected final @NonNull CyclicPartitionsAnalysis cyclesAnalysis;
	private int parallelScheduleDepth = -1;

	/**
	 *	The nested partitions that are encapsulated by this cyclic partition.
	 */
	protected final @NonNull Set<@NonNull Partition> partitions;

	/**
	 *	Map of nested partition to its acyclic predecessors within the cyclic partition.
	 */
	protected final @NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2predecessors = new HashMap<>();

	/**
	 *	Map of nested partition to its acyclic successors within the cyclic partition.
	 */
	protected final @NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2successors = new HashMap<>();

	/**
	 * The predecessors of the cyclic partition outside the cyclic partition.
	 */
	protected final @NonNull Set<@NonNull Partition> externalPredecessors = new HashSet<>();

	/**
	 * The successors of the cyclic partition outside the cyclic partition.
	 */
	protected final @NonNull Set<@NonNull Partition> externalSuccessors = new HashSet<>();
	protected final @NonNull Set<@NonNull TraceClassAnalysis<@NonNull Partition>> traceClassAnalyses;
	protected final @NonNull Set<@NonNull TracePropertyAnalysis<@NonNull Partition>> tracePropertyAnalyses;
	private @Nullable List<@NonNull Iterable<@NonNull Partition>> partitionSchedule = null;
	private @Nullable List<@NonNull Collection<@NonNull MappingRegion>> regionSchedule = null;

	public CyclicPartition(@NonNull TransformationPartitioner transformationPartitioner, @NonNull String name, @NonNull CyclicPartitionsAnalysis cyclesAnalysis, @NonNull Set<@NonNull Partition> partitions,
			@NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2predecessors,
			@NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2successors,
			@NonNull Set<@NonNull TraceClassAnalysis<@NonNull Partition>> traceClassAnalyses,
			@NonNull Set<@NonNull TracePropertyAnalysis<@NonNull Partition>> tracePropertyAnalyses) {
		super(transformationPartitioner, QVTscheduleFactory.eINSTANCE.createCyclicMappingRegion());	// FIXME orphan region
		this.name = name;
		this.cyclesAnalysis = cyclesAnalysis;
		this.partitions = partitions;
		for (@NonNull Partition partition : partitions) {
			Set<@NonNull Partition> internalPredecessors = new HashSet<>(partition2predecessors.get(partition));
			externalPredecessors.addAll(internalPredecessors);
			internalPredecessors.remove(partition);
			internalPredecessors.retainAll(partitions);
			this.partition2predecessors.put(partition, internalPredecessors);
			Set<@NonNull Partition> internalSuccessors = new HashSet<>(partition2successors.get(partition));
			externalSuccessors.addAll(internalSuccessors);
			internalSuccessors.remove(partition);
			internalSuccessors.retainAll(partitions);
			this.partition2successors.put(partition, internalSuccessors);
		}
		externalPredecessors.removeAll(partitions);
		externalSuccessors.removeAll(partitions);
		this.traceClassAnalyses = traceClassAnalyses;
		this.tracePropertyAnalyses = tracePropertyAnalyses;
		assert !partitions.isEmpty();
		// FIXME	assert !traceClassAnalyses.isEmpty() || !tracePropertyAnalyses.isEmpty();
	}

	@Override
	public void analyzePartition() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull MappingRegion createMicroMappingRegion(int partitionNumber) {
		getRegionSchedule();
		// TODO Auto-generated method stub
		//	throw new UnsupportedOperationException();		// FIXME
		return partitions.iterator().next().createMicroMappingRegion(partitionNumber);		// FIXME temporary fudge
	}

	@Override
	public int getDepth() {
		assert parallelScheduleDepth >= 0;
		return parallelScheduleDepth;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	protected @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	protected @NonNull Iterable<@NonNull Node> getPartialNodes() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
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

	@Override
	public @NonNull Iterable<@NonNull Partition> getPartitions() {
		return partitions;
	}

	public @NonNull Set<@NonNull Partition> getPredecessors() {
		return externalPredecessors;
	}

	@Override
	public @NonNull List<@NonNull Collection<@NonNull MappingRegion>> getRegionSchedule() {
		List<@NonNull Collection<@NonNull MappingRegion>> regionSchedule2 = regionSchedule;
		if (regionSchedule2 == null) {
			regionSchedule = regionSchedule2 = new ArrayList<>();
			for (@NonNull Iterable<@NonNull Partition> concurrentPartitions : getPartitionSchedule()) {
				List<@NonNull MappingRegion> concurrentRegions = new ArrayList<>();
				for (@NonNull Partition partition : concurrentPartitions) {
					Region partitionRegion = partition.getRegion();
					int partitionNumber = partitionRegion.getNextPartitionNumber();
					concurrentRegions.add(partition.createMicroMappingRegion(partitionNumber));
				}
				regionSchedule2.add(concurrentRegions);
			}
		}
		return regionSchedule2;
	}

	public @NonNull Set<@NonNull Partition> getSuccessors() {
		return externalSuccessors;
	}

	@Override
	public @NonNull Iterable<@NonNull TraceClassAnalysis<@NonNull Partition>> getTraceClassAnalyses() {
		return traceClassAnalyses;
	}

	@Override
	public @NonNull Iterable<@NonNull TracePropertyAnalysis<@NonNull Partition>> getTracePropertyAnalyses() {
		return tracePropertyAnalyses;
	}

	@Override
	public void setDepth(int parallelScheduleDepth) {
		this.parallelScheduleDepth = parallelScheduleDepth;
	}

	@Override
	public @NonNull String toString() {
		return name;
	}
}
