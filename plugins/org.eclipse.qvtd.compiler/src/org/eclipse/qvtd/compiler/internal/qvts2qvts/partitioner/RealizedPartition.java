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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeRole;

import com.google.common.collect.Iterables;

/**
 * The RealizedPartition identifies the nodes and edges required by an unspeculated micro-mapping
 * which directly creates the realized variables.
 */
class RealizedPartition extends AbstractPartition
{
	public RealizedPartition(@NonNull Partitioner partitioner) {
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
			gatherSourceNavigations(node, node.getNodeRole());
			for (@NonNull NavigationEdge navigationEdge : node.getNavigationEdges()) {
				if (navigationEdge.isRealized()) {
					Node targetNode = navigationEdge.getTarget();
					NodeRole targetNodeRole = targetNode.getNodeRole();
					if (!targetNodeRole.isPredicated() && !targetNodeRole.isRealized()) {
						gatherSourceNavigations(targetNode, targetNodeRole);
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
		for (@NonNull NavigationEdge edge : partitioner.getRegion().getNavigationEdges()) {
			if (edge.isLoaded()) {
				Node sourceNode = edge.getSource();
				Node targetNode = edge.getTarget();
				if (!hasNode(sourceNode)) {
					addNode(sourceNode, sourceNode.getNodeRole());
				}
				if (!hasNode(targetNode)) {
					addNode(targetNode, targetNode.getNodeRole());
				}
			}
		}
	}

	private void gatherSourceNavigations(@NonNull Node targetNode, @NonNull NodeRole targetNodeRole) {
		if (!hasNode(targetNode)) {
			addNode(targetNode, targetNodeRole.resetHead());
			for (@NonNull Node sourceNode : getPredecessors(targetNode)) {
				gatherSourceNavigations(sourceNode, sourceNode.getNodeRole());
			}
		}
	}

	@Override
	protected @Nullable EdgeRole resolveEdgeRole(@NonNull NodeRole sourceNodeRole, @NonNull Edge edge, @NonNull NodeRole targetNodeRole) {
		EdgeRole edgeRole = edge.getEdgeRole();
		if (edgeRole.isRealized()) {
			assert !partitioner.hasRealizedEdge(edge);
		}
		return edgeRole;
	}
}