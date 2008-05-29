package org.eclipse.qvt.declarative.compilation;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Provider;

public class CompileOperation implements Operation {
	
	protected IAdaptable source;
	protected Map<String, String> parameters;
	protected IFolder sourceFolder;
	protected IFolder buildFolder;
	
	public CompileOperation(IAdaptable source, Map<String, String> parameters, IFolder sourceFolder, IFolder buildFolder) {
		this.source = source;
		this.parameters = parameters;
		this.sourceFolder = sourceFolder;
		this.buildFolder = buildFolder;
	}

	@Override
	public List<IFile> execute(Provider provider) {
		List<IFile> result = null;
		if (provider instanceof CompilationProvider) {
			CompilationProvider compilationProvider = (CompilationProvider) provider;
			result = compilationProvider.compile(source, parameters, sourceFolder, buildFolder);
		}
		return result;
	}

	public IAdaptable getSource() {
		return source;
	}

	public void setSource(IAdaptable source) {
		this.source = source;
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
