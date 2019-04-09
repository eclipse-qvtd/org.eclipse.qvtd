/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionPropertyAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * The CyclicPartitionsAnalysis identifies the Partitions and ClassAnalysis' that contribute to a cycle.
 *
 * This forms the basis of the cycle encpasulation and parallel schedule.
 */
public class CyclicPartitionsAnalysis
{
	protected final @NonNull TransformationPartitioner transformationPartitioner;
	protected final @NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> leafPartitionAnalyses;

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each mapping partitioner.
	 */
	protected final @NonNull Map<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>, @NonNull CyclicPartition> partitionAnalysis2cyclicPartition = new HashMap<>();

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each trace class analysis.
	 */
	protected final @NonNull Map<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>, @NonNull CyclicPartition> classAnalysis2cyclicPartition = new HashMap<>();

	public CyclicPartitionsAnalysis(@NonNull TransformationPartitioner transformationPartitioner, @NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> leafPartitions) {
		this.transformationPartitioner = transformationPartitioner;
		this.leafPartitionAnalyses = leafPartitions;
	}

	/**
	 * Return a map of the RegionAnalyses that form a cycle including each Partition.
	 *
	 * NB cycles may involve trace classes and their trace class properties.
	 */
	public @NonNull RootPartitionAnalysis analyze(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		Map<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> leafPartitionAnalysis2predecessors = CompilerUtil.computeTransitivePredecessors(leafPartitionAnalyses);
		Map<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> leafPartitionAnalysis2successors = CompilerUtil.computeTransitiveSuccessors(leafPartitionAnalysis2predecessors);
		Set<@NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> intersections = new HashSet<>();
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> leafPartitionAnalysis : leafPartitionAnalyses) {
			Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> predecessors = leafPartitionAnalysis2predecessors.get(leafPartitionAnalysis);
			Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> successors = leafPartitionAnalysis2successors.get(leafPartitionAnalysis);
			Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> intersection = new HashSet<>(predecessors);
			intersection.retainAll(successors);
			if (!intersection.isEmpty()) {
				intersections.add(intersection);
			}
		}
		//
		if (intersections.isEmpty()) {
			//	Set<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> cyclicClassAnalyses = computeClassAnalysisDependencies(partitionedTransformationAnalysis, leafPartitionAnalyses);
			//	Set<@NonNull PropertyPartitionAnalysis> cyclicPropertyAnalyses = computePropertyAnalysisDependencies(partitionedTransformationAnalysis, leafPartitionAnalyses);
			String rootName = QVTscheduleConstants.ROOT_MAPPING_NAME;
			return RootPartitionAnalysis.createRootPartitionAnalysis(partitionedTransformationAnalysis, transformationPartitioner.getTransformationAnalysis(), rootName, leafPartitionAnalysis2predecessors);
		}
		intersections.add(Sets.newHashSet(leafPartitionAnalyses));
		return createAcyclicPartitionHierarchy(partitionedTransformationAnalysis, intersections, leafPartitionAnalysis2predecessors);
	}

	private @NonNull Set<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> computeClassAnalysisDependencies(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> nestedPartitions) {
		Set<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> consumedClassAnalyses = new HashSet<>();
		Set<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> superProducedClassAnalyses = new HashSet<>();
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> nestedPartitionAnalysis : nestedPartitions) {
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> consumedClassAnalyses2 = nestedPartitionAnalysis.getConsumedClassAnalyses();
			if (consumedClassAnalyses2 != null) {
				Iterables.addAll(consumedClassAnalyses, consumedClassAnalyses2);
			}
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> superProducedClassAnalyses2 = nestedPartitionAnalysis.getSuperProducedClassAnalyses();
			if (superProducedClassAnalyses2 != null) {
				Iterables.addAll(superProducedClassAnalyses, superProducedClassAnalyses2);
			}
		}
		Set<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> cyclicClassAnalyses = new HashSet<>(consumedClassAnalyses);
		cyclicClassAnalyses.retainAll(superProducedClassAnalyses);
		return cyclicClassAnalyses;
	}

	/*	private @NonNull Set<@NonNull PropertyPartitionAnalysis> computePropertyAnalysisDependencies(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Iterable<@NonNull PartitionAnalysis> nestedPartitions) {
		Set<@NonNull PropertyPartitionAnalysis> consumedPropertyAnalyses = new HashSet<>();
		Set<@NonNull PropertyPartitionAnalysis> producedPropertyAnalyses = new HashSet<>();
		for (@NonNull PartitionAnalysis nestedPartitionAnalysis : nestedPartitions) {
			Iterable<@NonNull PropertyPartitionAnalysis> consumedPropertyAnalyses2 = nestedPartitionAnalysis.getConsumedPropertyAnalyses();
			if (consumedPropertyAnalyses2 != null) {
				Iterables.addAll(consumedPropertyAnalyses, consumedPropertyAnalyses2);
			}
			Iterable<@NonNull PropertyPartitionAnalysis> producedPropertyAnalyses2 = nestedPartitionAnalysis.getProducedPropertyAnalyses();
			if (producedPropertyAnalyses2 != null) {
				Iterables.addAll(producedPropertyAnalyses, producedPropertyAnalyses2);
			}
		}
		Set<@NonNull PropertyPartitionAnalysis> cyclicPropertyAnalyses = new HashSet<>(consumedPropertyAnalyses);
		cyclicPropertyAnalyses.retainAll(producedPropertyAnalyses);
		return cyclicPropertyAnalyses;
	} */

	/**
	 * Return a RootPartition/CyclicPartition hierarchy with a CyclicPartition wrapping the non-last partitionings and a
	 * RootPartition for the last partitionings.
	 *
	 * NB The partitionings is a working collection modified on return.
	 * @param leafPartition2successors
	 */
	private @NonNull RootPartitionAnalysis createAcyclicPartitionHierarchy(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Iterable<@NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> partitionings,
			@NonNull Map<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> partition2predecessors) {
		List<@NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> sortedPartitionings = new ArrayList<>();
		Map<@NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> partitioning2predecessors = new HashMap<>();
		for (@NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> partitioning : partitionings) {
			sortedPartitionings.add(partitioning);
			Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> predecessors = new HashSet<>();
			for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : partitioning) {
				predecessors.addAll(partition2predecessors.get(partitionAnalysis));
			}
			partitioning2predecessors.put(partitioning, predecessors);
		}
		//	Collections.sort(sortedPartitionings, QVTbaseUtil.CollectionSizeComparator.INSTANCE);	// Smallest first
		Collections.sort(sortedPartitionings, new Comparator<@NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>>() { // Fewest predecessors first

			@Override
			public int compare(@NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> o1, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> o2) {
				Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> predecessors1 = partitioning2predecessors.get(o1);
				Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> predecessors2 = partitioning2predecessors.get(o2);
				assert predecessors1 != null;
				assert predecessors2 != null;
				int s1 = predecessors1.size();
				int s2 = predecessors2.size();
				if (s1 == s2) {
					s1 = o1.size();
					s2 = o2.size();
				}
				return s1 - s2;
			}});
		//
		//	A nested cycle is necessarily fully contained by a nesting cycle. We can therefore steadily replace
		//	each set of nested elements by a cyclic element in the nesting context. The smallest first ordering
		//	does not need to be recomputed after each nesting simplification since nested candidates continue to
		//	precede their potential nestings.
		//
		List<@NonNull CompositePartitionAnalysis> acyclicPartitionHierarchy = new ArrayList<>();
		int iMax = sortedPartitionings.size();
		assert iMax >= 2;
		assert sortedPartitionings.get(iMax-1).equals(Sets.newHashSet(leafPartitionAnalyses));
		for (int i = 0; i < iMax-1; i++)  {
			Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> nestedPartitioning = sortedPartitionings.get(i);
			String cycleName = "«cycle-" + i + "»";
			//	CyclicPartition nestedCyclicPartition = createCyclicPartition(cycleName, nestedPartitioning, partition2predecessors, partition2successors);
			Set<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> cyclicClassAnalyses = computeClassAnalysisDependencies(partitionedTransformationAnalysis, nestedPartitioning);
			//	Set<@NonNull PropertyPartitionAnalysis> cyclicPropertyAnalyses = computePropertyAnalysisDependencies(partitionedTransformationAnalysis, nestedPartitioning);
			CyclicPartitionAnalysis nestedCyclicPartitionAnalysis = CyclicPartitionAnalysis.createCyclicPartitionAnalysis(partitionedTransformationAnalysis, cycleName, nestedPartitioning, partition2predecessors);
			CyclicPartition nestedCyclicPartition = nestedCyclicPartitionAnalysis.getPartition();
			acyclicPartitionHierarchy.add(nestedCyclicPartitionAnalysis);

			//
			for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> nestedPartition : nestedPartitioning) {
				CyclicPartition oldCycleAnalysis = partitionAnalysis2cyclicPartition.put(nestedPartition, nestedCyclicPartition);
				assert oldCycleAnalysis == null;
				partition2predecessors.remove(nestedPartition);
			}
			partition2predecessors.put(nestedCyclicPartitionAnalysis, nestedCyclicPartitionAnalysis.getExplicitPredecessors());
			//
			for (@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> cyclicClassAnalysis : cyclicClassAnalyses) {
				CyclicPartition oldCycleAnalysis = classAnalysis2cyclicPartition.put(cyclicClassAnalysis, nestedCyclicPartition);
				assert oldCycleAnalysis == null;
			}

			//
			//	Replace the nestedPartitioning partitions by nestedCyclicPartition in the potentially nesting cycles
			//
			for (int j = i+1; j < iMax; j++)  {
				Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> nestingPartitioning = sortedPartitionings.get(j);
				int oldSize = nestingPartitioning.size();
				if (nestingPartitioning.removeAll(nestedPartitioning)) {
					int newSize = nestingPartitioning.size();
					assert (oldSize - newSize) == nestedPartitioning.size();
					nestingPartitioning.add(nestedCyclicPartitionAnalysis);
				}
			}
			for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partition : partition2predecessors.keySet()) {
				Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> predecessors = partition2predecessors.get(partition);
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
		//	Set<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> rootClassAnalyses = computeClassAnalysisDependencies(partitionedTransformationAnalysis, rootPartitioning);
		//	Set<@NonNull PropertyPartitionAnalysis> rootPropertyAnalyses = computePropertyAnalysisDependencies(partitionedTransformationAnalysis, rootPartitioning);
		String rootName = QVTscheduleConstants.ROOT_MAPPING_NAME;
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
				List<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> partitions2 = Lists.newArrayList(cyclicPartitionAnalysis.getPartitionAnalyses());
				Collections.sort(partitions2, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partition : partitions2) {
					s.append("\n\t" + partition);
					Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> consumedClassAnalyses = partition.getConsumedClassAnalyses();
					if (consumedClassAnalyses != null) {
						for (@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> classAnalysis : consumedClassAnalyses) {
							s.append("\n\t  =>" + classAnalysis);
						}
					}
					Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> producedClassAnalyses = partition.getProducedClassAnalyses();
					if (producedClassAnalyses != null) {
						for (@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> classAnalysis : producedClassAnalyses) {
							s.append("\n\t  <=" + classAnalysis);
						}
					}
					Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis>> consumedPropertyAnalyses = partition.getConsumedPropertyAnalyses();
					if (consumedPropertyAnalyses != null) {
						for (@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis> propertyAnalysis : consumedPropertyAnalyses) {
							s.append("\n\t  =>" + propertyAnalysis);
						}
					}
					Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis>> producedPropertyAnalyses = partition.getProducedPropertyAnalyses();
					if (producedPropertyAnalyses != null) {
						for (@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis> propertyAnalysis : producedPropertyAnalyses) {
							s.append("\n\t  <=" + propertyAnalysis);
						}
					}
				}
				/*				s.append("\n  ClassAnalyses:");
				List<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> classAnalyses = Lists.newArrayList(cyclicPartitionAnalysis.getClassAnalyses());
				Collections.sort(classAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> classAnalysis : classAnalyses) {
					s.append("\n\t" + classAnalysis);
				}
				s.append("\n  PropertyAnalyses:");
				List<@NonNull PropertyPartitionAnalysis> propertyAnalyses = Lists.newArrayList(cyclicPartitionAnalysis.getPropertyAnalyses());
				Collections.sort(propertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PropertyPartitionAnalysis propertyAnalysis : propertyAnalyses) {
					s.append("\n\t" + propertyAnalysis);
				} */
				TransformationPartitioner.CYCLES.println(s.toString());
			}
		}
	}
}
