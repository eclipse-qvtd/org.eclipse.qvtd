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
 * $Id: CompilationService.java,v 1.10 2009/03/05 14:42:17 qglineur Exp $
 */
package org.eclipse.qvt.declarative.compilation;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.qvt.declarative.common.framework.service.ExecutionStrategy;
import org.eclipse.qvt.declarative.common.framework.service.Operation;
import org.eclipse.qvt.declarative.common.framework.service.Service;

/**
 * A service to gather the providers able to compile transformation from a its
 * abstract syntax tree.
 * 
 * @author Quentin Glineur
 * 
 */
public class CompilationService extends Service implements CompilationProvider {

	protected static final CompilationService INSTANCE = new CompilationService();

	protected CompilationService() {
		super();
	}

	/**
	 * Get the compilation service singleton.
	 * 
	 * @return the compilation service instance
	 */
	public static CompilationService getInstance() {
		return INSTANCE;
	}

	public List<File> compile(Object abstractSyntaxTree,
			Map<String, String> parameters) throws Exception {
		return execute(new CompileOperation(abstractSyntaxTree, parameters));
	}

	@SuppressWarnings("unchecked")
	private List<File> execute(Operation operation) throws Exception {
		return (List<File>) execute(ExecutionStrategy.FIRST, operation);
	}

}
