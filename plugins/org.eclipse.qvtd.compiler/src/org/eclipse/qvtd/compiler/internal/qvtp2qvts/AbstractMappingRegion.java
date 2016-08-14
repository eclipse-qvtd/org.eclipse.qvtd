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
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public abstract class AbstractMappingRegion extends AbstractRegion implements MappingRegion
{
	/**
	 * HeadComparator supports sorting a list of Head candidates into a most suitable first order.
	 */
	protected static final class HeadComparator implements Comparator<@NonNull Node>
	{
		private final @NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourceClosure;
		private @Nullable Map<@NonNull Node, @NonNull Integer> node2implicity = null;

		protected HeadComparator(@NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourceClosure) {
			this.targetFromSourceClosure = targetFromSourceClosure;
		}

		@Override
		public int compare(@NonNull Node o1, @NonNull Node o2) {
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
			//	Constant first - never happens
			//
			if (o1.isConstant() != o2.isConstant()) {
				return o1.isConstant() ? -1 : 1;
			}
			//
			//	Least reachable first
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
			//	Loaded first
			//
			if (o1.isLoaded() != o2.isLoaded()) {
				return o1.isLoaded() ? -1 : 1;
			}
			//
			//	Predicated first
			//
			if (o1.isPredicated() != o2.isPredicated()) {
				return o1.isPredicated() ? -1 : 1;
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
				node2implicity = node2implicity2 = new HashMap<>();
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
	}

	/**
	 * The subsets of guardVariables from which all guardVariables are to-one navigable.
	 */
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> headNodes = null;

	protected AbstractMappingRegion(@NonNull MultiRegion multiRegion) {
		super(multiRegion);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitMappingRegion(this);
	}

	@Override
	public void addEdge(@NonNull Edge edge) {
		assert (basicGetSymbolName() == null) || !edge.isNavigation();
		super.addEdge(edge);
	}

	protected void addHeadNode(@NonNull Node headNode) {
		assert basicGetSymbolName() == null;
		getHeadNodes().add(headNode);
	}

	@Override
	public void addNode(@NonNull Node node) {
		assert basicGetSymbolName() == null;
		super.addNode(node);
	}

	protected @NonNull List<@NonNull Node> computeHeadNodes() {
		//
		//	A head node is reachable from very few nodes, typically just itself, occasionally from a small group of mutually bidirectional nodes,
		//	so we searcvh for the least reachable nodes taking care to avoid hazrads from the source-to-target / target-source asymmetry.
		//
		List<@NonNull Node> navigableNodes = new ArrayList<>();
		for (@NonNull Node node : getNodes()) {
			if (node.isPattern() && node.isNavigable() && node.isClass() && !node.isNull() && !node.isOperation()) {	// Excludes, null, attributes, constants, operations
				if (node.isLoaded() || node.isPredicated() || node.isSpeculated()) {
					navigableNodes.add(node);
				}
			}
		}
		//
		//	Compute the Set of all source nodes from which each target can be reached by transitive to-one navigation.
		//
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourceClosure = new HashMap<>();
		for (@NonNull Node targetNode : navigableNodes) {
			targetFromSourceClosure.put(targetNode, Sets.newHashSet(targetNode));
		}
		for (@NonNull Node sourceNode : navigableNodes) {
			//			assert !navigableNode.isDataType();									// FIXME avoid even considering these nodes
			//			assert !navigableNode.isSpeculation();								// FIXME avoid even considering these nodes
			//			assert !navigableNode.isRealized();									// FIXME avoid even considering these nodes
			//			Type type = navigableNode.getCompleteClass().getPrimaryClass();
			//			assert !(type instanceof CollectionType);
			//				System.err.println("No head created for CollectionType " + type + " in " + this);
			//				continue;
			//			}
			//			Set<@NonNull Node> sourceClosure = new HashSet<>();
			//			targetFromSourceClosure.put(navigableNode, targetClosure);
			//			targetClosure.add(navigableNode);
			for (@NonNull Edge navigationEdge : sourceNode.getNavigationEdges()) {
				if (!navigationEdge.isRealized()) {
					Node targetNode = navigationEdge.getTarget();
					if (targetNode.isNavigable() && targetNode.isClass() && !targetNode.isNull()) {
						Set<@NonNull Node> sourceClosure = targetFromSourceClosure.get(targetNode);
						assert sourceClosure != null;
						sourceClosure.add(sourceNode);
					}
				}
			}
			//			for (@NonNull Edge computationEdge : navigableNode.getComputationEdges()) {
			//				targetClosure.add(computationEdge.getSource());
			//			}
		}
		//
		//	Ripple the local target-from-source closure to compute the overall target-from-source closure.
		//
		boolean isChanged = true;
		while (isChanged) {
			isChanged = false;
			for (@NonNull Node targetNode : navigableNodes) {
				Set<@NonNull Node> sourceClosure = targetFromSourceClosure.get(targetNode);
				assert sourceClosure != null;
				for (@NonNull Node sourceNode : new ArrayList<>(sourceClosure)) {
					Set<@NonNull Node> sourceSourceClosure = targetFromSourceClosure.get(sourceNode);
					assert sourceSourceClosure != null;
					if (sourceClosure.addAll(sourceSourceClosure)) {
						isChanged = true;
					}
				}
			}
		}
		//
		//	Compute the inverse Set of all source nodes from which a particular target node can be reached by transitive to-one navigation.
		//
		final Map<@NonNull Node, @NonNull Set<@NonNull Node>> source2targetClosure = new HashMap<>();
		for (@NonNull Node sourceNode : navigableNodes) {
			source2targetClosure.put(sourceNode, Sets.newHashSet(sourceNode));
		}
		for (@NonNull Node targetNode : targetFromSourceClosure.keySet()) {
			Set<@NonNull Node> sourceClosure = targetFromSourceClosure.get(targetNode);
			assert sourceClosure != null;
			for (@NonNull Node sourceNode : sourceClosure) {
				Set<@NonNull Node> targetClosure = source2targetClosure.get(sourceNode);
				assert targetClosure != null;
				targetClosure.add(targetNode);
			}
		}
		//
		//	Sort the guardNodes into least reachable first order enabling the heads to be identified
		//	by successive removal from the start of the list.
		//
		List<@NonNull Node> headLessNodes = new ArrayList<>();
		Iterables.addAll(headLessNodes, targetFromSourceClosure.keySet());
		Collections.sort(headLessNodes, new HeadComparator(targetFromSourceClosure));
		//
		//	Loop to keep removing distinct inputs until all guard nodes are reachable from some head.
		//
		List<@NonNull Node> headNodes = new ArrayList<>();
		while (!headLessNodes.isEmpty()) {
			Node headNode = headLessNodes.remove(0);
			assert headNode != null;
			@SuppressWarnings("unused") Set<@NonNull Node> debugSourceClosure = targetFromSourceClosure.get(headNode);
			Set<@NonNull Node> targetClosure = source2targetClosure.get(headNode);
			assert targetClosure != null;
			for (@NonNull Node node : targetClosure) {
				if (node != headNode) {
					node.resetHead();
				}
				else {
					headNode.setHead();
				}
				headLessNodes.remove(node);
			}
			targetClosure.remove(headNode);
			assert !headNodes.contains(headNode);
			headNodes.add(headNode);
		}
		//
		//	Check head node consistency
		//
		Set<@NonNull Node> debugHeadNodes = new HashSet<>();
		for (@NonNull Node node : getNodes()) {
			if (node.isHead() && !node.isTrue() && !node.getNodeRole().isExtraGuardVariable()) {
				debugHeadNodes.add(node);
			}
		}
		assert debugHeadNodes.equals(new HashSet<>(headNodes));
		return headNodes;
	}

	@Override
	public @NonNull String getColor() {
		return "green";
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

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setColor("palegreen");
		s.setPenwidth(Role.LINE_WIDTH);
		super.toGraph(s);
	}
}