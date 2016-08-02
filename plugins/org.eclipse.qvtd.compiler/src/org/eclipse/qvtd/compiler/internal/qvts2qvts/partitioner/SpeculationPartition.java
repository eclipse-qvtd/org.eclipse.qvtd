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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
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
			if (node.isPattern() && node.isClass()) {		// FIXME UML2RDBMS experiment
				NodeRole speculationNodeRole = node.getNodeRole().resetHead().asSpeculation();
				addNode(node, speculationNodeRole);
			}
		}
		//
		//	Loaded pattern nodes are retained as is for the predicate.
		//
		for (@NonNull Node node : partitioner.getLoadedNodes()) {
			if (node.isPattern() && node.isClass()) {
				addNode(node, node.getNodeRole());
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

	@Override
	protected boolean isComputable(@NonNull Set<@NonNull Node> sourceNodes, @NonNull Edge edge) {
		if (edge.isPredicated()) {
			return false;
		}
		return super.isComputable(sourceNodes, edge);
	}
}