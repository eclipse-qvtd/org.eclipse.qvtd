/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * MergedEdge contributes a merge of multiple edges as part of a MergedRegion.
 */
public class MergedEdge extends AbstractEdge
{
	protected final @NonNull List<SimpleEdge> simpleEdges = new ArrayList<SimpleEdge>();
		
	public MergedEdge(@NonNull MergedRegion mergedRegion, @NonNull MergedNode sourceNode, @NonNull Edge primaryEdge, @NonNull MergedNode targetNode) {
		super(primaryEdge.getEdgeRole(), mergedRegion, sourceNode, primaryEdge.getName(), targetNode);
		addEdge(primaryEdge);
	}

	public void addEdge(@NonNull Edge edge) {
		for (SimpleEdge simpleEdge : edge.getSimpleEdges()) {
			assert !simpleEdges.contains(simpleEdge);
			simpleEdges.add(simpleEdge);
			mergeRole(simpleEdge.getEdgeRole());
		}
	}

	public @NonNull Iterable<SimpleEdge> getEdges() {
		return simpleEdges;
	}

	@Override
	public @NonNull Iterable<SimpleEdge> getSimpleEdges() {
		return simpleEdges;
	}
}