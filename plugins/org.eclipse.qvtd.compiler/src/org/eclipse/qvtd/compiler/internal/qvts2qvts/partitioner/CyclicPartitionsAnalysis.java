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
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * The CyclicPartitionsAnalysis identifies the Partitions and TraceClassAnalysis' that contribute to a cycle.
 *
 * This forms the basis of the cycle encpasulation and parallel schedule.
 */
public class CyclicPartitionsAnalysis
{
	protected final @NonNull TransformationPartitioner transformationPartitioner;
	protected final @NonNull Iterable<@NonNull PartitionAnalysis> leafPartitionAnalyses;

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each mapping partitioner.
	 */
	protected final @NonNull Map<@NonNull PartitionAnalysis, @NonNull CyclicPartition> partitionAnalysis2cyclicPartition = new HashMap<>();

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each trace class analysis.
	 */
	protected final @NonNull Map<@NonNull TraceClassPartitionAnalysis, @NonNull CyclicPartition> traceClassAnalysis2cyclicPartition = new HashMap<>();

	public CyclicPartitionsAnalysis(@NonNull TransformationPartitioner transformationPartitioner, @NonNull Iterable<@NonNull PartitionAnalysis> leafPartitions) {
		this.transformationPartitioner = transformationPartitioner;
		this.leafPartitionAnalyses = leafPartitions;
	}

	/**
	 * Return a map of the RegionAnalyses that form a cycle including each Partition.
	 *
	 * NB cycles may involve trace classes and their trace class properties.
	 */
	public @NonNull RootPartitionAnalysis analyze(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> leafPartitionAnalysis2predecessors = CompilerUtil.computeTransitivePredecessors(leafPartitionAnalyses);
		Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> leafPartitionAnalysis2successors = CompilerUtil.computeTransitiveSuccessors(leafPartitionAnalysis2predecessors);
		Set<@NonNull Set<@NonNull PartitionAnalysis>> intersections = new HashSet<>();
		for (@NonNull PartitionAnalysis leafPartitionAnalysis : leafPartitionAnalyses) {
			Set<@NonNull PartitionAnalysis> intersection = new HashSet<>(leafPartitionAnalysis2predecessors.get(leafPartitionAnalysis));
			intersection.retainAll(leafPartitionAnalysis2successors.get(leafPartitionAnalysis));
			if (!intersection.isEmpty()) {
				intersections.add(intersection);
			}
		}
		//
		if (intersections.isEmpty()) {
			//	Set<@NonNull TraceClassPartitionAnalysis> cyclicTraceClassAnalyses = computeTraceClassAnalysisDependencies(partitionedTransformationAnalysis, leafPartitionAnalyses);
			//	Set<@NonNull TracePropertyPartitionAnalysis> cyclicTracePropertyAnalyses = computeTracePropertyAnalysisDependencies(partitionedTransformationAnalysis, leafPartitionAnalyses);
			String rootName = "«root»";
			return RootPartitionAnalysis.createRootPartitionAnalysis(partitionedTransformationAnalysis, transformationPartitioner.getTransformationAnalysis(), rootName, leafPartitionAnalysis2predecessors);
		}
		intersections.add(Sets.newHashSet(leafPartitionAnalyses));
		return createAcyclicPartitionHierarchy(partitionedTransformationAnalysis, intersections, leafPartitionAnalysis2predecessors);
	}

