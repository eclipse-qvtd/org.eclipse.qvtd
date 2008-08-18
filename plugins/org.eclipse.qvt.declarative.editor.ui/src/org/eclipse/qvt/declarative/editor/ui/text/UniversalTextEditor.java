/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: UniversalTextEditor.java,v 1.1 2008/08/18 07:46:26 ewillink Exp $
 */
package org.eclipse.qvt.declarative.editor.ui.text;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.imp.editor.UniversalEditor;
import org.eclipse.jface.text.ITextViewerExtension6;
import org.eclipse.jface.text.IUndoManager;
import org.eclipse.jface.text.IUndoManagerExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.text.ITextEditorWithUndoContext;

public class UniversalTextEditor extends UniversalEditor implements ITextEditorWithUndoContext
{
	protected final IPageManager pageManager;

	public UniversalTextEditor(IPageManager editorPageManager) {
		this.pageManager = editorPageManager;
	}
	
	public IUndoContext getUndoContext() {
		ISourceViewer sourceViewer = getSourceViewer();
		if (sourceViewer instanceof ITextViewerExtension6) {
			IUndoManager undoManager= ((ITextViewerExtension6)sourceViewer).getUndoManager();
			if (undoManager instanceof IUndoManagerExtension)
				return ((IUndoManagerExtension)undoManager).getUndoContext();
		}
		return null;
	}
}
