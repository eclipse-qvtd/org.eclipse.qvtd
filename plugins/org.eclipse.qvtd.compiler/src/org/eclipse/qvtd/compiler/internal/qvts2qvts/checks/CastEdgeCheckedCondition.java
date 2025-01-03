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

import java.util.Collections;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;

/**
 * A CastEdgeCheckedCondition identifies the failure when a source fails to compky with the required target type.
 */
public class CastEdgeCheckedCondition extends CheckedCondition
{
	private final @NonNull NavigableEdge castEdge;

	public CastEdgeCheckedCondition(@NonNull NavigableEdge castEdge) {
		this.castEdge = castEdge;
	}

	@Override
	public <R> R accept(@NonNull CheckedConditionVisitor<R> visitor) {
		return visitor.visitCastEdgeCheckedCondition(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CastEdgeCheckedCondition)) {
			return false;
		}
		CastEdgeCheckedCondition that = (CastEdgeCheckedCondition)obj;
		return castEdge == that.castEdge;
	}

	public @NonNull NavigableEdge getCastEdge() {
		return castEdge;
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getEdges() {
		return Collections.singletonList(castEdge);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode() + System.identityHashCode(castEdge);
	}
}