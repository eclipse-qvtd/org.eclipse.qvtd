/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import com.google.common.collect.Iterables;

/**
 * HeadAnalysis is a helper class to compute the head nodes of a region.
 */
public abstract class HeadAnalysis
{
	/**
	 * HeadComparator supports sorting a list of Head candidates into a most suitable first order.
	 */
	protected static class HeadComparator implements Comparator<@NonNull Node>
	{
		private final @NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourceClosure;
		private final @Nullable List<@NonNull Node> preferredHeadNodes;
		private @Nullable Map<@NonNull Node, @NonNull Integer> node2implicity = null;

		public HeadComparator(@NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourceClosure, @Nullable List<@NonNull Node> preferredHeadNodes) {
			this.targetFromSourceClosure = targetFromSourceClosure;
			this.preferredHeadNodes = preferredHeadNodes;
		}

		@Override
		public int compare(@NonNull Node o1, @NonNull Node o2) {
			//
			//	DataTypes last
			//
			boolean d1 = o1.isDataType();
			boolean d2 = o2.isDataType();
			if (d1 != d2) {
				return d1 ? 1 : -1;
			}
			//
			//	Preferred heads in preference order.
			//
			List<@NonNull Node> preferredHeadNodes2 = preferredHeadNodes;
			if (preferredHeadNodes2 != null) {
				int i1 = preferredHeadNodes2.indexOf(o1);
				int i2 = preferredHeadNodes2.indexOf(o2);
				if (i1 != i2) {
					if (i1 < 0) {
						return 1;
					}
					else if (i2 < 0) {
						return -1;
					}
					else {
						return i1 - i2;
					}
				}
			}
			//
			//	Explicit head first
			//
			//			if (o1.isHead() != o2.isHead()) {
			//				return o1.isHead() ? -1 : 1;
			//			}
			//
			//	Speculated first
			//
			if (o1.isSpeculated() != o2.isSpeculated()) {
				return o1.isSpeculated() ? -1 : 1;
			}
			//
			//	Constant next - never happens
			//
			if (o1.isConstant() != o2.isConstant()) {
				return o1.isConstant() ? -1 : 1;
			}
			//
			//	Least reachable next
			//
			Set<@NonNull Node> set1 = targetFromSourceClosure.get(o1);
			Set<@NonNull Node> set2 = targetFromSourceClosure.get(o2);
			assert (set1 != null) && (set2 != null);
			int l1 = set1.size();
			int l2 = set2.size();
			int diff = l1 - l2;
			if (diff != 0) {
				return diff;
			}
			//
			//	Loaded heads seem more attractive than predicated, since we can just dispatch on an input object collection. If the scheduler ensures
			//	that the predicated input is actually ready then we just incur a probably inefficuent implicit opposite navigation.
			//
			//	But conversely, predicated heads ensure that we use what we are waiting for anyway and then navigate more efficiently.
			//
			//	The clinching argument demonstrated by testQVTcCompiler_Forward2Reverse is that the predicated candidate might
			//	be part of a nasty cyclic dependency and so need speculation. Heads cannot be speculated. So we must prefer a loaded head
			//	at least until we can anticipate speculation more accurately.
			//
			//	Loaded next
			//
			if (o1.isLoaded() != o2.isLoaded()) {
				return o1.isLoaded() ? -1 : 1;
			}
			//
			//	Predicated next
			//
			if (o1.isPredicated() != o2.isPredicated()) {
				return o1.isPredicated() ? -1 : 1;
			}
			//
			//	Least implicit next (prefers middle to output)
			//
			int i1 = getImplicity(o1);
			int i2 = getImplicity(o2);
			diff = i1 - i2;
			if (diff != 0) {
				return diff;
			}
			//
			//	Alphabetical last
			//
			String n1 = o1.getName();
			String n2 = o2.getName();
			return n1.compareTo(n2);
		}

