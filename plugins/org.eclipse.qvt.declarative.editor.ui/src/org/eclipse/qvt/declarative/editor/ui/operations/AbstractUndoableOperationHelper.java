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
package org.eclipse.qvt.declarative.editor.ui.operations;

import java.util.Iterator;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.workspace.AbstractEMFOperation;
import org.eclipse.emf.workspace.CompositeEMFOperation;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.qvt.declarative.editor.ui.IUndoContextAffecter;
import org.eclipse.qvt.declarative.editor.ui.IUndoableOperationHelper;
import org.eclipse.qvt.declarative.editor.ui.commands.PageChangeCommand;
import org.eclipse.qvt.declarative.editor.ui.commands.PageSaveCommand;

public class AbstractUndoableOperationHelper implements IUndoableOperationHelper
{
	public Command getCommand(IUndoableOperation operation) {
		if (operation instanceof EMFCommandOperation)
			return ((EMFCommandOperation)operation).getCommand();
		else
			return null;
	}

	public boolean isDirty(IUndoableOperation operation) {
		if (operation instanceof EMFCommandOperation) {
			Command command = ((EMFCommandOperation)operation).getCommand();
			return !(command instanceof AbstractCommand.NonDirtying);
		}
		else if (operation instanceof CompositeEMFOperation) {
			for (Iterator<?> iterator = ((CompositeEMFOperation)operation).iterator(); iterator.hasNext(); ) {
				Object childOperation = iterator.next();
				if (childOperation instanceof AbstractEMFOperation)
					if (isDirty((AbstractEMFOperation) childOperation))
						return true;
			}
			return false;
		}
		else
			return true;
	}

	public boolean isPageChange(IUndoableOperation operation) {
		Command command = getCommand(operation);
		return command instanceof PageChangeCommand;
	}

	public boolean isPageSave(IUndoableOperation operation) {
		Command command = getCommand(operation);
		return command instanceof PageSaveCommand;
	}
	
	public void setAffectedContexts(IUndoableOperation operation) {
		if (operation instanceof AbstractEMFOperation)
			setAffectedContexts(operation, (AbstractEMFOperation) operation);					
	}

	private void setAffectedContexts(IUndoableOperation operation, AbstractEMFOperation emfOperation) {
		if (emfOperation instanceof EMFCommandOperation) {
			Command command = ((EMFCommandOperation)emfOperation).getCommand();
			if (command instanceof IUndoContextAffecter)
				((IUndoContextAffecter)command).setAffectedContext(operation);
		}
		else if (emfOperation instanceof CompositeEMFOperation) {
			for (Iterator<?> iterator = ((CompositeEMFOperation)emfOperation).iterator(); iterator.hasNext(); ) {
				Object childOperation = iterator.next();
				if (childOperation instanceof AbstractEMFOperation)
					setAffectedContexts(operation, (AbstractEMFOperation) childOperation);
			}
		}
	}
}
