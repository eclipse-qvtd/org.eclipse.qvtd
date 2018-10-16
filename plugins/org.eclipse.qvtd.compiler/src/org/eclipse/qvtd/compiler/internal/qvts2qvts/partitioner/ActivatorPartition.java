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
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The ActivatorPartition creates the realized trace node ftom one (or more) head nodes
 * exploiting the uniqueness of the micromapping invocation to share duplicate attempts at realization.
 *
 * FIXME. This functionality should eventually be absorbed into the roor region together with
 * smart loops to resolve secondary heads from a primary head.
 */
public class ActivatorPartition extends AbstractPartialPartition
{
	public static class ActivatorPartitionFactory extends AbstractPartitionFactory
	{
		public ActivatorPartitionFactory(@NonNull MappingPartitioner mappingPartitioner) {
			super(mappingPartitioner);
		}

		@Override
		public @NonNull ActivatorPartition createPartition() {
			ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(mappingPartitioner), getAvailableNavigableEdges(mappingPartitioner));
			return new ActivatorPartition(mappingPartitioner, reachabilityForest);
		}
	}

	protected ActivatorPartition(@NonNull MappingPartitioner partitioner, @NonNull ReachabilityForest reachabilityForest) {
		super(computeName(partitioner, "activator"), partitioner, reachabilityForest);
		Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(originalRegion);
		//
		//	The realized middle (trace) nodes become speculation nodes.
		//
		for (@NonNull Node traceNode : partitioner.getTraceNodes()) {
			addNode(traceNode, Role.SPECULATION);
		}
		//
		//	The head nodes remain as loaded/predicated nodes.
		//
		for (@NonNull Node headNode : headNodes) {
			if (!headNode.isDependency()) {
				addNode(headNode);
			}
		}
		//
		//	Add the outstanding predicates that can be checked by this partition.
		//
		//		resolveTrueNodes();
		//
		//	Ensure that the predecessors of each node are included in the partition.
		//
		//		resolvePrecedingNodes();
		//
		//	Ensure that re-used trace classes do not lead to ambiguous mappings.
		//
		//		resolveDisambiguations();
		//
		//	Join up the edges.
		//
		resolveEdges();
	}

	/**
	 * Add all old nodes, including node, that have no cyclic dependency and are reachable by to-one navigation from node.
	 */
	protected void addReachableOldAcyclicNodes(@NonNull Node node) {
		if (!hasNode(node) && (node.isHead() || isOld(node) && !partitioner.isCyclic(node))) {
			addNode(node, QVTscheduleUtil.getNodeRole(node));
			for (@NonNull NavigableEdge edge : node.getNavigableEdges()) {
				if (isOld(edge)) {
					addReachableOldAcyclicNodes(edge.getEdgeTarget());
				}
			}
		}
	}

	@Override
	public @NonNull MappingRegion createMicroMappingRegion() {
		int partitionNumber = originalRegion.getNextPartitionNumber();
		return createMicroMappingRegion("«activator»", "_p" + partitionNumber);
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getHeadNodes() {
		return QVTscheduleUtil.getHeadNodes(originalRegion);
	}

	/**
	 * Return a prioritized hint for the choice of head nodes.
	 * The override implementation returns null for no hint.
	 */
	@Override
	protected @Nullable Iterable<@NonNull Node> getPreferredHeadNodes() {
		return null;
	}

	/**
	 * Return true if edge is available for use by this partition.
	 * The override implementation returns true for all constant and loaded edges.
	 */
	@Override
	protected boolean isAvailable(@NonNull Edge edge) {
		return edge.isConstant() || edge.isLoaded();
	}

	/**
	 * Return true if node is available for use by this partition.
	 * The override implementation returns true for all constant and loaded nodes.
	 */
	@Override
	protected boolean isAvailable(@NonNull Node node) {
		return node.isConstant() || node.isLoaded();
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			assert !partitioner.hasRealizedEdge(edge);
		}
		return edgeRole;
	}
}