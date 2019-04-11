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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionPropertyAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;

/**
 * PartitionAnalysis captures the analysis of a Partition.
 */
public interface PartitionAnalysis extends PartialRegionAnalysis<@NonNull PartitionsAnalysis>
{
	void analyzePartitionEdges(@Nullable StringBuilder s);
	@NonNull Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> getClassAnalyses();
	@Override
	@NonNull Partition getPartition();
	@NonNull PartitionedTransformationAnalysis getPartitionedTransformationAnalysis();
	@Override
	@Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> getProducedClassAnalyses();
	@Override
	@Nullable Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis>> getProducedPropertyAnalyses();
	@NonNull Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis>>  getPropertyAnalyses();
	@Override
	@Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> getSuperProducedClassAnalyses();
	boolean isChecked(@NonNull Edge edge);
}