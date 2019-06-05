/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.AbstractPartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionPropertyAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * PartitionAnalysis captures the analysis of a Partition.
 */
public abstract class AbstractPartitionAnalysis<@NonNull P extends Partition> extends AbstractPartialRegionAnalysis<@NonNull PartitionsAnalysis> implements PartitionAnalysis
{
	protected final @NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis;
	protected final @NonNull P partition;

	protected AbstractPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull P partition) {
		super(partitionedTransformationAnalysis);
		this.partitionedTransformationAnalysis = partitionedTransformationAnalysis;
		this.partition = partition;

	}

	public void analyzePartition() {}

	public void analyzePartition2() {}

	/**
	 * Register all predicated and realized edges with the partitioned transformation analysis.
	 */
	@Override
	public void analyzePartitionEdges(@Nullable StringBuilder s) {}

	@Override
	public @NonNull Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> getClassAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @Nullable Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> getExplicitPredecessors() {
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
	public @NonNull PartitionedTransformationAnalysis getPartitionedTransformationAnalysis() {
		return partitionedTransformationAnalysis;
	}

	@Override
	public @NonNull Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis>> getPropertyAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Region getRegion() {
		return QVTscheduleUtil.getRegion(partition);
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