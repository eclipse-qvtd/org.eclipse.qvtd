/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.merger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Concurrency;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedConditionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.AbstractCompositePartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.BasicPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.MergedPartitionFactory;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionedTransformationAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.CompositePartition;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * ConcurrentPartitionMerger replaces partitions that occur at the same depth in the parallel schedule and
 * which have identical failure mechanisms by an equivalent merged partition..
 */
public class ConcurrentPartitionMerger extends AbstractMerger
{
	public static @NonNull List<@NonNull Concurrency> merge(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull List<@NonNull Concurrency> partitionSchedule) {
		for (int i = 0; i < partitionSchedule.size(); i++) {
			Concurrency oldConcurrency = partitionSchedule.get(i);
			if (oldConcurrency.size() > 1) {
				Map<@NonNull Region, @NonNull List<@NonNull PartitionAnalysis>> region2partitions = new HashMap<>();
				for (@NonNull PartitionAnalysis partitionAnalysis : oldConcurrency) {
					Partition partition = partitionAnalysis.getPartition();
					if (!(partition instanceof CyclicPartition)) {
						Region region = QVTscheduleUtil.getRegion(partition);
						List<@NonNull PartitionAnalysis> partitions = region2partitions.get(region);
						if (partitions == null) {
							partitions = new ArrayList<>();
							region2partitions.put(region, partitions);
						}
						partitions.add(partitionAnalysis);
					}
				}
				Concurrency newConcurrency = null;
				for (@NonNull Region region : region2partitions.keySet()) {
					if (!(region instanceof CyclicMappingRegion)) {
						List<@NonNull PartitionAnalysis> partitions = region2partitions.get(region);
						assert partitions != null;
						if (partitions.size() > 1) {
							ConcurrentPartitionMerger concurrentMerger = new ConcurrentPartitionMerger(partitionedTransformationAnalysis, partitions);
							Map<@NonNull PartitionAnalysis, @Nullable PartitionAnalysis> old2new = concurrentMerger.merge();
							if (old2new != null) {
								if (newConcurrency == null) {
									newConcurrency = new Concurrency(oldConcurrency);
								}
								for (@NonNull PartitionAnalysis oldPartition : old2new.keySet()) {
									newConcurrency.remove(oldPartition);
									PartitionAnalysis newPartition = old2new.get(oldPartition);
									assert newPartition != null;
									newConcurrency.add(newPartition);
								}
							}
							if (newConcurrency != null) {
								partitionSchedule.set(i, newConcurrency);
							}
						}
					}
				}
			}
		}
		return partitionSchedule;
	}

	protected final @NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis;
	protected final @NonNull Iterable<@NonNull PartitionAnalysis> partitions;

	protected ConcurrentPartitionMerger(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull Iterable<@NonNull PartitionAnalysis> partitions) {
		this.partitionedTransformationAnalysis = partitionedTransformationAnalysis;
		this.partitions = partitions;
	}

