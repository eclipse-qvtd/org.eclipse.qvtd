package org.eclipse.qvtd.debug.utils;
/*******************************************************************************
 * Copyright (c) 2009 R.Dvorak and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Radek Dvorak - initial API and implementation
 *******************************************************************************/

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class QVTiDebugCore extends org.eclipse.ocl.examples.debug.utils.QVTODebugCore {
	
	public static final @NonNull String BREAKPOINT_MARKER_ID = "org.eclipse.qvtd.debug.QVTdBreakpointMarker"; //$NON-NLS-1$

	public static final @NonNull String MODEL_ID = "org.eclipse.qvtd.debug"; //$NON-NLS-1$
	
	public static final @NonNull String DEBUGGER_ACTIVE_PROPERTY = "org.eclipse.qvtd.debug.debuggerActive"; //$NON-NLS-1$
	
	// The plug-in fBreakpointID
	public static final @NonNull String PLUGIN_ID = QVTiDebugPlugin.PLUGIN_ID; //$NON-NLS-1$

	/**
	 * The constructor
	 */
	public QVTiDebugCore() {
		super();
	}
}
