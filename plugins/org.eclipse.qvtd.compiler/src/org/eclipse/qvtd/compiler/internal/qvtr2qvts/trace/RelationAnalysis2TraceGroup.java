/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace;

import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadNodeGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.RuleAnalysis2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TracedHeadAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.RelationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A RuleAnalysis2TraceGroup manages the mapping between the analysis of a single rule and the one to four
 * invocation/trace classes/interfaces that may be needed to trace execution of that rule.
 */
public class RelationAnalysis2TraceGroup extends RuleAnalysis2TraceGroup
{
	protected final @Nullable RelationAnalysis2TraceClass relationAnalysis2traceClass;
	protected final @Nullable RelationAnalysis2TraceInterface relationAnalysis2traceInterface;
	protected final @Nullable RelationAnalysis2InvocationClass relationAnalysis2invocationClass;
	protected final @Nullable RelationAnalysis2DispatchClass relationAnalysis2dispatchClass;

	public RelationAnalysis2TraceGroup(@NonNull RelationAnalysis relationAnalysis) {
		super(relationAnalysis);
		Relation relation = relationAnalysis.getRule();

		//	MappingRegionAnalysis mappingRegionAnalysis = new MappingRegionAnalysis(relationAnalysis.getScheduleManager(), relationAnalysis.getRegion());
		//	mappingRegionAnalysis.computeHeadNodes(targetFromSources, preferredHeadNodes)
		QVTrelationNameGenerator nameGenerator = relationAnalysis.getNameGenerator();
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
		relationAnalysis2traceClass = traceClassName != null ? new RelationAnalysis2TraceClass(this, traceClassName) : null;
		relationAnalysis2traceInterface = traceInterfaceName != null ? new RelationAnalysis2TraceInterface(this, traceInterfaceName) : null;
		relationAnalysis2dispatchClass = dispatchClassName != null ? new RelationAnalysis2DispatchClass(this, dispatchClassName) : null;
		relationAnalysis2invocationClass = invocationClassName != null ? new RelationAnalysis2InvocationClass(this, invocationClassName) : null;
	}

	/*	private void analyzeInvocationVariable(@NonNull OCLExpression invocation) {
		Rule invokedRule = scheduleManager.getReferredRule(invocation);
		if (!scheduleManager.isTopLevel(invokedRule)) {
			getInvocation2TraceProperty(invocation);
		}
	} */

	@Override
	public void analyzeTraceElements() throws CompilerChainException {
		//		if ("TmapHelper".equals(toString())) {
		//			getClass();
		//		}
		//		if ("TmapVariableExp_referredVariable".equals(toString())) {
		//			getClass();
		//		}
		//
		//	Determine a head node for the minimum number of sub-regions that have a to-one path from the head.
		//
		if ("mapOutPattern_qvtr".equals(getName())) {
			getClass();
		}
		List<@NonNull HeadNodeGroup> headNodeGroups = TracedHeadAnalysis.computeTraceHeadGroupNodes(ruleAnalysis.getScheduleManager(), ruleAnalysis.getRegion());
		RelationAnalysis2TraceInterface relationAnalysis2traceInterface2 = relationAnalysis2traceInterface;
		if (relationAnalysis2traceInterface2 != null) {
			relationAnalysis2traceInterface2.analyzeTraceElements(headNodeGroups);
		}
		RelationAnalysis2TraceClass relationAnalysis2traceClass2 = relationAnalysis2traceClass;
		if (relationAnalysis2traceClass2 != null) {
			relationAnalysis2traceClass2.analyzeTraceElements(headNodeGroups);
		}
		RelationAnalysis2DispatchClass relationAnalysis2invocationInterface2 = relationAnalysis2dispatchClass;
		if (relationAnalysis2invocationInterface2 != null) {
			relationAnalysis2invocationInterface2.analyzeTraceElements(headNodeGroups);
		}
		RelationAnalysis2InvocationClass relationAnalysis2invocationClass2 = relationAnalysis2invocationClass;
		if (relationAnalysis2invocationClass2 != null) {
			relationAnalysis2invocationClass2.analyzeTraceElements(headNodeGroups);
		}
	}

	public @Nullable RelationAnalysis2InvocationClass basicGetRuleAnalysis2InvocationClass() {
		return relationAnalysis2invocationClass;
	}

	public @Nullable RelationAnalysis2DispatchClass basicGetRuleAnalysis2InvocationInterface() {
		return relationAnalysis2dispatchClass;
	}

	public @Nullable RelationAnalysis2TraceInterface basicGetRuleAnalysis2TraceInterface() {
		return relationAnalysis2traceInterface;
	}

