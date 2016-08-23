/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MicroMappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeRole;
import org.eclipse.qvtd.compiler.internal.qvts2qvti.AbstractForestBuilder;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

abstract class AbstractPartition
{
	protected static class PartitionForest extends AbstractForestBuilder
	{
		protected PartitionForest(@NonNull Iterable<@NonNull Node> rootNodes, @NonNull Iterable<@NonNull NavigationEdge> edges) {
			super(rootNodes, edges);
		}

		protected @NonNull Iterable<@NonNull Node> getPredecessors(@NonNull Node targetNode) {
			Set<@NonNull Node> sourceNodes = new HashSet<>();
			NavigationEdge parentEdge = getParentEdge(targetNode);
			if (parentEdge != null) {
				//			Integer targetDepth = getDepth(targetNode);
				//			assert targetDepth != null;
				Node sourceNode = parentEdge.getSource();
				if (sourceNode == targetNode) {
					sourceNode = parentEdge.getTarget();
				}
				sourceNodes.add(sourceNode);
				//			Integer sourceDepth = getDepth(sourceNode);
				//			assert sourceDepth != null;
			}
			for (@NonNull Edge edge : targetNode.getComputationEdges()) {
				sourceNodes.add(edge.getSource());
			}
			//		sourceNodes.remove(targetNode);
			return sourceNodes;
		}

	}
	protected final @NonNull Partitioner partitioner;
	protected final @NonNull Iterable<@NonNull Edge> alreadyRealizedEdges;
	private final @NonNull Map<@NonNull Node, @NonNull NodeRole> node2nodeRole = new HashMap<>();
	private final @NonNull Map<@NonNull Edge, org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole> edge2edgeRole = new HashMap<>();
	private /*@LazyNonNull*/ PartitionForest forest = null;

	protected AbstractPartition(@NonNull Partitioner partitioner) {
		this.partitioner = partitioner;
		this.alreadyRealizedEdges = partitioner.getAlreadyRealizedEdges();
	}

	private void addEdge(@NonNull Edge edge, @NonNull EdgeRole newEdgeRole) {
		switch (edge.getEdgeRole().getPhase())
		{
			case CONSTANT: {
				assert newEdgeRole.isConstant();
				break;
			}
			case LOADED: {
				assert newEdgeRole.isLoaded();
				break;
			}
			case PREDICATED: {
				assert newEdgeRole.isPredicated();
				break;
			}
			case REALIZED: {
				if (!partitioner.hasRealizedEdge(edge)) {
					assert newEdgeRole.isRealized();
				}
				else {
					assert newEdgeRole.isPredicated();
				}
				break;
			}
			default: {
				throw new UnsupportedOperationException(getClass().getSimpleName() + ".addEdge " + edge);
			}
		}
		partitioner.addEdge(edge, newEdgeRole, this);
		edge2edgeRole.put(edge, newEdgeRole);
	}

	protected void addNode(@NonNull Node node, @NonNull NodeRole newNodeRole) {
		switch (node.getNodeRole().getPhase())
		{
			case CONSTANT: {
				assert newNodeRole.isConstant();
				if (node.isTrue()) {
					partitioner.addTrueNode(node);
				}
				break;
			}
			case LOADED: {
				assert newNodeRole.isLoaded();
				break;
			}
			case PREDICATED: {
				assert newNodeRole.isPredicated() || newNodeRole.isSpeculated();
				partitioner.addPredicatedNode(node);
				break;
			}
			case REALIZED: {
				if (!partitioner.hasRealizedNode(node)) {
					assert newNodeRole.isRealized() || newNodeRole.isSpeculation();
					partitioner.addRealizedNode(node);
				}
				else {
					assert newNodeRole.isPredicated() || newNodeRole.isSpeculated();
				}
				break;
			}
			default: {
				throw new UnsupportedOperationException(getClass().getSimpleName() + ".addNode " + node);
			}
		}
		NodeRole oldNodeRole = node2nodeRole.put(node, newNodeRole);
		assert (oldNodeRole == null) || (oldNodeRole == newNodeRole);
	}

	private @NonNull PartitionForest createForest() {
		List<@NonNull NavigationEdge> navigableEdges = Lists.newArrayList(partitioner.getNavigableEdges());
		for (@NonNull Edge edge : alreadyRealizedEdges) {
			if (edge instanceof NavigationEdge) {
				navigableEdges.add((NavigationEdge) edge);
			}
		}
		return new PartitionForest(partitioner.getRealizedMiddleNodes(), navigableEdges);
	}

