/*******************************************************************************
 * Copyright (c) 2011, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.ui;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Use this class to register components to be used within the IDE.
 */
public class QVTbaseUiModule extends org.eclipse.qvtd.xtext.qvtbase.ui.AbstractQVTbaseUiModule
{
	public static final @NonNull String PLUGIN_ID = "org.eclipse.qvtd.xtext.qvtbase.ui";
	public static final @NonNull String MARKER_ID = "org.eclipse.qvtd.xtext.qvtbase.ui.Marker";

	public QVTbaseUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
}
