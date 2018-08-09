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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import com.google.common.collect.Iterables;

public class RootPartition /*extends AbstractPartialRegionAnalysis<@NonNull Partition>*/ //implements Partition
{
	protected final @NonNull Iterable<@NonNull Partition> partitions;
	protected final @NonNull List<@NonNull MappingRegion> partitionedRegions;

	public RootPartition(@NonNull Iterable<@NonNull Partition> partitions) {
		this.partitions = partitions;
		this.partitionedRegions = new ArrayList<>(Iterables.size(partitions));
		int partitionNumber = 0;
		Region currentRegion = null;
		for (@NonNull Partition partition : partitions) {
			Region partitionRegion = partition.getRegion();
			if (currentRegion != partitionRegion) {
				currentRegion = partitionRegion;
				partitionNumber = 0;
			}
			partitionedRegions.add(partition.createMicroMappingRegion(partitionNumber++));
		}
	}

	public @NonNull Iterable<@NonNull MappingRegion> getPartitionedRegions() {
		return partitionedRegions;
	}
}