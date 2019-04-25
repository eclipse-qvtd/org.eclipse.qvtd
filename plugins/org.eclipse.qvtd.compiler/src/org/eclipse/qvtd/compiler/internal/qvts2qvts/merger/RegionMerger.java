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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import com.google.common.collect.Iterables;

/**
 * RegionMerger provides the ability to merge one or more secondary regions into a primary region to
 * create a new merged region.
 *
 * RegionMerger is used by classes such as EarlyMerger and LateMerger that orchestrate what may be merged safely.
 */
abstract class RegionMerger // implements Region
{
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The original regions contributing to the merged region.
	 */
	private final @NonNull List<@NonNull MappingRegion> originalRegions = new ArrayList<>();

	/**
	 * Mapping from each original region node to the corresponding merged node.
	 */
	protected final @NonNull Map<@NonNull Node, @NonNull NodeMerger> originalNode2nodeMerger = new HashMap<>();

	/**
	 * Mapping from each original region edge to the corresponding merged edge.
	 */
	private final @NonNull Map<@NonNull Edge, @NonNull EdgeMerger> originalEdge2edgeMerger = new HashMap<>();

	private final @NonNull Map<@NonNull ClassDatum, @NonNull List<@NonNull NodeMerger>> classDatum2nodeMergers =  new HashMap<>();

	/**
	 * The original edges that are not represented in the result.
	 */
	private /*@LazyNonNull*/ Set<@NonNull Edge> debugPrunedEdges = null;

