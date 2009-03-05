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
 * $Id: CompileOperation.java,v 1.9 2009/03/05 14:42:17 qglineur Exp $
 */
package org.eclipse.qvt.declarative.compilation;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Provider;
import org.eclipse.qvt.declarative.common.framework.service.ProviderDescriptor;

/**
 * An operation that compile a transformation into executable code
 * 
 * @author Quentin Glineur
 * 
 */
public class CompileOperation implements Operation {

	protected Object abstractSyntaxTree;
	protected Map<String, String> parameters;

	/**
	 * Construct a new compile operation holding the given parameters.
	 * 
	 * @param abstractSyntaxTree
	 * @param parameters
	 */
	public CompileOperation(Object abstractSyntaxTree,
			Map<String, String> parameters) {
		this.abstractSyntaxTree = abstractSyntaxTree;
		this.parameters = parameters;
	}

	public List<File> execute(Provider provider) throws Exception {
		List<File> result = null;
		if (provider instanceof ProviderDescriptor) {
			ProviderDescriptor descriptor = (ProviderDescriptor) provider;
			provider = descriptor.getDescribedProvider();
		}
		if (provider instanceof CompilationProvider) {
			CompilationProvider compilationProvider = (CompilationProvider) provider;
			result = compilationProvider
					.compile(abstractSyntaxTree, parameters);
		}
		return result;
	}

	/**
	 * Get the transformation targeted by the compilation.
	 * 
	 * @return the transformation
	 */
	public Object getSource() {
		return abstractSyntaxTree;
	}

	/**
	 * Set the transformation targeted by the compilation.
	 * 
	 * @param source
	 *            the transformation on which the compilation should be run on.
	 */
	public void setSource(Object source) {
		this.abstractSyntaxTree = source;
	}

	/**
	 * Get the parameters of the compilation.
	 * 
	 * @return The parameters considered by the compilation process
	 */
	public Map<String, String> getParameters() {
		return parameters;
	}

	/**
	 * Set the parameters of the compilation.
	 * 
	 * @param parameters
	 *            The parameters able to impact the compilation process
	 */
	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}

}
