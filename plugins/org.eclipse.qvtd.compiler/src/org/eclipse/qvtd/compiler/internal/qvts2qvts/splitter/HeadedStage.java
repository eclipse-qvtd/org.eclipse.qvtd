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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.splitter;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A Stage specifies part of a multi-headed region split. It has a headNode to represent its primary content
 * and an edge that defines the entry to the stage, null fir the first stage.
 */
abstract class HeadedStage extends AbstractStage
{
	protected final @Nullable HeadedStage sourceStage;
	protected final @Nullable Edge edge;
	protected final @NonNull SimpleGroup targetSimpleGroup;

	protected final @NonNull Iterable<@NonNull Node> headNodes;
	protected final @NonNull List<@NonNull Node> navigableNodes;
	protected final @NonNull List<@NonNull Node> computableNodes;
	protected final @NonNull Iterable<@NonNull Node> deadNodes;

	/**
	 * Transitive closure of all successors.
	 */
	protected final @NonNull Set<@NonNull Stage> successors = new HashSet<>();

	protected HeadedStage(@NonNull SplitterAnalysis splitter, @Nullable HeadedStage sourceStage, @Nullable Edge edge, @NonNull SimpleGroup targetSimpleGroup) {
		super(splitter);
		this.sourceStage = sourceStage;
		this.edge = edge;
		this.targetSimpleGroup = targetSimpleGroup;
		this.headNodes = targetSimpleGroup.getHeadNodes();
		Iterable<@NonNull Node> allNavigableNodes = targetSimpleGroup.getReachableNodes();
		Set<@NonNull Node> allComputableNodes = SplitterUtil.computeComputableTargetNodes(allNavigableNodes);
		Set<@NonNull Node> allNodes = Sets.newHashSet(allNavigableNodes);
		allNodes.addAll(allComputableNodes);
		this.deadNodes = computeDeadNodes(allNodes);
		this.navigableNodes = Lists.newArrayList(allNavigableNodes);
		this.computableNodes = Lists.newArrayList(allComputableNodes);
		int oldSize = this.computableNodes.size();
		this.computableNodes.removeAll(navigableNodes);
		int newSize = this.computableNodes.size();
		assert oldSize-newSize == navigableNodes.size();
		CompilerUtil.removeAll(navigableNodes, headNodes);
		CompilerUtil.removeAll(navigableNodes, deadNodes);
		CompilerUtil.removeAll(computableNodes, deadNodes);
		Collections.sort(navigableNodes, NameUtil.NAMEABLE_COMPARATOR);
		Collections.sort(computableNodes, NameUtil.NAMEABLE_COMPARATOR);
	}

	public void addSuccessor(@NonNull HeadedStage successorStage) {
		if (successors.add(successorStage)) {
			if (sourceStage != null) {
				sourceStage.addSuccessor(successorStage);
			}
		}
	}

	@Override
	protected @NonNull String buildContents(@NonNull StringBuilder s) {
		build(s, "head nodes", headNodes);
		build(s, "navigable nodes", navigableNodes);
		build(s, "computable nodes", computableNodes);
		build(s, "dead nodes", deadNodes);
		return targetSimpleGroup.getName();
	}

	@Override
	public void check() {
		Set<@NonNull Node> accumulator = new HashSet<>();
		checkAccumulate(accumulator, headNodes);
		checkAccumulate(accumulator, navigableNodes);
		checkAccumulate(accumulator, computableNodes);
		checkAccumulate(accumulator, deadNodes);
		Set<@NonNull Node> navigableNodes = SplitterUtil.computeNavigableNodes(headNodes);
		Set<@NonNull Node> computableNodes = SplitterUtil.computeComputableTargetNodes(navigableNodes);
		assert computableNodes.containsAll(navigableNodes);
		Set<@NonNull Node> allNodes = new HashSet<>(navigableNodes);
		allNodes.addAll(computableNodes);
		checkAccumulated(accumulator, allNodes);
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getHeadNodes() {
		return headNodes;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getOtherNodes() {
		return Iterables.concat(navigableNodes, computableNodes);
	}

	@Override
	public @NonNull Iterable<@NonNull Stage> getSuccessors() {
		return successors;
	}

	@Override
	protected boolean isLive(@NonNull Node node, @NonNull Set<@NonNull Node> deadNodes) {
		if (node.isHead()) {
			return true;
		}
		if (node.isRealized()) {
			return false;
		}
		int bidirectionals = 0;
		for (@NonNull Edge edge : node.getOutgoingEdges()) {
			if (!edge.isRealized() && !deadNodes.contains(edge.getTarget())) {
				if (!SplitterUtil.isBidirectional(edge)) {
					return true;
				}
				bidirectionals++;
			}
		}
		return bidirectionals > 1;
	}

	@Override
	public void toString(@NonNull StringBuilder s, int depth) {
		CompilerUtil.indent(s, depth);
		s.append("simple-group : ");
		s.append(targetSimpleGroup.getName());
		s.append(" : ");
		s.append(targetSimpleGroup.getHeadNode());
	}
}