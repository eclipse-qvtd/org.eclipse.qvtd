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
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.PivotHelper;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

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

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	protected void registerConsumptionsAndProductions(@NonNull RuleRegion region) {	// FIXME Unify with ContentsAnalysis
		for (@NonNull Node newNode : region.getNewNodes()) {
			if (!newNode.isSuccess()) {
				ClassDatum classDatum = QVTscheduleUtil.getClassDatum(newNode);
				classDatum.getProducingRegions().add(region);
			}
		}
		for (@NonNull Node predicatedNode : region.getOldNodes()) {
			ClassDatum classDatum = QVTscheduleUtil.getClassDatum(predicatedNode);
			classDatum.getConsumingRegions().add(region);
		}
	}
}