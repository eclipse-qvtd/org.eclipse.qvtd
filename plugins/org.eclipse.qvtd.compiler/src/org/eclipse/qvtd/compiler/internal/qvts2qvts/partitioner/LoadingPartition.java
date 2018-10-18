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
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

public class LoadingPartition extends AbstractAcyclicPartition
{
	public LoadingPartition(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull LoadingRegion region) {
		super("«load»", partitionedTransformationAnalysis, region);
		//		regionAnalysis.getTransformationAnalysis().setLoadingRegionAnalysis(regionAnalysis);
	}

	@Override
	protected @NonNull List<@NonNull Node> analyze() {
		return new ArrayList<>();
	}

	public void analyzeIntroductions() {
		//	regionAnalysis.getTransformationAnalysis().setLoadingRegionAnalysis(regionAnalysis);
		partitionedTransformationAnalysis.setLoadingRegionAnalysis(this);
	}

	@Override
	protected void computeSymbolName(@NonNull SymbolNameBuilder s) {
		s.appendString(QVTscheduleUtil.ROOT_MAPPING_NAME);
	}

	@Override
	public @NonNull MappingRegion createMicroMappingRegion() {
		return (MappingRegion)region;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getHeadNodes() {
		return QVTscheduleUtil.getHeadNodes(region);
	}

	@Override
	public @NonNull MappingRegion getMicroMappingRegion() {
		return (MappingRegion)region;
	}

	@Override
	public @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		return QVTscheduleUtil.getOwnedEdges(region);
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getPartialNodes() {
		return QVTscheduleUtil.getOwnedNodes(region);
	}

	@Override
	protected @NonNull String getSymbolNamePrefix() {
		return "r_";
	}
}