package org.eclipse.qvt.declarative.execution;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.qvt.declarative.common.framework.service.Provider;

/**
 * An interface to implement by a client who wish to provide a QVT Execution.
 * 
 * @author Quentin Glineur
 */
public interface ExecutionProvider extends Provider {

	//TODO API change to consider directly the executable and not the source (do it in the builder)
	/**
	 * Creates and return the result of the execution of the given transformation.
	 * @param sourceFile The textual representation of the transformation
	 * @param parameters An execution context to set runtime transformation parameters
	 * @param sourceFolder The root folder of transformation source file
	 * @param buildFolder The root folder of executable files
	 * @return The result of the transformation
	 */
	public List<? extends Object> execute(IFile sourceFile,
			ExecutionContext parameters, IFolder sourceFolder,
			IFolder buildFolder);

}
