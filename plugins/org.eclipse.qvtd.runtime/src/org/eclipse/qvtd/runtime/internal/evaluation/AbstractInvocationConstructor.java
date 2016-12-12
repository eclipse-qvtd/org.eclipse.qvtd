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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.ids.IdResolver;
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocation;
import org.eclipse.qvtd.runtime.evaluation.Connection;
import org.eclipse.qvtd.runtime.evaluation.ExecutionVisitor;
import org.eclipse.qvtd.runtime.evaluation.Interval;
import org.eclipse.qvtd.runtime.evaluation.Invocation;
import org.eclipse.qvtd.runtime.evaluation.InvocationConstructor;
import org.eclipse.qvtd.runtime.evaluation.InvocationManager;

public abstract class AbstractInvocationConstructor implements InvocationConstructor
{
	public static abstract class Incremental extends AbstractInvocationConstructor implements InvocationConstructor.Incremental
	{
		protected int sequence = 0;

		/**
		 * List of consumed connections.
		 */
		private final @NonNull List<Connection.@NonNull Incremental> consumedConnections = new ArrayList<>();

		public Incremental(@NonNull InvocationManager invocationManager, @NonNull String name) {
			super(invocationManager, name, true);
		}

		@Override
		public synchronized void addConsumedConnection(Connection.@NonNull Incremental connection) {
			//			assert !consumedConnections.contains(connection);
			consumedConnections.add(connection);
			super.addConsumedConnection(connection);
		}

		@Override
		public @NonNull List<Connection.@NonNull Incremental> getConsumedConnections() {
			return consumedConnections;
		}

		@Override
		protected final @NonNull Invocation newInstance(@NonNull Object @NonNull [] values) {
			throw new IllegalStateException("Incremental invocations require an invocationHashCode.");
		}

		@Override
		public int nextSequence() {
			return sequence++;
		}
	}

	private static abstract class Binder
	{
		/**
		 * The Mapping.ownedParameter index that consumes or appends to the connection.
		 */
		protected final int valueIndex;

		/**
		 * The Connection that provides the values to be consumed.
		 */
		protected final @NonNull Connection connection;

		protected Binder(int valueIndex,  @NonNull Connection connection) {
			this.valueIndex = valueIndex;
			this.connection = connection;
		}
	}

	private static class Appender extends Binder
	{
		/**
		 * Next Appender in linked list of all appenders.
		 */
		private @Nullable Appender nextAppender = null;

		protected Appender(int valueIndex, @NonNull Connection connection) {
			super(valueIndex, connection);
		}

		public void appendAppender(int valueIndex, @NonNull Connection connection) {
			Appender nextAppender2 = nextAppender;
			if (nextAppender2 != null) {
				nextAppender2.appendAppender(valueIndex, connection);
			}
			else {
				nextAppender = new Appender(valueIndex, connection);
			}
		}

		public void propagate(@NonNull Object @NonNull [] values) {
			values[valueIndex] = connection;
			Appender nextAppender2 = nextAppender;
			if (nextAppender2 != null) {
				nextAppender2.propagate(values);
			}
		}

		@Override
		public String toString() {
			return "?/" + valueIndex;
		}
	}

	/**
	 * A Consumer manages the provision of values to be consumed from a Connection
	 * at a Mapping guard parameter.
	 */
	private static class Consumer extends Binder
	{
		protected final @NonNull AbstractInvocationConstructor invocationConstructor;

		/**
		 * The logical AbstractInvocationConstructor.consumers index of this Consumer.
		 */
		protected final int consumerIndex;

		/**
		 * The index of the last value consumed by a previous propagate.
		 */
		private int previouslyConsumedIndex = 0;

		/**
		 * The index of the last value to be consumed by the current propagate.
		 */
		private int targetConsumedIndex = 0;

		/**
		 * The index of the value used by the current invocation of the current propagate.
		 */
		private int currentConsumedIndex = 0;

		/**
		 * Next Consumer in linked list of all consumers.
		 */
		private @Nullable Consumer nextConsumer = null;

