/*******************************************************************************
 * Copyright (c) 2018, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public class BasicPartitionAnalysis extends MappingPartitionAnalysis<@NonNull BasicPartition>
{
	/**
	 * The mechanisms to reach required nodes.
	 */
	private final @NonNull ReachabilityForest reachabilityForest;

	private @Nullable Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> explicitPredecessors = null;
	//	private final @NonNull String namePrefix;
	//	private final @NonNull String symbolSuffix;

	public BasicPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull BasicPartition partition,
			@NonNull ReachabilityForest reachabilityForest, @NonNull String namePrefix, @NonNull String symbolSuffix) {
		super(partitionedTransformationAnalysis, partition);
		this.reachabilityForest = reachabilityForest;
		//	this.namePrefix = namePrefix;
		//	this.symbolSuffix = symbolSuffix;
		partitionedTransformationAnalysis.addPartitionAnalysis(this);
	}

	public void addExplicitPredecessor(@NonNull BasicPartitionAnalysis precedingPartitionAnalysis) {
		getPartition().addExplicitPredecessor(precedingPartitionAnalysis.getPartition());
		//	Set<@NonNull PartitionAnalysis> explicitPredecessors2 = this.explicitPredecessors;
		//	if (explicitPredecessors2 == null) {
		//		explicitPredecessors2 = new HashSet<>();
		//	}
		//	explicitPredecessors2.add(precedingPartitionAnalysis);
	}

	@Override
	public void analyzePartition2() {
		super.analyzePartition2();
		Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> partitionAnalyses = new HashSet<>();
		for (@NonNull Partition partition : QVTscheduleUtil.getExplicitPredecessors(partition)) {
			partitionAnalyses.add(partitionedTransformationAnalysis.getPartitionAnalysis(partition));
		}
		this.explicitPredecessors = partitionAnalyses;
		// FIXME derived trace property consumptions
	}

	/*	public void merge(@NonNull Map<@NonNull PartitionAnalysis, @Nullable PartitionAnalysis> old2new) {
		for (@NonNull PartitionAnalysis oldPartitionAnalysis : old2new.keySet()) {
			Partition oldPartition = oldPartitionAnalysis.getPartition();
			partition.destroy();
		}
		partitionedTransformationAnalysis.getRootPartitionAnalysis().merge(old2new);
	} */

	@Override
	public @Nullable Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> getExplicitPredecessors() {
		return explicitPredecessors;
	}

	protected @NonNull Iterable<@NonNull Node> getPredecessorsClosure(@NonNull Node targetNode) {
		return reachabilityForest.getPredecessorsClosure(targetNode);
	}

	//	@Override
	@Override
	public @NonNull ReachabilityForest getReachabilityForest() {
		return reachabilityForest;
	}

	@Override
	public boolean isChecked(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		return role != null ? role.isChecked() : false; //edge.isPredicated();
	}
}