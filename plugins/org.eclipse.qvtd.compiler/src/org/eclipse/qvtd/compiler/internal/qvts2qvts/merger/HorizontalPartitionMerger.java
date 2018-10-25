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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedConditionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.BasicPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.MergedPartitionFactory;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionedTransformationAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.CompositePartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;

/**
 * LateConsumerMerger replaces one list of MappingRegions by another in which each set of regions that
 * share a consumption and can be merged exploiting knowledge of the schedule is replaced by an
 * equivalent merged region.
 *
 * Preconditions:
 *
 * Late consumer merge must occur at all possible merge sites, or none. That is, a merged region that consumes
 * some node and surrounding predicates at its head must merge with all other regions that consume that
 * head node with non-conflicting predicates.
 *
 * Every predicated edge/node of a late merged region must be shared with or satisfied by the other region.
 */
public class HorizontalPartitionMerger extends AbstractMerger
{
	protected final @NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis;
	protected final @NonNull RegionAnalysis regionAnalysis;
	protected final @NonNull Iterable<@NonNull PartitionAnalysis> partitions;

	public HorizontalPartitionMerger(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull RegionAnalysis regionAnalysis, @NonNull Iterable<@NonNull PartitionAnalysis> partitions) {
		this.partitionedTransformationAnalysis = partitionedTransformationAnalysis;
		this.regionAnalysis = regionAnalysis;
		this.partitions = partitions;
	}

	public @Nullable Map<@NonNull PartitionAnalysis, @Nullable PartitionAnalysis> merge() {
		//
		//	Build maps of failure mechanisms of each partition.
		//
		ScheduleManager scheduleManager = regionAnalysis.getScheduleManager();
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
					System.out.println("Merge " + merges);
					CompositePartition owningCompositePartition = merges.get(0).getPartition().getOwningCompositePartition();
					List<MappingPartition> ownedMappingPartitions = owningCompositePartition.getOwnedMappingPartitions();
					MergedPartitionFactory mergedPartitionFactory = new MergedPartitionFactory(regionAnalysis, merges);
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
				}
			}
		}
		return old2new;
	}
}
