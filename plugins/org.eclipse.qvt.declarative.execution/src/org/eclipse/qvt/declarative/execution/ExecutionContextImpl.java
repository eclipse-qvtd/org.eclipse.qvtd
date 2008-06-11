package org.eclipse.qvt.declarative.execution;

import java.util.List;

public class ExecutionContextImpl<M> implements ExecutionContext<M> {
	
	public static enum ExecutionMode {
		enforcement, checkOnly
	}
	
	protected List<NamedModel<M>> sourceModels;
	protected NamedModel<M> directionModel;
	protected ExecutionMode mode;
	
	public ExecutionContextImpl(List<NamedModel<M>> sourceModels, NamedModel<M> directionModel, ExecutionMode mode) throws IllegalArgumentException{
		super();
		this.sourceModels = sourceModels;
		setDirectionModel(directionModel);
		this.mode = mode;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvt.declarative.execution.ExecutionContext#getDirectionModel()
	 */
	public NamedModel<M> getDirectionModel() {
		return directionModel;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvt.declarative.execution.ExecutionContext#setDirectionModel(M)
	 */
	public void setDirectionModel(NamedModel<M> directionModel) {
		this.directionModel = directionModel;
		
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvt.declarative.execution.ExecutionContext#getMode()
	 */
	public ExecutionMode getMode() {
		return mode;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvt.declarative.execution.ExecutionContext#setMode(org.eclipse.qvt.declarative.execution.AbstractExecutionContext.ExecutionMode)
	 */
	public void setMode(ExecutionMode mode) {
		this.mode = mode;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvt.declarative.execution.ExecutionContext#addModel(M)
	 */
	public void addSourceModel(NamedModel<M> model) {
		sourceModels.add(model);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvt.declarative.execution.ExecutionContext#getModels()
	 */
	public List<NamedModel<M>> getSourceModels() {
		return sourceModels;
	}
	

}
