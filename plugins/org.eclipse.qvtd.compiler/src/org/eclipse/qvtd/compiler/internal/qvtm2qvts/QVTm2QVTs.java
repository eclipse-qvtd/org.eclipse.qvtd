/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractQVTb2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ContentsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.EarlyMerger;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Lists;

public class QVTm2QVTs extends AbstractQVTb2QVTs
{
	public QVTm2QVTs(@NonNull ProblemHandler problemHandler, @NonNull EnvironmentFactory environmentFactory,
			CompilerOptions.@Nullable StepOptions schedulerOptions) {
		super(new QVTcoreScheduleManager(environmentFactory, schedulerOptions)
		{
			@Override
			public void addRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
				problemHandler.addProblem(CompilerUtil.createRegionError(region, messageTemplate, bindings));
			}

			@Override
			public void addRegionWarning(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
				problemHandler.addProblem(CompilerUtil.createRegionWarning(region, messageTemplate, bindings));
			}
		}, problemHandler);
	}

	public @NonNull Map<@NonNull ScheduledRegion, Iterable<@NonNull MappingRegion>> transform() throws IOException {
		scheduleManager.analyzeSourceModel();
		Iterable<@NonNull TransformationAnalysis> transformationAnalyses = scheduleManager.getOrderedTransformationAnalyses();
		for (@NonNull TransformationAnalysis transformationAnalysis : transformationAnalyses) {
			transformationAnalysis.analyzeMappingRegions();
		}
		@SuppressWarnings("unused")
		ContentsAnalysis<@NonNull RuleRegion> originalContentsAnalysis = scheduleManager.analyzeOriginalContents();
		Map<@NonNull ScheduledRegion, @NonNull Iterable<@NonNull RuleRegion>> scheduledRegion2activeRegions = scheduleManager.analyzeTransformations();
		for (@NonNull MappingRegion ruleRegion : QVTscheduleUtil.getOwnedMappingRegions(scheduleManager.getScheduleModel())) {
			scheduleManager.writeDebugGraphs(ruleRegion, null);
		}
		Map<@NonNull ScheduledRegion, @NonNull Iterable<@NonNull MappingRegion>> scheduledRegion2mergedRegions = new HashMap<>();
		if (!scheduleManager.isNoEarlyMerge()) {
			for (@NonNull ScheduledRegion scheduledRegion : scheduledRegion2activeRegions.keySet()) {
				Iterable<@NonNull RuleRegion> activeRegions = scheduledRegion2activeRegions.get(scheduledRegion);
				assert activeRegions != null;
				List<@NonNull MappingRegion> mergedRegions = new ArrayList<>(EarlyMerger.merge(scheduleManager, activeRegions));
				scheduledRegion2mergedRegions.put(scheduledRegion, mergedRegions);
			}
		}
		else {
			for (@NonNull ScheduledRegion scheduledRegion : scheduledRegion2activeRegions.keySet()) {
				Iterable<@NonNull RuleRegion> activeRegions = scheduledRegion2activeRegions.get(scheduledRegion);
				assert activeRegions != null;
				scheduledRegion2mergedRegions.put(scheduledRegion, Lists.newArrayList(activeRegions));
			}
		}
		return scheduledRegion2mergedRegions;
	}
}