	public @NonNull RelationAnalysis2TraceGroup getBaseRelationAnalysis2TraceGroup() {
		return getRuleAnalysis().getBaseRelationAnalysis().getRuleAnalysis2TraceGroup();
	}

	public org.eclipse.ocl.pivot.@NonNull Class getInvocationClass() {
		if (relationAnalysis2dispatchClass != null) {
			return relationAnalysis2dispatchClass.getMiddleClass();
		}
		return getRuleAnalysis2TraceClass().getMiddleClass();
	}

	public org.eclipse.ocl.pivot.@NonNull Class getInvocationInterface() {
		return getRuleAnalysis2InvocationInterface().getMiddleClass();
	}

	@Override
	public @NonNull String getName() {
		return ruleAnalysis.getName();
	}

	public @NonNull QVTrelationNameGenerator getNameGenerator() {
		return getScheduleManager().getNameGenerator();
	}

	@Override
	public @NonNull Relation getRule() {
		return (Relation) ruleAnalysis.getRule();
	}

	@Override
	public @NonNull RelationAnalysis getRuleAnalysis() {
		return (RelationAnalysis) ruleAnalysis;
	}

	public @NonNull RelationAnalysis2DispatchClass getRuleAnalysis2DispatchClass() {
		return ClassUtil.nonNullState(relationAnalysis2dispatchClass);
		/*		if (relationAnalysis2invocationClass != null) {
			return relationAnalysis2invocationClass;
		}
		else if (relationAnalysis2dispatchClass != null) {
			return relationAnalysis2dispatchClass;
		}
		else {
			return getRuleAnalysis2TraceClass();
		} */
	}

	public @NonNull RelationAnalysis2MiddleType getRuleAnalysis2InvocationInterface() {
		if (relationAnalysis2dispatchClass != null) {
			return relationAnalysis2dispatchClass;
		}
		else if (relationAnalysis2invocationClass != null) {
			return relationAnalysis2invocationClass;
		}
		else {
			return getRuleAnalysis2TraceInterface();
		}
	}

	public @NonNull RelationAnalysis2TraceClass getRuleAnalysis2TraceClass() {
		return ClassUtil.nonNullState(relationAnalysis2traceClass);
	}

	public @NonNull RelationAnalysis2MiddleType getRuleAnalysis2TraceInterface() {
		if (relationAnalysis2traceInterface != null) {
			return relationAnalysis2traceInterface;
		}
		else {
			return getRuleAnalysis2TraceClass();
		}
	}

	public @NonNull QVTrelationScheduleManager getScheduleManager() {
		return getRuleAnalysis().getScheduleManager();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getTraceClass() {
		return getRuleAnalysis2TraceClass().getMiddleClass();
	}

	public org.eclipse.ocl.pivot.@NonNull Class getTraceInterface() {
		return getRuleAnalysis2TraceInterface().getMiddleClass();
	}

	/*	@Override
	public @NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty element2traceProperty, @NonNull String name) {
		if (relationAnalysis2traceClass != null) {
			return relationAnalysis2traceClass.getUniquePropertyName(element2traceProperty, name);
		}
		//		else if (relationAnalysis2dispatchClass != null) {
		//			return relationAnalysis2dispatchClass.getUniquePropertyName(element2traceProperty, name);
		//		}
		else if (relationAnalysis2traceInterface != null) {
			return relationAnalysis2traceInterface.getUniquePropertyName(element2traceProperty, name);
		}
		else {
			throw new IllegalStateException();
		}
	} */

	@Override
	public void synthesizeTraceElements() throws CompilerChainException {
		//		if ("TC_mapOclExpression".equals(toString())) {
		//			getClass();
		//		}
		getRuleAnalysis().synthesizeTraceElements(this);
	}

	@Override
	public void synthesizeTraceModel() {
		//		if ("TC_mapVariableExp_referredVariable".equals(toString())) {
		//			getClass();
		//		}
		if (relationAnalysis2traceInterface != null) {
			relationAnalysis2traceInterface.synthesizeTraceModel();
		}
		//		RelationAnalysis2TraceClass relationAnalysis2traceClass2 = relationAnalysis2traceClass;
		if (relationAnalysis2traceClass != null) {
			relationAnalysis2traceClass.synthesizeTraceModel();
		}
		if (relationAnalysis2dispatchClass != null) {
			relationAnalysis2dispatchClass.synthesizeTraceModel();
		}
		if (relationAnalysis2invocationClass != null) {
			relationAnalysis2invocationClass.synthesizeTraceModel();
		}
	}

	@Override
	public @NonNull String toString() {
		return getRuleAnalysis().toString();
	}
}