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
	public void analyzePartition();

	public @NonNull MappingRegion createMicroMappingRegion(int partitionNumber);

	public int getDepth();

	public @NonNull Region getRegion();

	public @Nullable Role getRole(@NonNull Edge edge);

	public @Nullable Role getRole(@NonNull Node node);

	public void setDepth(int parallelScheduleDepth);
}