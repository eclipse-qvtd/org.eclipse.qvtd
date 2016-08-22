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
 * The AssignmentPartition identifies the nodes and edges required by an assignment micro-mapping
 * which creates the predicates and realization of a property assignment.
 */
class AssignmentPartition extends AbstractPartition
{
	protected final @NonNull NavigationEdge realizedEdge;

	public AssignmentPartition(@NonNull Partitioner partitioner, @NonNull NavigationEdge realizedEdge) {
		super(partitioner);
		this.realizedEdge = realizedEdge;
		//
		//	The realized middle (trace) nodes become predicated head nodes.
		//
		for (@NonNull Node node : partitioner.getRealizedMiddleNodes()) {
			addNode(node, node.getNodeRole().asPredicated()/*.asMatched()*/);
		}
		//
		//	The nodes that support identification of the realized edge are used as is.
		//
		gatherSourceNavigations(realizedEdge.getSource());
		gatherSourceNavigations(realizedEdge.getTarget());
		//
		//	Join up the edges.
		//
		resolveEdgeRoles();
	}

	private void gatherSourceNavigations(@NonNull Node targetNode) {
		if (!hasNode(targetNode)) {
			NodeRole targetNodeRole = targetNode.getNodeRole();
			if (targetNodeRole.isRealized()) {
				targetNodeRole = targetNodeRole.asPredicated()/*.asMatched()*/;
			}
			addNode(targetNode, targetNodeRole);
			boolean hasPredecessor = false;
			for (@NonNull Node sourceNode : getPredecessors(targetNode)) {
				hasPredecessor = true;
				gatherSourceNavigations(sourceNode);
			}
			if (!hasPredecessor && targetNode.isPredicated()) {			// Must be the wrong end of a 1:N navigation
				for (@NonNull NavigationEdge edge : targetNode.getNavigationEdges()) {
					if (edge.isPredicated() && (edge.getOppositeEdge() == null)) {
						Node nonUnitSourceNode = edge.getTarget();
						gatherSourceNavigations(nonUnitSourceNode);
					}
				}
			}
		}
	}

	@Override
	protected @Nullable EdgeRole resolveEdgeRole(@NonNull NodeRole sourceNodeRole, @NonNull Edge edge, @NonNull NodeRole targetNodeRole) {
		EdgeRole edgeRole = edge.getEdgeRole();
		if (edgeRole.isRealized() && partitioner.hasRealizedEdge(edge)) {
			edgeRole = edgeRole.asPredicated();
		}
		return edgeRole;
	}
}