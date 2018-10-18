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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The Assignment Partition identifies the nodes and edges required by an assignment micro-mapping
 * which creates the predicates and realization of a property assignment.
 */
public class AssignmentPartitionFactory extends AbstractPartitionFactory
{
	protected final @NonNull Edge realizedEdge;

	public AssignmentPartitionFactory(@NonNull MappingPartitioner mappingPartitioner, @NonNull Edge realizedEdge) {
		super(mappingPartitioner);
		this.realizedEdge = realizedEdge;
	}

	@Override
	public @NonNull BasicPartition createPartition() {
		ReachabilityForest reachabilityForest = createReachabilityForest();
		String name = computeName("edge-" + QVTscheduleUtil.getName(realizedEdge));
		Iterable<@NonNull Node> headNodes = mappingPartitioner.getTraceNodes();
		BasicPartition partition = new BasicPartition(name, mappingPartitioner, headNodes, reachabilityForest);
		int partitionNumber = region.getNextPartitionNumber();
		String namePrefix = "«edge" + partitionNumber + "»";
		String symbolSuffix = "_p" + partitionNumber;
		partition.initMicroMappingRegion(namePrefix, symbolSuffix);
		initializePartition(partition);
		return partition;
	}

	protected void initializePartition(@NonNull BasicPartition partition) {
		//	this.traceNode = mappingPartitioner.getTraceNode();
		String regionName = region.getName();
		if ("mapNavigationOrAttributeCallExp_Property_qvtr".equals(regionName)) {
			getClass();
		}
		//
		//	The realized middle (trace) nodes become predicated head nodes.
		//
		for (@NonNull Node traceNode : mappingPartitioner.getTraceNodes()) {
			addNode(partition, traceNode, Role.PREDICATED);
			Node localSuccessNode = mappingPartitioner.basicGetLocalSuccessNode(traceNode);
			if (localSuccessNode != null) {		// ?? localSuccess property is not mandatory
				addNode(partition, localSuccessNode, Role.CONSTANT_SUCCESS_TRUE);
			}
			Node globalSuccessNode = mappingPartitioner.basicGetGlobalSuccessNode(traceNode);
			if (globalSuccessNode != null) {		// success property is not mandatory
				addNode(partition, globalSuccessNode, Role.CONSTANT_SUCCESS_TRUE);
			}
		}
		//
		//	The ends of the realized edge are used as is except that REALIZED elsewhere nodes are PREDICATED here.
		//
		Node sourceNode = realizedEdge.getEdgeSource();
		if (!partition.hasNode(sourceNode)) {							// never fails; source node is not a trace node
			Role sourceNodeRole = QVTscheduleUtil.getNodeRole(sourceNode);
			if (sourceNodeRole == Role.REALIZED) {
				sourceNodeRole = QVTscheduleUtil.asPredicated(sourceNodeRole);
			}
			addNode(partition, sourceNode, sourceNodeRole);
		}
		Node targetNode = realizedEdge.getEdgeTarget();
		if (!partition.hasNode(targetNode)) {							// very unlikely to fail; can a REALIZED edge share source/target
			Role targetNodeRole = QVTscheduleUtil.getNodeRole(targetNode);
			if (targetNodeRole == Role.REALIZED) {
				targetNodeRole = QVTscheduleUtil.asPredicated(targetNodeRole);
			}
			addNode(partition, targetNode, targetNodeRole);
		}
		//
		//	Add all nodes required to reach the source/target nodes.
		//
		resolvePrecedingNodes(partition);
		Node qvtrThis = null;
		Node qvtrTransformation = null;
		for (@NonNull Node node : partition.getNodes()) {
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
			resolvePrecedingNodes(partition);
		}
		//
		//	Ensure that re-used trace classes do not lead to ambiguous mappings.
		//
		resolveDisambiguations(partition);
		//
		//	Join up the edges.
		//
		resolveEdges(partition);
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		return QVTscheduleUtil.getEdgeRole(edge);
	}

	@Override
	public @NonNull String toString() {
		return super.toString() + " " + realizedEdge.getName();
	}
}
