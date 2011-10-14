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
package org.eclipse.qvt.declarative.editor.ui.actions;

import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.qvt.declarative.editor.ui.xml.EMOFXMLPageFactory;
import org.eclipse.qvt.declarative.editor.ui.xml.EcoreXMLPageFactory;
import org.eclipse.qvt.declarative.editor.ui.xml.XMLPageFactoryRegistry;

public class OpenEMOFSheetAction extends AbstractObjectActionDelegate
{
	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> it = ((IStructuredSelection) selection).iterator(); it.hasNext(); ) {
				Object element = it.next();
				XMLResource resource = null;
				if (element instanceof XMLResource)
					resource = (XMLResource) element;
				else if (element instanceof IAdaptable)
					resource = (XMLResource) ((IAdaptable) element).getAdapter(XMLResource.class);
				if ((resource != null) && (targetPart instanceof PagedEditor)) {
					PagedEditor pagedEditor = ((PagedEditor) targetPart);
					XMLPageFactoryRegistry pageFactoryRegistry = pagedEditor.getPageFactoryRegistry(XMLPageFactoryRegistry.class);
					if (pageFactoryRegistry != null)
						pageFactoryRegistry.createPageFor(pagedEditor, "EMOF", resource);
				}
			}
		}
	}

	@Override
	public void selectionChanged(IAction action, ISelection selection) {
		super.selectionChanged(action, selection);
		if (!(selection instanceof IStructuredSelection)) {
			action.setEnabled(false);
			return;					
		}
		for (Iterator<?> it = ((IStructuredSelection) selection).iterator(); it.hasNext(); ) {
			Object element = it.next();
			if (!(element instanceof XMLResource)) {
				action.setEnabled(false);
				return;					
			}
			if (!EcoreXMLPageFactory.isEPackageBased((XMLResource) element)
			 && !EMOFXMLPageFactory.isPackageBased((XMLResource) element)) {
				action.setEnabled(false);
				return;					
			}
		}
		action.setEnabled(true);
	}
}