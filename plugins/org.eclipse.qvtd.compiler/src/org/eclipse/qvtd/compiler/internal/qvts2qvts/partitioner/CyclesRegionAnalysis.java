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

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;

/**
 * The CyclesAnalysis identifies a CycleAnalysis for each group of regionAnalyses that contribute to a cycle.
 */
public class CyclesRegionAnalysis extends CyclesAnalysis<@NonNull RegionAnalysis>
{
	public CyclesRegionAnalysis(@NonNull TransformationAnalysis transformationAnalysis, @NonNull Iterable<@NonNull RegionAnalysis> regionAnalyses) {
		super(transformationAnalysis, regionAnalyses);
	}

	@Override
	protected @NonNull CycleAnalysis<@NonNull RegionAnalysis> createCycleAnalysis(@NonNull Set<@NonNull RegionAnalysis> cyclicRegionAnalyses,
			@NonNull Set<@NonNull TraceClassAnalysis<@NonNull RegionAnalysis>> cyclicTraceClassAnalyses,
			@NonNull Set<@NonNull TracePropertyAnalysis<@NonNull RegionAnalysis>> cyclicTracePropertyAnalyses) {
		return new CycleRegionAnalysis(this, cyclicRegionAnalyses, cyclicTraceClassAnalyses, cyclicTracePropertyAnalyses);
	}
}