		/**
		 * Return the number of outgoing implicit connection from node. A middle model node
		 * has no implicit connections and so is a better candodate for a head than an output
		 * model node which has implicit connections to the trace.
		 */
		private int getImplicity(@NonNull Node node) {
			Map<@NonNull Node, @NonNull Integer> node2implicity2 = node2implicity;
			if (node2implicity2 == null) {
				node2implicity = node2implicity2 = new HashMap<>();
			}
			Integer implicity = node2implicity2.get(node);
			if (implicity == null) {
				implicity = 0;
				for (@NonNull NavigableEdge e : node.getNavigableEdges()) {
					if (e.getProperty().isIsImplicit()) {
						implicity++;
					}
				}
				node2implicity2.put(node, implicity);
			}
			return implicity;
		}
	}

	//	protected final @NonNull Partition partition;
	protected final @NonNull MappingRegion mappingRegion;

	protected HeadAnalysis(@NonNull MappingRegion mappingRegion) {
		this.mappingRegion = mappingRegion;;
	}

	protected @NonNull List<@NonNull HeadNodeGroup> computeHeadNodeGroups(@NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourcesClosure,
			@NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> sourceToTargetsClosure,
			@Nullable List<@NonNull Node> preferredHeadNodes) {
		//
		//	Sort the guardNodes into least reachable first order enabling the heads to be identified
		//	by successive removal from the start of the list.
		//
		List<@NonNull Node> headLessNodes = new ArrayList<>();
		Iterables.addAll(headLessNodes, targetFromSourcesClosure.keySet());
		Collections.sort(headLessNodes, new HeadComparator(targetFromSourcesClosure, preferredHeadNodes));
		//
		//	Loop to identify the least reachable residual node and then remove all nodes reachable from this new head.
		//	Removed nodes from which the new head is reachable are accumulated as a mutually reachable head group.
		//
		List<@NonNull HeadNodeGroup> headNodeGroups = new ArrayList<>();
		Set<@NonNull Node> reachableNodes = new HashSet<>();
		while (!headLessNodes.isEmpty()) {
			Node headNode = headLessNodes.remove(0);
			assert headNode != null;
			List<@NonNull Node> headNodeGroup = new ArrayList<>();
			headNodeGroup.add(headNode);
			@SuppressWarnings("unused") Set<@NonNull Node> debugSourceClosure = targetFromSourcesClosure.get(headNode);
			Set<@NonNull Node> targetsClosure = sourceToTargetsClosure.get(headNode);
			assert targetsClosure != null;
			for (@NonNull Node targetNode : targetsClosure) {
				if (reachableNodes.add(targetNode)) {
					headLessNodes.remove(targetNode);
					if (targetNode != headNode) {
						Set<@NonNull Node> otherTargetsClosure = sourceToTargetsClosure.get(targetNode);
						assert otherTargetsClosure != null;
						if (otherTargetsClosure.contains(headNode)) {
							headNodeGroup.add(targetNode);
						}
					}
				}
			}
			headNodeGroups.add(new HeadNodeGroup(headNodeGroup));
		}
		//
		//	Prune any computationally derived heads
		//
		if (headNodeGroups.size() > 1) {	// FIXME do we really need to do this for unidirectional transformations??
			for (int iGroup = headNodeGroups.size()-1; iGroup >= 0; --iGroup) {		// Reverse index to allow removal
				HeadNodeGroup headNodeGroup = headNodeGroups.get(iGroup);
				for (@NonNull HeadNodeGroup otherHeadNodeGroup : headNodeGroups) {
					if (otherHeadNodeGroup != headNodeGroup) {
						if (headNodeGroup.isDeriveableFrom(otherHeadNodeGroup)) {
							headNodeGroups.remove(iGroup);
							break;
						}
					}
				}
			}
		}
		return headNodeGroups;
	}

	/*
	 *	Pick the first element of each headNodeGroup as a headNode.
	 */
	protected @NonNull List<@NonNull Node> selectHeadNodes(@NonNull List<@NonNull HeadNodeGroup> headNodeGroups,
			@Nullable Iterable<@NonNull Node> preferredHeadNodes) {
		List<@NonNull Node> headNodes = new ArrayList<>();
		for (@NonNull HeadNodeGroup headNodeGroup : headNodeGroups) {
			Node headNode = headNodeGroup.getPreferredHeadNode(preferredHeadNodes);
			assert !headNodes.contains(headNode);
			headNodes.add(headNode);
		}
		return headNodes;
	}

	@Override
	public String toString() {
		return mappingRegion.toString();
	}
}