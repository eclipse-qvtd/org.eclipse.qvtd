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
package org.eclipse.qvt.declarative.editor.ui.paged;

import java.util.Collection;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.command.Command;
import org.eclipse.qvt.declarative.editor.ui.operations.OperationHistoryListener;
import org.eclipse.ui.IEditorPart;

public class PagedOperationHistoryListener extends OperationHistoryListener
{
	private class ResetDirtyRunnable implements Runnable
	{
		public void run() {
			PagedOperationHistoryListener.super.resetDirty();
			pagedEditor.firePropertyChange(IEditorPart.PROP_DIRTY);
			pagedEditor.showDirtyPage(false);
		}
	}

	private class ResetDirtyPageRunnable implements Runnable
	{
		public void run() {
			PagedOperationHistoryListener.super.resetDirtyPage();
			pagedEditor.firePropertyChange(IEditorPart.PROP_DIRTY);
			pagedEditor.showDirtyPage(false);
		}
	}

//	private class SetDirtyRunnable implements Runnable
//	{
//		public void run() {
//			PagedOperationHistoryListener.super.setDirty();
//			pagedEditor.firePropertyChange(IEditorPart.PROP_DIRTY);
//		}
//	}

	private class SetDirtyPageRunnable implements Runnable
	{
		public void run() {
			PagedOperationHistoryListener.super.setDirtyPage();
			pagedEditor.firePropertyChange(IEditorPart.PROP_DIRTY);
			pagedEditor.showDirtyPage(true);
		}
	}
	
	/**
	 * Runnable to reset isDirtyPage.
	 */
	protected final Runnable resetDirtyPageRunnable = new ResetDirtyPageRunnable();
	
	/**
	 * Runnable to reset isDirty.
	 */
	protected final Runnable resetDirtyRunnable = new ResetDirtyRunnable();
	
	/**
	 * Runnable to set isDirtyPage.
	 */
	protected final Runnable setDirtyPageRunnable = new SetDirtyPageRunnable();
	
	/**
	 * Runnable to set isDirty.
	 */
//	protected final Runnable setDirtyRunnable = new SetDirtyRunnable();

	public PagedOperationHistoryListener(PagedEditor pagedEditor) {
		super(pagedEditor);
	}

	@Override
	protected void resetDirty() {
		if (PagedEditor.traceEditorShowDirty.isActive())
			PagedEditor.traceEditorShowDirty.println("resetDirty " + pagedEditor);		
		pagedEditor.getDisplay().asyncExec(resetDirtyRunnable);
	}

	@Override
	protected void resetDirtyPage() {
		if (PagedEditor.traceEditorShowDirty.isActive())
			PagedEditor.traceEditorShowDirty.println("resetDirtyPage " + pagedEditor);		
		pagedEditor.getDisplay().asyncExec(resetDirtyPageRunnable);
	}

//	@Override
//	protected void setDirty() {
//	if (PagedEditor.editorShowDirty.isActive())
//		PagedEditor.editorShowDirty.println("setDirty " + pagedEditor);		
//		pagedEditor.getDisplay().asyncExec(setDirtyRunnable);
//	}

	@Override
	protected void setDirtyPage() {
		if (PagedEditor.traceEditorShowDirty.isActive())
			PagedEditor.traceEditorShowDirty.println("setDirtyPage " + pagedEditor);		
		pagedEditor.getDisplay().asyncExec(setDirtyPageRunnable);
	}

	@Override
	protected void setDone(IUndoableOperation operation) {
		// remove the default undo context so that we can have
		//     independent undo/redo of independent resource changes
		operation.removeContext(pagedEditor.getWorkspaceCommandStack().getDefaultUndoContext());						
		// add our overall undo context to populate our overall undo menu
		operation.addContext(undoContext);
		// add our page-specific undo context to populate our page-specific undo menu
		undoableOperationHelper.setAffectedContexts(operation);					
		Command command = undoableOperationHelper.getCommand(operation);								
		final Collection<?> affectedObjects = command != null ? command.getAffectedObjects() : null;
		if (affectedObjects != null) {
			pagedEditor.getDisplay().asyncExec(new Runnable() {
				public void run() {
//					dirty = true;
//					firePropertyChange(IEditorPart.PROP_DIRTY);
					// Try to select the affected objects.
					//
//					if (affectedObjects != null)
					pagedEditor.setSelectionToViewer(affectedObjects);
//					if (pagedEditor.propertySheetPage != null)
//						pagedEditor.propertySheetPage.refresh();
				}
			});
		}
	}
}