/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtrelation.ui;

import org.eclipse.ocl.xtext.base.ui.BaseEditor;
import org.eclipse.qvtd.xtext.qvtrelation.ui.internal.QVTrelationActivator;

public class QVTrelationEditor extends BaseEditor
{
	public static final String EDITOR_ID = QVTrelationActivator.ORG_ECLIPSE_QVTD_XTEXT_QVTRELATION_QVTRELATION;

	public QVTrelationEditor() {
		super();
	}

	@Override
	protected void initializeEditor() {
		super.initializeEditor();
		setEditorContextMenuId("#QVTrelationEditorContext"); //$NON-NLS-1$
		setRulerContextMenuId("#QVTrelationRulerContext"); //$NON-NLS-1$
		//		setHelpContextId(ITextEditorHelpContextIds.TEXT_EDITOR);
	}
}