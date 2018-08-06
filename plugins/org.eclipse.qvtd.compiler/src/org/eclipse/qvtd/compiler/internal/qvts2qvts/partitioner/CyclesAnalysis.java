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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * The CyclesAnalysis identifies a CycleAnalysis for each group of regionAnalyses that contribute to a cycle.
 */
public abstract class CyclesAnalysis<RA extends RegionAnalysis>
{
	protected final @NonNull TransformationAnalysis transformationAnalysis;
	protected final @NonNull Iterable<@NonNull RA> regionAnalyses;

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each mapping partitioner.
	 */
	protected final @NonNull Map<@NonNull RA, @NonNull CycleAnalysis<@NonNull RA>> regionAnalysis2cycleAnalysis = new HashMap<>();

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each trace class analysis.
	 */
	protected final @NonNull Map<@NonNull TraceClassAnalysis<@NonNull RA>, @NonNull CycleAnalysis<@NonNull RA>> traceClassAnalysis2cycleAnalysis = new HashMap<>();

	protected CyclesAnalysis(@NonNull TransformationAnalysis transformationAnalysis, @NonNull Iterable<@NonNull RA> regionAnalyses) {
		this.transformationAnalysis = transformationAnalysis;
		this.regionAnalyses = regionAnalyses;
	}

	/**
	 * Return a map of the RegionAnalyses that form a cycle including each RA.
	 *
	 * NB cycles may involve trace classes and their trace class properties.
	 */
	public void analyze() {
		Iterable<@NonNull Set<@NonNull RA>> prunedCycleElements = computeCycleElementSets();
		//
		/*		for (@NonNull RA regionAnalysis : regionAnalyses) {
			Set<@NonNull RA> newCycleElements = new HashSet<>(partitioner2predecessors.get(regionAnalysis));
			newCycleElements.retainAll(partitioner2successors.get(regionAnalysis));
			if (!newCycleElements.isEmpty() && !allCycleElements.contains(newCycleElements)) {
				List<@NonNull Set<@NonNull RA>> redundantCycleElements = null;
				for (@NonNull Set<@NonNull RA> oldCycleElements : allCycleElements) {
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

	protected @Nullable Iterable<@NonNull Set<@NonNull RA>> computeCycleElementSets() {
		Map<@NonNull RA, @NonNull Set<@NonNull RA>> partitioner2predecessors = computeTransitivePredecessors();
		Map<@NonNull RA, @NonNull Set<@NonNull RA>> partitioner2successors = computeTransitiveSuccessors();
		Set<@NonNull Set<@NonNull RA>> allCycleElements = new HashSet<>();
		for (@NonNull RA regionAnalysis : regionAnalyses) {
			Set<@NonNull RA> newCycleElements = new HashSet<>(partitioner2predecessors.get(regionAnalysis));
			newCycleElements.retainAll(partitioner2successors.get(regionAnalysis));
			if (!newCycleElements.isEmpty()) {
				allCycleElements.add(newCycleElements);
			}
		}
		//
		List<@NonNull Set<@NonNull RA>> prunedCycleElements = new ArrayList<>(allCycleElements);
		for (int i = prunedCycleElements.size(); --i >= 0; ) {
			Set<@NonNull RA> iCycleElements = prunedCycleElements.get(i);
			boolean pruneIt = false;
			for (int j = i; --j >= 0; ) {
				Set<@NonNull RA> jCycleElements = prunedCycleElements.get(j);
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
	 * Return a map of the RegionAnalyses that may execute before each RA.
	 */
	protected @NonNull Map<@NonNull RA, @NonNull Set<@NonNull RA>> computeTransitivePredecessors() {
		Map<@NonNull RA, @NonNull Set<@NonNull RA>> consumer2producers = new HashMap<>();
		for (@NonNull RA regionAnalysis : regionAnalyses) {
			consumer2producers.put(regionAnalysis, new HashSet<>());
		}
		for (@NonNull RA consumer : regionAnalyses) {
			@SuppressWarnings("unchecked")
			Iterable<@NonNull ? extends TraceClassAnalysis<@NonNull RA>> consumedTraceClassAnalyses = (Iterable<@NonNull ? extends TraceClassAnalysis<@NonNull RA>>)(Object)consumer.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses != null) {
				for (@NonNull TraceClassAnalysis<@NonNull RA> consumedTraceClassAnalysis : consumedTraceClassAnalyses) {
					for (@NonNull TraceClassAnalysis<@NonNull RA> subConsumedTraceClass : consumedTraceClassAnalysis.getSubTraceClassAnalyses()) {
						for (@NonNull RA producer : subConsumedTraceClass.getProducers()) {
							Set<@NonNull RA> producers = consumer2producers.get(consumer);
							assert producers != null;
							producers.add(producer);
						}
					}
				}
			}
			@SuppressWarnings("unchecked")
			Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> consumedTracePropertyAnalyses = (Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>>)(Object)consumer.getConsumedTracePropertyAnalyses();
			if (consumedTracePropertyAnalyses != null) {
				for (@NonNull TracePropertyAnalysis<@NonNull RA> consumedTracePropertyAnalysis : consumedTracePropertyAnalyses) {
					for (@NonNull RA producer : consumedTracePropertyAnalysis.getProducers()) {
						Set<@NonNull RA> producers = consumer2producers.get(consumer);
						assert producers != null;
						producers.add(producer);
					}
				}
			}
		}
		if (TransformationPartitioner.PREDECESSORS.isActive()) {
			for (@NonNull RA successor : regionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull RA> producers = new ArrayList<>(consumer2producers.get(successor));
				Collections.sort(producers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull RA producer : producers) {
					s.append(" " + producer);
				}
				TransformationPartitioner.PREDECESSORS.println(s.toString());
			}
		}
		Map<@NonNull RA, @NonNull Set<@NonNull RA>> consumer2producersClosure = CompilerUtil.computeClosure(consumer2producers);
		if (TransformationPartitioner.PREDECESSORS.isActive()) {
			for (@NonNull RA successor : regionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull RA> producers = new ArrayList<>(consumer2producersClosure.get(successor));
				Collections.sort(producers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull RA producer : producers) {
					s.append(" " + producer);
				}
				TransformationPartitioner.PREDECESSORS.println(s.toString());
			}
		}
		return consumer2producersClosure;
	}

