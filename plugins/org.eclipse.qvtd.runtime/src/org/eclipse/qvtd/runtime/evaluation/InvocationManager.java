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

import java.lang.reflect.Constructor;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * An InvocationManager supervises the invocations of mappings, inhibiting re-executions and
 * maintaining a blocked list of invocations that have failed and a waiting list of invocations
 * ready to be reattempted.
 * 
 * @since 1.1
 * @noimplement clients should derive from AbstractInvocationManager
 */
public interface InvocationManager extends ExecutionVisitable
{	
    /**
     * Create or reuse the unique occurrence object, created by constructor and parameterized by argValues.
     * @throws ReflectiveOperationException 
     */
	<T extends Occurrence> @NonNull T createFirst(@NonNull Object constructorThis, @NonNull Constructor<? extends T> constructor, @Nullable Object @NonNull [] argValues) throws ReflectiveOperationException;

	boolean flush() throws ReflectiveOperationException;
    void invoke(@NonNull Invocation invocation, boolean doFlush) throws ReflectiveOperationException;
    void unblock(@NonNull Invocation invocation);
}
