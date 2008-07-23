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

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.qvt.declarative.editor.ui.IMasterPageManager;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.qvt.declarative.editor.ui.pages.AbstractPageFactoryRegistry;

/**
 * A TextPageFactoryRegistry manages creation of Text pages.
 */
public class TextPageFactoryRegistry extends AbstractPageFactoryRegistry<TextPageFactory>
{
	public IMasterPageManager createMasterPageFor(PagedEditor pagedEditor, XMLResource resource, TextResource textResource) {
		if (textResource == null)
			return null;
		for (TextPageFactory pageFactory : getPageFactories()) {
			IMasterPageManager masterPageManager = pageFactory.createMasterPageFor(pagedEditor, resource, textResource);
			if (masterPageManager != null)
				return masterPageManager;
		}
		return null;
	}

	public void createOtherPagesFor(PagedEditor pagedEditor) {
		for (TextPageFactory pageFactory : getPageFactories())
			pageFactory.createOtherPagesFor(pagedEditor);
	}

	public TextPageManager createPageFor(PagedEditor pagedEditor, XMLResource resource, TextResource textResource) {
		TextPageManager pageManager = new TextPageManager(pagedEditor, resource, textResource);
		pagedEditor.addPageManager(pageManager);
		return pageManager;
	}
}
