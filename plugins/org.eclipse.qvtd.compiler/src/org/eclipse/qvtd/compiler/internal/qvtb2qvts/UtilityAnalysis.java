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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseLibraryHelper;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Node.Utility;
import org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;

import com.google.common.collect.Sets;

/**
 * UtilityAnalysis is a helper that assigns a Utility value to each Region node.
 *
 * FIXME a QVTrelationUtilityAnalysis might be simpler than this QVTc chain version.
 */
public class UtilityAnalysis
{
	public static void assignUtilities(@NonNull ScheduleManager scheduleManager, @NonNull RuleRegion region) {
		new UtilityAnalysis(scheduleManager, region).assignUtilities();
	}

	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull MappingRegion mappingRegion;
	protected final @NonNull QVTbaseLibraryHelper qvtbaseLibraryHelper;

	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> stronglyMatchedNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> unconditionalNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> conditionalNodes = null;
	//	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> dependencyNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> deadNodes = null;

	protected UtilityAnalysis(@NonNull ScheduleManager scheduleManager, @NonNull MappingRegion mappingRegion) {
		this.scheduleManager = scheduleManager;
		this.mappingRegion = mappingRegion;
		this.qvtbaseLibraryHelper = scheduleManager.getQVTbaseLibraryHelper();
	}

	protected void assignUtilities() {		// FIXME remove assertions after 1-Jan-2017
		Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(mappingRegion);
		Node dispatchNode = computeDispatchNode();
		Set<@NonNull Node> traceNodes = computeTraceNodes(headNodes);
		Set<@NonNull Node> stronglyMatchedNodes = computeStronglyMatchedNodes(headNodes);
		Set<@NonNull Node> unconditionalNodes = computeUnconditionalNodes(headNodes);
		Set<@NonNull Node> conditionalNodes = computeConditionalNodes(unconditionalNodes);
		//		Set<@NonNull Node> dependencyNodes = computeDependencyNodes(headNodes);
		Set<@NonNull Node> deadNodes = null;
		//
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			Node.Utility oldUtility = node.basicGetUtility();
			if (dispatchNode == node) {
				node.setUtility(Node.Utility.DISPATCH);
			}
			else if (traceNodes.contains(node)) {
				node.setUtility(Node.Utility.TRACE);
			}
			else if (stronglyMatchedNodes.contains(node)) {
				node.setUtility(Node.Utility.STRONGLY_MATCHED);
				//FIXME				assert unconditionalNodes.contains(node);
				if (!unconditionalNodes.contains(node)) {
					QVTruntimeUtil.errPrintln(node + " is not unconditional in " + this);
				}
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
			Node.Utility newUtility = node.getUtility();
			if (oldUtility != null) {
				assert oldUtility == newUtility;
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

	private boolean canBeStronglyMatched(@NonNull Node node) {
		if (node.isPattern()) {
			return true;
		}
		if (node.isConstant()) {
			return true;
		}
		return false;
	}

	private boolean canBeUnconditional(@NonNull Node node) {
		if (node.isIterator()) {
			return false;
		}
		if (node.isOperation()) {
			return true;
		}
		if (node.isPattern()) {
			return true;
		}
		if (node.isSuccess()) {
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

	private @Nullable Node computeDispatchNode() {
		Node dispatchNode = null;
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			if (node.isPredicated()) {
				if (node.basicGetUtility() == Utility.DISPATCH) {
					assert dispatchNode == null;		// No double dispatch
					dispatchNode = node;
				}
			}
		}
		return dispatchNode;
	}

	private @NonNull Set<@NonNull Node> computeStronglyMatchedNodes(@NonNull Iterable<@NonNull Node> headNodes) {
		Set<@NonNull Node> stronglyMatchedNodes = new HashSet<>();
		for (@NonNull Node headNode : headNodes) {
			if (!headNode.isDependency()) {
				stronglyMatchedNodes.add(headNode);
			}
		}
		//		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
		//			if (node.isConstant()) {
		//				stronglyMatchedNodes.add(node);
		//			}
		//		}
		Set<@NonNull Node> moreStronglyMatchedNodes = new HashSet<>(stronglyMatchedNodes);
		while (moreStronglyMatchedNodes.size() > 0) {
			Set<@NonNull Node> moreMoreNodes = new HashSet<>();
			for (@NonNull Node sourceNode : moreStronglyMatchedNodes) {
				for (@NonNull NavigableEdge edge : sourceNode.getNavigableEdges()) {
					Node targetNode = edge.getEdgeTarget();
					if (canBeStronglyMatched(targetNode)) {
						if (targetNode.isNullLiteral() || edge.getProperty().isIsRequired()) {
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

	private Set<@NonNull Node> computeTraceNodes(@NonNull Iterable<@NonNull Node> headNodes) {
		Set<@NonNull Node> traceNodes = new HashSet<>();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			if (node.basicGetUtility() == Utility.TRACE) {
				traceNodes.add(node);
			}
		}
		if (traceNodes.isEmpty()) {			// A QVTc / legacy usage - deduce trace node(s)
			for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
				if (node.isRealized() && scheduleManager.isMiddle(node)) {
					traceNodes.add(node);
				}
			}
		}
		return traceNodes;
	}

	private @NonNull Set<@NonNull Node> computeUnconditionalNodes(@NonNull Iterable<@NonNull Node> headNodes) {
		@NonNull Set<@NonNull Node> unconditionalNodes = Sets.newHashSet(headNodes);
		//		Iterables.addAll(unconditionalNodes, mappingRegion.getNewNodes());
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			if (node.isNew() || node.isConstant()) {
				unconditionalNodes.add(node);
			}
		}
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
					assert !incomingEdge.isCast();
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
					else if (outgoingEdge.isDependency()) {}
					else if (outgoingEdge.isCast() || outgoingEdge.isNavigation()) {
						if (targetNode.isNullLiteral()) {
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

	private boolean isConditionalEdge(@NonNull Edge edge) {
		if (edge instanceof OperationParameterEdge) {
			OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
			Parameter parameter = operationParameterEdge.getReferredParameter();
			if (parameter == qvtbaseLibraryHelper.getIfThenParameter()) {
				return true;
			}
			else if (parameter == qvtbaseLibraryHelper.getIfElseParameter()) {
				return true;
			}
			else if (parameter == qvtbaseLibraryHelper.getLoopBodyParameter()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return mappingRegion.toString();
	}
}