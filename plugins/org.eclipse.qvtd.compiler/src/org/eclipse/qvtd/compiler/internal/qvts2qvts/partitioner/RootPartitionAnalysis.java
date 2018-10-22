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
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

public class RootPartitionAnalysis extends AbstractCompositePartitionAnalysis<RootPartition> implements CompositePartitionAnalysis
{
	public static @NonNull RootPartitionAnalysis createRootPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis,
			@NonNull AbstractTransformationAnalysis transformationAnalysis,
			@NonNull String name, @NonNull Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> partitionAnalysis2predecessors) {
		RootPartition rootPartition = RegionHelper.createRootPartition(name, transformationAnalysis.getScheduleManager());
		transformationAnalysis.getScheduledRegion().setOwnedRootPartition(rootPartition);
		RootPartitionAnalysis rootPartitionAnalysis = new RootPartitionAnalysis(partitionedTransformationAnalysis, rootPartition, partitionAnalysis2predecessors);
		return rootPartitionAnalysis;
	}

	private @Nullable ScheduledRegion scheduledRegion = null;

	private RootPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull RootPartition rootPartition,
			@NonNull Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> partitionAnalysis2predecessors) {
		super(partitionedTransformationAnalysis, rootPartition, partitionAnalysis2predecessors);
		partitionedTransformationAnalysis.setRootPartitionAnalysis(this);
		//		partitionedTransformationAnalysis.addPartitionAnalysis(this);
	}

	@Override
	protected @NonNull List<@NonNull Iterable<@NonNull PartitionAnalysis>> createPartitionSchedule() {
		List<@NonNull Iterable<@NonNull PartitionAnalysis>> flatPartitionSchedule;
		List<@NonNull Iterable<@NonNull PartitionAnalysis>> parallelSchedule = CompilerUtil.computeParallelSchedule(partitionAnalysis2predecessors);
		flatPartitionSchedule = new ArrayList<>();
		for (@NonNull Iterable<@NonNull PartitionAnalysis> concurrency : parallelSchedule) {
			List<@NonNull PartitionAnalysis> flatConcurrency = new ArrayList<>();
			for (@NonNull PartitionAnalysis partitionAnalysis : concurrency) {
				if (partitionAnalysis instanceof CompositePartitionAnalysis) {
					List<@NonNull Iterable<@NonNull PartitionAnalysis>> partitionSchedule2 = ((CompositePartitionAnalysis)partitionAnalysis).getPartitionSchedule();
					for (@NonNull Iterable<@NonNull PartitionAnalysis> concurrency2 : partitionSchedule2) {	// FIXME Avoid flattening
						for (@NonNull PartitionAnalysis partition2 : concurrency2) {
							flatConcurrency.add(partition2);
						}
					}
				}
				else {
					flatConcurrency.add(partitionAnalysis);
				}
			}
			flatPartitionSchedule.add(flatConcurrency);
		}
		return flatPartitionSchedule;
	}

	public @NonNull ScheduledRegion getScheduledRegion() {
		return ClassUtil.nonNullState(scheduledRegion);
	}

	public void setScheduledRegion(@NonNull ScheduledRegion scheduledRegion) {
		this.scheduledRegion = scheduledRegion;
	}

	//		@Override
	//		public boolean isRealized(@NonNull Edge edge) {
	//			throw new UnsupportedOperationException();
	//		}
}