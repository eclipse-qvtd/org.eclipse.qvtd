/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui.paged;

import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.ui.editors.text.FileDocumentProvider;

public class PagedFileDocumentProvider extends FileDocumentProvider
{
	protected final IPageManager pageManager;
	
	public PagedFileDocumentProvider(IPageManager pageManager) {
		this.pageManager = pageManager;
	}

	@Override
	protected IDocument createEmptyDocument() {
		return new Document()
		{
			@Override
			public String toString() {
				return pageManager.toString();
			}
		};
	}
}