package org.eclipse.qvt.declarative.execution;

import java.util.List;

public class ExecutionContextImpl implements ExecutionContext {
	
	public static enum ExecutionMode {
		enforcement, checkOnly
	}
	
	protected List<Object> models;
	protected Object directionModel;
	protected ExecutionMode mode;
	
	public ExecutionContextImpl(List<Object> models, Object directionModel, ExecutionMode mode) throws IllegalArgumentException{
		super();
		this.models = models;
		setDirectionModel(directionModel);
		this.mode = mode;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvt.declarative.execution.ExecutionContext#getDirectionModel()
	 */
	public Object getDirectionModel() {
		return directionModel;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvt.declarative.execution.ExecutionContext#setDirectionModel(M)
	 */
	public void setDirectionModel(Object directionModel) throws IllegalArgumentException{
		if (! models.contains(directionModel)) {
			throw new IllegalArgumentException("Direction model is not part of the models");
		}
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
	public void addModel(Object model) {
		models.add(model);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvt.declarative.execution.ExecutionContext#getModels()
	 */
	public List<Object> getModels() {
		return models;
	}
	

}
