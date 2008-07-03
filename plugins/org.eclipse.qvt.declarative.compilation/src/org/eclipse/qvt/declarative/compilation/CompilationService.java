package org.eclipse.qvt.declarative.compilation;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.qvt.declarative.common.framework.service.ExecutionStrategy;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Service;

public class CompilationService extends Service implements CompilationProvider {

	protected static final CompilationService INSTANCE = new CompilationService();

	static {
		INSTANCE.registerProviders(Activator.PLUGIN_ID, "compilationProvider"); //$NON-NLS-1$
	}

	protected CompilationService() {
		super();
	}

	public static CompilationService getInstance() {
		return INSTANCE;
	}

	@Override
	public List<File> compile(Object abstractSyntaxTree,
			Map<String, String> parameters, File sourceFolder, File binFolder)
			throws Exception {
		return execute(new CompileOperation(abstractSyntaxTree, parameters,
				sourceFolder, binFolder));
	}

	@SuppressWarnings("unchecked")
	private List<File> execute(Operation operation) throws Exception {
		return (List<File>) execute(ExecutionStrategy.FIRST, operation);
	}

}
