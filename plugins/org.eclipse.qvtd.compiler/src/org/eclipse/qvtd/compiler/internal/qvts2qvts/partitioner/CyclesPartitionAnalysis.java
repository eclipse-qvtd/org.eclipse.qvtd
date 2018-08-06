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

/**
 * The CyclesAnalysis identifies a CyclicPartition for each group of allPartitions that contribute to a cycle.
 */
public class CyclesPartitionAnalysis extends CyclesAnalysis<@NonNull Partition>
{
	public CyclesPartitionAnalysis(@NonNull TransformationPartitioner transformationPartitioner, @NonNull Iterable<@NonNull Partition> allPartitions) {
		super(transformationPartitioner, allPartitions);
	}

	@Override
	protected @NonNull CycleAnalysis<@NonNull Partition> createCycleAnalysis(
			@NonNull Set<@NonNull Partition> cyclicRegionAnalyses,
			@NonNull Set<@NonNull TraceClassAnalysis<@NonNull Partition>> cyclicTraceClassAnalyses,
			@NonNull Set<@NonNull TracePropertyAnalysis<@NonNull Partition>> cyclicTracePropertyAnalyses) {
		return new CyclePartitionAnalysis(this, cyclicRegionAnalyses, cyclicTraceClassAnalyses, cyclicTracePropertyAnalyses);
	}
}
