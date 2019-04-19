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
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import com.google.common.collect.Iterables;

/**
 * AbstractPartitioningStrategy provides the default/mandatory supervision of the creation of an appropriate suite of Partitions for a Region.
 */
public class AbstractPartitioningStrategy implements PartitioningStrategy
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis;
	protected final @NonNull MappingPartitioner mappingPartitioner;
	protected final @NonNull AbstractTransformationAnalysis transformationAnalysis;;
	protected final @NonNull RegionAnalysis regionAnalysis;;

	public AbstractPartitioningStrategy(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull MappingPartitioner mappingPartitioner) {
		this.scheduleManager = partitionedTransformationAnalysis.getScheduleManager();
		this.partitionedTransformationAnalysis = partitionedTransformationAnalysis;
		this.mappingPartitioner = mappingPartitioner;
		this.transformationAnalysis = mappingPartitioner.getTransformationAnalysis();
		this.regionAnalysis = mappingPartitioner.getRegionAnalysis();
	}

	@Override
	public @NonNull Iterable<@NonNull PartitionAnalysis> partition() {
		boolean isCyclic = transformationAnalysis.isCyclic(regionAnalysis);
		//	boolean isInfallible = false;
		//	if (cycleAnalysis != null) {
		//		isInfallible = cycleAnalysis.isInfallible();
		//	}
		boolean hasPredication = false;
		boolean needsActivator = false;
		List<@NonNull Node> realizedWhenNodes = mappingPartitioner.getRealizedWhenNodes();
		boolean useActivators = scheduleManager.useActivators();
		if (useActivators) {		// QVTr
			List<@NonNull Node> predicatedWhenNodes = mappingPartitioner.getPredicatedWhenNodes();
			hasPredication = (predicatedWhenNodes.size() > 0) || (realizedWhenNodes.size() > 0);
			List<@NonNull Node> realizedExecutionNodes = mappingPartitioner.getRealizedExecutionNodes();
			if (realizedExecutionNodes.size() > 0)	{			// A 'single' realized "trace" node is a boring no-override top activation.
				needsActivator = true;
			}
			else {
				needsActivator = false;
			}
		}
		else {		// legacy QVTc
			Iterable<@NonNull Node> predicatedMiddleNodes = mappingPartitioner.getPredicatedMiddleNodes();
			hasPredication = !Iterables.isEmpty(predicatedMiddleNodes);
		}
		boolean needsSpeculation = isCyclic && hasPredication; //(dispatchedTraceNodes2.isEmpty() ? !predicatedMiddleNodes.isEmpty() : !predicatedMiddleNodes.containsAll(dispatchedTraceNodes2));
		//
		//	Create the partitioned regions
		//
		List<@NonNull PartitionAnalysis> newPartitionAnalyses = new ArrayList<>();
		if (needsActivator) {
			//
			//	Create an activator to make a QVTr top relation behave as a non-top relation.
			//
			newPartitionAnalyses.add(new ActivatorPartitionFactory(mappingPartitioner).createPartitionAnalysis(partitionedTransformationAnalysis));
		}
		if (realizedWhenNodes.size() > 0) {
			newPartitionAnalyses.add(new WhenPartitionFactory(mappingPartitioner, useActivators).createPartitionAnalysis(partitionedTransformationAnalysis));
		}
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
			//			if (isInfallible) {
			//				regionAnalysis.getFallibilities()
			//			}
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
		//		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
		//			for (@NonNull PartitionAnalysis partitionAnalysis : newPartitionAnalyses) {
		//				scheduleManager.writeDebugGraphs(partitionAnalysis.getPartition(), null);
		//			}
		//		}
		if (newPartitionAnalyses.size() > 1) {		// FIXME shouldn't this work anyway when no partitioning was needed?
			mappingPartitioner.check(/*isInfallible*/);
		}
		return newPartitionAnalyses;
	}
}