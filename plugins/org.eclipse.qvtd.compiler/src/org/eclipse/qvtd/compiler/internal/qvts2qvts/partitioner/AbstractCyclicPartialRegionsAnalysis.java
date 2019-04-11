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

import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionPropertyAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionsAnalysis;
import com.google.common.collect.Lists;

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
			if (consumedClassAnalyses != null) {
				s.append("\n  ConsumedClassAnalyses:");
				List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> sortedConsumedClassAnalyses = Lists.newArrayList(consumedClassAnalyses);
				Collections.sort(sortedConsumedClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> consumedClassAnalysis : sortedConsumedClassAnalyses) {
					s.append("\n\t" + consumedClassAnalysis);
				}
			}
			Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> superProducedClassAnalyses = cyclicRegionAnalysis.getSuperProducedClassAnalyses();
			if (superProducedClassAnalyses != null) {
				s.append("\n  ProducedClassAnalyses:");
				List<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> sortedSuperProducedClassAnalyses = Lists.newArrayList(superProducedClassAnalyses);
				Collections.sort(sortedSuperProducedClassAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> producedClassAnalysis : sortedSuperProducedClassAnalyses) {
					s.append("\n\t" + producedClassAnalysis);
				}
			}
			Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> consumedPropertyAnalyses = cyclicRegionAnalysis.getConsumedPropertyAnalyses();
			if (consumedPropertyAnalyses != null) {
				s.append("\n  ConsumedPropertyAnalyses:");
				List<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> sortedConsumedPropertyAnalyses = Lists.newArrayList(consumedPropertyAnalyses);
				Collections.sort(sortedConsumedPropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartialRegionPropertyAnalysis<@NonNull PRA> consumedPropertyAnalysis : sortedConsumedPropertyAnalyses) {
					s.append("\n\t" + consumedPropertyAnalysis + "(" + consumedPropertyAnalysis.getBasePropertyAnalysis() + ")");
				}
			}
			Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> producedPropertyAnalyses = cyclicRegionAnalysis.getProducedPropertyAnalyses();
			if (producedPropertyAnalyses != null) {
				s.append("\n  ProducedPropertyAnalyses:");
				List<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> sortedProducedPropertyAnalyses = Lists.newArrayList(producedPropertyAnalyses);
				Collections.sort(sortedProducedPropertyAnalyses, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull PartialRegionPropertyAnalysis<@NonNull PRA> producedPropertyAnalysis : sortedProducedPropertyAnalyses) {
					s.append("\n\t" + producedPropertyAnalysis + "(" + producedPropertyAnalysis.getBasePropertyAnalysis() + ")");
				}
			}
			cyclesTracingOption.println(s.toString());
		}
	}
}
