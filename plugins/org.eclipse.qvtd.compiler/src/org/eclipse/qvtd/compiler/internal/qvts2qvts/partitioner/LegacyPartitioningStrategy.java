/*******************************************************************************
 * Copyright (c) 2019, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

import com.google.common.collect.Iterables;

/**
 * LegacyPartitioningStrategysupervises the creation of a QVTc-style suite of Partitions without activators.
 */
public class LegacyPartitioningStrategy extends AbstractPartitioningStrategy
{
	public LegacyPartitioningStrategy(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull MappingPartitioner mappingPartitioner) {
		super(partitionedTransformationAnalysis, mappingPartitioner);
		assert !scheduleManager.useActivators();
	}

	@Override
	public @NonNull Iterable<@NonNull PartitionAnalysis> partition() {
		Iterable<@NonNull Node> predicatedMiddleNodes = mappingPartitioner.getPredicatedMiddleNodes();
		boolean hasPredication = !Iterables.isEmpty(predicatedMiddleNodes);
		boolean isCyclic = transformationAnalysis.basicGetCyclicRegionAnalysis(regionAnalysis) != null;
		boolean needsSpeculation = isCyclic && hasPredication; //(dispatchedTraceNodes2.isEmpty() ? !predicatedMiddleNodes.isEmpty() : !predicatedMiddleNodes.containsAll(dispatchedTraceNodes2));
		//
		//	Create the partitioned regions
		//
		//	List<@NonNull Node> realizedWhenNodes = mappingPartitioner.getRealizedWhenNodes();
		//	createWhenPartitions(realizedWhenNodes);
		if (!needsSpeculation) {
			//
			//	If speculation is not needed just add the functionality as a single region.
			//
			if (newPartitionAnalyses.isEmpty()) {		// i.e. a QVTr non top relation - re-use as is
				newPartitionAnalyses.add(new NonPartitionFactory(mappingPartitioner).createPartitionAnalysis(partitionedTransformationAnalysis));
			}
			else {							// i.e. a QVTr top relation - create a residue to finish off the activator
				newPartitionAnalyses.add(new ResidualPartitionFactory(mappingPartitioner).createPartitionAnalysis(partitionedTransformationAnalysis));
			}
		}
		else {								// cycles may need speculation and partitioning into isolated actions
			createSpeculationPartitions();
			createAssignmentPartitions();
		}
		check();
		return newPartitionAnalyses;
	}

	@Override
	protected boolean useActivators() {
		return false;
	}
}