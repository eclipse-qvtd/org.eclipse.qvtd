package org.eclipse.qvt.declarative.compilation;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.qvt.declarative.common.framework.service.ExecutionStrategy;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Service;

public class CompilationService extends Service implements CompilationProvider {
	
	protected static final CompilationService instance = new CompilationService();
	
	static {
		instance.registerProviders(Activator.PLUGIN_ID, "org.eclipse.qvt.declarative.compiler_provider"); //$NON-NLS-1$
	}
	
	protected CompilationService() {
		super();
	}
	
	public CompilationService getInstance() {
		return instance;
	}

	@Override
	public List<IFile> compile(Object abstractSyntaxTree,
			Map<String, String> parameters, IFolder sourceFolder,
			IFolder buildFolder) {
		return execute(new CompileOperation(abstractSyntaxTree, parameters, sourceFolder, buildFolder));
	}

	@SuppressWarnings("unchecked")
	private List<IFile> execute(Operation operation) {
		return (List<IFile>) execute(ExecutionStrategy.FIRST, operation);
	}
	
	
}
