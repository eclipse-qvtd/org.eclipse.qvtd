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
package org.eclipse.qvt.declarative.editor.qvtrelation.ui;

import org.eclipse.qvt.declarative.editor.ui.IPageManager;
import org.eclipse.qvt.declarative.editor.ui.text.TextPageEditor;

public class QVTrTextEditor extends TextPageEditor
{
	public QVTrTextEditor(IPageManager editorPageManager) {
		super(editorPageManager);
		setSourceViewerConfiguration(new QVTrTextConfiguration(colorManager));
	}
}
