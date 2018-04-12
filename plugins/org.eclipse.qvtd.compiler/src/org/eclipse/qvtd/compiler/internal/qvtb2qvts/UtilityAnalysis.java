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
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Sets;

/**
 * UtilityAnalysis is a helper that assigns a Utility value to each Region node.
 *
 * FIXME a QVTrelationUtilityAnalysis might be simpler than this QVTc chain version.
 */
public class UtilityAnalysis
{
	public static void assignUtilities(@NonNull RuleRegion region) {
		new UtilityAnalysis(region).assignUtilities();
	}

	protected final @NonNull MappingRegion mappingRegion;

	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> stronglyMatchedNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> unconditionalNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> conditionalNodes = null;
	//	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> dependencyNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> deadNodes = null;

	protected UtilityAnalysis(@NonNull MappingRegion mappingRegion) {
		this.mappingRegion = mappingRegion;
	}

	protected void assignUtilities() {		// FIXME remove assertions after 1-Jan-2017
		Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(mappingRegion);
		Set<@NonNull Node> stronglyMatchedNodes = computeStronglyMatchedNodes(headNodes);
		Set<@NonNull Node> unconditionalNodes = computeUnconditionalNodes(headNodes);
		Set<@NonNull Node> conditionalNodes = computeConditionalNodes(unconditionalNodes);
		//		Set<@NonNull Node> dependencyNodes = computeDependencyNodes(headNodes);
		Set<@NonNull Node> deadNodes = null;
		//
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			if (stronglyMatchedNodes.contains(node)) {
				node.setUtility(Node.Utility.STRONGLY_MATCHED);
				//FIXME				assert unconditionalNodes.contains(node);
				if (!unconditionalNodes.contains(node)) {
					System.err.println(node + " is not unconditional in " + this);
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
		if (node.isExplicitNull()) {
			return true;
		}
		if (node.isPattern()) {
			return true;
		}
		if (node.isConstant()) {
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