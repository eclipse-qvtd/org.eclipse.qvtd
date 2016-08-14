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
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.EdgeRole;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeRole;

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
		//	The ends of all predicated edges not predicated in the Speculation partition are added as is.
		//
		resolvePredicatedEdges();
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
				NavigationEdge navigationEdge = (NavigationEdge) incomingEdge;
				Property middle2outputProperty = navigationEdge.getProperty();
				if (partitioner.isCorrolary(incomingEdge)) {
					assert corrolaryProperty == null;
					Node sourceNode = navigationEdge.getSource();
					while (true) {
						NavigationEdge parentEdge = getParentEdge(sourceNode);
						if (parentEdge == null) {
							break;
						}
						if (parentEdge.getTarget() != sourceNode) {
							parentEdge = parentEdge.getOppositeEdge();
							if (parentEdge == null) {
								return false;
							}
						}
						sourceNode = parentEdge.getSource();
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

	private void gatherSourceNavigations(@NonNull Node targetNode, @NonNull NodeRole targetNodeRole) {
		if (!hasNode(targetNode)) {
			addNode(targetNode, targetNodeRole.resetHead());
			if (!tracedInputNodes.contains(targetNode)) {
				boolean hasPredecessor = false;
				for (@NonNull Node sourceNode : getPredecessors(targetNode)) {
					hasPredecessor = true;
					gatherSourceNavigations(sourceNode, sourceNode.getNodeRole());
				}
				if (!hasPredecessor && targetNode.isPredicated()) {			// Must be the wrong end of a 1:N navigation
					for (@NonNull NavigationEdge edge : targetNode.getNavigationEdges()) {
						if (edge.isPredicated() && (edge.getOppositeEdge() == null)) {
							Node nonUnitSourceNode = edge.getTarget();
							gatherSourceNavigations(nonUnitSourceNode, nonUnitSourceNode.getNodeRole());
						}
					}
				}
			}
		}
	}

	@Override
	protected boolean isComputable(@NonNull Set<@NonNull Node> sourceNodes, @NonNull Edge edge) {
		Node sourceNode = edge.getSource();
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
	protected @Nullable EdgeRole resolveEdgeRole(@NonNull NodeRole sourceNodeRole, @NonNull Edge edge, @NonNull NodeRole targetNodeRole) {
		EdgeRole edgeRole = edge.getEdgeRole();
		if (edgeRole.isRealized() && partitioner.hasRealizedEdge(edge)) {
			if (edge.getTarget().isConstant()) {
				edgeRole = null;		// Constant assignment already done in speculation partition. No need to predicate it with a constant to constant connection.
			}
			else {
				edgeRole = edgeRole.asPredicated();
			}
		}
		return edgeRole;
	}


	@Override
	protected void resolveNavigations(@NonNull Node node) {
		if (!node.isConstant() && !node.isLoaded()) {
			super.resolveNavigations(node);
		}
	}

	protected void resolvePredicatedEdges() {
		for (@NonNull Edge edge : partitioner.getPredicatedEdges()) {
			if (!partitioner.hasPredicatedEdge(edge) && !partitioner.isCorrolary(edge)) {
				Node sourceNode = edge.getSource();
				NodeRole sourceNodeRole = sourceNode.getNodeRole();
				if (!sourceNodeRole.isRealized()) {
					Node targetNode = edge.getTarget();
					NodeRole targetNodeRole = targetNode.getNodeRole();
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

	protected void resolvePredicatedMiddleNodes() {
		for (@NonNull Node node : partitioner.getPredicatedMiddleNodes()) {
			NodeRole nodeRole = node.getNodeRole();
			if (node.isPattern() && node.isClass()) {
				nodeRole = nodeRole.resetHead().asSpeculated();
			}
			gatherSourceNavigations(node, nodeRole);
		}
	}

	protected void resolvePredicatedOutputNodes() {
		for (@NonNull Node node : partitioner.getPredicatedOutputNodes()) {
			if (!isCorrolary(node)) {
				NodeRole nodeRole = node.getNodeRole();
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
				Node sourceNode = edge.getSource();
				NodeRole sourceNodeRole = sourceNode.getNodeRole();
				if (!sourceNodeRole.isRealized()) {
					Node targetNode = edge.getTarget();
					NodeRole targetNodeRole = targetNode.getNodeRole();
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
			NodeRole nodeRole = node.getNodeRole();
			if (node.isPattern() && node.isClass()) {
				nodeRole = nodeRole.asSpeculated().asNavigable().setHead();
			}
			if (!hasNode(node)) {
				addNode(node, nodeRole);
			}
			for (@NonNull NavigationEdge edge : node.getNavigationEdges()) {
				if (partitioner.hasRealizedEdge(edge)) {
					tracedInputNodes.add(edge.getTarget());
				}
			}
		}
	}

	protected void resolveRealizedOutputNodes() {
		for (@NonNull Node node : partitioner.getRealizedOutputNodes()) {
			gatherSourceNavigations(node, node.getNodeRole());
			for (@NonNull NavigationEdge navigationEdge : node.getNavigationEdges()) {
				if (navigationEdge.isRealized()) {
					Node targetNode = navigationEdge.getTarget();
					NodeRole targetNodeRole = targetNode.getNodeRole();
					if (!targetNodeRole.isPredicated() && !targetNodeRole.isRealized()) {
						gatherSourceNavigations(targetNode, targetNodeRole);
					}
				}
			}
		}
	}
}