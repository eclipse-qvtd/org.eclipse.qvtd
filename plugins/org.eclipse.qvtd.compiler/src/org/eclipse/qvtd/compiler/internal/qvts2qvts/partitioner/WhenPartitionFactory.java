/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * The When Partition realizes top-when calls so  that the result can be predicated downstream..
 */
public class WhenPartitionFactory extends AbstractSimplePartitionFactory
{
	protected final boolean useActivators;
	private final @NonNull Iterable<@NonNull Node> executionNodes;
	private final @NonNull Iterable<@NonNull Node> realizedWhenNodes;
	private final @Nullable Node dispatchNode;

	public WhenPartitionFactory(@NonNull MappingPartitioner mappingPartitioner, boolean useActivators) {
		super(mappingPartitioner);
		this.executionNodes = mappingPartitioner.getExecutionNodes();
		this.realizedWhenNodes = mappingPartitioner.getRealizedWhenNodes();
		this.useActivators = useActivators;
		this.dispatchNode = mappingPartitioner.basicGetDispatchNode();
	}

	@Override
	public @NonNull BasicPartitionAnalysis createPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		ReachabilityForest reachabilityForest = createReachabilityForest();
		String name = computeName("when");
		Iterable<@NonNull Node> headNodes = useActivators ? executionNodes : QVTscheduleUtil.getHeadNodes(mappingPartitioner.getRegion());
		BasicPartition partition = createBasicPartition(name, headNodes);
		int partitionNumber = region.getNextPartitionNumber();
		BasicPartitionAnalysis basicPartitionAnalysis = new BasicPartitionAnalysis(partitionedTransformationAnalysis, partition, reachabilityForest, "«when»", "_p" + partitionNumber);
		initializePartition(basicPartitionAnalysis);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(partition, null);
		}
		return basicPartitionAnalysis;
	}

	@Override
	protected @NonNull Iterable<@NonNull Node> getReachabilityRootNodes() {
		Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(mappingPartitioner.getRegion());
		Iterable<@NonNull Node> traceNodes = mappingPartitioner.getTraceNodes();
		List<@NonNull Node> rootNodes = new ArrayList<>();
		for (@NonNull Node headNode : useActivators ? traceNodes : headNodes) {
			if (!headNode.isDependency()) {
				rootNodes.add(headNode);
			}
		}
		for (@NonNull Node constantInputNode : mappingPartitioner.getConstantInputNodes()) {
			rootNodes.add(constantInputNode);
		}
		return rootNodes;
	}

	protected void initializePartition(@NonNull BasicPartitionAnalysis partitionAnalysis) {
		BasicPartition partition = partitionAnalysis.getPartition();
		//
		//	The trace node(s) need to be present.
		//
		for (@NonNull Node traceNode : executionNodes) {
			addNode(partition, traceNode, Role.PREDICATED); //, Role.SPECULATED);
		}
		//
		//	Realize top-when calls and their input edges.
		//
		for (@NonNull Node realizedWhenNode : realizedWhenNodes) {
			addNode(partition, realizedWhenNode); //, Role.SPECULATED);
			for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(realizedWhenNode)) {
				Node argumentNode = QVTscheduleUtil.getSourceNode(incomingEdge);
				if (scheduleManager.isInput(argumentNode)) {
					addNode(partition, argumentNode); //, Role.SPECULATED);
				}
			}
		}
		//
		//	Ensure that the predecessors of each node are included in the partition.
		//
		resolvePrecedingNodes(partitionAnalysis);
		//
		//	Ensure that re-used trace classes do not lead to ambiguous mappings.
		//
		resolveDisambiguations(partition);
		//
		//	Join up the edges.
		//
		resolveEdges(partitionAnalysis);
	}

	/**
	 * Return true if node is available for use by this partition.
	 * The override implementation returns true for all constant and loaded nodes.
	 */
	@Override
	protected boolean isAvailable(@NonNull BasicPartition partition, @NonNull Node node) {
		return node.isConstant() || node.isLoaded();
	}

	protected boolean isTraced(@NonNull Node node, @NonNull Iterable<@NonNull Node> executionNodes) {
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isCast() || edge.isNavigation()) {
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				if (Iterables.contains(executionNodes, sourceNode)) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED) {
			if (mappingPartitioner.hasRealizedEdge(edge)) {
				edgeRole = Role.PREDICATED;
			}
			else if (dispatchNode == edge.getSourceNode()) {
				edgeRole = null;			// Suppress Disptach.result assignment
			}
		}
		return edgeRole;
	}
}