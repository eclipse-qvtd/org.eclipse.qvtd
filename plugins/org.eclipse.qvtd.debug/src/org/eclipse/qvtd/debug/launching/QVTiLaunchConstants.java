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
package org.eclipse.qvtd.debug.launching;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;

public interface QVTiLaunchConstants
{
	public static final @NonNull String LAUNCH_CONFIGURATION_TYPE_ID = "org.eclipse.qvtd.debug.launching.QVTiLaunchConfigurationDelegate";

	/**
	 * ILaunchConfiguration Boolean attribute for the auto-build of the transformation chain.
	 */
	public static final @NonNull String AUTO_BUILD_KEY = "auto-build";

	/**
	 * ILaunchConfiguration Boolean attribute for generation of *.dot graphs of the scheduling.
	 */
	public static final @NonNull String DOT_GRAPHS_KEY = "dot-graphs";

	public static final @NonNull Map<String, String> EMPTY_MAP = new HashMap<String,String>();

	/**
	 * ILaunchConfiguration String attribute for the genmodel resource.
	 */
	public static final @NonNull String GENMODEL_KEY = "genmodel";

	/**
	 * ILaunchConfiguration Map<String,String> attribute for the intermediate resource per intermediate model name.
	 */
	public static final @NonNull String INTERMEDIATES_KEY = "intermediates";

	/**
	 * ILaunchConfiguration Boolean attribute for the interpreted rather than code generated execution.
	 */
	public static final @NonNull String INTERPRETED_KEY = "interpreted";

	/**
	 * ILaunchConfiguration Map<String,String> attribute for the input resource per input model name.
	 */
	public static final @NonNull String NEW_IN_KEY = "in";

	/**
	 * ILaunchConfiguration Map<String,String> attribute for the output resource per output model name.
	 */
	public static final @NonNull String NEW_OUT_KEY = "out";

	/**
	 * ILaunchConfiguration Map<String,String> attribute for previous/reference input resource per input model name.
	 */
	public static final @NonNull String OLD_IN_KEY = "old-in";

	/**
	 * ILaunchConfiguration Map<String,String> attribute for the previous/referenceoutput resource per output model name.
	 */
	public static final @NonNull String OLD_OUT_KEY = "old-out";

	/**
	 * ILaunchConfiguration String attribute for the default project.
	 */
	public static final @NonNull String PROJECT_KEY = "project";

	/**
	 * ILaunchConfiguration String attribute for the textual trace evaluation option.
	 */
	public static final @NonNull String TRACE_EVALUATION_KEY = "console-trace";

	/**
	 * ILaunchConfiguration String attribute for the transformation resource.
	 */
	public static final @NonNull String TX_KEY = "tx";

	/**
	 * ILaunchConfiguration Boolean attribute for generation of *.graphml graphs of the scheduling.
	 */
	public static final @NonNull String YED_GRAPHS_KEY = "yed-graphs";

	public static final @NonNull String ENFORCE_UPDATE_MODE = "ENFORCE - UPDATE";
	public static final @NonNull String ENFORCE_CREATE_MODE = "ENFORCE - CREATE";
	public static final @NonNull String CHECK_MODE = "CHECK";


	//	String PREFIX = "org.eclipse.qvtd.debug.";  //$NON-NLS-1$
	//	String MODULE           = PREFIX + "module"; //$NON-NLS-1$


}
