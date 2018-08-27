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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.AbstractPartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;

abstract class AbstractPartition extends AbstractPartialRegionAnalysis<@NonNull Partition> implements Partition
{
	protected final @NonNull MappingPartitioner partitioner;
	protected final @NonNull RegionAnalysis regionAnalysis;
	protected final @NonNull TransformationAnalysis transformationAnalysis;
	private int parallelScheduleDepth = -1;

	protected AbstractPartition(@NonNull MappingPartitioner partitioner) {
		super(partitioner.getRegionsPartitionAnalysis(), partitioner.getRegion());
		this.partitioner = partitioner;
		this.regionAnalysis = partitioner.getRegionAnalysis();
		this.transformationAnalysis = regionAnalysis.getTransformationAnalysis();
	}

	@Override
	public void analyzePartition() {
		analyze();
	}

	@Override
	public int getDepth() {
		assert parallelScheduleDepth >= 0;
		return parallelScheduleDepth;
	}

	@Override
	public @Nullable Iterable<@NonNull Partition> getPredecessors() {
		return null;
	}

	//	@Override
	//	public @NonNull Region getRegion() {
	//		return region;
	//	}

	@Override
	public void setDepth(int parallelScheduleDepth) {
		this.parallelScheduleDepth = parallelScheduleDepth;
	}

	@Override
	public String toString() {
		return region.toString();
	}
}