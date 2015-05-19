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

import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.execute.context.EtlContext;
import org.eclipse.epsilon.etl.trace.TransformationTrace;

/**
 * The EtlTask is used to execute Epsilon Flock scripts in standalone mode.
 */
public class EtlTask extends EpsilonTask {

	
	/**
	 * Instantiates a new ETL task.
	 *
	 * @param etlSourceURI the ETL source uri
	 */
	public EtlTask(URI etlSourceURI) {
		super();
		this.sourceURI = etlSourceURI;
		models = new ArrayList<IModel>();
	}

	/**
	 * Instantiates a new ETL task.
	 *
	 * @param etlSourcePath the ETL source path
	 */
	public EtlTask(String etlSourcePath) {
		super();
		this.sourceURI = URI.create(etlSourcePath);
		models = new ArrayList<IModel>();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.qvtd.build.etl.EpsilonTask#createModule()
	 */
	@Override
	public IEolExecutableModule createModule() {
		
		return new EtlModule();
	}
	
	/**
	 * Gets the transformation trace. This method should be called after executing 
	 * the task.
	 *
	 * @return the transformation trace
	 * @throws QvtMtcExecutionException if the ETL module has not been initialised
	 */
	
	public TransformationTrace getTransformationTrace() throws QvtMtcExecutionException {
		
		if( module == null) {
			throw new QvtMtcExecutionException("The ETL module has not ben initialized and the transformation may not have executed yet.");
		}
		EtlContext context = (EtlContext) module.getContext();
		return context.getTransformationTrace();
	}


}
