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

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.flock.FlockModule;
import org.eclipse.epsilon.flock.FlockResult;
import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockUnsupportedModelException;

/**
 * The FlockTask is used to execute Epsilon Flock scripts in standalone mode.
 */
public class FlockTask extends EpsilonTask {
	
	/** The original model. */
	private IModel originalModel;
	
	/** The migrated model. */
	private IModel migratedModel;
	
	/**
	 * Instantiates a new flock task.
	 *
	 * @param flockSourceURI the etl source uri
	 */
	public FlockTask(URI flockSourceURI) {
		super();
		this.sourceURI = flockSourceURI;
		models = new ArrayList<IModel>();
	}

	/**
	 * Instantiates a new flock task.
	 *
	 * @param flockSourcePath the etl source path
	 */
	public FlockTask(String flockSourcePath) {
		super();
		this.sourceURI = URI.create(flockSourcePath);
		models = new ArrayList<IModel>();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.etl.EpsilonTask#createModule()
	 */
	@Override
	public IEolExecutableModule createModule() {
		
		return new FlockModule();
	}

	/**
	 * Gets the original model.
	 *
	 * @return the original model
	 */
	public IModel getOriginalModel() {
		return originalModel;
	}

	/**
	 * Sets the original model.
	 *
	 * @param originalModel the new original model
	 */
	public void setOriginalModel(IModel originalModel) {
		this.originalModel = originalModel;
		addModel(originalModel);
	}

	/**
	 * Gets the migrated model.
	 *
	 * @return the migrated model
	 */
	public IModel getMigratedModel() {
		return migratedModel;
	}

	/**
	 * Sets the migrated model.
	 *
	 * @param migratedModel the new migrated model
	 */
	public void setMigratedModel(IModel migratedModel) {
		this.migratedModel = migratedModel;
		addModel(migratedModel);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.etl.EpsilonTask#execute()
	 */
	@Override
	public void execute() throws QvtMtcExecutionException {
		
		module = createModule();
		try {
			module.parse(sourceURI);
		} catch (Exception e) {
			throw new QvtMtcExecutionException("There was an error loading the Flock script.", e.getCause());
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
		
		try {
			((IFlockContext)module.getContext()).setOriginalModel(originalModel);
			((IFlockContext)module.getContext()).setMigratedModel(migratedModel);
		} catch (FlockUnsupportedModelException e) {
			throw new QvtMtcExecutionException(e.getMessage(),e.getCause());
		}
		preProcess();
		try {
			result = module.execute();
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

	@Override
	public void postProcess() {
		// TODO Auto-generated method stub
		super.postProcess();
		((FlockResult)result).printWarnings(System.out);
	}
	
	
	
}
