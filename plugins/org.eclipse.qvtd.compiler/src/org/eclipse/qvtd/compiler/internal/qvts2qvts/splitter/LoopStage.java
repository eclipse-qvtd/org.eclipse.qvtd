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
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;

/**
 * A LoopStage specifies an intermediate looping part of a multi-headed region split.
 * It has a headNode to represent its primary content and an edge that defines the entry to the stage.
 * LoopStages may be folded into the HeadStage.
 */
class LoopStage extends HeadedStage
{
	public LoopStage(@NonNull SplitterAnalysis splitter, @Nullable HeadedStage sourceStage, @NonNull Edge edge, @NonNull SimpleGroup targetSimpleGroup) {
		super(splitter, sourceStage, edge, targetSimpleGroup);
	}

	@Override
	protected @NonNull String buildContents(@NonNull StringBuilder s) {
		Node iteratedNode = getIteratedNode();
		Node iteratorNode = getIteratorNode();
		build(s, "iteration domain", Collections.singletonList(iteratedNode));
		build(s, iteratorNode.isSpeculated() || iteratorNode.isPredicated() ? "hazardous-iterator" : "safe-iterator", Collections.singletonList(iteratorNode));
		return super.buildContents(s);
	}

	@Override
	public void check() {}		// FIXME use inherited check

	public @NonNull Edge getEdge() {
		assert edge != null;
		return edge;
	}

	@Override
	public @NonNull Node getIteratedNode() {
		Edge edge = getEdge();
		return edge.isComputation() ? edge.getEdgeSource() : edge.getEdgeTarget();
	}

	@Override
	public @NonNull Node getIteratorNode() {
		Edge edge = getEdge();
		return edge.isComputation() ? edge.getEdgeTarget() : edge.getEdgeSource();
	}

	@Override
	protected boolean isLive(@NonNull Node node, @NonNull Set<@NonNull Node> deadNodes) {
		Edge edge = getEdge();
		if ((node == edge.getEdgeSource()) || (node == edge.getEdgeTarget())) {
			return true;
		}
		return super.isLive(node, deadNodes);
	}
}