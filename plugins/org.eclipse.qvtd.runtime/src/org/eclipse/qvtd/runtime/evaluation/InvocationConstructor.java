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
import org.eclipse.ocl.pivot.utilities.Nameable;

/**
 * An Invocation identifies a unique invocation of a Mapping and the objects/values bound to its guard variables.
 *
 * @noimplement clients should derive from AbstractInvocation
 */
public interface InvocationConstructor extends ExecutionVisitable, Nameable
{
	public interface Incremental extends InvocationConstructor
	{
		int nextSequence();
	}

	void addAppendedConnection(@NonNull Connection connection);

	void addConsumedConection(@NonNull Connection connection);

	/**
	 * Return the first invocation of this constructor with argValues, using newInstance(argValues) to
	 * create a new invocation instance if necessary. Returns null if an instance already created.
	 */
	@Nullable Invocation getFirstInvocation(@NonNull Object @NonNull [] argValues);

	/**
	 * Create the invocation identified by this constructor and values.
	 */
	@NonNull Invocation getInstance(@NonNull Object @NonNull [] values);

	@NonNull Interval getInterval();

	@NonNull Iterable<@NonNull Invocation> getInvocations();

	@Override
	@NonNull String getName();

	void propagate();
}