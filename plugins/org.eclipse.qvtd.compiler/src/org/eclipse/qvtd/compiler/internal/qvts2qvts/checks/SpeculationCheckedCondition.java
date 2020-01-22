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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;

/**
 * A PredicateEdgeCheckedCondition identifies the failure of a required consistent computation result.
 */
public class SpeculationCheckedCondition extends CheckedCondition
{
	protected final @NonNull Iterable <@NonNull SuccessEdge> speculatedEdges;

	public SpeculationCheckedCondition(@NonNull Iterable <@NonNull SuccessEdge> speculatedEdges) {
		this.speculatedEdges = speculatedEdges;
	}

	@Override
	public <R> R accept(@NonNull CheckedConditionVisitor<R> visitor) {
		return visitor.visitSpeculationCheckedCondition(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SpeculationCheckedCondition)) {
			return false;
		}
		SpeculationCheckedCondition that = (SpeculationCheckedCondition)obj;
		return speculatedEdges.equals(that.speculatedEdges);
	}

	@Override
	public @Nullable Iterable<@NonNull Edge> getEdges() {
		return null;		// Speculated edges are globally rather than locally checked
	}

	@Override
	public int hashCode() {
		return getClass().hashCode() + System.identityHashCode(speculatedEdges);
	}
}