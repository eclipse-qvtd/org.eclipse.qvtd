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
public class CyclesAnalysis
{
	protected final @NonNull TransformationAnalysis transformationAnalysis;
	protected final @NonNull Iterable<@NonNull RegionAnalysis> regionAnalyses;

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each mapping partitioner.
	 */
	protected final @NonNull Map<@NonNull RegionAnalysis, @NonNull CycleAnalysis> regionAnalysis2cycleAnalysis = new HashMap<>();

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each trace class analysis.
	 */
	protected final @NonNull Map<@NonNull TraceClassAnalysis, @NonNull CycleAnalysis> traceClassAnalysis2cycleAnalysis = new HashMap<>();

	public CyclesAnalysis(@NonNull TransformationAnalysis transformationAnalysis, @NonNull Iterable<@NonNull RegionAnalysis> regionAnalyses) {
		this.transformationAnalysis = transformationAnalysis;
		this.regionAnalyses = regionAnalyses;
	}

	/**
	 * Return a map of the RegionAnalyses that form a cycle including each RegionAnalysis.
	 *
	 * NB cycles may involve trace classes and their trace class properties.
	 */
	public void analyze() {
		Iterable<@NonNull Set<@NonNull RegionAnalysis>> prunedCycleElements = computeCycleElementSets();
		//
		/*		for (@NonNull RegionAnalysis regionAnalysis : regionAnalyses) {
			Set<@NonNull RegionAnalysis> newCycleElements = new HashSet<>(partitioner2predecessors.get(regionAnalysis));
			newCycleElements.retainAll(partitioner2successors.get(regionAnalysis));
			if (!newCycleElements.isEmpty() && !allCycleElements.contains(newCycleElements)) {
				List<@NonNull Set<@NonNull RegionAnalysis>> redundantCycleElements = null;
				for (@NonNull Set<@NonNull RegionAnalysis> oldCycleElements : allCycleElements) {
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

	protected @Nullable Iterable<@NonNull Set<@NonNull RegionAnalysis>> computeCycleElementSets() {
		Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> partitioner2predecessors = computeTransitivePredecessors();
		Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> partitioner2successors = computeTransitiveSuccessors();
		Set<@NonNull Set<@NonNull RegionAnalysis>> allCycleElements = new HashSet<>();
		for (@NonNull RegionAnalysis regionAnalysis : regionAnalyses) {
			Set<@NonNull RegionAnalysis> newCycleElements = new HashSet<>(partitioner2predecessors.get(regionAnalysis));
			newCycleElements.retainAll(partitioner2successors.get(regionAnalysis));
			if (!newCycleElements.isEmpty()) {
				allCycleElements.add(newCycleElements);
			}
		}
		//
		List<@NonNull Set<@NonNull RegionAnalysis>> prunedCycleElements = new ArrayList<>(allCycleElements);
		for (int i = prunedCycleElements.size(); --i >= 0; ) {
			Set<@NonNull RegionAnalysis> iCycleElements = prunedCycleElements.get(i);
			boolean pruneIt = false;
			for (int j = i; --j >= 0; ) {
				Set<@NonNull RegionAnalysis> jCycleElements = prunedCycleElements.get(j);
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
	 * Return a map of the RegionAnalyses that may execute before each RegionAnalysis.
	 */
	protected @NonNull Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> computeTransitivePredecessors() {
		Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> consumer2producers = new HashMap<>();
		for (@NonNull RegionAnalysis regionAnalysis : regionAnalyses) {
			consumer2producers.put(regionAnalysis, new HashSet<>());
		}
		for (@NonNull RegionAnalysis consumer : regionAnalyses) {
			Iterable<@NonNull TraceClassAnalysis> consumedTraceClassAnalyses = consumer.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses != null) {
				for (@NonNull TraceClassAnalysis consumedTraceClassAnalysis : consumedTraceClassAnalyses) {
					for (@NonNull TraceClassAnalysis subConsumedTraceClass : consumedTraceClassAnalysis.getSubTraceClassAnalyses()) {
						for (@NonNull RegionAnalysis producer : subConsumedTraceClass.getProducers()) {
							Set<@NonNull RegionAnalysis> producers = consumer2producers.get(consumer);
							assert producers != null;
							producers.add(producer);
						}
					}
				}
			}
			Iterable<@NonNull TracePropertyAnalysis> consumedTracePropertyAnalyses = consumer.getConsumedTracePropertyAnalyses();
			if (consumedTracePropertyAnalyses != null) {
				for (@NonNull TracePropertyAnalysis consumedTracePropertyAnalysis : consumedTracePropertyAnalyses) {
					for (@NonNull RegionAnalysis producer : consumedTracePropertyAnalysis.getProducers()) {
						Set<@NonNull RegionAnalysis> producers = consumer2producers.get(consumer);
						assert producers != null;
						producers.add(producer);
					}
				}
			}
		}
		if (TransformationPartitioner.PREDECESSORS.isActive()) {
			for (@NonNull RegionAnalysis successor : regionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull RegionAnalysis> producers = new ArrayList<>(consumer2producers.get(successor));
				Collections.sort(producers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull RegionAnalysis producer : producers) {
					s.append(" " + producer);
				}
				TransformationPartitioner.PREDECESSORS.println(s.toString());
			}
		}
		Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> consumer2producersClosure = CompilerUtil.computeClosure(consumer2producers);
		if (TransformationPartitioner.PREDECESSORS.isActive()) {
			for (@NonNull RegionAnalysis successor : regionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull RegionAnalysis> producers = new ArrayList<>(consumer2producersClosure.get(successor));
				Collections.sort(producers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull RegionAnalysis producer : producers) {
					s.append(" " + producer);
				}
				TransformationPartitioner.PREDECESSORS.println(s.toString());
			}
		}
		return consumer2producersClosure;
	}