	protected @Nullable Map<@NonNull PartitionAnalysis, @Nullable PartitionAnalysis> merge() {
		//
		//	Build maps of failure mechanisms of each partition.
		//
		ScheduleManager scheduleManager = partitionedTransformationAnalysis.getScheduleManager();
		Map<@NonNull Integer, @NonNull Set<@NonNull BasicPartitionAnalysis>> hash2partitionAnalyses = new HashMap<>();
		Map<@NonNull BasicPartitionAnalysis, @NonNull Set<@NonNull CheckedCondition>> partion2checkedConditions = new HashMap<>();
		for (@NonNull PartitionAnalysis partitionAnalysis : partitions) {
			BasicPartitionAnalysis basicPartitionAnalysis = (BasicPartitionAnalysis) partitionAnalysis;
			CheckedConditionAnalysis checkedConditionAnalysis = new CheckedConditionAnalysis(basicPartitionAnalysis, scheduleManager);
			Set<@NonNull CheckedCondition> checkedConditions = checkedConditionAnalysis.computeCheckedConditions();
			if (checkedConditions.size() > 0) {
				int hash = checkedConditions.hashCode();
				partion2checkedConditions.put(basicPartitionAnalysis, checkedConditions);
				Set<@NonNull BasicPartitionAnalysis> hashPartitionAnalyses = hash2partitionAnalyses.get(hash);
				if (hashPartitionAnalyses == null) {
					hashPartitionAnalyses = new HashSet<>();
					hash2partitionAnalyses.put(hash, hashPartitionAnalyses);
				}
				hashPartitionAnalyses.add(basicPartitionAnalysis);
			}
		}
		//
		//	Select partitions with identical container, passes and failure mechanisms for merging.
		//
		Map<@NonNull PartitionAnalysis, @Nullable PartitionAnalysis> old2new = new HashMap<>();
		for (@NonNull Set<@NonNull BasicPartitionAnalysis> hashPartitionAnalyses : hash2partitionAnalyses.values()) {
			if (hashPartitionAnalyses.size() > 1) {
				List<@NonNull BasicPartitionAnalysis> merges = null;
				List<@NonNull BasicPartitionAnalysis> residualHashPartitionAnalyses = new ArrayList<>(hashPartitionAnalyses);
				for (int i = 0; i < residualHashPartitionAnalyses.size(); i++) {		// Tolerate concurrent later removes
					BasicPartitionAnalysis iPartitionAnalysis = residualHashPartitionAnalyses.get(i);
					BasicPartition iPartition = iPartitionAnalysis.getPartition();
					CompositePartition iContainer = iPartition.getOwningCompositePartition();
					List<Integer> iPasses = iPartition.getPasses();
					Set<@NonNull CheckedCondition> iCheckedConditions = partion2checkedConditions.get(iPartitionAnalysis);
					assert iCheckedConditions != null;
					for (int j = residualHashPartitionAnalyses.size(); --j > i; ) {		// Tolerate concurrent later removes
						BasicPartitionAnalysis jPartitionAnalysis = residualHashPartitionAnalyses.get(j);
						BasicPartition jPartition = jPartitionAnalysis.getPartition();
						CompositePartition jContainer = jPartition.getOwningCompositePartition();
						List<Integer> jPasses = jPartition.getPasses();
						if ((iContainer == jContainer) && iPasses.equals(jPasses)) {
							Set<@NonNull CheckedCondition> jCheckedConditions = partion2checkedConditions.get(jPartitionAnalysis);
							assert jCheckedConditions != null;
							if (iCheckedConditions.equals(jCheckedConditions)) {
								if (merges == null) {
									merges = new ArrayList<>();
									merges.add(iPartitionAnalysis);
								}
								merges.add(jPartitionAnalysis);
								residualHashPartitionAnalyses.remove(j);
							}
						}
					}
				}
				if (merges != null) {
					System.out.println("Concurrent Merge " + merges);
					BasicPartition firstPartition = merges.get(0).getPartition();
					CompositePartition owningCompositePartition = firstPartition.getOwningCompositePartition();
					assert owningCompositePartition != null;
					AbstractCompositePartitionAnalysis<?> compositePartitionAnalysis = (AbstractCompositePartitionAnalysis<?>)partitionedTransformationAnalysis.getPartitionAnalysis(owningCompositePartition);
					List<MappingPartition> ownedMappingPartitions = owningCompositePartition.getOwnedMappingPartitions();
					MergedPartitionFactory mergedPartitionFactory = new MergedPartitionFactory(scheduleManager, QVTscheduleUtil.getRegion(firstPartition), merges);
					BasicPartitionAnalysis mergedPartitionAnalysis = mergedPartitionFactory.createPartitionAnalysis(partitionedTransformationAnalysis);
					BasicPartition mergedPartition = mergedPartitionAnalysis.getPartition();
					//					MappingRegion mappingRegion = (MappingRegion)regionAnalysis.getRegion();
					//					List<MappingPartition> mappingPartitions = mappingRegion.getMappingPartitions();
					for (@NonNull BasicPartitionAnalysis partitionAnalysis : merges) {
						//						mergedPartition.getExplicitPredecessors().addAll(oldPartition.getExplicitPredecessors());
						//						partitionAnalysis.destroy();
						//						BasicPartition oldPartition = partitionAnalysis.getPartition();
						//						boolean wasRemoved1 = ownedMappingPartitions.remove(oldPartition);
						//						assert wasRemoved1;
						//						boolean wasRemoved2 = mappingPartitions.remove(oldPartition);
						//						assert wasRemoved2;
						//						mergedPartition.getExplicitSuccessors().addAll(oldPartition.getExplicitSuccessors());
						//						oldPartition.getExplicitPredecessors().clear();
						//						oldPartition.getExplicitSuccessors().clear();
						old2new.put(partitionAnalysis, mergedPartitionAnalysis);
					}
					for (int pass : merges.iterator().next().getPartition().getPasses()) {
						mergedPartition.addPass(pass);
					}
					scheduleManager.writeDebugGraphs(mergedPartition, null);
					ownedMappingPartitions.add(mergedPartition);
					compositePartitionAnalysis.merge(old2new);
				}
			}
		}
		return old2new;
	}
}