		protected Consumer(@NonNull AbstractInvocationConstructor invocationConstructor, int valueIndex, int consumerIndex, @NonNull Connection connection) {
			super(valueIndex, connection);
			this.invocationConstructor = invocationConstructor;
			assert 0 <= consumerIndex;
			assert consumerIndex <= valueIndex;
			this.consumerIndex = consumerIndex;
		}

		public void appendConsumer(int valueIndex, @NonNull Connection connection) {
			assert targetConsumedIndex == 0;
			Consumer nextConsumer2 = nextConsumer;
			if (nextConsumer2 != null) {
				nextConsumer2.appendConsumer(valueIndex, connection);
			}
			else {
				nextConsumer = new Consumer(invocationConstructor, valueIndex, consumerIndex+1, connection);
			}
		}

		public boolean computeWork() {
			targetConsumedIndex = connection.getCapacity();
			boolean hasWork = previouslyConsumedIndex < targetConsumedIndex;
			Consumer nextConsumer2 = nextConsumer;
			if ((nextConsumer2 != null) && nextConsumer2.computeWork()) {
				hasWork = true;
			}
			return hasWork;
		}

		public void didWork() {
			previouslyConsumedIndex = targetConsumedIndex;
			Consumer nextConsumer2 = nextConsumer;
			if (nextConsumer2 != null) {
				nextConsumer2.didWork();
			}
		}

		public void invoked(@NonNull Invocation invocation) {
			if (connection instanceof Connection.Incremental) {
				((Connection.Incremental)connection).consume(currentConsumedIndex, invocation);
			}
			Consumer nextConsumer2 = nextConsumer;
			if (nextConsumer2 != null) {
				nextConsumer2.invoked(invocation);
			}
		}

		/**
		 * Propagate all new values of this and downstream consumers, updating values with prevailing state.
		 * Returns true if one or more invocations were invoked.
		 */
		public boolean propagateHere(int partialConsumerIndex, @NonNull Object @NonNull [] values) {
			boolean didInvoke = false;
			if (partialConsumerIndex < consumerIndex) {
				for (currentConsumedIndex = 0; currentConsumedIndex < targetConsumedIndex; currentConsumedIndex++) {
					didInvoke |= propagateNext(partialConsumerIndex, values);
				}
			}
			else if (partialConsumerIndex == consumerIndex) {
				if (nextConsumer != null) {
					// Offer each old index to downstream new indexes
					for (currentConsumedIndex = 0; currentConsumedIndex < previouslyConsumedIndex; currentConsumedIndex++) {
						Boolean didDownstreamInvoke = propagateNext(partialConsumerIndex+1, values);
						if (didDownstreamInvoke != null) {
							if (!didDownstreamInvoke) {
								break;	// If no downstream new index interested, terminate
							}
							didInvoke = true;
						}
					}
				}
				for (currentConsumedIndex = previouslyConsumedIndex; currentConsumedIndex < targetConsumedIndex; currentConsumedIndex++) {
					didInvoke |= propagateNext(partialConsumerIndex, values);
				}
			}
			else {
				assert false;
			}
			return didInvoke;
		}

		/**
		 * Propagate all new values of downstream consumers, updating values with prevailing state.
		 * Returns true if one or more invocations were invoked.
		 * Returns null if no value to pass downstream.
		 * Returns false if no invocations could be invoked.
		 */
		private @Nullable Boolean propagateNext(int partialConsumerIndex, @NonNull Object @NonNull [] values) {
			Object value = connection.getValue(currentConsumedIndex);
			if (value == null) {			// May be null for incrementally revoked value
				return null;				// doesn't constitute a downstream failure
			}
			values[valueIndex] = value;
			Consumer nextConsumer2 = nextConsumer;
			if (nextConsumer2 != null) {
				return nextConsumer2.propagateHere(partialConsumerIndex, values);
			}
			else {
				Invocation invocation = invocationConstructor.invoke(values);
				invocationConstructor.invoked(invocation);
				return true;
			}
		}

		@Override
		public String toString() {
			return consumerIndex + "/" + valueIndex + " " + previouslyConsumedIndex + "/" + currentConsumedIndex + "/" + targetConsumedIndex;
		}
	}

	protected final @NonNull Interval interval;
	protected final IdResolver.@NonNull IdResolverExtension idResolver;
	protected final @NonNull String name;
	protected final boolean isStrict;

