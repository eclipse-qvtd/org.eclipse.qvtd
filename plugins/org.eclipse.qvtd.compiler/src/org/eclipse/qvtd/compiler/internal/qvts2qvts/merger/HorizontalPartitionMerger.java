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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.Partition;

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
	//	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull RegionAnalysis regionAnalysis;
	protected final @NonNull Iterable<@NonNull Partition> partitions;

	public HorizontalPartitionMerger(@NonNull RegionAnalysis regionAnalysis, @NonNull Iterable<@NonNull Partition> partitions) {
		//		this.scheduleManager = regionAnalysis.getScheduleManager();
		this.regionAnalysis = regionAnalysis;
		this.partitions = partitions;
	}

	public @Nullable Map<@NonNull Partition, @Nullable Partition> merge() {
		//
		//	Build maps of failure mechanisms of each partition.
		//
		ScheduleManager scheduleManager = regionAnalysis.getScheduleManager();
		Map<@NonNull Integer, @NonNull Set<@NonNull Partition>> hash2partitions = new HashMap<>();
		Map<@NonNull Partition, @NonNull Set<@NonNull CheckedCondition>> partion2checkedConditions = new HashMap<>();
		for (@NonNull Partition partition : partitions) {
			CheckedConditionAnalysis checkedConditionAnalysis = new CheckedConditionAnalysis(partition, scheduleManager);
			Set<@NonNull CheckedCondition> checkedConditions = checkedConditionAnalysis.computeCheckedConditions();
			if (checkedConditions.size() > 0) {
				int hash = checkedConditions.hashCode();
				partion2checkedConditions.put(partition, checkedConditions);
				Set<@NonNull Partition> hashPartitions = hash2partitions.get(hash);
				if (hashPartitions == null) {
					hashPartitions = new HashSet<>();
					hash2partitions.put(hash, hashPartitions);
				}
				hashPartitions.add(partition);
			}
		}
		//
		//	Select partitions with identical failure mechanisms for merging.
		//
		for (@NonNull Set<@NonNull Partition> hashPartitions : hash2partitions.values()) {
			if (hashPartitions.size() > 1) {
				List<@NonNull Partition> merges = null;
				List<@NonNull Partition> residualHashPartitions = new ArrayList<>(hashPartitions);
				for (int i = 0; i < residualHashPartitions.size(); i++) {		// Tolerate concurrent later removes
					Partition iPartition = residualHashPartitions.get(i);
					Set<@NonNull CheckedCondition> iCheckedConditions = partion2checkedConditions.get(iPartition);
					assert iCheckedConditions != null;
					for (int j = residualHashPartitions.size(); --j > i; ) {		// Tolerate concurrent later removes
						Partition jPartition = residualHashPartitions.get(j);
						Set<@NonNull CheckedCondition> jCheckedConditions = partion2checkedConditions.get(jPartition);
						assert jCheckedConditions != null;
						if (iCheckedConditions.equals(jCheckedConditions)) {
							if (merges == null) {
								merges = new ArrayList<>();
								merges.add(iPartition);
							}
							merges.add(jPartition);
							residualHashPartitions.remove(j);
						}
					}
				}
				if (merges != null) {
					System.out.println("Merge " + merges);
				}
			}
		}
		Map<@NonNull Partition, @Nullable Partition> old2new = new HashMap<>();
		return null; //old2new;
	}
}
