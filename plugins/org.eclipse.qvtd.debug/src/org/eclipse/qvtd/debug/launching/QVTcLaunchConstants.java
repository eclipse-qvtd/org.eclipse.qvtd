/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.debug.launching;

import org.eclipse.jdt.annotation.NonNull;

public interface QVTcLaunchConstants extends QVTiLaunchConstants
{
	/**
	 * ILaunchConfiguration String attribute for the transformation direction.
	 */
	public static final @NonNull String DIRECTION_KEY = "direction";

	/**
	 * ILaunchConfiguration String attribute for the transformation mode.
	 */
	public static final @NonNull String MODE_KEY = "mode";

	/**
	 * ILaunchConfiguration Boolean attribute for the transformation partiality.
	 */
	public static final @NonNull String PARTIAL_KEY = "partial";
}
