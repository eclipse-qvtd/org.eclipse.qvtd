package org.eclipse.qvtd.pivot.qvtimperative.evaluation;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.manager.MetaModelManager;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;

public class QVTiRootEvaluationEnvironment extends QVTiEvaluationEnvironment
{
    protected final @NonNull Transformation transformation;

//    public QVTiRootEvaluationEnvironment(@NonNull MetaModelManager metaModelManager) {
//		super(metaModelManager);
//	}

    public QVTiRootEvaluationEnvironment(@NonNull MetaModelManager metaModelManager, @NonNull Transformation transformation) {
		super(metaModelManager);
		this.transformation = transformation;
	}

	public @NonNull QVTiRootEvaluationEnvironment getRootEvaluationEnvironment() {
		return this;
	}

	public @NonNull Transformation getTransformation() {
		return transformation;
	}
}
