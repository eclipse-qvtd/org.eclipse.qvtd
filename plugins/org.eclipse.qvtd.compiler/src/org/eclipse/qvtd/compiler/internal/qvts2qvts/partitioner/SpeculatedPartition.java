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

/**
 * The SpeculatedPartition identifies the nodes and edges required by a speculated micro-mapping
 * which creates the speculation predicates and realized variables.
 */
class SpeculatedPartition extends AbstractPartition
{
	public SpeculatedPartition(@NonNull Partitioner partitioner) {
		super(partitioner);
		Iterable<@NonNull Node> predicatedMiddleNodes = partitioner.getPredicatedMiddleNodes();
		Iterable<@NonNull Node> realizedMiddleNodes = partitioner.getRealizedMiddleNodes();
		Iterable<@NonNull Node> realizedOutputNodes = partitioner.getRealizedOutputNodes();
		//
		//	The realized middle (trace) nodes become speculated head nodes.
		//
		for (@NonNull Node node : realizedMiddleNodes) {
			node2nodeRole.put(node, node.getNodeRole().asSpeculated().setHead());
		}
		//
		//	The predicated middle nodes become speculated nodes.
		//
		for (@NonNull Node node : predicatedMiddleNodes) {
			gatherSourceNavigations(node, node.getNodeRole().resetHead().asSpeculated());
		}
		//
		//	The traced inputs nodes are used as is.
		//
		//		for (@NonNull Node node : tracedInputNodes) {
		//			node2nodeRole.put(node, node.getNodeRole().resetHead());
		//		}
		//
		//	The realized output nodes are realized as is.
		//
		for (@NonNull Node node : realizedOutputNodes) {
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
		//	The realized output nodes are linked to the trace as is.
		//
		//		for (@NonNull Node node : realizedMiddleNodes) {
		//			gatherRealizedNavigations(node, realizedOutputNodes);
		//		}
		//
		//	Join up the edges.
		//
		resolveEdgeRoles();
	}

	private void gatherSourceNavigations(@NonNull Node targetNode, @NonNull NodeRole targetNodeRole) {
		if (!node2nodeRole.containsKey(targetNode)) {
			node2nodeRole.put(targetNode, targetNodeRole);
			for (@NonNull Node sourceNode : partitioner.getPredecessors(targetNode)) {
				gatherSourceNavigations(sourceNode, sourceNode.getNodeRole());
			}
		}
	}

	@Override
	protected @Nullable EdgeRole resolveEdgeRole(@NonNull NodeRole sourceNodeRole, @NonNull Edge edge, @NonNull NodeRole targetNodeRole) {
		EdgeRole edgeRole = edge.getEdgeRole();
		if (edgeRole.isRealized()) {
			if (sourceNodeRole.isSpeculated() && !targetNodeRole.isRealized()) {
				edgeRole = edgeRole.asPredicated();
			}
			else if (targetNodeRole.isSpeculated() && !sourceNodeRole.isRealized()) {
				edgeRole = edgeRole.asPredicated();
			}
		}
		/*		else if (edgeRole.isPredicated()) {
			if (sourceNodeRole.isSpeculated()) {
				edgeRole = edgeRole.asSpeculated();
			}
			else if (targetNodeRole.isSpeculated()) {
				edgeRole = edgeRole.asSpeculated();
			}
		} */
		return edgeRole;
	}

	/*	private void gatherRealizedNavigations(@NonNull Node sourceNode, @NonNull Iterable<@NonNull Node> realizedOutputNodes) {
		for (@NonNull NavigationEdge edge : sourceNode.getNavigationEdges()) {
			EdgeRole edgeRole = edge.getEdgeRole();
			if (edgeRole.isRealized()) {
				Node targetNode = edge.getTarget();
				if (Iterables.contains(realizedOutputNodes, targetNode)) {
					edge2edgeRole.put(edge.getForwardEdge(), edgeRole);
				}
			}
		}
	} */
}