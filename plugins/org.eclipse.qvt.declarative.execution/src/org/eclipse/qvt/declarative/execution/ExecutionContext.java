package org.eclipse.qvt.declarative.execution;

import java.util.List;

public interface ExecutionContext {
	
	public static enum ExecutionMode {
		enforcement, checkOnly
	}

	public abstract LabelledModel getDirectionModel();

	public abstract void setDirectionModel(LabelledModel directionModel);

	public abstract ExecutionMode getMode();

	public abstract void setMode(ExecutionMode mode);

	public abstract void addSourceModel(LabelledModel model);

	public abstract List<LabelledModel> getSourceModels();

}