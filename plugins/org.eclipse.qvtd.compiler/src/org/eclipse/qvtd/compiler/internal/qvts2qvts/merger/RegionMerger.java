/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import com.google.common.collect.Iterables;

/**
 * RegionMerger provides the ability to merge one or more secondary regions into a primary region to
 * create a new merged region.
 *
 * RegionMerger is used by classes such as EarlyMerger and LateMerger that orchestrate what may be merged safely.
 */
abstract class RegionMerger // implements Region
{
	/**
	 * The primary original region contributing to the merged region.
	 */
	protected final @NonNull MappingRegion primaryRegion;

	/**
	 * Additional secondary region contributing to the merged region.
	 */
	protected final @NonNull List<@NonNull MappingRegion> secondaryRegions = new ArrayList<>();

	/**
	 * Nodes to be merged from a secondary region mapped to a corresponding primary region node.
	 */
	protected final @NonNull Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode = new HashMap<>();

	/**
	 * Mapping from each primary and secondary region node to the corresponding merged node.
	 */
	protected final @NonNull Map<@NonNull Node, @NonNull NodeMerger> oldNode2nodeMerger = new HashMap<>();

	/**
	 * Mapping from each primary and secondary region edge to the corresponding merged edge.
	 */
	private final @NonNull Map<@NonNull Edge, @NonNull EdgeMerger> oldEdge2edgeMerger = new HashMap<>();

	/**
	 * The original edges that are not represented in the result.
	 */
	private /*@LazyNonNull*/ Set<@NonNull Edge> debugPrunedEdges = null;

	protected RegionMerger(@NonNull MappingRegion primaryRegion) {
		this.primaryRegion = primaryRegion;
		//		assert !(primaryRegion instanceof MicroMappingRegion);
		//
		for (@NonNull Node primaryNode : RegionUtil.getOwnedNodes(primaryRegion)) {
			new NodeMerger(this, primaryNode);
		}
		//
		for (@NonNull Edge primaryEdge : RegionUtil.getOwnedEdges(primaryRegion)) {
			if (!primaryEdge.isSecondary()) {
				new EdgeMerger(this, primaryEdge);
			}
		}
	}

	private void addPrunedEdge(@NonNull Edge prunedEdge) {
		Set<@NonNull Edge> debugPrunedEdges2 = debugPrunedEdges;
		if (debugPrunedEdges2 == null) {
			debugPrunedEdges2 = debugPrunedEdges = new HashSet<>();
		}
		boolean wasAdded = debugPrunedEdges2.add(prunedEdge);
		assert wasAdded;
	}

	protected void addSecondaryEdge(@NonNull Edge secondaryEdge) {
		NodeMerger sourceNodeMerger = getNodeMerger(secondaryEdge.getEdgeSource());
		NodeMerger targetNodeMerger = getNodeMerger(secondaryEdge.getEdgeTarget());
		if (sourceNodeMerger != targetNodeMerger) {
			boolean isMerged = false;
			for (@NonNull EdgeMerger edgeMerger : sourceNodeMerger.getOutgoingEdgeMergers(targetNodeMerger)) {
				if (edgeMerger.sameEdge(secondaryEdge) != null) {
					edgeMerger.addOldEdge(secondaryEdge);
					isMerged = true;
					break;
				}
			}
			if (!isMerged) {
				new EdgeMerger(this, secondaryEdge);
			}
		}
		else {
			addPrunedEdge(secondaryEdge);
		}
	}

	public void addSecondaryRegion(@NonNull MappingRegion secondaryRegion, @NonNull Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode) {
		//		assert !(secondaryRegion instanceof MicroMappingRegion);
		assert !secondaryRegions.contains(secondaryRegion);
		secondaryRegions.add(secondaryRegion);
		this.secondaryNode2primaryNode.putAll(secondaryNode2primaryNode);
		//
		for (@NonNull Node secondaryNode : RegionUtil.getOwnedNodes(secondaryRegion)) {
			Node primaryNode = secondaryNode2primaryNode.get(secondaryNode);
			if (primaryNode != null) {
				NodeMerger nodeMerger = oldNode2nodeMerger.get(primaryNode);
				assert nodeMerger != null;
				nodeMerger.addOldNode(secondaryNode);
			}
			else {
				new NodeMerger(this, secondaryNode);
			}
		}
		//
		for (@NonNull Edge secondaryEdge : RegionUtil.getOwnedEdges(secondaryRegion)) {
			if (!secondaryEdge.isSecondary()) {
				addSecondaryEdge(secondaryEdge);
			}
		}
	}

	public void check(@NonNull MappingRegion newRegion) {
		checkNodes(newRegion, primaryRegion);
		for (@NonNull Region secondaryRegion : secondaryRegions) {
			checkNodes(newRegion, secondaryRegion);
		}
		checkEdges(newRegion, primaryRegion);
		for (@NonNull Region secondaryRegion : secondaryRegions) {
			checkEdges(newRegion, secondaryRegion);
		}
	}

	protected void checkEdges(@NonNull MappingRegion newRegion, @NonNull Region oldRegion) {
		for (@NonNull Edge oldEdge : RegionUtil.getOwnedEdges(oldRegion)) {
			assert oldEdge.getOwningRegion() == oldRegion;
			if (!oldEdge.isRecursion() && !oldEdge.isSecondary()) {		// FIXME Remove this irregularity
				EdgeMerger edgeMerger = oldEdge2edgeMerger.get(oldEdge);
				if (edgeMerger != null) {
					assert Iterables.contains(edgeMerger.getOldEdges(), oldEdge);
					assert edgeMerger.getNewEdge().getOwningRegion() == newRegion;
				}
				else {
					assert debugPrunedEdges.contains(oldEdge);
				}
			}
		}
	}

