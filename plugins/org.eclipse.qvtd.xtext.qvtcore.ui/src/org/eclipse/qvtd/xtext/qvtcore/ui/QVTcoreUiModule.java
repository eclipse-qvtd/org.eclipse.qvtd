/*******************************************************************************
 * Copyright (c) 2011, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcore.ui;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.base.ui.commands.ToggleNatureCommand;
import org.eclipse.qvtd.xtext.qvtbase.ui.QVTbaseJavaClassPathResourceForIEditorInputFactory;
import org.eclipse.qvtd.xtext.qvtbase.ui.commands.ToggleQVTdNatureCommand;
import org.eclipse.qvtd.xtext.qvtcore.ui.internal.QVTcoreActivator;
import org.eclipse.qvtd.xtext.qvtcore.ui.model.QVTcoreDocumentProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;

/**
 * Use this class to register components to be used within the IDE.
 */
public class QVTcoreUiModule extends org.eclipse.qvtd.xtext.qvtcore.ui.AbstractQVTcoreUiModule
{
	public static final @NonNull String PLUGIN_ID = "org.eclipse.qvtd.xtext.qvtcore.ui";
	@SuppressWarnings("null")
	public static final @NonNull String EDITOR_ID = QVTcoreActivator.ORG_ECLIPSE_QVTD_XTEXT_QVTCORE_QVTCORE;
	public static final @NonNull String MARKER_ID = "org.eclipse.qvtd.xtext.qvtcore.ui.Marker";

	public QVTcoreUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public Class<? extends XtextDocumentProvider> bindXtextDocumentProvider() {
		return QVTcoreDocumentProvider.class;
	}

	@Override
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return QVTbaseJavaClassPathResourceForIEditorInputFactory.class;
	}

	public Class<? extends ToggleNatureCommand> bindToggleNatureCommand() {
		return ToggleQVTdNatureCommand.class;
	}
}