	/**
	 * Map from invocation hashCode to one or more invocations with that hashCode. Single map entries use the
	 * Invocation directly as the entry. Colliding entries use a List<@NonNull Invocation> for the collisions.
	 * <br>
	 * This map is used to inhibit repeated invocations.
	 */
	private final @NonNull Map<@NonNull Integer, @NonNull Object> hashCode2invocations = new HashMap<>();

	/**
	 * Flattened copy of hashCode2invocations.values(). Not maintained until actually requested.
	 */
	//	private /*@LazyNonNull*/ List<@NonNull Invocation> allInvocations = null;

	/**
	 * The number of values required to match the Mapping.ownedParameters.
	 */
	private int valuesCount = 0;

	/**
	 * Linked list of the Consumers to manage each guard parameter.
	 */
	private /*@LazyNonNull*/ Consumer firstConsumer = null;

	/**
	 * Linked list of the Appenders to manage each append parameter.
	 */
	private /*@LazyNonNull*/ Appender firstAppender = null;

	/**
	 * The values passed to the current invocation, one per Mapping.ownedParameter in that order.
	 */
	private @NonNull Object /*@LazyNonNull*/ values[] = null;

	/**
	 * Set true while propagation in progress.
	 */
	private boolean propagating = false;

	/**
	 * Set true if re-entrant propgation inhibited.
	 */
	private boolean repropagate = false;

	protected AbstractInvocationConstructor(@NonNull InvocationManager invocationManager, @NonNull String name, boolean isStrict) {
		this.interval = invocationManager.createInterval();
		Executor executor = invocationManager.getExecutor();
		this.idResolver = (IdResolver.IdResolverExtension)executor.getIdResolver();
		this.name = name;
		this.isStrict = isStrict;
		invocationManager.addInvoker(this);
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitInvocationConstructor(this);
	}

	@Override
	public synchronized void addAppendedConnection(@NonNull Connection connection) {
		assert values == null;
		//		assert oldConsumedIndexes == null;
		//		assert !appendedConnections.contains(connection);
		//		appendedConnections.add(connection);
		connection.addAppender(this);
		if (firstAppender != null) {
			firstAppender.appendAppender(valuesCount, connection);
		}
		else {
			firstAppender = new Appender(valuesCount, connection);
		}
		valuesCount++;
	}

	@Override
	public synchronized void addConsumedConnection(@NonNull Connection connection) {
		assert values == null;
		connection.addConsumer(this);
		if (firstConsumer != null) {
			firstConsumer.appendConsumer(valuesCount, connection);
		}
		else {
			firstConsumer = new Consumer(this, valuesCount, 0, connection);
		}
		connection.queue();
		valuesCount++;
	}

	//	@Override
	public synchronized void destroy(AbstractInvocation.@NonNull Incremental invocation, int invocationHashCode) {
		Object zeroOrMoreInvocations = hashCode2invocations.get(invocationHashCode);
		if (zeroOrMoreInvocations instanceof Invocation) {
			Invocation oneInvocation = (Invocation)zeroOrMoreInvocations;
			if (oneInvocation == invocation) {
				hashCode2invocations.remove(invocationHashCode);
			}
		}
		else if (zeroOrMoreInvocations instanceof List<?>) {
			@SuppressWarnings("unchecked")@NonNull List<@NonNull Invocation> zeroOrMoreInvocations2 = (List<@NonNull Invocation>)zeroOrMoreInvocations;
			zeroOrMoreInvocations2.remove(invocation);
			if (zeroOrMoreInvocations2.size() == 1) {
				hashCode2invocations.put(invocationHashCode, zeroOrMoreInvocations2.get(0));
			}
		}
	}

	@Override
	public @NonNull Interval getInterval() {
		return interval;
	}

	@Override
	public @NonNull Iterable<@NonNull Invocation> debugGetInvocations() {
		List<@NonNull Invocation> allInvocations = new ArrayList<>();
		for (Object zeroOrMoreInvocations : hashCode2invocations.values()) {
			if (zeroOrMoreInvocations instanceof Invocation) {
				allInvocations.add((Invocation)zeroOrMoreInvocations);
			}
			else if (zeroOrMoreInvocations instanceof List<?>) {
				@SuppressWarnings("unchecked")@NonNull List<@NonNull Invocation> zeroOrMoreInvocations2 = (List<@NonNull Invocation>)zeroOrMoreInvocations;
				allInvocations.addAll(zeroOrMoreInvocations2);
			}
		}
		return allInvocations;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}

