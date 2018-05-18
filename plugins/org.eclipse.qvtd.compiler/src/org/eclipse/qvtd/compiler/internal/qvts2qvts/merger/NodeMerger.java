/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.merger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * A NodeMerger gathers the contributions for a node in a merged region and supports
 * optimization of the to be created merged region.
 */
class NodeMerger
{
	protected final @NonNull RegionMerger regionMerger;
	protected final @NonNull List<@NonNull Node> originalNodes = new ArrayList<>();
	private @NonNull Role nodeRole;
	private Node.@NonNull Utility nodeUtility;
	private @NonNull Map<@NonNull NodeMerger, @NonNull List<@NonNull EdgeMerger>> sourceNodeMerger2edgeMergers = new HashMap<>();
	private @NonNull Map<@NonNull NodeMerger, @NonNull List<@NonNull EdgeMerger>> targetNodeMerger2edgeMergers = new HashMap<>();
	private @Nullable Node mergedNode = null;

	public NodeMerger(@NonNull RegionMerger regionMerger, @NonNull Node originalNode) {
		this.regionMerger = regionMerger;
		originalNodes.add(originalNode);
		nodeRole = QVTscheduleUtil.getNodeRole(originalNode);
		nodeUtility = originalNode.getUtility();
		regionMerger.mapOriginalNode(originalNode, this);
	}

	public void addIncomingEdgeMerger(@NonNull EdgeMerger edgeMerger, @NonNull NodeMerger sourceNodeMerger) {
		List<@NonNull EdgeMerger> edgeMergers = getIncomingEdgeMergers(sourceNodeMerger);
		assert !edgeMergers.contains(edgeMerger);
		edgeMergers.add(edgeMerger);
	}

	public void addOutgoingEdgeMerger(@NonNull EdgeMerger edgeMerger, @NonNull NodeMerger targetNodeMerger) {
		List<@NonNull EdgeMerger> edgeMergers = getOutgoingEdgeMergers(targetNodeMerger);
		assert !edgeMergers.contains(edgeMerger);
		edgeMergers.add(edgeMerger);
	}

	public void addOriginalNode(@NonNull Node originalNode) {
		assert !originalNodes.contains(originalNode);
		originalNodes.add(originalNode);
		nodeRole = QVTscheduleUtil.mergeToMoreKnownPhase(nodeRole, QVTscheduleUtil.getNodeRole(originalNode));
		nodeUtility = QVTscheduleUtil.mergeToStrongerUtility(nodeUtility, originalNode.getUtility());
		regionMerger.mapOriginalNode(originalNode, this);
	}

	public @Nullable Node createMergedNode(@NonNull MappingRegion mergedRegion) {
		Node mergedNode2 = mergedNode;
		assert mergedNode2 == null;
		for (@NonNull Node originalNode : originalNodes) {
			mergedNode2 = mergedNode = originalNode.createNode(nodeRole, mergedRegion);
			if (originalNode.isHead()) {
				mergedNode2.setHead();
				mergedRegion.getHeadNodes().add(mergedNode2);
			}
			mergedNode2.setUtility(nodeUtility);
			break;
		}
		if (mergedNode2 == null) {
			return null;
		}
		//		for (@NonNull Node originalNode : originalNodes) {
		//			//				originalNode2mergedNode.put(originalNode, mergedNode);
		//			for (@NonNull TypedElement typedElement : originalNode.getTypedElements()) {
		//				mergedNode2.addTypedElement(typedElement);
		//			}
		//		}
		return mergedNode2;
	}

	public void destroy() {
		for (@NonNull List<@NonNull EdgeMerger> incomingEdgeMergers : sourceNodeMerger2edgeMergers.values()) {
			for (int i = incomingEdgeMergers.size(); --i >= 0; ) {		// Down count to avoid CME
				incomingEdgeMergers.get(i).destroy();
			}
		}
		for (@NonNull List<@NonNull EdgeMerger> outgoingEdgeMergers : targetNodeMerger2edgeMergers.values()) {
			for (int i = outgoingEdgeMergers.size(); --i >= 0; ) {		// Down count to avoid CME
				outgoingEdgeMergers.get(i).destroy();
			}
		}
		for (@NonNull Node originalNode : originalNodes) {
			regionMerger.unmapOriginalNode(originalNode, this);
		}
	}

