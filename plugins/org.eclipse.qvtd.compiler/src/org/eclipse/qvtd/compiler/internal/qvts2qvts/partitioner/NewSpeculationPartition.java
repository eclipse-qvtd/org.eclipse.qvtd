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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Node.Utility;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
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
class NewSpeculationPartition extends AbstractPartialPartition
{
	private final @NonNull Set<@NonNull Node> originalHeadNodes;
	private final @NonNull Iterable<@NonNull Node> executionNodes;
	private final @Nullable Node dispatchNode;

	public NewSpeculationPartition(@NonNull MappingPartitioner partitioner, @NonNull ReachabilityForest reachabilityForest) {
		super(partitioner, reachabilityForest);
		this.originalHeadNodes = Sets.newHashSet(QVTscheduleUtil.getHeadNodes(region));
		this.executionNodes = partitioner.getExecutionNodes();
		this.dispatchNode = partitioner.basicGetDispatchNode();

		//
		//	For a no-override top relation the realized middle (trace) nodes become speculated nodes.
		//	For an override top relation the predicated middle (trace) nodes become speculated nodes.
		//	For a non-top relation the predicated middle (trace) nodes become speculated nodes.
		//
		for (@NonNull Node traceNode : executionNodes) {
			addNode(traceNode, Role.PREDICATED); //, Role.SPECULATED);
		}
		//
		//	For an override relation the predicated middle dispatch nodes become speculated nodes.
		//
		Node dispatchNode2 = dispatchNode;
		if (dispatchNode2 != null) {
			assert dispatchNode2.isPredicated();
			addNode(dispatchNode2); //, Role.SPECULATED);
		}
		//
		//	All old nodes reachable from heads that are not part of cycles are copied to the speculation guard.
		//	NB. Unreachable loaded nodes are effectively predicates and so are deferred.
		//
		Set<@NonNull Node> checkableOldNodes = new HashSet<>();
		for (@NonNull Node node : originalHeadNodes) {
			gatherReachableOldAcyclicNodes(checkableOldNodes, node);
		}
		if (dispatchNode != null) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(dispatchNode)) {
				if ((edge.isCast() || edge.isNavigation()) && edge.isOld()) {
					Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
					gatherReachableOldAcyclicNodes(checkableOldNodes, sourceNode);
				}
			}
		}
		for (@NonNull Node node : checkableOldNodes) {
			boolean isCyclicCorollary = transformationAnalysis.isCorollary(node) && partitioner.isCyclic(node);  // waiting for a cyclic corollary could deadlock
			//			boolean isPredicated = node.isPredicated();
			//			boolean isMatched = node.isMatched();
			//			boolean isUnconditional = node.isUnconditional();
			Utility utility = node.getUtility();
			boolean isWeaklyMatched = utility == Utility.WEAKLY_MATCHED;
			boolean isTraced = isTraced(node, executionNodes);
			if (!isCyclicCorollary && (isTraced || isWeaklyMatched)) {
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
		//	Ensure that re-used trace classes do not lead to ambiguous mappings.
		//
		resolveDisambiguations();
		//
		//	Join up the edges.
		//
		resolveEdges();
	}

	@Override
	public @NonNull MappingRegion createMicroMappingRegion(int partitionNumber) {
		return createMicroMappingRegion("«speculation»", "_p" + partitionNumber);
	}

	/**
	 * Add all old nodes, including node, that have no cyclic dependency and are reachable by to-one navigation from node.
	 */
	protected void gatherReachableOldAcyclicNodes(@NonNull Set<@NonNull Node> checkableOldNodes, @NonNull Node node) {
		//		boolean isNeeded = false;
		if (!hasNode(node) && !checkableOldNodes.contains(node) && (node.isHead() || node.isOld() && !partitioner.isCyclic(node))) {
			checkableOldNodes.add(node);
			for (@NonNull NavigableEdge edge : node.getNavigableEdges()) {
				if (edge.isOld()) {
					Node targetNode = QVTscheduleUtil.getTargetNode(edge);
					gatherReachableOldAcyclicNodes(checkableOldNodes, targetNode);
				}
			}
		}
		//		return isNeeded;
	}

	@Override
	protected @Nullable Iterable<@NonNull Node> getPreferredHeadNodes() {
		return executionNodes;
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

	protected boolean isTraced(@NonNull Node node, @NonNull Iterable<@NonNull Node> executionNodes) {
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isCast() || edge.isNavigation()) {
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				if (Iterables.contains(executionNodes, sourceNode)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			if (partitioner.hasRealizedEdge(edge)) {
				edgeRole = Role.PREDICATED;
			}
			else if (dispatchNode == edge.getSourceNode()) {
				edgeRole = null;			// Suppress Diaptach.result assignment
			}
		}
		return edgeRole;
	}
}