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
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.qvtd.runtime.internal.evaluation.AbstractConnectionInternal;

/**
 * A SimpleConnection maintains the unique values between one or more sources,
 * typically Mappings, that invoke append() and one or more consumers that consume each value.
 *
 * It is assumed that the overall application enforces unqiueness externally if uniqueness of values is required.
 * Use StrictConnection to enforce uniqueness internally.
 *
 * Incremental update is not supported.
 */
public class SimpleConnection extends AbstractConnectionInternal
{
	public SimpleConnection(@NonNull Interval interval, @NonNull String name, @NonNull TypeId typeId) {
		super(interval, name, typeId);
	}
}