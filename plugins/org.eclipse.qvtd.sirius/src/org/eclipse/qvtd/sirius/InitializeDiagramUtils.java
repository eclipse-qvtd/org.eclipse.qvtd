/*******************************************************************************
 * Copyright (c) 2024 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.sirius;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.FrameworkUtil;

public class InitializeDiagramUtils
{
	private static final Logger logger = Logger.getLogger(InitializeDiagramUtils.class);
	private static final @NonNull String DIALOG_TITLE = "Initialize Diagram Error";

	@SuppressWarnings("null")
	public static @NonNull String PLUGIN_ID = FrameworkUtil.getBundle(InitializeDiagramUtils.class).getSymbolicName();

	public static void openError(Shell activeShell, String dialogMessage, String statusMessage) {
		Status status = new Status(IStatus.ERROR, PLUGIN_ID, 0, statusMessage, null);
		ErrorDialog.openError(activeShell, DIALOG_TITLE, dialogMessage, status);
	}

	public static void openError(@NonNull String dialogMessage, String statusMessage, @Nullable Throwable t) {
		int severity = IStatus.ERROR;
		int code = 0;
		Status status;
		if (t != null) {
			MultiStatus multiStatus = new MultiStatus(PLUGIN_ID, code, statusMessage);
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			t.printStackTrace(new PrintStream(os));
			BufferedReader r = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(os.toByteArray())));
			try {
				for (String line; (line = r.readLine()) != null; ) {
					multiStatus.add(new Status(severity, PLUGIN_ID, line));
				}
			} catch (IOException e) {
				logger.warn("Failed to read printStackTrace output", e);
			}
			status = multiStatus;
		}
		else {
			status = new Status(severity, PLUGIN_ID, code, statusMessage, t);
		}
		Display.getDefault().asyncExec(new Runnable()
		{
			@Override
			public void run() {
				ErrorDialog.openError(null, DIALOG_TITLE, dialogMessage, status);
			}
		});
	}
}
