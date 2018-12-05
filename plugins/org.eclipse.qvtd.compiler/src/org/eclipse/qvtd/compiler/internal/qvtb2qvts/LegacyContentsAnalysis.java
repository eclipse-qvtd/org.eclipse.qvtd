/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 *     E.D.Willink - use Complete model
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.TraceClassRegionAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * A ContentsAnalysis provides an analysis of many (all) regions to facilitate lookup of all producers consumers of particular types and properties.
 */
public class LegacyContentsAnalysis
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ContentsAnalysis<@NonNull RuleRegion> contentsAnalysis;
	private final @NonNull AbstractTransformationAnalysis transformationAnalysis;

	public LegacyContentsAnalysis(@NonNull ScheduleManager scheduleManager) {
		this.scheduleManager = scheduleManager;
		this.contentsAnalysis = new ContentsAnalysis<@NonNull RuleRegion>(scheduleManager);
		Iterable<@NonNull AbstractTransformationAnalysis> transformationAnalyses = scheduleManager.getTransformationAnalyses();
		assert Iterables.size(transformationAnalyses) == 1;
		this.transformationAnalysis = transformationAnalyses.iterator().next();
	}

	public void addRegion(@NonNull RuleRegion ruleRegion) {
		contentsAnalysis.addRegion(ruleRegion);
	}

	public @NonNull Iterable<@NonNull RuleRegion> getConsumingRegions(@NonNull ClassDatum classDatum) {
		Iterable<@NonNull RuleRegion> legacyConsumingRegions = contentsAnalysis.getConsumingRegions(classDatum);
		TraceClassRegionAnalysis traceClassAnalysis = transformationAnalysis.basicGetTraceClassAnalysis(classDatum);
		Set<@NonNull RuleRegion> consumingRegions = new HashSet<>();
		if (traceClassAnalysis != null) {
			for (@NonNull TraceClassRegionAnalysis subTraceClassAnalysis : traceClassAnalysis.getSubTraceClassAnalyses()) {
				for (@NonNull RegionAnalysis regionAnalysis : subTraceClassAnalysis.getConsumers()) {
					consumingRegions.add((RuleRegion) regionAnalysis.getRegion());
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
							consumingRegions.add((RuleRegion) regionAnalysis.getRegion());
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

	public @NonNull Iterable<@NonNull RuleRegion> getProducingRegions(@NonNull ClassDatum classDatum) {
		Iterable<@NonNull RuleRegion> legacyProducingRegions = contentsAnalysis.getProducingRegions(classDatum);
		TraceClassRegionAnalysis traceClassAnalysis = transformationAnalysis.basicGetTraceClassAnalysis(classDatum);
		Set<@NonNull RuleRegion> producingRegions = new HashSet<>();
		if (traceClassAnalysis != null) {
			for (@NonNull TraceClassRegionAnalysis subTraceClassAnalysis : traceClassAnalysis.getSubTraceClassAnalyses()) {
				for (@NonNull RegionAnalysis regionAnalysis : subTraceClassAnalysis.getProducers()) {
					producingRegions.add((RuleRegion) regionAnalysis.getRegion());
				}
			}
		}
		if (!Sets.newHashSet(legacyProducingRegions).equals(producingRegions)) {
			legacyProducingRegions = contentsAnalysis.getProducingRegions(classDatum);
			traceClassAnalysis = transformationAnalysis.basicGetTraceClassAnalysis(classDatum);
			if (traceClassAnalysis != null) {
				for (@NonNull TraceClassRegionAnalysis subTraceClassAnalysis : traceClassAnalysis.getSubTraceClassAnalyses()) {
					for (@NonNull RegionAnalysis regionAnalysis : subTraceClassAnalysis.getProducers()) {
						producingRegions.add((RuleRegion) regionAnalysis.getRegion());
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

	public @Nullable String dumpClass2newNode() {
		return contentsAnalysis.dumpClass2newNode();
	}

	public @Nullable String dumpClass2oldNode() {
		return contentsAnalysis.dumpClass2oldNode();
	}

	public @Nullable Iterable<@NonNull Node> getNewNodes(@NonNull ClassDatum classDatum) {
		Iterable<@NonNull Node> legacyNewNodes = contentsAnalysis.getNewNodes(classDatum);
		TraceClassRegionAnalysis traceClassAnalysis = transformationAnalysis.basicGetTraceClassAnalysis(classDatum);
		Set<@NonNull RuleRegion> producingRegions = new HashSet<>();
		if (traceClassAnalysis != null) {
			for (@NonNull TraceClassRegionAnalysis subTraceClassAnalysis : traceClassAnalysis.getSubTraceClassAnalyses()) {
				for (@NonNull RegionAnalysis regionAnalysis : subTraceClassAnalysis.getProducers()) {
					producingRegions.add((RuleRegion) regionAnalysis.getRegion());
				}
			}
		}
		return legacyNewNodes;
	}

	public @Nullable Iterable<@NonNull NavigableEdge> getNewEdges(@NonNull NavigableEdge edge, @NonNull ClassDatum classDatum) {
		return contentsAnalysis.getNewEdges(edge, classDatum);
	}
}
