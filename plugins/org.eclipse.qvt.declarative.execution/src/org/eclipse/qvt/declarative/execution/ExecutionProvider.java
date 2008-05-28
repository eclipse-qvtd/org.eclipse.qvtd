package org.eclipse.qvt.declarative.execution;

import org.eclipse.core.resources.IFile;
import org.eclipse.qvt.declarative.common.Provider;

public interface ExecutionProvider extends Provider {
	
	public String getName();
	
	public Object execute(IFile executable, ExecutionContext parameters);

}
