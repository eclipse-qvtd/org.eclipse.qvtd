package org.eclipse.qvt.declarative.execution;

import java.util.List;

import org.eclipse.qvt.declarative.execution.ExecutionContext.ExecutionMode;
import org.eclipse.qvt.declarative.execution.internal.ExecutionContextFactoryImpl;

public interface ExecutionContextFactory {
	
	public ExecutionContextFactory INSTANCE = ExecutionContextFactoryImpl.getInstance();
	
	public ExecutionContext createExecutionContext(List<LabelledModel> sourceModels,
			LabelledModel directionModel, ExecutionMode mode);

}