	public @NonNull MicroMappingRegion createMicroMappingRegion(@NonNull String prefix, @NonNull String suffix) {
		PartitioningVisitor partitioningVisitor = PartitioningVisitor.createPartialRegion(partitioner.getRegion(), prefix, suffix, this);
		MicroMappingRegion microMappingRegion = partitioningVisitor.getRegion();
		microMappingRegion.getHeadNodes();
		check(microMappingRegion);
		return microMappingRegion;
	}

	private void check(@NonNull MicroMappingRegion region) {
		Set<@NonNull Node> reachableNodes = new HashSet<>();
		for (@NonNull Node node : region.getHeadNodes()) {
			gatherReachables(reachableNodes, node);
		}
		Set<@NonNull Node> allNodes = Sets.newHashSet(region.getNodes());
		if (!reachableNodes.equals(allNodes)) {
			Set<@NonNull Node> extraNodesSet = Sets.newHashSet(reachableNodes);
			CompilerUtil.removeAll(extraNodesSet, allNodes);
			for (@NonNull Node node : extraNodesSet) {
				partitioner.addProblem(region.createWarning("unexpected " + node));
			}
			Set<@NonNull Node> missingNodesSet = Sets.newHashSet(allNodes);
			missingNodesSet.removeAll(reachableNodes);
			for (@NonNull Node node : missingNodesSet) {
				partitioner.addProblem(region.createWarning("unreachable " + node));
			}
		}
	}

	private void gatherReachables(@NonNull Set<@NonNull Node> reachableNodes, @NonNull Node node) {
		if (reachableNodes.add(node)) {
			for (@NonNull Edge edge : node.getIncomingEdges()) {
				if (edge.isComputation() || edge.isNavigation()) {		// excludes only recursion
					gatherReachables(reachableNodes, edge.getSource());
				}
			}
			for (@NonNull Edge edge : node.getOutgoingEdges()) {
				if (edge.isNavigation()) {
					gatherReachables(reachableNodes, edge.getTarget());
				}
			}
		}
	}

	public @Nullable EdgeRole getEdgeRole(@NonNull Edge edge) {
		return edge2edgeRole.get(edge);
	}

	public @Nullable NodeRole getNodeRole(@NonNull Node node) {
		return node2nodeRole.get(node);
	}

	protected @Nullable NavigationEdge getParentEdge(@NonNull Node targetNode) {
		PartitionForest forest2 = forest;
		if (forest2 == null) {
			forest = forest2 = createForest();
		}
		return forest2.getParentEdge(targetNode);
	}

	protected @NonNull Iterable<@NonNull Node> getPredecessors(@NonNull Node targetNode) {
		PartitionForest forest2 = forest;
		if (forest2 == null) {
			forest = forest2 = createForest();
		}
		return forest2.getPredecessors(targetNode);
	}

	private boolean hasEdge(@NonNull Edge edge) {
		return edge2edgeRole.containsKey(edge);
	}

	protected boolean hasNode(@NonNull Node node) {
		return node2nodeRole.containsKey(node);
	}

	protected boolean isComputable(@NonNull Set<@NonNull Node> sourceNodes, @NonNull Edge edge) {
		//		assert edge.isComputation();
		Node node = edge.getSource();
		if (!sourceNodes.add(node)) {
			return true;
		}
		if (hasNode(node)) {
			return true;
		}
		if (node.isTrue()) {
			return true;
		}
		if (node.isPattern() && node.isMatched() && node.isClass()) {
			return false;
		}
		if (node.isOperation()) {
			for (@NonNull Edge incomingEdge : node.getIncomingEdges()) {
				if (incomingEdge.isComputation() && !isComputable(sourceNodes, incomingEdge)) {
					return false;
				}
			}
		}
		else if (node.isPattern()) {
			for (@NonNull Edge incomingEdge : node.getIncomingEdges()) {
				if (incomingEdge.isComputation() && !isComputable(sourceNodes, incomingEdge)) {
					return false;
				}
			}
		}
		//		else if (node.isPredicated()) {
		//			if (!partitioner.hasPredicatedNode(node)) {
		//				return false;
		//			}
		//		}
		return true;
	}

