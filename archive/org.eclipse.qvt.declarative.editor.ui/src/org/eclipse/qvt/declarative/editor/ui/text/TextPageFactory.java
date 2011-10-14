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
import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.IMasterPageManager;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.qvt.declarative.editor.ui.pages.AbstractPageFactory;
import org.eclipse.qvt.declarative.editor.ui.pages.PageDefinitions;

/**
 * A TextPageFactory manages creation of Textual CST edting pages.
 */
public class TextPageFactory extends AbstractPageFactory
{
	public TextPageFactory(PagedEditor pagedEditor, ICreationFactory creationFactory) {
		super(pagedEditor, creationFactory);
	}

	public IMasterPageManager createMasterPageFor(PagedEditor pagedEditor, XMLResource resource, TextResource textResource) {
		return createPageFor(pagedEditor, resource, textResource);
	}

	public void createOtherPagesFor(PagedEditor pagedEditor) {
		if (pagedEditor.getCreationFactory() != getCreationFactory())
			return;
		IMasterPageManager masterPageManager = pagedEditor.getMasterPageManager();
		if (!(masterPageManager instanceof TextPageManager))
			createPageFor(pagedEditor, masterPageManager.getEcoreResource(), null);
	}

	public TextPageManager createPageFor(PagedEditor pagedEditor, XMLResource resource, TextResource textResource) {
		TextPageManager pageManager = new TextPageManager(pagedEditor, resource, textResource);
		pagedEditor.addPageManager(pageManager);
		return pageManager;
	}
	
	public void registerAsIn(String name, PageDefinitions pageFactoryRegistries) throws InstantiationException, IllegalAccessException {
		TextPageFactoryRegistry pageFactoryRegistry = pageFactoryRegistries.create(TextPageFactoryRegistry.class);
		pageFactoryRegistry.registerPageFactory(name, this);
	}
}