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
import java.util.Arrays;
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
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof MultipleEdgeCheckedCondition)) {
			return false;
		}
		MultipleEdgeCheckedCondition that = (MultipleEdgeCheckedCondition)obj;
		if (node != that.node) {
			return false;
		}
		int size = edges.size();
		if (size != that.edges.size()) {
			return false;
		}
		int[] these = new int[size];
		int[] those = new int[size];
		for (int i = 0; i < size; i++) {
			these[i] = System.identityHashCode(edges.get(i));
			those[i] = System.identityHashCode(that.edges.get(i));
		}
		Arrays.sort(these);
		Arrays.sort(those);
		return these.equals(those);
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getEdges() {
		return edges;
	}

	@Override
	public @NonNull Node getNode() {
		return node;
	}

	@Override
	public int hashCode() {
		int hash = getClass().hashCode() + System.identityHashCode(node);
		for (@NonNull Edge edge : edges) {
			hash += System.identityHashCode(edge);
		}
		return hash;
	}
}