/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

public interface PartialRegionAnalysis<@NonNull PRA extends PartialRegionsAnalysis> extends Nameable
{
	@Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> getConsumedTraceClassAnalyses();
	@Nullable Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> getConsumedTracePropertyAnalyses();
	@Nullable Iterable<@NonNull PartialRegionAnalysis<@NonNull PRA>> getExplicitPredecessors();
	@NonNull Partition getPartition();
	@NonNull Region getRegion();
	@NonNull Iterable<@NonNull Node> getTraceNodes();
	@Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> getProducedTraceClassAnalyses();
	@Nullable Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> getProducedTracePropertyAnalyses();
	@Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> getSuperProducedTraceClassAnalyses();
}