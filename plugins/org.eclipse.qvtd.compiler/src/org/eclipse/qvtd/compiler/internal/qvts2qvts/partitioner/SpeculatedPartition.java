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
	private final @NonNull Set<@NonNull Node> tracedInputNodes = new HashSet<>();

	public SpeculatedPartition(@NonNull MappingPartitioner partitioner, @NonNull ReachabilityForest reachabilityForest) {
		super(partitioner, reachabilityForest, "«speculated»");
		//
		//	The realized trace nodes becomes a speculated head nodes.
		//
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
		//
		//	Add the success predicates.
		//
		resolveSuccessNodes();
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
				Node partialNode = regionHelper.createBooleanLiteralNode(true);
				addNode(node, partialNode);
				return partialNode;
			}
		};
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
		if (edgeRole == Role.REALIZED && partitioner.hasRealizedEdge(edge)) {
			if (edge.getEdgeTarget().isConstant()) {
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
				addNode(node, QVTscheduleUtil.getNodeRole(node));
			}
		}
	}

	protected void resolveSuccessNodes() {
		for (@NonNull Node traceNode : partitioner.getTraceNodes()) {
			assert traceNode.isMatched() && traceNode.isClass() && traceNode.isPattern();
			Node successNode = partitioner.getSuccessNode(traceNode);		// FIXME only optional because trace property can be missing
			if (successNode != null) {
				addNode(successNode, Role.PREDICATED);
			}
		}
	}

	protected void resolveTraceNodes() {
		for (@NonNull Node traceNode : partitioner.getTraceNodes()) {
			assert traceNode.isMatched() && traceNode.isClass() && traceNode.isPattern();
			//		if (!hasNode(traceNode)) {
			addNode(traceNode, Role.PREDICATED);
			Node successNode = partitioner.getSuccessNode(traceNode);		// FIXME only optional because trace property can be missing
			if (successNode != null) {
				addNode(successNode, Role.PREDICATED);
			}
		}
		for (@NonNull Node traceNode : partitioner.getTraceNodes()) {
			for (@NonNull NavigableEdge edge : traceNode.getNavigableEdges()) {
				if (partitioner.hasRealizedEdge(edge)) {
					tracedInputNodes.add(edge.getEdgeTarget());
				}
			}
		}
	}
}