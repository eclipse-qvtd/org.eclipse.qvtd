/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * MergedEdge contributes a merge of multiple edges as part of a MergedRegion.
 */
public class MergedEdge extends AbstractEdge
{
	protected final @NonNull List<@NonNull SimpleEdge> simpleEdges = new ArrayList<@NonNull SimpleEdge>();

	public MergedEdge(@NonNull MergedMappingRegion mergedRegion, @NonNull MergedNode sourceNode, @NonNull Edge primaryEdge, @NonNull MergedNode targetNode) {
		super(primaryEdge.getEdgeRole(), mergedRegion, sourceNode, primaryEdge.getName(), targetNode);
		addEdge(primaryEdge);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitMergedEdge(this);
	}

	public void addEdge(@NonNull Edge edge) {
		for (@NonNull SimpleEdge simpleEdge : edge.getSimpleEdges()) {
			assert !simpleEdges.contains(simpleEdge);
			simpleEdges.add(simpleEdge);
			mergeRole(simpleEdge.getEdgeRole());
		}
	}

	public @NonNull Iterable<SimpleEdge> getEdges() {
		return simpleEdges;
	}

	@Override
	public @NonNull Iterable<@NonNull SimpleEdge> getSimpleEdges() {
		return simpleEdges;
	}
}