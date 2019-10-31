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

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * The abstract implementation of a SlotState provides the mandatory shared functionality for maintaining
 * the state of an object slot.
 */
public abstract class AbstractSlotState implements SlotState
{
	public enum SlotMode {
		ASSIGNABLE,		// No assignment has been performed, object reads are blocked (collections reads may be unblocked)
		ASSIGNED,		// Last assignment has been performed, reads are unblocked
		REASSIGNABLE	// Incremental-only - No assignment has been performed by a re-execution, object reads are blocked (collections reads may be unblocked)
	}

	public abstract static class Incremental extends AbstractSlotState implements SlotState.Incremental
	{
		public static final @NonNull List<Execution.@NonNull Incremental> EMPTY_EXECUTIONS_LIST = Collections.emptyList();
		public static final @NonNull List<Invocation.@NonNull Incremental> EMPTY_INVOCATIONS_LIST = Collections.emptyList();

		private Set<Invocation.@NonNull Incremental> sources = null;
		private Set<Execution.@NonNull Incremental> targets = null;

		protected Incremental(@NonNull SlotMode mode) {
			super(mode);
		}

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

	protected @NonNull SlotMode mode;
	private @Nullable Object blockedInvocations = null;

	protected AbstractSlotState(@NonNull SlotMode mode) {
		this.mode = mode;
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitSlotState(this);
	}

	@Override
	public synchronized void block(@NonNull Invocation invocation) {
		final Object blockedInvocations2 = blockedInvocations;
		if (blockedInvocations2 == null) {
			blockedInvocations = invocation;
		}
		else if (blockedInvocations2 instanceof Invocation) {
			List<Invocation> blockedInvocationList = new ArrayList<Invocation>();
			blockedInvocationList.add((Invocation) blockedInvocations2);
			blockedInvocationList.add(invocation);
			blockedInvocations = blockedInvocationList;
		}
		else {
			@SuppressWarnings("unchecked")
			List<Invocation> blockedInvocationList = (List<Invocation>)blockedInvocations2;
			blockedInvocationList.add(invocation);
		}
	}

	protected boolean isAssigned() {
		return mode == SlotMode.ASSIGNED;
	}

	protected synchronized void unblock(@NonNull ObjectManager objectManager) {
		final Object blockedInvocations2 = blockedInvocations;
		if (blockedInvocations2 instanceof Invocation) {
			((Invocation) blockedInvocations2).unblock();
		}
		else if (blockedInvocations2 != null) {
			@SuppressWarnings("unchecked")
			List<Invocation> blockedInvocationList = (List<Invocation>)blockedInvocations2;
			for (@SuppressWarnings("null")@NonNull Invocation invocation : blockedInvocationList) {
				invocation.unblock();
			}
		}
		blockedInvocations = null;
	}
}
