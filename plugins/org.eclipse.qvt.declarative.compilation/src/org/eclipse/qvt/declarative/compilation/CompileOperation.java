package org.eclipse.qvt.declarative.compilation;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Provider;
import org.eclipse.qvt.declarative.common.framework.service.ProviderDescriptor;

public class CompileOperation implements Operation {

	protected Object abstractSyntaxTree;
	protected Map<String, String> parameters;
	protected File sourceFolder;
	protected File binFolder;

	public CompileOperation(Object abstractSyntaxTree,
			Map<String, String> parameters, File sourceFolder, File buildFolder) {
		this.abstractSyntaxTree = abstractSyntaxTree;
		this.parameters = parameters;
		this.sourceFolder = sourceFolder;
		this.binFolder = buildFolder;
	}

	@Override
	public List<File> execute(Provider provider) throws Exception {
		List<File> result = null;
		if (provider instanceof ProviderDescriptor) {
			ProviderDescriptor descriptor = (ProviderDescriptor) provider;
			provider = descriptor.getDescribedProvider();
		}
		if (provider instanceof CompilationProvider) {
			CompilationProvider compilationProvider = (CompilationProvider) provider;
			result = compilationProvider.compile(abstractSyntaxTree,
					parameters, sourceFolder, binFolder);

		}
		return result;
	}

	public Object getSource() {
		return abstractSyntaxTree;
	}

	public void setSource(Object source) {
		this.abstractSyntaxTree = source;
	}

	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
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

	public void setBinFolder(File buildFolder) {
		this.binFolder = buildFolder;
	}

}
