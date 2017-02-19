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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * A Stage specifies part of a multi-headed region split. It has a headNode to represent its primary content
 * and an edge that defines the entry to the stage, null fir the first stage.
 */
abstract class AbstractStage implements Stage
{
	/**
	 * The Splitter supervising the region splitting.
	 */
	protected final @NonNull SplitterAnalysis splitter;

	protected AbstractStage(@NonNull SplitterAnalysis splitter) {
		this.splitter = splitter;
	}

	protected abstract @NonNull String buildContents(@NonNull StringBuilder s);

	protected void build(@NonNull StringBuilder s, @NonNull String title, @NonNull Iterable<@NonNull Node> nodes) {
		if (!Iterables.isEmpty(nodes)) {
			s.append("\n");
			CompilerUtil.indent(s, 2);
			s.append(title);
			for (@NonNull Node node : nodes) {
				s.append("\n");
				CompilerUtil.indent(s, 3);
				if (node.isHead()) {
					s.append("*");
				}
				s.append(node.getName());
				s.append(" : ");
				s.append(node);
			}
		}
	}

	/**
	 * Verify that addition of nodes to accumulator contributes exclusively new content.
	 */
	protected void checkAccumulate(@NonNull Set<@NonNull Node> accumulator, @NonNull Iterable<@NonNull Node> nodes) {
		for (@NonNull Node node : nodes) {
			boolean wasAdded = accumulator.add(node);
			assert wasAdded;
		}
	}

	/**
	 * Verify that the accumulator contributes exclusively new content.
	 */
	protected void checkAccumulated(@NonNull Set<@NonNull Node> actualNodes, @NonNull Iterable<@NonNull Node> expectedNodes) {
		Set<@NonNull Node> expectedNodesSet = Sets.newHashSet(expectedNodes);
		if (!actualNodes.equals(expectedNodesSet)) {
			StringBuilder s = new StringBuilder();
			Set<@NonNull Node> extraNodesSet = Sets.newHashSet(actualNodes);
			CompilerUtil.removeAll(extraNodesSet, expectedNodes);
			for (@NonNull Node node : extraNodesSet) {
				s.append("\nextra: ");
				s.append(node);
			}
			Set<@NonNull Node> missingNodesSet = Sets.newHashSet(expectedNodes);
			missingNodesSet.removeAll(actualNodes);
			for (@NonNull Node node : missingNodesSet) {
				s.append("\nmissing: ");
				s.append(node);
			}
			assert false : "Bad nodes for " + this + s.toString();
		}
	}

	/**
	 * The dead nodes are non-realized nodes that have outgoing edges only to dead nodes or head nodes.
	 */
	protected @NonNull Iterable<@NonNull Node> computeDeadNodes(@NonNull Iterable<@NonNull Node> reachableNodes) {
		Set<@NonNull Node> deadNodes = new HashSet<>();
		Set<@NonNull Node> tryNodes = Sets.newHashSet(reachableNodes);
		while (!tryNodes.isEmpty()) {
			Set<@NonNull Node> retryNodes = new HashSet<>();
			for (@NonNull Node node : tryNodes) {
				if (!isLive(node, deadNodes)) {
					deadNodes.add(node);
					for (@NonNull Edge edge : node.getIncomingEdges()) {
						if (!edge.isRealized()) {
							Node sourceNode = edge.getEdgeSource();
							if (!sourceNode.isRealized()) {
								retryNodes.add(sourceNode);
							}
						}
					}
				}
			}
			retryNodes.removeAll(deadNodes);
			tryNodes = retryNodes;
		}
		List<@NonNull Node> nodeList = new ArrayList<>(deadNodes);
		Collections.sort(nodeList, NameUtil.NAMEABLE_COMPARATOR);
		return nodeList;
	}

	@Override
	public void debug() {
		if (Splitter.STAGES.isActive()) {
			StringBuilder s = new StringBuilder();
			toString(s, 1);
			String name = buildContents(s);
			Splitter.STAGES.println(splitter.toString() + ":" + name + "\n" + s.toString());
		}
	}

	@Override
	public @Nullable Node getIteratedNode() {
		return null;
	}

	@Override
	public @Nullable Node getIteratorNode() {
		return null;
	}

	protected abstract boolean isLive(@NonNull Node node, @NonNull Set<@NonNull Node> deadNodes);

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		s.append(splitter.toString());
		s.append(" ");
		toString(s, 0);
		return s.toString();
	}
}