/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.invocation;

import org.eclipse.jdt.annotation.NonNull;

/**
 * AbstractTransformationTechnology provides the mandatory shared functionality of TransformationTechnology
 * that is to be extended by all TransformationTechnology implementations.
 */
public abstract class AbstractTransformationTechnology implements TransformationTechnology
{
	protected final @NonNull String name;

	protected AbstractTransformationTechnology(@NonNull String name) {
		this.name = name;
	}

	@Override
	public @NonNull String getName() {
		return name;
	}
}
