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

import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.text.ColorManager;
import org.eclipse.qvt.declarative.editor.ui.text.LazyTextPageEditor;

public class XMLPageEditor extends LazyTextPageEditor
{
	private ColorManager colorManager;

	public XMLPageEditor(IPageManager pageManager) {
		super(pageManager, new XMLDocumentProvider(pageManager));
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
	}
	
	@Override public void dispose() {
		colorManager.dispose();
		super.dispose();
	}
}
