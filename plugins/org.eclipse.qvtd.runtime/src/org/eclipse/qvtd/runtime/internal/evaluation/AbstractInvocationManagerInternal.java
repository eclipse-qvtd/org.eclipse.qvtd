/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
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
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocationManager;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformer;
import org.eclipse.qvtd.runtime.evaluation.DefaultInterval;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
import com.google.common.collect.Iterables;

/**
 * InvocationManager supervises and provides thread safety for the lists of blocked and waiting invocations.
 */
public abstract class AbstractInvocationManagerInternal extends AbstractInvocationManager
{
	/**
	 * The distinct intervals of the schedule. Wherever possible work for earlier intervals is completed before that
	 * for later intervals.
	 */
	private final @NonNull List<@NonNull Interval> intervals = new ArrayList<>();

	/**
	 * The invokers that create invocations.
	 */
	private final @NonNull List<@NonNull InvocationConstructor> invokers = new ArrayList<>();

	private volatile int nextIndex = Integer.MAX_VALUE;

	protected final @NonNull Executor executor;

	protected AbstractInvocationManagerInternal(@NonNull Executor executor) {
		this.executor = executor;
	}

	@Override
	public void addInvoker(@NonNull InvocationConstructor constructor) {
		assert !invokers.contains(constructor);
		invokers.add(constructor);
	}

	@Override
	public @Nullable Interval basicGetInterval(int intervalIndex) {
		if ((0 <= intervalIndex) && (intervalIndex < intervals.size())) {
			return intervals.get(intervalIndex);
		}
		else {
			return null;
		}
	}

	@Override
	public @NonNull Interval createInterval() {
		Interval interval = new DefaultInterval(this, intervals.size());
		//		intervals.add(interval);
		return interval;
	}

	/*	@Override
	public @NonNull InvocationConstructor createInvoker(@NonNull InvocationConstructor constructor, int consumedConnections, @NonNull Interval interval, @NonNull Connection @NonNull  ... connections) {
		InvocationConstructor invoker;
		if (consumedConnections == 1) {
			invoker = new AbstractInvoker1(interval, constructor, connections[0], Arrays.copyOfRange(connections, 1, connections.length));
		}
		else {
			invoker = new AbstractInvokerN(interval, constructor, Arrays.copyOf(connections, consumedConnections), Arrays.copyOfRange(connections, consumedConnections, connections.length));
		}
		invokers.add(invoker);
		return invoker;
	} */

	public @NonNull Iterable<@NonNull Invocation> debugGetAllInvocations() {
		List<@NonNull Invocation> allInvocations = new ArrayList<>();
		for (@NonNull InvocationConstructor invoker : invokers) {
			Iterables.addAll(allInvocations, invoker.debugGetInvocations());
		}
		return allInvocations;
	}

	@Override
	public void diagnoseWorkLists(@NonNull StringBuilder s) {
		for (@NonNull Interval interval : intervals) {
			interval.diagnoseWorkLists(s);
		}
	}

	@Override
	public boolean flush() {
		for (int index = nextIndex; index < intervals.size(); index = nextIndex) {
			for (int testIndex = 0; testIndex < index; testIndex++) {
				Interval currentInterval = intervals.get(testIndex);
				assert currentInterval.isFlushed();
			}
			nextIndex = index+1;
			Interval currentInterval = intervals.get(index);
			AbstractTransformer.INVOCATIONS.println("--------" + index + "--------");
			currentInterval.flush();				// May set nextIndex back to 'same' or even earlier
		}
		for (@NonNull Interval interval : intervals) {
			if (!interval.isFlushed()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public @NonNull Executor getExecutor() {
		return executor;
	}

	/*	@Override  -- use lazyCreateInterval
	public @NonNull Interval getInterval(int intervalIndex) {
		while (intervals.size() <= intervalIndex) {
			createInterval();
		}
		return intervals.get(intervalIndex);
	} */

	@Override
	public @NonNull Iterable<@NonNull Interval> getIntervals() {
		return intervals;
	}

	@Override
	public int getIntervalsSize() {
		return intervals.size();
	}

	@Override
	public @NonNull Iterable<@NonNull InvocationConstructor> getInvokers() {
		return invokers;
	}

	@Override
	public @NonNull Interval getRootInterval() {
		if (intervals.size() <= 0) {
			createInterval();
		}
		return intervals.get(0);
	}

	@Override
	public @NonNull Interval lazyCreateInterval(int intervalIndex) {
		if (intervalIndex < 0) {
			return createInterval();
		}
		while (intervals.size() <= intervalIndex) {
			createInterval();
		}
		return intervals.get(intervalIndex);
	}

	@Override
	public void setInterval(@NonNull Interval interval) {
		int intervalIndex = interval.getIndex();
		assert intervalIndex <= intervals.size();
		if (intervalIndex == intervals.size()) {
			intervals.add(interval);
		}
		assert interval == intervals.get(intervalIndex);
	}

	//	@Override
	//	public @Nullable Transformer getTransformer() {
	//		return transformer;
	//	}

	@Override
	public void setWorkToDoAt(int intervalIndex) {
		if (intervalIndex < nextIndex) {
			nextIndex = intervalIndex;
		}
	}
}