	/**
	 * Return a map of the RegionAnalyses that may execute after each RA.
	 */
	protected @NonNull Map<@NonNull RA, @NonNull Set<@NonNull RA>> computeTransitiveSuccessors() {
		Map<@NonNull RA, @NonNull Set<@NonNull RA>> producer2consumers = new HashMap<>();
		for (@NonNull RA regionAnalysis : regionAnalyses) {
			producer2consumers.put(regionAnalysis, new HashSet<>());
		}
		for (@NonNull RA producer : regionAnalyses) {
			@SuppressWarnings("unchecked")
			Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> producedTraceClassAnalyses = (Iterable<@NonNull TraceClassAnalysis<@NonNull RA>>)(Object)producer.getProducedTraceClassAnalyses();
			if (producedTraceClassAnalyses != null) {
				for (@NonNull TraceClassAnalysis<@NonNull RA> producedTraceClassAnalysis : producedTraceClassAnalyses) {
					for (@NonNull TraceClassAnalysis<@NonNull RA> superProducedTraceClassAnalysis : producedTraceClassAnalysis.getSuperTraceClassAnalyses()) {
						for (@NonNull RA consumer : superProducedTraceClassAnalysis.getConsumers()) {
							Set<@NonNull RA> consumers = producer2consumers.get(producer);
							assert consumers != null;
							consumers.add(consumer);
						}
					}
				}
			}
			@SuppressWarnings("unchecked")
			Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> producedTracePropertyAnalyses = (Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>>)(Object)producer.getProducedTracePropertyAnalyses();
			if (producedTracePropertyAnalyses != null) {
				for (@NonNull TracePropertyAnalysis<@NonNull RA> producedTracePropertyAnalysis : producedTracePropertyAnalyses) {
					for (@NonNull RA consumer : producedTracePropertyAnalysis.getConsumers()) {
						Set<@NonNull RA> consumers = producer2consumers.get(producer);
						assert consumers != null;
						consumers.add(consumer);
					}
				}
			}
		}
		if (TransformationPartitioner.SUCCESSORS.isActive()) {
			for (@NonNull RA successor : regionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull RA> consumers = new ArrayList<>(producer2consumers.get(successor));
				Collections.sort(consumers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull RA consumer : consumers) {
					s.append(" " + consumer);
				}
				TransformationPartitioner.SUCCESSORS.println(s.toString());
			}
		}
		Map<@NonNull RA, @NonNull Set<@NonNull RA>> producer2consumersClosure = CompilerUtil.computeClosure(producer2consumers);
		if (TransformationPartitioner.SUCCESSORS.isActive()) {
			for (@NonNull RegionAnalysis predecessor : regionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append(predecessor + ":");
				List<@NonNull RegionAnalysis> consumers = new ArrayList<>(producer2consumersClosure.get(predecessor));
				Collections.sort(consumers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull RegionAnalysis consumer : consumers) {
					s.append(" " + consumer);
				}
				TransformationPartitioner.SUCCESSORS.println(s.toString());
			}
		}
		return producer2consumersClosure;
	}


