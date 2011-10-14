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
package org.eclipse.qvt.declarative.editor.ui.text;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.IUndoManagerExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.common.NullProvider;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.text.undo.DocumentUndoManagerRegistry;
import org.eclipse.text.undo.IDocumentUndoManager;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;

/**
 * A LazyTextEditor defers provision of its IDocumentProvider until its IEditorInput has contents.
 * If no content is available, as may be the case for an editor page in a multi-page editor that
 * has yet to be activated, a NullProvider satisfies the inherited requirement for a provider. 
 */
public class LazyTextPageEditor extends TextEditor implements ITextEditorWithUndoContext
{
	protected final IPageManager pageManager;
	private IDocumentProvider activeDocumentProvider;

	public LazyTextPageEditor(IPageManager pageManager, IDocumentProvider activeDocumentProvider) {
		this.pageManager = pageManager;
		this.activeDocumentProvider = activeDocumentProvider;
	}

	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		//
		//	Bugzilla 224324 part 1. Ensure that partial text operation does not continue across save.
		//
		IDocument document = activeDocumentProvider.getDocument(getEditorInput());
		if (document != null) {
			IDocumentUndoManager documentUndoManager = DocumentUndoManagerRegistry.getDocumentUndoManager(document);
			if (documentUndoManager != null)
				documentUndoManager.commit();
		}
		super.doSave(progressMonitor);
	}

	@Override protected void doSetInput(IEditorInput editorInput) throws CoreException {
		if ((editorInput instanceof LazyFileEditorInput)
		 && !((LazyFileEditorInput) editorInput).hasContents())
			setDocumentProvider(NullProvider.INSTANCE);
		else
			setDocumentProvider(activeDocumentProvider);
		super.doSetInput(editorInput);
	}

	@Override
	protected void editorContextMenuAboutToShow(IMenuManager menu) {
	 	IAction undoAction = getAction(ITextEditorActionConstants.UNDO);
	 	IAction redoAction = getAction(ITextEditorActionConstants.REDO);
 		if ((undoAction != null) && (undoAction.getId() == null))			// Workaround a ?? bug in inherited action creation
	 		undoAction.setId(ITextEditorActionConstants.UNDO);
 		if ((redoAction != null) && (redoAction.getId() == null))
 			redoAction.setId(ITextEditorActionConstants.REDO);
		super.editorContextMenuAboutToShow(menu);
		if (!isEditable())
			addAction(menu, ITextEditorActionConstants.GROUP_UNDO, ITextEditorActionConstants.UNDO);
	 	if ((undoAction != null) && (redoAction != null)) {
	 		IMenuManager subMenu = menu.findMenuUsingPath(ITextEditorActionConstants.GROUP_UNDO);
	 		if (subMenu != null)
	 			subMenu.insertAfter(ITextEditorActionConstants.UNDO, redoAction);
	 		else
	 			menu.insertAfter(ITextEditorActionConstants.UNDO, redoAction);
	 	}
	}

	public IDocumentProvider getActiveDocumentProvider() {
		return activeDocumentProvider;
	}	

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if (key.equals(IPageManager.class))
			return pageManager;
		if (key.equals(IUndoContext.class))
			return getUndoContext();
		return super.getAdapter(key);
	}

	public PagedEditor getPagedEditor() {
		return pageManager.getPagedEditor();
	}
	
	public IUndoContext getUndoContext() {
		ISourceViewer sourceViewer = getSourceViewer();
		if (sourceViewer instanceof ITextViewerExtension6) {
			IUndoManager undoManager= ((ITextViewerExtension6)sourceViewer).getUndoManager();
			if (undoManager instanceof IUndoManagerExtension)
				return ((IUndoManagerExtension)undoManager).getUndoContext();
		}
		return null;
	}

	@Override public boolean isDirty() {
		return getPagedEditor().isDirtyPage();
	}

//	public boolean isDirtyPage() {
//		return super.isDirty();
//	}

	@Override
	public void setAction(String actionID, IAction action) {
		if (actionID.equals(ITextEditorActionConstants.SAVE)) {
			// Bug 224324 
			//
			// Suppress the TextEditor SAVE in favour of the MultiPageEditorPart SAVE,
			// which performs an all editors save that ensures that the dirty state is
			// maintained, and updated before actions are enabled accordingly.
			//
			// FIXME How many more actions should be similarly disabled
		}
		else
			super.setAction(actionID, action);
	}

	@Override public String toString() {
		return getClass().getSimpleName() + " " + String.valueOf(((IFileEditorInput)getEditorInput()).getFile());
	}
}