	/**
	 * Invoke a mapping with the given constructor with a given set of argValues once. This shortform of invokeOnce
	 * should only be used when it is known that recursive invocation is impossible.
	 */
	@Override
	public @NonNull Invocation invoke(@NonNull Object @NonNull ... argValues) {
		Invocation theInvocation;
		if (isStrict) {
			int invocationHashCode = 0;
			for (@NonNull Object argValue : argValues) {
				invocationHashCode = 3 * invocationHashCode + idResolver.oclHashCode(argValue);
			}
			synchronized (hashCode2invocations) {
				Object zeroOrMoreInvocations = hashCode2invocations.get(invocationHashCode);
				Invocation oneInvocation = null;
				List<@NonNull Invocation> twoOrMoreInvocations = null;
				if (zeroOrMoreInvocations instanceof Invocation) {
					oneInvocation = (Invocation)zeroOrMoreInvocations;
					if (oneInvocation.isEqual(idResolver, argValues)) {
						return oneInvocation;
					}
				}
				else if (zeroOrMoreInvocations instanceof List<?>) {
					@SuppressWarnings("unchecked")@NonNull List<@NonNull Invocation> zeroOrMoreInvocations2 = (List<@NonNull Invocation>)zeroOrMoreInvocations;
					twoOrMoreInvocations = zeroOrMoreInvocations2;
					for (@NonNull Invocation anInvocation : zeroOrMoreInvocations2) {
						if (anInvocation.isEqual(idResolver, argValues)) {
							return anInvocation;
						}
					}
				}
				theInvocation = newInstance(invocationHashCode, argValues);
				if (zeroOrMoreInvocations == null) {
					hashCode2invocations.put(invocationHashCode, theInvocation);
				}
				else if (twoOrMoreInvocations == null) {
					twoOrMoreInvocations = new ArrayList<@NonNull Invocation>(4);
					assert oneInvocation != null;
					twoOrMoreInvocations.add(oneInvocation);
					twoOrMoreInvocations.add(theInvocation);
					hashCode2invocations.put(invocationHashCode, twoOrMoreInvocations);
				}
				else {
					twoOrMoreInvocations.add(theInvocation);
				}
			}
		}
		else {
			theInvocation = newInstance(argValues);
		}
		//		if (allInvocations != null) {
		//			allInvocations.add(theInvocation);
		//		}
		interval.queue(theInvocation);
		return theInvocation;
	}

	protected void invoked(@NonNull Invocation invocation) {
		if (firstConsumer != null) {
			firstConsumer.invoked(invocation);
		}
	}

	@Override
	public boolean isStrict() {
		return isStrict;
	}

	/**
	 * Create the mapping instance. In due course, its execute() method is invoked.
	 */
	protected abstract @NonNull Invocation newInstance(@NonNull Object @NonNull [] values);

	/**
	 * Create the mapping instance. In due course, its execute() method is invoked.
	 * Eventually the invocationHashCode may be used to facilitate destroy().
	 */
	protected @NonNull Invocation newInstance(int invocationHashCode, @NonNull Object @NonNull [] values) {
		return newInstance(values);
	}

	@Override
	public void propagate() {
		@NonNull Object[] values2 = values;
		if (values2 == null) {
			synchronized (this) {
				values2 = values;
				if (values2 == null) {
					values2 = values = new @NonNull Object[valuesCount];
					if (firstAppender != null) {
						firstAppender.propagate(values2);
					}
				}
			}
		}
		synchronized (this) {
			if (propagating) {
				repropagate = true;
				return;
			}
			propagating = true;
		}
		do {
			repropagate = false;
			if (firstConsumer.computeWork()) {
				firstConsumer.propagateHere(0, values2);
				firstConsumer.didWork();
			}
		} while (repropagate);
		propagating = false;
	}

	@Override
	public @NonNull String toString() {
		return getName();
	}
}