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
 * $Id: CompilationProvider.java,v 1.10 2009/03/05 14:42:17 qglineur Exp $
 */
package org.eclipse.qvt.declarative.compilation;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.qvt.declarative.common.framework.service.Provider;

/**
 * An interface to implement by a client who wish to provide a QVT compilation.
 * Generally, such a compilation is coupled with an execution client
 * implementation able to handle the compiled files format.
 * 
 * @author Quentin Glineur
 * 
 */
public interface CompilationProvider extends Provider {

	/**
	 * Create and return a list of executable files from the abstract syntax
	 * tree originating from a syntax analysis.
	 * 
	 * @param abstractSyntaxTree
	 *            A representation of the abstract syntax tree.
	 * @param parameters
	 *            A map associating a property name to a string value so that
	 *            the compilation can be parameterized.
	 * @return The list of file resulting from the compilation.
	 * @throws Exception
	 */
	public List<File> compile(Object abstractSyntaxTree,
			Map<String, String> parameters) throws Exception;
}
