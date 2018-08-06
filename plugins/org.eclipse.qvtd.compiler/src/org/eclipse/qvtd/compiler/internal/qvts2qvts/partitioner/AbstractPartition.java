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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

abstract class AbstractPartition implements Partition
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull MappingPartitioner partitioner;
	protected final @NonNull MappingRegion region;
	protected final @NonNull RegionAnalysis regionAnalysis;
	protected final @NonNull TransformationAnalysis transformationAnalysis;

	protected AbstractPartition(@NonNull MappingPartitioner partitioner) {
		this.scheduleManager = partitioner.getScheduleManager();
		this.partitioner = partitioner;
		this.region = partitioner.getRegion();
		this.regionAnalysis = partitioner.getRegionAnalysis();
		this.transformationAnalysis = regionAnalysis.getTransformationAnalysis();
	}

	@Override
	public @NonNull Region getRegion() {
		return region;
	}

	@Override
	public String toString() {
		return partitioner.toString();
	}
}