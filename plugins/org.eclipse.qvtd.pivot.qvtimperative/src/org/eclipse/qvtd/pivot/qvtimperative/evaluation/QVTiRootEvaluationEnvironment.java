/*******************************************************************************
 * Copyright (c) 2014 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.EnvironmentFactoryInternal;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class QVTiRootEvaluationEnvironment extends QVTiEvaluationEnvironment
{
    protected final @NonNull Transformation transformation;

    public QVTiRootEvaluationEnvironment(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull QVTiModelManager modelManager, @NonNull Transformation transformation) {
		super(environmentFactory, modelManager);
		this.transformation = transformation;
	}

	@Override
	public @NonNull QVTiRootEvaluationEnvironment getRootEvaluationEnvironment() {
		return this;
	}

	@Override
	public @NonNull Transformation getTransformation() {
		return transformation;
	}
}
