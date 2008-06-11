package org.eclipse.qvt.declarative.execution;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.qvt.declarative.common.framework.service.Provider;

public interface ExecutionProvider<M> extends Provider {
	
	public List<? extends Object> execute(IFile sourceFile, ExecutionContext<M> parameters, IFolder sourceFolder, IFolder buildFolder);

}
