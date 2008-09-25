package org.eclipse.qvt.declarative.execution;

import java.io.File;

import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Provider;

/**
 * An operation that execute a compiled file.
 * 
 * @author Quentin Glineur
 * 
 */
public class ExecuteOperation implements Operation {

	protected File executableFile;
	protected ExecutionContext parameters;

	/**
	 * Constructs an <code>ExecuteOperation</code> initializing its fields.
	 * 
	 * @param executableFile
	 *            the compiled file to execute
	 * @param parameters
	 *            the execution parameters
	 */
	public ExecuteOperation(File executableFile, ExecutionContext parameters) {
		super();
		this.executableFile = executableFile;
		this.parameters = parameters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.qvt.declarative.common.framework.service.Operation#execute
	 * (org.eclipse.qvt.declarative.common.framework.service.Provider)
	 */
	public Object execute(Provider provider) {
		if (provider instanceof ExecutionProvider) {
			ExecutionProvider executionProvider = (ExecutionProvider) provider;
			return executionProvider.execute(executableFile, parameters);
		}
		return null;
	}

	/**
	 * @return The file whose execution is asked by this operation.
	 */
	public File getExecutableFile() {
		return executableFile;
	}

	/**
	 * @param sourceFile
	 *            The file whose execution is asked by this operation.
	 */
	public void setExecutableFile(File sourceFile) {
		this.executableFile = sourceFile;
	}

	/**
	 * @return The execution parameters.
	 */
	public ExecutionContext getParameters() {
		return parameters;
	}

	/**
	 * @param parameters
	 *            The execution parameters.
	 */
	public void setParameters(ExecutionContext parameters) {
		this.parameters = parameters;
	}

}
