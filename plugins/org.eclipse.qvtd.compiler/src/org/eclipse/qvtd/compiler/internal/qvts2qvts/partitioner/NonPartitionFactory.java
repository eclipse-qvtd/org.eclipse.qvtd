/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
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
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NonPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Lists;

public class NonPartitionFactory extends AbstractPartitionFactory
{
	public NonPartitionFactory(@NonNull MappingPartitioner mappingPartitioner) {
		super(mappingPartitioner);
	}

	@Override
	public @NonNull NonPartition createPartition(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		ReachabilityForest reachabilityForest = createReachabilityForest();
		MappingRegion region = mappingPartitioner.getRegion();
		NonPartition nonPartition = createNonPartition(QVTscheduleUtil.getName(region));
		NonPartitionAnalysis nonPartitionAnalysis = new NonPartitionAnalysis(partitionedTransformationAnalysis, nonPartition, reachabilityForest);
		return nonPartitionAnalysis.getPartition();
	}

	/**
	 * Return the navigable edges that may be used by to locate nodes by this partition.
	 * The default implementation returns all old primary navigable edges
	 * and all already realized navigable edges
	 */
	@Override
	protected @NonNull Iterable<@NonNull NavigableEdge> getAvailableNavigableEdges() {
		Set<@NonNull NavigableEdge> oldEdges = new HashSet<>();
		MappingRegion region = mappingPartitioner.getRegion();
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			Role edgeRole = edge.getEdgeRole();
			assert edgeRole != null;
			if (edgeRole.isOld() && (edge.isCast() || edge.isNavigation()) /*&& edge.isUnconditional()*/) {
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				Role sourceNodeRole = sourceNode.getNodeRole();
				assert sourceNodeRole != null;
				if (sourceNodeRole.isOld()){
					Node targetNode = QVTscheduleUtil.getTargetNode(edge);
					Role targetNodeRole = targetNode.getNodeRole();
					assert targetNodeRole != null;
					if (targetNodeRole.isOld()) {
						oldEdges.add((NavigableEdge) edge);
					}
				}
			}
		}
		//		List<@NonNull Edge> sortedEdges = new ArrayList<>(oldEdges);
		//		Collections.sort(sortedEdges, reachabilityForest.getEdgeCostComparator());
		return oldEdges;
	}

	@Override
	protected @NonNull Iterable<@NonNull Node> getReachabilityRootNodes() {
		MappingRegion region = mappingPartitioner.getRegion();
		//
		//	The zero-cost nodes are the head nodes ...
		//
		List<@NonNull Node> zeroCostNodes = Lists.newArrayList(QVTscheduleUtil.getHeadNodes(region));
		//
		//	... and the no-input constant nodes
		//
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			if (node.isOperation()) {
				if (node.isConstant()) {
					boolean hasNoComputationInputs = true;
					for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
						if (edge.isComputation()) {
							hasNoComputationInputs = false;
							break;
						}
					}
					if (hasNoComputationInputs) {
						zeroCostNodes.add(node);
					}
				}
			}
		}
		return zeroCostNodes;
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		throw new UnsupportedOperationException();	// resolveEdges() should never have been invoked.
	}
}