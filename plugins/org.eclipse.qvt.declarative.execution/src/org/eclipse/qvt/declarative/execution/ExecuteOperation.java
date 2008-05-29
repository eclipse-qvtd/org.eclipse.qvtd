package org.eclipse.qvt.declarative.execution;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Provider;

public class ExecuteOperation implements Operation {

	protected IFile sourceFile;
	protected ExecutionContext parameters;
	protected IFolder sourceFolder;
	protected IFolder buildFolder;

	public ExecuteOperation(IFile sourceFile, ExecutionContext parameters, IFolder sourceFolder, IFolder buildFolder) {
		super();
		this.sourceFile = sourceFile;
		this.parameters = parameters;
		this.sourceFolder = sourceFolder;
		this.buildFolder = buildFolder;
	}

	@Override
	public Object execute(Provider provider) {
		if (provider instanceof ExecutionProvider) {
			ExecutionProvider executionProvider = (ExecutionProvider) provider;
			return executionProvider.execute(sourceFile, parameters, sourceFolder, buildFolder);
		}
		return null;
	}

	public IFolder getSourceFolder() {
		return sourceFolder;
	}

	public void setSourceFolder(IFolder sourceFolder) {
		this.sourceFolder = sourceFolder;
	}

	public IFolder getBuildFolder() {
		return buildFolder;
	}

	public void setBuildFolder(IFolder buildFolder) {
		this.buildFolder = buildFolder;
	}

	public IFile getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(IFile sourceFile) {
		this.sourceFile = sourceFile;
	}

	public ExecutionContext getParameters() {
		return parameters;
	}

	public void setParameters(ExecutionContext parameters) {
		this.parameters = parameters;
	}
	
	

}
