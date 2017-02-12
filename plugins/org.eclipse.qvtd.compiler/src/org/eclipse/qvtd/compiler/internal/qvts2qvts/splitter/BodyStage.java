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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.splitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A BodyStage specifies the final part of a multi-headed region split.
 * It has headNodes to represent its inputs.
 */
class BodyStage extends AbstractStage
{
	private static void computeOperationSources(Set<@NonNull Node> nodes, @NonNull Node node) {
		if (nodes.add(node)) {
			for (@NonNull Edge edge : node.getIncomingEdges()) {
				if (edge.isExpression()) {
					computeOperationSources(nodes, edge.getEdgeSource());
				}
			}
		}
	}

	//	private final @NonNull List<@NonNull Stage> stages;
	//	private final @NonNull Iterable<@NonNull Node> visibleIteratedNodes;
	private final @NonNull Iterable<@NonNull Node> visibleIteratorNodes;
	private final @NonNull Iterable<@NonNull Node> realizedNodes;
	private final @NonNull Iterable<@NonNull Node> allHeadNodes;
	private final @NonNull Iterable<@NonNull Node> directlyRequiredNodes;
	private final @NonNull Iterable<@NonNull Node> deadNodes;
	private final @NonNull Iterable<@NonNull Node> indirectlyRequiredNodes;

	public BodyStage(@NonNull SplitterAnalysis splitter, @NonNull Iterable<@NonNull Stage> stages) {
		super(splitter);
		//		this.stages = Lists.newArrayList(stages);
		//		this.visibleIteratedNodes = computedVisibleIteratedNodes(stages);
		this.visibleIteratorNodes = computedVisibleIteratorNodes(stages);
		this.realizedNodes = computeNewNodes();
		//
		//	Determine the nodes needed to realize the realized nodes.
		//
		Iterable<@NonNull Node> requiredNodes = computeRequiredNodes();
		this.allHeadNodes = computeAllHeadNodes(requiredNodes);
		this.directlyRequiredNodes = computeDirectlyRequiredNodes(requiredNodes);
		Iterable<@NonNull Node> allNodes = computeAllNodes();
		this.deadNodes = computeDeadNodes(allNodes);
		this.indirectlyRequiredNodes = computeIndirectlyRequiredNodes(allNodes);
	}

	@Override
	protected @NonNull String buildContents(@NonNull StringBuilder s) {
		//		build(s, "visible iterated nodes", visibleIteratedNodes);
		//		build(s, "visible iterator nodes", visibleIteratorNodes);
		build(s, "all head nodes", allHeadNodes);
		build(s, "realized nodes", realizedNodes);
		build(s, "directly required nodes", directlyRequiredNodes);
		build(s, "indirectly required nodes", indirectlyRequiredNodes);
		build(s, "dead nodes", deadNodes);
		return "body";
	}

	@Override
	public void check() {
		Set<@NonNull Node> accumulator = new HashSet<>();
		checkAccumulate(accumulator, allHeadNodes);
		checkAccumulate(accumulator, realizedNodes);
		checkAccumulate(accumulator, directlyRequiredNodes);
		checkAccumulate(accumulator, indirectlyRequiredNodes);
		checkAccumulate(accumulator, deadNodes);
		checkAccumulated(accumulator, splitter.getRegion().getNodes());
	}

	/**
	 * The original head nodes and the intermediate heads for computed iterators are directly detectable
	 * as traced inputs of the realized trace object. Intermediate heads for inverse navigated iterators
	 * are detectable from the visible iterators.
	 */
	protected @NonNull Iterable<@NonNull Node> computeAllHeadNodes(@NonNull Iterable<@NonNull Node> requiredNodes) {
		Set<@NonNull Node> nodeSet = Sets.newHashSet(visibleIteratorNodes);
		for (@NonNull Node headNode : splitter.getRegion().getHeadNodes()) {
			if (headNode.isSpeculated() || headNode.isPredicated()) {
				nodeSet.add(headNode);
			}
		}
		for (@NonNull Node node : requiredNodes) {
			if (node.isHead()) {
				nodeSet.add(node);
			}
		}
		List<@NonNull Node> nodes = Lists.newArrayList(nodeSet);
		Collections.sort(nodes, NameUtil.NAMEABLE_COMPARATOR);
		return nodes;
	}

	protected @NonNull Iterable<@NonNull Node> computeAllNodes() {
		Set<@NonNull Node> navigableNodes = SplitterUtil.computeNavigableNodes(allHeadNodes);
		Set<@NonNull Node> computableNodes = SplitterUtil.computeComputableTargetNodes(navigableNodes);
		Set<@NonNull Node> allNodes = Sets.newHashSet(navigableNodes);
		allNodes.addAll(computableNodes);
		return allNodes;
	}

