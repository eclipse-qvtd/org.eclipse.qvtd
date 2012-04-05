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
 * $Id: ExecutionService.java,v 1.11 2009/02/19 18:28:42 qglineur Exp $
 */
package org.eclipse.qvt.declarative.execution;

import java.util.List;

import org.eclipse.qvt.declarative.common.framework.service.ExecutionStrategy;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Service;

/**
 * A service to gather the providers able to run a transformation from a
 * compiled file.
 * 
 * @author Quentin Glineur
 * 
 */
public class ExecutionService extends Service implements ExecutionProvider {

	private static ExecutionService INSTANCE = new ExecutionService();

	protected ExecutionService() {
		super();
	}

	/**
	 * Get the execution service singleton
	 * 
	 * @return
	 */
	public static final ExecutionService getInstance() {
		return INSTANCE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.qvt.declarative.execution.ExecutionProvider#execute(java.
	 * io.File, org.eclipse.qvt.declarative.execution.ExecutionContext)
	 */
	public List<? extends Object> execute(String transformationQualifiedName,
			ExecutionContext parameters) {
		Operation operation = new ExecuteOperation(transformationQualifiedName,
				parameters);
		return execute(operation);
	}

	private List<? extends Object> execute(Operation operation) {
		try {
			return execute(ExecutionStrategy.FIRST, operation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
