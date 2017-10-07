/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

public class RegionHelper
{
	public static void initHeadNodes(@NonNull MappingRegion mappingRegion, @Nullable List<@NonNull Node> preferredHeadNodes) {
		RegionHelper regionHelper = new RegionHelper(mappingRegion);
		regionHelper.initHeadNodes(preferredHeadNodes);
	}

	public class HeadNodeGroup
	{
		private final @NonNull List<@NonNull Node> headNodes;
		private Set<@NonNull Node> missingNodes = null;
		private List<@NonNull Node> toOneList = null;
		private Set<@NonNull Node> toOneSet = null;
		private List<@NonNull Node> toManyList = null;
		private Set<@NonNull Node> toManySet = null;

		public HeadNodeGroup(@NonNull List<@NonNull Node> headNodes) {
			this.headNodes = headNodes;
		}

		public @NonNull Iterable<@NonNull Node> getHeadNodes() {
			return headNodes;
		}

		public @NonNull Node getPreferredHeadNode() {
			return headNodes.get(0);
		}

		private void computeReachables() {
			missingNodes = new HashSet<>();
			toOneList = new ArrayList<>(headNodes);
			toOneSet = new HashSet<>(headNodes);
			toManyList = new ArrayList<>();
			toManySet = new HashSet<>();
			int iToOne = 0;
			int iToMany = 0;
			while ((iToOne < toOneList.size()) || (iToMany < toManyList.size())) {
				while (iToOne < toOneList.size()) {
					Node toOneNode = toOneList.get(iToOne++);
					computeReachable(toOneNode);
				}
				if (iToMany < toManyList.size()) {
					Node toManyNode = toManyList.get(iToMany++);
					computeReachable(toManyNode);
				}
			}
		}

		private void computeReachable(@NonNull Node node) {
			for (@NonNull Edge outgoingEdge : RegionUtil.getOutgoingEdges(node)) {
				if (outgoingEdge.isOld()) {
					Type sourceType = null;
					Node targetNode = RegionUtil.getTargetNode(outgoingEdge);
					if (outgoingEdge.isNavigation()) {
						Property targetProperty = RegionUtil.getProperty((NavigableEdge) outgoingEdge);
						sourceType = targetProperty.getType();
					}
					else if (outgoingEdge.isPredicate()) {
						// sourceType = null;			// «includes» is not reachable
					}
					else if (outgoingEdge.isComputation() && !toOneSet.contains(targetNode) && !toManySet.contains(targetNode)) {
						boolean reachable = true;
						for (@NonNull Edge incomingEdge : RegionUtil.getIncomingEdges(targetNode)) {
							if ((incomingEdge != outgoingEdge) && incomingEdge.isComputation()) {
								Node sourceNode = RegionUtil.getSourceNode(incomingEdge);
								if (!sourceNode.isConstant() && !toOneSet.contains(sourceNode) && !toManySet.contains(sourceNode)) {
									missingNodes.add(sourceNode);
									reachable = false;
								}
							}
						}
						if (reachable) {
							// assert targetNode.isOperation() || targetNode.isIterator();
							Iterable<@NonNull TypedElement> typedElements = targetNode.getTypedElements();
							if (!Iterables.isEmpty(typedElements)) {
								TypedElement typedElement = typedElements.iterator().next();
								sourceType = typedElement.getType();
							}
						}
					}
					if (sourceType != null) {
						Type nodeType = null;
						Iterable<@NonNull TypedElement> typedElements = targetNode.getTypedElements();
						if (!Iterables.isEmpty(typedElements)) {
							TypedElement typedElement = typedElements.iterator().next();
							nodeType = typedElement.getType();
						}
						if ((sourceType instanceof CollectionType) || (nodeType instanceof CollectionType)) {
							if (!toOneSet.contains(targetNode) && toManySet.add(targetNode)) {
								toManyList.add(targetNode);
								missingNodes.remove(targetNode);
							}
						}
						else {
							if (toOneSet.add(targetNode)) {
								toOneList.add(targetNode);
								missingNodes.remove(targetNode);
							}
						}
					}
				}
			}
		}

		/**
		 * Return true if all of the headNodes of this HeadNodeGroup are reachable as to-one nodess of thatHeadNodeGroup.
		 */
		public boolean isDeriveableFrom(@NonNull HeadNodeGroup thatHeadNodeGroup) {
			return thatHeadNodeGroup.getToOneList().containsAll(headNodes);
		}

