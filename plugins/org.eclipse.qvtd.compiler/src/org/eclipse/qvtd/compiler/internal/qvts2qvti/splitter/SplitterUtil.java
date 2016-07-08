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
package org.eclipse.qvtd.compiler.internal.qvts2qvti.splitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;

import com.google.common.collect.Lists;

class SplitterUtil
{
	public static @NonNull Set<@NonNull Node> computeComputableNodes(@NonNull Iterable<@NonNull Node> nodes) {
		Set<@NonNull Node> computableNodes = new HashSet<>();
		for (@NonNull Node node : nodes) {
			computeComputableNodes(computableNodes, node);
		}
		return Collections.unmodifiableSet(computableNodes);
	}

	private static void computeComputableNodes(@NonNull Set<@NonNull Node> computableNodes, @NonNull Node sourceNode) {
		if (computableNodes.add(sourceNode)) {
			for (@NonNull Edge edge : sourceNode.getOutgoingEdges()) {
				if (edge.isComputation()) {
					Node targetNode = edge.getTarget();
					computeComputableNodes(computableNodes, targetNode);
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


	/* public static @NonNull Set<@NonNull Node> computeReachableNodes(@NonNull Iterable<@NonNull SimpleGroup> simpleGroups) {
		Set<@NonNull Node> reachableNodes = new HashSet<>();
		for (@NonNull SimpleGroup simpleGroup : simpleGroups) {
			Iterables.addAll(reachableNodes, simpleGroup.getReachableNodes());
		}
		return Collections.unmodifiableSet(reachableNodes);
	} */

	public static @NonNull Set<@NonNull Node> computeReachableNodes(@NonNull Iterable<@NonNull Node> headNodes) {
		Set<@NonNull Node> reachableNodes = new HashSet<>();
		for (@NonNull Node headNode : headNodes) {
			computeReachableNodes(reachableNodes, headNode);
		}
		return reachableNodes;
	}

	private static @NonNull Set<@NonNull Node> computeReachableNodes(@NonNull Set<@NonNull Node> reachableNodes, @NonNull Node sourceNode) {
		if (reachableNodes.add(sourceNode)) {
			for (@NonNull NavigationEdge edge : sourceNode.getNavigationEdges()) {
				assert edge.getSource() == sourceNode;
				if (!edge.isRealized() && edge.isNavigable()) {
					Node targetNode = edge.getTarget();
					computeReachableNodes(reachableNodes, targetNode);
				}
			}
		}
		return reachableNodes;
	}

	public static void indent(@NonNull StringBuilder s, int depth) {
		for (int i = 0; i < depth; i++) {
			s.append("    ");
		}
	}
}