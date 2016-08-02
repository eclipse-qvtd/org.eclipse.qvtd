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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeRole;

/**
 * The SpeculatedPartition identifies the nodes and edges required by a speculated micro-mapping
 * which creates the speculation predicates and realized variables.
 */
class SpeculatedPartition extends AbstractPartition
{
	public SpeculatedPartition(@NonNull Partitioner partitioner) {
		super(partitioner);
		//	Iterable<@NonNull Edge> predicatedEdges = partitioner.getPredicatedEdges();
		Iterable<@NonNull Node> predicatedMiddleNodes = partitioner.getPredicatedMiddleNodes();
		Iterable<@NonNull Node> predicatedOutputNodes = partitioner.getPredicatedOutputNodes();
		Iterable<@NonNull Node> realizedMiddleNodes = partitioner.getRealizedMiddleNodes();
		Iterable<@NonNull Node> realizedOutputNodes = partitioner.getRealizedOutputNodes();
		//
		//	The realized middle (trace) nodes become speculated head nodes.
		//
		for (@NonNull Node node : realizedMiddleNodes) {
			NodeRole nodeRole = node.getNodeRole();
			if (node.isPattern() && node.isClass()) {
				nodeRole = nodeRole.asSpeculated().setHead();
			}
			addNode(node, nodeRole);
		}
		//
		//	The predicated middle nodes become speculated guard nodes and all preceding
		//	navigations are retained as is.
		//
		for (@NonNull Node node : predicatedMiddleNodes) {
			NodeRole nodeRole = node.getNodeRole();
			if (node.isPattern() && node.isClass()) {
				nodeRole = nodeRole.resetHead().asSpeculated();
			}
			gatherSourceNavigations(node, nodeRole);
		}
		//
		//	The predicated output nodes and all preceding navigations are retained as is.
		//
		for (@NonNull Node node : predicatedOutputNodes) {
			NodeRole nodeRole = node.getNodeRole();
			//			if (node.isPattern() && node.isClass()) {
			//				nodeRole = nodeRole.resetHead().asSpeculated();
			//			}
			gatherSourceNavigations(node, nodeRole);
		}
		//
		//	The realized output nodes are realized as is.
		//
		for (@NonNull Node node : realizedOutputNodes) {
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
		//
		//	The ends of all predicated edges not predicated in the Speculation partition are added as is.
		//
		/*		for (@NonNull Edge edge : predicatedEdges) {
			Node sourceNode = edge.getSource();
			Node targetNode = edge.getTarget();
			NodeRole sourceNodeRole = sourceNode.getNodeRole();
			NodeRole targetNodeRole = targetNode.getNodeRole();
			if (!sourceNodeRole.isLoaded() || !targetNodeRole.isLoaded()) {
				if (!hasNode(sourceNode)) {
					addNode(sourceNode, sourceNodeRole);
				}
				if (!hasNode(targetNode)) {
					addNode(targetNode, targetNodeRole);
				}
			}
		} */
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

	private void gatherSourceNavigations(@NonNull Node targetNode, @NonNull NodeRole targetNodeRole) {
		if (!hasNode(targetNode)) {
			addNode(targetNode, targetNodeRole.resetHead());
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