/*******************************************************************************
 * Copyright (c) 2016, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.IterableUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.BasePartialRegionPropertyAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionPropertyAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionsAnalysis;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public abstract class AbstractCyclicPartialRegionsAnalysis<@NonNull PRA extends PartialRegionsAnalysis<@NonNull PRA>>
{
	protected void showCycles(@NonNull TracingOption cyclesTracingOption,
			@NonNull Iterable<? extends @NonNull PartialRegionAnalysis<@NonNull PRA>> cyclicRegionAnalyses) {
		List<@NonNull PartialRegionAnalysis<@NonNull PRA>> sortedCyclicRegionAnalyses = Lists.newArrayList(cyclicRegionAnalyses);
		if (sortedCyclicRegionAnalyses.isEmpty()) {
			cyclesTracingOption.println("No cycles");
			return;
		}
		Collections.sort(sortedCyclicRegionAnalyses, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull PartialRegionAnalysis<@NonNull PRA> cyclicRegionAnalysis : sortedCyclicRegionAnalyses) {
			StringBuilder s = new StringBuilder();
			s.append(cyclicRegionAnalysis.getName());
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> consumedClassAnalyses = cyclicRegionAnalysis.getConsumedClassAnalyses();
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> superProducedClassAnalyses = cyclicRegionAnalysis.getSuperProducedClassAnalyses();
			Set<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> cyclicClassAnalyses = null;
			if (consumedClassAnalyses != null) {
				if (superProducedClassAnalyses != null) {
					cyclicClassAnalyses = Sets.newHashSet(consumedClassAnalyses);
					IterableUtil.retainAll(cyclicClassAnalyses, superProducedClassAnalyses);
				}
				s.append("\n  ConsumedClassAnalyses:");
				List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> sortedConsumedClassAnalyses = Lists.newArrayList(consumedClassAnalyses);
				if (cyclicClassAnalyses != null) {
					sortedConsumedClassAnalyses.removeAll(cyclicClassAnalyses);
				}
				Collections.sort(sortedConsumedClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> consumedClassAnalysis : sortedConsumedClassAnalyses) {
					s.append("\n\t" + consumedClassAnalysis);
				}
			}
			if ((cyclicClassAnalyses != null) && !cyclicClassAnalyses.isEmpty()) {
				s.append("\n  CyclicClassAnalyses:");
				List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> sortedCyclicClassAnalyses = Lists.newArrayList(cyclicClassAnalyses);
				Collections.sort(sortedCyclicClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> cyclicClassAnalysis : sortedCyclicClassAnalyses) {
					s.append("\n\t" + cyclicClassAnalysis);
				}
			}
			if (superProducedClassAnalyses != null) {
				s.append("\n  ProducedClassAnalyses:");
				List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> sortedSuperProducedClassAnalyses = Lists.newArrayList(superProducedClassAnalyses);
				if (cyclicClassAnalyses != null) {
					sortedSuperProducedClassAnalyses.removeAll(cyclicClassAnalyses);
				}
				Collections.sort(sortedSuperProducedClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> producedClassAnalysis : sortedSuperProducedClassAnalyses) {
					s.append("\n\t" + producedClassAnalysis);
				}
			}
			Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> consumedPropertyAnalyses = cyclicRegionAnalysis.getConsumedPropertyAnalyses();
			Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> producedPropertyAnalyses = cyclicRegionAnalysis.getProducedPropertyAnalyses();
			Set<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> cyclicPropertyAnalyses = null;
			if (consumedPropertyAnalyses != null) {
				if (producedPropertyAnalyses != null) {
					cyclicPropertyAnalyses = Sets.newHashSet(consumedPropertyAnalyses);
					IterableUtil.retainAll(cyclicPropertyAnalyses, producedPropertyAnalyses);
				}
				s.append("\n  ConsumedPropertyAnalyses:");
				List<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> sortedConsumedPropertyAnalyses = Lists.newArrayList(consumedPropertyAnalyses);
				if (cyclicPropertyAnalyses != null) {
					sortedConsumedPropertyAnalyses.removeAll(cyclicPropertyAnalyses);
				}
				Collections.sort(sortedConsumedPropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartialRegionPropertyAnalysis<@NonNull PRA> consumedPropertyAnalysis : sortedConsumedPropertyAnalyses) {
					s.append("\n\t" + consumedPropertyAnalysis);
					BasePartialRegionPropertyAnalysis<@NonNull PRA> baseConsumedPropertyAnalysis = consumedPropertyAnalysis.getBasePropertyAnalysis();
					if (consumedPropertyAnalysis.getPropertyDatum() != baseConsumedPropertyAnalysis.getPropertyDatum()) {
						s.append("(" + baseConsumedPropertyAnalysis + ")");
					}
				}
			}
			if ((cyclicPropertyAnalyses != null) && !cyclicPropertyAnalyses.isEmpty()) {
				s.append("\n  CyclicPropertyAnalyses:");
				List<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> sortedCyclicPropertyAnalyses = Lists.newArrayList(cyclicPropertyAnalyses);
				Collections.sort(sortedCyclicPropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartialRegionPropertyAnalysis<@NonNull PRA> cyclicPropertyAnalysis : sortedCyclicPropertyAnalyses) {
					s.append("\n\t" + cyclicPropertyAnalysis);
					BasePartialRegionPropertyAnalysis<@NonNull PRA> baseCyclicPropertyAnalysis = cyclicPropertyAnalysis.getBasePropertyAnalysis();
					if (cyclicPropertyAnalysis.getPropertyDatum() != baseCyclicPropertyAnalysis.getPropertyDatum()) {
						s.append("(" + baseCyclicPropertyAnalysis + ")");
					}
				}
			}
			if (producedPropertyAnalyses != null) {
				s.append("\n  ProducedPropertyAnalyses:");
				List<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> sortedProducedPropertyAnalyses = Lists.newArrayList(producedPropertyAnalyses);
				if (cyclicPropertyAnalyses != null) {
					sortedProducedPropertyAnalyses.removeAll(cyclicPropertyAnalyses);
				}
				Collections.sort(sortedProducedPropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartialRegionPropertyAnalysis<@NonNull PRA> producedPropertyAnalysis : sortedProducedPropertyAnalyses) {
					s.append("\n\t" + producedPropertyAnalysis);
					BasePartialRegionPropertyAnalysis<@NonNull PRA> baseProducedPropertyAnalysis = producedPropertyAnalysis.getBasePropertyAnalysis();
					if (producedPropertyAnalysis.getPropertyDatum() != baseProducedPropertyAnalysis.getPropertyDatum()) {
						s.append("(" + baseProducedPropertyAnalysis + ")");
					}
				}
			}
			cyclesTracingOption.println(s.toString());
		}
	}
}
