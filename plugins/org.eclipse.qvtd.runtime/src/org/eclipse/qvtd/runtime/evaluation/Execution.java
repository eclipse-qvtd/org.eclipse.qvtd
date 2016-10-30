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
import org.eclipse.ocl.pivot.utilities.Nameable;

/**
 * An Execution identifies a unique execution and the objects/values that it uses.
 * Derived EXecutions support Mapping Invocations and unique Function Computations
 *
 * @noimplement clients should derive from AbstractInvocation
 */
public interface Execution extends ExecutionVisitable, Nameable
{
	public interface Incremental extends Execution
	{
		void addReadSlot(SlotState.@NonNull Incremental readSlot);
		@NonNull Iterable<@NonNull Object> getCreatedObjects();
		@Override
		@NonNull String getName();
	}
}