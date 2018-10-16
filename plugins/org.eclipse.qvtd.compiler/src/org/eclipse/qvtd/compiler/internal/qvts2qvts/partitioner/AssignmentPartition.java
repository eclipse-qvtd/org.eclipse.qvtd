/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The AssignmentPartition identifies the nodes and edges required by an assignment micro-mapping
 * which creates the predicates and realization of a property assignment.
 */
public class AssignmentPartition extends AbstractPartialPartition
{
	public static class AssignmentPartitionFactory extends AbstractPartitionFactory
	{
		protected final @NonNull Edge realizedEdge;

		public AssignmentPartitionFactory(@NonNull MappingPartitioner mappingPartitioner, @NonNull Edge realizedEdge) {
			super(mappingPartitioner);
			this.realizedEdge = realizedEdge;
		}

		@Override
		public @NonNull AssignmentPartition createPartition() {
			ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(mappingPartitioner), getAvailableNavigableEdges(mappingPartitioner));
			return new AssignmentPartition(mappingPartitioner, reachabilityForest, realizedEdge);
		}
	}

	//	private final @NonNull Node traceNode;

	protected AssignmentPartition(@NonNull MappingPartitioner partitioner, @NonNull ReachabilityForest reachabilityForest, @NonNull Edge realizedEdge) {
		super(computeName(partitioner, "edge-" + QVTscheduleUtil.getName(realizedEdge)), partitioner, reachabilityForest);
		//	this.traceNode = partitioner.getTraceNode();
		String name = originalRegion.getName();
		if ("mapHelper_Operation_qvtr".equals(name)) {
			getClass();
		}
		//
		//	The realized middle (trace) nodes become predicated head nodes.
		//
		for (@NonNull Node traceNode : partitioner.getTraceNodes()) {
			addNode(traceNode, Role.PREDICATED);
			Node localSuccessNode = partitioner.basicGetLocalSuccessNode(traceNode);
			if (localSuccessNode != null) {		// ?? localSuccess property is not mandatory
				addNode(localSuccessNode, Role.CONSTANT_SUCCESS_TRUE);
			}
			Node globalSuccessNode = partitioner.basicGetGlobalSuccessNode(traceNode);
			if (globalSuccessNode != null) {		// success property is not mandatory
				addNode(globalSuccessNode, Role.CONSTANT_SUCCESS_TRUE);
			}
		}
		//
		//	The ends of the realized edge are used as is except that REALIZED elsewhere nodes are PREDICATED here.
		//
		Node sourceNode = realizedEdge.getEdgeSource();
		if (!hasNode(sourceNode)) {							// never fails; source node is not a trace node
			Role sourceNodeRole = QVTscheduleUtil.getNodeRole(sourceNode);
			if (sourceNodeRole == Role.REALIZED) {
				sourceNodeRole = QVTscheduleUtil.asPredicated(sourceNodeRole);
			}
			addNode(sourceNode, sourceNodeRole);
		}
		Node targetNode = realizedEdge.getEdgeTarget();
		if (!hasNode(targetNode)) {							// very unlikely to fail; can a REALIZED edge share source/target
			Role targetNodeRole = QVTscheduleUtil.getNodeRole(targetNode);
			if (targetNodeRole == Role.REALIZED) {
				targetNodeRole = QVTscheduleUtil.asPredicated(targetNodeRole);
			}
			addNode(targetNode, targetNodeRole);
		}
		//
		//	Add all nodes required to reach the source/target nodes.
		//
		resolvePrecedingNodes();
		Node qvtrThis = null;
		Node qvtrTransformation = null;
		for (@NonNull Node node : getNodes()) {
			if ("qvtrThisVariable".equals(node.getName())) {
				qvtrThis = node;
			}
			else if ("qvtrTransformation".equals(node.getName())) {
				qvtrTransformation = node;
			}
		}
		if ((qvtrThis != null) != (qvtrTransformation != null)) {
			//			Iterable<@NonNull Node> reachabilityRootNodes = getReachabilityRootNodes();
			//			Iterable<@NonNull NavigableEdge> availableNavigableEdges = getAvailableNavigableEdges();
			//			ReachabilityForest reachabilityForest2 = new ReachabilityForest(reachabilityRootNodes, availableNavigableEdges);
			resolvePrecedingNodes();
		}
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
	public @NonNull MappingRegion createMicroMappingRegion() {
		int partitionNumber = originalRegion.getNextPartitionNumber();
		String namePrefix = "«edge" + partitionNumber + "»";
		String symbolSuffix = "_p" + partitionNumber;
		return createMicroMappingRegion(namePrefix, symbolSuffix);
	}

	@Override
	protected @NonNull PartitioningVisitor createPartitioningVisitor(@NonNull MicroMappingRegion partialRegion) {
		return new PartitioningVisitor(new RegionHelper<>(scheduleManager, partialRegion), this)
		{
			@Override
			public @Nullable Element visitSuccessNode(@NonNull SuccessNode node) {
				//	if (node == partitioner.basicGetLocalSuccessNode(traceNode)) {
				//		return null;			// localStatus is redundant when globalStatus in use
				//	}
				//	else {
				Node partialNode = regionHelper.createBooleanLiteralNode(true);
				addNode(node, partialNode);
				return partialNode;
				//	}
			}
		};
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			AbstractPartialPartition realizingPartition = partitioner.getRealizingPartition(edge);
			if (realizingPartition instanceof AssignmentPartition) {
				if (!transformationAnalysis.isCorollary(QVTscheduleUtil.getTargetNode(edge))) {			// FIXME do corollaries before assigns
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