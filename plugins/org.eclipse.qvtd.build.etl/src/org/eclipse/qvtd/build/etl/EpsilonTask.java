/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Horacio Hoyos - adjustment to RISkC project
 ******************************************************************************/
package org.eclipse.qvtd.build.etl;

import java.net.URI;
import java.util.List;

import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.models.IModel;



/**
 * Provides the basic attributes and methods for the set of Epsilon standalone
 * engines. Specific implementations for each of the Epsilon languages (i.e., EOL,
 *  ETL, etc.) override methods as required, and provide additional functionality
 *  
 *  @author Horacio Hoyos
 */
public abstract class EpsilonTask {
	
	/** The EXL source URI. */
	protected URI sourceURI;
	
	/** The models. */
	protected List<IModel> models;
	
	/** The module. */
	protected IEolExecutableModule module;
	
	/** The result. */
	protected Object result;
	
	/**
	 * Creates the module used by the engine to execute the ExL source. Specific
	 * ExL language engines should provide a specific module.
	 *
	 * @return the EXL executable module
	 */
	public abstract IEolExecutableModule createModule();
	
	
	/**
	 * @return the ExL sourceURI
	 */
	public URI getSourceURI() {
		return sourceURI;
	}

	/**
	 * @param sourceURI the ExL source URI
	 */
	public void setSourceURI(URI sourceURI) {
		this.sourceURI = sourceURI;
	}

	/**
	 * Gets the list of models available to the engine
	 *
	 * @return the model list
	 */
	public List<IModel> getModels() {
		return models;
	}
	
	/**
	 * Sets the models available to the engine
	 *
	 * @param models the new models
	 */
	public void setModels(List<IModel> models) {
		this.models = models;
	}
	
	
	public void addModel(IModel model) {
		this.models.add(model);
	}
	
	public void removeModel(IModel model) {
		this.models.remove(model);
	}
	
	public void removeAllModels() {
		this.models.clear();
	}
	
	
	/**
	 * Gets the models loaded to the engine. The loaded models can be different
	 * to the list of models, for example if a model fails to load.
	 *
	 * @return the module models
	 */
	public List<IModel> getModuleModels() {
		return module.getContext().getModelRepository().getModels();
	}
	
	
	/**
	 * This method is invoked after the engine has executed if there were no
	 * exceptions. Implementations should override this method o provide any
	 * required post-processing after the engine has executed. For example
	 * modifying the result object. This method should be called after module
	 * execution if the extending class has overridden {@link #execute()} to
	 * provide a more fined grained control over the module execution.
	 */
	public void postProcess() {};
	
	/**
	 * This method is invoked after the ExL source is parsed and the
	 * models are loaded to the engine's context. Implementations should
	 * override this method to provide any required pre-processing before the
	 * engine is executed. This method should be called after module execution
	 * if the extending class has overridden {@link #execute()}
	 * to provide a more fined grained control over the module execution. 
	 */
	public void preProcess() {};
	
	/**
	 * Executes the Epsilon source on the loaded models using the engine.
	 * Parses the Epsilon source for errors, loads the models to the engine's
	 * repository, invokes the {@link #preProcess()} method, executes the engine
	 * and the invokes the {@link #postProcess()} method. The result of executing
	 * the engine is saved in the {@see #result} field. Models are disposed (i.e.
	 * un-loaded) after execution. Models are removed from the context to provide
	 * clean execution of next invocation.
	 *
	 * Different Epsilon modules may require to override this method to provide
	 * specific functionality.
	 * @throws EpsilonParseException If syntax errors were detected in the source file.
	 *         Error details will be printed in the System.err stream.
	 *         TODO Provide a better way of getting the errors, log4j or other
	 *         method in case the host application has not console
	 * @throws EpsilonSourceLoadException If there was an error loading the source file.
	 * @throws EpsilonExecutionException If there was an error executing the source
	 */
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
		
		preProcess();
		try {
			result = execute(module);
		} catch (EolRuntimeException e) {
			throw new EpsilonExecutionException(e.getMessage(),e.getCause());
		}
		postProcess();
		for (IModel model : getModels()) {
			if (model.isStoredOnDisposal()) {
				model.store();
			}
			module.getContext().getModelRepository().removeModel(model);
		}
	}
	
	
	/**
	 * Execute. The actual module execution.
	 * Depending on the specific executor this method may be implemented 
	 * differently. 
	 *
	 * @param module the module
	 * @return the object
	 * @throws EolRuntimeException if there is an exception during parsing, loading
	 * of the models or execution of the engine.
	 */
	protected Object execute(IEolExecutableModule module) throws EolRuntimeException {
		return module.execute();
	}
	
	/**
	 * Gets the file, given the name. The file is searched by the class loader.
	 *
	 * @param fileName the file name
	 * @return the file
	 * @throws URISyntaxException the uRI syntax exception
	 */
	/*
	protected File getFile(String fileName) throws URISyntaxException {
		
		URI binUri = EpsilonStandaloneEngine.class.getResource(fileName).toURI();
		URI uri = null;
		
		if (binUri.toString().indexOf("bin") > -1) {
			uri = new URI(binUri.toString().replaceAll("bin", "src"));
		}
		else {
			uri = binUri;
		}
		
		return new File(uri);
	}
	*/

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

}
