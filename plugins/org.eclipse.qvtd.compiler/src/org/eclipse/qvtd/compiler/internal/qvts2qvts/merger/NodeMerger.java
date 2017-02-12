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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.merger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MappingRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.NodeRole;

/**
 * A NodeMerger gathers the contributions for a node in a merged region and supports
 * optimization of the to be created merged region.
 */
class NodeMerger
{
	protected final @NonNull RegionMerger regionMerger;
	protected final @NonNull List<@NonNull Node> oldNodes = new ArrayList<>();
	private @NonNull NodeRole nodeRole;
	private Node.@NonNull Utility nodeUtility;
	private @NonNull Map<@NonNull NodeMerger, @NonNull List<@NonNull EdgeMerger>> sourceNodeMerger2edgeMergers = new HashMap<>();
	private @NonNull Map<@NonNull NodeMerger, @NonNull List<@NonNull EdgeMerger>> targetNodeMerger2edgeMergers = new HashMap<>();
	private @Nullable Node newNode = null;

	public NodeMerger(@NonNull RegionMerger regionMerger, @NonNull Node oldNode) {
		this.regionMerger = regionMerger;
		oldNodes.add(oldNode);
		nodeRole = oldNode.getNodeRole();
		nodeUtility = oldNode.getUtility();
		regionMerger.mapOldNode(oldNode, this);
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

	public void addOldNode(@NonNull Node oldNode) {
		assert !oldNodes.contains(oldNode);
		oldNodes.add(oldNode);
		nodeRole = RegionUtil.mergeToMoreKnownPhase(nodeRole, oldNode.getNodeRole());
		nodeUtility = RegionUtil.mergeToStrongerUtility(nodeUtility, oldNode.getUtility());
		regionMerger.mapOldNode(oldNode, this);
	}

	public @Nullable Node createNewNode(@NonNull MappingRegion newRegion) {
		Node newNode2 = newNode;
		assert newNode2 == null;
		for (@NonNull Node oldNode : oldNodes) {
			newNode2 = newNode = oldNode.createNode(nodeRole, newRegion);
			newNode2.setUtility(nodeUtility);
			break;
		}
		if (newNode2 == null) {
			return null;
		}
		for (@NonNull Node oldNode : oldNodes) {
			//				oldNode2mergedNode.put(oldNode, mergedNode);
			for (@NonNull TypedElement typedElement : oldNode.getTypedElements()) {
				newNode2.addTypedElement(typedElement);
			}
		}
		return newNode2;
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
		for (@NonNull Node oldNode : oldNodes) {
			regionMerger.unmapOldNode(oldNode, this);
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

	public @NonNull List<@NonNull EdgeMerger> getIncomingEdgeMergers(@NonNull NodeMerger sourceNodeMerger) {
		List<@NonNull EdgeMerger> edgeMergers = sourceNodeMerger2edgeMergers.get(sourceNodeMerger);
		if (edgeMergers == null) {
			edgeMergers = new ArrayList<>();
			sourceNodeMerger2edgeMergers.put(sourceNodeMerger, edgeMergers);
		}
		return edgeMergers;
	}

	public @NonNull Node getNewNode() {
		return ClassUtil.nonNullState(newNode);
	}

	public @NonNull Iterable<@NonNull Node> getOldNodes() {
		return oldNodes;
	}

	public @NonNull List<@NonNull EdgeMerger> getOutgoingEdgeMergers(@NonNull NodeMerger targetNodeMerger) {
		List<@NonNull EdgeMerger> edgeMergers = targetNodeMerger2edgeMergers.get(targetNodeMerger);
		if (edgeMergers == null) {
			edgeMergers = new ArrayList<>();
			targetNodeMerger2edgeMergers.put(targetNodeMerger, edgeMergers);
		}
		return edgeMergers;
	}

	public boolean isNew() {
		return nodeRole.isNew();
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
		return newNode != null? newNode.toString() : oldNodes.get(0).toString();
	}
}