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
import org.eclipse.ocl.examples.pivot.evaluation.PivotEvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public abstract class QVTiEvaluationEnvironment extends PivotEvaluationEnvironment implements IQVTiEvaluationEnvironment
{
	protected final @NonNull QVTiModelManager modelManager;
	
	protected QVTiEvaluationEnvironment(@NonNull MetaModelManager metaModelManager, @NonNull QVTiModelManager modelManager) {
		super(metaModelManager);
		this.modelManager = modelManager;
	}

	protected QVTiEvaluationEnvironment(@NonNull IQVTiEvaluationEnvironment evaluationEnvironment) {
		super(evaluationEnvironment);
		this.modelManager = evaluationEnvironment.getModelManager();
	}

	public @NonNull QVTiModelManager getModelManager() {
		return modelManager;
	}

	public @Nullable IQVTiEvaluationEnvironment getParentEvaluationEnvironment() {
		return (IQVTiEvaluationEnvironment) parent;
	}
}
