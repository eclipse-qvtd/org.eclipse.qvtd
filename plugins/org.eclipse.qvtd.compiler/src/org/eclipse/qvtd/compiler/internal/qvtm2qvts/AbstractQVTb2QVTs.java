/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

public abstract class AbstractQVTb2QVTs extends PivotHelper
{
	public static final @NonNull TracingOption CALL_TREE = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/callTree");
	public static final @NonNull TracingOption DEBUG_GRAPHS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/debugGraphs");
	public static final @NonNull TracingOption DUMP_CLASS_TO_CONSUMING_NODES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/dump/class2consumingNodes");
	public static final @NonNull TracingOption DUMP_CLASS_TO_CONTAINING_PROPERTIES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/dump/class2containingProperty");
	public static final @NonNull TracingOption DUMP_CLASS_TO_REALIZED_NODES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/dump/class2realizedNodes");
	public static final @NonNull TracingOption DUMP_INPUT_MODEL_TO_DOMAIN_USAGE = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/dump/inputModel2domainUsage");
	public static final @NonNull TracingOption DUMP_PROPERTY_TO_CONSUMING_CLASSES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/dump/property2consumingClass");
	public static final @NonNull TracingOption EDGE_ORDER = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/edgeOrder");
	public static final @NonNull TracingOption REGION_CYCLES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/regionCycles");
	public static final @NonNull TracingOption REGION_DEPTH = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/regionDepth");
	//	public static final @NonNull TracingOption REGION_LOCALITY = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/regionLocality");
	public static final @NonNull TracingOption REGION_ORDER = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/regionOrder");
	public static final @NonNull TracingOption REGION_STACK = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/regionStack");
	public static final @NonNull TracingOption REGION_TRAVERSAL = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtm2qvts/regionTraversal");

	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ProblemHandler problemHandler;

	/**
	 * The Region to which each mapping is allocated.
	 */
	private final @NonNull Map<@NonNull Rule, @NonNull RuleAnalysis> rule2ruleAnalysis = new HashMap<>();

	public AbstractQVTb2QVTs(@NonNull ScheduleManager scheduleManager, @NonNull ProblemHandler problemHandler) {
		super(scheduleManager.getEnvironmentFactory());
		this.scheduleManager = scheduleManager;
		this.problemHandler = problemHandler;
	}

	public void addProblem(@NonNull CompilerProblem problem) {
		problemHandler.addProblem(problem);
	}

	public void addRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		addProblem(CompilerUtil.createRegionError(region, messageTemplate, bindings));
	}

	public void addRegionWarning(@NonNull Region region, @NonNull String messageTemplate, Object... bindings) {
		addProblem(CompilerUtil.createRegionWarning(region, messageTemplate, bindings));
	}

	protected void addRuleAnalysis(@NonNull RuleAnalysis ruleAnalysis) {
		rule2ruleAnalysis.put(ruleAnalysis.getRule(), ruleAnalysis);
	}

	public @NonNull MappingRegion getMappingRegion(@NonNull Rule rule) {
		RuleAnalysis ruleAnalysis = rule2ruleAnalysis.get(rule);
		assert ruleAnalysis != null;
		return ruleAnalysis.getRegion();
	}

	protected @NonNull Iterable<@NonNull RuleAnalysis> getRuleAnalyses() {
		return rule2ruleAnalysis.values();
	}

	protected @NonNull RuleAnalysis getRuleAnalysis(@NonNull Rule rule) {
		return ClassUtil.nonNullState(rule2ruleAnalysis.get(rule));
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}
}
