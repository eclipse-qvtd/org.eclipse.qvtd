/*******************************************************************************
 * Copyright (c) 2017, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvti;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Lists;

/**
 * NavigationEdgeSorter supports ordering of a list of NavigationEdges into least-dependent first order thereby ensuring
 * that unrealized variables are created and initialized for accessed realized attribute nodes before they are used.
 */
public class NavigationEdgeSorter
{
	public class SourceNodeSizeComparator implements Comparator<@NonNull NavigableEdge>
	{
		@Override
		public int compare(@NonNull NavigableEdge o1, @NonNull NavigableEdge o2) {
			Set<@NonNull Node> s1 = edge2sourceNodes.get(o1);
			Set<@NonNull Node> s2 = edge2sourceNodes.get(o2);
			int i1 = s1 != null ? s1.size() : 0;
			int i2 = s2 != null ? s2.size() : 0;
			if (i1 != i2) {
				return i1 - i2;
			}
			String n1 = o1.toString();
			String n2 = o2.toString();
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	public static @NonNull Iterable<@NonNull NavigableEdge> getSortedAssignments(@NonNull Iterable<@NonNull NavigableEdge> realizedNavigationEdges) {
		NavigationEdgeSorter assignmentSorter = new NavigationEdgeSorter();
		for (@NonNull NavigableEdge edge : realizedNavigationEdges) {
			if (!edge.isSecondary()) {
				assignmentSorter.add(edge);
			}
		}
		return assignmentSorter.getSortedAssignments();
	}

	/**
	 * Map from each edge to the computational source nodes of the edge's target.
	 */
	protected final @NonNull Map<@NonNull NavigableEdge, @Nullable Set<@NonNull Node>> edge2sourceNodes = new HashMap<>();

	/**
	 * Add all navigationEdges to the Map of analyzed edges.
	 */
	public void add(@NonNull NavigableEdge navigationEdge) {
		Set<@NonNull Node> sourceNodes = null;
		if (navigationEdge.isRealized()) {
			Node targetNode = navigationEdge.getEdgeTarget();
			if (targetNode.isDataType()) {
				sourceNodes = gatherSourceNodes(new HashSet<@NonNull Node>(), targetNode);
			}
		}
		edge2sourceNodes.put(navigationEdge, sourceNodes);
	}

	private @NonNull Set<@NonNull Node> gatherSourceNodes(@NonNull Set<@NonNull Node> sourceNodes, @NonNull Node node) {
		if (sourceNodes.add(node)) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isComputation()) {
					gatherSourceNodes(sourceNodes, edge.getEdgeSource());
				}
			}
		}
		return sourceNodes;
	}

	/**
	 * Return the edges in fewest dependencies first order.
	 */
	public @NonNull Iterable<@NonNull NavigableEdge> getSortedAssignments() {
		List<@NonNull NavigableEdge> sortedEdges = Lists.newArrayList(edge2sourceNodes.keySet());
		Collections.sort(sortedEdges, new SourceNodeSizeComparator());
		return sortedEdges;
	}
}
