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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The Speculated Partition completes the speculation by realizing the corollaries of the speculation.
 */
public class SpeculatedPartitionFactory extends AbstractSimplePartitionFactory
{
	private final @NonNull Set<@NonNull Node> tracedInputNodes = new HashSet<>();

	public SpeculatedPartitionFactory(@NonNull MappingPartitioner mappingPartitioner) {
		super(mappingPartitioner);
	}

	@Override
	public @NonNull BasicPartitionAnalysis createPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		ReachabilityForest reachabilityForest = createReachabilityForest();
		String name = computeName("speculated");
		Node traceNode = mappingPartitioner.getTraceNode();
		Iterable<@NonNull Node> headNodes = mappingPartitioner.getTraceNodes();
		BasicPartition partition = createBasicPartition(name, headNodes);
		int partitionNumber = region.getNextPartitionNumber();
		BasicPartitionAnalysis basicPartitionAnalysis = new BasicPartitionAnalysis(partitionedTransformationAnalysis, partition, reachabilityForest, "«speculated»", "_p" + partitionNumber);
		initializePartition(basicPartitionAnalysis, traceNode);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(partition, null);
		}
		return basicPartitionAnalysis;
	}

	protected void initializePartition(@NonNull BasicPartitionAnalysis partitionAnalysis, @NonNull Node traceNode) {
		BasicPartition partition = partitionAnalysis.getPartition();
		//		assert traceNode.isPredicated();
		//		this.predicatedDispatchNode = mappingPartitioner.basicGetPredicatedDispatchNode();
		//
		//	The realized trace nodes becomes a speculated head nodes.
		//
		//
		//	For a no-override top relation the realized middle (trace) nodes become predicated nodes.
		//	For an override top relation the predicated middle (trace) nodes become predicated nodes.
		//	For a non-top relation the predicated middle (trace) nodes become predicated nodes.
		//
		//		for (@NonNull Node traceNode : traceNodes) {
		//			addNode(traceNode, Role.PREDICATED);
		//		}
		resolveTraceNodes(partition, traceNode);
		//
		//	The realized output nodes are realized as is.
		//
		resolveRealizedOutputNodes(partition);
		//
		//	The non-corollary, non-realized ends of all realized edges are added as is.
		//
		resolveRealizedEdges(partition);
		//
		//	Add the outstanding predicates that can be checked by this partition.
		//
		//		resolveTrueNodes();
		//
		//	Ensure that the predecessors of each node are included in the partition.
		//
		resolvePrecedingNodes(partitionAnalysis);
		//
		//	Ensure that re-used trace classes do not lead to ambiguous mapings.
		//
		resolveDisambiguations(partition);
		//
		//	Join up the edges.
		//
		resolveEdges(partitionAnalysis);
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED && mappingPartitioner.hasRealizedEdge(edge)) {
			if (edge.isSuccess()) {
				edgeRole = Role.PREDICATED;		// Enforce sequencing
			}
			else if (edge.getEdgeTarget().isConstant()) {
				edgeRole = null;		// Constant assignment already done in speculation partition. No need to predicate it with a constant to constant connection.
			}
			else {
				edgeRole = Role.PREDICATED;
			}
		}
		return edgeRole;
	}

	protected void resolveRealizedEdges(@NonNull BasicPartition partition) {
		for (@NonNull NavigableEdge edge : mappingPartitioner.getRealizedEdges()) {
			if (edge instanceof NavigationEdge) {
				if (!mappingPartitioner.hasRealizedEdge(edge) && (mappingPartitioner.getCorollaryOf((NavigationEdge) edge) == null)) {
					Node sourceNode = edge.getEdgeSource();
					if (!sourceNode.isPredicated() || mappingPartitioner.hasCheckedNode(sourceNode)) { // || isLocalCorollary(sourceNode)) {
						Node targetNode = edge.getEdgeTarget();
						if (!targetNode.isPredicated() || mappingPartitioner.hasCheckedNode(targetNode)) { // || isLocalCorollary(sourceNode)) {
							if (!partition.hasNode(sourceNode)) {
								addNode(partition, sourceNode, QVTscheduleUtil.getNodeRole(sourceNode));
							}
							if (!partition.hasNode(targetNode)) {
								addNode(partition, targetNode, QVTscheduleUtil.getNodeRole(targetNode));
							}
						}
					}
				}
			}
			else {
				// SharedEdge
			}
		}
	}

	protected void resolveRealizedOutputNodes(@NonNull BasicPartition partition) {
		for (@NonNull Node node : mappingPartitioner.getRegionAnalysis().getCorollaryNodes()) {
			if (!partition.hasNode(node) && !node.isSuccess()) {
				addNode(partition, node);
			}
		}
	}

	/*	protected void resolveSuccessEdges() {
			//	}
			//		for (@NonNull Node traceNode : executionNodes) {
			//			assert traceNode.isMatched() && traceNode.isClass() && traceNode.isPattern();
			//			Node successNode = mappingPartitioner.getSuccessNode(traceNode);		// FIXME only optional because trace property can be missing
			//			if (successNode != null) {
			//				addNode(successNode, Role.PREDICATED);
			//			}
			//		}
			for (@NonNull Edge edge : mappingPartitioner.getSuccessEdges()) {
				if (!mappingPartitioner.hasRealizedEdge(edge) && !mappingPartitioner.hasPredicatedEdge(edge)) {
					Node sourceNode = edge.getEdgeSource();
					Node targetNode = edge.getEdgeTarget();
					//			if (edge.isPredicated()) {
					//				if (!hasNode(targetNode)) {
					//					addNode(targetNode);
					//				}
					//				mappingPartitioner.addCheckedNode(targetNode);
					//				mappingPartitioner.addEdge(edge, Role.PREDICATED, this);	// FUXME this fudges inadequate speculation
					//			}
					//			else {
					if (!hasNode(sourceNode)) {
						addNode(sourceNode);
					}
					if (!hasNode(targetNode)) {
						addNode(targetNode);
					}
				}
				//			}
			}
		}*/

	protected void resolveTraceNodes(@NonNull BasicPartition partition, @NonNull Node traceNode) {
		assert traceNode.isMatched() && traceNode.isClass() && traceNode.isPattern();
		addNode(partition, traceNode, Role.PREDICATED);
		if (scheduleManager.useActivators()) {
			Node localSuccessNode = mappingPartitioner.basicGetLocalSuccessNode(traceNode);
			if (localSuccessNode != null) {
				addNode(partition, localSuccessNode, Role.CONSTANT_SUCCESS_TRUE);
			}
			Node globalSuccessNode = mappingPartitioner.basicGetGlobalSuccessNode(traceNode);
			if (globalSuccessNode != null) {
				addNode(partition, globalSuccessNode, Role.CONSTANT_SUCCESS_TRUE);
			}	// else error already generated by GlobalPartitionFactory
		}
		//	}
		//		}
		//		for (@NonNull Node traceNode : executionNodes) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(traceNode)) {
			if (edge instanceof NavigationEdge) {
				NavigationEdge navigationEdge = (NavigationEdge) edge;
				if (mappingPartitioner.hasRealizedEdge(navigationEdge)) {
					tracedInputNodes.add(navigationEdge.getEdgeTarget());
				}
			}
		}
		//		}
	}
}