package org.eclipse.qvtd.cs2as.runtime;

import java.util.List;

import org.eclipse.qvtd.pivot.qvtbase.evaluation.TransformationExecutor;

public interface CS2ASTransformation extends TransformationExecutor {

	public List<EObjectDiagnostic> getErrors();
}
