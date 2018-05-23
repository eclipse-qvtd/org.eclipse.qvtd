/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.ui;

import org.eclipse.ocl.xtext.base.ui.BaseEditor;
import org.eclipse.qvtd.xtext.qvtimperative.ui.internal.QVTimperativeActivator;

public class QVTimperativeEditor extends BaseEditor
{
	public static final String EDITOR_ID = QVTimperativeActivator.ORG_ECLIPSE_QVTD_XTEXT_QVTIMPERATIVE_QVTIMPERATIVE;

	public QVTimperativeEditor() {
		super();
	}

	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		setEditorContextMenuId("#QVTimperativeEditorContext"); //$NON-NLS-1$
		setRulerContextMenuId("#QVTimperativeRulerContext"); //$NON-NLS-1$
		//		setHelpContextId(ITextEditorHelpContextIds.TEXT_EDITOR);
	}
}
