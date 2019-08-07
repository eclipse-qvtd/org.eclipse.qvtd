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
package org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadNodeGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Rule2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TracedHeadAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Transformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.RelationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A Relation2TraceGroup manages the mapping between the analysis of a single rule and the one to four
 * invocation/trace classes/interfaces that may be needed to trace execution of that rule.
 */
public class Relation2TraceGroup extends Rule2TraceGroup
{
	protected final @Nullable Relation2TraceClass relation2traceClass;
	protected final @Nullable Relation2TraceInterface relation2traceInterface;
	protected final @Nullable Relation2InvocationClass relation2invocationClass;
	protected final @Nullable Relation2DispatchClass relation2dispatchClass;

	private final @NonNull List<@NonNull TracingStrategy> tracingStrategies = new ArrayList<>();

	public Relation2TraceGroup(@NonNull Transformation2TracePackage transformation2tracePackage, @NonNull Relation relation) {
		super(transformation2tracePackage, relation);
		QVTrelationNameGenerator nameGenerator = getNameGenerator();
		String traceClassName = null;
		String traceInterfaceName = null;
		String invocationClassName = null;
		String dispatchClassName = null;
		Rule baseRelation = QVTrelationUtil.basicGetBaseRule(relation);
		boolean hasOverrides = QVTrelationUtil.hasOverrides(relation);
		boolean isAbstract = relation.isIsAbstract();
		boolean topLevel = relation.isIsTopLevel();
		if (!isAbstract) {
			traceClassName = nameGenerator.createTraceClassName(relation);
		}
		if (hasOverrides && (baseRelation == relation)) {
			traceInterfaceName = nameGenerator.createTraceInterfaceName(relation);
		}
		if (/*!topLevel &&*/ hasOverrides) { // || relationAnalysis.hasIncomingWhereInvocationAnalyses())) {
			if (!topLevel && !isAbstract) {
				invocationClassName = nameGenerator.createInvocationClassName(relation);
			}
			if (baseRelation == relation) {
				dispatchClassName = nameGenerator.createDispatchClassName(relation);
			}
		}
		relation2traceClass = traceClassName != null ? new Relation2TraceClass(this, traceClassName) : null;
		if (traceInterfaceName != null) {
			relation2traceInterface = new Relation2TraceInterface(this, traceInterfaceName);
			addTracingStrategy(AbstractTracingStrategy.HasInterfaceTracingStrategy.INSTANCE);
		}
		else {
			relation2traceInterface = null;
		}
		if (dispatchClassName != null) {
			relation2dispatchClass = new Relation2DispatchClass(this, dispatchClassName);
			addTracingStrategy(AbstractTracingStrategy.HasDispatcherTracingStrategy.INSTANCE);
		}
		else {
			relation2dispatchClass = null;
		}
		relation2invocationClass = invocationClassName != null ? new Relation2InvocationClass(this, invocationClassName) : null;
		//
		//	Set the trace variable type
		//
		Relation2TraceClass relation2traceClass2 = relation2traceClass;
		if (relation2traceClass2 != null) {
			Variable traceVariable = QVTrelationUtil.getTraceVariable(relation);
			traceVariable.setType(relation2traceClass2.getMiddleClass());
		}
	}

	/*	private void analyzeInvocationVariable(@NonNull OCLExpression invocation) {
		Rule invokedRule = scheduleManager.getReferredRule(invocation);
		if (!scheduleManager.isTopLevel(invokedRule)) {
			getInvocation2TraceProperty(invocation);
		}
	} */

	public void addTracingStrategy(@NonNull TracingStrategy tracingStrategy) {
		tracingStrategies.add(tracingStrategy);
	}

