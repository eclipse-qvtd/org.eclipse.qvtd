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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.qvtd.pivot.qvtschedule.MultiRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl;

public abstract class AbstractRegion extends RegionImpl
{

	/**
	 * Set true if this region recurses on its outputs.
	 */
	//	private boolean isCyclic = false;

	protected AbstractRegion(@NonNull MultiRegion multiRegion) {
		super(multiRegion);
	}

	protected @Nullable Map<@NonNull Node, @NonNull Node> expandRecursion(@NonNull Node nextNode, @NonNull Node prevNode, @NonNull Map<@NonNull Node, @NonNull Node> bindings) {
		Node oldPrevNode = bindings.put(nextNode, prevNode);
		if (oldPrevNode != null) {
			assert oldPrevNode == prevNode;
			return bindings;
		}
		for (@NonNull NavigableEdge navigationEdge : prevNode.getNavigationEdges()) {
			Node nextTarget = nextNode.getNavigationTarget(navigationEdge.getProperty());
			if (nextTarget == null) {
				return null;
			}
			Node prevTarget = navigationEdge.getEdgeTarget();
			if (expandRecursion(nextTarget, prevTarget, bindings) == null) {
				return null;
			}
		}
		return bindings;
	}

	public void resolveRecursion() {
		Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> completeClass2nodes = RegionUtil.getCompleteClass2Nodes(this);
		List<@NonNull Node> headNodes = getHeadNodes();
		if (headNodes.size() == 1) {			// FIXME multi-heads
			Node headNode = headNodes.get(0);
			List<@NonNull Node> nodeList = completeClass2nodes.get(headNode.getCompleteClass());
			assert nodeList != null;
			if (nodeList.size() > 1) {
				for (@NonNull Node node : nodeList) {
					if (node != headNode) {
						Map<@NonNull Node, @NonNull Node> bindings = expandRecursion(headNode, node, new HashMap<>());
						if (bindings != null) {
							//						this.recursiveBindings  = bindings;
							for (Map.@NonNull Entry<@NonNull Node, @NonNull Node> entry : bindings.entrySet()) {
								@NonNull Node prevNode = entry.getKey();
								@NonNull Node nextNode = entry.getValue();
								RegionUtil.createRecursionEdge(prevNode, nextNode, prevNode.isHead());
							}
							return;				// FIXME can we have more than one recursion ??
						}
					}
				}
			}
		}
	}
}