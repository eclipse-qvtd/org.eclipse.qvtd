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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The SpeculatedPartition completes the speculation by realizing the corollaries of the speculation.
 */
class SpeculatedPartition extends AbstractPartialPartition
{
	private final @NonNull Node traceNode;
	//	private final @Nullable Node predicatedDispatchNode;
	private final @NonNull Set<@NonNull Node> tracedInputNodes = new HashSet<>();

	public SpeculatedPartition(@NonNull MappingPartitioner partitioner, @NonNull ReachabilityForest reachabilityForest) {
		super(partitioner, reachabilityForest, "«speculated»");
		this.traceNode = partitioner.getTraceNode();
		//		assert traceNode.isPredicated();
		//		this.predicatedDispatchNode = partitioner.basicGetPredicatedDispatchNode();
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
		resolveTraceNodes();
		//
		//	The realized output nodes are realized as is.
		//
		resolveRealizedOutputNodes();
		//
		//	The non-corollary, non-realized ends of all realized edges are added as is.
		//
		resolveRealizedEdges();
		//
		//	Add the outstanding predicates that can be checked by this partition.
		//
		//		resolveTrueNodes();
		//
		//	Ensure that the predecessors of each node are included in the partition.
		//
		resolvePrecedingNodes();
		//
		//	Ensure that re-used trace classes do not lead to ambiguous mapings.
		//
		resolveDisambiguations();
		//
		//	Join up the edges.
		//
		resolveEdges();
	}

	@Override
	public @NonNull MappingRegion createMicroMappingRegion(int partitionNumber) {
		return createMicroMappingRegion("«speculated»", "_p" + partitionNumber);
	}

	@Override
	protected @NonNull PartitioningVisitor createPartitioningVisitor(@NonNull MicroMappingRegion partialRegion) {
		return new PartitioningVisitor(new RegionHelper<>(scheduleManager, partialRegion), this)
		{
			@Override
			public @Nullable Element visitSuccessNode(@NonNull SuccessNode node) {
				if (node == partitioner.basicGetGlobalSuccessNode(traceNode)) {
					Node partialNode = regionHelper.createBooleanLiteralNode(true);
					addNode(node, partialNode);
					return partialNode;
				}
				else if (node == partitioner.basicGetLocalSuccessNode(traceNode)) {
					return null;			// localStatus is redundant when globalStatus in use
				}
				else {
					return super.visitSuccessNode(node);
				}
			}
		};
	}

	@Override
	protected @Nullable Iterable<@NonNull Node> getPreferredHeadNodes() {
		return Collections.singleton(traceNode);
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED && partitioner.hasRealizedEdge(edge)) {
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

	protected void resolveRealizedEdges() {
		for (@NonNull NavigableEdge edge : partitioner.getRealizedEdges()) {
			if (!partitioner.hasRealizedEdge(edge) && (partitioner.getCorollaryOf(edge) == null)) {
				Node sourceNode = edge.getEdgeSource();
				if (!sourceNode.isPredicated() || partitioner.hasPredicatedNode(sourceNode)) { // || isLocalCorollary(sourceNode)) {
					Node targetNode = edge.getEdgeTarget();
					if (!targetNode.isPredicated() || partitioner.hasPredicatedNode(targetNode)) { // || isLocalCorollary(sourceNode)) {
						if (!hasNode(sourceNode)) {
							addNode(sourceNode, QVTscheduleUtil.getNodeRole(sourceNode));
						}
						if (!hasNode(targetNode)) {
							addNode(targetNode, QVTscheduleUtil.getNodeRole(targetNode));
						}
					}
				}
			}
		}
	}

	protected void resolveRealizedOutputNodes() {
		for (@NonNull Node node : regionAnalysis.getCorollaryNodes()) {
			if (!hasNode(node) && !node.isSuccess()) {
				addNode(node);
			}
		}
	}

	/*	protected void resolveSuccessEdges() {
		//	}
		//		for (@NonNull Node traceNode : executionNodes) {
		//			assert traceNode.isMatched() && traceNode.isClass() && traceNode.isPattern();
		//			Node successNode = partitioner.getSuccessNode(traceNode);		// FIXME only optional because trace property can be missing
		//			if (successNode != null) {
		//				addNode(successNode, Role.PREDICATED);
		//			}
		//		}
		for (@NonNull Edge edge : partitioner.getSuccessEdges()) {
			if (!partitioner.hasRealizedEdge(edge) && !partitioner.hasPredicatedEdge(edge)) {
				Node sourceNode = edge.getEdgeSource();
				Node targetNode = edge.getEdgeTarget();
				//			if (edge.isPredicated()) {
				//				if (!hasNode(targetNode)) {
				//					addNode(targetNode);
				//				}
				//				partitioner.addPredicatedNode(targetNode);
				//				partitioner.addEdge(edge, Role.PREDICATED, this);	// FUXME this fudges inadequate speculation
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

	protected void resolveTraceNodes() {
		assert traceNode.isMatched() && traceNode.isClass() && traceNode.isPattern();
		addNode(traceNode, Role.PREDICATED);
		if (scheduleManager.useActivators()) {
			Node globalSuccessNode = partitioner.getGlobalSuccessNode(traceNode);
			addNode(globalSuccessNode, Role.PREDICATED);
		}
		//	}
		//		}
		//		for (@NonNull Node traceNode : executionNodes) {
		for (@NonNull NavigableEdge edge : traceNode.getNavigableEdges()) {
			if (partitioner.hasRealizedEdge(edge)) {
				tracedInputNodes.add(edge.getEdgeTarget());
			}
		}
		//		}
	}
}