	/*	private boolean isComputable1(@NonNull Set<@NonNull Node> sourceNodes, @NonNull Edge edge) {
		//		assert edge.isComputation();
		Node node = edge.getSource();
		if (!sourceNodes.add(node)) {
			return true;
		}
		if (node.isOperation()) {
			for (@NonNull Edge incomingEdge : node.getIncomingEdges()) {
				if (incomingEdge.isComputation() && !isComputable1(sourceNodes, incomingEdge)) {
					return false;
				}
			}
		}
		else if (node.isPredicated()) {
			if (!partitioner.hasPredicatedNode(node)) {
				return false;
			}
		}
		return true;
	}

	private boolean isComputable2(@NonNull Set<@NonNull Node> sourceNodes, @NonNull Edge edge) {
		//		assert edge.isComputation();
		Node node = edge.getSource();
		if (!sourceNodes.add(node)) {
			return true;
		}
		if (node.isOperation()) {
			for (@NonNull Edge incomingEdge : node.getIncomingEdges()) {
				if (incomingEdge.isComputation() && !isComputable2(sourceNodes, incomingEdge)) {
					return false;
				}
			}
		}
		else if (node.isRealized()) {
			if (!partitioner.hasRealizedNode(node)) {
				return false;
			}
		}
		return true;
	} */

	protected void resolveComputations() {
		for (@NonNull Node node : new ArrayList<>(node2nodeRole.keySet())) {
			resolveComputations(node);
			resolveNavigations(node);
		}
	}

	protected boolean resolveComputations(@NonNull Node targetNode) {
		boolean gotIt = false;
		for (@NonNull Edge incomingEdge : targetNode.getIncomingEdges()) {		// Should be just one.
			if (incomingEdge.isComputation() || (incomingEdge.isNavigation() && incomingEdge.isOld())) {
				Set<@NonNull Node> sourceNodes = new HashSet<>();
				if (isComputable(sourceNodes, incomingEdge)) {
					gotIt = true;
					for (@NonNull Node sourceNode : sourceNodes) {
						if (!hasNode(sourceNode)) {
							addNode(sourceNode, sourceNode.getNodeRole());
						}
					}
				}
			}
		}
		return gotIt;
	}

	protected abstract @Nullable EdgeRole resolveEdgeRole(@NonNull NodeRole sourceNodeRole, @NonNull Edge edge, @NonNull NodeRole targetNodeRole);

	/**
	 * Resolve all the edges that have a source and target node by invoking resolveEdgeRole to determine
	 * what form of edge is required.
	 */
	protected void resolveEdgeRoles() {
		for (@NonNull Edge edge : partitioner.getRegion().getEdges()) {
			if (!edge.isSecondary() && !hasEdge(edge)) {
				NodeRole sourceNodeRole = node2nodeRole.get(edge.getSource());
				if (sourceNodeRole != null) {
					NodeRole targetNodeRole = node2nodeRole.get(edge.getTarget());
					if (targetNodeRole != null) {
						EdgeRole edgeRole = resolveEdgeRole(sourceNodeRole, edge, targetNodeRole);
						if (edgeRole != null) {
							if (edgeRole.isRealized()) {
								if (partitioner.hasRealizedEdge(edge)) {
									edgeRole = null;
								}
							}
							if (edgeRole != null) {
								addEdge(edge, edgeRole);
							}
						}
					}
				}
			}
		}
	}

	protected void resolveNavigations(@NonNull Node node) {
		for (@NonNull NavigationEdge edge : node.getNavigationEdges()) {
			if (!partitioner.hasRealizedEdge(edge)) {
				Node targetNode = edge.getTarget();
				if (targetNode.isDataType()) {
					if (resolveComputations(targetNode)) {
						if (!hasNode(targetNode)) {
							addNode(targetNode, targetNode.getNodeRole());
						}
					}
				}
			}
		}
	}

	protected void resolvePredicates() {
		for (@NonNull Node targetNode : partitioner.getTrueNodes()) {
			if (!partitioner.hasTrueNode(targetNode)) {
				for (@NonNull Edge incomingEdge : targetNode.getIncomingEdges()) {		// Should be just one.
					if (incomingEdge.isComputation()) {
						Set<@NonNull Node> sourceNodes = Sets.newHashSet(targetNode);
						if (isComputable(sourceNodes, incomingEdge)) {
							for (@NonNull Node sourceNode : sourceNodes) {
								if (!hasNode(sourceNode)) {
									addNode(sourceNode, sourceNode.getNodeRole());
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return partitioner.toString();
	}
}