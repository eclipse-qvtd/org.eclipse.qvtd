package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class QVTiNestedEvaluationEnvironment extends QVTiEvaluationEnvironment
{
	protected final @NonNull QVTiRootEvaluationEnvironment rootEvaluationEnvironment;
	
	public QVTiNestedEvaluationEnvironment(@NonNull IQVTiEvaluationEnvironment evaluationEnvironment) {
		super(evaluationEnvironment);
		rootEvaluationEnvironment = evaluationEnvironment.getRootEvaluationEnvironment();
	}

	public @NonNull Transformation getTransformation() {
		return rootEvaluationEnvironment.getTransformation();
	}

	public @NonNull QVTiRootEvaluationEnvironment getRootEvaluationEnvironment() {
		return rootEvaluationEnvironment;
	}
}
