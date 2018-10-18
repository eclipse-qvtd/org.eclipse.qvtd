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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Sets;

public class BasicPartition extends AbstractAcyclicPartition
{
	protected final @NonNull MappingPartitioner partitioner;
	protected final @NonNull Iterable<@NonNull Node> headNodes;
	private @NonNull String namePrefix = "";
	private @NonNull String symbolSuffix = "";

	/**
	 * The nodes of region that are required by the partition and the nodeRole that each node plays in the partition.
	 */
	private final @NonNull Map<@NonNull Node, @NonNull Role> node2nodeRole = new HashMap<>();

	/**
	 * The edges of region that are required by the partition and the edgeRole that each edge plays in the partition.
	 */
	private final @NonNull Map<@NonNull Edge, @NonNull Role> edge2edgeRole = new HashMap<>();

	/**
	 * The mechanisms to reach required nodes.
	 */
	private final @NonNull ReachabilityForest reachabilityForest;

	/**
	 * Explicitly specified predecessors for use by QVTc where there is no trace localSuccess linkage.
	 */
	private final @NonNull List<@NonNull Partition> explicitPredecessors = new ArrayList<>();

	private @Nullable MicroMappingRegion microMappingRegion = null;

	protected BasicPartition(@NonNull String name, @NonNull MappingPartitioner partitioner,
			@NonNull Iterable<@NonNull Node> headNodes, @NonNull ReachabilityForest reachabilityForest) {
		super(name, partitioner.getPartitionedTransformationAnalysis(), partitioner.getRegionAnalysis());
		this.partitioner = partitioner;
		this.headNodes = headNodes;
		this.reachabilityForest = reachabilityForest;
	}

	public void addExplicitPredecessor(@NonNull Partition speculationPartition) {
		explicitPredecessors.add(speculationPartition);
	}

	/**
	 * Return true of all required predecessor of targetNOde are available for use by this partition.
	 *
	protected boolean allPredecessorsAreAvailable(@NonNull Node targetNode) {
		List<@NonNull Node> requiredNodes = new ArrayList<>(nodes);
		requiredNodes.add(targetNode);
		Map<@NonNull Node, @NonNull Role> requiredNode2nodeRole = new HashMap<>();
		for (int i = 0; i < requiredNodes.size(); i++) {
			Node node = requiredNodes.get(i);
			assert node != null;
			Edge traceEdge = partitioner.getTraceEdge(node);
			if ((traceEdge == null) || !partitioner.hasRealizedEdge(traceEdge)) {
				for (@NonNull Node precedingNode : getPredecessors(node)) {
					if (!isAvailable(node)) {
						return false;
					}
					if (!requiredNode2nodeRole.containsKey(precedingNode)) {
						requiredNode2nodeRole.put(precedingNode, QVTscheduleUtil.getNodeRole(precedingNode));
						requiredNodes.add(precedingNode);
					}
				}
			}
		}
		/*		for (@NonNull Node requiredNode : requiredNodes) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(requiredNode)) {
				if (!requiredNode2nodeRole.containsKey(precedingNode)) {
					requiredNode2nodeRole.put(precedingNode, QVTscheduleUtil.getNodeRole(precedingNode));
					requiredNodes.add(precedingNode);
				}
			}
		} * /
		return true;
	} */

