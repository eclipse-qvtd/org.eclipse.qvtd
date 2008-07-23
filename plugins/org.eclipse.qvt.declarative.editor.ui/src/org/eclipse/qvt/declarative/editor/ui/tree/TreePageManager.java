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
package org.eclipse.qvt.declarative.editor.ui.tree;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.qvt.declarative.editor.ui.pages.DirectPageManager;
import org.eclipse.ui.IFileEditorInput;

/**
 * A TextPageManager manages editing of the primary edit Resource as a ResourceSet tree.
 */
public class TreePageManager extends DirectPageManager<TreePageEditor>
{
	public TreePageManager(PagedEditor pagedEditor, String pageTitle) {
		super(pagedEditor, pageTitle);
		setEditor(new TreePageEditor(this));
	}

	public void addSelectionChangedListener(ISelectionChangedListener listener) {
		editor.getViewer().addSelectionChangedListener(listener);
	}

/*	public void doSave(IProgressMonitor monitor) {
		saveTo(pagedEditor.getEditorInputFile(), monitor);
//		editor.doSave(monitor);
		if (isPrimary && (editorInput == secondaryEditorInput)) {
			try {
				InputStream inputStream = editorInput.getFile().getContents();
				editorInput = pagedEditor.getEditorInput();
				editorInput.getFile().setContents(inputStream, IResource.FORCE, monitor);
				editor.setInput(editorInput);
			} catch (CoreException e) {
				QVTEditorPlugin.logError("Failed to copy secondary file to primary", e);
			}
		}
	} */

/*	public String getCurrentContents() throws IOException {
		throw new UnsupportedOperationException(getClass().getName() + ".getCurrentContents");	
//		Resource ecoreResource = getModelResource();
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//		ecoreResource.save(outputStream, null);
//		return outputStream.toString();
	} */
	
	public IFileEditorInput getEditorInput() {
//		throw new UnsupportedOperationException(getClass().getName() + ".getEditorInput");
		return pagedEditor.getEditorInput();
	}

	public ISelection getSelection() {
		return editor.getViewer().getSelection();
	}

	@Override
	public IUndoContext getUndoContext() {
		return pagedEditor.getUndoContext();
	}

	public boolean gotoMarker(IMarker marker) {
		pagedEditor.setActiveEditor(getEditor());
		return true;
	}

	public void removeSelectionChangedListener(ISelectionChangedListener listener) {
		editor.getViewer().removeSelectionChangedListener(listener);
	}

	public void setSelection(ISelection selection) {
		selection = pagedEditor.unwrapEditPartSelection(selection);
		editor.getViewer().setSelection(selection);		
	}
}