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

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeRole;

/**
 * The SpeculationPartition identifies the nodes and edges required in a speculation micro-mapping
 * which creates the speculated trace with predicates solely on constant/loaded inputs.
 */
class SpeculationPartition extends AbstractPartition
{
	public SpeculationPartition(@NonNull Partitioner partitioner) {
		super(partitioner);
		@SuppressWarnings("unused") String name = partitioner.getRegion().getName();
		//
		//	The realized middle (trace) nodes become speculation nodes.
		//	All traced loaded nodes are retained as is to be traced by the speculation.
		//	NB. Unreachable loaded nodes are effectively predicates nd so are deferred.
		//
		for (@NonNull Node node : partitioner.getRealizedMiddleNodes()) {
			if (node.isPattern() && node.isClass()) {		// FIXME UML2RDBMS experiment
				NodeRole speculationNodeRole = node.getNodeRole().asSpeculation();
				addNode(node, speculationNodeRole);
				for (@NonNull NavigationEdge edge : node.getNavigationEdges()) {
					addReachableConstantOrLoadedNodes(edge.getTarget());
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
	 * Add all nodes, including node, that are constant or loaded and reachable by to-one navigation from node.
	 */
	protected void addReachableConstantOrLoadedNodes(@NonNull Node node) {
		if (node.isConstant() || node.isLoaded()) {
			if (!hasNode(node)) {
				addNode(node, node.getNodeRole());
				for (@NonNull NavigationEdge edge : node.getNavigationEdges()) {
					if (edge.isConstant() || edge.isLoaded()) {
						addReachableConstantOrLoadedNodes(edge.getTarget());
					}
				}
			}
		}
	}

	@Override
	protected boolean isComputable(@NonNull Set<@NonNull Node> sourceNodes, @NonNull Edge edge) {
		if (edge.isPredicated()) {
			return false;
		}
		if (edge.getTarget().isRealized()) {
			return false;
		}
		return super.isComputable(sourceNodes, edge);
	}

	@Override
	protected boolean resolveComputations(@NonNull Node targetNode) {
		if (targetNode.isConstant() || targetNode.isLoaded()) {
			return super.resolveComputations(targetNode);
		}
		else {
			return false;
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