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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The SpeculatingPartition validates the residual predictaes omitted from the speculation.
 * The corollary is realized and realized edges that do not involve other speculations
 * are also realized. Realization of speculation nodes must wait for the speculated partition.
 */
class SpeculatingPartition extends AbstractPartialPartition
{
	private final @NonNull Set<@NonNull Node> tracedInputNodes = new HashSet<>();

	public SpeculatingPartition(@NonNull MappingPartitioner partitioner, @NonNull ReachabilityForest reachabilityForest) {
		super(partitioner, reachabilityForest);
		//
		//	The realized middle (trace) nodes become speculated head nodes and their already realized edge ends populate tracedInputNodes.
		//
		resolveTraceNodes();
		//
		//	The cyclic predicated middle nodes become speculated guard nodes and all preceding
		//	navigations are retained as is.
		//
		resolvePredicatedMiddleNodes();
		//
		//	The predicated output nodes and all preceding navigations are retained as is.
		//
		resolvePredicatedOutputNodes();
		//
		//	The ends of all matched predicated edges not already matched in the Speculation partition are added as is.
		//
		resolveMatchedPredicatedEdges();
		//
		//	The non-corollary, non-realized ends of all realized edges are added as is.
		//
		resolveRealizedEdges();
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
		return createMicroMappingRegion("«speculating»", "_p" + partitionNumber);
	}

	private boolean isDownstreamFromCorollary(@NonNull Node node) {
		if (transformationAnalysis.isCorollary(node)) {
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
	}

	/**
	 * Return true if node is a corollary of this mapping.
	 */
	private boolean isLocalCorollary(@NonNull Node node) {
		assert node.isRealized();
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isRealized() && (edge instanceof NavigableEdge)) {
				// A cyclic node cannot be a corollary since we must establish that all speculating
				// partitions are ok before the speculated region can create the full cycle.
				if (!partitioner.isCyclic(QVTscheduleUtil.getSourceNode(edge))) {
					List<@NonNull Region> corollaryOfRegions = partitioner.getCorollaryOf((NavigableEdge)edge);
					if ((corollaryOfRegions != null) && (corollaryOfRegions.size() == 1) && corollaryOfRegions.contains(region)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED && partitioner.hasRealizedEdge(edge)) {
			if (edge.getEdgeTarget().isConstant()) {
				edgeRole = null;		// Constant assignment already done in speculation partition. No need to predicate it with a constant to constant connection.
			}
			else {
				edgeRole = Role.PREDICATED;
			}
		}
		return edgeRole;
	}

	protected void resolveMatchedPredicatedEdges() {
		for (@NonNull Edge edge : partitioner.getPredicatedEdges()) {
			if (edge.isMatched() && !partitioner.hasPredicatedEdge(edge)) {
				if (!(edge instanceof NavigableEdge) || (partitioner.getCorollaryOf((NavigableEdge)edge) == null)) {
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
		}
	}

	protected void resolvePredicatedMiddleNodes() {
		for (@NonNull Node node : partitioner.getPredicatedMiddleNodes()) {
			if (!hasNode(node) && node.isMatched() && partitioner.isCyclic(node)) {
				Role nodeRole = QVTscheduleUtil.getNodeRole(node);
				if (node.isPattern() && node.isClass()) {
					nodeRole = QVTscheduleUtil.asSpeculated(nodeRole);
				}
				addNode(node, QVTscheduleUtil.asSpeculated(nodeRole));
			}
		}
	}

	protected void resolvePredicatedOutputNodes() {
		for (@NonNull Node node : partitioner.getPredicatedOutputNodes()) {
			if (!hasNode(node) && !transformationAnalysis.isCorollary(node) && !isDownstreamFromCorollary(node)) {
				addNode(node, QVTscheduleUtil.getNodeRole(node));
			}
		}
	}

	protected void resolveRealizedEdges() {
		for (@NonNull NavigableEdge edge : partitioner.getRealizedEdges()) {
			if (!partitioner.hasRealizedEdge(edge) && (partitioner.getCorollaryOf(edge) == null)) {
				Node sourceNode = edge.getEdgeSource();
				if (!sourceNode.isRealized() || isLocalCorollary(sourceNode)) {
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
	}

	protected void resolveTraceNodes() {
		Iterable<@NonNull Node> traceNodes = partitioner.getTraceNodes();
		for (@NonNull Node traceNode : traceNodes) {
			addNode(traceNode, Role.SPECULATED);
		}
		for (@NonNull Node traceNode : traceNodes) {
			for (@NonNull NavigableEdge edge : traceNode.getNavigableEdges()) {
				if (partitioner.hasRealizedEdge(edge)) {
					tracedInputNodes.add(edge.getEdgeTarget());
				}
			}
			Node successNode = partitioner.getSuccessNode(traceNode);		// FIXME only optional because trace property can be missing
			if (successNode != null) {
				addNode(successNode, Role.REALIZED);
			}
		}
	}
}