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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;

/**
 * AbstractInvocation provides the mandatory shared functionality of the intrusive blocked/waiting linked list functionality.
 */
public abstract class AbstractComputation implements Computation
{
	public abstract static class Incremental extends AbstractComputation implements Computation.Incremental
	{
		public static final @NonNull List<@NonNull Object> EMPTY_OBJECT_LIST = Collections.emptyList();

		private Set<SlotState.@NonNull Incremental> readSlots = null;

		@Override
		public void addReadSlot(SlotState.@NonNull Incremental readSlot) {
			if (readSlots == null) {
				readSlots = new HashSet<>();
			}
			readSlots.add(readSlot);
			readSlot.addTargetInternal(this);
		}

		@Override
		public @NonNull Iterable<@NonNull Object> getCreatedObjects() {
			return /*createdObjects != null ? createdObjects :*/ EMPTY_OBJECT_LIST;
		}
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitComputation(this);
	}

	@Override
	public @NonNull String getName() {
		return toString().replace("@",  "\n@");
	}
}