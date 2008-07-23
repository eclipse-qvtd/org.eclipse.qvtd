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

import java.util.List;

import org.eclipse.emf.transaction.ui.view.ExtendedPropertySheetPage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchPart;

public final class PagedPropertySheetPage extends ExtendedPropertySheetPage
{
  	protected final PagedEditor pagedEditor;
  	
	public PagedPropertySheetPage(PagedEditor pagedEditor) {
		super(pagedEditor.getAdapterFactoryEditingDomain());
		this.pagedEditor = pagedEditor;
	}

	@Override public void refresh() {
		if (!getControl().isDisposed())
			super.refresh();
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		selection = pagedEditor.unwrapEditPartSelection(selection);
		super.selectionChanged(part, selection);
	}

	@Override
	public void setActionBars(IActionBars actionBars) {
		super.setActionBars(actionBars);
		pagedEditor.getActionBarContributor().shareGlobalActions(this, actionBars);
	}

	@Override
	public void setSelectionToViewer(List<?> selection) {
		pagedEditor.setSelectionToViewer(selection);
		pagedEditor.setFocus();
	}
}