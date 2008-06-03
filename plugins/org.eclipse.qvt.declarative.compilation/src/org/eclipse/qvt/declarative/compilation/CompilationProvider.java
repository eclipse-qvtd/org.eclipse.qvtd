package org.eclipse.qvt.declarative.compilation;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.qvt.declarative.common.framework.service.Provider;

public interface CompilationProvider extends Provider{
	
	public List<IFile> compile (Object abstractSyntaxTree, Map<String, String> parameters, IFolder sourceFolder, IFolder buildFolder);

}
