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
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.EarlyMerger;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Lists;

public class QVTm2QVTs extends AbstractQVTb2QVTs
{
	public QVTm2QVTs(@NonNull ProblemHandler problemHandler, @NonNull EnvironmentFactory environmentFactory,
			CompilerOptions.@Nullable StepOptions schedulerOptions) {
		super(new QVTcoreScheduleManager(environmentFactory, schedulerOptions), problemHandler);
	}

	public @NonNull List<@NonNull MappingRegion> transform() throws IOException {
		scheduleManager.analyzeRules();
		scheduleManager.analyzeTransformations();
		List<@NonNull RuleRegion> orderedRuleRegions = new ArrayList<>();
		for (@NonNull MappingRegion mappingRegion : QVTscheduleUtil.getOwnedMappingRegions(scheduleManager.getScheduleModel())) {
			orderedRuleRegions.add((RuleRegion) mappingRegion);
		}
		Collections.sort(orderedRuleRegions, NameUtil.NAMEABLE_COMPARATOR);		// For predictability
		//
		//	Extract salient characteristics from within each MappingAction.
		//
		//		for (@NonNull RuleRegion ruleRegion : orderedRuleRegions) {
		//			MappingAnalysis mappingAnalysis = MappingAnalysis.createMappingRegion(scheduleManager, ruleRegion);
		//			addRuleAnalysis(mappingAnalysis);
		//		}
		for (@NonNull TransformationAnalysis transformationAnalysis : scheduleManager.getTransformationAnalyses()) {
			List<@NonNull RuleAnalysis> ruleAnalyses = Lists.newArrayList(transformationAnalysis.getRuleAnalyses());
			Collections.sort(ruleAnalyses, NameUtil.NAMEABLE_COMPARATOR);		// Stabilize side effect of symbol name disambiguator suffixes
			for (@NonNull RuleAnalysis ruleAnalysis : ruleAnalyses) {
				ruleAnalysis.registerConsumptionsAndProductions();
			}
			for (@NonNull RuleAnalysis ruleAnalysis : ruleAnalyses) {
				scheduleManager.writeDebugGraphs(ruleAnalysis.getRegion(), null);
			}
		}
		List<@NonNull MappingRegion> orderedRegions = new ArrayList<>();
		for (@NonNull RuleRegion ruleRegion : orderedRuleRegions) {
			//			Rule rule = QVTscheduleUtil.getReferredRule(ruleRegion);
			//			RuleAnalysis mappingAnalysis = getRuleAnalysis(rule);
			//			orderedRegions.add(mappingAnalysis.getRuleRegion());
			orderedRegions.add(ruleRegion);
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
