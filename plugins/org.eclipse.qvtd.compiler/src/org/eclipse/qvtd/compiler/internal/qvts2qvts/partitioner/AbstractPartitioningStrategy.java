/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;

/**
 * AbstractPartitioningStrategy provides the default/mandatory supervision of the creation of an appropriate suite of Partitions for a Region.
 */
public abstract class AbstractPartitioningStrategy implements PartitioningStrategy
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis;
	protected final @NonNull MappingPartitioner mappingPartitioner;
	protected final @NonNull AbstractTransformationAnalysis transformationAnalysis;
	protected final @NonNull RegionAnalysis regionAnalysis;
	//
	//	Working list of PartitionAnalysi to return from partition().
	//
	protected final @NonNull List<@NonNull PartitionAnalysis> newPartitionAnalyses = new ArrayList<>();

	protected AbstractPartitioningStrategy(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull MappingPartitioner mappingPartitioner) {
		this.scheduleManager = partitionedTransformationAnalysis.getScheduleManager();
		this.partitionedTransformationAnalysis = partitionedTransformationAnalysis;
		this.mappingPartitioner = mappingPartitioner;
		this.transformationAnalysis = mappingPartitioner.getTransformationAnalysis();
		this.regionAnalysis = mappingPartitioner.getRegionAnalysis();
	}

	protected void check() {
		if (newPartitionAnalyses.size() > 1) {		// FIXME shouldn't this work anyway when no partitioning was needed?
			mappingPartitioner.check(/*isInfallible*/);
		}
	}

	protected void createAssignmentPartitions() {
		//
		//	Create an AssignmentRegion for each still to-be-realized edge to an output which may well result
		//  in two realized edges.
		//
		for (@NonNull NavigableEdge outputEdge : mappingPartitioner.getRealizedOutputEdges()) {
			if (!mappingPartitioner.hasRealizedEdge(outputEdge)) {
				newPartitionAnalyses.add(new AssignmentPartitionFactory(mappingPartitioner, outputEdge).createPartitionAnalysis(partitionedTransformationAnalysis));
			}
		}
		//
		//	Create an AssignmentRegion for each still to-be-realized edge.
		//
		for (@NonNull NavigableEdge edge : mappingPartitioner.getRealizedEdges()) {
			if (!mappingPartitioner.hasRealizedEdge(edge)) {
				newPartitionAnalyses.add(new AssignmentPartitionFactory(mappingPartitioner, edge).createPartitionAnalysis(partitionedTransformationAnalysis));
			}
		}
	}

	protected void createSpeculationPartitions() {
		boolean useActivators = useActivators();
		if (useActivators) {
			regionAnalysis.createLocalSuccess();
		}
		BasicPartitionAnalysis localPredicatePartition = new LocalPredicatePartitionFactory(mappingPartitioner, useActivators).createPartitionAnalysis(partitionedTransformationAnalysis);
		BasicPartitionAnalysis globalPredicatePartition = new GlobalPredicatePartitionFactory(mappingPartitioner).createPartitionAnalysis(partitionedTransformationAnalysis);
		BasicPartitionAnalysis speculatedPartition = new SpeculatedPartitionFactory(mappingPartitioner).createPartitionAnalysis(partitionedTransformationAnalysis);
		newPartitionAnalyses.add(localPredicatePartition);
		newPartitionAnalyses.add(globalPredicatePartition);
		newPartitionAnalyses.add(speculatedPartition);
		if (!useActivators) {
			globalPredicatePartition.addExplicitPredecessor(localPredicatePartition);
			speculatedPartition.addExplicitPredecessor(globalPredicatePartition);
		}
	}

	protected abstract boolean useActivators();
}