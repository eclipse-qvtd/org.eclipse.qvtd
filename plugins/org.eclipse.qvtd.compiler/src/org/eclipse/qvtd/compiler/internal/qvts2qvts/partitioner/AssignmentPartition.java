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
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The AssignmentPartition identifies the nodes and edges required by an assignment micro-mapping
 * which creates the predicates and realization of a property assignment.
 */
class AssignmentPartition extends AbstractPartition
{
	protected final @NonNull Edge realizedEdge;

	public AssignmentPartition(@NonNull Partitioner partitioner, @NonNull Edge realizedEdge) {
		super(partitioner);
		this.realizedEdge = realizedEdge;
		//
		//	The realized middle (trace) nodes become predicated head nodes.
		//
		for (@NonNull Node node : partitioner.getRealizedMiddleNodes()) {
			addNode(node, QVTscheduleUtil.asPredicated(RegionUtil.getNodeRole(node))/*.asMatched()*/);
		}
		//
		//	The nodes that support identification of the realized edge are used as is.
		//
		gatherSourceNavigations(realizedEdge.getEdgeSource());
		gatherSourceNavigations(realizedEdge.getEdgeTarget());
		//
		//	Join up the edges.
		//
		resolveEdgeRoles();
	}

	private void gatherSourceNavigations(@NonNull Node targetNode) {
		if (!hasNode(targetNode)) {
			Role targetNodeRole = RegionUtil.getNodeRole(targetNode);
			if (targetNodeRole == Role.REALIZED) {
				targetNodeRole = QVTscheduleUtil.asPredicated(targetNodeRole)/*.asMatched()*/;
			}
			addNode(targetNode, targetNodeRole);
			boolean hasPredecessor = false;
			for (@NonNull Node sourceNode : getPredecessors(targetNode)) {
				hasPredecessor = true;
				gatherSourceNavigations(sourceNode);
			}
			if (!hasPredecessor && targetNode.isPredicated()) {			// Must be the wrong end of a 1:N navigation
				for (@NonNull NavigableEdge edge : targetNode.getNavigationEdges()) {
					if (edge.isPredicated() && (edge.getOppositeEdge() == null)) {
						Node nonUnitSourceNode = edge.getEdgeTarget();
						gatherSourceNavigations(nonUnitSourceNode);
					}
				}
			}
		}
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = RegionUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED && partitioner.hasRealizedEdge(edge)) {
			edgeRole = Role.PREDICATED;
		}
		return edgeRole;
	}
}