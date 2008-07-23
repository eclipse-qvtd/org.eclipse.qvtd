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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.ui.IEditorPart;

/**
 * A DirectPageManager manages direct editing of Resource(s) in the ResourceSet.
 */
public abstract class DirectPageManager<E extends IEditorPart> extends AbstractPageManager<E>
{
	public DirectPageManager(PagedEditor pagedEditor, String pageTitle) {
		super(pagedEditor, pageTitle);
	}

	public void activate(IProgressMonitor monitor, long resourceSetTimeStamp) {}

	public void deactivated(IProgressMonitor monitor, long resourceSetTimeStamp) {}

	public XMLResource getResource() {
		return null;
	}

	public boolean hasResourceSetTimeStamp(long resourceSetTimeStamp) {
		return true;
	}
	
	public boolean isDirect() {
		return true;
	}

	public void refresh() {}
}