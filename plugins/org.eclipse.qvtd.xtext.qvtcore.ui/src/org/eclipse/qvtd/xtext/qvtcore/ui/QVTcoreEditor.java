/*******************************************************************************
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.ui;

import org.eclipse.qvtd.xtext.qvtcore.ui.internal.QVTcoreActivator;
import org.eclipse.xtext.ui.editor.XtextEditor;

public class QVTcoreEditor extends XtextEditor
{
	public static final String EDITOR_ID = QVTcoreActivator.ORG_ECLIPSE_QVTD_XTEXT_QVTCORE_QVTCORE;

	public QVTcoreEditor() {
		super();
	}
}