package org.eclipse.qvt.declarative.execution.internal;

import java.util.List;

import org.eclipse.qvt.declarative.execution.ExecutionContext;
import org.eclipse.qvt.declarative.execution.ExecutionContextFactory;
import org.eclipse.qvt.declarative.execution.LabelledModel;
import org.eclipse.qvt.declarative.execution.ExecutionContext.ExecutionMode;

public class ExecutionContextFactoryImpl implements ExecutionContextFactory {

	protected static ExecutionContextFactory INSTANCE = new ExecutionContextFactoryImpl();
	
	protected ExecutionContextFactoryImpl() {
		
	}
	
	public static ExecutionContextFactory getInstance() {
		return INSTANCE;
	}
	
	public ExecutionContext createExecutionContext(
			List<LabelledModel> sourceModels, LabelledModel directionModel,
			ExecutionMode mode) {
		return new ExecutionContextImpl(sourceModels, directionModel, mode);
	}
	

}
