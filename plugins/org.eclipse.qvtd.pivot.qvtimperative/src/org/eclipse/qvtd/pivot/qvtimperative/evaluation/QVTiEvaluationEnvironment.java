package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.evaluation.PivotEvaluationEnvironment;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;

public abstract class QVTiEvaluationEnvironment extends PivotEvaluationEnvironment implements IQVTiEvaluationEnvironment
{
	protected QVTiEvaluationEnvironment(@NonNull MetaModelManager metaModelManager) {
		super(metaModelManager);
	}

	protected QVTiEvaluationEnvironment(@NonNull IQVTiEvaluationEnvironment evaluationEnvironment) {
		super(evaluationEnvironment);
	}

	public @Nullable IQVTiEvaluationEnvironment getParentEvaluationEnvironment() {
		return (IQVTiEvaluationEnvironment) parent;
	}
}
