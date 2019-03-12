/*******************************************************************************
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.ui;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.base.ui.BaseEditor;
import org.eclipse.qvtd.xtext.qvtcore.ui.internal.QVTcoreActivator;

public class QVTcoreEditor extends BaseEditor
{
	public static final String EDITOR_ID = QVTcoreActivator.ORG_ECLIPSE_QVTD_XTEXT_QVTCORE_QVTCORE;

	public QVTcoreEditor() {
		super();
	}

	@Override
	public @NonNull String getMarkerId() {
		return QVTcoreUiModule.MARKER_ID;
	}

	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		setEditorContextMenuId("#QVTcoreEditorContext"); //$NON-NLS-1$
		setRulerContextMenuId("#QVTcoreRulerContext"); //$NON-NLS-1$
		//		setHelpContextId(ITextEditorHelpContextIds.TEXT_EDITOR);
	}
}