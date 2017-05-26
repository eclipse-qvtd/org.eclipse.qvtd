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
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;

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
		//	The realized middle (trace) nodes become speculated head nodes.
		//
		resolveTraceNode();
		//
		//	The predicated middle nodes become speculated guard nodes and all preceding
		//	navigations are retained as is.
		//
		resolvePredicatedMiddleNodes();
		//
		//	The predicated output nodes and all preceding navigations are retained as is.
		//
		resolvePredicatedOutputNodes();
		//
		//	The realized output nodes are realized as is.
		//
		//		resolveRealizedOutputNodes();
		//
		//	The ends of all matched predicated edges not already matched in the Speculation partition are added as is.
		//
		resolveMatchedPredicatedEdges();
		//
		//	The non-corrolary, non-realized ends of all realized edges are added as is.
		//
		resolveRealizedEdges();
		//
		//	Perform any required computations.
		//
		resolveComputations();
		//
		//	Perform any outstanding predicates.
		//
		resolvePredicates();
		//
		//	Ensure that re-used trace classes do not lead to ambiguous mapings.
		//
		resolveDisambiguations();
		//
		//	Join up the edges.
		//
		resolveEdgeRoles();
	}

	private void gatherSourceNavigations(@NonNull Node targetNode, @NonNull Role targetNodeRole) {
		if (!hasNode(targetNode)) {
			addNode(targetNode, targetNodeRole);
			if (!tracedInputNodes.contains(targetNode)) {
				boolean hasPredecessor = false;
				for (@NonNull Node sourceNode : getPredecessors(targetNode)) {
					hasPredecessor = true;
					gatherSourceNavigations(sourceNode, RegionUtil.getNodeRole(sourceNode));
				}
				if (!hasPredecessor && targetNode.isPredicated()) {			// Must be the wrong end of a 1:N navigation
					for (@NonNull NavigableEdge edge : targetNode.getNavigationEdges()) {
						if (edge.isPredicated() && (edge.getOppositeEdge() == null)) {
							Node nonUnitSourceNode = edge.getEdgeTarget();
							gatherSourceNavigations(nonUnitSourceNode, RegionUtil.getNodeRole(nonUnitSourceNode));
						}
					}
				}
			}
		}
	}

	@Override
	protected boolean isComputable(@NonNull Set<@NonNull Node> sourceNodes, @NonNull Edge edge) {
		Node sourceNode = edge.getEdgeSource();
		if (tracedInputNodes.contains(sourceNode)) {
			sourceNodes.add(sourceNode);
			return true;
		}
		return super.isComputable(sourceNodes, edge);
	}

	/**
	 * Return true if node is a corrolary of some mapping.
	 */
	private boolean isCorrolary(@NonNull Node node) {
		if (node.isPredicated()) {
			for (@NonNull Edge edge : RegionUtil.getIncomingEdges(node)) {
				if (edge.isPredicated() && edge.isNavigation()) {
					List<@NonNull MappingRegion> corrolaryOf = partitioner.getCorrolaryOf(edge);
					if (corrolaryOf != null) {
						return true;
					}
				}
			}
		}
		else if (node.isRealized()) {
			for (@NonNull Edge edge : RegionUtil.getIncomingEdges(node)) {
				if (edge.isRealized() && edge.isNavigation()) {
					List<@NonNull MappingRegion> corrolaryOf = partitioner.getCorrolaryOf(edge);
					if (corrolaryOf != null) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Return true if node is a corrolary of this mapping.
	 */
	private boolean isLocalCorrolary(@NonNull Node node) {
		assert node.isRealized();
		for (@NonNull Edge edge : RegionUtil.getIncomingEdges(node)) {
			if (edge.isRealized() && edge.isNavigation() && !partitioner.isCyclic(RegionUtil.getSourceNode(edge))) {
				List<@NonNull MappingRegion> corrolaryOfRegions = partitioner.getCorrolaryOf(edge);
				if ((corrolaryOfRegions != null) && (corrolaryOfRegions.size() == 1) && corrolaryOfRegions.contains(region)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	protected boolean resolveComputations(@NonNull Node targetNode) {
		if (tracedInputNodes.contains(targetNode)) {
			return true;
		}
		//		return super.resolveComputations(targetNode);
		//	}
		//	protected boolean resolveComputations(@NonNull Node targetNode) {
		boolean gotIt = false;
		for (@NonNull Edge incomingEdge : RegionUtil.getIncomingEdges(targetNode)) {
			if (incomingEdge.isComputation() || (incomingEdge.isNavigation() && incomingEdge.isOld())) {
				Set<@NonNull Node> sourceNodes = new HashSet<>();
				if (isComputable(sourceNodes, incomingEdge)) {
					gotIt = true;
					for (@NonNull Node sourceNode : sourceNodes) {
						if (!hasNode(sourceNode)) {
							//							addNode(sourceNode, RegionUtil.getNodeRole(sourceNode));
							gatherSourceNavigations(sourceNode, RegionUtil.getNodeRole(sourceNode));
						}
					}
				}
			}
		}
		return gotIt;
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = RegionUtil.getEdgeRole(edge);
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
							addNode(sourceNode, RegionUtil.getNodeRole(sourceNode));
						}
						if (!hasNode(targetNode)) {
							addNode(targetNode, RegionUtil.getNodeRole(targetNode));
						}
					}
				}
			}
		}
	}

	@Override
	protected void resolveNavigations(@NonNull Node node) {
		if (!node.isConstant() && !node.isLoaded()) {
			super.resolveNavigations(node);
		}
	}

	protected void resolvePredicatedMiddleNodes() {
		for (@NonNull Node node : partitioner.getPredicatedMiddleNodes()) {
			if (node.isMatched() && partitioner.isCyclic(node)) {
				Role nodeRole = RegionUtil.getNodeRole(node);
				if (node.isPattern() && node.isClass()) {
					nodeRole = RegionUtil.asSpeculated(nodeRole);
				}
				gatherSourceNavigations(node, RegionUtil.asSpeculated(nodeRole));
			}
		}
	}

	protected void resolvePredicatedOutputNodes() {
		for (@NonNull Node node : partitioner.getPredicatedOutputNodes()) {
			if (!isCorrolary(node)) {
				Role nodeRole = RegionUtil.getNodeRole(node);
				gatherSourceNavigations(node, nodeRole);
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
							addNode(sourceNode, RegionUtil.getNodeRole(sourceNode));
						}
						if (!hasNode(targetNode)) {
							addNode(targetNode, RegionUtil.getNodeRole(targetNode));
						}
					}
				}
			}
		}
	}

	/*	protected void resolveRealizedOutputNodes() {
		for (@NonNull Node node : partitioner.getRealizedOutputNodes()) {
			if (isCorrolary(node)) {
				gatherSourceNavigations(node, RegionUtil.getNodeRole(node));
				for (@NonNull NavigableEdge navigationEdge : node.getNavigationEdges()) {
					if (navigationEdge.isRealized()) {
						Node targetNode = navigationEdge.getEdgeTarget();
						if (!targetNode.isPredicated() && !targetNode.isRealized()) {
							gatherSourceNavigations(targetNode, RegionUtil.getNodeRole(targetNode));
						}
					}
				}
			}
		}
	} */

	protected void resolveTraceNode() {
		Node traceNode = partitioner.getTraceNode();
		addNode(traceNode, Role.SPECULATED);
		for (@NonNull NavigableEdge edge : traceNode.getNavigationEdges()) {
			if (partitioner.hasRealizedEdge(edge)) {
				tracedInputNodes.add(edge.getEdgeTarget());
			}
		}
		Node successNode = partitioner.basicGetSuccessNode();		// FIXME only optional because trace property can be missing
		if (successNode != null) {
			addNode(successNode, Role.REALIZED);
		}
	}
}