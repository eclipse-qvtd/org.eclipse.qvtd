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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Concurrency;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;

public class RootPartitionAnalysis extends AbstractCompositePartitionAnalysis<@NonNull RootPartition>
{
	public static @NonNull RootPartitionAnalysis createRootPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis,
			@NonNull AbstractTransformationAnalysis transformationAnalysis,
			@NonNull String name, @NonNull Map<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> partitionAnalysis2predecessors) {
		RootPartition rootPartition = RegionHelper.createRootPartition(name, transformationAnalysis.getScheduleManager());
		transformationAnalysis.getRootRegion().setOwnedRootPartition(rootPartition);
		RootPartitionAnalysis rootPartitionAnalysis = new RootPartitionAnalysis(partitionedTransformationAnalysis, rootPartition, partitionAnalysis2predecessors);
		return rootPartitionAnalysis;
	}

	private @Nullable RootRegion rootRegion = null;

	private RootPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull RootPartition rootPartition,
			@NonNull Map<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>, @NonNull Set<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>> partitionAnalysis2predecessors) {
		super(partitionedTransformationAnalysis, rootPartition, partitionAnalysis2predecessors);
		partitionedTransformationAnalysis.setRootPartitionAnalysis(this);
		//		partitionedTransformationAnalysis.addPartitionAnalysis(this);
	}

	@Override
	protected @NonNull List<@NonNull Concurrency> createPartitionSchedule() {
		List<@NonNull Concurrency>  flatPartitionSchedule = new ArrayList<>();
		Iterable<@NonNull Concurrency> parallelSchedule = CompilerUtil.computeParallelSchedule(originalPartitionAnalysis2predecessors, TransformationPartitioner.ROOT_SCHEDULE_PREDECESSORS);
		if (TransformationPartitioner.ROOT_SCHEDULE.isActive()) {
			CompilerUtil.traceSchedule(TransformationPartitioner.ROOT_SCHEDULE, getName(), parallelSchedule);
		}
		for (@NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> concurrency : parallelSchedule) {
			appendConcurrency(flatPartitionSchedule, concurrency);
		}
		if (TransformationPartitioner.PARALLEL_SCHEDULE.isActive()) {
			CompilerUtil.traceSchedule(TransformationPartitioner.PARALLEL_SCHEDULE, null, flatPartitionSchedule);
		}
		return flatPartitionSchedule;
	}

	public @NonNull RootRegion getRootRegion() {
		return ClassUtil.nonNullState(rootRegion);
	}

	public void setRootRegion(@NonNull RootRegion rootRegion) {
		this.rootRegion = rootRegion;
	}

	//		@Override
	//		public boolean isRealized(@NonNull Edge edge) {
	//			throw new UnsupportedOperationException();
	//		}
}