package org.eclipse.qvt.declarative.execution;

import java.io.File;
import java.util.List;

import org.eclipse.qvt.declarative.common.framework.service.ExecutionStrategy;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Service;

/**
 * A service to gather the providers able to run a transformation from a
 * compiled file.
 * 
 * @author Quentin Glineur
 * 
 */
public class ExecutionService extends Service implements ExecutionProvider {

	protected static final ExecutionService INSTANCE = new ExecutionService();

	protected ExecutionService() {
		super();
	}

	/**
	 * Get the execution service singleton
	 * 
	 * @return
	 */
	public static final ExecutionService getInstance() {
		return INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.qvt.declarative.execution.ExecutionProvider#execute(java.
	 * io.File, org.eclipse.qvt.declarative.execution.ExecutionContext)
	 */
	public List<? extends Object> execute(File sourceFile,
			ExecutionContext parameters) {
		Operation operation = new ExecuteOperation(sourceFile, parameters);
		return execute(operation);
	}

	private List<? extends Object> execute(Operation operation) {
		try {
			return execute(ExecutionStrategy.FIRST, operation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
