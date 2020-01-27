/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * A Rule2TraceGroup manages the mapping between the analysis of a single rule and the one to four
 * invocation/trace classes/interfaces that may be needed to trace execution of that rule.
 */
public abstract class Rule2TraceGroup
{
	protected final @NonNull Transformation2TracePackage transformation2tracePackage;
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull Rule rule;

	protected Rule2TraceGroup(@NonNull Transformation2TracePackage transformation2tracePackage, @NonNull Rule rule) {
		this.transformation2tracePackage = transformation2tracePackage;
		this.scheduleManager = transformation2tracePackage.getScheduleManager();
		this.rule = rule;
		assert scheduleManager.getMultipleScheduleManager() == scheduleManager;
	}

	public abstract void analyzeTraceElements(@NonNull RuleAnalysis ruleAnalysis, @NonNull Set<@NonNull Node> excludedNodes) throws CompilerChainException;

	public @Nullable Element2MiddleProperty basicGetRelation2GlobalSuccessProperty() {
		return null;
	}

	public @Nullable Element2MiddleProperty basicGetRelation2LocalSuccessProperty() {
		return null;
	}

	public @NonNull String getName() {
		return QVTscheduleUtil.getName(rule);
	}

	public @NonNull Rule getRule() {
		return rule;
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public abstract org.eclipse.ocl.pivot.@NonNull Class getTraceClass();

	public @NonNull Transformation2TracePackage getTransformation2TracePackage() {
		return transformation2tracePackage;
	}

	public abstract void synthesizeTraceModel(@NonNull RuleAnalysis ruleAnalysis);
}