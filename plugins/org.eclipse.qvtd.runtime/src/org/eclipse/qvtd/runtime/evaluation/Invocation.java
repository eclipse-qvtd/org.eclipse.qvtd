/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.ids.IdResolver;

/**
 * An Invocation identifies a unique invocation of a Mapping and the objects/values bound to its guard variables.
 *
 * @noimplement clients should derive from AbstractInvocation
 */
public interface Invocation extends ExecutionVisitable
{
	/**
	 * Execute the mapping invocation, returning true if successfully executed, or false if some predicate failed.
	 * @throws InvocationFailedException if a required memory access could not be performed; a retry when ready is required
	 */
	boolean execute() throws InvocationFailedException;

	/**
	 * Insert this Invocation following predecessor, which may be in the blocked or waiting invocations linked list.
	 */
	void insertAfter(@NonNull Invocation predecessor);

	/**
	 * Return true if an occurrence with thoseValues would be a re-occurrence.
	 */
	boolean isEqual(@NonNull IdResolver idResolver, @NonNull Object @NonNull [] thoseValues);


	/**
	 * Remove this Invocation from the blocked or waiting invocations linked list.
	 */
	void remove();

	public interface Constructor
	{
		/**
		 * Return the first invocation of this constructor with argValues, using newInstance(argValues) to
		 * create a new invocation instance if necessary. Returns null if an instance already created.
		 */
		@Nullable Invocation getFirstInvocation(@NonNull Object @NonNull [] argValues);

		/**
		 * Create the invocation identified by this constructor and values.
		 */
		@NonNull Invocation newInstance(@NonNull Object @NonNull [] values);
	}

	public interface Incremental extends Invocation
	{
		void addCreatedObject(@NonNull Object createdObject);
		void addReadSlot(SlotState.@NonNull Incremental readSlot);
		void addWriteSlot(SlotState.@NonNull Incremental writeSlot);
		@NonNull Iterable<@NonNull Object> getCreatedObjects();
		@NonNull Iterable<SlotState.@NonNull Incremental> getReadSlots();
		@NonNull Iterable<SlotState.@NonNull Incremental> getWriteSlots();
		//		void invalidate();
	}
}