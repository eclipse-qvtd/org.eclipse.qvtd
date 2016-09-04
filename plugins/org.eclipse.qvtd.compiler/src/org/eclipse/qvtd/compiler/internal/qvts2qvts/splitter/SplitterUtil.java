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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigableEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;

import com.google.common.collect.Lists;

class SplitterUtil
{
	/**
	 * Return the nodes (including seedNodes) that can be reached by computation from seedNodes.
	 */
	public static @NonNull Set<@NonNull Node> computeComputableTargetNodes(@NonNull Iterable<@NonNull Node> seedNodes) {
		Set<@NonNull Node> computableTargetNodes = new HashSet<>();
		Set<@NonNull Node> unresolvedOperationNodes = new HashSet<>();
		for (@NonNull Node node : seedNodes) {
			computeComputableTargetNodes(computableTargetNodes, node, unresolvedOperationNodes);
		}
		while (!unresolvedOperationNodes.isEmpty()) {
			boolean resolvedOne = false;
			for (@NonNull Node unresolvedNode : new ArrayList<>(unresolvedOperationNodes)) {
				boolean allReachable = true;
				for (@NonNull Edge edge : unresolvedNode.getIncomingEdges()) {
					if (edge.isExpression() && !computableTargetNodes.contains(edge.getSource())) {
						allReachable = false;
					}
				}
				if (allReachable) {
					resolvedOne = true;
					unresolvedOperationNodes.remove(unresolvedNode);
					computeComputableTargetNodes(computableTargetNodes, unresolvedNode, unresolvedOperationNodes);
				}
			}
			if (!resolvedOne) {
				break;
			}
		}
		return Collections.unmodifiableSet(computableTargetNodes);
	}

	private static void computeComputableTargetNodes(@NonNull Set<@NonNull Node> computableTargetNodes, @NonNull Node sourceNode, @NonNull Set<@NonNull Node> unresolvedOperationNodes) {
		if (computableTargetNodes.add(sourceNode)) {
			for (@NonNull Edge edge : sourceNode.getOutgoingEdges()) {
				if (edge.isComputation() || (edge.isNavigation() && !edge.isMatched())) {
					Node targetNode = edge.getTarget();
					if (targetNode.isRealized() && targetNode.isOperation()) {
						unresolvedOperationNodes.add(targetNode);		// Keys require an all-input check.
					}
					else {		// FIXME ?? exclude computation of many that is consumed as not-many
						computeComputableTargetNodes(computableTargetNodes, targetNode, unresolvedOperationNodes);
					}
				}
			}
			for (@NonNull Edge edge : sourceNode.getIncomingEdges()) {	// FIXME gather constant inputs to avoid assert fail
				if (edge.isComputation()){ // || (edge.isConstant())) {
					Node node = edge.getSource();
					if (node.isConstant()) {
						computeComputableTargetNodes(computableTargetNodes, node, unresolvedOperationNodes);
					}
				}
			}
		}
	}

	public static @NonNull List<@NonNull Node> computeHeadNodes(@NonNull Iterable<@NonNull SimpleGroup> simpleGroups) {
		Set<@NonNull Node> headNodeSet = new HashSet<>();
		for (@NonNull SimpleGroup simpleGroup : simpleGroups) {
			headNodeSet.add(simpleGroup.getHeadNode());
		}
		ArrayList<@NonNull Node> headNodeList = new ArrayList<>(headNodeSet);
		Collections.sort(headNodeList, NameUtil.NAMEABLE_COMPARATOR);
		return headNodeList;
	}

	public static @NonNull String computeMultiHeadNodeName(Iterable<@NonNull Node> headNodes) {
		StringBuilder s = new StringBuilder();
		List<@NonNull Node> sortedHeadNodes = Lists.newArrayList(headNodes);
		Collections.sort(sortedHeadNodes, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull Node headNode : sortedHeadNodes) {
			if (s.length() <= 0) {
				s.append("\"");
			}
			else {
				s.append(",");
			}
			s.append(headNode.getName());
		}
		s.append("\"");
		return s.toString();
	}

	/**
	 * Return the nodes (including headNodes) that can be reached by to-one navigation from headNodes.
	 */
	public static @NonNull Set<@NonNull Node> computeNavigableNodes(@NonNull Iterable<@NonNull Node> headNodes) {
		Set<@NonNull Node> reachableNodes = new HashSet<>();
		for (@NonNull Node headNode : headNodes) {
			computeNavigableNodes(reachableNodes, headNode);
		}
		return reachableNodes;
	}

	private static @NonNull Set<@NonNull Node> computeNavigableNodes(@NonNull Set<@NonNull Node> reachableNodes, @NonNull Node sourceNode) {
		if (reachableNodes.add(sourceNode)) {
			for (@NonNull NavigableEdge edge : sourceNode.getNavigationEdges()) {
				assert edge.getSource() == sourceNode;
				if (!edge.isRealized() && edge.isMatched()) {
					Node targetNode = edge.getTarget();
					computeNavigableNodes(reachableNodes, targetNode);
				}
			}
		}
		return reachableNodes;
	}

	public static boolean isBidirectional(@NonNull Edge edge) {
		if (!edge.isNavigation()) {
			return false;
		}
		Node sourceNode = edge.getSource();
		Node targetNode = edge.getTarget();
		for (@NonNull Edge edge2 : targetNode.getOutgoingEdges()) {
			if (edge2.isNavigation() && (edge2.getTarget() == sourceNode)) {
				return true;
			}
		}
		return false;
	}
}