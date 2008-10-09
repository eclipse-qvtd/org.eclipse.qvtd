/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * </copyright>
 * 
 * Contributors:
 *     Quentin Glineur - initial API and implementation
 *
 * $Id: ExecuteOperation.java,v 1.9 2008/10/09 17:21:02 qglineur Exp $
 */
package org.eclipse.qvt.declarative.execution;

import java.io.File;
import java.util.List;

import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Provider;
import org.eclipse.qvt.declarative.common.framework.service.ProviderDescriptor;

/**
 * An operation that execute a compiled file.
 * 
 * @author Quentin Glineur
 * 
 */
public class ExecuteOperation implements Operation {

	protected File executableFile;
	protected ExecutionContext parameters;

	/**
	 * Constructs an <code>ExecuteOperation</code> initializing its fields.
	 * 
	 * @param executableFile
	 *            the compiled file to execute
	 * @param parameters
	 *            the execution parameters
	 */
	public ExecuteOperation(File executableFile, ExecutionContext parameters) {
		super();
		this.executableFile = executableFile;
		this.parameters = parameters;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.qvt.declarative.common.framework.service.Operation#execute
	 * (org.eclipse.qvt.declarative.common.framework.service.Provider)
	 */
	public Object execute(Provider provider) {
		List<?> result = null;
		if (provider instanceof ProviderDescriptor) {
			ProviderDescriptor descriptor = (ProviderDescriptor) provider;
			provider = descriptor.getDescribedProvider();
		}
		if (provider instanceof ExecutionProvider) {
			ExecutionProvider executionProvider = (ExecutionProvider) provider;
			result = executionProvider.execute(executableFile, parameters);
		}
		return result;
	}

	/**
	 * @return The file whose execution is asked by this operation.
	 */
	public File getExecutableFile() {
		return executableFile;
	}

	/**
	 * @param sourceFile
	 *            The file whose execution is asked by this operation.
	 */
	public void setExecutableFile(File sourceFile) {
		this.executableFile = sourceFile;
	}

	/**
	 * @return The execution parameters.
	 */
	public ExecutionContext getParameters() {
		return parameters;
	}

	/**
	 * @param parameters
	 *            The execution parameters.
	 */
	public void setParameters(ExecutionContext parameters) {
		this.parameters = parameters;
	}

}
