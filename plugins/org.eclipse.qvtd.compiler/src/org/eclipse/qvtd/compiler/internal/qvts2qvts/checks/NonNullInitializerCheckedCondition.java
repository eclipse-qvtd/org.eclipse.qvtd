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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;

/**
 * A NonNullInitializerCheckedCondition identifies the failure that arises when
 * a required initializer is evaluated to null.
 */
public class NonNullInitializerCheckedCondition extends CheckedCondition
{
	protected final @NonNull OperationNode operationNode;

	public NonNullInitializerCheckedCondition(@NonNull OperationNode operationNode) {
		this.operationNode = operationNode;
	}

	@Override
	public <R> R accept(@NonNull CheckedConditionVisitor<R> visitor) {
		return visitor.visitNonNullInitializerCheckedCondition(this);
	}

	@Override
	public @Nullable Node getNode() {
		return operationNode;
	}

	public @NonNull OperationNode getOperationNode() {
		return operationNode;
	}
}