/*******************************************************************************
 * Copyright (c) 2013 The University of York, Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Horacio Hoyos - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.build.etl;

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
import org.eclipse.ocl.examples.pivot.IteratorExp;

public class FlockTask extends EpsilonTask {
	
	private IModel originalModel;
	private IModel migratedModel;
	
	public FlockTask(URI etlSourceURI) {
		super();
		this.sourceURI = etlSourceURI;
		models = new ArrayList<IModel>();
	}

	public FlockTask(String etlSourcePath) {
		super();
		this.sourceURI = URI.create(etlSourcePath);
		models = new ArrayList<IModel>();
	}
	
	@Override
	public IEolExecutableModule createModule() {
		// TODO Auto-generated method stub
		return new FlockModule();
	}

	public IModel getOriginalModel() {
		return originalModel;
	}

	public void setOriginalModel(IModel originalModel) {
		this.originalModel = originalModel;
		addModel(originalModel);
	}

	public IModel getMigratedModel() {
		return migratedModel;
	}

	public void setMigratedModel(IModel migratedModel) {
		this.migratedModel = migratedModel;
		addModel(migratedModel);
	}
	
	@Override
	public void execute() throws EpsilonParseException, EpsilonSourceLoadException, EpsilonExecutionException {
		
		module = createModule();
		try {
			module.parse(sourceURI);
		} catch (Exception e1) {
			throw new EpsilonSourceLoadException("There was an error loading the source.", e1.getCause());
		}
		
		/*catch (URISyntaxException e) {
			throw new EpsilonStandalonevoidException("Error parsing source. " + e.getMessage());
		} catch (Exception e) {
			throw new EpsilonStandaloneException("Error parsing source. " + e.getMessage());
		}*/
		
		if (module.getParseProblems().size() > 0) {
			System.err.println("Parse errors occured...");
			for (ParseProblem problem : module.getParseProblems()) {
				System.err.println(problem.toString());
			}
			throw new EpsilonParseException("Parse errors occured. See stack trace for details.");
		}
		
		for (IModel model : getModels()) {
			module.getContext().getModelRepository().addModel(model);
		}
		
		try {
			((IFlockContext)module.getContext()).setOriginalModel(originalModel);
			((IFlockContext)module.getContext()).setMigratedModel(migratedModel);
		} catch (FlockUnsupportedModelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		preProcess();
		try {
			result = module.execute();
			((FlockResult)result).printWarnings(System.out);
		} catch (EolRuntimeException e) {
			throw new EpsilonExecutionException(e.getMessage(),e.getCause());
		}
		postProcess();
		for (IModel model : getModels()) {
			if (model.isStoredOnDisposal()) {
				try {
					model.store();
				}
				catch (Exception ex) { ex.printStackTrace(); }
			}
			module.getContext().getModelRepository().removeModel(model);
		}
	}
	
}
