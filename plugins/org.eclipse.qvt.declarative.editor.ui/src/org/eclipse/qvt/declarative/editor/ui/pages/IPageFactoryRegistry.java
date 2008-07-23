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

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.qvt.declarative.editor.ui.IMasterPageManager;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;
import org.eclipse.qvt.declarative.editor.ui.text.TextResource;

/**
 * A derived IPageFactoryRegistry manages a set of derived IPageFactory registrations and
 * supports creation of the appropriate content-specific editing page.
 */
public interface IPageFactoryRegistry<T extends IPageFactory>
{
	/**
	 * Create the master page editor for pagedEditor that fully supports editing resource in isText mode.
	 * 
	 * @param pagedEditor the overall paged editor
	 * @param resource the resource being edited
	 * @param isText true if the resource originated from a textual CST
	 * @return the master page editor
	 */
	public IMasterPageManager createMasterPageFor(PagedEditor pagedEditor, XMLResource resource, TextResource textResource);

	/**
	 * Create any pages in pagedEditor (other than the master page) that should appear
	 * when the paged editor starts up.
	 * 
	 * @param pagedEditor the overall paged editor
	 */
	public void createOtherPagesFor(PagedEditor pagedEditor);

	/**
	 * Register pageFactort as suitable for editing contentType.
	 * @param contentType particular page variant   
	 * @param pageFactory to be registered
	 */
	public void registerPageFactory(String contentType, T pageFactory);
}