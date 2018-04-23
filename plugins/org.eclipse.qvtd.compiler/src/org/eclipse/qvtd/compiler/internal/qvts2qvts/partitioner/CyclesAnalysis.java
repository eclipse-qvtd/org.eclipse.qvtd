/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * The CyclesAnalysis identifies a CycleAnalysis for each group of mappingPartitioners that contribute to a cycle.
 */
public class CyclesAnalysis
{
	protected final @NonNull TransformationPartitioner transformationPartitioner;
	protected final @NonNull Iterable<@NonNull MappingPartitioner> mappingPartitioners;

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each mapping partitioner.
	 */
	protected final @NonNull Map<@NonNull MappingPartitioner, @NonNull CycleAnalysis> mappingPartitioner2cycleAnalysis = new HashMap<>();

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each trace class analysis.
	 */
	protected final @NonNull Map<@NonNull TraceClassAnalysis, @NonNull CycleAnalysis> traceClassAnalysis2cycleAnalysis = new HashMap<>();

	public CyclesAnalysis(@NonNull TransformationPartitioner transformationPartitioner, @NonNull Iterable<@NonNull MappingPartitioner> mappingPartitioners) {
		this.transformationPartitioner = transformationPartitioner;
		this.mappingPartitioners = mappingPartitioners;
	}

	/**
	 * Return a map of the MappingPartitioners that form a cycle including each MappingPartitioner.
	 *
	 * NB cycles may involve trace classes and their trace class properties.
	 */
	public void analyze() {
		Iterable<@NonNull Set<@NonNull MappingPartitioner>> prunedCycleElements = computeCycleElementSets();
		//
		/*		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			Set<@NonNull MappingPartitioner> newCycleElements = new HashSet<>(partitioner2predecessors.get(mappingPartitioner));
			newCycleElements.retainAll(partitioner2successors.get(mappingPartitioner));
			if (!newCycleElements.isEmpty() && !allCycleElements.contains(newCycleElements)) {
				List<@NonNull Set<@NonNull MappingPartitioner>> redundantCycleElements = null;
				for (@NonNull Set<@NonNull MappingPartitioner> oldCycleElements : allCycleElements) {
					if (QVTbaseUtil.containsAny(oldCycleElements, newCycleElements)) {
						if (redundantCycleElements == null) {
							redundantCycleElements = new ArrayList<>();
						}
						redundantCycleElements.add(oldCycleElements);
						newCycleElements.addAll(oldCycleElements);
					}
				}
				if (redundantCycleElements != null) {
					allCycleElements.removeAll(redundantCycleElements);
				}
				allCycleElements.add(newCycleElements);
			}
		} */
		//
		if (prunedCycleElements != null) {
			createCycleAnalyses(prunedCycleElements);
		}
	}

