/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NamedElement;
import org.eclipse.ocl.pivot.internal.evaluation.BasicEvaluationEnvironment;
import org.eclipse.ocl.pivot.internal.utilities.EnvironmentFactoryInternal;

public abstract class QVTiEvaluationEnvironment extends BasicEvaluationEnvironment implements IQVTiEvaluationEnvironment
{
	protected QVTiEvaluationEnvironment(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull NamedElement executableObject, @NonNull QVTiModelManager modelManager) {
		super(environmentFactory, executableObject, modelManager);
	}

	protected QVTiEvaluationEnvironment(@NonNull IQVTiEvaluationEnvironment evaluationEnvironment, @NonNull NamedElement executableObject) {
		super(evaluationEnvironment, executableObject);
	}

	@Override
	public @NonNull QVTiModelManager getModelManager() {
		return (QVTiModelManager) modelManager;
	}

	public @Nullable IQVTiEvaluationEnvironment getParentEvaluationEnvironment() {
		return (IQVTiEvaluationEnvironment) parent;
	}
}
