package org.eclipse.qvt.declarative.execution;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.qvt.declarative.common.framework.service.ExecutionStrategy;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Service;

public class ExecutionService extends Service implements ExecutionProvider {
	
	protected static final ExecutionService INSTANCE = new ExecutionService();
	
	static {
		INSTANCE.registerProviders(Activator.PLUGIN_ID, "executionProvider"); //$NON-NLS-1$
	}
	
	protected ExecutionService() {
		super();
	}
	
	public static final ExecutionService getInstance() {
		return INSTANCE;
	}

	@Override
	public List<? extends Object> execute(IFile sourceFile, ExecutionContext parameters,
			IFolder sourceFolder, IFolder buildFolder) {
		return execute(new ExecuteOperation(sourceFile, parameters, sourceFolder, buildFolder));
	}
	
	private List<? extends Object> execute(Operation operation) {
		try {
			return execute(ExecutionStrategy.FIRST, operation);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
