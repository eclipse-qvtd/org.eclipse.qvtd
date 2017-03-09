/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;

import com.google.common.collect.Iterables;

/**
 * Each CycleAnalysis identifies one group of mappingPartitioners that contribute to a cycle.
 */
public class CycleAnalysis
{
	protected final @NonNull TransformationPartitioner transformationPartitioner;
	protected final @NonNull Set<@NonNull MappingPartitioner> mappingPartitioners;
	protected final @NonNull Set<@NonNull TraceClassAnalysis> traceClassAnalyses;

	public CycleAnalysis(@NonNull TransformationPartitioner transformationPartitioner, @NonNull Set<@NonNull MappingPartitioner> mappingPartitioners, @NonNull Set<@NonNull TraceClassAnalysis> traceClassAnalyses) {
		this.transformationPartitioner = transformationPartitioner;
		this.mappingPartitioners = mappingPartitioners;
		this.traceClassAnalyses = traceClassAnalyses;
	}

	public @NonNull Iterable<@NonNull MappingPartitioner> getMappingPartitioners() {
		return mappingPartitioners;
	}

	public @NonNull Iterable<@NonNull TraceClassAnalysis> getTraceClassAnalyses() {
		return traceClassAnalyses;
	}

	public @NonNull Iterable<@NonNull MappingRegion> partition(@NonNull Iterable<@NonNull MappingPartitioner> orderedMappingPartitioners) {
		List<@NonNull MappingRegion> partitionedRegions = new ArrayList<>();
		for (@NonNull MappingPartitioner mappingPartitioner : orderedMappingPartitioners) {
			if (mappingPartitioners.contains(mappingPartitioner)) {
				Iterables.addAll(partitionedRegions, mappingPartitioner.partition());
			}
		}
		return partitionedRegions;
	}
}
