/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CommonPropertySheetPage.java,v 1.2 2008/11/19 21:55:36 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.imp;

import java.util.List;

import org.eclipse.emf.transaction.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.qvt.declarative.editor.ui.QVTEditorPlugin;
import org.eclipse.qvt.declarative.editor.ui.format.DefaultFormatManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;

public final class CommonPropertySheetPage extends ExtendedPropertySheetPage
{
 	protected final CommonTextEditor textEditor;
  	
	public CommonPropertySheetPage(CommonTextEditor textEditor) {
		super(textEditor.getAdapterFactoryEditingDomain());
		this.textEditor = textEditor;
	}

	@Override
	public void dispose() {
		super.dispose();
		getSite().getPage().removePostSelectionListener(this);
	}

	@Override
	public void init(IPageSite pageSite) {
		pageSite.getPage().addPostSelectionListener(this);
		super.init(pageSite);
	}


	@Override public void refresh() {
		if (!getControl().isDisposed())
			super.refresh();
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
//		System.out.println(getClass().getSimpleName() + ".selectionChanged()");
		selection = textEditor.getASTorCSTSelection(selection);
        if (QVTEditorPlugin.SELECTION_OUTER.isActive())
			QVTEditorPlugin.SELECTION_OUTER.println(getClass(), "selectionChanged " + DefaultFormatManager.format(selection));
		super.selectionChanged(part, selection);
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
		super.setActionBars(actionBars);
//		textEditor.getActionBarContributor().shareGlobalActions(this, actionBars);
	}

	@Override
	public void setSelectionToViewer(List<?> selection) {
//		textEditor.setSelectionToViewer(selection);
		textEditor.setFocus();
	}
}