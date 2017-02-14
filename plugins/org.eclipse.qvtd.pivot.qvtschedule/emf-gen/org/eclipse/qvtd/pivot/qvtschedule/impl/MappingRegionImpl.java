/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MultiRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class MappingRegionImpl extends RegionImpl implements MappingRegion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.MAPPING_REGION;
	}

	/**
	 * The subsets of guardVariables from which all guardVariables are to-one navigable.
	 */
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> headNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> stronglyMatchedNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> unconditionalNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> conditionalNodes = null;
	//	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> dependencyNodes = null;
	private /*@LazyNonNull*/ @Nullable List<@NonNull Node> deadNodes = null;

	protected MappingRegionImpl(@NonNull MultiRegion multiRegion) {
		super(multiRegion);
	}

	@Override
	public void addEdge(@NonNull Edge edge) {
		assert stronglyMatchedNodes == null;
		assert unconditionalNodes == null;
		assert conditionalNodes == null;
		assert (basicGetSymbolName() == null) || !edge.isNavigation();
		super.addEdge(edge);
	}

	protected void addHeadNode(@NonNull Node headNode) {
		assert basicGetSymbolName() == null;
		if (headNodes != null) { assert !headNodes.contains(headNode); }
		getHeadNodes().add(headNode);
	}

	/*	@Override
	public void addNode(@NonNull Node node) {
		assert stronglyMatchedNodes == null;
		assert unconditionalNodes == null;
		assert conditionalNodes == null;
		assert basicGetSymbolName() == null;
		super.addNode(node);
	} */

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

	protected @NonNull List<@NonNull Node> computeHeadNodes() {
		//
		//	A head node is reachable from very few nodes, typically just itself, occasionally from a small group of mutually bidirectional nodes,
		//	so we search for the least reachable nodes taking care to avoid hazards from the source-to-target / target-source asymmetry.
		//
		List<@NonNull Node> navigableNodes = new ArrayList<>();
		for (@NonNull Node node : QVTscheduleUtil.getNodes(this)) {
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
		Collections.sort(headLessNodes, new QVTscheduleUtil.HeadComparator(targetFromSourceClosure));
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
		for (@NonNull Node node : QVTscheduleUtil.getNodes(this)) {
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
		Iterables.addAll(unconditionalNodes, getNewNodes());
		for (@NonNull NavigableEdge edge : getRealizedNavigationEdges()) {
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

	protected void computeUtilities(@NonNull Iterable<@NonNull Node> headNodes) {		// FIXME remove assertions after 1-Jan-2017
		Set<@NonNull Node> stronglyMatchedNodes = computeStronglyMatchedNodes(headNodes);
		Set<@NonNull Node> unconditionalNodes = computeUnconditionalNodes(headNodes);
		Set<@NonNull Node> conditionalNodes = computeConditionalNodes(unconditionalNodes);
		//		Set<@NonNull Node> dependencyNodes = computeDependencyNodes(headNodes);
		Set<@NonNull Node> deadNodes = null;
		//
		for (@NonNull Node node : QVTscheduleUtil.getNodes(this)) {
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

	private boolean isConditionalEdge(@NonNull Edge edge) {
		String edgeName = edge.getName();
		return QVTscheduleConstants.IF_THEN_NAME.equals(edgeName)
				|| QVTscheduleConstants.IF_ELSE_NAME.equals(edgeName)
				|| QVTscheduleConstants.LOOP_BODY_NAME.equals(edgeName);
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
		s.setPenwidth(QVTscheduleConstants.LINE_WIDTH);
		super.toGraph(s);
	}
} //MappingRegionImpl
