/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;

/**
 * The FallibilityAnalysis identifies why individual Mappings may fail allowing cycles of Mappings whose
 * cycle members succeed conditionally to succeed unconditionally.
 *
 * The regions/mappings are first accumulate()'d, then the closure of the accumulated results are install()'d
 * within each RegionAnalysis.
 */
public interface FallibilityAnalysis
{
	public static final @NonNull TracingOption GLOBAL = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/fallibility/global");
	public static final @NonNull TracingOption LOCAL = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/fallibility/local");

	/**
	 * Return true if speculative execution of the associated partition analysis is guaranteed to succeed.
	 */
	boolean isInfallible();

	/**
	 * Return true if speculative execution of the associated partition analysis is guaranteed to terminate.
	 */
	boolean isTerminating();
}