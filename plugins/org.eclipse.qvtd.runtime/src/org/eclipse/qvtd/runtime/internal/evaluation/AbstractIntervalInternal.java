/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
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
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.ExecutionVisitor;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.SlotState;

/**
 * AbstractIntervalInternal provides the shared implementation of the intrusive blocked/waiting linked list functionality.
 */
public abstract class AbstractIntervalInternal extends ConnectionLinkage implements Interval
{
	protected final boolean debugInvocations = AbstractTransformer.INVOCATIONS.isActive();

	protected final @NonNull InvocationManager invocationManager;
	protected final int intervalIndex;

	/**
	 * Head of doubly linked list of blocked invocations.
	 */
	private @Nullable AbstractInvocationInternal blockedInvocations = null;

	/**
	 * Head of doubly linked list of unblocked invocations waiting for a re-execution attempt.
	 */
	private @Nullable AbstractInvocationInternal waitingInvocations = null;


	public AbstractIntervalInternal(@NonNull InvocationManager invocationManager, int intervalIndex) {
		this.invocationManager = invocationManager;
		this.intervalIndex = intervalIndex;
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitInterval(this);
	}

	private synchronized void block(@NonNull Invocation invocation, @NonNull SlotState slotState) {
		AbstractInvocationInternal castInvocation = (AbstractInvocationInternal) invocation;
		assert castInvocation.debug_blockedBy == null;
		castInvocation.debug_blockedBy = slotState;
		AbstractInvocationInternal blockedInvocations2 = blockedInvocations;
		if (blockedInvocations2 == null) {
			blockedInvocations = castInvocation;
		}
		else {
			castInvocation.insertAfter(blockedInvocations2.prev);
		}
		slotState.block(invocation);
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("block " + invocation + " for " + slotState);
		}
	}

	@Override
	public boolean flush() {
		flushInternal();
		AbstractInvocationInternal blockedInvocation = blockedInvocations;
		if (blockedInvocation == null) {
			return true;
		}
		do {
			if (debugInvocations) {
				AbstractTransformer.INVOCATIONS.println("still blocked " + blockedInvocation + " by " + blockedInvocation.debug_blockedBy);
			}
			blockedInvocation = blockedInvocation.next;
		}
		while (blockedInvocation != blockedInvocations);
		return false;
	}

	private void flushInternal() {
		while (waitingInvocations != null) {
			AbstractInvocationInternal invocation = null;
			synchronized (this) {
				AbstractInvocationInternal waitingInvocations2 = waitingInvocations;
				if (waitingInvocations2 != null) {
					invocation = waitingInvocations2;
					waitingInvocations = waitingInvocations2.next;
					if (waitingInvocations == invocation) {
						waitingInvocations = null;
					}
					invocation.remove();
				}
			}
			if (invocation != null) {
				if (debugInvocations) {
					AbstractTransformer.INVOCATIONS.println("re-invoke " + invocation);
				}
				invoke(invocation, false);
			}
		}
	}


	@Override
	public int getIndex() {
		return intervalIndex;
	}

	@Override
	public @NonNull InvocationManager getInvocationManager() {
		return invocationManager;
	}

	@Override
	public @NonNull String getName() {
		return String.valueOf(intervalIndex);
	}

	@Override
	public void invoke(@NonNull Invocation invocation, boolean doFlush) {
		try {
			invocation.execute();
			if (debugInvocations) {
				AbstractTransformer.INVOCATIONS.println("done " + invocation);
			}
			if (doFlush) {
				flushInternal();
			}
		}
		catch (InvocationFailedException e) {
			block(invocation, e.slotState);
		}
	}

	@Override
	public synchronized void queue(@NonNull Invocation invocation) {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("queue " + invocation);
		}
		AbstractInvocationInternal castInvocation = (AbstractInvocationInternal) invocation;
		assert castInvocation.debug_blockedBy == null;
		assert blockedInvocations != castInvocation;
		AbstractInvocationInternal waitingInvocations2 = waitingInvocations;
		if (waitingInvocations2 == null) {
			waitingInvocations = castInvocation;
		}
		else {
			castInvocation.insertAfter(waitingInvocations2.prev);
		}
		//		queue();
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(intervalIndex);
		//		s.append(": ");
		//		int i = 0;
		//		for (@NonNull ConnectionLinkage nextConnectionLinkage = nextConnection; nextConnectionLinkage != this; nextConnectionLinkage = nextConnectionLinkage.nextConnection) {
		//			i++;
		//		}
		//		s.append(i);
		return s.toString();
	}

	@Override
	public synchronized void unblock(@NonNull Invocation invocation) {
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("unblock " + invocation);
		}
		AbstractInvocationInternal castInvocation = (AbstractInvocationInternal) invocation;
		assert castInvocation.debug_blockedBy != null;
		castInvocation.debug_blockedBy = null;
		if (blockedInvocations == castInvocation) {
			blockedInvocations = castInvocation.next;
			if (blockedInvocations == castInvocation) {
				blockedInvocations = null;
			}
		}
		castInvocation.remove();
		AbstractInvocationInternal waitingInvocations2 = waitingInvocations;
		if (waitingInvocations2 == null) {
			waitingInvocations = castInvocation;
		}
		else {
			castInvocation.insertAfter(waitingInvocations2.prev);
		}
		//		queue();
	}
}
