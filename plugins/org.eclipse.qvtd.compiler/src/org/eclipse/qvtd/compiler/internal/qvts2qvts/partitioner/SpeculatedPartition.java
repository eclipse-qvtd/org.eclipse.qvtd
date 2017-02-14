/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Phase;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * The SpeculatedPartition identifies the nodes and edges required by a speculated micro-mapping
 * which creates the speculation predicates and realized variables.
 */
class SpeculatedPartition extends AbstractPartition
{
	private final @NonNull Set<@NonNull Node> tracedInputNodes = new HashSet<>();

	public SpeculatedPartition(@NonNull Partitioner partitioner) {
		super(partitioner);
		//
		//	The realized middle (trace) nodes become speculated head nodes.
		//
		resolveRealizedMiddleNodes();
		//
		//	The predicated middle nodes become speculated guard nodes and all preceding
		//	navigations are retained as is.
		//
		resolvePredicatedMiddleNodes();
		//
		//	The predicated output nodes and all preceding navigations are retained as is.
		//
		resolvePredicatedOutputNodes();
		//
		//	The realized output nodes are realized as is.
		//
		resolveRealizedOutputNodes();
		//
		//	The ends of all matched predicated edges not already matched in the Speculation partition are added as is.
		//
		resolveMatchedPredicatedEdges();
		//
		//	The non-corrolary, non-realized ends of all realized edges are added as is.
		//
		resolveRealizedEdges();
		//
		//	Perform any required computations.
		//
		resolveComputations();
		//
		//	Perform any outstanding predicates.
		//
		resolvePredicates();
		//
		//	Join up the edges.
		//
		resolveEdgeRoles();
	}

	private boolean isCorrolary(@NonNull Node node) {
		assert node.isPredicated();
		//
		//	Any number of outgoing realized edges can be deferred till the corrolary is available.
		//
		for (@NonNull Edge outgoingEdge : node.getOutgoingEdges()) {
			if (outgoingEdge.isRealized()) {
				// OK to defer
			}
			else if (!outgoingEdge.isSecondary()) {
				return false;
			}
		}
		//
		//	Any number of incoming realized edges can be deferred till the corrolary is available.
		//	An incoming predicated edge must be a known middle-to-output corrolary.
		//	N o paremt edge of an incomingEdge may n=be unidorectional, else a 1:N choice gets lost
		//
		Property corrolaryProperty = null;
		for (@NonNull Edge incomingEdge : node.getIncomingEdges()) {
			if (incomingEdge.isRealized()) {
				// OK to defer
			}
			else if (incomingEdge.isComputation()) {
				// OK to defer
			}
			else if (incomingEdge.isNavigation() && !incomingEdge.isSecondary() && incomingEdge.isPredicated()) {
				NavigableEdge navigationEdge = (NavigableEdge) incomingEdge;
				Property middle2outputProperty = navigationEdge.getProperty();
				if (partitioner.isCorrolary(incomingEdge)) {
					assert corrolaryProperty == null;
					Node sourceNode = navigationEdge.getEdgeSource();
					while (true) {
						NavigableEdge parentEdge = getParentEdge(sourceNode);
						if (parentEdge == null) {
							break;
						}
						if (parentEdge.getEdgeTarget() != sourceNode) {
							parentEdge = parentEdge.getOppositeEdge();
							if (parentEdge == null) {
								return false;
							}
						}
						sourceNode = parentEdge.getEdgeSource();
					}
					corrolaryProperty = middle2outputProperty;
				}
			}
			else {
				assert false;
			}
		}
		if (corrolaryProperty != null) {
			return true;
		}
		return false;
	}

	private void gatherSourceNavigations(@NonNull Node targetNode, @NonNull Role targetNodeRole) {
		if (!hasNode(targetNode)) {
			addNode(targetNode, targetNodeRole);
			if (!tracedInputNodes.contains(targetNode)) {
				boolean hasPredecessor = false;
				for (@NonNull Node sourceNode : getPredecessors(targetNode)) {
					hasPredecessor = true;
					gatherSourceNavigations(sourceNode, RegionUtil.getNodeRole(sourceNode));
				}
				if (!hasPredecessor && targetNode.isPredicated()) {			// Must be the wrong end of a 1:N navigation
					for (@NonNull NavigableEdge edge : targetNode.getNavigationEdges()) {
						if (edge.isPredicated() && (edge.getOppositeEdge() == null)) {
							Node nonUnitSourceNode = edge.getEdgeTarget();
							gatherSourceNavigations(nonUnitSourceNode, RegionUtil.getNodeRole(nonUnitSourceNode));
						}
					}
				}
			}
		}
	}

	@Override
	protected boolean isComputable(@NonNull Set<@NonNull Node> sourceNodes, @NonNull Edge edge) {
		Node sourceNode = edge.getEdgeSource();
		if (tracedInputNodes.contains(sourceNode)) {
			sourceNodes.add(sourceNode);
			return true;
		}
		return super.isComputable(sourceNodes, edge);
	}

