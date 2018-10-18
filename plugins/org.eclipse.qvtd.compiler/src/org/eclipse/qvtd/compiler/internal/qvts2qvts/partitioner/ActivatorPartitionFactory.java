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
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * The Activator Partition creates the realized trace node ftom one (or more) head nodes
 * exploiting the uniqueness of the micromapping invocation to share duplicate attempts at realization.
 *
 * FIXME. This functionality should eventually be absorbed into the roor region together with
 * smart loops to resolve secondary heads from a primary head.
 */
public class ActivatorPartitionFactory extends AbstractPartitionFactory
{
	public ActivatorPartitionFactory(@NonNull MappingPartitioner mappingPartitioner) {
		super(mappingPartitioner);
	}

	/**
	 * Add all old nodes, including node, that have no cyclic dependency and are reachable by to-one navigation from node.
	 *
		protected void addReachableOldAcyclicNodes(@NonNull Node node) {
			if (!hasNode(node) && (node.isHead() || isOld(node) && !partitioner.isCyclic(node))) {
				addNode(node, QVTscheduleUtil.getNodeRole(node));
				for (@NonNull NavigableEdge edge : node.getNavigableEdges()) {
					if (isOld(edge)) {
						addReachableOldAcyclicNodes(edge.getEdgeTarget());
					}
				}
			}
		} */

	@Override
	public @NonNull BasicPartition createPartition() {
		ReachabilityForest reachabilityForest = createReachabilityForest();
		String name = computeName("activator");
		Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(region);
		BasicPartition partition = new BasicPartition(name, mappingPartitioner.getScheduleManager(), region, headNodes, reachabilityForest);
		int partitionNumber = region.getNextPartitionNumber();
		partition.initMicroMappingRegion("«activator»", "_p" + partitionNumber);
		initializePartition(partition);
		return partition;
	}

	protected void initializePartition(@NonNull BasicPartition partition) {
		Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(region);
		//
		//	The realized middle (trace) nodes become speculation nodes.
		//
		for (@NonNull Node traceNode : mappingPartitioner.getTraceNodes()) {
			addNode(partition, traceNode, Role.SPECULATION);
		}
		//
		//	The head nodes remain as loaded/predicated nodes.
		//
		for (@NonNull Node headNode : headNodes) {
			if (!headNode.isDependency()) {
				addNode(partition, headNode);
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
		resolveEdges(partition);
	}

	@Override
	protected @NonNull Iterable<@NonNull Node> getReachabilityRootNodes() {
		Iterable<@NonNull Node> traceNodes = mappingPartitioner.getTraceNodes();
		Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(mappingPartitioner.getRegion());
		return Iterables.concat(traceNodes, headNodes);
	}

	/**
	 * Return true if edge is available for use by this partition.
	 * The override implementation returns true for all constant and loaded edges.
	 */
	//	@Override
	//	protected boolean isAvailable(@NonNull Edge edge) {
	//		return edge.isConstant() || edge.isLoaded();
	//	}

	/**
	 * Return true if node is available for use by this partition.
	 * The override implementation returns true for all constant and loaded nodes.
	 */
	@Override
	protected boolean isAvailable(@NonNull BasicPartition partition, @NonNull Node node) {
		return node.isConstant() || node.isLoaded();
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			assert !mappingPartitioner.hasRealizedEdge(edge);
		}
		return edgeRole;
	}
}
