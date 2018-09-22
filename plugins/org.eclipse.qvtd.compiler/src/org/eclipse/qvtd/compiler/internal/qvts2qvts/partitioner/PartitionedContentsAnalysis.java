/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *     E.D.Willink - use Complete model
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ContentsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.TraceClassRegionAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * A ContentsAnalysis provides an analysis of many (all) regions to facilitate lookup of all producers consumers of particular types and properties.
 */
@Deprecated // WIP phasing out
public class PartitionedContentsAnalysis
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ContentsAnalysis<@NonNull Region> contentsAnalysis;
	private final @NonNull AbstractTransformationAnalysis transformationAnalysis;

	public PartitionedContentsAnalysis(@NonNull ScheduleManager scheduleManager) {
		this.scheduleManager = scheduleManager;
		this.contentsAnalysis = new ContentsAnalysis<@NonNull Region>(scheduleManager);
		Iterable<@NonNull AbstractTransformationAnalysis> transformationAnalyses = scheduleManager.getTransformationAnalyses();
		assert Iterables.size(transformationAnalyses) == 1;
		this.transformationAnalysis = transformationAnalyses.iterator().next();
	}

	private void addRegion(@NonNull Region ruleRegion) {
		contentsAnalysis.addRegion(ruleRegion);
	}

	public void analyzeRegions(@NonNull ScheduledRegion rootScheduledRegion) {
		for (@NonNull Region region : QVTscheduleUtil.getActiveRegions(rootScheduledRegion)) {
			addRegion(region);
		}
		if (QVTm2QVTs.DUMP_CLASS_TO_REALIZED_NODES.isActive()) {
			QVTm2QVTs.DUMP_CLASS_TO_REALIZED_NODES.println(dumpClass2newNode());
		}
		if (QVTm2QVTs.DUMP_CLASS_TO_CONSUMING_NODES.isActive()) {
			QVTm2QVTs.DUMP_CLASS_TO_CONSUMING_NODES.println(dumpClass2oldNode());
		}
	}

	public @NonNull Iterable<@NonNull MappingRegion> getConsumingRegions(@NonNull ClassDatum classDatum) {
		Iterable<@NonNull Region> legacyConsumingRegions = contentsAnalysis.getConsumingRegions(classDatum);
		TraceClassRegionAnalysis traceClassAnalysis = transformationAnalysis.basicGetTraceClassAnalysis(classDatum);
		Set<@NonNull MappingRegion> consumingRegions = new HashSet<>();
		if (traceClassAnalysis != null) {
			for (@NonNull TraceClassRegionAnalysis subTraceClassAnalysis : traceClassAnalysis.getSubTraceClassAnalyses()) {
				for (@NonNull RegionAnalysis regionAnalysis : subTraceClassAnalysis.getConsumers()) {
					consumingRegions.add((MappingRegion) regionAnalysis.getRegion());
				}
			}
		}
		if (!Sets.newHashSet(legacyConsumingRegions).equals(consumingRegions)) {
			if (!scheduleManager.isInput(classDatum.getReferredTypedModel())) {
				legacyConsumingRegions = contentsAnalysis.getConsumingRegions(classDatum);
				traceClassAnalysis = transformationAnalysis.basicGetTraceClassAnalysis(classDatum);
				if (traceClassAnalysis != null) {
					for (@NonNull TraceClassRegionAnalysis subTraceClassAnalysis : traceClassAnalysis.getSubTraceClassAnalyses()) {
						for (@NonNull RegionAnalysis regionAnalysis : subTraceClassAnalysis.getConsumers()) {
							consumingRegions.add((MappingRegion) regionAnalysis.getRegion());
						}
					}
				}
				//	assert consumingRegions.containsAll(Sets.newHashSet(legacyConsumingRegions));
				//	assert false;
				System.err.println("Inconsistent " + classDatum + " consumingRegions");
			}
		}
		return consumingRegions;
	}

	public @NonNull Iterable<@NonNull MappingRegion> getProducingRegions(@NonNull ClassDatum classDatum) {
		Iterable<@NonNull Region> legacyProducingRegions = contentsAnalysis.getProducingRegions(classDatum);
		TraceClassRegionAnalysis traceClassAnalysis = transformationAnalysis.basicGetTraceClassAnalysis(classDatum);
		Set<@NonNull MappingRegion> producingRegions = new HashSet<>();
		if (traceClassAnalysis != null) {
			for (@NonNull TraceClassRegionAnalysis subTraceClassAnalysis : traceClassAnalysis.getSubTraceClassAnalyses()) {
				for (@NonNull RegionAnalysis regionAnalysis : subTraceClassAnalysis.getProducers()) {
					producingRegions.add((MappingRegion) regionAnalysis.getRegion());
				}
			}
		}
		if (!Sets.newHashSet(legacyProducingRegions).equals(producingRegions)) {
			legacyProducingRegions = contentsAnalysis.getProducingRegions(classDatum);
			traceClassAnalysis = transformationAnalysis.basicGetTraceClassAnalysis(classDatum);
			if (traceClassAnalysis != null) {
				for (@NonNull TraceClassRegionAnalysis subTraceClassAnalysis : traceClassAnalysis.getSubTraceClassAnalyses()) {
					for (@NonNull RegionAnalysis regionAnalysis : subTraceClassAnalysis.getProducers()) {
						producingRegions.add((MappingRegion) regionAnalysis.getRegion());
					}
				}
			}
			assert producingRegions.containsAll(Sets.newHashSet(legacyProducingRegions));
			System.err.println("Inconsistent " + classDatum + " producingRegions");
			assert false;
		}
		return producingRegions;
	}

	public Iterable<@NonNull Node> getOldNodes(@NonNull ClassDatum classDatum) {
		return contentsAnalysis.getOldNodes(classDatum);
	}

	private @Nullable String dumpClass2newNode() {
		return contentsAnalysis.dumpClass2newNode();
	}

	private @Nullable String dumpClass2oldNode() {
		return contentsAnalysis.dumpClass2oldNode();
	}

	public @Nullable Iterable<@NonNull Node> getNewNodes(@NonNull ClassDatum classDatum) {
		Iterable<@NonNull Node> legacyNewNodes = contentsAnalysis.getNewNodes(classDatum);
		TraceClassRegionAnalysis traceClassAnalysis = transformationAnalysis.basicGetTraceClassAnalysis(classDatum);
		Set<@NonNull MappingRegion> producingRegions = new HashSet<>();
		if (traceClassAnalysis != null) {
			for (@NonNull TraceClassRegionAnalysis subTraceClassAnalysis : traceClassAnalysis.getSubTraceClassAnalyses()) {
				for (@NonNull RegionAnalysis regionAnalysis : subTraceClassAnalysis.getProducers()) {
					producingRegions.add((MappingRegion) regionAnalysis.getRegion());
				}
			}
		}
		return legacyNewNodes;
	}

	public @Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull NavigableEdge edge, @NonNull ClassDatum classDatum) {
		return contentsAnalysis.getNewEdges(edge, classDatum);
	}
}