	/**
	 * The directly required nodes are the required nodes that are not head nodes.
	 */
	protected @NonNull Iterable<@NonNull Node> computeDirectlyRequiredNodes(@NonNull Iterable<@NonNull Node> requiredNodes) {
		List<@NonNull Node> nodes = Lists.newArrayList(requiredNodes);
		CompilerUtil.removeAll(nodes, allHeadNodes);
		Collections.sort(nodes, NameUtil.NAMEABLE_COMPARATOR);
		return nodes;
	}

	protected @NonNull Iterable<@NonNull Node>  computeIndirectlyRequiredNodes(@NonNull Iterable<@NonNull Node> allNodes) {
		Set<@NonNull Node> nodeSet = Sets.newHashSet(allNodes);
		CompilerUtil.removeAll(nodeSet, allHeadNodes);
		CompilerUtil.removeAll(nodeSet, deadNodes);
		CompilerUtil.removeAll(nodeSet, directlyRequiredNodes);
		CompilerUtil.removeAll(nodeSet, realizedNodes);
		List<@NonNull Node> nodesList = Lists.newArrayList(nodeSet);
		Collections.sort(nodesList, NameUtil.NAMEABLE_COMPARATOR);
		return nodesList;
	}

	protected @NonNull Iterable<@NonNull Node> computeNewNodes() {
		Region region = splitter.getRegion();
		List<@NonNull Node> newNode = Lists.newArrayList(region.getNewNodes());
		Collections.sort(newNode, NameUtil.NAMEABLE_COMPARATOR);
		return newNode;
	}

	protected @NonNull Iterable<@NonNull Node> computeReachableNodes(@NonNull Iterable<@NonNull Node> requiredNodes) {
		Set<@NonNull Node> reachableNodes = SplitterUtil.computeNavigableNodes(allHeadNodes);
		//		assert reachableNodes.containsAll(requiredNodes);
		for (@NonNull Node node : requiredNodes) {
			reachableNodes.remove(node);
		}
		List<@NonNull Node> reachableNodesList = Lists.newArrayList(reachableNodes);
		Collections.sort(reachableNodesList, NameUtil.NAMEABLE_COMPARATOR);
		return reachableNodesList;
	}

	/**
	 * The required nodes are the sources of all realized navigation edges, and the transitive source
	 * of all computations terminating in a realized node.
	 */
	protected @NonNull Iterable<@NonNull Node> computeRequiredNodes() {
		Set<@NonNull Node> requiredNodeSet = new HashSet<>();
		for (@NonNull Node node : realizedNodes) {
			if (node.isOperation()) {
				computeOperationSources(requiredNodeSet, node);
			}
		}
		Region region = splitter.getRegion();
		for (@NonNull Edge edge : region.getRealizedEdges()) {
			requiredNodeSet.add(edge.getEdgeSource());
			requiredNodeSet.add(edge.getEdgeTarget());
		}
		for (@NonNull Node node : realizedNodes) {
			requiredNodeSet.remove(node);
		}
		List<@NonNull Node> nodes = Lists.newArrayList(requiredNodeSet);
		Collections.sort(nodes, NameUtil.NAMEABLE_COMPARATOR);
		return nodes;
	}

	protected @NonNull Iterable<@NonNull Node> computedVisibleIteratedNodes(Iterable<@NonNull Stage> stages) {
		List<@NonNull Node> nodes = new ArrayList<>();
		for (@NonNull Stage stage : stages) {
			Node node = stage.getIteratedNode();
			if (node != null) {
				nodes.add(node);
			}
		}
		Collections.sort(nodes, NameUtil.NAMEABLE_COMPARATOR);
		return nodes;
	}

	protected @NonNull Iterable<@NonNull Node> computedVisibleIteratorNodes(Iterable<@NonNull Stage> stages) {
		List<@NonNull Node> nodes = new ArrayList<>();
		for (@NonNull Stage stage : stages) {
			Node node = stage.getIteratorNode();
			if (node != null) {
				nodes.add(node);
			}
		}
		Collections.sort(nodes, NameUtil.NAMEABLE_COMPARATOR);
		return nodes;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getHeadNodes() {
		return allHeadNodes;
	}

	@Override
	protected boolean isLive(@NonNull Node node, @NonNull Set<@NonNull Node> deadNodes) {
		if (node.isHead()) {
			return true;		// Head node is needed
		}
		if (node.isRealized()) {
			return true;		// Realized node is needed
		}
		for (@NonNull Edge edge : node.getIncomingEdges()) {
			if (edge.isRealized()) {
				return true;	// Target of a realized edge is needed
			}
		}
		for (@NonNull Edge edge : node.getOutgoingEdges()) {
			Node targetNode = edge.getEdgeTarget();
			if (!deadNodes.contains(targetNode) && !targetNode.isHead()) {
				return true;	// Source of a live computation of a non-head is needed.
			}
		}
		return false ;
	}

	@Override
	public void toString(@NonNull StringBuilder s, int depth) {
		CompilerUtil.indent(s, depth);
		s.append("body");
	}
}