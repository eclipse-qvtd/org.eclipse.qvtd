/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.internal.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.evaluation.Executor;

/**
 * InvocationManager supervises and provides thread safety for the lists of blocked and waiting invocations.
 */
public class IncrementalInvocationManager extends AbstractInvocationManagerInternal
{
	public IncrementalInvocationManager(@NonNull Executor executor) {
		super(executor);
	}
}