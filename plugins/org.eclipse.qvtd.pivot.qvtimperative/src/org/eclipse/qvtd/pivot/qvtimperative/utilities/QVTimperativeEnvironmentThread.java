/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentThread;

public abstract class QVTimperativeEnvironmentThread<R> extends AbstractEnvironmentThread<R, @NonNull QVTimperativeEnvironmentFactory, OCLInternal>
{
	protected QVTimperativeEnvironmentThread(@NonNull String threadName, @NonNull QVTimperativeEnvironmentThreadFactory environmentThreadFactory) {
		super(threadName, environmentThreadFactory);
	}
}