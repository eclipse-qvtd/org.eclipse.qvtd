/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Concurrency;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionPropertyAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Sets;

public class CyclicPartitionAnalysis extends AbstractCompositePartitionAnalysis<@NonNull CyclicPartition>
{
	public static @NonNull CyclicPartitionAnalysis createCyclicPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis,
			@NonNull String name, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> partitionAnalyses,
			@NonNull Map<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> partitionAnalysis2predecessors) {

		Map<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> nestedPartitionAnalysis2predecessors = new HashMap<>();
		Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> externalPredecessors = new HashSet<>();
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : partitionAnalyses) {
			Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> internalPredecessors = new HashSet<>(partitionAnalysis2predecessors.get(partitionAnalysis));
			externalPredecessors.addAll(internalPredecessors);
			internalPredecessors.remove(partitionAnalysis);
			internalPredecessors.retainAll(partitionAnalyses);
			nestedPartitionAnalysis2predecessors.put(partitionAnalysis, internalPredecessors);
		}
		externalPredecessors.removeAll(partitionAnalyses);
		assert !partitionAnalyses.isEmpty();


		ScheduleManager scheduleManager = partitionedTransformationAnalysis.getScheduleManager();
		CyclicPartition cyclicPartition = RegionHelper.createCyclicPartition(name, scheduleManager);
		return new CyclicPartitionAnalysis(partitionedTransformationAnalysis, cyclicPartition, nestedPartitionAnalysis2predecessors, externalPredecessors);
	}

	/**
	 * The predecessors of the cyclic partition outside the cyclic partition.
	 */
	protected final @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> externalPredecessors;

	private CyclicPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull CyclicPartition cyclicPartition,
			@NonNull Map<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> partitionAnalysis2predecessors,
			@NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> externalPredecessors) {
		super(partitionedTransformationAnalysis, cyclicPartition, partitionAnalysis2predecessors);
		this.externalPredecessors = externalPredecessors;
		partitionedTransformationAnalysis.addPartitionAnalysis(this);


		// FIXME WIP
		Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> cyclicPartitionAnalyses = partitionAnalysis2predecessors.keySet();
		Set<@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis>> containmentPropertyPartitionAnalyses = new HashSet<>();
		Set<@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis>> containerPropertyPartitionAnalyses = new HashSet<>();
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> consumer : cyclicPartitionAnalyses) {
			Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis>> consumedPropertyAnalyses = consumer.getConsumedPropertyAnalyses();
			if (consumedPropertyAnalyses != null) {
				for (@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis> consumedPropertyAnalysis : consumedPropertyAnalyses) {
					PropertyDatum propertyDatum = consumedPropertyAnalysis.getPropertyDatum();
					Property consumedProperty = propertyDatum.getReferredProperty();
					boolean isContainment = consumedProperty.isIsComposite();
					Property consumedOppositeProperty = consumedProperty.getOpposite();
					boolean isContainer = (consumedOppositeProperty != null) && consumedOppositeProperty.isIsComposite();
					if (isContainment || isContainer) {
						for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> producer : consumedPropertyAnalysis.getCompatibleProducers()) {
							if (cyclicPartitionAnalyses.contains(producer)) {
								Partition producingPartition = producer.getPartition();
								for (@NonNull Edge edge : producingPartition.getPartialEdges()) {
									Node targetNode = QVTscheduleUtil.getTargetNode(edge);
									if (targetNode.isRealized() && edge.isRealized() && edge.isNavigation()) {
										NavigableEdge navigableEdge = (NavigableEdge)edge;
										if (navigableEdge.getProperty() == consumedProperty) {
											if (isContainment) {
												containmentPropertyPartitionAnalyses.add(consumedPropertyAnalysis);
											}
											if (isContainer) {
												containerPropertyPartitionAnalyses.add(consumedPropertyAnalysis);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		TransformationPartitioner.CONTAINMENT.println("Containment: " + containmentPropertyPartitionAnalyses);
		TransformationPartitioner.CONTAINMENT.println("Container: " + containerPropertyPartitionAnalyses);
	}

	/**
	 * Return an acyclic schedule for the recursingSteps by ignoring the baseCase/recursingCase partitions that
	 * cause the cycles.
	 * @param recursiveCases
	 */
	protected @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> computeBaseRecursingSteps(@NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> recursingSteps) {
		Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> baseRecursingSteps = new HashSet<>();
		Map<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> immediatePredecessors = CompilerUtil.computeImmediatePredecessors(recursingSteps, TransformationPartitioner.CYCLE_SCHEDULE_PREDECESSORS);
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : recursingSteps) {
			Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> predecessors = immediatePredecessors.get(partitionAnalysis);
			assert predecessors != null;
			baseRecursingSteps.add(partitionAnalysis);
		}
		return baseRecursingSteps;
	}

	protected @NonNull List<@NonNull Concurrency> computeRecursiveSchedule(@NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> recursingSteps) {
		Map<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> immediatePredecessors = CompilerUtil.computeImmediatePredecessors(recursingSteps, TransformationPartitioner.CYCLE_SCHEDULE_PREDECESSORS);
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : recursingSteps) {
			Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> predecessors = immediatePredecessors.get(partitionAnalysis);
			assert predecessors != null;
			predecessors.retainAll(recursingSteps);
		}
		Map<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> partitionAnalysis2predecessors = CompilerUtil.computeClosure(immediatePredecessors);
		return CompilerUtil.computeParallelSchedule(partitionAnalysis2predecessors, TransformationPartitioner.CYCLE_SCHEDULE_PREDECESSORS);
	}

	@Override
	protected @NonNull List<@NonNull Concurrency> createPartitionSchedule() {
		assert partitionAnalyses.equals(originalPartitionAnalysis2predecessors.keySet());
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
		// The cyclic schedule is therefore {basic-cases}, {recursing-steps}... {recursive-cases}
		//
		Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> externalPartitionAnalyses = new HashSet<>();
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> consumingPartitionAnalysis : partitionAnalyses) {
			assert !externalPredecessors.contains(consumingPartitionAnalysis);
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> consumedClassAnalyses = consumingPartitionAnalysis.getConsumedClassAnalyses();
			if (consumedClassAnalyses != null) {
				for (@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> consumedClassAnalysis : consumedClassAnalyses) {
					for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> producingPartitionAnalysis : consumedClassAnalysis.getCompatibleProducers()) {
						if (!partitionAnalyses.contains(producingPartitionAnalysis)) {
							externalPartitionAnalyses.add(consumingPartitionAnalysis);
						}
					}
				}
			}
			Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis>> consumedPropertyAnalyses = consumingPartitionAnalysis.getConsumedPropertyAnalyses();
			if (consumedPropertyAnalyses != null) {
				for (@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis> consumedPropertyAnalysis : consumedPropertyAnalyses) {
					for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> producingPartitionAnalysis : consumedPropertyAnalysis.getCompatibleProducers()) {
						if (!partitionAnalyses.contains(producingPartitionAnalysis)) {
							externalPartitionAnalyses.add(consumingPartitionAnalysis);
						}
					}
				}
			}
		}
		Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> basicCases = new HashSet<>();
		Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> recursingSteps = new HashSet<>();
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : partitionAnalyses) {
			Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> rawExplicitPredecessors = partitionAnalysis.getExplicitPredecessors();
			Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> explicitPredecessors = null;
			if (rawExplicitPredecessors != null) {
				explicitPredecessors = Sets.newHashSet(rawExplicitPredecessors);
				explicitPredecessors.retainAll(partitionAnalyses);
				if (explicitPredecessors.isEmpty()) {
					explicitPredecessors = null;
				}
			}
			if (explicitPredecessors != null) {			// an explicit predecessor in the loop
				recursingSteps.add(partitionAnalysis);	//  forces something else first
			}
			else if (externalPartitionAnalyses.contains(partitionAnalysis)) {
				basicCases.add(partitionAnalysis);
			}
			else {
				recursingSteps.add(partitionAnalysis);
			}
		}
		//
		//	Append the basicCases, then the recursingSteps in dependency order.
		//
		List<@NonNull Concurrency> partitionSchedule = new ArrayList<>();
		appendConcurrency(partitionSchedule, basicCases);		// Maybe empty for recursingSteps-only cycles

		Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> residualSteps = null;
		if (recursingSteps.size() > 0) {
			Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> baseRecursingSteps = computeBaseRecursingSteps(recursingSteps);
			residualSteps = new HashSet<>(recursingSteps);
			if (baseRecursingSteps.size() > 0) {
				residualSteps.removeAll(baseRecursingSteps);
				if (baseRecursingSteps.size() <= 1) {
					appendConcurrency(partitionSchedule, baseRecursingSteps);
				}
				else {
					List<@NonNull Concurrency> baseRecursiveSchedule = computeRecursiveSchedule(baseRecursingSteps);
					for (@NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> concurrency : baseRecursiveSchedule) {
						appendConcurrency(partitionSchedule, concurrency);
					}
				}
			}
		}
		if ((residualSteps != null) && !residualSteps.isEmpty()) {
			List<@NonNull Concurrency> residualSchedule = computeRecursiveSchedule(residualSteps);
			for (@NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> concurrency : residualSchedule) {
				appendConcurrency(partitionSchedule, concurrency);
			}
		}
		partitionSchedule.get(0).setCycleStart();
		partitionSchedule.get(partitionSchedule.size()-1).setCycleEnd();
		if (TransformationPartitioner.CYCLE_SCHEDULE.isActive()) {
			CompilerUtil.traceSchedule(TransformationPartitioner.CYCLE_SCHEDULE, getName(), partitionSchedule);
		}
		return partitionSchedule;
	}

	@Override
	public @Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> getConsumedClassAnalyses() {
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis>> getConsumedPropertyAnalyses() {
		return null;
	}

	@Override
	public @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> getExplicitPredecessors() {
		return externalPredecessors;
	}

	@Override
	public @Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> getProducedClassAnalyses() {
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis>> getProducedPropertyAnalyses() {
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> getSuperProducedClassAnalyses() {
		return null;
	}
}