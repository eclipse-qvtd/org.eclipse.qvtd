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

/**
 * Each CycleAnalysis identifies one group of regionAnalyses that contribute to a cycle.
 */
public class CyclePartitionAnalysis implements CycleAnalysis<@NonNull Partition>
{
	protected final @NonNull CyclesAnalysis<@NonNull Partition> cyclesAnalysis;
	protected final @NonNull Set<@NonNull Partition> regionAnalyses;
	protected final @NonNull Set<@NonNull TraceClassAnalysis<@NonNull Partition>> traceClassAnalyses;
	protected final @NonNull Set<@NonNull TracePropertyAnalysis<@NonNull Partition>> tracePropertyAnalyses;

	public CyclePartitionAnalysis(@NonNull CyclesAnalysis<@NonNull Partition> cyclesAnalysis, @NonNull Set<@NonNull Partition> regionAnalyses,
			@NonNull Set<@NonNull TraceClassAnalysis<@NonNull Partition>> traceClassAnalyses, @NonNull Set<@NonNull TracePropertyAnalysis<@NonNull Partition>> tracePropertyAnalyses) {
		this.cyclesAnalysis = cyclesAnalysis;
		this.regionAnalyses = regionAnalyses;
		this.traceClassAnalyses = traceClassAnalyses;
		this.tracePropertyAnalyses = tracePropertyAnalyses;
		assert !regionAnalyses.isEmpty();
		assert !traceClassAnalyses.isEmpty() || !tracePropertyAnalyses.isEmpty();
	}

	@Override
	public @NonNull Iterable<@NonNull Partition> getRegionAnalyses() {
		return regionAnalyses;
	}

	@Override
	public @NonNull Iterable<@NonNull TraceClassAnalysis<@NonNull Partition>> getTraceClassAnalyses() {
		return traceClassAnalyses;
	}

	@Override
	public @NonNull Iterable<@NonNull TracePropertyAnalysis<@NonNull Partition>> getTracePropertyAnalyses() {
		return tracePropertyAnalyses;
	}
}
