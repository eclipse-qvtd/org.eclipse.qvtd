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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MicroMappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeRole;

abstract class AbstractPartition
{
	protected final @NonNull Partitioner partitioner;
	protected final @NonNull Map<@NonNull Node, @NonNull NodeRole> node2nodeRole = new HashMap<>();
	protected final @NonNull Map<@NonNull Edge, @NonNull EdgeRole> edge2edgeRole = new HashMap<>();

	protected AbstractPartition(@NonNull Partitioner partitioner) {
		this.partitioner = partitioner;
	}

	public @NonNull MicroMappingRegion createMicroMappingRegion(@NonNull String prefix, @NonNull String suffix) {
		PartitioningVisitor partitioningVisitor = PartitioningVisitor.createPartialRegion(partitioner.getRegion(), prefix, suffix, this);
		return partitioningVisitor.getRegion();
	}

	public @Nullable EdgeRole getEdgeRole(@NonNull Edge edge) {
		return edge2edgeRole.get(edge);
	}

	public @Nullable NodeRole getNodeRole(@NonNull Node node) {
		return node2nodeRole.get(node);
	}

	protected @Nullable EdgeRole resolveEdgeRole(@NonNull NodeRole sourceNodeRole, @NonNull Edge edge, @NonNull NodeRole targetNodeRole) {
		EdgeRole edgeRole = edge.getEdgeRole();
		if (edgeRole.isRealized() && partitioner.hasRealized(edge)) {
			edgeRole = edgeRole.asPredicated();
		}
		return edgeRole;
	}

	/**
	 * Resolve all the edges that have a source and target node by invoking resolveEdgeRole to determine
	 * what form of edge is required.
	 */
	protected void resolveEdgeRoles() {
		for (@NonNull Edge edge : partitioner.getRegion().getEdges()) {
			if (!edge.isSecondary() && !edge2edgeRole.containsKey(edge)) {
				NodeRole sourceNodeRole = node2nodeRole.get(edge.getSource());
				if (sourceNodeRole != null) {
					NodeRole targetNodeRole = node2nodeRole.get(edge.getTarget());
					if (targetNodeRole != null) {
						EdgeRole edgeRole = resolveEdgeRole(sourceNodeRole, edge, targetNodeRole);
						if (edgeRole != null) {
							if (edgeRole.isRealized()) {
								if (!partitioner.addRealizedEdge(edge)) {
									edgeRole = null;
								}
							}
							if (edgeRole != null) {
								edge2edgeRole.put(edge, edgeRole);
							}
						}
					}
				}
			}
		}
	}
}