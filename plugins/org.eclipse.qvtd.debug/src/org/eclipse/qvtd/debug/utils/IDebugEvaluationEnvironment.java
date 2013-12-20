package org.eclipse.qvtd.debug.utils;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.pivot.Element;
import org.eclipse.ocl.examples.pivot.Operation;
import org.eclipse.qvtd.debug.stubs.QvtInterruptedExecutionException;
import org.eclipse.qvtd.debug.stubs.QvtRuntimeException;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.IQVTiEvaluationEnvironment;

public interface IDebugEvaluationEnvironment extends IQVTiEvaluationEnvironment
{
	boolean isDeferredExecution();
	void processDeferredTasks();
	IDebugEvaluationEnvironment getParentEvaluationEnvironment();
	@NonNull DebugRootEvaluationEnvironment getRootEvaluationEnvironment();
	@Nullable Operation getOperation();
	@Nullable Element getCurrentIP();
	int getDepth();
	Element setCurrentIP(Element element);
	void throwQVTException(@NonNull QvtRuntimeException qvtInterruptedExecutionException);
}
