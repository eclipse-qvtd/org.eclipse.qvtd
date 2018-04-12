/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * The RealizedPartition identifies the nodes and edges required by an unspeculated micro-mapping
 * which directly creates the realized variables.
 */
class zzNewRealizedPartition extends AbstractPartition
{
	public zzNewRealizedPartition(@NonNull MappingPartitioner partitioner, @NonNull ReachabilityForest reachabilityForest) {
		super(partitioner, reachabilityForest);
		Iterable<@NonNull Node> predicatedMiddleNodes = partitioner.getPredicatedMiddleNodes();
		assert Iterables.isEmpty(predicatedMiddleNodes);
		//
		//	The trace nodes are always realized.
		//
		for (@NonNull Node node : partitioner.getTraceNodes()) {
			if (!hasNode(node)) {
				addNode(node, Role.PREDICATED);
			}
		}
		//
		//	The ends of loaded navigation edges are retained as is for the predicate.
		//
		addLoadedNavigationEdgeSourceAndTargetNodes();
		//
		//	The realized nodes are realized as is.
		//
		for (@NonNull Node node : partitioner.getRealizedOutputNodes()) {
			if (!hasNode(node)) {
				addNode(node);
			}
		}
		//
		//	Add the outstanding predicates that can be checked by this partition.
		//
		//		resolveTrueNodes();
		//
		//	Ensure that the predecessors of each node are included in the partition.
		//
		resolvePrecedingNodes();
		//
		//	Join up the edges.
		//
		resolveEdges();
	}

	/**
	 * Add the ends of all the loaded edges. This gathers the loaded PatternNodeRoles and also the
	 * odd-balls such as Null nodes.
	 */
	protected void addLoadedNavigationEdgeSourceAndTargetNodes() {
		for (@NonNull NavigableEdge edge : region.getNavigationEdges()) {
			if (edge.isLoaded()) {
				Node sourceNode = edge.getEdgeSource();
				Node targetNode = edge.getEdgeTarget();
				if (!hasNode(sourceNode)) {
					addNode(sourceNode, QVTscheduleUtil.getNodeRole(sourceNode));
				}
				if (!hasNode(targetNode)) {
					addNode(targetNode, QVTscheduleUtil.getNodeRole(targetNode));
				}
			}
		}
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