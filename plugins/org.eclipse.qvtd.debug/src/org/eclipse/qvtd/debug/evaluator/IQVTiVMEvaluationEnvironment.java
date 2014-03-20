package org.eclipse.qvtd.debug.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.evaluator.IVMEvaluationEnvironment;
import org.eclipse.ocl.examples.debug.evaluator.VMRuntimeException;
import org.eclipse.ocl.examples.debug.vm.UnitLocation;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.IQVTiEvaluationEnvironment;

public interface IQVTiVMEvaluationEnvironment extends IQVTiEvaluationEnvironment, IVMEvaluationEnvironment<Transformation>
{
	@NonNull IQVTiEvaluationEnvironment createClonedEvaluationEnvironment();
	@NonNull Element getCurrentIP();
	@NonNull UnitLocation getCurrentLocation();
	@NonNull QVTiVMModelManager getModelManager();
	@Nullable IQVTiVMEvaluationEnvironment getParentEvaluationEnvironment();
	@NonNull QVTiRootVMEvaluationEnvironment getRootEvaluationEnvironment();
	void processDeferredTasks();
	@NonNull Element setCurrentIP(@NonNull Element element);
	void throwQVTException(@NonNull VMRuntimeException qvtInterruptedExecutionException);
}
