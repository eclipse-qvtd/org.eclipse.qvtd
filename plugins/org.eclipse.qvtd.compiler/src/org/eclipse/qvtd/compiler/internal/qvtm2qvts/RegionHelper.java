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
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

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
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.impl.MappingRegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public class RegionHelper
{
	public static void initHeadNodes(@NonNull MappingRegion mappingRegion) {
		RegionHelper regionHelper = new RegionHelper(mappingRegion);
		regionHelper.initHeadNodes();
	}

	/**
	 * HeadComparator supports sorting a list of Head candidates into a most suitable first order.
	 */
	protected class HeadComparator implements Comparator<@NonNull Node>
	{
		private final @NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourceClosure;

		public HeadComparator(@NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourceClosure) {
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
	}

	protected final @NonNull MappingRegion mappingRegion;

	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> stronglyMatchedNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> unconditionalNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> conditionalNodes = null;
	//	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> dependencyNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> deadNodes = null;
	private @Nullable Map<@NonNull Node, @NonNull Integer> node2implicity = null;

	public RegionHelper(@NonNull MappingRegion mappingRegion) {
		this.mappingRegion = mappingRegion;
	}

	private boolean canBeStronglyMatched(@NonNull Node node) {
		if (node.isExplicitNull()) {
			return true;
		}
		if (node.isPattern()) {
			return true;
		}
		return false;
	}

	private boolean canBeUnconditional(@NonNull Node node) {
		if (node.isExplicitNull()) {
			return true;
		}
		if (node.isIterator()) {
			return false;
		}
		if (node.isOperation()) {
			return true;
		}
		if (node.isPattern()) {
			return true;
		}
		return false;
	}

	/**
	 * Any node with an edge to an unconditional node that is not itself unconditional must be conditional.
	 */
	private @NonNull Set<@NonNull Node> computeConditionalNodes(@NonNull Set<@NonNull Node> unconditionalNodes) {
		Set<@NonNull Node> conditionalNodes = new HashSet<>();
		Set<@NonNull Node> moreNodes = unconditionalNodes;
		while (moreNodes.size() > 0) {
			Set<@NonNull Node> moreMoreNodes = new HashSet<>();
			for (@NonNull Node node : moreNodes) {
				for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(node)) {
					Node sourceNode = incomingEdge.getEdgeSource();
					if (!unconditionalNodes.contains(sourceNode) && conditionalNodes.add(sourceNode)) {
						moreMoreNodes.add(sourceNode);
					}
				}
				for (@NonNull Edge outgoingEdge : QVTscheduleUtil.getOutgoingEdges(node)) {
					Node targetNode = outgoingEdge.getEdgeTarget();
					if (!unconditionalNodes.contains(targetNode) && conditionalNodes.add(targetNode)) {
						moreMoreNodes.add(targetNode);
					}
				}
			}
			if (moreMoreNodes.size() <= 0) {
				break;
			}
			moreNodes = moreMoreNodes;
		}
		this.conditionalNodes = new ArrayList<>(conditionalNodes);
		Collections.sort(this.conditionalNodes, NameUtil.NAMEABLE_COMPARATOR);
		return conditionalNodes;
	}

	/**
	 * Any dependency node transitively connected to a deopendency head contributes to the dependency nodes.
	 *
	private @NonNull Set<@NonNull Node> computeDependencyNodes(@NonNull Iterable <@NonNull Node> headNodes) {
		Set<@NonNull Node> dependencyNodes = new HashSet<>();
		Iterable<@NonNull Node> moreNodes = headNodes;
		while (!Iterables.isEmpty(moreNodes)) {
			Set<@NonNull Node> moreMoreNodes = new HashSet<>();
			for (@NonNull Node node : moreNodes) {
				if (node.isDependency() && dependencyNodes.add(node)) {
					for (@NonNull NavigableEdge edge : node.getNavigationEdges()) {
						Node targetNode = edge.getTarget();
						moreMoreNodes.add(targetNode);
					}
				}
			}
			if (moreMoreNodes.size() <= 0) {
				break;
			}
			moreNodes = moreMoreNodes;
		}
		this.dependencyNodes = new ArrayList<>(dependencyNodes);
		Collections.sort(this.dependencyNodes, NameUtil.NAMEABLE_COMPARATOR);
		return dependencyNodes;
	} */

	protected @NonNull List<@NonNull Node> computeHeadNodes(@NonNull MappingRegion mappingRegion) {
		//
		//	A head node is reachable from very few nodes, typically just itself, occasionally from a small group of mutually bidirectional nodes,
		//	so we search for the least reachable nodes taking care to avoid hazards from the source-to-target / target-source asymmetry.
		//
		List<@NonNull Node> navigableNodes = new ArrayList<>();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			if (node.isPattern() && node.isMatched() && node.isClass() && !node.isExplicitNull() && !node.isOperation()) {	// Excludes, null, attributes, constants, operations
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
					Node targetNode = navigationEdge.getEdgeTarget();
					if (targetNode.isMatched() && targetNode.isClass() && !targetNode.isExplicitNull()) {
						Set<@NonNull Node> sourceClosure = targetFromSourceClosure.get(targetNode);
						if (sourceClosure != null) {
							sourceClosure.add(sourceNode);
						}
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
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			if (node.isTrue() || node.isDependency()) {
				debugHeadNodes.add(node);
				node.setHead();
				assert !headNodes.contains(node);
				headNodes.add(node);
			}
			else if (node.isHead()) {
				debugHeadNodes.add(node);
			}
		}
		assert debugHeadNodes.equals(new HashSet<>(headNodes));
		//
		return headNodes;
	}

	private @NonNull Set<@NonNull Node> computeStronglyMatchedNodes(@NonNull Iterable<@NonNull Node> headNodes) {
		Set<@NonNull Node> stronglyMatchedNodes = new HashSet<>();
		for (@NonNull Node headNode : headNodes) {
			if (!headNode.isDependency() && !headNode.isTrue()) {
				stronglyMatchedNodes.add(headNode);
			}
		}
		Set<@NonNull Node> moreStronglyMatchedNodes = new HashSet<>(stronglyMatchedNodes);
		while (moreStronglyMatchedNodes.size() > 0) {
			Set<@NonNull Node> moreMoreNodes = new HashSet<>();
			for (@NonNull Node sourceNode : moreStronglyMatchedNodes) {
				for (@NonNull NavigableEdge edge : sourceNode.getNavigationEdges()) {
					Node targetNode = edge.getEdgeTarget();
					if (canBeStronglyMatched(targetNode)) {
						if (targetNode.isExplicitNull() || edge.getProperty().isIsRequired()) {
							if (stronglyMatchedNodes.add(targetNode)) {
								moreMoreNodes.add(targetNode);
							}
						}
					}
				}
			}
			if (moreMoreNodes.size() <= 0) {
				break;
			}
			moreStronglyMatchedNodes = moreMoreNodes;
		}
		this.stronglyMatchedNodes = new ArrayList<>(stronglyMatchedNodes);
		Collections.sort(this.stronglyMatchedNodes, NameUtil.NAMEABLE_COMPARATOR);
		return stronglyMatchedNodes;
	}

	private @NonNull Set<@NonNull Node> computeUnconditionalNodes(@NonNull Iterable<@NonNull Node> headNodes) {
		@NonNull Set<@NonNull Node> unconditionalNodes = Sets.newHashSet(headNodes);
		Iterables.addAll(unconditionalNodes, mappingRegion.getNewNodes());
		for (@NonNull NavigableEdge edge : mappingRegion.getRealizedNavigationEdges()) {
			if (!edge.isSecondary()) {
				Node sourceNode = edge.getEdgeSource();
				assert canBeUnconditional(sourceNode);
				unconditionalNodes.add(sourceNode);
				Node targetNode = edge.getEdgeTarget();
				assert canBeUnconditional(targetNode);
				unconditionalNodes.add(targetNode);
			}
		}
		Set<@NonNull Node> moreUnconditionalNodes = new HashSet<>(unconditionalNodes);
		while (moreUnconditionalNodes.size() > 0) {
			Set<@NonNull Node> moreMoreNodes = new HashSet<>();
			for (@NonNull Node node : moreUnconditionalNodes) {
				for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(node)) {
					Node sourceNode = incomingEdge.getEdgeSource();
					if (!canBeUnconditional(sourceNode)) {}
					else if (incomingEdge.isComputation()) {
						if (!isConditionalEdge(incomingEdge)) {
							if (unconditionalNodes.add(sourceNode)) {
								moreMoreNodes.add(sourceNode);
							}
						}
						// if is <<then>>
						// gather <<then>> visibilities
						// gather <<else>> visibilities
						// intersection <<then>>/<<else>> is unconditional
					}
					else if (incomingEdge.isNavigation()) {		// Unconditional target has unconditional source
						if (unconditionalNodes.add(sourceNode)) {
							moreMoreNodes.add(sourceNode);
						}
					}
					else {
						System.out.println("Unsupported incoming edge in " + this + " : " + incomingEdge);
					}
				}
				for (@NonNull Edge outgoingEdge : QVTscheduleUtil.getOutgoingEdges(node)) {
					Node targetNode = outgoingEdge.getEdgeTarget();
					if (!canBeUnconditional(targetNode)) {}
					else if (outgoingEdge.isComputation()) {}
					else if (outgoingEdge.isNavigation()) {
						if (targetNode.isExplicitNull()) {
							if (unconditionalNodes.add(targetNode)) {
								moreMoreNodes.add(targetNode);
							}
						}
						else if (node.isRequired() && ((NavigableEdge)outgoingEdge).getProperty().isIsRequired()) {
							if (unconditionalNodes.add(targetNode)) {
								moreMoreNodes.add(targetNode);
							}
						}
					}
					else {
						System.out.println("Unsupported outgoing edge in " + this + " : " + outgoingEdge);
					}
				}
			}
			if (moreMoreNodes.size() <= 0) {
				break;
			}
			moreUnconditionalNodes = moreMoreNodes;
		}
		this.unconditionalNodes = new ArrayList<>(unconditionalNodes);
		Collections.sort(this.unconditionalNodes, NameUtil.NAMEABLE_COMPARATOR);
		return unconditionalNodes;
	}

	public void computeUtilities(@NonNull Iterable<@NonNull Node> headNodes) {		// FIXME remove assertions after 1-Jan-2017
		Set<@NonNull Node> stronglyMatchedNodes = computeStronglyMatchedNodes(headNodes);
		Set<@NonNull Node> unconditionalNodes = computeUnconditionalNodes(headNodes);
		Set<@NonNull Node> conditionalNodes = computeConditionalNodes(unconditionalNodes);
		//		Set<@NonNull Node> dependencyNodes = computeDependencyNodes(headNodes);
		Set<@NonNull Node> deadNodes = null;
		//
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			if (stronglyMatchedNodes.contains(node)) {
				node.setUtility(Node.Utility.STRONGLY_MATCHED);
				assert unconditionalNodes.contains(node);
				//				assert !dependencyNodes.contains(node);
			}
			else if (unconditionalNodes.contains(node) && !node.isDependency()) {
				node.setUtility(Node.Utility.WEAKLY_MATCHED);
				//				assert !dependencyNodes.contains(node);
			}
			else if (conditionalNodes.contains(node)) {
				node.setUtility(Node.Utility.CONDITIONAL);
				//				assert !dependencyNodes.contains(node);
			}
			else if (node.isDependency()) {
				node.setUtility(Node.Utility.DEPENDENCY);
			}
			else {
				System.err.println("Dead node in " + this + " : " + node);
				if (deadNodes == null) {
					deadNodes = new HashSet<>();
				}
				deadNodes.add(node);
				node.setUtility(Node.Utility.DEAD);
				toString();
			}
		}
		if (deadNodes != null) {
			this.deadNodes = new ArrayList<>(deadNodes);
			Collections.sort(this.deadNodes, NameUtil.NAMEABLE_COMPARATOR);
		}
		/*		for (@NonNull Node node : getNodes()) {
			boolean isMatched = node.isMatched();
			boolean isUnconditional = node.isUnconditional();
			boolean isRequired = node.isRequired();
			boolean isPattern = node.isPattern();
			if (isMatched != (isUnconditional && isPattern)) {
				System.out.println("Inconsistently isMatched in " + this + " : " + node);
			}
		} */
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
			for (@NonNull NavigableEdge e : node.getNavigationEdges()) {
				if (e.getProperty().isIsImplicit()) {
					implicity++;
				}
			}
			node2implicity2.put(node, implicity);
		}
		return implicity;
	}

	public @NonNull List<@NonNull Node> initHeadNodes() {
		List<@NonNull Node> headNodes = computeHeadNodes(mappingRegion);
		((MappingRegionImpl)mappingRegion).getHeadNodes2().addAll(headNodes);
		return headNodes;
	}

	private boolean isConditionalEdge(@NonNull Edge edge) {
		String edgeName = edge.getName();
		return QVTscheduleConstants.IF_THEN_NAME.equals(edgeName)
				|| QVTscheduleConstants.IF_ELSE_NAME.equals(edgeName)
				|| QVTscheduleConstants.LOOP_BODY_NAME.equals(edgeName);
	}
}