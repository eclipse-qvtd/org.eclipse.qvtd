/*******************************************************************************
 * Copyright (c) 2013 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.jdt.annotation.NonNull;
import org.osgi.framework.BundleContext;

public class QVTiDebugPlugin extends Plugin
{
	public static final @NonNull String PLUGIN_ID = "org.eclipse.qvtd.debug";
	
	private static QVTiDebugPlugin plugin;

	public static QVTiDebugPlugin getDefault() {
		return plugin;
	}

	public void start(BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		plugin = this;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		plugin = null;
		super.stop(bundleContext);
	}
}
