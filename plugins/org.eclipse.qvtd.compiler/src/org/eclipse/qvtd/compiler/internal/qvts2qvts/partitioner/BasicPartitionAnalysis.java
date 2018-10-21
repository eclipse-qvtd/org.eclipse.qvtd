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

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Sets;

public class BasicPartitionAnalysis extends MappingPartitionAnalysis<BasicPartition>
{
	/**
	 * The mechanisms to reach required nodes.
	 */
	private final @NonNull ReachabilityForest reachabilityForest;

	private @Nullable Set<@NonNull PartitionAnalysis> explicitPredecessors = null;
	private @Nullable MicroMappingRegion microMappingRegion = null;
	private @NonNull String namePrefix = "";
	private @NonNull String symbolSuffix = "";

	public BasicPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull BasicPartition partition,
			@NonNull ReachabilityForest reachabilityForest, @NonNull String namePrefix, @NonNull String symbolSuffix) {
		super(partitionedTransformationAnalysis, partition);
		this.reachabilityForest = reachabilityForest;
		this.namePrefix = namePrefix;
		this.symbolSuffix = symbolSuffix;
		partitionedTransformationAnalysis.addPartitionAnalysis(this);
	}

	@Override
	public void analyzePartition2() {
		super.analyzePartition2();
		this.explicitPredecessors = Sets.newHashSet(partitionedTransformationAnalysis.getPartitionAnalyses(QVTscheduleUtil.getExplicitPredecessors(partition)));
	}

	@Override
	public @NonNull MappingRegion createMicroMappingRegion() {
		assert microMappingRegion  == null;
		assert !(partition.getRegion() instanceof MicroMappingRegion);
		MicroMappingRegion partialRegion = QVTscheduleFactory.eINSTANCE.createMicroMappingRegion();
		scheduleManager.addMappingRegion(partialRegion);
		partialRegion.setMappingRegion((MappingRegion) partition.getRegion());
		partialRegion.setNamePrefix(namePrefix);
		partialRegion.setSymbolNameSuffix(symbolSuffix);
		partialRegion.setName(namePrefix + " " + partition.getRegion().getName());
		this.microMappingRegion = partialRegion;
		/*	check(microMappingRegion); */
		return microMappingRegion;
	}

	@Override
	public @Nullable Set<@NonNull PartitionAnalysis> getExplicitPredecessors() {
		return explicitPredecessors;
	}

	@Override
	public @NonNull MappingRegion getMicroMappingRegion() {
		return ClassUtil.nonNullState(microMappingRegion);
	}

	protected @NonNull Iterable<@NonNull Node> getPredecessors(@NonNull Node targetNode) {
		return reachabilityForest.getPredecessors(targetNode);
	}

	//	@Override
	@Override
	public @NonNull ReachabilityForest getReachabilityForest() {
		return reachabilityForest;
	}

	@Override
	public boolean isAwaited(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		return role != null ? role.isAwaited() : false; //edge.isPredicated();
	}
}