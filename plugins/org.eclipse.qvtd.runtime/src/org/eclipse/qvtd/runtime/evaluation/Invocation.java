/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.ids.IdResolver;

/**
 * An Invocation identifies a unique invocation of a Mapping and the objects/values bound to its guard variables.
 *
 * @noimplement clients should derive from AbstractInvocation
 */
public interface Invocation extends Execution
{
	/**
	 * Execute the mapping invocation, returning true if successfully executed, or false if some predicate failed.
	 * @throws InvocationFailedException if a required memory access could not be performed; a retry when ready is required
	 */
	boolean execute() throws InvocationFailedException;

	@NonNull Interval getInterval();

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

	void unblock();

	public interface Incremental extends Invocation, Execution.Incremental
	{
		void addCreatedObject(@NonNull Object createdObject);
		void addWriteSlot(SlotState.@NonNull Incremental writeSlot);
		@NonNull Object getBoundValue(int index);
		int getBoundValues();
		InvocationConstructor.@NonNull Incremental getConstructor();
		@NonNull Iterable<SlotState.@NonNull Incremental> getReadSlots();
		@NonNull Iterable<SlotState.@NonNull Incremental> getWriteSlots();
	}
}