	/**
	 * Verify that all unconditional nodes in the new region are reachable from its heads.
	 */
	public void check(@NonNull MicroMappingRegion region) {
		Set<@NonNull Node> reachableNodes = new HashSet<>();
		for (@NonNull Node node : QVTscheduleUtil.getHeadNodes(region)) {
			checkGatherReachables(reachableNodes, node);
		}
		Set<@NonNull Node> allNodes = Sets.newHashSet(QVTscheduleUtil.getOwnedNodes(region));
		if (!reachableNodes.equals(allNodes)) {
			Set<@NonNull Node> extraNodesSet = Sets.newHashSet(reachableNodes);
			CompilerUtil.removeAll(extraNodesSet, allNodes);
			for (@NonNull Node node : extraNodesSet) {
				partitioner.addProblem(CompilerUtil.createRegionWarning(region, "unexpected " + node));
			}
			Set<@NonNull Node> missingNodesSet = Sets.newHashSet(allNodes);
			missingNodesSet.removeAll(reachableNodes);
			for (@NonNull Node node : missingNodesSet) {
				if (!node.isConstant() && !node.isUnconditional()) {
					node.isUnconditional();
					partitioner.addProblem(CompilerUtil.createRegionWarning(region, "unreachable " + node));
				}
			}
		}
	}
	private void checkGatherReachables(@NonNull Set<@NonNull Node> reachableNodes, @NonNull Node node) {
		if (node instanceof OperationNode) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isComputation() && !edge.isConstant()) {
					if (!reachableNodes.contains(edge.getEdgeSource())) {
						return;
					}
				}
			}
		}
		if (reachableNodes.add(node)) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (/*edge.isComputation() ||*/ edge.isCast() || edge.isNavigation()) {		// excludes only recursion
					checkGatherReachables(reachableNodes, edge.getEdgeSource());
				}
			}
			for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(node)) {
				if (edge.isComputation() || edge.isCast() || edge.isNavigation()) {
					checkGatherReachables(reachableNodes, edge.getEdgeTarget());
				}
			}
		}
	}

	@Override
	public final @NonNull MappingRegion createMicroMappingRegion() {
		return createMicroMappingRegion(namePrefix, symbolSuffix);
	}

	protected final @NonNull MicroMappingRegion createMicroMappingRegion(@NonNull String namePrefix, @NonNull String symbolSuffix) {
		assert microMappingRegion  == null;
		assert !(originalRegion instanceof MicroMappingRegion);
		MicroMappingRegion partialRegion = createPartialRegion(namePrefix, symbolSuffix);
		//	originalRegion.accept(partitioningVisitor);
		MicroMappingRegion microMappingRegion = partialRegion;//partitioningVisitor.getRegion();
		/*	Iterable<@NonNull Node> preferredHeadNodes = getPreferredHeadNodes();
		List<@NonNull Node> partialPreferredHeadNodes = null;
		if (preferredHeadNodes != null) {
			partialPreferredHeadNodes = new ArrayList<>();
			for (@NonNull Node preferredNode : preferredHeadNodes) {
				partialPreferredHeadNodes.add(partitioningVisitor.getNode(preferredNode));
			}
		}
		Iterable<@NonNull Node> headNodes = RuleHeadAnalysis.computeRuleHeadNodes(scheduleManager, microMappingRegion, partialPreferredHeadNodes);
		Iterables.addAll(QVTscheduleUtil.Internal.getHeadNodesList(microMappingRegion), headNodes);


		//	if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
		//		scheduleManager.writeDebugGraphs(microMappingRegion, null);
		//	}
		check(microMappingRegion); */
		this.microMappingRegion = microMappingRegion;
		return microMappingRegion;
	}

	protected @NonNull MicroMappingRegion createPartialRegion(@NonNull String namePrefix, @NonNull String symbolSuffix) {
		MicroMappingRegion partialRegion = QVTscheduleFactory.eINSTANCE.createMicroMappingRegion();
		scheduleManager.addMappingRegion(partialRegion);
		partialRegion.setMappingRegion((MappingRegion) originalRegion);
		partialRegion.setNamePrefix(namePrefix);
		partialRegion.setSymbolNameSuffix(symbolSuffix);
		partialRegion.setName(namePrefix + " " + originalRegion.getName());
		return partialRegion;
	}

	@Override
	public @NonNull List<@NonNull Partition> getExplicitPredecessors() {
		return explicitPredecessors;
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getHeadNodes() {
		return headNodes;
	}

	@Override
	public @NonNull MappingRegion getMicroMappingRegion() {
		return ClassUtil.nonNullState(microMappingRegion);
	}

	@Override
	public @NonNull String getName() {		// FIXME Bad RegionHelper override
		return name;
	}

	/**
	 * Return all the original region nodes that contribute to the partition.
	 */
	protected @NonNull Iterable<@NonNull Node> getNodes() {
		return node2nodeRole.keySet();
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		return edge2edgeRole.keySet();
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getPartialNodes() {
		return getNodes();
	}

	protected @NonNull Iterable<@NonNull Node> getPredecessors(@NonNull Node targetNode) {
		return reachabilityForest.getPredecessors(targetNode);
	}

	@Override
	public @NonNull ReachabilityForest getReachabilityForest() {
		return reachabilityForest;
	}

	/**
	 * Return the role that the original region's edge plays in the partition. Null for none.
	 */
	@Override
	public @Nullable Role getRole(@NonNull Edge edge) {
		return edge2edgeRole.get(edge);
	}

	/**
	 * Return the role that the original region's node plays in the partition. Null for none.
	 */
	@Override
	public @Nullable Role getRole(@NonNull Node node) {
		return node2nodeRole.get(node);
	}

	/**
	 * Return true if the original region edge contributes to the partition.
	 */
	public boolean hasEdge(@NonNull Edge edge) {
		return edge2edgeRole.containsKey(edge);
	}

	/**
	 * Return true if the original region node contributes to the partition.
	 */
	protected boolean hasNode(@NonNull Node node) {
		return node2nodeRole.containsKey(node);
	}

	protected void initMicroMappingRegion(@NonNull String namePrefix, @NonNull String symbolSuffix) {
		this.namePrefix = namePrefix;
		this.symbolSuffix = symbolSuffix;
	}

	@Override
	public boolean isAwaited(@NonNull Edge edge) {
		Role role = getRole(edge);
		return role != null ? role.isAwaited() : false; //edge.isPredicated();
	}

	@Override
	protected boolean isConstant(@NonNull Edge edge) {
		Role role = getRole(edge);
		return role != null ? role.isConstant() : false; //edge.isConstant();
	}

	@Override
	protected boolean isConstant(@NonNull Node node) {
		Role role = getRole(node);
		return role != null ? role.isConstant() : false; //node.isConstant();
	}

	@Override
	protected boolean isLoaded(@NonNull Edge edge) {
		Role role = getRole(edge);
		return role != null ? role.isLoaded() : false; //edge.isLoaded();
	}

	@Override
	protected boolean isLoaded(@NonNull Node node) {
		Role role = getRole(node);
		return role != null ? role.isLoaded() : false; //node.isLoaded();
	}

	//	@Override
	protected boolean isOld(@NonNull Edge edge) {
		Role role = getRole(edge);
		return role != null ? role.isOld() : false; //edge.isOld();
	}

	//	@Override
	protected boolean isOld(@NonNull Node node) {
		Role role = getRole(node);
		return role != null ? role.isOld() : false; //node.isOld();
	}

	@Override
	public boolean isPredicated(@NonNull Edge edge) {
		Role role = getRole(edge);
		return role != null ? role.isPredicated() : false; //edge.isPredicated();
	}

	@Override
	protected boolean isPredicated(@NonNull Node node) {
		Role role = getRole(node);
		return role != null ? role.isPredicated() : false; //node.isPredicated();
	}

	@Override
	public boolean isRealized(@NonNull Edge edge) {
		Role role = getRole(edge);
		return role != null ? role.isRealized() : false; //edge.isRealized();
	}

	@Override
	protected boolean isRealized(@NonNull Node node) {
		Role role = getRole(node);
		return role != null ? role.isRealized() : false; //node.isRealized();
	}

	@Override
	protected boolean isSpeculated(@NonNull Edge edge) {
		Role role = getRole(edge);
		return role != null ? role.isSpeculated() : false; //edge.isSpeculated();
	}

	@Override
	protected boolean isSpeculated(@NonNull Node node) {
		Role role = getRole(node);
		return role != null ? role.isSpeculated() : false; //node.isSpeculated();
	}

	@Override
	protected boolean isSpeculation(@NonNull Node node) {
		Role role = getRole(node);
		return role != null ? role.isSpeculation() : false; //node.isSpeculation();
	}

	public @Nullable Role putEdgeRole(@NonNull Edge edge, @NonNull Role newEdgeRole) {
		return edge2edgeRole.put(edge, newEdgeRole);
	}

	public @Nullable Role putNodeRole(@NonNull Node node, @NonNull Role newNodeRole) {
		return node2nodeRole.put(node, newNodeRole);
	}

	@Override
	public @NonNull String toString() {
		return getName();
	}
}