		private @NonNull List<@NonNull Node> getToOneList() {
			List<@NonNull Node> toOneList2 = toOneList;
			if (toOneList2 == null) {
				computeReachables();
				toOneList2 = toOneList;
				assert toOneList2 != null;
			}
			return toOneList2;
		}

		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(mappingRegion);
			s.append("\n\theads:");
			for (@NonNull Node node : headNodes) {
				s.append("\n\t\t");
				s.append(node);
			}
			if (toOneList != null) {
				s.append("\n\tto-ones:");
				for (@NonNull Node node : toOneList) {
					s.append("\n\t\t");
					s.append(node);
				}
			}
			if (toManyList != null) {
				s.append("\n\tto-manys:");
				for (@NonNull Node node : toManyList) {
					s.append("\n\t\t");
					s.append(node);
				}
			}
			if (missingNodes != null) {
				s.append("\n\tmissings:");
				for (@NonNull Node node : missingNodes) {
					s.append("\n\t\t");
					s.append(node);
				}
			}
			return s.toString();
		}
	}

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
			//	Uncast next
			//
			boolean c1 = RegionUtil.getCastTarget(o1) != o1;
			boolean c2 = RegionUtil.getCastTarget(o2) != o2;
			if (c1 != c2) {
				return !c1 ? -1 : 1;
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
				for (@NonNull NavigableEdge e : node.getNavigationEdges()) {
					if (e.getProperty().isIsImplicit()) {
						implicity++;
					}
				}
				node2implicity2.put(node, implicity);
			}
			return implicity;
		}
	}

	protected final @NonNull MappingRegion mappingRegion;

	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> stronglyMatchedNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> unconditionalNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> conditionalNodes = null;
	//	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> dependencyNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> deadNodes = null;

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

	public @NonNull List<@NonNull Node> computeHeadNodes(@NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSources, @Nullable List<@NonNull Node> preferredHeadNodes) {
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourcesClosure = targetFromSources;
		Iterable <@NonNull Node> navigableNodes = targetFromSourcesClosure.keySet();
		//
		//	Ripple the local target-from-sources to compute the overall target-from-sources closure.
		//
		boolean isChanged = true;
		while (isChanged) {
			isChanged = false;
			for (@NonNull Node targetNode : navigableNodes) {
				Set<@NonNull Node> sourcesClosure = targetFromSourcesClosure.get(targetNode);
				assert sourcesClosure != null;
				for (@NonNull Node sourceNode : new ArrayList<>(sourcesClosure)) {
					Set<@NonNull Node> sourceSourceClosure = targetFromSourcesClosure.get(sourceNode);
					assert sourceSourceClosure != null;
					if (sourcesClosure.addAll(sourceSourceClosure)) {
						isChanged = true;
					}
				}
			}
		}
		//
		//	Compute the inverse Set of all source nodes from which a particular target node can be reached by transitive to-one navigation.
		//
		final Map<@NonNull Node, @NonNull Set<@NonNull Node>> source2targetsClosure = new HashMap<>();
		for (@NonNull Node sourceNode : navigableNodes) {
			source2targetsClosure.put(sourceNode, Sets.newHashSet(sourceNode));
		}
		for (@NonNull Node targetNode : targetFromSourcesClosure.keySet()) {
			Set<@NonNull Node> sourcesClosure = targetFromSourcesClosure.get(targetNode);
			assert sourcesClosure != null;
			for (@NonNull Node sourceNode : sourcesClosure) {
				Set<@NonNull Node> targetClosure = source2targetsClosure.get(sourceNode);
				assert targetClosure != null;
				targetClosure.add(targetNode);
			}
		}
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
			Set<@NonNull Node> targetsClosure = source2targetsClosure.get(headNode);
			assert targetsClosure != null;
			for (@NonNull Node targetNode : targetsClosure) {
				if (reachableNodes.add(targetNode)) {
					headLessNodes.remove(targetNode);
					if (targetNode != headNode) {
						Set<@NonNull Node> otherTargetsClosure = source2targetsClosure.get(targetNode);
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
		if (headNodeGroups.size() > 1) {
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
		//
		//	Pick the first element of each headNodeGroup as a headNode.
		//
		List<@NonNull Node> headNodes = new ArrayList<>();
		for (@NonNull HeadNodeGroup headNodeGroup : headNodeGroups) {
			Node headNode = headNodeGroup.getPreferredHeadNode();
			assert !headNodes.contains(headNode);
			headNodes.add(headNode);
		}
		//
		//	Set/reset the head flag on each node.
		//
		assert reachableNodes.equals(targetFromSourcesClosure.keySet());
		for (@NonNull Node node : reachableNodes) {
			if (headNodes.contains(node)) {
				node.setHead();
			}
			else {
				node.resetHead();
			}
		}
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

	//
	//	Compute the Set of all source nodes from which each target can be reached by transitive to-one navigation.
	//
	protected @NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> computeTargetFromSources(@NonNull Iterable<@NonNull Node> navigableNodes) {
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
			//				System.out.println("No head created for CollectionType " + type + " in " + this);
			//				continue;
			//			}
			//			Set<@NonNull Node> sourceClosure = new HashSet<>();
			//			targetFromSourceClosure.put(navigableNode, targetClosure);
			//			targetClosure.add(navigableNode);
			for (@NonNull Edge navigationEdge : sourceNode.getNavigationEdges()) {
				if (!navigationEdge.isRealized()) {
					Node targetNode = navigationEdge.getEdgeTarget();
					if (targetNode.isMatched() /*&& targetNode.isClass()*/ && !targetNode.isExplicitNull()) {
						Set<@NonNull Node> sourceClosure = targetFromSourceClosure.get(targetNode);
						if (sourceClosure != null) {
							sourceClosure.add(sourceNode);
						}
					}
				}
			}
		}
		return targetFromSourceClosure;
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
				System.out.println("Dead node in " + this + " : " + node);
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

	public @NonNull List<@NonNull Node> initHeadNodes(@Nullable List<@NonNull Node> preferredHeadNodes) {
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
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSources = computeTargetFromSources(navigableNodes);
		List<@NonNull Node> headNodes = computeHeadNodes(targetFromSources, preferredHeadNodes);
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
		mappingRegion.getHeadNodes().addAll(headNodes);
		return headNodes;
	}

	private boolean isConditionalEdge(@NonNull Edge edge) {
		String edgeName = edge.getName();
		return QVTscheduleConstants.IF_THEN_NAME.equals(edgeName)
				|| QVTscheduleConstants.IF_ELSE_NAME.equals(edgeName)
				|| QVTscheduleConstants.LOOP_BODY_NAME.equals(edgeName);
	}

	@Override
	public String toString() {
		return mappingRegion.toString();
	}
}