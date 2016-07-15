/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Type;

import com.google.common.collect.Iterables;

public abstract class AbstractMappingRegion extends AbstractRegion implements MappingRegion
{
	/**
	 * HeadComparator supports sorting a list of Head candidates into a most suitable first order.
	 */
	protected static final class HeadComparator implements Comparator<@NonNull Node>
	{
		private final @NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> target2sourceClosure;
		private @Nullable Map<@NonNull Node, @NonNull Integer> node2implicity = null;

		protected HeadComparator(@NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> target2sourceClosure) {
			this.target2sourceClosure = target2sourceClosure;
		}

		@Override
		public int compare(@NonNull Node o1, @NonNull Node o2) {
			//
			//	Least reachable first
			//
			Set<@NonNull Node> set1 = target2sourceClosure.get(o1);
			Set<@NonNull Node> set2 = target2sourceClosure.get(o2);
			assert (set1 != null) && (set2 != null);
			int l1 = set1.size();
			int l2 = set2.size();
			int diff = l1 - l2;
			if (diff != 0) {
				return diff;
			}
			//
			//	Earliest phase first (prefers LOADED to PREDICATED)
			//
			int r1 = getPhase(o1.getNodeRole());
			int r2 = getPhase(o2.getNodeRole());
			diff = r1 - r2;
			if (diff != 0) {
				return diff;
			}
			//
			//	Least implicit first (prefers middle to output)
			//
			int i1 = getImplicity(o1);
			int i2 = getImplicity(o2);
			diff = i1 - i2;
			if (diff != 0) {
				return diff;
			}
			//
			//	Alphabetical
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
				node2implicity = node2implicity2 = new HashMap<@NonNull Node, @NonNull Integer>();
			}
			Integer implicity = node2implicity2.get(node);
			if (implicity == null) {
				implicity = 0;
				for (@NonNull NavigationEdge e : node.getNavigationEdges()) {
					if (e.getProperty().isIsImplicit()) {
						implicity++;
					}
				}
				node2implicity2.put(node, implicity);
			}
			return implicity;
		}

		private int getPhase(@NonNull NodeRole nodeRole) {
			if (nodeRole.isConstant()) {
				return 0;
			}
			if (nodeRole.isLoaded()) {
				return 1;
			}
			if (nodeRole.isPredicated()) {
				return 2;
			}
			if (nodeRole.isRealized()) {
				return 3;
			}
			return 4;
		}
	}

	/**
	 * The subsets of guardVariables from which all guardVariables are to-one navigable.
	 */
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> headNodes = null;

	protected AbstractMappingRegion(@NonNull MultiRegion multiRegion) {
		super(multiRegion);
	}

	protected void addHeadNode(@NonNull Node headNode) {
		getHeadNodes().add(headNode);
	}

	protected @NonNull List<@NonNull Node> computeHeadNodes() {
		Iterable<@NonNull Node> navigableNodes = getNavigableNodes();		// Excludes, null, attributes, constants, operations
		//
		//	Compute the Set of all target nodes that can be reached by transitive to-one navigation from a particular source node.
		//
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> source2targetClosure = new HashMap<@NonNull Node, @NonNull Set<@NonNull Node>>();
		for (@NonNull Node navigableNode : navigableNodes) {
			if (navigableNode.isAttributeNode()) {
				continue;									// FIXME avoid even considering these nodes
			}
			Type type = navigableNode.getCompleteClass().getPrimaryClass();
			if (type instanceof CollectionType) {
				System.err.println("No head created for CollectionType " + type + " in " + this);
				continue;
			}
			Set<@NonNull Node> targetClosure = new HashSet<@NonNull Node>();
			source2targetClosure.put(navigableNode, targetClosure);
			targetClosure.add(navigableNode);
			for (@NonNull Edge navigationEdge : navigableNode.getNavigationEdges()) {
				if (!navigationEdge.isRealized()) {
					targetClosure.add(navigationEdge.getTarget());
				}
			}
			for (@NonNull Edge computationEdge : navigableNode.getComputationEdges()) {
				targetClosure.add(computationEdge.getSource());
			}
		}
		boolean isChanged = true;
		while (isChanged) {
			isChanged = false;
			for (@NonNull Node sourceNode : navigableNodes) {
				Set<Node> targetClosure = source2targetClosure.get(sourceNode);
				if (targetClosure != null) {
					for (@NonNull Node nextNode : new ArrayList<@NonNull Node>(targetClosure)) {
						Set<@NonNull Node> nextTargetClosure = source2targetClosure.get(nextNode);
						if ((nextTargetClosure != null) && targetClosure.addAll(nextTargetClosure)) {
							isChanged = true;
						}
					}
				}
			}
		}
		//
		//	Compute the inverse Set of all source nodes from which a particular target node can be reached by transitive to-one navigation.
		//
		final Map<@NonNull Node, @NonNull Set<@NonNull Node>> target2sourceClosure = new HashMap<@NonNull Node, @NonNull Set<@NonNull Node>>();
		for (@NonNull Node targetNode : navigableNodes) {
			Set<@NonNull Node> sourceClosure = new HashSet<@NonNull Node>();
			target2sourceClosure.put(targetNode, sourceClosure);
			sourceClosure.add(targetNode);
		}
		for (@NonNull Node sourceNode : source2targetClosure.keySet()) {
			Set<@NonNull Node> targetClosure = source2targetClosure.get(sourceNode);
			assert targetClosure != null;
			for (@NonNull Node targetNode : targetClosure) {
				Set<@NonNull Node> sourceClosure = target2sourceClosure.get(targetNode);
				if (sourceClosure != null) {
					sourceClosure.add(sourceNode);
				}
			}
		}
		//
		//	Sort the guardNodes into least reachable first order enabling the heads to be identified
		//	by successive removal from the start of the list.
		//
		List<@NonNull Node> headLessNodes = new ArrayList<@NonNull Node>();
		Iterables.addAll(headLessNodes, source2targetClosure.keySet());
		Collections.sort(headLessNodes, new HeadComparator(target2sourceClosure));
		//
		//	Loop to keep removing distinct inputs until all guard nodes are reachable from some head.
		//
		List<@NonNull Node> headNodes = new ArrayList<@NonNull Node>();
		while (!headLessNodes.isEmpty()) {
			Node headNode = headLessNodes.remove(0);
			assert headNode != null;
			Set<@NonNull Node> targetClosure = source2targetClosure.get(headNode);
			assert targetClosure != null;
			headNode.setHead();
			headLessNodes.removeAll(targetClosure);
			targetClosure.remove(headNode);
			assert !headNodes.contains(headNode);
			headNodes.add(headNode);
		}
		return headNodes;
	}

	@Override
	public final @NonNull List<@NonNull Node> getHeadNodes() {
		List<@NonNull Node> headNodes2 = headNodes;
		if (headNodes2 == null) {
			headNodes = headNodes2 = computeHeadNodes();
		}
		return headNodes2;
	}

	@Override
	public void resetHead(@NonNull Node headNode) {
		boolean wasRemoved = getHeadNodes().remove(headNode);
		assert wasRemoved;
		headNode.resetHead();
	}
}