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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.paged.PagedFileDocumentProvider;

@Deprecated // Use UniversalTextEditor
public class TextDocumentProvider extends PagedFileDocumentProvider
{
	public TextDocumentProvider(IPageManager pageManager) {
		super(pageManager);
	}

	/* (non-Javadoc)
	 * Method declared on AbstractDocumentProvider
	 */
	@Override protected IDocument createDocument(Object element) throws CoreException {
		IDocument document = super.createDocument(element);	// FIXME can throw ResourceException 
		if (document != null) {
			IDocumentPartitioner partitioner =
				new FastPartitioner(
					new TextPartitionScanner(),
                    TextPartitionScanner.getConfiguredContentTypes());
			partitioner.connect(document);
			document.setDocumentPartitioner(partitioner);
		}
		return document;
	}
}