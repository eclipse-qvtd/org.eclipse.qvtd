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
import org.eclipse.qvt.declarative.ecore.adapters.AdaptingXMIResource;
import org.eclipse.qvt.declarative.editor.ui.IMasterPageManager;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;

/**
 * An EcoreXMLPageFactory manages creation of Ecore-based XML pages.
 */
public class EcoreXMLPageFactory extends XMLPageFactory
{
	public static final String PAGE_TITLE = "Ecore XMI";

	public EcoreXMLPageFactory(PagedEditor pagedEditor) {
		super(pagedEditor);
	}
	
	@Override
	public IMasterPageManager createMasterPageFor(PagedEditor pagedEditor, XMLResource resource) {
		if (!isEPackageBased(resource) && !resource.getContents().isEmpty())
			return null;
		AdaptingXMIResource adapter = AdaptingXMIResource.findAdapter(resource);
		if (adapter != null)
			return null;
		return createPageFor(pagedEditor, resource);
	}

	@Override
	public void createOtherPagesFor(PagedEditor pagedEditor) {
		IMasterPageManager masterPageManager = pagedEditor.getMasterPageManager();
		if (masterPageManager instanceof EcoreXMLPageManager)
			return;
		XMLResource resource = masterPageManager.getEcoreResource();
		createPageFor(masterPageManager.getPagedEditor(), resource);
	}

	@Override
	public EcoreXMLPageManager createPageFor(PagedEditor pagedEditor, XMLResource resource) {
		EcoreXMLPageManager pageManager = new EcoreXMLPageManager(pagedEditor, resource, PAGE_TITLE);
		pagedEditor.addPageManager(pageManager);
		return pageManager;
	}
}