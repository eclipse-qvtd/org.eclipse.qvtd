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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.AbstractVisitor;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeRole;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeRole;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.Visitable2;
import org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl;

/**
 * The PartitioningVisitor performs the selective clone of a region, selecting and possibly reclassifying
 * nodes and retaining only edges between the selected nodes.
 */
class PartitioningVisitor extends AbstractVisitor<Visitable2>
{
	public static @NonNull PartitioningVisitor createPartialRegion(@NonNull MappingRegion fullRegion,
			@NonNull String namePrefix, @NonNull String symbolSuffix, @NonNull AbstractPartition partition) {
		MicroMappingRegion partialRegion = new MicroMappingRegionImpl(fullRegion, namePrefix, symbolSuffix);
		PartitioningVisitor partitioningVisitor = new PartitioningVisitor(partialRegion, partition);
		fullRegion.accept(partitioningVisitor);
		return partitioningVisitor;
	}

	protected final @NonNull MicroMappingRegion partialRegion;
	protected final @NonNull AbstractPartition partition;
	private final @NonNull Map<@NonNull Node, @NonNull Node> oldNode2partialNode = new HashMap<>();

	protected PartitioningVisitor(@NonNull MicroMappingRegion partialRegion, @NonNull AbstractPartition partition) {
		this.partialRegion = partialRegion;
		this.partition = partition;
	}

	/*	private void checkEdges(@NonNull Region oldRegion) {
		for (@NonNull Edge oldEdge : oldRegion.getEdges()) {
			assert oldEdge.getRegion() == oldRegion;
			if (!oldEdge.isRecursion() && !oldEdge.isSecondary()) {		// FIXME Remove this irregularity
				List<@NonNull Edge> oldEdges = oldEdge2oldEdges.get(oldEdge);
				assert oldEdges != null;
				assert oldEdges.contains(oldEdge);
				Edge mergedEdge = debugOldEdge2mergedEdge.get(oldEdge);
				assert mergedEdge != null;
				assert mergedEdge.getRegion() == mergedRegion;
			}
		}
	}

	private void checkNodes(@NonNull Region oldRegion) {
		for (@NonNull Node oldNode : oldRegion.getNodes()) {
			assert oldNode.getRegion() == oldRegion;
			Node mergedNode = oldNode2mergedNode.get(oldNode);
			assert mergedNode != null;
			assert mergedNode.getRegion() == mergedRegion;
		}
	} */

	public @NonNull Node getNode(@NonNull Node node) {
		return ClassUtil.nonNullState(oldNode2partialNode.get(node));
	}

	public @NonNull MicroMappingRegion getRegion() {
		return partialRegion;
	}

	@Override
	public @Nullable Edge visitEdge(@NonNull Edge edge) {
		if (edge.isSecondary()) {
			return null;
		}
		Node partialSourceNode = oldNode2partialNode.get(edge.getEdgeSource());
		if (partialSourceNode == null) {
			return null;
		}
		Node partialTargetNode = oldNode2partialNode.get(edge.getEdgeTarget());
		if (partialTargetNode == null) {
			return null;
		}
		EdgeRole edgeRole = partition.getEdgeRole(edge);
		if (edgeRole == null) {
			return null;
		}
		return edge.createEdge(edgeRole, partialSourceNode, partialTargetNode, edge.isPartial());
	}

	@Override
	public @NonNull MappingRegion visitMappingRegion(@NonNull MappingRegion mappingRegion) {
		//
		//	Create the nodes.
		//
		for (@NonNull Node node : mappingRegion.getNodes()) {
			node.accept(this);
		}
		//
		//	Create the edges.
		//
		for (@NonNull Edge edge : mappingRegion.getEdges()) {
			edge.accept(this);
		}
		//
		//		checkNodes(primaryRegion);
		//		checkNodes(secondaryRegion);
		//		checkEdges(primaryRegion);
		//		checkEdges(secondaryRegion);
		return partialRegion;
	}

	@Override
	public @Nullable NavigableEdge visitNavigableEdge(@NonNull NavigableEdge navigableEdge) {
		if (navigableEdge.isSecondary()) {
			return null;
		}
		Node partialSourceNode = oldNode2partialNode.get(navigableEdge.getEdgeSource());
		if (partialSourceNode == null) {
			return null;
		}
		Node partialTargetNode = oldNode2partialNode.get(navigableEdge.getEdgeTarget());
		if (partialTargetNode == null) {
			return null;
		}
		EdgeRole edgeRole = partition.getEdgeRole(navigableEdge);
		if (edgeRole == null) {
			return null;
		}
		return navigableEdge.createEdge(edgeRole, partialSourceNode, partialTargetNode, navigableEdge.isPartial());
	}

	@Override
	public @Nullable Node visitNode(@NonNull Node node) {
		NodeRole nodeRole = partition.getNodeRole(node);
		if (nodeRole == null) {
			return null;
		}
		Node partialNode = null;
		if (node.isOperation()) {
			//
			//	An operation result that is cached in the middle trace by a speculation partition
			//	must be converted to a step node when re-accessed by a speculated partition.
			//
			for (@NonNull Edge edge : node.getIncomingEdges()) {
				if (edge.isNavigation() && edge.isRealized()) {
					EdgeRole edgeRole = partition.getEdgeRole(edge);
					if ((edgeRole != null) && edgeRole.isPredicated()) {
						partialNode = RegionUtil.createStepNode(partialRegion, node, node.isMatched());
						break;
					}
				}
			}
		}
		if (partialNode == null) {
			partialNode = node.createNode(nodeRole, partialRegion);
		}
		oldNode2partialNode.put(node, partialNode);
		partialNode.setUtility(node.getUtility());
		partialNode.setContained(node.isContained());
		for (@NonNull TypedElement typedElement : node.getTypedElements()) {
			partialNode.addTypedElement(typedElement);
		}
		return partialNode;
	}

	@Override
	public @Nullable Node visitVariableNode(@NonNull VariableNode variableNode) {
		NodeRole nodeRole = partition.getNodeRole(variableNode);
		if (nodeRole == null) {
			return null;
		};
		Node partialNode = variableNode.createNode(nodeRole, partialRegion);
		oldNode2partialNode.put(variableNode, partialNode);
		partialNode.setUtility(variableNode.getUtility());
		partialNode.setContained(variableNode.isContained());
		for (@NonNull TypedElement typedElement : variableNode.getTypedElements()) {
			partialNode.addTypedElement(typedElement);
		}
		return partialNode;
	}
}
