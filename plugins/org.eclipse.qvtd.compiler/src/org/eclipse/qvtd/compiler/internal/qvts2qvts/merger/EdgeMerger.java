/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * An EdgeMerger gathers the contributions for an edge in a merged region and supports
 * optimization of the to be created merged region.
 */
class EdgeMerger
{
	protected final @NonNull RegionMerger regionMerger;
	protected final @NonNull NodeMerger mergedSourceNodeMerger;
	protected final @NonNull NodeMerger mergedTargetNodeMerger;
	protected final @NonNull List<@NonNull Edge> originalEdges = new ArrayList<>();
	private @NonNull Role edgeRole;
	private @Nullable Edge mergedEdge = null;

	public EdgeMerger(@NonNull RegionMerger regionMerger, @NonNull Edge originalEdge) {
		assert !originalEdge.isSecondary();
		this.regionMerger = regionMerger;
		mergedSourceNodeMerger = regionMerger.getNodeMerger(originalEdge.getEdgeSource());
		mergedTargetNodeMerger = regionMerger.getNodeMerger(originalEdge.getEdgeTarget());
		originalEdges.add(originalEdge);
		edgeRole = QVTscheduleUtil.getEdgeRole(originalEdge);
		regionMerger.mapOriginalEdge(originalEdge, this);
		mergedSourceNodeMerger.addOutgoingEdgeMerger(this, mergedTargetNodeMerger);
		mergedTargetNodeMerger.addIncomingEdgeMerger(this, mergedSourceNodeMerger);
	}

	public void addOriginalEdge(@NonNull Edge originalEdge) {
		assert !originalEdge.isSecondary();
		assert !originalEdges.contains(originalEdge);
		originalEdges.add(originalEdge);
		edgeRole = QVTscheduleUtil.mergeToMoreKnownPhase(edgeRole, QVTscheduleUtil.getEdgeRole(originalEdge));
		regionMerger.mapOriginalEdge(originalEdge, this);
	}

	public @Nullable Edge createMergedEdge(@NonNull Node sourceNodeMerger, @NonNull Node targetNodeMerger) {
		Edge mergedEdge2 = mergedEdge;
		assert mergedEdge2 == null;
		for (@NonNull Edge originalEdge : originalEdges) {
			mergedEdge2 = mergedEdge = originalEdge.createEdge(edgeRole, originalEdge.getInitUtility(), sourceNodeMerger, targetNodeMerger);
			break;
		}
		if (mergedEdge2 == null) {
			return null;
		}
		return mergedEdge2;
	}

	public void destroy() {
		mergedSourceNodeMerger.removeOutgoingEdgeMerger(this, mergedTargetNodeMerger);
		mergedTargetNodeMerger.removeIncomingEdgeMerger(this, mergedSourceNodeMerger);
		for (@NonNull Edge originalEdge : originalEdges) {
			regionMerger.unmapOriginalEdge(originalEdge, this);
		}
	}

	public @NonNull Edge getMergedEdge() {
		return ClassUtil.nonNullState(mergedEdge);
	}

	public @NonNull Iterable<@NonNull Edge> getOriginalEdges() {
		return originalEdges;
	}

	public @NonNull Node getOriginalSource() {
		return getPrimaryEdge().getEdgeSource();
	}

	public @NonNull Node getOriginalTarget() {
		return getPrimaryEdge().getEdgeTarget();
	}

	private @NonNull Edge getPrimaryEdge() {
		return originalEdges.get(0);
	}

	public @Nullable Property getProperty() {
		Edge primaryEdge = getPrimaryEdge();		// FIXME check all original edges
		if (primaryEdge instanceof NavigationEdge) {
			return QVTscheduleUtil.getReferredProperty((NavigationEdge)primaryEdge);
		}
		else {
			return null;
		}
	}

	public @NonNull NodeMerger getSource() {
		return mergedSourceNodeMerger;
	}

	public @NonNull NodeMerger getTarget() {
		return mergedTargetNodeMerger;
	}

	private boolean isCast() {
		return getPrimaryEdge().isCast();
	}

	public boolean isConstant() {
		return getPrimaryEdge().isConstant();		// FIXME check all original edges
	}

	public boolean isFoldable() {
		return isCast() && mergedTargetNodeMerger.isNew() && !mergedSourceNodeMerger.isNew();
	}

	public boolean isLoaded() {
		return getPrimaryEdge().isLoaded();		// FIXME check all original edges
	}

	public boolean isNew() {
		return getPrimaryEdge().isNew();		// FIXME check all original edges
	}

	public boolean isOld() {
		return getPrimaryEdge().isOld();		// FIXME check all original edges
	}

	//	public boolean isUnconditional() {
	//		return getPrimaryEdge().isUnconditional();		// FIXME check all original edges
	//	}

	/**
	 * Return an originalEdge that is the same as mergedEdge or null if none.
	 */
	public @Nullable Edge sameEdge(@NonNull Edge mergedEdge) {
		if (mergedEdge instanceof NavigationEdge) {
			Property mergedProperty = QVTscheduleUtil.getReferredProperty((NavigationEdge)mergedEdge);
			for (@NonNull Edge originalEdge : originalEdges) {
				if (originalEdge instanceof NavigationEdge) {
					Property originalProperty = QVTscheduleUtil.getReferredProperty((NavigationEdge)originalEdge);
					if (originalProperty == mergedProperty) {
						return originalEdge;
					}
				}
			}
		}
		else {
			Class<? extends @NonNull Edge> mergedClass = mergedEdge.getClass();
			for (@NonNull Edge originalEdge : originalEdges) {
				Class<? extends @NonNull Edge> originalClass = originalEdge.getClass();
				if (originalClass == mergedClass) {
					return originalEdge;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return mergedEdge != null? mergedEdge.toString() : getPrimaryEdge().toString();
	}
}