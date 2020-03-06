/*******************************************************************************
 * Copyright (c) 2016, 2020 Willink Transformations and others.
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
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.TypeId;

public abstract class AbstractConnection implements Connection
{
	protected final boolean debugAppends = AbstractTransformer.APPENDS.isActive();
	protected final @NonNull Interval interval;
	protected final @NonNull String name;
	protected final @NonNull TypeId typeId;

	/**
	 * The consumers of each appended value.
	 */
	protected final @NonNull List<@NonNull InvocationConstructor> consumers = new ArrayList<>();

	/**
	 * Singly linked list element of connections awaiting propagation from their interval, null when last/unlinked.
	 */
	private @Nullable AbstractConnection nextConnection = null;

	/**
	 * True when this connection is part of the interval's list of connections awaiting propagation.
	 */
	private boolean isQueued = false;

	protected AbstractConnection(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId) {
		this.interval = interval;
		this.name = name;
		this.typeId = typeId;
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitConnection(this);
	}

	@Override
	public boolean addConsumer(@NonNull InvocationConstructor consumer) {
		//		assert listOfValueAndConsumingInvocations.isEmpty() || listOfValueAndConsumingInvocations.get(0).;
		if (!consumers.contains(consumer)) {
			consumers.add(consumer);
			return true;
		}
		return false;
	}

	@Override
	public @NonNull Iterable<@NonNull InvocationConstructor> getConsumers() {
		return consumers;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	public final @Nullable AbstractConnection getNextConnection() {
		return nextConnection;
	}

	@Override
	public @NonNull TypeId getTypeId() {
		return typeId;
	}

	//	@Override
	public boolean isQueued() {
		return isQueued;
	}

	@Override
	public void propagate() {
		for (@NonNull InvocationConstructor consumer : consumers) {
			consumer.propagate();
		}
	}

	@Override
	public final void queue() {
		if (!isQueued) {
			isQueued = true;
			interval.queue(this); // FIXME Use earliest consuming interval; typically one later
		}
	}

	public void resetQueued() {
		isQueued = false;
		this.nextConnection = null;
	}

	public void setNextConnection(@NonNull AbstractConnection nextConnection) {
		assert nextConnection != this;
		//		assert isQueued;
		this.nextConnection = nextConnection;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("<");
		s.append(interval.getIndex());
		s.append(">");
		s.append(name);
		//		s.append(" : ");
		//		s.append(typeId);
		s.append("[");
		try {
			s.append(getCapacity());
		}
		catch (Throwable e) {		// if invoked by debugger during construction
			s.append("?");
		}
		s.append("]");
		return s.toString();
	}
}