	@Override
	protected boolean resolveComputations(@NonNull Node targetNode) {
		if (tracedInputNodes.contains(targetNode)) {
			return true;
		}
		return super.resolveComputations(targetNode);
	}


	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		Role edgeRole = RegionUtil.getEdgeRole(edge);
		if (edgeRole.isRealized() && partitioner.hasRealizedEdge(edge)) {
			if (edge.getEdgeTarget().isConstant()) {
				edgeRole = null;		// Constant assignment already done in speculation partition. No need to predicate it with a constant to constant connection.
			}
			else {
				edgeRole = QVTscheduleConstants.getEdgeRole(Phase.PREDICATED);
			}
		}
		return edgeRole;
	}

	protected void resolveMatchedPredicatedEdges() {
		for (@NonNull Edge edge : partitioner.getPredicatedEdges()) {
			if (edge.isMatched() && !partitioner.hasPredicatedEdge(edge) && !partitioner.isCorrolary(edge)) {
				Node sourceNode = edge.getEdgeSource();
				Role sourceNodeRole = RegionUtil.getNodeRole(sourceNode);
				if (!sourceNodeRole.isRealized()) {
					Node targetNode = edge.getEdgeTarget();
					Role targetNodeRole = RegionUtil.getNodeRole(targetNode);
					if (!targetNodeRole.isRealized()) {
						if (!hasNode(sourceNode)) {
							addNode(sourceNode, sourceNodeRole);
						}
						if (!hasNode(targetNode)) {
							addNode(targetNode, targetNodeRole);
						}
					}
				}
			}
		}
	}

	@Override
	protected void resolveNavigations(@NonNull Node node) {
		if (!node.isConstant() && !node.isLoaded()) {
			super.resolveNavigations(node);
		}
	}

	protected void resolvePredicatedMiddleNodes() {
		for (@NonNull Node node : partitioner.getPredicatedMiddleNodes()) {
			if (node.isMatched()) {
				Role nodeRole = RegionUtil.getNodeRole(node);
				if (node.isPattern() && node.isClass()) {
					nodeRole = QVTscheduleUtil.asSpeculated(nodeRole);
				}
				gatherSourceNavigations(node, QVTscheduleUtil.asSpeculated(nodeRole));
			}
		}
	}

	protected void resolvePredicatedOutputNodes() {
		for (@NonNull Node node : partitioner.getPredicatedOutputNodes()) {
			if (!isCorrolary(node)) {
				Role nodeRole = RegionUtil.getNodeRole(node);
				//			if (node.isPattern() && node.isClass()) {
				//				nodeRole = nodeRole.resetHead().asSpeculated();
				//			}
				gatherSourceNavigations(node, nodeRole);
			}
		}
	}

	protected void resolveRealizedEdges() {
		for (@NonNull Edge edge : partitioner.getRealizedEdges()) {
			if (!partitioner.hasRealizedEdge(edge) && !partitioner.isCorrolary(edge)) {
				Node sourceNode = edge.getEdgeSource();
				Role sourceNodeRole = RegionUtil.getNodeRole(sourceNode);
				if (!sourceNodeRole.isRealized()) {
					Node targetNode = edge.getEdgeTarget();
					Role targetNodeRole = RegionUtil.getNodeRole(targetNode);
					if (!targetNodeRole.isRealized()) {
						if (!hasNode(sourceNode)) {
							addNode(sourceNode, sourceNodeRole);
						}
						if (!hasNode(targetNode)) {
							addNode(targetNode, targetNodeRole);
						}
					}
				}
			}
		}
	}

	protected void resolveRealizedMiddleNodes() {
		for (@NonNull Node node : partitioner.getRealizedMiddleNodes()) {
			if (node.isMatched() && node.isClass()) {
				Role nodeRole = RegionUtil.getNodeRole(node);
				//				assert nodeRole.isMatched();
				assert node.isPattern();//
				nodeRole = QVTscheduleUtil.asSpeculated(nodeRole);
				//				}
				if (!hasNode(node)) {
					addNode(node, nodeRole);
				}
				for (@NonNull NavigableEdge edge : node.getNavigationEdges()) {
					if (partitioner.hasRealizedEdge(edge)) {
						tracedInputNodes.add(edge.getEdgeTarget());
					}
				}
			}
		}
	}

	protected void resolveRealizedOutputNodes() {
		for (@NonNull Node node : partitioner.getRealizedOutputNodes()) {
			gatherSourceNavigations(node, RegionUtil.getNodeRole(node));
			for (@NonNull NavigableEdge navigationEdge : node.getNavigationEdges()) {
				if (navigationEdge.isRealized()) {
					Node targetNode = navigationEdge.getEdgeTarget();
					Role targetNodeRole = RegionUtil.getNodeRole(targetNode);
					if (!targetNodeRole.isPredicated() && !targetNodeRole.isRealized()) {
						gatherSourceNavigations(targetNode, targetNodeRole);
					}
				}
			}
		}
	}
}