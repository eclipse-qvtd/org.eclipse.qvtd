/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * AbstractObjectManager provides the mandatory shared functionality for an object state manager.
 */
public abstract class AbstractObjectManager implements ObjectManager
{
	protected static final @NonNull List<@NonNull SlotState> EMPTY_SLOT_STATE_LIST = Collections.emptyList();

	protected final @NonNull InvocationManager invocationManager;
	protected final boolean debugInvocations = AbstractTransformer.INVOCATIONS.isActive();

	protected AbstractObjectManager(@NonNull InvocationManager invocationManager) {
		this.invocationManager = invocationManager;
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitObjectManager(this);
	}
}