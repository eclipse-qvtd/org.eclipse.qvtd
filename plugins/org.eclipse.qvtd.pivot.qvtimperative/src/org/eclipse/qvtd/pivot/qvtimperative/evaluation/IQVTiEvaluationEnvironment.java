package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.evaluation.EvaluationEnvironment;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public interface IQVTiEvaluationEnvironment extends EvaluationEnvironment
{
	@NonNull QVTiModelManager getModelManager();
	@NonNull QVTiRootEvaluationEnvironment getRootEvaluationEnvironment();
	@NonNull Transformation getTransformation();
}