	protected void checkNodes(@NonNull MappingRegion newRegion, @NonNull Region oldRegion) {
		for (@NonNull Node oldNode : RegionUtil.getOwnedNodes(oldRegion)) {
			assert oldNode.getOwningRegion() == oldRegion;
			Node nodeMerger = getNodeMerger(oldNode).getNewNode();
			assert nodeMerger.getOwningRegion() == newRegion;
		}
	}

	public @NonNull MappingRegion create() {
		@NonNull String newName = createNewName();
		MappingRegion newRegion = createNewRegion(newName);
		createNewNodes(newRegion);
		createNewEdges();
		//		RegionHelper.initHeadNodes(newRegion);
		return newRegion;
	}

	protected @NonNull String createNewName() {
		List<@NonNull String> names = new ArrayList<>();
		names.add(primaryRegion.getName().replace("»\\n", "» "));
		for (@NonNull MappingRegion secondaryRegion : secondaryRegions) {
			names.add(secondaryRegion.getName().replace("»\\n", "» "));
		}
		Collections.sort(names);
		StringBuilder s = new StringBuilder();
		for (@NonNull String name : names) {
			if (s.length() > 0) {
				s.append("\\n");
			}
			s.append(name);
		}
		return s.toString();
	}

	protected void createNewEdges() {
		for (@NonNull EdgeMerger edgeMerger : new HashSet<>(oldEdge2edgeMerger.values())) {
			Node sourceNodeMerger = getNodeMerger(edgeMerger.getOldSource()).getNewNode();
			Node targetNodeMerger = getNodeMerger(edgeMerger.getOldTarget()).getNewNode();
			edgeMerger.createNewEdge(sourceNodeMerger, targetNodeMerger);
		}
	}

	protected void createNewNodes(@NonNull MappingRegion newRegion) {
		for (@NonNull NodeMerger nodeMerger : new HashSet<>(oldNode2nodeMerger.values())) {
			nodeMerger.createNewNode(newRegion);
		}
	}

	protected abstract @NonNull MappingRegion createNewRegion(@NonNull String newName);

	protected @NonNull EdgeMerger getEdgeMerger(@NonNull Edge oldEdge) {
		return ClassUtil.nonNullState(oldEdge2edgeMerger.get(oldEdge));
	}

	protected @NonNull NodeMerger getNodeMerger(@NonNull Node oldNode) {
		return ClassUtil.nonNullState(oldNode2nodeMerger.get(oldNode));
	}

	protected @NonNull List<@NonNull MappingRegion> getSecondaryRegions() {
		return secondaryRegions;
	}

	protected void mapOldEdge(@NonNull Edge oldEdge, @NonNull EdgeMerger edgeMerger) {
		EdgeMerger oldMergedEdge = oldEdge2edgeMerger.put(oldEdge, edgeMerger);
		assert oldMergedEdge == null;
	}

	protected void mapOldNode(@NonNull Node oldNode, @NonNull NodeMerger nodeMerger) {
		NodeMerger oldMergedNode = oldNode2nodeMerger.put(oldNode, nodeMerger);
		assert oldMergedNode == null;
	}

	/**
	 * Prune nodes (and edges) that are not needed.
	 *
	 * Nodes that can be folded into other nodes, e.g. the input of a cast can be folded into its output, are pruned.
	 */
	public void prune() {
		List<@NonNull EdgeMerger> foldableEdgeMergers = new ArrayList<>();
		for (@NonNull NodeMerger nodeMerger : new HashSet<>(oldNode2nodeMerger.values())) {
			nodeMerger.gatherFoldableEdges(foldableEdgeMergers);
		}
		for (@NonNull EdgeMerger foldableEdgeMerger : foldableEdgeMergers) {
			NodeMerger sourceNodeMerger = foldableEdgeMerger.getSource();
			NodeMerger targetNodeMerger = foldableEdgeMerger.getTarget();
			sourceNodeMerger.destroy();
			for (@NonNull Node oldNode : sourceNodeMerger.getOldNodes()) {
				targetNodeMerger.addOldNode(oldNode);
				for (@NonNull Edge oldEdge : RegionUtil.getIncomingEdges(oldNode)) {
					addSecondaryEdge(oldEdge);
				}
				for (@NonNull Edge oldEdge : RegionUtil.getOutgoingEdges(oldNode)) {
					addSecondaryEdge(oldEdge);
				}
			}
		}
	}

	@Override
	public String toString() {
		return createNewName();
	}

	protected void unmapOldEdge(@NonNull Edge oldEdge, @NonNull EdgeMerger edgeMerger) {
		EdgeMerger oldEdgeMerger = oldEdge2edgeMerger.remove(oldEdge);
		assert oldEdgeMerger == edgeMerger;
	}

	protected void unmapOldNode(@NonNull Node oldNode, @NonNull NodeMerger nodeMerger) {
		NodeMerger oldNodeMerger = oldNode2nodeMerger.remove(oldNode);
		assert oldNodeMerger == nodeMerger;
	}
}
