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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.EnvironmentFactoryInternal;
import org.eclipse.ocl.pivot.internal.evaluation.PivotEvaluationEnvironment;

public abstract class QVTiEvaluationEnvironment extends PivotEvaluationEnvironment implements IQVTiEvaluationEnvironment
{
	protected final @NonNull QVTiModelManager modelManager;
	
	protected QVTiEvaluationEnvironment(@NonNull EnvironmentFactoryInternal environmentFactory, @NonNull QVTiModelManager modelManager) {
		super(environmentFactory);
		this.modelManager = modelManager;
	}

	protected QVTiEvaluationEnvironment(@NonNull IQVTiEvaluationEnvironment evaluationEnvironment) {
		super(evaluationEnvironment);
		this.modelManager = evaluationEnvironment.getModelManager();
	}

	@Override
	public @NonNull QVTiModelManager getModelManager() {
		return modelManager;
	}

	public @Nullable IQVTiEvaluationEnvironment getParentEvaluationEnvironment() {
		return (IQVTiEvaluationEnvironment) parent;
	}
}
