package org.eclipse.qvtd.build.etl;

import java.net.URI;
import java.util.ArrayList;

import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.execute.context.EtlContext;
import org.eclipse.epsilon.etl.trace.TransformationTrace;

public class EtlTask extends EpsilonTask {

	
	public EtlTask(URI etlSourceURI) {
		super();
		this.sourceURI = etlSourceURI;
		models = new ArrayList<IModel>();
	}

	public EtlTask(String etlSourcePath) {
		super();
		this.sourceURI = URI.create(etlSourcePath);
		models = new ArrayList<IModel>();
	}

	@Override
	public IEolExecutableModule createModule() {
		
		return new EtlModule();
	}
	
	/**
	 * Gets the transformation trace. This method should be called after executing 
	 * and getting its result.
	 *
	 * @throws ExecutorException if no previously execution.
	 */
	
	public TransformationTrace getTransformationTrace() throws EpsilonExecutionException {
		
		if( module == null) {
			throw new EpsilonExecutionException("Transformation not Executed. No context found.");
		}
		EtlContext context = (EtlContext) module.getContext();
		return context.getTransformationTrace();
	}


}
