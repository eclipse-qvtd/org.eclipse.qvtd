/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.debug.launching;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

public interface QVTiLaunchConstants
{
	public static final @NonNull Map<String, String> EMPTY_MAP = new HashMap<String,String>();

	/**
	 * ILaunchConfiguration String attribute for the transformation resource.
	 */
	public static final @NonNull String TX_KEY = "tx";

	/**
	 * ILaunchConfiguration Map<String,String> attribute for the input resource per input model name.
	 */
	public static final @NonNull String IN_KEY = "in";

	/**
	 * ILaunchConfiguration Map<String,String> attribute for the output resource per output model name.
	 */
	public static final @NonNull String OUT_KEY = "out";



//	String PREFIX = "org.eclipse.qvtd.debug.";  //$NON-NLS-1$
//	String MODULE           = PREFIX + "module"; //$NON-NLS-1$


}
