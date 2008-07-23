/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.command.Command;

public interface IUndoableOperationHelper
{
	/**
	 * Return a command if there is one.
	 * 
	 * @param operation
	 * @return
	 */
	public Command getCommand(IUndoableOperation operation);
	
	public boolean isDirty(IUndoableOperation operation);

	public boolean isPageChange(IUndoableOperation operation);

	public boolean isPageSave(IUndoableOperation operation);
	
	public void setAffectedContexts(IUndoableOperation operation);
}
