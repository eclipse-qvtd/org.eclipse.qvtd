/*******************************************************************************
 * Copyright (c) 2015, 2020 Willink Transformations and others.
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
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;

/**
 * A ConstantTargetCheckedCondition identifies the failure when a computation fails to yield the required constant value.
 */
public class ConstantTargetCheckedCondition extends CheckedCondition
{
	protected final @NonNull NavigationEdge navigationEdge;
	protected final @NonNull CheckPriority checkPriority;

	public ConstantTargetCheckedCondition(@NonNull NavigationEdge navigationEdge) {
		this.navigationEdge = navigationEdge;
		checkPriority = CheckPriority.CONSTANT_TARGET;
	}

	public ConstantTargetCheckedCondition(@NonNull SuccessEdge successEdge, boolean isLocalSuccess) {
		this.navigationEdge = successEdge;
		checkPriority = isLocalSuccess ? CheckPriority.LOCAL_SUCCESS_EDGE : CheckPriority.GLOBAL_SUCCESS_EDGE;
	}

	@Override
	public <R> R accept(@NonNull CheckedConditionVisitor<R> visitor) {
		return visitor.visitConstantTargetCheckedCondition(this);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof ConstantTargetCheckedCondition)) {
			return false;
		}
		ConstantTargetCheckedCondition that = (ConstantTargetCheckedCondition)obj;
		return (navigationEdge == that.navigationEdge) && (checkPriority == that.checkPriority);
	}

	@Override
	protected @NonNull CheckPriority getCheckPriority() {
		return checkPriority;
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getEdges() {
		return Collections.singletonList(navigationEdge);
	}

	public @NonNull NavigationEdge getNavigationEdge() {
		return navigationEdge;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode() + checkPriority.ordinal() + System.identityHashCode(navigationEdge);
	}
}