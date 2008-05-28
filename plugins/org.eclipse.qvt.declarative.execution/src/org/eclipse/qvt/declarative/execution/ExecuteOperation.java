package org.eclipse.qvt.declarative.execution;

import org.eclipse.core.resources.IFile;
import org.eclipse.qvt.declarative.common.Operation;
import org.eclipse.qvt.declarative.common.Provider;

public class ExecuteOperation implements Operation {

	protected IFile sourceFile;
	protected ExecutionContext parameters;

	public ExecuteOperation(IFile sourceFile, ExecutionContext parameters) {
		super();
		this.sourceFile = sourceFile;
		this.parameters = parameters;
	}

	@Override
	public Object execute(Provider provider) {
		if (provider instanceof ExecutionProvider) {
			ExecutionProvider executionProvider = (ExecutionProvider) provider;
			return executionProvider.execute(sourceFile, parameters);
		}
		return null;
	}

	public IFile getExecutable() {
		return sourceFile;
	}

	public void setExecutable(IFile executable) {
		this.sourceFile = executable;
	}

	public ExecutionContext getParameters() {
		return parameters;
	}

	public void setParameters(ExecutionContext parameters) {
		this.parameters = parameters;
	}
	
	

}
