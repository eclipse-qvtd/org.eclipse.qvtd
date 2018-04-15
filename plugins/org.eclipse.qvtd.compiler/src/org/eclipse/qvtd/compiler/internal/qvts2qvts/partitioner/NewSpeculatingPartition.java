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
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The SpeculatingPartition validates the residual predictaes omitted from the speculation.
 * The corollary is realized and realized edges that do not involve other speculations
 * are also realized. Realization of speculation nodes must wait for the speculated partition.
 */
class NewSpeculatingPartition extends AbstractPartition
{
	private final @NonNull Iterable<@NonNull Node> executionNodes;
	private final @NonNull Set<@NonNull Node> tracedInputNodes = new HashSet<>();

	public NewSpeculatingPartition(@NonNull MappingPartitioner partitioner, @NonNull ReachabilityForest reachabilityForest) {
		super(partitioner, reachabilityForest);
		this.executionNodes = partitioner.getExecutionNodes();
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
		Node dispatchNode = partitioner.basicGetDispatchNode();
		if (dispatchNode != null) {
			assert dispatchNode.isPredicated();
			addNode(dispatchNode);
		}
		//
		//	The cyclic predicated middle nodes become speculated guard nodes and all preceding
		//	navigations are retained as is.
		//
		//		resolvePredicatedMiddleNodes();
		for (@NonNull Node whenNode : partitioner.getPredicatedWhenNodes()) {
			if (!partitioner.hasPredicatedNode(whenNode)) {
				addNode(whenNode); //, Role.SPECULATED);
			}
		}
		//
		//	The predicated output nodes and all preceding navigations are retained as is.
		//
		//		resolvePredicatedOutputNodes();
		//
		//	The ends of the success edges are added to define the speculation problem.
		//
		resolveSuccessEdges();
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
		//		resolveDisambiguations();
		//
		//	Join up the edges.
		//
		resolveEdges();
	}

	@Override
	protected @Nullable Iterable<@NonNull Node> getPreferredHeadNodes() {
		return executionNodes;
	}

	private boolean isAlwaysSatisfied(@NonNull Edge edge) {
		return edge.isUnconditional(); //true;		// FIXME perform compile-time speculation resolution
	}

	/*	private boolean isDownstreamFromCorollary(@NonNull Node node) {
		if (isCorollary(node)) {
			return true;
		}
		if (node.isOperation()) {
			boolean allReachable = true;
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isComputation()) {
					Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
					if (isDownstreamFromCorollary(sourceNode)) {
						allReachable = false;
						break;
					}
				}
			}
			if (allReachable) {
				return false;
			}
		}
		for (@NonNull Node precedingNode : getPredecessors(node)) {
			if (!isDownstreamFromCorollary(precedingNode)) {
				return false;
			}
		}
		return true;
	} */

	/**
	 * Return true if node is a corollary of this mapping.
	 *
	private boolean isLocalCorollary(@NonNull Node node) {
		assert node.isRealized();
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isRealized() && edge.isNavigation()) {
				// A cyclic node cannot be a corollary since we must establish that all speculating
				// partitions are ok before the speculated region can create the full cycle.
				if (!partitioner.isCyclic(QVTscheduleUtil.getSourceNode(edge))) {
					List<@NonNull MappingRegion> corollaryOfRegions = partitioner.getCorollaryOf(edge);
					if ((corollaryOfRegions != null) && (corollaryOfRegions.size() == 1) && corollaryOfRegions.contains(region)) {
						return true;
					}
				}
			}
		}
		return false;
	} */

	/*	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if ((edgeRole == Role.REALIZED) && !(edge instanceof SuccessEdge)) {
			edgeRole = null;
		}
		return edgeRole;
	} */

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			/* if (edge instanceof SuccessEdge) {
						edgeRole = Role.SPECULATED;			// FIXME fudge awaiting run-time support
					}
					else */ if (partitioner.hasRealizedEdge(edge)) {
						edgeRole = Role.PREDICATED;
					}
		}
		if (edgeRole == Role.PREDICATED) {
			if (edge instanceof SuccessEdge) {
				edgeRole = Role.SPECULATED;
			}
		}
		return edgeRole;
	}

	/*	protected void resolveMatchedPredicatedEdges() {
		for (@NonNull Edge edge : partitioner.getPredicatedEdges()) {
			if (edge.isMatched() && !partitioner.hasPredicatedEdge(edge) && (partitioner.getCorollaryOf(edge) == null)) {
				Node sourceNode = edge.getEdgeSource();
				if (!sourceNode.isRealized()) {
					Node targetNode = edge.getEdgeTarget();
					if (!targetNode.isRealized()) {
						if (!hasNode(sourceNode)) {
							addNode(sourceNode, QVTscheduleUtil.getNodeRole(sourceNode));
						}
						if (!hasNode(targetNode)) {
							addNode(targetNode, QVTscheduleUtil.getNodeRole(targetNode));
						}
					}
				}
			}
		}
	} */

	protected void resolvePredicatedMiddleNodes() {
		for (@NonNull Node node : partitioner.getPredicatedMiddleNodes()) {
			if (!hasNode(node) && node.isMatched()) { // && partitioner.isCyclic(node)) {
				Role nodeRole = QVTscheduleUtil.getNodeRole(node);
				//				if (node.isPattern() && node.isClass()) {
				//					nodeRole = QVTscheduleUtil.asSpeculated(nodeRole);
				//				}
				addNode(node, nodeRole); //QVTscheduleUtil.asSpeculated(nodeRole));
			}
		}
	}

	/*	protected void resolvePredicatedOutputNodes() {
		for (@NonNull Node node : partitioner.getPredicatedOutputNodes()) {
			if (!hasNode(node) && !isCorollary(node) && !isDownstreamFromCorollary(node)) {
				addNode(node, QVTscheduleUtil.getNodeRole(node));
			}
		}
	} */

	protected void resolveSuccessEdges() {
		for (@NonNull Edge edge : partitioner.getSuccessEdges()) {
			Node sourceNode = edge.getEdgeSource();
			Node targetNode = edge.getEdgeTarget();
			//			if (edge.isPredicated() && isAlwaysSatisfied(edge)) {
			//				if (!hasNode(targetNode)) {
			//					addNode(targetNode);
			//				}
			//				partitioner.addPredicatedNode(targetNode);
			//				partitioner.addEdge(edge, Role.PREDICATED, this);	// FIXME this fudges inadequate speculation
			//			}
			//			else {
			if (!hasNode(sourceNode)) {
				addNode(sourceNode);
			}
			if (!hasNode(targetNode)) {
				addNode(targetNode);
			}
			//			}
		}
	}

	/*	protected void resolveTraceNode() {
		Iterable<@NonNull Node> traceNodes = partitioner.getTraceNodes();		// Just 1 speculated middle node
		for (@NonNull Node traceNode : traceNodes) {
			addNode(traceNode, Role.SPECULATED);
		}
		/ *		for (@NonNull Node traceNode : traceNodes) {
			for (@NonNull NavigableEdge edge : traceNode.getNavigationEdges()) {
				if (partitioner.hasRealizedEdge(edge)) {
					tracedInputNodes.add(edge.getEdgeTarget());
				}
			}
			Node successNode = partitioner.getSuccessNode(traceNode);		// FIXME only optional because trace property can be missing
			if (successNode != null) {
				addNode(successNode, Role.REALIZED);
			}
		} * /
	} */
}