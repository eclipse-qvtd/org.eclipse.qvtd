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
 * $Id: CommonOutlinePage.java,v 1.1 2008/08/24 19:03:19 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.cst;

import org.eclipse.imp.editor.IMPOutlinePage;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonTextEditor;
import org.eclipse.qvt.declarative.editor.ui.imp.CommonTreeModelBuilder;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPageSite;

public abstract class CommonOutlinePage extends IMPOutlinePage implements ICSTOutlinePage, ISelectionListener
{
	protected final CommonTextEditor editor;
	protected final CommonTreeModelBuilder treeModelBuilder;
	private boolean changingSelection = false;	// Set true while selection is changing to inhibit recursive call-backs

	public CommonOutlinePage(CommonTextEditor editor, CommonTreeModelBuilder treeModelBuilder) {
		super(editor.getParseController(), treeModelBuilder,
			editor.getLanguageServiceManager().getLabelProvider(),
			editor.getLanguageServiceManager().getImageProvider(),
			null);
		this.editor = editor;
		this.treeModelBuilder = treeModelBuilder;
	}

	@Override
	public void dispose() {
		super.dispose();
		getSite().getPage().removeSelectionListener(this);
// FIXME (bug 230581) editor.removeModelListener(this);
	}

	protected ISelection getItemSelection(ISelection selection) {
		if ((selection instanceof IStructuredSelection) && !selection.isEmpty()) {
			Object[] selections = ((IStructuredSelection)selection).toArray();
			Object[] unwrappedSelections = new Object[selections.length];
			for (int i = 0; i < selections.length; i++)
				unwrappedSelections[i] = treeModelBuilder.getItem(selections[i]);
			selection = new StructuredSelection(unwrappedSelections);
			
		}
		return selection;
	}

	@Override
	public void init(IPageSite pageSite) {
		editor.addModelListener(this);
		pageSite.getPage().addSelectionListener(this);
		super.init(pageSite);
	}
	
	protected boolean isChangingSelection() {
		return changingSelection;
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
        if (!changingSelection) {
//    		System.out.println(getClass().getSimpleName() + ".selectionChanged");
        	try {
        		changingSelection = true;
            	ISelection selection = event.getSelection();
				fireSelectionChanged(selection);
        		if ((selection instanceof IStructuredSelection) && (((IStructuredSelection)selection).size() == 1)) {
        			Object object = ((IStructuredSelection)selection).getFirstElement();
        			CSTNode cstNode = editor.getParseController().getCSTNode(object);
        			if (cstNode != null)
        				editor.selectAndReveal(cstNode.getStartOffset(), cstNode.getEndOffset() - cstNode.getStartOffset() + 1);
        		}	      	
        	}
        	finally {
        		changingSelection = false;
        	}
        }      
	}

	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (!isChangingSelection())
			setSelection(selection);
	}

	@Override
	public void setSelection(ISelection selection) {
        if (!changingSelection) {
//    		System.out.println(getClass().getSimpleName() + ".setSelection");
        	try {
        		changingSelection = true;
    			ISelection itemSelection = getItemSelection(selection);
        		super.setSelection(itemSelection);
        	}
        	finally {
        		changingSelection = false;
        	}
        }      
	}
}
