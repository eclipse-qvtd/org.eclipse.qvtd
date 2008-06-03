package org.eclipse.qvt.declarative.compilation;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Provider;

public class CompileOperation implements Operation {
	
	protected Object abstractSyntaxTree;
	protected Map<String, String> parameters;
	protected IFolder sourceFolder;
	protected IFolder buildFolder;
	
	public CompileOperation(Object abstractSyntaxTree, Map<String, String> parameters, IFolder sourceFolder, IFolder buildFolder) {
		this.abstractSyntaxTree = abstractSyntaxTree;
		this.parameters = parameters;
		this.sourceFolder = sourceFolder;
		this.buildFolder = buildFolder;
	}

	@Override
	public List<IFile> execute(Provider provider) {
		List<IFile> result = null;
		if (provider instanceof CompilationProvider) {
			CompilationProvider compilationProvider = (CompilationProvider) provider;
			result = compilationProvider.compile(abstractSyntaxTree, parameters, sourceFolder, buildFolder);
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

}
