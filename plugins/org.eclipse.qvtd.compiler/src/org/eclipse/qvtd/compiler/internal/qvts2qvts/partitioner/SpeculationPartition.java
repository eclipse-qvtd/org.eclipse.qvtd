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
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;

/**
 * The SpeculationPartition identifies the nodes and edges required in a speculation micro-mapping
 * which creates the speculated trace with predicates solely on constant/loaded inputs.
 */
class SpeculationPartition extends AbstractPartition
{
	public SpeculationPartition(@NonNull MappingPartitioner partitioner) {
		super(partitioner);
		@SuppressWarnings("unused") String name = partitioner.getRegion().getName();
		//
		//	The realized middle (trace) nodes become speculation nodes.
		//
		for (@NonNull Node node : partitioner.getRealizedMiddleNodes()) {
			if (node.isPattern() && node.isClass()) {		// FIXME UML2RDBMS experiment
				Role speculationNodeRole = RegionUtil.asSpeculation(RegionUtil.getNodeRole(node));
				addNode(node, speculationNodeRole);
			}
		}
		//
		//	All old nodes reachable from heads that are not part of cycles are copied to the speculation guard.
		//	NB. Unreachable loaded nodes are effectively predicates and so are deferred.
		//
		for (@NonNull Node node : RegionUtil.getHeadNodes(partitioner.getRegion())) {
			addReachableOldAcyclicNodes(node);
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
	 * Add all old nodes, including node, that have no cyclic dependency and are reachable by to-one navigation from node.
	 */
	protected void addReachableOldAcyclicNodes(@NonNull Node node) {
		if (node.isOld() && !hasNode(node) && !partitioner.isCyclic(node)) {
			addNode(node, RegionUtil.getNodeRole(node));
			for (@NonNull NavigableEdge edge : node.getNavigationEdges()) {
				if (edge.isOld()) {
					addReachableOldAcyclicNodes(edge.getEdgeTarget());
				}
			}
		}
	}

	@Override
	protected boolean isComputable(@NonNull Set<@NonNull Node> sourceNodes, @NonNull Edge edge) {
		if (edge.isPredicated()) {
			return false;
		}
		if (edge.getEdgeTarget().isRealized()) {
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
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = RegionUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			assert !partitioner.hasRealizedEdge(edge);
		}
		return edgeRole;
	}
}