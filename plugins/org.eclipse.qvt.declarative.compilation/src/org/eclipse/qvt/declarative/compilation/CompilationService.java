package org.eclipse.qvt.declarative.compilation;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.qvt.declarative.common.framework.service.ExecutionStrategy;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Service;

/**
 * A service to gather the providers able to compile transformation from a its
 * abstract syntax tree.
 * 
 * @author Quentin Glineur
 * 
 */
public class CompilationService extends Service implements CompilationProvider {

	protected static final CompilationService INSTANCE = new CompilationService();

	protected CompilationService() {
		super();
		registerProviders(Activator.getDefault().getBundle().getSymbolicName(), "compilationProvider"); //$NON-NLS-1$
	}

	/**
	 * Get the compilation service singleton.
	 * 
	 * @return the compilation service instance
	 */
	public static CompilationService getInstance() {
		return INSTANCE;
	}

	public List<File> compile(Object abstractSyntaxTree,
			Map<String, String> parameters, List<File> sourceFolders,
			File binFolder) throws Exception {
		return execute(new CompileOperation(abstractSyntaxTree, parameters,
				sourceFolders, binFolder));
	}

	@SuppressWarnings("unchecked")
	private List<File> execute(Operation operation) throws Exception {
		return (List<File>) execute(ExecutionStrategy.FIRST, operation);
	}

}
