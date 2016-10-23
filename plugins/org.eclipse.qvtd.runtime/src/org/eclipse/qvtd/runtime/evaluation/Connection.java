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
package org.eclipse.qvtd.runtime.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.Nameable;

/**
 * A Connection maintains the values between one or more sources, typically Mappings, that
 * invoke append() and one or more consumers that consume each value.
 *
 * The AbstractConnection may optionally enforce uniqueness on the internal values where the overall
 * application is unable to do so automatically.
 *
 * Incremental update is supported by a revoke() or an append(), or a replace() of an appended value.
 *
 * @noimplement clients should derive from AbstractConnection
 */
public interface Connection extends ExecutionVisitable, Nameable
{
	public interface Incremental extends Connection
	{
		void check();

		/**
		 * Remove the revoked entries and update the internal indexes accordingly.
		 */
		void cleanup();

		void consume(int elementIndex, @NonNull Invocation mapping);

		@NonNull Iterable<@NonNull InvocationConstructor> getAppenders();

		/**
		 * Replace the old value at connectionKey by newValue.
		 *
		 * If the old value is a multiple value in a unique value connection, the multi-value count is decremented
		 * and a new entry created for the newValue by delegating to append to enforce uniqueness of the newValue.
		 *
		 * Otherwise the old value is removed, its consumingInvocations are invalidated
		 * so that they recompute with the newValue which replaces the old.
		 */
		@NonNull Object replace(@NonNull Object connectionKey, @NonNull Object newValue);

		/**
		 * Revoke, inverse append, the old value at connectionKey.
		 *
		 * If the old value is a multiple value in a unique value connection, the multi-value count is decremented.
		 *
		 * Otherwise the old value is removed, its consumingInvocations are revoked
		 * so that their appends are also revoked.
		 */
		void revoke(@NonNull Object connectionKey);
	}

	void addAppender(@NonNull InvocationConstructor appendingInvoker);

	boolean addConsumer(@NonNull InvocationConstructor consumingInvoker);

	/**
	 * Append aValue to the contents, enforcing uniqueness if necessary, and waking up the overall
	 * connection manager to schedule a propagate() to consumers when convenient.
	 *
	 * Return the new entry.
	 */
	@NonNull Object append(@NonNull Object aValue);

	int getCapacity();

	@NonNull Iterable<@NonNull InvocationConstructor> getConsumers();

	@Nullable Object getValue(int i);

	int getValues();

	void propagate();

	<@NonNull T> @NonNull Iterable<T> typedIterable(Class<T> elementClass);
}