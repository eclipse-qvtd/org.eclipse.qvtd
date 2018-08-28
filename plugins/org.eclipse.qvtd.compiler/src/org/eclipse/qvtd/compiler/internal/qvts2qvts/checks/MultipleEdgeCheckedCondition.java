/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.checks;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * A MultipleEdgeCheckedCondition identifies the failure when two or more alternate navigation paths yield inconsistent results.
 */
public class MultipleEdgeCheckedCondition extends CheckedCondition
{
	protected final @NonNull Node node;
	protected final @NonNull List<@NonNull Edge> edges = new ArrayList<>();

	public MultipleEdgeCheckedCondition(@NonNull Node node,  @NonNull Edge firstEdge, @NonNull Edge secondEdge) {
		this.node = node;
		addEdge(firstEdge);
		addEdge(secondEdge);
	}

	@Override
	public <R> R accept(@NonNull CheckedConditionVisitor<R> visitor) {
		return visitor.visitMultipleEdgeCheckedCondition(this);
	}

	public boolean addEdge(@NonNull Edge edge) {
		return edges.add(edge);
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getEdges() {
		return edges;
	}

	@Override
	public @NonNull Node getNode() {
		return node;
	}
}