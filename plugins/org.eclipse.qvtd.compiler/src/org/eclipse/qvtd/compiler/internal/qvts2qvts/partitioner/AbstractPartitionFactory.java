/*******************************************************************************
 * Copyright (c) 2018, 2020 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public abstract class AbstractPartitionFactory<R extends Region> extends RegionHelper<R> implements PartitionFactory
{
	protected AbstractPartitionFactory(@NonNull ScheduleManager scheduleManager, @NonNull R region) {
		super(scheduleManager, region);
	}

	protected void addEdge(@NonNull BasicPartition partition, @NonNull Edge edge, @NonNull Role newEdgeRole) {
		assert edge.getOwningRegion() == region;
		addEdge2(partition, edge, newEdgeRole);
		if (edge instanceof NavigationEdge) {
			NavigationEdge oppositeEdge = ((NavigationEdge)edge).getOppositeEdge();
			if (oppositeEdge != null) {
				addEdge2(partition, oppositeEdge, newEdgeRole);
			}
		}
	}

	protected void addEdge2(@NonNull BasicPartition partition, @NonNull Edge edge, @NonNull Role newEdgeRole) {
		Role displacedEdgeRole = partition.putEdgeRole(edge, newEdgeRole);
		assert (displacedEdgeRole == null) || (displacedEdgeRole == newEdgeRole);
	}

	protected @NonNull ReachabilityForest createReachabilityForest() {
		return new ReachabilityForest(null, getReachabilityRootNodes(), getAvailableNavigableEdges());
	}

	protected abstract @NonNull Iterable<@NonNull NavigableEdge> getAvailableNavigableEdges();

	protected abstract @NonNull Iterable<@NonNull Node> getReachabilityRootNodes();

	protected @Nullable Role resolveCheckedEdgeRole(@NonNull Edge edge, @NonNull Role edgeRole) {
		return edgeRole;
	}

	/**
	 * Determine the appropriate new edgeRole for the edge between nodes with new SourceNoeRole and targetNodeRole.
	 * May return null for an edge that is not required.
	 *
	 * The default implementation accepts all edges just changing REALIZED to PREDICATED for already realized edges.
	 */
	protected abstract @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole);

	/**
	 * Resolve all the original region edges by adding to the partition provided the nodes at each end have already been added.
	 * The addition is mediated by resolveEdgeRole that may adjust the edgeRole or suppress the addition.
	 */
	protected void resolveEdges(@NonNull BasicPartitionAnalysis partitionAnalysis) {
		BasicPartition partition = partitionAnalysis.getPartition();
		ReachabilityForest reachabilityForest = partitionAnalysis.getReachabilityForest();
		Set<@NonNull Edge> reachingEdges = new HashSet<>();
		//
		//	Add all the edges necessary to reach each node.
		//
		for (@NonNull Node node : partition.getPartialNodes()) {
			for (Edge reachingEdge : reachabilityForest.getReachingEdges(node)) {
				reachingEdges.add(reachingEdge);
				if (!partition.hasEdge(reachingEdge)) {
					Role sourceNodeRole = partition.getRole(reachingEdge.getEdgeSource());
					if (sourceNodeRole != null) {
						Role targetNodeRole = partition.getRole(reachingEdge.getEdgeTarget());
						if (targetNodeRole != null) {
							Role edgeRole = resolveEdgeRole(sourceNodeRole, reachingEdge, targetNodeRole);
							if (edgeRole != null) {
								if (edgeRole == Role.REALIZED) {
									edgeRole = resolveReachingEdgeRole(partition, reachingEdges, reachingEdge, edgeRole);
								}
								if (edgeRole != null) {
									addEdge(partition, reachingEdge, edgeRole);
								}
							}
						}
					}
				}
			}
		}
		//
		//	Add all the edges necessary to reach each node.
		/*
		for (@NonNull Node node : partition.getPartialNodes()) {
			if (node.isOperation()) {
				for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
					if ((edge.isExpression() || edge.isNavigation()) && !partition.hasEdge(edge)) {
						Role sourceNodeRole = partition.getRole(edge.getEdgeSource());
						if (sourceNodeRole != null) {
							Role targetNodeRole = partition.getRole(edge.getEdgeTarget());
							if (targetNodeRole != null) {
								Role edgeRole = resolveEdgeRole(sourceNodeRole, edge, targetNodeRole);
								if (edgeRole != null) {
									if (edgeRole == Role.REALIZED) {
										edgeRole = resolveReachingEdgeRole(partition, reachingEdges, edge, edgeRole);
									}
									if (edgeRole != null) {
										addEdge(partition, edge, edgeRole);
									}
								}
							}
						}
					}
				}
			}
			else {
				for (@NonNull Edge edge : reachabilityForest.getReachingEdges(node)) {
					if (!partition.hasEdge(edge)) {
						Role sourceNodeRole = partition.getRole(edge.getEdgeSource());
						if (sourceNodeRole != null) {
							Role targetNodeRole = partition.getRole(edge.getEdgeTarget());
							if (targetNodeRole != null) {
								Role edgeRole = resolveEdgeRole(sourceNodeRole, edge, targetNodeRole);
								if (edgeRole != null) {
									if (edgeRole == Role.REALIZED) {
										edgeRole = resolveReachingEdgeRole(partition, reachingEdges, edge, edgeRole);
									}
									if (edgeRole != null) {
										addEdge(partition, edge, edgeRole);
									}
								}
							}
						}
					}
				}
			}
		} */
		//
		//	Add all the other edges whose redundancy must be checked, unless they have already been checked.
		//
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			//	for (@NonNull Edge edge : getPartialEdges()) {
			if (!edge.isSecondary() && !partition.hasEdge(edge)) {
				Role sourceNodeRole = partition.getRole(edge.getEdgeSource());
				if (sourceNodeRole != null) {
					Role targetNodeRole = partition.getRole(edge.getEdgeTarget());
					if (targetNodeRole != null) {
						Role edgeRole = resolveEdgeRole(sourceNodeRole, edge, targetNodeRole);
						if (edgeRole != null) {
							if (edgeRole == Role.REALIZED) {
								edgeRole = resolveReachingEdgeRole(partition, reachingEdges, edge, edgeRole);
							}
							else {
								edgeRole = resolveCheckedEdgeRole(edge, edgeRole);
							}
							if (edgeRole != null) {
								addEdge(partition, edge, edgeRole);
							}
						}
					}
				}
			}
		}
	}

	protected @Nullable Role resolveReachingEdgeRole(@NonNull BasicPartition partition, @NonNull Set<@NonNull Edge> reachingEdges, @NonNull Edge edge, @NonNull Role edgeRole) {
		return edgeRole;
	}
}