/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;

/**
 * Each CycleAnalysis identifies one group of regionAnalyses that contribute to a cycle.
 */
public class CycleRegionAnalysis extends CycleAnalysis<@NonNull RegionAnalysis>
{
	private @Nullable Boolean isInfallible = null;

	public CycleRegionAnalysis(@NonNull CyclesAnalysis<@NonNull RegionAnalysis> cyclesAnalysis, @NonNull Set<@NonNull RegionAnalysis> regionAnalyses,
			@NonNull Set<@NonNull TraceClassAnalysis<@NonNull RegionAnalysis>> traceClassAnalyses, @NonNull Set<@NonNull TracePropertyAnalysis<@NonNull RegionAnalysis>> tracePropertyAnalyses) {
		super(cyclesAnalysis, regionAnalyses, traceClassAnalyses, tracePropertyAnalyses);
	}

	/**
	 * Return true if all sources of fallibility are within the cycle.
	 *
	public boolean isInfallible() {
		Boolean isInfallible2 = isInfallible;
		if (isInfallible2 == null) {
			Set<@NonNull RegionAnalysis> cycleFallibilities = new HashSet<>();
			for (@NonNull RegionAnalysis regionAnalysis : regionAnalyses) {
				Iterables.addAll(cycleFallibilities, regionAnalysis.getFallibilities());
			}
			Set<@NonNull RegionAnalysis> externalFallibilities = new HashSet<>(cycleFallibilities);
			for (@NonNull RegionAnalysis regionAnalysis : regionAnalyses) {
				externalFallibilities.remove(regionAnalysis);
			}
			isInfallible = isInfallible2 = externalFallibilities.isEmpty();
		}
		return isInfallible2;
	} */
}
