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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.PartialRegionAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;

public interface Partition extends PartialRegionAnalysis<@NonNull Partition>
{
	void analyzePartition();

	@NonNull MappingRegion createMicroMappingRegion();

	int getDepth();

	@NonNull MappingRegion getMicroMappingRegion();

	@NonNull Region getOriginalRegion();

	@Nullable Role getRole(@NonNull Edge edge);

	@Nullable Role getRole(@NonNull Node node);

	void setDepth(int parallelScheduleDepth);
}