/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
 * The abstract implementation of a SlotState provides the mandatory shared functionality for maintaining
 * the state of an object slot.
 */
public abstract class AbstractSlotState implements SlotState
{

	public abstract static class Incremental extends AbstractSlotState implements SlotState.Incremental
	{
		public static final @NonNull List<Execution.@NonNull Incremental> EMPTY_EXECUTIONS_LIST = Collections.emptyList();
		public static final @NonNull List<Invocation.@NonNull Incremental> EMPTY_INVOCATIONS_LIST = Collections.emptyList();

		private Set<Invocation.@NonNull Incremental> sources = null;
		private Set<Execution.@NonNull Incremental> targets = null;

		@Override
		public void addSourceInternal(Invocation.@NonNull Incremental invocation) {
			if (sources == null) {
				sources = new HashSet<>();
			}
			sources.add(invocation);
		}

		@Override
		public void addTargetInternal(Execution.@NonNull Incremental invocation) {
			if (targets == null) {
				targets = new HashSet<>();
			}
			targets.add(invocation);
		}

		@Override
		public @NonNull Iterable<Invocation.@NonNull Incremental> getSources() {
			return sources != null ? sources : EMPTY_INVOCATIONS_LIST;
		}


		@Override
		public @NonNull Iterable<Execution.@NonNull Incremental> getTargets() {
			return targets != null ? targets : EMPTY_EXECUTIONS_LIST;
		}

		protected void revokeTargets() {
			for (Execution.@NonNull Incremental target : getTargets()) {
				target.revoke();
			}
		}
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitSlotState(this);
	}
}
