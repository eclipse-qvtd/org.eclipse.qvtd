/*******************************************************************************
 * Copyright (c) 2014, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     R.Dvorak and others - QVTo debugger framework
 *     E.D.Willink - revised API for OCL/QVTi debugger framework
 *******************************************************************************/
package org.eclipse.qvtd.debug.core;

import java.util.List;

import org.eclipse.core.runtime.ILog;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.debug.vm.core.VMDebugCore;
import org.eclipse.ocl.examples.debug.vm.utils.Trace;
import org.eclipse.ocl.xtext.essentialocl.as2cs.EssentialOCLLocationInFileProvider;
import org.eclipse.qvtd.debug.QVTiDebugPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class QVTiDebugCore extends VMDebugCore
{
	public static final @NonNull QVTiDebugCore INSTANCE = new QVTiDebugCore();

	public static final @NonNull String BREAKPOINT_MARKER_ID = "org.eclipse.qvtd.debug.QVTdBreakpointMarker"; //$NON-NLS-1$
	public static final @NonNull String MODEL_ID = "org.eclipse.qvtd.debug"; //$NON-NLS-1$
	public static final @NonNull String DEBUGGER_ACTIVE_PROPERTY = "org.eclipse.qvtd.debug.debuggerActive"; //$NON-NLS-1$

	// The plug-in fBreakpointID
	public static final @NonNull String PLUGIN_ID = QVTiDebugPlugin.PLUGIN_ID;

	private static final @NonNull String EXCEPTIONS_CATCHING = PLUGIN_ID + "/exceptions/catching"; //$NON-NLS-1$
	private static final @NonNull String EXCEPTIONS_THROWING = PLUGIN_ID + "/exceptions/throwing"; //$NON-NLS-1$
	private static final @NonNull String METHODS_ENTERING = PLUGIN_ID + "/methods/entering"; //$NON-NLS-1$
	private static final @NonNull String METHODS_EXITING = PLUGIN_ID + "/methods/exiting"; //$NON-NLS-1$

	private static final @NonNull EssentialOCLLocationInFileProvider locationInFileProvider = new EssentialOCLLocationInFileProvider();

	public static @NonNull Trace TRACE = new Trace(EXCEPTIONS_CATCHING, EXCEPTIONS_THROWING, METHODS_ENTERING, METHODS_EXITING);

	private QVTiDebugCore() {}

	@Override
	public @NonNull String getBreakpointMarkerId() {
		return BREAKPOINT_MARKER_ID;
	}

	@Override
	public @NonNull String getDebugTargetName() {
		return "QVTi Debug target";
	}

	@Override
	public @NonNull String getDebugThreadName() {
		return "QVTi Debug UI";
	}

	@Override
	public @NonNull String getDebuggerActiveProperty() {
		return DEBUGGER_ACTIVE_PROPERTY;
	}

	@Override
	public @NonNull List<@NonNull QVTiLineBreakpoint> getLineBreakpoints() {
		return getOCLBreakpoints(QVTiLineBreakpoint.class);
	}

	@Override
	public @NonNull EssentialOCLLocationInFileProvider getLocationInFileProvider() {
		return locationInFileProvider;
	}

	@Override
	public @Nullable ILog getLog() {
		QVTiDebugPlugin debugPlugin = QVTiDebugPlugin.getDefault();
		return debugPlugin != null ? debugPlugin.getLog() : null;
	}

	@Override
	public @NonNull String getModelId() {
		return MODEL_ID;
	}

	@Override
	public @NonNull String getPluginId() {
		return PLUGIN_ID;
	}

	@Override
	public @NonNull Trace getTrace() {
		return TRACE;
	}

	@Override
	public @NonNull String getVMThreadName() {
		return "QVTi Debug VM";
	}
}
