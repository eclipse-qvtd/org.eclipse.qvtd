package org.eclipse.qvt.declarative.compilation;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.qvt.declarative.common.framework.service.Provider;

/**
 * An interface to implement by a client who wish to provide a QVT compilation.
 * Generally, such a compilation is coupled with an execution client
 * implementation able to handle the compiled files format.
 * 
 * @author Quentin Glineur
 * 
 */
public interface CompilationProvider extends Provider {

	/**
	 * Create and return a list of executable files from the abstract syntax
	 * tree originated from syntax analysis.
	 * 
	 * @param abstractSyntaxTree
	 *            A representation of the abstract syntax tree.
	 * @param parameters
	 *            A map associating a property name to a string value so that
	 *            the compilation can be parametrized.
	 * @param sourceFolder
	 *            The folder considered as the repository of textual
	 *            transformation (handy for base namespace).
	 * @param binFolder
	 *            The folder considered as the repository of executable
	 *            transformation (where to write the compiled file).
	 * @return The list of file resulting from the compilation.
	 * @throws Exception
	 */
	public List<File> compile(Object abstractSyntaxTree,
			Map<String, String> parameters, File sourceFolder, File binFolder)
			throws Exception;

}
