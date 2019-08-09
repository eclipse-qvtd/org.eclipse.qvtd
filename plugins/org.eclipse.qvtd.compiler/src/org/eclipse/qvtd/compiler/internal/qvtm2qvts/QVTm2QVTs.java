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
import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractQVTb2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import com.google.common.collect.Lists;

public class QVTm2QVTs extends AbstractQVTb2QVTs
{
	public QVTm2QVTs(@NonNull ProblemHandler problemHandler, @NonNull EnvironmentFactory environmentFactory,
			@NonNull Transformation transformation, CompilerOptions.@Nullable StepOptions schedulerOptions) {
		super(new QVTcoreScheduleManager(environmentFactory, transformation, problemHandler, schedulerOptions), problemHandler);
	}

	public @NonNull Map<@NonNull RootRegion, Iterable<@NonNull MappingRegion>> transform() throws IOException {
		scheduleManager.getDomainUsageAnalysis().analyzeTransformation();
		scheduleManager.analyzeSourceModel();
		Iterable<@NonNull AbstractTransformationAnalysis> transformationAnalyses = scheduleManager.getOrderedTransformationAnalyses();
		for (@NonNull AbstractTransformationAnalysis transformationAnalysis : transformationAnalyses) {
			transformationAnalysis.analyzeMappingRegions();
		}
		scheduleManager.analyzeOriginalContents();		// FIXME Should treat LoadingRegion uniformly
		Map<@NonNull RootRegion, @NonNull Iterable<@NonNull RuleRegion>> rootRegion2activeRegions = scheduleManager.analyzeTransformations();
		for (@NonNull RuleRegion ruleRegion : scheduleManager.gatherRuleRegions()) {
			scheduleManager.writeDebugGraphs(ruleRegion, null);
		}
		Map<@NonNull RootRegion, @NonNull Iterable<@NonNull MappingRegion>> rootRegion2mergedRegions = new HashMap<>();
		/*		if (!scheduleManager.isNoEarlyMerge()) {
			for (@NonNull RootRegion rootRegion : rootRegion2activeRegions.keySet()) {
				Iterable<@NonNull RuleRegion> activeRegions = rootRegion2activeRegions.get(rootRegion);
				assert activeRegions != null;
				List<@NonNull MappingRegion> mergedRegions = new ArrayList<>(EarlyMerger.merge(scheduleManager, activeRegions));
				rootRegion2mergedRegions.put(rootRegion, mergedRegions);
			}
		}
		else { */
		for (@NonNull RootRegion rootRegion : rootRegion2activeRegions.keySet()) {
			Iterable<@NonNull RuleRegion> activeRegions = rootRegion2activeRegions.get(rootRegion);
			assert activeRegions != null;
			rootRegion2mergedRegions.put(rootRegion, Lists.newArrayList(activeRegions));
		}
		//		}
		return rootRegion2mergedRegions;
	}
}
