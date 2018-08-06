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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.PartialRegionAnalysis;

/**
 * Each CycleAnalysis identifies one group of regionAnalyses that contribute to a cycle.
 */
public abstract class CycleAnalysis<RA extends PartialRegionAnalysis<@NonNull RA>>
{
	protected final @NonNull CyclesAnalysis<@NonNull RA> cyclesAnalysis;
	protected final @NonNull Set<@NonNull RA> regionAnalyses;
	protected final @NonNull Set<@NonNull TraceClassAnalysis<@NonNull RA>> traceClassAnalyses;
	protected final @NonNull Set<@NonNull TracePropertyAnalysis<@NonNull RA>> tracePropertyAnalyses;

	protected CycleAnalysis(@NonNull CyclesAnalysis<@NonNull RA> cyclesAnalysis, @NonNull Set<@NonNull RA> regionAnalyses,
			@NonNull Set<@NonNull TraceClassAnalysis<@NonNull RA>> traceClassAnalyses, @NonNull Set<@NonNull TracePropertyAnalysis<@NonNull RA>> tracePropertyAnalyses) {
		this.cyclesAnalysis = cyclesAnalysis;
		this.regionAnalyses = regionAnalyses;
		this.traceClassAnalyses = traceClassAnalyses;
		this.tracePropertyAnalyses = tracePropertyAnalyses;
		assert !regionAnalyses.isEmpty();
		assert !traceClassAnalyses.isEmpty() || !tracePropertyAnalyses.isEmpty();
	}

	public @NonNull Iterable<@NonNull RA> getRegionAnalyses() {
		return regionAnalyses;
	}

	public @NonNull Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> getTraceClassAnalyses() {
		return traceClassAnalyses;
	}

	public @NonNull Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> getTracePropertyAnalyses() {
		return tracePropertyAnalyses;
	}
}
