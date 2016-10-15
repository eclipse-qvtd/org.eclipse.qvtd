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
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.ExecutionVisitor;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;

/**
 * An AbstractConnection maintains the values between one or more sources, typically Mappings, that
 * invoke append() and one or more consumers that consume each value.
 *
 * The AbstractConnection may optionally enforce uniqueness on the internal values where the overall
 * application is unable to do so automatically.
 *
 * Incremental update is supported by a revoke() or an append(), or a replace() of an appended value.
 */
public abstract class AbstractConnectionInternal implements Connection
{
	protected final class ValueIterator<T> implements Iterator<T> {

		private final int size = listOfValueAndConsumingInvocations.size();

		private int cursor = next(0);

		@Override
		public boolean hasNext() {
			return cursor < size;
		}

		@Override
		public @NonNull T next() {
			List<@NonNull Object> valueAndConsumingInvocations = listOfValueAndConsumingInvocations.get(cursor);
			if (valueAndConsumingInvocations == null) {
				throw new NoSuchElementException();
			}
			cursor = next(cursor+1);
			return (T) valueAndConsumingInvocations.get(VALUE_INDEX);
		}

		private int next(int i) {
			while (i < size) {
				if (listOfValueAndConsumingInvocations.get(i) != null) {
					return i;
				}
				i++;
			}
			return size;
		}
	}

	protected static final int VALUE_INDEX = 0;
	protected static final int INDEX_INDEX = 1;
	protected static final int COUNT_INDEX = 2;

	protected final boolean debugAppends = AbstractTransformer.APPENDS.isActive();
	protected final boolean debugConsumes = AbstractTransformer.CONSUMES.isActive();
	protected final @NonNull Interval interval;
	protected final @NonNull String name;
	protected final @NonNull CollectionTypeId typeId;

	/**
	 * Singly linked list element of connections awaiting propagation from their interval, null when last/unlinked.
	 */
	private @Nullable AbstractConnectionInternal nextConnection = null;

	/**
	 * True when this connection is part of the interval's list of connections awaiting propagation.
	 */
	private boolean isQueued = false;

	/**
	 * The consumers of each appended value.
	 */
	protected final @NonNull List<@NonNull InvocationConstructor> consumers = new ArrayList<>();

	/**
	 * The appenders of values.
	 */
	protected final @NonNull List<@NonNull InvocationConstructor> appenders = new ArrayList<>();

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
	public void addAppender(@NonNull InvocationConstructor appender) {
		if (!appenders.contains(appender)) {
			appenders.add(appender);
		}
	}

	@Override
	public void addConsumer(@NonNull InvocationConstructor consumer) {
		//		assert listOfValueAndConsumingInvocations.isEmpty() || listOfValueAndConsumingInvocations.get(0).;
		if (!consumers.contains(consumer)) {
			consumers.add(consumer);
			if (!listOfValueAndConsumingInvocations.isEmpty()) {
				queue();
			}
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
		if (debugConsumes) {
			AbstractTransformer.CONSUMES.println(this + " => " + LabelUtil.getLabel(valueAndConsumingInvocations.get(VALUE_INDEX)));
		}
	}

	@Override
	public @NonNull Iterable<@NonNull InvocationConstructor> getAppenders() {
		return appenders;
	}

	@Override
	public int getCapacity() {		// not getSize() since some entries may be null.
		return listOfValueAndConsumingInvocations.size();
	}

	@Override
	public @NonNull Iterable<@NonNull InvocationConstructor> getConsumers() {
		return consumers;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	final @Nullable AbstractConnectionInternal getNextConnection() {
		return nextConnection;
	}

	@Override
	public @Nullable Object getValue(int i) {
		List<@NonNull Object> valueAndConsumingInvocations = listOfValueAndConsumingInvocations.get(i);
		return valueAndConsumingInvocations != null ? valueAndConsumingInvocations.get(VALUE_INDEX) : null;
	}

	@Override
	public int getValues() {
		return listOfValueAndConsumingInvocations.size();
	}

	@Override
	public void propagate() {
		for (@NonNull InvocationConstructor consumer : consumers) {
			consumer.propagate();
		}
	}

	protected final void queue() {
		if (!isQueued) {
			isQueued = true;
			interval.queue(this);
		}
	}

	void resetQueued() {
		isQueued = false;
		this.nextConnection = null;
	}

	void setNextConnection(@NonNull AbstractConnectionInternal nextConnection) {
		assert nextConnection != this;
		assert isQueued;
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
		s.append(listOfValueAndConsumingInvocations.size());
		s.append("]");
		return s.toString();
	}

	@Override
	public <@NonNull T> @NonNull Iterable<T> typedIterable(Class<T> elementClass) {
		return new Iterable<T>()
		{
			@Override
			public Iterator<@NonNull T> iterator() {
				return new ValueIterator<T>();
			}
		};
	}
}