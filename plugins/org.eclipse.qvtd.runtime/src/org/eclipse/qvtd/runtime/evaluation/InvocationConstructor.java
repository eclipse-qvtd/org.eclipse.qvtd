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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
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
		void addConsumedConnection(Connection.@NonNull Incremental connection);

		void destroy(AbstractInvocation.@NonNull Incremental incremental, int invocationHashCode);

		@NonNull List<Connection.@NonNull Incremental> getConsumedConnections();

		int nextSequence();
	}

	void addAppendedConnection(@NonNull Connection connection);

	void addConsumedConnection(@NonNull Connection connection);

	@NonNull Iterable<@NonNull Invocation> debugGetInvocations();

	@NonNull Interval getInterval();

	@Override
	@NonNull String getName();

	/**
	 * Invoke the Mapping with the given set of boundValues exactly once.
	 *
	 * If isStrict and a previous invocation exists, no re-invocation occurs.
	 *
	 * If not isStrict or no previous invocation exists, the invocations occurs.
	 *
	 * The InvocationConstructor creator guarantees that isStrict is only true if
	 * duplicate invocations cannot occur.
	 */
	@NonNull Invocation invoke(@NonNull Object @NonNull ... boundValues);

	boolean isStrict();

	void propagate();
}