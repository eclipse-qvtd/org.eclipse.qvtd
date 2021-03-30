/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation based on MtcBroker
 ******************************************************************************/
package org.eclipse.qvtd.compiler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentThread.EnvironmentThreadResult;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThread;

public class CompilationResult extends EnvironmentThreadResult<@NonNull ImperativeTransformation, @NonNull QVTimperativeEnvironmentFactory>
{
	public CompilationResult(@NonNull QVTimperativeEnvironmentThread<@NonNull ImperativeTransformation> environmentThread, @NonNull ImperativeTransformation result) {
		super(environmentThread, result);
		assert environmentThread.isSuspended() : "Thread " + environmentThread.getName() + " must be suspended to persist compilation result";
	}
}
