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
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * A CheckedCondition identifies a possible micromapping failure mechanism.
 *
 * Trace synthesis determines whether a success property is needed according to the presence of possible failures.
 *
 * Speculation determines whether checks require run-time evaluation.
 *
 * QVTi synthesis prioritises easily computed CheckedConditions to minimize the wasted effort in computing failures.
 */
public abstract class CheckedCondition
{
	/**
	 * Return the result of invoking the derived-class-specific visitor method.
	 */
	public abstract <R> R accept(@NonNull CheckedConditionVisitor<R> visitor);

	/**
	 * Return a list of edges that contribute to the check, null for none.
	 */
	public @Nullable Iterable<@NonNull Edge> getEdges() {
		return null;
	}

	/**
	 * Return the node that contributes to the check, null for none.
	 */
	public @Nullable Node getNode() {
		return null;
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName());
		s.append("(");
		boolean isFirst = true;
		Iterable<@NonNull Edge> edges = getEdges();
		if (edges != null) {
			for (@NonNull Edge edge : edges) {
				if (!isFirst) {
					s.append(",");
				}
				s.append(edge.getDisplayName());
				isFirst = false;
			}
		}
		Node node = getNode();
		if (node != null) {
			if (!isFirst) {
				s.append(",");
			}
			s.append(node.getDisplayName());
			isFirst = false;
		}
		s.append(")");
		return s.toString();
	}
}