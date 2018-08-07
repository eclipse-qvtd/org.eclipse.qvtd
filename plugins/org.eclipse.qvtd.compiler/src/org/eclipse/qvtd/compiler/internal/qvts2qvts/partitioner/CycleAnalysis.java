/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.PartialRegionAnalysis;

/**
 * Each CycleAnalysis identifies one group of regionAnalyses that contribute to a cycle.
 */
public interface CycleAnalysis<@NonNull RA extends PartialRegionAnalysis<@NonNull RA>>
{
	public @NonNull Iterable<@NonNull RA> getRegionAnalyses();

	public @NonNull Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> getTraceClassAnalyses();

	public @NonNull Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> getTracePropertyAnalyses();

	public @NonNull RA getRA();
}
