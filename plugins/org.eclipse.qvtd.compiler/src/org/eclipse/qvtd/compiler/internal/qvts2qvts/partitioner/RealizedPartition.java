/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;

import com.google.common.collect.Iterables;

/**
 * The RealizedPartition identifies the nodes and edges required by an unspeculated micro-mapping
 * which directly creates the realized variables.
 */
class RealizedPartition extends AbstractPartition
{
	public RealizedPartition(@NonNull MappingPartitioner partitioner) {
		super(partitioner);
		Iterable<@NonNull Node> predicatedMiddleNodes = partitioner.getPredicatedMiddleNodes();
		Iterable<@NonNull Node> realizedMiddleNodes = partitioner.getRealizedMiddleNodes();
		Iterable<@NonNull Node> realizedOutputNodes = partitioner.getRealizedOutputNodes();
		assert Iterables.isEmpty(predicatedMiddleNodes);
		//
		//	The ends of loaded navigation edges are retained as is for the predicate.
		//
		addLoadedNavigationEdgeSourceAndTargetNodes();
		//
		//	The realized nodes are realized as is.
		//
		for (@NonNull Node node : Iterables.concat(realizedMiddleNodes, realizedOutputNodes)) {
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
		//
		//	Perform any required computations.
		//
		resolveComputations();
		//
		//	Perform any outstanding predicates.
		//
		resolvePredicates();
		//
		//	Join up the edges.
		//
		resolveEdgeRoles();
	}

	/**
	 * Add the ends of all the loaded edges. This gathers the loaded PatternNodeRoles and also the
	 * odd-valls such as Null nodes.
	 */
	protected void addLoadedNavigationEdgeSourceAndTargetNodes() {
		for (@NonNull NavigableEdge edge : partitioner.getRegion().getNavigationEdges()) {
			if (edge.isLoaded()) {
				Node sourceNode = edge.getEdgeSource();
				Node targetNode = edge.getEdgeTarget();
				if (!hasNode(sourceNode)) {
					addNode(sourceNode, RegionUtil.getNodeRole(sourceNode));
				}
				if (!hasNode(targetNode)) {
					addNode(targetNode, RegionUtil.getNodeRole(targetNode));
				}
			}
		}
	}

	private void gatherSourceNavigations(@NonNull Node targetNode, @NonNull Role targetNodeRole) {
		if (!hasNode(targetNode)) {
			addNode(targetNode, targetNodeRole);
			for (@NonNull Node sourceNode : getPredecessors(targetNode)) {
				gatherSourceNavigations(sourceNode, RegionUtil.getNodeRole(sourceNode));
			}
		}
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = RegionUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			assert !partitioner.hasRealizedEdge(edge);
		}
		return edgeRole;
	}
}