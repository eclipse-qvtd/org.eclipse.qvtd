/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.osgi.framework.BundleContext;

public class QVTiDebugPlugin extends Plugin
{
	public static final @NonNull String PLUGIN_ID = "org.eclipse.qvtd.debug";

	private static QVTiDebugPlugin plugin;

	public static QVTiDebugPlugin getDefault() {
		return plugin;
	}

	public static void throwCoreExceptionError(String message, @Nullable Throwable t) throws CoreException {
		if (t != null) {
			StringBuilder s = new StringBuilder();
			s.append(message + "\n");
			StringWriter sw = new StringWriter();
			sw.append(s.toString());
			t.printStackTrace(new PrintWriter(sw));
			message = sw.toString().replaceAll("\\r\\n", "\n");
		}
		/*		if (EcorePlugin.IS_ECLIPSE_RUNNING) {
			try {
				IStatus status;
				if (t instanceof CoreException) {
					status = ((CoreException)t).getStatus();
					// if the 'message' resource string and the IStatus' message are the same,
					// don't show both in the dialog
					if (status != null && message.equals(status.getMessage())) {
						message = null;
					}
				} else {
					status= new Status(IStatus.ERROR, PLUGIN_ID, 0, "Error within Debug UI: ", t); //$NON-NLS-1$
					//				log(status);
				}
				final String finalMessage = message;
				Display display = Display.getDefault();
				if (Thread.currentThread() == display.getThread()) {
					ErrorDialog.openError(null, "QVTd Error", finalMessage, status);
				}
				else {
					display.asyncExec(new Runnable()
					{
						@Override
						public void run() {
							ErrorDialog.openError(null, "QVTd Error", finalMessage, status);
						}
					});
				}
				return;
			}
			catch (Throwable e) {}
		} */
		throw new CoreException(newCoreStatusError(message, t));
	}

	public static @NonNull IStatus newCoreStatusError(String message, @Nullable Throwable e) {
		return new Status(IStatus.ERROR, PLUGIN_ID, 0, message, e);
	}

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		plugin = this;
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		super.stop(bundleContext);
	}
}
