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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;

public class RegionUtil
{
	public static boolean containsNone(@NonNull Iterable<@NonNull Node> firstNodes, @NonNull Iterable<@NonNull Node> secondNodes) {
		for (@NonNull Node firstNode : firstNodes) {
			for (@NonNull Node secondNode : secondNodes) {
				if (firstNode == secondNode) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Return the edge unless it is subject to a cast chain in which case return the final cast.
	 */
	public static @NonNull NavigationEdge getCastTarget(@NonNull NavigationEdge edge) {
		@NonNull NavigationEdge sourceEdge = edge;
		while (true) {
			@Nullable NavigationEdge targetEdge = null;
			for (@NonNull Edge nextEdge : sourceEdge.getTarget().getOutgoingEdges()) {
				if (nextEdge.isRecursion()) {
					continue;
				}
				if (!nextEdge.isCast()) {
					return sourceEdge;
				}
				if (targetEdge != null) {			// FIXME multi-cast support
					return sourceEdge;
				}
				targetEdge = (@Nullable NavigationEdge) nextEdge;
			}
			if (targetEdge == null) {
				return sourceEdge;
			}
			sourceEdge = targetEdge;
		}
	}

	/**
	 * Return the node unless it is subject to a cast chain in which case return the final cast.
	 */
	public static @NonNull Node getCastTarget(@NonNull Node node) {
		@NonNull Node sourceNode = node;
		while (true) {
			@Nullable Node targetNode = null;
			for (@NonNull Edge edge : sourceNode.getOutgoingEdges()) {
				if (edge.isRecursion() || edge.isSecondary()) {
					continue;
				}
				if (!edge.isCast()) {
					return sourceNode;
				}
				if (targetNode != null) {			// FIXME multi-cast support
					return sourceNode;
				}
				targetNode = edge.getTarget();
			}
			if (targetNode == null) {
				return sourceNode;
			}
			sourceNode = targetNode;
		}
	}

	/**
	 * Return true if the source of thatEdge is compatible with the source of thisEdge.
	 */
	public static boolean isConformantSource(@NonNull NavigationEdge thatEdge, @NonNull NavigationEdge thisEdge) {
		Node thatSource = thatEdge.getSource();
		CompleteClass thatType = thatSource.getCompleteClass();
		CompleteClass thisType = thisEdge.getSource().getCompleteClass();
		if (thatType.conformsTo(thisType)) {
			return true;
		}
		if (thatSource.isRealized()) {
			return false;
		}
		if (thisType.conformsTo(thatType)) {
			return true;
		}
		return false;
	}

	/**
	 * Return true if the target of thatEdge is compatible with the target of thisEdge.
	 */
	public static boolean isConformantTarget(@NonNull NavigationEdge thatEdge, @NonNull NavigationEdge thisEdge) {
		Node thatTarget = getCastTarget(thatEdge.getTarget());
		Node thisTarget = getCastTarget(thisEdge.getTarget());
		CompleteClass thatType = thatTarget.getCompleteClass();
		CompleteClass thisType = thisTarget.getCompleteClass();
		if (thatType.conformsTo(thisType)) {
			return true;
		}
		if (thatTarget.isRealized()) {
			return false;
		}
		if (thisType.conformsTo(thatType)) {
			return true;
		}
		return false;
	}
}