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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.MappingPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.MergedPartitionFactory;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionedTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TransformationPartitioner;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.CompositePartition;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * ConcurrentPartitionMerger replaces one list of MappingRegions by another in which each set of regions that
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
public class SequentialPartitionMerger extends AbstractMerger
{
	public static @NonNull List<@NonNull Concurrency> merge(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull List<@NonNull Concurrency> partitionSchedule) {
		RootPartitionAnalysis rootPartitionAnalysis = partitionedTransformationAnalysis.getRootPartitionAnalysis();
		ScheduleManager scheduleManager = partitionedTransformationAnalysis.getScheduleManager();
		for (@NonNull Connection connection : QVTscheduleUtil.getOwnedConnections(rootPartitionAnalysis.getRootRegion())) {
			if (connection.isPassed()) {
				Iterable<@NonNull Partition> sourcePartitions = connection.getSourcePartitions();
				if (Iterables.size(sourcePartitions) == 1) {
					Partition sourcePartition = sourcePartitions.iterator().next();
					if (sourcePartition instanceof MappingPartition) {
						PartitionAnalysis sourcePartitionAnalysis = partitionedTransformationAnalysis.getPartitionAnalysis(sourcePartition);
						if (sourcePartitionAnalysis instanceof BasicPartitionAnalysis) {
							List<@NonNull BasicPartitionAnalysis> mergeablePartitionAnalyses = null;
							CheckedConditionAnalysis sourceCheckedConditionAnalysis = new CheckedConditionAnalysis((MappingPartitionAnalysis<?>)sourcePartitionAnalysis, scheduleManager);
							Set<@NonNull CheckedCondition> sourceCheckedConditions = sourceCheckedConditionAnalysis.computeCheckedConditions();
							for (@NonNull Partition targetPartition : connection.getTargetPartitions()) {
								if ((targetPartition.getHeadNodes().size() == 1) && (sourcePartition.getRegion() == targetPartition.getRegion())) {
									PartitionAnalysis targetPartitionAnalysis = partitionedTransformationAnalysis.getPartitionAnalysis(targetPartition);
									if (targetPartitionAnalysis instanceof BasicPartitionAnalysis) {
										CheckedConditionAnalysis targetCheckedConditionAnalysis = new CheckedConditionAnalysis((MappingPartitionAnalysis<?>)targetPartitionAnalysis, scheduleManager);
										Set<@NonNull CheckedCondition> targetCheckedConditions = targetCheckedConditionAnalysis.computeCheckedConditions();
										if (sourceCheckedConditions.containsAll(targetCheckedConditions)) {
											if (mergeablePartitionAnalyses == null) {
												mergeablePartitionAnalyses = new ArrayList<>();
												mergeablePartitionAnalyses.add((BasicPartitionAnalysis)sourcePartitionAnalysis);
											}
											mergeablePartitionAnalyses.add((BasicPartitionAnalysis)targetPartitionAnalysis);
											TransformationPartitioner.MERGE_SEQUENTIAL.println(sourcePartition + " => " + connection + " => " + targetPartitionAnalysis);
										}
									}
								}
							}
							/*	if (mergeablePartitionAnalyses != null) {
								SequentialPartitionMerger sequentialMerger = new SequentialPartitionMerger(partitionedTransformationAnalysis, mergeablePartitionAnalyses);
								Map<@NonNull PartitionAnalysis, @Nullable PartitionAnalysis> old2new = sequentialMerger.merge();
								if (old2new != null) {
									/*		if (newConcurrency == null) {
										newConcurrency = Sets.newHashSet(oldConcurrency);
									}
									for (@NonNull PartitionAnalysis oldPartition : old2new.keySet()) {
										newConcurrency.remove(oldPartition);
										PartitionAnalysis newPartition = old2new.get(oldPartition);
										assert newPartition != null;
										newConcurrency.add(newPartition);
									}
								}
								if (newConcurrency != null) {
									partitionSchedule.set(i, newConcurrency); * /
								}
							} */
						}
					}
				}
			}
		}
		return partitionSchedule;
	}

	protected final @NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis;
	protected final @NonNull List<@NonNull BasicPartitionAnalysis> mergeablePartitionAnalyses;

	protected SequentialPartitionMerger(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis,
			@NonNull List<@NonNull BasicPartitionAnalysis> mergeablePartitionAnalyses) {
		this.partitionedTransformationAnalysis = partitionedTransformationAnalysis;
		this.mergeablePartitionAnalyses = mergeablePartitionAnalyses;
	}

	protected @Nullable Map<@NonNull PartitionAnalysis, @Nullable PartitionAnalysis> merge() {
		ScheduleManager scheduleManager = partitionedTransformationAnalysis.getScheduleManager();
		Map<@NonNull PartitionAnalysis, @Nullable PartitionAnalysis> old2new = new HashMap<>();
		BasicPartition firstPartition = mergeablePartitionAnalyses.get(0).getPartition();
		CompositePartition owningCompositePartition = firstPartition.getOwningCompositePartition();
		assert owningCompositePartition != null;
		AbstractCompositePartitionAnalysis<?> compositePartitionAnalysis = (AbstractCompositePartitionAnalysis<?>)partitionedTransformationAnalysis.getPartitionAnalysis(owningCompositePartition);
		List<MappingPartition> ownedMappingPartitions = owningCompositePartition.getOwnedMappingPartitions();
		MergedPartitionFactory mergedPartitionFactory = new MergedPartitionFactory(scheduleManager, QVTscheduleUtil.getRegion(firstPartition), mergeablePartitionAnalyses);
		BasicPartitionAnalysis mergedPartitionAnalysis = mergedPartitionFactory.createPartitionAnalysis(partitionedTransformationAnalysis);
		BasicPartition mergedPartition = mergedPartitionAnalysis.getPartition();
		//					MappingRegion mappingRegion = (MappingRegion)regionAnalysis.getRegion();
		//					List<MappingPartition> mappingPartitions = mappingRegion.getMappingPartitions();
		for (@NonNull BasicPartitionAnalysis mergeablePartitionAnalysis : mergeablePartitionAnalyses) {
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
			old2new.put(mergeablePartitionAnalysis, mergedPartitionAnalysis);
		}
		for (int pass : firstPartition.getPasses()) {
			mergedPartition.addPass(pass);
		}
		scheduleManager.writeDebugGraphs(mergedPartition, null);
		ownedMappingPartitions.add(mergedPartition);
		compositePartitionAnalysis.merge(old2new);
		return old2new;
	}
}
