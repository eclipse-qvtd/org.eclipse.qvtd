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

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.qvt.declarative.editor.ui.IMasterPageManager;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.qvt.declarative.editor.ui.pages.AbstractPageFactoryRegistry;
import org.eclipse.qvt.declarative.editor.ui.text.TextResource;

public class TreePageFactoryRegistry extends AbstractPageFactoryRegistry<ResourceSetPageFactory>
{
	public IMasterPageManager createMasterPageFor(PagedEditor pagedEditor, XMLResource resource, TextResource textResource) {
		return null;
	}

	public void createOtherPagesFor(PagedEditor pagedEditor) {
		for (ResourceSetPageFactory pageFactory : getPageFactories())
			pageFactory.createOtherPagesFor(pagedEditor);
	}
}
