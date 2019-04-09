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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;

import com.google.common.collect.Iterables;

/**
 * The CyclicRegionsAnalysis identifies the RegionAnalysis' and TraceClassAnalysis' that contribute to cycles.
 *
 * This supports the initial optimization to only partition those regions that are cyclic.
 */
public class CyclicRegionsAnalysis
{
	/**
	 * The RegionAnalysis' whose transitive consumption is also transitively produced.
	 */
	private final @NonNull Set<@NonNull RegionAnalysis> cyclicRegionAnalyses = new HashSet<>();

	/**
	 * Mapping to the cycle analysis that identifies the cycle involving each trace class analysis.
	 */
	private final @NonNull Set<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> cyclicTraceClassAnalyses = new HashSet<>();

	public CyclicRegionsAnalysis(@NonNull Iterable<@NonNull RegionAnalysis> regionAnalyses) {
		analyze(regionAnalyses);
	}

	/**
	 * Return a map of the RegionAnalyses that form a cycle including each RegionAnalysis.
	 *
	 * NB cycles may involve trace classes and their trace class properties.
	 */
	private void analyze(@NonNull Iterable<@NonNull RegionAnalysis> regionAnalyses) {
		Map<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>>> partitioner2predecessors = CompilerUtil.computeTransitivePredecessors(regionAnalyses);
		Map<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>>> partitioner2successors = CompilerUtil.computeTransitiveSuccessors(partitioner2predecessors);
		for (@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis> regionAnalysis : regionAnalyses) {
			Set<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>> intersection = new HashSet<>(partitioner2predecessors.get(regionAnalysis));
			intersection.retainAll(partitioner2successors.get(regionAnalysis));
			for (@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis> intersectingRegionAnalysis : intersection) {
				cyclicRegionAnalyses.add((RegionAnalysis)intersectingRegionAnalysis);
			}
		}
		if (cyclicRegionAnalyses.isEmpty()) {
			return;
		}
		Set<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> consumedTraceClassAnalyses = new HashSet<>();
		Set<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> superProducedTraceClassAnalyses = new HashSet<>();
		for (@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis> cyclicRegionAnalysis : cyclicRegionAnalyses) {
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> consumedTraceClassAnalyses2 = cyclicRegionAnalysis.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses2 != null) {
				Iterables.addAll(consumedTraceClassAnalyses, consumedTraceClassAnalyses2);
			}
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> superProducedTraceClassAnalyses2 = cyclicRegionAnalysis.getSuperProducedTraceClassAnalyses();
			if (superProducedTraceClassAnalyses2 != null) {
				Iterables.addAll(superProducedTraceClassAnalyses, superProducedTraceClassAnalyses2);
			}
		}
		cyclicTraceClassAnalyses.addAll(consumedTraceClassAnalyses);
		cyclicTraceClassAnalyses.retainAll(superProducedTraceClassAnalyses);
		if (TransformationPartitioner.CYCLES.isActive()) {
			showCycles(cyclicRegionAnalyses.iterator().next().getTransformationAnalysis(), cyclicRegionAnalyses);
		}
	}

	public boolean isCyclic(@NonNull RegionAnalysis regionAnalysis) {
		return cyclicRegionAnalyses.contains(regionAnalysis);
	}

	public boolean isCyclic(@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> traceClassAnalysis) {		// FIXME this might be removeable
		assert cyclicTraceClassAnalyses != null;
		return cyclicTraceClassAnalyses.contains(traceClassAnalysis);
	}

	protected void showCycles(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull Set<@NonNull RegionAnalysis> cyclicRegionAnalyses) {
		if (TransformationPartitioner.CYCLES.isActive()) {
			if (cyclicRegionAnalyses.isEmpty()) {
				TransformationPartitioner.CYCLES.println("No cycles");
			}
			else {
				for (@NonNull RegionAnalysis cyclicRegionAnalysis : cyclicRegionAnalyses) {
					StringBuilder s = new StringBuilder();
					s.append(cyclicRegionAnalysis.getName());
					Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> consumedTraceClassAnalyses = cyclicRegionAnalysis.getConsumedTraceClassAnalyses();
					if (consumedTraceClassAnalyses != null) {
						s.append("\n  ConsumedTraceClassAnalyses:");
						for (@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> consumedTraceClassAnalysis : consumedTraceClassAnalyses) {
							s.append("\n\t" + consumedTraceClassAnalysis);
						}
					}
					Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> superProducedTraceClassAnalyses = cyclicRegionAnalysis.getSuperProducedTraceClassAnalyses();
					if (superProducedTraceClassAnalyses != null) {
						s.append("\n  ProducedTraceClassAnalyses:");
						for (@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> producedTraceClassAnalysis : superProducedTraceClassAnalyses) {
							s.append("\n\t" + producedTraceClassAnalysis);
						}
					}
					TransformationPartitioner.CYCLES.println(s.toString());
				}
			}
		}
		/*	if (Iterables.isEmpty(cyclicRegionAnalyses)) {
			TransformationPartitioner.CYCLES.println("No cycles");
		}
		else {
			for (@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> cyclicRegionAnalysis : cyclicRegionAnalyses) {
				StringBuilder s = new StringBuilder();
				s.append("\n  Regions:");
								List<@NonNull PartitionAnalysis> partitions2 = Lists.newArrayList(cyclicPartitionAnalysis.getPartitionAnalyses());
				Collections.sort(partitions2, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartitionAnalysis partition : partitions2) {
					s.append("\n\t" + partition);
					Iterable<@NonNull ? extends TraceClassPartitionAnalysis> consumedTraceClassAnalyses = cyclicRegionAnalysis.getConsumers();
					if (consumedTraceClassAnalyses != null) {
						for (@NonNull TraceClassPartitionAnalysis traceClassAnalysis : consumedTraceClassAnalyses) {
							s.append("\n\t  =>" + traceClassAnalysis);
						}
					}
					Iterable<@NonNull ? extends TraceClassPartitionAnalysis> producedTraceClassAnalyses = cyclicPartitionAnalysis.getProducedTraceClassAnalyses();
					if (producedTraceClassAnalyses != null) {
						for (@NonNull TraceClassPartitionAnalysis traceClassAnalysis : producedTraceClassAnalyses) {
							s.append("\n\t  <=" + traceClassAnalysis);
						}
					}
					Iterable<@NonNull ? extends TracePropertyPartitionAnalysis> consumedTracePropertyAnalyses = cyclicPartitionAnalysis.getConsumedTracePropertyAnalyses();
					if (consumedTracePropertyAnalyses != null) {
						for (@NonNull TracePropertyPartitionAnalysis tracePropertyAnalysis : consumedTracePropertyAnalyses) {
							s.append("\n\t  =>" + tracePropertyAnalysis);
						}
					}
					Iterable<@NonNull ? extends TracePropertyPartitionAnalysis> producedTracePropertyAnalyses = cyclicPartitionAnalysis.getProducedTracePropertyAnalyses();
					if (producedTracePropertyAnalyses != null) {
						for (@NonNull TracePropertyPartitionAnalysis tracePropertyAnalysis : producedTracePropertyAnalyses) {
							s.append("\n\t  <=" + tracePropertyAnalysis);
						}
					}
				}
				s.append("\n  TraceClassAnalyses:");
				List<@NonNull TraceClassPartitionAnalysis> traceClassAnalyses = Lists.newArrayList(cyclicPartitionAnalysis.getTraceClassAnalyses());
				Collections.sort(traceClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull TraceClassPartitionAnalysis traceClassAnalysis : traceClassAnalyses) {
					s.append("\n\t" + traceClassAnalysis);
				}
				s.append("\n  TracePropertyAnalyses:");
				List<@NonNull TracePropertyPartitionAnalysis> tracePropertyAnalyses = Lists.newArrayList(cyclicPartitionAnalysis.getTracePropertyAnalyses());
				Collections.sort(tracePropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull TracePropertyPartitionAnalysis tracePropertyAnalysis : tracePropertyAnalyses) {
					s.append("\n\t" + tracePropertyAnalysis);
				}
				TransformationPartitioner.CYCLES.println(s.toString());
			}
		} */
	}
}
