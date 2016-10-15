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

		public Incremental(@NonNull InvocationManager invocationManager, @NonNull String name, boolean isStrict) {
			super(invocationManager, name, isStrict);
		}

		public void connect(@NonNull Connection @Nullable [] consumedConnections, @NonNull Connection @Nullable [] appendedConnections) {
			if (consumedConnections != null) {
				for (@NonNull Connection consumedConnection : consumedConnections) {
					consumedConnection.addConsumer(this);
					addConsumedConection(consumedConnection);
				}
			}
			if (appendedConnections != null) {
				for (@NonNull Connection appendedConnection : appendedConnections) {
					appendedConnection.addAppender(this);
					addAppendedConnection(appendedConnection);
				}
			}
		}

		@Override
		public int nextSequence() {
			return sequence++;
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
	private /*@LazyNonNull*/ List<@NonNull Invocation> allInvocations = null;

	private final @NonNull List<@NonNull Connection> consumedConnections = new ArrayList<>();
	private final @NonNull List<@NonNull Connection> appendedConnections = new ArrayList<>();
	private int /*@LazyNonNull*/ [] oldConsumedIndexes = null;

	protected AbstractInvocationConstructor(@NonNull InvocationManager invocationManager, @NonNull String name, boolean isStrict) {
		this.interval = invocationManager.createInterval();
		Executor executor = invocationManager.getExecutor();
		this.idResolver = (IdResolver.IdResolverExtension)executor.getIdResolver();	// FIXME null Transformer
		this.name = name;
		this.isStrict = isStrict;
		invocationManager.addInvoker(this);
	}

	@Override
	public <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitInvocationConstructor(this);
	}

	protected void addAppendedConnection(@NonNull Connection connection) {
		assert oldConsumedIndexes == null;
		assert !appendedConnections.contains(connection);
		appendedConnections.add(connection);
	}

	@Override
	public void addConsumedConection(@NonNull Connection connection) {
		assert !consumedConnections.contains(connection);
		consumedConnections.add(connection);
	}

	@Override
	public @NonNull Interval getInterval() {
		return interval;
	}

	@Override
	public @NonNull Iterable<@NonNull Invocation> getInvocations() {
		List<@NonNull Invocation> allInvocations2 = allInvocations;
		if (allInvocations2 == null) {
			allInvocations2 = allInvocations = new ArrayList<>();
			for (Object zeroOrMoreInvocations : hashCode2invocations.values()) {
				if (zeroOrMoreInvocations instanceof Invocation) {
					allInvocations2.add((Invocation)zeroOrMoreInvocations);
				}
				else if (zeroOrMoreInvocations instanceof List<?>) {
					@SuppressWarnings("unchecked")@NonNull List<@NonNull Invocation> zeroOrMoreInvocations2 = (List<@NonNull Invocation>)zeroOrMoreInvocations;
					allInvocations2.addAll(zeroOrMoreInvocations2);
				}
			}
		}
		return allInvocations2;
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
			int hashCode = 0;
			for (@Nullable Object argValue : argValues) {
				hashCode = 3 * hashCode + idResolver.oclHashCode(argValue);
			}
			synchronized (hashCode2invocations) {
				Object zeroOrMoreInvocations = hashCode2invocations.get(hashCode);
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
				theInvocation = newInstance(argValues);
				if (zeroOrMoreInvocations == null) {
					hashCode2invocations.put(hashCode, theInvocation);
				}
				else if (twoOrMoreInvocations == null) {
					twoOrMoreInvocations = new ArrayList<@NonNull Invocation>(4);
					assert oneInvocation != null;
					twoOrMoreInvocations.add(oneInvocation);
					twoOrMoreInvocations.add(theInvocation);
					hashCode2invocations.put(hashCode, twoOrMoreInvocations);
				}
				else {
					twoOrMoreInvocations.add(theInvocation);
				}
			}
		}
		else {
			theInvocation = newInstance(argValues);
		}
		if (allInvocations != null) {
			allInvocations.add(theInvocation);
		}
		interval.queue(theInvocation);
		return theInvocation;
	}

	@Override
	public boolean isStrict() {
		return isStrict;
	}

	/**
	 * Create the mapping instance. In due course, its execute() method is invoked.
	 */
	protected abstract @NonNull Invocation newInstance(@NonNull Object @NonNull [] values);

	@Override
	public void propagate() {
		int consumedConnectionsSize = consumedConnections.size();
		if (oldConsumedIndexes == null) {
			oldConsumedIndexes = new int[consumedConnectionsSize];
			for (int i = 0; i < consumedConnectionsSize; i++) {
				oldConsumedIndexes[i] = 0;
			}
		}
		int @NonNull [] newConsumedIndexes = new int[consumedConnectionsSize];
		boolean hasWork = false;
		for (int i = 0; i < consumedConnectionsSize; i++) {
			Connection consumedConnection = consumedConnections.get(i);
			newConsumedIndexes[i] = consumedConnection.getCapacity();
			if (newConsumedIndexes[i] > oldConsumedIndexes[i]) {
				hasWork = true;
			}
		}
		if (hasWork) {
			int appendedConnectionsSize = appendedConnections.size();
			@NonNull Object @NonNull [] boundValues = new @NonNull Object[consumedConnectionsSize + appendedConnectionsSize];
			for (int i = 0; i < appendedConnectionsSize; i++) {
				boundValues[consumedConnectionsSize+i] = appendedConnections.get(i);
			}
			int @NonNull [] consumeIndexes = new int[consumedConnectionsSize];
			propagate(0, newConsumedIndexes, consumeIndexes, boundValues);
			for (int i = 0; i < consumedConnectionsSize; i++) {
				oldConsumedIndexes[i] = newConsumedIndexes[i];
			}
		}
	}
	private void propagate(int depth, int @NonNull [] newConsumedIndexes, int @NonNull [] consumeIndexes, @NonNull Object @NonNull [] boundValues) {
		int consumedConnectionsSize = consumedConnections.size();
		if (depth < consumedConnectionsSize) {
			Connection consumedConnection = consumedConnections.get(depth);
			for (int i = oldConsumedIndexes[depth]; i < newConsumedIndexes[depth]; i++) {
				consumeIndexes[depth] = i;
				Object value = consumedConnection.getValue(i);
				if (value != null) {				// Revoked value may be null.
					boundValues[depth] = value;
					propagate(depth+1, newConsumedIndexes, consumeIndexes, boundValues);
				}
			}
		}
		else {
			Invocation mappingInstance = invoke(boundValues);
			for (int i = 0; i < consumedConnectionsSize; i++) {
				Connection consumedConnection = consumedConnections.get(i);
				consumedConnection.consume(consumeIndexes[i], mappingInstance);
			}
		}
	}

	@Override
	public @NonNull String toString() {
		return getName();
	}
}