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
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;

import com.google.common.collect.Lists;

/**
 * An AbstractGroup represents one or more mutually navigable head nodes and their reachable nodes within a
 * multi-headed Region. The abstract fuinctionality maintains the comptable realtionships between the groups.
 */
abstract class AbstractGroup implements Group
{
	/**
	 * The Splitter supervising the region splitting.
	 */
	protected final @NonNull SplitterAnalysis splitter;

	/**
	 * The name of the group.
	 */
	protected final @NonNull String name;

	/**
	 * All the nodes reachable from one of the head nodes by to-one navigation.
	 */
	private final @NonNull Set<@NonNull Node> reachableNodes;

	/**
	 * Map from each incoming computation edge to the preceding groups.
	 */
	private final @NonNull Map<@NonNull Edge, @NonNull List<@NonNull AbstractGroup>> edge2predecessors = new HashMap<>();

	/**
	 * Map from each outgoing computationedge to the succeding group.
	 */
	private final @NonNull Map<@NonNull Edge, @NonNull AbstractGroup> edge2successor = new HashMap<>();

	/**
	 * Each predecessor group and the edges that compute from that group to this group.
	 */
	private final @NonNull Map<@NonNull AbstractGroup, @NonNull List<@NonNull Edge>> predecessor2edges = new HashMap<>();

	/**
	 * The successor groups and the edge that computes it.
	 */
	private final @NonNull LinkedHashMap<@NonNull AbstractGroup, @NonNull Edge> successorGroups = new LinkedHashMap<>();

	protected AbstractGroup(@NonNull SplitterAnalysis splitter, @NonNull List<@NonNull Node> headNodes) {
		this.splitter = splitter;
		this.name = SplitterUtil.computeMultiHeadNodeName(headNodes);
		this.reachableNodes = SplitterUtil.computeNavigableNodes(headNodes);
	}

	public void addPredecessor(@NonNull Edge edge, @NonNull List<@NonNull AbstractGroup> predecessorGroups) {
		List<@NonNull AbstractGroup> oldPredecessorGroups = edge2predecessors.put(edge, predecessorGroups);
		assert oldPredecessorGroups == null;
		for (@NonNull AbstractGroup predecessorGroup : predecessorGroups) {
			AbstractGroup oldSuccessorGroup = predecessorGroup.edge2successor.put(edge, this);
			assert oldSuccessorGroup == null;
			List<@NonNull Edge> edges = predecessor2edges.get(predecessorGroup);
			if (edges == null) {
				edges = new ArrayList<>();
				predecessor2edges.put(predecessorGroup, edges);
			}
			assert !edges.contains(edge);
			edges.add(edge);
		}
	}

	public void addSuccessor(@NonNull AbstractGroup successorGroup) {
		//		successorGroup.predecessorGroups.add(this);
		List<@NonNull Edge> edges = successorGroup.predecessor2edges.get(this);
		assert (edges != null) && !edges.isEmpty();
		if (edges.size() > 1) {
			edges = Lists.newArrayList(edges);
			Collections.sort(edges, NameUtil.NAMEABLE_COMPARATOR);	// Is there a better heuristic than alphaberically first ?
		}
		Edge edge = edges.get(0);
		assert !successorGroups.containsKey(successorGroup);
		//		assert !successorGroup.predecessorGroups.contains(this);
		successorGroups.put(successorGroup, edge);
	}

	public void buildSplit(@NonNull Split split, @Nullable SimpleGroup sourceSimpleGroup) {
		for (Map.Entry<@NonNull AbstractGroup, @NonNull Edge> entry : successorGroups.entrySet()) {
			entry.getKey().buildSplit(split, sourceSimpleGroup, entry.getValue());
		}
	}

	public abstract void computeMutualOrdering(@NonNull Iterable<@NonNull SimpleGroup> externalSimpleGroups);

	/**
	 * Descend a computable group tree passing simpleGroups to each navigable group so that the
	 * navigable group schedules according to the simpleGroups that have been resolved by the
	 * calling context.
	 */
	public void computeNavigableGroupSchedule(@NonNull Iterable<@NonNull SimpleGroup> simpleGroups) {
		computeMutualOrdering(simpleGroups);
		List<@NonNull SimpleGroup> nestedSimpleGroups = Lists.newArrayList(simpleGroups);
		for (@NonNull SimpleGroup simpleGroup : getInternalSimpleGroups()) {
			nestedSimpleGroups.add(simpleGroup);
		}
		for (@NonNull AbstractGroup successorGroup : successorGroups.keySet()) {
			successorGroup.computeNavigableGroupSchedule(nestedSimpleGroups);
		}
	}

	protected abstract void buildSplit(@NonNull Split subregion, @Nullable SimpleGroup sourceSimpleGroup, @Nullable Edge edge);

	public abstract @NonNull Iterable<@NonNull SimpleGroup> getInternalSimpleGroups();

	@Override
	public final @NonNull String getName() {
		return name;
	}

	public @NonNull Iterable<@NonNull AbstractGroup> getPredecessors() {
		return predecessor2edges.keySet();
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getReachableNodes() {
		return reachableNodes;
	}

	public @NonNull SplitterAnalysis getSplitter() {
		return splitter;
	}

	//	public void setPredecessor(@NonNull ComputableGroup lastScheduledComputable) {
	//		lastScheduledComputable.successorGroups.add(this);
	//	}

	@Override
	public @NonNull String toString() {
		return name;
	}

	@Override
	public void toString(@NonNull StringBuilder s, int depth) {
		List<@NonNull Group> sortedGroups = Lists.newArrayList(successorGroups.keySet());
		Collections.sort(sortedGroups, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull Group group : sortedGroups) {
			Edge edge = successorGroups.get(group);
			assert edge != null;
			s.append("\n");
			CompilerUtil.indent(s, depth+1);
			s.append("successor:\n");
			CompilerUtil.indent(s, depth+2);
			s.append("edge: ");
			s.append(edge.toString());
			s.append("\n");
			group.toString(s, depth+2);
		}
	}
}