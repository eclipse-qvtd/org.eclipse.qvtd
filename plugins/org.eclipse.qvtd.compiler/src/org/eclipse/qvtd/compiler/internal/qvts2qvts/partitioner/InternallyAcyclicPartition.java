/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An InternallyAcyclicPartition comprises one of more nested partitions whose inter-dependencies are acyclic.
 *
 * A derived RootPartition defines the overall schedule. A derived CyclicPartiion encapsulates a cycle as
 * internally acyclic content to be cycled externally.
 */
public interface InternallyAcyclicPartition extends Partition
{
	@NonNull List<@NonNull Iterable<@NonNull Partition>> getPartitionSchedule();

	@NonNull Iterable<@NonNull Partition> getPartitions();

	//	@NonNull List<@NonNull Collection<@NonNull Region>> getRegionSchedule();

	@NonNull Iterable<@NonNull TraceClassPartitionAnalysis> getTraceClassAnalyses();

	@NonNull Iterable<@NonNull TracePropertyPartitionAnalysis> getTracePropertyAnalyses();
}