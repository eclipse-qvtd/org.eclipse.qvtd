package org.eclipse.qvtd.debug.evaluator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.NamedElement;
import org.eclipse.qvtd.debug.vm.UnitLocation;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.IQVTiEvaluationEnvironment;

public interface IDebugEvaluationEnvironment extends IQVTiEvaluationEnvironment
{
	@NonNull Element getCurrentIP();
	@NonNull UnitLocation getCurrentLocation();
	int getDepth();
	long getID();
	@Nullable NamedElement getOperation();
	@Nullable IDebugEvaluationEnvironment getParentEvaluationEnvironment();
	@NonNull DebugRootEvaluationEnvironment getRootEvaluationEnvironment();
	boolean isDeferredExecution();
	void processDeferredTasks();
	@NonNull Element setCurrentIP(@NonNull Element element);
	void throwQVTException(@NonNull QvtRuntimeException qvtInterruptedExecutionException);
}
