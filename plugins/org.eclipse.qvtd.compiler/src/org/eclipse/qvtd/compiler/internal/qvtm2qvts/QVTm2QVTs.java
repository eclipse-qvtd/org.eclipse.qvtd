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
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractQVTb2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;

public class QVTm2QVTs extends AbstractQVTb2QVTs
{
	protected final @NonNull TypedModelsConfiguration typedModelsConfiguration;

	public QVTm2QVTs(@NonNull ProblemHandler problemHandler, @NonNull EnvironmentFactory environmentFactory,
			@NonNull Transformation transformation, @NonNull TypedModelsConfiguration typedModelsConfiguration, CompilerOptions.@Nullable StepOptions schedulerOptions) {
		super(new QVTcoreScheduleManager(environmentFactory, transformation, typedModelsConfiguration, problemHandler, schedulerOptions), problemHandler);
		this.typedModelsConfiguration = typedModelsConfiguration;
	}

	public @NonNull Iterable<@NonNull RuleRegion> transform() throws IOException {
		scheduleManager.getDomainUsageAnalysis().analyzeTransformation();
		scheduleManager.analyzeSourceModel(problemHandler);
		AbstractTransformationAnalysis transformationAnalysis = scheduleManager.getTransformationAnalysis();
		transformationAnalysis.analyzeMappingRegions();
		scheduleManager.analyzeOriginalContents();		// FIXME Should treat LoadingRegion uniformly
		scheduleManager.analyzeTransformation();
		for (@NonNull RuleRegion ruleRegion : transformationAnalysis.gatherRuleRegions()) {
			scheduleManager.writeDebugGraphs(ruleRegion, null);
		}
		//s	Map<@NonNull RootRegion, @NonNull Iterable<@NonNull MappingRegion>> rootRegion2mergedRegions = new HashMap<>();
		/*		if (!scheduleManager.isNoEarlyMerge()) {
			for (@NonNull RootRegion rootRegion : rootRegion2activeRegions.keySet()) {
				Iterable<@NonNull RuleRegion> activeRegions = rootRegion2activeRegions.get(rootRegion);
				assert activeRegions != null;
				List<@NonNull MappingRegion> mergedRegions = new ArrayList<>(EarlyMerger.merge(scheduleManager, activeRegions));
				rootRegion2mergedRegions.put(rootRegion, mergedRegions);
			}
		}
		else { */
		return transformationAnalysis.gatherRuleRegions();
		//		}
	}
}
