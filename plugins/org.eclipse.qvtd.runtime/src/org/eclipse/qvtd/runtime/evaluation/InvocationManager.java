/*******************************************************************************
 * Copyright (c) 2013, 2017 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.evaluation.Executor;

/**
 * An InvocationManager supervises the invocations of mappings, inhibiting re-executions and
 * maintaining a blocked list of invocations that have failed and a waiting list of invocations
 * ready to be reattempted.
 *
 * @noimplement clients should derive from AbstractInvocationManager
 */
public interface InvocationManager extends ExecutionVisitable
{
	void addInvoker(@NonNull InvocationConstructor constructor);
	@Nullable Interval basicGetInterval(int intervalIndex);
	@NonNull Interval createInterval();
	void diagnoseWorkLists(@NonNull StringBuilder s);
	boolean flush();
	@NonNull Executor getExecutor();
	@NonNull Iterable<@NonNull Interval> getIntervals();
	int getIntervalsSize();
	@NonNull Iterable<@NonNull InvocationConstructor> getInvokers();
	@NonNull Interval getRootInterval();
	//	@Nullable Transformer getTransformer();
	@NonNull Interval lazyCreateInterval(int intervalIndex);
	void setInterval(@NonNull Interval interval);
	void setWorkToDoAt(int intervalIndex);
}
