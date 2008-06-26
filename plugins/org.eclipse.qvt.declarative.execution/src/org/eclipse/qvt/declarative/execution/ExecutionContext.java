package org.eclipse.qvt.declarative.execution;

import java.util.List;

import org.eclipse.qvt.declarative.execution.ExecutionContextImpl.ExecutionMode;

public interface ExecutionContext {

	public abstract LabelledModel getDirectionModel();

	public abstract void setDirectionModel(LabelledModel directionModel);

	public abstract ExecutionMode getMode();

	public abstract void setMode(ExecutionMode mode);

	public abstract void addSourceModel(LabelledModel model);

	public abstract List<LabelledModel> getSourceModels();

}