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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;

public class LoadingPartitionAnalysis extends AbstractPartitionAnalysis<LoadingPartition>
{
	public static @NonNull LoadingPartitionAnalysis createLoadingPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis,
			@NonNull LoadingRegion loadingRegion) {
		RegionHelper<@NonNull LoadingRegion> regionHelper = new RegionHelper<@NonNull LoadingRegion>(partitionedTransformationAnalysis.getScheduleManager(), loadingRegion);
		LoadingPartition loadingPartition = regionHelper.createLoadingPartition();
		return new LoadingPartitionAnalysis(partitionedTransformationAnalysis, loadingPartition);
	}

	public LoadingPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull LoadingPartition partition) {
		super(partitionedTransformationAnalysis, partition);
		partitionedTransformationAnalysis.addPartitionAnalysis(this);
	}

	@Override
	public void analyzePartition2() {
		partitionedTransformationAnalysis.setLoadingRegionAnalysis(this);
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getConsumedTraceClassAnalyses() {
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getConsumedTracePropertyAnalyses() {
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getProducedTraceClassAnalyses() {
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getProducedTracePropertyAnalyses() {
		return null;
	}

	@Override
	public @Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getSuperProducedTraceClassAnalyses() {
		return null;
	}
}