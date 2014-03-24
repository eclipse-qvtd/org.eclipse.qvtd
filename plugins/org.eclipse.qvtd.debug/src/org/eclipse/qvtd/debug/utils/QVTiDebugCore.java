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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.debug.utils.QVTODebugCore;
import org.eclipse.ocl.examples.debug.utils.Trace2;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;
import org.eclipse.qvtd.debug.core.QVTiLineBreakpoint;

/**
 * The activator class controls the plug-in life cycle
 */
public class QVTiDebugCore extends QVTODebugCore
{
	public static final @NonNull QVTiDebugCore INSTANCE = new QVTiDebugCore();
	
	public static final @NonNull String BREAKPOINT_MARKER_ID = "org.eclipse.qvtd.debug.QVTdBreakpointMarker"; //$NON-NLS-1$
	public static final @NonNull String MODEL_ID = "org.eclipse.qvtd.debug"; //$NON-NLS-1$
	public static final @NonNull String DEBUGGER_ACTIVE_PROPERTY = "org.eclipse.qvtd.debug.debuggerActive"; //$NON-NLS-1$
	
	// The plug-in fBreakpointID
	public static final @NonNull String PLUGIN_ID = QVTiDebugPlugin.PLUGIN_ID; //$NON-NLS-1$

	private static final @NonNull String EXCEPTIONS_CATCHING = PLUGIN_ID + "/exceptions/catching"; //$NON-NLS-1$
	private static final @NonNull String EXCEPTIONS_THROWING = PLUGIN_ID + "/exceptions/throwing"; //$NON-NLS-1$
	private static final @NonNull String METHODS_ENTERING = PLUGIN_ID + "/methods/entering"; //$NON-NLS-1$
	private static final @NonNull String METHODS_EXITING = PLUGIN_ID + "/methods/exiting"; //$NON-NLS-1$
	
	public static @NonNull Trace2 TRACE = new Trace2(EXCEPTIONS_CATCHING, EXCEPTIONS_THROWING, METHODS_ENTERING, METHODS_EXITING);

	private QVTiDebugCore() {}

	public @NonNull String getBreakpointMarkerId() {
		return BREAKPOINT_MARKER_ID;
	}

	public @NonNull String getDebuggerActiveProperty() {
		return DEBUGGER_ACTIVE_PROPERTY;
	}
    
	public @NonNull List<QVTiLineBreakpoint> getLineBreakpoints() {
		return getQVTOBreakpoints(QVTiLineBreakpoint.class);
	}
	
	public @NonNull String getModelId() {
		return MODEL_ID;
	}
	
	public @NonNull String getPluginId() {
		return PLUGIN_ID;
	}

	public @NonNull Trace2 getTrace() {
		return TRACE;
	}
	
	public @NonNull String getVMThreadName() {
		return "QVTi VM";
	}	
}