	protected void createCycleAnalyses(@NonNull Iterable<@NonNull Set<@NonNull RA>> cycleElementSets) {
		List<@NonNull CycleAnalysis<@NonNull RA>> cycleAnalyses = new ArrayList<>();
		for (@NonNull Set<@NonNull RA> cycleElements : cycleElementSets) {
			CycleAnalysis<@NonNull RA> cycleAnalysis = createCycleAnalysis(cycleElements);
			cycleAnalyses.add(cycleAnalysis);
		}
		if (TransformationPartitioner.CYCLES.isActive()) {
			if (cycleAnalyses.isEmpty()) {
				TransformationPartitioner.CYCLES.println("No cycles");
			}
			else {
				for (@NonNull CycleAnalysis<@NonNull RA> cycleAnalysis : cycleAnalyses) {
					StringBuilder s = new StringBuilder();
					s.append("\n  RegionAnalyses:");
					List<@NonNull RA> regionAnalyses2 = Lists.newArrayList(cycleAnalysis.getRegionAnalyses());
					Collections.sort(regionAnalyses2, NameUtil.NAMEABLE_COMPARATOR);
					for (@NonNull RA regionAnalysis : regionAnalyses2) {
						s.append("\n\t" + regionAnalysis);
						Iterable<@NonNull ? extends TraceClassAnalysis<@NonNull RegionAnalysis>> consumedTraceClassAnalyses = regionAnalysis.getConsumedTraceClassAnalyses();
						if (consumedTraceClassAnalyses != null) {
							for (@NonNull TraceClassAnalysis<@NonNull RegionAnalysis> traceClassAnalysis : consumedTraceClassAnalyses) {
								s.append("\n\t  =>" + traceClassAnalysis);
							}
						}
						Iterable<@NonNull ? extends TraceClassAnalysis<@NonNull RegionAnalysis>> producedTraceClassAnalyses = regionAnalysis.getProducedTraceClassAnalyses();
						if (producedTraceClassAnalyses != null) {
							for (@NonNull TraceClassAnalysis<@NonNull RegionAnalysis> traceClassAnalysis : producedTraceClassAnalyses) {
								s.append("\n\t  <=" + traceClassAnalysis);
							}
						}
						Iterable<@NonNull ? extends TracePropertyAnalysis<@NonNull RegionAnalysis>> consumedTracePropertyAnalyses = regionAnalysis.getConsumedTracePropertyAnalyses();
						if (consumedTracePropertyAnalyses != null) {
							for (@NonNull TracePropertyAnalysis<@NonNull RegionAnalysis> tracePropertyAnalysis : consumedTracePropertyAnalyses) {
								s.append("\n\t  =>" + tracePropertyAnalysis);
							}
						}
						Iterable<@NonNull ? extends TracePropertyAnalysis<@NonNull RegionAnalysis>> producedTracePropertyAnalyses = regionAnalysis.getProducedTracePropertyAnalyses();
						if (producedTracePropertyAnalyses != null) {
							for (@NonNull TracePropertyAnalysis<@NonNull RegionAnalysis> tracePropertyAnalysis : producedTracePropertyAnalyses) {
								s.append("\n\t  <=" + tracePropertyAnalysis);
							}
						}
					}
					s.append("\n  TraceClassAnalyses:");
					List<@NonNull TraceClassAnalysis<@NonNull RA>> traceClassAnalyses = Lists.newArrayList(cycleAnalysis.getTraceClassAnalyses());
					Collections.sort(traceClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
					for (@NonNull TraceClassAnalysis<@NonNull RA> traceClassAnalysis : traceClassAnalyses) {
						s.append("\n\t" + traceClassAnalysis);
					}
					s.append("\n  TracePropertyAnalyses:");
					List<@NonNull TracePropertyAnalysis<@NonNull RA>> tracePropertyAnalyses = Lists.newArrayList(cycleAnalysis.getTracePropertyAnalyses());
					Collections.sort(tracePropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
					for (@NonNull TracePropertyAnalysis<@NonNull RA> tracePropertyAnalysis : tracePropertyAnalyses) {
						s.append("\n\t" + tracePropertyAnalysis);
					}
					TransformationPartitioner.CYCLES.println(s.toString());
				}
			}
		}
	}

	protected @NonNull CycleAnalysis<@NonNull RA> createCycleAnalysis(@NonNull Set<@NonNull RA> cyclicRegionAnalyses) {
		Set<@NonNull TraceClassAnalysis<@NonNull RA>> consumedTraceClassAnalyses = new HashSet<>();
		Set<@NonNull TraceClassAnalysis<@NonNull RA>> superProducedTraceClassAnalyses = new HashSet<>();
		Set<@NonNull TracePropertyAnalysis<@NonNull RA>> consumedTracePropertyAnalyses = new HashSet<>();
		for (@NonNull RA cyclicRegionAnalysis : cyclicRegionAnalyses) {
			@SuppressWarnings("unchecked")
			Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> consumedTraceClassAnalyses2 = (Iterable<@NonNull TraceClassAnalysis<@NonNull RA>>)(Object)cyclicRegionAnalysis.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses2 != null) {
				Iterables.addAll(consumedTraceClassAnalyses, consumedTraceClassAnalyses2);
			}
			@SuppressWarnings("unchecked")
			Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> superProducedTraceClassAnalyses2 = (Iterable<@NonNull TraceClassAnalysis<@NonNull RA>>)(Object)cyclicRegionAnalysis.getSuperProducedTraceClassAnalyses();
			if (superProducedTraceClassAnalyses2 != null) {
				Iterables.addAll(superProducedTraceClassAnalyses, superProducedTraceClassAnalyses2);
			}
			@SuppressWarnings("unchecked")
			Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> consumedTracePropertyAnalyses2 = (Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>>)(Object)cyclicRegionAnalysis.getConsumedTracePropertyAnalyses();
			if (consumedTracePropertyAnalyses2 != null) {
				Iterables.addAll(consumedTracePropertyAnalyses, consumedTracePropertyAnalyses2);
			}
		}
		Set<@NonNull TraceClassAnalysis<@NonNull RA>> cyclicTraceClassAnalyses = new HashSet<>(consumedTraceClassAnalyses);
		cyclicTraceClassAnalyses.retainAll(superProducedTraceClassAnalyses);
		Set<@NonNull TracePropertyAnalysis<@NonNull RA>> cyclicTracePropertyAnalyses = new HashSet<>(consumedTracePropertyAnalyses);
		CycleAnalysis<@NonNull RA> cycleAnalysis = createCycleAnalysis(cyclicRegionAnalyses, cyclicTraceClassAnalyses, cyclicTracePropertyAnalyses);
		for (@NonNull RA cyclicRegionAnalysis : cyclicRegionAnalyses) {
			CycleAnalysis<@NonNull RA> oldCycleAnalysis = regionAnalysis2cycleAnalysis.put(cyclicRegionAnalysis, cycleAnalysis);
			assert oldCycleAnalysis == null;
		}
		for (@NonNull TraceClassAnalysis<@NonNull RA> cyclicTraceClassAnalysis : cyclicTraceClassAnalyses) {
			CycleAnalysis<@NonNull RA> oldCycleAnalysis = traceClassAnalysis2cycleAnalysis.put(cyclicTraceClassAnalysis, cycleAnalysis);
			assert oldCycleAnalysis == null;
		}
		return cycleAnalysis;
	}

	protected abstract @NonNull CycleAnalysis<@NonNull RA> createCycleAnalysis(@NonNull Set<@NonNull RA> cyclicRegionAnalyses,
			@NonNull Set<@NonNull TraceClassAnalysis<@NonNull RA>> cyclicTraceClassAnalyses,
			@NonNull Set<@NonNull TracePropertyAnalysis<@NonNull RA>> cyclicTracePropertyAnalyses);

	public @Nullable CycleAnalysis<@NonNull RA> getCycleAnalysis(@NonNull RA regionAnalysis) {
		return regionAnalysis2cycleAnalysis.get(regionAnalysis);
	}

	public @Nullable CycleAnalysis<@NonNull RA> getCycleAnalysis(@NonNull TraceClassAnalysis<@NonNull RA> traceClassAnalysis) {
		return traceClassAnalysis2cycleAnalysis.get(traceClassAnalysis);
	}

	public @NonNull TransformationAnalysis getTransformationAnalysis() {
		return transformationAnalysis;
	}
}
