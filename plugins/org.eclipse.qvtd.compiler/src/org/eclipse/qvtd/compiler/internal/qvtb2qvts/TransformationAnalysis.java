/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TransformationAnalysis2TracePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

/**
 * A TransformationAnalysis accumulates the tesults of analyzing a RelationalTransformation and its contents.
 */
public class TransformationAnalysis extends QVTbaseHelper implements Nameable
{
	/**
	 * The supervising ScheduleManager.
	 */
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The analyzed Transformation.
	 */
	protected final @NonNull Transformation transformation;

	/**
	 * The ScheduledRegion that implements the transformation.
	 */
	protected final @NonNull ScheduledRegion scheduledRegion;

	/**
	 * The mapping from analyzed Transformation to its corresponding trace Package.
	 */
	private @Nullable TransformationAnalysis2TracePackage transformationAnalysis2tracePackage = null;

	/**
	 * Map from each rule to its analysis.
	 */
	private final @NonNull Map<@NonNull Rule, @NonNull RuleAnalysis> rule2ruleAnalysis = new HashMap<>();

	public TransformationAnalysis(@NonNull ScheduleManager scheduleManager, @NonNull Transformation transformation, @NonNull ScheduledRegion scheduledRegion) {
		super(scheduleManager.getEnvironmentFactory());
		this.scheduleManager = scheduleManager;
		this.transformation = transformation;
		this.scheduledRegion = scheduledRegion;
		for (@NonNull Rule asRule : QVTbaseUtil.getOwnedRules(transformation)) {
			RuleAnalysis ruleAnalysis = scheduleManager.createRuleAnalysis(this, asRule);
			rule2ruleAnalysis.put(asRule, ruleAnalysis);
		}
	}

	/**
	 * Perform the independent local analysis of each Rule.
	 */
	public void analyzeMappingRegions() {
		for (@NonNull Rule asRule : QVTbaseUtil.getOwnedRules(transformation)) {
			RuleAnalysis ruleAnalysis = getRuleAnalysis(asRule);
			ruleAnalysis.analyzeMappingRegion();
		}
		CompleteModel completeModel = environmentFactory.getCompleteModel();
		for (@NonNull TypedModel typedModel : QVTbaseUtil.getModelParameters(transformation)) {
			for (org.eclipse.ocl.pivot.@NonNull Package asPackage : QVTbaseUtil.getUsedPackages(typedModel)) {
				CompletePackage completePackage = completeModel.getCompletePackage(asPackage);
				scheduleManager.analyzeCompletePackage(typedModel, completePackage);
			}
		}
	}

	/**
	 * Determine the TypedModel usage of each model element.
	 */
	public void analyzeSourceModel() {
		for (@NonNull RuleAnalysis ruleAnalysis : rule2ruleAnalysis.values()) {
			ruleAnalysis.analyzeSourceModel();
		}
	}

	public @NonNull Iterable<@NonNull RuleRegion> gatherRuleRegions() {
		List<@NonNull RuleRegion> ruleRegions = new ArrayList<>();
		for (@NonNull RuleAnalysis ruleAnalysis : rule2ruleAnalysis.values()) {
			ruleAnalysis.gatherRuleRegions(ruleRegions);
		}
		Collections.sort(ruleRegions, NameUtil.NAMEABLE_COMPARATOR);		// For predictability
		return ruleRegions;
	}

	@Override
	public String getName() {
		return transformation.getName();
	}

	//	public @NonNull Iterable<@NonNull RuleAnalysis> getRuleAnalyses() {
	//		return rule2ruleAnalysis.values();
	//	}

	public @NonNull RuleAnalysis getRuleAnalysis(@NonNull Rule rule) {
		return ClassUtil.nonNullState(rule2ruleAnalysis.get(rule));
		/*		RuleAnalysis ruleAnalysis = rule2ruleAnalysis.get(rule);
		if (ruleAnalysis != null) {
			return ruleAnalysis;
		}
		TransformationAnalysis transformationAnalysis = scheduleManager.getTransformationAnalysis(QVTbaseUtil.getContainingTransformation(rule));
		if (transformationAnalysis != this) {
			return transformationAnalysis.getRuleAnalysis(rule);
		}
		throw new IllegalStateException("No RuleAnalysis for '" + rule + "'"); */
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @NonNull ScheduledRegion getScheduledRegion() {
		return scheduledRegion;
	}

	public @NonNull Transformation getTransformation() {
		return transformation;
	}

	public @NonNull TransformationAnalysis2TracePackage getTransformationAnalysis2TracePackage() {
		TransformationAnalysis2TracePackage transformationAnalysis2tracePackage2 = transformationAnalysis2tracePackage;
		if (transformationAnalysis2tracePackage2 == null) {
			transformationAnalysis2tracePackage = transformationAnalysis2tracePackage2 = scheduleManager.createTransformationAnalysis2TracePackage(this);
		}
		return transformationAnalysis2tracePackage2;
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(transformation);
	}
}