	/**
	 * Return a map of the RegionAnalyses that may execute after each RegionAnalysis.
	 */
	protected @NonNull Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> computeTransitiveSuccessors() {
		Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> producer2consumers = new HashMap<>();
		for (@NonNull RegionAnalysis regionAnalysis : regionAnalyses) {
			producer2consumers.put(regionAnalysis, new HashSet<>());
		}
		for (@NonNull RegionAnalysis producer : regionAnalyses) {
			Iterable<@NonNull TraceClassAnalysis> producedTraceClassAnalyses = producer.getProducedTraceClassAnalyses();
			if (producedTraceClassAnalyses != null) {
				for (@NonNull TraceClassAnalysis producedTraceClassAnalysis : producedTraceClassAnalyses) {
					for (@NonNull TraceClassAnalysis superProducedTraceClassAnalysis : producedTraceClassAnalysis.getSuperTraceClassAnalyses()) {
						for (@NonNull RegionAnalysis consumer : superProducedTraceClassAnalysis.getConsumers()) {
							Set<@NonNull RegionAnalysis> consumers = producer2consumers.get(producer);
							assert consumers != null;
							consumers.add(consumer);
						}
					}
				}
			}
			Iterable<@NonNull TracePropertyAnalysis> producedTracePropertyAnalyses = producer.getProducedTracePropertyAnalyses();
			if (producedTracePropertyAnalyses != null) {
				for (@NonNull TracePropertyAnalysis producedTracePropertyAnalysis : producedTracePropertyAnalyses) {
					for (@NonNull RegionAnalysis consumer : producedTracePropertyAnalysis.getConsumers()) {
						Set<@NonNull RegionAnalysis> consumers = producer2consumers.get(producer);
						assert consumers != null;
						consumers.add(consumer);
					}
				}
			}
		}
		if (TransformationPartitioner.SUCCESSORS.isActive()) {
			for (@NonNull RegionAnalysis successor : regionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append(successor + ":");
				List<@NonNull RegionAnalysis> consumers = new ArrayList<>(producer2consumers.get(successor));
				Collections.sort(consumers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull RegionAnalysis consumer : consumers) {
					s.append(" " + consumer);
				}
				TransformationPartitioner.SUCCESSORS.println(s.toString());
			}
		}
		Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> producer2consumersClosure = CompilerUtil.computeClosure(producer2consumers);
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


	protected void createCycleAnalyses(@NonNull Iterable<@NonNull Set<@NonNull RegionAnalysis>> cycleElementSets) {
		List<@NonNull CycleAnalysis> cycleAnalyses = new ArrayList<>();
		for (@NonNull Set<@NonNull RegionAnalysis> cycleElements : cycleElementSets) {
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
					s.append("\n  RegionAnalyses:");
					List<@NonNull RegionAnalysis> regionAnalyses2 = Lists.newArrayList(cycleAnalysis.getRegionAnalyses());
					Collections.sort(regionAnalyses2, NameUtil.NAMEABLE_COMPARATOR);
					for (@NonNull RegionAnalysis regionAnalysis : regionAnalyses2) {
						s.append("\n\t" + regionAnalysis);
						Iterable<@NonNull TraceClassAnalysis> consumedTraceClassAnalyses = regionAnalysis.getConsumedTraceClassAnalyses();
						if (consumedTraceClassAnalyses != null) {
							for (@NonNull TraceClassAnalysis traceClassAnalysis : consumedTraceClassAnalyses) {
								s.append("\n\t  =>" + traceClassAnalysis);
							}
						}
						Iterable<@NonNull TraceClassAnalysis> producedTraceClassAnalyses = regionAnalysis.getProducedTraceClassAnalyses();
						if (producedTraceClassAnalyses != null) {
							for (@NonNull TraceClassAnalysis traceClassAnalysis : producedTraceClassAnalyses) {
								s.append("\n\t  <=" + traceClassAnalysis);
							}
						}
						Iterable<@NonNull TracePropertyAnalysis> consumedTracePropertyAnalyses = regionAnalysis.getConsumedTracePropertyAnalyses();
						if (consumedTracePropertyAnalyses != null) {
							for (@NonNull TracePropertyAnalysis tracePropertyAnalysis : consumedTracePropertyAnalyses) {
								s.append("\n\t  =>" + tracePropertyAnalysis);
							}
						}
						Iterable<@NonNull TracePropertyAnalysis> producedTracePropertyAnalyses = regionAnalysis.getProducedTracePropertyAnalyses();
						if (producedTracePropertyAnalyses != null) {
							for (@NonNull TracePropertyAnalysis tracePropertyAnalysis : producedTracePropertyAnalyses) {
								s.append("\n\t  <=" + tracePropertyAnalysis);
							}
						}
					}
					s.append("\n  TraceClassAnalyses:");
					List<@NonNull TraceClassAnalysis> traceClassAnalyses = Lists.newArrayList(cycleAnalysis.getTraceClassAnalyses());
					Collections.sort(traceClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
					for (@NonNull TraceClassAnalysis traceClassAnalysis : traceClassAnalyses) {
						s.append("\n\t" + traceClassAnalysis);
					}
					s.append("\n  TracePropertyAnalyses:");
					List<@NonNull TracePropertyAnalysis> tracePropertyAnalyses = Lists.newArrayList(cycleAnalysis.getTracePropertyAnalyses());
					Collections.sort(tracePropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
					for (@NonNull TracePropertyAnalysis tracePropertyAnalysis : tracePropertyAnalyses) {
						s.append("\n\t" + tracePropertyAnalysis);
					}
					TransformationPartitioner.CYCLES.println(s.toString());
				}
			}
		}
	}

	protected @NonNull CycleAnalysis createCycleAnalysis(@NonNull Set<@NonNull RegionAnalysis> cyclicRegionAnalyses) {
		Set<@NonNull TraceClassAnalysis> consumedTraceClassAnalyses = new HashSet<>();
		Set<@NonNull TraceClassAnalysis> superProducedTraceClassAnalyses = new HashSet<>();
		Set<@NonNull TracePropertyAnalysis> consumedTracePropertyAnalyses = new HashSet<>();
		for (@NonNull RegionAnalysis cyclicRegionAnalysis : cyclicRegionAnalyses) {
			Iterable<@NonNull TraceClassAnalysis> consumedTraceClassAnalyses2 = cyclicRegionAnalysis.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses2 != null) {
				Iterables.addAll(consumedTraceClassAnalyses, consumedTraceClassAnalyses2);
			}
			Iterable<@NonNull TraceClassAnalysis> superProducedTraceClassAnalyses2 = cyclicRegionAnalysis.getSuperProducedTraceClassAnalyses();
			if (superProducedTraceClassAnalyses2 != null) {
				Iterables.addAll(superProducedTraceClassAnalyses, superProducedTraceClassAnalyses2);
			}
			Iterable<@NonNull TracePropertyAnalysis> consumedTracePropertyAnalyses2 = cyclicRegionAnalysis.getConsumedTracePropertyAnalyses();
			if (consumedTracePropertyAnalyses2 != null) {
				Iterables.addAll(consumedTracePropertyAnalyses, consumedTracePropertyAnalyses2);
			}
		}
		Set<@NonNull TraceClassAnalysis> cyclicTraceClassAnalyses = new HashSet<>(consumedTraceClassAnalyses);
		cyclicTraceClassAnalyses.retainAll(superProducedTraceClassAnalyses);
		Set<@NonNull TracePropertyAnalysis> cyclicTracePropertyAnalyses = new HashSet<>(consumedTracePropertyAnalyses);
		CycleAnalysis cycleAnalysis = new CycleAnalysis(this, cyclicRegionAnalyses, cyclicTraceClassAnalyses, cyclicTracePropertyAnalyses);
		for (@NonNull RegionAnalysis cyclicRegionAnalysis : cyclicRegionAnalyses) {
			CycleAnalysis oldCycleAnalysis = regionAnalysis2cycleAnalysis.put(cyclicRegionAnalysis, cycleAnalysis);
			assert oldCycleAnalysis == null;
		}
		for (@NonNull TraceClassAnalysis cyclicTraceClassAnalysis : cyclicTraceClassAnalyses) {
			CycleAnalysis oldCycleAnalysis = traceClassAnalysis2cycleAnalysis.put(cyclicTraceClassAnalysis, cycleAnalysis);
			assert oldCycleAnalysis == null;
		}
		return cycleAnalysis;
	}

	public @Nullable CycleAnalysis getCycleAnalysis(@NonNull RegionAnalysis regionAnalysis) {
		return regionAnalysis2cycleAnalysis.get(regionAnalysis);
	}

	public @Nullable CycleAnalysis getCycleAnalysis(@NonNull TraceClassAnalysis traceClassAnalysis) {
		return traceClassAnalysis2cycleAnalysis.get(traceClassAnalysis);
	}

	public @NonNull TransformationAnalysis getTransformationAnalysis() {
		return transformationAnalysis;
	}
}
