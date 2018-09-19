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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.AbstractPartition;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

import com.google.common.collect.Iterables;

/**
 * Each CycleAnalysis identifies one group of regionAnalyses that contribute to a cycle.
 */
public class CyclicPartition extends AbstractPartition implements InternallyAcyclicPartition, Partition
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
	 * The predecessors of the cyclic partition outside the cyclic partition.
	 */
	protected final @NonNull Set<@NonNull Partition> externalPredecessors = new HashSet<>();

	protected final @NonNull Set<@NonNull TraceClassPartitionAnalysis> traceClassAnalyses;
	protected final @NonNull Set<@NonNull TracePropertyPartitionAnalysis> tracePropertyAnalyses;
	private @Nullable List<@NonNull Iterable<@NonNull Partition>> partitionSchedule = null;
	//	private @Nullable List<@NonNull Collection<@NonNull Region>> regionSchedule = null;

	public CyclicPartition(@NonNull TransformationPartitioner transformationPartitioner, @NonNull String name, @NonNull CyclicPartitionsAnalysis cyclesAnalysis, @NonNull Set<@NonNull Partition> partitions,
			@NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2predecessors,
			@NonNull Set<@NonNull TraceClassPartitionAnalysis> traceClassAnalyses,
			@NonNull Set<@NonNull TracePropertyPartitionAnalysis> tracePropertyAnalyses) {
		super(transformationPartitioner.getPartitionedTransformationAnalysis());
		this.name = name;
		this.cyclesAnalysis = cyclesAnalysis;
		this.partitions = partitions;
		for (@NonNull Partition partition : partitions) {
			Set<@NonNull Partition> internalPredecessors = new HashSet<>(partition2predecessors.get(partition));
			externalPredecessors.addAll(internalPredecessors);
			internalPredecessors.remove(partition);
			internalPredecessors.retainAll(partitions);
			this.partition2predecessors.put(partition, internalPredecessors);
		}
		externalPredecessors.removeAll(partitions);
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
	public @NonNull MappingRegion createMicroMappingRegion() {
		throw new UnsupportedOperationException();		// FIXME
	}

	public @NonNull Iterable<@NonNull MappingRegion> createMicroMappingRegions() {
		//	getRegionSchedule();
		List<@NonNull MappingRegion> microMappingRegions = new ArrayList<>();
		for (@NonNull Partition partition : partitions) {		// FIXME smarter cyclic schedule
			if (partition instanceof CyclicPartition) {
				Iterables.addAll(microMappingRegions, ((CyclicPartition)partition).createMicroMappingRegions());
			}
			else {
				microMappingRegions.add(partition.getMicroMappingRegion());
			}
		}
		return microMappingRegions;
	}

	/*	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getConsumedTraceClassPartitionAnalyses() {
		return (Iterable<@NonNull TraceClassPartitionAnalysis>)getConsumedTraceClassAnalyses();
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getConsumedTracePropertyPartitionAnalyses() {
		return (Iterable<@NonNull TracePropertyPartitionAnalysis>)getConsumedTracePropertyAnalyses();
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getProducedTraceClassPartitionAnalyses() {
		return (Iterable<@NonNull TraceClassPartitionAnalysis>)getProducedTraceClassAnalyses();
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getProducedTracePropertyPartitionAnalyses() {
		return (Iterable<@NonNull TracePropertyPartitionAnalysis>)getProducedTracePropertyAnalyses();
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getSuperProducedTraceClassPartitionAnalyses() {
		return (Iterable<@NonNull TraceClassPartitionAnalysis>)getSuperProducedTraceClassAnalyses();
	} */

	@Override
	public int getDepth() {
		assert parallelScheduleDepth >= 0;
		return parallelScheduleDepth;
	}

	@Override
	public @NonNull Set<@NonNull Partition> getExplicitPredecessors() {
		return externalPredecessors;
	}

	@Override
	public @NonNull MappingRegion getMicroMappingRegion() {
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @NonNull Region getOriginalRegion() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getPartialNodes() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull List<@NonNull Iterable<@NonNull Partition>> getPartitionSchedule() {
		List<@NonNull Iterable<@NonNull Partition>> partitionSchedule2 = partitionSchedule;
		if (partitionSchedule2 == null) {
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
			Iterable<@NonNull Partition> keys = partition2predecessors.keySet();
			partitionSchedule = partitionSchedule2 = Collections.singletonList(keys); //CompilerUtil.computeParallelSchedule(partition2predecessors);
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

	@Override
	public @NonNull String getSymbolName() {
		return name;
	}

	@Override
	public @NonNull Iterable<@NonNull TraceClassPartitionAnalysis> getTraceClassAnalyses() {
		return traceClassAnalyses;
	}

	@Override
	public @NonNull Iterable<@NonNull TracePropertyPartitionAnalysis> getTracePropertyAnalyses() {
		return tracePropertyAnalyses;
	}

	@Override
	public void setDepth(int parallelScheduleDepth) {
		this.parallelScheduleDepth = parallelScheduleDepth;
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull String toString() {
		return name;
	}
}
