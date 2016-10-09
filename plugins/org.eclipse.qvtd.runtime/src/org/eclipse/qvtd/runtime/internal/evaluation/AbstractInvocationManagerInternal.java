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
package org.eclipse.qvtd.runtime.internal.evaluation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.runtime.evaluation.AbstractInvocationManager;
import org.eclipse.qvtd.runtime.evaluation.Interval;

/**
 * InvocationManager supervises and provides thread safety for the lists of blocked and waiting invocations.
 */
public class AbstractInvocationManagerInternal extends AbstractInvocationManager
{
	/**
	 * The distinct intervals of the schedule. Wherever possible work for earlier intervals is completed before that
	 * for later intervals.
	 */
	private final @NonNull List<@NonNull Interval> intervals = new ArrayList<>();


	private /*@LazyNonNull*/ Interval defaultInterval = null;

	@Override
	public @NonNull Interval createInterval() {
		assert defaultInterval == null;
		Interval interval = new AbstractIntervalInternal(this, intervals.size()) {};
		intervals.add(interval);
		return interval;
	}

	@Override
	public boolean flush() {
		return getDefaultInterval().flush();
	}

	@Override
	public @NonNull Interval getDefaultInterval() {
		Interval defaultInterval2 = defaultInterval;
		if (defaultInterval2  == null) {
			defaultInterval2 = defaultInterval = createInterval();
		}
		return defaultInterval2;
	}
}