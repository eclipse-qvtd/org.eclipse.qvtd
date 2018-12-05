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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * A HeadNodeGroup identifies a set of mutually one to one navigable nodes from which many nodes can be navigated.
 *
 * If necessary a HeadNodeGroup supports a determination atht all nodes in one head node group can be derived from
 * those in another.
 */
public class HeadNodeGroup
{
	/**
	 * The mutually to-one navigable nodes that define the head group.
	 */
	private final @NonNull List<@NonNull Node> headGroupNodes;

	/**
	 * The object nodes awaiting analysis.
	 */
	private Deque<@NonNull Node> workList = null;

	/**
	 * The object nodes currently known to be to-one navigable from the head.
	 */
	private Set<@NonNull Node> uniqueNodes = null;

	/**
	 * The iterated nodes currently known to be to-one navigable from the head.
	 */
	private Set<@NonNull Node> iteratedNodes = null;

	/**
	 * The collection nodes currently known to be to-one navigable from the head.
	 */
	private Set<@NonNull Node> aggregateNodes = null;

	public HeadNodeGroup(@NonNull List<@NonNull Node> headGroupNodes) {
		this.headGroupNodes = headGroupNodes;
	}

	private boolean accumulateReachableTargets(@NonNull Node sourceNode) {
		boolean gotOne = false;
		boolean isIteratedSource = iteratedNodes.contains(sourceNode);
		boolean isAggregateSource = aggregateNodes.contains(sourceNode);
		boolean isOldSource = sourceNode.isOld();
		for (@NonNull Edge source2targetEdge : QVTscheduleUtil.getOutgoingEdges(sourceNode)) {
			if (isOldSource ? source2targetEdge.isOld() : source2targetEdge.isNew()) {
				boolean isAggregateArgument = false;
				Type targetType = null;
				Node targetNode = QVTscheduleUtil.getTargetNode(source2targetEdge);
				if (uniqueNodes.contains(targetNode) || iteratedNodes.contains(targetNode) || aggregateNodes.contains(targetNode)) {
					// targetType = null;			// already reached
				}
				else if (source2targetEdge.isCast() || source2targetEdge.isNavigation()) {
					Property targetProperty = QVTscheduleUtil.getProperty((NavigableEdge) source2targetEdge);
					targetType = targetProperty.getType();
				}
				else if (source2targetEdge.isPredicate()) {
					// targetType = null;			// «includes» is not reachable
				}
				else if (source2targetEdge.isComputation()) {
					isAggregateArgument = isAggregateSource && targetNode.isOperation();
					boolean allArgumentsReachable = true;
					for (@NonNull Edge argumentEdge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
						if ((argumentEdge != source2targetEdge) && argumentEdge.isComputation()) {
							Node argumentNode = QVTscheduleUtil.getSourceNode(argumentEdge);
							if (!argumentNode.isConstant() && !uniqueNodes.contains(argumentNode) && !iteratedNodes.contains(argumentNode) && !aggregateNodes.contains(argumentNode)) {
								allArgumentsReachable = false;
								break;
							}
							Type argumentType = argumentNode.getCompleteClass().getPrimaryClass();
							if (argumentType instanceof CollectionType) {
								isAggregateArgument = targetNode.isOperation();
							}
						}
					}
					if (allArgumentsReachable) {
						// assert targetNode.isOperation() || targetNode.isIterator();
						targetType = targetNode.getCompleteClass().getPrimaryClass();
					}
				}
				if (targetType != null) {
					if (targetType instanceof CollectionType) {
						aggregateNodes.add(targetNode);
					}
					else if ((isAggregateSource || isIteratedSource) &&!isAggregateArgument) {
						iteratedNodes.add(targetNode);
					}
					else {
						//							assert isToOne;
						uniqueNodes.add(targetNode);
					}
					workList.add(targetNode);
					gotOne = true;
				}
			}
		}
		return gotOne;
	}

	private void accumulateReachables() {
		workList = new ArrayDeque<>(headGroupNodes);
		uniqueNodes = new HashSet<>(headGroupNodes);
		iteratedNodes = new HashSet<>();
		aggregateNodes = new HashSet<>();
		while (!workList.isEmpty()) {
			Node workNode = workList.removeFirst();
			accumulateReachableTargets(workNode);
		}
	}

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
		if (iteratedNodes != null) {
			s.append("\n\tto-iterated:");
			for (@NonNull Node node : iteratedNodes) {
				s.append("\n\t\t");
				s.append(node);
			}
		}
		if (aggregateNodes != null) {
			s.append("\n\tto-aggregates:");
			for (@NonNull Node node : aggregateNodes) {
				s.append("\n\t\t");
				s.append(node);
			}
		}
		if (workList != null) {
			s.append("\n\twork-list:");
			for (@NonNull Node node : workList) {
				s.append("\n\t\t");
				s.append(node);
			}
		}
		return s.toString();
	}
}