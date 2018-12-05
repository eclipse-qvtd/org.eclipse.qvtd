/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.utilities.Nameable;

/**
 * An Interval identifies one of the scheduler time slots. Invocations associated with one Interval may rely on
 * Invocatuions in earlier intervals completing before they start.
 *
 * @noimplement clients should derive from AbstractInterval
 */
public interface Interval extends ExecutionVisitable, Nameable
{
	@NonNull Connection createConnection(@NonNull String name, @NonNull TypeId typeId, boolean isStrict, @NonNull ModeFactory modeFactory);

	@Deprecated /* @deprecated provide isIncremental argument */
	@NonNull Connection createConnection(@NonNull String name, @NonNull TypeId typeId, boolean isStrict);

	@Deprecated /* @deprecated provide isIncremental argument */
	Connection.@NonNull Incremental createIncrementalConnection(@NonNull String name, @NonNull TypeId typeId, boolean isStrict);

	void diagnoseWorkLists(@NonNull StringBuilder s);

	boolean flush();

	@NonNull Iterable<@NonNull Connection> getConnections();

	int getIndex();

	@NonNull InvocationManager getInvocationManager();

	@Override
	@NonNull String getName();

	boolean isFlushed();

	void queue(@NonNull Connection connection);

	void queue(@NonNull Invocation consumer);

	void unblock(@NonNull Invocation invocation);
}