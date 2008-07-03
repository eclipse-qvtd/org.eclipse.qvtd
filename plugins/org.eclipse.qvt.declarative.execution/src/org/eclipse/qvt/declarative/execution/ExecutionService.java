package org.eclipse.qvt.declarative.execution;

import java.io.File;
import java.util.List;

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
	public List<? extends Object> execute(File sourceFile,
			ExecutionContext parameters, File sourceFolder, File binFolder) {
		return execute(new ExecuteOperation(sourceFile, parameters,
				sourceFolder, binFolder));
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
