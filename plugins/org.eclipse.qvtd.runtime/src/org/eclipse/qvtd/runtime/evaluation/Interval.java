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
import org.eclipse.ocl.pivot.utilities.Nameable;

/**
 * An Interval identifies one of the scheduler time slots. Invocations associated with one Interval may rely on
 * Invocatuions in earlier intervals completing before they start.
 *
 * @noimplement clients should derive from AbstractInterval
 */
public interface Interval extends ExecutionVisitable, Nameable
{
	boolean flush();

	@NonNull InvocationManager getInvocationManager();

	@Override
	@NonNull String getName();

	void invoke(@NonNull Invocation invocation, boolean doFlush);

	void queue(@NonNull Invocation consumer);

	void unblock(@NonNull Invocation invocation);
}