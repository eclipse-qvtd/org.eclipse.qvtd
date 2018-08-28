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
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;

/**
 * A PredicateNavigationEdgeCheckedCondition identifies the failure of a navigation to lovate ta required constant value.
 */
public class PredicateNavigationEdgeCheckedCondition extends CheckedCondition
{
	protected final @NonNull NavigationEdge navigationEdge;

	public PredicateNavigationEdgeCheckedCondition(@NonNull NavigationEdge navigationEdge) {
		this.navigationEdge = navigationEdge;
	}

	@Override
	public <R> R accept(@NonNull CheckedConditionVisitor<R> visitor) {
		return visitor.visitPredicateNavigationEdgeCheckedCondition(this);
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getEdges() {
		return Collections.singletonList(navigationEdge);
	}

	public @NonNull NavigationEdge getNavigationEdge() {
		return navigationEdge;
	}
}