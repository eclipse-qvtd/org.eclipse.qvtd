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
 * The CyclicRegionsAnalysis identifies the RegionAnalysis' and ClassAnalysis' that contribute to cycles.
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
	private final @NonNull Set<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> cyclicClassAnalyses = new HashSet<>();

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
		Set<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> consumedClassAnalyses = new HashSet<>();
		Set<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> superProducedClassAnalyses = new HashSet<>();
		for (@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis> cyclicRegionAnalysis : cyclicRegionAnalyses) {
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> consumedClassAnalyses2 = cyclicRegionAnalysis.getConsumedClassAnalyses();
			if (consumedClassAnalyses2 != null) {
				Iterables.addAll(consumedClassAnalyses, consumedClassAnalyses2);
			}
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> superProducedClassAnalyses2 = cyclicRegionAnalysis.getSuperProducedClassAnalyses();
			if (superProducedClassAnalyses2 != null) {
				Iterables.addAll(superProducedClassAnalyses, superProducedClassAnalyses2);
			}
		}
		cyclicClassAnalyses.addAll(consumedClassAnalyses);
		cyclicClassAnalyses.retainAll(superProducedClassAnalyses);
		if (TransformationPartitioner.CYCLES.isActive()) {
			showCycles(cyclicRegionAnalyses.iterator().next().getTransformationAnalysis(), cyclicRegionAnalyses);
		}
	}

	public boolean isCyclic(@NonNull RegionAnalysis regionAnalysis) {
		return cyclicRegionAnalyses.contains(regionAnalysis);
	}

	public boolean isCyclic(@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> classAnalysis) {		// FIXME this might be removeable
		assert cyclicClassAnalyses != null;
		return cyclicClassAnalyses.contains(classAnalysis);
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
					Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> consumedClassAnalyses = cyclicRegionAnalysis.getConsumedClassAnalyses();
					if (consumedClassAnalyses != null) {
						s.append("\n  ConsumedClassAnalyses:");
						for (@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> consumedClassAnalysis : consumedClassAnalyses) {
							s.append("\n\t" + consumedClassAnalysis);
						}
					}
					Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> superProducedClassAnalyses = cyclicRegionAnalysis.getSuperProducedClassAnalyses();
					if (superProducedClassAnalyses != null) {
						s.append("\n  ProducedClassAnalyses:");
						for (@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> producedClassAnalysis : superProducedClassAnalyses) {
							s.append("\n\t" + producedClassAnalysis);
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
					Iterable<@NonNull ? extends ClassPartitionAnalysis> consumedClassAnalyses = cyclicRegionAnalysis.getConsumers();
					if (consumedClassAnalyses != null) {
						for (@NonNull ClassPartitionAnalysis classAnalysis : consumedClassAnalyses) {
							s.append("\n\t  =>" + classAnalysis);
						}
					}
					Iterable<@NonNull ? extends ClassPartitionAnalysis> producedClassAnalyses = cyclicPartitionAnalysis.getProducedClassAnalyses();
					if (producedClassAnalyses != null) {
						for (@NonNull ClassPartitionAnalysis classAnalysis : producedClassAnalyses) {
							s.append("\n\t  <=" + classAnalysis);
						}
					}
					Iterable<@NonNull ? extends PropertyPartitionAnalysis> consumedPropertyAnalyses = cyclicPartitionAnalysis.getConsumedPropertyAnalyses();
					if (consumedPropertyAnalyses != null) {
						for (@NonNull PropertyPartitionAnalysis propertyAnalysis : consumedPropertyAnalyses) {
							s.append("\n\t  =>" + propertyAnalysis);
						}
					}
					Iterable<@NonNull ? extends PropertyPartitionAnalysis> producedPropertyAnalyses = cyclicPartitionAnalysis.getProducedPropertyAnalyses();
					if (producedPropertyAnalyses != null) {
						for (@NonNull PropertyPartitionAnalysis propertyAnalysis : producedPropertyAnalyses) {
							s.append("\n\t  <=" + propertyAnalysis);
						}
					}
				}
				s.append("\n  ClassAnalyses:");
				List<@NonNull ClassPartitionAnalysis> classAnalyses = Lists.newArrayList(cyclicPartitionAnalysis.getClassAnalyses());
				Collections.sort(classAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull ClassPartitionAnalysis classAnalysis : classAnalyses) {
					s.append("\n\t" + classAnalysis);
				}
				s.append("\n  PropertyAnalyses:");
				List<@NonNull PropertyPartitionAnalysis> propertyAnalyses = Lists.newArrayList(cyclicPartitionAnalysis.getPropertyAnalyses());
				Collections.sort(propertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PropertyPartitionAnalysis propertyAnalysis : propertyAnalyses) {
					s.append("\n\t" + propertyAnalysis);
				}
				TransformationPartitioner.CYCLES.println(s.toString());
			}
		} */
	}
}
