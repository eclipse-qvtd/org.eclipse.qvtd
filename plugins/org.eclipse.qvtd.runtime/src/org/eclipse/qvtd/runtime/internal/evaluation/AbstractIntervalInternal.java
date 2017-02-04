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
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.qvtd.runtime.evaluation.AbstractConnection;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.ExecutionVisitor;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationFailedException;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;
import org.eclipse.qvtd.runtime.evaluation.SimpleConnection;
import org.eclipse.qvtd.runtime.evaluation.SimpleIncrementalConnection;
import org.eclipse.qvtd.runtime.evaluation.SlotState;
import org.eclipse.qvtd.runtime.evaluation.StrictConnection;
import org.eclipse.qvtd.runtime.evaluation.StrictIncrementalConnection;

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
	private @Nullable AbstractConnection headConnection = null;

	/**
	 * Tail of a singly linked list element of connections awaiting propagation, null when empty.
	 */
	private @Nullable AbstractConnection tailConnection = null;

	/**
	 * Head of doubly linked list of blocked invocations.
	 */
	private @NonNull List<@NonNull Connection> connections = new ArrayList<>();

	/**
	 * Head of doubly linked list of blocked invocations.
	 */
	private @Nullable AbstractInvocationInternal blockedInvocations = null;

	/**
	 * Head of doubly linked list of unblocked invocations waiting for an execution attempt.
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
		assert castInvocation.next == castInvocation;
		assert castInvocation.prev == castInvocation;
		assert blockedInvocations != castInvocation;
		assert waitingInvocations != castInvocation;
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
	public @NonNull Connection createConnection(@NonNull String name, @NonNull TypeId typeId, boolean isStrict) {
		Connection connection;
		if (isStrict) {
			connection = new StrictConnection(this, name, typeId);
		}
		else {
			connection = new SimpleConnection(this, name, typeId);
		}
		connections.add(connection);
		return connection;
	}

	@Override
	public Connection.@NonNull Incremental createIncrementalConnection(@NonNull String name, @NonNull TypeId typeId, boolean isStrict) {
		Connection.Incremental connection;
		if (isStrict) {
			connection = new StrictIncrementalConnection(this, name, typeId);
		}
		else {
			connection = new SimpleIncrementalConnection(this, name, typeId);
		}
		connections.add(connection);
		return connection;
	}

	public synchronized void destroy(@NonNull Invocation invocation) {
		assert invocation.getInterval() == this;
		if (debugInvocations) {
			AbstractTransformer.INVOCATIONS.println("destroy " + invocation);
		}
		AbstractInvocationInternal castInvocation = (AbstractInvocationInternal) invocation;
		assert blockedInvocations != castInvocation;
		if (waitingInvocations == castInvocation) {
			waitingInvocations = castInvocation.next;
			if (waitingInvocations == castInvocation) {
				waitingInvocations = null;
			}
		}
		AbstractInvocationInternal prevInvocation = castInvocation.prev;
		if (prevInvocation != castInvocation) {
			AbstractInvocationInternal nextInvocation = castInvocation.next;
			prevInvocation.next = nextInvocation;
			nextInvocation.prev = prevInvocation;
			castInvocation.next = castInvocation;
			castInvocation.prev = castInvocation;
		}
	}

	@Override
	public boolean flush() {
		while (headConnection != null) {
			AbstractConnection nextConnection2;
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
					AbstractTransformer.INVOCATIONS.println("invoke " + invocation);
				}
				try {
					boolean success = invocation.execute();
					if (debugInvocations) {
						AbstractTransformer.INVOCATIONS.println((success ? "done "  : "fail ") + invocation);
					}
				}
				catch (InvocationFailedException e) {
					block(invocation, e.slotState);
				}
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
		AbstractConnection connection2 = (AbstractConnection)connection;
		AbstractConnection tailConnection2 = tailConnection;
		if (tailConnection2 == null) {								// Empty list
			assert headConnection == null;
			assert connection2.getNextConnection() == null;
			headConnection = connection2;
		}
		else {														// New element
			assert headConnection != null;
			if (connection2.getNextConnection() != null) {
				return;
			}
			tailConnection2.setNextConnection(connection2);
		}
		tailConnection = connection2;
		queue();
	}

	@Override
	public synchronized void queue(@NonNull Invocation invocation) {
		assert invocation.getInterval() == this;
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
		queue();
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("<");
		s.append(intervalIndex);
		s.append("> ");
		int i = 0;
		for (AbstractConnection aConnection = headConnection; aConnection != null; aConnection = aConnection.getNextConnection()) {
			i++;
			if (i > 100) {
				i = 999999;
				break;
			}
		}
		s.append(i);
		s.append(" connections, ");
		int j = 0;
		AbstractInvocationInternal blockedInvocation = blockedInvocations;
		if (blockedInvocation != null) {
			j++;
			while ((blockedInvocation = blockedInvocation.next) != blockedInvocations) {
				if (++j > 100) {
					j = 999999;
					break;
				}
			}
		}
		s.append(j);
		s.append(" blocked, ");
		int k = 0;
		AbstractInvocationInternal waitingInvocation = waitingInvocations;
		if (waitingInvocation != null) {
			k++;
			while ((waitingInvocation = waitingInvocation.next) != waitingInvocations) {
				if (++k > 100) {
					k = 999999;
					break;
				}
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
		queue();
	}
}
