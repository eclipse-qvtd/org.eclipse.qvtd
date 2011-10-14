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

import org.eclipse.qvt.declarative.editor.ui.ICreationFactory;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedEditor;


public abstract class AbstractPageFactory implements IPageFactory
{
	protected final PagedEditor pagedEditor;
	protected final ICreationFactory creationFactory;
	
	protected AbstractPageFactory(PagedEditor pagedEditor, ICreationFactory creationFactory) {
		this.pagedEditor = pagedEditor;
		this.creationFactory = creationFactory;
	}
	
	protected AbstractPageFactory(PagedEditor pagedEditor) {
		this(pagedEditor, pagedEditor.getCreationFactory());
	}
	
	public ICreationFactory getCreationFactory() {
		return creationFactory;
	}
//	public void registerIn(PageFactoryRegistries pageFactoryRegistries) {
//		IPageFactoryRegistry pageFactoryRegistry = getPageFactoryRegistry();
//		pageFactoryRegistries.put(pageFactoryRegistry);
//		pageFactoryRegistry.addPageFactory(name, pageFactory);
//	}
}