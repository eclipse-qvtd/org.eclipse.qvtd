/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.CompilerChain.Key;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.EarlyMerger;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public class QVTm2QVTs extends AbstractQVTb2QVTs
{
	/**
	 * The Region to which each mapping is allocated.
	 */
	private final @NonNull Map<@NonNull Rule, @NonNull MappingAnalysis> mapping2mappingAnalysis = new HashMap<>();

	public QVTm2QVTs(@NonNull ProblemHandler problemHandler, @NonNull EnvironmentFactory environmentFactory, @NonNull Transformation asTransformation,
			@Nullable Map<@NonNull Key<? extends Object>, @Nullable Object> schedulerOptions) {
		super(new QVTcoreScheduleManager(environmentFactory, asTransformation, schedulerOptions), problemHandler);
	}

	public @NonNull MappingRegion getMappingRegion(@NonNull Rule mapping) {
		MappingAnalysis mappingAnalysis = mapping2mappingAnalysis.get(mapping);
		assert mappingAnalysis != null;
		return mappingAnalysis.getRuleRegion();
	}

	public @NonNull List<@NonNull MappingRegion> transform() throws IOException {
		List<@NonNull RuleRegion> orderedRuleRegions = new ArrayList<>();
		for (@NonNull MappingRegion mappingRegion : QVTscheduleUtil.getOwnedMappingRegions(scheduleManager.getScheduleModel())) {
			orderedRuleRegions.add((RuleRegion) mappingRegion);
		}
		Collections.sort(orderedRuleRegions, NameUtil.NAMEABLE_COMPARATOR);		// For predictability
		//
		//	Extract salient characteristics from within each MappingAction.
		//
		for (@NonNull RuleRegion ruleRegion : orderedRuleRegions) {
			MappingAnalysis mappingRegion = MappingAnalysis.createMappingRegion(scheduleManager, ruleRegion);
			mapping2mappingAnalysis.put(QVTscheduleUtil.getReferredRule(ruleRegion), mappingRegion);
		}
		List<@NonNull MappingAnalysis> mappingAnalyses = new ArrayList<>(mapping2mappingAnalysis.values());
		Collections.sort(mappingAnalyses, NameUtil.NAMEABLE_COMPARATOR);		// Stabilize side effect of symbol name disambiguator suffixes
		for (@NonNull MappingAnalysis mappingRegion : mappingAnalyses) {
			mappingRegion.registerConsumptionsAndProductions();
		}
		if (AbstractQVTb2QVTs.DEBUG_GRAPHS.isActive()) {
			for (@NonNull MappingAnalysis mappingAnalysis : mappingAnalyses) {
				scheduleManager.writeDebugGraphs(mappingAnalysis.getRuleRegion(), null);
			}
		}
		List<@NonNull MappingRegion> orderedRegions = new ArrayList<>();
		for (@NonNull RuleRegion ruleRegion : orderedRuleRegions) {
			Rule mapping = QVTscheduleUtil.getReferredRule(ruleRegion);
			MappingAnalysis mappingAnalysis = mapping2mappingAnalysis.get(mapping);
			assert mappingAnalysis != null;
			orderedRegions.add(mappingAnalysis.getRuleRegion());
			//			mappingRegion.resolveRecursion();
		}
		boolean noEarlyMerge = scheduleManager.isNoEarlyMerge();
		List<@NonNull MappingRegion> activeRegions = new ArrayList<>(noEarlyMerge ? orderedRegions : EarlyMerger.merge(scheduleManager, orderedRegions));
		//		for (@NonNull Region activeRegion : activeRegions) {
		//			((AbstractRegion)activeRegion).resolveRecursion();
		//		}
		//		for (@NonNull OperationRegion operationRegion : multiRegion.getOperationRegions()) {
		//			activeRegions.add(operationRegion);
		//		}
		//		multiRegion.setActiveRegions(activeRegions);
		return activeRegions;
	}
}
