/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.Nullable;

/**
 * AbstractInvocationManager provides the mandatory shared functionality for a mapping invocation manager.
 * @since 1.1
 */
public abstract class AbstractInvocationManager implements InvocationManager
{

	@Override
	public @Nullable <R> R accept(@NonNull ExecutionVisitor<R> visitor) {
		return visitor.visitInvocationManager(this);
	}
}