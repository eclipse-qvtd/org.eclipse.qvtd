/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
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
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The SpeculatingPartition validates the residual predictaes omitted from the speculation.
 * The corrolary is realized and realized edges that do not involve other speculations
 * are also realized. Realization of speculation nodes must wait for the speculated partition.
 */
class SpeculatingPartition extends AbstractPartition
{
	private final @NonNull Set<@NonNull Node> tracedInputNodes = new HashSet<>();

	public SpeculatingPartition(@NonNull MappingPartitioner partitioner) {
		super(partitioner);
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
		//	The non-corrolary, non-realized ends of all realized edges are added as is.
		//
		resolveRealizedEdges();
		//
		//	Add the outstanding predicates that can be checked by this partition.
		//
		resolveTrueNodes();
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

	private boolean isDownstreamFromCorrolary(@NonNull Node node) {
		if (isCorrolary(node)) {
			return true;
		}
		if (node.isOperation()) {
			boolean allReachable = true;
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isComputation()) {
					Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
					if (isDownstreamFromCorrolary(sourceNode)) {
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
			if (!isDownstreamFromCorrolary(precedingNode)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return true if node is a corrolary of this mapping.
	 */
	private boolean isLocalCorrolary(@NonNull Node node) {
		assert node.isRealized();
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isRealized() && edge.isNavigation() && !partitioner.isCyclic(QVTscheduleUtil.getSourceNode(edge))) {
				List<@NonNull MappingRegion> corrolaryOfRegions = partitioner.getCorrolaryOf(edge);
				if ((corrolaryOfRegions != null) && (corrolaryOfRegions.size() == 1) && corrolaryOfRegions.contains(region)) {
					return true;
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
			if (edge.isMatched() && !partitioner.hasPredicatedEdge(edge) && (partitioner.getCorrolaryOf(edge) == null)) {
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
			if (!hasNode(node) && !isCorrolary(node) && !isDownstreamFromCorrolary(node)) {
				addNode(node, QVTscheduleUtil.getNodeRole(node));
			}
		}
	}

	protected void resolveRealizedEdges() {
		for (@NonNull Edge edge : partitioner.getRealizedEdges()) {
			if (!partitioner.hasRealizedEdge(edge) && (partitioner.getCorrolaryOf(edge) == null)) {
				Node sourceNode = edge.getEdgeSource();
				if (!sourceNode.isRealized() || isLocalCorrolary(sourceNode)) {
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
			for (@NonNull NavigableEdge edge : traceNode.getNavigationEdges()) {
				if (partitioner.hasRealizedEdge(edge)) {
					tracedInputNodes.add(edge.getEdgeTarget());
				}
			}
			Node statusNode = partitioner.getStatusNode(traceNode);		// FIXME only optional because trace property can be missing
			if (statusNode != null) {
				addNode(statusNode, Role.REALIZED);
			}
		}
	}
}