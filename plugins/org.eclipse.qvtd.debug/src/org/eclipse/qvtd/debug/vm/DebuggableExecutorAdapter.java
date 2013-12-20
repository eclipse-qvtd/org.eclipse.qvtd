/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.vm;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.qvtd.debug.utils.CompiledUnit;

public interface DebuggableExecutorAdapter {
	/**
	 * Connects this adapter to the debugger which will partipate in the
	 * execution process
	 * 
	 * @param debugShell
	 */
	void connect(IQVTODebuggerShell debugShell);

	/**
	 * Causes to run the executor behind this adapter
	 * 
	 * @return the status of finished execution
	 * @throws IllegalStateException
	 *             if this adapter is not connected to debugger
	 */
	Diagnostic execute() throws IllegalStateException;

	/**
	 * Gets the main compiled unit to be executed
	 * @return the unit object
	 */
	CompiledUnit getUnit();	
}