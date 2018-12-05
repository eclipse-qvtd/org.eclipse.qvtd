/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.launching;

import org.eclipse.jdt.annotation.NonNull;

public interface QVTcLaunchConstants extends QVTiLaunchConstants
{
	public static final @NonNull String LAUNCH_CONFIGURATION_TYPE_ID = "org.eclipse.qvtd.debug.launching.QVTcLaunchConfigurationDelegate";

	/**
	 * ILaunchConfiguration String attribute for the transformation direction.
	 */
	public static final @NonNull String DIRECTION_KEY = "direction";

	/**
	 * ILaunchConfiguration String attribute for the transformation mode.
	 */
	public static final @NonNull String MODE_KEY = "mode";

	/**
	 * ILaunchConfiguration Boolean attribute for the transformation partial view selection.
	 */
	public static final @NonNull String VIEW_KEY = "view";
}
