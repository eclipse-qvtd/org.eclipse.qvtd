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

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.views.contentoutline.ContentOutlinePage;

public class PagedContentOutlinePage extends ContentOutlinePage implements IEditingDomainProvider
{
	protected final PagedEditor pagedEditor;
	/**
	 * This is a kludge...
	 */
	protected IStatusLineManager statusLineManager;

	public PagedContentOutlinePage(PagedEditor pagedEditor) {
		this.pagedEditor = pagedEditor;
	}

	@Override
	public void createControl(Composite parent) {
		super.createControl(parent);
		TreeViewer treeViewer = getTreeViewer();
		// Set up the tree viewer.
		//
		pagedEditor.initializeTreeViewer(treeViewer);
		// Make sure our popups work.
		//
		pagedEditor.createContextMenuFor(treeViewer);
	}

	public EditingDomain getEditingDomain() {
		return pagedEditor.getEditingDomain();
	}

	public IStatusLineManager getStatusLineManager() {
		return statusLineManager;
	}

	@Override
	public TreeViewer getTreeViewer() {				// Change visibility to public
		return super.getTreeViewer();
	}

	@Override
	public void makeContributions(IMenuManager menuManager, IToolBarManager toolBarManager, IStatusLineManager statusLineManager) {
		super.makeContributions(menuManager, toolBarManager, statusLineManager);
		this.statusLineManager = statusLineManager;
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
		super.setActionBars(actionBars);
		pagedEditor.getActionBarContributor().shareGlobalActions(this, actionBars);
	}

	@Override
	public void setSelection(ISelection selection) {
		selection = pagedEditor.unwrapEditPartSelection(selection);
		super.setSelection(selection);
	}
}