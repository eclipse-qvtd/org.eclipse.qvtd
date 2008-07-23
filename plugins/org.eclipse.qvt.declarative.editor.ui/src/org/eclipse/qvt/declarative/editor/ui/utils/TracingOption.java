/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.editor.ui.utils;

import org.eclipse.core.runtime.Platform;
import org.eclipse.qvt.declarative.editor.ui.plugin.QVTEditorPlugin;

public final class TracingOption
{
	public static final TracingOption DEBUG = new TracingOption("debug"); //$NON-NLS-1$

	public static final TracingOption EDITOR_SAVE = new TracingOption("editor/save"); //$NON-NLS-1$

	public static final TracingOption RESOURCE_LOAD = new TracingOption("resource/load"); //$NON-NLS-1$

	private final String option;
	private Boolean cache = null;
	
	public TracingOption(String option) {
		this(QVTEditorPlugin.PLUGIN_ID, option);
	}
	
	public TracingOption(String pluginId, String option) {
		this.option = pluginId + "/" + option;
	}

	public boolean isActive() {
		if (cache == null) {
			String debugOption = Platform.getDebugOption(option);
			boolean isTrue = Boolean.TRUE.toString().equalsIgnoreCase(debugOption);
			cache = Boolean.valueOf(isTrue);
		}
		return cache.booleanValue();
	}

	public void println(String string) {
		if (cache.booleanValue())		// May NPE if isActive() guard was omitted.
			System.out.println(option + " : " + string);		
	}

	public void println(Class<?> clazz, String string) {
		if (cache.booleanValue())		// May NPE if isActive() guard was omitted.
			System.out.println(option + " : " + clazz.getSimpleName() + " : " + string);		
	}
}
