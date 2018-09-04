/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.merger;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.Partition;

/**
 * LateConsumerMerger replaces one list of MappingRegions by another in which each set of regions that
 * share a consumption and can be merged exploiting knowledge of the schedule is replaced by an
 * equivalent merged region.
 *
 * Preconditions:
 *
 * Late consumer merge must occur at all possible merge sites, or none. That is, a merged region that consumes
 * some node and surrounding predicates at its head must merge with all other regions that consume that
 * head node with non-conflicting predicates.
 *
 * Every predicated edge/node of a late merged region must be shared with or satisfied by the other region.
 */
public class HorizontalPartitionMerger extends AbstractMerger
{
	//	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull RegionAnalysis regionAnalysis;
	protected final @NonNull Iterable<@NonNull Partition> partitions;

	public HorizontalPartitionMerger(@NonNull RegionAnalysis regionAnalysis, @NonNull Iterable<@NonNull Partition> partitions) {
		//		this.scheduleManager = regionAnalysis.getScheduleManager();
		this.regionAnalysis = regionAnalysis;
		this.partitions = partitions;
	}

	public @Nullable Map<@NonNull Partition, @Nullable Partition> merge() {
		//	this.checkedConditionAnalysis = new CheckedConditionAnalysis(regionAnalysis, reachabilityForest);
		Map<@NonNull Partition, @Nullable Partition> old2new = new HashMap<>();
		return null; //old2new;
	}
}
