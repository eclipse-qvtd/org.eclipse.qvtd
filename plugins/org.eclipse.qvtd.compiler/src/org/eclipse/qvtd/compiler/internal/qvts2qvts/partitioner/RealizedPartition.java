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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MicroMappingRegion;
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
		//	Loaded nodes are retained as is for the predicate.
		//
		for (@NonNull Node node : partitioner.getLoadedNodes()) {
			addNode(node, node.getNodeRole());
		}
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

	@Override
	public @NonNull MicroMappingRegion createMicroMappingRegion(@NonNull String prefix, @NonNull String suffix) {
		MicroMappingRegion microMappingRegion = super.createMicroMappingRegion(prefix, suffix);
		microMappingRegion.getHeadNodes();
		return microMappingRegion;
	}

	private void gatherSourceNavigations(@NonNull Node targetNode, @NonNull NodeRole targetNodeRole) {
		if (!hasNode(targetNode)) {
			addNode(targetNode, targetNodeRole.resetHead());
			for (@NonNull Node sourceNode : getPredecessors(targetNode)) {
				gatherSourceNavigations(sourceNode, sourceNode.getNodeRole());
			}
		}
	}
}