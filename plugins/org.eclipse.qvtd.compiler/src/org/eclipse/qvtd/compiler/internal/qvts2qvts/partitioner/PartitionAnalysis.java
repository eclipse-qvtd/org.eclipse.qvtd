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
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;

/**
 * PartitionAnalysis captures the analysis of a Partition.
 */
public interface PartitionAnalysis extends CompilerUtil.PartialRegion<@NonNull PartitionAnalysis, @NonNull TraceClassPartitionAnalysis, @NonNull TracePropertyPartitionAnalysis>
{
	void analyzePartitionEdges();
	void computeCheckedOrEnforcedEdges();
	@NonNull MappingRegion createMicroMappingRegion();
	@NonNull MappingRegion getMicroMappingRegion();
	@NonNull Partition getPartition();
	//	@NonNull ReachabilityForest getReachabilityForest();
	boolean isAwaited(@NonNull Edge edge);
	@Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getProducedTraceClassAnalyses();
	@Nullable Iterable<@NonNull TracePropertyPartitionAnalysis> getProducedTracePropertyAnalyses();
	@NonNull Iterable<@NonNull TraceClassPartitionAnalysis> getTraceClassAnalyses();
	@NonNull Iterable<@NonNull TracePropertyPartitionAnalysis>  getTracePropertyAnalyses();
	@Nullable Iterable<@NonNull TraceClassPartitionAnalysis> getSuperProducedTraceClassAnalyses();
	@NonNull Iterable<@NonNull Node> getTraceNodes();
}