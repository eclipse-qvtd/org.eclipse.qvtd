/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.qvtd.runtime.evaluation.AbstractConnection;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.Connection;
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
public abstract class AbstractIncrementalConnectionInternal extends AbstractConnection implements Connection.Incremental
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
			@SuppressWarnings("unchecked")
			T castValue = (T) valueAndConsumingInvocations.get(VALUE_INDEX);
			return castValue;
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

	protected final boolean debugConsumes = AbstractTransformer.CONSUMES.isActive();

	/**
	 * The appenders of values.
	 */
	protected final @NonNull List<@NonNull InvocationConstructor> appenders = new ArrayList<>();

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

	protected AbstractIncrementalConnectionInternal(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId) {
		super(interval, name, typeId);
	}

	@Override
	public void addAppender(@NonNull InvocationConstructor appender) {
		if (!appenders.contains(appender)) {
			appenders.add(appender);
		}
	}

	@Override
	public boolean addConsumer(@NonNull InvocationConstructor consumer) {
		//		assert listOfValueAndConsumingInvocations.isEmpty() || listOfValueAndConsumingInvocations.get(0).;
		if (!super.addConsumer(consumer)) {
			return false;
		}
		if (!listOfValueAndConsumingInvocations.isEmpty()) {
			queue();
		}
		return true;
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
		//		assert !valueAndConsumingInvocations.contains(invocation);		// Earlier indexes cannot be the invocation, so no need for a sub-list
		valueAndConsumingInvocations.add(invocation);
		// FIXME empty status if all consumers at final index
		// invocationManager.dequeue(this);
		if (debugConsumes) {
			AbstractTransformer.CONSUMES.println(this + " => " + LabelUtil.getLabel(valueAndConsumingInvocations.get(VALUE_INDEX)));
		}
	}

	@Override
	public int debugGetSize() {
		int size = 0;
		for (@Nullable List<@NonNull Object> valueAndConsumingInvocations : listOfValueAndConsumingInvocations) {
			if (valueAndConsumingInvocations != null) {
				size++;
			}
		}
		return size;
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
	public @Nullable Object getValue(int i) {
		List<@NonNull Object> valueAndConsumingInvocations = listOfValueAndConsumingInvocations.get(i);
		return valueAndConsumingInvocations != null ? valueAndConsumingInvocations.get(VALUE_INDEX) : null;
	}

	@Override
	public int getValues() {
		return listOfValueAndConsumingInvocations.size();
	}


	@Override
	public <@NonNull T> @NonNull Iterable<T> typedIterable(Class<T> elementClass) {
		return new Iterable<T>()
		{
			@Override
			public @NonNull Iterator<@NonNull T> iterator() {
				return new ValueIterator<T>();
			}
		};
	}
}