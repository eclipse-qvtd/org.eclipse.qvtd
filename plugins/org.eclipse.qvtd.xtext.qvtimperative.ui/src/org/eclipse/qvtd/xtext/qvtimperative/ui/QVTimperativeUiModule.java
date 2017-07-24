/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.ui;

import org.eclipse.qvtd.xtext.qvtimperative.ui.internal.QVTimperativeActivator;
import org.eclipse.qvtd.xtext.qvtimperative.ui.model.QVTimperativeDocumentProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class QVTimperativeUiModule extends AbstractQVTimperativeUiModule
{
	public static final String PLUGIN_ID = "org.eclipse.qvtd.xtext.qvtimperative.ui";
	public static final String EDITOR_ID = QVTimperativeActivator.ORG_ECLIPSE_QVTD_XTEXT_QVTIMPERATIVE_QVTIMPERATIVE;

	public QVTimperativeUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends XtextDocumentProvider> bindXtextDocumentProvider() {
		return QVTimperativeDocumentProvider.class;
	}
}
