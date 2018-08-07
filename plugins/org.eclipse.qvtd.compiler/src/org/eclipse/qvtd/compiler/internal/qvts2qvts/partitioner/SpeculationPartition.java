/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Sets;

/**
 * The SpeculationPartition identifies the nodes and edges required in a speculation micro-mapping
 * which creates the speculated trace with predicates solely on constant inputs, loaded inputs
 * and acyclic predicated nodes.
 */
//
// FIXME if multiple heads are predicated, we cannot wait for all of them before speculating. Speculation
//	may need to consider just loaded nodes.
//
class SpeculationPartition extends AbstractPartialPartition
{
	private final @NonNull Set<@NonNull Node> headNodes;

	public SpeculationPartition(@NonNull MappingPartitioner partitioner, @NonNull ReachabilityForest reachabilityForest) {
		super(partitioner, reachabilityForest, "«speculation»");
		this.headNodes = Sets.newHashSet(QVTscheduleUtil.getHeadNodes(region));
		//
		//	The realized middle (trace) nodes become speculation nodes.
		//
		for (@NonNull Node traceNode : partitioner.getTraceNodes()) {
			addNode(traceNode, Role.SPECULATION);
		}
		//
		//	All old nodes reachable from heads that are not part of cycles are copied to the speculation guard.
		//	NB. Unreachable loaded nodes are effectively predicates and so are deferred.
		//
		for (@NonNull Node node : headNodes) {
			addReachableOldAcyclicNodes(node);
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
		//	Ensure that re-used trace classes do not lead to ambiguous mappings.
		//
		resolveDisambiguations();
		//
		//	Join up the edges.
		//
		resolveEdges();
	}

	/**
	 * Add all old nodes, including node, that have no cyclic dependency and are reachable by to-one navigation from node.
	 */
	protected void addReachableOldAcyclicNodes(@NonNull Node node) {
		if (!hasNode(node) && (node.isHead() || node.isOld() && !partitioner.isCyclic(node))) {
			addNode(node, QVTscheduleUtil.getNodeRole(node));
			for (@NonNull NavigableEdge edge : node.getNavigableEdges()) {
				if (edge.isOld()) {
					addReachableOldAcyclicNodes(edge.getEdgeTarget());
				}
			}
		}
	}

	@Override
	public @NonNull MappingRegion createMicroMappingRegion(int partitionNumber) {
		return createMicroMappingRegion("«speculation»", "_p" + partitionNumber);
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