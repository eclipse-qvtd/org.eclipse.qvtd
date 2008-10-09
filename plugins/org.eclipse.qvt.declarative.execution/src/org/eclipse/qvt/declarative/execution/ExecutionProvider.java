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
 * $Id: ExecutionProvider.java,v 1.9 2008/10/09 17:21:02 qglineur Exp $
 */
package org.eclipse.qvt.declarative.execution;

import java.io.File;
import java.util.List;

import org.eclipse.qvt.declarative.common.framework.service.Provider;

/**
 * An interface to implement by a client who wish to provide a QVT Execution.
 * 
 * @author Quentin Glineur
 */
public interface ExecutionProvider extends Provider {

	/**
	 * Creates and return the result of the execution of the given
	 * transformation.
	 * 
	 * @param executableFile
	 *            The compiled version of the transformation
	 * @param parameters
	 *            An execution context to set runtime transformation parameters
	 * 
	 * @return The result of the transformation
	 */
	public List<? extends Object> execute(File executableFile,
			ExecutionContext parameters);

}
