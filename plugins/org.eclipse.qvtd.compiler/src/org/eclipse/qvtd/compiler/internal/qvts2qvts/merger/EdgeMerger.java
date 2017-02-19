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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.merger;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeRole;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * An EdgeMerger gathers the contributions for an edge in a merged region and supports
 * optimization of the to be created merged region.
 */
class EdgeMerger
{
	protected final @NonNull RegionMerger regionMerger;
	protected final @NonNull NodeMerger mergedSourceNodeMerger;
	protected final @NonNull NodeMerger mergedTargetNodeMerger;
	protected final @NonNull List<@NonNull Edge> oldEdges = new ArrayList<>();
	private @NonNull EdgeRole edgeRole;
	private @Nullable Edge newEdge = null;

	public EdgeMerger(@NonNull RegionMerger regionMerger, @NonNull Edge oldEdge) {
		assert !oldEdge.isSecondary();
		this.regionMerger = regionMerger;
		mergedSourceNodeMerger = regionMerger.getNodeMerger(oldEdge.getEdgeSource());
		mergedTargetNodeMerger = regionMerger.getNodeMerger(oldEdge.getEdgeTarget());
		oldEdges.add(oldEdge);
		edgeRole = oldEdge.getEdgeRole();
		regionMerger.mapOldEdge(oldEdge, this);
		mergedSourceNodeMerger.addOutgoingEdgeMerger(this, mergedTargetNodeMerger);
		mergedTargetNodeMerger.addIncomingEdgeMerger(this, mergedSourceNodeMerger);
	}

	public void addOldEdge(@NonNull Edge oldEdge) {
		assert !oldEdge.isSecondary();
		assert !oldEdges.contains(oldEdge);
		oldEdges.add(oldEdge);
		edgeRole = RegionUtil.mergeToMoreKnownPhase(edgeRole, oldEdge.getEdgeRole());
		regionMerger.mapOldEdge(oldEdge, this);
	}

	public @Nullable Edge createNewEdge(@NonNull Node sourceNodeMerger, @NonNull Node targetNodeMerger) {
		Edge newEdge2 = newEdge;
		assert newEdge2 == null;
		for (@NonNull Edge oldEdge : oldEdges) {
			newEdge2 = newEdge = oldEdge.createEdge(edgeRole, sourceNodeMerger, targetNodeMerger, oldEdge.isPartial());
			break;
		}
		if (newEdge2 == null) {
			return null;
		}
		return newEdge2;
	}

	public void destroy() {
		mergedSourceNodeMerger.removeOutgoingEdgeMerger(this, mergedTargetNodeMerger);
		mergedTargetNodeMerger.removeIncomingEdgeMerger(this, mergedSourceNodeMerger);
		for (@NonNull Edge oldEdge : oldEdges) {
			regionMerger.unmapOldEdge(oldEdge, this);
		}
	}

	public @NonNull Edge getNewEdge() {
		return ClassUtil.nonNullState(newEdge);
	}

	public @NonNull Iterable<@NonNull Edge> getOldEdges() {
		return oldEdges;
	}

	public @NonNull Node getOldSource() {
		return oldEdges.get(0).getEdgeSource();
	}

	public @NonNull Node getOldTarget() {
		return oldEdges.get(0).getEdgeTarget();
	}

	public @NonNull NodeMerger getSource() {
		return mergedSourceNodeMerger;
	}

	public @NonNull NodeMerger getTarget() {
		return mergedTargetNodeMerger;
	}

	private boolean isCast() {
		return oldEdges.get(0).isCast();
	}

	public boolean isFoldable() {
		return isCast() && mergedTargetNodeMerger.isNew() && !mergedSourceNodeMerger.isNew();
	}

	/**
	 * Return an oldEdge that is the same as newEdge or null if none.
	 */
	public @Nullable Edge sameEdge(@NonNull Edge newEdge) {
		if (newEdge instanceof NavigableEdge) {
			Property newProperty = ((NavigableEdge)newEdge).getProperty();
			for (@NonNull Edge oldEdge : oldEdges) {
				if (oldEdge instanceof NavigableEdge) {
					Property oldProperty = ((NavigableEdge)oldEdge).getProperty();
					if (oldProperty == newProperty) {
						return oldEdge;
					}
				}
			}
		}
		else {
			Class<? extends @NonNull Edge> newClass = newEdge.getClass();
			for (@NonNull Edge oldEdge : oldEdges) {
				Class<? extends @NonNull Edge> oldClass = oldEdge.getClass();
				if (oldClass == newClass) {
					return oldEdge;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return newEdge != null? newEdge.toString() : oldEdges.get(0).toString();
	}
}