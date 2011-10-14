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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.qvt.declarative.editor.ui.IMasterPageManager;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.qvt.declarative.editor.ui.text.TextResource;

/**
 * The map of Registries of Page Factories; one registry per major page editing style such as
 * Text, Diagram, XML, Tree.
 */
public class PageDefinitions
{
	private final Map<Class<? extends IPageFactoryRegistry<?>>, IPageFactoryRegistry<?>> map = new HashMap<Class<? extends IPageFactoryRegistry<?>>, IPageFactoryRegistry<?>>();

	public <T extends IPageFactoryRegistry<?>> T create(Class<T> key) throws InstantiationException, IllegalAccessException {
		IPageFactoryRegistry<?> pageFactoryRegistry = map.get(key);
		if (pageFactoryRegistry == null) {
			pageFactoryRegistry = key.newInstance();
			map.put(key, pageFactoryRegistry);
		}			
		return get(key);
	}

	public IMasterPageManager createMasterPageFor(PagedEditor pagedEditor, XMLResource resource, TextResource textResource) {
		for (IPageFactoryRegistry<?> pageFactoryRegistry : map.values()) {
			IMasterPageManager pageManager = pageFactoryRegistry.createMasterPageFor(pagedEditor, resource, textResource);
			if (pageManager != null)
				return pageManager;
		}
		return null;
	}

	public void createOtherPagesFor(PagedEditor pagedEditor) {
		for (IPageFactoryRegistry<?> pageFactoryRegistry : map.values())
			pageFactoryRegistry.createOtherPagesFor(pagedEditor);
	}

	@SuppressWarnings("unchecked")
	public <T extends IPageFactoryRegistry<?>> T get(Class<T> key) {
		return (T) map.get(key);
	}
}
