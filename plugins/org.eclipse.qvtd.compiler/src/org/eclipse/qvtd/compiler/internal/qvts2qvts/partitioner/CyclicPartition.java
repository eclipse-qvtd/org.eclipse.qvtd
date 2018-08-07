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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.AbstractPartialRegionAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;

/**
 * Each CycleAnalysis identifies one group of regionAnalyses that contribute to a cycle.
 */
public class CyclicPartition extends AbstractPartialRegionAnalysis<@NonNull Partition> implements Partition, CycleAnalysis<@NonNull Partition>
{
	protected final @NonNull String name;
	protected final @NonNull CyclesPartitionAnalysis cyclesAnalysis;
	protected final @NonNull Set<@NonNull Partition> regionAnalyses;
	protected final @NonNull Set<@NonNull TraceClassAnalysis<@NonNull Partition>> traceClassAnalyses;
	protected final @NonNull Set<@NonNull TracePropertyAnalysis<@NonNull Partition>> tracePropertyAnalyses;

	public CyclicPartition(@NonNull String name, @NonNull CyclesPartitionAnalysis cyclesAnalysis, @NonNull Set<@NonNull Partition> regionAnalyses,
			@NonNull Set<@NonNull TraceClassAnalysis<@NonNull Partition>> traceClassAnalyses, @NonNull Set<@NonNull TracePropertyAnalysis<@NonNull Partition>> tracePropertyAnalyses) {
		super(cyclesAnalysis.getRegionsAnalysis(), QVTscheduleFactory.eINSTANCE.createCyclicMappingRegion());	// FIXME orphan region
		this.name = name;
		this.cyclesAnalysis = cyclesAnalysis;
		this.regionAnalyses = regionAnalyses;
		this.traceClassAnalyses = traceClassAnalyses;
		this.tracePropertyAnalyses = tracePropertyAnalyses;
		assert !regionAnalyses.isEmpty();
		assert !traceClassAnalyses.isEmpty() || !tracePropertyAnalyses.isEmpty();
	}

	@Override
	public void analyzePartition() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull MappingRegion createMicroMappingRegion(int partitionNumber) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	protected @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	protected @NonNull Iterable<@NonNull Node> getPartialNodes() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException();		// FIXME
	}

	@Override
	public @NonNull Partition getRA() {
		return this;
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

	@Override
	public @NonNull String toString() {
		return name;
	}
}
