package org.eclipse.qvt.declarative.execution;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.qvt.declarative.common.framework.service.Provider;

public interface ExecutionProvider extends Provider {
	
	public String getName();
	
	public Object execute(IFile sourceFile, ExecutionContext parameters, IFolder sourceFolder, IFolder buildFolder);

}