	public void gatherFoldableEdges(@NonNull List<@NonNull EdgeMerger> foldableEdgeMergers) {
		for (@NonNull List<@NonNull EdgeMerger> outgoingEdgeMergers : targetNodeMerger2edgeMergers.values()) {
			for (@NonNull EdgeMerger edgeMerger : outgoingEdgeMergers) {
				if (edgeMerger.isFoldable()) {
					foldableEdgeMergers.add(edgeMerger);
				}
			}
		}
	}

	public @NonNull Iterable<@NonNull Edge> getArgumentEdges() {
		return getPrimaryNode().getArgumentEdges();		// FIXME check all original nodes
	}

	public @NonNull List<@NonNull EdgeMerger> getIncomingEdgeMergers(@NonNull NodeMerger sourceNodeMerger) {
		List<@NonNull EdgeMerger> edgeMergers = sourceNodeMerger2edgeMergers.get(sourceNodeMerger);
		if (edgeMergers == null) {
			edgeMergers = new ArrayList<>();
			sourceNodeMerger2edgeMergers.put(sourceNodeMerger, edgeMergers);
		}
		return edgeMergers;
	}

	public @NonNull Node getMergedNode() {
		return ClassUtil.nonNullState(mergedNode);
	}

	public @NonNull String getName() {
		return QVTscheduleUtil.getName(getPrimaryNode());
	}

	public @Nullable NavigableEdge getNavigableEdge(@NonNull Property property) {
		return getPrimaryNode().getNavigableEdge(property);		// FIXME check all original nodes
	}

	public @Nullable Node getNavigableTarget(@NonNull Property property) {
		return getPrimaryNode().getNavigableTarget(property);		// FIXME check all original nodes
	}

	public @NonNull Role getNodeRole() {
		return QVTscheduleUtil.getNodeRole(getPrimaryNode());
	}

	public @NonNull Iterable<@NonNull Node> getOriginalNodes() {
		return originalNodes;
	}

	public @NonNull List<@NonNull EdgeMerger> getOutgoingEdgeMergers(@NonNull NodeMerger targetNodeMerger) {
		List<@NonNull EdgeMerger> edgeMergers = targetNodeMerger2edgeMergers.get(targetNodeMerger);
		if (edgeMergers == null) {
			edgeMergers = new ArrayList<>();
			targetNodeMerger2edgeMergers.put(targetNodeMerger, edgeMergers);
		}
		return edgeMergers;
	}

	private @NonNull Node getPrimaryNode() {
		return originalNodes.get(0);
	}

	public boolean isConstant() {
		return getPrimaryNode().isConstant();		// FIXME check all original nodes
	}

	public boolean isIterator() {
		return getPrimaryNode().isIterator();		// FIXME check all original nodes
	}

	public boolean isLoaded() {
		return getPrimaryNode().isLoaded();		// FIXME check all original nodes
	}

	public boolean isNew() {
		return nodeRole.isNew();
	}

	public boolean isNullLiteral() {
		return getPrimaryNode().isNullLiteral();		// FIXME check all original nodes
	}

	public boolean isOld() {
		return getPrimaryNode().isOld();		// FIXME check all original nodes
	}

	public boolean isRequired() {
		return getPrimaryNode().isRequired();		// FIXME check all original nodes
	}

	public boolean isUnconditional() {
		return getPrimaryNode().isUnconditional();		// FIXME check all original nodes
	}

	public void removeIncomingEdgeMerger(@NonNull EdgeMerger edgeMerger, @NonNull NodeMerger sourceNodeMerger) {
		List<@NonNull EdgeMerger> edgeMergers = getIncomingEdgeMergers(sourceNodeMerger);
		boolean wasRemoved = edgeMergers.remove(edgeMerger);
		assert wasRemoved;
	}

	public void removeOutgoingEdgeMerger(@NonNull EdgeMerger edgeMerger, @NonNull NodeMerger targetNodeMerger) {
		List<@NonNull EdgeMerger> edgeMergers = getOutgoingEdgeMergers(targetNodeMerger);
		boolean wasRemoved = edgeMergers.remove(edgeMerger);
		assert wasRemoved;
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(mergedNode != null? mergedNode : originalNodes.get(0));
	}
}