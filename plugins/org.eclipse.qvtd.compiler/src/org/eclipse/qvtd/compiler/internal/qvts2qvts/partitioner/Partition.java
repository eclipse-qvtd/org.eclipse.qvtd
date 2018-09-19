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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Graphable;

public interface Partition extends CompilerUtil.PartialRegion<@NonNull Partition, @NonNull TraceClassPartitionAnalysis, @NonNull TracePropertyPartitionAnalysis>, Graphable
{
	void analyzePartition();
	@NonNull MappingRegion createMicroMappingRegion();
	int getDepth();
	@NonNull MappingRegion getMicroMappingRegion();
	@NonNull Region getOriginalRegion();
	@NonNull Iterable<@NonNull Edge> getPartialEdges();
	@NonNull Iterable<@NonNull Node> getPartialNodes();
	@Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getProducedTraceClassAnalyses();
	@Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getProducedTracePropertyAnalyses();
	@Nullable Role getRole(@NonNull Edge edge);
	@Nullable Role getRole(@NonNull Node node);
	@Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getSuperProducedTraceClassAnalyses();
	@NonNull List<@NonNull Node> getTraceNodes();
	void setDepth(int parallelScheduleDepth);
}