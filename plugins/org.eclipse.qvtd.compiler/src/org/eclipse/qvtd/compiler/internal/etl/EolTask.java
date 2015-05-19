/*******************************************************************************
 * Copyright (c) 2013, 2015 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.etl;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dom.Operation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;


/**
 * The EolTask is used to execute Epsilon Flock scripts in standalone mode.
 */
public class EolTask extends EpsilonTask {
	

	/**
	 * Instantiates a new eol task.
	 *
	 * @param eolSourceURI the eol source uri
	 */
	public EolTask(URI eolSourceURI) {
		super();
		this.sourceURI = eolSourceURI;
		models = new ArrayList<IModel>();
	}

	/* (non-Javadoc)
	 * @see net.sourceforge.riskc.riskc.generator.epsilon.EpsilonStandalone#createModule()
	 */
	@Override
	public EolModule createModule() {
		return new EolModule();
	}
	

	/* (non-Javadoc)
	 * @see net.sourceforge.riskc.riskc.generator.epsilon.EpsilonStandalone#getModels()
	 */
	@Override
	public List<IModel> getModels() {
		return models;
	}
	
	/**
	 * Prepares the EOL engine's environment by parsing the source and loading
	 * the models. This method should be called before invoking {@link #executeOperation(String)}
	 * when invoking specific operations in the EOL source. When using this
	 * method, a call to the {@link close()} method should be made when no
	 * more operations are being executed.
	 *
	 * @throws QvtMtcExecutionException If there are errors parsing the source.
	 */
	public void prepare() throws QvtMtcExecutionException  {
		
		module = createModule();
		try {
			module.parse(sourceURI);
		} catch (Exception e) {
			throw new QvtMtcExecutionException("There was an error loading the source.", e.getCause());
		}
		
		if (module.getParseProblems().size() > 0) {
			StringBuilder sb = new StringBuilder();
			for (ParseProblem problem : module.getParseProblems()) {
				sb.append(problem.toString() + "\\n");
			}
			throw new QvtMtcExecutionException("Parse errors occured: " + sb.toString());
		}
		for (IModel model : getModels()) {
			module.getContext().getModelRepository().addModel(model);
		}
		
	}
	
	/**
	 * When executing specific operations ({@link executeOperation(String)}) 
	 * this this method should be called when no more operations are going to
	 * be invoked in order to store the models and remove them from the context.
	 *
	 * @throws QvtMtcExecutionException the qvt mtc execution exception
	 */
	public void close() throws QvtMtcExecutionException {
		
		for (IModel model : getModels()) {
			if (model.isStoredOnDisposal()) {
				try {
					model.store();
				}
				catch (Exception e) {
					throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
				}
			}
			module.getContext().getModelRepository().removeModel(model);
		}
	}
	
	
	/**
	 * Execute a specific operation, identified by the operationName parameter.
	 * {@link #prepare()} should be invoked (once) before calling this method 
	 * (and the method can then be called repeatedly). The result of executing
	 * the operation in the loaded model(s) is stored in the {@see #result} field.
	 * 	
	 * @param operationName The name of the operation in the EOL source
	 * @throws QvtMtcExecutionException If there was an error executing the operation 
	 */
	public void executeOperation(String operationName) throws QvtMtcExecutionException {
		
		prepare();
		preProcess();
		result = executeOperation(module, operationName);
		postProcess();
	}
	

	/**
	 * Executes the first operation found in the EOL source. To invoke a specific
	 * operation use {@link #executeOperation(IEolExecutableModule, String)}.
	 * The result of the operation will be stored in the result field.
	 *
	 * @throws QvtMtcExecutionException If there was an error executing the operation.
	 */
	public void executeFromFirstOperation() throws QvtMtcExecutionException {
		prepare();
		Operation operation = module.getDeclaredOperations().get(0);
		preProcess();
		try {
			result = operation.execute(null, Collections.EMPTY_LIST, module.getContext());
		} catch (EolRuntimeException e) {
			throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
		}
		postProcess();
		for (IModel model : getModels()) {
			if (model.isStoredOnDisposal()) {
				try {
					model.store();
				}
				catch (Exception e) {
					throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
				}
			}
			module.getContext().getModelRepository().removeModel(model);
		}
	}
	
	/**
	 * Invokes the actual execution of an operation in the EOL source.  
	 *
	 * @param module the module
	 * @param operationName the operation name
	 * @return the object
	 * @throws QvtMtcExecutionException the execution exception
	 */
	private Object executeOperation(IEolExecutableModule module, String operationName) throws QvtMtcExecutionException {
		Operation operation = module.getDeclaredOperations().getOperation(operationName);
		if(operation != null) {
			try {
				return operation.execute(null, Collections.EMPTY_LIST, module.getContext());
			} catch (EolRuntimeException e) {
				e.printStackTrace();
				throw new QvtMtcExecutionException(e.getMessage());
			}
		}
		return null;
	}

}
