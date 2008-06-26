package org.eclipse.qvt.declarative.execution;

import java.util.List;

public class ExecutionContextImpl implements ExecutionContext {

	public static enum ExecutionMode {
		enforcement, checkOnly
	}

	protected List<LabelledModel> sourceModels;
	protected LabelledModel directionModel;
	protected ExecutionMode mode;

	public ExecutionContextImpl(List<LabelledModel> sourceModels,
			LabelledModel directionModel, ExecutionMode mode)
			throws IllegalArgumentException {
		super();
		this.sourceModels = sourceModels;
		setDirectionModel(directionModel);
		this.mode = mode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.qvt.declarative.execution.ExecutionContext#getDirectionModel
	 * ()
	 */
	public LabelledModel getDirectionModel() {
		return directionModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.qvt.declarative.execution.ExecutionContext#setDirectionModel
	 * (M)
	 */
	public void setDirectionModel(LabelledModel directionModel) {
		this.directionModel = directionModel;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.qvt.declarative.execution.ExecutionContext#getMode()
	 */
	public ExecutionMode getMode() {
		return mode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.qvt.declarative.execution.ExecutionContext#setMode(org.eclipse
	 * .qvt.declarative.execution.AbstractExecutionContext.ExecutionMode)
	 */
	public void setMode(ExecutionMode mode) {
		this.mode = mode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.qvt.declarative.execution.ExecutionContext#addModel(M)
	 */
	public void addSourceModel(LabelledModel model) {
		sourceModels.add(model);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.qvt.declarative.execution.ExecutionContext#getModels()
	 */
	public List<LabelledModel> getSourceModels() {
		return sourceModels;
	}

}
