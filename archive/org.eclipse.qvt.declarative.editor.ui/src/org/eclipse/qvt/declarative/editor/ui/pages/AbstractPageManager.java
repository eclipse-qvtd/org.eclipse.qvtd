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
package org.eclipse.qvt.declarative.editor.ui.pages;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;

public abstract class AbstractPageManager<E extends IEditorPart> implements IPageManager
{
	protected final PagedEditor pagedEditor;
	protected String pageTitle;
	protected E editor = null;
	
	public AbstractPageManager(PagedEditor pagedEditor, String pageTitle) {
		this.pagedEditor = pagedEditor;
		this.pageTitle = pageTitle;
	}

	public void dispose() {}
	
	public IAction getAction(String actionId) {
		return pagedEditor.getActionBarContributor().getSharedAction(actionId);
	}

	@SuppressWarnings("unchecked")
	public <T> T getAdapter(Class<T> key) {
		if (key.isAssignableFrom(getClass()))
			return (T) this;
		return null;
	}

	public ICreationFactory getCreationFactory() {
		return pagedEditor.getCreationFactory();
	}
	
	public E getEditor() {
		return editor;
	}
	
	public Image getImage() {
		return null;
	}

	public PagedEditor getPagedEditor() {
		return pagedEditor;
	}
	
	public ResourceSet getResourceSet() {
		return pagedEditor.getResourceSet();
	}

	public final ISelectionProvider getSelectionProvider() {
		return this;
	}

	public String getTitle() {
		return pageTitle;
	}

	public abstract IUndoContext getUndoContext();
	
	public void resumeResourceListening() {}
	
	public void setEditor(E editor) {
		this.editor = editor;
	}

	public void setTitle(String title) {
		this.pageTitle = title;
		pagedEditor.setPageTitle(editor, pageTitle);
	}
	
	public void suspendResourceListening() {}

	@Override
	public String toString() {
		return pagedEditor.toString() + " : " + pageTitle;
	}
}