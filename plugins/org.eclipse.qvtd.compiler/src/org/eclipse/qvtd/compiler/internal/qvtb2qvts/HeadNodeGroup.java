/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * A HeadNodeGroup identifies a set of mutually one to one navigable nodes from which many nodes can be navigated.
 *
 * If necessary a HeadNodeGroup supports a determination that all nodes in one head node group can be derived from
 * those in another.
 */
public abstract class HeadNodeGroup implements Nameable
{
	/**
	 * The mutually to-one navigable nodes that define the head group.
	 */
	private final @NonNull List<@NonNull Node> headGroupNodes;

	/**
	 * The object nodes currently known to be to-one navigable from the head.
	 */
	private Set<@NonNull Node> uniqueNodes = null;

	public HeadNodeGroup(@NonNull List<@NonNull Node> headGroupNodes) {
		assert !headGroupNodes.isEmpty();
		this.headGroupNodes = headGroupNodes;
	}

	private boolean accumulateReachableTargets(@NonNull Deque<@NonNull Node> workList) {
		Node sourceNode = workList.removeFirst();
		assert sourceNode.isMatched();
		boolean gotOne = false;
		for (@NonNull Edge source2targetEdge : QVTscheduleUtil.getOutgoingEdges(sourceNode)) {
			Node targetNode = QVTscheduleUtil.getTargetNode(source2targetEdge);
			if (targetNode.isMatched() && canBeSameGroup(sourceNode, source2targetEdge) && !uniqueNodes.contains(targetNode)) {
				if (source2targetEdge.isCast()) {				// Can happen when analyzing traced heads
					uniqueNodes.add(targetNode);
					workList.add(targetNode);
					gotOne = true;
				}
				else if (source2targetEdge.isPredicate()) {
					uniqueNodes.add(targetNode);
					gotOne = true;
				}
				else if (source2targetEdge.isNavigation()) {
					if (!source2targetEdge.isPartial()) {
						uniqueNodes.add(targetNode);
						workList.add(targetNode);
						gotOne = true;
					}
				}
				else if (source2targetEdge.isComputation()) {
					boolean allArgumentsReachable = true;
					for (@NonNull Edge argumentEdge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
						if ((argumentEdge != source2targetEdge) && argumentEdge.isComputation()) {
							Node argumentNode = QVTscheduleUtil.getSourceNode(argumentEdge);
							if (argumentNode.isMatched()) {
								if (!argumentNode.isConstant() && !uniqueNodes.contains(argumentNode)) {
									allArgumentsReachable = false;
									break;
								}
							}
						}
					}
					if (allArgumentsReachable) {
						uniqueNodes.add(targetNode);
						workList.add(targetNode);
						gotOne = true;
					}
				}
			}
		}
		for (@NonNull Edge target2sourceEdge : QVTscheduleUtil.getIncomingEdges(sourceNode)) {
			if (target2sourceEdge instanceof KeyPartEdge) {		// FIXME KeyPartEdge is bidirectional
				Node targetNode = QVTscheduleUtil.getSourceNode(target2sourceEdge);
				uniqueNodes.add(targetNode);
				if (targetNode.isMatched()) {
					workList.add(targetNode);
				}
				gotOne = true;
			}
		}
		return gotOne;
	}

	private void accumulateReachables() {
		Deque<@NonNull Node> workList = new ArrayDeque<>(headGroupNodes);
		uniqueNodes = new HashSet<>(headGroupNodes);
		while (!workList.isEmpty()) {
			accumulateReachableTargets(workList);
		}
	}

	public void appendTo(@NonNull StringBuilder s) {
		s.append("heads:");
		List<@NonNull Node> nodeList1 = new ArrayList<>(headGroupNodes);
		Collections.sort(nodeList1, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull Node node : nodeList1) {
			s.append(" ");
			s.append(node.getName());
		}
		if (uniqueNodes != null) {
			List<@NonNull Node> nodeList2 = new ArrayList<>(uniqueNodes);
			nodeList2.removeAll(headGroupNodes);
			if (nodeList2.size() > 0) {
				Collections.sort(nodeList2, NameUtil.NAMEABLE_COMPARATOR);
				s.append(", to-ones:");
				for (@NonNull Node node : nodeList2) {
					s.append(" ");
					s.append(node.getName());
				}
			}
		}
	}

	protected abstract boolean canBeSameGroup(@NonNull Node sourceNode, @NonNull Edge source2targetEdge);

	public @NonNull Iterable<@NonNull Node> getHeadNodes() {
		return headGroupNodes;
	}

	public @NonNull Node getPreferredHeadNode(@Nullable Iterable<@NonNull Node> preferredHeadNodes) {
		if (preferredHeadNodes != null) {
			for (@NonNull Node node : headGroupNodes) {
				if (Iterables.contains(preferredHeadNodes, node)) {
					return node;
				}
			}
		}
		return headGroupNodes.get(0);
	}

	private @NonNull Set<@NonNull Node> getToOneSet() {
		Set<@NonNull Node> toOneSet2 = uniqueNodes;
		if (toOneSet2 == null) {
			accumulateReachables();
			toOneSet2 = uniqueNodes;
			assert toOneSet2 != null;
		}
		return toOneSet2;
	}

	/**
	 * Return true if all of the headNodes of this HeadNodeGroup are reachable as to-one nodess of thatHeadNodeGroup.
	 */
	public boolean isDeriveableFrom(@NonNull HeadNodeGroup thatHeadNodeGroup) {
		return thatHeadNodeGroup.getToOneSet().containsAll(headGroupNodes);
	}

	/**
	 * Return true if any of the headNodes of this HeadNodeGroup are part of the this TypedModel.
	 */
	public boolean isThis() {
		for (@NonNull Node headNode : headGroupNodes) {
			ClassDatum classDatum = QVTscheduleUtil.getClassDatum(headNode);
			TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
			if (typedModel.isIsThis()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(headGroupNodes.iterator().next().getOwningRegion());
		s.append("\n\theads:");
		for (@NonNull Node node : headGroupNodes) {
			s.append("\n\t\t");
			s.append(node);
		}
		if (uniqueNodes != null) {
			s.append("\n\tto-ones:");
			for (@NonNull Node node : uniqueNodes) {
				s.append("\n\t\t");
				s.append(node);
			}
		}
		return s.toString();
	}
}