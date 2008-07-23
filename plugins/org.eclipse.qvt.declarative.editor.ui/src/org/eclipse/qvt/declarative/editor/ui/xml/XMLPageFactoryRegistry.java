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
package org.eclipse.qvt.declarative.editor.ui.xml;

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.qvt.declarative.editor.ui.IMasterPageManager;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.qvt.declarative.editor.ui.pages.AbstractPageFactoryRegistry;
import org.eclipse.qvt.declarative.editor.ui.text.TextResource;

/**
 * An XMLPageFactoryRegistry manages creation of XML pages.
 */
public class XMLPageFactoryRegistry extends AbstractPageFactoryRegistry<XMLPageFactory>
{
	public IMasterPageManager createMasterPageFor(PagedEditor pagedEditor, XMLResource resource, TextResource textResource) {
		if (textResource != null)
			return null;
		for (XMLPageFactory pageFactory : getPageFactories()) {
			IMasterPageManager masterPageManager = pageFactory.createMasterPageFor(pagedEditor, resource);
			if (masterPageManager != null)
				return masterPageManager;
		}
		return null;
	}

	public void createOtherPagesFor(PagedEditor pagedEditor) {
		for (XMLPageFactory pageFactory : getPageFactories())
			pageFactory.createOtherPagesFor(pagedEditor);
	}

	public void createPageFor(PagedEditor pagedEditor, String name, XMLResource resource) {
		XMLPageFactory pageFactory = getPageFactory(name);
		if (pageFactory != null)
			pageFactory.createPageFor(pagedEditor, resource);
	}
}