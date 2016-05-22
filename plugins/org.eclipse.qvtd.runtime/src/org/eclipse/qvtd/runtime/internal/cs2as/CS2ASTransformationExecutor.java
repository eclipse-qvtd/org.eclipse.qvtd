/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.runtime.internal.cs2as;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.runtime.evaluation.AbstractTransformationExecutor;

public class CS2ASTransformationExecutor extends AbstractTransformationExecutor {

	public CS2ASTransformationExecutor(@NonNull EnvironmentFactory environmentFactory,
			@NonNull Class<? extends CS2ASTransformer> txClass)
					throws ReflectiveOperationException {
		super(environmentFactory, txClass);
	}

	@Override
	public @NonNull CS2ASTransformer getTransformer() {
		return (CS2ASTransformer) super.getTransformer();
	}
}
