/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.BasePartialRegionPropertyAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionPropertyAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * A CyclicRegionAnalysis aggregates the regionAnalyses that have cyclic dependencies in to a single logical Region,
 * which is never realized directly since it is partitioned to redice dependencies.
 */
public class CyclicRegionAnalysis implements Comparable<@NonNull CyclicRegionAnalysis>
{
	protected final @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>> regionAnalyses;
	protected final @NonNull String name;
	private final @NonNull Set<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> consumedClassAnalyses = new HashSet<>();
	private final @NonNull Set<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> superProducedClassAnalyses = new HashSet<>();
	private final @NonNull Set<@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis>> consumedPropertyAnalyses = new HashSet<>();
	private final @NonNull Set<@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis>> producedPropertyAnalyses = new HashSet<>();
	private final @NonNull Set<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> cyclicClassAnalyses = new HashSet<>();
	private final @NonNull Set<@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis>> cyclicPropertyAnalyses = new HashSet<>();
	private final @NonNull Map<@NonNull PropertyDatum, @NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis>> propertyDatum2cyclicPropertyAnalysis = new HashMap<>();

	public CyclicRegionAnalysis(@NonNull Set<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>> regionAnalyses) {
		this.regionAnalyses = regionAnalyses;
		List</*@NonNull*/ String> names = new ArrayList<>();
		for (@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis> regionAnalysis : regionAnalyses) {
			names.add(regionAnalysis.getName());
		}
		Collections.sort(names);
		StringBuilder s =new StringBuilder();
		boolean isFirst = true;
		for (String name : names) {
			if (!isFirst) {
				s.append("+");
			}
			else {
				isFirst = false;
			}
			s.append(name);
		}
		this.name = s.toString();
		for (@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis> regionAnalysis : regionAnalyses) {
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> consumedClassAnalyses2 = regionAnalysis.getConsumedClassAnalyses();
			if (consumedClassAnalyses2 != null) {
				Iterables.addAll(consumedClassAnalyses, consumedClassAnalyses2);
			}
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> superProducedClassAnalyses2 = regionAnalysis.getSuperProducedClassAnalyses();
			if (superProducedClassAnalyses2 != null) {
				Iterables.addAll(superProducedClassAnalyses, superProducedClassAnalyses2);
			}
			Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis>> consumedPropertyAnalyses2 = regionAnalysis.getConsumedPropertyAnalyses();
			if (consumedPropertyAnalyses2 != null) {
				Iterables.addAll(consumedPropertyAnalyses, consumedPropertyAnalyses2);
			}
			Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis>> producedPropertyAnalyses2 = regionAnalysis.getProducedPropertyAnalyses();
			if (producedPropertyAnalyses2 != null) {
				Iterables.addAll(producedPropertyAnalyses, producedPropertyAnalyses2);
			}
		}
		cyclicClassAnalyses.addAll(consumedClassAnalyses);
		cyclicClassAnalyses.retainAll(superProducedClassAnalyses);
		consumedClassAnalyses.removeAll(cyclicClassAnalyses);
		superProducedClassAnalyses.removeAll(cyclicClassAnalyses);
		cyclicPropertyAnalyses.addAll(consumedPropertyAnalyses);
		cyclicPropertyAnalyses.retainAll(producedPropertyAnalyses);
		consumedPropertyAnalyses.removeAll(cyclicPropertyAnalyses);
		producedPropertyAnalyses.removeAll(cyclicPropertyAnalyses);
		for (@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis> cyclicPropertyAnalysis : cyclicPropertyAnalyses) {
			PropertyDatum propertyDatum = cyclicPropertyAnalysis.getPropertyDatum();		// ?? all supers ??
			propertyDatum2cyclicPropertyAnalysis.put(propertyDatum, cyclicPropertyAnalysis);
		}
	}

	@Override
	public int compareTo(@NonNull CyclicRegionAnalysis that) {
		//	int s1 = this.regionAnalyses.size();
		//	int s2 = that.regionAnalyses.size();
		//	if (s1 != s2) {
		//		return s2 - s1;
		//	}
		return name.compareTo(that.name);	// Since the name is a concatenation, a nested cycle is shorter and so first.
	}

