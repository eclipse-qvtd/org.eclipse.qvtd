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

/**
 * An InvocationManager supervises the invocations of mappings, inhibiting re-executions and
 * maintaining a blocked list of invocations that have failed and a waiting list of invocations
 * ready to be reattempted.
 *
 * @noimplement clients should derive from AbstractInvocationManager
 */
public interface InvocationManager extends ExecutionVisitable
{
	boolean flush();
	@NonNull Interval getDefaultInterval();
}
