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
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The ResidualPartition copies everything adjuting to the preceding ActivatorPartotion.
 */
class ResidualPartition extends AbstractPartialPartition
{
	public ResidualPartition(@NonNull MappingPartitioner partitioner, @NonNull ReachabilityForest reachabilityForest) {
		super(partitioner, reachabilityForest, "«residue»");
		//		Iterable<@NonNull Node> predicatedMiddleNodes = partitioner.getPredicatedMiddleNodes();
		//		assert Iterables.isEmpty(predicatedMiddleNodes);
		//
		//	The trace nodes are always predicated.
		//
		for (@NonNull Node node : partitioner.getTraceNodes()) {
			if (!hasNode(node)) {
				addNode(node, Role.SPECULATED);
			}
			Node localSuccessNode = partitioner.basicGetLocalSuccessNode(node);
			if (localSuccessNode != null) {		// ?? localSuccess property is not mandatory
				addNode(localSuccessNode, Role.PREDICATED);
			}
		}
		//
		//	All other nodes are as is
		//
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(partitioner.getRegion())) {
			if (!hasNode(node)) {
				addNode(node);
			}
		}
		//
		//	Ensure that the predecessors of each node are included in the partition.
		//
		resolvePrecedingNodes();
		//
		//	Join up the edges.
		//
		resolveEdges();
	}

	@Override
	public @NonNull MappingRegion createMicroMappingRegion(int partitionNumber) {
		return createMicroMappingRegion("«residue»", "_p" + partitionNumber);
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			if (partitioner.hasRealizedEdge(edge)) {
				edgeRole = Role.PREDICATED;
			}
		}
		return edgeRole;
	}
}