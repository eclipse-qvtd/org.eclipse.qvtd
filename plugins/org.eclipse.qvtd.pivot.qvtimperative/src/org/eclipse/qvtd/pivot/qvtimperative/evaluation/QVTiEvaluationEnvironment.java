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
