package org.eclipse.qvt.declarative.execution;

import java.io.File;
import java.util.List;

import org.eclipse.qvt.declarative.common.framework.service.Provider;

/**
 * An interface to implement by a client who wish to provide a QVT Execution.
 * 
 * @author Quentin Glineur
 */
public interface ExecutionProvider extends Provider {

	/**
	 * Creates and return the result of the execution of the given
	 * transformation.
	 * 
	 * @param executableFile
	 *            The compiled version of the transformation
	 * @param parameters
	 *            An execution context to set runtime transformation parameters
	 * 
	 * @return The result of the transformation
	 */
	public List<? extends Object> execute(File executableFile,
			ExecutionContext parameters);

}
