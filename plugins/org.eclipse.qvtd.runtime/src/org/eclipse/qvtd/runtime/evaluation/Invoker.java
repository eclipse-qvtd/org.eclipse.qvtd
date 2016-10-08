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
 * An Invoker marshalls the arguments to invoke a mapping Invocation.
 *
 * @noimplement clients should derive from AbstractInvoker
 */
public interface Invoker extends ExecutionVisitable, Nameable
{
	@NonNull Interval getInterval();

	@NonNull Iterable<@NonNull Invocation> getInvocations();

	void propagate();
}