	protected RegionMerger(@NonNull ScheduleManager scheduleManager, @NonNull MappingRegion primaryRegion) {
		this.scheduleManager = scheduleManager;
		originalRegions.add(primaryRegion);
		//		assert !(primaryRegion instanceof MicroMappingRegion);
		//
		for (@NonNull Node primaryNode : QVTscheduleUtil.getOwnedNodes(primaryRegion)) {
			new NodeMerger(this, primaryNode);
		}
		//
		for (@NonNull Edge primaryEdge : QVTscheduleUtil.getOwnedEdges(primaryRegion)) {
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
					edgeMerger.addOriginalEdge(secondaryEdge);
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

	public void addSecondaryRegion(@NonNull MappingRegion secondaryRegion, @NonNull Correlator correlator) {
		assert correlator.getRegionMerger() == this;
		Map<@NonNull Node, @NonNull NodeMerger> node2nodeMerger = correlator.getNode2NodeMerger();
		//		Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode = correlator.getNode2Node();
		//		Map<@NonNull Node, @NonNull NodeMerger> node2nodeMerger = getExtraNode2NodeMerger(secondaryNode2primaryNode);
		//		assert !(secondaryRegion instanceof MicroMappingRegion);
		assert !originalRegions.contains(secondaryRegion);
		originalRegions.add(secondaryRegion);
		//
		for (@NonNull Node secondaryNode : QVTscheduleUtil.getOwnedNodes(secondaryRegion)) {
			NodeMerger nodeMerger = node2nodeMerger.get(secondaryNode);
			if (nodeMerger != null) {
				nodeMerger.addOriginalNode(secondaryNode);
			}
			else {
				new NodeMerger(this, secondaryNode);
			}
		}
		//
		for (@NonNull Edge secondaryEdge : QVTscheduleUtil.getOwnedEdges(secondaryRegion)) {
			if (!secondaryEdge.isSecondary()) {
				addSecondaryEdge(secondaryEdge);
			}
		}
	}

	public void check(@NonNull MappingRegion mergedRegion) {
		for (@NonNull Region originalRegion : originalRegions) {
			checkNodes(mergedRegion, originalRegion);
		}
		for (@NonNull Region originalRegion : originalRegions) {
			checkEdges(mergedRegion, originalRegion);
		}
	}

	protected void checkEdges(@NonNull MappingRegion mergedRegion, @NonNull Region originalRegion) {
		for (@NonNull Edge originalEdge : QVTscheduleUtil.getOwnedEdges(originalRegion)) {
			assert originalEdge.getOwningRegion() == originalRegion;
			if (!originalEdge.isRecursion() && !originalEdge.isSecondary()) {		// FIXME Remove this irregularity
				EdgeMerger edgeMerger = originalEdge2edgeMerger.get(originalEdge);
				if (edgeMerger != null) {
					assert Iterables.contains(edgeMerger.getOriginalEdges(), originalEdge);
					assert edgeMerger.getMergedEdge().getOwningRegion() == mergedRegion;
				}
				else {
					assert debugPrunedEdges.contains(originalEdge);
				}
			}
		}
	}

	protected void checkNodes(@NonNull MappingRegion mergedRegion, @NonNull Region originalRegion) {
		for (@NonNull Node originalNode : QVTscheduleUtil.getOwnedNodes(originalRegion)) {
			assert originalNode.getOwningRegion() == originalRegion;
			Node nodeMerger = getNodeMerger(originalNode).getMergedNode();
			assert nodeMerger.getOwningRegion() == mergedRegion;
		}
	}

	public @NonNull MappingRegion create() {
		@NonNull String mergedName = createMergedName();
		MappingRegion mergedRegion = createMergedRegion(mergedName);
		createMergedNodes(mergedRegion);
		createMergedEdges();
		//		MappingRegionAnalysis.initHeadNodes(mergedRegion);
		return mergedRegion;
	}

	protected @NonNull String createMergedName() {
		List<@NonNull String> names = new ArrayList<>();
		for (@NonNull MappingRegion originalRegion : originalRegions) {
			names.add(originalRegion.getName().replace("»\\n", "» "));
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

	protected void createMergedEdges() {
		for (@NonNull EdgeMerger edgeMerger : new HashSet<>(originalEdge2edgeMerger.values())) {
			Node sourceNodeMerger = getNodeMerger(edgeMerger.getOriginalSource()).getMergedNode();
			Node targetNodeMerger = getNodeMerger(edgeMerger.getOriginalTarget()).getMergedNode();
			edgeMerger.createMergedEdge(sourceNodeMerger, targetNodeMerger);
		}
	}

	protected void createMergedNodes(@NonNull MappingRegion mergedRegion) {
		for (@NonNull NodeMerger nodeMerger : new HashSet<>(originalNode2nodeMerger.values())) {
			nodeMerger.createMergedNode(mergedRegion);
		}
	}

	protected abstract @NonNull MappingRegion createMergedRegion(@NonNull String mergedName);

	protected @Nullable EdgeMerger getEdgeMerger(@NonNull Edge originalEdge) {
		return originalEdge2edgeMerger.get(originalEdge);
	}

	protected @NonNull NodeMerger getNodeMerger(@NonNull Node originalNode) {
		return ClassUtil.nonNullState(originalNode2nodeMerger.get(originalNode));
	}

	public @NonNull Map<@NonNull Node, @NonNull NodeMerger> getExtraNode2NodeMerger(@NonNull Map<@NonNull Node, @NonNull Node> extraNode2existingNode) {
		Map<@NonNull Node, @NonNull NodeMerger> node2nodeMerger = new HashMap<>();
		//		for (@NonNull Node node : extraNode2node.keySet()) {
		//			NodeMerger nodeMerger = originalNode2nodeMerger.get(node);
		//			//			assert nodeMerger != null;
		//			if (nodeMerger != null) {
		//				node2nodeMerger.put(node, nodeMerger);
		//			}
		//		}
		for (@NonNull Node extraNode : extraNode2existingNode.keySet()) {
			Node existingNode = extraNode2existingNode.get(extraNode);
			assert existingNode != null;
			NodeMerger nodeMerger = originalNode2nodeMerger.get(existingNode);
			assert nodeMerger != null;
			NodeMerger oldNodeMerger = node2nodeMerger.put(extraNode, nodeMerger);
			assert (oldNodeMerger == null) || (oldNodeMerger == nodeMerger);
		}
		return node2nodeMerger;
	}

	public @Nullable List<@NonNull NodeMerger> getNodeMergers(@NonNull ClassDatum classDatum) {
		return classDatum2nodeMergers.get(classDatum);
	}

	protected @NonNull List<@NonNull MappingRegion> getOriginalRegions() {
		return originalRegions;
	}

	public @NonNull MappingRegion getPrimaryRegion() {
		return originalRegions.get(0);
	}

	public boolean isAbstract() {
		MappingRegion primaryRegion = getPrimaryRegion();
		if (primaryRegion instanceof RuleRegion) {
			if (((RuleRegion)primaryRegion).getReferredRule().isIsAbstract()) {
				return true;
			}
		}
		return false;
	}

	protected void mapOriginalEdge(@NonNull Edge originalEdge, @NonNull EdgeMerger edgeMerger) {
		EdgeMerger originalMergedEdge = originalEdge2edgeMerger.put(originalEdge, edgeMerger);
		assert originalMergedEdge == null;
	}

	protected void mapOriginalNode(@NonNull Node originalNode, @NonNull NodeMerger nodeMerger) {
		NodeMerger originalMergedNode = originalNode2nodeMerger.put(originalNode, nodeMerger);
		assert originalMergedNode == null;
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(originalNode);
		List<@NonNull NodeMerger> nodeMergers = classDatum2nodeMergers.get(classDatum);
		if (nodeMergers == null) {
			nodeMergers = new ArrayList<>();
			classDatum2nodeMergers.put(classDatum, nodeMergers);
		}
		if (!nodeMergers.contains(nodeMerger)) {
			nodeMergers.add(nodeMerger);
		}
	}

	/**
	 * Prune nodes (and edges) that are not needed.
	 *
	 * Nodes that can be folded into other nodes, e.g. the input of a cast can be folded into its output, are pruned.
	 */
	public void prune() {
		List<@NonNull EdgeMerger> foldableEdgeMergers = new ArrayList<>();
		for (@NonNull NodeMerger nodeMerger : new HashSet<>(originalNode2nodeMerger.values())) {
			nodeMerger.gatherFoldableEdges(foldableEdgeMergers);
		}
		for (@NonNull EdgeMerger foldableEdgeMerger : foldableEdgeMergers) {
			NodeMerger sourceNodeMerger = foldableEdgeMerger.getSource();
			NodeMerger targetNodeMerger = foldableEdgeMerger.getTarget();
			sourceNodeMerger.destroy();
			for (@NonNull Node originalNode : sourceNodeMerger.getOriginalNodes()) {
				targetNodeMerger.addOriginalNode(originalNode);
				for (@NonNull Edge originalEdge : QVTscheduleUtil.getIncomingEdges(originalNode)) {
					addSecondaryEdge(originalEdge);
				}
				for (@NonNull Edge originalEdge : QVTscheduleUtil.getOutgoingEdges(originalNode)) {
					addSecondaryEdge(originalEdge);
				}
			}
		}
	}

	@Override
	public String toString() {
		return createMergedName();
	}

	protected void unmapOriginalEdge(@NonNull Edge originalEdge, @NonNull EdgeMerger edgeMerger) {
		EdgeMerger originalEdgeMerger = originalEdge2edgeMerger.remove(originalEdge);
		assert originalEdgeMerger == edgeMerger;
	}

	protected void unmapOriginalNode(@NonNull Node originalNode, @NonNull NodeMerger nodeMerger) {
		NodeMerger originalNodeMerger = originalNode2nodeMerger.remove(originalNode);
		assert originalNodeMerger == nodeMerger;
	}
}