	@Override
	public void analyzeTraceElements(@NonNull RuleAnalysis ruleAnalysis) throws CompilerChainException {
		RelationAnalysis relationAnalysis = (RelationAnalysis)ruleAnalysis;
		//
		//	Determine a head node for the minimum number of sub-regions that have a to-one path from the head.
		//
		List<@NonNull HeadNodeGroup> headNodeGroups = TracedHeadAnalysis.computeTraceHeadGroupNodes(relationAnalysis.getRegion());
		Relation2TraceInterface relation2traceInterface2 = relation2traceInterface;
		if (relation2traceInterface2 != null) {
			relation2traceInterface2.analyzeTraceElements(headNodeGroups, relationAnalysis);
		}
		Relation2TraceClass relation2traceClass2 = relation2traceClass;
		if (relation2traceClass2 != null) {
			relation2traceClass2.analyzeTraceElements(headNodeGroups, relationAnalysis);
		}
		Relation2DispatchClass relation2invocationInterface2 = relation2dispatchClass;
		if (relation2invocationInterface2 != null) {
			relation2invocationInterface2.analyzeTraceElements(headNodeGroups, relationAnalysis);
		}
		Relation2InvocationClass relation2invocationClass2 = relation2invocationClass;
		if (relation2invocationClass2 != null) {
			relation2invocationClass2.analyzeTraceElements(headNodeGroups, relationAnalysis);
		}
	}

	public @Nullable Relation2InvocationClass basicGetRule2InvocationClass() {
		return relation2invocationClass;
	}

	public @Nullable Relation2DispatchClass basicGetRule2InvocationInterface() {
		return relation2dispatchClass;
	}

	public @Nullable Relation2TraceInterface basicGetRule2TraceInterface() {
		return relation2traceInterface;
	}

	public org.eclipse.ocl.pivot.@NonNull Class getInvocationClass() {
		if (relation2dispatchClass != null) {
			return relation2dispatchClass.getMiddleClass();
		}
		return getRule2TraceClass().getMiddleClass();
	}

	public org.eclipse.ocl.pivot.@NonNull Class getInvocationInterface() {
		return getRule2InvocationInterface().getMiddleClass();
	}

	public @NonNull QVTrelationNameGenerator getNameGenerator() {
		return (QVTrelationNameGenerator) scheduleManager.getNameGenerator();
	}

	@Override
	public @NonNull Relation getRule() {
		return (Relation)rule;
	}

	public @NonNull Relation2DispatchClass getRule2DispatchClass() {
		return ClassUtil.nonNullState(relation2dispatchClass);
		/*		if (relation2invocationClass != null) {
			return relation2invocationClass;
		}
		else if (relation2dispatchClass != null) {
			return relation2dispatchClass;
		}
		else {
			return getRule2TraceClass();
		} */
	}

	public @NonNull Relation2MiddleType getRule2InvocationInterface() {
		if (relation2dispatchClass != null) {
			return relation2dispatchClass;
		}
		else if (relation2invocationClass != null) {
			return relation2invocationClass;
		}
		else {
			return getRule2TraceInterface();
		}
	}

	public @NonNull Relation2TraceClass getRule2TraceClass() {
		return ClassUtil.nonNullState(relation2traceClass);
	}

	public @NonNull Relation2MiddleType getRule2TraceInterface() {
		if (relation2traceInterface != null) {
			return relation2traceInterface;
		}
		else {
			return getRule2TraceClass();
		}
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getTraceClass() {
		return getRule2TraceClass().getMiddleClass();
	}

	public org.eclipse.ocl.pivot.@NonNull Class getTraceInterface() {
		return getRule2TraceInterface().getMiddleClass();
	}

	public @NonNull Iterable<@NonNull TracingStrategy> getTracingStrategies() {
		return tracingStrategies;
	}

	@Override
	public void synthesizeTraceModel(@NonNull RuleAnalysis ruleAnalysis) {
		if (relation2traceInterface != null) {
			relation2traceInterface.synthesizeTraceModel(ruleAnalysis);
		}
		if (relation2traceClass != null) {
			relation2traceClass.synthesizeTraceModel(ruleAnalysis);
		}
		if (relation2dispatchClass != null) {
			relation2dispatchClass.synthesizeTraceModel(ruleAnalysis);
		}
		if (relation2invocationClass != null) {
			relation2invocationClass.synthesizeTraceModel(ruleAnalysis);
		}
	}

	@Override
	public @NonNull String toString() {
		return getName();
	}
}