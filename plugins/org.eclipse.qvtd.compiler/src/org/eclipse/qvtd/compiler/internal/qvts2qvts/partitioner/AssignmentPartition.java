/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.StatusNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The AssignmentPartition identifies the nodes and edges required by an assignment micro-mapping
 * which creates the predicates and realization of a property assignment.
 */
class AssignmentPartition extends AbstractPartition
{
	//	protected final @NonNull Edge realizedEdge;

	public AssignmentPartition(@NonNull MappingPartitioner partitioner, @NonNull Edge realizedEdge) {
		super(partitioner);
		//		this.realizedEdge = realizedEdge;
		//
		//	The realized middle (trace) nodes become predicated head nodes.
		//
		for (@NonNull Node traceNode : partitioner.getTraceNodes()) {
			addNode(traceNode, Role.PREDICATED);
			Node statusNode = partitioner.getStatusNode(traceNode);
			if (statusNode != null) {		// status property is not mandatory
				addNode(statusNode, Role.PREDICATED);
			}
		}
		//
		//	The ends of the realized edge are used as is except that REALIZED elsewhere nodes are PREDICATED here.
		//
		Node sourceNode = realizedEdge.getEdgeSource();
		if (!hasNode(sourceNode)) {							// never fails; source node is not a trace node
			Role sourceNodeRole = RegionUtil.getNodeRole(sourceNode);
			if (sourceNodeRole == Role.REALIZED) {
				sourceNodeRole = QVTscheduleUtil.asPredicated(sourceNodeRole);
			}
			addNode(sourceNode, sourceNodeRole);
		}
		Node targetNode = realizedEdge.getEdgeTarget();
		if (!hasNode(targetNode)) {							// very unlikely to fail; can a REALIZED edge share source/target
			Role targetNodeRole = RegionUtil.getNodeRole(targetNode);
			if (targetNodeRole == Role.REALIZED) {
				targetNodeRole = QVTscheduleUtil.asPredicated(targetNodeRole);
			}
			addNode(targetNode, targetNodeRole);
		}
		//
		//	Add all nodes required to reach the source/target nodes.
		//
		resolvePrecedingNodes();
		//
		//	Ensure that re-used trace classes do not lead to ambiguous mappings.
		//
		resolveDisambiguations();
		//
		//	Join up the edges.
		//
		resolveEdges();
	}

	@Override
	protected @NonNull PartitioningVisitor createPartitioningVisitor(@NonNull MicroMappingRegion partialRegion) {
		return new PartitioningVisitor(partialRegion, this)
		{
			@Override
			public @Nullable Element visitStatusNode(@NonNull StatusNode node) {
				Node partialNode = RegionUtil.createTrueNode(partialRegion);
				addNode(node, partialNode);
				return partialNode;
			}
		};
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = RegionUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			AbstractPartition realizingPartition = partitioner.getRealizingPartition(edge);
			if (realizingPartition instanceof AssignmentPartition) {
				if (!isCorrolary(RegionUtil.getTargetNode(edge))) {			// FIXME do corrolaries before assigns
					return null;
				}
			}
			if (realizingPartition != null) {
				edgeRole = Role.PREDICATED;
			}
		}
		return edgeRole;
	}
}