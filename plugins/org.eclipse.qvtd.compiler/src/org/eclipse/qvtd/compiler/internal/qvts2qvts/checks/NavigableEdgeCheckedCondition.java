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
 * A NavigableEdgeCheckedCondition identifies the temporary failure that arises when
 * observing a property access to a not-yet assigned slot.
 */
public class NavigableEdgeCheckedCondition extends CheckedCondition
{
	protected final @NonNull NavigableEdge navigableEdge;

	public NavigableEdgeCheckedCondition(@NonNull NavigableEdge navigableEdge) {
		this.navigableEdge = navigableEdge;
	}

	@Override
	public <R> R accept(@NonNull CheckedConditionVisitor<R> visitor) {
		return visitor.visitNavigableEdgeCheckedCondition(this);
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getEdges() {
		return Collections.singletonList(navigableEdge);
	}

	public @NonNull Edge getNavigableEdge() {
		return navigableEdge;
	}
}