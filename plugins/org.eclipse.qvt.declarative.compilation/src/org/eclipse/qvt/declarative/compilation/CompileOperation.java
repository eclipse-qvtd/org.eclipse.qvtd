package org.eclipse.qvt.declarative.compilation;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Provider;
import org.eclipse.qvt.declarative.common.framework.service.ProviderDescriptor;

/**
 * An operation that compile a transformation into executable code
 * 
 * @author Quentin Glineur
 * 
 */
public class CompileOperation implements Operation {

	protected Object abstractSyntaxTree;
	protected Map<String, String> parameters;
	protected List<File> sourceFolders;
	protected File binFolder;

	/**
	 * Construct a new compile operation holding the given parameters.
	 * 
	 * @param abstractSyntaxTree
	 * @param parameters
	 * @param sourceFolders
	 * @param buildFolder
	 */
	public CompileOperation(Object abstractSyntaxTree,
			Map<String, String> parameters, List<File> sourceFolders,
			File buildFolder) {
		this.abstractSyntaxTree = abstractSyntaxTree;
		this.parameters = parameters;
		this.sourceFolders = sourceFolders;
		this.binFolder = buildFolder;
	}

	public List<File> execute(Provider provider) throws Exception {
		List<File> result = null;
		if (provider instanceof ProviderDescriptor) {
			ProviderDescriptor descriptor = (ProviderDescriptor) provider;
			provider = descriptor.getDescribedProvider();
		}
		if (provider instanceof CompilationProvider) {
			CompilationProvider compilationProvider = (CompilationProvider) provider;
			result = compilationProvider.compile(abstractSyntaxTree,
					parameters, sourceFolders, binFolder);

		}
		return result;
	}

	/**
	 * Get the transformation targeted by the compilation.
	 * 
	 * @return the transformation
	 */
	public Object getSource() {
		return abstractSyntaxTree;
	}

	/**
	 * Set the transformation targeted by the compilation.
	 * 
	 * @param source
	 *            the transformation on which the compilation should be run on.
	 */
	public void setSource(Object source) {
		this.abstractSyntaxTree = source;
	}

	/**
	 * Get the parameters of the compilation.
	 * 
	 * @return The parameters considered by the compilation process
	 */
	public Map<String, String> getParameters() {
		return parameters;
	}

	/**
	 * Set the parameters of the compilation.
	 * 
	 * @param parameters
	 *            The parameters able to impact the compilation process
	 */
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

	/**
	 * Get the folder set as the base repository for source files and used to
	 * compute the transformation qualified name.
	 * 
	 * @return The source folder.
	 */
	public List<File> getSourceFolders() {
		return sourceFolders;
	}

	/**
	 * Make the operation consider the given folder as the base repository for
	 * source files. The transformation qualified name will be computed
	 * accordingly.
	 * 
	 * @param sourceFolders
	 *            The folder to consider as the base for qualified name
	 *            computation.
	 */
	public void setSourceFolder(List<File> sourceFolders) {
		this.sourceFolders = sourceFolders;
	}

	/**
	 * Get the folder where to store compiled files.
	 * 
	 * @return The binaries folder.
	 */
	public File getBinFolder() {
		return binFolder;
	}

	/**
	 * Make the operation consider the given folder as the base repository for
	 * compiled files.
	 * 
	 * @param binFolder
	 *            The base folder for compiled files.
	 */
	public void setBinFolder(File binFolder) {
		this.binFolder = binFolder;
	}

}
