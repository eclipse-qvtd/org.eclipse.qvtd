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
package org.eclipse.qvt.declarative.editor.ui.commands;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.qvt.declarative.editor.ui.IUndoContextAffecter;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;

public abstract class PageSaveCommand extends AbstractCommand implements IUndoContextAffecter
{
	protected final PagedEditor pagedEditor;
	protected final IProgressMonitor monitor;
	
	public PageSaveCommand(PagedEditor pagedEditor, String label, IProgressMonitor monitor) {
		this.pagedEditor = pagedEditor;
		this.monitor = monitor != null ? monitor : new NullProgressMonitor();
		setLabel(label);
	}

	@Override
	public boolean canUndo() {
		return false;
	}
	
	@Override
	protected boolean prepare() {
		return true;
	}

	public void redo() {}

	public void setAffectedContext(IUndoableOperation operation) {
		IUndoContext context = pagedEditor.getActivePageManager().getUndoContext();
		if (context != null)
			operation.addContext(context);
	}
}