	public boolean isCyclic(@NonNull PropertyDatum propertyDatum) {
		PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis> cyclicPropertyAnalysis = propertyDatum2cyclicPropertyAnalysis.get(propertyDatum);
		return cyclicPropertyAnalysis != null;
	}

	protected void showCycle(@NonNull TracingOption cyclesTracingOption) {
		StringBuilder s = new StringBuilder();
		s.append(name);
		s.append("\n  ConsumedClassAnalyses:");
		List<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> sortedConsumedClassAnalyses = Lists.newArrayList(consumedClassAnalyses);
		Collections.sort(sortedConsumedClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> consumedClassAnalysis : sortedConsumedClassAnalyses) {
			s.append("\n\t" + consumedClassAnalysis);
		}
		s.append("\n  CyclicClassAnalyses:");
		List<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> sortedCyclicClassAnalyses = Lists.newArrayList(cyclicClassAnalyses);
		Collections.sort(sortedCyclicClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> cyclicClassAnalysis : sortedCyclicClassAnalyses) {
			s.append("\n\t" + cyclicClassAnalysis);
		}
		s.append("\n  ProducedClassAnalyses:");
		List<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> sortedSuperProducedClassAnalyses = Lists.newArrayList(superProducedClassAnalyses);
		Collections.sort(sortedSuperProducedClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> producedClassAnalysis : sortedSuperProducedClassAnalyses) {
			s.append("\n\t" + producedClassAnalysis);
		}
		s.append("\n  ConsumedPropertyAnalyses:");
		List<@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis>> sortedConsumedPropertyAnalyses = Lists.newArrayList(consumedPropertyAnalyses);
		Collections.sort(sortedConsumedPropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis> consumedPropertyAnalysis : sortedConsumedPropertyAnalyses) {
			s.append("\n\t" + consumedPropertyAnalysis);
			BasePartialRegionPropertyAnalysis<@NonNull RegionsAnalysis> baseConsumedPropertyAnalysis = consumedPropertyAnalysis.getBasePropertyAnalysis();
			if (consumedPropertyAnalysis.getPropertyDatum() != baseConsumedPropertyAnalysis.getPropertyDatum()) {
				s.append("(" + baseConsumedPropertyAnalysis + ")");
			}
		}
		s.append("\n  CyclicPropertyAnalyses:");
		List<@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis>> sortedCyclicPropertyAnalyses = Lists.newArrayList(cyclicPropertyAnalyses);
		Collections.sort(sortedCyclicPropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis> cyclicPropertyAnalysis : sortedCyclicPropertyAnalyses) {
			s.append("\n\t" + cyclicPropertyAnalysis);
			BasePartialRegionPropertyAnalysis<@NonNull RegionsAnalysis> baseCyclicPropertyAnalysis = cyclicPropertyAnalysis.getBasePropertyAnalysis();
			if (cyclicPropertyAnalysis.getPropertyDatum() != baseCyclicPropertyAnalysis.getPropertyDatum()) {
				s.append("(" + baseCyclicPropertyAnalysis + ")");
			}
		}
		s.append("\n  ProducedPropertyAnalyses:");
		List<@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis>> sortedProducedPropertyAnalyses = Lists.newArrayList(producedPropertyAnalyses);
		Collections.sort(sortedProducedPropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis> producedPropertyAnalysis : sortedProducedPropertyAnalyses) {
			s.append("\n\t" + producedPropertyAnalysis);
			BasePartialRegionPropertyAnalysis<@NonNull RegionsAnalysis> baseProducedPropertyAnalysis = producedPropertyAnalysis.getBasePropertyAnalysis();
			if (producedPropertyAnalysis.getPropertyDatum() != baseProducedPropertyAnalysis.getPropertyDatum()) {
				s.append("(" + baseProducedPropertyAnalysis + ")");
			}
		}
		cyclesTracingOption.println(s.toString());
	}

	@Override
	public String toString() {
		return name;
	}
}