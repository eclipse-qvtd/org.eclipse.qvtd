/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The Residual Partition copies everything adjuting to the preceding ActivatorPartotion.
 */
public class ResidualPartitionFactory extends AbstractSimplePartitionFactory
{
	public ResidualPartitionFactory(@NonNull MappingPartitioner mappingPartitioner) {
		super(mappingPartitioner);
	}

	@Override
	public @NonNull BasicPartitionAnalysis createPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		ReachabilityForest reachabilityForest = createReachabilityForest();
		String name = computeName("residue");
		Iterable<@NonNull Node> headNodes = mappingPartitioner.getTraceNodes();
		BasicPartition partition = createBasicPartition(name, headNodes);
		int partitionNumber = region.getNextPartitionNumber();
		BasicPartitionAnalysis basicPartitionAnalysis = new BasicPartitionAnalysis(partitionedTransformationAnalysis, partition, reachabilityForest, "«residue»", "_p" + partitionNumber);
		initializePartition(basicPartitionAnalysis);
		return basicPartitionAnalysis;
	}

	protected void initializePartition(@NonNull BasicPartitionAnalysis partitionAnalysis) {
		BasicPartition partition = partitionAnalysis.getPartition();
		//		Iterable<@NonNull Node> predicatedMiddleNodes = partitioner.getPredicatedMiddleNodes();
		//		assert Iterables.isEmpty(predicatedMiddleNodes);
		//
		//	The trace nodes are always predicated.
		//
		for (@NonNull Node node : mappingPartitioner.getTraceNodes()) {
			if (!partition.hasNode(node)) {
				addNode(partition, node, Role.SPECULATED);
			}
			Node localSuccessNode = mappingPartitioner.basicGetLocalSuccessNode(node);
			if (localSuccessNode != null) {		// ?? localSuccess property is not mandatory
				addNode(partition, localSuccessNode, Role.PREDICATED);
			}
		}
		//
		//	All other nodes are as is
		//
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			if (!partition.hasNode(node)) {
				addNode(partition, node);
			}
		}
		//
		//	Ensure that the predecessors of each node are included in the partition.
		//
		resolvePrecedingNodes(partitionAnalysis);
		//
		//	Join up the edges.
		//
		resolveEdges(partitionAnalysis);
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			if (mappingPartitioner.hasRealizedEdge(edge)) {
				edgeRole = Role.PREDICATED;
			}
		}
		return edgeRole;
	}
}