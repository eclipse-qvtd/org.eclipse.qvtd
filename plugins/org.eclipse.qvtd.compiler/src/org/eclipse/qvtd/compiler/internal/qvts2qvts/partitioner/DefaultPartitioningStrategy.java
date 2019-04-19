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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * DefaultPartitioningStrategy the creation of a QVTr-style suite of Partitions with activators.
 */
public class DefaultPartitioningStrategy extends AbstractPartitioningStrategy
{
	protected final @NonNull List<@NonNull Node> realizedWhenNodes;
	protected final List<@NonNull Node> predicatedWhenNodes;

	public DefaultPartitioningStrategy(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull MappingPartitioner mappingPartitioner) {
		super(partitionedTransformationAnalysis, mappingPartitioner);
		assert scheduleManager.useActivators();
		this.realizedWhenNodes = mappingPartitioner.getRealizedWhenNodes();
		this.predicatedWhenNodes = mappingPartitioner.getPredicatedWhenNodes();
	}

	@Override
	public @NonNull Iterable<@NonNull PartitionAnalysis> partition() {
		//
		//	Create the partitioned regions
		//
		createActivatorPartition();
		createWhenPartitions();
		//
		boolean isCyclic = transformationAnalysis.isCyclic(regionAnalysis);
		boolean hasPredication = (predicatedWhenNodes.size() > 0) || (realizedWhenNodes.size() > 0);
		boolean needsSpeculation = isCyclic && hasPredication; //(dispatchedTraceNodes2.isEmpty() ? !predicatedMiddleNodes.isEmpty() : !predicatedMiddleNodes.containsAll(dispatchedTraceNodes2));
		if (!needsSpeculation) {
			//
			//	If speculation is not needed just add the functionality as a single region.
			//
			if (newPartitionAnalyses.isEmpty()) {		// i.e. a QVTr non top relation - re-use as is
				createNonPartition();
			}
			else {							// i.e. a QVTr top relation - create a residue to finish off the activator
				createResidualPartition();
			}
		}
		else {								// cycles may need speculation and partitioning into isolated actions
			createSpeculationPartitions();
			createAssignmentPartitions();
		}
		check();
		return newPartitionAnalyses;
	}

	protected void createNonPartition() {
		newPartitionAnalyses.add(new NonPartitionFactory(mappingPartitioner).createPartitionAnalysis(partitionedTransformationAnalysis));
	}

	protected void createActivatorPartition() {
		List<@NonNull Node> realizedExecutionNodes = mappingPartitioner.getRealizedExecutionNodes();
		//
		//	Create the partitioned regions
		//
		if (realizedExecutionNodes.size() > 0)	{			// A 'single' realized "trace" node is a boring no-override top activation.
			//
			//	Create an activator to make a QVTr top relation behave as a non-top relation.
			//
			newPartitionAnalyses.add(new ActivatorPartitionFactory(mappingPartitioner).createPartitionAnalysis(partitionedTransformationAnalysis));
		}
	}

	protected void createResidualPartition() {
		newPartitionAnalyses.add(new ResidualPartitionFactory(mappingPartitioner).createPartitionAnalysis(partitionedTransformationAnalysis));
	}

	protected void createWhenPartitions() {
		if (realizedWhenNodes.size() > 0) {
			newPartitionAnalyses.add(new WhenPartitionFactory(mappingPartitioner, useActivators()).createPartitionAnalysis(partitionedTransformationAnalysis));
		}
	}

	@Override
	protected boolean useActivators() {
		return true;
	}
}