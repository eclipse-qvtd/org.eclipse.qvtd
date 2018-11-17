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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Concurrency;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition;

public class CyclicPartitionAnalysis extends AbstractCompositePartitionAnalysis<CyclicPartition>
{
	public static @NonNull CyclicPartitionAnalysis createCyclicPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis,
			@NonNull String name, @NonNull Set<@NonNull PartitionAnalysis> partitionAnalyses,
			@NonNull Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> partitionAnalysis2predecessors) {

		Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> nestedPartitionAnalysis2predecessors = new HashMap<>();
		Set<@NonNull PartitionAnalysis> externalPredecessors = new HashSet<>();
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalyses) {
			Set<@NonNull PartitionAnalysis> internalPredecessors = new HashSet<>(partitionAnalysis2predecessors.get(partitionAnalysis));
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
	protected final @NonNull Set<@NonNull PartitionAnalysis> externalPredecessors;

	private CyclicPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull CyclicPartition cyclicPartition,
			@NonNull Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> partitionAnalysis2predecessors,
			@NonNull Set<@NonNull PartitionAnalysis> externalPredecessors) {
		super(partitionedTransformationAnalysis, cyclicPartition, partitionAnalysis2predecessors);
		this.externalPredecessors = externalPredecessors;
		partitionedTransformationAnalysis.addPartitionAnalysis(this);
	}

	/**
	 * Return an acyclic schedule for the recursingSteps by ignoring the baseCase/recursingCase partitions that
	 * cause the cycles.
	 * @param recursiveCases
	 */
	protected @NonNull Set<@NonNull PartitionAnalysis> computeBaseRecursingSteps(@NonNull Set<@NonNull PartitionAnalysis> recursingSteps, @NonNull Set<@NonNull PartitionAnalysis> badPredecessors) {
		Set<@NonNull PartitionAnalysis> baseRecursingSteps = new HashSet<>();
		Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> immediatePredecessors = CompilerUtil.computeImmediatePredecessors(recursingSteps);
		for (@NonNull PartitionAnalysis partitionAnalysis : recursingSteps) {
			Set<@NonNull PartitionAnalysis> predecessors = immediatePredecessors.get(partitionAnalysis);
			assert predecessors != null;
			if (!predecessors.removeAll(badPredecessors)) {
				baseRecursingSteps.add(partitionAnalysis);
			}
		}
		return baseRecursingSteps;
	}

	protected @NonNull List<@NonNull Concurrency> computeRecursiveSchedule(@NonNull Set<@NonNull PartitionAnalysis> recursingSteps) {
		Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> immediatePredecessors = CompilerUtil.computeImmediatePredecessors(recursingSteps);
		for (@NonNull PartitionAnalysis partitionAnalysis : recursingSteps) {
			Set<@NonNull PartitionAnalysis> predecessors = immediatePredecessors.get(partitionAnalysis);
			assert predecessors != null;
			predecessors.retainAll(recursingSteps);
		}
		Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> partitionAnalysis2predecessors = CompilerUtil.computeClosure(immediatePredecessors);
		return CompilerUtil.computeParallelSchedule(partitionAnalysis2predecessors);
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
		// The cyclic schedule is therefore {base-cases}, {recursing-steps}... {recursive-cases}
		//
		Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull TraceElementPartitionAnalysis>> partitionAnalysis2acyclicTraceClassAnalyses = new HashMap<>();
		Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull TraceElementPartitionAnalysis>> partitionAnalysis2cyclicTraceClassAnalyses = new HashMap<>();
		Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull TraceElementPartitionAnalysis>> partitionAnalysis2mixedTraceClassAnalyses = new HashMap<>();
		for (@NonNull PartitionAnalysis consumingPartitionAnalysis : partitionAnalyses) {
			assert !externalPredecessors.contains(consumingPartitionAnalysis);
			Iterable<@NonNull TraceClassPartitionAnalysis> consumedTraceClassAnalyses = consumingPartitionAnalysis.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses != null) {
				for (@NonNull TraceClassPartitionAnalysis consumedTraceClassAnalysis : consumedTraceClassAnalyses) {
					Iterable<@NonNull PartitionAnalysis> producingPartitionAnalyses = consumedTraceClassAnalysis.getProducers();
					boolean isExternal = false;
					boolean isInternal = false;
					for (@NonNull PartitionAnalysis producingPartitionAnalysis : producingPartitionAnalyses) {
						if (partitionAnalyses.contains(producingPartitionAnalysis)) {
							isInternal = true;
						}
						else {
							isExternal = true;
						}
					}
					Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull TraceElementPartitionAnalysis>> partitionAnalysis2traceClassAnalyses;
					if (!isInternal) {
						partitionAnalysis2traceClassAnalyses = partitionAnalysis2acyclicTraceClassAnalyses;
					}
					else if (!isExternal) {
						partitionAnalysis2traceClassAnalyses = partitionAnalysis2cyclicTraceClassAnalyses;
					}
					else {
						partitionAnalysis2traceClassAnalyses = partitionAnalysis2mixedTraceClassAnalyses;
					}
					Set<@NonNull TraceElementPartitionAnalysis> traceClassAnalyses = partitionAnalysis2traceClassAnalyses.get(consumingPartitionAnalysis);
					if (traceClassAnalyses == null) {
						traceClassAnalyses = new HashSet<>();
						partitionAnalysis2traceClassAnalyses.put(consumingPartitionAnalysis, traceClassAnalyses);
					}
					traceClassAnalyses.add(consumedTraceClassAnalysis);
				}
			}
			Iterable<@NonNull TracePropertyPartitionAnalysis> consumedTracePropertyAnalyses = consumingPartitionAnalysis.getConsumedTracePropertyAnalyses();
			if (consumedTracePropertyAnalyses != null) {
				for (@NonNull TracePropertyPartitionAnalysis consumedTracePropertyAnalysis : consumedTracePropertyAnalyses) {
					Iterable<@NonNull PartitionAnalysis> producingPartitionAnalyses = consumedTracePropertyAnalysis.getProducers();
					boolean isExternal = false;
					boolean isInternal = false;
					for (@NonNull PartitionAnalysis producingPartitionAnalysis : producingPartitionAnalyses) {
						boolean isInternallyContained = partitionAnalyses.contains(producingPartitionAnalysis);
						boolean isExternallyContained = externalPredecessors.contains(producingPartitionAnalysis);
						//	assert isInternallyContained != isExternallyContained;
						assert !isInternallyContained || !isExternallyContained;		// externalPredecessors does not include cyclic ancestors
						if (isInternallyContained) {
							isInternal = true;
						}
						else {
							isExternal = true;
						}
					}
					Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull TraceElementPartitionAnalysis>> partitionAnalysis2traceClassAnalyses;
					if (!isInternal) {
						partitionAnalysis2traceClassAnalyses = partitionAnalysis2acyclicTraceClassAnalyses;
					}
					else if (!isExternal) {
						partitionAnalysis2traceClassAnalyses = partitionAnalysis2cyclicTraceClassAnalyses;
					}
					else {
						partitionAnalysis2traceClassAnalyses = partitionAnalysis2mixedTraceClassAnalyses;
					}
					Set<@NonNull TraceElementPartitionAnalysis> traceClassAnalyses = partitionAnalysis2traceClassAnalyses.get(consumingPartitionAnalysis);
					if (traceClassAnalyses == null) {
						traceClassAnalyses = new HashSet<>();
						partitionAnalysis2traceClassAnalyses.put(consumingPartitionAnalysis, traceClassAnalyses);
					}
					traceClassAnalyses.add(consumedTracePropertyAnalysis);
				}
			}
		}
		Set<@NonNull PartitionAnalysis> baseCases = new HashSet<>();
		Set<@NonNull PartitionAnalysis> recursiveCases = new HashSet<>();
		Set<@NonNull PartitionAnalysis> recursingSteps = new HashSet<>();
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalyses) {
			Set<@NonNull TraceElementPartitionAnalysis> acyclicTraceClassAnalyses = partitionAnalysis2acyclicTraceClassAnalyses.get(partitionAnalysis);
			Set<@NonNull TraceElementPartitionAnalysis> cyclicTraceClassAnalyses = partitionAnalysis2cyclicTraceClassAnalyses.get(partitionAnalysis);
			Set<@NonNull TraceElementPartitionAnalysis> mixedTraceClassAnalyses = partitionAnalysis2mixedTraceClassAnalyses.get(partitionAnalysis);
			if (mixedTraceClassAnalyses == null) {
				if (cyclicTraceClassAnalyses == null) {
					if (acyclicTraceClassAnalyses == null) {
						assert false; // dead does not occur
					}
					else {
						assert false; // acyclic does not occur
					}
				}
				else {
					recursingSteps.add(partitionAnalysis);
				}
			}
			else {
				if (cyclicTraceClassAnalyses == null) {
					baseCases.add(partitionAnalysis);
				}
				else {
					recursiveCases.add(partitionAnalysis);
				}
			}
		}
		//
		//	Append the baseCases, then the recursingCases in dependency order and finally the recursingCases to the schedule.
		//
		List<@NonNull Concurrency> partitionSchedule = new ArrayList<>();
		appendConcurrency(partitionSchedule, baseCases);		// Maybe empty for recursingSteps-only cycles

		Set<@NonNull PartitionAnalysis> residualSteps = null;
		if (recursingSteps.size() > 0) {
			Set<@NonNull PartitionAnalysis> baseRecursingSteps = computeBaseRecursingSteps(recursingSteps, recursiveCases);
			residualSteps = new HashSet<>(recursingSteps);
			if (baseRecursingSteps.size() > 0) {
				residualSteps.removeAll(baseRecursingSteps);
				if (baseRecursingSteps.size() <= 1) {
					appendConcurrency(partitionSchedule, baseRecursingSteps);
				}
				else {
					List<@NonNull Concurrency> baseRecursiveSchedule = computeRecursiveSchedule(baseRecursingSteps);
					for (@NonNull Iterable<@NonNull PartitionAnalysis> concurrency : baseRecursiveSchedule) {
						appendConcurrency(partitionSchedule, concurrency);
					}
				}
			}
		}
		appendConcurrency(partitionSchedule, recursiveCases);	// Maybe empty for recursingSteps-only cycles
		if ((residualSteps != null) && !residualSteps.isEmpty()) {
			List<@NonNull Concurrency> residualSchedule = computeRecursiveSchedule(residualSteps);
			for (@NonNull Iterable<@NonNull PartitionAnalysis> concurrency : residualSchedule) {
				appendConcurrency(partitionSchedule, concurrency);
			}
		}
		partitionSchedule.get(0).setCycleStart();
		partitionSchedule.get(partitionSchedule.size()-1).setCycleEnd();
		return partitionSchedule;
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getConsumedTraceClassAnalyses() {
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getConsumedTracePropertyAnalyses() {
		return null;
	}

	@Override
	public @NonNull Set<@NonNull PartitionAnalysis> getExplicitPredecessors() {
		return externalPredecessors;
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getProducedTraceClassAnalyses() {
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getProducedTracePropertyAnalyses() {
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getSuperProducedTraceClassAnalyses() {
		return null;
	}
}