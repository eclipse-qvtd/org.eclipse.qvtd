package org.eclipse.qvt.declarative.execution;

import java.util.List;

import org.eclipse.qvt.declarative.execution.ExecutionContextImpl.ExecutionMode;

public interface ExecutionContext<M> {

	public abstract NamedModel<M> getDirectionModel();

	public abstract void setDirectionModel(NamedModel<M> directionModel);

	public abstract ExecutionMode getMode();

	public abstract void setMode(ExecutionMode mode);

	public abstract void addSourceModel(NamedModel<M> model);

	public abstract List<NamedModel<M>> getSourceModels();

}