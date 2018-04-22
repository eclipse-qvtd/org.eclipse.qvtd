/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.checks;

import java.util.Collections;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;

/**
 * A PredicateEdgeCheckedCondition identifies the failure of a required consistent computation result.
 */
public class PredicateEdgeCheckedCondition extends CheckedCondition
{
	protected final @NonNull PredicateEdge predicateEdge;

	public PredicateEdgeCheckedCondition(@NonNull PredicateEdge predicateEdge) {
		this.predicateEdge = predicateEdge;
	}

	@Override
	public <R> R accept(@NonNull CheckedConditionVisitor<R> visitor) {
		return visitor.visitPredicateEdgeCheckedCondition(this);
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getEdges() {
		return Collections.singletonList(predicateEdge);
	}

	public @NonNull PredicateEdge getPredicateEdge() {
		return predicateEdge;
	}
}