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
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class QVTiRootEvaluationEnvironment extends QVTiEvaluationEnvironment
{
    public QVTiRootEvaluationEnvironment(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull Transformation executableObject, @NonNull QVTiModelManager modelManager) {
		super(environmentFactory, executableObject, modelManager);
	}

	@Override
	public @NonNull QVTiRootEvaluationEnvironment getRootEvaluationEnvironment() {
		return this;
	}

	@Override
	public @NonNull Transformation getTransformation() {
		Object executableObject2 = executableObject;
		assert executableObject2 != null;
		return (Transformation) executableObject2;
	}
}
