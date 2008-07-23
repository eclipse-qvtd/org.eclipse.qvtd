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
import org.eclipse.qvt.declarative.editor.ui.pages.AbstractPageFactory;
import org.eclipse.qvt.declarative.editor.ui.pages.PageDefinitions;
import org.eclipse.qvt.declarative.editor.ui.xml.EcoreXMLPageManager;

/**
 * An EcoreXMLPageFactory manages creation of Ecore XML pages.
 */
public class ResourceSetPageFactory extends AbstractPageFactory
{
	public ResourceSetPageFactory(PagedEditor pagedEditor) {
		super(pagedEditor);
	}

	public IMasterPageManager createMasterPageFor(PagedEditor pagedEditor, XMLResource resource, boolean isText) {
		return null;
	}

	public EcoreXMLPageManager createPageFor(PagedEditor pagedEditor, XMLResource resource, boolean isText) {
		TreePageManager pageManager = new TreePageManager(pagedEditor, "ResourceSet");
		pagedEditor.addPageManager(pageManager);
		return null;
	}

	public void createOtherPagesFor(PagedEditor pagedEditor) {
		createPageFor(pagedEditor, null, false);
	}
	
	public void registerAsIn(String name, PageDefinitions pageFactoryRegistries) throws InstantiationException, IllegalAccessException {
		TreePageFactoryRegistry pageFactoryRegistry = pageFactoryRegistries.create(TreePageFactoryRegistry.class);
		pageFactoryRegistry.registerPageFactory(name, this);
	}
}