	private @NonNull Set<@NonNull TraceClassPartitionAnalysis> computeTraceClassAnalysisDependencies(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Iterable<@NonNull PartitionAnalysis> nestedPartitions) {
		Set<@NonNull TraceClassPartitionAnalysis> consumedTraceClassAnalyses = new HashSet<>();
		Set<@NonNull TraceClassPartitionAnalysis> superProducedTraceClassAnalyses = new HashSet<>();
		for (@NonNull PartitionAnalysis nestedPartitionAnalysis : nestedPartitions) {
			Iterable<@NonNull TraceClassPartitionAnalysis> consumedTraceClassAnalyses2 = nestedPartitionAnalysis.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses2 != null) {
				Iterables.addAll(consumedTraceClassAnalyses, consumedTraceClassAnalyses2);
			}
			Iterable<@NonNull TraceClassPartitionAnalysis> superProducedTraceClassAnalyses2 = nestedPartitionAnalysis.getSuperProducedTraceClassAnalyses();
			if (superProducedTraceClassAnalyses2 != null) {
				Iterables.addAll(superProducedTraceClassAnalyses, superProducedTraceClassAnalyses2);
			}
		}
		Set<@NonNull TraceClassPartitionAnalysis> cyclicTraceClassAnalyses = new HashSet<>(consumedTraceClassAnalyses);
		cyclicTraceClassAnalyses.retainAll(superProducedTraceClassAnalyses);
		return cyclicTraceClassAnalyses;
	}

	/*	private @NonNull Set<@NonNull TracePropertyPartitionAnalysis> computeTracePropertyAnalysisDependencies(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Iterable<@NonNull PartitionAnalysis> nestedPartitions) {
		Set<@NonNull TracePropertyPartitionAnalysis> consumedTracePropertyAnalyses = new HashSet<>();
		Set<@NonNull TracePropertyPartitionAnalysis> producedTracePropertyAnalyses = new HashSet<>();
		for (@NonNull PartitionAnalysis nestedPartitionAnalysis : nestedPartitions) {
			Iterable<@NonNull TracePropertyPartitionAnalysis> consumedTracePropertyAnalyses2 = nestedPartitionAnalysis.getConsumedTracePropertyAnalyses();
			if (consumedTracePropertyAnalyses2 != null) {
				Iterables.addAll(consumedTracePropertyAnalyses, consumedTracePropertyAnalyses2);
			}
			Iterable<@NonNull TracePropertyPartitionAnalysis> producedTracePropertyAnalyses2 = nestedPartitionAnalysis.getProducedTracePropertyAnalyses();
			if (producedTracePropertyAnalyses2 != null) {
				Iterables.addAll(producedTracePropertyAnalyses, producedTracePropertyAnalyses2);
			}
		}
		Set<@NonNull TracePropertyPartitionAnalysis> cyclicTracePropertyAnalyses = new HashSet<>(consumedTracePropertyAnalyses);
		cyclicTracePropertyAnalyses.retainAll(producedTracePropertyAnalyses);
		return cyclicTracePropertyAnalyses;
	} */

	/**
	 * Return a RootPartition/CyclicPartition hierarchy with a CyclicPartition wrapping the non-last partitionings and a
	 * RootPartition for the last partitionings.
	 *
	 * NB The partitionings is a working collection modified on return.
	 * @param leafPartition2successors
	 */
	private @NonNull RootPartitionAnalysis createAcyclicPartitionHierarchy(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Iterable<@NonNull Set<@NonNull PartitionAnalysis>> partitionings,
			@NonNull Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> partition2predecessors) {
		List<@NonNull Set<@NonNull PartitionAnalysis>> sortedPartitionings = Lists.newArrayList(partitionings);
		Collections.sort(sortedPartitionings, QVTbaseUtil.CollectionSizeComparator.INSTANCE);	// Smallest first
		//
		//	A nested cycle is necessarily fully contained by a nesting cycle. We can therefore steadily replace
		//	each set of nested elements by a cyclic element in the nesting context. The smallest first lordering
		//	does not need to be recomputed after each nesting simplification since nested candidates continue to
		//	precede their potential nestings.
		//
		List<@NonNull CompositePartitionAnalysis> acyclicPartitionHierarchy = new ArrayList<>();
		int iMax = sortedPartitionings.size();
		assert iMax >= 2;
		assert sortedPartitionings.get(iMax-1).equals(Sets.newHashSet(leafPartitionAnalyses));
		for (int i = 0; i < iMax-1; i++)  {
			Set<@NonNull PartitionAnalysis> nestedPartitioning = sortedPartitionings.get(i);
			String cycleName = "«cycle-" + i + "»";
			//	CyclicPartition nestedCyclicPartition = createCyclicPartition(cycleName, nestedPartitioning, partition2predecessors, partition2successors);
			Set<@NonNull TraceClassPartitionAnalysis> cyclicTraceClassAnalyses = computeTraceClassAnalysisDependencies(partitionedTransformationAnalysis, nestedPartitioning);
			//	Set<@NonNull TracePropertyPartitionAnalysis> cyclicTracePropertyAnalyses = computeTracePropertyAnalysisDependencies(partitionedTransformationAnalysis, nestedPartitioning);
			CyclicPartitionAnalysis nestedCyclicPartitionAnalysis = CyclicPartitionAnalysis.createCyclicPartitionAnalysis(partitionedTransformationAnalysis, cycleName, nestedPartitioning, partition2predecessors);
			CyclicPartition nestedCyclicPartition = nestedCyclicPartitionAnalysis.getPartition();
			acyclicPartitionHierarchy.add(nestedCyclicPartitionAnalysis);

			//
			for (@NonNull PartitionAnalysis nestedPartition : nestedPartitioning) {
				CyclicPartition oldCycleAnalysis = partitionAnalysis2cyclicPartition.put(nestedPartition, nestedCyclicPartition);
				assert oldCycleAnalysis == null;
				partition2predecessors.remove(nestedPartition);
			}
			partition2predecessors.put(nestedCyclicPartitionAnalysis, nestedCyclicPartitionAnalysis.getExplicitPredecessors());
			//
			for (@NonNull TraceClassPartitionAnalysis cyclicTraceClassAnalysis : cyclicTraceClassAnalyses) {
				CyclicPartition oldCycleAnalysis = traceClassAnalysis2cyclicPartition.put(cyclicTraceClassAnalysis, nestedCyclicPartition);
				assert oldCycleAnalysis == null;
			}

			//
			//	Replace the nestedPartitioning partitions by nestedCyclicPartition in the potentially nesting cycles
			//
			for (int j = i+1; j < iMax; j++)  {
				Set<@NonNull PartitionAnalysis> nestingPartitioning = sortedPartitionings.get(j);
				int oldSize = nestingPartitioning.size();
				if (nestingPartitioning.removeAll(nestedPartitioning)) {
					int newSize = nestingPartitioning.size();
					assert (oldSize - newSize) == nestedPartitioning.size();
					nestingPartitioning.add(nestedCyclicPartitionAnalysis);
				}
			}
			for (@NonNull PartitionAnalysis partition : partition2predecessors.keySet()) {
				Set<@NonNull PartitionAnalysis> predecessors = partition2predecessors.get(partition);
				assert predecessors != null;
				int oldSize = predecessors.size();
				if (predecessors.removeAll(nestedPartitioning)) {
					int newSize = predecessors.size();
					assert (oldSize - newSize) == nestedPartitioning.size();
					predecessors.add(nestedCyclicPartitionAnalysis);
				}
			}
		}
		//	Set<@NonNull PartitionAnalysis> rootPartitioning = sortedPartitionings.get(iMax-1);
		//	Set<@NonNull TraceClassPartitionAnalysis> rootTraceClassAnalyses = computeTraceClassAnalysisDependencies(partitionedTransformationAnalysis, rootPartitioning);
		//	Set<@NonNull TracePropertyPartitionAnalysis> rootTracePropertyAnalyses = computeTracePropertyAnalysisDependencies(partitionedTransformationAnalysis, rootPartitioning);
		String rootName = "«root»";
		RootPartitionAnalysis rootPartitionAnalysis = RootPartitionAnalysis.createRootPartitionAnalysis(partitionedTransformationAnalysis, transformationPartitioner.getTransformationAnalysis(), rootName, partition2predecessors);
		acyclicPartitionHierarchy.add(rootPartitionAnalysis);
		if (TransformationPartitioner.CYCLES.isActive()) {
			showCycles(partitionedTransformationAnalysis, acyclicPartitionHierarchy);
		}
		return rootPartitionAnalysis;
	}

	protected void showCycles(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, Iterable<@NonNull CompositePartitionAnalysis> cyclicPartitionAnalyses) {
		if (Iterables.isEmpty(cyclicPartitionAnalyses)) {
			TransformationPartitioner.CYCLES.println("No cycles");
		}
		else {
			for (@NonNull CompositePartitionAnalysis cyclicPartitionAnalysis : cyclicPartitionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append("\n  Partitions:");
				List<@NonNull PartitionAnalysis> partitions2 = Lists.newArrayList(cyclicPartitionAnalysis.getPartitionAnalyses());
				Collections.sort(partitions2, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartitionAnalysis partition : partitions2) {
					s.append("\n\t" + partition);
					Iterable<@NonNull ? extends TraceClassPartitionAnalysis> consumedTraceClassAnalyses = cyclicPartitionAnalysis.getConsumedTraceClassAnalyses();
					if (consumedTraceClassAnalyses != null) {
						for (@NonNull TraceClassPartitionAnalysis traceClassAnalysis : consumedTraceClassAnalyses) {
							s.append("\n\t  =>" + traceClassAnalysis);
						}
					}
					Iterable<@NonNull ? extends TraceClassPartitionAnalysis> producedTraceClassAnalyses = cyclicPartitionAnalysis.getProducedTraceClassAnalyses();
					if (producedTraceClassAnalyses != null) {
						for (@NonNull TraceClassPartitionAnalysis traceClassAnalysis : producedTraceClassAnalyses) {
							s.append("\n\t  <=" + traceClassAnalysis);
						}
					}
					Iterable<@NonNull ? extends TracePropertyPartitionAnalysis> consumedTracePropertyAnalyses = cyclicPartitionAnalysis.getConsumedTracePropertyAnalyses();
					if (consumedTracePropertyAnalyses != null) {
						for (@NonNull TracePropertyPartitionAnalysis tracePropertyAnalysis : consumedTracePropertyAnalyses) {
							s.append("\n\t  =>" + tracePropertyAnalysis);
						}
					}
					Iterable<@NonNull ? extends TracePropertyPartitionAnalysis> producedTracePropertyAnalyses = cyclicPartitionAnalysis.getProducedTracePropertyAnalyses();
					if (producedTracePropertyAnalyses != null) {
						for (@NonNull TracePropertyPartitionAnalysis tracePropertyAnalysis : producedTracePropertyAnalyses) {
							s.append("\n\t  <=" + tracePropertyAnalysis);
						}
					}
				}
				s.append("\n  TraceClassAnalyses:");
				List<@NonNull TraceClassPartitionAnalysis> traceClassAnalyses = Lists.newArrayList(cyclicPartitionAnalysis.getTraceClassAnalyses());
				Collections.sort(traceClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull TraceClassPartitionAnalysis traceClassAnalysis : traceClassAnalyses) {
					s.append("\n\t" + traceClassAnalysis);
				}
				s.append("\n  TracePropertyAnalyses:");
				List<@NonNull TracePropertyPartitionAnalysis> tracePropertyAnalyses = Lists.newArrayList(cyclicPartitionAnalysis.getTracePropertyAnalyses());
				Collections.sort(tracePropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull TracePropertyPartitionAnalysis tracePropertyAnalysis : tracePropertyAnalyses) {
					s.append("\n\t" + tracePropertyAnalysis);
				}
				TransformationPartitioner.CYCLES.println(s.toString());
			}
		}
	}
}
