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
import org.eclipse.qvtd.runtime.evaluation.ExecutionVisitor;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.Invoker;

/**
 * An AbstractConnection maintains the values between one or more sources, typically Mappings, that
 * invoke append() and one or more consumers that consume each value.
 *
 * The AbstractConnection may optionally enforce uniqueness on the internal values where the overall
 * application is unable to do so automatically.
 *
 * Incremental update is supported by a revoke() or an append(), or a replace() of an appended value.
 */
public abstract class AbstractConnectionInternal extends ConnectionLinkage implements Connection
{
	protected static final int VALUE_INDEX = 0;
	protected static final int INDEX_INDEX = 1;
	protected static final int COUNT_INDEX = 2;

	protected final boolean debugAppends = AbstractTransformer.APPENDS.isActive();
	protected final @NonNull Interval interval;
	protected final @NonNull String name;
	protected final @NonNull CollectionTypeId typeId;

	/**
	 * The consumers of each appended value.
	 */
	protected final @NonNull List<@NonNull Invoker> consumers = new ArrayList<>();

	/**
	 * The producers of values.
	 */
	protected final @NonNull List<@NonNull Invoker> producers = new ArrayList<>();

	/**
	 * The earlist interval at which a consumer can execute.
	 */
	//	private /*@LazyNonNull*/ Interval earliestInterval = null;

	/**
	 * First VALUE_INDEX entry of each list is the @NonNull Object element value.
	 * Second INDEX_INDEX entry of each list is the @NonNull Integer index within the outer list.
	 * If unique values are maintained the third COUNT_INDEX entry of each list is the number of copies of this value.
	 * Subsequent entries are @NonNull AbstractMapping consumers of the value.
	 * The entry is returned opaquely as a connectionKey to enable append() to return a
	 * key that may subsequently be used by remove() or replace().
	 * Revoked entries are set to null in order to preserve index validity until a cleanup.
	 */
	protected final @NonNull List<@Nullable List<@NonNull Object>> listOfValueAndConsumingInvocations = new ArrayList<>();

	protected AbstractConnectionInternal(@NonNull Interval interval, @NonNull String name, @NonNull CollectionTypeId typeId) {
		this.interval = interval;
		this.name = name;
		this.typeId = typeId;
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitConnection(this);
	}

	@Override
	public void addConsumer(@NonNull Invoker consumer) {
		//		assert listOfValueAndConsumingInvocations.isEmpty() || listOfValueAndConsumingInvocations.get(0).;
		if (!consumers.contains(consumer)) {
			consumers.add(consumer);
			if (!listOfValueAndConsumingInvocations.isEmpty()) {
				queue();
			}
		}
	}

	@Override
	public void addProducer(@NonNull Invoker producer) {
		if (!producers.contains(producer)) {
			producers.add(producer);
		}
	}

	/**
	 * Remove the revoked entries and update the internal indexes accordingly.
	 */
	@Override
	public synchronized void cleanup() {
		int iWrite = 0;
		for (int iRead = 0; iRead < listOfValueAndConsumingInvocations.size(); iRead++) {
			List<@NonNull Object> valueAndConsumingInvocations = listOfValueAndConsumingInvocations.get(iRead);
			if (valueAndConsumingInvocations != null) {
				if (iWrite != iRead) {
					listOfValueAndConsumingInvocations.set(iWrite, valueAndConsumingInvocations);
				}
				valueAndConsumingInvocations.set(INDEX_INDEX, iWrite);
				iWrite++;
			}
		}
	}

	@Override
	public void consume(int elementIndex, @NonNull Invocation invocation) {
		List<@NonNull Object> valueAndConsumingInvocations = listOfValueAndConsumingInvocations.get(elementIndex);
		assert valueAndConsumingInvocations != null;
		assert !valueAndConsumingInvocations.contains(invocation);		// Earlier indexes cannot be the invocation, so no need for a sub-list
		valueAndConsumingInvocations.add(invocation);
		// FIXME empty status if all consumers at final index
		// invocationManager.dequeue(this);
	}

	@Override
	public int getCapacity() {		// not getSize() since some entries may be null.
		return listOfValueAndConsumingInvocations.size();
	}

	@Override
	public @NonNull Iterable<@NonNull Invoker> getConsumers() {
		return consumers;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	@Override
	public @NonNull Iterable<@NonNull Invoker> getProducers() {
		return producers;
	}

	@Override
	public @Nullable Object getValue(int i) {
		List<@NonNull Object> valueAndConsumingInvocations = listOfValueAndConsumingInvocations.get(i);
		return valueAndConsumingInvocations != null ? valueAndConsumingInvocations.get(VALUE_INDEX) : null;
	}

	/*	@Override
	public void insertAfter(@NonNull Interval predecessor) {
		@NonNull AbstractIntervalInternal castPredecessor = (AbstractIntervalInternal)predecessor;
		@NonNull AbstractIntervalInternal successor = castPredecessor.next;
		successor.prev = this;
		next = successor;
		castPredecessor.next = this;
		prev = castPredecessor;
	} */

	/*	@Override
	public void remove() {
		prev.next = next;
		next.prev = prev;
		prev = this;
		next = this;
	} */

	@Override
	public int getValues() {
		return listOfValueAndConsumingInvocations.size();
	}

	@Override
	public void propagate() {
		for (@NonNull Invoker consumer : consumers) {
			consumer.propagate();
		}
	}

	protected void queue() {
		throw new UnsupportedOperationException();
		//		if (nextConnection == this) {
		//			interval.queue(this);
		//		}
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(interval.getIndex());
		s.append(": ");
		s.append(name);
		s.append(" : ");
		s.append(typeId);
		s.append(": ");
		int i = 0;
		for (@NonNull ConnectionLinkage nextConnectionLinkage = nextConnection; nextConnectionLinkage != this; nextConnectionLinkage = nextConnectionLinkage.nextConnection) {
			i++;
		}
		s.append(i);
		return s.toString();
	}
}