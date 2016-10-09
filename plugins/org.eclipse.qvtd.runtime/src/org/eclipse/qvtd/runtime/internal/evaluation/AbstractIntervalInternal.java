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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.EnforcedConnection;
import org.eclipse.qvtd.runtime.evaluation.ExecutionVisitor;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.SlotState;
import org.eclipse.qvtd.runtime.evaluation.UnenforcedConnection;

/**
 * AbstractIntervalInternal provides the shared implementation of the intrusive blocked/waiting linked list functionality.
 */
public abstract class AbstractIntervalInternal implements Interval
{
	protected final boolean debugInvocations = AbstractTransformer.INVOCATIONS.isActive();

	protected final @NonNull InvocationManager invocationManager;
	protected final int intervalIndex;

	//	public @Nullable SlotState debug_blockedBy = null;

	/**
	 * Head of a singly linked list element of connections awaiting propagation, null when empty.
	 */
	private @Nullable AbstractConnectionInternal headConnection = null;

	/**
	 * Tail of a singly linked list element of connections awaiting propagation, null when empty.
	 */
	private @Nullable AbstractConnectionInternal tailConnection = null;

	/**
	 * Head of doubly linked list of blocked invocations.
	 */
	private @NonNull List<@NonNull Connection> connections = new ArrayList<>();

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
	public @NonNull Connection createConnection(@NonNull String name, @NonNull CollectionTypeId typeId, boolean isEnforced) {
		Connection connection;
		if (isEnforced) {
			connection = new EnforcedConnection(this, name, typeId);
		}
		else {
			connection = new UnenforcedConnection(this, name, typeId);
		}
		connections.add(connection);
		return connection;
	}

	@Override
	public boolean flush() {
		while (headConnection != null) {
			AbstractConnectionInternal nextConnection2;
			synchronized(this) {
				nextConnection2 = headConnection;
				if (nextConnection2 != null) {
					headConnection = nextConnection2.getNextConnection();
					if (headConnection == null) {
						tailConnection = null;
					}
					nextConnection2.resetQueued();
				}
			}
			if (nextConnection2 != null) {
				nextConnection2.propagate();
			}
		}
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

	@Override
	public @NonNull Iterable<@NonNull Connection> getConnections() {
		return connections;
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
				while (waitingInvocations != null) {
					AbstractInvocationInternal invocation2 = null;
					synchronized (this) {
						AbstractInvocationInternal waitingInvocations2 = waitingInvocations;
						if (waitingInvocations2 != null) {
							invocation2 = waitingInvocations2;
							waitingInvocations = waitingInvocations2.next;
							if (waitingInvocations == invocation2) {
								waitingInvocations = null;
							}
							invocation2.remove();
						}
					}
					if (invocation2 != null) {
						if (debugInvocations) {
							AbstractTransformer.INVOCATIONS.println("re-invoke " + invocation2);
						}
						invoke(invocation2, false);
					}
				}
			}
		}
		catch (InvocationFailedException e) {
			block(invocation, e.slotState);
		}
	}

	@Override
	public boolean isFlushed() {
		if (tailConnection != null) {
			return false;
		}
		// assert each connection fully propagatred
		if (blockedInvocations != null) {
			return false;
		}
		if (waitingInvocations != null) {
			return false;
		}
		return true;
	}

	public void queue() {
		invocationManager.setWorkToDoAt(intervalIndex);
	}

	@Override
	public synchronized void queue(@NonNull Connection connection) {
		AbstractConnectionInternal connection2 = (AbstractConnectionInternal)connection;
		AbstractConnectionInternal tailConnection2 = tailConnection;
		if (tailConnection2 == null) {								// Empty list
			assert headConnection == null;
			assert connection2.getNextConnection() == null;
			headConnection = connection2;
		}
		else {														// New element
			assert headConnection != null;
			tailConnection2.setNextConnection(connection2);
		}
		tailConnection = connection2;
		queue();
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
		s.append("<");
		s.append(intervalIndex);
		s.append("> ");
		int i = 0;
		for (AbstractConnectionInternal aConnection = headConnection; aConnection != null; aConnection = aConnection.getNextConnection()) {
			i++;
			if (i > 100) {
				i = 999999;
				break;
			}
		}
		s.append(i);
		s.append(" connections, ");
		int j = 0;
		for (AbstractInvocationInternal anInvocation = blockedInvocations; anInvocation != null; anInvocation = anInvocation.next) {
			j++;
			if (j > 100) {
				j = 999999;
				break;
			}
			if (anInvocation == blockedInvocations) {
				break;
			}
		}
		s.append(j);
		s.append(" blocked, ");
		int k = 0;
		for (AbstractInvocationInternal anInvocation = waitingInvocations; anInvocation != null; anInvocation = anInvocation.next) {
			k++;
			if (k > 100) {
				k = 999999;
				break;
			}
			if (anInvocation == waitingInvocations) {
				break;
			}
		}
		s.append(k);
		s.append(" waiting");
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
