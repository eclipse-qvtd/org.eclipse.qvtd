package org.eclipse.qvt.declarative.execution;

import java.io.File;

import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Provider;

public class ExecuteOperation implements Operation {

	protected File sourceFile;
	protected ExecutionContext parameters;
	protected File sourceFolder;
	protected File binFolder;

	public ExecuteOperation(File sourceFile, ExecutionContext parameters,
			File sourceFolder, File binFolder) {
		super();
		this.sourceFile = sourceFile;
		this.parameters = parameters;
		this.sourceFolder = sourceFolder;
		this.binFolder = binFolder;
	}

	@Override
	public Object execute(Provider provider) {
		if (provider instanceof ExecutionProvider) {
			ExecutionProvider executionProvider = (ExecutionProvider) provider;
			return executionProvider.execute(sourceFile, parameters,
					sourceFolder, binFolder);
		}
		return null;
	}

	public File getSourceFolder() {
		return sourceFolder;
	}

	public void setSourceFolder(File sourceFolder) {
		this.sourceFolder = sourceFolder;
	}

	public File getBinFolder() {
		return binFolder;
	}

	public void setBinFolder(File binFolder) {
		this.binFolder = binFolder;
	}

	public File getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(File sourceFile) {
		this.sourceFile = sourceFile;
	}

	public ExecutionContext getParameters() {
		return parameters;
	}

	public void setParameters(ExecutionContext parameters) {
		this.parameters = parameters;
	}

}
