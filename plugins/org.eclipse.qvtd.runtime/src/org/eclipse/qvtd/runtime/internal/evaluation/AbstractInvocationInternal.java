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
package org.eclipse.qvtd.runtime.internal.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.SlotState;

/**
 * AbstractInvocation provides the shared implementation of the intrusive blocked/waiting linked list functionality.
 */
public abstract class AbstractInvocationInternal implements Invocation
{
	protected final @NonNull Interval interval;
	@NonNull AbstractInvocationInternal prev = this;
	@NonNull AbstractInvocationInternal next = this;
	public @Nullable SlotState debug_blockedBy = null;

	protected AbstractInvocationInternal(@NonNull Interval interval) {
		this.interval = interval;
		// too soon		interval.queue(this);
	}

	@Override
	public void insertAfter(@NonNull Invocation predecessor) {
		@NonNull AbstractInvocationInternal castPredecessor = (AbstractInvocationInternal)predecessor;
		@NonNull AbstractInvocationInternal successor = castPredecessor.next;
		successor.prev = this;
		next = successor;
		castPredecessor.next = this;
		prev = castPredecessor;
	}

	@Override
	public void invokeInternal(boolean doFlush) {
		interval.invoke(this, doFlush);
	}

	@Override
	public void remove() {
		prev.next = next;
		next.prev = prev;
		prev = this;
		next = this;
	}

	public void revoke() {
		throw new UnsupportedOperationException();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(this));
	}

	@Override
	public void unblock() {
		interval.unblock(this);
	}
}