	protected @Nullable Iterable<@NonNull Set<@NonNull MappingPartitioner>> computeCycleElementSets() {
		Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> partitioner2predecessors = computeTransitivePredecessors();
		Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> partitioner2successors = computeTransitiveSuccessors();
		Set<@NonNull Set<@NonNull MappingPartitioner>> allCycleElements = new HashSet<>();
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			Set<@NonNull MappingPartitioner> newCycleElements = new HashSet<>(partitioner2predecessors.get(mappingPartitioner));
			newCycleElements.retainAll(partitioner2successors.get(mappingPartitioner));
			if (!newCycleElements.isEmpty()) {
				allCycleElements.add(newCycleElements);
			}
		}
		//
		List<@NonNull Set<@NonNull MappingPartitioner>> prunedCycleElements = new ArrayList<>(allCycleElements);
		for (int i = prunedCycleElements.size(); --i >= 0; ) {
			Set<@NonNull MappingPartitioner> iCycleElements = prunedCycleElements.get(i);
			boolean pruneIt = false;
			for (int j = i; --j >= 0; ) {
				Set<@NonNull MappingPartitioner> jCycleElements = prunedCycleElements.get(j);
				if (QVTbaseUtil.containsAny(jCycleElements, iCycleElements) && jCycleElements.addAll(iCycleElements)) {
					pruneIt = true;
				}
			}
			if (pruneIt) {
				prunedCycleElements.remove(i);
			}
		}
		return prunedCycleElements.isEmpty() ? null : prunedCycleElements;
	}

	/**
	 * Return a map of the MappingPartitioners that may execute before each MappingPartitioner.
	 */
	protected @NonNull Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> computeTransitivePredecessors() {
		Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> consumer2producers = new HashMap<>();
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			consumer2producers.put(mappingPartitioner, new HashSet<>());
		}
		for (@NonNull MappingPartitioner consumer : mappingPartitioners) {
			Iterable<@NonNull TraceClassAnalysis> consumedTraceClassAnalyses = consumer.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses != null) {
				for (@NonNull TraceClassAnalysis consumedTraceClassAnalysis : consumedTraceClassAnalyses) {
					for (@NonNull TraceClassAnalysis subConsumedTraceClass : consumedTraceClassAnalysis.getSubTraceClassAnalyses()) {
						for (@NonNull MappingPartitioner producer : subConsumedTraceClass.getProducers()) {
							Set<@NonNull MappingPartitioner> producers = consumer2producers.get(consumer);
							assert producers != null;
							producers.add(producer);
						}
					}
				}
			}
		}
		if (TransformationPartitioner.PREDECESSORS.isActive()) {
			for (@NonNull MappingPartitioner successor : mappingPartitioners) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull MappingPartitioner> producers = new ArrayList<>(consumer2producers.get(successor));
				Collections.sort(producers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull MappingPartitioner producer : producers) {
					s.append(" " + producer);
				}
				TransformationPartitioner.PREDECESSORS.println(s.toString());
			}
		}
		Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> consumer2producersClosure = CompilerUtil.computeClosure(consumer2producers);
		if (TransformationPartitioner.PREDECESSORS.isActive()) {
			for (@NonNull MappingPartitioner successor : mappingPartitioners) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull MappingPartitioner> producers = new ArrayList<>(consumer2producersClosure.get(successor));
				Collections.sort(producers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull MappingPartitioner producer : producers) {
					s.append(" " + producer);
				}
				TransformationPartitioner.PREDECESSORS.println(s.toString());
			}
		}
		return consumer2producersClosure;
	}

	/**
	 * Return a map of the MappingPartitioners that may execute after each MappingPartitioner.
	 */
	protected @NonNull Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> computeTransitiveSuccessors() {
		Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> producer2consumers = new HashMap<>();
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			producer2consumers.put(mappingPartitioner, new HashSet<>());
		}
		for (@NonNull MappingPartitioner producer : mappingPartitioners) {
			Iterable<@NonNull TraceClassAnalysis> producedTraceClassAnalyses = producer.getProducedTraceClassAnalyses();
			if (producedTraceClassAnalyses != null) {
				for (@NonNull TraceClassAnalysis producedTraceClassAnalysis : producedTraceClassAnalyses) {
					for (@NonNull TraceClassAnalysis superProducedTraceClassAnalysis : producedTraceClassAnalysis.getSuperTraceClassAnalyses()) {
						for (@NonNull MappingPartitioner consumer : superProducedTraceClassAnalysis.getConsumers()) {
							Set<@NonNull MappingPartitioner> consumers = producer2consumers.get(producer);
							assert consumers != null;
							consumers.add(consumer);
						}
					}
				}
			}
		}
		if (TransformationPartitioner.SUCCESSORS.isActive()) {
			for (@NonNull MappingPartitioner successor : mappingPartitioners) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull MappingPartitioner> consumers = new ArrayList<>(producer2consumers.get(successor));
				Collections.sort(consumers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull MappingPartitioner consumer : consumers) {
					s.append(" " + consumer);
				}
				TransformationPartitioner.SUCCESSORS.println(s.toString());
			}
		}
		Map<@NonNull MappingPartitioner, @NonNull Set<@NonNull MappingPartitioner>> producer2consumersClosure = CompilerUtil.computeClosure(producer2consumers);
		if (TransformationPartitioner.SUCCESSORS.isActive()) {
			for (@NonNull MappingPartitioner predecessor : mappingPartitioners) {
				StringBuilder s = new StringBuilder();
				s.append(predecessor + ":");
				List<@NonNull MappingPartitioner> consumers = new ArrayList<>(producer2consumersClosure.get(predecessor));
				Collections.sort(consumers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull MappingPartitioner consumer : consumers) {
					s.append(" " + consumer);
				}
				TransformationPartitioner.SUCCESSORS.println(s.toString());
			}
		}
		return producer2consumersClosure;
	}


	protected void createCycleAnalyses(@NonNull Iterable<@NonNull Set<@NonNull MappingPartitioner>> cycleElementSets) {
		List<@NonNull CycleAnalysis> cycleAnalyses = new ArrayList<>();
		for (@NonNull Set<@NonNull MappingPartitioner> cycleElements : cycleElementSets) {
			CycleAnalysis cycleAnalysis = createCycleAnalysis(cycleElements);
			cycleAnalyses.add(cycleAnalysis);
		}
		if (TransformationPartitioner.CYCLES.isActive()) {
			if (cycleAnalyses.isEmpty()) {
				TransformationPartitioner.CYCLES.println("No cycles");
			}
			else {
				for (@NonNull CycleAnalysis cycleAnalysis : cycleAnalyses) {
					StringBuilder s = new StringBuilder();
					s.append("\n  MappingPartitioners:");
					List<@NonNull MappingPartitioner> mappingPartitioners2 = Lists.newArrayList(cycleAnalysis.getMappingPartitioners());
					Collections.sort(mappingPartitioners2, NameUtil.NAMEABLE_COMPARATOR);
					for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners2) {
						s.append("\n\t" + mappingPartitioner);
					}
					s.append("\n  TraceClassAnalyses:");
					List<@NonNull TraceClassAnalysis> traceClassAnalyses = Lists.newArrayList(cycleAnalysis.getTraceClassAnalyses());
					Collections.sort(traceClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
					for (@NonNull TraceClassAnalysis traceClassAnalysis : traceClassAnalyses) {
						s.append("\n\t" + traceClassAnalysis);
					}
					TransformationPartitioner.CYCLES.println(s.toString());
				}
			}
		}
	}

	protected @NonNull CycleAnalysis createCycleAnalysis(@NonNull Set<@NonNull MappingPartitioner> cyclicMappingPartitioners) {
		Set<@NonNull TraceClassAnalysis> consumedTraceClassAnalyses = new HashSet<>();
		Set<@NonNull TraceClassAnalysis> superProducedTraceClassAnalyses = new HashSet<>();
		for (@NonNull MappingPartitioner cyclicMappingPartitioner : cyclicMappingPartitioners) {
			Iterables.addAll(consumedTraceClassAnalyses, cyclicMappingPartitioner.getConsumedTraceClassAnalyses());
			Iterables.addAll(superProducedTraceClassAnalyses, cyclicMappingPartitioner.getSuperProducedTraceClassAnalyses());
		}
		Set<@NonNull TraceClassAnalysis> cyclicTraceClassAnalyses = new HashSet<>(consumedTraceClassAnalyses);
		cyclicTraceClassAnalyses.retainAll(superProducedTraceClassAnalyses);
		CycleAnalysis cycleAnalysis = new CycleAnalysis(this, cyclicMappingPartitioners, cyclicTraceClassAnalyses);
		for (@NonNull MappingPartitioner cyclicMappingPartitioner : cyclicMappingPartitioners) {
			CycleAnalysis oldCycleAnalysis = mappingPartitioner2cycleAnalysis.put(cyclicMappingPartitioner, cycleAnalysis);
			assert oldCycleAnalysis == null;
		}
		for (@NonNull TraceClassAnalysis cyclicTraceClassAnalysis : cyclicTraceClassAnalyses) {
			CycleAnalysis oldCycleAnalysis = traceClassAnalysis2cycleAnalysis.put(cyclicTraceClassAnalysis, cycleAnalysis);
			assert oldCycleAnalysis == null;
		}
		return cycleAnalysis;
	}

	public @Nullable CycleAnalysis getCycleAnalysis(@NonNull MappingPartitioner mappingPartitioner) {
		return mappingPartitioner2cycleAnalysis.get(mappingPartitioner);
	}

	public @Nullable CycleAnalysis getCycleAnalysis(@NonNull TraceClassAnalysis traceClassAnalysis) {
		return traceClassAnalysis2cycleAnalysis.get(traceClassAnalysis);
	}

	public @NonNull TransformationPartitioner getTransformationPartitioner() {
		return transformationPartitioner;
	}
}
