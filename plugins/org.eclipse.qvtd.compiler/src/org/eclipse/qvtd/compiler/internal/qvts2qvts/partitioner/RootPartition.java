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
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToGraphHelper;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public class RootPartition extends AbstractPartition implements InternallyAcyclicPartition
{
	protected final @NonNull AbstractTransformationAnalysis transformationAnalysis;
	protected final @NonNull LoadingRegion loadingRegion;
	protected final @NonNull Iterable<@NonNull Partition> partitions;
	protected final @NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2predecessors;
	//	protected final @NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2successors;
	//	protected final @NonNull List<@NonNull MappingRegion> partitionedRegions;
	protected final @NonNull Set<@NonNull TraceClassPartitionAnalysis> cyclicTraceClassAnalyses;
	protected final @NonNull Set<@NonNull TracePropertyPartitionAnalysis> cyclicTracePropertyAnalyses;
	private @Nullable ScheduledRegion scheduledRegion = null;
	private @Nullable List<@NonNull Iterable<@NonNull Partition>> partitionSchedule = null;
	//	private @Nullable List<@NonNull Collection<@NonNull Region>> regionSchedule = null;

	public RootPartition(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull String name, @NonNull Map<@NonNull Partition, @NonNull Set<@NonNull Partition>> partition2predecessors,
			@NonNull Set<@NonNull TraceClassPartitionAnalysis> cyclicTraceClassAnalyses,
			@NonNull Set<@NonNull TracePropertyPartitionAnalysis> cyclicTracePropertyAnalyses) {
		super(name);
		this.transformationAnalysis = transformationAnalysis;
		this.loadingRegion = QVTscheduleUtil.getOwnedLoadingRegion(transformationAnalysis.getScheduledRegion());
		this.partitions = partition2predecessors.keySet();
		this.partition2predecessors = partition2predecessors;
		//		this.partition2successors = partition2successors;
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
	public void analyzePartition() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void appendNode(@NonNull ToGraphHelper toGraphHelper, @NonNull String nodeName) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getConsumedTraceClassAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getConsumedTracePropertyAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		return QVTscheduleUtil.getOwnedEdges(loadingRegion);
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getPartialNodes() {
		return QVTscheduleUtil.getOwnedNodes(loadingRegion);
	}

	@Override
	public @NonNull List<@NonNull Iterable<@NonNull Partition>> getPartitionSchedule() {
		List<@NonNull Iterable<@NonNull Partition>> flatPartitionSchedule = partitionSchedule;
		if (flatPartitionSchedule == null) {
			List<@NonNull Iterable<@NonNull Partition>> parallelSchedule = CompilerUtil.computeParallelSchedule(partition2predecessors);
			partitionSchedule = flatPartitionSchedule = new ArrayList<>();
			for (@NonNull Iterable<@NonNull Partition> concurrency : parallelSchedule) {
				List<@NonNull Partition> flatConcurrency = new ArrayList<>();
				for (@NonNull Partition partition : concurrency) {
					if (partition instanceof InternallyAcyclicPartition) {
						List<@NonNull Iterable<@NonNull Partition>> partitionSchedule2 = ((InternallyAcyclicPartition)partition).getPartitionSchedule();
						for (@NonNull Iterable<@NonNull Partition> concurrency2 : partitionSchedule2) {	// FIXME Avoid flattening
							for (@NonNull Partition partition2 : concurrency2) {
								flatConcurrency.add(partition2);
							}
						}
					}
					else {
						flatConcurrency.add(partition);
					}
				}
				flatPartitionSchedule.add(flatConcurrency);
			}
		}
		return flatPartitionSchedule;
	}

	//	public @NonNull Iterable<@NonNull MappingRegion> getPartitionedRegions() {
	//		return partitionedRegions;
	//	}

	@Override
	public @NonNull Iterable<@NonNull Partition> getPartitions() {
		return partitions;
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getProducedTraceClassAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getProducedTracePropertyAnalyses() {
		throw new UnsupportedOperationException();
	}

	public @NonNull ScheduledRegion getScheduledRegion() {
		return ClassUtil.nonNullState(scheduledRegion);
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getSuperProducedTraceClassAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	protected @NonNull String getSymbolNamePrefix() {
		return "s_";
	}

	@Override
	public @NonNull Iterable<@NonNull TraceClassPartitionAnalysis> getTraceClassAnalyses() {
		return cyclicTraceClassAnalyses;
	}

	@Override
	public @NonNull List<@NonNull Node> getTraceNodes() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Iterable<@NonNull TracePropertyPartitionAnalysis> getTracePropertyAnalyses() {
		return cyclicTracePropertyAnalyses;
	}

	@Override
	public boolean isAwaited(@NonNull Edge edge) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isRealized(@NonNull Edge edge) {
		throw new UnsupportedOperationException();
	}

	public void setScheduledRegion(@NonNull ScheduledRegion scheduledRegion) {
		this.scheduledRegion = scheduledRegion;
	}
}