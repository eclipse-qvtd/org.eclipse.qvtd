package org.eclipse.qvt.declarative.execution;

import java.util.List;

import org.eclipse.qvt.declarative.execution.ExecutionContextImpl.ExecutionMode;

public interface ExecutionContext {

	public abstract Object getDirectionModel();

	public abstract void setDirectionModel(Object directionModel)
			throws IllegalArgumentException;

	public abstract ExecutionMode getMode();

	public abstract void setMode(ExecutionMode mode);

	public abstract void addModel(Object model);

	public abstract List<Object> getModels();

}