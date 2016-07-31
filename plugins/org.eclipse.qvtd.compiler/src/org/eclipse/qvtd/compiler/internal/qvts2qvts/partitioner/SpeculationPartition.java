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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MicroMappingRegion;
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
		//
		//	The realized middle (trace) nodes become speculation nodes.
		//
		for (@NonNull Node node : partitioner.getRealizedMiddleNodes()) {
			node2nodeRole.put(node, node.getNodeRole().resetHead().asSpeculation());
		}
		//
		//	Loaded inputs and all their computations are retained as is for the predicate.
		//
		for (@NonNull Node node : partitioner.getLoadedNodes()) {
			gatherInputComputations(node);
		}
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

	private void gatherInputComputations(@NonNull Node targetNode) {
		if (!node2nodeRole.containsKey(targetNode)) {
			node2nodeRole.put(targetNode, targetNode.getNodeRole().resetHead());
			for (@NonNull Edge edge : targetNode.getIncomingEdges()) {
				EdgeRole edgeRole = edge.getEdgeRole();
				if (edgeRole.isComputation() && !edgeRole.isPredicated() && !edgeRole.isRealized()) {
					Node sourceNode = edge.getSource();
					NodeRole sourceNodeRole = sourceNode.getNodeRole();
					if (!sourceNodeRole.isPredicated() && !sourceNodeRole.isRealized() && !node2nodeRole.containsKey(sourceNode)) {
						node2nodeRole.put(sourceNode, sourceNodeRole);
						gatherInputComputations(sourceNode);
					}
				}
			}
		}
	}
}