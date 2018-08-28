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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Rule;

/**
 * A RuleAnalysis2TraceGroup manages the mapping between the analysis of a single rule and the one to four
 * invocation/trace classes/interfaces that may be needed to trace execution of that rule.
 */
public abstract class RuleAnalysis2TraceGroup
{
	protected final @NonNull RuleAnalysis ruleAnalysis;

	protected RuleAnalysis2TraceGroup(@NonNull RuleAnalysis ruleAnalysis) {
		this.ruleAnalysis = ruleAnalysis;
	}

	public abstract void analyzeTraceElements() throws CompilerChainException;

	public @NonNull String getName() {
		return ruleAnalysis.getName();
	}

	public @NonNull Rule getRule() {
		return ruleAnalysis.getRule();
	}

	public @NonNull RuleAnalysis getRuleAnalysis() {
		return ruleAnalysis;
	}

	public abstract org.eclipse.ocl.pivot.@NonNull Class getTraceClass();

	//	public abstract @NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty element2traceProperty, @NonNull String name);

	public abstract void synthesizeTraceElements() throws CompilerChainException;

	public abstract void synthesizeTraceModel();
}