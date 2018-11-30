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
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Role;

/**
 * PartitionAnalysis captures the analysis of a Partition.
 */
public abstract class AbstractPartitionAnalysis<P extends Partition> implements PartitionAnalysis
{
	protected final @NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis;
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull P partition;

	protected AbstractPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull P partition) {
		this.partitionedTransformationAnalysis = partitionedTransformationAnalysis;
		this.scheduleManager = partitionedTransformationAnalysis.getScheduleManager();
		this.partition = partition;

	}

	@Override
	public void addEnforcedEdge(@NonNull NavigableEdge realizedEdge) {}

	public void analyzePartition() {}

	public void analyzePartition2() {}

	/**
	 * Register all predicated and realized edges with the partitioned transformation analysis.
	 */
	@Override
	public void analyzePartitionEdges() {}

	@Override
	public void computeCheckedOrEnforcedEdges() {}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getConsumedTraceClassAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getConsumedTracePropertyAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Set<@NonNull PartitionAnalysis> getExplicitPredecessors() {
		return null;
	}

	@Override
	public @NonNull String getName() {
		return partition.getName();
	}

	@Override
	public @NonNull P getPartition() {
		return partition;
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getProducedTraceClassAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getProducedTracePropertyAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getSuperProducedTraceClassAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Iterable<@NonNull TraceClassPartitionAnalysis> getTraceClassAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Iterable<@NonNull TracePropertyPartitionAnalysis> getTracePropertyAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull List<@NonNull Node> getTraceNodes() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isChecked(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isChecked();
	}

	@Override
	public String toString() {
		return partition.toString();
	}
}